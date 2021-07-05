package d.a.q0.h.o0.g.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.j2.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f53522b = null;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f53523a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-159919159, "Ld/a/q0/h/o0/g/b/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-159919159, "Ld/a/q0/h/o0/g/b/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53523a = new ArrayList();
    }

    public final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) ? String.format("%s_%s:%s", str, str2, str3) : (String) invokeLLL.objValue;
    }

    public void b(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            String g2 = g(i2);
            String D = d.a.q0.a.a2.e.i() == null ? null : d.a.q0.a.a2.e.i().D();
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = PrefetchEvent.STATE_CLICK;
            eVar.f49125g = g2;
            eVar.f49123e = str;
            if (str2 != null) {
                eVar.a("target_appkey", str2);
            }
            eVar.a("current_appkey", D);
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("location", str3);
            }
            k.g(eVar);
        }
    }

    public void c(int i2, d.a.q0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) {
            String g2 = g(i2);
            JSONArray f2 = f(aVar);
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = "show";
            eVar.f49125g = g2;
            if (f2 != null) {
                eVar.a(GameGuideConfigInfo.KEY_GAME_LIST, f2);
            }
            k.g(eVar);
        }
    }

    public void d(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
            String g2 = g(i2);
            String a2 = a(g2, str, str2);
            if (this.f53523a.contains(a2)) {
                return;
            }
            String D = d.a.q0.a.a2.e.i() == null ? null : d.a.q0.a.a2.e.i().D();
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = PrefetchEvent.STATE_CLICK;
            eVar.f49125g = g2;
            eVar.f49123e = str;
            if (str2 != null) {
                eVar.a("target_appkey", str2);
            }
            eVar.a("current_appkey", D);
            k.g(eVar);
            this.f53523a.add(a2);
        }
    }

    public void e(int i2, d.a.q0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, aVar) == null) {
            String g2 = g(i2);
            JSONArray f2 = f(aVar);
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49120b = "show";
            eVar.f49125g = g2;
            if (f2 != null) {
                eVar.a(GameGuideConfigInfo.KEY_GAME_LIST, f2);
            }
            k.g(eVar);
            this.f53523a.clear();
        }
    }

    public final JSONArray f(d.a.q0.h.o0.g.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.f53535b == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (RecommendItemModel recommendItemModel : aVar.f53535b) {
                jSONArray.put(recommendItemModel.appKey);
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
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
