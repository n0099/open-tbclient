package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.i;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class g<T> extends d<List<T>, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Executor f68238d;

    public g() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public final Object a_(b<T> bVar, List<T> list) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            CountDownLatch countDownLatch = new CountDownLatch(list.size());
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
            for (T t : list) {
                this.f68238d.execute(new Runnable(this, bVar, t, copyOnWriteArrayList, copyOnWriteArrayList2, countDownLatch) { // from class: com.bytedance.sdk.openadsdk.preload.b.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f68239a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Object f68240b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ List f68241c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ List f68242d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ CountDownLatch f68243e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ g f68244f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bVar, t, copyOnWriteArrayList, copyOnWriteArrayList2, countDownLatch};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f68244f = this;
                        this.f68239a = bVar;
                        this.f68240b = t;
                        this.f68241c = copyOnWriteArrayList;
                        this.f68242d = copyOnWriteArrayList2;
                        this.f68243e = countDownLatch;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                try {
                                    this.f68241c.add(this.f68239a.a((b) this.f68240b));
                                } catch (i.a e2) {
                                    Throwable cause = e2.getCause();
                                    this.f68242d.add(cause);
                                    this.f68244f.d(cause);
                                }
                                this.f68243e.countDown();
                            }
                        }
                    }
                });
            }
            countDownLatch.await();
            if (copyOnWriteArrayList2.isEmpty()) {
                return copyOnWriteArrayList;
            }
            throw new com.bytedance.sdk.openadsdk.preload.b.a.a(copyOnWriteArrayList2);
        }
        return invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            super.a(objArr);
            if (objArr != null) {
                if (objArr.length == 1) {
                    if (objArr[0] instanceof Executor) {
                        this.f68238d = (Executor) objArr[0];
                        return;
                    }
                    throw new IllegalArgumentException("ParallelInterceptor args must be instance of Executor");
                }
                throw new IllegalArgumentException("ParallelInterceptor only need one param");
            }
            this.f68238d = com.bytedance.sdk.openadsdk.preload.geckox.b.r();
        }
    }
}
