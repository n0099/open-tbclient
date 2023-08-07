package com.kwai.sodler.kwai;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
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
/* loaded from: classes10.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean axa;
    public static final Handler handler;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwai.sodler.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0709a<P extends com.kwai.sodler.lib.a.a, R extends f<P>> extends b.C0710b<P, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwai.sodler.lib.ext.b<P, R> axd;
        public b<P, R> axe;

        public C0709a(com.kwai.sodler.lib.ext.b<P, R> bVar, b<P, R> bVar2) {
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

        @Override // com.kwai.sodler.lib.ext.b.C0710b, com.kwai.sodler.lib.ext.b
        public final void a(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, r) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.a(r);
        }

        @Override // com.kwai.sodler.lib.ext.b.C0710b, com.kwai.sodler.lib.ext.b
        public final void a(R r, P p) {
            com.kwai.sodler.lib.ext.b<P, R> bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r, p) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.a((com.kwai.sodler.lib.ext.b<P, R>) r, (R) p);
        }

        @Override // com.kwai.sodler.lib.ext.b.C0710b, com.kwai.sodler.lib.ext.b
        public final void a(R r, PluginError pluginError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, r, pluginError) == null) {
                com.kwai.sodler.lib.a.e("Sodler.helper", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                com.kwai.sodler.lib.ext.b<P, R> bVar = this.axd;
                if (bVar != null) {
                    bVar.a((com.kwai.sodler.lib.ext.b<P, R>) r, pluginError);
                }
                b<P, R> bVar2 = this.axe;
                if (bVar2 != null) {
                    bVar2.d(r);
                }
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0710b, com.kwai.sodler.lib.ext.b
        public final void b(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, r) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.b(r);
        }

        @Override // com.kwai.sodler.lib.ext.b.C0710b, com.kwai.sodler.lib.ext.b
        public final void c(R r) {
            com.kwai.sodler.lib.ext.b<P, R> bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, r) == null) || (bVar = this.axd) == null) {
                return;
            }
            bVar.c(r);
        }
    }

    /* loaded from: classes10.dex */
    public interface b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {
        void d(R r);
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

    public static <P extends com.kwai.sodler.lib.a.a, R extends f<P>> void a(Context context, R r, com.kwai.sodler.lib.ext.b<P, R> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, r, bVar) == null) {
            init(context);
            r.cH(i.EU().EX().getRetryCount());
            r.a(new C0709a(bVar, new b<P, R>() { // from class: com.kwai.sodler.kwai.a.1
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

                /* JADX WARN: Incorrect types in method signature: (TR;)V */
                @Override // com.kwai.sodler.kwai.a.b
                public final void d(f fVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, fVar) == null) {
                        i.EU().l(fVar);
                        a.handler.postDelayed(new Runnable(this, fVar) { // from class: com.kwai.sodler.kwai.a.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ f axb;
                            public final /* synthetic */ AnonymousClass1 axc;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, fVar};
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
                                this.axb = fVar;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.axb.Fn()) {
                                    i.EU().a(this.axb, 16);
                                }
                            }
                        }, fVar.Fm() instanceof PluginError.UpdateError ? 1000L : 0L);
                    }
                }
            }));
            i.EU().a(r, 16);
        }
    }

    public static void a(Context context, @NonNull com.kwai.sodler.lib.c.b bVar, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, bVar, aVar) == null) {
            a(context, new com.kwai.sodler.lib.b.a(bVar), aVar);
        }
    }

    public static void a(Context context, @NonNull com.kwai.sodler.lib.c.b bVar, b.c cVar) {
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
