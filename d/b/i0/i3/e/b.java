package d.b.i0.i3.e;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56251a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56252b;

    public List<DressItemData> a() {
        return this.f56252b;
    }

    public String b() {
        return this.f56251a;
    }

    public void c(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain == null) {
            return;
        }
        this.f56251a = themeBgInMain.bg_category;
        this.f56252b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBgInMain.props) {
            this.f56252b.add(new DressItemData(themeBgProp));
        }
    }
}
