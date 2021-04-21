package d.b.c.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static Field f42773a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f42774b;

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Handler f42775a;

        public a(Handler handler) {
            this.f42775a = handler;
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
                if (this.f42775a != null) {
                    this.f42775a.handleMessage(message);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f42773a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f42773a.getType().getDeclaredField("mHandler");
                f42774b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT >= 28 || f42773a == null || f42774b == null || (obj = f42773a.get(toast)) == null || (handler = (Handler) f42774b.get(obj)) == null) {
                return;
            }
            f42774b.set(obj, new a(handler));
        } catch (Exception unused) {
        }
    }
}
