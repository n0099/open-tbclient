package com.kwad.sdk.api.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.SecurityChecker;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.e;
import com.kwad.sdk.api.loader.h;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static abstract class a<T> implements c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f71480a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71480a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f71480a.a(th);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements f<a.C1978a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f71481a;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71481a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1978a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                try {
                    new com.kwad.sdk.api.loader.e(this.f71481a).a(new e.a(this, cVar) { // from class: com.kwad.sdk.api.loader.k.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f71482a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f71483b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f71483b = this;
                            this.f71482a = cVar;
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(a.b bVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                                if (bVar == null || !bVar.a()) {
                                    this.f71482a.a((Throwable) new RuntimeException("UpdateData is illegal"));
                                } else {
                                    this.f71482a.a((c) bVar.f71452c);
                                }
                            }
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(Exception exc) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                                this.f71482a.a((Throwable) exc);
                            }
                        }
                    });
                } catch (Exception e2) {
                    cVar.a(e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface c<T> {
        void a(T t);

        void a(Throwable th);
    }

    /* loaded from: classes10.dex */
    public static class d implements f<a.C1978a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1978a> f71484a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71485b;

        public d(f<a.C1978a> fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71484a = fVar;
            this.f71485b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1978a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f71484a.a(new a<a.C1978a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f71486b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f71487c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(cVar);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((c) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f71487c = this;
                        this.f71486b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1978a c1978a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1978a) == null) {
                            File a2 = com.kwad.sdk.api.loader.g.a(this.f71487c.f71485b, c1978a.f71448e);
                            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                            if (ksAdSDKImpl != null) {
                                ksAdSDKImpl.reportBatchEvent(60, null);
                            }
                            com.kwad.sdk.api.loader.h.a(c1978a.f71445b, a2.getPath(), new h.a(this, c1978a, ksAdSDKImpl, System.currentTimeMillis(), a2) { // from class: com.kwad.sdk.api.loader.k.d.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ a.C1978a f71488a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ IKsAdSDK f71489b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f71490c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ File f71491d;

                                /* renamed from: e  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f71492e;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, c1978a, ksAdSDKImpl, Long.valueOf(r9), a2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f71492e = this;
                                    this.f71488a = c1978a;
                                    this.f71489b = ksAdSDKImpl;
                                    this.f71490c = r9;
                                    this.f71491d = a2;
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            com.kwad.sdk.api.loader.g.a(this.f71491d);
                                        } catch (Exception unused) {
                                        }
                                        if (this.f71489b != null) {
                                            long currentTimeMillis = System.currentTimeMillis() - this.f71490c;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis));
                                            this.f71489b.reportBatchEvent(62, hashMap);
                                        }
                                        this.f71492e.f71486b.a((Throwable) new RuntimeException("Download failed."));
                                    }
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a(File file) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
                                        a.C1978a c1978a2 = this.f71488a;
                                        c1978a2.f71449f = file;
                                        this.f71492e.f71486b.a((c) c1978a2);
                                        if (this.f71489b != null) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(System.currentTimeMillis() - this.f71490c));
                                            this.f71489b.reportBatchEvent(61, hashMap);
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements f<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1978a> f71493a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71494b;

        public e(f<a.C1978a> fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71493a = fVar;
            this.f71494b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, context)) == null) ? context.getApplicationContext().getPackageName().equals(b(context)) : invokeL.booleanValue;
        }

        private String b(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
                int myPid = Process.myPid();
                String str = "";
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        str = runningAppProcessInfo.processName;
                    }
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<Boolean> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f71493a.a(new c<a.C1978a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f71495a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f71496b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f71496b = this;
                        this.f71495a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1978a c1978a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1978a) == null) {
                            try {
                                if (!this.f71496b.a(this.f71496b.f71494b)) {
                                    this.f71495a.a((Throwable) new RuntimeException("not main process"));
                                    return;
                                }
                                IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(63, null);
                                }
                                if (!com.kwad.sdk.api.loader.b.a(this.f71496b.f71494b, c1978a.f71449f.getPath(), c1978a.f71448e)) {
                                    throw new RuntimeException("Apk pre install failed");
                                }
                                com.kwad.sdk.api.loader.f.a(this.f71496b.f71494b, com.kwad.sdk.api.loader.f.f71460a, c1978a.f71448e);
                                this.f71495a.a((c) Boolean.TRUE);
                                com.kwad.sdk.api.loader.g.a(c1978a.f71449f);
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(64, null);
                                }
                            } catch (Exception e2) {
                                this.f71495a.a((Throwable) e2);
                            }
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f71495a.a(th);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* loaded from: classes10.dex */
    public static class g implements f<a.C1978a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1978a> f71497a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71498b;

        public g(f<a.C1978a> fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71497a = fVar;
            this.f71498b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1978a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f71497a.a(new a<a.C1978a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f71499b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ g f71500c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(cVar);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((c) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f71500c = this;
                        this.f71499b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1978a c1978a) {
                        File file;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1978a) == null) || c1978a == null || (file = c1978a.f71449f) == null) {
                            return;
                        }
                        SecurityChecker.a(file, c1978a, new SecurityChecker.a(this, c1978a) { // from class: com.kwad.sdk.api.loader.k.g.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a.C1978a f71501a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f71502b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c1978a};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f71502b = this;
                                this.f71501a = c1978a;
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(Exception exc) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, exc) == null) {
                                    this.f71502b.f71499b.a((Throwable) exc);
                                }
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(boolean z, SecurityChecker.State state) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, state) == null) {
                                    if (z) {
                                        this.f71502b.f71499b.a((c) this.f71501a);
                                        return;
                                    }
                                    com.kwad.sdk.api.loader.g.a(this.f71501a.f71449f);
                                    c cVar2 = this.f71502b.f71499b;
                                    cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class h implements f<a.C1978a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1978a> f71503a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71504b;

        public h(f<a.C1978a> fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71503a = fVar;
            this.f71504b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1978a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f71503a.a(new c<a.C1978a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f71505a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ h f71506b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f71506b = this;
                        this.f71505a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1978a c1978a) {
                        c cVar2;
                        RuntimeException runtimeException;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1978a) == null) || c1978a == null) {
                            return;
                        }
                        q.a(this.f71506b.f71504b, "interval", c1978a.f71447d);
                        q.a(this.f71506b.f71504b, "lastUpdateTime", System.currentTimeMillis());
                        if (c1978a.b()) {
                            String a2 = Loader.get().a(this.f71506b.f71504b);
                            com.kwad.sdk.api.loader.f.a(this.f71506b.f71504b, com.kwad.sdk.api.loader.f.f71461b, "");
                            cVar2 = this.f71505a;
                            runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                        } else if (com.kwad.sdk.api.loader.f.a(c1978a.f71448e, Loader.get().a(this.f71506b.f71504b)) && c1978a.a()) {
                            this.f71505a.a((c) c1978a);
                            String str = "new Verson: " + c1978a.f71448e;
                            return;
                        } else {
                            cVar2 = this.f71505a;
                            runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c1978a.f71448e + " currentDynamicVersion:" + Loader.get().a(this.f71506b.f71504b) + " dynamicType:" + c1978a.f71444a);
                        }
                        cVar2.a((Throwable) runtimeException);
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f71505a.a(th);
                        }
                    }
                });
            }
        }
    }

    public static f<Boolean> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Context context = Loader.get().getContext();
            return new e(new g(new d(new h(new b(str), context), context), context), context);
        }
        return (f) invokeL.objValue;
    }
}
