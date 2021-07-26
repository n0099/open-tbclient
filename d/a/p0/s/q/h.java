package d.a.p0.s.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.optLong("activity_id");
            jSONObject.optString("main_title");
            jSONObject.optString("sub_title");
            jSONObject.optInt("back_pic_width");
            jSONObject.optInt("back_pic_height");
            jSONObject.optString("back_pic");
            jSONObject.optString("subpage_link");
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b(ActivityInfo activityInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activityInfo) == null) || activityInfo == null) {
            return;
        }
        try {
            activityInfo.activity_id.longValue();
            String str = activityInfo.main_title;
            String str2 = activityInfo.sub_title;
            activityInfo.back_pic_width.intValue();
            activityInfo.back_pic_height.intValue();
            String str3 = activityInfo.back_pic;
            String str4 = activityInfo.subpage_link;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
