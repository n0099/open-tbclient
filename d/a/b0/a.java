package d.a.b0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.c0.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static d.a.c0.a f38286a = null;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.c0.o.a.a f38287b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f38288c = 1;

    /* renamed from: d.a.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0475a extends a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.b0.e.a f38289a;

        public C0475a(a aVar, d.a.b0.e.a aVar2) {
            this.f38289a = aVar2;
        }

        @Override // d.a.c0.a.b
        public void a(int i2, String str) {
            if (i2 == 3) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("statusCode", 6);
                    this.f38289a.onPayResult(6, jSONObject.toString());
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f38289a.onPayResult(6, str);
                    return;
                }
            }
            this.f38289a.onPayResult(i2, str);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.a.c0.o.a.c {

        /* renamed from: d.a.b0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0476a implements d.a.b0.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.c0.o.a.a f38290a;

            public C0476a(b bVar, d.a.c0.o.a.a aVar) {
                this.f38290a = aVar;
            }

            @Override // d.a.b0.e.a
            public void onPayResult(int i2, String str) {
                a.f(this.f38290a, i2, str);
            }
        }

        /* renamed from: d.a.b0.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0477b implements d.a.b0.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.c0.o.a.a f38291a;

            public C0477b(b bVar, d.a.c0.o.a.a aVar) {
                this.f38291a = aVar;
            }

            @Override // d.a.b0.e.a
            public void onPayResult(int i2, String str) {
                a.f(this.f38291a, i2, str);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements d.a.b0.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.c0.o.a.a f38292a;

            public c(b bVar, d.a.c0.o.a.a aVar) {
                this.f38292a = aVar;
            }

            @Override // d.a.b0.e.a
            public void onPayResult(int i2, String str) {
                a.f(this.f38292a, i2, str);
            }
        }

        @Override // d.a.c0.o.a.c
        public void a(Activity activity, d.a.c0.o.a.b bVar, d.a.c0.o.a.a aVar) {
            if (bVar == null || TextUtils.isEmpty(bVar.f39498a) || bVar.f39499b == null) {
                a.f(aVar, 6, "支付信息不能为空");
                return;
            }
            String str = bVar.f39498a;
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
                d.a.b0.c.e().a(activity, bVar.f39499b.optString("orderInfo"), new C0476a(this, aVar));
            } else if (c2 == 2) {
                d.a.b0.c.e().d(activity, bVar.f39499b, new C0477b(this, aVar));
            } else if (c2 == 3) {
                d.a.b0.c.e().b(activity, bVar.f39499b.optString("orderInfo"), new c(this, aVar));
            } else if (c2 == 4) {
                d.a.c0.o.a.a unused = a.f38287b = aVar;
                d.c();
                d.a.b0.c.e().c(activity, bVar.f39499b);
            } else {
                aVar.onResult(3, "未知的支付方式");
            }
            activity.finish();
        }
    }

    public static d.a.c0.a e(Context context) {
        d.a.c0.a aVar = f38286a;
        if (aVar != null) {
            return aVar;
        }
        f38288c = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
        a.C0500a c0500a = new a.C0500a();
        c0500a.g(f38288c);
        c0500a.e(context.getApplicationContext());
        c0500a.f(false);
        d.a.c0.a d2 = c0500a.d();
        f38286a = d2;
        return d2;
    }

    public static void f(d.a.c0.o.a.a aVar, int i2, String str) {
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

    public static d.a.c0.o.a.c g() {
        return new b();
    }

    public static void h(int i2, String str) {
        d.a.c0.o.a.a aVar = f38287b;
        if (aVar != null) {
            aVar.onResult(i2, str);
            f38287b = null;
        }
    }

    public static boolean j() {
        return false;
    }

    public boolean c(Activity activity, String str, d.a.b0.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.a.b0.b.a().b(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, d.a.b0.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.a.b0.b.a().d(activity, str, aVar);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void i(Activity activity, JSONObject jSONObject, String[] strArr, d.a.b0.e.a aVar) {
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
        bundle.putString("zid", d.a.b0.b.a().e(activity));
        e(activity).a(activity, bundle, g(), new C0475a(this, aVar));
    }

    public void k(JSONObject jSONObject, d.a.c0.l.a aVar) {
        e(AppRuntime.getAppContext()).b(1, jSONObject, aVar);
    }

    public void l(d.a.c0.l.a aVar) {
        e(AppRuntime.getAppContext()).b(2, null, aVar);
    }
}
