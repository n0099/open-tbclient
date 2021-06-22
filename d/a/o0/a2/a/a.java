package d.a.o0.a2.a;

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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public int f54945e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f54946f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.a.o0.a2.c.b> f54947g;

    /* renamed from: h  reason: collision with root package name */
    public c f54948h;

    /* renamed from: d.a.o0.a2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1238a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a2.c.b f54949e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f54950f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54951g;

        public View$OnClickListenerC1238a(d.a.o0.a2.c.b bVar, b bVar2, int i2) {
            this.f54949e = bVar;
            this.f54950f = bVar2;
            this.f54951g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f54949e.d() && a.this.f54945e >= 10) {
                l.M(a.this.f54946f.getApplicationContext(), a.this.f54946f.getApplicationContext().getString(R.string.max_interest_select_num));
                return;
            }
            d.a.o0.a2.c.b bVar = this.f54949e;
            bVar.e(!bVar.d());
            a.this.i(this.f54950f.f54955c, this.f54949e);
            a.this.h(this.f54949e);
            if (a.this.f54948h != null) {
                a.this.f54948h.F0(a.this.f54945e);
            }
            if (this.f54949e.d()) {
                StatisticItem statisticItem = new StatisticItem("c13682");
                statisticItem.param("obj_type", 2);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_source", this.f54951g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f54953a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54954b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f54955c;

        public b(View view) {
            this.f54953a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f54954b = (TextView) view.findViewById(R.id.interest_text);
            this.f54955c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f54954b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void F0(int i2);
    }

    public a(List<d.a.o0.a2.c.b> list, Context context) {
        this.f54947g = list;
        this.f54946f = context;
    }

    public List<d.a.o0.a2.c.b> f() {
        ArrayList arrayList = new ArrayList();
        for (d.a.o0.a2.c.b bVar : this.f54947g) {
            if (bVar.d()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void g(c cVar) {
        this.f54948h = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<d.a.o0.a2.c.b> list = this.f54947g;
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
            view = LayoutInflater.from(this.f54946f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        d.a.o0.a2.c.b bVar2 = this.f54947g.get(i2);
        if (bVar2.a() > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f54953a, bVar2.a(), null);
        }
        bVar.f54954b.setText(bVar2.c());
        i(bVar.f54955c, bVar2);
        if (bVar2.d()) {
            this.f54945e++;
        }
        view.setOnClickListener(new View$OnClickListenerC1238a(bVar2, bVar, i2));
        return view;
    }

    public final void h(d.a.o0.a2.c.b bVar) {
        if (bVar.d()) {
            this.f54945e++;
        } else {
            this.f54945e--;
        }
    }

    public final void i(ImageView imageView, d.a.o0.a2.c.b bVar) {
        if (bVar.d()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
    }
}
