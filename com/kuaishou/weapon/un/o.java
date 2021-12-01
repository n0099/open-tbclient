package com.kuaishou.weapon.un;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.WeaponRECE;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
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
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f56775c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f56776d = -2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f56777e = -3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f56778f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f56779g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f56780h = 6;

    /* renamed from: i  reason: collision with root package name */
    public static o f56781i;

    /* renamed from: j  reason: collision with root package name */
    public static Application f56782j;

    /* renamed from: k  reason: collision with root package name */
    public static Random f56783k;
    public static Map<String, p> l;
    public static Map<String, p> m;
    public static Map<String, WeaponRECE> n;
    public static List<Integer> o;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f56784b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1645309929, "Lcom/kuaishou/weapon/un/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1645309929, "Lcom/kuaishou/weapon/un/o;");
                return;
            }
        }
        f56783k = new Random();
        l = new ConcurrentHashMap();
        m = new ConcurrentHashMap();
        n = new HashMap();
        o = new ArrayList();
    }

    public o() {
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

    private Pair<Boolean, String> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            File file = new File(str2);
            if (l1.a(file)) {
                String a = s1.a(file);
                return TextUtils.isEmpty(a) ? new Pair<>(Boolean.FALSE, "") : !a.equalsIgnoreCase(str) ? new Pair<>(Boolean.FALSE, a) : new Pair<>(Boolean.TRUE, "");
            }
            return new Pair<>(Boolean.FALSE, "");
        }
        return (Pair) invokeLL.objValue;
    }

    public static o a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, context, z)) == null) {
            if (f56781i == null) {
                if (context.getApplicationContext() instanceof Application) {
                    f56782j = (Application) context.getApplicationContext();
                }
                f56781i = new o();
            }
            return f56781i;
        }
        return (o) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a A[Catch: all -> 0x0121, TRY_LEAVE, TryCatch #2 {all -> 0x0121, blocks: (B:7:0x0009, B:10:0x0017, B:19:0x0031, B:20:0x0034, B:22:0x003a, B:23:0x0041, B:25:0x0047, B:27:0x0054, B:29:0x005a, B:38:0x0074, B:39:0x0077, B:41:0x007d, B:42:0x0084, B:44:0x008a, B:46:0x0097, B:48:0x009d, B:57:0x00b7, B:58:0x00ba, B:60:0x00c0, B:61:0x00c7, B:63:0x00cd, B:65:0x00da, B:67:0x00e0, B:75:0x00f9, B:76:0x00fc, B:78:0x0102, B:79:0x0109, B:81:0x010f, B:83:0x011c, B:82:0x0119, B:64:0x00d7, B:45:0x0094, B:26:0x0051, B:32:0x0062, B:34:0x006c, B:51:0x00a5, B:53:0x00af, B:69:0x00e7, B:71:0x00f1, B:13:0x001f, B:15:0x0029), top: B:90:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d A[Catch: all -> 0x0121, TRY_LEAVE, TryCatch #2 {all -> 0x0121, blocks: (B:7:0x0009, B:10:0x0017, B:19:0x0031, B:20:0x0034, B:22:0x003a, B:23:0x0041, B:25:0x0047, B:27:0x0054, B:29:0x005a, B:38:0x0074, B:39:0x0077, B:41:0x007d, B:42:0x0084, B:44:0x008a, B:46:0x0097, B:48:0x009d, B:57:0x00b7, B:58:0x00ba, B:60:0x00c0, B:61:0x00c7, B:63:0x00cd, B:65:0x00da, B:67:0x00e0, B:75:0x00f9, B:76:0x00fc, B:78:0x0102, B:79:0x0109, B:81:0x010f, B:83:0x011c, B:82:0x0119, B:64:0x00d7, B:45:0x0094, B:26:0x0051, B:32:0x0062, B:34:0x006c, B:51:0x00a5, B:53:0x00af, B:69:0x00e7, B:71:0x00f1, B:13:0x001f, B:15:0x0029), top: B:90:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e0 A[Catch: all -> 0x0121, TRY_LEAVE, TryCatch #2 {all -> 0x0121, blocks: (B:7:0x0009, B:10:0x0017, B:19:0x0031, B:20:0x0034, B:22:0x003a, B:23:0x0041, B:25:0x0047, B:27:0x0054, B:29:0x005a, B:38:0x0074, B:39:0x0077, B:41:0x007d, B:42:0x0084, B:44:0x008a, B:46:0x0097, B:48:0x009d, B:57:0x00b7, B:58:0x00ba, B:60:0x00c0, B:61:0x00c7, B:63:0x00cd, B:65:0x00da, B:67:0x00e0, B:75:0x00f9, B:76:0x00fc, B:78:0x0102, B:79:0x0109, B:81:0x010f, B:83:0x011c, B:82:0x0119, B:64:0x00d7, B:45:0x0094, B:26:0x0051, B:32:0x0062, B:34:0x006c, B:51:0x00a5, B:53:0x00af, B:69:0x00e7, B:71:0x00f1, B:13:0x001f, B:15:0x0029), top: B:90:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(IntentFilter intentFilter) {
        InterceptResult invokeL;
        int countCategories;
        int countDataSchemes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, intentFilter)) == null) {
            if (intentFilter == null) {
                return "";
            }
            try {
                StringBuilder sb = new StringBuilder();
                int countActions = intentFilter.countActions();
                if (countActions > 0) {
                    ArrayList<String> arrayList = new ArrayList();
                    for (int i2 = 0; i2 < countActions; i2++) {
                        String action = intentFilter.getAction(i2);
                        if (!TextUtils.isEmpty(action)) {
                            arrayList.add(action);
                        }
                    }
                    if (arrayList.size() > 0) {
                        Collections.sort(arrayList);
                        for (String str : arrayList) {
                            sb.append(str);
                        }
                        countCategories = intentFilter.countCategories();
                        if (countCategories > 0) {
                            ArrayList<String> arrayList2 = new ArrayList();
                            for (int i3 = 0; i3 < countCategories; i3++) {
                                String category = intentFilter.getCategory(i3);
                                if (!TextUtils.isEmpty(category)) {
                                    arrayList2.add(category);
                                }
                            }
                            if (arrayList2.size() > 0) {
                                Collections.sort(arrayList2);
                                for (String str2 : arrayList2) {
                                    sb.append(str2);
                                }
                                if (intentFilter.countDataTypes() > 0) {
                                    ArrayList<String> arrayList3 = new ArrayList();
                                    for (int i4 = 0; i4 < countCategories; i4++) {
                                        String dataType = intentFilter.getDataType(i4);
                                        if (!TextUtils.isEmpty(dataType)) {
                                            arrayList3.add(dataType);
                                        }
                                    }
                                    if (arrayList3.size() > 0) {
                                        Collections.sort(arrayList3);
                                        for (String str3 : arrayList3) {
                                            sb.append(str3);
                                        }
                                        countDataSchemes = intentFilter.countDataSchemes();
                                        if (countDataSchemes > 0) {
                                            ArrayList<String> arrayList4 = new ArrayList();
                                            for (int i5 = 0; i5 < countDataSchemes; i5++) {
                                                String dataScheme = intentFilter.getDataScheme(i5);
                                                if (!TextUtils.isEmpty(dataScheme)) {
                                                    arrayList4.add(dataScheme);
                                                }
                                            }
                                            if (arrayList4.size() > 0) {
                                                Collections.sort(arrayList4);
                                                for (String str4 : arrayList4) {
                                                    sb.append(str4);
                                                }
                                                return sb.toString();
                                            }
                                        }
                                        sb.append("_");
                                        return sb.toString();
                                    }
                                }
                                sb.append("_");
                                countDataSchemes = intentFilter.countDataSchemes();
                                if (countDataSchemes > 0) {
                                }
                                sb.append("_");
                                return sb.toString();
                            }
                        }
                        sb.append("_");
                        if (intentFilter.countDataTypes() > 0) {
                        }
                        sb.append("_");
                        countDataSchemes = intentFilter.countDataSchemes();
                        if (countDataSchemes > 0) {
                        }
                        sb.append("_");
                        return sb.toString();
                    }
                }
                sb.append("_");
                countCategories = intentFilter.countCategories();
                if (countCategories > 0) {
                }
                sb.append("_");
                if (intentFilter.countDataTypes() > 0) {
                }
                sb.append("_");
                countDataSchemes = intentFilter.countDataSchemes();
                if (countDataSchemes > 0) {
                }
                sb.append("_");
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(1:92)(6:11|12|(1:14)(1:90)|15|(4:22|(3:23|24|(1:26)(1:27))|28|29)|61)|30|31|(8:36|37|38|(3:40|41|(1:43)(1:44))|45|(1:47)|48|49)|59|60|61) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0154, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0155, code lost:
        r10 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(p pVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{pVar, str, str2, hashSet, bArr, sb, Boolean.valueOf(z)}) == null) {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pVar.f56789e));
            FileOutputStream fileOutputStream2 = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String name = nextEntry.getName();
                    if (name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextEntry.isDirectory()) {
                        String str3 = Build.CPU_ABI;
                        String str4 = Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null;
                        if (name.contains(str3) || ((!TextUtils.isEmpty(str4) && name.contains(str4)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str3) || (!TextUtils.isEmpty(str4) && "armeabi-v7a".equalsIgnoreCase(str4)))))) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            String substring = name.substring(3);
                            sb2.append(substring.replace(".so", str2 + ".so"));
                            String sb3 = sb2.toString();
                            String substring2 = sb3.substring(0, sb3.lastIndexOf(47));
                            hashSet.add(substring2.substring(substring2.lastIndexOf(47) + 1));
                            g(substring2);
                            File file = new File(sb3);
                            file.delete();
                            file.createNewFile();
                            fileOutputStream = new FileOutputStream(sb3);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
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
                            l1.a(sb3, Boolean.TRUE);
                            fileOutputStream2 = fileOutputStream;
                        }
                    }
                    if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                        String str5 = pVar.m;
                        g(str5);
                        File file2 = new File(str5, pVar.a + "-" + pVar.f56788d + ".dex");
                        try {
                            file2.delete();
                            file2.createNewFile();
                            FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                            while (true) {
                                try {
                                    int read2 = zipInputStream.read(bArr);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    fileOutputStream3.write(bArr, 0, read2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream2 = fileOutputStream3;
                                    l1.a(th);
                                    if (file2 != null && file2.exists()) {
                                        file2.delete();
                                    }
                                    zipInputStream.closeEntry();
                                }
                            }
                            fileOutputStream3.close();
                            if (sb.length() > 0) {
                                sb.setLength(0);
                            }
                            sb.append(file2.getAbsolutePath());
                            l1.a(sb.toString(), Boolean.TRUE);
                            fileOutputStream2 = fileOutputStream3;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    zipInputStream.closeEntry();
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = fileOutputStream2;
                }
            }
            zipInputStream.close();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:155:0x02cc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:203:0x03a7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:221:0x03e4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:322:0x0325 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:323:0x0331 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:324:0x03ad */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:325:0x03b2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:344:0x0431 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:345:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:394:0x00df */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:395:0x00df */
    /* JADX DEBUG: Null dom frontier in handler: EOFException -> 0x01d8 */
    /* JADX DEBUG: Null dom frontier in handler: EOFException -> 0x0325 */
    /* JADX DEBUG: Null dom frontier in handler: EOFException -> 0x03ad */
    /* JADX DEBUG: Null dom frontier in handler: FileNotFoundException | ZipException -> 0x01e6 */
    /* JADX DEBUG: Null dom frontier in handler: FileNotFoundException | ZipException -> 0x0331 */
    /* JADX DEBUG: Null dom frontier in handler: FileNotFoundException | ZipException -> 0x03b2 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x029a */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0583 */
    /* JADX DEBUG: Null dom frontier in handler: all -> 0x0585 */
    /* JADX WARN: Can't wrap try/catch for region: R(5:(9:(2:7|(19:11|12|(1:14)(1:377)|15|(1:17)|18|19|20|21|22|23|24|25|26|(13:30|31|32|33|(1:299)(17:37|38|39|40|41|42|(4:283|284|45|(7:52|53|54|55|(4:56|57|58|(3:60|61|62)(1:179))|180|181)(3:277|278|215))|44|45|(3:47|49|51)(1:282)|52|53|54|55|(5:56|57|58|(0)(0)|62)|180|181)|182|183|(1:246)(19:188|189|190|191|192|193|195|196|(3:197|198|(1:200)(1:201))|202|(1:204)|205|206|207|208|209|210|211|212)|213|214|215|27|28)|308|309|(1:311)|312))|24|25|26|(2:27|28)|308|309|(0)|312)|20|21|22|23) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:32|33|(1:299)(17:37|38|39|40|41|42|(4:283|284|45|(7:52|53|54|55|(4:56|57|58|(3:60|61|62)(1:179))|180|181)(3:277|278|215))|44|45|(3:47|49|51)(1:282)|52|53|54|55|(5:56|57|58|(0)(0)|62)|180|181)|182|183|(1:246)(19:188|189|190|191|192|193|195|196|(3:197|198|(1:200)(1:201))|202|(1:204)|205|206|207|208|209|210|211|212)|213|214|215) */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02b3, code lost:
        r11 = r24;
        r4 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02f1, code lost:
        if (r21 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0338, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0359, code lost:
        throw new java.io.FileNotFoundException(r12 + "--" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0373, code lost:
        throw new java.io.FileNotFoundException(r12 + "--file not exists after copy");
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x038d, code lost:
        throw new java.io.FileNotFoundException(r12 + "--backupFile not exists");
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x03a6, code lost:
        throw new java.io.FileNotFoundException(r12 + "--backupDir not exists");
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x03a7, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x03a9, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03aa, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x03ac, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03ad, code lost:
        r7 = r5;
        r17 = r20;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x03b1, code lost:
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03b2, code lost:
        r7 = r5;
        r17 = r20;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x03bd, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03be, code lost:
        r11 = r4;
        r20 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03c1, code lost:
        r12 = null;
        r16 = null;
        r21 = null;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03dc, code lost:
        r16.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x03e1, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x03e4, code lost:
        if (r21 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x03e7, code lost:
        r11 = r4;
        r17 = "";
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x03eb, code lost:
        r12 = 0;
        r16 = null;
        r21 = null;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x0400, code lost:
        r16.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0405, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0408, code lost:
        if (r21 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x040b, code lost:
        r11 = r4;
        r17 = "";
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x040f, code lost:
        r12 = null;
        r16 = null;
        r21 = null;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0424, code lost:
        r16.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0429, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x042c, code lost:
        if (r21 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x042e, code lost:
        r21.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x043d, code lost:
        if (r15.contains(android.os.Build.CPU_ABI) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x043f, code lost:
        r4 = r29 + "/" + android.os.Build.CPU_ABI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0457, code lost:
        if (android.os.Build.VERSION.SDK_INT < 8) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x045f, code lost:
        if (r15.contains(android.os.Build.CPU_ABI2) == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0461, code lost:
        r19 = r29 + "/" + android.os.Build.CPU_ABI2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0476, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0477, code lost:
        com.kuaishou.weapon.un.l1.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x04b6, code lost:
        if (android.os.Build.VERSION.SDK_INT < 8) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x04be, code lost:
        if (r15.contains(android.os.Build.CPU_ABI2) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x04c0, code lost:
        r7 = r29 + "/" + android.os.Build.CPU_ABI2 + ":" + java.lang.System.getProperty("java.library.path");
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x04df, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x04e0, code lost:
        com.kuaishou.weapon.un.l1.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        r12 = r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        r20 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
        r7 = r28.f56790f.getFilesDir();
        r11 = com.kuaishou.weapon.un.r1.f56835j;
        r0 = new java.io.File(r7, com.kuaishou.weapon.un.r1.f56835j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
        if (r0.exists() != false) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
        r7 = new java.io.File(r0, r28.a + "-" + r28.f56788d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (r7.exists() != false) goto L340;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b2, code lost:
        r0 = new java.io.File(r28.f56789e);
        com.kuaishou.weapon.un.l1.a(r7, r0);
        com.kuaishou.weapon.un.l1.a(r28.f56789e, java.lang.Boolean.TRUE);
        com.kuaishou.weapon.un.b.a(r0);
        com.kuaishou.weapon.un.b.a(r0, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cd, code lost:
        if (r0.exists() != false) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
        r0 = new java.util.zip.ZipFile(r28.f56789e);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x02bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x014e A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x01b6 A[EDGE_INSN: B:397:0x01b6->B:87:0x01b6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e5 A[Catch: all -> 0x02f5, IOException -> 0x02fc, EOFException -> 0x0301, FileNotFoundException -> 0x0307, ZipException -> 0x030b, TRY_LEAVE, TryCatch #33 {EOFException -> 0x0301, FileNotFoundException -> 0x0307, ZipException -> 0x030b, IOException -> 0x02fc, all -> 0x02f5, blocks: (B:43:0x00df, B:45:0x00e5), top: B:380:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0121 A[Catch: IOException -> 0x020e, EOFException -> 0x0215, FileNotFoundException -> 0x0219, ZipException -> 0x021d, all -> 0x02d7, TryCatch #26 {all -> 0x02d7, blocks: (B:47:0x00f0, B:49:0x00fc, B:52:0x0104, B:64:0x011b, B:66:0x0121, B:68:0x0127, B:70:0x012d, B:72:0x0133, B:74:0x0139, B:76:0x013f, B:79:0x014e, B:62:0x0116), top: B:338:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01af  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v49 */
    /* JADX WARN: Type inference failed for: r12v50 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(p pVar, String str, String str2, boolean z) {
        HashSet<String> hashSet;
        boolean z2;
        StringBuilder sb;
        ZipFile zipFile;
        InputStream inputStream;
        ZipFile zipFile2;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream2;
        String str3;
        ZipFile zipFile3;
        StringBuilder sb2;
        String str4;
        String str5;
        String str6;
        Class<?> loadClass;
        Class<?> loadClass2;
        String str7;
        String str8;
        StringBuilder sb3;
        InputStream inputStream3;
        StringBuilder sb4;
        InputStream inputStream4;
        StringBuilder sb5;
        Enumeration<? extends ZipEntry> entries;
        InputStream inputStream5;
        String str9;
        String str10;
        StringBuilder sb6;
        File file;
        StringBuilder sb7;
        InputStream inputStream6;
        FileOutputStream fileOutputStream3;
        StringBuilder sb8;
        String str11;
        String str12;
        InputStream inputStream7;
        InputStream inputStream8;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65542, this, new Object[]{pVar, str, str2, Boolean.valueOf(z)}) != null) {
            return;
        }
        InputStream inputStream9 = r1.f56831f;
        String str13 = ".so";
        String str14 = "-";
        hashSet = new HashSet<>();
        try {
            try {
                try {
                    if (!z && !TextUtils.isEmpty(pVar.n)) {
                        File file2 = new File(pVar.n);
                        if (file2.exists() && file2.isFile()) {
                            z2 = false;
                            String replace = TextUtils.isEmpty(pVar.f56788d) ? pVar.f56788d.replace(".", "") : "";
                            sb = new StringBuilder();
                            if (!z2) {
                                sb.append(pVar.n);
                            }
                            byte[] bArr = new byte[4096];
                            zipFile = null;
                            str8 = null;
                            inputStream = null;
                            str8 = null;
                            str8 = null;
                            ZipFile zipFile4 = new ZipFile(pVar.f56789e);
                            String str15 = "";
                            zipFile2 = zipFile4;
                            entries = zipFile2.entries();
                            inputStream9 = 0;
                            fileOutputStream = null;
                            while (entries.hasMoreElements()) {
                                try {
                                    Enumeration<? extends ZipEntry> enumeration = entries;
                                    ZipEntry nextElement = entries.nextElement();
                                    inputStream2 = inputStream9;
                                    try {
                                        try {
                                            String name = nextElement.getName();
                                            if (!name.startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) || nextElement.isDirectory()) {
                                                str9 = str13;
                                                str10 = str14;
                                                sb6 = sb;
                                                zipFile3 = 1;
                                            } else {
                                                sb6 = sb;
                                                try {
                                                    str11 = Build.CPU_ABI;
                                                    try {
                                                        str10 = str14;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        str10 = str14;
                                                    }
                                                } catch (EOFException unused) {
                                                    sb3 = sb6;
                                                    inputStream9 = inputStream2;
                                                    zipFile3 = zipFile2;
                                                    str3 = str15;
                                                    sb5 = sb3;
                                                    inputStream4 = inputStream9;
                                                    byte[] bArr2 = bArr;
                                                    sb2 = sb5;
                                                    inputStream9 = inputStream4;
                                                    a(pVar, str, replace, hashSet, bArr2, sb2, z2);
                                                    if (zipFile3 != null) {
                                                    }
                                                    if (inputStream9 != 0) {
                                                    }
                                                } catch (FileNotFoundException unused2) {
                                                    sb3 = sb6;
                                                    inputStream9 = inputStream2;
                                                    zipFile3 = zipFile2;
                                                    str3 = str15;
                                                    sb4 = sb3;
                                                    inputStream3 = inputStream9;
                                                    byte[] bArr3 = bArr;
                                                    sb2 = sb4;
                                                    inputStream9 = inputStream3;
                                                    a(pVar, str, replace, hashSet, bArr3, sb2, z2);
                                                    if (zipFile3 != null) {
                                                    }
                                                    if (inputStream9 != null) {
                                                    }
                                                } catch (ZipException unused3) {
                                                    sb3 = sb6;
                                                    inputStream9 = inputStream2;
                                                    zipFile3 = zipFile2;
                                                    str3 = str15;
                                                    sb4 = sb3;
                                                    inputStream3 = inputStream9;
                                                    byte[] bArr32 = bArr;
                                                    sb2 = sb4;
                                                    inputStream9 = inputStream3;
                                                    a(pVar, str, replace, hashSet, bArr32, sb2, z2);
                                                    if (zipFile3 != null) {
                                                    }
                                                    if (inputStream9 != null) {
                                                    }
                                                } catch (IOException e2) {
                                                    e = e2;
                                                }
                                                try {
                                                    if (Build.VERSION.SDK_INT >= 8) {
                                                        try {
                                                            str12 = Build.CPU_ABI2;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            l1.a(th);
                                                            str12 = null;
                                                            if (name.contains(str11)) {
                                                            }
                                                            StringBuilder sb9 = new StringBuilder();
                                                            sb9.append(str);
                                                            sb9.append(name.substring(3).replace(str13, replace + str13));
                                                            String sb10 = sb9.toString();
                                                            String substring = sb10.substring(0, sb10.lastIndexOf(47));
                                                            zipFile3 = 1;
                                                            hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                                                            g(substring);
                                                            new File(sb10).delete();
                                                            inputStream7 = zipFile2.getInputStream(nextElement);
                                                            fileOutputStream2 = new FileOutputStream(sb10);
                                                            str9 = str13;
                                                            while (true) {
                                                                try {
                                                                    read = inputStream7.read(bArr);
                                                                    inputStream2 = inputStream7;
                                                                    if (read <= 0) {
                                                                    }
                                                                    fileOutputStream2.write(bArr, 0, read);
                                                                    inputStream7 = inputStream2;
                                                                } catch (EOFException unused4) {
                                                                    inputStream2 = inputStream7;
                                                                } catch (FileNotFoundException | ZipException unused5) {
                                                                    inputStream2 = inputStream7;
                                                                } catch (IOException e3) {
                                                                    e = e3;
                                                                    inputStream2 = inputStream7;
                                                                } catch (Throwable th3) {
                                                                    th = th3;
                                                                    inputStream2 = inputStream7;
                                                                }
                                                            }
                                                            l1.a(sb10, Boolean.TRUE);
                                                            fileOutputStream = fileOutputStream2;
                                                            if (name.endsWith(".dex")) {
                                                            }
                                                            str14 = str10;
                                                            sb = sb6;
                                                            entries = enumeration;
                                                            inputStream9 = inputStream2;
                                                            str13 = str9;
                                                        }
                                                        if (name.contains(str11) || ((!TextUtils.isEmpty(str12) && name.contains(str12)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str11) || (!TextUtils.isEmpty(str12) && "armeabi-v7a".equalsIgnoreCase(str12)))))) {
                                                            StringBuilder sb92 = new StringBuilder();
                                                            sb92.append(str);
                                                            sb92.append(name.substring(3).replace(str13, replace + str13));
                                                            String sb102 = sb92.toString();
                                                            String substring2 = sb102.substring(0, sb102.lastIndexOf(47));
                                                            zipFile3 = 1;
                                                            hashSet.add(substring2.substring(substring2.lastIndexOf(47) + 1));
                                                            g(substring2);
                                                            new File(sb102).delete();
                                                            inputStream7 = zipFile2.getInputStream(nextElement);
                                                            fileOutputStream2 = new FileOutputStream(sb102);
                                                            str9 = str13;
                                                            while (true) {
                                                                read = inputStream7.read(bArr);
                                                                inputStream2 = inputStream7;
                                                                if (read <= 0) {
                                                                    break;
                                                                }
                                                                try {
                                                                    fileOutputStream2.write(bArr, 0, read);
                                                                    inputStream7 = inputStream2;
                                                                } catch (EOFException unused6) {
                                                                    fileOutputStream = fileOutputStream2;
                                                                    zipFile3 = zipFile2;
                                                                    str3 = str15;
                                                                    inputStream4 = inputStream2;
                                                                    sb5 = sb6;
                                                                    byte[] bArr22 = bArr;
                                                                    sb2 = sb5;
                                                                    inputStream9 = inputStream4;
                                                                    a(pVar, str, replace, hashSet, bArr22, sb2, z2);
                                                                    if (zipFile3 != null) {
                                                                    }
                                                                    if (inputStream9 != 0) {
                                                                    }
                                                                } catch (FileNotFoundException | ZipException unused7) {
                                                                    fileOutputStream = fileOutputStream2;
                                                                    zipFile3 = zipFile2;
                                                                    str3 = str15;
                                                                    inputStream3 = inputStream2;
                                                                    sb4 = sb6;
                                                                    byte[] bArr322 = bArr;
                                                                    sb2 = sb4;
                                                                    inputStream9 = inputStream3;
                                                                    a(pVar, str, replace, hashSet, bArr322, sb2, z2);
                                                                    if (zipFile3 != null) {
                                                                    }
                                                                    if (inputStream9 != null) {
                                                                    }
                                                                } catch (IOException e4) {
                                                                    e = e4;
                                                                    fileOutputStream = fileOutputStream2;
                                                                    zipFile3 = zipFile2;
                                                                    inputStream9 = inputStream2;
                                                                    sb2 = sb6;
                                                                    str3 = str15;
                                                                    a(pVar, str, replace, hashSet, bArr, sb2, z2);
                                                                    l1.a(e);
                                                                    if (zipFile3 != null) {
                                                                    }
                                                                    if (inputStream9 != null) {
                                                                    }
                                                                } catch (Throwable th4) {
                                                                    th = th4;
                                                                    zipFile = zipFile2;
                                                                    if (zipFile != null) {
                                                                    }
                                                                    if (inputStream2 != null) {
                                                                    }
                                                                    if (fileOutputStream2 != null) {
                                                                    }
                                                                    throw th;
                                                                }
                                                            }
                                                            l1.a(sb102, Boolean.TRUE);
                                                            fileOutputStream = fileOutputStream2;
                                                        } else {
                                                            entries = enumeration;
                                                            inputStream9 = inputStream2;
                                                            sb = sb6;
                                                            str14 = str10;
                                                        }
                                                    }
                                                    fileOutputStream2 = new FileOutputStream(sb102);
                                                    str9 = str13;
                                                    while (true) {
                                                        read = inputStream7.read(bArr);
                                                        inputStream2 = inputStream7;
                                                        if (read <= 0) {
                                                        }
                                                        fileOutputStream2.write(bArr, 0, read);
                                                        inputStream7 = inputStream2;
                                                    }
                                                    l1.a(sb102, Boolean.TRUE);
                                                    fileOutputStream = fileOutputStream2;
                                                } catch (EOFException unused8) {
                                                    inputStream9 = inputStream7;
                                                    sb3 = sb6;
                                                    zipFile3 = zipFile2;
                                                    str3 = str15;
                                                    sb5 = sb3;
                                                    inputStream4 = inputStream9;
                                                    byte[] bArr222 = bArr;
                                                    sb2 = sb5;
                                                    inputStream9 = inputStream4;
                                                    a(pVar, str, replace, hashSet, bArr222, sb2, z2);
                                                    if (zipFile3 != null) {
                                                    }
                                                    if (inputStream9 != 0) {
                                                    }
                                                } catch (FileNotFoundException unused9) {
                                                    inputStream8 = inputStream7;
                                                    inputStream9 = inputStream8;
                                                    sb3 = sb6;
                                                    zipFile3 = zipFile2;
                                                    str3 = str15;
                                                    sb4 = sb3;
                                                    inputStream3 = inputStream9;
                                                    byte[] bArr3222 = bArr;
                                                    sb2 = sb4;
                                                    inputStream9 = inputStream3;
                                                    a(pVar, str, replace, hashSet, bArr3222, sb2, z2);
                                                    if (zipFile3 != null) {
                                                    }
                                                    if (inputStream9 != null) {
                                                    }
                                                } catch (ZipException unused10) {
                                                    inputStream8 = inputStream7;
                                                    inputStream9 = inputStream8;
                                                    sb3 = sb6;
                                                    zipFile3 = zipFile2;
                                                    str3 = str15;
                                                    sb4 = sb3;
                                                    inputStream3 = inputStream9;
                                                    byte[] bArr32222 = bArr;
                                                    sb2 = sb4;
                                                    inputStream9 = inputStream3;
                                                    a(pVar, str, replace, hashSet, bArr32222, sb2, z2);
                                                    if (zipFile3 != null) {
                                                    }
                                                    if (inputStream9 != null) {
                                                    }
                                                } catch (IOException e5) {
                                                    e = e5;
                                                    inputStream2 = inputStream7;
                                                    inputStream9 = inputStream2;
                                                    sb3 = sb6;
                                                    zipFile3 = zipFile2;
                                                    sb2 = sb3;
                                                    inputStream9 = inputStream9;
                                                    str3 = str15;
                                                    a(pVar, str, replace, hashSet, bArr, sb2, z2);
                                                    l1.a(e);
                                                    if (zipFile3 != null) {
                                                    }
                                                    if (inputStream9 != null) {
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    inputStream2 = inputStream7;
                                                    inputStream = inputStream2;
                                                    inputStream2 = inputStream;
                                                    fileOutputStream2 = fileOutputStream;
                                                    zipFile = zipFile2;
                                                    if (zipFile != null) {
                                                    }
                                                    if (inputStream2 != null) {
                                                    }
                                                    if (fileOutputStream2 != null) {
                                                    }
                                                    throw th;
                                                }
                                                str12 = null;
                                                if (name.contains(str11)) {
                                                }
                                                StringBuilder sb922 = new StringBuilder();
                                                sb922.append(str);
                                                sb922.append(name.substring(3).replace(str13, replace + str13));
                                                String sb1022 = sb922.toString();
                                                String substring22 = sb1022.substring(0, sb1022.lastIndexOf(47));
                                                zipFile3 = 1;
                                                hashSet.add(substring22.substring(substring22.lastIndexOf(47) + 1));
                                                g(substring22);
                                                new File(sb1022).delete();
                                                inputStream7 = zipFile2.getInputStream(nextElement);
                                            }
                                            if (name.endsWith(".dex") || nextElement.isDirectory() || !z2) {
                                                str14 = str10;
                                                sb = sb6;
                                                entries = enumeration;
                                                inputStream9 = inputStream2;
                                            } else {
                                                String str16 = pVar.m;
                                                g(str16);
                                                StringBuilder sb11 = new StringBuilder();
                                                sb11.append(pVar.a);
                                                String str17 = str10;
                                                try {
                                                    sb11.append(str17);
                                                    sb11.append(pVar.f56788d);
                                                    sb11.append(".dex");
                                                    file = new File(str16, sb11.toString());
                                                    try {
                                                        inputStream6 = zipFile2.getInputStream(nextElement);
                                                    } catch (Throwable unused11) {
                                                        sb7 = sb6;
                                                    }
                                                } catch (Throwable unused12) {
                                                    StringBuilder sb12 = sb6;
                                                    file = null;
                                                    sb7 = sb12;
                                                    inputStream9 = inputStream2;
                                                    sb3 = sb7;
                                                    if (file != null) {
                                                        try {
                                                            if (file.exists()) {
                                                                file.delete();
                                                            }
                                                        } catch (EOFException unused13) {
                                                            zipFile3 = zipFile2;
                                                            str3 = str15;
                                                            sb5 = sb3;
                                                            inputStream4 = inputStream9;
                                                            byte[] bArr2222 = bArr;
                                                            sb2 = sb5;
                                                            inputStream9 = inputStream4;
                                                            a(pVar, str, replace, hashSet, bArr2222, sb2, z2);
                                                            if (zipFile3 != null) {
                                                            }
                                                            if (inputStream9 != 0) {
                                                            }
                                                        } catch (FileNotFoundException | ZipException unused14) {
                                                            zipFile3 = zipFile2;
                                                            str3 = str15;
                                                            sb4 = sb3;
                                                            inputStream3 = inputStream9;
                                                            byte[] bArr322222 = bArr;
                                                            sb2 = sb4;
                                                            inputStream9 = inputStream3;
                                                            a(pVar, str, replace, hashSet, bArr322222, sb2, z2);
                                                            if (zipFile3 != null) {
                                                            }
                                                            if (inputStream9 != null) {
                                                            }
                                                        } catch (IOException e6) {
                                                            e = e6;
                                                            zipFile3 = zipFile2;
                                                            sb2 = sb3;
                                                            inputStream9 = inputStream9;
                                                            str3 = str15;
                                                            a(pVar, str, replace, hashSet, bArr, sb2, z2);
                                                            l1.a(e);
                                                            if (zipFile3 != null) {
                                                            }
                                                            if (inputStream9 != null) {
                                                            }
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            inputStream = inputStream9;
                                                            inputStream2 = inputStream;
                                                            fileOutputStream2 = fileOutputStream;
                                                            zipFile = zipFile2;
                                                            if (zipFile != null) {
                                                            }
                                                            if (inputStream2 != null) {
                                                            }
                                                            if (fileOutputStream2 != null) {
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    str14 = str17;
                                                    sb = sb3;
                                                    entries = enumeration;
                                                    inputStream9 = inputStream9;
                                                    str13 = str9;
                                                }
                                                try {
                                                    FileOutputStream fileOutputStream4 = new FileOutputStream(file);
                                                    while (true) {
                                                        try {
                                                            int read2 = inputStream6.read(bArr);
                                                            if (read2 <= 0) {
                                                                break;
                                                            }
                                                            fileOutputStream4.write(bArr, 0, read2);
                                                        } catch (Throwable unused15) {
                                                            fileOutputStream3 = fileOutputStream4;
                                                            sb8 = sb6;
                                                        }
                                                    }
                                                    fileOutputStream4.close();
                                                    if (inputStream6 != null) {
                                                        inputStream6.close();
                                                    }
                                                    sb8 = sb6;
                                                    try {
                                                        sb8.append(file.getAbsolutePath());
                                                        fileOutputStream3 = fileOutputStream4;
                                                    } catch (Throwable unused16) {
                                                        fileOutputStream3 = fileOutputStream4;
                                                    }
                                                    try {
                                                        l1.a(sb8.toString(), Boolean.TRUE);
                                                        str14 = str17;
                                                        sb = sb8;
                                                        entries = enumeration;
                                                        fileOutputStream = fileOutputStream3;
                                                        inputStream9 = inputStream6;
                                                    } catch (Throwable unused17) {
                                                        fileOutputStream = fileOutputStream3;
                                                        sb3 = sb8;
                                                        inputStream9 = inputStream6;
                                                        if (file != null) {
                                                        }
                                                        str14 = str17;
                                                        sb = sb3;
                                                        entries = enumeration;
                                                        inputStream9 = inputStream9;
                                                        str13 = str9;
                                                    }
                                                } catch (Throwable unused18) {
                                                    sb7 = sb6;
                                                    inputStream2 = inputStream6;
                                                    inputStream9 = inputStream2;
                                                    sb3 = sb7;
                                                    if (file != null) {
                                                    }
                                                    str14 = str17;
                                                    sb = sb3;
                                                    entries = enumeration;
                                                    inputStream9 = inputStream9;
                                                    str13 = str9;
                                                }
                                            }
                                            str13 = str9;
                                        } catch (Throwable th7) {
                                            th = th7;
                                        }
                                    } catch (EOFException unused19) {
                                        sb3 = sb;
                                    } catch (FileNotFoundException unused20) {
                                        sb3 = sb;
                                    } catch (ZipException unused21) {
                                        sb3 = sb;
                                    } catch (IOException e7) {
                                        e = e7;
                                        sb3 = sb;
                                        inputStream9 = inputStream2;
                                    }
                                } catch (EOFException unused22) {
                                    sb3 = sb;
                                    inputStream2 = inputStream9;
                                } catch (FileNotFoundException unused23) {
                                    sb3 = sb;
                                    inputStream2 = inputStream9;
                                } catch (ZipException unused24) {
                                    sb3 = sb;
                                    inputStream2 = inputStream9;
                                } catch (IOException e8) {
                                    e = e8;
                                    sb3 = sb;
                                } catch (Throwable th8) {
                                    th = th8;
                                    inputStream2 = inputStream9;
                                }
                            }
                            sb2 = sb;
                            inputStream5 = inputStream9;
                            zipFile2.close();
                            if (inputStream5 != null) {
                                inputStream5.close();
                            }
                            str3 = str15;
                        }
                    }
                    entries = zipFile2.entries();
                    inputStream9 = 0;
                    fileOutputStream = null;
                    while (entries.hasMoreElements()) {
                    }
                    sb2 = sb;
                    inputStream5 = inputStream9;
                    zipFile2.close();
                    if (inputStream5 != null) {
                    }
                    str3 = str15;
                } catch (EOFException unused25) {
                    sb3 = sb;
                    inputStream9 = null;
                    fileOutputStream = null;
                } catch (FileNotFoundException | ZipException unused26) {
                    sb3 = sb;
                    inputStream9 = null;
                    fileOutputStream = null;
                } catch (IOException e9) {
                    e = e9;
                    sb3 = sb;
                    inputStream9 = null;
                    fileOutputStream = null;
                } catch (Throwable th9) {
                    th = th9;
                    fileOutputStream = null;
                }
                ZipFile zipFile42 = new ZipFile(pVar.f56789e);
                String str152 = "";
                zipFile2 = zipFile42;
            } catch (Throwable th10) {
                th = th10;
                fileOutputStream2 = null;
                inputStream2 = null;
                if (zipFile != null) {
                    zipFile.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th11) {
            th = th11;
            inputStream = inputStream9;
            zipFile2 = zipFile3;
        }
        z2 = true;
        if (TextUtils.isEmpty(pVar.f56788d)) {
        }
        sb = new StringBuilder();
        if (!z2) {
        }
        byte[] bArr4 = new byte[4096];
        zipFile = null;
        str8 = null;
        inputStream = null;
        str8 = null;
        str8 = null;
        str4 = str3;
        if (TextUtils.isEmpty(str4) && (("armeabi-v7a".equals(Build.CPU_ABI) && hashSet.contains("armeabi")) || (Build.VERSION.SDK_INT >= 8 && "armeabi-v7a".equals(Build.CPU_ABI2) && hashSet.contains("armeabi")))) {
            str4 = str + "/armeabi:" + System.getProperty("java.library.path");
        }
        pVar.f56792h = str4;
        pVar.n = sb2.toString();
        try {
            str5 = str2;
        } catch (Throwable unused27) {
            str5 = str2;
        }
        try {
            String absolutePath = new File(str5, "apkDex").getAbsolutePath();
            l1.b(absolutePath);
            g(absolutePath);
            pVar.f56791g = new q(sb2.toString(), absolutePath, str4, getClass().getClassLoader());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(pVar.f56787c);
            str6 = r1.f56831f;
        } catch (Throwable unused28) {
            str6 = r1.f56831f;
            String absolutePath2 = new File(str5, "dexDex").getAbsolutePath();
            l1.b(absolutePath2);
            g(absolutePath2);
            pVar.f56791g = new q(pVar.f56789e, absolutePath2, str4, getClass().getClassLoader());
            loadClass = pVar.f56791g.loadClass(pVar.f56787c + str6);
            if (loadClass != null || TextUtils.isEmpty(loadClass.getName())) {
                throw new Exception("class Weapon ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
            return;
        }
        try {
            sb13.append(str6);
            loadClass2 = pVar.f56791g.loadClass(sb13.toString());
            if (loadClass2 != null || TextUtils.isEmpty(loadClass2.getName())) {
                throw new Exception("class W_ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
            return;
        } catch (Throwable unused29) {
            String absolutePath22 = new File(str5, "dexDex").getAbsolutePath();
            l1.b(absolutePath22);
            g(absolutePath22);
            pVar.f56791g = new q(pVar.f56789e, absolutePath22, str4, getClass().getClassLoader());
            loadClass = pVar.f56791g.loadClass(pVar.f56787c + str6);
            if (loadClass != null) {
            }
            throw new Exception("class Weapon ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
        }
        String str18 = str8;
        if (str18 != null) {
            str4 = str7 + ":" + str18 + ":" + System.getProperty("java.library.path");
        } else {
            str4 = str7 + ":" + System.getProperty("java.library.path");
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = str + "/armeabi:" + System.getProperty("java.library.path");
        }
        pVar.f56792h = str4;
        pVar.n = sb2.toString();
        str5 = str2;
        String absolutePath3 = new File(str5, "apkDex").getAbsolutePath();
        l1.b(absolutePath3);
        g(absolutePath3);
        pVar.f56791g = new q(sb2.toString(), absolutePath3, str4, getClass().getClassLoader());
        StringBuilder sb132 = new StringBuilder();
        sb132.append(pVar.f56787c);
        str6 = r1.f56831f;
        sb132.append(str6);
        loadClass2 = pVar.f56791g.loadClass(sb132.toString());
        if (loadClass2 != null) {
        }
        throw new Exception("class W_ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
    }

    private synchronized boolean a(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, pVar)) == null) {
            synchronized (this) {
                if (pVar != null) {
                    if (!TextUtils.isEmpty(pVar.f56789e)) {
                        p pVar2 = l.get(pVar.f56789e);
                        if (pVar2 != null) {
                            if (pVar2.f56788d.equals(pVar.f56788d)) {
                                return true;
                            }
                            f(pVar2.f56789e);
                        }
                        try {
                            pVar.f56790f = f56782j;
                            if (pVar.p == 1) {
                                if (TextUtils.isEmpty(pVar.f56787c) || TextUtils.isEmpty(pVar.f56789e)) {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                                pVar.m = f56782j.getFilesDir().getCanonicalPath() + r1.f56836k + pVar.a;
                                String str = pVar.m + "/dex";
                                String str2 = (pVar.m + "/lib/" + this.f56784b) + "/" + f56783k.nextInt();
                                g(str);
                                l1.a(str, Boolean.FALSE);
                                g(str2);
                                a(pVar, str2, str, false);
                                m.put(pVar.f56787c, pVar);
                                l.put(pVar.f56789e, pVar);
                                a(pVar, pVar.o);
                            }
                            if (pVar.p != 1 || 0 != 0) {
                                PackageInfo packageInfo = pVar.s;
                                if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                                    packageInfo = f56782j.getPackageManager().getPackageArchiveInfo(pVar.f56789e, 1);
                                }
                                if (TextUtils.isEmpty(packageInfo.packageName) || !packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                                    throw new Exception("weapon package name check failed");
                                }
                                if (pVar.p != 1 && pVar.f56786b != 1 && !((Boolean) a(pVar.f56794j, pVar.f56789e).first).booleanValue()) {
                                    return false;
                                }
                                pVar.f56787c = packageInfo.packageName;
                                pVar.o = packageInfo.applicationInfo.className;
                                pVar.f56788d = packageInfo.versionName;
                                pVar.l = packageInfo.activities;
                                pVar.q = packageInfo.applicationInfo.theme;
                                pVar.m = f56782j.getFilesDir().getCanonicalPath() + r1.f56836k + pVar.a;
                                String str3 = pVar.m + "/dex";
                                String str4 = (pVar.m + "/lib/" + this.f56784b) + "/" + f56783k.nextInt();
                                g(str3);
                                l1.a(str3, Boolean.FALSE);
                                g(str4);
                                a(pVar, str4, str3, true);
                                m.put(pVar.f56787c, pVar);
                                l.put(pVar.f56789e, pVar);
                                o.add(Integer.valueOf(pVar.a));
                                a(pVar, packageInfo.applicationInfo.className);
                            }
                            return true;
                        } catch (Throwable unused) {
                            f(pVar.f56789e);
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean a(p pVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, pVar, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                Class<?> loadClass = pVar.f56791g.loadClass(str);
                if (loadClass.newInstance() instanceof Application) {
                    Application application = (Application) loadClass.newInstance();
                    e.a(Application.class, f56782j, application);
                    a(application, f56782j);
                    application.onCreate();
                }
                return true;
            } catch (Throwable th) {
                l1.a(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static o c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f56781i : (o) invokeV.objValue;
    }

    public static Application d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f56782j : (Application) invokeV.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
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
            } catch (Throwable th) {
                l1.a(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public p a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return m.get(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (p) invokeL.objValue;
    }

    public List<p> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : m.keySet()) {
                arrayList.add(m.get(str));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(Application application, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, application, context) == null) {
            Class<?> cls = context.getClass();
            for (Class<Application> cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    Field declaredField = cls2.getDeclaredField("mBase");
                    declaredField.setAccessible(true);
                    if (declaredField.getType().isAssignableFrom(cls)) {
                        declaredField.set(application, context);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void a(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rVar) == null) {
            synchronized (this) {
                try {
                } finally {
                }
                if (rVar.f56823d == null) {
                    return;
                }
                p pVar = m.get(rVar.a);
                if (pVar != null) {
                    if (pVar.r == null) {
                        pVar.r = new ArrayList();
                    }
                    for (int i2 = 0; i2 < pVar.r.size(); i2++) {
                        if (rVar.a(pVar.r.get(i2))) {
                            return;
                        }
                    }
                    pVar.r.add(rVar);
                    String a = a(rVar.f56823d);
                    if (!TextUtils.isEmpty(a) && !a.equals("____")) {
                        if (!n.keySet().contains(a) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a)) {
                            WeaponRECE weaponRECE = new WeaponRECE();
                            f56782j.registerReceiver(weaponRECE, rVar.f56823d);
                            if (0 != 0) {
                                try {
                                    Thread.sleep(3000L);
                                } catch (InterruptedException e2) {
                                    l1.a(e2);
                                }
                                f56782j.registerReceiver(weaponRECE, rVar.f56823d);
                            }
                            n.put(a, weaponRECE);
                        }
                    }
                }
            }
        }
    }

    public boolean a(p pVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, pVar, z)) == null) {
            System.currentTimeMillis();
            this.a = z;
            this.f56784b = pVar.f56788d;
            return a(pVar);
        }
        return invokeLZ.booleanValue;
    }

    public p b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                return l.get(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (p) invokeL.objValue;
    }

    public Map<String, p> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? m : (Map) invokeV.objValue;
    }

    public synchronized void b(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rVar) == null) {
            synchronized (this) {
                if (rVar != null) {
                    try {
                    } catch (Throwable th) {
                        l1.a(th);
                    }
                    if (rVar.f56823d != null) {
                        p pVar = m.get(rVar.a);
                        if (pVar != null && pVar.r != null) {
                            ArrayList<Integer> arrayList = new ArrayList();
                            for (int i2 = 0; i2 < pVar.r.size(); i2++) {
                                if (rVar.a(pVar.r.get(i2))) {
                                    arrayList.add(Integer.valueOf(i2));
                                }
                            }
                            for (Integer num : arrayList) {
                                int intValue = num.intValue();
                                if (pVar != null && pVar.r != null) {
                                    pVar.r.remove(intValue);
                                }
                            }
                            if (pVar != null && pVar.r != null && pVar.r.size() == 0) {
                                pVar.r = null;
                            }
                        }
                        String a = a(rVar.f56823d);
                        if (!TextUtils.isEmpty(a) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a)) {
                            for (p pVar2 : a()) {
                                if (pVar2.r != null && pVar2.r.size() > 0) {
                                    for (r rVar2 : pVar2.r) {
                                        String a2 = a(rVar2.f56823d);
                                        if (!TextUtils.isEmpty(a2) && a2.equals(a)) {
                                            return;
                                        }
                                    }
                                    continue;
                                }
                            }
                            f56782j.unregisterReceiver(n.get(a));
                            n.remove(a);
                        }
                    }
                }
            }
        }
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            p pVar = m.get(str);
            if (pVar == null) {
                return null;
            }
            return pVar.f56789e;
        }
        return (String) invokeL.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? m.containsKey(str) : invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            p pVar = m.get(str);
            if (pVar != null) {
                l.remove(pVar.f56789e);
                m.remove(str);
                l1.b(pVar.m);
                Application application = f56782j;
                if (application != null) {
                    l1.b(application.getFileStreamPath(pVar.f56787c).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            p pVar = l.get(str);
            if (pVar != null) {
                l.remove(str);
                m.remove(pVar.f56787c);
                l1.b(pVar.m);
                Application application = f56782j;
                if (application != null) {
                    l1.b(application.getFileStreamPath(pVar.f56787c).getAbsolutePath());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
