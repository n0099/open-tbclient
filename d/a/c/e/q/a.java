package d.a.c.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42653a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42654b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42655c;

    /* renamed from: d  reason: collision with root package name */
    public static c f42656d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f42657e = new Handler(new C0548a());

    /* renamed from: d.a.c.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0548a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 6) {
                        if (a.f42656d != null) {
                            a.f42656d.error(message.what, h.a(R.string.voice_err_play));
                        }
                    } else {
                        if (a.f42656d != null) {
                            a.f42656d.d(message.arg1);
                        }
                        return true;
                    }
                } else if (a.f42656d != null) {
                    a.f42656d.error(message.what, h.a(R.string.voice_err_no_file));
                }
            } else if (a.f42656d != null) {
                a.f42656d.c(a.f42655c, message.arg1);
            }
            int unused = a.f42653a = 0;
            c unused2 = a.f42656d = null;
            return false;
        }
    }

    public static boolean e(String str, c cVar, int i2) {
        if (f42653a == 0) {
            b bVar = f42654b;
            if (bVar == null) {
                f42654b = new b(f42657e, i2);
            } else {
                bVar.k(i2);
            }
            f42655c = str;
            f42656d = cVar;
            f42654b.j(str);
            f42653a = 2;
            new Thread(f42654b).start();
            return true;
        }
        return false;
    }

    public static void f() {
        b bVar = f42654b;
        if (bVar != null) {
            bVar.l();
        } else {
            f42653a = 0;
        }
    }
}
