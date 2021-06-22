package d.a.k0.m;

import android.content.Context;
import android.os.Build;
import d.a.k0.n.b;
import d.a.k0.q.c;
/* loaded from: classes2.dex */
public class a implements d.a.k0.n.a {

    /* renamed from: c  reason: collision with root package name */
    public static a f44303c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.n.a f44304a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44305b = false;

    public static a b() {
        if (f44303c == null) {
            synchronized (a.class) {
                if (f44303c == null) {
                    f44303c = new a();
                }
            }
        }
        return f44303c;
    }

    @Override // d.a.k0.n.a
    public String a() {
        d.a.k0.n.a aVar = this.f44304a;
        if (aVar == null) {
            return null;
        }
        try {
            return aVar.a();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040 A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #0 {all -> 0x0045, blocks: (B:2:0x0000, B:5:0x0005, B:21:0x003c, B:23:0x0040, B:15:0x0020, B:16:0x0025, B:17:0x0028, B:18:0x002e, B:19:0x0034), top: B:26:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // d.a.k0.n.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, b bVar) {
        d.a.k0.n.a aVar;
        try {
            if (this.f44305b) {
                return;
            }
            this.f44305b = true;
            int ordinal = com.baidu.sso.r.a.a(Build.MANUFACTURER).ordinal();
            if (ordinal == 0) {
                aVar = null;
            } else if (ordinal == 1) {
                aVar = new d.a.k0.o.b();
            } else if (ordinal == 2) {
                aVar = new d.a.k0.r.b();
            } else if (ordinal == 3) {
                aVar = new c();
            } else if (ordinal != 4) {
                if (this.f44304a == null) {
                    this.f44304a.a(context, bVar);
                    return;
                }
                return;
            } else {
                aVar = new d.a.k0.p.b();
            }
            this.f44304a = aVar;
            if (this.f44304a == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
