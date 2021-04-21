package d.b.j0.d2.k.e;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes3.dex */
public abstract class t0 {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f54736a;

    /* renamed from: b  reason: collision with root package name */
    public View f54737b;

    public t0(BaseFragmentActivity baseFragmentActivity, View view) {
        this.f54736a = baseFragmentActivity;
        this.f54737b = view;
    }

    public void a() {
        b(null);
    }

    public void b(g gVar) {
        if (this.f54736a == null || this.f54737b == null) {
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
