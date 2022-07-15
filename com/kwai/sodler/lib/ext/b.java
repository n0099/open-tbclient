package com.kwai.sodler.lib.ext;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.a.a;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.h;
/* loaded from: classes5.dex */
public interface b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {

    /* loaded from: classes5.dex */
    public static class a extends C0567b<com.kwai.sodler.lib.kwai.a, com.kwai.sodler.lib.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    }

    /* renamed from: com.kwai.sodler.lib.ext.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0567b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> implements b<P, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0567b() {
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

        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r) == null) {
            }
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r, P p) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r, p) == null) {
            }
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r, PluginError pluginError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, r, pluginError) == null) {
            }
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void b(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
            }
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void c(R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, r) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends C0567b<h, com.kwai.sodler.lib.b.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    }

    void a(R r);

    void a(R r, P p);

    void a(R r, PluginError pluginError);

    void b(R r);

    void c(R r);
}
