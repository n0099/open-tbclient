package d.a.i0.b.n.g;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.b.g;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f46211a;

    /* renamed from: b  reason: collision with root package name */
    public String f46212b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46213c;

    /* renamed from: d  reason: collision with root package name */
    public String f46214d;

    /* renamed from: e  reason: collision with root package name */
    public int f46215e;

    /* renamed from: f  reason: collision with root package name */
    public String f46216f;

    /* renamed from: g  reason: collision with root package name */
    public String f46217g;

    public String a() {
        char c2;
        String str = this.f46214d;
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
            this.f46217g = AppRuntime.getAppContext().getString(g.account_onekey_login_dx_agree_text);
        } else if (c2 == 1) {
            this.f46217g = AppRuntime.getAppContext().getString(g.account_onekey_login_lt_agree_text);
        } else if (c2 != 2) {
            this.f46217g = "";
        } else {
            this.f46217g = AppRuntime.getAppContext().getString(g.account_onekey_login_yd_agree_text);
        }
        return this.f46217g;
    }

    public String b() {
        char c2;
        String str = this.f46214d;
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
            this.f46216f = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
        } else if (c2 == 1) {
            this.f46216f = "https://ms.zzx9.cn/html/oauth/protocol2.html";
        } else if (c2 == 2) {
            this.f46216f = "https://wap.cmpassport.com/resources/html/contract.html";
        }
        return this.f46216f;
    }

    public String c() {
        return this.f46212b;
    }

    public boolean d() {
        return this.f46213c;
    }

    public int e() {
        return this.f46215e;
    }

    public boolean f() {
        return this.f46211a;
    }

    public void g(String str) {
        this.f46212b = str;
    }

    public void h(boolean z) {
        this.f46213c = z;
    }

    public void i(int i2) {
        this.f46215e = i2;
    }

    public void j(boolean z) {
        this.f46211a = z;
    }

    public void k(String str) {
        this.f46214d = str;
    }
}
