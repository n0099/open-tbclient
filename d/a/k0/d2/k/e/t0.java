package d.a.k0.d2.k.e;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes5.dex */
public abstract class t0 {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f53251a;

    /* renamed from: b  reason: collision with root package name */
    public View f53252b;

    public t0(BaseFragmentActivity baseFragmentActivity, View view) {
        this.f53251a = baseFragmentActivity;
        this.f53252b = view;
    }

    public void a() {
        b(null);
    }

    public void b(g gVar) {
        if (this.f53251a == null || this.f53252b == null) {
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
