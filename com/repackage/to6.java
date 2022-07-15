package com.repackage;

import android.app.Activity;
import android.util.LruCache;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.te;
import java.util.Map;
/* loaded from: classes7.dex */
public class to6 {
    public static /* synthetic */ Interceptable $ic;
    public static to6 c;
    public transient /* synthetic */ FieldHolder $fh;
    public LruCache<String, String> a;
    public te<String> b;

    /* loaded from: classes7.dex */
    public class a extends km4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to6 a;

        public a(to6 to6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to6Var;
        }

        @Override // com.repackage.km4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity != null && activity.getClass().getName().equals("FrsActivity")) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : this.a.a.snapshot().entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append(",");
                }
                if (sb.length() <= 1) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
                this.a.b.a("transition_cache_key", sb.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements te.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to6 a;

        public b(to6 to6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {to6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = to6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.te.a
        /* renamed from: b */
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || str2 == null || str2.isEmpty()) {
                return;
            }
            for (String str3 : str2.split(",")) {
                String[] split = str3.split("=");
                if (split != null && split.length == 2) {
                    this.a.a.put(split[0], split[1]);
                }
            }
        }
    }

    public to6() {
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
        this.a = new LruCache<>(10);
        br4.f();
        this.b = br4.g("tb.recently_vistited_forum_animation");
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new a(this));
        this.b.f("transition_cache_key", new b(this));
    }

    public static to6 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (to6.class) {
                    if (c == null) {
                        c = new to6();
                    }
                }
            }
            return c;
        }
        return (to6) invokeV.objValue;
    }

    public uo6 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return new uo6(null);
            }
            return new uo6(this.a.get(str));
        }
        return (uo6) invokeL.objValue;
    }

    public void e(String str, uo6 uo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, uo6Var) == null) {
            this.a.put(str, uo6Var.toString());
        }
    }
}
