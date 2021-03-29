package d.g.b.a;

import com.google.ar.core.ArCoreApk;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public class d implements ArCoreApk.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f66048a;

    public d(AtomicReference atomicReference) {
        this.f66048a = atomicReference;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        this.f66048a.set(availability);
    }
}
