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
    public int f54820e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f54821f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.a.n0.a2.c.b> f54822g;

    /* renamed from: h  reason: collision with root package name */
    public c f54823h;

    /* renamed from: d.a.n0.a2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1234a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a2.c.b f54824e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f54825f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54826g;

        public View$OnClickListenerC1234a(d.a.n0.a2.c.b bVar, b bVar2, int i2) {
            this.f54824e = bVar;
            this.f54825f = bVar2;
            this.f54826g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f54824e.d() && a.this.f54820e >= 10) {
                l.M(a.this.f54821f.getApplicationContext(), a.this.f54821f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.a.n0.a2.c.b bVar = this.f54824e;
            bVar.e(!bVar.d());
            a.this.i(this.f54825f.f54830c, this.f54824e);
            a.this.h(this.f54824e);
            if (a.this.f54823h != null) {
                a.this.f54823h.F0(a.this.f54820e);
            }
            if (this.f54824e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f54826g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f54828a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54829b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f54830c;

        public b(View view) {
            this.f54828a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f54829b = (TextView) view.findViewById(R.id.interest_text);
            this.f54830c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f54829b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void F0(int i2);
    }

    public a(List<d.a.n0.a2.c.b> list, Context context) {
        this.f54822g = list;
        this.f54821f = context;
    }

    public List<d.a.n0.a2.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.a.n0.a2.c.b bVar : this.f54822g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f54823h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.n0.a2.c.b> list = this.f54822g;
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
            view = LayoutInflater.from(this.f54821f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.a.n0.a2.c.b bVar2 = this.f54822g.get(i2);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f54828a, bVar2.a(), null);
        }
        bVar.f54829b.setText(bVar2.c());
        i(bVar.f54830c, bVar2);
        if (bVar2.d()) {
            this.f54820e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1234a(bVar2, bVar, i2));
        return view;
    }

    public final void h(d.a.n0.a2.c.b bVar) {
        if (bVar.d()) {
            this.f54820e++;
        } else {
            this.f54820e--;
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
