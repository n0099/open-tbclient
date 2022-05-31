package com.repackage;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m7;
import com.repackage.u7;
import com.repackage.y6;
/* loaded from: classes5.dex */
public class f5<T> implements m7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u7<String, b> a;
    public y6<b> b;
    public y6<a> c;
    public T d;

    /* loaded from: classes5.dex */
    public static class a<T> implements m7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Class<T> b;

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

        @Override // com.repackage.m7.c
        public void a(m7 m7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, m7Var, jsonValue) == null) {
                this.a = (String) m7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) m7Var.l("type", String.class, jsonValue);
                try {
                    this.b = r8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements m7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public j7 a;
        public f5 b;

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
                    return;
                }
            }
            new u7();
            this.a = new j7();
        }

        @Override // com.repackage.m7.c
        public void a(m7 m7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, m7Var, jsonValue) == null) {
                u7 u7Var = (u7) m7Var.l("data", u7.class, jsonValue);
                this.a.b((int[]) m7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public f5() {
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
        this.a = new u7<>();
        this.b = new y6<>(true, 3, b.class);
        this.c = new y6<>();
    }

    @Override // com.repackage.m7.c
    public void a(m7 m7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, m7Var, jsonValue) == null) {
            u7<String, b> u7Var = (u7) m7Var.l("unique", u7.class, jsonValue);
            this.a = u7Var;
            u7.a<String, b> b2 = u7Var.b();
            b2.d();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            y6<b> y6Var = (y6) m7Var.m("data", y6.class, b.class, jsonValue);
            this.b = y6Var;
            y6.b<b> it = y6Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((y6) m7Var.m("assets", y6.class, a.class, jsonValue));
            this.d = (T) m7Var.l("resource", null, jsonValue);
        }
    }

    public y6<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (y6) invokeV.objValue;
    }
}
