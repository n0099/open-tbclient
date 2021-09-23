package com.bytedance.sdk.openadsdk.preload.geckox;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.statistic.c;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f68955a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.e.b f68956b;

    /* renamed from: c  reason: collision with root package name */
    public Queue<String> f68957c;

    /* renamed from: d  reason: collision with root package name */
    public b f68958d;

    /* renamed from: e  reason: collision with root package name */
    public File f68959e;

    public a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68955a = new ArrayList();
        this.f68956b = new com.bytedance.sdk.openadsdk.preload.geckox.e.b();
        this.f68957c = new LinkedBlockingQueue();
        this.f68958d = bVar;
        File m = bVar.m();
        this.f68959e = m;
        m.mkdirs();
        c.a(this, this.f68958d);
    }

    public static a a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar != null) {
                List<String> e2 = bVar.e();
                if (e2 != null && !e2.isEmpty()) {
                    g.a(bVar.a());
                    return new a(bVar);
                }
                throw new IllegalArgumentException("access key empty");
            }
            throw new IllegalArgumentException("config == null");
        }
        return (a) invokeL.objValue;
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                List<String> e2 = this.f68958d.e();
                for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                    boolean z = false;
                    for (String str : e2) {
                        if (TextUtils.equals(str, entry.getKey())) {
                            z = true;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f68958d.e());
            a(com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(new com.bytedance.sdk.openadsdk.preload.geckox.k.a.a(arrayList)), 100);
        }
    }

    public void a(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            a("default", null, map, null);
        }
    }

    public void a(String str, Map<String, Map<String, Object>> map, Map<String, List<CheckRequestBodyModel.TargetChannel>> map2, com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (a()) {
                    if (b(map2)) {
                        this.f68958d.g().execute(new Runnable(this, str, aVar, map, map2) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f68960a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.geckox.e.a f68961b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ Map f68962c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ Map f68963d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ a f68964e;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str, aVar, map, map2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68964e = this;
                                this.f68960a = str;
                                this.f68961b = aVar;
                                this.f68962c = map;
                                this.f68963d = map2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.openadsdk.preload.geckox.a.a.b bVar;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start check update...", this.f68960a);
                                    if (this.f68964e.f68958d.b() != null) {
                                        bVar = this.f68964e.f68958d.b().a();
                                        bVar.a(this.f68964e.f68958d.b(), this.f68964e.f68958d.m(), this.f68964e.f68958d.e());
                                    } else {
                                        bVar = null;
                                    }
                                    try {
                                        try {
                                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "update finished", com.bytedance.sdk.openadsdk.preload.geckox.j.a.a(this.f68961b, this.f68964e.f68959e, this.f68964e.f68958d, this.f68964e.f68956b, this.f68962c, this.f68963d, this.f68960a).a((com.bytedance.sdk.openadsdk.preload.b.b<Object>) this.f68960a));
                                            com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar2 = this.f68961b;
                                            if (aVar2 != null) {
                                                aVar2.a();
                                            }
                                            if (bVar != null) {
                                                bVar.a();
                                            }
                                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                                        } catch (Exception e2) {
                                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "Gecko update failed:", e2);
                                            com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar3 = this.f68961b;
                                            if (aVar3 != null) {
                                                aVar3.a();
                                            }
                                            if (bVar != null) {
                                                bVar.a();
                                            }
                                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                                        }
                                        this.f68964e.b();
                                    } catch (Throwable th) {
                                        com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar4 = this.f68961b;
                                        if (aVar4 != null) {
                                            aVar4.a();
                                        }
                                        if (bVar != null) {
                                            bVar.a();
                                        }
                                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                                        throw th;
                                    }
                                }
                            }
                        });
                        return;
                    }
                    throw new IllegalArgumentException("target keys not in deployments keys");
                }
                throw new IllegalArgumentException("deployments keys not in local keys");
            }
            throw new IllegalArgumentException("groupType == null");
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            List<String> d2 = this.f68958d.d();
            List<String> e2 = this.f68958d.e();
            if (d2 == null || d2.isEmpty() || e2 == null || e2.isEmpty()) {
                return false;
            }
            for (String str : e2) {
                boolean z = false;
                for (String str2 : d2) {
                    if (TextUtils.equals(str, str2)) {
                        z = true;
                    }
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, aVar) == null) {
            this.f68956b.a(cls, aVar);
        }
    }

    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, str, i2) == null) {
            if (this.f68958d.o() != null && this.f68958d.o().a()) {
                this.f68958d.o().a(str, i2);
            } else if (this.f68957c.size() < 10) {
                this.f68957c.add(str);
            }
        }
    }
}
