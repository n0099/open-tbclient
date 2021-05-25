package d.a.m0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f50130a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f50131b;

    public ArrayList<String> a() {
        return this.f50130a;
    }

    public int b() {
        return this.f50131b;
    }

    public boolean c(ColorEgg colorEgg) {
        List<String> list;
        this.f50131b = 0;
        if (colorEgg == null || (list = colorEgg.holiday_words) == null || list.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.f50130a.add(str);
            }
        }
        if (this.f50130a.size() <= 0) {
            return false;
        }
        this.f50131b = colorEgg.style_flag.intValue();
        return true;
    }
}
