package d.a.c.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f38897a;

    /* renamed from: b  reason: collision with root package name */
    public static b f38898b;

    /* renamed from: c  reason: collision with root package name */
    public static String f38899c;

    /* renamed from: d  reason: collision with root package name */
    public static c f38900d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f38901e = new Handler(new C0489a());

    /* renamed from: d.a.c.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0489a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 6) {
                        if (a.f38900d != null) {
                            a.f38900d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f38900d != null) {
                            a.f38900d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f38900d != null) {
                    a.f38900d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f38900d != null) {
                a.f38900d.c(a.f38899c, message.arg1);
            }
            int unused = a.f38897a = 0;
            c unused2 = a.f38900d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i2) {
        if (f38897a == 0) {
            b bVar = f38898b;
            if (bVar == null) {
                f38898b = new b(f38901e, i2);
            } else {
                bVar.k(i2);
            }
            f38899c = str;
            f38900d = cVar;
            f38898b.j(str);
            f38897a = 2;
            new Thread(f38898b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f38898b;
        if (bVar != null) {
            bVar.l();
        } else {
            f38897a = 0;
        }
    }
}
