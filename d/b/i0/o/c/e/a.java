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
    public final VIEW f57185a;

    /* renamed from: b  reason: collision with root package name */
    public MODEL f57186b;

    /* renamed from: d.b.i0.o.c.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1364a implements View.OnClickListener {
        public View$OnClickListenerC1364a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: d.b.i0.o.c.e.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57185a.b(view)) {
                return;
            }
            a aVar = a.this;
            aVar.h(aVar.f57186b);
        }
    }

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        this.f57185a = view;
        i(model);
        this.f57186b = model;
        View actionBar = this.f57185a.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1364a());
        }
    }

    public VIEW c() {
        return this.f57185a;
    }

    @CallSuper
    public void d(@NonNull MODEL model) {
        this.f57186b = model;
        if (this.f57185a == null) {
            return;
        }
        g();
        this.f57185a.d(model.getCurrentState(), model.getPercent());
    }

    @CallSuper
    public void e(int i) {
        this.f57185a.a(i);
        MODEL model = this.f57186b;
        if ((model != null ? model.getCurrentState() : null) != DownloadStatus.STATUS_NONE) {
            g();
        }
    }

    @CallSuper
    public void f(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.f57186b;
        if (model == null) {
            return;
        }
        this.f57185a.c(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            g();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            d.b.i0.o.d.a.i().l(downloadStatus, model);
        }
    }

    public final void g() {
        if (this.f57185a.getRealView().getVisibility() == 0) {
            return;
        }
        this.f57185a.getRealView().setVisibility(0);
    }

    public abstract void h(MODEL model);

    public abstract void i(MODEL model);
}
