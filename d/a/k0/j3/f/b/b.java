package d.a.k0.j3.f.b;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56881a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56882b;

    public List<DressItemData> a() {
        return this.f56882b;
    }

    public String b() {
        return this.f56881a;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain == null) {
            return;
        }
        this.f56881a = themeBubbleInMain.bubble_category;
        this.f56882b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f56882b.add(new DressItemData(themeBgProp));
        }
    }
}
