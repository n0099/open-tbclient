package tv.athena.revenue.payui.webview;

import androidx.annotation.Keep;
import com.baidu.tieba.yfd;
import com.google.gson.annotations.SerializedName;
@Keep
/* loaded from: classes2.dex */
public class UrlPageParams {
    @SerializedName("pageType")
    public int pageType;
    @SerializedName("rightIcon")
    public String rightIcon;
    @SerializedName("rightIconTitle")
    public String rightIconTitle;
    @SerializedName("rightIconUrl")
    public String rightIconUrl;
    @SerializedName("rightTitle")
    public String rightTitle;
    @SerializedName("rightUrl")
    public String rightUrl;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;

    public String toString() {
        return "UrlPageParams{title='" + this.title + "', url='" + yfd.a(this.url) + "', rightTitle='" + this.rightTitle + "', rightUrl='" + yfd.a(this.rightUrl) + "', rightIcon='" + yfd.a(this.rightIcon) + "', rightIconTitle='" + this.rightIconTitle + "', rightIconUrl='" + yfd.a(this.rightIconUrl) + "', pageType='" + this.pageType + "'}";
    }
}
