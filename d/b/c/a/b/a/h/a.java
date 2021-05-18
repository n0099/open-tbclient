package d.b.c.a.b.a.h;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65268d = com.bytedance.sdk.a.a.f.a(":");

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65269e = com.bytedance.sdk.a.a.f.a(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65270f = com.bytedance.sdk.a.a.f.a(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65271g = com.bytedance.sdk.a.a.f.a(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65272h = com.bytedance.sdk.a.a.f.a(":scheme");

    /* renamed from: i  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65273i = com.bytedance.sdk.a.a.f.a(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f65274a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f65275b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65276c;

    public a(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f65274a.equals(aVar.f65274a) && this.f65275b.equals(aVar.f65275b);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f65274a.hashCode()) * 31) + this.f65275b.hashCode();
    }

    public String toString() {
        return d.b.c.a.b.a.e.j("%s: %s", this.f65274a.a(), this.f65275b.a());
    }

    public a(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public a(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.f65274a = fVar;
        this.f65275b = fVar2;
        this.f65276c = fVar.g() + 32 + fVar2.g();
    }
}
