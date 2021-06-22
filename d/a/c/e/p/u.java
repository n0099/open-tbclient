package d.a.c.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static Field f42650a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f42651b;

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Handler f42652a;

        public a(Handler handler) {
            this.f42652a = handler;
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
                if (this.f42652a != null) {
                    this.f42652a.handleMessage(message);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f42650a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f42650a.getType().getDeclaredField("mHandler");
                f42651b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT >= 28 || f42650a == null || f42651b == null || (obj = f42650a.get(toast)) == null || (handler = (Handler) f42651b.get(obj)) == null) {
                return;
            }
            f42651b.set(obj, new a(handler));
        } catch (Exception unused) {
        }
    }
}
