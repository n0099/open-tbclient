package ms.bd.c;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import ms.bd.c.n;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f73108a;

    /* renamed from: b  reason: collision with root package name */
    public final n.b f73109b;

    /* renamed from: c  reason: collision with root package name */
    public final n.a f73110c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73111d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f73112e;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f73113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f73114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f73115g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f73116h;

        public a(o oVar, Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, context, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73116h = oVar;
            this.f73113e = context;
            this.f73114f = str;
            this.f73115g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f73116h.g(this.f73113e, this.f73114f, this.f73115g);
                    throw null;
                } catch (UnsatisfiedLinkError unused) {
                    throw null;
                } catch (m unused2) {
                    throw null;
                }
            }
        }
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        q qVar = new q();
        l lVar = new l();
        this.f73108a = new HashSet();
        this.f73109b = qVar;
        this.f73110c = lVar;
    }

    public File a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? context.getDir("lib", 0) : (File) invokeL.objValue;
    }

    public File b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2)) == null) {
            String d2 = ((q) this.f73109b).d(str);
            if (n.b(str2)) {
                return new File(a(context), d2);
            }
            File a2 = a(context);
            return new File(a2, d2 + "." + str2);
        }
        return (File) invokeLLL.objValue;
    }

    public void c(Context context, String str, String str2, n.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2, cVar) == null) {
            if (context == null) {
                throw new IllegalArgumentException("Given context is null");
            }
            if (n.b(str)) {
                throw new IllegalArgumentException("Given library is either null or empty");
            }
            String.format(Locale.US, "Beginning load of %s...", str);
            if (cVar == null) {
                g(context, str, str2);
            } else {
                new Thread(new a(this, context, str, str2)).start();
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, objArr) == null) {
            String.format(Locale.US, str, objArr);
        }
    }

    public final void g(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, str, str2) == null) {
            if (this.f73108a.contains(str) && !this.f73111d) {
                String.format(Locale.US, "%s already loaded previously!", str);
                return;
            }
            try {
                ((q) this.f73109b).a(str);
                this.f73108a.add(str);
                String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e2) {
                String.format(Locale.US, "Loading the library normally failed: %s", Log.getStackTraceString(e2));
                String.format(Locale.US, "%s (%s) was not loaded normally, re-linking...", str, str2);
                File b2 = b(context, str, str2);
                if (!b2.exists() || this.f73111d) {
                    if (this.f73111d) {
                        String.format(Locale.US, "Forcing a re-link of %s (%s)...", str, str2);
                    }
                    File a2 = a(context);
                    File b3 = b(context, str, str2);
                    File[] listFiles = a2.listFiles(new p(this, ((q) this.f73109b).d(str)));
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            if (this.f73111d || !file.getAbsolutePath().equals(b3.getAbsolutePath())) {
                                file.delete();
                            }
                        }
                    }
                    ((l) this.f73110c).b(context, ((q) this.f73109b).b(), ((q) this.f73109b).d(str), b2, this);
                }
                try {
                    if (this.f73112e) {
                        w wVar = null;
                        try {
                            w wVar2 = new w(b2);
                            try {
                                List<String> g2 = wVar2.g();
                                wVar2.close();
                                for (String str3 : g2) {
                                    c(context, ((q) this.f73109b).e(str3), null, null);
                                }
                            } catch (Throwable th) {
                                th = th;
                                wVar = wVar2;
                                wVar.close();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException unused) {
                }
                ((q) this.f73109b).c(b2.getAbsolutePath());
                this.f73108a.add(str);
                String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
            }
        }
    }
}
