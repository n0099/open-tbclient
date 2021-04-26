package d.a.h0.b.m.g;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f45592a;

    /* renamed from: b  reason: collision with root package name */
    public String f45593b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45594c;

    /* renamed from: d  reason: collision with root package name */
    public String f45595d;

    /* renamed from: e  reason: collision with root package name */
    public int f45596e;

    /* renamed from: f  reason: collision with root package name */
    public String f45597f;

    /* renamed from: g  reason: collision with root package name */
    public String f45598g;

    public String a() {
        char c2;
        String str = this.f45595d;
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
            this.f45598g = AppRuntime.getAppContext().getString(g.account_onekey_login_dx_agree_text);
        } else if (c2 == 1) {
            this.f45598g = AppRuntime.getAppContext().getString(g.account_onekey_login_lt_agree_text);
        } else if (c2 != 2) {
            this.f45598g = "";
        } else {
            this.f45598g = AppRuntime.getAppContext().getString(g.account_onekey_login_yd_agree_text);
        }
        return this.f45598g;
    }

    public String b() {
        char c2;
        String str = this.f45595d;
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
            this.f45597f = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
        } else if (c2 == 1) {
            this.f45597f = "https://ms.zzx9.cn/html/oauth/protocol2.html";
        } else if (c2 == 2) {
            this.f45597f = "https://wap.cmpassport.com/resources/html/contract.html";
        }
        return this.f45597f;
    }

    public String c() {
        return this.f45593b;
    }

    public boolean d() {
        return this.f45594c;
    }

    public int e() {
        return this.f45596e;
    }

    public boolean f() {
        return this.f45592a;
    }

    public void g(String str) {
        this.f45593b = str;
    }

    public void h(boolean z) {
        this.f45594c = z;
    }

    public void i(int i2) {
        this.f45596e = i2;
    }

    public void j(boolean z) {
        this.f45592a = z;
    }

    public void k(String str) {
        this.f45595d = str;
    }
}
