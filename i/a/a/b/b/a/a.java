package i.a.a.b.b.a;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import d.r.b.a.a.i.c.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.pay.IMiddlePayService;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Activity f68723a;

    /* renamed from: c  reason: collision with root package name */
    public long f68725c;

    /* renamed from: e  reason: collision with root package name */
    public j f68727e;

    /* renamed from: f  reason: collision with root package name */
    public int f68728f;

    /* renamed from: g  reason: collision with root package name */
    public int f68729g;
    public Map<String, Object> k;
    public IPayCallback<String> l;
    public IToken m;

    /* renamed from: b  reason: collision with root package name */
    public PayType f68724b = PayType.ALI_PAY;

    /* renamed from: d  reason: collision with root package name */
    public String f68726d = "";

    /* renamed from: h  reason: collision with root package name */
    public IMiddlePayService.SubscriptType f68730h = IMiddlePayService.SubscriptType.NORMAL_CHARGE;

    /* renamed from: i  reason: collision with root package name */
    public IMiddlePayService.ChargeSource f68731i = IMiddlePayService.ChargeSource.WALLET_CHARGE;
    public String j = "";

    public final Activity a() {
        Activity activity = this.f68723a;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activity");
        }
        return activity;
    }

    public final IPayCallback<String> b() {
        return this.l;
    }

    public final IMiddlePayService.ChargeSource c() {
        return this.f68731i;
    }

    public final int d() {
        return this.f68729g;
    }

    public final Map<String, Object> e() {
        return this.k;
    }

    public final j f() {
        j jVar = this.f68727e;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
        }
        return jVar;
    }

    public final PayType g() {
        return this.f68724b;
    }

    public final String h() {
        return this.j;
    }

    public final IMiddlePayService.SubscriptType i() {
        return this.f68730h;
    }

    public final String j() {
        return this.f68726d;
    }

    public final IToken k() {
        return this.m;
    }

    public final long l() {
        return this.f68725c;
    }

    public final int m() {
        return this.f68728f;
    }

    public final void n(Activity activity) {
        this.f68723a = activity;
    }

    public final void o(IPayCallback<String> iPayCallback) {
        this.l = iPayCallback;
    }

    public final void p(int i2) {
        this.f68729g = i2;
    }

    public final void q(Map<String, Object> map) {
        this.k = map;
    }

    public final void r(j jVar) {
        this.f68727e = jVar;
    }

    public final void s(PayType payType) {
        this.f68724b = payType;
    }

    public final void t(String str) {
        this.f68726d = str;
    }

    public final void u(IToken iToken) {
        this.m = iToken;
    }

    public final void v(long j) {
        this.f68725c = j;
    }

    public final void w(int i2) {
        this.f68728f = i2;
    }
}
