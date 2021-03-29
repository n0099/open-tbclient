package d.b.i0.c2.k.e;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes4.dex */
public abstract class r0 {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f52820a;

    /* renamed from: b  reason: collision with root package name */
    public View f52821b;

    public r0(BaseFragmentActivity baseFragmentActivity, View view) {
        this.f52820a = baseFragmentActivity;
        this.f52821b = view;
    }

    public void a() {
        b(null);
    }

    public void b(e eVar) {
        if (this.f52820a == null || this.f52821b == null) {
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
