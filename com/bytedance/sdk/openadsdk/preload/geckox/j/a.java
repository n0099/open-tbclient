package com.bytedance.sdk.openadsdk.preload.geckox.j;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.b;
import com.bytedance.sdk.openadsdk.preload.b.h;
import com.bytedance.sdk.openadsdk.preload.b.l;
import com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.d.c;
import com.bytedance.sdk.openadsdk.preload.geckox.d.e;
import com.bytedance.sdk.openadsdk.preload.geckox.d.f;
import com.bytedance.sdk.openadsdk.preload.geckox.d.g;
import com.bytedance.sdk.openadsdk.preload.geckox.d.i;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static b<Object> a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2, Map<String, Map<String, Object>> map, Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{aVar, file, bVar, bVar2, map, map2, str})) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h.a.a().a(e.class).a(file, bVar.d()).a(bVar2.a(e.class)).b());
            arrayList.add(h.a.a().a(c.class).a(bVar, map, map2, aVar, str).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(f(aVar), bVar2.a(c.class))).b());
            arrayList.add(h.a.a().a(f.class).a(bVar.f()).a(a(aVar)).b());
            l.b bVar3 = new l.b();
            bVar3.a("branch_zip").a(d(aVar, file, bVar, bVar2)).a(h.a.a().a(com.bytedance.sdk.openadsdk.preload.b.f.class).b());
            bVar3.a("branch_single_file").a(a(aVar, file, bVar, bVar2)).a(h.a.a().a(com.bytedance.sdk.openadsdk.preload.b.f.class).b());
            bVar3.a("branch_myarchive_file").a(g(aVar, file, bVar, bVar2)).a(h.a.a().a(com.bytedance.sdk.openadsdk.preload.b.f.class).b());
            arrayList.add(bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.class));
            arrayList.add(h.a.a().a(i.class).a(b(aVar)).b());
            return com.bytedance.sdk.openadsdk.preload.b.c.a(arrayList, null);
        }
        return (b) invokeCommon.objValue;
    }

    public static List<h> b(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, aVar, file, bVar, bVar2)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h.a.a().a(g.class).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.b.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.b.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.a.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.c.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.c.class))).b());
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<h> c(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, aVar, file, bVar, bVar2)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.h.class).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.c.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.c.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.b.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.b.class))).b());
            arrayList.add(h.a.a().a(d.class).a(bVar).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(d.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.a.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.e.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.a.b.e.class))).b());
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public static h d(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, aVar, file, bVar, bVar2)) == null) {
            l.b bVar3 = new l.b();
            bVar3.a(SchemeDescPatchListener.PATCH).a(f(aVar, file, bVar, bVar2));
            bVar3.a("full").a(e(aVar, file, bVar, bVar2));
            return bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class);
        }
        return (h) invokeLLLL.objValue;
    }

    public static List<h> e(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, aVar, file, bVar, bVar2)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h.a.a().a(g.class).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.b.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.b.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.a.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.d.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.d.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.a.c.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar))).b());
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<h> f(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, aVar, file, bVar, bVar2)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.h.class).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.c.class).a(bVar, file).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(e(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.c.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.b.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.b.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.d.class).a(bVar).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.d.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.a.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.a.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.f.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(d(aVar), bVar2.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.f.class))).b());
            arrayList.add(h.a.a().a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.b.e.class).a(new com.bytedance.sdk.openadsdk.preload.b.b.b(c(aVar))).b());
            return arrayList;
        }
        return (List) invokeLLLL.objValue;
    }

    public static h g(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, aVar, file, bVar, bVar2)) == null) {
            l.b bVar3 = new l.b();
            bVar3.a(SchemeDescPatchListener.PATCH).a(b(aVar, file, bVar));
            bVar3.a("full").a(a(aVar, file, bVar));
            return bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class);
        }
        return (h) invokeLLLL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a d(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.preload.b.b.a(aVar) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.j.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.e.a f32234a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32234a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                        super.a(bVar, dVar, th);
                        this.f32234a.a((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class), th);
                    }
                }
            };
        }
        return (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static List<h> b(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, aVar, file, bVar)) == null) ? Collections.emptyList() : (List) invokeLLL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a b(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.preload.b.b.a(aVar) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.j.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.e.a f32232a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32232a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bVar, dVar) == null) {
                        super.a(bVar, dVar);
                        Pair pair = (Pair) bVar.a(i.class);
                        this.f32232a.a((String) pair.first, ((Long) pair.second).longValue());
                    }
                }
            };
        }
        return (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a e(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.preload.b.b.a(aVar) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.j.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.e.a f32235a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32235a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                        super.a(bVar, dVar, th);
                        this.f32235a.b((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class), th);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void b(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                        super.b(bVar, dVar);
                        this.f32235a.c((UpdatePackage) bVar.b(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void c(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, dVar) == null) {
                        super.c(bVar, dVar);
                        this.f32235a.a((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class));
                    }
                }
            };
        }
        return (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static h a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar, com.bytedance.sdk.openadsdk.preload.geckox.e.b bVar2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, aVar, file, bVar, bVar2)) == null) {
            l.b bVar3 = new l.b();
            bVar3.a(SchemeDescPatchListener.PATCH).a(c(aVar, file, bVar, bVar2));
            bVar3.a("full").a(b(aVar, file, bVar, bVar2));
            return bVar3.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class);
        }
        return (h) invokeLLLL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a c(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.preload.b.b.a(aVar) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.j.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.e.a f32233a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32233a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                        super.a(bVar, dVar, th);
                        this.f32233a.a((UpdatePackage) bVar.a(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class), th);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void b(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                        super.b(bVar, dVar);
                        this.f32233a.b((UpdatePackage) bVar.b(com.bytedance.sdk.openadsdk.preload.geckox.d.b.class));
                    }
                }
            };
        }
        return (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static List<h> a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, File file, com.bytedance.sdk.openadsdk.preload.geckox.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, aVar, file, bVar)) == null) ? Collections.emptyList() : (List) invokeLLL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.preload.b.b.a(aVar) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.j.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.e.a f32231a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32231a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                        super.a(bVar, dVar, th);
                        this.f32231a.a(((UpdatePackage) bVar.b(f.class)).getChannel(), th);
                    }
                }
            };
        }
        return (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.preload.b.b.a f(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.preload.b.b.a(aVar) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.j.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.e.a f32236a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32236a = aVar;
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void a(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bVar, dVar, th) == null) {
                        super.a(bVar, dVar, th);
                        this.f32236a.a((Map) bVar.a(c.class), th);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
                public <T> void b(b<T> bVar, com.bytedance.sdk.openadsdk.preload.b.d dVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
                        super.b(bVar, dVar);
                        Map<String, List<Pair<String, Long>>> map = (Map) bVar.a(c.class);
                        HashMap hashMap = new HashMap();
                        for (UpdatePackage updatePackage : (List) bVar.b(c.class)) {
                            String accessKey = updatePackage.getAccessKey();
                            List list = (List) hashMap.get(accessKey);
                            if (list == null) {
                                list = new ArrayList();
                            }
                            list.add(updatePackage);
                            hashMap.put(accessKey, list);
                        }
                        this.f32236a.a(map, hashMap);
                    }
                }
            };
        }
        return (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }
}
