package d.a.m0.b.n.g;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50169a;

    /* renamed from: b  reason: collision with root package name */
    public String f50170b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50171c;

    /* renamed from: d  reason: collision with root package name */
    public String f50172d;

    /* renamed from: e  reason: collision with root package name */
    public int f50173e;

    /* renamed from: f  reason: collision with root package name */
    public String f50174f;

    /* renamed from: g  reason: collision with root package name */
    public String f50175g;

    public String a() {
        char c2;
        String str = this.f50172d;
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
            this.f50175g = AppRuntime.getAppContext().getString(g.account_onekey_login_dx_agree_text);
        } else if (c2 == 1) {
            this.f50175g = AppRuntime.getAppContext().getString(g.account_onekey_login_lt_agree_text);
        } else if (c2 != 2) {
            this.f50175g = "";
        } else {
            this.f50175g = AppRuntime.getAppContext().getString(g.account_onekey_login_yd_agree_text);
        }
        return this.f50175g;
    }

    public String b() {
        char c2;
        String str = this.f50172d;
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
            this.f50174f = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
        } else if (c2 == 1) {
            this.f50174f = "https://ms.zzx9.cn/html/oauth/protocol2.html";
        } else if (c2 == 2) {
            this.f50174f = "https://wap.cmpassport.com/resources/html/contract.html";
        }
        return this.f50174f;
    }

    public String c() {
        return this.f50170b;
    }

    public boolean d() {
        return this.f50171c;
    }

    public int e() {
        return this.f50173e;
    }

    public boolean f() {
        return this.f50169a;
    }

    public void g(String str) {
        this.f50170b = str;
    }

    public void h(boolean z) {
        this.f50171c = z;
    }

    public void i(int i2) {
        this.f50173e = i2;
    }

    public void j(boolean z) {
        this.f50169a = z;
    }

    public void k(String str) {
        this.f50172d = str;
    }
}
