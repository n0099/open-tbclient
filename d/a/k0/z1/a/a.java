package d.a.k0.z1.a;

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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f63652e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f63653f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.a.k0.z1.c.b> f63654g;

    /* renamed from: h  reason: collision with root package name */
    public c f63655h;

    /* renamed from: d.a.k0.z1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1758a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.z1.c.b f63656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f63657f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f63658g;

        public View$OnClickListenerC1758a(d.a.k0.z1.c.b bVar, b bVar2, int i2) {
            this.f63656e = bVar;
            this.f63657f = bVar2;
            this.f63658g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f63656e.d() && a.this.f63652e >= 10) {
                l.M(a.this.f63653f.getApplicationContext(), a.this.f63653f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.a.k0.z1.c.b bVar = this.f63656e;
            bVar.e(!bVar.d());
            a.this.i(this.f63657f.f63662c, this.f63656e);
            a.this.h(this.f63656e);
            if (a.this.f63655h != null) {
                a.this.f63655h.C0(a.this.f63652e);
            }
            if (this.f63656e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f63658g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f63660a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63661b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f63662c;

        public b(View view) {
            this.f63660a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f63661b = (TextView) view.findViewById(R.id.interest_text);
            this.f63662c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f63661b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void C0(int i2);
    }

    public a(List<d.a.k0.z1.c.b> list, Context context) {
        this.f63654g = list;
        this.f63653f = context;
    }

    public List<d.a.k0.z1.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.a.k0.z1.c.b bVar : this.f63654g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f63655h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.k0.z1.c.b> list = this.f63654g;
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
            view = LayoutInflater.from(this.f63653f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.a.k0.z1.c.b bVar2 = this.f63654g.get(i2);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f63660a, bVar2.a(), null);
        }
        bVar.f63661b.setText(bVar2.c());
        i(bVar.f63662c, bVar2);
        if (bVar2.d()) {
            this.f63652e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1758a(bVar2, bVar, i2));
        return view;
    }

    public final void h(d.a.k0.z1.c.b bVar) {
        if (bVar.d()) {
            this.f63652e++;
        } else {
            this.f63652e--;
        }
    }

    public final void i(ImageView imageView, d.a.k0.z1.c.b bVar) {
        if (bVar.d()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
