package d.b.g0.b.m.g;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f47817a;

    /* renamed from: b  reason: collision with root package name */
    public String f47818b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47819c;

    /* renamed from: d  reason: collision with root package name */
    public String f47820d;

    /* renamed from: e  reason: collision with root package name */
    public int f47821e;

    /* renamed from: f  reason: collision with root package name */
    public String f47822f;

    /* renamed from: g  reason: collision with root package name */
    public String f47823g;

    public String a() {
        char c2;
        String str = this.f47820d;
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
            this.f47823g = AppRuntime.getAppContext().getString(g.account_onekey_login_dx_agree_text);
        } else if (c2 == 1) {
            this.f47823g = AppRuntime.getAppContext().getString(g.account_onekey_login_lt_agree_text);
        } else if (c2 != 2) {
            this.f47823g = "";
        } else {
            this.f47823g = AppRuntime.getAppContext().getString(g.account_onekey_login_yd_agree_text);
        }
        return this.f47823g;
    }

    public String b() {
        char c2;
        String str = this.f47820d;
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
            this.f47822f = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
        } else if (c2 == 1) {
            this.f47822f = "https://ms.zzx9.cn/html/oauth/protocol2.html";
        } else if (c2 == 2) {
            this.f47822f = "https://wap.cmpassport.com/resources/html/contract.html";
        }
        return this.f47822f;
    }

    public String c() {
        return this.f47818b;
    }

    public boolean d() {
        return this.f47819c;
    }

    public int e() {
        return this.f47821e;
    }

    public boolean f() {
        return this.f47817a;
    }

    public void g(String str) {
        this.f47818b = str;
    }

    public void h(boolean z) {
        this.f47819c = z;
    }

    public void i(int i) {
        this.f47821e = i;
    }

    public void j(boolean z) {
        this.f47817a = z;
    }

    public void k(String str) {
        this.f47820d = str;
    }
}
