package d.b.i0.o.c.e;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.b.i0.o.c.e.b;
/* loaded from: classes4.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {

    /* renamed from: a  reason: collision with root package name */
    public final VIEW f57184a;

    /* renamed from: b  reason: collision with root package name */
    public MODEL f57185b;

    /* renamed from: d.b.i0.o.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1363a implements View.OnClickListener {
        public View$OnClickListenerC1363a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: d.b.i0.o.c.e.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57184a.b(view)) {
                return;
            }
            a aVar = a.this;
            aVar.h(aVar.f57185b);
        }
    }

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        this.f57184a = view;
        i(model);
        this.f57185b = model;
        View actionBar = this.f57184a.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1363a());
        }
    }

    public VIEW c() {
        return this.f57184a;
    }

    @CallSuper
    public void d(@NonNull MODEL model) {
        this.f57185b = model;
        if (this.f57184a == null) {
            return;
        }
        g();
        this.f57184a.d(model.getCurrentState(), model.getPercent());
    }

    @CallSuper
    public void e(int i) {
        this.f57184a.a(i);
        MODEL model = this.f57185b;
        if ((model != null ? model.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            g();
        }
    }

    @CallSuper
    public void f(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.f57185b;
        if (model == null) {
            return;
        }
        this.f57184a.c(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            g();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            d.b.i0.o.d.a.i().l(downloadStatus, model);
        }
    }

    public final void g() {
        if (this.f57184a.getRealView().getVisibility() == 0) {
            return;
        }
        this.f57184a.getRealView().setVisibility(0);
    }

    public abstract void h(MODEL model);

    public abstract void i(MODEL model);
}
