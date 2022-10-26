package com.kwai.sodler.kwai;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.b.c;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.ext.c;
import com.kwai.sodler.lib.i;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean axa;
    public static final Handler handler;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwai.sodler.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0628a extends b.C0629b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwai.sodler.lib.ext.b axd;
        public b axe;

        public C0628a(com.kwai.sodler.lib.ext.b bVar, b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.axd = bVar;
            this.axe = bVar2;
        }

        @Override // com.kwai.sodler.lib.ext.b.C0629b, com.kwai.sodler.lib.ext.b
        public final void a(f fVar) {
            com.kwai.sodler.lib.ext.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.a(fVar);
        }

        @Override // com.kwai.sodler.lib.ext.b.C0629b, com.kwai.sodler.lib.ext.b
        public final void a(f fVar, com.kwai.sodler.lib.a.a aVar) {
            com.kwai.sodler.lib.ext.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, aVar) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.a(fVar, aVar);
        }

        @Override // com.kwai.sodler.lib.ext.b.C0629b, com.kwai.sodler.lib.ext.b
        public final void a(f fVar, PluginError pluginError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, pluginError) == null) {
                com.kwai.sodler.lib.a.e("Sodler.helper", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                com.kwai.sodler.lib.ext.b bVar = this.axd;
                if (bVar != null) {
                    bVar.a(fVar, pluginError);
                }
                b bVar2 = this.axe;
                if (bVar2 != null) {
                    bVar2.d(fVar);
                }
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0629b, com.kwai.sodler.lib.ext.b
        public final void b(f fVar) {
            com.kwai.sodler.lib.ext.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.b(fVar);
        }

        @Override // com.kwai.sodler.lib.ext.b.C0629b, com.kwai.sodler.lib.ext.b
        public final void c(f fVar) {
            com.kwai.sodler.lib.ext.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.c(fVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void d(f fVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1108959656, "Lcom/kwai/sodler/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1108959656, "Lcom/kwai/sodler/kwai/a;");
                return;
            }
        }
        handler = new Handler(Looper.getMainLooper());
    }

    public static void a(Context context, f fVar, com.kwai.sodler.lib.ext.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, fVar, bVar) == null) {
            init(context);
            fVar.cH(i.EU().EX().getRetryCount());
            fVar.a(new C0628a(bVar, new b() { // from class: com.kwai.sodler.kwai.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.kwai.sodler.kwai.a.b
                public final void d(f fVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, fVar2) == null) {
                        i.EU().l(fVar2);
                        a.handler.postDelayed(new Runnable(this, fVar2) { // from class: com.kwai.sodler.kwai.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ f axb;
                            public final /* synthetic */ AnonymousClass1 axc;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, fVar2};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.axc = this;
                                this.axb = fVar2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.axb.Fn()) {
                                    i.EU().a(this.axb, 16);
                                }
                            }
                        }, fVar2.Fm() instanceof PluginError.UpdateError ? 1000L : 0L);
                    }
                }
            }));
            i.EU().a(fVar, 16);
        }
    }

    public static void a(Context context, com.kwai.sodler.lib.c.b bVar, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, bVar, aVar) == null) {
            a(context, new com.kwai.sodler.lib.b.a(bVar), aVar);
        }
    }

    public static void a(Context context, com.kwai.sodler.lib.c.b bVar, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, bVar, cVar) == null) {
            a(context, new c(bVar), cVar);
        }
    }

    public static synchronized void a(Context context, com.kwai.sodler.lib.ext.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, cVar) == null) {
            synchronized (a.class) {
                if (axa) {
                    return;
                }
                i.EU().a(context, cVar);
                axa = true;
            }
        }
    }

    public static void a(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, aVar) == null) {
            i.EU().EZ().b(aVar);
        }
    }

    public static synchronized void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (a.class) {
                c.a aVar = new c.a();
                aVar.fc("sodler");
                aVar.cI(1);
                aVar.bF(false);
                aVar.bG(true);
                a(context, aVar.FG());
            }
        }
    }
}
