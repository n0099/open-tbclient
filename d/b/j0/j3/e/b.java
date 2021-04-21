package d.b.j0.j3.e;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f58119a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f58120b;

    public List<DressItemData> a() {
        return this.f58120b;
    }

    public String b() {
        return this.f58119a;
    }

    public void c(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain == null) {
            return;
        }
        this.f58119a = themeBgInMain.bg_category;
        this.f58120b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBgInMain.props) {
            this.f58120b.add(new DressItemData(themeBgProp));
        }
    }
}
