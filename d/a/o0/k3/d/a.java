package d.a.o0.k3.d;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60774a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f60775b;

    public String a() {
        return this.f60774a;
    }

    public List<DressItemData> b() {
        return this.f60775b;
    }

    public void c(ThemePendantInMain themePendantInMain) {
        if (themePendantInMain == null) {
            return;
        }
        this.f60774a = themePendantInMain.pendant_category;
        this.f60775b = new ArrayList();
        for (ThemeBgProp themeBgProp : themePendantInMain.props) {
            this.f60775b.add(new DressItemData(themeBgProp));
        }
    }
}
