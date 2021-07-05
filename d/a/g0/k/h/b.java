package d.a.g0.k.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import d.a.g0.n.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45433a;

    /* renamed from: b  reason: collision with root package name */
    public long f45434b;

    /* renamed from: c  reason: collision with root package name */
    public String f45435c;

    /* renamed from: d  reason: collision with root package name */
    public String f45436d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f45437e;

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
        this.f45433a = str;
        this.f45434b = System.currentTimeMillis();
        this.f45435c = f.d();
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f45433a)) {
                d.a.g0.n.d.b("statistics action can not null");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("a", this.f45433a);
                jSONObject.put("t", this.f45434b);
                jSONObject.put(Config.EXCEPTION_CRASH_TYPE, this.f45435c);
                if (this.f45437e != null) {
                    jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f45437e);
                } else if (!TextUtils.isEmpty(this.f45436d)) {
                    try {
                        jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, new JSONObject(this.f45436d));
                    } catch (JSONException unused) {
                        jSONObject.put(AdvanceSetting.CLEAR_NOTIFICATION, this.f45436d);
                    }
                }
            } catch (JSONException e2) {
                if (d.a.g0.n.d.f45496d) {
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
            this.f45437e = jSONObject;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f45436d = str;
            return this;
        }
        return (b) invokeL.objValue;
    }
}
