package d.a.m0.z0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class o0 {
    public static final void a(Wire wire, Class<? extends Message> cls) {
        File[] listFiles;
        String name;
        if (wire == null || cls == null) {
            return;
        }
        String str = "wire_" + cls.getName();
        File file = new File(TbadkCoreApplication.getInst().getCacheDir(), str + "_" + TbConfig.getVersion());
        byte[] bArr = null;
        try {
            if (file.exists() && (bArr = b(file)) != null) {
                wire.parseFrom(bArr, cls);
            }
            if (bArr == null) {
                byte[] bArr2 = (byte[]) d.a.c.e.b.a.a.c(cls, "toByteArray", new Object[0]).invoke(c(cls, new HashSet()), new Object[0]);
                wire.parseFrom(bArr2, cls);
                d(file, bArr2);
            }
        } catch (Throwable th) {
            BdLog.detailException(th);
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir == null || (listFiles = cacheDir.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null && (name = file2.getName()) != null && name.startsWith(str) && !file.getName().equals(name)) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static byte[] b(File file) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        byte[] bArr = null;
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(1024);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr2, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    try {
                        BdLog.e(th.getMessage());
                        return bArr;
                    } finally {
                        d.a.c.e.p.m.e(fileInputStream);
                        d.a.c.e.p.m.f(byteArrayOutputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        return bArr;
    }

    public static final Object c(Class<?> cls, HashSet<Class<?>> hashSet) {
        Field[] declaredFields;
        Type[] actualTypeArguments;
        if (hashSet != null && !hashSet.contains(cls)) {
            hashSet.add(cls);
            try {
                Class<?> cls2 = Class.forName(cls.getName() + "$Builder");
                Method declaredMethod = cls2.getDeclaredMethod("build", Boolean.TYPE);
                Object newInstance = cls2.newInstance();
                for (Field field : cls2.getDeclaredFields()) {
                    Class<?> type = field.getType();
                    if (type != null) {
                        if (d.a.c.e.b.a.a.g(type, Message.class)) {
                            Object c2 = c(type, hashSet);
                            if (c2 != null) {
                                if (d.a.c.e.b.a.a.g(c2.getClass(), Message.class)) {
                                    field.setAccessible(true);
                                    field.set(newInstance, c2);
                                } else {
                                    BdLog.e("");
                                }
                            }
                        } else if (d.a.c.e.b.a.a.g(type, List.class)) {
                            Type genericType = field.getGenericType();
                            if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                                try {
                                    Class cls3 = (Class) actualTypeArguments[0];
                                    if (d.a.c.e.b.a.a.g(cls3, Message.class)) {
                                        ArrayList arrayList = new ArrayList();
                                        Object c3 = c(cls3, hashSet);
                                        if (c3 != null) {
                                            if (d.a.c.e.b.a.a.g(c3.getClass(), Message.class)) {
                                                arrayList.add(c3);
                                            } else {
                                                BdLog.e("");
                                            }
                                            field.setAccessible(true);
                                            field.set(newInstance, arrayList);
                                        }
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                }
                return declaredMethod.invoke(newInstance, Boolean.TRUE);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
        return null;
    }

    public static final boolean d(File file, byte[] bArr) {
        if (file == null || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists() || file.delete()) {
                if (file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        d.a.c.e.p.m.f(fileOutputStream2);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            BdLog.e(th.getMessage());
                            return false;
                        } finally {
                            d.a.c.e.p.m.f(fileOutputStream);
                        }
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
