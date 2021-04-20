package d.b.i0.a1.d.b;

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
import d.b.i0.a1.d.f.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52483a;

    /* renamed from: b  reason: collision with root package name */
    public View f52484b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.a1.d.f.a f52485c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f52486d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.a1.d.a.b f52487e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f52488f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f52489g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f52490h;
    public TextView i;
    public f j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n = false;
    public Animation.AnimationListener o = new a();
    public AdapterView.OnItemClickListener p = new C1142b();
    public View.OnClickListener q = new c();
    public PopupWindow.OnDismissListener r = new d();
    public a.InterfaceC1145a s = new e();

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

    /* renamed from: d.b.i0.a1.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1142b implements AdapterView.OnItemClickListener {
        public C1142b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.f52487e != null && i < b.this.f52487e.getCount() && b.this.f52487e.getItem(i) != null && (b.this.f52487e.getItem(i) instanceof d.b.i0.a1.d.c.a)) {
                d.b.i0.a1.d.c.a aVar = (d.b.i0.a1.d.c.a) b.this.f52487e.getItem(i);
                if (aVar.f52517d == 1) {
                    if (b.this.j != null) {
                        b.this.j.a(aVar);
                    }
                    d.b.h0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f52514a);
                    d.b.h0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f52515b);
                    b.this.f();
                    TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f52514a));
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
    public class e implements a.InterfaceC1145a {
        public e() {
        }

        @Override // d.b.i0.a1.d.f.a.InterfaceC1145a
        public void a() {
            b.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(d.b.i0.a1.d.c.a aVar);

        void b();

        void c();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f52483a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        d.b.i0.a1.d.f.a aVar = this.f52485c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void f() {
        d.b.i0.a1.d.f.a aVar = this.f52485c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f52483a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.f52484b = inflate;
        this.f52488f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.f52489g = (RelativeLayout) this.f52484b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.f52490h = (ImageView) this.f52484b.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.i = (TextView) this.f52484b.findViewById(R.id.id_game_video_choose_half_empty_txt);
        GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f52484b.findViewById(R.id.id_game_video_choose_half_gridview);
        this.f52486d = gameVideoGridView;
        gameVideoGridView.setMaxHeight(l.k(this.f52483a.getPageActivity()));
        this.f52486d.setNumColumns(4);
        this.f52486d.setEmptyView(this.f52489g);
        d.b.i0.a1.d.a.b bVar = new d.b.i0.a1.d.a.b(this.f52483a, 102, this.m);
        this.f52487e = bVar;
        this.f52486d.setAdapter((ListAdapter) bVar);
        this.f52486d.setOnItemClickListener(this.p);
        this.f52484b.setOnClickListener(this.q);
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
        d.b.i0.a1.d.f.a aVar = this.f52485c;
        if (aVar != null) {
            return aVar.isShowing();
        }
        return false;
    }

    public void j() {
        RelativeLayout relativeLayout = this.f52488f;
        if (relativeLayout != null) {
            SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
        }
        TextView textView = this.i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
        }
        ImageView imageView = this.f52490h;
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
        GameVideoGridView gameVideoGridView = this.f52486d;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void l(List<d.b.i0.a1.d.c.a> list) {
        this.f52487e.b(list);
    }

    public void m(f fVar) {
        this.j = fVar;
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        if (view == null) {
            return;
        }
        this.f52487e.notifyDataSetChanged();
        if (this.f52485c == null) {
            d.b.i0.a1.d.f.a aVar = new d.b.i0.a1.d.f.a(this.f52483a, this.f52484b, -1, -1);
            this.f52485c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f52483a.getResources().getColor(R.color.black_alpha66)));
            this.f52485c.setAnimationStyle(0);
            this.f52485c.b(this.s);
            this.f52485c.setFocusable(true);
            this.f52485c.setOnDismissListener(this.r);
        }
        if (this.f52485c.isShowing()) {
            this.f52485c.dismiss();
        }
        this.f52485c.showAsDropDown(view, 0, 0);
        this.f52486d.e();
        RelativeLayout relativeLayout = this.f52488f;
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
        if (translateAnimation == null || (relativeLayout = this.f52488f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i) {
        d.b.i0.a1.d.a.b bVar = this.f52487e;
        if (bVar != null) {
            bVar.c(i);
        }
    }
}
