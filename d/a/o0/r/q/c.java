package d.a.o0.r.q;

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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f52591a;

    /* renamed from: b  reason: collision with root package name */
    public String f52592b;

    /* renamed from: c  reason: collision with root package name */
    public String f52593c;

    /* renamed from: d  reason: collision with root package name */
    public String f52594d;

    /* renamed from: e  reason: collision with root package name */
    public float f52595e;

    /* renamed from: f  reason: collision with root package name */
    public String f52596f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f52597g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f52598h;

    /* renamed from: i  reason: collision with root package name */
    public String f52599i;
    public String j;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f52600a;

        /* renamed from: b  reason: collision with root package name */
        public String f52601b;

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
                aVar.f52600a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
                String optString = jSONObject.optString("url");
                aVar.f52601b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f52601b = jSONObject.optString("cmd");
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f52602a;

        /* renamed from: b  reason: collision with root package name */
        public String f52603b;

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
                bVar.f52602a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
                String optString = jSONObject.optString("url");
                bVar.f52603b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f52603b = jSONObject.optString("cmd");
                }
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
        this.f52595e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f52596f) && TextUtils.isEmpty(cVar.f52594d) && ((bVar = cVar.f52597g) == null || TextUtils.isEmpty(bVar.f52602a)) && ((aVar = cVar.f52598h) == null || TextUtils.isEmpty(aVar.f52600a))) ? false : true;
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
            cVar.f52591a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cVar.f52592b = jSONObject.optString("app_icon");
            cVar.f52593c = jSONObject.optString("app_name");
            cVar.f52594d = jSONObject.optString("developer_name");
            cVar.f52596f = jSONObject.optString("version");
            cVar.f52597g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f52598h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f52599i = jSONObject.optString("apk_size");
            cVar.j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f52595e = parseFloat;
                } else {
                    cVar.f52595e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f52595e = -1.0f;
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
            if (cVar != null && cVar.f52591a) {
                return (TextUtils.isEmpty(cVar.f52596f) || TextUtils.isEmpty(cVar.f52594d) || (bVar = cVar.f52597g) == null || TextUtils.isEmpty(bVar.f52603b) || (aVar = cVar.f52598h) == null || TextUtils.isEmpty(aVar.f52601b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
