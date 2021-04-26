package d.a.j0.z1.a;

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
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f62928e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f62929f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.a.j0.z1.c.b> f62930g;

    /* renamed from: h  reason: collision with root package name */
    public c f62931h;

    /* renamed from: d.a.j0.z1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1693a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.z1.c.b f62932e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62933f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f62934g;

        public View$OnClickListenerC1693a(d.a.j0.z1.c.b bVar, b bVar2, int i2) {
            this.f62932e = bVar;
            this.f62933f = bVar2;
            this.f62934g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f62932e.d() && a.this.f62928e >= 10) {
                l.M(a.this.f62929f.getApplicationContext(), a.this.f62929f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.a.j0.z1.c.b bVar = this.f62932e;
            bVar.e(!bVar.d());
            a.this.i(this.f62933f.f62938c, this.f62932e);
            a.this.h(this.f62932e);
            if (a.this.f62931h != null) {
                a.this.f62931h.D0(a.this.f62928e);
            }
            if (this.f62932e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f62934g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f62936a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62937b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62938c;

        public b(View view) {
            this.f62936a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f62937b = (TextView) view.findViewById(R.id.interest_text);
            this.f62938c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f62937b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void D0(int i2);
    }

    public a(List<d.a.j0.z1.c.b> list, Context context) {
        this.f62930g = list;
        this.f62929f = context;
    }

    public List<d.a.j0.z1.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.a.j0.z1.c.b bVar : this.f62930g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f62931h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.j0.z1.c.b> list = this.f62930g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f62929f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.a.j0.z1.c.b bVar2 = this.f62930g.get(i2);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f62936a, bVar2.a(), null);
        }
        bVar.f62937b.setText(bVar2.c());
        i(bVar.f62938c, bVar2);
        if (bVar2.d()) {
            this.f62928e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1693a(bVar2, bVar, i2));
        return view;
    }

    public final void h(d.a.j0.z1.c.b bVar) {
        if (bVar.d()) {
            this.f62928e++;
        } else {
            this.f62928e--;
        }
    }

    public final void i(ImageView imageView, d.a.j0.z1.c.b bVar) {
        if (bVar.d()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
