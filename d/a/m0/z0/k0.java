package d.a.m0.z0;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes3.dex */
public class k0 implements Thread.UncaughtExceptionHandler {

    /* renamed from: g  reason: collision with root package name */
    public static final String f54722g = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + File.separator + "tieba" + File.separator + "oom" + File.separator;

    /* renamed from: e  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f54723e = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: f  reason: collision with root package name */
    public ExceptionData f54724f = null;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0006 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static String d(String str) {
        String readLine;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = 0;
        try {
            try {
                Process exec = Runtime.getRuntime().exec(str);
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        readLine = bufferedReader2.readLine();
                        if (d.a.c.e.p.k.isEmpty(readLine)) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        d.a.c.e.p.m.g(bufferedReader);
                        bufferedReader = bufferedReader;
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        d.a.c.e.p.m.g(bufferedReader);
                        throw th;
                    }
                }
                exec.destroy();
                d.a.c.e.p.m.g(bufferedReader2);
                bufferedReader = readLine;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
        return sb.toString();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4, types: [byte[]] */
    public static byte[] f(File file) {
        byte[] bArr;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = 0;
        byte[] bArr2 = null;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            bArr = null;
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
            d.a.c.e.p.m.e(fileInputStream);
            return bArr2;
        } catch (Exception e3) {
            e = e3;
            bArr = bArr2;
            fileInputStream3 = fileInputStream;
            BdLog.e(e.toString());
            d.a.c.e.p.m.e(fileInputStream3);
            fileInputStream2 = bArr;
            return fileInputStream2;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            d.a.c.e.p.m.e(fileInputStream2);
            throw th;
        }
    }

    public static boolean h(Throwable th) {
        if ("java.lang.OutOfMemoryError".equals(th.getClass().getName())) {
            return true;
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            return h(cause);
        }
        return false;
    }

