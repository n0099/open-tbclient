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
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static abstract class a<T> implements c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f63958a;

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
            this.f63958a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f63958a.a(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements f<a.C1887a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f63959a;

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
            this.f63959a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1887a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                try {
                    new com.kwad.sdk.api.loader.e(this.f63959a).a(new e.a(this, cVar) { // from class: com.kwad.sdk.api.loader.k.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f63960a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f63961b;

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
                            this.f63961b = this;
                            this.f63960a = cVar;
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(a.b bVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                                if (bVar == null || !bVar.a()) {
                                    this.f63960a.a((Throwable) new RuntimeException("UpdateData is illegal"));
                                } else {
                                    this.f63960a.a((c) bVar.f63930c);
                                }
                            }
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(Exception exc) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                                this.f63960a.a((Throwable) exc);
                            }
                        }
                    });
                } catch (Exception e2) {
                    cVar.a(e2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c<T> {
        void a(T t);

        void a(Throwable th);
    }

    /* loaded from: classes2.dex */
    public static class d implements f<a.C1887a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1887a> f63962a;

        /* renamed from: b  reason: collision with root package name */
        public Context f63963b;

        public d(f<a.C1887a> fVar, Context context) {
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
            this.f63962a = fVar;
            this.f63963b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1887a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f63962a.a(new a<a.C1887a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f63964b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f63965c;

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
                        this.f63965c = this;
                        this.f63964b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1887a c1887a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1887a) == null) {
                            File a2 = com.kwad.sdk.api.loader.g.a(this.f63965c.f63963b, c1887a.f63926e);
                            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                            if (ksAdSDKImpl != null) {
                                ksAdSDKImpl.reportBatchEvent(60, null);
                            }
                            com.kwad.sdk.api.loader.h.a(c1887a.f63923b, a2.getPath(), new h.a(this, c1887a, ksAdSDKImpl, System.currentTimeMillis(), a2) { // from class: com.kwad.sdk.api.loader.k.d.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ a.C1887a f63966a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ IKsAdSDK f63967b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f63968c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ File f63969d;

                                /* renamed from: e  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f63970e;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, c1887a, ksAdSDKImpl, Long.valueOf(r9), a2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f63970e = this;
                                    this.f63966a = c1887a;
                                    this.f63967b = ksAdSDKImpl;
                                    this.f63968c = r9;
                                    this.f63969d = a2;
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            com.kwad.sdk.api.loader.g.a(this.f63969d);
                                        } catch (Exception unused) {
                                        }
                                        if (this.f63967b != null) {
                                            long currentTimeMillis = System.currentTimeMillis() - this.f63968c;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis));
                                            this.f63967b.reportBatchEvent(62, hashMap);
                                        }
                                        this.f63970e.f63964b.a((Throwable) new RuntimeException("Download failed."));
                                    }
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a(File file) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
                                        a.C1887a c1887a2 = this.f63966a;
                                        c1887a2.f63927f = file;
                                        this.f63970e.f63964b.a((c) c1887a2);
                                        if (this.f63967b != null) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(System.currentTimeMillis() - this.f63968c));
                                            this.f63967b.reportBatchEvent(61, hashMap);
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

    /* loaded from: classes2.dex */
    public static class e implements f<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1887a> f63971a;

        /* renamed from: b  reason: collision with root package name */
        public Context f63972b;

        public e(f<a.C1887a> fVar, Context context) {
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
            this.f63971a = fVar;
            this.f63972b = context;
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
                this.f63971a.a(new c<a.C1887a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f63973a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f63974b;

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
                        this.f63974b = this;
                        this.f63973a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1887a c1887a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1887a) == null) {
                            try {
                                if (!this.f63974b.a(this.f63974b.f63972b)) {
                                    this.f63973a.a((Throwable) new RuntimeException("not main process"));
                                    return;
                                }
                                IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(63, null);
                                }
                                if (!com.kwad.sdk.api.loader.b.a(this.f63974b.f63972b, c1887a.f63927f.getPath(), c1887a.f63926e)) {
                                    throw new RuntimeException("Apk pre install failed");
                                }
                                com.kwad.sdk.api.loader.f.a(this.f63974b.f63972b, com.kwad.sdk.api.loader.f.f63938a, c1887a.f63926e);
                                this.f63973a.a((c) Boolean.TRUE);
                                com.kwad.sdk.api.loader.g.a(c1887a.f63927f);
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(64, null);
                                }
                            } catch (Exception e2) {
                                this.f63973a.a((Throwable) e2);
                            }
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f63973a.a(th);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* loaded from: classes2.dex */
    public static class g implements f<a.C1887a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1887a> f63975a;

        /* renamed from: b  reason: collision with root package name */
        public Context f63976b;

        public g(f<a.C1887a> fVar, Context context) {
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
            this.f63975a = fVar;
            this.f63976b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1887a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f63975a.a(new a<a.C1887a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f63977b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ g f63978c;

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
                        this.f63978c = this;
                        this.f63977b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1887a c1887a) {
                        File file;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1887a) == null) || c1887a == null || (file = c1887a.f63927f) == null) {
                            return;
                        }
                        SecurityChecker.a(file, c1887a, new SecurityChecker.a(this, c1887a) { // from class: com.kwad.sdk.api.loader.k.g.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a.C1887a f63979a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f63980b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c1887a};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f63980b = this;
                                this.f63979a = c1887a;
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(Exception exc) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, exc) == null) {
                                    this.f63980b.f63977b.a((Throwable) exc);
                                }
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(boolean z, SecurityChecker.State state) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, state) == null) {
                                    if (z) {
                                        this.f63980b.f63977b.a((c) this.f63979a);
                                        return;
                                    }
                                    com.kwad.sdk.api.loader.g.a(this.f63979a.f63927f);
                                    c cVar2 = this.f63980b.f63977b;
                                    cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h implements f<a.C1887a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1887a> f63981a;

        /* renamed from: b  reason: collision with root package name */
        public Context f63982b;

        public h(f<a.C1887a> fVar, Context context) {
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
            this.f63981a = fVar;
            this.f63982b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1887a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f63981a.a(new c<a.C1887a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f63983a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ h f63984b;

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
                        this.f63984b = this;
                        this.f63983a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1887a c1887a) {
                        c cVar2;
                        RuntimeException runtimeException;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1887a) == null) || c1887a == null) {
                            return;
                        }
                        q.a(this.f63984b.f63982b, "interval", c1887a.f63925d);
                        q.a(this.f63984b.f63982b, "lastUpdateTime", System.currentTimeMillis());
                        if (c1887a.b()) {
                            String a2 = Loader.get().a(this.f63984b.f63982b);
                            com.kwad.sdk.api.loader.f.a(this.f63984b.f63982b, com.kwad.sdk.api.loader.f.f63939b, "");
                            cVar2 = this.f63983a;
                            runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                        } else if (com.kwad.sdk.api.loader.f.a(c1887a.f63926e, Loader.get().a(this.f63984b.f63982b)) && c1887a.a()) {
                            this.f63983a.a((c) c1887a);
                            String str = "new Verson: " + c1887a.f63926e;
                            return;
                        } else {
                            cVar2 = this.f63983a;
                            runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c1887a.f63926e + " currentDynamicVersion:" + Loader.get().a(this.f63984b.f63982b) + " dynamicType:" + c1887a.f63922a);
                        }
                        cVar2.a((Throwable) runtimeException);
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f63983a.a(th);
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
