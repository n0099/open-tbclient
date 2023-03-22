package tv.athena.revenue.payui.webview;

import androidx.annotation.Keep;
import com.baidu.tieba.j0b;
import com.google.gson.annotations.SerializedName;
@Keep
/* loaded from: classes9.dex */
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
        return "UrlPageParams{title='" + this.title + "', url='" + j0b.a(this.url) + "', rightTitle='" + this.rightTitle + "', rightUrl='" + j0b.a(this.rightUrl) + "', rightIcon='" + j0b.a(this.rightIcon) + "', rightIconTitle='" + this.rightIconTitle + "', rightIconUrl='" + j0b.a(this.rightIconUrl) + "', pageType='" + this.pageType + "'}";
    }
}
