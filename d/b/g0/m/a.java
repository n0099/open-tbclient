package d.b.g0.m;

import android.content.Context;
import android.os.Build;
/* loaded from: classes2.dex */
public class a implements b {

    /* renamed from: c  reason: collision with root package name */
    public static a f43722c;

    /* renamed from: a  reason: collision with root package name */
    public b f43723a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43724b = false;

    /* renamed from: d.b.g0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0617a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43725a;

        static {
            int[] iArr = new int[com.baidu.sso.q.b.values().length];
            f43725a = iArr;
            try {
                iArr[com.baidu.sso.q.b.VIVO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43725a[com.baidu.sso.q.b.OPPO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43725a[com.baidu.sso.q.b.XIAOMI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43725a[com.baidu.sso.q.b.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43725a[com.baidu.sso.q.b.UNSUPPORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static a b() {
        if (f43722c == null) {
            synchronized (a.class) {
                if (f43722c == null) {
                    f43722c = new a();
                }
            }
        }
        return f43722c;
    }

    @Override // d.b.g0.m.b
    public String a() {
        b bVar = this.f43723a;
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
    @Override // d.b.g0.m.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, c cVar) {
        b cVar2;
        try {
            if (this.f43724b) {
                return;
            }
            this.f43724b = true;
            int i = C0617a.f43725a[com.baidu.sso.q.b.a(Build.MANUFACTURER).ordinal()];
            if (i == 1) {
                cVar2 = new d.b.g0.p.c();
            } else if (i == 2) {
                cVar2 = new d.b.g0.o.b();
            } else if (i == 3) {
                cVar2 = new d.b.g0.q.b();
            } else if (i == 4) {
                cVar2 = new d.b.g0.n.b();
            } else if (i != 5) {
                if (this.f43723a == null) {
                    this.f43723a.a(context, cVar);
                    return;
                }
                return;
            } else {
                cVar2 = null;
            }
            this.f43723a = cVar2;
            if (this.f43723a == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
