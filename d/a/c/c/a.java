package d.a.c.c;

import android.util.SparseArray;
import com.baidu.adp.base.BdBaseApplication;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f38649b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<String> f38650a;

    public a() {
        this.f38650a = null;
        this.f38650a = new SparseArray<>();
    }

    public static a a() {
        if (f38649b == null) {
            synchronized (a.class) {
                if (f38649b == null) {
                    f38649b = new a();
                }
            }
        }
        return f38649b;
    }

    public String b(int i2) {
        String str = this.f38650a.get(i2);
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
                int i2 = field.getInt(newInstance);
                String name = field.getName();
                if (this.f38650a.get(i2) == null) {
                    this.f38650a.put(i2, name);
                } else {
                    throw new Error("cmd " + str + " " + name + " 和 " + this.f38650a.get(i2) + " 重复");
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
