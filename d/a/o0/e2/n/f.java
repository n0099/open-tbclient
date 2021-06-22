package d.a.o0.e2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f57511a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f57512b;

    /* renamed from: c  reason: collision with root package name */
    public int f57513c = 3;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.f57512b = baseFragmentActivity;
    }

    public final void a(d.a.o0.e2.h.e eVar, String str) {
        if (eVar == null) {
            return;
        }
        if (this.f57511a == null) {
            this.f57511a = new c(LayoutInflater.from(this.f57512b.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f57511a.m(eVar, str);
    }

    public View b() {
        c cVar = this.f57511a;
        if (cVar == null) {
            return null;
        }
        return cVar.f57490a;
    }

    public void c(int i2) {
        if (this.f57513c != i2) {
            c cVar = this.f57511a;
            if (cVar != null) {
                cVar.o();
            }
            this.f57513c = i2;
        }
    }

    public void d(d.a.o0.e2.h.e eVar, String str) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        a(eVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar = this.f57511a;
        if (cVar != null) {
            bdTypeListView.removeHeaderView(cVar.f57490a);
        }
    }
}
