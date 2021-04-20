package d.b.i0.j3.d;

import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetPendantByCategory.ThemePendantInMain;
import tbclient.ThemeBgProp;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57669a;

    /* renamed from: b  reason: collision with root package name */
    public List<DressItemData> f57670b;

    public String a() {
        return this.f57669a;
    }

    public List<DressItemData> b() {
        return this.f57670b;
    }

    public void c(ThemePendantInMain themePendantInMain) {
        if (themePendantInMain == null) {
            return;
        }
        this.f57669a = themePendantInMain.pendant_category;
        this.f57670b = new ArrayList();
        for (ThemeBgProp themeBgProp : themePendantInMain.props) {
            this.f57670b.add(new DressItemData(themeBgProp));
        }
    }
}
