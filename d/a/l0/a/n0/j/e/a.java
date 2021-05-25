package d.a.l0.a.n0.j.e;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.l0.a.k;
import d.a.l0.a.v1.b.d;
import d.a.l0.a.v1.b.f;
/* loaded from: classes2.dex */
public class a extends ProviderDelegation {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43623a = k.f43199a;

    public static int a(int i2) {
        if (ProcessUtils.isMainProcess()) {
            return b.b().c(i2);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("level", i2);
        f b2 = d.b(a.class, bundle);
        int i3 = b2.a() ? b2.f45297a.getInt("count", 0) : 0;
        if (f43623a) {
            Log.d("RecoveryCountDelegation", "GetRecoveryCount level=" + i2 + ";count=" + i3);
        }
        return i3;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        int i2 = bundle.getInt("level", -1);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("count", b.b().c(i2));
        return bundle2;
    }
}
