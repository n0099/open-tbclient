package d.a.j0.s.b.c;

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
import d.a.h0.a.w0.c.h;
import java.nio.charset.Charset;
@Singleton
@Service
/* loaded from: classes4.dex */
public class b implements h {

    /* loaded from: classes4.dex */
    public class a implements DelegateListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.v.a f59940a;

        public a(b bVar, d.a.h0.a.v.a aVar) {
            this.f59940a = aVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            if (delegateResult.isOk()) {
                this.f59940a.a(delegateResult.mResult.getString(QRCodeScanActivityConfig.RESULT_SCAN_CODE, ""), "", Charset.defaultCharset().name());
            }
        }
    }

    @Override // d.a.h0.a.w0.c.h
    public void a(Context context, d.a.h0.a.v.a aVar) {
        if (context instanceof Activity) {
            DelegateUtils.callOnMainWithActivity((Activity) context, ScanCodeDelegateActivity.class, d.a.j0.s.b.c.a.class, new Bundle(), new a(this, aVar));
        }
    }
}
