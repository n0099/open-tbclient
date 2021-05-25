package d.r.c;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f68189a;

    /* renamed from: b  reason: collision with root package name */
    public String f68190b;

    public d(int i2) {
        this.f68189a = i2;
        if (i2 == 0) {
            this.f68190b = "成功";
        } else if (i2 == 1) {
            this.f68190b = "未能找到可用的授权APP";
        } else if (i2 == 2) {
            this.f68190b = "授权APP版本太低，请先升级";
        } else if (i2 != 3) {
            this.f68190b = "未知错误";
        } else {
            this.f68190b = "App配置错误，请在AndroidManifest.xml加上BridgeActivity声明";
        }
    }

    public d(int i2, String str) {
        this.f68189a = i2;
        this.f68190b = str;
    }
}
