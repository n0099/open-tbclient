package d.b.b.c;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f41482b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<String> f41483a;

    public a() {
        this.f41483a = null;
        this.f41483a = new SparseArray<>();
    }

    public static a a() {
        if (f41482b == null) {
            synchronized (a.class) {
                if (f41482b == null) {
                    f41482b = new a();
                }
            }
        }
        return f41482b;
    }

    public String b(int i) {
        String str = this.f41483a.get(i);
        if (str != null) {
            return str;
        }
        return null;
    }

    public void c(List<String> list) {
        if (!BdBaseApplication.getInst().isDebugMode() || list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            d(str);
        }
    }

    public final void d(String str) {
        try {
            Class<?> loadClass = a.class.getClassLoader().loadClass(str);
            Object newInstance = loadClass.newInstance();
            Field[] fields = loadClass.getFields();
            if (fields == null || fields.length <= 0) {
                return;
            }
            for (Field field : fields) {
                int i = field.getInt(newInstance);
                String name = field.getName();
                if (this.f41483a.get(i) == null) {
                    this.f41483a.put(i, name);
                } else {
                    throw new Error("cmd " + str + " " + name + " 和 " + this.f41483a.get(i) + " 重复");
                }
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (InstantiationException e5) {
            e5.printStackTrace();
        }
    }
}
