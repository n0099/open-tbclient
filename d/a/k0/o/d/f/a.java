package d.a.k0.o.d.f;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.a.k0.o.d.f.b;
/* loaded from: classes4.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {

    /* renamed from: a  reason: collision with root package name */
    public final VIEW f57800a;

    /* renamed from: b  reason: collision with root package name */
    public MODEL f57801b;

    /* renamed from: d.a.k0.o.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1447a implements View.OnClickListener {
        public View$OnClickListenerC1447a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: d.a.k0.o.d.f.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57800a.b(view)) {
                return;
            }
            a aVar = a.this;
            aVar.h(aVar.f57801b);
        }
    }

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        this.f57800a = view;
        i(model);
        this.f57801b = model;
        View actionBar = this.f57800a.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1447a());
        }
    }

    public VIEW c() {
        return this.f57800a;
    }

    @CallSuper
    public void d(@NonNull MODEL model) {
        this.f57801b = model;
        if (this.f57800a == null) {
            return;
        }
        g();
        this.f57800a.d(model.getCurrentState(), model.getPercent());
    }

    @CallSuper
    public void e(int i2) {
        this.f57800a.a(i2);
        MODEL model = this.f57801b;
        if (model != null) {
            model.getCurrentState();
        }
        DownloadStatus downloadStatus = DownloadStatus.STATUS_NONE;
    }

    @CallSuper
    public void f(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.f57801b;
        if (model == null) {
            return;
        }
        this.f57800a.c(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            g();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            d.a.k0.o.e.a.i().l(downloadStatus, model);
        }
    }

    public final void g() {
        if (this.f57800a.getRealView().getVisibility() == 0) {
            return;
        }
        this.f57800a.getRealView().setVisibility(0);
    }

    public abstract void h(MODEL model);

    public abstract void i(MODEL model);
}
