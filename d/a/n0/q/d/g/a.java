package d.a.n0.q.d.g;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.a.n0.q.d.g.b;
/* loaded from: classes4.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {

    /* renamed from: a  reason: collision with root package name */
    public final VIEW f58223a;

    /* renamed from: b  reason: collision with root package name */
    public MODEL f58224b;

    /* renamed from: d.a.n0.q.d.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1475a implements View.OnClickListener {
        public View$OnClickListenerC1475a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: d.a.n0.q.d.g.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f58223a.b(view)) {
                return;
            }
            a aVar = a.this;
            aVar.j(aVar.f58224b);
        }
    }

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        this.f58223a = view;
        k(model);
        this.f58224b = model;
        View actionBar = this.f58223a.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1475a());
        }
    }

    public MODEL c() {
        return this.f58224b;
    }

    public VIEW d() {
        return this.f58223a;
    }

    @CallSuper
    public void e(@NonNull MODEL model) {
        this.f58224b = model;
        if (this.f58223a == null) {
            return;
        }
        i();
        this.f58223a.d(model.getCurrentState(), model.getPercent());
    }

    public void f(int i2) {
        this.f58223a.a(Math.max(this.f58224b.getPercent(), i2));
    }

    @CallSuper
    public void g(int i2) {
        this.f58223a.a(Math.max(this.f58224b.getPercent(), i2));
        MODEL model = this.f58224b;
        if (model != null) {
            model.getCurrentState();
        }
        DownloadStatus downloadStatus = DownloadStatus.STATUS_NONE;
    }

    @CallSuper
    public void h(@NonNull DownloadStatus downloadStatus) {
        MODEL model = this.f58224b;
        if (model == null) {
            return;
        }
        this.f58223a.c(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            i();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            d.a.n0.q.e.a.i().l(downloadStatus, model);
        }
    }

    public void i() {
        if (this.f58223a.getRealView().getVisibility() == 0) {
            return;
        }
        this.f58223a.getRealView().setVisibility(0);
    }

    public abstract void j(MODEL model);

    public abstract void k(MODEL model);
}
