package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.az;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<com.kwad.components.ad.reward.c.g> a;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(818220707, "Lcom/kwad/components/ad/reward/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(818220707, "Lcom/kwad/components/ad/reward/b$a;");
                    return;
                }
            }
            a = new b((byte) 0);
        }
    }

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
        this.a = new HashSet();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (b) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.c.k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, playableSource, kVar) == null) || this.a.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.c.g gVar : this.a) {
            gVar.a(playableSource, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, playableSource) == null) || this.a.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.c.g gVar : this.a) {
            gVar.e();
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.a.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.c.g gVar : this.a) {
            gVar.d();
        }
    }

    public final void a(com.kwad.components.ad.reward.c.g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) || gVar == null) {
            return;
        }
        this.a.add(gVar);
    }

    public final void a(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource) == null) {
            a(playableSource, (com.kwad.components.ad.reward.c.k) null);
        }
    }

    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.c.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, playableSource, kVar) == null) {
            if (c()) {
                b(playableSource, kVar);
            } else {
                az.a(new Runnable(this, playableSource, kVar) { // from class: com.kwad.components.ad.reward.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PlayableSource a;
                    public final /* synthetic */ com.kwad.components.ad.reward.c.k b;
                    public final /* synthetic */ b c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, playableSource, kVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.c = this;
                        this.a = playableSource;
                        this.b = kVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.c.b(this.a, this.b);
                        }
                    }
                });
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (c()) {
                d();
            } else {
                az.a(new Runnable(this) { // from class: com.kwad.components.ad.reward.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.b();
                        }
                    }
                });
            }
        }
    }

    public final void b(com.kwad.components.ad.reward.c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.a.remove(gVar);
        }
    }

    public final void b(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, playableSource) == null) {
            if (c()) {
                c(playableSource);
            } else {
                az.a(new Runnable(this, playableSource) { // from class: com.kwad.components.ad.reward.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PlayableSource a;
                    public final /* synthetic */ b b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, playableSource};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = playableSource;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.b.c(this.a);
                        }
                    }
                });
            }
        }
    }
}
