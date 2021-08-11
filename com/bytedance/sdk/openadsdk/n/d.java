package com.bytedance.sdk.openadsdk.n;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.n.b;
import com.bytedance.sdk.openadsdk.n.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static volatile d f67815e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f67816a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<Map<String, com.bytedance.sdk.openadsdk.n.b>> f67817b;

    /* renamed from: c  reason: collision with root package name */
    public final b<Runnable> f67818c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f67819d;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.n.b.c f67820f;

    /* renamed from: g  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.n.a.c f67821g;

    /* renamed from: h  reason: collision with root package name */
    public volatile com.bytedance.sdk.openadsdk.n.a.b f67822h;

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<a> f67823i;

    /* renamed from: j  reason: collision with root package name */
    public final b.InterfaceC1920b f67824j;
    public volatile c k;
    public volatile c l;
    public volatile String m;
    public volatile boolean n;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f67833a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f67834b;

        /* renamed from: c  reason: collision with root package name */
        public final int f67835c;

        /* renamed from: d  reason: collision with root package name */
        public final String f67836d;

        /* renamed from: e  reason: collision with root package name */
        public final Map<String, String> f67837e;

        /* renamed from: f  reason: collision with root package name */
        public final String[] f67838f;

        public a(boolean z, boolean z2, int i2, String str, Map<String, String> map, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, map, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67833a = z;
            this.f67834b = z2;
            this.f67835c = i2;
            this.f67836d = str;
            this.f67837e = map;
            this.f67838f = strArr;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                if (this.f67833a == aVar.f67833a && this.f67834b == aVar.f67834b && this.f67835c == aVar.f67835c) {
                    return this.f67836d.equals(aVar.f67836d);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ((((((this.f67833a ? 1 : 0) * 31) + (this.f67834b ? 1 : 0)) * 31) + this.f67835c) * 31) + this.f67836d.hashCode();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b<T> extends LinkedBlockingDeque<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ThreadPoolExecutor f67839a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadPoolExecutor) == null) {
                synchronized (this) {
                    if (this.f67839a != null) {
                        throw new IllegalStateException("You can only call setExecutor() once!");
                    }
                    if (threadPoolExecutor != null) {
                        this.f67839a = threadPoolExecutor;
                    } else {
                        throw new NullPointerException("executor argument can't be null!");
                    }
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                synchronized (this) {
                    int poolSize = this.f67839a.getPoolSize();
                    int activeCount = this.f67839a.getActiveCount();
                    int maximumPoolSize = this.f67839a.getMaximumPoolSize();
                    if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                        boolean z = e.f67842c;
                        return false;
                    }
                    return offerFirst(t);
                }
            }
            return invokeL.booleanValue;
        }
    }

    public d() {
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
        this.f67816a = 163840;
        this.f67817b = new SparseArray<>(2);
        this.f67823i = new HashSet<>();
        this.f67824j = new b.InterfaceC1920b(this) { // from class: com.bytedance.sdk.openadsdk.n.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f67825a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67825a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.n.b.InterfaceC1920b
            public void a(com.bytedance.sdk.openadsdk.n.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    int f2 = bVar.f();
                    synchronized (this.f67825a.f67817b) {
                        Map map = (Map) this.f67825a.f67817b.get(f2);
                        if (map != null) {
                            map.remove(bVar.f67763h);
                        }
                    }
                    if (e.f67842c) {
                        String str = "afterExecute, key: " + bVar.f67763h;
                    }
                }
            }
        };
        b<Runnable> bVar = new b<>();
        this.f67818c = bVar;
        ExecutorService a2 = a(bVar);
        this.f67819d = a2;
        this.f67818c.a((ThreadPoolExecutor) a2);
        this.f67817b.put(0, new HashMap());
        this.f67817b.put(1, new HashMap());
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f67815e == null) {
                synchronized (d.class) {
                    if (f67815e == null) {
                        f67815e = new d();
                    }
                }
            }
            return f67815e;
        }
        return (d) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.bytedance.sdk.openadsdk.n.g.d.a(new com.bytedance.sdk.component.d.g(this, "cancelAll") { // from class: com.bytedance.sdk.openadsdk.n.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67830a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67830a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ArrayList<com.bytedance.sdk.openadsdk.n.b> arrayList = new ArrayList();
                        synchronized (this.f67830a.f67817b) {
                            int size = this.f67830a.f67817b.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                Map map = (Map) this.f67830a.f67817b.get(this.f67830a.f67817b.keyAt(i2));
                                if (map != null) {
                                    arrayList.addAll(map.values());
                                    map.clear();
                                }
                            }
                            this.f67830a.f67818c.clear();
                        }
                        for (com.bytedance.sdk.openadsdk.n.b bVar : arrayList) {
                            bVar.a();
                            if (e.f67842c) {
                                String str = "PreloadTask: " + bVar + ", canceled!!!";
                            }
                        }
                    }
                }
            });
        }
    }

    public void a(com.bytedance.sdk.openadsdk.n.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f67821g = cVar;
        }
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : (c) invokeV.objValue;
    }

    public void a(com.bytedance.sdk.openadsdk.n.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f67820f = cVar;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 > 0) {
                this.f67816a = i2;
            }
            if (e.f67842c) {
                String str = "MaxPreloadSize: " + i2;
            }
        }
    }

    public synchronized void a(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            synchronized (this) {
            }
        }
    }

    public c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (c) invokeV.objValue;
    }

    public void a(boolean z, String str) {
        com.bytedance.sdk.openadsdk.n.b bVar;
        com.bytedance.sdk.openadsdk.n.b remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            this.m = str;
            this.n = z;
            if (e.f67842c) {
                String str2 = "setCurrentPlayKey, " + str;
            }
            HashSet hashSet = null;
            HashSet hashSet2 = null;
            if (str == null) {
                synchronized (this.f67823i) {
                    if (!this.f67823i.isEmpty()) {
                        hashSet2 = new HashSet(this.f67823i);
                        this.f67823i.clear();
                    }
                }
                if (hashSet2 != null) {
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        a(aVar.f67833a, aVar.f67834b, aVar.f67835c, aVar.f67836d, aVar.f67837e, aVar.f67838f);
                        if (e.f67842c) {
                            String str3 = "setCurrentPlayKey, resume preload: " + aVar.f67836d;
                        }
                    }
                    return;
                }
                return;
            }
            int i2 = e.f67847h;
            if (i2 != 3 && i2 != 2) {
                if (i2 == 1) {
                    synchronized (this.f67817b) {
                        Map<String, com.bytedance.sdk.openadsdk.n.b> map = this.f67817b.get(com.bytedance.sdk.openadsdk.n.b.b.a(z));
                        remove = map != null ? map.remove(str) : null;
                    }
                    if (remove != null) {
                        remove.a();
                        return;
                    }
                    return;
                }
                return;
            }
            synchronized (this.f67817b) {
                int size = this.f67817b.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Map<String, com.bytedance.sdk.openadsdk.n.b> map2 = this.f67817b.get(this.f67817b.keyAt(i3));
                    if (map2 != null) {
                        Collection<com.bytedance.sdk.openadsdk.n.b> values = map2.values();
                        if (values != null && !values.isEmpty()) {
                            if (hashSet == null) {
                                hashSet = new HashSet();
                            }
                            hashSet.addAll(values);
                        }
                        map2.clear();
                    }
                }
            }
            if (hashSet == null || hashSet.isEmpty()) {
                return;
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((com.bytedance.sdk.openadsdk.n.b) it2.next()).a();
                if (e.f67842c) {
                    String str4 = "setCurrentPlayKey, cancel preload: " + bVar.f67762g;
                }
            }
            if (i2 == 3) {
                synchronized (this.f67823i) {
                    Iterator it3 = hashSet.iterator();
                    while (it3.hasNext()) {
                        a aVar2 = (a) ((com.bytedance.sdk.openadsdk.n.b) it3.next()).n;
                        if (aVar2 != null) {
                            this.f67823i.add(aVar2);
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i2, String str, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, strArr}) == null) {
            a(z, z2, i2, str, null, strArr);
        }
    }

    public void a(boolean z, boolean z2, int i2, String str, Map<String, String> map, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, map, strArr}) == null) {
            boolean z3 = e.f67842c;
            com.bytedance.sdk.openadsdk.n.a.a aVar = z ? this.f67822h : this.f67821g;
            com.bytedance.sdk.openadsdk.n.b.c cVar = this.f67820f;
            if (aVar != null && cVar != null) {
                if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
                    return;
                }
                int i3 = i2 <= 0 ? this.f67816a : i2;
                String a2 = z2 ? str : com.bytedance.sdk.openadsdk.n.g.b.a(str);
                File d2 = aVar.d(a2);
                if (d2 != null && d2.length() >= i3) {
                    if (e.f67842c) {
                        String str2 = "no need preload, file size: " + d2.length() + ", need preload size: " + i3;
                        return;
                    }
                    return;
                } else if (f.a().a(com.bytedance.sdk.openadsdk.n.b.b.a(z), a2)) {
                    if (e.f67842c) {
                        String str3 = "has running proxy task, skip preload for key: " + str;
                        return;
                    }
                    return;
                } else {
                    synchronized (this.f67817b) {
                        Map<String, com.bytedance.sdk.openadsdk.n.b> map2 = this.f67817b.get(z ? 1 : 0);
                        if (map2.containsKey(a2)) {
                            return;
                        }
                        int i4 = i3;
                        a aVar2 = new a(z, z2, i3, str, map, strArr);
                        String str4 = this.m;
                        if (str4 != null) {
                            int i5 = e.f67847h;
                            if (i5 == 3) {
                                synchronized (this.f67823i) {
                                    this.f67823i.add(aVar2);
                                }
                                if (e.f67842c) {
                                    String str5 = "cancel preload: " + str + ", add to pending queue";
                                }
                                return;
                            } else if (i5 == 2) {
                                if (e.f67842c) {
                                    String str6 = "cancel preload: " + str;
                                }
                                return;
                            } else if (i5 == 1 && this.n == z && str4.equals(a2)) {
                                if (e.f67842c) {
                                    String str7 = "cancel preload: " + str + ", it is playing";
                                }
                                return;
                            }
                        }
                        ArrayList arrayList = null;
                        List<i.b> a3 = com.bytedance.sdk.openadsdk.n.g.d.a(com.bytedance.sdk.openadsdk.n.g.d.a(map));
                        if (a3 != null) {
                            arrayList = new ArrayList(a3.size());
                            int size = a3.size();
                            for (int i6 = 0; i6 < size; i6++) {
                                i.b bVar = a3.get(i6);
                                if (bVar != null) {
                                    arrayList.add(new i.b(bVar.f67936a, bVar.f67937b));
                                }
                            }
                        }
                        com.bytedance.sdk.openadsdk.n.b a4 = new b.a().a(aVar).a(cVar).a(str).b(a2).a(new l(com.bytedance.sdk.openadsdk.n.g.d.a(strArr))).a((List<i.b>) arrayList).a(i4).a(this.f67824j).a(aVar2).a();
                        map2.put(a2, a4);
                        this.f67819d.execute(a4);
                        return;
                    }
                }
            }
            boolean z4 = e.f67842c;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            a(false, false, str);
        }
    }

    public void a(boolean z, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.n.g.d.a(new com.bytedance.sdk.component.d.g(this, "cancel b b S", z, z2, str) { // from class: com.bytedance.sdk.openadsdk.n.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f67826a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f67827b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f67828c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ d f67829d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r8, Boolean.valueOf(z), Boolean.valueOf(z2), str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67829d = this;
                this.f67826a = z;
                this.f67827b = z2;
                this.f67828c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.n.b bVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.f67829d.f67817b) {
                        Map map = (Map) this.f67829d.f67817b.get(com.bytedance.sdk.openadsdk.n.b.b.a(this.f67826a));
                        if (map != null) {
                            bVar = (com.bytedance.sdk.openadsdk.n.b) map.remove(this.f67827b ? this.f67828c : com.bytedance.sdk.openadsdk.n.g.b.a(this.f67828c));
                        } else {
                            bVar = null;
                        }
                    }
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        });
    }

    public static ExecutorService a(b<Runnable> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            int a2 = com.bytedance.sdk.openadsdk.n.g.d.a();
            return new ThreadPoolExecutor(0, a2 < 1 ? 1 : a2 > 4 ? 4 : a2, 60L, TimeUnit.SECONDS, bVar, new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.n.d.4
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

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread thread = new Thread(this, runnable) { // from class: com.bytedance.sdk.openadsdk.n.d.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f67831a;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(runnable);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, runnable};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super((Runnable) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f67831a = this;
                            }

                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    try {
                                        Process.setThreadPriority(10);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                    super.run();
                                }
                            }
                        };
                        thread.setName("tt_pangle_thread_video_preload_" + thread.getId());
                        thread.setDaemon(true);
                        if (e.f67842c) {
                            String str = "new preload thead: " + thread.getName();
                        }
                        return thread;
                    }
                    return (Thread) invokeL2.objValue;
                }
            }, new RejectedExecutionHandler(bVar) { // from class: com.bytedance.sdk.openadsdk.n.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f67832a;

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
                    this.f67832a = bVar;
                }

                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
                        try {
                            this.f67832a.offerFirst(runnable);
                            boolean z = e.f67842c;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
        return (ExecutorService) invokeL.objValue;
    }
}
