package d.a.r0.r.q;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<UserData> f55958a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<UserData> f55959b;

    /* renamed from: c  reason: collision with root package name */
    public a1 f55960c;

    /* renamed from: d  reason: collision with root package name */
    public int f55961d;

    /* renamed from: e  reason: collision with root package name */
    public int f55962e;

    public g1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55958a = new ArrayList<>();
        this.f55959b = new ArrayList<>();
        this.f55960c = new a1();
        this.f55961d = 0;
        this.f55962e = 0;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55962e : invokeV.intValue;
    }

    public ArrayList<UserData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55959b : (ArrayList) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55961d : invokeV.intValue;
    }

    public a1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55960c : (a1) invokeV.objValue;
    }

    public ArrayList<UserData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f55958a : (ArrayList) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                g(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    UserData userData = new UserData();
                    userData.parserJson(optJSONArray.getJSONObject(i2));
                    userData.mAttentionType = 2;
                    this.f55958a.add(userData);
                }
            }
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    UserData userData2 = new UserData();
                    userData2.parserJson(optJSONArray2.getJSONObject(i3));
                    userData2.mAttentionType = 1;
                    this.f55959b.add(userData2);
                }
            }
            this.f55960c.i(jSONObject.optJSONObject("page"));
            this.f55961d = jSONObject.optInt("tafriendnum", 0);
            this.f55962e = jSONObject.optInt("commonfriendnum", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void h(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, a1Var) == null) {
            this.f55960c = a1Var;
        }
    }
}
