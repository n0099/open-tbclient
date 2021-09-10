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
        public c f71126a;

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
            this.f71126a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f71126a.a(th);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements f<a.C1972a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f71127a;

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
            this.f71127a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1972a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                try {
                    new com.kwad.sdk.api.loader.e(this.f71127a).a(new e.a(this, cVar) { // from class: com.kwad.sdk.api.loader.k.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f71128a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f71129b;

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
                            this.f71129b = this;
                            this.f71128a = cVar;
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(a.b bVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                                if (bVar == null || !bVar.a()) {
                                    this.f71128a.a((Throwable) new RuntimeException("UpdateData is illegal"));
                                } else {
                                    this.f71128a.a((c) bVar.f71098c);
                                }
                            }
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(Exception exc) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                                this.f71128a.a((Throwable) exc);
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
    public static class d implements f<a.C1972a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1972a> f71130a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71131b;

        public d(f<a.C1972a> fVar, Context context) {
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
            this.f71130a = fVar;
            this.f71131b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1972a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f71130a.a(new a<a.C1972a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f71132b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f71133c;

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
                        this.f71133c = this;
                        this.f71132b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1972a c1972a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1972a) == null) {
                            File a2 = com.kwad.sdk.api.loader.g.a(this.f71133c.f71131b, c1972a.f71094e);
                            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                            if (ksAdSDKImpl != null) {
                                ksAdSDKImpl.reportBatchEvent(60, null);
                            }
                            com.kwad.sdk.api.loader.h.a(c1972a.f71091b, a2.getPath(), new h.a(this, c1972a, ksAdSDKImpl, System.currentTimeMillis(), a2) { // from class: com.kwad.sdk.api.loader.k.d.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ a.C1972a f71134a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ IKsAdSDK f71135b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f71136c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ File f71137d;

                                /* renamed from: e  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f71138e;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, c1972a, ksAdSDKImpl, Long.valueOf(r9), a2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f71138e = this;
                                    this.f71134a = c1972a;
                                    this.f71135b = ksAdSDKImpl;
                                    this.f71136c = r9;
                                    this.f71137d = a2;
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            com.kwad.sdk.api.loader.g.a(this.f71137d);
                                        } catch (Exception unused) {
                                        }
                                        if (this.f71135b != null) {
                                            long currentTimeMillis = System.currentTimeMillis() - this.f71136c;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis));
                                            this.f71135b.reportBatchEvent(62, hashMap);
                                        }
                                        this.f71138e.f71132b.a((Throwable) new RuntimeException("Download failed."));
                                    }
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a(File file) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
                                        a.C1972a c1972a2 = this.f71134a;
                                        c1972a2.f71095f = file;
                                        this.f71138e.f71132b.a((c) c1972a2);
                                        if (this.f71135b != null) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(System.currentTimeMillis() - this.f71136c));
                                            this.f71135b.reportBatchEvent(61, hashMap);
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
        public f<a.C1972a> f71139a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71140b;

        public e(f<a.C1972a> fVar, Context context) {
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
            this.f71139a = fVar;
            this.f71140b = context;
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
                this.f71139a.a(new c<a.C1972a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f71141a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f71142b;

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
                        this.f71142b = this;
                        this.f71141a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1972a c1972a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1972a) == null) {
                            try {
                                if (!this.f71142b.a(this.f71142b.f71140b)) {
                                    this.f71141a.a((Throwable) new RuntimeException("not main process"));
                                    return;
                                }
                                IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(63, null);
                                }
                                if (!com.kwad.sdk.api.loader.b.a(this.f71142b.f71140b, c1972a.f71095f.getPath(), c1972a.f71094e)) {
                                    throw new RuntimeException("Apk pre install failed");
                                }
                                com.kwad.sdk.api.loader.f.a(this.f71142b.f71140b, com.kwad.sdk.api.loader.f.f71106a, c1972a.f71094e);
                                this.f71141a.a((c) Boolean.TRUE);
                                com.kwad.sdk.api.loader.g.a(c1972a.f71095f);
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(64, null);
                                }
                            } catch (Exception e2) {
                                this.f71141a.a((Throwable) e2);
                            }
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f71141a.a(th);
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
    public static class g implements f<a.C1972a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1972a> f71143a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71144b;

        public g(f<a.C1972a> fVar, Context context) {
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
            this.f71143a = fVar;
            this.f71144b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1972a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f71143a.a(new a<a.C1972a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f71145b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ g f71146c;

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
                        this.f71146c = this;
                        this.f71145b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1972a c1972a) {
                        File file;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1972a) == null) || c1972a == null || (file = c1972a.f71095f) == null) {
                            return;
                        }
                        SecurityChecker.a(file, c1972a, new SecurityChecker.a(this, c1972a) { // from class: com.kwad.sdk.api.loader.k.g.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a.C1972a f71147a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f71148b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c1972a};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f71148b = this;
                                this.f71147a = c1972a;
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(Exception exc) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, exc) == null) {
                                    this.f71148b.f71145b.a((Throwable) exc);
                                }
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(boolean z, SecurityChecker.State state) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, state) == null) {
                                    if (z) {
                                        this.f71148b.f71145b.a((c) this.f71147a);
                                        return;
                                    }
                                    com.kwad.sdk.api.loader.g.a(this.f71147a.f71095f);
                                    c cVar2 = this.f71148b.f71145b;
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
    public static class h implements f<a.C1972a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1972a> f71149a;

        /* renamed from: b  reason: collision with root package name */
        public Context f71150b;

        public h(f<a.C1972a> fVar, Context context) {
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
            this.f71149a = fVar;
            this.f71150b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1972a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f71149a.a(new c<a.C1972a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f71151a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ h f71152b;

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
                        this.f71152b = this;
                        this.f71151a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1972a c1972a) {
                        c cVar2;
                        RuntimeException runtimeException;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1972a) == null) || c1972a == null) {
                            return;
                        }
                        q.a(this.f71152b.f71150b, "interval", c1972a.f71093d);
                        q.a(this.f71152b.f71150b, "lastUpdateTime", System.currentTimeMillis());
                        if (c1972a.b()) {
                            String a2 = Loader.get().a(this.f71152b.f71150b);
                            com.kwad.sdk.api.loader.f.a(this.f71152b.f71150b, com.kwad.sdk.api.loader.f.f71107b, "");
                            cVar2 = this.f71151a;
                            runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                        } else if (com.kwad.sdk.api.loader.f.a(c1972a.f71094e, Loader.get().a(this.f71152b.f71150b)) && c1972a.a()) {
                            this.f71151a.a((c) c1972a);
                            String str = "new Verson: " + c1972a.f71094e;
                            return;
                        } else {
                            cVar2 = this.f71151a;
                            runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c1972a.f71094e + " currentDynamicVersion:" + Loader.get().a(this.f71152b.f71150b) + " dynamicType:" + c1972a.f71090a);
                        }
                        cVar2.a((Throwable) runtimeException);
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f71151a.a(th);
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
