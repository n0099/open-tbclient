package d.b.j0.j3.g.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f58210a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.j0.j3.a> f58211b;

    public ArrayList<d.b.j0.j3.a> a() {
        return this.f58211b;
    }

    public String b() {
        return this.f58210a;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain == null) {
            return;
        }
        this.f58210a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f58211b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                d.b.j0.j3.a aVar = new d.b.j0.j3.a();
                aVar.k(themeCardPropMain);
                this.f58211b.add(aVar);
            }
        }
    }
}
