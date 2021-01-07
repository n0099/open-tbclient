package yaq;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import com.qq.e.comm.managers.GDTADManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.Reference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
public class gdtadv {
    static String ApkPath = null;
    static Context ctx = null;
    static final String libName = "yaqcore_gdtadv";
    static final String libbasicName = "yaqstub_gdtadv";
    static String LibPath = null;
    static String LibBasicPath = null;
    static String DataPath = null;
    static String Apkname_full = null;
    static String Apkname = null;
    static long vctx = 0;
    static int DexNum = 1;
    static int loadedcount = 0;
    static int arch_code = 0;
    static String CPUABI = null;

    static {
        ApkPath = null;
        ctx = null;
        ClassLoader classLoader = gdtadv.class.getClassLoader();
        getelffilearch("/proc/" + Process.myTid() + "/exe");
        try {
            if (Build.VERSION.CODENAME.equals("S") || Build.VERSION.SDK_INT > 30) {
                throw new UnsupportedOperationException("unsupport OS version");
            }
            ctx = getContextinmainthread();
            if (ctx == null) {
                ctx = GDTADManager.getInstance().getAppContext();
                if (ctx == null) {
                    throw new RuntimeException("cannot get context!");
                }
            }
            ApkPath = getAppPath(classLoader);
            if (ApkPath == null) {
                throw new RuntimeException("cannot get apppath!");
            }
            System.loadLibrary(libName);
            if (loadedcount != 1) {
                throw new RuntimeException("load gdt core lib error");
            }
            System.loadLibrary(libbasicName);
            if (loadedcount != 2) {
                throw new RuntimeException("load gdt stub lib error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("load gdt lib error");
        }
    }

    static String getAppPath(Context context) {
        return context.getPackageResourcePath();
    }

    static String getAppPath(ClassLoader classLoader) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, ClassNotFoundException {
        String[] strArr;
        if (Build.VERSION.SDK_INT < 9 || Build.VERSION.SDK_INT > 13) {
            Field declaredField = Class.forName("dalvik.system.BaseDexClassLoader").getDeclaredField("pathList");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            String[] strArr2 = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                try {
                    Field declaredField3 = objArr[i].getClass().getDeclaredField("zip");
                    declaredField3.setAccessible(true);
                    File file = (File) declaredField3.get(objArr[i]);
                    if (file != null) {
                        strArr2[i] = file.getAbsolutePath();
                    }
                } catch (NoSuchFieldException e) {
                    try {
                        Field declaredField4 = objArr[i].getClass().getDeclaredField("zipFile");
                        declaredField4.setAccessible(true);
                        strArr2[i] = new File(((ZipFile) declaredField4.get(objArr[i])).getName()).getAbsolutePath();
                    } catch (NoSuchFieldException e2) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            String obj2 = objArr[i].toString();
                            if (obj2.indexOf("zip file") == 0) {
                                int lastIndexOf = obj2.lastIndexOf("\"");
                                strArr2[i] = obj2.substring(obj2.lastIndexOf("\"", lastIndexOf - 1) + 1, lastIndexOf);
                            }
                        } else {
                            Field declaredField5 = objArr[i].getClass().getDeclaredField("path");
                            declaredField5.setAccessible(true);
                            File file2 = (File) declaredField5.get(objArr[i]);
                            if (file2 != null) {
                                strArr2[i] = file2.getAbsolutePath();
                            }
                        }
                    }
                }
            }
            strArr = strArr2;
        } else {
            Field declaredField6 = Class.forName("dalvik.system.DexClassLoader").getDeclaredField("mFiles");
            declaredField6.setAccessible(true);
            Object[] objArr2 = (Object[]) declaredField6.get(classLoader);
            String[] strArr3 = new String[objArr2.length];
            for (int i2 = 0; i2 < objArr2.length; i2++) {
                File file3 = (File) objArr2[i2];
                if (file3 != null) {
                    strArr3[i2] = file3.getAbsolutePath();
                }
            }
            strArr = strArr3;
        }
        for (String str : strArr) {
            if (str != null && isyaqpkg(str, "assets/yaqgdtadv.sig")) {
                return str;
            }
        }
        String appPath = getAppPath(ctx);
        if (appPath == null || !isyaqpkg(appPath, "assets/yaqgdtadv.sig")) {
            return null;
        }
        return appPath;
    }

    public static native byte getBresult(int i, int i2, Object... objArr);

    static Context getContext() {
        try {
            return getContextnormal(Class.forName("android.app.ActivityThread"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    static Context getContextRaw() {
        Method method;
        Object obj;
        try {
            try {
                try {
                    Class<?> cls = Class.forName("android.app.ActivityThread");
                    try {
                        Field declaredField = cls.getDeclaredField("sThreadLocal");
                        declaredField.setAccessible(true);
                        ThreadLocal threadLocal = (ThreadLocal) declaredField.get(cls);
                        Looper mainLooper = Looper.getMainLooper();
                        Field declaredField2 = Looper.class.getDeclaredField("mThread");
                        declaredField2.setAccessible(true);
                        Field declaredField3 = Thread.class.getDeclaredField("localValues");
                        declaredField3.setAccessible(true);
                        Object obj2 = declaredField3.get((Thread) declaredField2.get(mainLooper));
                        Class<?> cls2 = Class.forName("java.lang.ThreadLocal$Values");
                        Field declaredField4 = cls2.getDeclaredField("table");
                        Field declaredField5 = cls2.getDeclaredField("mask");
                        Field declaredField6 = ThreadLocal.class.getDeclaredField("hash");
                        Field declaredField7 = ThreadLocal.class.getDeclaredField("reference");
                        try {
                            declaredField4.setAccessible(true);
                            declaredField5.setAccessible(true);
                            declaredField6.setAccessible(true);
                            declaredField7.setAccessible(true);
                            Object[] objArr = (Object[]) declaredField4.get(obj2);
                            int i = declaredField6.getInt(threadLocal) & declaredField5.getInt(obj2);
                            if (((Reference) declaredField7.get(threadLocal)) == objArr[i]) {
                                obj = objArr[i + 1];
                            } else {
                                try {
                                    method = cls2.getMethod("getAfterMiss", new Class[0]);
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                    method = null;
                                }
                                try {
                                    obj = method.invoke(obj2, threadLocal);
                                } catch (InvocationTargetException e2) {
                                    e2.printStackTrace();
                                    obj = null;
                                }
                            }
                            try {
                                return getContextinner(cls, obj);
                            } catch (ClassNotFoundException e3) {
                                e = e3;
                                e.printStackTrace();
                                return null;
                            } catch (IllegalAccessException e4) {
                                e = e4;
                                e.printStackTrace();
                                return null;
                            } catch (IllegalArgumentException e5) {
                                e = e5;
                                e.printStackTrace();
                                return null;
                            } catch (NoSuchFieldException e6) {
                                e = e6;
                                e.printStackTrace();
                                return null;
                            }
                        } catch (ClassNotFoundException e7) {
                            e = e7;
                        } catch (IllegalAccessException e8) {
                            e = e8;
                        } catch (IllegalArgumentException e9) {
                            e = e9;
                        } catch (NoSuchFieldException e10) {
                            e = e10;
                        }
                    } catch (NoSuchFieldException e11) {
                        return getContextnormal(cls);
                    }
                } catch (NoSuchFieldException e12) {
                    e = e12;
                }
            } catch (ClassNotFoundException e13) {
                e = e13;
            } catch (IllegalAccessException e14) {
                e = e14;
            } catch (IllegalArgumentException e15) {
                e = e15;
            }
        } catch (ClassNotFoundException e16) {
            e = e16;
        } catch (IllegalAccessException e17) {
            e = e17;
        } catch (IllegalArgumentException e18) {
            e = e18;
        } catch (NoSuchFieldException e19) {
            e = e19;
        }
    }

    static Context getContextinmainthread() {
        return Process.myTid() == Process.myPid() ? getContext() : getContextRaw();
    }

    static Context getContextinner(Class cls, Object obj) {
        try {
            return (Context) cls.getMethod("getApplication", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    static Context getContextnormal(Class cls) {
        try {
            return getContextinner(cls, cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static native char getCresult(int i, int i2, Object... objArr);

    public static native double getDresult(int i, int i2, Object... objArr);

    public static native float getFresult(int i, int i2, Object... objArr);

    public static native int getIresult(int i, int i2, Object... objArr);

    public static native long getJresult(int i, int i2, Object... objArr);

    public static native short getSresult(int i, int i2, Object... objArr);

    public static native void getVresult(int i, int i2, Object... objArr);

    public static native int getXresult();

    public static native boolean getZresult(int i, int i2, Object... objArr);

    public static String getelffilearch(String str) {
        int readelfarch = readelfarch(str);
        if (readelfarch == 3) {
            arch_code = 3;
            return "armeabi";
        } else if (readelfarch == 40) {
            arch_code = 1;
            return "armeabi";
        } else if (readelfarch == 62) {
            arch_code = 4;
            return "arm64-v8a";
        } else if (readelfarch != 183) {
            arch_code = 999;
            return "unknown";
        } else {
            arch_code = 2;
            return "arm64-v8a";
        }
    }

    public static native Object getobjresult(int i, int i2, Object... objArr);

    public static native void init(int i);

    /* JADX WARN: Removed duplicated region for block: B:33:0x0034 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean isyaqpkg(String str, String str2) {
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            try {
                try {
                    if (zipFile.getEntry(str2) == null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    try {
                        zipFile.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return false;
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
            if (zipFile != null) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0045 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0016 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.RandomAccessFile */
    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: java.io.RandomAccessFile */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.RandomAccessFile] */
    public static int readelfarch(String str) {
        RandomAccessFile e;
        RandomAccessFile randomAccessFile;
        int i = 0;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
            }
            try {
                randomAccessFile.seek(18L);
                i = randomAccessFile.read();
                randomAccessFile.close();
                e = randomAccessFile;
            } catch (FileNotFoundException e3) {
                e = e3;
                e = randomAccessFile;
                e.printStackTrace();
                if (e != 0) {
                    e.close();
                    e = e;
                }
                return i;
            } catch (IOException e4) {
                e = e4;
                e = randomAccessFile;
                e.printStackTrace();
                if (e != 0) {
                    e.close();
                    e = e;
                }
                return i;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            e = 0;
        } catch (IOException e6) {
            e = e6;
            e = 0;
        } catch (Throwable th2) {
            th = th2;
            e = 0;
            if (e != 0) {
                try {
                    e.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
        return i;
    }

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }
}
