package com.kwai.sodler.lib.ext;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.a.a;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.g;
import com.kwai.sodler.lib.h;
/* loaded from: classes2.dex */
public interface b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {

    /* loaded from: classes2.dex */
    public static class a implements b<g, h> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void a(h hVar, PluginError pluginError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, hVar, pluginError) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void a(h hVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, hVar, gVar) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.sodler.lib.ext.b
        public void b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwai.sodler.lib.ext.b
        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwai.sodler.lib.ext.b
        public void d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            }
        }
    }

    void a(R r);

    void a(R r, P p);

    void a(R r, PluginError pluginError);

    void b(R r);

    void c(R r);

    void d(R r);
}
