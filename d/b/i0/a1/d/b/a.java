package d.b.i0.a1.d.b;

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
    public TbPageContext f52474a;

    /* renamed from: b  reason: collision with root package name */
    public View f52475b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f52476c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.a1.d.a.b f52477d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52478e;

    /* renamed from: f  reason: collision with root package name */
    public b f52479f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f52480g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f52481h = new C1141a();

    /* renamed from: d.b.i0.a1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1141a implements AdapterView.OnItemClickListener {
        public C1141a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.f52477d != null && i < a.this.f52477d.getCount() && a.this.f52477d.getItem(i) != null && (a.this.f52477d.getItem(i) instanceof d.b.i0.a1.d.c.a)) {
                d.b.i0.a1.d.c.a aVar = (d.b.i0.a1.d.c.a) a.this.f52477d.getItem(i);
                if (aVar.f52517d == 1) {
                    a.this.f52477d.c(aVar.f52514a);
                    if (a.this.f52479f != null) {
                        a.this.f52479f.a(aVar);
                    }
                    a.this.d();
                    d.b.h0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f52514a);
                    d.b.h0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f52515b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f52514a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.b.i0.a1.d.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f52474a = tbPageContext;
        this.f52480g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f52475b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f52475b.getParent()).removeView(this.f52475b);
        }
        viewGroup.addView(this.f52475b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f52475b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f52475b.getParent()).removeView(this.f52475b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f52474a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f52475b = inflate;
        this.f52476c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f52477d = new d.b.i0.a1.d.a.b(this.f52474a, 101, this.f52480g);
        this.f52476c.setNumColumns(4);
        this.f52476c.setAdapter((ListAdapter) this.f52477d);
        this.f52476c.setOnItemClickListener(this.f52481h);
        this.f52478e = (TextView) this.f52475b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f52478e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f52475b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f52476c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.b.i0.a1.d.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f52477d.b(list);
        this.f52477d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f52479f = bVar;
    }
}
