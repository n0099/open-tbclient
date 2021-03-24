package d.b.i0.c2.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.i0.c2.k.e.x0.g;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f53302a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f53303b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53304c;

    /* renamed from: d  reason: collision with root package name */
    public View f53305d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.c2.k.c.b f53306e;

    /* renamed from: f  reason: collision with root package name */
    public g f53307f;

    public c(TbPageContext<?> tbPageContext) {
        b(tbPageContext.getPageActivity());
        d.b.i0.c2.k.c.b bVar = new d.b.i0.c2.k.c.b(tbPageContext, this.f53304c);
        this.f53306e = bVar;
        this.f53307f = new g(this.f53304c, bVar);
        c();
    }

    public View a() {
        return this.f53302a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f53302a = linearLayout;
        this.f53303b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f53302a.findViewById(R.id.pb_recom_info_list);
        this.f53304c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f53304c.setFadingEdgeLength(0);
        this.f53304c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f53304c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f53304c.setNestedScrollingEnabled(false);
        this.f53305d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f53302a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f53303b, R.color.CAM_X0105);
        this.f53306e.c();
    }

    public void d(int i) {
        this.f53304c.y(this.f53305d);
        this.f53305d.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.f53304c.r(this.f53305d);
    }

    public void e(boolean z) {
        this.f53304c.setNestedScrollingEnabled(z);
    }

    public void f(d.b.i0.c2.h.e eVar) {
        this.f53307f.k(eVar);
    }
}
