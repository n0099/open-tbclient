package d.b.i0.c2.k.e;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes4.dex */
public abstract class r0 {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f52819a;

    /* renamed from: b  reason: collision with root package name */
    public View f52820b;

    public r0(BaseFragmentActivity baseFragmentActivity, View view) {
        this.f52819a = baseFragmentActivity;
        this.f52820b = view;
    }

    public void a() {
        b(null);
    }

    public void b(e eVar) {
        if (this.f52819a == null || this.f52820b == null) {
            return;
        }
        c(eVar);
    }

    public abstract void c(e eVar);

    public void d(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }
}
