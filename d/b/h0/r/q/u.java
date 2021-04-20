package d.b.h0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f51298a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f51299b;

    public ArrayList<String> a() {
        return this.f51298a;
    }

    public int b() {
        return this.f51299b;
    }

    public boolean c(ColorEgg colorEgg) {
        List<String> list;
        this.f51299b = 0;
        if (colorEgg == null || (list = colorEgg.holiday_words) == null || list.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.f51298a.add(str);
            }
        }
        if (this.f51298a.size() <= 0) {
            return false;
        }
        this.f51299b = colorEgg.style_flag.intValue();
        return true;
    }
}
