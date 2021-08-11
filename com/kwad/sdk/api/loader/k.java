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
        public c f70746a;

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
            this.f70746a = cVar;
        }

        @Override // com.kwad.sdk.api.loader.k.c
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.f70746a.a(th);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements f<a.C1968a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70747a;

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
            this.f70747a = str;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1968a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                try {
                    new com.kwad.sdk.api.loader.e(this.f70747a).a(new e.a(this, cVar) { // from class: com.kwad.sdk.api.loader.k.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f70748a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f70749b;

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
                            this.f70749b = this;
                            this.f70748a = cVar;
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(a.b bVar) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                                if (bVar == null || !bVar.a()) {
                                    this.f70748a.a((Throwable) new RuntimeException("UpdateData is illegal"));
                                } else {
                                    this.f70748a.a((c) bVar.f70718c);
                                }
                            }
                        }

                        @Override // com.kwad.sdk.api.loader.e.a
                        public void a(Exception exc) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                                this.f70748a.a((Throwable) exc);
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
    public static class d implements f<a.C1968a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1968a> f70750a;

        /* renamed from: b  reason: collision with root package name */
        public Context f70751b;

        public d(f<a.C1968a> fVar, Context context) {
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
            this.f70750a = fVar;
            this.f70751b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1968a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f70750a.a(new a<a.C1968a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f70752b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f70753c;

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
                        this.f70753c = this;
                        this.f70752b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1968a c1968a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1968a) == null) {
                            File a2 = com.kwad.sdk.api.loader.g.a(this.f70753c.f70751b, c1968a.f70714e);
                            IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                            if (ksAdSDKImpl != null) {
                                ksAdSDKImpl.reportBatchEvent(60, null);
                            }
                            com.kwad.sdk.api.loader.h.a(c1968a.f70711b, a2.getPath(), new h.a(this, c1968a, ksAdSDKImpl, System.currentTimeMillis(), a2) { // from class: com.kwad.sdk.api.loader.k.d.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ a.C1968a f70754a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ IKsAdSDK f70755b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ long f70756c;

                                /* renamed from: d  reason: collision with root package name */
                                public final /* synthetic */ File f70757d;

                                /* renamed from: e  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f70758e;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, c1968a, ksAdSDKImpl, Long.valueOf(r9), a2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f70758e = this;
                                    this.f70754a = c1968a;
                                    this.f70755b = ksAdSDKImpl;
                                    this.f70756c = r9;
                                    this.f70757d = a2;
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            com.kwad.sdk.api.loader.g.a(this.f70757d);
                                        } catch (Exception unused) {
                                        }
                                        if (this.f70755b != null) {
                                            long currentTimeMillis = System.currentTimeMillis() - this.f70756c;
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(currentTimeMillis));
                                            this.f70755b.reportBatchEvent(62, hashMap);
                                        }
                                        this.f70758e.f70752b.a((Throwable) new RuntimeException("Download failed."));
                                    }
                                }

                                @Override // com.kwad.sdk.api.loader.h.a
                                public void a(File file) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
                                        a.C1968a c1968a2 = this.f70754a;
                                        c1968a2.f70715f = file;
                                        this.f70758e.f70752b.a((c) c1968a2);
                                        if (this.f70755b != null) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put(ReportAction.KEY_DOWNLOAD_DURATION, Long.valueOf(System.currentTimeMillis() - this.f70756c));
                                            this.f70755b.reportBatchEvent(61, hashMap);
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
        public f<a.C1968a> f70759a;

        /* renamed from: b  reason: collision with root package name */
        public Context f70760b;

        public e(f<a.C1968a> fVar, Context context) {
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
            this.f70759a = fVar;
            this.f70760b = context;
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
                this.f70759a.a(new c<a.C1968a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f70761a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f70762b;

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
                        this.f70762b = this;
                        this.f70761a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1968a c1968a) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1968a) == null) {
                            try {
                                if (!this.f70762b.a(this.f70762b.f70760b)) {
                                    this.f70761a.a((Throwable) new RuntimeException("not main process"));
                                    return;
                                }
                                IKsAdSDK ksAdSDKImpl = Loader.get().getKsAdSDKImpl();
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(63, null);
                                }
                                if (!com.kwad.sdk.api.loader.b.a(this.f70762b.f70760b, c1968a.f70715f.getPath(), c1968a.f70714e)) {
                                    throw new RuntimeException("Apk pre install failed");
                                }
                                com.kwad.sdk.api.loader.f.a(this.f70762b.f70760b, com.kwad.sdk.api.loader.f.f70726a, c1968a.f70714e);
                                this.f70761a.a((c) Boolean.TRUE);
                                com.kwad.sdk.api.loader.g.a(c1968a.f70715f);
                                if (ksAdSDKImpl != null) {
                                    ksAdSDKImpl.reportBatchEvent(64, null);
                                }
                            } catch (Exception e2) {
                                this.f70761a.a((Throwable) e2);
                            }
                        }
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f70761a.a(th);
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
    public static class g implements f<a.C1968a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1968a> f70763a;

        /* renamed from: b  reason: collision with root package name */
        public Context f70764b;

        public g(f<a.C1968a> fVar, Context context) {
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
            this.f70763a = fVar;
            this.f70764b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1968a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f70763a.a(new a<a.C1968a>(this, cVar, cVar) { // from class: com.kwad.sdk.api.loader.k.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f70765b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ g f70766c;

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
                        this.f70766c = this;
                        this.f70765b = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1968a c1968a) {
                        File file;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1968a) == null) || c1968a == null || (file = c1968a.f70715f) == null) {
                            return;
                        }
                        SecurityChecker.a(file, c1968a, new SecurityChecker.a(this, c1968a) { // from class: com.kwad.sdk.api.loader.k.g.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a.C1968a f70767a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f70768b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c1968a};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f70768b = this;
                                this.f70767a = c1968a;
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(Exception exc) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, exc) == null) {
                                    this.f70768b.f70765b.a((Throwable) exc);
                                }
                            }

                            @Override // com.kwad.sdk.api.loader.SecurityChecker.a
                            public void a(boolean z, SecurityChecker.State state) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, state) == null) {
                                    if (z) {
                                        this.f70768b.f70765b.a((c) this.f70767a);
                                        return;
                                    }
                                    com.kwad.sdk.api.loader.g.a(this.f70767a.f70715f);
                                    c cVar2 = this.f70768b.f70765b;
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
    public static class h implements f<a.C1968a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public f<a.C1968a> f70769a;

        /* renamed from: b  reason: collision with root package name */
        public Context f70770b;

        public h(f<a.C1968a> fVar, Context context) {
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
            this.f70769a = fVar;
            this.f70770b = context;
        }

        @Override // com.kwad.sdk.api.loader.k.f
        public void a(c<a.C1968a> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f70769a.a(new c<a.C1968a>(this, cVar) { // from class: com.kwad.sdk.api.loader.k.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f70771a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ h f70772b;

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
                        this.f70772b = this;
                        this.f70771a = cVar;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(a.C1968a c1968a) {
                        c cVar2;
                        RuntimeException runtimeException;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, c1968a) == null) || c1968a == null) {
                            return;
                        }
                        q.a(this.f70772b.f70770b, "interval", c1968a.f70713d);
                        q.a(this.f70772b.f70770b, "lastUpdateTime", System.currentTimeMillis());
                        if (c1968a.b()) {
                            String a2 = Loader.get().a(this.f70772b.f70770b);
                            com.kwad.sdk.api.loader.f.a(this.f70772b.f70770b, com.kwad.sdk.api.loader.f.f70727b, "");
                            cVar2 = this.f70771a;
                            runtimeException = new RuntimeException("DynamicType == -1, curVersion: " + a2);
                        } else if (com.kwad.sdk.api.loader.f.a(c1968a.f70714e, Loader.get().a(this.f70772b.f70770b)) && c1968a.a()) {
                            this.f70771a.a((c) c1968a);
                            String str = "new Verson: " + c1968a.f70714e;
                            return;
                        } else {
                            cVar2 = this.f70771a;
                            runtimeException = new RuntimeException("No new sdkVersion. remote sdkVersion:" + c1968a.f70714e + " currentDynamicVersion:" + Loader.get().a(this.f70772b.f70770b) + " dynamicType:" + c1968a.f70710a);
                        }
                        cVar2.a((Throwable) runtimeException);
                    }

                    @Override // com.kwad.sdk.api.loader.k.c
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                            this.f70771a.a(th);
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
