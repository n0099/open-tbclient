package d.a.c.e.n.h;

import java.util.Comparator;
/* loaded from: classes.dex */
public class e implements Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(d dVar, d dVar2) {
        int i2 = (dVar.f42433c > dVar2.f42433c ? 1 : (dVar.f42433c == dVar2.f42433c ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        return i2 == 0 ? 0 : -1;
    }
}
