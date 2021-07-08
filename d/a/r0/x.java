package d.a.r0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f67467a;

    /* renamed from: b  reason: collision with root package name */
    public int f67468b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f67469c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67470d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f67471e;

    /* renamed from: f  reason: collision with root package name */
    public String f67472f;

    /* renamed from: g  reason: collision with root package name */
    public int f67473g;

    /* renamed from: h  reason: collision with root package name */
    public int f67474h;

    /* renamed from: i  reason: collision with root package name */
    public List<k> f67475i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458395697, "Ld/a/r0/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-458395697, "Ld/a/r0/x;");
                return;
            }
        }
        j = AppConfig.isDebug();
    }

    public x(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67475i = new ArrayList();
        this.f67469c = jSONObject;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67471e : (JSONObject) invokeV.objValue;
    }

    public List<k> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67475i : (List) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67473g : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67474h : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67472f : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67467a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67468b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                if (this.f67469c != null && this.f67469c.length() != 0) {
                    JSONObject jSONObject = this.f67469c;
                    this.f67470d = jSONObject.optJSONObject("set");
                    this.f67467a = jSONObject.optInt("threshold", 10000);
                    this.f67468b = jSONObject.optInt("timeup", 604800000);
                    this.f67472f = jSONObject.optString(ShaderParams.VALUE_TYPE_STEP);
                    jSONObject.optString(StickerDataChangeType.REPLACE);
                    this.f67471e = jSONObject.optJSONObject("del");
                    this.f67473g = jSONObject.optInt("all_size", 614400);
                    this.f67474h = jSONObject.optInt("single_size", 153600);
                    jSONObject.optInt("real_size", 614400);
                    jSONObject.optInt("non_real_size", 614400);
                    int i2 = 1;
                    if (this.f67470d != null) {
                        Iterator<String> keys = this.f67470d.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && (optJSONObject = this.f67470d.optJSONObject(next)) != null && optJSONObject.length() != 0) {
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                                String optString = optJSONObject.optString("version");
                                if (optJSONObject2 != null && !TextUtils.isEmpty(optString)) {
                                    Iterator<String> it = keys;
                                    k kVar = new k(next, optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH, i2) != 0, optJSONObject2.optInt(Constant.IS_REAL, 0) == 1, optJSONObject2.optInt("timeout", 60), optJSONObject2.optInt("type", 0), optJSONObject2.optInt("isAbtest", 0) == 1);
                                    if (n.a(next)) {
                                        kVar.m(optJSONObject2.optInt("isSend", 1) == 1);
                                    }
                                    if (optJSONObject2.has("rate")) {
                                        kVar.r(optJSONObject2.getInt("rate"));
                                    }
                                    if (optJSONObject2.has("c")) {
                                        kVar.i(optJSONObject2.getString("c"));
                                    }
                                    if (optJSONObject2.has("limitUnit")) {
                                        kVar.o(optJSONObject2.getInt("limitUnit"));
                                    }
                                    if (optJSONObject2.has("limitCnt")) {
                                        kVar.n(optJSONObject2.getInt("limitCnt"));
                                    }
                                    if (optJSONObject2.has(Constant.ID_TYPE)) {
                                        kVar.k(optJSONObject2.getInt(Constant.ID_TYPE));
                                    }
                                    kVar.q(optJSONObject2.optInt("ch", 0) == 1);
                                    if (optJSONObject2.has("dfc")) {
                                        kVar.l(optJSONObject2.getInt("dfc") == 1);
                                    }
                                    if (optJSONObject2.has("reallog")) {
                                        kVar.s(optJSONObject2.getInt("reallog") == 1);
                                    }
                                    if (optJSONObject2.has("gflow")) {
                                        kVar.j(optJSONObject2.getInt("gflow"));
                                    }
                                    if (optJSONObject2.has("uploadType")) {
                                        kVar.t(optJSONObject2.optInt("uploadType", -1));
                                    }
                                    int optInt = optJSONObject2.optInt("lcache", 2);
                                    if (optInt == 1 || optInt == 0) {
                                        kVar.p(optInt);
                                    }
                                    kVar.u(optString);
                                    this.f67475i.add(kVar);
                                    keys = it;
                                    i2 = 1;
                                }
                            }
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void i(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f67475i = list;
        }
    }
}
