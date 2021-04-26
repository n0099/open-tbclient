package d.a.j0.a1.d.b;

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
import d.a.j0.a1.d.f.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f50602a;

    /* renamed from: b  reason: collision with root package name */
    public View f50603b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.a1.d.f.a f50604c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f50605d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.a1.d.a.b f50606e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f50607f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f50608g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f50609h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f50610i;
    public f j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n = false;
    public Animation.AnimationListener o = new a();
    public AdapterView.OnItemClickListener p = new C1104b();
    public View.OnClickListener q = new c();
    public PopupWindow.OnDismissListener r = new d();
    public a.InterfaceC1107a s = new e();

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

    /* renamed from: d.a.j0.a1.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1104b implements AdapterView.OnItemClickListener {
        public C1104b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (b.this.f50606e != null && i2 < b.this.f50606e.getCount() && b.this.f50606e.getItem(i2) != null && (b.this.f50606e.getItem(i2) instanceof d.a.j0.a1.d.c.a)) {
                d.a.j0.a1.d.c.a aVar = (d.a.j0.a1.d.c.a) b.this.f50606e.getItem(i2);
                if (aVar.f50638d == 1) {
                    if (b.this.j != null) {
                        b.this.j.a(aVar);
                    }
                    d.a.i0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f50635a);
                    d.a.i0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f50636b);
                    b.this.f();
                    TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f50635a));
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
    public class e implements a.InterfaceC1107a {
        public e() {
        }

        @Override // d.a.j0.a1.d.f.a.InterfaceC1107a
        public void a() {
            b.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(d.a.j0.a1.d.c.a aVar);

        void b();

        void c();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f50602a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        d.a.j0.a1.d.f.a aVar = this.f50604c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void f() {
        d.a.j0.a1.d.f.a aVar = this.f50604c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f50602a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.f50603b = inflate;
        this.f50607f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.f50608g = (RelativeLayout) this.f50603b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.f50609h = (ImageView) this.f50603b.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.f50610i = (TextView) this.f50603b.findViewById(R.id.id_game_video_choose_half_empty_txt);
        GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f50603b.findViewById(R.id.id_game_video_choose_half_gridview);
        this.f50605d = gameVideoGridView;
        gameVideoGridView.setMaxHeight(l.k(this.f50602a.getPageActivity()));
        this.f50605d.setNumColumns(4);
        this.f50605d.setEmptyView(this.f50608g);
        d.a.j0.a1.d.a.b bVar = new d.a.j0.a1.d.a.b(this.f50602a, 102, this.m);
        this.f50606e = bVar;
        this.f50605d.setAdapter((ListAdapter) bVar);
        this.f50605d.setOnItemClickListener(this.p);
        this.f50603b.setOnClickListener(this.q);
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
        d.a.j0.a1.d.f.a aVar = this.f50604c;
        if (aVar != null) {
            return aVar.isShowing();
        }
        return false;
    }

    public void j() {
        RelativeLayout relativeLayout = this.f50607f;
        if (relativeLayout != null) {
            SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
        }
        TextView textView = this.f50610i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
        }
        ImageView imageView = this.f50609h;
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
        GameVideoGridView gameVideoGridView = this.f50605d;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void l(List<d.a.j0.a1.d.c.a> list) {
        this.f50606e.b(list);
    }

    public void m(f fVar) {
        this.j = fVar;
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        if (view == null) {
            return;
        }
        this.f50606e.notifyDataSetChanged();
        if (this.f50604c == null) {
            d.a.j0.a1.d.f.a aVar = new d.a.j0.a1.d.f.a(this.f50602a, this.f50603b, -1, -1);
            this.f50604c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f50602a.getResources().getColor(R.color.black_alpha66)));
            this.f50604c.setAnimationStyle(0);
            this.f50604c.b(this.s);
            this.f50604c.setFocusable(true);
            this.f50604c.setOnDismissListener(this.r);
        }
        if (this.f50604c.isShowing()) {
            this.f50604c.dismiss();
        }
        this.f50604c.showAsDropDown(view, 0, 0);
        this.f50605d.e();
        RelativeLayout relativeLayout = this.f50607f;
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
        if (translateAnimation == null || (relativeLayout = this.f50607f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i2) {
        d.a.j0.a1.d.a.b bVar = this.f50606e;
        if (bVar != null) {
            bVar.c(i2);
        }
    }
}
