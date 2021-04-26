package d.a.j0.j3.e;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56104a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56105b;

    public List<DressItemData> a() {
        return this.f56105b;
    }

    public String b() {
        return this.f56104a;
    }

    public void c(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain == null) {
            return;
        }
        this.f56104a = themeBgInMain.bg_category;
        this.f56105b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBgInMain.props) {
            this.f56105b.add(new DressItemData(themeBgProp));
        }
    }
}
