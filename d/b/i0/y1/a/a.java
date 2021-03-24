package d.b.i0.y1.a;

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
import d.b.b.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f62562e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f62563f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.b.i0.y1.c.b> f62564g;

    /* renamed from: h  reason: collision with root package name */
    public c f62565h;

    /* renamed from: d.b.i0.y1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1674a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.y1.c.b f62566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62567f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f62568g;

        public View$OnClickListenerC1674a(d.b.i0.y1.c.b bVar, b bVar2, int i) {
            this.f62566e = bVar;
            this.f62567f = bVar2;
            this.f62568g = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f62566e.d() && a.this.f62562e >= 10) {
                l.L(a.this.f62563f.getApplicationContext(), a.this.f62563f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.b.i0.y1.c.b bVar = this.f62566e;
            bVar.e(!bVar.d());
            a.this.i(this.f62567f.f62572c, this.f62566e);
            a.this.h(this.f62566e);
            if (a.this.f62565h != null) {
                a.this.f62565h.C0(a.this.f62562e);
            }
            if (this.f62566e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f62568g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f62570a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62571b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62572c;

        public b(View view) {
            this.f62570a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f62571b = (TextView) view.findViewById(R.id.interest_text);
            this.f62572c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f62571b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void C0(int i);
    }

    public a(List<d.b.i0.y1.c.b> list, Context context) {
        this.f62564g = list;
        this.f62563f = context;
    }

    public List<d.b.i0.y1.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.b.i0.y1.c.b bVar : this.f62564g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f62565h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.b.i0.y1.c.b> list = this.f62564g;
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
            view = LayoutInflater.from(this.f62563f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.b.i0.y1.c.b bVar2 = this.f62564g.get(i);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f62570a, bVar2.a(), null);
        }
        bVar.f62571b.setText(bVar2.c());
        i(bVar.f62572c, bVar2);
        if (bVar2.d()) {
            this.f62562e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1674a(bVar2, bVar, i));
        return view;
    }

    public final void h(d.b.i0.y1.c.b bVar) {
        if (bVar.d()) {
            this.f62562e++;
        } else {
            this.f62562e--;
        }
    }

    public final void i(ImageView imageView, d.b.i0.y1.c.b bVar) {
        if (bVar.d()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
