package d.a.o0.k3.f.b;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60875a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f60876b;

    public List<DressItemData> a() {
        return this.f60876b;
    }

    public String b() {
        return this.f60875a;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain == null) {
            return;
        }
        this.f60875a = themeBubbleInMain.bubble_category;
        this.f60876b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f60876b.add(new DressItemData(themeBgProp));
        }
    }
}
