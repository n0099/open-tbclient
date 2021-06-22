package d.a.o0.b1.e.b;

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
    public TbPageContext f55263a;

    /* renamed from: b  reason: collision with root package name */
    public View f55264b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f55265c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.b1.e.a.b f55266d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55267e;

    /* renamed from: f  reason: collision with root package name */
    public b f55268f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f55269g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f55270h = new C1252a();

    /* renamed from: d.a.o0.b1.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1252a implements AdapterView.OnItemClickListener {
        public C1252a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (a.this.f55266d != null && i2 < a.this.f55266d.getCount() && a.this.f55266d.getItem(i2) != null && (a.this.f55266d.getItem(i2) instanceof d.a.o0.b1.e.c.a)) {
                d.a.o0.b1.e.c.a aVar = (d.a.o0.b1.e.c.a) a.this.f55266d.getItem(i2);
                if (aVar.f55308d == 1) {
                    a.this.f55266d.c(aVar.f55305a);
                    if (a.this.f55268f != null) {
                        a.this.f55268f.a(aVar);
                    }
                    a.this.d();
                    d.a.n0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f55305a);
                    d.a.n0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f55306b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f55305a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.a.o0.b1.e.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55263a = tbPageContext;
        this.f55269g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f55264b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f55264b.getParent()).removeView(this.f55264b);
        }
        viewGroup.addView(this.f55264b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f55264b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f55264b.getParent()).removeView(this.f55264b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f55263a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f55264b = inflate;
        this.f55265c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f55266d = new d.a.o0.b1.e.a.b(this.f55263a, 101, this.f55269g);
        this.f55265c.setNumColumns(4);
        this.f55265c.setAdapter((ListAdapter) this.f55266d);
        this.f55265c.setOnItemClickListener(this.f55270h);
        this.f55267e = (TextView) this.f55264b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f55267e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f55264b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f55265c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.a.o0.b1.e.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f55266d.b(list);
        this.f55266d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f55268f = bVar;
    }
}
