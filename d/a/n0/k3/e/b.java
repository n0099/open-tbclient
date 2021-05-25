package d.a.n0.k3.e;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56991a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56992b;

    public List<DressItemData> a() {
        return this.f56992b;
    }

    public String b() {
        return this.f56991a;
    }

    public void c(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain == null) {
            return;
        }
        this.f56991a = themeBgInMain.bg_category;
        this.f56992b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBgInMain.props) {
            this.f56992b.add(new DressItemData(themeBgProp));
        }
    }
}
