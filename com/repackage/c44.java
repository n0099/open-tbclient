package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class c44 {
    public static /* synthetic */ Interceptable $ic;
    public static final String b = null;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755847186, "Lcom/repackage/c44;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755847186, "Lcom/repackage/c44;");
        }
    }

    public c44() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) ? String.format("%s_%s:%s", str, str2, str3) : (String) invokeLLL.objValue;
    }

    public void b(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String g = g(i);
            String N = u03.L() == null ? null : u03.L().N();
            w73 w73Var = new w73();
            w73Var.b = "click";
            w73Var.g = g;
            w73Var.e = str;
            if (str2 != null) {
                w73Var.a("target_appkey", str2);
            }
            w73Var.a("current_appkey", N);
            if (!TextUtils.isEmpty(str3)) {
                w73Var.a("location", str3);
            }
            n73.g(w73Var);
        }
    }

    public void c(int i, i44 i44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, i44Var) == null) {
            String g = g(i);
            JSONArray f = f(i44Var);
            w73 w73Var = new w73();
            w73Var.b = "show";
            w73Var.g = g;
            if (f != null) {
                w73Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            n73.g(w73Var);
        }
    }

    public void d(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i, str, str2) == null) {
            String g = g(i);
            String a = a(g, str, str2);
            if (this.a.contains(a)) {
                return;
            }
            String N = u03.L() == null ? null : u03.L().N();
            w73 w73Var = new w73();
            w73Var.b = "click";
            w73Var.g = g;
            w73Var.e = str;
            if (str2 != null) {
                w73Var.a("target_appkey", str2);
            }
            w73Var.a("current_appkey", N);
            n73.g(w73Var);
            this.a.add(a);
        }
    }

    public void e(int i, i44 i44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, i44Var) == null) {
            String g = g(i);
            JSONArray f = f(i44Var);
            w73 w73Var = new w73();
            w73Var.b = "show";
            w73Var.g = g;
            if (f != null) {
                w73Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            n73.g(w73Var);
            this.a.clear();
        }
    }

    public final JSONArray f(i44 i44Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, i44Var)) == null) {
            if (i44Var == null || i44Var.b == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (RecommendItemModel recommendItemModel : i44Var.b) {
                jSONArray.put(recommendItemModel.appKey);
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return "popview";
                }
                return "list";
            }
            return "carousel";
        }
        return (String) invokeI.objValue;
    }
}
