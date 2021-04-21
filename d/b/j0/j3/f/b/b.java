package d.b.j0.j3.f.b;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f58185a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f58186b;

    public List<DressItemData> a() {
        return this.f58186b;
    }

    public String b() {
        return this.f58185a;
    }

    public void c(ThemeBubbleInMain themeBubbleInMain) {
        if (themeBubbleInMain == null) {
            return;
        }
        this.f58185a = themeBubbleInMain.bubble_category;
        this.f58186b = new ArrayList();
        for (ThemeBgProp themeBgProp : themeBubbleInMain.props) {
            this.f58186b.add(new DressItemData(themeBgProp));
        }
    }
}
