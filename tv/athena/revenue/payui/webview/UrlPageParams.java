package tv.athena.revenue.payui.webview;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
@Keep
/* loaded from: classes10.dex */
public class UrlPageParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    public UrlPageParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "UrlPageParams{title='" + this.title + "', url='" + this.url + "', rightTitle='" + this.rightTitle + "', rightUrl='" + this.rightUrl + "', pageType='" + this.pageType + "'}";
        }
        return (String) invokeV.objValue;
    }
}
