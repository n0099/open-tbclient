package d.b.i0.d2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f54540a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f54541b;

    /* renamed from: c  reason: collision with root package name */
    public int f54542c = 3;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.f54541b = baseFragmentActivity;
    }

    public final void a(d.b.i0.d2.h.e eVar, String str) {
        if (eVar == null) {
            return;
        }
        if (this.f54540a == null) {
            this.f54540a = new c(LayoutInflater.from(this.f54541b.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f54540a.m(eVar, str);
    }

    public View b() {
        c cVar = this.f54540a;
        if (cVar == null) {
            return null;
        }
        return cVar.f54521a;
    }

    public void c(int i) {
        if (this.f54542c != i) {
            c cVar = this.f54540a;
            if (cVar != null) {
                cVar.o();
            }
            this.f54542c = i;
        }
    }

    public void d(d.b.i0.d2.h.e eVar, String str) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        a(eVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar = this.f54540a;
        if (cVar != null) {
            bdTypeListView.removeHeaderView(cVar.f54521a);
        }
    }
}
