package d.b.j0.a1.d.b;

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
    public TbPageContext f52895a;

    /* renamed from: b  reason: collision with root package name */
    public View f52896b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f52897c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.a1.d.a.b f52898d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52899e;

    /* renamed from: f  reason: collision with root package name */
    public b f52900f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f52901g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f52902h = new C1164a();

    /* renamed from: d.b.j0.a1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1164a implements AdapterView.OnItemClickListener {
        public C1164a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.f52898d != null && i < a.this.f52898d.getCount() && a.this.f52898d.getItem(i) != null && (a.this.f52898d.getItem(i) instanceof d.b.j0.a1.d.c.a)) {
                d.b.j0.a1.d.c.a aVar = (d.b.j0.a1.d.c.a) a.this.f52898d.getItem(i);
                if (aVar.f52938d == 1) {
                    a.this.f52898d.c(aVar.f52935a);
                    if (a.this.f52900f != null) {
                        a.this.f52900f.a(aVar);
                    }
                    a.this.d();
                    d.b.i0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f52935a);
                    d.b.i0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f52936b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f52935a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.b.j0.a1.d.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f52895a = tbPageContext;
        this.f52901g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f52896b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f52896b.getParent()).removeView(this.f52896b);
        }
        viewGroup.addView(this.f52896b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f52896b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f52896b.getParent()).removeView(this.f52896b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f52895a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f52896b = inflate;
        this.f52897c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f52898d = new d.b.j0.a1.d.a.b(this.f52895a, 101, this.f52901g);
        this.f52897c.setNumColumns(4);
        this.f52897c.setAdapter((ListAdapter) this.f52898d);
        this.f52897c.setOnItemClickListener(this.f52902h);
        this.f52899e = (TextView) this.f52896b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f52899e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f52896b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f52897c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.b.j0.a1.d.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f52898d.b(list);
        this.f52898d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f52900f = bVar;
    }
}
