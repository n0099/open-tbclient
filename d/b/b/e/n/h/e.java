package d.b.b.e.n.h;

import java.util.Comparator;
/* loaded from: classes.dex */
public class e implements Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(d dVar, d dVar2) {
        int i = (dVar.f41928c > dVar2.f41928c ? 1 : (dVar.f41928c == dVar2.f41928c ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i == 0 ? 0 : -1;
    }
}
