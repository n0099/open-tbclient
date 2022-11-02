package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bd;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<com.kwad.components.ad.reward.d.f> lt;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b lx;
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
            lx = new b((byte) 0);
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
        this.lt = new HashSet();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, playableSource, jVar) == null) || this.lt.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.f fVar : this.lt) {
            fVar.a(playableSource, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, playableSource) == null) || this.lt.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.f fVar : this.lt) {
            fVar.bP();
        }
    }

    public static b eV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a.lx : (b) invokeV.objValue;
    }

    private void eX() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.lt.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.f fVar : this.lt) {
            fVar.bO();
        }
    }

    public static boolean isMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Looper.getMainLooper() == Looper.myLooper() : invokeV.booleanValue;
    }

    public final void a(com.kwad.components.ad.reward.d.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        this.lt.add(fVar);
    }

    public final void a(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, playableSource) == null) {
            c(playableSource, null);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.lt.remove(fVar);
        }
    }

    public final void b(PlayableSource playableSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, playableSource) == null) {
            if (isMainThread()) {
                c(playableSource);
            } else {
                bd.runOnUiThread(new Runnable(this, playableSource) { // from class: com.kwad.components.ad.reward.b.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PlayableSource lu;
                    public final /* synthetic */ b lw;

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
                        this.lw = this;
                        this.lu = playableSource;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.lw.c(this.lu);
                        }
                    }
                });
            }
        }
    }

    public final void c(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, playableSource, jVar) == null) {
            if (isMainThread()) {
                b(playableSource, jVar);
            } else {
                bd.runOnUiThread(new Runnable(this, playableSource, jVar) { // from class: com.kwad.components.ad.reward.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PlayableSource lu;
                    public final /* synthetic */ com.kwad.components.ad.reward.d.j lv;
                    public final /* synthetic */ b lw;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, playableSource, jVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.lw = this;
                        this.lu = playableSource;
                        this.lv = jVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.lw.b(this.lu, this.lv);
                        }
                    }
                });
            }
        }
    }

    public final void eW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (isMainThread()) {
                eX();
            } else {
                bd.runOnUiThread(new Runnable(this) { // from class: com.kwad.components.ad.reward.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b lw;

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
                        this.lw = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.lw.eW();
                        }
                    }
                });
            }
        }
    }
}
