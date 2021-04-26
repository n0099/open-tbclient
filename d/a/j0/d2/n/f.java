package d.a.j0.d2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public c f52784a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f52785b;

    /* renamed from: c  reason: collision with root package name */
    public int f52786c = 3;

    public f(BaseFragmentActivity baseFragmentActivity) {
        this.f52785b = baseFragmentActivity;
    }

    public final void a(d.a.j0.d2.h.e eVar, String str) {
        if (eVar == null) {
            return;
        }
        if (this.f52784a == null) {
            this.f52784a = new c(LayoutInflater.from(this.f52785b.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f52784a.m(eVar, str);
    }

    public View b() {
        c cVar = this.f52784a;
        if (cVar == null) {
            return null;
        }
        return cVar.f52763a;
    }

    public void c(int i2) {
        if (this.f52786c != i2) {
            c cVar = this.f52784a;
            if (cVar != null) {
                cVar.o();
            }
            this.f52786c = i2;
        }
    }

    public void d(d.a.j0.d2.h.e eVar, String str) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        a(eVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar = this.f52784a;
        if (cVar != null) {
            bdTypeListView.removeHeaderView(cVar.f52763a);
        }
    }
}
