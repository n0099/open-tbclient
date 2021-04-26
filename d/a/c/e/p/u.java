package d.a.c.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static Field f39985a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f39986b;

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Handler f39987a;

        public a(Handler handler) {
            this.f39987a = handler;
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
                if (this.f39987a != null) {
                    this.f39987a.handleMessage(message);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f39985a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f39985a.getType().getDeclaredField("mHandler");
                f39986b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT >= 28 || f39985a == null || f39986b == null || (obj = f39985a.get(toast)) == null || (handler = (Handler) f39986b.get(obj)) == null) {
                return;
            }
            f39986b.set(obj, new a(handler));
        } catch (Exception unused) {
        }
    }
}
