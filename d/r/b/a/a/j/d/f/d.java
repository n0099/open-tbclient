package d.r.b.a.a.j.d.f;

import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes7.dex */
public final class d implements d.r.b.a.a.j.d.f.a {

    /* renamed from: i  reason: collision with root package name */
    public static final a f67393i = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public boolean f67394a;

    /* renamed from: b  reason: collision with root package name */
    public Object f67395b;

    /* renamed from: c  reason: collision with root package name */
    public String f67396c = "";

    /* renamed from: d  reason: collision with root package name */
    public final int f67397d;

    /* renamed from: e  reason: collision with root package name */
    public final int f67398e;

    /* renamed from: f  reason: collision with root package name */
    public final RequestParams f67399f;

    /* renamed from: g  reason: collision with root package name */
    public final c f67400g;

    /* renamed from: h  reason: collision with root package name */
    public final d.r.b.a.a.j.d.b f67401h;

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
        this.f67397d = i2;
        this.f67398e = i3;
        this.f67399f = requestParams;
        this.f67400g = cVar;
        this.f67401h = bVar;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public void a(Object obj) {
        this.f67395b = obj;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public int b() {
        return this.f67397d;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public Object c() {
        return this.f67395b;
    }

    public final String d() {
        return this.f67396c;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public String e() {
        return this.f67396c;
    }

    public final void f(String str) {
        this.f67396c = str;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public boolean run() {
        if (this.f67401h == null || this.f67400g == null) {
            return false;
        }
        if (this.f67394a) {
            return true;
        }
        this.f67399f.setSeq(this.f67396c);
        d.r.b.a.a.f.e.a a2 = this.f67400g.a(this.f67397d, this.f67398e, this.f67399f);
        if (a2 == null) {
            return false;
        }
        this.f67394a = true;
        d.r.b.a.a.j.d.b bVar = this.f67401h;
        String str = this.f67396c;
        if (a2 == null) {
            Intrinsics.throwNpe();
        }
        byte[] b2 = a2.b();
        Intrinsics.checkExpressionValueIsNotNull(b2, "req!!.marshall()");
        bVar.b(str, b2);
        return true;
    }
}
