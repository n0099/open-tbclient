package d.a.l0.a.n0.j;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends ProviderDelegation {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47292a;

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_recovery_enable", true);
        f47292a = true;
    }

    public static void a(d.a.l0.a.n0.j.f.a aVar) {
        if (f47292a && aVar != null) {
            if (ProcessUtils.isMainProcess()) {
                b.a(aVar).b();
                d.a.l0.a.n0.j.e.b.b().a(aVar.f47302a);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("recovery_level", aVar.f47302a);
            bundle.putStringArrayList("recovery_app_list", aVar.f47303b);
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, bundle);
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        if (f47292a) {
            int i2 = bundle.getInt("recovery_level", -1);
            ArrayList<String> stringArrayList = bundle.getStringArrayList("recovery_app_list");
            d.a.l0.a.n0.j.f.a aVar = new d.a.l0.a.n0.j.f.a();
            aVar.f47302a = i2;
            if (stringArrayList != null) {
                aVar.f47303b = stringArrayList;
            }
            b.a(aVar).b();
            d.a.l0.a.n0.j.e.b.b().a(aVar.f47302a);
            return null;
        }
        return null;
    }
}
