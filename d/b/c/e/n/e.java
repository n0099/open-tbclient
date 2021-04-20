package d.b.c.e.n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static e f42391d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f42392a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f42393b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public Handler f42394c = new a(this, Looper.getMainLooper());

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
        public int f42400a;

        /* renamed from: b  reason: collision with root package name */
        public int f42401b;

        /* renamed from: c  reason: collision with root package name */
        public int f42402c;

        public c(e eVar) {
        }

        public int a() {
            return this.f42400a;
        }

        public int b() {
            return this.f42401b;
        }

        public int c() {
            return this.f42402c;
        }

        public void d(int i) {
            this.f42400a = i;
        }

        public void e(int i) {
            this.f42401b = i;
        }

        public void f(int i) {
            this.f42402c = i;
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
        this.f42393b.put("net", cVar);
        this.f42393b.put("op", cVar);
        this.f42393b.put("stat", cVar);
        this.f42393b.put("crash", cVar);
        this.f42393b.put("pfmonitor", cVar);
        c cVar2 = new c(this, null);
        cVar2.d(3000);
        cVar2.e(120000);
        cVar2.f(1500);
        this.f42393b.put("file", cVar2);
        this.f42393b.put(IMTrackDatabase.DbEnum.TABLE_NAME, cVar2);
        this.f42393b.put("img", cVar2);
        this.f42393b.put("voice", cVar2);
        this.f42393b.put("error", cVar2);
        c cVar3 = new c(this, null);
        cVar3.d(3000);
        cVar3.e(120000);
        cVar3.f(1500);
        this.f42393b.put("dbg", cVar3);
    }

    public static e c() {
        if (f42391d == null) {
            synchronized (e.class) {
                if (f42391d == null) {
                    f42391d = new e();
                }
            }
        }
        return f42391d;
    }

    public synchronized boolean a(String str) {
        c cVar = this.f42393b.get(str);
        if (cVar == null) {
            return false;
        }
        b bVar = this.f42392a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar == null) {
            bVar = new b(this, null);
            bVar.h(false);
            bVar.i(false);
            bVar.j(currentTimeMillis);
            this.f42392a.put(str, bVar);
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
        Message obtainMessage = this.f42394c.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = bVar;
        this.f42394c.removeMessages(5);
        this.f42394c.sendMessageDelayed(obtainMessage, 300000L);
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f42395a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42396b;

        /* renamed from: c  reason: collision with root package name */
        public int f42397c;

        /* renamed from: d  reason: collision with root package name */
        public long f42398d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42399e;

        public b(e eVar) {
            this.f42396b = false;
            this.f42397c = 0;
            this.f42399e = false;
        }

        public long a() {
            return this.f42398d;
        }

        public int b() {
            return this.f42397c;
        }

        public long c() {
            return this.f42395a;
        }

        public boolean d() {
            return this.f42396b;
        }

        public boolean e() {
            return this.f42399e;
        }

        public void f(long j) {
            this.f42398d = j;
        }

        public void g(int i) {
            this.f42397c = i;
        }

        public void h(boolean z) {
            this.f42396b = z;
        }

        public void i(boolean z) {
            this.f42399e = z;
        }

        public void j(long j) {
            this.f42395a = j;
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }
}
