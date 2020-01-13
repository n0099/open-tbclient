package common.network.download;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import java.io.File;
/* loaded from: classes.dex */
public class g {
    private Handler mHandler;

    public void onFail(Exception exc) {
    }

    public void am(File file) {
    }

    public void j(int i, int i2) {
    }

    public void a(File file, int i, int i2) {
    }

    public g() {
        this(null);
    }

    public g(@Nullable Handler handler) {
        if (handler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mHandler = handler;
        }
    }

    public final void b(final File file, final int i, final int i2) {
        this.mHandler.post(new Runnable() { // from class: common.network.download.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.a(file, i, i2);
            }
        });
    }

    public final void ei(final int i, final int i2) {
        this.mHandler.post(new Runnable() { // from class: common.network.download.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.j(i, i2);
            }
        });
    }

    public final void an(final File file) {
        this.mHandler.post(new Runnable() { // from class: common.network.download.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.am(file);
            }
        });
    }

    public final void p(final Exception exc) {
        this.mHandler.post(new Runnable() { // from class: common.network.download.g.4
            @Override // java.lang.Runnable
            public void run() {
                g.this.onFail(exc);
            }
        });
    }
}
