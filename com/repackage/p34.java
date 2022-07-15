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
/* loaded from: classes6.dex */
public class p34 {
    public static /* synthetic */ Interceptable $ic;
    public static final String b = null;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755460864, "Lcom/repackage/p34;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755460864, "Lcom/repackage/p34;");
        }
    }

    public p34() {
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
            String O = h03.M() == null ? null : h03.M().O();
            j73 j73Var = new j73();
            j73Var.b = "click";
            j73Var.g = g;
            j73Var.e = str;
            if (str2 != null) {
                j73Var.a("target_appkey", str2);
            }
            j73Var.a("current_appkey", O);
            if (!TextUtils.isEmpty(str3)) {
                j73Var.a("location", str3);
            }
            a73.g(j73Var);
        }
    }

    public void c(int i, v34 v34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, v34Var) == null) {
            String g = g(i);
            JSONArray f = f(v34Var);
            j73 j73Var = new j73();
            j73Var.b = "show";
            j73Var.g = g;
            if (f != null) {
                j73Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            a73.g(j73Var);
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
            String O = h03.M() == null ? null : h03.M().O();
            j73 j73Var = new j73();
            j73Var.b = "click";
            j73Var.g = g;
            j73Var.e = str;
            if (str2 != null) {
                j73Var.a("target_appkey", str2);
            }
            j73Var.a("current_appkey", O);
            a73.g(j73Var);
            this.a.add(a);
        }
    }

    public void e(int i, v34 v34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, v34Var) == null) {
            String g = g(i);
            JSONArray f = f(v34Var);
            j73 j73Var = new j73();
            j73Var.b = "show";
            j73Var.g = g;
            if (f != null) {
                j73Var.a(GameGuideConfigInfo.KEY_GAME_LIST, f);
            }
            a73.g(j73Var);
            this.a.clear();
        }
    }

    public final JSONArray f(v34 v34Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, v34Var)) == null) {
            if (v34Var == null || v34Var.b == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (RecommendItemModel recommendItemModel : v34Var.b) {
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
