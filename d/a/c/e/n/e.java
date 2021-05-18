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
    public static e f39080d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f39081a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f39082b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public Handler f39083c = new a(this, Looper.getMainLooper());

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
        public int f39089a;

        /* renamed from: b  reason: collision with root package name */
        public int f39090b;

        /* renamed from: c  reason: collision with root package name */
        public int f39091c;

        public c(e eVar) {
        }

        public int a() {
            return this.f39089a;
        }

        public int b() {
            return this.f39090b;
        }

        public int c() {
            return this.f39091c;
        }

        public void d(int i2) {
            this.f39089a = i2;
        }

        public void e(int i2) {
            this.f39090b = i2;
        }

        public void f(int i2) {
            this.f39091c = i2;
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
        this.f39082b.put("net", cVar);
        this.f39082b.put("op", cVar);
        this.f39082b.put("stat", cVar);
        this.f39082b.put("crash", cVar);
        this.f39082b.put("pfmonitor", cVar);
        c cVar2 = new c(this, null);
        cVar2.d(3000);
        cVar2.e(120000);
        cVar2.f(1500);
        this.f39082b.put("file", cVar2);
        this.f39082b.put(IMTrackDatabase.DbEnum.TABLE_NAME, cVar2);
        this.f39082b.put("img", cVar2);
        this.f39082b.put("voice", cVar2);
        this.f39082b.put("error", cVar2);
        c cVar3 = new c(this, null);
        cVar3.d(3000);
        cVar3.e(120000);
        cVar3.f(1500);
        this.f39082b.put("dbg", cVar3);
    }

    public static e c() {
        if (f39080d == null) {
            synchronized (e.class) {
                if (f39080d == null) {
                    f39080d = new e();
                }
            }
        }
        return f39080d;
    }

    public synchronized boolean a(String str) {
        c cVar = this.f39082b.get(str);
        if (cVar == null) {
            return false;
        }
        b bVar = this.f39081a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar == null) {
            bVar = new b(this, null);
            bVar.h(false);
            bVar.i(false);
            bVar.j(currentTimeMillis);
            this.f39081a.put(str, bVar);
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
        Message obtainMessage = this.f39083c.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = bVar;
        this.f39083c.removeMessages(5);
        this.f39083c.sendMessageDelayed(obtainMessage, 300000L);
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public long f39084a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39085b;

        /* renamed from: c  reason: collision with root package name */
        public int f39086c;

        /* renamed from: d  reason: collision with root package name */
        public long f39087d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39088e;

        public b(e eVar) {
            this.f39085b = false;
            this.f39086c = 0;
            this.f39088e = false;
        }

        public long a() {
            return this.f39087d;
        }

        public int b() {
            return this.f39086c;
        }

        public long c() {
            return this.f39084a;
        }

        public boolean d() {
            return this.f39085b;
        }

        public boolean e() {
            return this.f39088e;
        }

        public void f(long j) {
            this.f39087d = j;
        }

        public void g(int i2) {
            this.f39086c = i2;
        }

        public void h(boolean z) {
            this.f39085b = z;
        }

        public void i(boolean z) {
            this.f39088e = z;
        }

        public void j(long j) {
            this.f39084a = j;
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }
}
