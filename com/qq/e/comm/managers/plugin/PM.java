package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PM {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, String> q;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;
    public final Context b;
    public String c;
    public File d;
    public volatile int e;
    public DexClassLoader f;
    public RandomAccessFile g;
    public FileLock h;
    public boolean i;
    public final f j;
    public volatile POFactory k;
    public int l;
    public Future<Boolean> m;
    public boolean n;
    public boolean o;
    public String p;

    /* loaded from: classes10.dex */
    public static class b extends HashMap<Class<?>, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        q = new b();
    }

    public PM(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fVar};
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
        this.n = false;
        this.b = context.getApplicationContext();
        this.j = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        d();
    }

    private JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                int pluginVersion = getPluginVersion();
                if (pluginVersion > 10000) {
                    jSONObject.put("vas", this.p);
                }
                jSONObject.put("pv", pluginVersion);
                jSONObject.put(FunAdSdk.PLATFORM_SIG, this.c);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, com.qq.e.comm.managers.b.b().a());
                jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.b));
                jSONObject.put("ict", this.l);
                jSONObject.put("mup", this.i);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.i) {
                try {
                    com.qq.e.comm.managers.plugin.b.a(this.b, h.e(this.b), h.f(this.b));
                    this.c = Sig.ASSET_PLUGIN_SIG;
                    this.d = h.e(this.b);
                    this.e = SDKStatus.getBuildInPluginVersion();
                    return true;
                } catch (Throwable th) {
                    GDTLogger.e("插件初始化失败 ");
                    com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.o) {
                return false;
            }
            if (this.i) {
                g gVar = new g(h.c(this.b), h.d(this.b));
                if (gVar.a()) {
                    boolean a2 = gVar.a(h.e(this.b), h.f(this.b));
                    GDTLogger.d("NextExist,Updated=" + a2);
                }
            }
            g gVar2 = new g(h.e(this.b), h.f(this.b));
            if (gVar2.a()) {
                if (gVar2.c() >= SDKStatus.getBuildInPluginVersion()) {
                    this.c = gVar2.b();
                    this.e = gVar2.c();
                    this.d = h.e(this.b);
                    this.p = gVar2.d();
                    this.n = true;
                    return true;
                }
                GDTLogger.d("last updated plugin version =" + this.e + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public POFactory getPOFactory() throws e {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.k == null) {
                synchronized (this) {
                    if (this.k == null) {
                        try {
                            this.k = (POFactory) getFactory(POFactory.class);
                        } catch (e e) {
                            if (!this.n) {
                                throw e;
                            }
                            GDTLogger.e("插件加载错误，回退到内置版本");
                            this.o = true;
                            d();
                            this.k = (POFactory) getFactory(POFactory.class);
                        }
                    }
                }
            }
            return this.k;
        }
        return (POFactory) invokeV.objValue;
    }

    public boolean tryLockUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                File b2 = h.b(this.b);
                if (!b2.exists()) {
                    b2.createNewFile();
                    h.a("lock", b2);
                }
                if (b2.exists()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(b2, "rw");
                    this.g = randomAccessFile;
                    FileLock tryLock = randomAccessFile.getChannel().tryLock();
                    this.h = tryLock;
                    if (tryLock != null) {
                        this.g.writeByte(37);
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

    /* loaded from: classes10.dex */
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
                if (!this.a.i) {
                    PM pm = this.a;
                    pm.i = pm.tryLockUpdate();
                }
                if (PM.b(this.a)) {
                    PM.c(this.a);
                }
                this.a.l = (int) (System.currentTimeMillis() - currentTimeMillis);
                return Boolean.TRUE;
            }
            return invokeV.objValue;
        }
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
                    if (!pm.c()) {
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

    public static void c(PM pm) {
        String absolutePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, pm) == null) {
            if (pm != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("PluginFile:\t");
                File file = pm.d;
                if (file == null) {
                    absolutePath = StringUtil.NULL_STRING;
                } else {
                    absolutePath = file.getAbsolutePath();
                }
                sb.append(absolutePath);
                GDTLogger.d(sb.toString());
                if (pm.c != null && pm.d != null) {
                    try {
                        pm.f = new DexClassLoader(pm.d.getAbsolutePath(), h.a(pm.b).getAbsolutePath(), null, pm.getClass().getClassLoader());
                        f fVar = pm.j;
                        if (fVar != null) {
                            fVar.a();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        GDTLogger.e("插件ClassLoader构造发生异常", th);
                        f fVar2 = pm.j;
                        if (fVar2 != null) {
                            fVar2.b();
                        }
                        com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                        return;
                    }
                }
                pm.f = null;
                return;
            }
            throw null;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.n = false;
            SharedPreferences sharedPreferences = this.b.getSharedPreferences("start_crash", 0);
            if (sharedPreferences.getInt("crash_count", 0) >= 2) {
                this.o = true;
                sharedPreferences.edit().remove("crash_count").commit();
                GDTLogger.e("加载本地插件");
            }
            this.m = this.a.submit(new a(this));
        }
    }

    public <T> T getFactory(Class<T> cls) throws e {
        InterceptResult invokeL;
        ClassLoader classLoader;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            Future<Boolean> future = this.m;
            if (future != null) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
            GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
            if (Sig.ASSET_PLUGIN_SIG == null) {
                classLoader = PM.class.getClassLoader();
            } else {
                classLoader = this.f;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("PluginClassLoader is parent");
            if (PM.class.getClassLoader() == classLoader) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            GDTLogger.d(sb.toString());
            if (classLoader != null) {
                try {
                    String str = q.get(cls);
                    if (!TextUtils.isEmpty(str)) {
                        Class<?> loadClass = classLoader.loadClass(str);
                        T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.b, a()));
                        GDTLogger.d("ServiceDelegateFactory =" + cast);
                        return cast;
                    }
                    throw new e("factory  implemention name is not specified for interface:" + cls.getName());
                } catch (Throwable th) {
                    throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
                }
            }
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        return (T) invokeL.objValue;
    }

    public int getPluginVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Future<Boolean> future = this.m;
            if (future != null) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
            return this.e;
        }
        return invokeV.intValue;
    }
}
