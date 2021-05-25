package d.a.l0.a.v1.a.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import d.a.l0.a.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45273a = k.f43199a;

    public static void a(int i2, String str, String str2, @Nullable Bundle bundle) {
        a b2 = b(str);
        if (b2 == null) {
            if (!f45273a) {
                c(i2, str2, null);
                return;
            }
            throw new RuntimeException("Messenger创建代理类失败");
        }
        if (f45273a) {
            Log.d("MDelegate-Delegation", "exec call messenger delegation: " + str);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        b2.f45269a = bundle;
        b2.f45270b = i2;
        b2.f45271c = str2;
        b2.b(bundle);
    }

    public static a b(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            if (f45273a) {
                Log.e("MDelegate-Delegation", "create delegation with null delegate name");
            }
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls == null) {
                if (f45273a) {
                    throw new RuntimeException("Messenger代理类不存在：" + str);
                }
                return null;
            }
            int modifiers = cls.getModifiers();
            if (a.class.isAssignableFrom(cls) && !cls.isInterface() && !Modifier.isAbstract(modifiers)) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                Object newInstance = declaredConstructor.newInstance(new Object[0]);
                if (!(newInstance instanceof a)) {
                    if (f45273a) {
                        throw new RuntimeException("Messenger代理类不是:" + a.class.getName());
                    }
                    return null;
                }
                return (a) newInstance;
            }
            if (f45273a) {
                throw new RuntimeException("Messenger代理类不合法：" + str);
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            if (f45273a) {
                e2.printStackTrace();
                throw new RuntimeException(e2);
            }
            return null;
        }
    }

    public static void c(int i2, String str, @Nullable Bundle bundle) {
        if (d.a.l0.a.v1.a.b.d.a.a(str)) {
            return;
        }
        if (f45273a) {
            Log.d("MDelegate-Delegation", "send result to client: " + i2 + " observer: " + str);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_observer_id", str);
        if (bundle != null) {
            bundle2.putBundle("key_result_data", bundle);
        }
        if (i2 == -1000) {
            d.a.l0.a.v1.c.d.a.f(bundle2);
        } else {
            d.a.l0.a.v1.c.d.a.e(i2, bundle2);
        }
    }
}
