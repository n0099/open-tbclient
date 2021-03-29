package d.b.i0.z0.d.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62855a;

    /* renamed from: b  reason: collision with root package name */
    public View f62856b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f62857c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.z0.d.a.b f62858d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62859e;

    /* renamed from: f  reason: collision with root package name */
    public b f62860f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f62861g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f62862h = new C1689a();

    /* renamed from: d.b.i0.z0.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1689a implements AdapterView.OnItemClickListener {
        public C1689a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.f62858d != null && i < a.this.f62858d.getCount() && a.this.f62858d.getItem(i) != null && (a.this.f62858d.getItem(i) instanceof d.b.i0.z0.d.c.a)) {
                d.b.i0.z0.d.c.a aVar = (d.b.i0.z0.d.c.a) a.this.f62858d.getItem(i);
                if (aVar.f62898d == 1) {
                    a.this.f62858d.c(aVar.f62895a);
                    if (a.this.f62860f != null) {
                        a.this.f62860f.a(aVar);
                    }
                    a.this.d();
                    d.b.h0.r.d0.b.i().u("key_game_video_tab_has_choosed_sub_class_id", aVar.f62895a);
                    d.b.h0.r.d0.b.i().w("key_game_video_tab_has_choosed_sub_class_name", aVar.f62896b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f62895a));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(d.b.i0.z0.d.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f62855a = tbPageContext;
        this.f62861g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f62856b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f62856b.getParent()).removeView(this.f62856b);
        }
        viewGroup.addView(this.f62856b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f62856b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f62856b.getParent()).removeView(this.f62856b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f62855a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f62856b = inflate;
        this.f62857c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f62858d = new d.b.i0.z0.d.a.b(this.f62855a, 101, this.f62861g);
        this.f62857c.setNumColumns(4);
        this.f62857c.setAdapter((ListAdapter) this.f62858d);
        this.f62857c.setOnItemClickListener(this.f62862h);
        this.f62859e = (TextView) this.f62856b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f62859e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f62856b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f62857c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.b.i0.z0.d.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f62858d.b(list);
        this.f62858d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f62860f = bVar;
    }
}
