package d.a.c.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static Field f39230a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f39231b;

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Handler f39232a;

        public a(Handler handler) {
            this.f39232a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f39232a != null) {
                    this.f39232a.handleMessage(message);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f39230a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f39230a.getType().getDeclaredField("mHandler");
                f39231b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT >= 28 || f39230a == null || f39231b == null || (obj = f39230a.get(toast)) == null || (handler = (Handler) f39231b.get(obj)) == null) {
                return;
            }
            f39231b.set(obj, new a(handler));
        } catch (Exception unused) {
        }
    }
}
