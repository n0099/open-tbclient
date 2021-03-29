package d.b.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.b.b.e.q.g;
import d.b.b.e.q.h;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42774a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42775b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42776c;

    /* renamed from: d  reason: collision with root package name */
    public static g f42777d;

    /* renamed from: e  reason: collision with root package name */
    public static long f42778e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f42779f = new Handler(new C0577a());

    /* renamed from: d.b.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0577a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 100) {
                switch (i) {
                    case 0:
                        if (a.f42777d != null) {
                            a.f42777d.c(a.f42776c, message.arg1);
                            g unused = a.f42777d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f42777d != null) {
                            if (d.b.b.e.p.f.d()) {
                                a.f42777d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f42777d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f42777d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f42777d != null) {
                            a.f42777d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f42777d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f42777d != null) {
                            a.f42777d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f42777d != null) {
                            a.f42777d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f42777d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f42777d != null) {
                            a.f42777d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f42777d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f42777d != null) {
                            a.f42777d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f42777d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f42777d != null) {
                            a.f42777d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f42777d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f42777d != null) {
                            a.f42777d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f42777d != null) {
                            a.f42777d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f42777d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f42777d != null) {
                a.f42777d.e();
            }
            int unused9 = a.f42774a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f42775b;
        if (bVar != null) {
            bVar.cancel();
        }
        f42774a = 0;
    }

    public static boolean f(String str, int i, g gVar) {
        if (System.currentTimeMillis() - f42778e < 1000) {
            return false;
        }
        f42778e = System.currentTimeMillis();
        if (f42774a == 0) {
            if (f42775b == null) {
                f42775b = new b(f42779f);
            }
            f42776c = str;
            f42777d = gVar;
            if (f42775b.i(str, i)) {
                f42774a = 3;
                new Thread(f42775b).start();
                return true;
            }
            f42775b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f42775b;
        if (bVar != null) {
            bVar.j();
        }
        f42774a = 0;
    }
}
