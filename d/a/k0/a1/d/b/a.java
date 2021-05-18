package d.a.k0.a1.d.b;

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
    public TbPageContext f51290a;

    /* renamed from: b  reason: collision with root package name */
    public View f51291b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f51292c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.a1.d.a.b f51293d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51294e;

    /* renamed from: f  reason: collision with root package name */
    public b f51295f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f51296g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f51297h = new C1175a();

    /* renamed from: d.a.k0.a1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1175a implements AdapterView.OnItemClickListener {
        public C1175a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (a.this.f51293d != null && i2 < a.this.f51293d.getCount() && a.this.f51293d.getItem(i2) != null && (a.this.f51293d.getItem(i2) instanceof d.a.k0.a1.d.c.a)) {
                d.a.k0.a1.d.c.a aVar = (d.a.k0.a1.d.c.a) a.this.f51293d.getItem(i2);
                if (aVar.f51335d == 1) {
                    a.this.f51293d.c(aVar.f51332a);
                    if (a.this.f51295f != null) {
                        a.this.f51295f.a(aVar);
                    }
                    a.this.d();
                    d.a.j0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f51332a);
                    d.a.j0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f51333b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f51332a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.a.k0.a1.d.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f51290a = tbPageContext;
        this.f51296g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f51291b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f51291b.getParent()).removeView(this.f51291b);
        }
        viewGroup.addView(this.f51291b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f51291b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f51291b.getParent()).removeView(this.f51291b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f51290a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f51291b = inflate;
        this.f51292c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f51293d = new d.a.k0.a1.d.a.b(this.f51290a, 101, this.f51296g);
        this.f51292c.setNumColumns(4);
        this.f51292c.setAdapter((ListAdapter) this.f51293d);
        this.f51292c.setOnItemClickListener(this.f51297h);
        this.f51294e = (TextView) this.f51291b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f51294e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f51291b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f51292c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.a.k0.a1.d.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f51293d.b(list);
        this.f51293d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f51295f = bVar;
    }
}
