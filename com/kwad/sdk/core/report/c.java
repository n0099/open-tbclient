package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class c<T extends d, R extends com.kwad.sdk.core.network.g> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static ExecutorService f36509e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f36510a;

    /* renamed from: b  reason: collision with root package name */
    public i f36511b;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f36512c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f36513d;

    /* renamed from: f  reason: collision with root package name */
    public Context f36514f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f36515g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f36516h;

    /* renamed from: i  reason: collision with root package name */
    public int f36517i;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f36532a;

        /* renamed from: b  reason: collision with root package name */
        public final i f36533b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f36534c;

        public a(c cVar, Context context, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36532a = cVar;
            this.f36534c = context;
            this.f36533b = iVar;
        }

        private void a(@NonNull List<T> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, list) == null) {
                List a2 = r.a(list, 200);
                int size = a2.size();
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                for (int i2 = 0; i2 < size; i2++) {
                    this.f36532a.a((List) a2.get(i2), atomicBoolean);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<T> b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f36532a.f36515g.get() > 0 || !com.ksad.download.d.b.a(this.f36534c) || (b2 = this.f36533b.b()) == null || b2.isEmpty()) {
                return;
            }
            a(b2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-615486434, "Lcom/kwad/sdk/core/report/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-615486434, "Lcom/kwad/sdk/core/report/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36510a = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
        this.f36511b = new j();
        this.f36512c = null;
        this.f36513d = null;
        this.f36515g = new AtomicInteger(0);
        this.f36516h = new AtomicInteger(0);
        this.f36517i = 5;
        if (f36509e == null) {
            f36509e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) || (handler = this.f36513d) == null) {
            return;
        }
        handler.removeMessages(16843025);
        Message obtain = Message.obtain(this.f36513d, new a(this, this.f36514f, this.f36511b));
        obtain.what = 16843025;
        this.f36513d.sendMessageDelayed(obtain, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = this.f36516h.get();
            if (i2 > 16) {
                i2 = 16;
            }
            return this.f36511b.a() >= ((long) (com.kwad.sdk.core.config.c.v() << i2));
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int andIncrement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (andIncrement = this.f36516h.getAndIncrement()) > this.f36517i) {
            return;
        }
        if (andIncrement > 0) {
            this.f36510a *= 2;
        }
        b(this.f36510a);
    }

    public abstract R a(List<T> list);

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b(0L);
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f36510a = j < 60 ? 60000L : j * 1000;
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f36514f = context;
            HandlerThread handlerThread = new HandlerThread(b());
            this.f36512c = handlerThread;
            handlerThread.start();
            this.f36513d = new Handler(this.f36512c.getLooper());
        }
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || t == null) {
            return;
        }
        new com.kwad.sdk.core.network.i<R, BatchReportResult>(this, t) { // from class: com.kwad.sdk.core.report.c.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f36527a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f36528b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, t};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36528b = this;
                this.f36527a = t;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public BatchReportResult b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                    JSONObject jSONObject = new JSONObject(str);
                    BatchReportResult batchReportResult = new BatchReportResult();
                    batchReportResult.parseJson(jSONObject);
                    return batchReportResult;
                }
                return (BatchReportResult) invokeL.objValue;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public R b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f36527a);
                    return (R) this.f36528b.a(arrayList);
                }
                return (R) invokeV.objValue;
            }
        }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>(this, t) { // from class: com.kwad.sdk.core.report.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f36529a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f36530b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, t};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36530b = this;
                this.f36529a = t;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.kwad.sdk.core.report.c */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull R r, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, r, i2, str) == null) {
                    this.f36530b.a((h) new h<T>(this) { // from class: com.kwad.sdk.core.report.c.6.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass6 f36531a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f36531a = this;
                        }

                        @Override // com.kwad.sdk.core.report.h
                        @NonNull
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable3 = $ic;
                            return (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) ? (T) this.f36531a.f36529a : (T) invokeV.objValue;
                        }
                    });
                }
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public /* bridge */ /* synthetic */ void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AnonymousClass6) gVar, (BatchReportResult) baseResultData);
            }

            public void a(@NonNull R r, @NonNull BatchReportResult batchReportResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, r, batchReportResult) == null) {
                    com.kwad.sdk.core.d.a.a("BaseBatchReporter", "立即上报 onSuccess action= " + this.f36529a + " result " + batchReportResult.getResult());
                }
            }
        });
    }

    public void a(@NonNull h<T> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hVar) == null) {
            f36509e.execute(new Runnable(this, hVar) { // from class: com.kwad.sdk.core.report.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f36518a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f36519b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36519b = this;
                    this.f36518a = hVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.f36519b.f36513d.hasMessages(16843025)) {
                            c cVar = this.f36519b;
                            cVar.b(cVar.f36510a);
                        }
                        this.f36519b.f36511b.a((i) this.f36518a.a());
                        if (this.f36519b.c()) {
                            this.f36519b.a();
                        }
                    }
                }
            });
        }
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            this.f36511b = iVar;
        }
    }

    public void a(List<T> list, AtomicBoolean atomicBoolean) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, atomicBoolean) == null) || list == null || list.size() <= 0) {
            return;
        }
        this.f36515g.getAndIncrement();
        new com.kwad.sdk.core.network.i<R, BatchReportResult>(this, list) { // from class: com.kwad.sdk.core.report.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f36520a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f36521b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36521b = this;
                this.f36520a = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public BatchReportResult b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                    JSONObject jSONObject = new JSONObject(str);
                    BatchReportResult batchReportResult = new BatchReportResult();
                    batchReportResult.parseJson(jSONObject);
                    return batchReportResult;
                }
                return (BatchReportResult) invokeL.objValue;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public R b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (R) this.f36521b.a(this.f36520a) : (R) invokeV.objValue;
            }
        }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>(this, list, atomicBoolean) { // from class: com.kwad.sdk.core.report.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f36522a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f36523b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f36524c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list, atomicBoolean};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36524c = this;
                this.f36522a = list;
                this.f36523b = atomicBoolean;
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull R r, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, r, i2, str) == null) {
                    this.f36523b.set(true);
                    if (this.f36524c.f36515g.decrementAndGet() == 0) {
                        this.f36524c.d();
                    }
                }
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public /* bridge */ /* synthetic */ void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AnonymousClass3) gVar, (BatchReportResult) baseResultData);
            }

            public void a(@NonNull R r, @NonNull BatchReportResult batchReportResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, r, batchReportResult) == null) {
                    this.f36524c.f36511b.a(this.f36522a);
                    if (this.f36524c.f36515g.decrementAndGet() == 0 && this.f36523b.get()) {
                        this.f36524c.d();
                    }
                    this.f36524c.a(batchReportResult.getInterval());
                    c cVar = this.f36524c;
                    cVar.b(cVar.f36510a);
                }
            }
        });
    }

    public abstract String b();

    public void b(@NonNull h<T> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            f36509e.execute(new Runnable(this, hVar) { // from class: com.kwad.sdk.core.report.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f36525a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f36526b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, hVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36526b = this;
                    this.f36525a = hVar;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.core.report.c */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36526b.a((c) this.f36525a.a());
                    }
                }
            });
        }
    }
}
