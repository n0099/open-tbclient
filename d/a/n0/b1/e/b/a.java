package d.a.n0.b1.e.b;

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
    public TbPageContext f55138a;

    /* renamed from: b  reason: collision with root package name */
    public View f55139b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f55140c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.b1.e.a.b f55141d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55142e;

    /* renamed from: f  reason: collision with root package name */
    public b f55143f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f55144g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f55145h = new C1248a();

    /* renamed from: d.a.n0.b1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1248a implements AdapterView.OnItemClickListener {
        public C1248a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (a.this.f55141d != null && i2 < a.this.f55141d.getCount() && a.this.f55141d.getItem(i2) != null && (a.this.f55141d.getItem(i2) instanceof d.a.n0.b1.e.c.a)) {
                d.a.n0.b1.e.c.a aVar = (d.a.n0.b1.e.c.a) a.this.f55141d.getItem(i2);
                if (aVar.f55183d == 1) {
                    a.this.f55141d.c(aVar.f55180a);
                    if (a.this.f55143f != null) {
                        a.this.f55143f.a(aVar);
                    }
                    a.this.d();
                    d.a.m0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f55180a);
                    d.a.m0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f55181b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f55180a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.a.n0.b1.e.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55138a = tbPageContext;
        this.f55144g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f55139b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f55139b.getParent()).removeView(this.f55139b);
        }
        viewGroup.addView(this.f55139b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f55139b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f55139b.getParent()).removeView(this.f55139b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f55138a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f55139b = inflate;
        this.f55140c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f55141d = new d.a.n0.b1.e.a.b(this.f55138a, 101, this.f55144g);
        this.f55140c.setNumColumns(4);
        this.f55140c.setAdapter((ListAdapter) this.f55141d);
        this.f55140c.setOnItemClickListener(this.f55145h);
        this.f55142e = (TextView) this.f55139b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f55142e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f55139b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f55140c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.a.n0.b1.e.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f55141d.b(list);
        this.f55141d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f55143f = bVar;
    }
}
