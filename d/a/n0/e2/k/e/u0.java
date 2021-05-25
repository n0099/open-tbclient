package d.a.n0.e2.k.e;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes5.dex */
public abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f53516a;

    /* renamed from: b  reason: collision with root package name */
    public View f53517b;

    public u0(BaseFragmentActivity baseFragmentActivity, View view) {
        this.f53516a = baseFragmentActivity;
        this.f53517b = view;
    }

    public void a() {
        b(null);
    }

    public void b(g gVar) {
        if (this.f53516a == null || this.f53517b == null) {
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
