package bcaasc.io.phonenumberauthenticaldemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * @author catherine.brainwilliam
 * @since 2018/11/27
 */
public class MainJActivity extends Activity {

    public static final String ACCOUNT_SID =
            "AC155c5a36717e9dedc7c5f2e2588bc54c";
    public static final String AUTH_TOKEN =
            "591bbf42528598ab072ec2b3f794e330";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_get_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

                        Message message = Message
                                .creator(new PhoneNumber("+18580269120"), // to
                                        new PhoneNumber("+15612202426"), // from
                                        "Where's Wallace?")
                                .create();

                        System.out.println(message.getSid());
                    }
                }).start();

            }
        });
    }
}
