package d.b.b.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static Field f42035a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f42036b;

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Handler f42037a;

        public a(Handler handler) {
            this.f42037a = handler;
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
                if (this.f42037a != null) {
                    this.f42037a.handleMessage(message);
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f42035a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f42035a.getType().getDeclaredField("mHandler");
                f42036b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT >= 28 || f42035a == null || f42036b == null || (obj = f42035a.get(toast)) == null || (handler = (Handler) f42036b.get(obj)) == null) {
                return;
            }
            f42036b.set(obj, new a(handler));
        } catch (Exception unused) {
        }
    }
}
