package d.a.a;

import androidx.collection.ArraySet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41199a = false;

    /* renamed from: b  reason: collision with root package name */
    public final Set<a> f41200b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.a.a.v.d> f41201c = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.f41199a) {
            d.a.a.v.d dVar = this.f41201c.get(str);
            if (dVar == null) {
                dVar = new d.a.a.v.d();
                this.f41201c.put(str, dVar);
            }
            dVar.a(f2);
            if (str.equals("__container")) {
                for (a aVar : this.f41200b) {
                    aVar.a(f2);
                }
            }
        }
    }

    public void b(boolean z) {
        this.f41199a = z;
    }
}
