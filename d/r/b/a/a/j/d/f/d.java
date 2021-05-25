package d.r.b.a.a.j.d.f;

import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes7.dex */
public final class d implements d.r.b.a.a.j.d.f.a {

    /* renamed from: i  reason: collision with root package name */
    public static final a f68122i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f68123a;

    /* renamed from: b  reason: collision with root package name */
    public Object f68124b;

    /* renamed from: c  reason: collision with root package name */
    public String f68125c = "";

    /* renamed from: d  reason: collision with root package name */
    public final int f68126d;

    /* renamed from: e  reason: collision with root package name */
    public final int f68127e;

    /* renamed from: f  reason: collision with root package name */
    public final RequestParams f68128f;

    /* renamed from: g  reason: collision with root package name */
    public final c f68129g;

    /* renamed from: h  reason: collision with root package name */
    public final d.r.b.a.a.j.d.b f68130h;

    /* loaded from: classes7.dex */
    public static final class a {
        public a() {
        }

        public final d a(int i2, int i3, RequestParams requestParams, c cVar, d.r.b.a.a.j.d.b bVar) {
            requestParams.setSeq(d.r.b.a.a.f.h.e.a());
            d dVar = new d(i2, i3, requestParams, cVar, bVar);
            String seq = requestParams.getSeq();
            if (seq == null) {
                Intrinsics.throwNpe();
            }
            dVar.f(seq);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("obtain seq = %s", Arrays.copyOf(new Object[]{dVar.d()}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            d.r.b.a.a.f.d.d.f("RevenueService-RequestJob", format);
            return dVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(int i2, int i3, RequestParams requestParams, c cVar, d.r.b.a.a.j.d.b bVar) {
        this.f68126d = i2;
        this.f68127e = i3;
        this.f68128f = requestParams;
        this.f68129g = cVar;
        this.f68130h = bVar;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public void a(Object obj) {
        this.f68124b = obj;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public int b() {
        return this.f68126d;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public Object c() {
        return this.f68124b;
    }

    public final String d() {
        return this.f68125c;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public String e() {
        return this.f68125c;
    }

    public final void f(String str) {
        this.f68125c = str;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public boolean run() {
        if (this.f68130h == null || this.f68129g == null) {
            return false;
        }
        if (this.f68123a) {
            return true;
        }
        this.f68128f.setSeq(this.f68125c);
        d.r.b.a.a.f.e.a a2 = this.f68129g.a(this.f68126d, this.f68127e, this.f68128f);
        if (a2 == null) {
            return false;
        }
        this.f68123a = true;
        d.r.b.a.a.j.d.b bVar = this.f68130h;
        String str = this.f68125c;
        if (a2 == null) {
            Intrinsics.throwNpe();
        }
        byte[] b2 = a2.b();
        Intrinsics.checkExpressionValueIsNotNull(b2, "req!!.marshall()");
        bVar.b(str, b2);
        return true;
    }
}
