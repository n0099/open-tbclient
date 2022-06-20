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
import com.repackage.a7;
import com.repackage.o7;
import com.repackage.w7;
/* loaded from: classes6.dex */
public class h5<T> implements o7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w7<String, b> a;
    public a7<b> b;
    public a7<a> c;
    public T d;

    /* loaded from: classes6.dex */
    public static class a<T> implements o7.c {
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

        @Override // com.repackage.o7.c
        public void a(o7 o7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, o7Var, jsonValue) == null) {
                this.a = (String) o7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) o7Var.l("type", String.class, jsonValue);
                try {
                    this.b = t8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements o7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public l7 a;
        public h5 b;

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
            new w7();
            this.a = new l7();
        }

        @Override // com.repackage.o7.c
        public void a(o7 o7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, o7Var, jsonValue) == null) {
                w7 w7Var = (w7) o7Var.l("data", w7.class, jsonValue);
                this.a.b((int[]) o7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public h5() {
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
        this.a = new w7<>();
        this.b = new a7<>(true, 3, b.class);
        this.c = new a7<>();
    }

    @Override // com.repackage.o7.c
    public void a(o7 o7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, o7Var, jsonValue) == null) {
            w7<String, b> w7Var = (w7) o7Var.l("unique", w7.class, jsonValue);
            this.a = w7Var;
            w7.a<String, b> b2 = w7Var.b();
            b2.d();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            a7<b> a7Var = (a7) o7Var.m("data", a7.class, b.class, jsonValue);
            this.b = a7Var;
            a7.b<b> it = a7Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((a7) o7Var.m("assets", a7.class, a.class, jsonValue));
            this.d = (T) o7Var.l("resource", null, jsonValue);
        }
    }

    public a7<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (a7) invokeV.objValue;
    }
}
