package d.b.j0.a1.d.b;

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
import d.b.c.e.p.l;
import d.b.j0.a1.d.f.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52904a;

    /* renamed from: b  reason: collision with root package name */
    public View f52905b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.a1.d.f.a f52906c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f52907d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.a1.d.a.b f52908e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f52909f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f52910g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f52911h;
    public TextView i;
    public f j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n = false;
    public Animation.AnimationListener o = new a();
    public AdapterView.OnItemClickListener p = new C1165b();
    public View.OnClickListener q = new c();
    public PopupWindow.OnDismissListener r = new d();
    public a.InterfaceC1168a s = new e();

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

    /* renamed from: d.b.j0.a1.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1165b implements AdapterView.OnItemClickListener {
        public C1165b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.f52908e != null && i < b.this.f52908e.getCount() && b.this.f52908e.getItem(i) != null && (b.this.f52908e.getItem(i) instanceof d.b.j0.a1.d.c.a)) {
                d.b.j0.a1.d.c.a aVar = (d.b.j0.a1.d.c.a) b.this.f52908e.getItem(i);
                if (aVar.f52938d == 1) {
                    if (b.this.j != null) {
                        b.this.j.a(aVar);
                    }
                    d.b.i0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f52935a);
                    d.b.i0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f52936b);
                    b.this.f();
                    TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f52935a));
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
    public class e implements a.InterfaceC1168a {
        public e() {
        }

        @Override // d.b.j0.a1.d.f.a.InterfaceC1168a
        public void a() {
            b.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(d.b.j0.a1.d.c.a aVar);

        void b();

        void c();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f52904a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        d.b.j0.a1.d.f.a aVar = this.f52906c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void f() {
        d.b.j0.a1.d.f.a aVar = this.f52906c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f52904a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.f52905b = inflate;
        this.f52909f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.f52910g = (RelativeLayout) this.f52905b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.f52911h = (ImageView) this.f52905b.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.i = (TextView) this.f52905b.findViewById(R.id.id_game_video_choose_half_empty_txt);
        GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f52905b.findViewById(R.id.id_game_video_choose_half_gridview);
        this.f52907d = gameVideoGridView;
        gameVideoGridView.setMaxHeight(l.k(this.f52904a.getPageActivity()));
        this.f52907d.setNumColumns(4);
        this.f52907d.setEmptyView(this.f52910g);
        d.b.j0.a1.d.a.b bVar = new d.b.j0.a1.d.a.b(this.f52904a, 102, this.m);
        this.f52908e = bVar;
        this.f52907d.setAdapter((ListAdapter) bVar);
        this.f52907d.setOnItemClickListener(this.p);
        this.f52905b.setOnClickListener(this.q);
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
        d.b.j0.a1.d.f.a aVar = this.f52906c;
        if (aVar != null) {
            return aVar.isShowing();
        }
        return false;
    }

    public void j() {
        RelativeLayout relativeLayout = this.f52909f;
        if (relativeLayout != null) {
            SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
        }
        TextView textView = this.i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
        }
        ImageView imageView = this.f52911h;
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
        GameVideoGridView gameVideoGridView = this.f52907d;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void l(List<d.b.j0.a1.d.c.a> list) {
        this.f52908e.b(list);
    }

    public void m(f fVar) {
        this.j = fVar;
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        if (view == null) {
            return;
        }
        this.f52908e.notifyDataSetChanged();
        if (this.f52906c == null) {
            d.b.j0.a1.d.f.a aVar = new d.b.j0.a1.d.f.a(this.f52904a, this.f52905b, -1, -1);
            this.f52906c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f52904a.getResources().getColor(R.color.black_alpha66)));
            this.f52906c.setAnimationStyle(0);
            this.f52906c.b(this.s);
            this.f52906c.setFocusable(true);
            this.f52906c.setOnDismissListener(this.r);
        }
        if (this.f52906c.isShowing()) {
            this.f52906c.dismiss();
        }
        this.f52906c.showAsDropDown(view, 0, 0);
        this.f52907d.e();
        RelativeLayout relativeLayout = this.f52909f;
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
        if (translateAnimation == null || (relativeLayout = this.f52909f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i) {
        d.b.j0.a1.d.a.b bVar = this.f52908e;
        if (bVar != null) {
            bVar.c(i);
        }
    }
}
