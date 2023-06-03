package tv.athena.revenue.payui.webview;

import androidx.annotation.Keep;
import com.baidu.tieba.lvb;
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
        return "UrlPageParams{title='" + this.title + "', url='" + lvb.a(this.url) + "', rightTitle='" + this.rightTitle + "', rightUrl='" + lvb.a(this.rightUrl) + "', rightIcon='" + lvb.a(this.rightIcon) + "', rightIconTitle='" + this.rightIconTitle + "', rightIconUrl='" + lvb.a(this.rightIconUrl) + "', pageType='" + this.pageType + "'}";
    }
}
