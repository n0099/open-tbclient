package d.a.k0.j3.g.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56907a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.k0.j3.a> f56908b;

    public ArrayList<d.a.k0.j3.a> a() {
        return this.f56908b;
    }

    public String b() {
        return this.f56907a;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain == null) {
            return;
        }
        this.f56907a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f56908b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                d.a.k0.j3.a aVar = new d.a.k0.j3.a();
                aVar.k(themeCardPropMain);
                this.f56908b.add(aVar);
            }
        }
    }
}
