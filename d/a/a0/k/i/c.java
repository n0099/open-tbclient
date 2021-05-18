package d.a.a0.k.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.m;
import com.baidu.walletfacesdk.LightInvokerImpl;
import d.a.a0.g;
import d.a.a0.k.h.d;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public b f38455a;

    /* loaded from: classes2.dex */
    public class a extends d.a.a0.k.a.a<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f38456a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f38457b;

        /* renamed from: d.a.a0.k.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0484a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.a0.p.c f38459e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f38460f;

            public RunnableC0484a(d.a.a0.p.c cVar, String str) {
                this.f38459e = cVar;
                this.f38460f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.a0.p.c cVar = this.f38459e;
                if (cVar != null && cVar.u()) {
                    this.f38459e.q();
                }
                a.this.f38457b.g(0, this.f38460f);
            }
        }

        public a(String str, m mVar) {
            this.f38456a = str;
            this.f38457b = mVar;
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            m mVar = this.f38457b;
            mVar.m("launchpayment error msg is " + message, str);
            d.a.a0.k.h.b bVar = new d.a.a0.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("launchpayment error --> " + str, th).U());
            d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            d.f38421c = map.get("orderId");
            if (!map.containsKey("parentType")) {
                c.this.d(map, this.f38456a, this.f38457b);
                return;
            }
            String str = map.get("parentType");
            if (TextUtils.isEmpty(str)) {
                c.this.d(map, this.f38456a, this.f38457b);
            } else if (4 != Integer.parseInt(str)) {
                c.this.d(map, this.f38456a, this.f38457b);
            } else {
                String a2 = d.a.a0.n.b.a(0, map.get("orderId"), "Successful payment");
                d.a.a0.p.c cVar = new d.a.a0.p.c(View.inflate(this.f38457b.getContext(), g.pay_success, null), -1, -1, true);
                cVar.y(false);
                cVar.A(false);
                cVar.C(false);
                cVar.E(this.f38457b, 0, 0, 0);
                new Handler().postDelayed(new RunnableC0484a(cVar, a2), 2000L);
                d.a.a0.k.h.a.g("8");
                d.a.a0.n.d.e("WalletList->pay() 命中0单元");
            }
        }
    }

    public c(b bVar) {
        this.f38455a = bVar;
    }

    public final void a(Activity activity, String str, Map<String, String> map) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(activity, PayWebActivity.class);
        intent.putExtra("load_url", str);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        intent.putExtra("launch_payment_data", bundle);
        activity.startActivityForResult(intent, 200);
    }

    public void c(Bundle bundle, String str, m mVar) {
        d.a.a0.k.b.b.j().d(bundle, new a(str, mVar), str);
    }

    public final void d(Map<String, String> map, String str, m mVar) {
        String str2 = map.get("extData");
        if (!TextUtils.isEmpty(str2)) {
            try {
                if (TextUtils.equals(new JSONObject(str2).optString(LightInvokerImpl.VOICE_ACTIONTYPE), "H5")) {
                    String str3 = map.get("payUrl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (e(mVar.getContext())) {
                            mVar.setWechatH5Pay(true);
                            mVar.setIsPreparePaying(false);
                            a((Activity) mVar.getContext(), str3, map);
                            d.a.a0.k.h.a.g("8");
                            return;
                        }
                        Toast.makeText(mVar.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                        mVar.g(3, "wx_not_installed");
                        return;
                    }
                    mVar.m("H5 no corresponding url ", null);
                    d.a.a0.k.h.a.d("8", null, "H5 no corresponding url");
                    return;
                }
            } catch (Exception unused) {
                mVar.m("launchpayment extData analyze failed ", null);
                d.a.a0.k.h.a.d("8", null, "launchpayment extData analyze failed");
                return;
            }
        }
        this.f38455a.b(map, str, mVar);
    }

    public final boolean e(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (installedPackages.get(i2).packageName.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }
}
