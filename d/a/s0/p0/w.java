package d.a.s0.p0;

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
import d.a.s0.p0.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public u f64545a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f64546b;

    /* loaded from: classes9.dex */
    public class a implements u.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64547e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f64548f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ w f64549g;

        public a(w wVar, List list, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, list, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64549g = wVar;
            this.f64547e = list;
            this.f64548f = map;
        }

        @Override // d.a.s0.p0.u.l
        public void onResult(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                this.f64549g.d(this.f64547e, this.f64548f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64550e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f64551f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ w f64552g;

        /* loaded from: classes9.dex */
        public class a implements u.l {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f64553e;

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
                this.f64553e = bVar;
            }

            @Override // d.a.s0.p0.u.l
            public void onResult(int i2, int i3, int i4) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                    b bVar = this.f64553e;
                    bVar.f64552g.g(bVar.f64551f);
                }
            }
        }

        public b(w wVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64552g = wVar;
            this.f64550e = list;
            this.f64551f = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f64552g.f64545a.h(this.f64550e, false, new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements u.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.s0.p0.u.l
        public void onResult(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                if (i3 > 0) {
                    BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                    d.a.s0.c2.d.s(System.currentTimeMillis());
                }
                d.a.s0.c2.d.m().u(false);
            }
        }
    }

    public w() {
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
        this.f64545a = u.s();
        this.f64546b = new Handler(Looper.getMainLooper());
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
                    d.a.r0.b0.c cVar = new d.a.r0.b0.c();
                    cVar.f54832f = collectEmotionData2.pkgId;
                    cVar.f54827a = collectEmotionData2.pid;
                    cVar.f54830d = collectEmotionData2.picUrl;
                    cVar.f54828b = collectEmotionData2.width;
                    cVar.f54829c = collectEmotionData2.height;
                    cVar.f54831e = collectEmotionData2.thumbnail;
                    arrayList2.add(cVar);
                }
                this.f64546b.post(new b(this, arrayList2, list));
                return;
            }
            g(list);
        }
    }

    public final void e(List<CollectEmotionData> list, List<CollectEmotionData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, CollectEmotionData> h2 = h(list2);
            Map<String, CollectEmotionData> h3 = h(list);
            for (Map.Entry<String, CollectEmotionData> entry : h2.entrySet()) {
                if (!h3.containsKey(entry.getKey())) {
                    arrayList.add(entry.getValue());
                }
            }
            if (!arrayList.isEmpty()) {
                this.f64545a.l(arrayList, false, new a(this, list, h2));
            } else {
                d(list, h2);
            }
        }
    }

    public void f(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            u.s().k(true);
            List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
            for (CollectEmotionData collectEmotionData : n) {
                String o = u.o(collectEmotionData.pid, false);
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
            Iterator<CollectEmotionData> it2 = n.iterator();
            while (it2.hasNext()) {
                BdLog.e("NewFaceSyncUtil Local data:" + it2.next().pkgId);
            }
            e(list, n);
        }
    }

    public final void g(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f64545a.t(list, false, new c(this));
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
