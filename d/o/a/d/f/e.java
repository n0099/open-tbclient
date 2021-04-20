package d.o.a.d.f;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.c.d;
import d.o.a.d.f.c;
import d.o.a.d.j;
import d.o.a.d.n.l;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class e implements l.a {

    /* renamed from: c  reason: collision with root package name */
    public static String f67562c = "e";

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f67563d;

    /* renamed from: a  reason: collision with root package name */
    public d.o.a.d.n.l f67564a = new d.o.a.d.n.l(Looper.getMainLooper(), this);

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f67565b;

    public e() {
        this.f67565b = null;
        this.f67565b = new ConcurrentHashMap<>();
    }

    public static e a() {
        if (f67563d == null) {
            synchronized (e.class) {
                if (f67563d == null) {
                    f67563d = new e();
                }
            }
        }
        return f67563d;
    }

    public static boolean c(d dVar) {
        return (dVar == null || dVar.B() == null || TextUtils.isEmpty(dVar.B().a())) ? false : true;
    }

    public static boolean d(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.H0() == 0 || downloadInfo.H0() == -4;
    }

    public void b(int i, d dVar, d.o.a.a.a.c.c cVar) {
        String str = f67562c;
        d.o.a.d.n.j.a(str, "sendQuickAppMsg msgWhat:" + i, null);
        if (this.f67564a == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = Long.valueOf(dVar.d());
        this.f67564a.sendMessageDelayed(obtain, e());
    }

    public long e() {
        return n.s().optLong("quick_app_check_internal", IMLikeRequest.TIME_INTERVAL);
    }

    @Override // d.o.a.d.n.l.a
    public void a(Message message) {
        if (message == null) {
            return;
        }
        boolean a2 = n.u() != null ? n.u().a() : false;
        Object obj = message.obj;
        long longValue = obj instanceof Long ? ((Long) obj).longValue() : 0L;
        d a3 = c.g.e().a(longValue);
        if (a3 instanceof d.o.a.b.a.a.c) {
            ((d.o.a.b.a.a.c) a3).b(3);
        }
        int i = message.what;
        if (i == 4) {
            if (a2) {
                j.c.a().g(longValue, true, 2);
            }
        } else if (i == 5) {
            if (a2) {
                j.c.a().g(longValue, true, 1);
            }
        } else if (i != 7) {
        } else {
            Runnable runnable = this.f67565b.get(Long.valueOf(longValue));
            this.f67565b.remove(Long.valueOf(longValue));
            if (a2) {
                j.c.a().c(longValue, 1);
                j.c.a().g(longValue, true, 1);
                return;
            }
            if (runnable != null) {
                this.f67564a.post(runnable);
            }
            j.c.a().g(longValue, false, 1);
        }
    }
}
