package d.a.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.a.c.e.q.g;
import d.a.c.e.q.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f39919a;

    /* renamed from: b  reason: collision with root package name */
    public static b f39920b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39921c;

    /* renamed from: d  reason: collision with root package name */
    public static g f39922d;

    /* renamed from: e  reason: collision with root package name */
    public static long f39923e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f39924f = new Handler(new C0534a());

    /* renamed from: d.a.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0534a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 100) {
                switch (i2) {
                    case 0:
                        if (a.f39922d != null) {
                            a.f39922d.c(a.f39921c, message.arg1);
                            g unused = a.f39922d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f39922d != null) {
                            if (d.a.c.e.p.f.d()) {
                                a.f39922d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f39922d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f39922d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f39922d != null) {
                            a.f39922d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f39922d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f39922d != null) {
                            a.f39922d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f39922d != null) {
                            a.f39922d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f39922d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f39922d != null) {
                            a.f39922d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f39922d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f39922d != null) {
                            a.f39922d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f39922d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f39922d != null) {
                            a.f39922d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f39922d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f39922d != null) {
                            a.f39922d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f39922d != null) {
                            a.f39922d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f39922d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f39922d != null) {
                a.f39922d.e();
            }
            int unused9 = a.f39919a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f39920b;
        if (bVar != null) {
            bVar.cancel();
        }
        f39919a = 0;
    }

    public static boolean f(String str, int i2, g gVar) {
        if (System.currentTimeMillis() - f39923e < 1000) {
            return false;
        }
        f39923e = System.currentTimeMillis();
        if (f39919a == 0) {
            if (f39920b == null) {
                f39920b = new b(f39924f);
            }
            f39921c = str;
            f39922d = gVar;
            if (f39920b.i(str, i2)) {
                f39919a = 3;
                new Thread(f39920b).start();
                return true;
            }
            f39920b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f39920b;
        if (bVar != null) {
            bVar.j();
        }
        f39919a = 0;
    }
}
