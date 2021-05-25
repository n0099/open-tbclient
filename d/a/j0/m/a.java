package d.a.j0.m;

import android.content.Context;
import android.os.Build;
/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: c  reason: collision with root package name */
    public static a f40485c;

    /* renamed from: a  reason: collision with root package name */
    public b f40486a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40487b = false;

    /* renamed from: d.a.j0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0556a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40488a;

        static {
            int[] iArr = new int[com.baidu.sso.q.b.values().length];
            f40488a = iArr;
            try {
                iArr[com.baidu.sso.q.b.VIVO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40488a[com.baidu.sso.q.b.OPPO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40488a[com.baidu.sso.q.b.XIAOMI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40488a[com.baidu.sso.q.b.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40488a[com.baidu.sso.q.b.UNSUPPORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static a b() {
        if (f40485c == null) {
            synchronized (a.class) {
                if (f40485c == null) {
                    f40485c = new a();
                }
            }
        }
        return f40485c;
    }

    @Override // d.a.j0.m.b
    public String a() {
        b bVar = this.f40486a;
        if (bVar == null) {
            return null;
        }
        try {
            return bVar.a();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0045 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #0 {all -> 0x004b, blocks: (B:2:0x0000, B:5:0x0005, B:22:0x0041, B:24:0x0045, B:17:0x0026, B:18:0x0029, B:19:0x002f, B:20:0x0035, B:21:0x003b), top: B:29:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // d.a.j0.m.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, c cVar) {
        b cVar2;
        try {
            if (this.f40487b) {
                return;
            }
            this.f40487b = true;
            int i2 = C0556a.f40488a[com.baidu.sso.q.b.a(Build.MANUFACTURER).ordinal()];
            if (i2 == 1) {
                cVar2 = new d.a.j0.p.c();
            } else if (i2 == 2) {
                cVar2 = new d.a.j0.o.b();
            } else if (i2 == 3) {
                cVar2 = new d.a.j0.q.b();
            } else if (i2 == 4) {
                cVar2 = new d.a.j0.n.b();
            } else if (i2 != 5) {
                if (this.f40486a == null) {
                    this.f40486a.a(context, cVar);
                    return;
                }
                return;
            } else {
                cVar2 = null;
            }
            this.f40486a = cVar2;
            if (this.f40486a == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
