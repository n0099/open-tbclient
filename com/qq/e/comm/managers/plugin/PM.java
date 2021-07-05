package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes7.dex */
public class PM {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, String> o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f40953a;
    public String abc;

    /* renamed from: b  reason: collision with root package name */
    public final Context f40954b;

    /* renamed from: c  reason: collision with root package name */
    public String f40955c;

    /* renamed from: d  reason: collision with root package name */
    public File f40956d;

    /* renamed from: e  reason: collision with root package name */
    public int f40957e;

    /* renamed from: f  reason: collision with root package name */
    public DexClassLoader f40958f;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f40959g;

    /* renamed from: h  reason: collision with root package name */
    public FileLock f40960h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f40961i;
    public a.InterfaceC0517a j;
    public POFactory k;
    public int l;
    public Future<Boolean> m;
    public a.b n;

    /* loaded from: classes7.dex */
    public interface a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public interface InterfaceC0517a {
            void onLoadFail();

            void onLoadSuccess();
        }

        /* loaded from: classes7.dex */
        public interface b {
            void a();

            void b();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408867239, "Lcom/qq/e/comm/managers/plugin/PM;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408867239, "Lcom/qq/e/comm/managers/plugin/PM;");
                return;
            }
        }
        o = new HashMap<Class<?>, String>() { // from class: com.qq.e.comm.managers.plugin.PM.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
            }
        };
    }

    public PM(Context context, a.InterfaceC0517a interfaceC0517a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, interfaceC0517a};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40953a = Executors.newSingleThreadExecutor();
        this.abc = "";
        this.n = new a.b(this) { // from class: com.qq.e.comm.managers.plugin.PM.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public /* synthetic */ PM f40963a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f40963a = this;
            }

            @Override // com.qq.e.comm.managers.plugin.PM.a.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    PM.d(this.f40963a);
                }
            }

            @Override // com.qq.e.comm.managers.plugin.PM.a.b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f40963a.e();
                }
            }
        };
        this.f40954b = context.getApplicationContext();
        this.j = interfaceC0517a;
        this.m = this.f40953a.submit(new Callable<Boolean>(this) { // from class: com.qq.e.comm.managers.plugin.PM.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public /* synthetic */ PM f40962a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f40962a = this;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Boolean call() throws Exception {
                long currentTimeMillis = System.currentTimeMillis();
                PM pm = this.f40962a;
                pm.f40961i = pm.d();
                if (this.f40962a.b()) {
                    this.f40962a.a();
                }
                this.f40962a.l = (int) (System.currentTimeMillis() - currentTimeMillis);
                return Boolean.TRUE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            StringBuilder sb = new StringBuilder("PluginFile:\t");
            File file = this.f40956d;
            sb.append(file == null ? StringUtil.NULL_STRING : file.getAbsolutePath());
            GDTLogger.d(sb.toString());
            if (this.f40955c == null || this.f40956d == null) {
                this.f40958f = null;
                return;
            }
            try {
                this.f40958f = new DexClassLoader(this.f40956d.getAbsolutePath(), d.a(this.f40954b).getAbsolutePath(), null, getClass().getClassLoader());
                if (this.j != null) {
                    this.j.onLoadSuccess();
                }
            } catch (Throwable th) {
                GDTLogger.e("exception while init plugin class loader", th);
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
        if (r2 == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        InterceptResult invokeV;
        StringBuilder sb;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            boolean z2 = false;
            try {
                GDTLogger.d("TimeStap_BEFORE_PLUGIN_INIT:" + System.currentTimeMillis());
                if (!c()) {
                    if (this.f40961i) {
                        if (com.qq.e.comm.managers.plugin.a.a(this.f40954b, d.b(this.f40954b), d.e(this.f40954b))) {
                            this.f40955c = Sig.ASSET_PLUGIN_SIG;
                            this.f40956d = d.b(this.f40954b);
                            this.f40957e = Constants.PLUGIN.ASSET_PLUGIN_VERSION;
                            z = true;
                        } else {
                            GDTLogger.e("Fail to prepair Defult plugin ");
                        }
                    }
                    z = false;
                }
                z2 = true;
                sb = new StringBuilder("TimeStap_AFTER_PLUGIN_INIT:");
            } catch (Throwable th) {
                try {
                    GDTLogger.report("Exception while init plugin manager", th);
                    sb = new StringBuilder("TimeStap_AFTER_PLUGIN_INIT:");
                } catch (Throwable th2) {
                    GDTLogger.d("TimeStap_AFTER_PLUGIN_INIT:" + System.currentTimeMillis());
                    throw th2;
                }
            }
            sb.append(System.currentTimeMillis());
            GDTLogger.d(sb.toString());
            return z2;
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.f40961i) {
                com.qq.e.comm.managers.plugin.a aVar = new com.qq.e.comm.managers.plugin.a(d.d(this.f40954b), d.g(this.f40954b));
                if (aVar.a()) {
                    boolean a2 = aVar.a(d.b(this.f40954b), d.e(this.f40954b));
                    GDTLogger.d("NextExist,Updated=" + a2);
                }
            }
            com.qq.e.comm.managers.plugin.a aVar2 = new com.qq.e.comm.managers.plugin.a(d.b(this.f40954b), d.e(this.f40954b));
            if (aVar2.a()) {
                if (aVar2.b() >= 1232 && aVar2.b() / 10 == 123) {
                    this.f40955c = aVar2.c();
                    this.f40957e = aVar2.b();
                    this.f40956d = d.b(this.f40954b);
                    int i2 = this.f40957e;
                    if (i2 >= 2000 || i2 <= 0) {
                        this.abc = aVar2.f40964a;
                        return true;
                    }
                    return true;
                }
                GDTLogger.d("last updated plugin version =" + this.f40957e + ";asset plugin version=1232");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ void d(PM pm) {
        try {
            if (pm.f40958f == null && pm.c()) {
                pm.a();
            }
        } catch (Exception e2) {
            GDTLogger.report("Exception while init online plugin: ", e2);
            pm.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                File h2 = d.h(this.f40954b);
                if (!h2.exists()) {
                    h2.createNewFile();
                    com.qq.e.comm.util.StringUtil.writeTo("lock", h2);
                }
                if (h2.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(h2, "rw");
                    this.f40959g = randomAccessFile;
                    FileLock tryLock = randomAccessFile.getChannel().tryLock();
                    this.f40960h = tryLock;
                    if (tryLock != null) {
                        this.f40959g.writeByte(37);
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        a.InterfaceC0517a interfaceC0517a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (interfaceC0517a = this.j) == null) {
            return;
        }
        interfaceC0517a.onLoadFail();
    }

    private void f() {
        Future<Boolean> future;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (future = this.m) == null) {
            return;
        }
        try {
            future.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public <T> T getFactory(Class<T> cls) throws c {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            f();
            GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
            ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f40958f;
            StringBuilder sb = new StringBuilder("PluginClassLoader is parent");
            sb.append(PM.class.getClassLoader() == classLoader);
            GDTLogger.d(sb.toString());
            if (classLoader == null) {
                throw new c("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
            }
            try {
                String str = o.get(cls);
                if (com.qq.e.comm.util.StringUtil.isEmpty(str)) {
                    throw new c("factory  implemention name is not specified for interface:" + cls.getName());
                }
                Class<?> loadClass = classLoader.loadClass(str);
                T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
                GDTLogger.d("ServiceDelegateFactory =" + cast);
                return cast;
            } catch (Throwable th) {
                throw new c("Fail to getfactory implement instance for interface:" + cls.getName(), th);
            }
        }
        return (T) invokeL.objValue;
    }

    public int getInitCostTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.intValue;
    }

    public String getLocalSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f();
            return this.f40955c;
        }
        return (String) invokeV.objValue;
    }

    public POFactory getPOFactory() throws c {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.k == null) {
                this.k = (POFactory) getFactory(POFactory.class);
            }
            return this.k;
        }
        return (POFactory) invokeV.objValue;
    }

    public int getPluginVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            f();
            return this.f40957e;
        }
        return invokeV.intValue;
    }

    public void update(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && this.f40961i) {
            b bVar = new b(this.f40954b, this.f40953a);
            bVar.a(this.n);
            bVar.a(str, str2);
        }
    }
}
