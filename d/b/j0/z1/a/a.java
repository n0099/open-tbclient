package d.b.j0.z1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f64645e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f64646f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.b.j0.z1.c.b> f64647g;

    /* renamed from: h  reason: collision with root package name */
    public c f64648h;

    /* renamed from: d.b.j0.z1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1756a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.z1.c.b f64649e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f64650f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f64651g;

        public View$OnClickListenerC1756a(d.b.j0.z1.c.b bVar, b bVar2, int i) {
            this.f64649e = bVar;
            this.f64650f = bVar2;
            this.f64651g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f64649e.d() && a.this.f64645e >= 10) {
                l.L(a.this.f64646f.getApplicationContext(), a.this.f64646f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.b.j0.z1.c.b bVar = this.f64649e;
            bVar.e(!bVar.d());
            a.this.i(this.f64650f.f64655c, this.f64649e);
            a.this.h(this.f64649e);
            if (a.this.f64648h != null) {
                a.this.f64648h.C0(a.this.f64645e);
            }
            if (this.f64649e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f64651g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f64653a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64654b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f64655c;

        public b(View view) {
            this.f64653a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f64654b = (TextView) view.findViewById(R.id.interest_text);
            this.f64655c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f64654b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void C0(int i);
    }

    public a(List<d.b.j0.z1.c.b> list, Context context) {
        this.f64647g = list;
        this.f64646f = context;
    }

    public List<d.b.j0.z1.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.b.j0.z1.c.b bVar : this.f64647g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f64648h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.j0.z1.c.b> list = this.f64647g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f64646f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.b.j0.z1.c.b bVar2 = this.f64647g.get(i);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f64653a, bVar2.a(), null);
        }
        bVar.f64654b.setText(bVar2.c());
        i(bVar.f64655c, bVar2);
        if (bVar2.d()) {
            this.f64645e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1756a(bVar2, bVar, i));
        return view;
    }

    public final void h(d.b.j0.z1.c.b bVar) {
        if (bVar.d()) {
            this.f64645e++;
        } else {
            this.f64645e--;
        }
    }

    public final void i(ImageView imageView, d.b.j0.z1.c.b bVar) {
        if (bVar.d()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
