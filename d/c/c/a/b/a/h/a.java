package d.c.c.a.b.a.h;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66115d = com.bytedance.sdk.a.a.f.a(":");

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66116e = com.bytedance.sdk.a.a.f.a(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66117f = com.bytedance.sdk.a.a.f.a(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66118g = com.bytedance.sdk.a.a.f.a(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f66119h = com.bytedance.sdk.a.a.f.a(":scheme");
    public static final com.bytedance.sdk.a.a.f i = com.bytedance.sdk.a.a.f.a(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f66120a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f66121b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66122c;

    public a(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f66120a.equals(aVar.f66120a) && this.f66121b.equals(aVar.f66121b);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f66120a.hashCode()) * 31) + this.f66121b.hashCode();
    }

    public String toString() {
        return d.c.c.a.b.a.e.j("%s: %s", this.f66120a.a(), this.f66121b.a());
    }

    public a(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public a(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.f66120a = fVar;
        this.f66121b = fVar2;
        this.f66122c = fVar.g() + 32 + fVar2.g();
    }
}
