package d.a.k0.a1.d.b;

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
import d.a.k0.a1.d.f.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51299a;

    /* renamed from: b  reason: collision with root package name */
    public View f51300b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.a1.d.f.a f51301c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f51302d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.a1.d.a.b f51303e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f51304f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f51305g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f51306h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51307i;
    public f j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n = false;
    public Animation.AnimationListener o = new a();
    public AdapterView.OnItemClickListener p = new C1176b();
    public View.OnClickListener q = new c();
    public PopupWindow.OnDismissListener r = new d();
    public a.InterfaceC1179a s = new e();

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

    /* renamed from: d.a.k0.a1.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1176b implements AdapterView.OnItemClickListener {
        public C1176b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (b.this.f51303e != null && i2 < b.this.f51303e.getCount() && b.this.f51303e.getItem(i2) != null && (b.this.f51303e.getItem(i2) instanceof d.a.k0.a1.d.c.a)) {
                d.a.k0.a1.d.c.a aVar = (d.a.k0.a1.d.c.a) b.this.f51303e.getItem(i2);
                if (aVar.f51335d == 1) {
                    if (b.this.j != null) {
                        b.this.j.a(aVar);
                    }
                    d.a.j0.r.d0.b.j().v("key_game_video_tab_has_choosed_sub_class_id", aVar.f51332a);
                    d.a.j0.r.d0.b.j().x("key_game_video_tab_has_choosed_sub_class_name", aVar.f51333b);
                    b.this.f();
                    TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f51332a));
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
    public class e implements a.InterfaceC1179a {
        public e() {
        }

        @Override // d.a.k0.a1.d.f.a.InterfaceC1179a
        public void a() {
            b.this.o();
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(d.a.k0.a1.d.c.a aVar);

        void b();

        void c();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f51299a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        d.a.k0.a1.d.f.a aVar = this.f51301c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void f() {
        d.a.k0.a1.d.f.a aVar = this.f51301c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f51299a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.f51300b = inflate;
        this.f51304f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.f51305g = (RelativeLayout) this.f51300b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.f51306h = (ImageView) this.f51300b.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.f51307i = (TextView) this.f51300b.findViewById(R.id.id_game_video_choose_half_empty_txt);
        GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f51300b.findViewById(R.id.id_game_video_choose_half_gridview);
        this.f51302d = gameVideoGridView;
        gameVideoGridView.setMaxHeight(l.k(this.f51299a.getPageActivity()));
        this.f51302d.setNumColumns(4);
        this.f51302d.setEmptyView(this.f51305g);
        d.a.k0.a1.d.a.b bVar = new d.a.k0.a1.d.a.b(this.f51299a, 102, this.m);
        this.f51303e = bVar;
        this.f51302d.setAdapter((ListAdapter) bVar);
        this.f51302d.setOnItemClickListener(this.p);
        this.f51300b.setOnClickListener(this.q);
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
        d.a.k0.a1.d.f.a aVar = this.f51301c;
        if (aVar != null) {
            return aVar.isShowing();
        }
        return false;
    }

    public void j() {
        RelativeLayout relativeLayout = this.f51304f;
        if (relativeLayout != null) {
            SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
        }
        TextView textView = this.f51307i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
        }
        ImageView imageView = this.f51306h;
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
        GameVideoGridView gameVideoGridView = this.f51302d;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void l(List<d.a.k0.a1.d.c.a> list) {
        this.f51303e.b(list);
    }

    public void m(f fVar) {
        this.j = fVar;
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        if (view == null) {
            return;
        }
        this.f51303e.notifyDataSetChanged();
        if (this.f51301c == null) {
            d.a.k0.a1.d.f.a aVar = new d.a.k0.a1.d.f.a(this.f51299a, this.f51300b, -1, -1);
            this.f51301c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f51299a.getResources().getColor(R.color.black_alpha66)));
            this.f51301c.setAnimationStyle(0);
            this.f51301c.b(this.s);
            this.f51301c.setFocusable(true);
            this.f51301c.setOnDismissListener(this.r);
        }
        if (this.f51301c.isShowing()) {
            this.f51301c.dismiss();
        }
        this.f51301c.showAsDropDown(view, 0, 0);
        this.f51302d.e();
        RelativeLayout relativeLayout = this.f51304f;
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
        if (translateAnimation == null || (relativeLayout = this.f51304f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i2) {
        d.a.k0.a1.d.a.b bVar = this.f51303e;
        if (bVar != null) {
            bVar.c(i2);
        }
    }
}
