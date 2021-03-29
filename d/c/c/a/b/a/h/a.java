package d.c.c.a.b.a.h;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65270d = com.bytedance.sdk.a.a.f.a(":");

    /* renamed from: e  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65271e = com.bytedance.sdk.a.a.f.a(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65272f = com.bytedance.sdk.a.a.f.a(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65273g = com.bytedance.sdk.a.a.f.a(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f65274h = com.bytedance.sdk.a.a.f.a(":scheme");
    public static final com.bytedance.sdk.a.a.f i = com.bytedance.sdk.a.a.f.a(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f65275a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.a.a.f f65276b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65277c;

    public a(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f65275a.equals(aVar.f65275a) && this.f65276b.equals(aVar.f65276b);
        }
        return false;
    }

    public int hashCode() {
        return ((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.f65275a.hashCode()) * 31) + this.f65276b.hashCode();
    }

    public String toString() {
        return d.c.c.a.b.a.e.j("%s: %s", this.f65275a.a(), this.f65276b.a());
    }

    public a(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public a(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.f65275a = fVar;
        this.f65276b = fVar2;
        this.f65277c = fVar.g() + 32 + fVar2.g();
    }
}
