package com.repackage;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.nps.utils.Constant;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/* loaded from: classes5.dex */
public class dm {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static Map<String, Boolean> b;
    public static String c;
    public static boolean d;
    public static boolean e;
    public static Signature[] f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964042084, "Lcom/repackage/dm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964042084, "Lcom/repackage/dm;");
                return;
            }
        }
        b = new HashMap();
        c = null;
        d = false;
        e = false;
        f = null;
    }

    public static boolean a(File file, String str, byte[] bArr) {
        InterceptResult invokeLLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, file, str, bArr)) == null) {
            if (file == null || !file.exists() || file.length() <= 0) {
                return false;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                String s = Util.s(fileInputStream, bArr);
                boolean equalsIgnoreCase = s.equalsIgnoreCase(str);
                em.b().m("plugin_install", "install_chack_md5", "", "result_" + equalsIgnoreCase + "-tempMd5_" + s + "-check_" + str + "-size_" + file.length() + "-file_" + file.getAbsolutePath());
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    BdLog.d(e3.getMessage());
                }
                return equalsIgnoreCase;
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                BdLog.d(e.getMessage());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        BdLog.d(e5.getMessage());
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        BdLog.d(e6.getMessage());
                    }
                }
                throw th;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(ArrayList<ZipEntry> arrayList, ZipEntry zipEntry) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, zipEntry)) == null) {
            if (arrayList != null && zipEntry != null) {
                String name = zipEntry.getName();
                if (TextUtils.isEmpty(name)) {
                    return false;
                }
                String substring = name.substring(name.lastIndexOf("/"));
                Iterator<ZipEntry> it = arrayList.iterator();
                while (it.hasNext()) {
                    ZipEntry next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && next.getName().endsWith(substring)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0196: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:112:0x0194 */
    public static final boolean c(ZipFile zipFile, File file, File file2, String str) {
        InterceptResult invokeLLLL;
        FileOutputStream fileOutputStream;
        ZipOutputStream zipOutputStream;
        FileOutputStream fileOutputStream2;
        ZipOutputStream zipOutputStream2;
        Throwable th;
        ZipOutputStream zipOutputStream3;
        FileOutputStream fileOutputStream3;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65539, null, zipFile, file, file2, str)) != null) {
            return invokeLLLL.booleanValue;
        }
        InputStream inputStream2 = null;
        try {
            try {
                file.mkdirs();
                ii.m(file);
                file2.createNewFile();
                fileOutputStream2 = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream3 = null;
                fileOutputStream = fileOutputStream3;
                pi.f(zipOutputStream3);
                pi.f(fileOutputStream);
                try {
                    ii.m(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (ZipException e3) {
            e = e3;
            zipOutputStream2 = null;
            fileOutputStream2 = null;
        } catch (IOException e4) {
            e = e4;
            zipOutputStream = null;
            fileOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        try {
            zipOutputStream3 = new ZipOutputStream(fileOutputStream2);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    try {
                        String name = nextElement.getName();
                        if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX)) {
                            pi.e(inputStream2);
                            pi.e(inputStream2);
                        } else {
                            InputStream inputStream3 = zipFile.getInputStream(nextElement);
                            try {
                            } catch (IOException e5) {
                                e = e5;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                File file3 = new File(file, name);
                                file3.getParentFile().mkdirs();
                                Util.b(inputStream3, file3);
                                byte[] bArr = new byte[4096];
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file3), 4096);
                                try {
                                    ZipEntry zipEntry = new ZipEntry(file3.getAbsolutePath().substring(file.getAbsolutePath().length() + 1));
                                    if (zipEntry.getName().equals("resources.arsc")) {
                                        zipEntry.setMethod(0);
                                        zipEntry.setSize(file3.length());
                                        zipEntry.setCompressedSize(zipEntry.getSize());
                                        zipEntry.setCrc(nextElement.getCrc());
                                    }
                                    zipOutputStream3.putNextEntry(zipEntry);
                                    while (true) {
                                        int read = bufferedInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream3.write(bArr, 0, read);
                                    }
                                    bufferedInputStream2.close();
                                    zipOutputStream3.flush();
                                    zipOutputStream3.closeEntry();
                                    try {
                                        pi.e(inputStream3);
                                        pi.e(bufferedInputStream2);
                                        inputStream2 = null;
                                    } catch (ZipException e6) {
                                        e = e6;
                                        zipOutputStream2 = zipOutputStream3;
                                        em.b().m("plugin_install", "delete_so", str, e.getMessage());
                                        pi.f(zipOutputStream2);
                                        pi.f(fileOutputStream2);
                                        try {
                                            ii.m(file);
                                            return false;
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                            return false;
                                        }
                                    } catch (IOException e8) {
                                        e = e8;
                                        zipOutputStream = zipOutputStream3;
                                        em.b().m("plugin_install", "delete_so", str, e.getMessage());
                                        pi.f(zipOutputStream);
                                        pi.f(fileOutputStream2);
                                        try {
                                            ii.m(file);
                                            return false;
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                            return false;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        fileOutputStream = fileOutputStream2;
                                        try {
                                            em.b().m("plugin_install", "delete_so", str, th.getMessage());
                                            pi.f(zipOutputStream3);
                                            pi.f(fileOutputStream);
                                            try {
                                                ii.m(file);
                                                return false;
                                            } catch (IOException e10) {
                                                e10.printStackTrace();
                                                return false;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            pi.f(zipOutputStream3);
                                            pi.f(fileOutputStream);
                                            ii.m(file);
                                            throw th;
                                        }
                                    }
                                } catch (IOException e11) {
                                    e = e11;
                                    bufferedInputStream = bufferedInputStream2;
                                    inputStream = inputStream3;
                                    try {
                                        throw e;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        pi.e(inputStream);
                                        pi.e(bufferedInputStream);
                                        throw th;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    bufferedInputStream = bufferedInputStream2;
                                    inputStream = inputStream3;
                                    pi.e(inputStream);
                                    pi.e(bufferedInputStream);
                                    throw th;
                                }
                            } catch (IOException e12) {
                                e = e12;
                                inputStream = inputStream3;
                                bufferedInputStream = null;
                                throw e;
                            } catch (Throwable th9) {
                                th = th9;
                                inputStream = inputStream3;
                                bufferedInputStream = null;
                                pi.e(inputStream);
                                pi.e(bufferedInputStream);
                                throw th;
                            }
                        }
                    } catch (IOException e13) {
                        e = e13;
                        inputStream = null;
                    } catch (Throwable th10) {
                        th = th10;
                        inputStream = null;
                    }
                }
                pi.f(zipOutputStream3);
                pi.f(fileOutputStream2);
                try {
                    ii.m(file);
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
                return true;
            } catch (ZipException e15) {
                e = e15;
            } catch (IOException e16) {
                e = e16;
            } catch (Throwable th11) {
                th = th11;
            }
        } catch (ZipException e17) {
            e = e17;
            zipOutputStream2 = null;
        } catch (IOException e18) {
            e = e18;
            zipOutputStream = null;
        } catch (Throwable th12) {
            th = th12;
            fileOutputStream = fileOutputStream2;
            zipOutputStream3 = null;
            em.b().m("plugin_install", "delete_so", str, th.getMessage());
            pi.f(zipOutputStream3);
            pi.f(fileOutputStream);
            ii.m(file);
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:178:0x040a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:341:0x03af */
    /* JADX WARN: Can't wrap try/catch for region: R(21:17|18|(1:236)(2:22|(4:(1:234)(1:27)|(5:30|31|32|33|34)|39|(15:122|(2:124|(2:126|127))(1:233)|128|(3:130|131|(3:133|134|(2:136|(2:141|142)(1:140))(2:143|144))(5:156|157|158|159|(6:161|162|163|164|165|166)(1:176)))|188|189|190|191|192|193|194|195|196|(2:198|(1:(1:224)(5:200|(2:204|(2:208|(3:219|220|221)(1:213)))|222|223|221)))(0)|225)(8:43|(15:45|46|47|48|49|50|51|52|53|54|55|57|58|(1:60)(4:90|91|92|93)|61)(1:121)|63|64|65|(1:86)(3:69|(4:72|(3:77|78|79)|80|70)|83)|84|85)))|235|39|(1:41)|122|(0)(0)|128|(0)|188|189|190|191|192|193|194|195|196|(0)(0)|225) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:9|(1:378)(2:13|(2:15|(21:17|18|(1:236)(2:22|(4:(1:234)(1:27)|(5:30|31|32|33|34)|39|(15:122|(2:124|(2:126|127))(1:233)|128|(3:130|131|(3:133|134|(2:136|(2:141|142)(1:140))(2:143|144))(5:156|157|158|159|(6:161|162|163|164|165|166)(1:176)))|188|189|190|191|192|193|194|195|196|(2:198|(1:(1:224)(5:200|(2:204|(2:208|(3:219|220|221)(1:213)))|222|223|221)))(0)|225)(8:43|(15:45|46|47|48|49|50|51|52|53|54|55|57|58|(1:60)(4:90|91|92|93)|61)(1:121)|63|64|65|(1:86)(3:69|(4:72|(3:77|78|79)|80|70)|83)|84|85)))|235|39|(1:41)|122|(0)(0)|128|(0)|188|189|190|191|192|193|194|195|196|(0)(0)|225)))|237|238|239|(5:364|365|366|367|368)(11:241|242|243|244|245|246|(2:248|(7:250|(8:254|(1:349)(2:258|(8:262|263|264|265|(2:267|(1:271))(2:275|(2:277|(2:281|282))(2:285|(3:287|(1:293)(1:291)|292)(6:294|295|296|297|(2:299|(2:303|304))(2:307|(2:309|(3:313|314|316))(2:320|(2:326|327)))|274)))|272|273|274))|348|272|273|274|251|252)|350|351|352|335|(4:338|339|340|341)(22:337|18|(1:20)|236|235|39|(0)|122|(0)(0)|128|(0)|188|189|190|191|192|193|194|195|196|(0)(0)|225)))|357|352|335|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0275, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0277, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0278, code lost:
        r21 = "_";
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x027a, code lost:
        r32 = "has_res";
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0674, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0675, code lost:
        com.baidu.adp.lib.util.BdLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0684, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0685, code lost:
        com.baidu.adp.lib.util.BdLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0788, code lost:
        com.repackage.em.b().i("plugin_repeat_install", r5);
        r0 = new java.lang.StringBuilder();
        r6 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0798, code lost:
        if (r41 == null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x079a, code lost:
        r0.append(r6);
        r0.append(r41.apkPath);
        r0.append(r6);
        r0.append(r41.versionCode);
        r0.append(r6);
        r0.append(r41.tempVersionCode);
        r0.append(r6);
        r0.append(r41.enable);
        r0.append(r6);
        r0.append(r41.install_fail_count);
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x07c2, code lost:
        com.repackage.em.b().m(r37, "plugin_repeat_install", r5, r3.getAbsolutePath() + r6 + r14.getAbsolutePath() + r0.toString());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0753 A[Catch: all -> 0x0802, TryCatch #21 {all -> 0x0802, blocks: (B:277:0x0749, B:279:0x0753, B:281:0x0757, B:283:0x075b, B:285:0x0761, B:287:0x076b, B:289:0x0771, B:291:0x0779, B:294:0x0788, B:296:0x079a, B:297:0x07c2), top: B:367:0x0749 }] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(File file, File file2, String str, String str2, PluginSetting pluginSetting) {
        InterceptResult invokeLLLLL;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str8;
        boolean z5;
        String str9;
        String str10;
        String str11;
        int i;
        String str12;
        boolean z6;
        InputStream inputStream;
        boolean z7;
        boolean z8;
        boolean z9;
        String str13;
        String str14;
        String str15;
        int i2;
        String attribute;
        NodeList elementsByTagName;
        int i3;
        NodeList nodeList;
        NamedNodeMap attributes;
        Node namedItem;
        boolean z10;
        boolean z11;
        String str16;
        File file3;
        String str17;
        File file4;
        File[] listFiles;
        String str18;
        String str19;
        int e2;
        ?? r10;
        String str20;
        FileInputStream fileInputStream;
        int i4;
        int i5;
        String str21;
        String str22;
        String str23;
        String str24;
        ActivityManager activityManager;
        String str25;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        InputStream inputStream2;
        InputStream inputStream3;
        InputStream inputStream4;
        xm r;
        xm r2;
        Util.a q;
        byte[] bArr;
        boolean z12;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2, str, str2, pluginSetting)) != null) {
            return (String) invokeLLLLL.objValue;
        }
        if (file2 != null && file2.exists() && file2.length() > 0) {
            long length = file2.length();
            PackageInfo packageArchiveInfo = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(file2.getAbsolutePath(), 128);
            String str26 = "has_res";
            if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
                str3 = "copy_todest_fail";
            } else {
                str3 = "copy_todest_fail";
                String str27 = packageArchiveInfo.packageName;
                if (str27 != null) {
                    str4 = str27;
                    if (packageArchiveInfo.versionCode != 0) {
                        String i6 = Util.i(applicationInfo);
                        boolean j = Util.j(packageArchiveInfo.applicationInfo);
                        boolean p = Util.p(packageArchiveInfo.applicationInfo);
                        String d2 = Util.d(packageArchiveInfo.applicationInfo);
                        boolean l = Util.l(packageArchiveInfo.applicationInfo);
                        boolean m = Util.m(packageArchiveInfo.applicationInfo);
                        String h = Util.h(packageArchiveInfo.applicationInfo);
                        String str28 = packageArchiveInfo.versionName;
                        i2 = packageArchiveInfo.versionCode;
                        z6 = l;
                        str5 = "has_res";
                        str14 = h;
                        z8 = p;
                        inputStream = d2;
                        z9 = m;
                        str13 = str28;
                        str15 = str4;
                        str4 = "_";
                        z7 = j;
                        str12 = i6;
                        if (!BdBaseApplication.getInst().isDebugMode() || a) {
                            z10 = z9;
                        } else {
                            z10 = z9;
                            if (!q(str15, file2.getAbsolutePath()).a) {
                                if (pluginSetting == null || !str.startsWith("file://")) {
                                    z11 = z8;
                                    str16 = "is_third";
                                    bArr = null;
                                    file3 = file2;
                                    z12 = false;
                                } else {
                                    z11 = z8;
                                    str16 = "is_third";
                                    bArr = null;
                                    file3 = file2;
                                    z12 = a(file3, pluginSetting.tempMd5, null);
                                }
                                if (!z12 && pluginSetting != null) {
                                    boolean a2 = a(file, pluginSetting.tempMd5, bArr);
                                    try {
                                        file2.delete();
                                    } catch (Exception e3) {
                                        BdLog.e(e3);
                                    }
                                    p(str, str15, "signature_not_match", str15 + "-SourceMd5_" + a2 + "-tmpSize_" + length + "-error_" + q.b + "-step_" + q.c);
                                    return null;
                                }
                                ?? r7 = "version_code";
                                boolean z13 = z7;
                                String str29 = str12;
                                if (pluginSetting == null && i2 == (i4 = pluginSetting.versionCode)) {
                                    if (str.startsWith("assets://")) {
                                        File file5 = new File(pluginSetting.apkPath);
                                        boolean exists = file5.exists();
                                        boolean isFile = file5.isFile();
                                        str22 = "install_dest_file";
                                        str23 = "install_src_file";
                                        long length2 = file5.length();
                                        try {
                                            try {
                                                inputStream = new FileInputStream(pluginSetting.apkPath);
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStream3 = inputStream;
                                                inputStream2 = r7;
                                            }
                                            try {
                                                try {
                                                    r = Util.r(inputStream);
                                                    str21 = "version_code";
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    i5 = i2;
                                                    str21 = "version_code";
                                                }
                                                try {
                                                    str24 = "package_name";
                                                    try {
                                                        inputStream4 = BdBaseApplication.getInst().getAssets().open(str.substring(9));
                                                        try {
                                                            if (r.compareTo(Util.r(inputStream4)) == 0) {
                                                                i5 = i2;
                                                                r7 = inputStream4;
                                                            } else {
                                                                i5 = i2;
                                                                try {
                                                                    em.b().m("plugin_install", "versionequals_apktime_notequals", str15, r.toString() + "-" + r2.toString());
                                                                    r7 = inputStream4;
                                                                } catch (Exception e5) {
                                                                    e = e5;
                                                                    BdLog.e(e);
                                                                    em.b().m("plugin_install", "versionequals_apktime_error", str15, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                                                                    r7 = inputStream4;
                                                                    lg.c(inputStream);
                                                                    lg.c(r7);
                                                                    file2.delete();
                                                                    activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                                                    if (activityManager != null) {
                                                                    }
                                                                    str25 = null;
                                                                    em b2 = em.b();
                                                                    String str30 = pluginSetting.packageName;
                                                                    StringBuilder sb = new StringBuilder();
                                                                    sb.append(i4);
                                                                    sb.append(" to ");
                                                                    int i7 = i5;
                                                                    sb.append(i7);
                                                                    sb.append("-instapkpath-");
                                                                    sb.append(pluginSetting.apkPath);
                                                                    sb.append("-md5-");
                                                                    sb.append(pluginSetting.md5);
                                                                    sb.append("-size-");
                                                                    sb.append(pluginSetting.size);
                                                                    sb.append("-newapkfile-");
                                                                    sb.append(file2);
                                                                    sb.append("-size-");
                                                                    sb.append(file2.length());
                                                                    sb.append("-srcpath-");
                                                                    sb.append(str);
                                                                    sb.append("-process-");
                                                                    sb.append(str25);
                                                                    b2.m("plugin_install", "versionCode_is_equals", str30, sb.toString());
                                                                    Intent intent = new Intent("com.baidu.adp.plugin.installcancel");
                                                                    intent.setPackage(BdBaseApplication.getInst().getPackageName());
                                                                    intent.putExtra(str24, str15);
                                                                    intent.putExtra(str23, str);
                                                                    intent.putExtra(str22, str);
                                                                    intent.putExtra(str21, i7);
                                                                    BdStatisticsManager.getInstance().save();
                                                                    BdBaseApplication.getInst().sendBroadcast(intent);
                                                                    return null;
                                                                }
                                                            }
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            i5 = i2;
                                                        }
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                        i5 = i2;
                                                        inputStream4 = null;
                                                        BdLog.e(e);
                                                        em.b().m("plugin_install", "versionequals_apktime_error", str15, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                                                        r7 = inputStream4;
                                                        lg.c(inputStream);
                                                        lg.c(r7);
                                                        file2.delete();
                                                        activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                                        if (activityManager != null) {
                                                        }
                                                        str25 = null;
                                                        em b22 = em.b();
                                                        String str302 = pluginSetting.packageName;
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append(i4);
                                                        sb2.append(" to ");
                                                        int i72 = i5;
                                                        sb2.append(i72);
                                                        sb2.append("-instapkpath-");
                                                        sb2.append(pluginSetting.apkPath);
                                                        sb2.append("-md5-");
                                                        sb2.append(pluginSetting.md5);
                                                        sb2.append("-size-");
                                                        sb2.append(pluginSetting.size);
                                                        sb2.append("-newapkfile-");
                                                        sb2.append(file2);
                                                        sb2.append("-size-");
                                                        sb2.append(file2.length());
                                                        sb2.append("-srcpath-");
                                                        sb2.append(str);
                                                        sb2.append("-process-");
                                                        sb2.append(str25);
                                                        b22.m("plugin_install", "versionCode_is_equals", str302, sb2.toString());
                                                        Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
                                                        intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                                                        intent2.putExtra(str24, str15);
                                                        intent2.putExtra(str23, str);
                                                        intent2.putExtra(str22, str);
                                                        intent2.putExtra(str21, i72);
                                                        BdStatisticsManager.getInstance().save();
                                                        BdBaseApplication.getInst().sendBroadcast(intent2);
                                                        return null;
                                                    }
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    i5 = i2;
                                                    str24 = "package_name";
                                                    inputStream4 = null;
                                                    BdLog.e(e);
                                                    em.b().m("plugin_install", "versionequals_apktime_error", str15, "exist-" + exists + "-isfile-" + isFile + "-length-" + length2 + "-" + e.getMessage());
                                                    r7 = inputStream4;
                                                    lg.c(inputStream);
                                                    lg.c(r7);
                                                    file2.delete();
                                                    activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                                    if (activityManager != null) {
                                                    }
                                                    str25 = null;
                                                    em b222 = em.b();
                                                    String str3022 = pluginSetting.packageName;
                                                    StringBuilder sb22 = new StringBuilder();
                                                    sb22.append(i4);
                                                    sb22.append(" to ");
                                                    int i722 = i5;
                                                    sb22.append(i722);
                                                    sb22.append("-instapkpath-");
                                                    sb22.append(pluginSetting.apkPath);
                                                    sb22.append("-md5-");
                                                    sb22.append(pluginSetting.md5);
                                                    sb22.append("-size-");
                                                    sb22.append(pluginSetting.size);
                                                    sb22.append("-newapkfile-");
                                                    sb22.append(file2);
                                                    sb22.append("-size-");
                                                    sb22.append(file2.length());
                                                    sb22.append("-srcpath-");
                                                    sb22.append(str);
                                                    sb22.append("-process-");
                                                    sb22.append(str25);
                                                    b222.m("plugin_install", "versionCode_is_equals", str3022, sb22.toString());
                                                    Intent intent22 = new Intent("com.baidu.adp.plugin.installcancel");
                                                    intent22.setPackage(BdBaseApplication.getInst().getPackageName());
                                                    intent22.putExtra(str24, str15);
                                                    intent22.putExtra(str23, str);
                                                    intent22.putExtra(str22, str);
                                                    intent22.putExtra(str21, i722);
                                                    BdStatisticsManager.getInstance().save();
                                                    BdBaseApplication.getInst().sendBroadcast(intent22);
                                                    return null;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                inputStream3 = inputStream;
                                                inputStream2 = null;
                                                lg.c(inputStream3);
                                                lg.c(inputStream2);
                                                throw th;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            i5 = i2;
                                            str21 = "version_code";
                                            str24 = "package_name";
                                            inputStream4 = null;
                                            inputStream = null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream2 = null;
                                            inputStream3 = null;
                                        }
                                        lg.c(inputStream);
                                        lg.c(r7);
                                    } else {
                                        i5 = i2;
                                        str21 = "version_code";
                                        str22 = "install_dest_file";
                                        str23 = "install_src_file";
                                        str24 = "package_name";
                                    }
                                    try {
                                        file2.delete();
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                    }
                                    activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity");
                                    if (activityManager != null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                                        str25 = null;
                                    } else {
                                        str25 = null;
                                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                                            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                                                str25 = runningAppProcessInfo.processName;
                                            }
                                        }
                                    }
                                    em b2222 = em.b();
                                    String str30222 = pluginSetting.packageName;
                                    StringBuilder sb222 = new StringBuilder();
                                    sb222.append(i4);
                                    sb222.append(" to ");
                                    int i7222 = i5;
                                    sb222.append(i7222);
                                    sb222.append("-instapkpath-");
                                    sb222.append(pluginSetting.apkPath);
                                    sb222.append("-md5-");
                                    sb222.append(pluginSetting.md5);
                                    sb222.append("-size-");
                                    sb222.append(pluginSetting.size);
                                    sb222.append("-newapkfile-");
                                    sb222.append(file2);
                                    sb222.append("-size-");
                                    sb222.append(file2.length());
                                    sb222.append("-srcpath-");
                                    sb222.append(str);
                                    sb222.append("-process-");
                                    sb222.append(str25);
                                    b2222.m("plugin_install", "versionCode_is_equals", str30222, sb222.toString());
                                    Intent intent222 = new Intent("com.baidu.adp.plugin.installcancel");
                                    intent222.setPackage(BdBaseApplication.getInst().getPackageName());
                                    intent222.putExtra(str24, str15);
                                    intent222.putExtra(str23, str);
                                    intent222.putExtra(str22, str);
                                    intent222.putExtra(str21, i7222);
                                    BdStatisticsManager.getInstance().save();
                                    BdBaseApplication.getInst().sendBroadcast(intent222);
                                    return null;
                                }
                                int i8 = i2;
                                if (str.startsWith("assets://")) {
                                    str17 = "plugin_install";
                                    if (!str15.equals(str.substring(str.lastIndexOf("/") + 1, str.lastIndexOf(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)))) {
                                        ii.n(file2);
                                        p(str, str15, "filename_packagename_not_match", null);
                                        BdLog.e(str + " must be named with it's package name : " + str15 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                                        return null;
                                    }
                                } else {
                                    str17 = "plugin_install";
                                }
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str15);
                                String str31 = str4;
                                sb3.append(str31);
                                String str32 = inputStream;
                                sb3.append(System.currentTimeMillis());
                                sb3.append(str31);
                                sb3.append(i8);
                                String sb4 = sb3.toString();
                                String str33 = "-";
                                file4 = new File(Util.g(), sb4 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                                if (!file3.equals(file4)) {
                                    String parent = file2.getParent();
                                    String parent2 = file4.getParent();
                                    try {
                                        if (parent.equals(parent2)) {
                                            try {
                                                if (file3.renameTo(file4)) {
                                                    if (!file4.exists() || file4.length() == 0) {
                                                        throw new Exception("rename fail");
                                                    }
                                                } else {
                                                    throw new Exception("rename return fail");
                                                }
                                            } catch (Exception e11) {
                                                try {
                                                    file4.delete();
                                                    ii.f(file3, file4);
                                                    file2.delete();
                                                } catch (IOException e12) {
                                                    if (file2.exists()) {
                                                        ii.n(file2);
                                                    }
                                                    BdLog.e(e12);
                                                    p(str, str15, "rename_todest_fail", e11.getMessage());
                                                    return null;
                                                }
                                            }
                                        } else {
                                            try {
                                                fileInputStream = new FileInputStream(file3);
                                                try {
                                                    Util.a b3 = Util.b(fileInputStream, file4);
                                                    file2.delete();
                                                    if (!b3.a) {
                                                        str20 = str3;
                                                        try {
                                                            p(str, str15, str20, b3.b);
                                                            lg.c(fileInputStream);
                                                            return null;
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            BdLog.e(e);
                                                            if (file4.exists()) {
                                                                ii.n(file4);
                                                            }
                                                            p(str, str15, str20, e.getMessage());
                                                            lg.c(fileInputStream);
                                                            return null;
                                                        }
                                                    }
                                                    lg.c(fileInputStream);
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    str20 = str3;
                                                }
                                            } catch (Exception e15) {
                                                e = e15;
                                                str20 = str3;
                                                fileInputStream = null;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                r10 = 0;
                                                lg.c(r10);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        r10 = parent2;
                                    }
                                }
                                File file6 = new File(Util.g(), sb4);
                                file6.mkdir();
                                File file7 = new File(file6, "lib");
                                file7.mkdir();
                                long currentTimeMillis = System.currentTimeMillis();
                                j(file4.getAbsolutePath(), file7.getAbsolutePath(), str15);
                                String str34 = str31;
                                em.b().l("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis, str15);
                                long currentTimeMillis2 = System.currentTimeMillis();
                                i(file4.getAbsolutePath(), str15, file6);
                                em.b().l("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis2, str15);
                                b.put(str2 + str, Boolean.TRUE);
                                Intent intent3 = new Intent("com.baidu.adp.plugin.installed");
                                intent3.setPackage(BdBaseApplication.getInst().getPackageName());
                                intent3.putExtra("package_name", str15);
                                intent3.putExtra("install_src_file", str);
                                intent3.putExtra("install_dest_file", file4.getAbsolutePath());
                                intent3.putExtra("version_code", i8);
                                intent3.putExtra("version_name", str13);
                                intent3.putExtra("cmd_range", str32);
                                intent3.putExtra("require_load", str29);
                                intent3.putExtra(str5, z13);
                                intent3.putExtra(str16, z11);
                                intent3.putExtra("is_patch", z10);
                                intent3.putExtra("replace_method_classes", str14);
                                intent3.putExtra("is_inject_classloader", z6);
                                intent3.putExtra("install_flag", c);
                                BdStatisticsManager.getInstance().save();
                                BdBaseApplication.getInst().sendOrderedBroadcast(intent3, null);
                                listFiles = Util.g().listFiles();
                                if (listFiles != null) {
                                    int length3 = listFiles.length;
                                    int i9 = 0;
                                    while (true) {
                                        if (i9 >= length3) {
                                            break;
                                        }
                                        File file8 = listFiles[i9];
                                        if (file8 != null && file8.isDirectory()) {
                                            String name = file8.getName();
                                            if (name.startsWith(str15) && !name.equals(sb4)) {
                                                str19 = str34;
                                                int lastIndexOf = name.lastIndexOf(str19);
                                                if (lastIndexOf > 0 && (e2 = mg.e(name.substring(lastIndexOf + 1), -1)) > 0 && e2 == i8) {
                                                    break;
                                                }
                                                str18 = str17;
                                                i9++;
                                                str17 = str18;
                                                str33 = str33;
                                                str34 = str19;
                                            }
                                        }
                                        str18 = str17;
                                        str19 = str34;
                                        i9++;
                                        str17 = str18;
                                        str33 = str33;
                                        str34 = str19;
                                    }
                                }
                                return str15;
                            }
                        }
                        z11 = z8;
                        str16 = "is_third";
                        file3 = file2;
                        ?? r72 = "version_code";
                        boolean z132 = z7;
                        String str292 = str12;
                        if (pluginSetting == null) {
                        }
                        int i82 = i2;
                        if (str.startsWith("assets://")) {
                        }
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append(str15);
                        String str312 = str4;
                        sb32.append(str312);
                        String str322 = inputStream;
                        sb32.append(System.currentTimeMillis());
                        sb32.append(str312);
                        sb32.append(i82);
                        String sb42 = sb32.toString();
                        String str332 = "-";
                        file4 = new File(Util.g(), sb42 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        if (!file3.equals(file4)) {
                        }
                        File file62 = new File(Util.g(), sb42);
                        file62.mkdir();
                        File file72 = new File(file62, "lib");
                        file72.mkdir();
                        long currentTimeMillis3 = System.currentTimeMillis();
                        j(file4.getAbsolutePath(), file72.getAbsolutePath(), str15);
                        String str342 = str312;
                        em.b().l("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis3, str15);
                        long currentTimeMillis22 = System.currentTimeMillis();
                        i(file4.getAbsolutePath(), str15, file62);
                        em.b().l("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis22, str15);
                        b.put(str2 + str, Boolean.TRUE);
                        Intent intent32 = new Intent("com.baidu.adp.plugin.installed");
                        intent32.setPackage(BdBaseApplication.getInst().getPackageName());
                        intent32.putExtra("package_name", str15);
                        intent32.putExtra("install_src_file", str);
                        intent32.putExtra("install_dest_file", file4.getAbsolutePath());
                        intent32.putExtra("version_code", i82);
                        intent32.putExtra("version_name", str13);
                        intent32.putExtra("cmd_range", str322);
                        intent32.putExtra("require_load", str292);
                        intent32.putExtra(str5, z132);
                        intent32.putExtra(str16, z11);
                        intent32.putExtra("is_patch", z10);
                        intent32.putExtra("replace_method_classes", str14);
                        intent32.putExtra("is_inject_classloader", z6);
                        intent32.putExtra("install_flag", c);
                        BdStatisticsManager.getInstance().save();
                        BdBaseApplication.getInst().sendOrderedBroadcast(intent32, null);
                        listFiles = Util.g().listFiles();
                        if (listFiles != null) {
                        }
                        return str15;
                    }
                }
            }
            ZipFile zipFile = new ZipFile(file2, 1);
            ZipEntry entry = zipFile.getEntry("assets/AndroidManifest.xml");
            if (entry == null) {
                try {
                    file2.delete();
                } catch (Exception e16) {
                    BdLog.e(e16);
                }
                p(str, str2, "assetsmanifestnull", "avirom-" + Util.c() + "-filesize-" + length + "-exp-" + ((String) null));
                return null;
            }
            str4 = "_";
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(zipFile.getInputStream(entry))).getDocumentElement();
            String attribute2 = documentElement.getAttribute("package");
            int i10 = Integer.parseInt(documentElement.getAttribute("android:versionCode"));
            try {
                attribute = documentElement.getAttribute("android:versionName");
                try {
                    elementsByTagName = documentElement.getElementsByTagName("meta-data");
                } catch (Exception e17) {
                    e = e17;
                    str8 = attribute;
                    str5 = "has_res";
                    str6 = null;
                    str7 = null;
                    z = false;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                }
            } catch (Exception e18) {
                e = e18;
                str5 = "has_res";
                str6 = null;
                str7 = null;
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                str8 = null;
                str10 = str7;
                z5 = z4;
                str11 = null;
                int i11 = i10;
                str9 = e.toString();
                i = i11;
                if (TextUtils.isEmpty(str11)) {
                }
            }
            if (elementsByTagName != null) {
                if (elementsByTagName.getLength() > 0) {
                    i3 = i10;
                    int i12 = 0;
                    str6 = null;
                    str7 = null;
                    z = false;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    while (i12 < elementsByTagName.getLength()) {
                        try {
                            Node item = elementsByTagName.item(i12);
                            if (item == null || (attributes = item.getAttributes()) == null) {
                                nodeList = elementsByTagName;
                            } else {
                                nodeList = elementsByTagName;
                                Node namedItem2 = attributes.getNamedItem("android:name");
                                if (namedItem2 != null && namedItem2.getNodeValue() != null) {
                                    str8 = attribute;
                                    try {
                                        if (namedItem2.getNodeValue().equals("is_inject_classloader")) {
                                            Node namedItem3 = attributes.getNamedItem("android:value");
                                            if (namedItem3 != null && namedItem3.getNodeValue() != null) {
                                                z4 = Boolean.parseBoolean(namedItem3.getNodeValue());
                                            }
                                        } else if (namedItem2.getNodeValue().equals(str26)) {
                                            Node namedItem4 = attributes.getNamedItem("android:value");
                                            if (namedItem4 != null && namedItem4.getNodeValue() != null) {
                                                try {
                                                    z = Boolean.parseBoolean(namedItem4.getNodeValue());
                                                } catch (Exception unused) {
                                                }
                                            }
                                        } else if (namedItem2.getNodeValue().equals("require_load")) {
                                            Node namedItem5 = attributes.getNamedItem("android:value");
                                            str7 = (namedItem5 == null || namedItem5.getNodeValue() == null) ? str7 : namedItem5.getNodeValue();
                                        } else {
                                            str5 = str26;
                                            try {
                                                if (namedItem2.getNodeValue().equals("cmd_range_0")) {
                                                    Node namedItem6 = attributes.getNamedItem("android:value");
                                                    if (namedItem6 != null && namedItem6.getNodeValue() != null) {
                                                        str6 = namedItem6.getNodeValue();
                                                    }
                                                } else if (namedItem2.getNodeValue().equals("is_third")) {
                                                    Node namedItem7 = attributes.getNamedItem("android:value");
                                                    if (namedItem7 != null && namedItem7.getNodeValue() != null) {
                                                        try {
                                                            z2 = Boolean.parseBoolean(namedItem7.getNodeValue());
                                                        } catch (Exception unused2) {
                                                        }
                                                    }
                                                } else if (namedItem2.getNodeValue().equals("is_patch") && (namedItem = attributes.getNamedItem("android:value")) != null && namedItem.getNodeValue() != null) {
                                                    z3 = Boolean.parseBoolean(namedItem.getNodeValue());
                                                }
                                                i12++;
                                                elementsByTagName = nodeList;
                                                attribute = str8;
                                                str26 = str5;
                                            } catch (Exception e19) {
                                                e = e19;
                                                i10 = i3;
                                                str10 = str7;
                                                z5 = z4;
                                                str11 = null;
                                                int i112 = i10;
                                                str9 = e.toString();
                                                i = i112;
                                                if (TextUtils.isEmpty(str11)) {
                                                }
                                            }
                                        }
                                        str5 = str26;
                                        i12++;
                                        elementsByTagName = nodeList;
                                        attribute = str8;
                                        str26 = str5;
                                    } catch (Exception e20) {
                                        e = e20;
                                        str5 = str26;
                                        i10 = i3;
                                        str10 = str7;
                                        z5 = z4;
                                        str11 = null;
                                        int i1122 = i10;
                                        str9 = e.toString();
                                        i = i1122;
                                        if (TextUtils.isEmpty(str11)) {
                                        }
                                    }
                                }
                            }
                            str8 = attribute;
                            str5 = str26;
                            i12++;
                            elementsByTagName = nodeList;
                            attribute = str8;
                            str26 = str5;
                        } catch (Exception e21) {
                            e = e21;
                            str8 = attribute;
                        }
                    }
                    str8 = attribute;
                    str5 = str26;
                    str11 = attribute2;
                    str10 = str7;
                    z5 = z4;
                    i = i3;
                    str9 = null;
                    if (TextUtils.isEmpty(str11)) {
                        try {
                            file2.delete();
                        } catch (Exception e22) {
                            BdLog.e(e22);
                        }
                        p(str, str2, "getpackageinfo_fail", "avirom-" + Util.c() + "-filesize-" + length + "-exp-" + str9);
                        return null;
                    }
                    em.b().i("plugin_xml_parse", str11);
                    str12 = str10;
                    z6 = z5;
                    inputStream = str6;
                    z7 = z;
                    z8 = z2;
                    z9 = z3;
                    str13 = str8;
                    str14 = null;
                    str15 = str11;
                    i2 = i;
                    if (BdBaseApplication.getInst().isDebugMode()) {
                    }
                    z10 = z9;
                    z11 = z8;
                    str16 = "is_third";
                    file3 = file2;
                    ?? r722 = "version_code";
                    boolean z1322 = z7;
                    String str2922 = str12;
                    if (pluginSetting == null) {
                    }
                    int i822 = i2;
                    if (str.startsWith("assets://")) {
                    }
                    StringBuilder sb322 = new StringBuilder();
                    sb322.append(str15);
                    String str3122 = str4;
                    sb322.append(str3122);
                    String str3222 = inputStream;
                    sb322.append(System.currentTimeMillis());
                    sb322.append(str3122);
                    sb322.append(i822);
                    String sb422 = sb322.toString();
                    String str3322 = "-";
                    file4 = new File(Util.g(), sb422 + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                    if (!file3.equals(file4)) {
                    }
                    File file622 = new File(Util.g(), sb422);
                    file622.mkdir();
                    File file722 = new File(file622, "lib");
                    file722.mkdir();
                    long currentTimeMillis32 = System.currentTimeMillis();
                    j(file4.getAbsolutePath(), file722.getAbsolutePath(), str15);
                    String str3422 = str3122;
                    em.b().l("plugin_extract_so", System.currentTimeMillis() - currentTimeMillis32, str15);
                    long currentTimeMillis222 = System.currentTimeMillis();
                    i(file4.getAbsolutePath(), str15, file622);
                    em.b().l("plugin_extract_dex", System.currentTimeMillis() - currentTimeMillis222, str15);
                    b.put(str2 + str, Boolean.TRUE);
                    Intent intent322 = new Intent("com.baidu.adp.plugin.installed");
                    intent322.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent322.putExtra("package_name", str15);
                    intent322.putExtra("install_src_file", str);
                    intent322.putExtra("install_dest_file", file4.getAbsolutePath());
                    intent322.putExtra("version_code", i822);
                    intent322.putExtra("version_name", str13);
                    intent322.putExtra("cmd_range", str3222);
                    intent322.putExtra("require_load", str2922);
                    intent322.putExtra(str5, z1322);
                    intent322.putExtra(str16, z11);
                    intent322.putExtra("is_patch", z10);
                    intent322.putExtra("replace_method_classes", str14);
                    intent322.putExtra("is_inject_classloader", z6);
                    intent322.putExtra("install_flag", c);
                    BdStatisticsManager.getInstance().save();
                    BdBaseApplication.getInst().sendOrderedBroadcast(intent322, null);
                    listFiles = Util.g().listFiles();
                    if (listFiles != null) {
                    }
                    return str15;
                }
            }
            i3 = i10;
            str8 = attribute;
            str5 = "has_res";
            str6 = null;
            str7 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            str11 = attribute2;
            str10 = str7;
            z5 = z4;
            i = i3;
            str9 = null;
            if (TextUtils.isEmpty(str11)) {
            }
        } else {
            p(str, str2, "tempfile_not_exist", file2 == null ? StringUtil.NULL_STRING : file2.exists() + "_" + file2.length());
            return null;
        }
    }

    public static void e(ZipFile zipFile, String str, ArrayList<ZipEntry> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, zipFile, str, arrayList) == null) || zipFile == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<ZipEntry> it = arrayList.iterator();
        while (it.hasNext()) {
            ZipEntry next = it.next();
            InputStream inputStream = null;
            try {
                try {
                    String name = next.getName();
                    int lastIndexOf = name.lastIndexOf("/");
                    inputStream = zipFile.getInputStream(next);
                    Util.b(inputStream, new File(str, name.substring(lastIndexOf)));
                } catch (IOException e2) {
                    BdLog.e(e2);
                }
            } finally {
                lg.c(inputStream);
            }
        }
    }

    public static void f(String str, String str2, PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, pluginSetting) == null) {
            if (TextUtils.isEmpty(str)) {
                p(str, str2, "srcfile_empty", "");
                em.b().o("plugin_install", "srcfile_empty", str2);
            } else if (str.startsWith("assets://")) {
                h(str, str2, pluginSetting);
            } else if (str.startsWith("file://")) {
                g(str, str2, pluginSetting);
            } else {
                p(str, str2, "srcfile_illegal", "");
                em.b().o("plugin_install", "srcfile_illegal", str2);
            }
        }
    }

    public static void g(String str, String str2, PluginSetting pluginSetting) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65543, null, str, str2, pluginSetting) != null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            p(str, str2, "do_install", "");
            em.b().o("plugin_install", "pkgname_null", str2);
            return;
        }
        String substring = str.substring(7);
        File file = new File(substring);
        if (!file.exists()) {
            p(str, str2, "apk_not_exist", "file_not_exists-apkFilePath_" + substring);
            em b2 = em.b();
            b2.m("plugin_install", "service_apk_not_exist", str2, c + "_" + substring);
            return;
        }
        int i2 = 0;
        try {
            int lastIndexOf = substring.lastIndexOf("_");
            int e2 = lastIndexOf > 0 ? mg.e(substring.substring(lastIndexOf + 1), -1) : -1;
            if (e2 > 0) {
                if (e2 < PluginPackageManager.o()) {
                    em b3 = em.b();
                    b3.m("plugin_install", "low_version_code", str2, " vc=" + String.valueOf(e2) + " tiebaVC=" + PluginPackageManager.o());
                    Intent intent = new Intent("com.baidu.adp.plugin.deleted");
                    intent.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent.putExtra("package_name", str2);
                    intent.putExtra("install_src_file", str);
                    intent.putExtra("fail_reason", "low_version_code");
                    intent.putExtra("version_code", e2);
                    BdBaseApplication.getInst().sendBroadcast(intent);
                    return;
                } else if (pluginSetting != null && e2 == (i = pluginSetting.versionCode)) {
                    em b4 = em.b();
                    String str3 = pluginSetting.packageName;
                    b4.m("plugin_install", "versionCode_is_equals", str3, i + " to " + e2 + "-instapkpath-" + pluginSetting.apkPath + "-md5-" + pluginSetting.md5 + "-size-" + pluginSetting.size + "-newapkfile-" + file + "-size-" + file.length() + "-srcpath-" + str);
                    Intent intent2 = new Intent("com.baidu.adp.plugin.installcancel");
                    intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent2.putExtra("package_name", str2);
                    intent2.putExtra("install_src_file", str);
                    intent2.putExtra("install_dest_file", str);
                    intent2.putExtra("version_code", e2);
                    BdStatisticsManager.getInstance().save();
                    BdBaseApplication.getInst().sendBroadcast(intent2);
                    return;
                }
            }
            try {
                if (!Util.o(file.length())) {
                    p(str, str2, "rom_size", String.valueOf(Util.c()));
                } else {
                    l(file, str, str2, pluginSetting);
                }
            } catch (Exception e3) {
                e = e3;
                i2 = 1;
                BdLog.e(e);
                p(str, str2, "open_apk", e.toString());
                em b5 = em.b();
                b5.p("plugin_install", "open_files_failed", str2, e.getMessage() + "---" + e.getClass().getName() + "---step_" + i2);
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static void h(String str, String str2, PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, pluginSetting) == null) {
            if (TextUtils.isEmpty(str)) {
                p(str, str2, "do_install", "");
                em.b().o("plugin_install", "pkgname_null", str2);
                return;
            }
            String substring = str.substring(9);
            InputStream inputStream = null;
            try {
                try {
                    inputStream = BdBaseApplication.getInst().getAssets().open(substring);
                } catch (Exception e2) {
                    BdLog.e(e2);
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    if (!ni.isEmpty(substring) && substring.startsWith("plugins/")) {
                        String substring2 = substring.substring(8);
                        try {
                            String[] list = BdBaseApplication.getInst().getAssets().list("plugins");
                            if (!ni.isEmpty(substring2) && list != null && list.length > 0) {
                                int i = 0;
                                while (true) {
                                    if (i >= list.length) {
                                        break;
                                    } else if (substring2.equals(list[i])) {
                                        z = false;
                                        break;
                                    } else {
                                        sb.append(list[i]);
                                        i++;
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (z) {
                        p(str, str2, "assets_not_found", sb.toString());
                    } else {
                        p(str, str2, "open_assets", "assetsPath-" + substring + "-exp-" + e2.toString());
                    }
                    em b2 = em.b();
                    b2.p("plugin_install", "open_assets_failed", str2, e2.getMessage() + "---" + e2.getClass().getName());
                }
                if (!Util.o(inputStream.available())) {
                    p(str, str2, "rom_size", String.valueOf(Util.c()));
                } else {
                    m(inputStream, str, str2, pluginSetting);
                }
            } finally {
                lg.c(null);
            }
        }
    }

    public static void i(String str, String str2, File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, str, str2, file) == null) || file == null) {
            return;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            em.b().m("plugin_install", "dexopt_file_illegal", str2, file2.getAbsolutePath());
        }
        if (file2.length() == 0) {
            em b2 = em.b();
            b2.m("plugin_install", "dexopt_file_empty", str2, file2.getAbsolutePath() + "---" + file2.length());
        }
        DexClassLoader dexClassLoader = null;
        try {
            dexClassLoader = new DexClassLoader(str, file.getAbsolutePath(), null, BdBaseApplication.getInst().getClassLoader());
        } catch (Exception e2) {
            em b3 = em.b();
            b3.m("plugin_install", "new_dexloader", str2, e2.getMessage() + "---" + e2.getClass().getName());
            BdLog.e(e2);
        }
        if (dexClassLoader != null) {
            try {
                dexClassLoader.loadClass(str2 + ".Static");
            } catch (ClassNotFoundException e3) {
                em.b().m("plugin_install", "loadR", str2, e3.getMessage());
                BdLog.e(e3);
            } catch (Exception e4) {
                em b4 = em.b();
                b4.m("plugin_install", "loadR2", str2, e4.getMessage() + "---" + e4.getClass().getName());
                BdLog.e(e4);
            }
        }
    }

    public static void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String lowerCase = Build.CPU_ABI.toLowerCase();
        String str4 = "none";
        if (Build.VERSION.SDK_INT > 7) {
            try {
                String str5 = (String) Build.class.getDeclaredField("CPU_ABI2").get(Build.class);
                try {
                    str4 = str5.toLowerCase();
                } catch (Throwable unused) {
                    str4 = str5;
                }
            } catch (Throwable unused2) {
            }
        }
        String str6 = str4;
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(str);
        } catch (IOException e2) {
            BdLog.e(e2);
        }
        if (zipFile == null) {
            return;
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            Enumeration<? extends ZipEntry> enumeration = entries;
            if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && name.endsWith(".so")) {
                String substring = name.substring(PluginInstallerService.APK_LIB_CPUABI_OFFSITE, name.lastIndexOf("/"));
                if (substring.toLowerCase().contains("mips")) {
                    arrayList3.add(nextElement);
                } else if (substring.toLowerCase().contains("x86")) {
                    arrayList2.add(nextElement);
                } else if (substring.toLowerCase().contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A)) {
                    arrayList4.add(nextElement);
                } else {
                    arrayList.add(nextElement);
                }
            }
            entries = enumeration;
        }
        if (!lowerCase.contains("x86") && !str6.contains("x86")) {
            if (!lowerCase.contains("mips") && !str6.contains("mips")) {
                if (!lowerCase.contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) && !str6.contains(PassBiometricUtil.CPU_TYPE_ARMEABI_V7A) && !k()) {
                    if (!lowerCase.contains("armeabi") && !str6.contains("armeabi")) {
                        em.b().g("plugin_cpuarch_judge_fail");
                        em b2 = em.b();
                        b2.m("plugin_install", "cpuarch_judge_fail", str3, lowerCase + "-" + str6);
                        e(zipFile, str2, arrayList);
                        if (arrayList.size() <= 0) {
                            return;
                        }
                    } else {
                        e(zipFile, str2, arrayList);
                        if (arrayList.size() <= 0) {
                            return;
                        }
                    }
                } else {
                    n(arrayList4, arrayList);
                    e(zipFile, str2, arrayList4);
                    if (arrayList4.size() <= 0) {
                        return;
                    }
                }
            } else {
                n(arrayList3, arrayList);
                e(zipFile, str2, arrayList3);
                if (arrayList3.size() <= 0) {
                    return;
                }
            }
        } else {
            n(arrayList2, arrayList);
            e(zipFile, str2, arrayList2);
            if (arrayList2.size() <= 0) {
                return;
            }
        }
        File file = new File(str);
        File parentFile = file.getParentFile();
        File file2 = new File(parentFile, file.getName() + "_tmp");
        try {
            if (c(zipFile, new File(new File(str2).getParentFile(), "tmp"), file2, str3)) {
                if (file2.renameTo(file)) {
                    return;
                }
                em.b().m("plugin_install", "delete_so", str3, "delete so suc but rename fail");
                file2.delete();
            } else {
                em.b().m("plugin_install", "delete_so", str3, "delete so fail");
                file2.delete();
            }
        } catch (Exception unused3) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0109 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0127 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x0011 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static boolean k() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (e) {
                return d;
            }
            boolean z = true;
            e = true;
            BufferedReader bufferedReader2 = 0;
            try {
                try {
                    fileInputStream = new FileInputStream("/proc/cpuinfo");
                    try {
                        inputStreamReader = new InputStreamReader(fileInputStream);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        inputStreamReader = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStreamReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                inputStreamReader = null;
            }
            try {
                int i = 2;
                Object[] objArr = {-1, -1, -1};
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(":");
                    if (split.length == i) {
                        String trim = split[0].trim();
                        String trim2 = split[z ? 1 : 0].trim();
                        if (trim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int indexOf = trim2.indexOf("ARMv") + 4; indexOf < trim2.length(); indexOf++) {
                                String str = trim2.charAt(indexOf) + "";
                                if (!str.matches("\\d")) {
                                    break;
                                }
                                sb.append(str);
                            }
                            objArr[0] = com.kuaishou.weapon.un.w0.j1;
                            objArr[1] = Integer.valueOf(mg.e(sb.toString(), -1));
                        } else if (trim.compareToIgnoreCase("Features") == 0) {
                            if (trim2.contains("neon")) {
                                objArr[2] = "neon";
                            }
                        } else {
                            if (trim.compareToIgnoreCase("model name") == 0) {
                                if (trim2.contains(com.kuaishou.weapon.un.w0.o1)) {
                                    objArr[0] = "INTEL";
                                    i = 2;
                                    objArr[2] = "atom";
                                }
                            } else {
                                i = 2;
                                if (trim.compareToIgnoreCase("cpu family") == 0) {
                                    objArr[1] = Integer.valueOf(mg.e(trim2, -1));
                                }
                            }
                            z = true;
                        }
                        z = true;
                        i = 2;
                    }
                }
                int intValue = ((Integer) objArr[z ? 1 : 0]).intValue();
                bufferedReader2 = 7;
                if (intValue != 7) {
                    z = false;
                }
                d = z;
                pi.g(bufferedReader);
            } catch (Exception e5) {
                e = e5;
                bufferedReader2 = bufferedReader;
                BdLog.e(e);
                pi.g(bufferedReader2);
                bufferedReader2 = bufferedReader2;
                pi.g(inputStreamReader);
                pi.e(fileInputStream);
                return d;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = bufferedReader;
                pi.g(bufferedReader2);
                pi.g(inputStreamReader);
                pi.e(fileInputStream);
                throw th;
            }
            pi.g(inputStreamReader);
            pi.e(fileInputStream);
            return d;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00c2 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    public static String l(File file, String str, String str2, PluginSetting pluginSetting) {
        InterceptResult invokeLLLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, file, str, str2, pluginSetting)) == null) {
            File file2 = new File(Util.g(), String.valueOf(System.currentTimeMillis()));
            String absolutePath = file.getAbsolutePath();
            long length = file.length();
            try {
                if (file2.exists()) {
                    ii.n(file2);
                }
                ii.f(file, file2);
                if (file2.length() != length) {
                    throw new Exception("size_not_match1_" + file2.length() + "_" + length);
                }
            } catch (Exception e2) {
                if (file2.exists()) {
                    ii.n(file2);
                }
                ?? r10 = 0;
                try {
                    try {
                        File file3 = new File(absolutePath);
                        fileInputStream = new FileInputStream(file3);
                        try {
                            Util.a b2 = Util.b(fileInputStream, file2);
                            if (b2.a) {
                                if (file2.length() == file3.length()) {
                                    lg.c(fileInputStream);
                                } else {
                                    throw new Exception("size_not_match2_" + file2.length() + "_" + file3.length());
                                }
                            } else {
                                ii.n(file2);
                                throw new Exception(b2.b);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            p(str, str2, "file_copy_temp_fail", "filesize_" + length + "-exception_" + e2.toString() + "-exception1_" + e.toString());
                            lg.c(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r10 = absolutePath;
                        lg.c(r10);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    lg.c(r10);
                    throw th;
                }
            }
            return d(file, file2, str, str2, pluginSetting);
        }
        return (String) invokeLLLL.objValue;
    }

    public static String m(InputStream inputStream, String str, String str2, PluginSetting pluginSetting) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, inputStream, str, str2, pluginSetting)) == null) {
            if (inputStream != null && str != null) {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(Util.g(), String.valueOf(System.currentTimeMillis()));
                Util.a b2 = Util.b(inputStream, file);
                if (!b2.a) {
                    try {
                        file.delete();
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                    p(str, str2, "assets_copy_temp_fail", b2.b);
                    return null;
                }
                em.b().l("plugin_copy_file", System.currentTimeMillis() - currentTimeMillis, str2);
                return d(null, file, str, str2, pluginSetting);
            }
            p(str, str2, "do_install", "");
            em.b().o("plugin_install", "doinstall_param_null", str2);
            return null;
        }
        return (String) invokeLLLL.objValue;
    }

    public static void n(ArrayList<ZipEntry> arrayList, ArrayList<ZipEntry> arrayList2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, arrayList, arrayList2) == null) || arrayList == null || arrayList2 == null) {
            return;
        }
        Iterator<ZipEntry> it = arrayList2.iterator();
        while (it.hasNext()) {
            ZipEntry next = it.next();
            if (!b(arrayList, next)) {
                arrayList.add(next);
            }
        }
    }

    public static void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, intent) == null) {
            PluginSetting pluginSetting = null;
            if (intent == null) {
                em.b().o("plugin_install", "handle_intent_null", null);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                em.b().o("plugin_install", "intent_action_null", null);
                return;
            }
            a = intent.getBooleanExtra("is_debug_plugin", false);
            if (action.equals(PluginInstallerService.ACTION_INSTALL)) {
                String stringExtra = intent.getStringExtra("install_src_file");
                String stringExtra2 = intent.getStringExtra("package_name");
                String stringExtra3 = intent.getStringExtra("install_flag");
                c = stringExtra3;
                if (stringExtra3 == null) {
                    c = "f" + System.currentTimeMillis();
                }
                em.b().m("plugin_install", "install_service_start", stringExtra2, c);
                try {
                    pluginSetting = (PluginSetting) intent.getSerializableExtra("plugin_setting");
                } catch (Throwable unused) {
                }
                PluginSetting g = om.h().g(stringExtra2);
                if (g != null && g.installStatus == 0 && g.tempVersionCode == 0) {
                    int lastIndexOf = stringExtra.lastIndexOf("_");
                    int e2 = lastIndexOf > 0 ? mg.e(stringExtra.substring(lastIndexOf + 1), -1) : -1;
                    if (g.enable && g.versionCode == e2) {
                        em.b().m("plugin_install", "setting_new_has_installed", stringExtra2, "pkgName_" + stringExtra2 + "-srcFile_" + stringExtra);
                        Intent intent2 = new Intent("com.baidu.adp.plugin.installrepeat");
                        intent2.setPackage(BdBaseApplication.getInst().getPackageName());
                        intent2.putExtra("package_name", stringExtra2);
                        intent2.putExtra("install_src_file", stringExtra);
                        BdBaseApplication.getInst().sendBroadcast(intent2);
                        return;
                    }
                }
                String str = stringExtra2 + stringExtra;
                if (b.containsKey(str) && b.get(str).booleanValue()) {
                    em.b().m("plugin_install", "plugin_has_installed", stringExtra2, "b_pkgName_" + stringExtra2 + "-srcFile_" + stringExtra);
                    Intent intent3 = new Intent("com.baidu.adp.plugin.installrepeat");
                    intent3.setPackage(BdBaseApplication.getInst().getPackageName());
                    intent3.putExtra("package_name", stringExtra2);
                    intent3.putExtra("install_src_file", stringExtra);
                    BdBaseApplication.getInst().sendBroadcast(intent3);
                    return;
                }
                f(stringExtra, stringExtra2, pluginSetting);
                return;
            }
            em.b().o("plugin_install", "intent_action_name_not_match", null);
        }
    }

    public static void p(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, str, str2, str3, str4) == null) {
            Intent intent = new Intent("com.baidu.adp.plugin.installfail");
            intent.setPackage(BdBaseApplication.getInst().getPackageName());
            intent.putExtra("install_src_file", str);
            intent.putExtra("fail_reason", str3);
            intent.putExtra("package_name", str2);
            intent.putExtra("install_comment", str4);
            intent.putExtra("install_flag", c);
            try {
                BdBaseApplication.getInst().sendBroadcast(intent);
            } catch (Throwable th) {
                em.b().m("plugin_install", "sendbroadcast_fail", str2, th.getMessage());
            }
        }
    }

    public static Util.a q(String str, String str2) {
        InterceptResult invokeLL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, str2)) == null) {
            Util.a aVar = new Util.a();
            if (f == null) {
                try {
                    f = BdBaseApplication.getInst().getPackageManager().getPackageInfo(BdBaseApplication.getInst().getPackageName(), 64).signatures;
                } catch (Throwable th) {
                    em.b().m("plugin_install", "getmainsign_frompm_fail", str, th.getMessage());
                }
            }
            try {
                signatureArr = BdBaseApplication.getInst().getPackageManager().getPackageArchiveInfo(str2, 64).signatures;
            } catch (Throwable th2) {
                em.b().m("plugin_install", "getpluginsign_frompm_fail", str, th2.getMessage());
                signatureArr = null;
            }
            if (signatureArr == null) {
                try {
                    signatureArr = wm.a(str2, aVar);
                    if (signatureArr != null) {
                        em.b().m("plugin_install", "collectCertificates_ok", str, null);
                    }
                } catch (Throwable th3) {
                    aVar.b += "-exception_" + th3.toString();
                    return aVar;
                }
            }
            if (signatureArr == null) {
                aVar.b = "get_newsignatures_null_" + str2;
                return aVar;
            }
            Signature[] signatureArr2 = f;
            if (signatureArr2 == null) {
                File file = new File(BdBaseApplication.getInst().getPackageCodePath());
                if (file.exists()) {
                    try {
                        signatureArr2 = wm.a(file.getAbsolutePath(), aVar);
                        f = signatureArr2;
                    } catch (Throwable th4) {
                        aVar.b += "-exception_" + th4.toString();
                        return aVar;
                    }
                }
            }
            int a2 = Util.a(signatureArr2, signatureArr);
            if (a2 == 0) {
                aVar.a = true;
                return aVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("mainsign");
            if (signatureArr2 != null) {
                try {
                    for (Signature signature : signatureArr2) {
                        if (signature != null) {
                            sb.append("_");
                            sb.append(signature.toCharsString());
                        }
                    }
                } catch (Throwable th5) {
                    sb.append(th5.getMessage());
                }
            }
            sb.append("_pluginsign");
            if (signatureArr != null) {
                try {
                    for (Signature signature2 : signatureArr) {
                        if (signature2 != null) {
                            sb.append("_");
                            sb.append(signature2.toCharsString());
                        }
                    }
                } catch (Throwable th6) {
                    sb.append(th6.getMessage());
                }
            }
            aVar.b = "compare_signatures_fail_" + a2 + "_" + sb.toString();
            return aVar;
        }
        return (Util.a) invokeLL.objValue;
    }
}
