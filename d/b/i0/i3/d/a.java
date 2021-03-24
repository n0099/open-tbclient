package d.b.i0.i3.d;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56221a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56222b;

    public String a() {
        return this.f56221a;
    }

    public List<DressItemData> b() {
        return this.f56222b;
    }

    public void c(ThemePendantInMain themePendantInMain) {
        if (themePendantInMain == null) {
            return;
        }
        this.f56221a = themePendantInMain.pendant_category;
        this.f56222b = new ArrayList();
        for (ThemeBgProp themeBgProp : themePendantInMain.props) {
            this.f56222b.add(new DressItemData(themeBgProp));
        }
    }
}
