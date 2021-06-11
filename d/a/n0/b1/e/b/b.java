package d.a.n0.b1.e.b;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import d.a.c.e.p.l;
import d.a.n0.b1.e.f.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55147a;

    /* renamed from: b  reason: collision with root package name */
    public View f55148b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.b1.e.f.a f55149c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f55150d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.e.a.b f55151e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f55152f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f55153g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55154h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55155i;
    public f j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n = false;
    public Animation.AnimationListener o = new a();
    public AdapterView.OnItemClickListener p = new C1249b();
    public View.OnClickListener q = new c();
    public PopupWindow.OnDismissListener r = new d();
    public a.InterfaceC1252a s = new e();

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.n = false;
            b.this.f();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.n = true;
        }
    }

    /* renamed from: d.a.n0.b1.e.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1249b implements AdapterView.OnItemClickListener {
        public C1249b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (b.this.f55151e != null && i2 < b.this.f55151e.getCount() && b.this.f55151e.getItem(i2) != null && (b.this.f55151e.getItem(i2) instanceof d.a.n0.b1.e.c.a)) {
                d.a.n0.b1.e.c.a aVar = (d.a.n0.b1.e.c.a) b.this.f55151e.getItem(i2);
                if (aVar.f55183d == 1) {
                    if (b.this.j != null) {
                        b.this.j.a(aVar);
                    }
                    d.a.m0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f55180a);
                    d.a.m0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f55181b);
                    b.this.f();
                    TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f55180a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PopupWindow.OnDismissListener {
        public d() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.j != null) {
                b.this.j.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.InterfaceC1252a {
        public e() {
        }

        @Override // d.a.n0.b1.e.f.a.InterfaceC1252a
        public void a() {
            b.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(d.a.n0.b1.e.c.a aVar);

        void b();

        void c();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f55147a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        d.a.n0.b1.e.f.a aVar = this.f55149c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void f() {
        d.a.n0.b1.e.f.a aVar = this.f55149c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f55147a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.f55148b = inflate;
        this.f55152f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.f55153g = (RelativeLayout) this.f55148b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.f55154h = (ImageView) this.f55148b.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.f55155i = (TextView) this.f55148b.findViewById(R.id.id_game_video_choose_half_empty_txt);
        GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f55148b.findViewById(R.id.id_game_video_choose_half_gridview);
        this.f55150d = gameVideoGridView;
        gameVideoGridView.setMaxHeight(l.k(this.f55147a.getPageActivity()));
        this.f55150d.setNumColumns(4);
        this.f55150d.setEmptyView(this.f55153g);
        d.a.n0.b1.e.a.b bVar = new d.a.n0.b1.e.a.b(this.f55147a, 102, this.m);
        this.f55151e = bVar;
        this.f55150d.setAdapter((ListAdapter) bVar);
        this.f55150d.setOnItemClickListener(this.p);
        this.f55148b.setOnClickListener(this.q);
        h();
        j();
    }

    public final void h() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.k = translateAnimation;
        translateAnimation.setDuration(300L);
        this.k.setFillAfter(true);
        this.k.setInterpolator(new AccelerateDecelerateInterpolator());
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.l = translateAnimation2;
        translateAnimation2.setDuration(200L);
        this.l.setFillAfter(true);
        this.l.setInterpolator(new AccelerateDecelerateInterpolator());
        this.l.setAnimationListener(this.o);
    }

    public boolean i() {
        d.a.n0.b1.e.f.a aVar = this.f55149c;
        if (aVar != null) {
            return aVar.isShowing();
        }
        return false;
    }

    public void j() {
        RelativeLayout relativeLayout = this.f55152f;
        if (relativeLayout != null) {
            SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
        }
        TextView textView = this.f55155i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
        }
        ImageView imageView = this.f55154h;
        if (imageView != null) {
            SkinManager.setImageResource(imageView, R.drawable.new_pic_emotion_08);
        }
    }

    public void k() {
        f();
        TranslateAnimation translateAnimation = this.k;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        TranslateAnimation translateAnimation2 = this.l;
        if (translateAnimation2 != null) {
            translateAnimation2.cancel();
        }
        GameVideoGridView gameVideoGridView = this.f55150d;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void l(List<d.a.n0.b1.e.c.a> list) {
        this.f55151e.b(list);
    }

    public void m(f fVar) {
        this.j = fVar;
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        if (view == null) {
            return;
        }
        this.f55151e.notifyDataSetChanged();
        if (this.f55149c == null) {
            d.a.n0.b1.e.f.a aVar = new d.a.n0.b1.e.f.a(this.f55147a, this.f55148b, -1, -1);
            this.f55149c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f55147a.getResources().getColor(R.color.black_alpha66)));
            this.f55149c.setAnimationStyle(0);
            this.f55149c.b(this.s);
            this.f55149c.setFocusable(true);
            this.f55149c.setOnDismissListener(this.r);
        }
        if (this.f55149c.isShowing()) {
            this.f55149c.dismiss();
        }
        this.f55149c.showAsDropDown(view, 0, 0);
        this.f55150d.e();
        RelativeLayout relativeLayout = this.f55152f;
        if (relativeLayout != null && (translateAnimation = this.k) != null) {
            relativeLayout.startAnimation(translateAnimation);
        }
        f fVar = this.j;
        if (fVar != null) {
            fVar.c();
        }
    }

    public final void o() {
        RelativeLayout relativeLayout;
        TranslateAnimation translateAnimation = this.l;
        if (translateAnimation == null || (relativeLayout = this.f55152f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i2) {
        d.a.n0.b1.e.a.b bVar = this.f55151e;
        if (bVar != null) {
            bVar.c(i2);
        }
    }
}
