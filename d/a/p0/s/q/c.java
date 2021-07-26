package d.a.p0.s.q;

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
    public boolean f53255a;

    /* renamed from: b  reason: collision with root package name */
    public String f53256b;

    /* renamed from: c  reason: collision with root package name */
    public String f53257c;

    /* renamed from: d  reason: collision with root package name */
    public String f53258d;

    /* renamed from: e  reason: collision with root package name */
    public float f53259e;

    /* renamed from: f  reason: collision with root package name */
    public String f53260f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public b f53261g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public a f53262h;

    /* renamed from: i  reason: collision with root package name */
    public String f53263i;
    public String j;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f53264a;

        /* renamed from: b  reason: collision with root package name */
        public String f53265b;

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
                aVar.f53264a = jSONObject.optString("desc", DisplayInfoView.AUTH_TEXT);
                String optString = jSONObject.optString("url");
                aVar.f53265b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f53265b = jSONObject.optString("cmd");
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
        public String f53266a;

        /* renamed from: b  reason: collision with root package name */
        public String f53267b;

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
                bVar.f53266a = jSONObject.optString("desc", DisplayInfoView.PRI_TEXT);
                String optString = jSONObject.optString("url");
                bVar.f53267b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.f53267b = jSONObject.optString("cmd");
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
        this.f53259e = -1.0f;
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
            return (TextUtils.isEmpty(cVar.f53260f) && TextUtils.isEmpty(cVar.f53258d) && ((bVar = cVar.f53261g) == null || TextUtils.isEmpty(bVar.f53266a)) && ((aVar = cVar.f53262h) == null || TextUtils.isEmpty(aVar.f53264a))) ? false : true;
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
            cVar.f53255a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            cVar.f53256b = jSONObject.optString("app_icon");
            cVar.f53257c = jSONObject.optString("app_name");
            cVar.f53258d = jSONObject.optString("developer_name");
            cVar.f53260f = jSONObject.optString("version");
            cVar.f53261g = b.a(jSONObject.optJSONObject("privacy"));
            cVar.f53262h = a.a(jSONObject.optJSONObject("permission"));
            cVar.f53263i = jSONObject.optString("apk_size");
            cVar.j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    cVar.f53259e = parseFloat;
                } else {
                    cVar.f53259e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                cVar.f53259e = -1.0f;
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
            if (cVar != null && cVar.f53255a) {
                return (TextUtils.isEmpty(cVar.f53260f) || TextUtils.isEmpty(cVar.f53258d) || (bVar = cVar.f53261g) == null || TextUtils.isEmpty(bVar.f53267b) || (aVar = cVar.f53262h) == null || TextUtils.isEmpty(aVar.f53265b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
