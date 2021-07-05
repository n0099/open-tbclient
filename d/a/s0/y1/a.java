package d.a.s0.y1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.multidex.MultiDex;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69597a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f69598b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f69599c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.y1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1895a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, classLoader, list, file) == null) {
                Object obj = a.g(classLoader, "pathList").get(classLoader);
                a.f(obj, "dexElements", c(obj, new ArrayList(list), file));
            }
        }

        public static Object[] c(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, obj, arrayList, file)) == null) ? (Object[]) a.h(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, arrayList, file) : (Object[]) invokeLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            IOException[] iOExceptionArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, classLoader, list, file) == null) {
                Object obj = a.g(classLoader, "pathList").get(classLoader);
                ArrayList arrayList = new ArrayList();
                a.f(obj, "dexElements", c(obj, new ArrayList(list), file, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                    }
                    Field g2 = a.g(classLoader, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr2 = (IOException[]) g2.get(classLoader);
                    if (iOExceptionArr2 == null) {
                        iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                    } else {
                        IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                        arrayList.toArray(iOExceptionArr3);
                        System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                        iOExceptionArr = iOExceptionArr3;
                    }
                    g2.set(classLoader, iOExceptionArr);
                }
            }
        }

        public static Object[] c(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, obj, arrayList, file, arrayList2)) == null) ? (Object[]) a.h(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2) : (Object[]) invokeLLLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void b(ClassLoader classLoader, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, classLoader, list) == null) {
                int size = list.size();
                Field g2 = a.g(classLoader, "path");
                StringBuilder sb = new StringBuilder((String) g2.get(classLoader));
                String[] strArr = new String[size];
                File[] fileArr = new File[size];
                ZipFile[] zipFileArr = new ZipFile[size];
                DexFile[] dexFileArr = new DexFile[size];
                ListIterator<File> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    File next = listIterator.next();
                    String absolutePath = next.getAbsolutePath();
                    sb.append(':');
                    sb.append(absolutePath);
                    int previousIndex = listIterator.previousIndex();
                    strArr[previousIndex] = absolutePath;
                    fileArr[previousIndex] = next;
                    zipFileArr[previousIndex] = new ZipFile(next);
                    dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
                }
                g2.set(classLoader, sb.toString());
                a.f(classLoader, "mPaths", strArr);
                a.f(classLoader, "mFiles", fileArr);
                a.f(classLoader, "mZips", zipFileArr);
                a.f(classLoader, "mDexs", dexFileArr);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-621691164, "Ld/a/s0/y1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-621691164, "Ld/a/s0/y1/a;");
                return;
            }
        }
        f69597a = MultiDex.CODE_CACHE_NAME + File.separator + "secondary-dexes";
        f69598b = new HashSet();
        f69599c = l(System.getProperty("java.vm.version"));
    }

    public static boolean d(List<File> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, list)) == null) {
            for (File file : list) {
                if (!d.a.s0.y1.b.n(file)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void e(Context context) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            File file = new File(context.getFilesDir(), "secondary-dexes");
            if (file.isDirectory()) {
                Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                    return;
                }
                for (File file2 : listFiles) {
                    Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                    if (file2.delete()) {
                        Log.i("MultiDex", "Deleted old file " + file2.getPath());
                    } else {
                        Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                    }
                }
                if (!file.delete()) {
                    Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
                    return;
                }
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            }
        }
    }

    public static void f(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, str, objArr) == null) {
            Field g2 = g(obj, str);
            Object[] objArr2 = (Object[]) g2.get(obj);
            Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
            System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
            System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
            g2.set(obj, objArr3);
        }
    }

    public static Field g(Object obj, String str) throws NoSuchFieldException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Field declaredField = cls.getDeclaredField(str);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                }
            }
            throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
        }
        return (Field) invokeLL.objValue;
    }

    public static Method h(Object obj, String str, Class... clsArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, str, clsArr)) == null) {
            for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    return declaredMethod;
                } catch (NoSuchMethodException unused) {
                }
            }
            throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
        }
        return (Method) invokeLLL.objValue;
    }

    public static ApplicationInfo i(Context context) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                if (packageManager == null || packageName == null) {
                    return null;
                }
                return packageManager.getApplicationInfo(packageName, 128);
            } catch (RuntimeException e2) {
                Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
                return null;
            }
        }
        return (ApplicationInfo) invokeL.objValue;
    }

    public static void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            Log.i("MultiDex", "install");
            if (f69599c) {
                Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            } else if (Build.VERSION.SDK_INT >= 4) {
                try {
                    ApplicationInfo i2 = i(context);
                    if (i2 == null) {
                        return;
                    }
                    synchronized (f69598b) {
                        String str = i2.sourceDir;
                        if (f69598b.contains(str)) {
                            return;
                        }
                        f69598b.add(str);
                        if (Build.VERSION.SDK_INT > 20) {
                            Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
                        }
                        try {
                            ClassLoader classLoader = context.getClassLoader();
                            if (classLoader == null) {
                                Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                                return;
                            }
                            e(context);
                            File file = new File(i2.dataDir, f69597a);
                            List<File> h2 = d.a.s0.y1.b.h(context, i2, file, false);
                            if (d(h2)) {
                                k(classLoader, file, h2);
                            } else {
                                Log.w("MultiDex", "Files were not valid zip files.  Forcing a reload.");
                                List<File> h3 = d.a.s0.y1.b.h(context, i2, file, true);
                                if (d(h3)) {
                                    k(classLoader, file, h3);
                                } else {
                                    throw new RuntimeException("Zip files were not valid.");
                                }
                            }
                            Log.i("MultiDex", "install done");
                        } catch (RuntimeException e2) {
                            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
                        }
                    }
                } catch (Exception e3) {
                    Log.e("MultiDex", "Multidex installation failure", e3);
                    throw new RuntimeException("Multi dex installation failed (" + e3.getMessage() + ").");
                }
            } else {
                throw new RuntimeException("Multi dex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
            }
        }
    }

    public static void k(ClassLoader classLoader, File file, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, classLoader, file, list) == null) || list.isEmpty()) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            b.b(classLoader, list, file);
        } else if (i2 >= 14) {
            C1895a.b(classLoader, list, file);
        } else {
            c.b(classLoader, list);
        }
    }

    public static boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            boolean z = false;
            if (str != null) {
                Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
                if (matcher.matches()) {
                    try {
                        int parseInt = Integer.parseInt(matcher.group(1));
                        int parseInt2 = Integer.parseInt(matcher.group(2));
                        if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                            z = true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("VM with version ");
            sb.append(str);
            sb.append(z ? " has multidex support" : " does not have multidex support");
            Log.i("MultiDex", sb.toString());
            return z;
        }
        return invokeL.booleanValue;
    }
}
