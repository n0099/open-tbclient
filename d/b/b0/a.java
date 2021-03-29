package d.b.b0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.c0.a;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static d.b.c0.a f42471a = null;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.c0.o.a.a f42472b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f42473c = 1;

    /* renamed from: d.b.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0553a extends a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.b0.e.a f42474a;

        public C0553a(a aVar, d.b.b0.e.a aVar2) {
            this.f42474a = aVar2;
        }

        @Override // d.b.c0.a.b
        public void a(int i, String str) {
            if (i == 3) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("statusCode", 6);
                    this.f42474a.onPayResult(6, jSONObject.toString());
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f42474a.onPayResult(6, str);
                    return;
                }
            }
            this.f42474a.onPayResult(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.b.c0.o.a.c {

        /* renamed from: d.b.b0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0554a implements d.b.b0.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.c0.o.a.a f42475a;

            public C0554a(b bVar, d.b.c0.o.a.a aVar) {
                this.f42475a = aVar;
            }

            @Override // d.b.b0.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f42475a, i, str);
            }
        }

        /* renamed from: d.b.b0.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0555b implements d.b.b0.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.c0.o.a.a f42476a;

            public C0555b(b bVar, d.b.c0.o.a.a aVar) {
                this.f42476a = aVar;
            }

            @Override // d.b.b0.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f42476a, i, str);
            }
        }

        /* loaded from: classes2.dex */
        public class c implements d.b.b0.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.c0.o.a.a f42477a;

            public c(b bVar, d.b.c0.o.a.a aVar) {
                this.f42477a = aVar;
            }

            @Override // d.b.b0.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f42477a, i, str);
            }
        }

        /* loaded from: classes2.dex */
        public class d implements d.b.b0.e.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.b.c0.o.a.a f42478a;

            public d(b bVar, d.b.c0.o.a.a aVar) {
                this.f42478a = aVar;
            }

            @Override // d.b.b0.e.a
            public void onPayResult(int i, String str) {
                a.f(this.f42478a, i, str);
            }
        }

        @Override // d.b.c0.o.a.c
        public void a(Activity activity, d.b.c0.o.a.b bVar, d.b.c0.o.a.a aVar) {
            if (bVar == null || TextUtils.isEmpty(bVar.f42682a) || bVar.f42683b == null) {
                a.f(aVar, 6, "支付信息不能为空");
                return;
            }
            String str = bVar.f42682a;
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
                d.b.b0.c.f().a(activity, bVar.f42683b.optString("orderInfo"), new C0554a(this, aVar));
            } else if (c2 == 2) {
                d.b.b0.c.f().e(activity, bVar.f42683b, new C0555b(this, aVar));
            } else if (c2 == 3) {
                d.b.b0.c.f().b(activity, bVar.f42683b.optString("orderInfo"), new c(this, aVar));
            } else if (c2 == 4) {
                d.b.c0.o.a.a unused = a.f42472b = aVar;
                d.b.b0.d.c();
                d.b.b0.c.f().d(activity, bVar.f42683b);
            } else if (c2 != 5) {
                aVar.onResult(3, "未知的支付方式");
            } else {
                d.b.b0.c.f().c(activity, bVar.f42683b, new d(this, aVar));
            }
            activity.finish();
        }
    }

    public static d.b.c0.a e(Context context) {
        d.b.c0.a aVar = f42471a;
        if (aVar != null) {
            return aVar;
        }
        f42473c = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getInt("poly_cashier_env", 1);
        a.C0559a c0559a = new a.C0559a();
        c0559a.g(f42473c);
        c0559a.e(context.getApplicationContext());
        c0559a.f(false);
        d.b.c0.a d2 = c0559a.d();
        f42471a = d2;
        return d2;
    }

    public static void f(d.b.c0.o.a.a aVar, int i, String str) {
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

    public static d.b.c0.o.a.c g() {
        return new b();
    }

    public static void h(int i, String str) {
        d.b.c0.o.a.a aVar = f42472b;
        if (aVar != null) {
            aVar.onResult(i, str);
            f42472b = null;
        }
    }

    public static boolean j() {
        return false;
    }

    public boolean c(Activity activity, String str, d.b.b0.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.b.b0.b.a().d(activity, str, aVar);
        return true;
    }

    public boolean d(Activity activity, String str, d.b.b0.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.b.b0.b.a().c(activity, str, aVar);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void i(Activity activity, JSONObject jSONObject, String[] strArr, d.b.b0.e.a aVar) {
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
        bundle.putString("zid", d.b.b0.b.a().e(activity));
        e(activity).a(activity, bundle, g(), new C0553a(this, aVar));
    }

    public void k(JSONObject jSONObject, d.b.c0.l.a aVar) {
        e(AppRuntime.getAppContext()).b(1, jSONObject, aVar);
    }

    public void l(d.b.c0.l.a aVar) {
        e(AppRuntime.getAppContext()).b(2, null, aVar);
    }
}
