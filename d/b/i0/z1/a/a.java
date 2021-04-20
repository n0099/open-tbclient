package d.b.i0.z1.a;

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
    public int f64224e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f64225f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.b.i0.z1.c.b> f64226g;

    /* renamed from: h  reason: collision with root package name */
    public c f64227h;

    /* renamed from: d.b.i0.z1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1733a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.z1.c.b f64228e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f64229f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f64230g;

        public View$OnClickListenerC1733a(d.b.i0.z1.c.b bVar, b bVar2, int i) {
            this.f64228e = bVar;
            this.f64229f = bVar2;
            this.f64230g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f64228e.d() && a.this.f64224e >= 10) {
                l.L(a.this.f64225f.getApplicationContext(), a.this.f64225f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.b.i0.z1.c.b bVar = this.f64228e;
            bVar.e(!bVar.d());
            a.this.i(this.f64229f.f64234c, this.f64228e);
            a.this.h(this.f64228e);
            if (a.this.f64227h != null) {
                a.this.f64227h.C0(a.this.f64224e);
            }
            if (this.f64228e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f64230g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f64232a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f64233b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f64234c;

        public b(View view) {
            this.f64232a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f64233b = (TextView) view.findViewById(R.id.interest_text);
            this.f64234c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f64233b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void C0(int i);
    }

    public a(List<d.b.i0.z1.c.b> list, Context context) {
        this.f64226g = list;
        this.f64225f = context;
    }

    public List<d.b.i0.z1.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.b.i0.z1.c.b bVar : this.f64226g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f64227h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.z1.c.b> list = this.f64226g;
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
            view = LayoutInflater.from(this.f64225f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.b.i0.z1.c.b bVar2 = this.f64226g.get(i);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f64232a, bVar2.a(), null);
        }
        bVar.f64233b.setText(bVar2.c());
        i(bVar.f64234c, bVar2);
        if (bVar2.d()) {
            this.f64224e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1733a(bVar2, bVar, i));
        return view;
    }

    public final void h(d.b.i0.z1.c.b bVar) {
        if (bVar.d()) {
            this.f64224e++;
        } else {
            this.f64224e--;
        }
    }

    public final void i(ImageView imageView, d.b.i0.z1.c.b bVar) {
        if (bVar.d()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
