package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
/* loaded from: classes10.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static List<Integer> b;
    public static r c;
    public static Application d;
    public static Random f;
    public static Map<String, s> g;
    public static Map<String, s> h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774483, "Lcom/kuaishou/weapon/p0/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774483, "Lcom/kuaishou/weapon/p0/r;");
                return;
            }
        }
        f = new Random();
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
        b = new ArrayList();
    }

    public r() {
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

    public static r a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c;
        }
        return (r) invokeV.objValue;
    }

    public Map<String, s> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return h;
        }
        return (Map) invokeV.objValue;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                if (!dn.a(file)) {
                    return new Pair<>(Boolean.FALSE, "");
                }
                String a = f.a(file);
                if (TextUtils.isEmpty(a)) {
                    return new Pair<>(Boolean.FALSE, "");
                }
                if (!a.equalsIgnoreCase(str)) {
                    return new Pair<>(Boolean.FALSE, a);
                }
                return new Pair<>(Boolean.TRUE, "");
            }
            return new Pair<>(Boolean.FALSE, "");
        }
        return (Pair) invokeLL.objValue;
    }

    public static r a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, z)) == null) {
            try {
                if (c == null) {
                    d = (Application) context.getApplicationContext();
                    c = new r();
                }
            } catch (Throwable unused) {
            }
            return c;
        }
        return (r) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00d8 A[EDGE_INSN: B:106:0x00d8->B:37:0x00d8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d3 A[Catch: all -> 0x00e2, LOOP:1: B:80:0x00cd->B:36:0x00d3, LOOP_END, TryCatch #0 {all -> 0x00e2, blocks: (B:34:0x00cd, B:36:0x00d3, B:37:0x00d8), top: B:80:0x00cd }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) {
        File file;
        String str3;
        FileOutputStream fileOutputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{sVar, str, str2, hashSet, bArr, sb, Boolean.valueOf(z)}) == null) {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.e));
            FileOutputStream fileOutputStream2 = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String name = nextEntry.getName();
                    if (!name.contains("../")) {
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
                                    File file2 = new File(sb3);
                                    file2.delete();
                                    file2.createNewFile();
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
                                            fileOutputStream2 = fileOutputStream;
                                            zipInputStream.close();
                                            if (fileOutputStream2 != null) {
                                                fileOutputStream2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    fileOutputStream.close();
                                    dn.a(sb3, Boolean.TRUE);
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
                            File file22 = new File(sb32);
                            file22.delete();
                            file22.createNewFile();
                            fileOutputStream = new FileOutputStream(sb32);
                            while (true) {
                                read = zipInputStream.read(bArr);
                                if (read > 0) {
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.close();
                            dn.a(sb32, Boolean.TRUE);
                            fileOutputStream2 = fileOutputStream;
                        }
                        try {
                            if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                                String str5 = sVar.m;
                                e(str5);
                                file = new File(str5, sVar.a + "-" + sVar.d + ".dex");
                                try {
                                    file.delete();
                                    file.createNewFile();
                                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                    while (true) {
                                        try {
                                            int read2 = zipInputStream.read(bArr);
                                            if (read2 <= 0) {
                                                break;
                                            }
                                            fileOutputStream3.write(bArr, 0, read2);
                                        } catch (Throwable unused) {
                                            fileOutputStream2 = fileOutputStream3;
                                            if (file != null && file.exists()) {
                                                file.delete();
                                            }
                                            zipInputStream.closeEntry();
                                        }
                                    }
                                    fileOutputStream3.close();
                                    if (sb.length() > 0) {
                                        sb.setLength(0);
                                    }
                                    sb.append(file.getAbsolutePath());
                                    dn.a(sb.toString(), Boolean.TRUE);
                                    fileOutputStream2 = fileOutputStream3;
                                } catch (Throwable unused2) {
                                }
                            }
                        } catch (Throwable unused3) {
                            file = null;
                        }
                        zipInputStream.closeEntry();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            zipInputStream.close();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:120:0x0228 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:229:0x0055 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0089 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x01a3 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x02ab */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0418 */
    /* JADX WARN: Can't wrap try/catch for region: R(10:29|(1:204)(11:33|34|35|(4:37|38|(4:56|(3:57|58|(1:60)(1:61))|62|63)|53)|201|38|(2:40|42)|56|(4:57|58|(0)(0)|60)|62|63)|64|65|(1:102)(10:70|71|72|73|74|(3:76|77|(3:79|80|81)(1:91))|92|(1:94)|95|96)|89|90|53|26|27) */
    /* JADX WARN: Can't wrap try/catch for region: R(28:3|(2:7|(26:11|12|(1:14)|15|(1:17)|18|19|20|21|23|24|25|(10:29|(1:204)(11:33|34|35|(4:37|38|(4:56|(3:57|58|(1:60)(1:61))|62|63)|53)|201|38|(2:40|42)|56|(4:57|58|(0)(0)|60)|62|63)|64|65|(1:102)(10:70|71|72|73|74|(3:76|77|(3:79|80|81)(1:91))|92|(1:94)|95|96)|89|90|53|26|27)|205|206|(1:208)|(1:210)|116|(6:118|119|120|(3:124|125|(1:127)(1:161))|163|(0)(0))(4:165|166|167|(1:171))|128|(1:134)|141|142|143|144|(2:146|(3:152|3ad|156)(1:150))(1:158)))|237|12|(0)|15|(0)|18|19|20|21|23|24|25|(2:26|27)|205|206|(0)|(0)|116|(0)(0)|128|(3:130|132|134)|141|142|143|144|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01e3, code lost:
        r14 = r2;
        r5 = null;
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01e8, code lost:
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ea, code lost:
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01ec, code lost:
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0228, code lost:
        if (r14 != null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0243, code lost:
        if (r14 != null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x025e, code lost:
        if (r14 != null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0260, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ad, code lost:
        r1 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0395 A[Catch: all -> 0x0418, TryCatch #26 {all -> 0x0418, blocks: (B:177:0x0374, B:178:0x0387, B:180:0x0395, B:182:0x039f, B:184:0x03a9, B:185:0x03ad, B:187:0x03f1, B:186:0x03ae), top: B:226:0x0374 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0418 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x011e A[EDGE_INSN: B:247:0x011e->B:55:0x011e ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[Catch: all -> 0x01d1, IOException -> 0x01d5, EOFException -> 0x01d9, FileNotFoundException | ZipException -> 0x01dd, TryCatch #17 {EOFException -> 0x01d9, FileNotFoundException | ZipException -> 0x01dd, IOException -> 0x01d5, all -> 0x01d1, blocks: (B:25:0x0062, B:27:0x0068, B:29:0x007a, B:31:0x0080, B:37:0x008a, B:39:0x0090, B:41:0x0096, B:43:0x009c, B:45:0x00a4, B:47:0x00ac, B:49:0x00b2, B:51:0x00ba, B:87:0x01b1, B:89:0x01b7), top: B:240:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0119 A[Catch: all -> 0x0125, IOException -> 0x0129, EOFException -> 0x012e, FileNotFoundException | ZipException -> 0x0133, LOOP:1: B:238:0x0113->B:54:0x0119, LOOP_END, TryCatch #18 {EOFException -> 0x012e, FileNotFoundException | ZipException -> 0x0133, IOException -> 0x0129, all -> 0x0125, blocks: (B:52:0x0113, B:54:0x0119, B:55:0x011e), top: B:238:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cc  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(s sVar, String str, String str2, boolean z) {
        boolean z2;
        String str3;
        StringBuilder sb;
        byte[] bArr;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        ZipFile zipFile;
        FileOutputStream fileOutputStream2;
        String str4;
        String str5;
        String str6;
        Enumeration<? extends ZipEntry> entries;
        Enumeration<? extends ZipEntry> enumeration;
        String str7;
        FileOutputStream fileOutputStream3;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{sVar, str, str2, Boolean.valueOf(z)}) == null) {
            ZipFile zipFile2 = str;
            HashSet<String> hashSet = new HashSet<>();
            try {
                try {
                    try {
                        try {
                            if (!z && !TextUtils.isEmpty(sVar.n)) {
                                File file = new File(sVar.n);
                                if (file.exists() && file.isFile()) {
                                    z2 = false;
                                    String str8 = "";
                                    if (!TextUtils.isEmpty(sVar.d)) {
                                        str8 = sVar.d.replace(".", "");
                                    }
                                    str3 = str8;
                                    sb = new StringBuilder();
                                    if (!z2) {
                                        sb.append(sVar.n);
                                    }
                                    bArr = new byte[4096];
                                    inputStream = 8;
                                    int i = 8;
                                    ZipFile zipFile3 = new ZipFile(sVar.e);
                                    entries = zipFile3.entries();
                                    inputStream2 = null;
                                    fileOutputStream = null;
                                    while (entries.hasMoreElements()) {
                                        try {
                                            ZipEntry nextElement = entries.nextElement();
                                            String name = nextElement.getName();
                                            if (name.startsWith("lib/") && !nextElement.isDirectory()) {
                                                String str9 = Build.CPU_ABI;
                                                if (Build.VERSION.SDK_INT >= i) {
                                                    str7 = Build.CPU_ABI2;
                                                    if (!name.contains(str9) || ((!TextUtils.isEmpty(str7) && name.contains(str7)) || (name.contains("armeabi") && (PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equalsIgnoreCase(str9) || (!TextUtils.isEmpty(str7) && PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equalsIgnoreCase(str7)))))) {
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append(zipFile2);
                                                        enumeration = entries;
                                                        sb2.append(name.substring(3).replace(".so", str3 + ".so"));
                                                        String sb3 = sb2.toString();
                                                        String substring = sb3.substring(0, sb3.lastIndexOf(47));
                                                        hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                                                        e(substring);
                                                        new File(sb3).delete();
                                                        inputStream2 = zipFile3.getInputStream(nextElement);
                                                        fileOutputStream3 = new FileOutputStream(sb3);
                                                        while (true) {
                                                            try {
                                                                read = inputStream2.read(bArr);
                                                                if (read > 0) {
                                                                    break;
                                                                }
                                                                fileOutputStream3.write(bArr, 0, read);
                                                            } catch (EOFException unused) {
                                                                fileOutputStream2 = fileOutputStream3;
                                                                zipFile2 = zipFile3;
                                                                inputStream = inputStream2;
                                                                a(sVar, str, str3, hashSet, bArr, sb, z2);
                                                                if (zipFile2 != 0) {
                                                                }
                                                                if (inputStream != 0) {
                                                                }
                                                            } catch (FileNotFoundException | ZipException unused2) {
                                                                fileOutputStream2 = fileOutputStream3;
                                                                zipFile2 = zipFile3;
                                                                inputStream = inputStream2;
                                                                a(sVar, str, str3, hashSet, bArr, sb, z2);
                                                                if (zipFile2 != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                            } catch (IOException unused3) {
                                                                fileOutputStream2 = fileOutputStream3;
                                                                zipFile2 = zipFile3;
                                                                inputStream = inputStream2;
                                                                a(sVar, str, str3, hashSet, bArr, sb, z2);
                                                                if (zipFile2 != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                fileOutputStream = fileOutputStream3;
                                                                zipFile = zipFile3;
                                                                if (zipFile != null) {
                                                                    zipFile.close();
                                                                }
                                                                if (inputStream2 != null) {
                                                                    inputStream2.close();
                                                                }
                                                                if (fileOutputStream != null) {
                                                                    fileOutputStream.close();
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                        dn.a(sb3, Boolean.TRUE);
                                                        fileOutputStream = fileOutputStream3;
                                                    }
                                                    i = 8;
                                                }
                                                str7 = null;
                                                if (!name.contains(str9)) {
                                                }
                                                StringBuilder sb22 = new StringBuilder();
                                                sb22.append(zipFile2);
                                                enumeration = entries;
                                                sb22.append(name.substring(3).replace(".so", str3 + ".so"));
                                                String sb32 = sb22.toString();
                                                String substring2 = sb32.substring(0, sb32.lastIndexOf(47));
                                                hashSet.add(substring2.substring(substring2.lastIndexOf(47) + 1));
                                                e(substring2);
                                                new File(sb32).delete();
                                                inputStream2 = zipFile3.getInputStream(nextElement);
                                                fileOutputStream3 = new FileOutputStream(sb32);
                                                while (true) {
                                                    read = inputStream2.read(bArr);
                                                    if (read > 0) {
                                                    }
                                                    fileOutputStream3.write(bArr, 0, read);
                                                }
                                                dn.a(sb32, Boolean.TRUE);
                                                fileOutputStream = fileOutputStream3;
                                            } else {
                                                enumeration = entries;
                                            }
                                            if (name.endsWith(".dex") && !nextElement.isDirectory() && z2) {
                                                String str10 = sVar.m;
                                                e(str10);
                                                File file2 = new File(str10, sVar.a + "-" + sVar.d + ".dex");
                                                try {
                                                    InputStream inputStream3 = zipFile3.getInputStream(nextElement);
                                                    try {
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
                                                                    inputStream2 = inputStream3;
                                                                    fileOutputStream = fileOutputStream4;
                                                                    if (file2 != null && file2.exists()) {
                                                                        file2.delete();
                                                                    }
                                                                    zipFile2 = str;
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
                                                        dn.a(sb.toString(), Boolean.TRUE);
                                                        inputStream2 = inputStream3;
                                                        fileOutputStream = fileOutputStream4;
                                                    } catch (Throwable unused6) {
                                                        inputStream2 = inputStream3;
                                                    }
                                                } catch (Throwable unused7) {
                                                }
                                            }
                                            zipFile2 = str;
                                            entries = enumeration;
                                            i = 8;
                                        } catch (EOFException unused8) {
                                            zipFile2 = zipFile3;
                                            inputStream = inputStream2;
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (FileNotFoundException | ZipException unused9) {
                                            zipFile2 = zipFile3;
                                            inputStream = inputStream2;
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (IOException unused10) {
                                            zipFile2 = zipFile3;
                                            inputStream = inputStream2;
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                    zipFile3.close();
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    str4 = "";
                                    if (!hashSet.contains(Build.CPU_ABI)) {
                                        StringBuilder sb4 = new StringBuilder();
                                        str5 = str;
                                        sb4.append(str5);
                                        sb4.append("/");
                                        sb4.append(Build.CPU_ABI);
                                        String sb5 = sb4.toString();
                                        if (Build.VERSION.SDK_INT >= 8 && hashSet.contains(Build.CPU_ABI2)) {
                                            str6 = str5 + "/" + Build.CPU_ABI2;
                                            if (str6 == null) {
                                                str4 = sb5 + ":" + str6 + ":" + System.getProperty("java.library.path");
                                            } else {
                                                str4 = sb5 + ":" + System.getProperty("java.library.path");
                                            }
                                        }
                                        str6 = null;
                                        if (str6 == null) {
                                        }
                                    } else {
                                        str5 = str;
                                        try {
                                            if (Build.VERSION.SDK_INT >= 8 && hashSet.contains(Build.CPU_ABI2)) {
                                                str4 = str5 + "/" + Build.CPU_ABI2 + ":" + System.getProperty("java.library.path");
                                            }
                                        } catch (Throwable unused11) {
                                        }
                                    }
                                    if (TextUtils.isEmpty(str4) && ((PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equals(Build.CPU_ABI) && hashSet.contains("armeabi")) || (Build.VERSION.SDK_INT >= 8 && PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equals(Build.CPU_ABI2) && hashSet.contains("armeabi")))) {
                                        str4 = str5 + "/armeabi:" + System.getProperty("java.library.path");
                                    }
                                    sVar.h = str4;
                                    sVar.n = sb.toString();
                                    String absolutePath = new File(str2, "apkDex").getAbsolutePath();
                                    dn.c(absolutePath);
                                    e(absolutePath);
                                    String a = dm.a(d);
                                    if (!TextUtils.isEmpty(sVar.n)) {
                                        if (sVar.c.endsWith("v7") || sVar.c.endsWith(V8Engine.TYPE_V8)) {
                                            synchronized (Runtime.getRuntime()) {
                                                Cdo.a(getClass().getClassLoader(), new File(str5 + "/" + a));
                                                Engine.soPath = str5 + "/" + a;
                                                Engine.soVersion = sVar.d;
                                                Engine.getInstance(d);
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            String absolutePath2 = new File(str2, "apkDex").getAbsolutePath();
                            dn.c(absolutePath2);
                            e(absolutePath2);
                            String a2 = dm.a(d);
                            if (!TextUtils.isEmpty(sVar.n)) {
                            }
                        } catch (Throwable unused12) {
                            return;
                        }
                        ZipFile zipFile32 = new ZipFile(sVar.e);
                        entries = zipFile32.entries();
                        inputStream2 = null;
                        fileOutputStream = null;
                        while (entries.hasMoreElements()) {
                        }
                        zipFile32.close();
                        if (inputStream2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        str4 = "";
                        if (!hashSet.contains(Build.CPU_ABI)) {
                        }
                        if (TextUtils.isEmpty(str4)) {
                            str4 = str5 + "/armeabi:" + System.getProperty("java.library.path");
                        }
                        sVar.h = str4;
                        sVar.n = sb.toString();
                    } catch (IOException e) {
                        try {
                            throw new FileNotFoundException(e.getMessage() + "--backupFile not exists");
                        } catch (EOFException unused13) {
                            ZipFile zipFile4 = null;
                            inputStream = 0;
                            fileOutputStream2 = null;
                            zipFile2 = zipFile4;
                            a(sVar, str, str3, hashSet, bArr, sb, z2);
                            if (zipFile2 != 0) {
                                zipFile2.close();
                            }
                            if (inputStream != 0) {
                                inputStream.close();
                            }
                        } catch (FileNotFoundException | ZipException unused14) {
                            zipFile2 = null;
                            inputStream = null;
                            fileOutputStream2 = null;
                            a(sVar, str, str3, hashSet, bArr, sb, z2);
                            if (zipFile2 != null) {
                                zipFile2.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (IOException unused15) {
                            zipFile2 = null;
                            inputStream = null;
                            fileOutputStream2 = null;
                            a(sVar, str, str3, hashSet, bArr, sb, z2);
                            if (zipFile2 != null) {
                                zipFile2.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream2 = null;
                    fileOutputStream = null;
                    zipFile = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = inputStream;
                fileOutputStream = fileOutputStream2;
                zipFile = zipFile2;
            }
            z2 = true;
            String str82 = "";
            if (!TextUtils.isEmpty(sVar.d)) {
            }
            str3 = str82;
            sb = new StringBuilder();
            if (!z2) {
            }
            bArr = new byte[4096];
            inputStream = 8;
            int i2 = 8;
        }
    }

    private synchronized boolean a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, sVar)) == null) {
            synchronized (this) {
                if (sVar != null) {
                    if (!TextUtils.isEmpty(sVar.e)) {
                        s sVar2 = g.get(sVar.e);
                        if (sVar2 != null) {
                            if (sVar2.d.equals(sVar.d)) {
                                return true;
                            }
                            a(sVar2.e);
                        }
                        try {
                            try {
                                sVar.f = d;
                                if (sVar.p == 1) {
                                    if (!TextUtils.isEmpty(sVar.c) && !TextUtils.isEmpty(sVar.e)) {
                                        sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.a;
                                        String str = sVar.m + "/dex";
                                        dn.c(sVar.m + "/lib");
                                        String str2 = (sVar.m + "/lib/" + this.e) + "/" + f.nextInt();
                                        e(str);
                                        dn.a(str, Boolean.FALSE);
                                        e(str2);
                                        a(sVar, str2, str, false);
                                        h.put(sVar.c, sVar);
                                        g.put(sVar.e, sVar);
                                    } else {
                                        throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                    }
                                }
                                if (sVar.p != 1 || 0 != 0) {
                                    PackageInfo packageInfo = sVar.r;
                                    if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                        packageInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                                    }
                                    if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                                        if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                                            return false;
                                        }
                                        sVar.c = packageInfo.packageName;
                                        sVar.o = packageInfo.applicationInfo.className;
                                        sVar.d = packageInfo.versionName;
                                        sVar.l = packageInfo.activities;
                                        sVar.q = packageInfo.applicationInfo.theme;
                                        sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.a;
                                        String str3 = sVar.m + "/dex";
                                        dn.c(sVar.m + "/lib");
                                        String str4 = (sVar.m + "/lib/" + this.e) + "/" + f.nextInt();
                                        e(str3);
                                        dn.a(str3, Boolean.FALSE);
                                        e(str4);
                                        a(sVar, str4, str3, true);
                                        h.put(sVar.c, sVar);
                                        g.put(sVar.e, sVar);
                                        b.add(Integer.valueOf(sVar.a));
                                    } else {
                                        throw new Exception("weapon package name check failed");
                                    }
                                }
                                return true;
                            } catch (Throwable unused) {
                                return false;
                            }
                        } catch (Throwable unused2) {
                            a(sVar.e);
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
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
                if (!file.exists()) {
                    file.mkdirs();
                    return true;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            s sVar = g.get(str);
            if (sVar != null) {
                g.remove(str);
                h.remove(sVar.c);
                dn.c(sVar.m);
                Application application = d;
                if (application != null) {
                    dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            s sVar = h.get(str);
            if (sVar != null) {
                g.remove(sVar.e);
                h.remove(str);
                dn.c(sVar.m);
                Application application = d;
                if (application != null) {
                    dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean a(s sVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, sVar, z)) == null) {
            this.a = z;
            this.e = sVar.d;
            return a(sVar);
        }
        return invokeLZ.booleanValue;
    }

    public s c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return g.get(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (s) invokeL.objValue;
    }

    public s d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return h.get(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (s) invokeL.objValue;
    }
}
