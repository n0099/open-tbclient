package d.b.i0.z0.d.b;

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
import d.b.b.e.p.l;
import d.b.i0.z0.d.f.a;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62864a;

    /* renamed from: b  reason: collision with root package name */
    public View f62865b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.z0.d.f.a f62866c;

    /* renamed from: d  reason: collision with root package name */
    public GameVideoGridView f62867d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.z0.d.a.b f62868e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f62869f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f62870g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f62871h;
    public TextView i;
    public f j;
    public TranslateAnimation k;
    public TranslateAnimation l;
    public BdUniqueId m;
    public boolean n = false;
    public Animation.AnimationListener o = new a();
    public AdapterView.OnItemClickListener p = new C1690b();
    public View.OnClickListener q = new c();
    public PopupWindow.OnDismissListener r = new d();
    public a.InterfaceC1693a s = new e();

    /* loaded from: classes3.dex */
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

    /* renamed from: d.b.i0.z0.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1690b implements AdapterView.OnItemClickListener {
        public C1690b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.f62868e != null && i < b.this.f62868e.getCount() && b.this.f62868e.getItem(i) != null && (b.this.f62868e.getItem(i) instanceof d.b.i0.z0.d.c.a)) {
                d.b.i0.z0.d.c.a aVar = (d.b.i0.z0.d.c.a) b.this.f62868e.getItem(i);
                if (aVar.f62898d == 1) {
                    if (b.this.j != null) {
                        b.this.j.a(aVar);
                    }
                    d.b.h0.r.d0.b.i().u("key_game_video_tab_has_choosed_sub_class_id", aVar.f62895a);
                    d.b.h0.r.d0.b.i().w("key_game_video_tab_has_choosed_sub_class_name", aVar.f62896b);
                    b.this.f();
                    TiebaStatic.log(new StatisticItem("c13489").param("obj_type", aVar.f62895a));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.e();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class e implements a.InterfaceC1693a {
        public e() {
        }

        @Override // d.b.i0.z0.d.f.a.InterfaceC1693a
        public void a() {
            b.this.o();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(d.b.i0.z0.d.c.a aVar);

        void b();

        void c();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f62864a = tbPageContext;
        this.m = bdUniqueId;
        g();
    }

    public void e() {
        d.b.i0.z0.d.f.a aVar = this.f62866c;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public void f() {
        d.b.i0.z0.d.f.a aVar = this.f62866c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f62864a.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.f62865b = inflate;
        this.f62869f = (RelativeLayout) inflate.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.f62870g = (RelativeLayout) this.f62865b.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.f62871h = (ImageView) this.f62865b.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.i = (TextView) this.f62865b.findViewById(R.id.id_game_video_choose_half_empty_txt);
        GameVideoGridView gameVideoGridView = (GameVideoGridView) this.f62865b.findViewById(R.id.id_game_video_choose_half_gridview);
        this.f62867d = gameVideoGridView;
        gameVideoGridView.setMaxHeight(l.k(this.f62864a.getPageActivity()));
        this.f62867d.setNumColumns(4);
        this.f62867d.setEmptyView(this.f62870g);
        d.b.i0.z0.d.a.b bVar = new d.b.i0.z0.d.a.b(this.f62864a, 102, this.m);
        this.f62868e = bVar;
        this.f62867d.setAdapter((ListAdapter) bVar);
        this.f62867d.setOnItemClickListener(this.p);
        this.f62865b.setOnClickListener(this.q);
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
        d.b.i0.z0.d.f.a aVar = this.f62866c;
        if (aVar != null) {
            return aVar.isShowing();
        }
        return false;
    }

    public void j() {
        RelativeLayout relativeLayout = this.f62869f;
        if (relativeLayout != null) {
            SkinManager.setBackgroundResource(relativeLayout, R.color.CAM_X0201);
        }
        TextView textView = this.i;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
        }
        ImageView imageView = this.f62871h;
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
        GameVideoGridView gameVideoGridView = this.f62867d;
        if (gameVideoGridView != null) {
            gameVideoGridView.d();
        }
    }

    public void l(List<d.b.i0.z0.d.c.a> list) {
        this.f62868e.b(list);
    }

    public void m(f fVar) {
        this.j = fVar;
    }

    public void n(View view) {
        TranslateAnimation translateAnimation;
        if (view == null) {
            return;
        }
        this.f62868e.notifyDataSetChanged();
        if (this.f62866c == null) {
            d.b.i0.z0.d.f.a aVar = new d.b.i0.z0.d.f.a(this.f62864a, this.f62865b, -1, -1);
            this.f62866c = aVar;
            aVar.setBackgroundDrawable(new ColorDrawable(this.f62864a.getResources().getColor(R.color.black_alpha66)));
            this.f62866c.setAnimationStyle(0);
            this.f62866c.b(this.s);
            this.f62866c.setFocusable(true);
            this.f62866c.setOnDismissListener(this.r);
        }
        if (this.f62866c.isShowing()) {
            this.f62866c.dismiss();
        }
        this.f62866c.showAsDropDown(view, 0, 0);
        this.f62867d.e();
        RelativeLayout relativeLayout = this.f62869f;
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
        if (translateAnimation == null || (relativeLayout = this.f62869f) == null || this.n) {
            return;
        }
        relativeLayout.startAnimation(translateAnimation);
    }

    public void p(int i) {
        d.b.i0.z0.d.a.b bVar = this.f62868e;
        if (bVar != null) {
            bVar.c(i);
        }
    }
}
