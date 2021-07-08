package d.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.SilentDownloaderManager;
import com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.media.duplayer.Utils;
import com.baidu.media.duplayer.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.CommandMessage;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static e f68476a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68477b;

    /* renamed from: c  reason: collision with root package name */
    public static String f68478c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f68479d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f68480e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68480e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    for (File file : new File(e.f68478c).listFiles()) {
                        if (file.isFile()) {
                            this.f68480e.h(file);
                        } else if (file.getName().equals(e.f68477b)) {
                            this.f68480e.n(file);
                        } else {
                            Utils.e(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1124463425, "Ld/a/y/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1124463425, "Ld/a/y/a/e;");
                return;
            }
        }
        f68479d = new LinkedHashSet();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized e b() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (e.class) {
                if (f68476a == null) {
                    f68477b = Utils.s();
                    f68476a = new e();
                }
                eVar = f68476a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (i2 & 896) == i2 : invokeI.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
                CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
                cyberCfgManager.setPrefStr("build_in_" + dVar.a(), dVar.d());
            }
        }
    }

    public boolean C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? (i2 & 2048) == i2 : invokeI.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && SDKVersion.VERSION.equals(CyberPlayerManager.getSDKVersion())) {
            for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
                if (dVar != null && i(dVar)) {
                    r(dVar);
                    t(dVar);
                    return;
                }
            }
        }
    }

    public boolean E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (i2 & 3) == i2 : invokeI.booleanValue;
    }

    public boolean F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? (i2 & CommandMessage.COMMAND_BASE) == i2 : invokeI.booleanValue;
    }

    public com.baidu.media.duplayer.d a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? LibsInfoDef.getAllGroupMap().get(Integer.valueOf(i2)) : (com.baidu.media.duplayer.d) invokeI.objValue;
    }

    public final String c(Context context, com.baidu.media.duplayer.d dVar) {
        InterceptResult invokeLL;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, dVar)) == null) {
            String str2 = null;
            if (dVar.l() == d.a.f8100a) {
                if (dVar.d().equals(d(dVar.a())) && d.a.y.b.a.e(context.getClassLoader())) {
                    return "apk_internal_jar";
                }
                sb = new StringBuilder();
                sb.append(f68478c);
                sb.append(File.separator);
                sb.append(dVar.a());
                sb.append("_");
                sb.append(dVar.d());
                str = ".jar";
            } else if (dVar.l() != d.a.f8101b) {
                return null;
            } else {
                if (dVar.d().equals(d(dVar.a())) && CyberCfgManager.getInstance().getCfgBoolValue("enable_libs_reuse", true)) {
                    str2 = ((BaseDexClassLoader) context.getClassLoader()).findLibrary(dVar.a());
                }
                if (!TextUtils.isEmpty(str2)) {
                    dVar.i(true);
                    return str2;
                }
                sb = new StringBuilder();
                sb.append(f68478c);
                sb.append(File.separator);
                sb.append(f68477b);
                sb.append(File.separator);
                sb.append(dVar.a());
                sb.append("_");
                sb.append(dVar.d());
                sb.append(File.separator);
                sb.append("lib");
                sb.append(dVar.a());
                str = ".so";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
            return cyberCfgManager.getPrefStr("build_in_" + str, "");
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> e(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, libsVersionType)) == null) {
            HashMap hashMap = new HashMap();
            if (CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION == libsVersionType) {
                for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
                    hashMap.put(dVar.a(), dVar.d());
                }
            } else if (CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION == libsVersionType) {
                for (com.baidu.media.duplayer.d dVar2 : LibsInfoDef.getAllGroupMap().values()) {
                    if (c.d(dVar2.g())) {
                        hashMap.put(dVar2.a(), dVar2.d());
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            if (SDKVersion.VERSION.equals(CyberPlayerManager.getSDKVersion())) {
                B();
            }
            k(context, str);
            D();
        }
    }

    public final void h(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, file) == null) {
            try {
                if (!file.isFile() || file.getName().contains(SDKVersion.VERSION)) {
                    return;
                }
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    public final boolean i(com.baidu.media.duplayer.d dVar) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, dVar)) == null) {
            if (dVar != null && !"cyber-player".equals(dVar.a()) && !"cyber-sdl".equals(dVar.a())) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue(dVar.a(), "");
                if (!TextUtils.isEmpty(cfgValue) && (split = cfgValue.split(";")) != null && split.length == 3 && CyberCfgManager.getInstance().isAllowUpdate(dVar.a(), split[1], dVar.d())) {
                    dVar.h(dVar.d());
                    dVar.k(dVar.j());
                    CyberCfgManager.getInstance();
                    dVar.b(CyberCfgManager.keepMainProcessVersion(dVar.a(), split[1]));
                    dVar.e(c(CyberPlayerManager.getApplicationContext(), dVar));
                    dVar.f("1".equals(split[2]));
                    dVar.c(true);
                    l(dVar);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            int i3 = (i2 & 2) == 2 ? 92 : 28;
            if ((i2 & 4) == 4) {
                i3 |= 32;
            }
            if ((i2 & 8) == 8) {
                i3 |= 896;
            }
            if ((i2 & 16) == 16) {
                i3 |= 3;
            }
            if ((i2 & 32) == 32) {
                i3 |= 2048;
            }
            return (i2 & 64) == 64 ? i3 | CommandMessage.COMMAND_BASE : i3;
        }
        return invokeI.intValue;
    }

    public final void k(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            f68478c = str + File.separator + "libs";
            for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
                String c2 = c(context, dVar);
                dVar.e(c2);
                if (dVar.l() == d.a.f8101b) {
                    File parentFile = new File(c2).getParentFile();
                    if (!parentFile.exists() || parentFile.isFile()) {
                        parentFile.mkdirs();
                    }
                    f68479d.add(parentFile.getAbsolutePath());
                }
            }
        }
    }

    public final void l(com.baidu.media.duplayer.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) && Utils.r(CyberPlayerManager.getApplicationContext())) {
            String prefStr = CyberCfgManager.getInstance().getPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE, dVar.a());
            String prefStr2 = CyberCfgManager.getInstance().getPrefStr("update_version", dVar.d());
            if (dVar.a().equals(prefStr) && CyberCfgManager.compareVersion(dVar.d(), prefStr2) == -1) {
                return;
            }
            CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE, dVar.a());
            CyberCfgManager.getInstance().setPrefStr("update_version", dVar.d());
        }
    }

    public final void n(File file) {
        File[] listFiles;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, file) == null) {
            try {
                for (File file2 : file.listFiles()) {
                    Iterator<String> it = f68479d.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().contains(file2.getAbsolutePath())) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        Utils.e(file2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public String[] o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Set<String> set = f68479d;
            return (String[]) set.toArray(new String[set.size()]);
        }
        return (String[]) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? f68477b : (String) invokeV.objValue;
    }

    public String q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            com.baidu.media.duplayer.d a2 = a(i2);
            if (a2 == null) {
                return null;
            }
            return f68477b + "_" + a2.a() + "_" + a2.d() + ".zip";
        }
        return (String) invokeI.objValue;
    }

    public final boolean r(com.baidu.media.duplayer.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, dVar)) == null) {
            if (dVar == null || !dVar.q() || dVar.d().equals(dVar.n())) {
                return false;
            }
            if (SilentDownloaderManager.getInstance().checkLibs(dVar.a(), dVar.d())) {
                String latestLoadedVersion = CyberCoreLoaderManager.getLatestLoadedVersion(dVar.a());
                if (CyberCfgManager.compareVersion(latestLoadedVersion, dVar.n()) != 1) {
                    latestLoadedVersion = dVar.n();
                }
                dVar.b(latestLoadedVersion);
                dVar.e(c(CyberPlayerManager.getApplicationContext(), dVar));
                dVar.c(false);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            long prefLong = CyberCfgManager.getInstance().getPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - prefLong > 432000000) {
                CyberCfgManager.getInstance().setPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, currentTimeMillis);
                CyberTaskExcutor.getInstance().execute(new a(this));
            }
        }
    }

    public final void t(com.baidu.media.duplayer.d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, dVar) == null) && dVar != null && dVar.l() == d.a.f8101b) {
            try {
                File parentFile = new File(dVar.j()).getParentFile();
                if (!parentFile.exists() || parentFile.isFile()) {
                    parentFile.mkdirs();
                }
                f68479d.add(parentFile.getAbsolutePath());
            } catch (Exception unused) {
            }
        }
    }

    public boolean u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? (i2 & 28) == i2 : invokeI.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int size = LibsInfoDef.getAllGroupMap().size();
            for (int i2 = 0; i2 <= size; i2++) {
                com.baidu.media.duplayer.d a2 = a(1 << i2);
                if (a2 != null && a2.m()) {
                    if (a2.q()) {
                        a2.b(a2.n());
                        a2.e(a2.o());
                        a2.c(false);
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? (i2 & 32) == i2 : invokeI.booleanValue;
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) ? (i2 & 64) == i2 : invokeI.booleanValue;
    }
}
