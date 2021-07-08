package d.a.o0.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DecryptCode.DataRes;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f51349a;

    /* renamed from: b  reason: collision with root package name */
    public String f51350b;

    /* renamed from: c  reason: collision with root package name */
    public String f51351c;

    /* renamed from: d  reason: collision with root package name */
    public String f51352d;

    /* renamed from: e  reason: collision with root package name */
    public String f51353e;

    /* renamed from: f  reason: collision with root package name */
    public String f51354f;

    /* renamed from: g  reason: collision with root package name */
    public String f51355g;

    /* renamed from: h  reason: collision with root package name */
    public String f51356h;

    /* renamed from: i  reason: collision with root package name */
    public int f51357i;
    public String j;
    public Integer k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-799837783, "Ld/a/o0/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-799837783, "Ld/a/o0/a/i;");
                return;
            }
        }
        l = TbadkCoreApplication.getInst().getString(R.string.tb_token);
        m = TbadkCoreApplication.getInst().getString(R.string.tb_ai_apps_tips);
        n = TbadkCoreApplication.getInst().getString(R.string.cancel);
        o = TbadkCoreApplication.getInst().getString(R.string.check_immediately);
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51349a = "";
        this.f51350b = "";
        this.f51351c = "";
        this.f51352d = "";
        this.f51353e = "";
        this.f51354f = "";
        this.f51355g = "";
        this.f51356h = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51354f : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51353e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51350b : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51351c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51349a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51352d : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f51357i : invokeV.intValue;
    }

    public void h(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            int intValue = dataRes.type.intValue();
            this.f51357i = intValue;
            if (intValue != 0 && intValue != 1) {
                if (intValue == 2) {
                    this.f51349a = dataRes.title;
                    this.f51352d = dataRes.url;
                    return;
                } else if (intValue != 4 && intValue == 3) {
                    this.f51352d = dataRes.url;
                    this.f51349a = dataRes.title;
                    this.f51350b = dataRes.img;
                    this.f51351c = dataRes.tips;
                    this.f51353e = dataRes.btn_sure;
                    this.f51354f = dataRes.btn_cancel;
                    return;
                } else {
                    return;
                }
            }
            this.f51349a = StringUtils.isNull(dataRes.title) ? l : dataRes.title;
            this.f51350b = dataRes.img;
            this.f51351c = StringUtils.isNull(dataRes.tips) ? m : dataRes.tips;
            if (!StringUtils.isNull(dataRes.url)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.url);
                    this.f51355g = jSONObject.optString("appid");
                    this.f51356h = jSONObject.optString("appname");
                    String optString = jSONObject.optString("url");
                    Integer valueOf = Integer.valueOf(jSONObject.optInt("is_game"));
                    this.k = valueOf;
                    this.f51352d = d.a.p0.u.a.a(this.f51355g, optString, "9104", valueOf);
                    this.j = jSONObject.optString("swan_app_id");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f51353e = StringUtils.isNull(dataRes.btn_sure) ? o : dataRes.btn_sure;
            this.f51354f = StringUtils.isNull(dataRes.btn_cancel) ? n : dataRes.btn_cancel;
        }
    }
}
