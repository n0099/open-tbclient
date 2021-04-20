package d.b.i0.d2.p;

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
    public LinearLayout f54745a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f54746b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f54747c;

    /* renamed from: d  reason: collision with root package name */
    public View f54748d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.d2.k.c.b f54749e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.d2.k.e.z0.g f54750f;

    public g(d.b.i0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        b(iVar.P());
        d.b.i0.d2.k.c.b bVar = new d.b.i0.d2.k.c.b(iVar, bdUniqueId, this.f54747c);
        this.f54749e = bVar;
        this.f54750f = new d.b.i0.d2.k.e.z0.g(this.f54747c, bVar);
        c();
    }

    public View a() {
        return this.f54745a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f54745a = linearLayout;
        this.f54746b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f54745a.findViewById(R.id.pb_recom_info_list);
        this.f54747c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f54747c.setFadingEdgeLength(0);
        this.f54747c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f54747c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f54747c.setNestedScrollingEnabled(false);
        this.f54748d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f54745a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f54746b, R.color.CAM_X0105);
        this.f54749e.c();
    }

    public void d(int i) {
        this.f54747c.y(this.f54748d);
        this.f54748d.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.f54747c.r(this.f54748d);
    }

    public void e(boolean z) {
        this.f54747c.setNestedScrollingEnabled(z);
    }

    public void f(d.b.i0.d2.h.e eVar) {
        this.f54750f.k(eVar);
    }
}
