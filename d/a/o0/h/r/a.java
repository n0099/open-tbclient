package d.a.o0.h.r;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50789a;

    /* renamed from: b  reason: collision with root package name */
    public String f50790b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50791c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50792d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50793e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50794f;

    /* renamed from: d.a.o0.h.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1126a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f50795a;

        /* renamed from: b  reason: collision with root package name */
        public String f50796b;

        public C1126a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50795a = false;
            this.f50795a = z;
            this.f50796b = str;
        }

        public static C1126a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C1126a(false, "未启用真机调试") : (C1126a) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50796b : (String) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50795a : invokeV.booleanValue;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50789a = null;
        this.f50790b = null;
        this.f50791c = false;
        this.f50792d = false;
        this.f50793e = false;
        this.f50794f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f50789a = optJSONObject.optString("hostname", null);
            this.f50790b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f50791c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f50794f = z;
        if (z) {
            this.f50789a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f50789a);
            this.f50790b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f50790b);
            this.f50791c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f50791c);
            this.f50792d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f50792d);
        }
        String str = this.f50789a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f50793e = true;
    }

    public static C1126a f(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? aVar == null ? C1126a.c() : aVar.e() : (C1126a) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f50789a);
            if (this.f50790b != null) {
                str = ":" + this.f50790b;
            } else {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50792d : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.o0.a.v.a.f(e.V()) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50791c : invokeV.booleanValue;
    }

    public C1126a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f50794f && c()) {
                return new C1126a(false, "线上包禁用真机调试");
            }
            boolean z = this.f50793e;
            return new C1126a(z, !z ? "未启用真机调试" : this.f50794f ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return (C1126a) invokeV.objValue;
    }
}
