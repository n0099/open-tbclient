package d.a.c.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f39233a;

    /* renamed from: b  reason: collision with root package name */
    public static b f39234b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39235c;

    /* renamed from: d  reason: collision with root package name */
    public static c f39236d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f39237e = new Handler(new C0505a());

    /* renamed from: d.a.c.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0505a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 6) {
                        if (a.f39236d != null) {
                            a.f39236d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f39236d != null) {
                            a.f39236d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f39236d != null) {
                    a.f39236d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f39236d != null) {
                a.f39236d.c(a.f39235c, message.arg1);
            }
            int unused = a.f39233a = 0;
            c unused2 = a.f39236d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i2) {
        if (f39233a == 0) {
            b bVar = f39234b;
            if (bVar == null) {
                f39234b = new b(f39237e, i2);
            } else {
                bVar.k(i2);
            }
            f39235c = str;
            f39236d = cVar;
            f39234b.j(str);
            f39233a = 2;
            new Thread(f39234b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f39234b;
        if (bVar != null) {
            bVar.l();
        } else {
            f39233a = 0;
        }
    }
}
