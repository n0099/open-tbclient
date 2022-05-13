package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f03;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class to2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public gg3 b;

    /* loaded from: classes7.dex */
    public class a implements f03.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ to2 b;

        public a(to2 to2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = to2Var;
            this.a = str;
        }

        @Override // com.repackage.f03.a
        public void a(f03 f03Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f03Var) == null) {
                to2.d(f03Var.c(), this.b.a, this.a);
                this.b.b.j();
            }
        }
    }

    public to2(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
    }

    public static void d(int i, Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, null, i, activity, str) == null) {
            if (i == 6) {
                g(activity, str);
            } else if (i == 7) {
                f(activity, str);
            } else if (i != 8) {
            } else {
                h(activity, str);
            }
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("content://") || str.startsWith("file://");
        }
        return invokeL.booleanValue;
    }

    public static void f(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, activity, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("urls", new JSONArray(new String[]{str}));
                jSONObject.put("type", "0");
                jSONObject.put("index", "0");
            } catch (JSONException e) {
                if (eh1.a) {
                    e.printStackTrace();
                }
            }
            bk2.C().b(activity, jSONObject);
        }
    }

    public static void g(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, activity, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("imageUrl", str);
            bk2.C().f(activity, new JSONObject(hashMap));
        }
    }

    public static void h(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, activity, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("imageUrl", str);
            bk2.C().a(activity, new JSONObject(hashMap));
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || e(str)) {
            return;
        }
        this.b.e(6, R.string.obfuscated_res_0x7f0f123a);
    }

    public void i(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str) == null) {
            gg3 gg3Var = this.b;
            if (gg3Var != null && gg3Var.n()) {
                this.b.j();
            }
            gg3 gg3Var2 = new gg3(view2);
            this.b = gg3Var2;
            gg3Var2.r(new a(this, str));
            c(str);
            this.b.t();
        }
    }
}
