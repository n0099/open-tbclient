package common.network.download;
/* loaded from: classes.dex */
public class f {
    private String mName;
    private int mType;
    private String mUrl;

    public f(String str, String str2) {
        this(str, str2, 0);
    }

    public f(String str, String str2, int i) {
        this.mUrl = str;
        this.mName = str2;
        this.mType = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getName() {
        return this.mName;
    }
}
