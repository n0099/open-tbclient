package d.b.y;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.z.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.z.a f65597a = null;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.z.o.a.a f65598b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f65599c = 1;

    /* renamed from: d.b.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1793a extends a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.y.e.a f65600a;

        public C1793a(a aVar, d.b.y.e.a aVar2) {
            this.f65600a = aVar2;
        }

        @Override // d.b.z.a.b
        public void a(int i, String str) {
            if (i == 3) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("statusCode", 6);
                    this.f65600a.onPayResult(6, jSONObject.toString());
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f65600a.onPayResult(6, str);
                    return;
                }
            }
            this.f65600a.onPayResult(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.b.z.o.a.c {

        /* renamed from: d.b.y.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1794a implements d.b.y.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.z.o.a.a f65601a;

            public C1794a(b bVar, d.b.z.o.a.a aVar) {
                this.f65601a = aVar;
            }

            @Override // d.b.y.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f65601a, i, str);
            }
        }

        /* renamed from: d.b.y.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1795b implements d.b.y.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.z.o.a.a f65602a;

            public C1795b(b bVar, d.b.z.o.a.a aVar) {
                this.f65602a = aVar;
            }

            @Override // d.b.y.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f65602a, i, str);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements d.b.y.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.z.o.a.a f65603a;

            public c(b bVar, d.b.z.o.a.a aVar) {
                this.f65603a = aVar;
            }

            @Override // d.b.y.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f65603a, i, str);
            }
        }

        /* loaded from: classes2.dex */
        public class d implements d.b.y.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.z.o.a.a f65604a;

            public d(b bVar, d.b.z.o.a.a aVar) {
                this.f65604a = aVar;
            }

            @Override // d.b.y.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f65604a, i, str);
            }
        }

        @Override // d.b.z.o.a.c
        public void a(Activity activity, d.b.z.o.a.b bVar, d.b.z.o.a.a aVar) {
            if (bVar == null || TextUtils.isEmpty(bVar.f65750a) || bVar.f65751b == null) {
                a.f(aVar, 6, "支付信息不能为空");
                return;
            }
            String str = bVar.f65750a;
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
                d.b.y.c.f().a(activity, bVar.f65751b.optString("orderInfo"), new C1794a(this, aVar));
            } else if (c2 == 2) {
                d.b.y.c.f().e(activity, bVar.f65751b, new C1795b(this, aVar));
            } else if (c2 == 3) {
                d.b.y.c.f().b(activity, bVar.f65751b.optString("orderInfo"), new c(this, aVar));
            } else if (c2 == 4) {
                d.b.z.o.a.a unused = a.f65598b = aVar;
                d.b.y.d.c();
                d.b.y.c.f().d(activity, bVar.f65751b);
            } else if (c2 != 5) {
                aVar.onResult(3, "未知的支付方式");
            } else {
                d.b.y.c.f().c(activity, bVar.f65751b, new d(this, aVar));
            }
            activity.finish();
        }
    }

    public static d.b.z.a e(Context context) {
        d.b.z.a aVar = f65597a;
        if (aVar != null) {
            return aVar;
        }
        f65599c = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
        a.C1796a c1796a = new a.C1796a();
        c1796a.g(f65599c);
        c1796a.e(context.getApplicationContext());
        c1796a.f(false);
        d.b.z.a d2 = c1796a.d();
        f65597a = d2;
        return d2;
    }

    public static void f(d.b.z.o.a.a aVar, int i, String str) {
        if (aVar != null) {
            int i2 = 2;
            if (i == 0) {
                i2 = 0;
            } else if (i == 1) {
                i2 = 1;
            } else if (i != 2) {
                i2 = 3;
            }
            aVar.onResult(i2, str);
        }
    }

    public static d.b.z.o.a.c g() {
        return new b();
    }

    public static void h(int i, String str) {
        d.b.z.o.a.a aVar = f65598b;
        if (aVar != null) {
            aVar.onResult(i, str);
            f65598b = null;
        }
    }

    public static boolean j() {
        return false;
    }

    public boolean c(Activity activity, String str, d.b.y.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.b.y.b.a().d(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, d.b.y.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.b.y.b.a().c(activity, str, aVar);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void i(Activity activity, JSONObject jSONObject, String[] strArr, d.b.y.e.a aVar) {
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
            int i = 0;
            while (i < strArr2.length) {
                String str2 = strArr2[i];
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
                    strArr3[i] = PayChannelController.ALIPAY_PAYCHANNEL;
                } else if (c3 == 1) {
                    strArr3[i] = PayChannelController.WXPAY_PAYCHANNEL;
                } else if (c3 == 2) {
                    strArr3[i] = PayChannelController.BAIFUBAO_PAYCHANNEL;
                } else if (c3 == 3) {
                    strArr3[i] = "BAIDU-QUICKPAY";
                } else if (c3 == 4) {
                    strArr3[i] = "BAIDU-ALIPAY-WISE-HUABEI-PAY";
                } else if (c3 == 5) {
                    strArr3[i] = "BAIDU-CHINAPAY-B2C";
                }
                i++;
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
        bundle.putString("zid", d.b.y.b.a().e(activity));
        e(activity).a(activity, bundle, g(), new C1793a(this, aVar));
    }

    public void k(JSONObject jSONObject, d.b.z.l.a aVar) {
        e(AppRuntime.getAppContext()).b(1, jSONObject, aVar);
    }

    public void l(d.b.z.l.a aVar) {
        e(AppRuntime.getAppContext()).b(2, null, aVar);
    }
}
