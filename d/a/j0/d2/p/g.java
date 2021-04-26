package d.a.j0.d2.p;

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
    public LinearLayout f53002a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f53003b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53004c;

    /* renamed from: d  reason: collision with root package name */
    public View f53005d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.d2.k.c.b f53006e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.d2.k.e.z0.g f53007f;

    public g(d.a.j0.d2.o.i iVar, BdUniqueId bdUniqueId) {
        b(iVar.A());
        d.a.j0.d2.k.c.b bVar = new d.a.j0.d2.k.c.b(iVar, bdUniqueId, this.f53004c);
        this.f53006e = bVar;
        this.f53007f = new d.a.j0.d2.k.e.z0.g(this.f53004c, bVar);
        c();
    }

    public View a() {
        return this.f53002a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f53002a = linearLayout;
        this.f53003b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f53002a.findViewById(R.id.pb_recom_info_list);
        this.f53004c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f53004c.setFadingEdgeLength(0);
        this.f53004c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f53004c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f53004c.setNestedScrollingEnabled(false);
        this.f53005d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f53002a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f53003b, R.color.CAM_X0105);
        this.f53006e.c();
    }

    public void d(int i2) {
        this.f53004c.y(this.f53005d);
        this.f53005d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
        this.f53004c.r(this.f53005d);
    }

    public void e(boolean z) {
        this.f53004c.setNestedScrollingEnabled(z);
    }

    public void f(d.a.j0.d2.h.e eVar) {
        this.f53007f.k(eVar);
    }
}
