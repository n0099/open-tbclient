package d.a.z;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.a0.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.a0.a f64903a = null;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.a0.o.a.a f64904b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f64905c = 1;

    /* renamed from: d.a.z.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1816a extends a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.z.e.a f64906a;

        public C1816a(a aVar, d.a.z.e.a aVar2) {
            this.f64906a = aVar2;
        }

        @Override // d.a.a0.a.b
        public void a(int i2, String str) {
            if (i2 == 3) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("statusCode", 6);
                    this.f64906a.onPayResult(6, jSONObject.toString());
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f64906a.onPayResult(6, str);
                    return;
                }
            }
            this.f64906a.onPayResult(i2, str);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.a.a0.o.a.c {

        /* renamed from: d.a.z.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1817a implements d.a.z.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.a0.o.a.a f64907a;

            public C1817a(b bVar, d.a.a0.o.a.a aVar) {
                this.f64907a = aVar;
            }

            @Override // d.a.z.e.a
            public void onPayResult(int i2, String str) {
                a.f(this.f64907a, i2, str);
            }
        }

        /* renamed from: d.a.z.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1818b implements d.a.z.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.a0.o.a.a f64908a;

            public C1818b(b bVar, d.a.a0.o.a.a aVar) {
                this.f64908a = aVar;
            }

            @Override // d.a.z.e.a
            public void onPayResult(int i2, String str) {
                a.f(this.f64908a, i2, str);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements d.a.z.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.a0.o.a.a f64909a;

            public c(b bVar, d.a.a0.o.a.a aVar) {
                this.f64909a = aVar;
            }

            @Override // d.a.z.e.a
            public void onPayResult(int i2, String str) {
                a.f(this.f64909a, i2, str);
            }
        }

        @Override // d.a.a0.o.a.c
        public void a(Activity activity, d.a.a0.o.a.b bVar, d.a.a0.o.a.a aVar) {
            if (bVar == null || TextUtils.isEmpty(bVar.f38478a) || bVar.f38479b == null) {
                a.f(aVar, 6, "支付信息不能为空");
                return;
            }
            String str = bVar.f38478a;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1537577171:
                    if (str.equals("BAIDU-QUICKPAY")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1021180251:
                    if (str.equals("BAIDU-ALIPAY-WISE-HUABEI-PAY")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 299450696:
                    if (str.equals(PayChannelController.BAIFUBAO_PAYCHANNEL)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1455583605:
                    if (str.equals(PayChannelController.ALIPAY_PAYCHANNEL)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1525377225:
                    if (str.equals("BAIDU-CHINAPAY-B2C")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 2009937959:
                    if (str.equals(PayChannelController.WXPAY_PAYCHANNEL)) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                d.a.z.c.e().a(activity, bVar.f38479b.optString("orderInfo"), new C1817a(this, aVar));
            } else if (c2 == 2) {
                d.a.z.c.e().d(activity, bVar.f38479b, new C1818b(this, aVar));
            } else if (c2 == 3) {
                d.a.z.c.e().b(activity, bVar.f38479b.optString("orderInfo"), new c(this, aVar));
            } else if (c2 == 4) {
                d.a.a0.o.a.a unused = a.f64904b = aVar;
                d.c();
                d.a.z.c.e().c(activity, bVar.f38479b);
            } else {
                aVar.onResult(3, "未知的支付方式");
            }
            activity.finish();
        }
    }

    public static d.a.a0.a e(Context context) {
        d.a.a0.a aVar = f64903a;
        if (aVar != null) {
            return aVar;
        }
        f64905c = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
        a.C0474a c0474a = new a.C0474a();
        c0474a.g(f64905c);
        c0474a.e(context.getApplicationContext());
        c0474a.f(false);
        d.a.a0.a d2 = c0474a.d();
        f64903a = d2;
        return d2;
    }

    public static void f(d.a.a0.o.a.a aVar, int i2, String str) {
        if (aVar != null) {
            int i3 = 2;
            if (i2 == 0) {
                i3 = 0;
            } else if (i2 == 1) {
                i3 = 1;
            } else if (i2 != 2) {
                i3 = 3;
            }
            aVar.onResult(i3, str);
        }
    }

    public static d.a.a0.o.a.c g() {
        return new b();
    }

    public static void h(int i2, String str) {
        d.a.a0.o.a.a aVar = f64904b;
        if (aVar != null) {
            aVar.onResult(i2, str);
            f64904b = null;
        }
    }

    public static boolean j() {
        return false;
    }

    public boolean c(Activity activity, String str, d.a.z.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.a.z.b.a().b(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, d.a.z.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.a.z.b.a().d(activity, str, aVar);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void i(Activity activity, JSONObject jSONObject, String[] strArr, d.a.z.e.a aVar) {
        Bundle bundle;
        char c2;
        char c3;
        String[] strArr2 = strArr;
        if (activity == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle2.putString(next, jSONObject.optString(next));
        }
        String str = "BAIDU-CHINAPAY-B2C";
        if (strArr2 != null) {
            String[] strArr3 = new String[strArr2.length];
            int i2 = 0;
            while (i2 < strArr2.length) {
                String str2 = strArr2[i2];
                switch (str2.hashCode()) {
                    case -2122629326:
                        if (str2.equals("Huabei")) {
                            c3 = 4;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case -1708856474:
                        if (str2.equals("WeChat")) {
                            c3 = 1;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case -1001747525:
                        if (str2.equals("Quickpay")) {
                            c3 = 3;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1725926417:
                        if (str2.equals("Chinapay")) {
                            c3 = 5;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1865715419:
                        if (str2.equals("BDWallet")) {
                            c3 = 2;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1963873898:
                        if (str2.equals("Alipay")) {
                            c3 = 0;
                            break;
                        }
                        c3 = 65535;
                        break;
                    default:
                        c3 = 65535;
                        break;
                }
                if (c3 == 0) {
                    strArr3[i2] = PayChannelController.ALIPAY_PAYCHANNEL;
                } else if (c3 == 1) {
                    strArr3[i2] = PayChannelController.WXPAY_PAYCHANNEL;
                } else if (c3 == 2) {
                    strArr3[i2] = PayChannelController.BAIFUBAO_PAYCHANNEL;
                } else if (c3 == 3) {
                    strArr3[i2] = "BAIDU-QUICKPAY";
                } else if (c3 == 4) {
                    strArr3[i2] = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                } else if (c3 == 5) {
                    strArr3[i2] = "BAIDU-CHINAPAY-B2C";
                }
                i2++;
                strArr2 = strArr;
            }
            bundle = bundle2;
            bundle.putStringArray("blockedPayChannels", strArr3);
        } else {
            bundle = bundle2;
        }
        String string = bundle.getString("chosenChannel", "");
        if (!TextUtils.isEmpty(string)) {
            switch (string.hashCode()) {
                case -2122629326:
                    if (string.equals("Huabei")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1708856474:
                    if (string.equals("WeChat")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1001747525:
                    if (string.equals("Quickpay")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1725926417:
                    if (string.equals("Chinapay")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1865715419:
                    if (string.equals("BDWallet")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1963873898:
                    if (string.equals("Alipay")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                str = PayChannelController.ALIPAY_PAYCHANNEL;
            } else if (c2 == 1) {
                str = PayChannelController.WXPAY_PAYCHANNEL;
            } else if (c2 == 2) {
                str = PayChannelController.BAIFUBAO_PAYCHANNEL;
            } else if (c2 == 3) {
                str = "BAIDU-QUICKPAY";
            } else if (c2 == 4) {
                str = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
            } else if (c2 != 5) {
                str = string;
            }
            bundle.putString("chosenChannel", str);
        }
        bundle.putString("zid", d.a.z.b.a().e(activity));
        e(activity).a(activity, bundle, g(), new C1816a(this, aVar));
    }

    public void k(JSONObject jSONObject, d.a.a0.l.a aVar) {
        e(AppRuntime.getAppContext()).b(1, jSONObject, aVar);
    }

    public void l(d.a.a0.l.a aVar) {
        e(AppRuntime.getAppContext()).b(2, null, aVar);
    }
}
