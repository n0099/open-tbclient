package d.a.c.e.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static e f42397d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f42398a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f42399b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public Handler f42400c = new a(this, Looper.getMainLooper());

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(e eVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar;
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof b) || (bVar = (b) obj) == null) {
                return;
            }
            bVar.i(false);
            bVar.h(false);
            bVar.g(0);
            bVar.j(System.currentTimeMillis());
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f42406a;

        /* renamed from: b  reason: collision with root package name */
        public int f42407b;

        /* renamed from: c  reason: collision with root package name */
        public int f42408c;

        public c(e eVar) {
        }

        public int a() {
            return this.f42406a;
        }

        public int b() {
            return this.f42407b;
        }

        public int c() {
            return this.f42408c;
        }

        public void d(int i2) {
            this.f42406a = i2;
        }

        public void e(int i2) {
            this.f42407b = i2;
        }

        public void f(int i2) {
            this.f42408c = i2;
        }

        public /* synthetic */ c(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e() {
        c cVar = new c(this, null);
        cVar.d(3000);
        cVar.e(120000);
        cVar.f(500);
        this.f42399b.put("net", cVar);
        this.f42399b.put("op", cVar);
        this.f42399b.put("stat", cVar);
        this.f42399b.put("crash", cVar);
        this.f42399b.put("pfmonitor", cVar);
        c cVar2 = new c(this, null);
        cVar2.d(3000);
        cVar2.e(120000);
        cVar2.f(1500);
        this.f42399b.put("file", cVar2);
        this.f42399b.put(IMTrackDatabase.DbEnum.TABLE_NAME, cVar2);
        this.f42399b.put("img", cVar2);
        this.f42399b.put("voice", cVar2);
        this.f42399b.put("error", cVar2);
        c cVar3 = new c(this, null);
        cVar3.d(3000);
        cVar3.e(120000);
        cVar3.f(1500);
        this.f42399b.put("dbg", cVar3);
    }

    public static e c() {
        if (f42397d == null) {
            synchronized (e.class) {
                if (f42397d == null) {
                    f42397d = new e();
                }
            }
        }
        return f42397d;
    }

    public synchronized boolean a(String str) {
        c cVar = this.f42399b.get(str);
        if (cVar == null) {
            return false;
        }
        b bVar = this.f42398a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar == null) {
            bVar = new b(this, null);
            bVar.h(false);
            bVar.i(false);
            bVar.j(currentTimeMillis);
            this.f42398a.put(str, bVar);
        }
        b bVar2 = bVar;
        if (bVar2.e()) {
            return true;
        }
        if (bVar2.d()) {
            bVar2.g(bVar2.b() + 1);
            if (currentTimeMillis - bVar2.a() < cVar.b()) {
                if (bVar2.b() >= cVar.c()) {
                    bVar2.i(true);
                    BdStatisticsManager.getInstance().op(false, "d", "logfast", null, 0L, 99999, str, new Object[0]);
                    b(bVar2);
                    return true;
                }
            } else {
                bVar2.h(false);
                bVar2.g(0);
                bVar2.j(currentTimeMillis);
            }
        } else if (currentTimeMillis - bVar2.c() < cVar.a()) {
            bVar2.h(true);
            bVar2.f(currentTimeMillis);
        } else {
            bVar2.j(currentTimeMillis);
        }
        return false;
    }

    public final void b(b bVar) {
        Message obtainMessage = this.f42400c.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = bVar;
        this.f42400c.removeMessages(5);
        this.f42400c.sendMessageDelayed(obtainMessage, 300000L);
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f42401a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42402b;

        /* renamed from: c  reason: collision with root package name */
        public int f42403c;

        /* renamed from: d  reason: collision with root package name */
        public long f42404d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42405e;

        public b(e eVar) {
            this.f42402b = false;
            this.f42403c = 0;
            this.f42405e = false;
        }

        public long a() {
            return this.f42404d;
        }

        public int b() {
            return this.f42403c;
        }

        public long c() {
            return this.f42401a;
        }

        public boolean d() {
            return this.f42402b;
        }

        public boolean e() {
            return this.f42405e;
        }

        public void f(long j) {
            this.f42404d = j;
        }

        public void g(int i2) {
            this.f42403c = i2;
        }

        public void h(boolean z) {
            this.f42402b = z;
        }

        public void i(boolean z) {
            this.f42405e = z;
        }

        public void j(long j) {
            this.f42401a = j;
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }
}
