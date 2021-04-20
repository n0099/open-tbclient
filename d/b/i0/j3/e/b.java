package d.b.i0.j3.e;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f57698a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f57699b;

    public List<DressItemData> a() {
        return this.f57699b;
    }

    public String b() {
        return this.f57698a;
    }

    public void c(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain == null) {
            return;
        }
        this.f57698a = themeBgInMain.bg_category;
        this.f57699b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBgInMain.props) {
            this.f57699b.add(new DressItemData(themeBgProp));
        }
    }
}
