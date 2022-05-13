package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x86;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class z86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x86 a;
    public Handler b;

    /* loaded from: classes7.dex */
    public class a implements x86.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ z86 c;

        public a(z86 z86Var, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z86Var;
            this.a = list;
            this.b = map;
        }

        @Override // com.repackage.x86.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.c.d(this.a, this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ z86 c;

        /* loaded from: classes7.dex */
        public class a implements x86.l {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.repackage.x86.l
            public void onResult(int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                    b bVar = this.a;
                    bVar.c.g(bVar.b);
                }
            }
        }

        public b(z86 z86Var, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z86Var;
            this.a = list;
            this.b = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.a.h(this.a, false, new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements x86.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.x86.l
        public void onResult(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                if (i2 > 0) {
                    BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                    bo7.s(System.currentTimeMillis());
                }
                bo7.m().u(false);
            }
        }
    }

    public z86() {
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
        this.a = x86.s();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void d(List<CollectEmotionData> list, Map<String, CollectEmotionData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, map) == null) {
            ArrayList<CollectEmotionData> arrayList = new ArrayList();
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null && !map.containsKey(collectEmotionData.pid) && !TextUtils.isEmpty(collectEmotionData.picUrl)) {
                    arrayList.add(collectEmotionData);
                }
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (CollectEmotionData collectEmotionData2 : arrayList) {
                    c45 c45Var = new c45();
                    c45Var.f = collectEmotionData2.pkgId;
                    c45Var.a = collectEmotionData2.pid;
                    c45Var.d = collectEmotionData2.picUrl;
                    c45Var.b = collectEmotionData2.width;
                    c45Var.c = collectEmotionData2.height;
                    c45Var.e = collectEmotionData2.thumbnail;
                    arrayList2.add(c45Var);
                }
                this.b.post(new b(this, arrayList2, list));
                return;
            }
            g(list);
        }
    }

    public final void e(List<CollectEmotionData> list, List<CollectEmotionData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, CollectEmotionData> h = h(list2);
            Map<String, CollectEmotionData> h2 = h(list);
            for (Map.Entry<String, CollectEmotionData> entry : h.entrySet()) {
                if (!h2.containsKey(entry.getKey())) {
                    arrayList.add(entry.getValue());
                }
            }
            if (!arrayList.isEmpty()) {
                this.a.l(arrayList, false, new a(this, list, h));
            } else {
                d(list, h);
            }
        }
    }

    public void f(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            x86.s().k(true);
            List<CollectEmotionData> m = n86.k().m(TbadkCoreApplication.getCurrentAccountForEmotion());
            for (CollectEmotionData collectEmotionData : m) {
                String o = x86.o(collectEmotionData.pid, false);
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(o);
                collectEmotionData.imageFileInfo = imageFileInfo;
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called CloudList:");
            Iterator<CollectEmotionData> it = list.iterator();
            while (it.hasNext()) {
                BdLog.e("NewFaceSyncUtil Cloud data:" + it.next().pkgId);
            }
            BdLog.e("NewFaceSyncUtil MergeCollectFace Called localList:");
            Iterator<CollectEmotionData> it2 = m.iterator();
            while (it2.hasNext()) {
                BdLog.e("NewFaceSyncUtil Local data:" + it2.next().pkgId);
            }
            e(list, m);
        }
    }

    public final void g(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a.t(list, false, new c(this));
        }
    }

    public final Map<String, CollectEmotionData> h(List<CollectEmotionData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (list != null) {
                for (CollectEmotionData collectEmotionData : list) {
                    if (collectEmotionData != null && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        hashMap.put(collectEmotionData.pid, collectEmotionData);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