    public final void a(FileWriter fileWriter, String str, String str2) {
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

    public final boolean b() {
        String[] split;
        int d2;
        int d3;
        int i2 = 100;
        try {
            i2 = d.a.m0.r.d0.b.j().k("crash_limit_count", 100);
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
            d2 = d.a.c.e.m.b.d(split[0], 0);
            d3 = d.a.c.e.m.b.d(split[1], i3);
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

    public final void c() {
        try {
            File file = new File(f54722g);
            if (!file.exists()) {
                file.mkdir();
            }
            Debug.dumpHprofData(f54722g + System.currentTimeMillis());
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public final int e() {
        return d.a.c.e.n.k.a.o().q("alert_crash", 5);
    }

    public final void g() {
        if (this.f54724f == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016301, this.f54724f));
        Map<String, String> map = this.f54724f.appendInfo;
        if (map != null) {
            for (String str : map.keySet()) {
                StringBuilder sb = new StringBuilder();
                ExceptionData exceptionData = this.f54724f;
                sb.append(exceptionData.info);
                sb.append("\n");
                sb.append(this.f54724f.appendInfo.get(str));
                exceptionData.info = sb.toString();
            }
        }
    }

    public final int i() {
        String[] split;
        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log";
        byte[] GetFileData = FileHelper.GetFileData(str);
        String str2 = GetFileData != null ? new String(GetFileData) : null;
        long j = StringUtils.getyyyyMMddHHTimeForNow();
        long j2 = 0;
        int i2 = 0;
        if (!TextUtils.isEmpty(str2) && (split = str2.split(":")) != null && split.length == 2) {
            i2 = d.a.c.e.m.b.d(split[0], 0);
            j2 = d.a.c.e.m.b.f(split[1], j);
        }
        int i3 = j2 == j ? 1 + i2 : 1;
        FileHelper.saveFileByAbsolutePath(str, (i3 + ":" + j).getBytes());
        return i3;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x015c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x0184 */
    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x00c5 */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0153, code lost:
        if (r10 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0176, code lost:
        if (r10 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0178, code lost:
        r10.uncaughtException(r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [d.a.m0.z0.k0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(Thread thread, Throwable th, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        PrintStream printStream;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        PrintStream printStream2;
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
                this.f54724f = new ExceptionData();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    printStream = new PrintStream(byteArrayOutputStream);
                    try {
                        exc.printStackTrace(printStream);
                        this.f54724f.info = new String(byteArrayOutputStream.toByteArray());
                        this.f54724f.mExcep = exc;
                        k(thread, exc);
                        this.f54724f = null;
                    } catch (Exception unused) {
                    } catch (Throwable th2) {
                        th = th2;
                        printStream3 = printStream;
                        d.a.c.e.p.m.f(printStream3);
                        d.a.c.e.p.m.f(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    printStream = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception unused3) {
                byteArrayOutputStream = null;
                printStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
            d.a.c.e.p.m.f(printStream);
            d.a.c.e.p.m.f(byteArrayOutputStream);
        }
        int i2 = i();
        ?? b2 = b();
        try {
            if (b2 != 0) {
                return;
            }
            try {
                b2 = new ByteArrayOutputStream();
                try {
                    printStream2 = new PrintStream((OutputStream) b2);
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    th.printStackTrace(printStream2);
                    byte[] byteArray = b2.toByteArray();
                    ExceptionData exceptionData = new ExceptionData();
                    this.f54724f = exceptionData;
                    if (z) {
                        exceptionData.info = th.getMessage();
                    } else {
                        exceptionData.info = new String(byteArray);
                        this.f54724f.mExcep = th;
                    }
                    g();
                    if (!z) {
                        k(thread, th);
                    }
                    SwitchManager.getInstance().crash(this.f54724f.info);
                    if (!TextUtils.isEmpty(this.f54724f.info)) {
                        BdLog.e(this.f54724f.info);
                    }
                    BdLog.e("hourCrash = " + i2);
                    if (i2 >= e()) {
                        m(thread, th);
                    }
                    d.a.c.e.p.m.f(printStream2);
                    d.a.c.e.p.m.f(b2);
                } catch (Exception e3) {
                    e = e3;
                    printStream3 = printStream2;
                    e.printStackTrace();
                    d.a.c.e.p.m.f(printStream3);
                    d.a.c.e.p.m.f(b2);
                    if (z) {
                        return;
                    }
                    if (TbConfig.getDebugSwitch()) {
                        uncaughtExceptionHandler2 = this.f54723e;
                    }
                    Process.killProcess(Process.myPid());
                } catch (Throwable th5) {
                    th = th5;
                    printStream3 = printStream2;
                    d.a.c.e.p.m.f(printStream3);
                    d.a.c.e.p.m.f(b2);
                    if (!z) {
                        if (TbConfig.getDebugSwitch() && (uncaughtExceptionHandler = this.f54723e) != null) {
                            uncaughtExceptionHandler.uncaughtException(thread, th);
                        } else {
                            Process.killProcess(Process.myPid());
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                b2 = 0;
            } catch (Throwable th6) {
                th = th6;
                b2 = 0;
            }
            if (z) {
                return;
            }
            if (TbConfig.getDebugSwitch()) {
                uncaughtExceptionHandler2 = this.f54723e;
            }
            Process.killProcess(Process.myPid());
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public final void k(Thread thread, Throwable th) {
        if (this.f54724f == null) {
            return;
        }
        l(thread, th, TbConfig.getDebugSwitch() ? TbConfig.FATAL_ERROR_DEBUG_FILE : TbConfig.FATAL_ERROR_FILE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0197, code lost:
        if (r11.f54724f.info.contains("java.lang.NoClassDefFoundError") != false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0240 A[Catch: all -> 0x0346, Exception -> 0x0349, LOOP:2: B:57:0x0240->B:62:0x025e, LOOP_START, PHI: r7 
      PHI: (r7v4 int) = (r7v0 int), (r7v5 int) binds: [B:56:0x023e, B:62:0x025e] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {all -> 0x0346, blocks: (B:11:0x0043, B:13:0x009f, B:14:0x00a8, B:15:0x00e8, B:17:0x00ee, B:19:0x00f8, B:20:0x0104, B:22:0x010a, B:25:0x0113, B:27:0x0135, B:29:0x015c, B:32:0x016d, B:30:0x0162, B:31:0x0168, B:34:0x0173, B:36:0x017b, B:38:0x0181, B:40:0x018d, B:42:0x0199, B:44:0x01a3, B:45:0x01c5, B:47:0x01cb, B:50:0x01d4, B:52:0x021d, B:51:0x0218, B:55:0x0228, B:57:0x0240, B:59:0x0246, B:61:0x0250, B:62:0x025e, B:63:0x0261, B:65:0x028f, B:66:0x02af, B:68:0x02ba, B:70:0x02c6, B:72:0x02d2, B:74:0x02f8, B:76:0x02fc, B:78:0x0302, B:79:0x030a, B:80:0x0329, B:84:0x0330, B:85:0x0337), top: B:106:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x028f A[Catch: all -> 0x0346, Exception -> 0x0349, TryCatch #2 {all -> 0x0346, blocks: (B:11:0x0043, B:13:0x009f, B:14:0x00a8, B:15:0x00e8, B:17:0x00ee, B:19:0x00f8, B:20:0x0104, B:22:0x010a, B:25:0x0113, B:27:0x0135, B:29:0x015c, B:32:0x016d, B:30:0x0162, B:31:0x0168, B:34:0x0173, B:36:0x017b, B:38:0x0181, B:40:0x018d, B:42:0x0199, B:44:0x01a3, B:45:0x01c5, B:47:0x01cb, B:50:0x01d4, B:52:0x021d, B:51:0x0218, B:55:0x0228, B:57:0x0240, B:59:0x0246, B:61:0x0250, B:62:0x025e, B:63:0x0261, B:65:0x028f, B:66:0x02af, B:68:0x02ba, B:70:0x02c6, B:72:0x02d2, B:74:0x02f8, B:76:0x02fc, B:78:0x0302, B:79:0x030a, B:80:0x0329, B:84:0x0330, B:85:0x0337), top: B:106:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02f8 A[Catch: Exception -> 0x032d, all -> 0x0346, TryCatch #1 {Exception -> 0x032d, blocks: (B:72:0x02d2, B:74:0x02f8, B:76:0x02fc, B:78:0x0302, B:79:0x030a, B:80:0x0329), top: B:104:0x02d2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(Thread thread, Throwable th, String str) {
        boolean z;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Object obj;
        byte[] f2;
        if (this.f54724f == null) {
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
                            if (this.f54724f.info != null) {
                                if (!this.f54724f.info.contains("java.lang.ClassNotFoundException")) {
                                }
                                try {
                                    PluginSettings l = d.a.c.h.j.g.d.k().l();
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
                                    str2 = d.a.c.h.h.b.c().toString();
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
                                String str3 = this.f54724f.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + d.a.c.a.b.f().c();
                                if (z) {
                                    str3 = str3 + "\n--PluginSettings--" + sb2.toString() + "\n--PluginTrace--" + str2;
                                }
                                a(fileWriter2, "error", str3);
                                if (this.f54724f.info != null && this.f54724f.info.contains("java.lang.ArrayIndexOutOfBoundsException: src.length=8192 srcPos=1 dst.length=8192 dstPos=0 length=-1")) {
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
                                                    a(fileWriter2, "--errorFile-", file.getAbsolutePath() + " - " + d.a.c.e.p.c.j(f2));
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
                            String str32 = this.f54724f.info + "--pluginInfo-" + sb.toString() + "\n--activityStack--" + d.a.c.a.b.f().c();
                            if (z) {
                            }
                            a(fileWriter2, "error", str32);
                            if (this.f54724f.info != null) {
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
                        } catch (Throwable th2) {
                            th = th2;
                            fileWriter = fileWriter2;
                            d.a.c.e.p.m.h(fileWriter);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileWriter = fileWriter2;
                        e.printStackTrace();
                        d.a.c.e.p.m.h(fileWriter);
                    }
                }
            } catch (Exception e4) {
                e = e4;
            }
            d.a.c.e.p.m.h(fileWriter);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void m(Thread thread, Throwable th) {
        BdLog.i("writeToFileForAlertLog = fatal_error_alert.log");
        l(thread, th, TbConfig.FATAL_ERROR_ALERT_FILE);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("Tieba", "Crash", th);
        String stackTraceElement = (th == null || th.getStackTrace() == null || th.getStackTrace().length <= 0) ? "" : th.getStackTrace()[0].toString();
        if (thread.getId() == Looper.getMainLooper().getThread().getId() || StringUtils.isNull(stackTraceElement) || StringUtils.isNull(th.getMessage()) || !th.getMessage().contains("Results have already been set") || !stackTraceElement.contains("com.google.android.gms")) {
            j(thread, th, false);
        }
    }
}
