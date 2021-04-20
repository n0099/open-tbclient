package d.q.a.a;

import android.content.Context;
import android.text.TextUtils;
import d.q.a.a.a.a.a;
/* loaded from: classes7.dex */
public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Context f68387a;

    public f(b bVar, Context context) {
        this.f68387a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, CONSTRUCTOR, SGET, INVOKE, IF, SGET, INVOKE, IF, SGET, INVOKE] complete} */
    @Override // d.q.a.a.a.a.a
    public final void a(boolean z, d.q.a.a.a.b.b bVar) {
        boolean isEmpty;
        try {
            if (z || bVar != null) {
                String b2 = bVar.b();
                d.q.a.a.c.b.b.e("get OAID " + b2);
                if (!TextUtils.isEmpty(b2)) {
                    b.f68355h = b2;
                }
            } else {
                d.q.a.a.c.b.b.e("not support OAID");
            }
            d.q.a.a.a.a.b.c().h();
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
                d.q.a.a.c.b.b.c(th);
                if (bVar != null) {
                    try {
                        bVar.d();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                if (TextUtils.isEmpty(b.f68355h) || b.f68355h.startsWith("KWE")) {
                    return;
                }
                new d.q.a.a.c.a.e(this.f68387a).d(b.f68355h);
            } finally {
                if (bVar != null) {
                    try {
                        bVar.d();
                    } catch (Throwable unused3) {
                    }
                }
                if (!TextUtils.isEmpty(b.f68355h) && !b.f68355h.startsWith("KWE")) {
                    new d.q.a.a.c.a.e(this.f68387a).d(b.f68355h);
                }
            }
        }
    }
}
