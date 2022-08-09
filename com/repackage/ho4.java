package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ho4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public String c;
    public String d;
    public float e;
    public String f;
    @Nullable
    public b g;
    @Nullable
    public a h;
    public String i;
    public String j;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                aVar.a = jSONObject.optString("desc", "权限");
                String optString = jSONObject.optString("url");
                aVar.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.b = jSONObject.optString("cmd");
                }
                aVar.c = jSONObject.optString("cmd");
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                bVar.a = jSONObject.optString("desc", "隐私");
                String optString = jSONObject.optString("url");
                bVar.b = optString;
                if (TextUtils.isEmpty(optString)) {
                    bVar.b = jSONObject.optString("cmd");
                }
                bVar.c = jSONObject.optString("cmd");
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    public ho4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1.0f;
    }

    public static boolean a(ho4 ho4Var) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ho4Var)) == null) {
            if (ho4Var == null) {
                return false;
            }
            return (TextUtils.isEmpty(ho4Var.f) && TextUtils.isEmpty(ho4Var.d) && ((bVar = ho4Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = ho4Var.h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static ho4 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ho4 ho4Var = new ho4();
            ho4Var.a = TextUtils.equals(jSONObject.optString("strict_mode", "1"), "1");
            ho4Var.b = jSONObject.optString("app_icon");
            ho4Var.c = jSONObject.optString("app_name");
            ho4Var.d = jSONObject.optString("developer_name");
            ho4Var.f = jSONObject.optString("version");
            ho4Var.g = b.a(jSONObject.optJSONObject("privacy"));
            ho4Var.h = a.a(jSONObject.optJSONObject(ShareLoginStat.GetShareListStat.KEY_PERMISSION));
            ho4Var.i = jSONObject.optString("apk_size");
            ho4Var.j = jSONObject.optString("apk_url");
            try {
                float parseFloat = Float.parseFloat(jSONObject.optString("score"));
                if (parseFloat <= 5.0f && parseFloat >= 0.0f) {
                    ho4Var.e = parseFloat;
                } else {
                    ho4Var.e = -1.0f;
                }
            } catch (NumberFormatException unused) {
                ho4Var.e = -1.0f;
            }
            return ho4Var;
        }
        return (ho4) invokeL.objValue;
    }

    public static boolean c(ho4 ho4Var) {
        InterceptResult invokeL;
        b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ho4Var)) == null) {
            if (ho4Var != null && ho4Var.a) {
                return (TextUtils.isEmpty(ho4Var.f) || TextUtils.isEmpty(ho4Var.d) || (bVar = ho4Var.g) == null || TextUtils.isEmpty(bVar.b) || (aVar = ho4Var.h) == null || TextUtils.isEmpty(aVar.b)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
