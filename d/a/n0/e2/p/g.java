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
    public LinearLayout f53922a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f53923b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53924c;

    /* renamed from: d  reason: collision with root package name */
    public View f53925d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.e2.k.c.b f53926e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.e2.k.e.a1.g f53927f;

    public g(d.a.n0.e2.o.i iVar, BdUniqueId bdUniqueId) {
        b(iVar.A());
        d.a.n0.e2.k.c.b bVar = new d.a.n0.e2.k.c.b(iVar, bdUniqueId, this.f53924c);
        this.f53926e = bVar;
        this.f53927f = new d.a.n0.e2.k.e.a1.g(this.f53924c, bVar);
        c();
    }

    public View a() {
        return this.f53922a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f53922a = linearLayout;
        this.f53923b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f53922a.findViewById(R.id.pb_recom_info_list);
        this.f53924c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f53924c.setFadingEdgeLength(0);
        this.f53924c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f53924c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f53924c.setNestedScrollingEnabled(false);
        this.f53925d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f53922a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f53923b, R.color.CAM_X0105);
        this.f53926e.c();
    }

    public void d(int i2) {
        this.f53924c.y(this.f53925d);
        this.f53925d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
        this.f53924c.r(this.f53925d);
    }

    public void e(boolean z) {
        this.f53924c.setNestedScrollingEnabled(z);
    }

    public void f(d.a.n0.e2.h.e eVar) {
        this.f53927f.k(eVar);
    }
}
