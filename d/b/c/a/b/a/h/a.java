package d.b.c.a.b.a.h;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69146d = com.bytedance.sdk.a.a.f.a(":");

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69147e = com.bytedance.sdk.a.a.f.a(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69148f = com.bytedance.sdk.a.a.f.a(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69149g = com.bytedance.sdk.a.a.f.a(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69150h = com.bytedance.sdk.a.a.f.a(":scheme");

    /* renamed from: i  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f69151i = com.bytedance.sdk.a.a.f.a(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f69152a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f69153b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69154c;

    public a(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f69152a.equals(aVar.f69152a) && this.f69153b.equals(aVar.f69153b);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f69152a.hashCode()) * 31) + this.f69153b.hashCode();
    }

    public String toString() {
        return d.b.c.a.b.a.e.j("%s: %s", this.f69152a.a(), this.f69153b.a());
    }

    public a(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public a(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.f69152a = fVar;
        this.f69153b = fVar2;
        this.f69154c = fVar.g() + 32 + fVar2.g();
    }
}
