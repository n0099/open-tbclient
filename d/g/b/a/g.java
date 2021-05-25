package d.g.b.a;

import com.google.ar.core.AugmentedFace;
import com.google.ar.core.Session;
import java.util.Map;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Long, AugmentedFace> f66194a = new com.google.ar.core.j(1, 0.75f, true);

    public final synchronized AugmentedFace a(long j, Session session) {
        AugmentedFace augmentedFace;
        augmentedFace = this.f66194a.get(Long.valueOf(j));
        if (augmentedFace == null) {
            augmentedFace = new AugmentedFace(j, session);
            this.f66194a.put(Long.valueOf(j), augmentedFace);
        }
        return augmentedFace;
    }
}
