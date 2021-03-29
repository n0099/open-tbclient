package d.b.i0.p0.m2;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Set;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f57916a = TbadkCoreApplication.getInst().getSharedPreferences("frs_guide_sp", 0);

    public final boolean a(String str, String str2) {
        return (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2)) ? false : true;
    }

    public void b(String str, String str2) {
        if (a(str, str2)) {
            String str3 = str + '_' + str2;
            Set<String> keySet = this.f57916a.getAll().keySet();
            SharedPreferences.Editor edit = this.f57916a.edit();
            for (String str4 : keySet) {
                if (str4.startsWith(str3)) {
                    edit.remove(str4);
                }
            }
            edit.apply();
        }
    }

    public long c(String str, String str2) {
        if (a(str, str2)) {
            return this.f57916a.getLong(str + '_' + str2 + "_visit_time", 0L);
        }
        return 0L;
    }

    public boolean d(String str, String str2) {
        if (a(str, str2)) {
            return this.f57916a.getBoolean(str + '_' + str2 + "_show", false);
        }
        return false;
    }

    public int e(String str, String str2) {
        if (a(str, str2)) {
            return this.f57916a.getInt(str + '_' + str2 + "_show_cnt", 0);
        }
        return 0;
    }

    public long f(String str, String str2) {
        if (a(str, str2)) {
            return this.f57916a.getLong(str + '_' + str2 + "_show_time", 0L);
        }
        return 0L;
    }

    public void g(String str, String str2, long j, boolean z) {
        if (a(str, str2)) {
            String str3 = str + '_' + str2 + "_show_time";
            String str4 = str + '_' + str2 + "_show_cnt";
            int i = this.f57916a.getInt(str4, 0);
            SharedPreferences.Editor edit = this.f57916a.edit();
            if (i > 3) {
                edit.putInt(str4, i + 1);
            }
            edit.putLong(str3, j);
            if (z) {
                edit.putBoolean(str + '_' + str2 + "_show", true);
            }
            edit.apply();
        }
    }

    public void h(String str, String str2, long j) {
        if (a(str, str2)) {
            String str3 = str + '_' + str2 + "_visit_time";
            SharedPreferences.Editor edit = this.f57916a.edit();
            edit.putLong(str3, j);
            edit.apply();
        }
    }
}
