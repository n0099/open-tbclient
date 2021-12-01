package com.kuaishou.weapon.un;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f56739b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f56740c = "16";

    /* renamed from: d  reason: collision with root package name */
    public static final String f56741d = "62c80c436b7547a68a12774c67519836";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f56742b;

        public a(String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f56742b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g1.a(this.a, this.f56742b);
            }
        }
    }

    public l1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, obj, str, clsArr, objArr)) == null) {
            if (obj == null || TextUtils.isEmpty(str)) {
                throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
            } else if (clsArr == null || objArr == null || clsArr.length == objArr.length) {
                Method[] declaredMethods = obj.getClass().getDeclaredMethods();
                Method method = null;
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Method method2 = declaredMethods[i2];
                    if (a(method2, str, clsArr)) {
                        method = method2;
                        break;
                    }
                    i2++;
                }
                if (method != null) {
                    return method.invoke(obj, objArr);
                }
                throw new NoSuchMethodException("cannot find method in target methodName=" + str);
            } else {
                throw new NoSuchMethodException("paramTypes or args fail");
            }
        }
        return invokeLLLL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return n.i().b().getAndroidID();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, str, map) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject a2 = new d1(str, q0.f56808f).a(context);
            if (map == null || map.size() <= 0) {
                a2.put("module_section", new JSONObject());
            } else {
                a2.put("module_section", new JSONObject(map));
            }
            t1.a().a(new a(a2.toString(), context));
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(File file, File file2) {
        Throwable th;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2) == null) || file == null || file2 == null || !a(file)) {
            return;
        }
        if (file2.exists()) {
            file2.delete();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    try {
                        a(th);
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused4) {
        }
    }

    public static void a(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, str, bool) == null) && bool.booleanValue()) {
            a("771", new File(str).getParentFile().getAbsolutePath());
        }
    }

    public static void a(Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, th) == null) && r0.b()) {
            th.printStackTrace();
        }
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) ? file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0 : invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return a(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || !a(str)) {
                return false;
            }
            try {
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("chmod " + str2 + " " + str + StringUtils.LF).waitFor();
                return true;
            } catch (Throwable th) {
                a(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Method method, String str, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, method, str, clsArr)) == null) {
            if (str.equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if ((parameterTypes != null && parameterTypes.length != 0) || (clsArr != null && clsArr.length != 0)) {
                    if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                        return false;
                    }
                    if (((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) || parameterTypes.length != clsArr.length) {
                        return false;
                    }
                    for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                        if (parameterTypes[i2] != clsArr[i2]) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static String[] a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(f56739b)) {
                String k2 = new d(context).k();
                if (TextUtils.isEmpty(k2)) {
                    return new String[2];
                }
                String[] split = k2.split("-");
                if (split == null || split.length != 2) {
                    return new String[2];
                }
                a = split[0];
                f56739b = split[1];
                return split;
            }
            return new String[]{a, f56739b};
        }
        return (String[]) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            try {
                return n.i().b().getHost();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String userId = n.i().b().getUserId();
                String k2 = k();
                String channel = n.i().b().getChannel();
                String j2 = j();
                String m = m();
                String str = "";
                jSONObject.put("userId", TextUtils.isEmpty(userId) ? "" : URLEncoder.encode(userId, "UTF-8"));
                jSONObject.put(Constants.PARAM_PLATFORM, TextUtils.isEmpty(k2) ? "" : URLEncoder.encode(k2, "UTF-8"));
                jSONObject.put("channel", TextUtils.isEmpty(channel) ? "" : URLEncoder.encode(channel, "UTF-8"));
                try {
                    if (new d(context).b(d.Z0)) {
                        jSONObject.put(SearchJsBridge.COOKIE_MOD, TextUtils.isEmpty(j2) ? "" : URLEncoder.encode(j2, "UTF-8"));
                        if (!TextUtils.isEmpty(m)) {
                            str = URLEncoder.encode(m, "UTF-8");
                        }
                    } else {
                        jSONObject.put(SearchJsBridge.COOKIE_MOD, "");
                    }
                    jSONObject.put("sysver", str);
                } catch (Exception unused) {
                }
                return jSONObject;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        b(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean b(java.lang.String r5, java.lang.String r6) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.kuaishou.weapon.un.l1.$ic
            if (r0 != 0) goto L48
        L4:
            java.lang.String r0 = "\\."
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            r2 = 0
            if (r1 != 0) goto L47
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L14
            goto L47
        L14:
            java.lang.String[] r5 = r5.split(r0)     // Catch: java.lang.Throwable -> L47
            java.lang.String[] r6 = r6.split(r0)     // Catch: java.lang.Throwable -> L47
            r0 = 0
        L1d:
            int r1 = r5.length     // Catch: java.lang.Throwable -> L47
            r3 = 1
            if (r0 >= r1) goto L42
            int r1 = r6.length     // Catch: java.lang.Throwable -> L47
            if (r0 >= r1) goto L42
            r1 = r5[r0]     // Catch: java.lang.Throwable -> L47
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L47
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L47
            r4 = r6[r0]     // Catch: java.lang.Throwable -> L47
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L47
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L47
            int r1 = r1 - r4
            if (r1 == 0) goto L3f
            if (r1 <= 0) goto L3e
            r2 = 1
        L3e:
            return r2
        L3f:
            int r0 = r0 + 1
            goto L1d
        L42:
            int r5 = r5.length     // Catch: java.lang.Throwable -> L47
            int r6 = r6.length     // Catch: java.lang.Throwable -> L47
            if (r5 <= r6) goto L47
            r2 = 1
        L47:
            return r2
        L48:
            r2 = r0
            r3 = 65551(0x1000f, float:9.1857E-41)
            r4 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeLL(r3, r4, r5, r6)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.un.l1.b(java.lang.String, java.lang.String):boolean");
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            try {
                return n.i().b().getImei();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Iterator<String> keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                JSONObject b2 = b(context);
                if (b2 != null && (keys = b2.keys()) != null) {
                    String str = "";
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = b2.getString(next);
                        sb.append(str);
                        sb.append(next);
                        sb.append("=");
                        sb.append(string);
                        str = ";";
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void c(String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
        }
    }

    public static void c(String str, String str2) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (a(file)) {
            if (file2.exists()) {
                file2.delete();
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        try {
                            a(th);
                            if (fileOutputStream == null) {
                                return;
                            }
                            fileOutputStream.close();
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused4) {
            }
        }
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            try {
                return (String) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager());
            } catch (Throwable th) {
                a(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, str, str2) == null) {
            a = str;
            f56739b = str2;
        }
    }

    public static String[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            try {
                return n.i().b().getImeis();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String[]) invokeV.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable th) {
                a(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static List<String> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                return n.i().b().getInstalledPackages();
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    public static Location f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            try {
                return n.i().b().getLocation();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Location) invokeV.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            try {
                return context.getPackageName();
            } catch (Throwable th) {
                a(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            try {
                return n.i().b().getMacAddress();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                String deviceId = n.i().b().getDeviceId();
                if (!TextUtils.isEmpty(deviceId)) {
                    r1.r = 1;
                    return deviceId;
                }
            } catch (Exception e2) {
                a(e2);
            }
            r1.r = 4;
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                return n.i().b().getOaid();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null && packageInfo.applicationInfo != null) {
                    return packageInfo.applicationInfo.className;
                }
            } catch (Throwable th) {
                a(th);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            try {
                return n.i().b().getPS();
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return Build.MANUFACTURER + "(" + Build.MODEL + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? "ANDROID_PHONE" : (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            try {
                return n.i().b().getProductName();
            } catch (Exception unused) {
                return "UNKNOWN_PRODUCT";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            return "ANDROID_" + Build.VERSION.RELEASE;
        }
        return (String) invokeV.objValue;
    }
}
