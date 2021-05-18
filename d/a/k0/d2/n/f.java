package d.a.k0.d2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f53487a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f53488b;

    /* renamed from: c  reason: collision with root package name */
    public int f53489c = 3;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.f53488b = baseFragmentActivity;
    }

    public final void a(d.a.k0.d2.h.e eVar, String str) {
        if (eVar == null) {
            return;
        }
        if (this.f53487a == null) {
            this.f53487a = new c(LayoutInflater.from(this.f53488b.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f53487a.m(eVar, str);
    }

    public View b() {
        c cVar = this.f53487a;
        if (cVar == null) {
            return null;
        }
        return cVar.f53466a;
    }

    public void c(int i2) {
        if (this.f53489c != i2) {
            c cVar = this.f53487a;
            if (cVar != null) {
                cVar.o();
            }
            this.f53489c = i2;
        }
    }

    public void d(d.a.k0.d2.h.e eVar, String str) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        a(eVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar = this.f53487a;
        if (cVar != null) {
            bdTypeListView.removeHeaderView(cVar.f53466a);
        }
    }
}
