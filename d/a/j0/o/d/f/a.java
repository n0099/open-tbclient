package d.a.j0.o.d.f;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.a.j0.o.d.f.b;
/* loaded from: classes4.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {

    /* renamed from: a  reason: collision with root package name */
    public final VIEW f57093a;

    /* renamed from: b  reason: collision with root package name */
    public MODEL f57094b;

    /* renamed from: d.a.j0.o.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1375a implements View.OnClickListener {
        public View$OnClickListenerC1375a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: d.a.j0.o.d.f.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57093a.b(view)) {
                return;
            }
            a aVar = a.this;
            aVar.h(aVar.f57094b);
        }
    }

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        this.f57093a = view;
        i(model);
        this.f57094b = model;
        View actionBar = this.f57093a.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1375a());
        }
    }

    public VIEW c() {
        return this.f57093a;
    }

    @CallSuper
    public void d(@NonNull MODEL model) {
        this.f57094b = model;
        if (this.f57093a == null) {
            return;
        }
        g();
        this.f57093a.d(model.getCurrentState(), model.getPercent());
    }

    @CallSuper
    public void e(int i2) {
        this.f57093a.a(i2);
        MODEL model = this.f57094b;
        if (model != null) {
            model.getCurrentState();
        }
        DownloadStatus downloadStatus = DownloadStatus.STATUS_NONE;
    }

    @CallSuper
    public void f(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.f57094b;
        if (model == null) {
            return;
        }
        this.f57093a.c(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            g();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            d.a.j0.o.e.a.i().l(downloadStatus, model);
        }
    }

    public final void g() {
        if (this.f57093a.getRealView().getVisibility() == 0) {
            return;
        }
        this.f57093a.getRealView().setVisibility(0);
    }

    public abstract void h(MODEL model);

    public abstract void i(MODEL model);
}
