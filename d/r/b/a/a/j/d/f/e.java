package d.r.b.a.a.j.d.f;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes7.dex */
public final class e extends d.r.b.a.a.j.d.a implements d.r.b.a.a.j.d.f.a {
    public static final a q = new a(null);

    /* renamed from: h  reason: collision with root package name */
    public d.r.b.a.a.f.e.a f68131h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68132i;
    public Object j;
    public String k;
    public final int l;
    public final int m;
    public final RequestParams n;
    public final c o;
    public final d.r.b.a.a.j.d.b p;

    /* loaded from: classes7.dex */
    public static final class a {
        public a() {
        }

        public final e a(int i2, int i3, RequestParams requestParams, c cVar, d.r.b.a.a.j.d.b bVar, int i4, int i5, int i6, int i7) {
            requestParams.setSeq(d.r.b.a.a.f.h.e.a());
            e eVar = new e(i2, i3, requestParams, cVar, bVar, i4, i5, i6, i7);
            String seq = requestParams.getSeq();
            if (seq == null) {
                Intrinsics.throwNpe();
            }
            eVar.n(seq);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("obtain seq = %s", Arrays.copyOf(new Object[]{eVar.l()}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            d.r.b.a.a.f.d.d.f("RevenueService-RetryRequestJob", format);
            return eVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(int i2, int i3, RequestParams requestParams, c cVar, d.r.b.a.a.j.d.b bVar, int i4, int i5, int i6, int i7) {
        super(new Handler(Looper.getMainLooper()), i6, i4, i5, i7);
        this.l = i2;
        this.m = i3;
        this.n = requestParams;
        this.o = cVar;
        this.p = bVar;
        this.k = "";
    }

    @Override // d.r.b.a.a.j.d.f.a
    public void a(Object obj) {
        this.j = obj;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public int b() {
        return this.l;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public Object c() {
        return this.j;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void d() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("retryCountExhaust command = %d, appId = %d, seq = %s", Arrays.copyOf(new Object[]{Integer.valueOf(this.l), Integer.valueOf(this.m), this.k}, 3));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        d.r.b.a.a.f.d.d.e("RevenueService-RetryRequestJob", format, new Object[0]);
        d.r.b.a.a.j.d.b bVar = this.p;
        if (bVar != null) {
            bVar.a(this.l, this.k, RetryPolicy.Status.RETRY_COUNT_EXHAUST.getCode(), RetryPolicy.Status.RETRY_COUNT_EXHAUST.getMessage());
        }
    }

    @Override // d.r.b.a.a.j.d.f.a
    public String e() {
        return this.k;
    }

    @Override // d.r.b.a.a.j.d.a
    public void j() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onRetry command = %d, appId = %d, seq = %s", Arrays.copyOf(new Object[]{Integer.valueOf(this.l), Integer.valueOf(this.m), this.k}, 3));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        d.r.b.a.a.f.d.d.f("RevenueService-RetryRequestJob", format);
        d.r.b.a.a.j.d.b bVar = this.p;
        if (bVar == null) {
            Intrinsics.throwNpe();
        }
        String str = this.k;
        d.r.b.a.a.f.e.a aVar = this.f68131h;
        if (aVar == null) {
            Intrinsics.throwNpe();
        }
        byte[] b2 = aVar.b();
        Intrinsics.checkExpressionValueIsNotNull(b2, "req!!.marshall()");
        bVar.b(str, b2);
    }

    public final String l() {
        return this.k;
    }

    public final void m(int i2, String str) {
        switch (i2) {
            case 408:
            case 504:
            case NetWorkErr.GET_FORUM_LIST_ERROR /* 110001 */:
            case 110003:
            case 200408:
            case 200504:
                k();
                return;
            default:
                d.r.b.a.a.j.d.b bVar = this.p;
                if (bVar != null) {
                    bVar.a(this.l, this.k, i2, str);
                }
                h();
                return;
        }
    }

    public final void n(String str) {
        this.k = str;
    }

    @Override // d.r.b.a.a.j.d.f.a
    public boolean run() {
        if (this.p == null || this.o == null) {
            return false;
        }
        if (this.f68132i) {
            return true;
        }
        this.n.setSeq(this.k);
        d.r.b.a.a.f.e.a a2 = this.o.a(this.l, this.m, this.n);
        this.f68131h = a2;
        if (a2 == null) {
            return false;
        }
        this.f68132i = true;
        g();
        return this.f68132i;
    }
}
