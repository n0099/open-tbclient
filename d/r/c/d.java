package d.r.c;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f67460a;

    /* renamed from: b  reason: collision with root package name */
    public String f67461b;

    public d(int i2) {
        this.f67460a = i2;
        if (i2 == 0) {
            this.f67461b = "成功";
        } else if (i2 == 1) {
            this.f67461b = "未能找到可用的授权APP";
        } else if (i2 == 2) {
            this.f67461b = "授权APP版本太低，请先升级";
        } else if (i2 != 3) {
            this.f67461b = "未知错误";
        } else {
            this.f67461b = "App配置错误，请在AndroidManifest.xml加上BridgeActivity声明";
        }
    }

    public d(int i2, String str) {
        this.f67460a = i2;
        this.f67461b = str;
    }
}
