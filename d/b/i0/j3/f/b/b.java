package d.b.i0.j3.f.b;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f57764a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f57765b;

    public List<DressItemData> a() {
        return this.f57765b;
    }

    public String b() {
        return this.f57764a;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain == null) {
            return;
        }
        this.f57764a = themeBubbleInMain.bubble_category;
        this.f57765b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f57765b.add(new DressItemData(themeBgProp));
        }
    }
}
