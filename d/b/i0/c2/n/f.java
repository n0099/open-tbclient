package d.b.i0.c2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f53131a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f53132b;

    /* renamed from: c  reason: collision with root package name */
    public int f53133c = 3;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.f53132b = baseFragmentActivity;
    }

    public final void a(d.b.i0.c2.h.e eVar, String str) {
        if (eVar == null) {
            return;
        }
        if (this.f53131a == null) {
            this.f53131a = new c(LayoutInflater.from(this.f53132b.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f53131a.m(eVar, str);
    }

    public View b() {
        c cVar = this.f53131a;
        if (cVar == null) {
            return null;
        }
        return cVar.f53112a;
    }

    public void c(int i) {
        if (this.f53133c != i) {
            c cVar = this.f53131a;
            if (cVar != null) {
                cVar.o();
            }
            this.f53133c = i;
        }
    }

    public void d(d.b.i0.c2.h.e eVar, String str) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        a(eVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar = this.f53131a;
        if (cVar != null) {
            bdTypeListView.removeHeaderView(cVar.f53112a);
        }
    }
}
