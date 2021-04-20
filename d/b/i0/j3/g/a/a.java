package d.b.i0.j3.g.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57789a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.b.i0.j3.a> f57790b;

    public ArrayList<d.b.i0.j3.a> a() {
        return this.f57790b;
    }

    public String b() {
        return this.f57789a;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain == null) {
            return;
        }
        this.f57789a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f57790b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                d.b.i0.j3.a aVar = new d.b.i0.j3.a();
                aVar.k(themeCardPropMain);
                this.f57790b.add(aVar);
            }
        }
    }
}
