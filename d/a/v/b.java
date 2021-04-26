package d.a.v;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f64109c = d.a.i0.r.d0.b.n("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f64110a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f64111b;

    /* renamed from: d.a.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1747b {

        /* renamed from: a  reason: collision with root package name */
        public static b f64112a = new b();
    }

    public static b b() {
        return C1747b.f64112a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f64111b == null) {
            this.f64111b = this.f64110a.getStringSet(f64109c, null);
        }
        Set<String> set = this.f64111b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f64110a.getStringSet(f64109c, null);
        this.f64111b = stringSet;
        if (stringSet == null) {
            this.f64111b = new HashSet();
        }
        this.f64111b.add(str);
        this.f64110a.edit().putStringSet(f64109c, this.f64111b).commit();
    }

    public b() {
        this.f64110a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
