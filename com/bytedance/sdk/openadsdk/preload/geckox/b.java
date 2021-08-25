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
    public final Context f68497a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f68498b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f68499c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.k.a f68500d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f68501e;

    /* renamed from: f  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.i.b f68502f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f68503g;

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f68504h;

    /* renamed from: i  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.geckox.a.a.a f68505i;

    /* renamed from: j  reason: collision with root package name */
    public final Long f68506j;
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
        public com.bytedance.sdk.openadsdk.preload.geckox.i.b f68509a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f68510b;

        /* renamed from: c  reason: collision with root package name */
        public List<String> f68511c;

        /* renamed from: d  reason: collision with root package name */
        public Context f68512d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f68513e;

        /* renamed from: f  reason: collision with root package name */
        public Executor f68514f;

        /* renamed from: g  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.k.a f68515g;

        /* renamed from: h  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a f68516h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f68517i;

        /* renamed from: j  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a f68518j;
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
            this.f68517i = true;
            this.f68512d = context.getApplicationContext();
        }

        public a a(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    this.f68511c = Arrays.asList(strArr);
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
                    this.f68510b = Arrays.asList(strArr);
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
                this.f68516h = aVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, executor)) == null) {
                this.f68514f = executor;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f68517i = z;
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
                this.f68513e = executor;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a a(com.bytedance.sdk.openadsdk.preload.geckox.a.a.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f68518j = aVar;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68497a : (Context) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.a.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68505i : (com.bytedance.sdk.openadsdk.preload.geckox.a.a.a) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public List<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68504h : (List) invokeV.objValue;
    }

    public List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f68503g : (List) invokeV.objValue;
    }

    public Executor f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68498b : (Executor) invokeV.objValue;
    }

    public Executor g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68499c : (Executor) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.i.b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f68502f : (com.bytedance.sdk.openadsdk.preload.geckox.i.b) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f68506j.longValue() : invokeV.longValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f68500d : (com.bytedance.sdk.openadsdk.preload.geckox.k.a) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f68501e : (com.bytedance.sdk.openadsdk.preload.geckox.statistic.a) invokeV.objValue;
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
        Context context = aVar.f68512d;
        this.f68497a = context;
        if (context != null) {
            this.f68503g = aVar.f68510b;
            this.f68504h = aVar.f68511c;
            this.f68500d = aVar.f68515g;
            this.f68505i = aVar.f68518j;
            this.f68506j = aVar.k;
            if (!TextUtils.isEmpty(aVar.l)) {
                this.k = aVar.l;
            } else {
                this.k = com.bytedance.sdk.openadsdk.preload.geckox.utils.a.a(this.f68497a);
            }
            this.l = aVar.m;
            this.n = aVar.p;
            this.o = aVar.q;
            if (aVar.o != null) {
                this.p = aVar.o;
            } else {
                this.p = new File(this.f68497a.getFilesDir(), "gecko_offline_res_x");
            }
            String str = aVar.n;
            this.m = str;
            if (!TextUtils.isEmpty(str)) {
                List<String> list = this.f68503g;
                if (list != null && !list.isEmpty()) {
                    if (this.f68506j != null) {
                        if (!TextUtils.isEmpty(this.l)) {
                            if (aVar.f68513e != null) {
                                this.f68498b = aVar.f68513e;
                            } else {
                                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ b f68507a;

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
                                        this.f68507a = this;
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
                                this.f68498b = threadPoolExecutor;
                            }
                            if (aVar.f68514f != null) {
                                this.f68499c = aVar.f68514f;
                            } else {
                                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory(this) { // from class: com.bytedance.sdk.openadsdk.preload.geckox.b.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ b f68508a;

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
                                        this.f68508a = this;
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
                                this.f68499c = threadPoolExecutor2;
                            }
                            if (aVar.f68509a != null) {
                                this.f68502f = aVar.f68509a;
                            } else {
                                this.f68502f = new com.bytedance.sdk.openadsdk.preload.geckox.i.a();
                            }
                            this.f68501e = aVar.f68516h;
                            this.q = aVar.f68517i;
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
