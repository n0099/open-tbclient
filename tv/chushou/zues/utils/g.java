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
/* loaded from: classes6.dex */
public class g {
    public static void A(CharSequence charSequence) {
        a.e(h.eHo(), charSequence);
    }

    public static void d(Context context, CharSequence charSequence) {
        a.e(context, charSequence);
    }

    public static void Sc(@StringRes int i) {
        a.showToast(h.eHo(), i);
    }

    public static void O(Context context, @StringRes int i) {
        a.showToast(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static class a {
        private static CharSequence qmX;
        private static Toast qmY = null;
        private static long qmZ = 0;

        static void e(final Context context, final CharSequence charSequence) {
            if (charSequence != null && charSequence.length() != 0) {
                if (context == null) {
                    context = h.eHo();
                }
                if (context != null) {
                    Runnable runnable = new Runnable() { // from class: tv.chushou.zues.utils.g.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.qmY == null) {
                                Toast unused = a.qmY = Toast.makeText(context.getApplicationContext(), (CharSequence) null, 0);
                                g.c(a.qmY);
                                a.qmY.setText(charSequence);
                                a.qmY.show();
                                CharSequence unused2 = a.qmX = charSequence;
                                long unused3 = a.qmZ = System.currentTimeMillis();
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (charSequence.equals(a.qmX)) {
                                if (currentTimeMillis - a.qmZ > 2000) {
                                    a.qmY.show();
                                    long unused4 = a.qmZ = currentTimeMillis;
                                    return;
                                }
                                return;
                            }
                            CharSequence unused5 = a.qmX = charSequence;
                            a.qmY.setText(charSequence);
                            a.qmY.show();
                            long unused6 = a.qmZ = currentTimeMillis;
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
                e(context, h.eHR().getString(i));
            }
        }
    }
}
