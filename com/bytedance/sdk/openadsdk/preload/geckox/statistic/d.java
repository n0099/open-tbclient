package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.d.g;
import com.bytedance.sdk.openadsdk.preload.geckox.d.h;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.StatisticModel;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.i;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.bytedance.sdk.openadsdk.preload.b.b.a a(com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a(bVar) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.b f32137a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32137a = bVar;
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar2, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bVar2, dVar) == null) {
                    super.a(bVar2, dVar);
                    e.a(this.f32137a, b.a(dVar.c()));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar2, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bVar2, dVar, th) == null) {
                    super.b(bVar2, dVar, th);
                    e.a(this.f32137a, b.a(dVar.c()));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar2, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2, dVar, th) == null) {
                    super.a(bVar2, dVar, th);
                    e.a(this.f32137a, b.a(dVar.c()));
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a(context) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f32139a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32139a = context;
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    Pair pair = (Pair) bVar.b(h.class);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                    String uri = ((Uri) pair.first).toString();
                    a2.f32151h = false;
                    a2.f32150g = SystemClock.uptimeMillis();
                    a2.f32148e.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.f32151h = true;
                    a2.f32150g = SystemClock.uptimeMillis();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, dVar) == null) {
                    super.c(bVar, dVar);
                    Pair pair = (Pair) bVar.b(h.class);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                    a2.f32147d = ((Uri) pair.first).toString();
                    a2.p = i.a(this.f32139a);
                    a2.f32149f = SystemClock.uptimeMillis();
                    a2.q = Long.valueOf(((UpdatePackage) pair.second).getPatch().getId());
                    a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                    a2.f32146c = ((UpdatePackage) pair.second).getChannel();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.j = false;
                    a2.n = SystemClock.uptimeMillis();
                    a2.t = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.j = true;
                    a2.n = SystemClock.uptimeMillis();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.C = false;
                    a2.z = SystemClock.uptimeMillis();
                    a2.E = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.C = true;
                    a2.z = SystemClock.uptimeMillis();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.D = false;
                    a2.A = SystemClock.uptimeMillis();
                    a2.F = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.D = true;
                    a2.A = SystemClock.uptimeMillis();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.k = false;
                    a2.u = th.getMessage();
                    a2.o = SystemClock.uptimeMillis();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.k = true;
                    a2.o = SystemClock.uptimeMillis();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.D = false;
                    a2.A = SystemClock.uptimeMillis();
                    a2.F = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, dVar, th) == null) {
                    super.b(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.D = false;
                    a2.A = SystemClock.uptimeMillis();
                    a2.F = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bVar, dVar) == null) {
                    super.a(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.D = true;
                    a2.A = SystemClock.uptimeMillis();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.k = false;
                    a2.o = SystemClock.uptimeMillis();
                    a2.u = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, bVar, dVar, th) == null) {
                    super.b(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.k = false;
                    a2.o = SystemClock.uptimeMillis();
                    a2.F = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bVar, dVar) == null) {
                    super.a(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.k = true;
                    a2.o = SystemClock.uptimeMillis();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a(context) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f32138a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32138a = context;
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    Pair pair = (Pair) bVar.b(g.class);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                    String uri = ((Uri) pair.first).toString();
                    a2.B = false;
                    a2.y = SystemClock.uptimeMillis();
                    a2.w.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                    a2.B = true;
                    a2.y = SystemClock.uptimeMillis();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, dVar) == null) {
                    super.c(bVar, dVar);
                    Pair pair = (Pair) bVar.b(g.class);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) pair.second).getChannel());
                    a2.v = ((Uri) pair.first).toString();
                    a2.p = i.a(this.f32138a);
                    a2.x = SystemClock.uptimeMillis();
                    a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                    a2.f32146c = ((UpdatePackage) pair.second).getChannel();
                    if (!TextUtils.isEmpty(((UpdatePackage) pair.second).getAccessKey())) {
                        a2.f32144a = ((UpdatePackage) pair.second).getAccessKey();
                    }
                    if (TextUtils.isEmpty(((UpdatePackage) pair.second).getGroupName())) {
                        return;
                    }
                    a2.f32145b = ((UpdatePackage) pair.second).getGroupName();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.j = false;
                    a2.m = SystemClock.uptimeMillis();
                    a2.t = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.j = true;
                    a2.m = SystemClock.uptimeMillis();
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? new com.bytedance.sdk.openadsdk.preload.b.b.a() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.statistic.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                    super.a(bVar, dVar, th);
                    com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a2 = b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel());
                    a2.f32152i = false;
                    a2.l = SystemClock.uptimeMillis();
                    a2.s = th.getMessage();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
            public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                    super.b(bVar, dVar);
                    b.a(dVar.c()).a(((UpdatePackage) ((Pair) bVar.b(h.class)).second).getChannel()).f32152i = true;
                }
            }
        } : (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeV.objValue;
    }
}
