package com.kwad.a;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.a.b;
import com.kwad.a.kwai.f;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<String> a;

    /* renamed from: b  reason: collision with root package name */
    public final b.InterfaceC2092b f55377b;

    /* renamed from: c  reason: collision with root package name */
    public final b.a f55378c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55379d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55380e;

    /* renamed from: f  reason: collision with root package name */
    public b.d f55381f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c() {
        this(new d(), new a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((b.InterfaceC2092b) objArr[0], (b.a) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(b.InterfaceC2092b interfaceC2092b, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC2092b, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashSet();
        if (interfaceC2092b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f55377b = interfaceC2092b;
        this.f55378c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, context, str, str2) == null) {
            if (this.a.contains(str) && !this.f55379d) {
                a("%s already loaded previously!", str);
                return;
            }
            try {
                this.f55377b.a(str);
                this.a.add(str);
                a("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e2) {
                a("Loading the library normally failed: %s", Log.getStackTraceString(e2));
                a("%s (%s) was not loaded normally, re-linking...", str, str2);
                File a = a(context, str, str2);
                if (!a.exists() || this.f55379d) {
                    if (this.f55379d) {
                        a("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    b(context, str, str2);
                    this.f55378c.a(context, this.f55377b.a(), this.f55377b.c(str), a, this);
                }
                try {
                    if (this.f55380e) {
                        f fVar = null;
                        try {
                            f fVar2 = new f(a);
                            try {
                                List<String> b2 = fVar2.b();
                                fVar2.close();
                                for (String str3 : b2) {
                                    a(context, this.f55377b.d(str3));
                                }
                            } catch (Throwable th) {
                                th = th;
                                fVar = fVar2;
                                fVar.close();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException unused) {
                }
                this.f55377b.b(a.getAbsolutePath());
                this.a.add(str);
                a("%s (%s) was re-linked!", str, str2);
            }
        }
    }

    public File a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? context.getDir("lib", 0) : (File) invokeL.objValue;
    }

    public File a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2)) == null) {
            String c2 = this.f55377b.c(str);
            if (e.a(str2)) {
                return new File(a(context), c2);
            }
            File a = a(context);
            return new File(a, c2 + "" + str2);
        }
        return (File) invokeLLL.objValue;
    }

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            a(context, str, (String) null, (b.c) null);
        }
    }

    public void a(Context context, String str, String str2, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, str2, cVar) == null) {
            if (context == null) {
                throw new IllegalArgumentException("Given context is null");
            }
            if (e.a(str)) {
                throw new IllegalArgumentException("Given library is either null or empty");
            }
            a("Beginning load of %s...", str);
            if (cVar == null) {
                c(context, str, str2);
            } else {
                new Thread(new Runnable(this, context, str, str2, cVar) { // from class: com.kwad.a.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f55382b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f55383c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ b.c f55384d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ c f55385e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, context, str, str2, cVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f55385e = this;
                        this.a = context;
                        this.f55382b = str;
                        this.f55383c = str2;
                        this.f55384d = cVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f55385e.c(this.a, this.f55382b, this.f55383c);
                                this.f55384d.a(this.f55382b);
                            } catch (Exception | UnsatisfiedLinkError e2) {
                                this.f55384d.a(this.f55382b, e2);
                            }
                        }
                    }
                }).start();
            }
        }
    }

    public void a(String str) {
        b.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (dVar = this.f55381f) == null) {
            return;
        }
        dVar.a(str);
    }

    public void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, objArr) == null) {
            a(String.format(Locale.US, str, objArr));
        }
    }

    public void b(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, str, str2) == null) {
            File a = a(context);
            File a2 = a(context, str, str2);
            File[] listFiles = a.listFiles(new FilenameFilter(this, this.f55377b.c(str)) { // from class: com.kwad.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f55386b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f55386b = this;
                    this.a = r7;
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, str3)) == null) ? str3.startsWith(this.a) : invokeLL.booleanValue;
                }
            });
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (this.f55379d || !file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }
}
