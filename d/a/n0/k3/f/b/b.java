package d.a.n0.k3.f.b;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60750a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f60751b;

    public List<DressItemData> a() {
        return this.f60751b;
    }

    public String b() {
        return this.f60750a;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain == null) {
            return;
        }
        this.f60750a = themeBubbleInMain.bubble_category;
        this.f60751b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f60751b.add(new DressItemData(themeBgProp));
        }
    }
}
