package d.a.r0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes9.dex */
public class g2 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId E0;
    public transient /* synthetic */ FieldHolder $fh;
    public String C0;
    public String D0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2131416297, "Ld/a/r0/r/q/g2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2131416297, "Ld/a/r0/r/q/g2;");
                return;
            }
        }
        E0 = BdUniqueId.gen();
    }

    public g2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.C0 : (String) invokeV.objValue;
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.D0 : (String) invokeV.objValue;
    }

    public void E0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.C0 = jSONObject.optString("news_link");
            this.D0 = jSONObject.optString("summary");
            jSONObject.optInt("position", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void F0(TopNews topNews) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, topNews) == null) || topNews == null) {
            return;
        }
        this.C0 = topNews.news_link;
        this.D0 = topNews.summary;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? E0 : (BdUniqueId) invokeV.objValue;
    }
}
