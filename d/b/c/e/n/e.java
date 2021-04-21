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
    public static e f42631d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f42632a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f42633b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public Handler f42634c = new a(this, Looper.getMainLooper());

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
        public int f42640a;

        /* renamed from: b  reason: collision with root package name */
        public int f42641b;

        /* renamed from: c  reason: collision with root package name */
        public int f42642c;

        public c(e eVar) {
        }

        public int a() {
            return this.f42640a;
        }

        public int b() {
            return this.f42641b;
        }

        public int c() {
            return this.f42642c;
        }

        public void d(int i) {
            this.f42640a = i;
        }

        public void e(int i) {
            this.f42641b = i;
        }

        public void f(int i) {
            this.f42642c = i;
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
        this.f42633b.put("net", cVar);
        this.f42633b.put("op", cVar);
        this.f42633b.put("stat", cVar);
        this.f42633b.put("crash", cVar);
        this.f42633b.put("pfmonitor", cVar);
        c cVar2 = new c(this, null);
        cVar2.d(3000);
        cVar2.e(120000);
        cVar2.f(1500);
        this.f42633b.put("file", cVar2);
        this.f42633b.put(IMTrackDatabase.DbEnum.TABLE_NAME, cVar2);
        this.f42633b.put("img", cVar2);
        this.f42633b.put("voice", cVar2);
        this.f42633b.put("error", cVar2);
        c cVar3 = new c(this, null);
        cVar3.d(3000);
        cVar3.e(120000);
        cVar3.f(1500);
        this.f42633b.put("dbg", cVar3);
    }

    public static e c() {
        if (f42631d == null) {
            synchronized (e.class) {
                if (f42631d == null) {
                    f42631d = new e();
                }
            }
        }
        return f42631d;
    }

    public synchronized boolean a(String str) {
        c cVar = this.f42633b.get(str);
        if (cVar == null) {
            return false;
        }
        b bVar = this.f42632a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar == null) {
            bVar = new b(this, null);
            bVar.h(false);
            bVar.i(false);
            bVar.j(currentTimeMillis);
            this.f42632a.put(str, bVar);
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
        Message obtainMessage = this.f42634c.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = bVar;
        this.f42634c.removeMessages(5);
        this.f42634c.sendMessageDelayed(obtainMessage, 300000L);
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f42635a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42636b;

        /* renamed from: c  reason: collision with root package name */
        public int f42637c;

        /* renamed from: d  reason: collision with root package name */
        public long f42638d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f42639e;

        public b(e eVar) {
            this.f42636b = false;
            this.f42637c = 0;
            this.f42639e = false;
        }

        public long a() {
            return this.f42638d;
        }

        public int b() {
            return this.f42637c;
        }

        public long c() {
            return this.f42635a;
        }

        public boolean d() {
            return this.f42636b;
        }

        public boolean e() {
            return this.f42639e;
        }

        public void f(long j) {
            this.f42638d = j;
        }

        public void g(int i) {
            this.f42637c = i;
        }

        public void h(boolean z) {
            this.f42636b = z;
        }

        public void i(boolean z) {
            this.f42639e = z;
        }

        public void j(long j) {
            this.f42635a = j;
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }
}
