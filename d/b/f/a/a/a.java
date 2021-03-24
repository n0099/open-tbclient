package d.b.f.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import d.b.b.e.q.g;
import d.b.b.e.q.h;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42773a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42774b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42775c;

    /* renamed from: d  reason: collision with root package name */
    public static g f42776d;

    /* renamed from: e  reason: collision with root package name */
    public static long f42777e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f42778f = new Handler(new C0576a());

    /* renamed from: d.b.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0576a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 100) {
                switch (i) {
                    case 0:
                        if (a.f42776d != null) {
                            a.f42776d.c(a.f42775c, message.arg1);
                            g unused = a.f42776d = null;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        if (a.f42776d != null) {
                            if (d.b.b.e.p.f.d()) {
                                a.f42776d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                            } else {
                                a.f42776d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                            }
                            g unused2 = a.f42776d = null;
                            break;
                        }
                        break;
                    case 2:
                        if (a.f42776d != null) {
                            a.f42776d.error(message.what, h.a(R.string.voice_err_file_fail));
                            g unused3 = a.f42776d = null;
                            break;
                        }
                        break;
                    case 4:
                        if (a.f42776d != null) {
                            a.f42776d.b(message.arg1);
                            break;
                        }
                        break;
                    case 5:
                        if (a.f42776d != null) {
                            a.f42776d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                            g unused4 = a.f42776d = null;
                            break;
                        }
                        break;
                    case 6:
                        if (a.f42776d != null) {
                            a.f42776d.error(message.what, h.a(R.string.voice_err_init_fail));
                            g unused5 = a.f42776d = null;
                            break;
                        }
                        break;
                    case 7:
                        if (a.f42776d != null) {
                            a.f42776d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                            g unused6 = a.f42776d = null;
                            break;
                        }
                        break;
                    case 8:
                        if (a.f42776d != null) {
                            a.f42776d.error(message.what, h.a(R.string.voice_record_short_tip));
                            g unused7 = a.f42776d = null;
                            break;
                        }
                        break;
                    case 9:
                        if (a.f42776d != null) {
                            a.f42776d.a(message.arg1);
                            break;
                        }
                        break;
                    default:
                        if (a.f42776d != null) {
                            a.f42776d.error(message.what, h.a(R.string.voice_err_other));
                            g unused8 = a.f42776d = null;
                            break;
                        }
                        break;
                }
            } else if (a.f42776d != null) {
                a.f42776d.e();
            }
            int unused9 = a.f42773a = 0;
            return false;
        }
    }

    public static void e() {
        b bVar = f42774b;
        if (bVar != null) {
            bVar.cancel();
        }
        f42773a = 0;
    }

    public static boolean f(String str, int i, g gVar) {
        if (System.currentTimeMillis() - f42777e < 1000) {
            return false;
        }
        f42777e = System.currentTimeMillis();
        if (f42773a == 0) {
            if (f42774b == null) {
                f42774b = new b(f42778f);
            }
            f42775c = str;
            f42776d = gVar;
            if (f42774b.i(str, i)) {
                f42773a = 3;
                new Thread(f42774b).start();
                return true;
            }
            f42774b = null;
        }
        return false;
    }

    public static void g() {
        b bVar = f42774b;
        if (bVar != null) {
            bVar.j();
        }
        f42773a = 0;
    }
}
