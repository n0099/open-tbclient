package d.b.j0.s.b.r;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.b.h0.a.p.c.p;
@Singleton
@Service
/* loaded from: classes4.dex */
public class c implements p {

    /* loaded from: classes4.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.b1.d.d.d f61852a;

        public a(c cVar, d.b.h0.a.b1.d.d.d dVar) {
            this.f61852a = dVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Bundle bundle = delegateResult.mResult;
            d.b.h0.a.b1.d.d.d dVar = this.f61852a;
            if (dVar != null) {
                dVar.a(true, null, bundle.getParcelableArrayList("mediaModels"));
            }
        }
    }

    @Override // d.b.h0.a.p.c.p
    public void a(Activity activity, Bundle bundle, d.b.h0.a.b1.d.d.d dVar) {
        if (ProcessUtils.isMainProcess()) {
            d.b.h0.a.i2.p.k(new b(activity, bundle, dVar), "main process compress files");
        } else {
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, d.b.j0.s.b.r.a.class, bundle, new a(this, dVar));
        }
    }
}
