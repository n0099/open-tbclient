package d.a.k0.d2.p;

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
    public LinearLayout f53709a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f53710b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53711c;

    /* renamed from: d  reason: collision with root package name */
    public View f53712d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.d2.k.c.b f53713e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.d2.k.e.z0.g f53714f;

    public g(d.a.k0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        b(iVar.A());
        d.a.k0.d2.k.c.b bVar = new d.a.k0.d2.k.c.b(iVar, bdUniqueId, this.f53711c);
        this.f53713e = bVar;
        this.f53714f = new d.a.k0.d2.k.e.z0.g(this.f53711c, bVar);
        c();
    }

    public View a() {
        return this.f53709a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f53709a = linearLayout;
        this.f53710b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f53709a.findViewById(R.id.pb_recom_info_list);
        this.f53711c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f53711c.setFadingEdgeLength(0);
        this.f53711c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f53711c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f53711c.setNestedScrollingEnabled(false);
        this.f53712d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f53709a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f53710b, R.color.CAM_X0105);
        this.f53713e.c();
    }

    public void d(int i2) {
        this.f53711c.y(this.f53712d);
        this.f53712d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
        this.f53711c.r(this.f53712d);
    }

    public void e(boolean z) {
        this.f53711c.setNestedScrollingEnabled(z);
    }

    public void f(d.a.k0.d2.h.e eVar) {
        this.f53714f.k(eVar);
    }
}
