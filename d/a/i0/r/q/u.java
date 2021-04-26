package d.a.i0.r.q;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f49267a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f49268b;

    public ArrayList<String> a() {
        return this.f49267a;
    }

    public int b() {
        return this.f49268b;
    }

    public boolean c(ColorEgg colorEgg) {
        List<String> list;
        this.f49268b = 0;
        if (colorEgg == null || (list = colorEgg.holiday_words) == null || list.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.f49267a.add(str);
            }
        }
        if (this.f49267a.size() <= 0) {
            return false;
        }
        this.f49268b = colorEgg.style_flag.intValue();
        return true;
    }
}
