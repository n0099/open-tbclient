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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62854a;

    /* renamed from: b  reason: collision with root package name */
    public View f62855b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f62856c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.z0.d.a.b f62857d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62858e;

    /* renamed from: f  reason: collision with root package name */
    public b f62859f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f62860g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f62861h = new C1688a();

    /* renamed from: d.b.i0.z0.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1688a implements AdapterView.OnItemClickListener {
        public C1688a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.f62857d != null && i < a.this.f62857d.getCount() && a.this.f62857d.getItem(i) != null && (a.this.f62857d.getItem(i) instanceof d.b.i0.z0.d.c.a)) {
                d.b.i0.z0.d.c.a aVar = (d.b.i0.z0.d.c.a) a.this.f62857d.getItem(i);
                if (aVar.f62897d == 1) {
                    a.this.f62857d.c(aVar.f62894a);
                    if (a.this.f62859f != null) {
                        a.this.f62859f.a(aVar);
                    }
                    a.this.d();
                    d.b.h0.r.d0.b.i().u("key_game_video_tab_has_choosed_sub_class_id", aVar.f62894a);
                    d.b.h0.r.d0.b.i().w("key_game_video_tab_has_choosed_sub_class_name", aVar.f62895b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f62894a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.b.i0.z0.d.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f62854a = tbPageContext;
        this.f62860g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f62855b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f62855b.getParent()).removeView(this.f62855b);
        }
        viewGroup.addView(this.f62855b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f62855b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f62855b.getParent()).removeView(this.f62855b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f62854a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f62855b = inflate;
        this.f62856c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f62857d = new d.b.i0.z0.d.a.b(this.f62854a, 101, this.f62860g);
        this.f62856c.setNumColumns(4);
        this.f62856c.setAdapter((ListAdapter) this.f62857d);
        this.f62856c.setOnItemClickListener(this.f62861h);
        this.f62858e = (TextView) this.f62855b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f62858e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f62855b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f62856c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.b.i0.z0.d.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f62857d.b(list);
        this.f62857d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f62859f = bVar;
    }
}
