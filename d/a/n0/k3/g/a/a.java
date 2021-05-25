package d.a.n0.k3.g.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57087a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.n0.k3.a> f57088b;

    public ArrayList<d.a.n0.k3.a> a() {
        return this.f57088b;
    }

    public String b() {
        return this.f57087a;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain == null) {
            return;
        }
        this.f57087a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f57088b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                d.a.n0.k3.a aVar = new d.a.n0.k3.a();
                aVar.k(themeCardPropMain);
                this.f57088b.add(aVar);
            }
        }
    }
}
