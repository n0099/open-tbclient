package com.kwad.sdk.api.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import androidx.annotation.Keep;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
@Keep
/* loaded from: classes6.dex */
public class DynamicInstallReceiver extends BroadcastReceiver {
    public static final AtomicBoolean HAS_REGISTER = new AtomicBoolean(false);

    @Keep
    public static void registerToApp(Context context) {
        if (context == null || HAS_REGISTER.get() || context.getApplicationContext() == null) {
            return;
        }
        context.getApplicationContext().registerReceiver(new DynamicInstallReceiver(), new IntentFilter(context.getPackageName() + ".loader.install.DynamicApk"));
        HAS_REGISTER.set(true);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        final String stringExtra2 = intent.getStringExtra(CommandMessage.SDK_VERSION);
        final File file = new File(stringExtra);
        if (file.exists()) {
            AsyncTask.execute(new Runnable() { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.a(context, file.getPath(), stringExtra2)) {
                            f.a(context, f.f32584a, stringExtra2);
                            g.a(file);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }
}
