package tv.athena.revenue.payui.webview;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
@Keep
/* loaded from: classes8.dex */
public class UrlPageParams {
    @SerializedName("pageType")
    public int pageType;
    @SerializedName("rightTitle")
    public String rightTitle;
    @SerializedName("rightUrl")
    public String rightUrl;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;

    public String toString() {
        return "UrlPageParams{title='" + this.title + "', url='" + this.url + "', rightTitle='" + this.rightTitle + "', rightUrl='" + this.rightUrl + "', pageType='" + this.pageType + "'}";
    }
}
