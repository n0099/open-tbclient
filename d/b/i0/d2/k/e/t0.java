package d.b.i0.d2.k.e;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public abstract class t0 {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f54315a;

    /* renamed from: b  reason: collision with root package name */
    public View f54316b;

    public t0(BaseFragmentActivity baseFragmentActivity, View view) {
        this.f54315a = baseFragmentActivity;
        this.f54316b = view;
    }

    public void a() {
        b(null);
    }

    public void b(g gVar) {
        if (this.f54315a == null || this.f54316b == null) {
            return;
        }
        c(gVar);
    }

    public abstract void c(g gVar);

    public void d(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
