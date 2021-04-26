package d.a.h0.b.n;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import d.a.h0.a.i2.v;
@Singleton
@Service
/* loaded from: classes3.dex */
public class b implements d.a.h0.a.w0.c.b {

    /* loaded from: classes3.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.n.c.b f45652a;

        public a(b bVar, d.a.h0.a.n.c.b bVar2) {
            this.f45652a = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Bundle bundle = delegateResult.mResult;
            if (bundle == null) {
                this.f45652a.a(0);
                return;
            }
            String string = bundle.getString("invoiceInfo");
            if (TextUtils.isEmpty(string)) {
                this.f45652a.a(0);
            } else {
                this.f45652a.b(v.b(string));
            }
        }
    }

    @Override // d.a.h0.a.w0.c.b
    public void a(Context context, String str, String str2, d.a.h0.a.n.c.b bVar) {
        if (context == null || bVar == null) {
            return;
        }
        DelegateUtils.callOnMainWithActivity((Activity) context, MainProcessDelegateActivity.class, d.a.h0.b.n.a.class, new a(this, bVar));
    }
}
