package tv.chushou.zues.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.StringRes;
import android.support.media.ExifInterface;
import android.widget.Toast;
import java.lang.reflect.Field;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.thread.EventThread;
/* loaded from: classes5.dex */
public class g {
    public static void y(CharSequence charSequence) {
        a.d(h.dWe(), charSequence);
    }

    public static void c(Context context, CharSequence charSequence) {
        a.d(context, charSequence);
    }

    public static void LI(@StringRes int i) {
        a.showToast(h.dWe(), i);
    }

    public static void F(Context context, @StringRes int i) {
        a.showToast(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b extends Handler {
        private Handler handler;

        b(Handler handler) {
            this.handler = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                this.handler.handleMessage(message);
            } catch (Exception e) {
                e.e(ExifInterface.GPS_DIRECTION_TRUE, "", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Toast toast) {
        if (toast != null && Build.VERSION.SDK_INT <= 25) {
            try {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(toast);
                Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, new b((Handler) declaredField2.get(obj)));
            } catch (Throwable th) {
                e.e(ExifInterface.GPS_DIRECTION_TRUE, "", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static CharSequence okx;
        private static Toast oky = null;
        private static long okz = 0;

        static void d(final Context context, final CharSequence charSequence) {
            if (charSequence != null && charSequence.length() != 0) {
                if (context == null) {
                    context = h.dWe();
                }
                if (context != null) {
                    Runnable runnable = new Runnable() { // from class: tv.chushou.zues.utils.g.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.oky == null) {
                                Toast unused = a.oky = Toast.makeText(context.getApplicationContext(), (CharSequence) null, 0);
                                g.c(a.oky);
                                a.oky.setText(charSequence);
                                a.oky.show();
                                CharSequence unused2 = a.okx = charSequence;
                                long unused3 = a.okz = System.currentTimeMillis();
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (charSequence.equals(a.okx)) {
                                if (currentTimeMillis - a.okz > 2000) {
                                    a.oky.show();
                                    long unused4 = a.okz = currentTimeMillis;
                                    return;
                                }
                                return;
                            }
                            CharSequence unused5 = a.okx = charSequence;
                            a.oky.setText(charSequence);
                            a.oky.show();
                            long unused6 = a.okz = currentTimeMillis;
                        }
                    };
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        RxExecutor.post(null, EventThread.MAIN_THREAD, runnable);
                    } else {
                        runnable.run();
                    }
                }
            }
        }

        static void showToast(Context context, @StringRes int i) {
            if (context != null) {
                d(context, h.dWI().getString(i));
            }
        }
    }
}
