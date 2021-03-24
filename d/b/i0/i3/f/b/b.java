package d.b.i0.i3.f.b;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f56316a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56317b;

    public List<DressItemData> a() {
        return this.f56317b;
    }

    public String b() {
        return this.f56316a;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain == null) {
            return;
        }
        this.f56316a = themeBubbleInMain.bubble_category;
        this.f56317b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f56317b.add(new DressItemData(themeBgProp));
        }
    }
}
