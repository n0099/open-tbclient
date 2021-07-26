package d.a.p0.b1;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes7.dex */
public class m0 implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final String f52115g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f52116e;

    /* renamed from: f  reason: collision with root package name */
    public ExceptionData f52117f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1623620030, "Ld/a/p0/b1/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1623620030, "Ld/a/p0/b1/m0;");
                return;
            }
        }
        f52115g = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + File.separator + "tieba" + File.separator + "oom" + File.separator;
    }

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52116e = Thread.getDefaultUncaughtExceptionHandler();
        this.f52117f = null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x000a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    public static String d(String str) {
        InterceptResult invokeL;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = 0;
            try {
                try {
                    Process exec = Runtime.getRuntime().exec(str);
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        try {
                            readLine = bufferedReader2.readLine();
                            if (d.a.d.e.p.k.isEmpty(readLine)) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            d.a.d.e.p.m.g(bufferedReader);
                            bufferedReader = bufferedReader;
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            d.a.d.e.p.m.g(bufferedReader);
                            throw th;
                        }
                    }
                    exec.destroy();
                    d.a.d.e.p.m.g(bufferedReader2);
                    bufferedReader = readLine;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] f(File file) {
        InterceptResult invokeL;
        byte[] bArr;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            byte[] bArr2 = null;
            fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int length = (int) file.length();
                bArr2 = new byte[length];
                int i2 = 0;
                while (i2 < length) {
                    int read = fileInputStream.read(bArr2, i2, length - i2);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                }
                d.a.d.e.p.m.e(fileInputStream);
                return bArr2;
            } catch (Exception e3) {
                e = e3;
                bArr = bArr2;
                fileInputStream2 = fileInputStream;
                BdLog.e(e.toString());
                d.a.d.e.p.m.e(fileInputStream2);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                d.a.d.e.p.m.e(fileInputStream2);
                throw th;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean h(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
                return true;
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                return h(cause);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void a(FileWriter fileWriter, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, fileWriter, str, str2) == null) {
            try {
                fileWriter.append((CharSequence) str);
                if (str2 != null) {
                    fileWriter.append("=");
                    fileWriter.append((CharSequence) str2);
                }
                fileWriter.append("\n");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        String[] split;
        int d2;
        int d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 100;
            try {
                i2 = d.a.p0.s.d0.b.j().k("crash_limit_count", 100);
                if (i2 < 10) {
                    i2 = 10;
                }
            } catch (Throwable unused) {
            }
            int i3 = StringHelper.getyyyyMMddTimeForNow();
            String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_upload_info.log";
            byte[] GetFileData = FileHelper.GetFileData(str);
            String str2 = GetFileData != null ? new String(GetFileData) : null;
            if (TextUtils.isEmpty(str2) || (split = str2.split(":")) == null || split.length != 2) {
                d3 = i3;
                d2 = 0;
            } else {
                d2 = d.a.d.e.m.b.d(split[0], 0);
                d3 = d.a.d.e.m.b.d(split[1], i3);
            }
            if (d3 != i3) {
                d2 = 0;
            }
            if (d2 > i2) {
                return true;
            }
            FileHelper.saveFileByAbsolutePath(str, ((d2 + 1) + ":" + i3).getBytes());
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                File file = new File(f52115g);
                if (!file.exists()) {
                    file.mkdir();
                }
                Debug.dumpHprofData(f52115g + System.currentTimeMillis());
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.d.e.n.m.a.o().q("alert_crash", 5) : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f52117f == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016301, this.f52117f));
        Map<String, String> map = this.f52117f.appendInfo;
        if (map != null) {
            for (String str : map.keySet()) {
                StringBuilder sb = new StringBuilder();
                ExceptionData exceptionData = this.f52117f;
                sb.append(exceptionData.info);
                sb.append("\n");
                sb.append(this.f52117f.appendInfo.get(str));
                exceptionData.info = sb.toString();
            }
        }
    }

    public final int i() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log";
            byte[] GetFileData = FileHelper.GetFileData(str);
            String str2 = GetFileData != null ? new String(GetFileData) : null;
            long j = StringUtils.getyyyyMMddHHTimeForNow();
            long j2 = 0;
            int i2 = 0;
            if (!TextUtils.isEmpty(str2) && (split = str2.split(":")) != null && split.length == 2) {
                i2 = d.a.d.e.m.b.d(split[0], 0);
                j2 = d.a.d.e.m.b.f(split[1], j);
            }
            int i3 = j2 == j ? 1 + i2 : 1;
            FileHelper.saveFileByAbsolutePath(str, (i3 + ":" + j).getBytes());
            return i3;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0157, code lost:
        if (r10 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x017a, code lost:
        if (r10 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x017c, code lost:
        r10.uncaughtException(r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(Thread thread, Throwable th, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        PrintStream printStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048582, this, thread, th, z) == null) {
            if (TbConfig.getDebugSwitch() && h(th)) {
                c();
            }
            PrintStream printStream3 = null;
            if (h(th)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append((th.getMessage() + d("cat proc/" + Process.myPid() + "/status")) + "\n===========================\n");
                    sb.append(d("cat proc/" + Process.myPid() + "/maps"));
                    Exception exc = new Exception(sb.toString());
                    this.f52117f = new ExceptionData();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        printStream = new PrintStream(byteArrayOutputStream);
                    } catch (Exception unused) {
                        printStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        exc.printStackTrace(printStream);
                        this.f52117f.info = new String(byteArrayOutputStream.toByteArray());
                        this.f52117f.mExcep = exc;
                        k(thread, exc);
                        this.f52117f = null;
                    } catch (Exception unused2) {
                    } catch (Throwable th3) {
                        th = th3;
                        printStream3 = printStream;
                        d.a.d.e.p.m.f(printStream3);
                        d.a.d.e.p.m.f(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception unused3) {
                    byteArrayOutputStream = null;
                    printStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                }
                d.a.d.e.p.m.f(printStream);
                d.a.d.e.p.m.f(byteArrayOutputStream);
            }
            int i2 = i();
            if (b()) {
                return;
            }
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    try {
                        printStream2 = new PrintStream(byteArrayOutputStream2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = null;
            } catch (Throwable th6) {
                th = th6;
                byteArrayOutputStream2 = null;
            }
            try {
                th.printStackTrace(printStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                ExceptionData exceptionData = new ExceptionData();
                this.f52117f = exceptionData;
                if (z) {
                    exceptionData.info = th.getMessage();
                } else {
                    exceptionData.info = new String(byteArray);
                    this.f52117f.mExcep = th;
                }
                g();
                if (!z) {
                    k(thread, th);
                }
                SwitchManager.getInstance().crash(this.f52117f.info);
                if (!TextUtils.isEmpty(this.f52117f.info)) {
                    BdLog.e(this.f52117f.info);
                }
                BdLog.e("hourCrash = " + i2);
                if (i2 >= e()) {
                    m(thread, th);
                }
                d.a.d.e.p.m.f(printStream2);
                d.a.d.e.p.m.f(byteArrayOutputStream2);
            } catch (Exception e4) {
                e = e4;
                printStream3 = printStream2;
                e.printStackTrace();
                d.a.d.e.p.m.f(printStream3);
                d.a.d.e.p.m.f(byteArrayOutputStream2);
                if (z) {
                    return;
                }
                if (TbConfig.getDebugSwitch()) {
                    uncaughtExceptionHandler2 = this.f52116e;
                }
                Process.killProcess(Process.myPid());
            } catch (Throwable th7) {
                th = th7;
                printStream3 = printStream2;
                d.a.d.e.p.m.f(printStream3);
                d.a.d.e.p.m.f(byteArrayOutputStream2);
                if (!z) {
                    if (TbConfig.getDebugSwitch() && (uncaughtExceptionHandler = this.f52116e) != null) {
                        uncaughtExceptionHandler.uncaughtException(thread, th);
                    } else {
                        Process.killProcess(Process.myPid());
                    }
                }
                throw th;
            }
            if (z) {
                return;
            }
            if (TbConfig.getDebugSwitch()) {
                uncaughtExceptionHandler2 = this.f52116e;
            }
            Process.killProcess(Process.myPid());
        }
    }

    public final void k(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, thread, th) == null) || this.f52117f == null) {
            return;
        }
        l(thread, th, TbConfig.getDebugSwitch() ? TbConfig.FATAL_ERROR_DEBUG_FILE : TbConfig.FATAL_ERROR_FILE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x019b, code lost:
        if (r11.f52117f.info.contains("java.lang.NoClassDefFoundError") != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0244 A[Catch: all -> 0x034a, Exception -> 0x034d, LOOP:2: B:59:0x0244->B:64:0x0262, LOOP_START, PHI: r7 
      PHI: (r7v4 int) = (r7v0 int), (r7v5 int) binds: [B:58:0x0242, B:64:0x0262] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x034d, blocks: (B:13:0x0047, B:15:0x00a3, B:16:0x00ac, B:36:0x0177, B:57:0x022c, B:59:0x0244, B:61:0x024a, B:63:0x0254, B:64:0x0262, B:65:0x0265, B:67:0x0293, B:68:0x02b3, B:70:0x02be, B:72:0x02ca, B:86:0x0334, B:87:0x033b), top: B:109:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0293 A[Catch: all -> 0x034a, Exception -> 0x034d, TryCatch #1 {Exception -> 0x034d, blocks: (B:13:0x0047, B:15:0x00a3, B:16:0x00ac, B:36:0x0177, B:57:0x022c, B:59:0x0244, B:61:0x024a, B:63:0x0254, B:64:0x0262, B:65:0x0265, B:67:0x0293, B:68:0x02b3, B:70:0x02be, B:72:0x02ca, B:86:0x0334, B:87:0x033b), top: B:109:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02fc A[Catch: Exception -> 0x0331, all -> 0x034a, TryCatch #5 {all -> 0x034a, blocks: (B:13:0x0047, B:15:0x00a3, B:16:0x00ac, B:17:0x00ec, B:19:0x00f2, B:21:0x00fc, B:22:0x0108, B:24:0x010e, B:27:0x0117, B:29:0x0139, B:31:0x0160, B:34:0x0171, B:32:0x0166, B:33:0x016c, B:36:0x0177, B:38:0x017f, B:40:0x0185, B:42:0x0191, B:44:0x019d, B:46:0x01a7, B:47:0x01c9, B:49:0x01cf, B:52:0x01d8, B:54:0x0221, B:53:0x021c, B:57:0x022c, B:59:0x0244, B:61:0x024a, B:63:0x0254, B:64:0x0262, B:65:0x0265, B:67:0x0293, B:68:0x02b3, B:70:0x02be, B:72:0x02ca, B:74:0x02d6, B:76:0x02fc, B:78:0x0300, B:80:0x0306, B:81:0x030e, B:82:0x032d, B:86:0x0334, B:87:0x033b), top: B:109:0x0047 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(Thread thread, Throwable th, String str) {
        boolean z;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object obj;
        byte[] f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, thread, th, str) == null) || this.f52117f == null) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                File CreateFileIfNotFoundAbsolutePath = FileHelper.CreateFileIfNotFoundAbsolutePath(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + str);
                if (CreateFileIfNotFoundAbsolutePath != null && CreateFileIfNotFoundAbsolutePath.length() < TbConfig.FATAL_ERROR_FILE_MAX_SIZE) {
                    FileWriter fileWriter2 = new FileWriter(CreateFileIfNotFoundAbsolutePath, true);
                    try {
                        try {
                            a(fileWriter2, StringHelper.getCurrentString(), null);
                            a(fileWriter2, "tieba_crash_new_info", null);
                            a(fileWriter2, "version", TbConfig.getVersion());
                            a(fileWriter2, "model", Build.MODEL);
                            a(fileWriter2, "android_version", Build.VERSION.RELEASE);
                            a(fileWriter2, "android_sdk", String.valueOf(Build.VERSION.SDK_INT));
                            a(fileWriter2, "from", TbConfig.getFrom());
                            a(fileWriter2, "current_from", TbConfig.getCurrentFrom());
                            a(fileWriter2, "uid", TbadkCoreApplication.getCurrentAccount());
                            a(fileWriter2, "client_id", TbadkCoreApplication.getClientId());
                            if (!TextUtils.isEmpty(TbConfig.getSubappType())) {
                                a(fileWriter2, HttpRequest.SUBAPP_TYPE, TbConfig.getSubappType());
                            }
                            a(fileWriter2, "imei", TbadkCoreApplication.getInst().getImei());
                            a(fileWriter2, "uname", TbadkCoreApplication.getCurrentAccountName());
                            a(fileWriter2, "activity", TiebaStaticHelper.getCurrentActivityAllName());
                            a(fileWriter2, "maxMemory", String.valueOf(Runtime.getRuntime().maxMemory()));
                            a(fileWriter2, "crash_type", th.getClass().getName());
                            StringBuilder sb = new StringBuilder();
                            try {
                                if (PluginCenter.getInstance() != null && PluginCenter.getInstance().getAllPlugins() != null) {
                                    Iterator<Plugin> it = PluginCenter.getInstance().getAllPlugins().iterator();
                                    while (it.hasNext()) {
                                        Plugin next = it.next();
                                        if (next != null) {
                                            PluginSetting P = PluginPackageManager.O().P(next.getPackageName());
                                            sb.append(next.getPackageName());
                                            sb.append("-");
                                            sb.append(next.getCurrentPluginMode());
                                            sb.append("-");
                                            if (P != null) {
                                                sb.append(new File(P.apkPath).exists());
                                                sb.append("-");
                                                sb.append(next.getVersionCode());
                                                sb.append("-");
                                                sb.append(P.tempVersionCode);
                                                sb.append("-");
                                                if (P.enable) {
                                                    sb.append("true");
                                                } else {
                                                    sb.append("false");
                                                }
                                            } else {
                                                sb.append(StringUtil.NULL_STRING);
                                            }
                                            sb.append(",");
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            StringBuilder sb2 = new StringBuilder();
                            String str2 = "";
                            int i2 = 0;
                            if (this.f52117f.info != null) {
                                if (!this.f52117f.info.contains("java.lang.ClassNotFoundException")) {
                                }
                                try {
                                    PluginSettings l = d.a.d.h.j.g.d.k().l();
                                    if (l != null) {
                                        sb2.append(l.getContainerVersion());
                                        sb2.append("-");
                                        sb2.append(l.getForbiddenFeatures());
                                        sb2.append("#");
                                        for (PluginSetting pluginSetting : l.getPlugins().values()) {
                                            if (pluginSetting != null) {
                                                sb2.append(pluginSetting.packageName);
                                                sb2.append("-");
                                                sb2.append(pluginSetting.versionCode);
                                                sb2.append("-");
                                                sb2.append(pluginSetting.tempVersionCode);
                                                sb2.append("-");
                                                sb2.append(pluginSetting.enable);
                                                sb2.append("-");
                                                sb2.append(pluginSetting.forbidden);
                                                sb2.append("-");
                                                sb2.append(pluginSetting.installStatus);
                                                sb2.append("-");
                                                sb2.append(new File(pluginSetting.apkPath).exists());
                                                sb2.append(";");
                                            }
                                        }
                                    } else {
                                        sb2.append("pluginSettings_is_null");
                                    }
                                    str2 = d.a.d.h.h.b.c().toString();
                                } catch (Exception unused2) {
                                }
                                z = true;
                                runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getApp().getSystemService("activity")).getRunningAppProcesses();
                                int myPid = Process.myPid();
                                if (runningAppProcesses != null) {
                                    while (true) {
                                        if (i2 >= runningAppProcesses.size()) {
                                            break;
                                        } else if (runningAppProcesses.get(i2).pid == myPid) {
                                            a(fileWriter2, "process_name", runningAppProcesses.get(i2).processName);
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                String str3 = this.f52117f.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + d.a.d.a.b.f().c();
                                if (z) {
                                    str3 = str3 + "\n--PluginSettings--" + sb2.toString() + "\n--PluginTrace--" + str2;
                                }
                                a(fileWriter2, "error", str3);
                                if (this.f52117f.info != null && this.f52117f.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
                                    int nextInt = new Random().nextInt(100);
                                    try {
                                        Field declaredField = thread.getClass().getDeclaredField("this$0");
                                        declaredField.setAccessible(true);
                                        Object obj2 = declaredField.get(thread);
                                        Field declaredField2 = obj2.getClass().getDeclaredField("mFile");
                                        declaredField2.setAccessible(true);
                                        obj = declaredField2.get(obj2);
                                        if (obj instanceof File) {
                                            File file = (File) obj;
                                            if (nextInt < 5) {
                                                if (f(file) == null) {
                                                    a(fileWriter2, "--errorFile-", file.getAbsolutePath());
                                                } else {
                                                    a(fileWriter2, "--errorFile-", file.getAbsolutePath() + " - " + d.a.d.e.p.c.j(f2));
                                                }
                                            }
                                            file.delete();
                                        }
                                    } catch (Exception e2) {
                                        if (nextInt < 5) {
                                            a(fileWriter2, "--errorFile-", e2.toString());
                                        }
                                    }
                                }
                                a(fileWriter2, "tieba_crash_new_info_end", null);
                                fileWriter2.append("\n");
                                fileWriter2.flush();
                                fileWriter = fileWriter2;
                            }
                            z = false;
                            runningAppProcesses = ((ActivityManager) TbadkCoreApplication.getInst().getApp().getSystemService("activity")).getRunningAppProcesses();
                            int myPid2 = Process.myPid();
                            if (runningAppProcesses != null) {
                            }
                            String str32 = this.f52117f.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + d.a.d.a.b.f().c();
                            if (z) {
                            }
                            a(fileWriter2, "error", str32);
                            if (this.f52117f.info != null) {
                                int nextInt2 = new Random().nextInt(100);
                                Field declaredField3 = thread.getClass().getDeclaredField("this$0");
                                declaredField3.setAccessible(true);
                                Object obj22 = declaredField3.get(thread);
                                Field declaredField22 = obj22.getClass().getDeclaredField("mFile");
                                declaredField22.setAccessible(true);
                                obj = declaredField22.get(obj22);
                                if (obj instanceof File) {
                                }
                            }
                            a(fileWriter2, "tieba_crash_new_info_end", null);
                            fileWriter2.append("\n");
                            fileWriter2.flush();
                            fileWriter = fileWriter2;
                        } catch (Exception e3) {
                            e = e3;
                            fileWriter = fileWriter2;
                            e.printStackTrace();
                            d.a.d.e.p.m.h(fileWriter);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter = fileWriter2;
                        d.a.d.e.p.m.h(fileWriter);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
        }
        d.a.d.e.p.m.h(fileWriter);
    }

    public final void m(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, thread, th) == null) {
            BdLog.i("writeToFileForAlertLog = fatal_error_alert.log");
            l(thread, th, TbConfig.FATAL_ERROR_ALERT_FILE);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, thread, th) == null) {
            Log.e("Tieba", "Crash", th);
            String stackTraceElement = (th == null || th.getStackTrace() == null || th.getStackTrace().length <= 0) ? "" : th.getStackTrace()[0].toString();
            if (thread.getId() == Looper.getMainLooper().getThread().getId() || StringUtils.isNull(stackTraceElement) || StringUtils.isNull(th.getMessage()) || !th.getMessage().contains("Results have already been set") || !stackTraceElement.contains("com.google.android.gms")) {
                j(thread, th, false);
            }
        }
    }
}
