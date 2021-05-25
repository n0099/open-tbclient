package d.a.n0.b1.d.b;

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
    public TbPageContext f51455a;

    /* renamed from: b  reason: collision with root package name */
    public View f51456b;

    /* renamed from: c  reason: collision with root package name */
    public GameVideoGridView f51457c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.b1.d.a.b f51458d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51459e;

    /* renamed from: f  reason: collision with root package name */
    public b f51460f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f51461g;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f51462h = new C1192a();

    /* renamed from: d.a.n0.b1.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1192a implements AdapterView.OnItemClickListener {
        public C1192a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (a.this.f51458d != null && i2 < a.this.f51458d.getCount() && a.this.f51458d.getItem(i2) != null && (a.this.f51458d.getItem(i2) instanceof d.a.n0.b1.d.c.a)) {
                d.a.n0.b1.d.c.a aVar = (d.a.n0.b1.d.c.a) a.this.f51458d.getItem(i2);
                if (aVar.f51500d == 1) {
                    a.this.f51458d.c(aVar.f51497a);
                    if (a.this.f51460f != null) {
                        a.this.f51460f.a(aVar);
                    }
                    a.this.d();
                    d.a.m0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f51497a);
                    d.a.m0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f51498b);
                    TiebaStatic.log(new StatisticItem("c13485").param("obj_type", aVar.f51497a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(d.a.n0.b1.d.c.a aVar);
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f51455a = tbPageContext;
        this.f51461g = bdUniqueId;
        e();
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.f51456b) == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f51456b.getParent()).removeView(this.f51456b);
        }
        viewGroup.addView(this.f51456b);
        TiebaStatic.log("c13484");
    }

    public void d() {
        View view = this.f51456b;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.f51456b.getParent()).removeView(this.f51456b);
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f51455a.getPageActivity()).inflate(R.layout.game_video_choose_fullscreen_layout, (ViewGroup) null);
        this.f51456b = inflate;
        this.f51457c = (GameVideoGridView) inflate.findViewById(R.id.id_game_video_choose_full_gridview);
        this.f51458d = new d.a.n0.b1.d.a.b(this.f51455a, 101, this.f51461g);
        this.f51457c.setNumColumns(4);
        this.f51457c.setAdapter((ListAdapter) this.f51458d);
        this.f51457c.setOnItemClickListener(this.f51462h);
        this.f51459e = (TextView) this.f51456b.findViewById(R.id.id_game_video_choose_full_title);
        f();
    }

    public void f() {
        TextView textView = this.f51459e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        }
        View view = this.f51456b;
        if (view != null) {
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        }
    }

    public void g() {
        GameVideoGridView gameVideoGridView = this.f51457c;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void h(List<d.a.n0.b1.d.c.a> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f51458d.b(list);
        this.f51458d.notifyDataSetChanged();
    }

    public void i(b bVar) {
        this.f51460f = bVar;
    }
}
