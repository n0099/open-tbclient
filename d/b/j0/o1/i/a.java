package d.b.j0.o1.i;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f59248a;

    public static Map<String, String> a() {
        if (f59248a == null) {
            try {
                Field declaredField = Class.forName("dalvik.system.VMRuntime").getDeclaredField("ABI_TO_INSTRUCTION_SET_MAP");
                declaredField.setAccessible(true);
                f59248a = (Map) declaredField.get(null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return f59248a;
    }

    public static void b(String str) {
        try {
            ApplicationInfo.class.getField("primaryCpuAbi").set(((PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0])).applicationInfo, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
