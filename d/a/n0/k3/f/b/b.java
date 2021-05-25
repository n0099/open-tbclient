package d.a.n0.k3.f.b;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f57061a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f57062b;

    public List<DressItemData> a() {
        return this.f57062b;
    }

    public String b() {
        return this.f57061a;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain == null) {
            return;
        }
        this.f57061a = themeBubbleInMain.bubble_category;
        this.f57062b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f57062b.add(new DressItemData(themeBgProp));
        }
    }
}
