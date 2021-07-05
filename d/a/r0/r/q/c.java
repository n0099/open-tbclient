package d.a.r0.r.q;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.mobads.container.widget.DisplayInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f55878a;

    /* renamed from: b  reason: collision with root package name */
    public String f55879b;

    /* renamed from: c  reason: collision with root package name */
    public String f55880c;

    /* renamed from: d  reason: collision with root package name */
    public float f55881d;

    /* renamed from: e  reason: collision with root package name */
    public String f55882e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public b f55883f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public a f55884g;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f55885a;

        /* renamed from: b  reason: collision with root package name */
        public String f55886b;

        public a() {
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

        @Nullable
        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                a aVar = new a();
                aVar.f55885a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
                aVar.f55886b = jSONObject.optString("url");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f55887a;

        /* renamed from: b  reason: collision with root package name */
        public String f55888b;

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
                }
            }
        }

        @Nullable
        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                bVar.f55887a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
                bVar.f55888b = jSONObject.optString("url");
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    public c() {
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
        this.f55881d = -1.0f;
    }

    public static boolean a(c cVar) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            return (TextUtils.isEmpty(cVar.f55882e) && TextUtils.isEmpty(cVar.f55880c) && ((bVar = cVar.f55883f) == null || TextUtils.isEmpty(bVar.f55887a)) && ((aVar = cVar.f55884g) == null || TextUtils.isEmpty(aVar.f55885a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static c b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.f55878a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            jSONObject.optString("app_icon");
            cVar.f55879b = jSONObject.optString("app_name");
            cVar.f55880c = jSONObject.optString("developer_name");
            cVar.f55882e = jSONObject.optString("version");
            cVar.f55883f = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f55884g = a.a(jSONObject.optJSONObject("permission"));
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f55881d = parseFloat;
                } else {
                    cVar.f55881d = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f55881d = -1.0f;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static boolean c(c cVar) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cVar)) == null) {
            if (cVar != null && cVar.f55878a) {
                return (TextUtils.isEmpty(cVar.f55882e) || TextUtils.isEmpty(cVar.f55880c) || (bVar = cVar.f55883f) == null || TextUtils.isEmpty(bVar.f55888b) || (aVar = cVar.f55884g) == null || TextUtils.isEmpty(aVar.f55886b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
