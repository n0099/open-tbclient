package d.a.n0.e2.p;

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
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f57611a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f57612b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57613c;

    /* renamed from: d  reason: collision with root package name */
    public View f57614d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.e2.k.c.b f57615e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.e2.k.e.a1.g f57616f;

    public g(d.a.n0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        b(iVar.B());
        d.a.n0.e2.k.c.b bVar = new d.a.n0.e2.k.c.b(iVar, bdUniqueId, this.f57613c);
        this.f57615e = bVar;
        this.f57616f = new d.a.n0.e2.k.e.a1.g(this.f57613c, bVar);
        c();
    }

    public View a() {
        return this.f57611a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f57611a = linearLayout;
        this.f57612b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f57611a.findViewById(R.id.pb_recom_info_list);
        this.f57613c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f57613c.setFadingEdgeLength(0);
        this.f57613c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f57613c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f57613c.setNestedScrollingEnabled(false);
        this.f57614d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f57611a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f57612b, R.color.CAM_X0105);
        this.f57615e.c();
    }

    public void d(int i2) {
        this.f57613c.y(this.f57614d);
        this.f57614d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
        this.f57613c.r(this.f57614d);
    }

    public void e(boolean z) {
        this.f57613c.setNestedScrollingEnabled(z);
    }

    public void f(d.a.n0.e2.h.e eVar) {
        this.f57616f.k(eVar);
    }
}
