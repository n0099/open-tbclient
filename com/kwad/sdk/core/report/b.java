package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.kwad.sdk.core.report.c;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.utils.u;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class b<T extends c, R extends com.kwad.sdk.core.network.g> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile Handler f72171c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f72172d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f72173a;

    /* renamed from: b  reason: collision with root package name */
    public h f72174b;

    /* renamed from: e  reason: collision with root package name */
    public Context f72175e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f72176f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f72177g;

    /* renamed from: h  reason: collision with root package name */
    public int f72178h;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f72193a;

        /* renamed from: b  reason: collision with root package name */
        public final h f72194b;

        /* renamed from: c  reason: collision with root package name */
        public final Context f72195c;

        public a(b bVar, Context context, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72193a = bVar;
            this.f72195c = context;
            this.f72194b = hVar;
        }

        private void a(@NonNull List<T> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, list) == null) {
                List a2 = u.a(list, 200);
                int size = a2.size();
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                for (int i2 = 0; i2 < size; i2++) {
                    this.f72193a.a((List) a2.get(i2), atomicBoolean);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<T> b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72193a.f72176f.get() > 0 || !com.ksad.download.d.b.a(this.f72195c) || (b2 = this.f72194b.b()) == null || b2.isEmpty()) {
                return;
            }
            a(b2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-615486465, "Lcom/kwad/sdk/core/report/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-615486465, "Lcom/kwad/sdk/core/report/b;");
        }
    }

    public b() {
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
        this.f72173a = AppConfig.TIMESTAMP_AVAILABLE_DURATION;
        this.f72174b = new i();
        this.f72176f = new AtomicInteger(0);
        this.f72177g = new AtomicInteger(0);
        this.f72178h = 5;
        if (f72172d == null) {
            f72172d = com.kwad.sdk.core.i.b.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, this, j2) == null) {
            synchronized (this) {
                if (f72171c == null) {
                    return;
                }
                f72171c.removeMessages(16843025);
                Message obtain = Message.obtain(f72171c, new a(this, this.f72175e, this.f72174b));
                obtain.what = 16843025;
                f72171c.sendMessageDelayed(obtain, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = this.f72177g.get();
            if (i2 > 16) {
                i2 = 16;
            }
            return this.f72174b.a() >= ((long) (com.kwad.sdk.core.config.c.m() << i2));
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int andIncrement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (andIncrement = this.f72177g.getAndIncrement()) > this.f72178h) {
            return;
        }
        if (andIncrement > 0) {
            this.f72173a *= 2;
        }
        b(this.f72173a);
    }

    public abstract R a(List<T> list);

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b(0L);
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f72173a = j2 < 60 ? 60000L : j2 * 1000;
        }
    }

    public synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                this.f72175e = context;
                if (f72171c == null) {
                    f72171c = com.kwad.sdk.core.i.a.b();
                }
            }
        }
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || t == null) {
            return;
        }
        new com.kwad.sdk.core.network.i<R, BatchReportResult>(this, t) { // from class: com.kwad.sdk.core.report.b.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f72188a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f72189b;

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
                this.f72189b = this;
                this.f72188a = t;
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
                    arrayList.add(this.f72188a);
                    return (R) this.f72189b.a(arrayList);
                }
                return (R) invokeV.objValue;
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean c() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }
        }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>(this, t) { // from class: com.kwad.sdk.core.report.b.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f72190a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f72191b;

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
                this.f72191b = this;
                this.f72190a = t;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.kwad.sdk.core.report.b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull R r, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, r, i2, str) == null) {
                    this.f72191b.a((g) new g<T>(this) { // from class: com.kwad.sdk.core.report.b.6.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass6 f72192a;

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
                            this.f72192a = this;
                        }

                        @Override // com.kwad.sdk.core.report.g
                        @NonNull
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable3 = $ic;
                            return (interceptable3 == null || (invokeV = interceptable3.invokeV(1048576, this)) == null) ? (T) this.f72192a.f72190a : (T) invokeV.objValue;
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
                    com.kwad.sdk.core.d.a.a("BaseBatchReporter", "立即上报 onSuccess action= " + this.f72190a + " result " + batchReportResult.getResult());
                }
            }
        });
    }

    public void a(@NonNull g<T> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            f72172d.execute(new Runnable(this, gVar) { // from class: com.kwad.sdk.core.report.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f72179a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f72180b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, gVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72180b = this;
                    this.f72179a = gVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (b.f72171c != null && !b.f72171c.hasMessages(16843025)) {
                            b bVar = this.f72180b;
                            bVar.b(bVar.f72173a);
                        }
                        this.f72180b.f72174b.a((h) this.f72179a.a());
                        if (this.f72180b.c()) {
                            this.f72180b.a();
                        }
                    }
                }
            });
        }
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            this.f72174b = hVar;
        }
    }

    public void a(List<T> list, AtomicBoolean atomicBoolean) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, atomicBoolean) == null) || list == null || list.size() <= 0) {
            return;
        }
        this.f72176f.getAndIncrement();
        new com.kwad.sdk.core.network.i<R, BatchReportResult>(this, list) { // from class: com.kwad.sdk.core.report.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f72181a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f72182b;

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
                this.f72182b = this;
                this.f72181a = list;
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (R) this.f72182b.a(this.f72181a) : (R) invokeV.objValue;
            }

            @Override // com.kwad.sdk.core.network.i
            public boolean c() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }
        }.a(new com.kwad.sdk.core.network.j<R, BatchReportResult>(this, list, atomicBoolean) { // from class: com.kwad.sdk.core.report.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f72183a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AtomicBoolean f72184b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f72185c;

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
                this.f72185c = this;
                this.f72183a = list;
                this.f72184b = atomicBoolean;
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull R r, int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, r, i2, str) == null) {
                    this.f72184b.set(true);
                    if (this.f72185c.f72176f.decrementAndGet() == 0) {
                        this.f72185c.d();
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
                    this.f72185c.f72174b.a(this.f72183a);
                    if (this.f72185c.f72176f.decrementAndGet() == 0 && this.f72184b.get()) {
                        this.f72185c.d();
                    }
                    this.f72185c.a(batchReportResult.getInterval());
                    b bVar = this.f72185c;
                    bVar.b(bVar.f72173a);
                }
            }
        });
    }

    public void b(@NonNull g<T> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            f72172d.execute(new Runnable(this, gVar) { // from class: com.kwad.sdk.core.report.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f72186a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f72187b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, gVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72187b = this;
                    this.f72186a = gVar;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.kwad.sdk.core.report.b */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f72187b.a((b) this.f72186a.a());
                    }
                }
            });
        }
    }
}
