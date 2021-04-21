package d.a.a.s.b;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<s> f41611a = new ArrayList();

    public void a(s sVar) {
        this.f41611a.add(sVar);
    }

    public void b(Path path) {
        for (int size = this.f41611a.size() - 1; size >= 0; size--) {
            d.a.a.x.h.b(path, this.f41611a.get(size));
        }
    }
}
