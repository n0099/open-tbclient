package tv.athena.revenue.payui.webview;

import androidx.annotation.Keep;
import com.baidu.tieba.qfc;
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
        return "UrlPageParams{title='" + this.title + "', url='" + qfc.a(this.url) + "', rightTitle='" + this.rightTitle + "', rightUrl='" + qfc.a(this.rightUrl) + "', rightIcon='" + qfc.a(this.rightIcon) + "', rightIconTitle='" + this.rightIconTitle + "', rightIconUrl='" + qfc.a(this.rightIconUrl) + "', pageType='" + this.pageType + "'}";
    }
}
