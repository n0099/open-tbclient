package d.b.v;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static String f65755c = d.b.i0.r.d0.b.n("advert_hide_list");

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f65756a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f65757b;

    /* renamed from: d.b.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1807b {

        /* renamed from: a  reason: collision with root package name */
        public static b f65758a = new b();
    }

    public static b b() {
        return C1807b.f65758a;
    }

    public boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        if (this.f65757b == null) {
            this.f65757b = this.f65756a.getStringSet(f65755c, null);
        }
        Set<String> set = this.f65757b;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public void c(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        Set<String> stringSet = this.f65756a.getStringSet(f65755c, null);
        this.f65757b = stringSet;
        if (stringSet == null) {
            this.f65757b = new HashSet();
        }
        this.f65757b.add(str);
        this.f65756a.edit().putStringSet(f65755c, this.f65757b).commit();
    }

    public b() {
        this.f65756a = TbadkCoreApplication.getInst().getSharedPreferences("mcn_advert_hide_list", 0);
    }
}
