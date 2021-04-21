package d.b.j0.d2.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f55166a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f55167b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f55168c;

    /* renamed from: d  reason: collision with root package name */
    public View f55169d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.d2.k.c.b f55170e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.d2.k.e.z0.g f55171f;

    public g(d.b.j0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        b(iVar.P());
        d.b.j0.d2.k.c.b bVar = new d.b.j0.d2.k.c.b(iVar, bdUniqueId, this.f55168c);
        this.f55170e = bVar;
        this.f55171f = new d.b.j0.d2.k.e.z0.g(this.f55168c, bVar);
        c();
    }

    public View a() {
        return this.f55166a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f55166a = linearLayout;
        this.f55167b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f55166a.findViewById(R.id.pb_recom_info_list);
        this.f55168c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f55168c.setFadingEdgeLength(0);
        this.f55168c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f55168c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f55168c.setNestedScrollingEnabled(false);
        this.f55169d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f55166a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f55167b, R.color.CAM_X0105);
        this.f55170e.c();
    }

    public void d(int i) {
        this.f55168c.y(this.f55169d);
        this.f55169d.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.f55168c.r(this.f55169d);
    }

    public void e(boolean z) {
        this.f55168c.setNestedScrollingEnabled(z);
    }

    public void f(d.b.j0.d2.h.e eVar) {
        this.f55171f.k(eVar);
    }
}
