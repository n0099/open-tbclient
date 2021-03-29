package d.b.h.a.i;

import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class a extends HandlerThread {
    public a(String str, int i) {
        super(str, i);
    }

    public void a() {
        try {
            Looper looper = getLooper();
            if (Build.VERSION.SDK_INT >= 18) {
                looper.quitSafely();
            } else {
                looper.quit();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        return quitSafely();
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        b.c(this);
        return true;
    }
}
