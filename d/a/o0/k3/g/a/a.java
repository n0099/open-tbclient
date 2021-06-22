package d.a.o0.k3.g.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetCardByCategory.ThemeCardInMain;
import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60901a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d.a.o0.k3.a> f60902b;

    public ArrayList<d.a.o0.k3.a> a() {
        return this.f60902b;
    }

    public String b() {
        return this.f60901a;
    }

    public void c(ThemeCardInMain themeCardInMain) {
        if (themeCardInMain == null) {
            return;
        }
        this.f60901a = themeCardInMain.card_category;
        List<ThemeCardPropMain> list = themeCardInMain.props;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f60902b = new ArrayList<>();
        for (ThemeCardPropMain themeCardPropMain : list) {
            if (themeCardPropMain != null) {
                d.a.o0.k3.a aVar = new d.a.o0.k3.a();
                aVar.k(themeCardPropMain);
                this.f60902b.add(aVar);
            }
        }
    }
}
