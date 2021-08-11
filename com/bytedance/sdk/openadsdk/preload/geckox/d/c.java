package com.bytedance.sdk.openadsdk.preload.geckox.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Common;
import com.bytedance.sdk.openadsdk.preload.geckox.model.ComponentModel;
import com.bytedance.sdk.openadsdk.preload.geckox.model.Response;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends com.bytedance.sdk.openadsdk.preload.b.d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.b f68348d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, Map<String, Object>> f68349e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, List<CheckRequestBodyModel.TargetChannel>> f68350f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.e.a f68351g;

    /* renamed from: h  reason: collision with root package name */
    public String f68352h;

    /* renamed from: i  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b f68353i;

    /* loaded from: classes9.dex */
    public static class a extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1928c extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1928c(String str, Throwable th) {
            super(str, th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68353i = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b();
    }

    private void b(List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, list) == null) || list == null) {
            return;
        }
        for (Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a> pair : list) {
            try {
                ((com.bytedance.sdk.openadsdk.preload.geckox.g.a) pair.second).a();
            } catch (Exception e2) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "releaseLock:", e2);
            }
        }
    }

    private List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> c(List<UpdatePackage> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (UpdatePackage updatePackage : list) {
                    try {
                        File file = new File(new File(this.f68348d.m(), updatePackage.getAccessKey()), updatePackage.getChannel());
                        if (file.isFile()) {
                            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
                        }
                        if (!file.mkdirs() && !file.isDirectory()) {
                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "can not create channel dir：", file.getAbsolutePath());
                            throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                            break;
                        }
                        com.bytedance.sdk.openadsdk.preload.geckox.g.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.g.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                        if (a2 != null) {
                            arrayList.add(new Pair(updatePackage.getChannel(), a2));
                            arrayList2.add(updatePackage);
                        } else {
                            a(this.f68351g, updatePackage.getChannel());
                        }
                    } catch (Exception e2) {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", e2);
                        a(updatePackage.getChannel(), this.f68351g, e2);
                    }
                }
                list.clear();
                list.addAll(arrayList2);
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            super.a(objArr);
            this.f68348d = (com.bytedance.sdk.openadsdk.preload.geckox.b) objArr[0];
            this.f68349e = (Map) objArr[1];
            this.f68350f = (Map) objArr[2];
            this.f68351g = (com.bytedance.sdk.openadsdk.preload.geckox.e.a) objArr[3];
            this.f68352h = (String) objArr[4];
        }
    }

    private Map<String, List<UpdatePackage>> b(Map<String, List<Pair<String, Long>>> map) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, map)) == null) {
            String c2 = c(map);
            String str = "https://" + this.f68348d.i() + "/gecko/server/v3/package";
            try {
                this.f68353i.f68431f = com.bytedance.sdk.openadsdk.preload.geckox.utils.i.a(this.f68348d.a());
                com.bytedance.sdk.openadsdk.preload.geckox.i.c a2 = this.f68348d.h().a(str, c2);
                this.f68353i.f68432g = a2.f68391c;
                this.f68353i.f68429d = a2.f68392d;
                this.f68353i.f68430e = com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b.a(a2.f68389a);
                if (a2.f68391c == 200) {
                    String str2 = a2.f68390b;
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "response:", str2);
                    try {
                        Response response = (Response) com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(str2, new com.bytedance.sdk.openadsdk.preload.a.c.a<Response<ComponentModel>>(this) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.d.c.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ c f68357a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68357a = this;
                            }
                        }.b());
                        int i2 = response.status;
                        if (i2 == 0) {
                            if (response.data != 0) {
                                com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.f68348d.a(), ((ComponentModel) response.data).getUniversalStrategies(), this.f68348d.m(), this.f68351g);
                                Map<String, List<UpdatePackage>> packages = ((ComponentModel) response.data).getPackages();
                                if (packages != null && !packages.isEmpty()) {
                                    for (String str3 : this.f68348d.e()) {
                                        List<UpdatePackage> list = packages.get(str3);
                                        if (list != null && !list.isEmpty()) {
                                            for (UpdatePackage updatePackage : list) {
                                                updatePackage.setAccessKey(str3);
                                                updatePackage.setLocalVersion(a(map.get(str3), updatePackage.getChannel()));
                                            }
                                        }
                                    }
                                    return packages;
                                }
                                com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.f68348d);
                                return new HashMap();
                            } else {
                                com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar = this.f68353i;
                                bVar.f68429d = "check update error：response.data==null";
                                com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f68348d, bVar);
                                throw new a("check update error：response.data==null");
                            }
                        }
                        if (i2 == 2000) {
                            com.bytedance.sdk.openadsdk.preload.geckox.a.a.a(this.f68348d);
                            return new HashMap();
                        }
                        String str4 = "check update error，unknow status code，response.status：" + response.status;
                        com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.b bVar2 = this.f68353i;
                        bVar2.f68429d = str4;
                        com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f68348d, bVar2);
                        throw new a(str4);
                    } catch (Exception e2) {
                        this.f68353i.f68429d = "json parse failed：" + e2.getMessage();
                        com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f68348d, this.f68353i);
                        throw new b("json parse failed：" + str2 + " caused by:" + e2.getMessage(), e2);
                    }
                }
                throw new NetworkErrorException("net work get failed, code: " + a2.f68391c + ", url:" + str);
            } catch (Exception e3) {
                com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f68348d, this.f68353i);
                throw new C1928c("request failed：url:" + str + ", caused by:" + e3.getMessage(), e3);
            }
        }
        return (Map) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Throwable {
        InterceptResult invokeLL;
        List<Pair<String, com.bytedance.sdk.openadsdk.preload.geckox.g.a>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, map)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start get server channel version[v3]... local channel version:", map);
            Map<String, List<UpdatePackage>> b2 = b(map);
            com.bytedance.sdk.openadsdk.preload.geckox.statistic.e.a(this.f68348d, this.f68353i);
            a(b2);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, List<UpdatePackage>> entry : b2.entrySet()) {
                arrayList.addAll(entry.getValue());
            }
            Object obj = null;
            try {
                list = c(arrayList);
                try {
                    obj = bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<List<UpdatePackage>>) arrayList);
                    b(list);
                    com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", th);
                        b(list);
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                        a(arrayList);
                        return obj;
                    } catch (Throwable th2) {
                        b(list);
                        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                list = null;
            }
            a(arrayList);
            return obj;
        }
        return invokeLL.objValue;
    }

    private String c(Map<String, List<Pair<String, Long>>> map) {
        InterceptResult invokeL;
        List<CheckRequestBodyModel.TargetChannel> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, map)) == null) {
            CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
            Context a2 = this.f68348d.a();
            checkRequestBodyModel.setCommon(new Common(this.f68348d.j(), this.f68348d.n(), this.f68348d.q(), com.bytedance.sdk.openadsdk.preload.geckox.utils.a.b(a2), com.bytedance.sdk.openadsdk.preload.geckox.utils.i.a(a2), this.f68348d.k(), this.f68348d.l()));
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, List<Pair<String, Long>>> entry : map.entrySet()) {
                HashMap hashMap2 = new HashMap();
                for (Pair<String, Long> pair : entry.getValue()) {
                    CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                    localChannel.localVersion = (Long) pair.second;
                    hashMap2.put(pair.first, localChannel);
                }
                hashMap.put(entry.getKey(), hashMap2);
            }
            this.f68353i.f68426a = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(hashMap);
            checkRequestBodyModel.setLocal(hashMap);
            HashMap hashMap3 = new HashMap();
            for (String str : this.f68348d.e()) {
                CheckRequestBodyModel.Group group = new CheckRequestBodyModel.Group();
                group.groupName = this.f68352h;
                Map<String, List<CheckRequestBodyModel.TargetChannel>> map2 = this.f68350f;
                if (map2 != null && !map2.isEmpty() && (list = this.f68350f.get(str)) != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    group.targetChannels = arrayList;
                    arrayList.addAll(list);
                }
                hashMap3.put(str, group);
            }
            this.f68353i.f68427b = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(hashMap3);
            checkRequestBodyModel.setDeployments(hashMap3);
            if (this.f68349e != null) {
                this.f68353i.f68428c = com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(this.f68349e);
                checkRequestBodyModel.setCustom(this.f68349e);
            }
            return com.bytedance.sdk.openadsdk.preload.geckox.c.b.a().b().a(checkRequestBodyModel);
        }
        return (String) invokeL.objValue;
    }

    private void a(List<UpdatePackage> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (UpdatePackage updatePackage : list) {
            com.bytedance.sdk.openadsdk.preload.geckox.a.c.a(new File(new File(this.f68348d.m(), updatePackage.getAccessKey()), updatePackage.getChannel()).getAbsolutePath());
        }
    }

    private void a(com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, aVar, str) == null) || aVar == null) {
            return;
        }
        try {
            aVar.a(str);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "onUpdating:", th);
        }
    }

    private void a(String str, com.bytedance.sdk.openadsdk.preload.geckox.e.a aVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, this, str, aVar, exc) == null) || aVar == null) {
            return;
        }
        try {
            aVar.a(str, exc);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "onUpdateFailed:", th);
        }
    }

    private void a(Map<String, List<UpdatePackage>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, map) == null) {
            for (Map.Entry<String, List<UpdatePackage>> entry : map.entrySet()) {
                Iterator<UpdatePackage> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    UpdatePackage next = it.next();
                    long localVersion = next.getLocalVersion();
                    long version = next.getVersion();
                    if (version < localVersion) {
                        a(it, next, localVersion, version);
                    }
                }
            }
        }
    }

    private void a(Iterator<UpdatePackage> it, UpdatePackage updatePackage, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{it, updatePackage, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", updatePackage.getChannel(), "rollback：", Long.valueOf(j2), "->", Long.valueOf(j3));
            File[] listFiles = new File(this.f68348d.m(), updatePackage.getAccessKey() + File.separator + updatePackage.getChannel()).listFiles(new FileFilter(this) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.d.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f68354a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68354a = this;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? file.isDirectory() : invokeL.booleanValue;
                }
            });
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            for (File file : listFiles) {
                try {
                    int i2 = (Long.parseLong(file.getName()) > j3 ? 1 : (Long.parseLong(file.getName()) == j3 ? 0 : -1));
                    if (i2 > 0) {
                        File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                        file.renameTo(file2);
                        com.bytedance.sdk.openadsdk.preload.geckox.utils.f.a().execute(new Runnable(this, file2) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.d.c.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ File f68355a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ c f68356b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, file2};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68356b = this;
                                this.f68355a = file2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(this.f68355a);
                                }
                            }
                        });
                    } else if (i2 == 0) {
                        it.remove();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private long a(List<Pair<String, Long>> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, list, str)) == null) {
            for (Pair<String, Long> pair : list) {
                if (((String) pair.first).equals(str)) {
                    return ((Long) pair.second).longValue();
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }
}
