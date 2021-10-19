package com.bytedance.sdk.openadsdk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static ThreadPoolExecutor r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f69023a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f69024b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f69025c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.k.a f69026d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f69027e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.i.b f69028f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f69029g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f69030h;

    /* renamed from: i  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.a.a.a f69031i;

    /* renamed from: j  reason: collision with root package name */
    public final Long f69032j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final File p;
    public final boolean q;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.i.b f69035a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f69036b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f69037c;

        /* renamed from: d  reason: collision with root package name */
        public Context f69038d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f69039e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f69040f;

        /* renamed from: g  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.k.a f69041g;

        /* renamed from: h  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f69042h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f69043i;

        /* renamed from: j  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a f69044j;
        public Long k;
        public String l;
        public String m;
        public String n;
        public File o;
        public String p;
        public String q;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69043i = true;
            this.f69038d = context.getApplicationContext();
        }

        public a a(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    this.f69037c = Arrays.asList(strArr);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    this.f69036b = Arrays.asList(strArr);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
                this.n = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.statistic.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                this.f69042h = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, executor)) == null) {
                this.f69040f = executor;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f69043i = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.m = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, executor)) == null) {
                this.f69039e = executor;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.a.a.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f69044j = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
                this.k = Long.valueOf(j2);
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.l = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, file)) == null) {
                this.o = file;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(this) : (b) invokeV.objValue;
        }
    }

    public static ThreadPoolExecutor r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (r == null) {
                synchronized (b.class) {
                    if (r == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        r = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                }
            }
            return r;
        }
        return (ThreadPoolExecutor) invokeV.objValue;
    }

    public Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69023a : (Context) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69031i : (com.bytedance.sdk.openadsdk.preload.geckox.a.a.a) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public List<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69030h : (List) invokeV.objValue;
    }

    public List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69029g : (List) invokeV.objValue;
    }

    public Executor f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f69024b : (Executor) invokeV.objValue;
    }

    public Executor g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69025c : (Executor) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.i.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f69028f : (com.bytedance.sdk.openadsdk.preload.geckox.i.b) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f69032j.longValue() : invokeV.longValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (File) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.k.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f69026d : (com.bytedance.sdk.openadsdk.preload.geckox.k.a) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f69027e : (com.bytedance.sdk.openadsdk.preload.geckox.statistic.a) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context context = aVar.f69038d;
        this.f69023a = context;
        if (context != null) {
            this.f69029g = aVar.f69036b;
            this.f69030h = aVar.f69037c;
            this.f69026d = aVar.f69041g;
            this.f69031i = aVar.f69044j;
            this.f69032j = aVar.k;
            if (!TextUtils.isEmpty(aVar.l)) {
                this.k = aVar.l;
            } else {
                this.k = com.bytedance.sdk.openadsdk.preload.geckox.utils.a.a(this.f69023a);
            }
            this.l = aVar.m;
            this.n = aVar.p;
            this.o = aVar.q;
            if (aVar.o != null) {
                this.p = aVar.o;
            } else {
                this.p = new File(this.f69023a.getFilesDir(), "gecko_offline_res_x");
            }
            String str = aVar.n;
            this.m = str;
            if (!TextUtils.isEmpty(str)) {
                List<String> list = this.f69029g;
                if (list != null && !list.isEmpty()) {
                    if (this.f69032j != null) {
                        if (!TextUtils.isEmpty(this.l)) {
                            if (aVar.f69039e != null) {
                                this.f69024b = aVar.f69039e;
                            } else {
                                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ b f69033a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                            newInitContext2.initArgs = r2;
                                            Object[] objArr2 = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext2);
                                            int i4 = newInitContext2.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext2.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext2);
                                                return;
                                            }
                                        }
                                        this.f69033a = this;
                                    }

                                    @Override // java.util.concurrent.ThreadFactory
                                    public Thread newThread(Runnable runnable) {
                                        InterceptResult invokeL;
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                                            Thread thread = new Thread(runnable);
                                            thread.setName("tt_pangle_thread_gecko_update");
                                            thread.setPriority(3);
                                            return thread;
                                        }
                                        return (Thread) invokeL.objValue;
                                    }
                                });
                                threadPoolExecutor.allowCoreThreadTimeOut(true);
                                this.f69024b = threadPoolExecutor;
                            }
                            if (aVar.f69040f != null) {
                                this.f69025c = aVar.f69040f;
                            } else {
                                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ b f69034a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                            newInitContext2.initArgs = r2;
                                            Object[] objArr2 = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext2);
                                            int i4 = newInitContext2.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext2.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext2);
                                                return;
                                            }
                                        }
                                        this.f69034a = this;
                                    }

                                    @Override // java.util.concurrent.ThreadFactory
                                    public Thread newThread(Runnable runnable) {
                                        InterceptResult invokeL;
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                                            Thread thread = new Thread(runnable);
                                            thread.setName("tt_pangle_thread_gecko_check_update");
                                            thread.setPriority(3);
                                            return thread;
                                        }
                                        return (Thread) invokeL.objValue;
                                    }
                                });
                                threadPoolExecutor2.allowCoreThreadTimeOut(true);
                                this.f69025c = threadPoolExecutor2;
                            }
                            if (aVar.f69035a != null) {
                                this.f69028f = aVar.f69035a;
                            } else {
                                this.f69028f = new com.bytedance.sdk.openadsdk.preload.geckox.i.a();
                            }
                            this.f69027e = aVar.f69042h;
                            this.q = aVar.f69043i;
                            return;
                        }
                        throw new IllegalArgumentException("deviceId key empty");
                    }
                    throw new IllegalArgumentException("appId == null");
                }
                throw new IllegalArgumentException("access key empty");
            }
            throw new IllegalArgumentException("host == null");
        }
        throw new IllegalArgumentException("context == null");
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, threadPoolExecutor) == null) {
            r = threadPoolExecutor;
        }
    }
}
