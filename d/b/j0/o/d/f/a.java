package d.b.j0.o.d.f;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.b.j0.o.d.f.b;
/* loaded from: classes4.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {

    /* renamed from: a  reason: collision with root package name */
    public final VIEW f59070a;

    /* renamed from: b  reason: collision with root package name */
    public MODEL f59071b;

    /* renamed from: d.b.j0.o.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1436a implements View.OnClickListener {
        public View$OnClickListenerC1436a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: d.b.j0.o.d.f.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59070a.b(view)) {
                return;
            }
            a aVar = a.this;
            aVar.h(aVar.f59071b);
        }
    }

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        this.f59070a = view;
        i(model);
        this.f59071b = model;
        View actionBar = this.f59070a.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1436a());
        }
    }

    public VIEW c() {
        return this.f59070a;
    }

    @CallSuper
    public void d(@NonNull MODEL model) {
        this.f59071b = model;
        if (this.f59070a == null) {
            return;
        }
        g();
        this.f59070a.d(model.getCurrentState(), model.getPercent());
    }

    @CallSuper
    public void e(int i) {
        this.f59070a.a(i);
        MODEL model = this.f59071b;
        if (model != null) {
            model.getCurrentState();
        }
        DownloadStatus downloadStatus = DownloadStatus.STATUS_NONE;
    }

    @CallSuper
    public void f(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.f59071b;
        if (model == null) {
            return;
        }
        this.f59070a.c(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            g();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            d.b.j0.o.e.a.i().l(downloadStatus, model);
        }
    }

    public final void g() {
        if (this.f59070a.getRealView().getVisibility() == 0) {
            return;
        }
        this.f59070a.getRealView().setVisibility(0);
    }

    public abstract void h(MODEL model);

    public abstract void i(MODEL model);
}
