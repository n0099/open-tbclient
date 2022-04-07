package com.qq.e.comm.managers.plugin;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes5.dex */
public class PM {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, String> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;
    public final Context b;
    public String c;
    public File d;
    public int e;
    public DexClassLoader f;
    public RandomAccessFile g;
    public FileLock h;
    public boolean i;
    public final e j;
    public POFactory k;
    public int l;
    public Future<Boolean> m;
    public final f n;
    public f o;

    /* loaded from: classes5.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PM a;

        public a(PM pm) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                PM pm = this.a;
                pm.i = PM.a(pm);
                if (PM.b(this.a)) {
                    this.a.c();
                }
                this.a.l = (int) (System.currentTimeMillis() - currentTimeMillis);
                return Boolean.TRUE;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PM a;

        public b(PM pm) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends HashMap<Class<?>, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Executors.newSingleThreadExecutor();
        this.j = null;
        b bVar = new b(this);
        this.n = bVar;
        this.o = bVar;
        this.b = context.getApplicationContext();
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
                    File b2 = h.b(pm.b);
                    if (!b2.exists()) {
                        b2.createNewFile();
                        StringUtil.writeTo("lock", b2);
                    }
                    if (b2.exists()) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(b2, "rw");
                        pm.g = randomAccessFile;
                        FileLock tryLock = randomAccessFile.getChannel().tryLock();
                        pm.h = tryLock;
                        if (tryLock != null) {
                            pm.g.writeByte(37);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.i) {
                Context context = this.b;
                if (!com.qq.e.comm.managers.plugin.b.a(context, h.e(context), h.f(this.b))) {
                    GDTLogger.e("插件初始化失败 ");
                    com.qq.e.comm.managers.plugin.a.a(new Exception(), "initAssetPlugin failed");
                    return false;
                }
                this.c = Sig.ASSET_PLUGIN_SIG;
                this.d = h.e(this.b);
                this.e = Constants.PLUGIN.ASSET_PLUGIN_VERSION;
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
            File file = this.d;
            sb.append(file == null ? com.baidu.android.common.others.lang.StringUtil.NULL_STRING : file.getAbsolutePath());
            GDTLogger.d(sb.toString());
            if (this.c == null || this.d == null) {
                this.f = null;
                return;
            }
            try {
                this.f = new DexClassLoader(this.d.getAbsolutePath(), h.a(this.b).getAbsolutePath(), null, getClass().getClassLoader());
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
                if (pm.f == null && pm.d()) {
                    pm.c();
                }
            } catch (Exception e) {
                GDTLogger.e("插件更新失败: ", e);
                pm.a();
            }
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.i) {
                g gVar = new g(h.c(this.b), h.d(this.b));
                if (gVar.a()) {
                    boolean a2 = gVar.a(h.e(this.b), h.f(this.b));
                    GDTLogger.d("NextExist,Updated=" + a2);
                }
            }
            g gVar2 = new g(h.e(this.b), h.f(this.b));
            if (gVar2.a()) {
                if (gVar2.c() >= 1292 && gVar2.c() / 10 == 129) {
                    this.c = gVar2.b();
                    this.e = gVar2.c();
                    this.d = h.e(this.b);
                    return true;
                }
                GDTLogger.d("last updated plugin version =" + this.e + ";asset plugin version=" + Constants.PLUGIN.ASSET_PLUGIN_VERSION);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.m = this.a.submit(new a(this));
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
            ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? PM.class.getClassLoader() : this.f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.intValue;
    }

    public String getLocalSig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f();
            return this.c;
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
            return this.e;
        }
        return invokeV.intValue;
    }

    public void update(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && this.i) {
            com.qq.e.comm.managers.plugin.c cVar = new com.qq.e.comm.managers.plugin.c(this.b, this.a);
            cVar.a(this.o);
            cVar.a(str, str2);
        }
    }
}
