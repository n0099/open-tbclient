package com.kwad.components.core.m;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class g {
    public static final AtomicBoolean IY = new AtomicBoolean(false);
    public static volatile g IZ;
    public a Ja;
    public Context mAppContext;

    public g(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public static g av(@NonNull Context context) {
        if (IZ == null) {
            synchronized (g.class) {
                if (IZ == null) {
                    IZ = new g(context);
                }
            }
        }
        return IZ;
    }

    private void oD() {
        Context context;
        if (!IY.get() || (context = this.mAppContext) == null) {
            return;
        }
        context.unregisterReceiver(this.Ja);
        IY.set(false);
    }

    public final void oC() {
        if (this.mAppContext == null || IY.get()) {
            return;
        }
        if (this.Ja == null) {
            this.Ja = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        this.mAppContext.registerReceiver(this.Ja, intentFilter);
        IY.set(true);
    }

    public final void oE() {
        oD();
    }
}
