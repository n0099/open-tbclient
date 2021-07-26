package d.a.i0.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f42917a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.i0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0602b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f42918a;

        public C0602b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42918a = new JSONObject();
            F("material_type", str);
            F("material_url", str2);
        }

        public C0602b A(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                try {
                    this.f42918a.put("skip_btn_width", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b B(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                try {
                    this.f42918a.put("skipTime", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b C(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                try {
                    this.f42918a.put("small_logo_height", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b D(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                try {
                    this.f42918a.put("small_logo_width", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b E(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jSONObject)) == null) {
                try {
                    this.f42918a.put("style", jSONObject);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public final void F(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
                try {
                    this.f42918a.put(str, str2);
                } catch (Throwable th) {
                    d.a.i0.a.k.b.i().g(th);
                }
            }
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new b(this.f42918a, null) : (b) invokeV.objValue;
        }

        public C0602b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                try {
                    this.f42918a.put("ad_click_opt", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                try {
                    this.f42918a.put("ad_label", str);
                    if (TextUtils.isEmpty(str)) {
                        this.f42918a.put("hide_ad_logo", false);
                    }
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public C0602b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
                try {
                    this.f42918a.put("ad_label_height", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
                try {
                    this.f42918a.put("ad_label_width", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                try {
                    this.f42918a.put("publisher", str);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public C0602b g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                try {
                    this.f42918a.put("app_version", str);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public C0602b h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
                try {
                    this.f42918a.put("bottom_logo_height", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
                try {
                    this.f42918a.put("close_type", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b j(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
                try {
                    this.f42918a.put("displayMantle", z);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeZ.objValue;
        }

        public C0602b k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
                try {
                    this.f42918a.put("bitmapDisplayMode", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
                try {
                    this.f42918a.put("full_screen", z);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeZ.objValue;
        }

        public C0602b m(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
                try {
                    this.f42918a.put("host_big_logo_res_id", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
                try {
                    this.f42918a.put("host_small_logo_res_id", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                try {
                    this.f42918a.put("show_host_small_logo", z);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeZ.objValue;
        }

        public C0602b p(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, jSONObject)) == null) {
                try {
                    this.f42918a.put("inner_style", jSONObject);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public C0602b q(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                F("lottie_url", str);
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public C0602b r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
                try {
                    this.f42918a.put("mantleActionText", str);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public C0602b s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                try {
                    this.f42918a.put("mantleBottomMargin", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
                F("prod", str);
                return this;
            }
            return (C0602b) invokeL.objValue;
        }

        public C0602b u(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
                try {
                    this.f42918a.put("hide_bd_logo", z);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeZ.objValue;
        }

        public C0602b v(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
                try {
                    this.f42918a.put("Display_Down_Info", z);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeZ.objValue;
        }

        public C0602b w(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
                try {
                    this.f42918a.put("lottie_show", z);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeZ.objValue;
        }

        public C0602b x(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
                try {
                    this.f42918a.put("show_wifi_view", z);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeZ.objValue;
        }

        public C0602b y(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
                try {
                    this.f42918a.put("skip_btn_height", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }

        public C0602b z(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
                try {
                    this.f42918a.put("skip_btn_type", i2);
                } catch (JSONException e2) {
                    d.a.i0.a.k.b.i().g(e2);
                }
                return this;
            }
            return (C0602b) invokeI.objValue;
        }
    }

    public /* synthetic */ b(JSONObject jSONObject, a aVar) {
        this(jSONObject);
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42917a : (JSONObject) invokeV.objValue;
    }

    public b(JSONObject jSONObject) {
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
        this.f42917a = jSONObject;
    }
}
