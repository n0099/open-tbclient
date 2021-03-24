package d.b.h0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f50890a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f50891b;

    public ArrayList<String> a() {
        return this.f50890a;
    }

    public int b() {
        return this.f50891b;
    }

    public boolean c(ColorEgg colorEgg) {
        List<String> list;
        this.f50891b = 0;
        if (colorEgg == null || (list = colorEgg.holiday_words) == null || list.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.f50890a.add(str);
            }
        }
        if (this.f50890a.size() <= 0) {
            return false;
        }
        this.f50891b = colorEgg.style_flag.intValue();
        return true;
    }
}
