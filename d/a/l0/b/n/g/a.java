package d.a.l0.b.n.g;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50061a;

    /* renamed from: b  reason: collision with root package name */
    public String f50062b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50063c;

    /* renamed from: d  reason: collision with root package name */
    public String f50064d;

    /* renamed from: e  reason: collision with root package name */
    public int f50065e;

    /* renamed from: f  reason: collision with root package name */
    public String f50066f;

    /* renamed from: g  reason: collision with root package name */
    public String f50067g;

    public String a() {
        char c2;
        String str = this.f50064d;
        int hashCode = str.hashCode();
        if (hashCode == 2154) {
            if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 2161) {
            if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            this.f50067g = AppRuntime.getAppContext().getString(g.account_onekey_login_dx_agree_text);
        } else if (c2 == 1) {
            this.f50067g = AppRuntime.getAppContext().getString(g.account_onekey_login_lt_agree_text);
        } else if (c2 != 2) {
            this.f50067g = "";
        } else {
            this.f50067g = AppRuntime.getAppContext().getString(g.account_onekey_login_yd_agree_text);
        }
        return this.f50067g;
    }

    public String b() {
        char c2;
        String str = this.f50064d;
        int hashCode = str.hashCode();
        if (hashCode == 2154) {
            if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 2161) {
            if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            this.f50066f = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
        } else if (c2 == 1) {
            this.f50066f = "https://ms.zzx9.cn/html/oauth/protocol2.html";
        } else if (c2 == 2) {
            this.f50066f = "https://wap.cmpassport.com/resources/html/contract.html";
        }
        return this.f50066f;
    }

    public String c() {
        return this.f50062b;
    }

    public boolean d() {
        return this.f50063c;
    }

    public int e() {
        return this.f50065e;
    }

    public boolean f() {
        return this.f50061a;
    }

    public void g(String str) {
        this.f50062b = str;
    }

    public void h(boolean z) {
        this.f50063c = z;
    }

    public void i(int i2) {
        this.f50065e = i2;
    }

    public void j(boolean z) {
        this.f50061a = z;
    }

    public void k(String str) {
        this.f50064d = str;
    }
}
