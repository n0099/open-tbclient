package d.a.j0.j3.d;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56073a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f56074b;

    public String a() {
        return this.f56073a;
    }

    public List<DressItemData> b() {
        return this.f56074b;
    }

    public void c(ThemePendantInMain themePendantInMain) {
        if (themePendantInMain == null) {
            return;
        }
        this.f56073a = themePendantInMain.pendant_category;
        this.f56074b = new ArrayList();
        for (ThemeBgProp themeBgProp : themePendantInMain.props) {
            this.f56074b.add(new DressItemData(themeBgProp));
        }
    }
}
