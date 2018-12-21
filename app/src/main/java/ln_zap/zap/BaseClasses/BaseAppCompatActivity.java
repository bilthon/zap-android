package ln_zap.zap.BaseClasses;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import ln_zap.zap.util.LocaleUtil;

public abstract class BaseAppCompatActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context ctx) {
        // Set the correct locale
        super.attachBaseContext(LocaleUtil.setLocale(ctx));
    }

    @Override
    protected void onResume() {
        super.onResume();
        initializeScreenRecordingSecurity();
    }

    /*Secure against screenshots and automated screen recording.
      Keep in mind that this does not prevent popups and other
      dialogues to be secured as well. Extra security measures might have to be considered.
      Check out the following link for more details:
      https://github.com/commonsguy/cwac-security/blob/master/docs/FLAGSECURE.md
      */
    private void initializeScreenRecordingSecurity() {
        if (true)
        {
            if(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("preventScreenRecording",true)){
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
            }
        }
    }
}
