package d.b.b.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42039a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42040b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42041c;

    /* renamed from: d  reason: collision with root package name */
    public static c f42042d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f42043e = new Handler(new C0542a());

    /* renamed from: d.b.b.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0542a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 6) {
                        if (a.f42042d != null) {
                            a.f42042d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f42042d != null) {
                            a.f42042d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f42042d != null) {
                    a.f42042d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f42042d != null) {
                a.f42042d.c(a.f42041c, message.arg1);
            }
            int unused = a.f42039a = 0;
            c unused2 = a.f42042d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i) {
        if (f42039a == 0) {
            b bVar = f42040b;
            if (bVar == null) {
                f42040b = new b(f42043e, i);
            } else {
                bVar.k(i);
            }
            f42041c = str;
            f42042d = cVar;
            f42040b.j(str);
            f42039a = 2;
            new Thread(f42040b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f42040b;
        if (bVar != null) {
            bVar.l();
        } else {
            f42039a = 0;
        }
    }
}
