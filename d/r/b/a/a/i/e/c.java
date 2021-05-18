package d.r.b.a.a.i.e;

import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.AlipayProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.WechatPayProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.d.e;
import d.r.b.a.a.i.d.f;
import d.r.b.a.a.i.d.h;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, f> f67816a = new HashMap(5);

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f67817a = new c();
    }

    public static c d() {
        return a.f67817a;
    }

    public synchronized void a(PayType payType, f fVar) {
        if (this.f67816a.containsKey(payType.getChannel())) {
            d.f("PayMethodProxyFactory", "addPayMethodProxyMap but contains paychannel:" + payType.getChannel());
            return;
        }
        d.b("PayMethodProxyFactory", "addPayMethodProxyMap paychannel:" + payType.getChannel());
        this.f67816a.put(payType.getChannel(), fVar);
    }

    public synchronized IPayMethod b(PayType payType) {
        f c2 = c(payType);
        if (c2 == null) {
            d.b("PayMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
            return null;
        } else if (payType == PayType.ALI_PAY) {
            if (c2 instanceof d.r.b.a.a.i.d.c) {
                return new AlipayProxy((d.r.b.a.a.i.d.c) c2);
            }
            d.e("PayMethodProxyFactory", "paySdkServiceProxy is not IAlipaySdkProxy ", new Object[0]);
            return null;
        } else if (payType == PayType.WECHAT_PAY) {
            if (c2 instanceof h) {
                return new WechatPayProxy((h) c2);
            }
            d.e("PayMethodProxyFactory", "paySdkServiceProxy is not IWechatSdkProxy ", new Object[0]);
            return null;
        } else if (payType == PayType.DXM_PAY) {
            if (c2 instanceof e) {
                return new d.r.b.a.a.i.d.a((e) c2);
            }
            d.e("PayMethodProxyFactory", "paySdkServiceProxy is not IDxmSdkServiceProxy ", new Object[0]);
            return null;
        } else {
            return null;
        }
    }

    public synchronized f c(PayType payType) {
        f fVar = this.f67816a.get(payType.getChannel());
        if (fVar == null) {
            d.b("PayMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
            return null;
        }
        return fVar;
    }
}
