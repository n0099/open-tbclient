package d.a.n0.u.b.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tieba.aiapps.apps.barcode.ScanCodeDelegateActivity;
import d.a.l0.a.c1.d.h;
import java.nio.charset.Charset;
@Singleton
@Service
/* loaded from: classes4.dex */
public class b implements h {

    /* loaded from: classes4.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.w.a f64967a;

        public a(b bVar, d.a.l0.a.w.a aVar) {
            this.f64967a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (delegateResult.isOk()) {
                this.f64967a.a(delegateResult.mResult.getString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, ""), "", Charset.defaultCharset().name());
            }
        }
    }

    @Override // d.a.l0.a.c1.d.h
    public void a(Context context, d.a.l0.a.w.a aVar) {
        if (context instanceof Activity) {
            DelegateUtils.callOnMainWithActivity((Activity) context, ScanCodeDelegateActivity.class, d.a.n0.u.b.c.a.class, new Bundle(), new a(this, aVar));
        }
    }
}
