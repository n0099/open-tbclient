package d.a.j0.j3.g.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f56200a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.j0.j3.a> f56201b;

    public ArrayList<d.a.j0.j3.a> a() {
        return this.f56201b;
    }

    public String b() {
        return this.f56200a;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain == null) {
            return;
        }
        this.f56200a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f56201b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                d.a.j0.j3.a aVar = new d.a.j0.j3.a();
                aVar.k(themeCardPropMain);
                this.f56201b.add(aVar);
            }
        }
    }
}
