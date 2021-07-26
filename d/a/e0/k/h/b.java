package d.a.e0.k.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.a.e0.n.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42618a;

    /* renamed from: b  reason: collision with root package name */
    public long f42619b;

    /* renamed from: c  reason: collision with root package name */
    public String f42620c;

    /* renamed from: d  reason: collision with root package name */
    public String f42621d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f42622e;

    public b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42618a = str;
        this.f42619b = System.currentTimeMillis();
        this.f42620c = f.d();
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f42618a)) {
                d.a.e0.n.d.b("statistics action can not null");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("a", this.f42618a);
                jSONObject.put("t", this.f42619b);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f42620c);
                if (this.f42622e != null) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f42622e);
                } else if (!TextUtils.isEmpty(this.f42621d)) {
                    try {
                        jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f42621d));
                    } catch (JSONException unused) {
                        jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f42621d);
                    }
                }
            } catch (JSONException e2) {
                if (d.a.e0.n.d.f42681d) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            this.f42622e = jSONObject;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f42621d = str;
            return this;
        }
        return (b) invokeL.objValue;
    }
}
