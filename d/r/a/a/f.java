package d.r.a.a;

import android.content.Context;
import android.text.TextUtils;
import d.r.a.a.a.a.a;
/* loaded from: classes7.dex */
public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f68534a;

    public f(b bVar, Context context) {
        this.f68534a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, CONSTRUCTOR, SGET, INVOKE, IF, SGET, INVOKE, IF, SGET, INVOKE] complete} */
    @Override // d.r.a.a.a.a.a
    public final void a(boolean z, d.r.a.a.a.b.b bVar) {
        boolean isEmpty;
        try {
            if (z || bVar != null) {
                String b2 = bVar.b();
                d.r.a.a.c.b.b.e("get OAID " + b2);
                if (!TextUtils.isEmpty(b2)) {
                    b.f68502h = b2;
                }
            } else {
                d.r.a.a.c.b.b.e("not support OAID");
            }
            d.r.a.a.a.a.b.c().h();
            if (bVar != null) {
                try {
                    bVar.d();
                } catch (Throwable unused) {
                    return;
                }
            }
            if (isEmpty) {
                return;
            }
        } catch (Throwable th) {
            try {
                d.r.a.a.c.b.b.c(th);
                if (bVar != null) {
                    try {
                        bVar.d();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                if (TextUtils.isEmpty(b.f68502h) || b.f68502h.startsWith("KWE")) {
                    return;
                }
                new d.r.a.a.c.a.e(this.f68534a).d(b.f68502h);
            } finally {
                if (bVar != null) {
                    try {
                        bVar.d();
                    } catch (Throwable unused3) {
                    }
                }
                if (!TextUtils.isEmpty(b.f68502h) && !b.f68502h.startsWith("KWE")) {
                    new d.r.a.a.c.a.e(this.f68534a).d(b.f68502h);
                }
            }
        }
    }
}
