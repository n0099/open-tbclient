package d.a.k0.j3.e;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56811a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56812b;

    public List<DressItemData> a() {
        return this.f56812b;
    }

    public String b() {
        return this.f56811a;
    }

    public void c(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain == null) {
            return;
        }
        this.f56811a = themeBgInMain.bg_category;
        this.f56812b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBgInMain.props) {
            this.f56812b.add(new DressItemData(themeBgProp));
        }
    }
}
