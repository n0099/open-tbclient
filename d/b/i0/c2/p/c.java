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
    public LinearLayout f53303a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f53304b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53305c;

    /* renamed from: d  reason: collision with root package name */
    public View f53306d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.c2.k.c.b f53307e;

    /* renamed from: f  reason: collision with root package name */
    public g f53308f;

    public c(TbPageContext<?> tbPageContext) {
        b(tbPageContext.getPageActivity());
        d.b.i0.c2.k.c.b bVar = new d.b.i0.c2.k.c.b(tbPageContext, this.f53305c);
        this.f53307e = bVar;
        this.f53308f = new g(this.f53305c, bVar);
        c();
    }

    public View a() {
        return this.f53303a;
    }

    public final void b(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
        this.f53303a = linearLayout;
        this.f53304b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f53303a.findViewById(R.id.pb_recom_info_list);
        this.f53305c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.f53305c.setFadingEdgeLength(0);
        this.f53305c.setOverScrollMode(2);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.f53305c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.f53305c.setNestedScrollingEnabled(false);
        this.f53306d = new View(context);
    }

    public void c() {
        SkinManager.setBackgroundColor(this.f53303a, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f53304b, R.color.CAM_X0105);
        this.f53307e.c();
    }

    public void d(int i) {
        this.f53305c.y(this.f53306d);
        this.f53306d.setLayoutParams(new ViewGroup.LayoutParams(1, i));
        this.f53305c.r(this.f53306d);
    }

    public void e(boolean z) {
        this.f53305c.setNestedScrollingEnabled(z);
    }

    public void f(d.b.i0.c2.h.e eVar) {
        this.f53308f.k(eVar);
    }
}
