package d.r.b.a.a.m.c.b;

import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final String f68129c = "b";

    @Override // d.r.b.a.a.m.c.b.a
    public String d() {
        return "http://datatest.bigda.com/c.gif";
    }

    @Override // d.r.b.a.a.m.c.b.a
    public String e() {
        return TextUtils.isEmpty(d.r.b.a.a.m.c.d.a.a()) ? "http://mlog.bigda.com/c.gif" : d.r.b.a.a.m.c.d.a.a();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x002e */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: d.r.b.a.a.m.c.b.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // d.r.b.a.a.m.c.b.a
    public boolean f(String str, String str2, int i2) {
        boolean z;
        if (str == null) {
            d.r.b.a.a.m.c.d.d.a(f68129c, "url == null");
            return false;
        } else if (str2 == null) {
            d.r.b.a.a.m.c.d.d.a(f68129c, "content == null");
            return false;
        } else {
            d.r.b.a.a.m.c.d.d.d(f68129c, "hiido service address is " + str);
            int i3 = i2;
            ?? r7 = str;
            while (true) {
                if (r7 == 0) {
                    try {
                        Intrinsics.throwNpe();
                    } catch (Throwable th) {
                        d.r.b.a.a.m.c.d.d.b(f68129c, "sendContent exception", th);
                        z = r7;
                    }
                }
                if (str2 == null) {
                    Intrinsics.throwNpe();
                }
                if (a(r7, str2)) {
                    d.r.b.a.a.m.c.d.d.d(f68129c, "Successfully sent " + str2 + " to " + ((String) r7));
                    r7 = 1;
                    return true;
                }
                d.r.b.a.a.m.c.d.d.d(f68129c, "Failed to sent " + str2 + " to " + ((String) r7));
                z = r7;
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return false;
                }
                i3 = i4;
                r7 = z;
            }
        }
    }
}
