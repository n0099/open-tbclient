package d.a.j0.a1.d.b;

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
    public TbPageContext f50593a;

    /* renamed from: b  reason: collision with root package name */
    public View f50594b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f50595c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.a1.d.a.b f50596d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50597e;

    /* renamed from: f  reason: collision with root package name */
    public b f50598f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f50599g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f50600h = new C1103a();

    /* renamed from: d.a.j0.a1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1103a implements AdapterView.OnItemClickListener {
        public C1103a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (a.this.f50596d != null && i2 < a.this.f50596d.getCount() && a.this.f50596d.getItem(i2) != null && (a.this.f50596d.getItem(i2) instanceof d.a.j0.a1.d.c.a)) {
                d.a.j0.a1.d.c.a aVar = (d.a.j0.a1.d.c.a) a.this.f50596d.getItem(i2);
                if (aVar.f50638d == 1) {
                    a.this.f50596d.c(aVar.f50635a);
                    if (a.this.f50598f != null) {
                        a.this.f50598f.a(aVar);
                    }
                    a.this.d();
                    d.a.i0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f50635a);
                    d.a.i0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f50636b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f50635a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.a.j0.a1.d.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f50593a = tbPageContext;
        this.f50599g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f50594b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f50594b.getParent()).removeView(this.f50594b);
        }
        viewGroup.addView(this.f50594b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f50594b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f50594b.getParent()).removeView(this.f50594b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f50593a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f50594b = inflate;
        this.f50595c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f50596d = new d.a.j0.a1.d.a.b(this.f50593a, 101, this.f50599g);
        this.f50595c.setNumColumns(4);
        this.f50595c.setAdapter((ListAdapter) this.f50596d);
        this.f50595c.setOnItemClickListener(this.f50600h);
        this.f50597e = (TextView) this.f50594b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f50597e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f50594b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f50595c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.a.j0.a1.d.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f50596d.b(list);
        this.f50596d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f50598f = bVar;
    }
}
