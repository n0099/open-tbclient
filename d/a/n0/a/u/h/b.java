package d.a.n0.a.u.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f47864b;

    /* renamed from: c  reason: collision with root package name */
    public String f47865c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f47866d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47867e;

    public b() {
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
        this.f47867e = false;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 101) {
                    if (i2 != 201) {
                        if (i2 != 202) {
                            if (i2 != 301) {
                                if (i2 != 302) {
                                    switch (i2) {
                                        case 401:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_sec_check_fail);
                                        case 402:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_acl_check_fail);
                                        case 403:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_allow_close);
                                        default:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
                                    }
                                }
                                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_notfound);
                            }
                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_module_notfound);
                        }
                        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_params_parse_fail);
                    }
                    return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
                }
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_not_support);
            }
            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_ok);
        }
        return (String) invokeI.objValue;
    }

    @Override // d.a.n0.a.u.h.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(this.f47864b));
                if (TextUtils.isEmpty(this.f47865c)) {
                    this.f47865c = b(this.f47864b);
                }
                jSONObject.put("message", this.f47865c);
                if (this.f47866d != null) {
                    jSONObject.put("data", this.f47867e ? Uri.encode(this.f47866d.toString(), StandardCharsets.UTF_8.name()) : this.f47866d);
                }
            } catch (JSONException e2) {
                if (k.f45831a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public void c(@NonNull String str, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (this.f47866d == null) {
                this.f47866d = new JSONObject();
            }
            try {
                this.f47866d.put(str, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean d(@NonNull String str, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) {
            if (this.f47866d == null) {
                this.f47866d = new JSONObject();
            }
            try {
                this.f47866d.put(str, obj);
                return true;
            } catch (JSONException e2) {
                if (k.f45831a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.n0.a.u.h.a
    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f47864b == 0 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a() : (String) invokeV.objValue;
    }

    public b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47867e = false;
        this.f47864b = i2;
    }

    public b(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47867e = false;
        this.f47864b = i2;
        this.f47865c = str;
    }

    public b(int i2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f47867e = false;
        this.f47864b = i2;
        this.f47866d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.f47867e = false;
        this.f47864b = i2;
        this.f47866d = jSONObject;
        this.f47867e = z;
    }

    public b(int i2, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f47867e = false;
        this.f47864b = i2;
        this.f47865c = str;
        this.f47866d = jSONObject;
    }
}
