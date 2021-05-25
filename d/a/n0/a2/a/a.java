package d.a.n0.a2.a;

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
    public int f51143e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f51144f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.a.n0.a2.c.b> f51145g;

    /* renamed from: h  reason: collision with root package name */
    public c f51146h;

    /* renamed from: d.a.n0.a2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1178a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a2.c.b f51147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f51148f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f51149g;

        public View$OnClickListenerC1178a(d.a.n0.a2.c.b bVar, b bVar2, int i2) {
            this.f51147e = bVar;
            this.f51148f = bVar2;
            this.f51149g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f51147e.d() && a.this.f51143e >= 10) {
                l.M(a.this.f51144f.getApplicationContext(), a.this.f51144f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.a.n0.a2.c.b bVar = this.f51147e;
            bVar.e(!bVar.d());
            a.this.i(this.f51148f.f51153c, this.f51147e);
            a.this.h(this.f51147e);
            if (a.this.f51146h != null) {
                a.this.f51146h.C0(a.this.f51143e);
            }
            if (this.f51147e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f51149g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f51151a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51152b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f51153c;

        public b(View view) {
            this.f51151a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f51152b = (TextView) view.findViewById(R.id.interest_text);
            this.f51153c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f51152b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void C0(int i2);
    }

    public a(List<d.a.n0.a2.c.b> list, Context context) {
        this.f51145g = list;
        this.f51144f = context;
    }

    public List<d.a.n0.a2.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.a.n0.a2.c.b bVar : this.f51145g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f51146h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.n0.a2.c.b> list = this.f51145g;
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
            view = LayoutInflater.from(this.f51144f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.a.n0.a2.c.b bVar2 = this.f51145g.get(i2);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f51151a, bVar2.a(), null);
        }
        bVar.f51152b.setText(bVar2.c());
        i(bVar.f51153c, bVar2);
        if (bVar2.d()) {
            this.f51143e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1178a(bVar2, bVar, i2));
        return view;
    }

    public final void h(d.a.n0.a2.c.b bVar) {
        if (bVar.d()) {
            this.f51143e++;
        } else {
            this.f51143e--;
        }
    }

    public final void i(ImageView imageView, d.a.n0.a2.c.b bVar) {
        if (bVar.d()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
