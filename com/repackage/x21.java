package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class x21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public c b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public a i;
    public b j;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public double c;

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

        public static a b(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                a aVar = new a();
                JSONObject c = yx0.c(str);
                aVar.a = c.optString("defer_charge_url");
                aVar.b = c.optInt("defer_type", 3);
                aVar.c = c.optDouble("defer_time", 0.0d);
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.b;
                return (i == 2 || i == 3) && this.c > 0.0d && !TextUtils.isEmpty(this.a);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;

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

        public static b a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                b bVar = new b();
                JSONObject c = yx0.c(str);
                bVar.e = c.optString("key");
                c.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME);
                bVar.a = c.optString("download_url");
                c.optString(BreakpointSQLiteKey.CONTENT_LENGTH);
                bVar.b = c.optString("close_virtual_progress");
                bVar.c = c.optString("apk_label");
                bVar.d = c.optString("apk_icon");
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public c() {
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

        public static c a(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                c cVar = new c();
                JSONObject c = yx0.c(str);
                cVar.a = c.optString("receive_title_script");
                c.optString("start_load_script");
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public x21() {
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

    public static x21 b(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            Bundle extras = intent.getExtras();
            x21 x21Var = null;
            if (extras == null) {
                return null;
            }
            Serializable serializable = extras.getSerializable("map");
            if (serializable instanceof HashMap) {
                HashMap hashMap = (HashMap) serializable;
                if (hashMap != null && !hashMap.isEmpty()) {
                    x21Var = new x21();
                    x21Var.c = (String) zx0.b(hashMap, LegoListActivityConfig.AD_ID);
                    x21Var.a = (String) zx0.b(hashMap, "url");
                    x21Var.f = (String) zx0.b(hashMap, "ext_info");
                    x21Var.g = (String) zx0.b(hashMap, TiebaStatic.Params.REFER);
                    x21Var.d = (String) zx0.b(hashMap, "charge_url");
                    x21Var.e = (String) zx0.b(hashMap, "ad_invoke_flag");
                    String str = (String) zx0.b(hashMap, "lp_real_url");
                    String str2 = (String) zx0.b(hashMap, "log_switch");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "1";
                    }
                    x21Var.h = str2;
                    String str3 = (String) zx0.b(hashMap, "sdk_script");
                    if (!TextUtils.isEmpty(str3)) {
                        x21Var.b = c.a(str3);
                    }
                    String str4 = (String) zx0.b(hashMap, "defer_charge");
                    if (!TextUtils.isEmpty(str4)) {
                        x21Var.i = a.b(str4);
                    }
                    String str5 = (String) zx0.b(hashMap, "download");
                    if (!TextUtils.isEmpty(str5)) {
                        x21Var.j = b.a(str5);
                    }
                    x21Var.c();
                }
                return x21Var;
            }
            return null;
        }
        return (x21) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.equals(this.e, "0") : invokeV.booleanValue;
    }

    public final void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.g)) {
            return;
        }
        if (this.g.contains("__CHARGE_URL__") && !TextUtils.isEmpty(this.d)) {
            this.g = this.g.replace("__CHARGE_URL__", this.d);
        }
        if (!this.g.contains("__DEFER_CHARGE_URL__") || (aVar = this.i) == null || TextUtils.isEmpty(aVar.a)) {
            return;
        }
        this.g = this.g.replace("__DEFER_CHARGE_URL__", this.i.a);
    }
}
