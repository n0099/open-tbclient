package d.a.o0.k3.e;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBgByCategory.ThemeBgInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60805a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f60806b;

    public List<DressItemData> a() {
        return this.f60806b;
    }

    public String b() {
        return this.f60805a;
    }

    public void c(ThemeBgInMain themeBgInMain) {
        if (themeBgInMain == null) {
            return;
        }
        this.f60805a = themeBgInMain.bg_category;
        this.f60806b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBgInMain.props) {
            this.f60806b.add(new DressItemData(themeBgProp));
        }
    }
}
