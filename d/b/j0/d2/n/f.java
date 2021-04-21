package d.b.j0.d2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f54961a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f54962b;

    /* renamed from: c  reason: collision with root package name */
    public int f54963c = 3;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.f54962b = baseFragmentActivity;
    }

    public final void a(d.b.j0.d2.h.e eVar, String str) {
        if (eVar == null) {
            return;
        }
        if (this.f54961a == null) {
            this.f54961a = new c(LayoutInflater.from(this.f54962b.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f54961a.m(eVar, str);
    }

    public View b() {
        c cVar = this.f54961a;
        if (cVar == null) {
            return null;
        }
        return cVar.f54942a;
    }

    public void c(int i) {
        if (this.f54963c != i) {
            c cVar = this.f54961a;
            if (cVar != null) {
                cVar.o();
            }
            this.f54963c = i;
        }
    }

    public void d(d.b.j0.d2.h.e eVar, String str) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        a(eVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar = this.f54961a;
        if (cVar != null) {
            bdTypeListView.removeHeaderView(cVar.f54942a);
        }
    }
}
