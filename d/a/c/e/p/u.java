package d.a.c.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static Field f38894a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f38895b;

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Handler f38896a;

        public a(Handler handler) {
            this.f38896a = handler;
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
                if (this.f38896a != null) {
                    this.f38896a.handleMessage(message);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f38894a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f38894a.getType().getDeclaredField("mHandler");
                f38895b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT >= 28 || f38894a == null || f38895b == null || (obj = f38894a.get(toast)) == null || (handler = (Handler) f38895b.get(obj)) == null) {
                return;
            }
            f38895b.set(obj, new a(handler));
        } catch (Exception unused) {
        }
    }
}
