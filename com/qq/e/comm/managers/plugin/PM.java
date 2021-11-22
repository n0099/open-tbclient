package com.qq.e.comm.managers.plugin;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
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
/* loaded from: classes2.dex */
public class PM {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, String> p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f68902a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f68903b;

    /* renamed from: c  reason: collision with root package name */
    public String f68904c;

    /* renamed from: d  reason: collision with root package name */
    public File f68905d;

    /* renamed from: e  reason: collision with root package name */
    public int f68906e;

    /* renamed from: f  reason: collision with root package name */
    public DexClassLoader f68907f;

    /* renamed from: g  reason: collision with root package name */
    public RandomAccessFile f68908g;

    /* renamed from: h  reason: collision with root package name */
    public FileLock f68909h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68910i;
    public final e j;
    public POFactory k;
    public int l;
    public Future<Boolean> m;
    public final f n;
    public f o;

    /* loaded from: classes2.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PM f68911a;

        public a(PM pm) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68911a = pm;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                PM pm = this.f68911a;
                pm.f68910i = PM.a(pm);
                if (PM.b(this.f68911a)) {
                    this.f68911a.c();
                }
                this.f68911a.l = (int) (System.currentTimeMillis() - currentTimeMillis);
                return Boolean.TRUE;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PM f68912a;

        public b(PM pm) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68912a = pm;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends HashMap<Class<?>, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
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
        p = new c();
    }

    public PM(Context context, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68902a = Executors.newSingleThreadExecutor();
        this.j = null;
        b bVar = new b(this);
        this.n = bVar;
        this.o = bVar;
        this.f68903b = context.getApplicationContext();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (eVar = this.j) == null) {
            return;
        }
        eVar.onLoadFail();
    }

    public static boolean a(PM pm) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, pm)) == null) {
            if (pm != null) {
                try {
                    File b2 = h.b(pm.f68903b);
                    if (!b2.exists()) {
                        b2.createNewFile();
                        StringUtil.writeTo("lock", b2);
                    }
                    if (b2.exists()) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(b2, "rw");
                        pm.f68908g = randomAccessFile;
                        FileLock tryLock = randomAccessFile.getChannel().tryLock();
                        pm.f68909h = tryLock;
                        if (tryLock != null) {
                            pm.f68908g.writeByte(37);
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                }
                return false;
            }
            throw null;
        }
        return invokeL.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (this.f68910i) {
                Context context = this.f68903b;
                if (!com.qq.e.comm.managers.plugin.b.a(context, h.e(context), h.f(this.f68903b))) {
                    GDTLogger.e("插件初始化失败 ");
                    com.qq.e.comm.managers.plugin.a.a(new Exception(), "initAssetPlugin failed");
                    return false;
                }
                this.f68904c = Sig.ASSET_PLUGIN_SIG;
                this.f68905d = h.e(this.f68903b);
                this.f68906e = 1280;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        if (r5.b() != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(PM pm) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pm)) == null) {
            if (pm != null) {
                boolean z = false;
                try {
                    GDTLogger.d("TimeStap_BEFORE_PLUGIN_INIT:" + System.currentTimeMillis());
                    if (!pm.d()) {
                    }
                    z = true;
                    sb = new StringBuilder();
                } catch (Throwable th) {
                    try {
                        GDTLogger.e("插件加载出现异常", th);
                        com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                        sb = new StringBuilder();
                    } catch (Throwable th2) {
                        GDTLogger.d("TimeStap_AFTER_PLUGIN_INIT:" + System.currentTimeMillis());
                        throw th2;
                    }
                }
                sb.append("TimeStap_AFTER_PLUGIN_INIT:");
                sb.append(System.currentTimeMillis());
                GDTLogger.d(sb.toString());
                return z;
            }
            throw null;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("PluginFile:\t");
            File file = this.f68905d;
            sb.append(file == null ? com.baidu.android.common.others.lang.StringUtil.NULL_STRING : file.getAbsolutePath());
            GDTLogger.d(sb.toString());
            if (this.f68904c == null || this.f68905d == null) {
                this.f68907f = null;
                return;
            }
            try {
                this.f68907f = new DexClassLoader(this.f68905d.getAbsolutePath(), h.a(this.f68903b).getAbsolutePath(), null, getClass().getClassLoader());
                e eVar = this.j;
                if (eVar != null) {
                    eVar.onLoadSuccess();
                }
            } catch (Throwable th) {
                GDTLogger.e("插件ClassLoader构造发生异常", th);
                a();
                com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            }
        }
    }

    public static void d(PM pm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, pm) == null) {
            if (pm == null) {
                throw null;
            }
            try {
                if (pm.f68907f == null && pm.d()) {
                    pm.c();
                }
            } catch (Exception e2) {
                GDTLogger.e("插件更新失败: ", e2);
                pm.a();
            }
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.f68910i) {
                g gVar = new g(h.c(this.f68903b), h.d(this.f68903b));
                if (gVar.a()) {
                    boolean a2 = gVar.a(h.e(this.f68903b), h.f(this.f68903b));
                    GDTLogger.d("NextExist,Updated=" + a2);
                }
            }
            g gVar2 = new g(h.e(this.f68903b), h.f(this.f68903b));
            if (gVar2.a()) {
                if (gVar2.c() >= 1280 && gVar2.c() / 10 == 128) {
                    this.f68904c = gVar2.b();
                    this.f68906e = gVar2.c();
                    this.f68905d = h.e(this.f68903b);
                    return true;
                }
                GDTLogger.d("last updated plugin version =" + this.f68906e + ";asset plugin version=1280");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.m = this.f68902a.submit(new a(this));
        }
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

    public <T> T getFactory(Class<T> cls) throws d {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            f();
            GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
            ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f68907f;
            StringBuilder sb = new StringBuilder();
            sb.append("PluginClassLoader is parent");
            sb.append(PM.class.getClassLoader() == classLoader);
            GDTLogger.d(sb.toString());
            if (classLoader == null) {
                throw new d("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
            }
            try {
                String str = p.get(cls);
                if (StringUtil.isEmpty(str)) {
                    throw new d("factory  implemention name is not specified for interface:" + cls.getName());
                }
                Class<?> loadClass = classLoader.loadClass(str);
                T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
                GDTLogger.d("ServiceDelegateFactory =" + cast);
                return cast;
            } catch (Throwable th) {
                throw new d("Fail to getfactory implement instance for interface:" + cls.getName(), th);
            }
        }
        return (T) invokeL.objValue;
    }

    public int getInitCostTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.intValue;
    }

    public String getLocalSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f();
            return this.f68904c;
        }
        return (String) invokeV.objValue;
    }

    public POFactory getPOFactory() throws d {
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
            return this.f68906e;
        }
        return invokeV.intValue;
    }

    public void update(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && this.f68910i) {
            com.qq.e.comm.managers.plugin.c cVar = new com.qq.e.comm.managers.plugin.c(this.f68903b, this.f68902a);
            cVar.a(this.o);
            cVar.a(str, str2);
        }
    }
}
