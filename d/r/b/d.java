package d.r.b;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f71549a;

    /* renamed from: b  reason: collision with root package name */
    public String f71550b;

    public d(int i2) {
        this.f71549a = i2;
        if (i2 == 0) {
            this.f71550b = "成功";
        } else if (i2 == 1) {
            this.f71550b = "未能找到可用的授权APP";
        } else if (i2 == 2) {
            this.f71550b = "授权APP版本太低，请先升级";
        } else if (i2 != 3) {
            this.f71550b = "未知错误";
        } else {
            this.f71550b = "App配置错误，请在AndroidManifest.xml加上BridgeActivity声明";
        }
    }

    public d(int i2, String str) {
        this.f71549a = i2;
        this.f71550b = str;
    }
}
