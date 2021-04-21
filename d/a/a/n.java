package d.a.a;

import androidx.collection.ArraySet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public boolean f41598a = false;

    /* renamed from: b  reason: collision with root package name */
    public final Set<a> f41599b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.a.a.x.f> f41600c = new HashMap();

    /* loaded from: classes.dex */
    public interface a {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.f41598a) {
            d.a.a.x.f fVar = this.f41600c.get(str);
            if (fVar == null) {
                fVar = new d.a.a.x.f();
                this.f41600c.put(str, fVar);
            }
            fVar.a(f2);
            if (str.equals("__container")) {
                for (a aVar : this.f41599b) {
                    aVar.a(f2);
                }
            }
        }
    }

    public void b(boolean z) {
        this.f41598a = z;
    }
}
