package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
/* loaded from: classes8.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public static s c;
    public static Application d;
    public static Random e;
    public static Map<String, t> f;
    public static Map<String, t> g;
    public static List<Integer> h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774452, "Lcom/kuaishou/weapon/p0/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774452, "Lcom/kuaishou/weapon/p0/s;");
                return;
            }
        }
        e = new Random();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        h = new ArrayList();
    }

    public s() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private Pair<Boolean, String> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            File file = new File(str2);
            if (n3.a(file)) {
                String a = g.a(file);
                return TextUtils.isEmpty(a) ? new Pair<>(Boolean.FALSE, "") : !a.equalsIgnoreCase(str) ? new Pair<>(Boolean.FALSE, a) : new Pair<>(Boolean.TRUE, "");
            }
            return new Pair<>(Boolean.FALSE, "");
        }
        return (Pair) invokeLL.objValue;
    }

    public static s a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            if (c == null) {
                d = (Application) context.getApplicationContext();
                c = new s();
            }
            return c;
        }
        return (s) invokeLZ.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(1:90)(11:11|12|13|(4:15|16|(4:23|(3:24|25|(1:27)(1:28))|29|30)|60)|86|16|(3:18|20|22)(1:85)|23|(4:24|25|(0)(0)|27)|29|30)|31|32|(8:37|38|39|(3:40|41|(1:43)(1:44))|45|(1:47)|48|49)|58|59|60) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014e, code lost:
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00d0 A[EDGE_INSN: B:104:0x00d0->B:35:0x00d0 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb A[Catch: all -> 0x00da, LOOP:1: B:84:0x00c5->B:34:0x00cb, LOOP_END, TryCatch #3 {all -> 0x00da, blocks: (B:32:0x00c5, B:34:0x00cb, B:35:0x00d0), top: B:84:0x00c5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(t tVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) {
        FileOutputStream fileOutputStream;
        String str3;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{tVar, str, str2, hashSet, bArr, sb, Boolean.valueOf(z)}) == null) {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(tVar.e));
            FileOutputStream fileOutputStream2 = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String name = nextEntry.getName();
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        if (Build.VERSION.SDK_INT >= 8) {
                            str3 = Build.CPU_ABI2;
                            if (!name.contains(str4) || ((!TextUtils.isEmpty(str3) && name.contains(str3)) || (name.contains("armeabi") && (PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str3) && PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equalsIgnoreCase(str3)))))) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str);
                                String substring = name.substring(3);
                                sb2.append(substring.replace(".so", str2 + ".so"));
                                String sb3 = sb2.toString();
                                String substring2 = sb3.substring(0, sb3.lastIndexOf(47));
                                hashSet.add(substring2.substring(substring2.lastIndexOf(47) + 1));
                                e(substring2);
                                File file = new File(sb3);
                                file.delete();
                                file.createNewFile();
                                fileOutputStream = new FileOutputStream(sb3);
                                while (true) {
                                    try {
                                        read = zipInputStream.read(bArr);
                                        if (read > 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    } catch (Throwable th) {
                                        th = th;
                                        zipInputStream.close();
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                                fileOutputStream.close();
                                n3.a(sb3, Boolean.TRUE);
                                fileOutputStream2 = fileOutputStream;
                            }
                        }
                        str3 = null;
                        if (!name.contains(str4)) {
                        }
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append(str);
                        String substring3 = name.substring(3);
                        sb22.append(substring3.replace(".so", str2 + ".so"));
                        String sb32 = sb22.toString();
                        String substring22 = sb32.substring(0, sb32.lastIndexOf(47));
                        hashSet.add(substring22.substring(substring22.lastIndexOf(47) + 1));
                        e(substring22);
                        File file2 = new File(sb32);
                        file2.delete();
                        file2.createNewFile();
                        fileOutputStream = new FileOutputStream(sb32);
                        while (true) {
                            read = zipInputStream.read(bArr);
                            if (read > 0) {
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                        n3.a(sb32, Boolean.TRUE);
                        fileOutputStream2 = fileOutputStream;
                    }
                    if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                        String str5 = tVar.m;
                        e(str5);
                        File file3 = new File(str5, tVar.a + "-" + tVar.d + ".dex");
                        try {
                            file3.delete();
                            file3.createNewFile();
                            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                            while (true) {
                                try {
                                    int read2 = zipInputStream.read(bArr);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    fileOutputStream3.write(bArr, 0, read2);
                                } catch (Throwable unused) {
                                    fileOutputStream2 = fileOutputStream3;
                                    if (file3 != null && file3.exists()) {
                                        file3.delete();
                                    }
                                    zipInputStream.closeEntry();
                                }
                            }
                            fileOutputStream3.close();
                            if (sb.length() > 0) {
                                sb.setLength(0);
                            }
                            sb.append(file3.getAbsolutePath());
                            n3.a(sb.toString(), Boolean.TRUE);
                            fileOutputStream2 = fileOutputStream3;
                        } catch (Throwable unused2) {
                        }
                    }
                    zipInputStream.closeEntry();
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
            }
            zipInputStream.close();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:121:0x021f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:239:0x0055 */
    /* JADX DEBUG: Null dom frontier in handler: EOFException -> 0x01da */
    /* JADX DEBUG: Null dom frontier in handler: FileNotFoundException | ZipException -> 0x01e0 */
    /* JADX DEBUG: Null dom frontier in handler: IOException -> 0x01d4 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0089 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x01a2 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x02a2 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x043c */
    /* JADX WARN: Can't wrap try/catch for region: R(7:29|(1:217)(13:33|34|35|(4:37|38|(6:56|57|58|(3:59|60|(1:62)(1:63))|64|65)|53)|214|38|(2:40|42)|56|57|58|(4:59|60|(0)(0)|62)|64|65)|66|67|(5:101|89|90|91|53)(11:72|73|74|(4:76|77|78|(2:80|81)(1:92))|93|(1:95)|96|97|90|91|53)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x021f, code lost:
        if (r14 != null) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x023a, code lost:
        if (r14 != null) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0255, code lost:
        if (r14 != null) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0257, code lost:
        r7 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0258, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x025b, code lost:
        r0 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0263, code lost:
        if (r11.contains(android.os.Build.CPU_ABI) == false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0265, code lost:
        r0 = new java.lang.StringBuilder();
        r1 = r20;
        r0.append(r1);
        r0.append("/");
        r0.append(android.os.Build.CPU_ABI);
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0281, code lost:
        if (android.os.Build.VERSION.SDK_INT < 8) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0289, code lost:
        if (r11.contains(android.os.Build.CPU_ABI2) == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x028b, code lost:
        r14 = r1 + "/" + android.os.Build.CPU_ABI2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02cf, code lost:
        r1 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02d5, code lost:
        if (android.os.Build.VERSION.SDK_INT < 8) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02dd, code lost:
        if (r11.contains(android.os.Build.CPU_ABI2) == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02df, code lost:
        r0 = r1 + "/" + android.os.Build.CPU_ABI2 + ":" + java.lang.System.getProperty("java.library.path");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01a8, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c5, code lost:
        if (r7 == null) goto L113;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x011e A[EDGE_INSN: B:263:0x011e->B:57:0x011e ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[Catch: all -> 0x01c9, IOException -> 0x01d4, EOFException -> 0x01da, FileNotFoundException | ZipException -> 0x01e0, TryCatch #17 {EOFException -> 0x01da, FileNotFoundException | ZipException -> 0x01e0, IOException -> 0x01d4, all -> 0x01c9, blocks: (B:25:0x0062, B:27:0x0068, B:29:0x007a, B:31:0x0080, B:37:0x008a, B:39:0x0090, B:41:0x0096, B:43:0x009c, B:45:0x00a4, B:47:0x00ac, B:49:0x00b2, B:51:0x00ba, B:53:0x00cb, B:87:0x01ac, B:89:0x01b2), top: B:254:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0119 A[Catch: all -> 0x0125, IOException -> 0x0128, EOFException -> 0x012d, FileNotFoundException | ZipException -> 0x0132, LOOP:1: B:252:0x0113->B:56:0x0119, LOOP_END, TryCatch #18 {EOFException -> 0x012d, FileNotFoundException | ZipException -> 0x0132, IOException -> 0x0128, all -> 0x0125, blocks: (B:54:0x0113, B:56:0x0119, B:57:0x011e), top: B:252:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c2  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(t tVar, String str, String str2, boolean z) {
        HashSet<String> hashSet;
        boolean z2;
        String replace;
        StringBuilder sb;
        byte[] bArr;
        InputStream inputStream;
        ZipFile zipFile;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream2;
        InputStream inputStream3;
        ZipFile zipFile2;
        FileOutputStream fileOutputStream3;
        String str3;
        String str4;
        String sb2;
        StringBuilder sb3;
        Enumeration<? extends ZipEntry> entries;
        Enumeration<? extends ZipEntry> enumeration;
        String str5;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65541, this, new Object[]{tVar, str, str2, Boolean.valueOf(z)}) != null) {
            return;
        }
        String str6 = str;
        hashSet = new HashSet<>();
        try {
            try {
                try {
                    try {
                        if (!z && !TextUtils.isEmpty(tVar.n)) {
                            File file = new File(tVar.n);
                            if (file.exists() && file.isFile()) {
                                z2 = false;
                                replace = TextUtils.isEmpty(tVar.d) ? "" : tVar.d.replace(".", "");
                                sb = new StringBuilder();
                                if (!z2) {
                                    sb.append(tVar.n);
                                }
                                bArr = new byte[4096];
                                inputStream = 8;
                                int i = 8;
                                zipFile = new ZipFile(tVar.e);
                                entries = zipFile.entries();
                                inputStream3 = null;
                                fileOutputStream = null;
                                while (entries.hasMoreElements()) {
                                    try {
                                        ZipEntry nextElement = entries.nextElement();
                                        String name = nextElement.getName();
                                        if (!name.startsWith("lib/") || nextElement.isDirectory()) {
                                            enumeration = entries;
                                        } else {
                                            String str7 = Build.CPU_ABI;
                                            if (Build.VERSION.SDK_INT >= i) {
                                                str5 = Build.CPU_ABI2;
                                                if (!name.contains(str7) || ((!TextUtils.isEmpty(str5) && name.contains(str5)) || (name.contains("armeabi") && (PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equalsIgnoreCase(str7) || (!TextUtils.isEmpty(str5) && PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equalsIgnoreCase(str5)))))) {
                                                    StringBuilder sb4 = new StringBuilder();
                                                    sb4.append(str6);
                                                    enumeration = entries;
                                                    sb4.append(name.substring(3).replace(".so", replace + ".so"));
                                                    String sb5 = sb4.toString();
                                                    String substring = sb5.substring(0, sb5.lastIndexOf(47));
                                                    hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                                                    e(substring);
                                                    new File(sb5).delete();
                                                    inputStream3 = zipFile.getInputStream(nextElement);
                                                    fileOutputStream2 = new FileOutputStream(sb5);
                                                    while (true) {
                                                        try {
                                                            read = inputStream3.read(bArr);
                                                            if (read > 0) {
                                                                break;
                                                            }
                                                            fileOutputStream2.write(bArr, 0, read);
                                                        } catch (EOFException unused) {
                                                            fileOutputStream3 = fileOutputStream2;
                                                            str6 = zipFile;
                                                            inputStream = inputStream3;
                                                            a(tVar, str, replace, hashSet, bArr, sb, z2);
                                                            if (str6 != 0) {
                                                            }
                                                            if (inputStream != 0) {
                                                            }
                                                        } catch (FileNotFoundException | ZipException unused2) {
                                                            fileOutputStream3 = fileOutputStream2;
                                                            str6 = zipFile;
                                                            inputStream = inputStream3;
                                                            a(tVar, str, replace, hashSet, bArr, sb, z2);
                                                            if (str6 != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                        } catch (IOException unused3) {
                                                            fileOutputStream3 = fileOutputStream2;
                                                            str6 = zipFile;
                                                            inputStream = inputStream3;
                                                            a(tVar, str, replace, hashSet, bArr, sb, z2);
                                                            if (str6 != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            zipFile2 = zipFile;
                                                            if (zipFile2 != null) {
                                                            }
                                                            if (inputStream3 != null) {
                                                            }
                                                            if (fileOutputStream2 != null) {
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    n3.a(sb5, Boolean.TRUE);
                                                    fileOutputStream = fileOutputStream2;
                                                }
                                                i = 8;
                                            }
                                            str5 = null;
                                            if (!name.contains(str7)) {
                                            }
                                            StringBuilder sb42 = new StringBuilder();
                                            sb42.append(str6);
                                            enumeration = entries;
                                            sb42.append(name.substring(3).replace(".so", replace + ".so"));
                                            String sb52 = sb42.toString();
                                            String substring2 = sb52.substring(0, sb52.lastIndexOf(47));
                                            hashSet.add(substring2.substring(substring2.lastIndexOf(47) + 1));
                                            e(substring2);
                                            new File(sb52).delete();
                                            inputStream3 = zipFile.getInputStream(nextElement);
                                            fileOutputStream2 = new FileOutputStream(sb52);
                                            while (true) {
                                                read = inputStream3.read(bArr);
                                                if (read > 0) {
                                                }
                                                fileOutputStream2.write(bArr, 0, read);
                                            }
                                            n3.a(sb52, Boolean.TRUE);
                                            fileOutputStream = fileOutputStream2;
                                        }
                                        if (name.endsWith(".dex") && !nextElement.isDirectory() && z2) {
                                            String str8 = tVar.m;
                                            e(str8);
                                            File file2 = new File(str8, tVar.a + "-" + tVar.d + ".dex");
                                            try {
                                                inputStream3 = zipFile.getInputStream(nextElement);
                                                FileOutputStream fileOutputStream4 = new FileOutputStream(file2);
                                                while (true) {
                                                    try {
                                                        int read2 = inputStream3.read(bArr);
                                                        if (read2 <= 0) {
                                                            break;
                                                        }
                                                        try {
                                                            fileOutputStream4.write(bArr, 0, read2);
                                                        } catch (Throwable unused4) {
                                                            fileOutputStream = fileOutputStream4;
                                                            if (file2 != null && file2.exists()) {
                                                                file2.delete();
                                                            }
                                                            str6 = str;
                                                            entries = enumeration;
                                                            i = 8;
                                                        }
                                                    } catch (Throwable unused5) {
                                                    }
                                                }
                                                fileOutputStream4.close();
                                                if (inputStream3 != null) {
                                                    inputStream3.close();
                                                }
                                                sb.append(file2.getAbsolutePath());
                                                n3.a(sb.toString(), Boolean.TRUE);
                                                str6 = str;
                                                fileOutputStream = fileOutputStream4;
                                            } catch (Throwable unused6) {
                                            }
                                            entries = enumeration;
                                            i = 8;
                                        } else {
                                            str6 = str;
                                            entries = enumeration;
                                            i = 8;
                                        }
                                    } catch (EOFException unused7) {
                                        str6 = zipFile;
                                        inputStream = inputStream3;
                                        fileOutputStream3 = fileOutputStream;
                                        a(tVar, str, replace, hashSet, bArr, sb, z2);
                                        if (str6 != 0) {
                                        }
                                        if (inputStream != 0) {
                                        }
                                    } catch (FileNotFoundException | ZipException unused8) {
                                        str6 = zipFile;
                                        inputStream = inputStream3;
                                        fileOutputStream3 = fileOutputStream;
                                        a(tVar, str, replace, hashSet, bArr, sb, z2);
                                        if (str6 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                    } catch (IOException unused9) {
                                        str6 = zipFile;
                                        inputStream = inputStream3;
                                        fileOutputStream3 = fileOutputStream;
                                        a(tVar, str, replace, hashSet, bArr, sb, z2);
                                        if (str6 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream2 = inputStream3;
                                        fileOutputStream2 = fileOutputStream;
                                        inputStream3 = inputStream2;
                                        zipFile2 = zipFile;
                                        if (zipFile2 != null) {
                                        }
                                        if (inputStream3 != null) {
                                        }
                                        if (fileOutputStream2 != null) {
                                        }
                                        throw th;
                                    }
                                }
                                zipFile.close();
                                if (inputStream3 != null) {
                                    inputStream3.close();
                                }
                            }
                        }
                        entries = zipFile.entries();
                        inputStream3 = null;
                        fileOutputStream = null;
                        while (entries.hasMoreElements()) {
                        }
                        zipFile.close();
                        if (inputStream3 != null) {
                        }
                    } catch (EOFException unused10) {
                        inputStream3 = null;
                        fileOutputStream = null;
                    } catch (FileNotFoundException | ZipException unused11) {
                        inputStream3 = null;
                        fileOutputStream = null;
                    } catch (IOException unused12) {
                        inputStream3 = null;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        inputStream2 = null;
                    }
                    zipFile = new ZipFile(tVar.e);
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream2 = null;
                    inputStream3 = null;
                    zipFile2 = null;
                    if (zipFile2 != null) {
                        zipFile2.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                try {
                    throw new FileNotFoundException(e2.getMessage() + "--backupFile not exists");
                } catch (EOFException unused13) {
                    str6 = 0;
                    inputStream = 0;
                    fileOutputStream3 = null;
                    a(tVar, str, replace, hashSet, bArr, sb, z2);
                    if (str6 != 0) {
                        str6.close();
                    }
                    if (inputStream != 0) {
                        inputStream.close();
                    }
                } catch (FileNotFoundException | ZipException unused14) {
                    str6 = null;
                    inputStream = null;
                    fileOutputStream3 = null;
                    a(tVar, str, replace, hashSet, bArr, sb, z2);
                    if (str6 != null) {
                        str6.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException unused15) {
                    str6 = null;
                    inputStream = null;
                    fileOutputStream3 = null;
                    a(tVar, str, replace, hashSet, bArr, sb, z2);
                    if (str6 != null) {
                        str6.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile = str6;
            fileOutputStream = fileOutputStream3;
            inputStream2 = inputStream;
        }
        z2 = true;
        replace = TextUtils.isEmpty(tVar.d) ? "" : tVar.d.replace(".", "");
        sb = new StringBuilder();
        if (!z2) {
        }
        bArr = new byte[4096];
        inputStream = 8;
        int i2 = 8;
        String str9 = null;
        if (str9 != null) {
            sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(":");
            sb3.append(str9);
        } else {
            sb3 = new StringBuilder();
            sb3.append(sb2);
        }
        sb3.append(":");
        sb3.append(System.getProperty("java.library.path"));
        str3 = sb3.toString();
        if (TextUtils.isEmpty(str3) && ((PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equals(Build.CPU_ABI) && hashSet.contains("armeabi")) || (Build.VERSION.SDK_INT >= 8 && PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equals(Build.CPU_ABI2) && hashSet.contains("armeabi")))) {
            str3 = str4 + "/armeabi:" + System.getProperty("java.library.path");
        }
        tVar.h = str3;
        tVar.n = sb.toString();
        try {
            String absolutePath = new File(str2, "apkDex").getAbsolutePath();
            n3.b(absolutePath);
            e(absolutePath);
            String b = m3.b(d);
            if (TextUtils.isEmpty(tVar.n) || !(tVar.c.endsWith("v7") || tVar.c.endsWith(V8Engine.TYPE_V8))) {
                if (tVar.a == 0 || b.equals(Build.CPU_ABI) || b.equals(Build.CPU_ABI2)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("e", l2.v);
                hashMap.put("m", b);
                hashMap.put("m1", Build.CPU_ABI);
                hashMap.put("m2", Build.CPU_ABI2);
                hashMap.put("l", ExifInterface.LATITUDE_SOUTH);
                h1.a(d, "1002001", hashMap);
                return;
            }
            synchronized (Runtime.getRuntime()) {
                Engine.soVersion = tVar.d;
                o3.a(getClass().getClassLoader(), new File(str4 + "/" + b));
                Engine.soPath = str4 + "/" + b;
                Engine.getInstance(d);
            }
            return;
        } catch (Throwable unused16) {
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = str4 + "/armeabi:" + System.getProperty("java.library.path");
        }
        tVar.h = str3;
        tVar.n = sb.toString();
        String absolutePath2 = new File(str2, "apkDex").getAbsolutePath();
        n3.b(absolutePath2);
        e(absolutePath2);
        String b2 = m3.b(d);
        if (TextUtils.isEmpty(tVar.n)) {
        }
        if (tVar.a == 0) {
        }
    }

    private synchronized boolean a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, tVar)) == null) {
            synchronized (this) {
                if (tVar != null) {
                    if (!TextUtils.isEmpty(tVar.e)) {
                        t tVar2 = f.get(tVar.e);
                        if (tVar2 != null) {
                            if (tVar2.d.equals(tVar.d)) {
                                return true;
                            }
                            d(tVar2.e);
                        }
                        try {
                            try {
                                tVar.f = d;
                                if (tVar.p == 1) {
                                    if (TextUtils.isEmpty(tVar.c) || TextUtils.isEmpty(tVar.e)) {
                                        throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                    }
                                    tVar.m = d.getFilesDir().getCanonicalPath() + i1.j + tVar.a;
                                    String str = tVar.m + "/dex";
                                    n3.b(tVar.m + "/lib");
                                    String str2 = (tVar.m + "/lib/" + this.b) + "/" + e.nextInt();
                                    e(str);
                                    n3.a(str, Boolean.FALSE);
                                    e(str2);
                                    a(tVar, str2, str, false);
                                    g.put(tVar.c, tVar);
                                    f.put(tVar.e, tVar);
                                }
                                if (tVar.p != 1 || 0 != 0) {
                                    PackageInfo packageInfo = tVar.r;
                                    if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                        packageInfo = d.getPackageManager().getPackageArchiveInfo(tVar.e, 1);
                                    }
                                    if (TextUtils.isEmpty(packageInfo.packageName) || !packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                                        throw new Exception("weapon package name check failed");
                                    }
                                    if (tVar.p != 1 && tVar.b != 1 && !((Boolean) a(tVar.j, tVar.e).first).booleanValue()) {
                                        return false;
                                    }
                                    tVar.c = packageInfo.packageName;
                                    tVar.o = packageInfo.applicationInfo.className;
                                    tVar.d = packageInfo.versionName;
                                    tVar.l = packageInfo.activities;
                                    tVar.q = packageInfo.applicationInfo.theme;
                                    tVar.m = d.getFilesDir().getCanonicalPath() + i1.j + tVar.a;
                                    String str3 = tVar.m + "/dex";
                                    n3.b(tVar.m + "/lib");
                                    String str4 = (tVar.m + "/lib/" + this.b) + "/" + e.nextInt();
                                    e(str3);
                                    n3.a(str3, Boolean.FALSE);
                                    e(str4);
                                    a(tVar, str4, str3, true);
                                    g.put(tVar.c, tVar);
                                    f.put(tVar.e, tVar);
                                    h.add(Integer.valueOf(tVar.a));
                                }
                                return true;
                            } catch (Throwable unused) {
                                d(tVar.e);
                                return false;
                            }
                        } catch (Throwable unused2) {
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static s b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? c : (s) invokeV.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    file.delete();
                }
                if (file.exists()) {
                    return true;
                }
                file.mkdirs();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public t a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return g.get(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (t) invokeL.objValue;
    }

    public Map<String, t> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? g : (Map) invokeV.objValue;
    }

    public boolean a(t tVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, tVar, z)) == null) {
            this.a = z;
            this.b = tVar.d;
            return a(tVar);
        }
        return invokeLZ.booleanValue;
    }

    public t b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return f.get(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (t) invokeL.objValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            t tVar = g.get(str);
            if (tVar != null) {
                f.remove(tVar.e);
                g.remove(str);
                n3.b(tVar.m);
                Application application = d;
                if (application != null) {
                    n3.b(application.getFileStreamPath(tVar.c).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            t tVar = f.get(str);
            if (tVar != null) {
                f.remove(str);
                g.remove(tVar.c);
                n3.b(tVar.m);
                Application application = d;
                if (application != null) {
                    n3.b(application.getFileStreamPath(tVar.c).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
