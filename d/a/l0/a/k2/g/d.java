package d.a.l0.a.k2.g;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public abstract class d extends ProviderDelegation {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46950a = k.f46875a;

    public abstract Bundle a(c cVar);

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public final Bundle execCall(Bundle bundle) {
        if (bundle.isEmpty()) {
            return Bundle.EMPTY;
        }
        return a(c.b(bundle));
    }
}
