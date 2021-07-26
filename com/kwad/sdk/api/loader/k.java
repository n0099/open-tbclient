package com.kwad.sdk.api.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;
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
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static abstract class a<T> implements c<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f34018a;

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
            this.f34018a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f34018a.a(th);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements f<a.C0401a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f34019a;

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
            this.f34019a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C0401a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                try {
                    new com.kwad.sdk.api.loader.e(this.f34019a).a(new e.a(this, cVar) { // from class: com.kwad.sdk.api.loader.k.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f34020a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f34021b;

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
                            this.f34021b = this;
                            this.f34020a = cVar;
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(a.b bVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                                if (bVar == null || !bVar.a()) {
                                    this.f34020a.a((Throwable) new RuntimeException("UpdateData is illegal"));
                                } else {
                                    this.f34020a.a((c) bVar.f33990c);
                                }
                            }
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(Exception exc) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                                this.f34020a.a((Throwable) exc);
                            }
                        }
                    });
                } catch (Exception e2) {
                    cVar.a(e2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c<T> {
        void a(T t);

        void a(Throwable th);
    }

    /* loaded from: classes6.dex */
    public static class d implements f<a.C0401a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0401a> f34022a;

        /* renamed from: b  reason: collision with root package name */
        public Context f34023b;

        public d(f<a.C0401a> fVar, Context context) {
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
            this.f34022a = fVar;
            this.f34023b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C0401a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f34022a.a(new a<a.C0401a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f34024b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f34025c;

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
                        this.f34025c = this;
                        this.f34024b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C0401a c0401a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c0401a) == null) {
                            File a2 = com.kwad.sdk.api.loader.g.a(this.f34025c.f34023b, c0401a.f33986e);
                            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                            if (ksAdSDKImpl != null) {
                                ksAdSDKImpl.reportBatchEvent(60, null);
                            }
                            com.kwad.sdk.api.loader.h.a(c0401a.f33983b, a2.getPath(), new h.a(this, c0401a, ksAdSDKImpl, System.currentTimeMillis(), a2) { // from class: com.kwad.sdk.api.loader.k.d.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ a.C0401a f34026a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ IKsAdSDK f34027b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f34028c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ File f34029d;

                                /* renamed from: e  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f34030e;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, c0401a, ksAdSDKImpl, Long.valueOf(r9), a2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f34030e = this;
                                    this.f34026a = c0401a;
                                    this.f34027b = ksAdSDKImpl;
                                    this.f34028c = r9;
                                    this.f34029d = a2;
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            com.kwad.sdk.api.loader.g.a(this.f34029d);
                                        } catch (Exception unused) {
                                        }
                                        if (this.f34027b != null) {
                                            long currentTimeMillis = System.currentTimeMillis() - this.f34028c;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis));
                                            this.f34027b.reportBatchEvent(62, hashMap);
                                        }
                                        this.f34030e.f34024b.a((Throwable) new RuntimeException("Download failed."));
                                    }
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a(File file) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
                                        a.C0401a c0401a2 = this.f34026a;
                                        c0401a2.f33987f = file;
                                        this.f34030e.f34024b.a((c) c0401a2);
                                        if (this.f34027b != null) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(System.currentTimeMillis() - this.f34028c));
                                            this.f34027b.reportBatchEvent(61, hashMap);
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

    /* loaded from: classes6.dex */
    public static class e implements f<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0401a> f34031a;

        /* renamed from: b  reason: collision with root package name */
        public Context f34032b;

        public e(f<a.C0401a> fVar, Context context) {
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
            this.f34031a = fVar;
            this.f34032b = context;
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
                this.f34031a.a(new c<a.C0401a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f34033a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f34034b;

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
                        this.f34034b = this;
                        this.f34033a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C0401a c0401a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c0401a) == null) {
                            try {
                                if (!this.f34034b.a(this.f34034b.f34032b)) {
                                    this.f34033a.a((Throwable) new RuntimeException("not main process"));
                                    return;
                                }
                                IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(63, null);
                                }
                                if (!com.kwad.sdk.api.loader.b.a(this.f34034b.f34032b, c0401a.f33987f.getPath(), c0401a.f33986e)) {
                                    throw new RuntimeException("Apk pre install failed");
                                }
                                com.kwad.sdk.api.loader.f.a(this.f34034b.f34032b, com.kwad.sdk.api.loader.f.f33998a, c0401a.f33986e);
                                this.f34033a.a((c) Boolean.TRUE);
                                com.kwad.sdk.api.loader.g.a(c0401a.f33987f);
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(64, null);
                                }
                            } catch (Exception e2) {
                                this.f34033a.a((Throwable) e2);
                            }
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f34033a.a(th);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f<T> {
        void a(c<T> cVar);
    }

    /* loaded from: classes6.dex */
    public static class g implements f<a.C0401a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0401a> f34035a;

        /* renamed from: b  reason: collision with root package name */
        public Context f34036b;

        public g(f<a.C0401a> fVar, Context context) {
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
            this.f34035a = fVar;
            this.f34036b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C0401a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f34035a.a(new a<a.C0401a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f34037b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ g f34038c;

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
                        this.f34038c = this;
                        this.f34037b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C0401a c0401a) {
                        File file;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c0401a) == null) || c0401a == null || (file = c0401a.f33987f) == null) {
                            return;
                        }
                        SecurityChecker.a(file, c0401a, new SecurityChecker.a(this, c0401a) { // from class: com.kwad.sdk.api.loader.k.g.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a.C0401a f34039a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f34040b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c0401a};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f34040b = this;
                                this.f34039a = c0401a;
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(Exception exc) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, exc) == null) {
                                    this.f34040b.f34037b.a((Throwable) exc);
                                }
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(boolean z, SecurityChecker.State state) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, state) == null) {
                                    if (z) {
                                        this.f34040b.f34037b.a((c) this.f34039a);
                                        return;
                                    }
                                    com.kwad.sdk.api.loader.g.a(this.f34039a.f33987f);
                                    c cVar2 = this.f34040b.f34037b;
                                    cVar2.a((Throwable) new RuntimeException("Security check failed. state = " + state));
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements f<a.C0401a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C0401a> f34041a;

        /* renamed from: b  reason: collision with root package name */
        public Context f34042b;

        public h(f<a.C0401a> fVar, Context context) {
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
            this.f34041a = fVar;
            this.f34042b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C0401a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f34041a.a(new c<a.C0401a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f34043a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ h f34044b;

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
                        this.f34044b = this;
                        this.f34043a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C0401a c0401a) {
                        c cVar2;
                        RuntimeException runtimeException;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c0401a) == null) || c0401a == null) {
                            return;
                        }
                        q.a(this.f34044b.f34042b, "interval", c0401a.f33985d);
                        q.a(this.f34044b.f34042b, "lastUpdateTime", System.currentTimeMillis());
                        if (c0401a.b()) {
                            String a2 = Loader.get().a(this.f34044b.f34042b);
                            com.kwad.sdk.api.loader.f.a(this.f34044b.f34042b, com.kwad.sdk.api.loader.f.f33999b, "");
                            cVar2 = this.f34043a;
                            runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                        } else if (com.kwad.sdk.api.loader.f.a(c0401a.f33986e, Loader.get().a(this.f34044b.f34042b)) && c0401a.a()) {
                            this.f34043a.a((c) c0401a);
                            Log.w("maple", "new Verson: " + c0401a.f33986e);
                            return;
                        } else {
                            cVar2 = this.f34043a;
                            runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c0401a.f33986e + " currentDynamicVersion:" + Loader.get().a(this.f34044b.f34042b) + " dynamicType:" + c0401a.f33982a);
                        }
                        cVar2.a((Throwable) runtimeException);
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f34043a.a(th);
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
