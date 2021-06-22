package d.a.o0.r0.o2;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import d.a.i.q;
/* loaded from: classes4.dex */
public class e implements q {

    /* renamed from: f  reason: collision with root package name */
    public NoPressedRelativeLayout f63052f;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f63053g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63054h;
    public final Animation j;
    public final Runnable k;
    public int l = -1;
    public int m = -1;
    public int n = -1;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f63051e = new Handler(new a());

    /* renamed from: i  reason: collision with root package name */
    public final Animation f63055i = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 111) {
                e.this.j();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (e.this.f63054h.getParent() != null) {
                ((ViewGroup) e.this.f63054h.getParent()).removeView(e.this.f63054h);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.e();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.e();
            if (e.this.f63053g == null || e.this.f63053g.w2() || e.this.f63053g.B0() == null) {
                return;
            }
            e.this.f63053g.B0().K1();
        }
    }

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.f63052f = noPressedRelativeLayout;
        this.f63053g = frsFragment;
        Animation loadAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.j = loadAnimation;
        loadAnimation.setAnimationListener(new b());
        this.k = new c();
        f();
    }

    public final void e() {
        if (this.f63054h.getParent() == null) {
            return;
        }
        this.l = -1;
        this.n = -1;
        this.f63051e.removeCallbacks(this.k);
        this.f63054h.clearAnimation();
        this.f63054h.startAnimation(this.j);
    }

    public final void f() {
        TextView textView = new TextView(TbadkCoreApplication.getInst());
        this.f63054h = textView;
        textView.setOnClickListener(new d());
        this.f63054h.setGravity(17);
        this.f63054h.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.f63053g.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.f63053g.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.f63054h.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.f63054h.setTextSize(0, this.f63053g.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        SkinManager.setBackgroundResource(this.f63054h, R.drawable.bg_home_float);
        SkinManager.setViewTextColor(this.f63054h, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.f63053g.h0().getBottom() + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.f63054h.setLayoutParams(layoutParams);
    }

    public void g() {
        this.f63051e.removeCallbacksAndMessages(null);
    }

    public void h(RecyclerView recyclerView, int i2, int i3) {
        this.l = i2;
        this.m = i3;
        if (this.n < 0) {
            this.n = i2;
        }
    }

    public void i(RecyclerView recyclerView, int i2) {
        int i3;
        int i4;
        if (i2 == 0) {
            int i5 = this.l;
            if (i5 > 0 && (i3 = this.m) > 0 && (i4 = this.n) >= 0 && i5 + i3 + 1 < i4) {
                this.f63051e.sendEmptyMessage(111);
            }
            this.n = this.l;
        }
    }

    public final void j() {
        if (this.f63054h.getParent() != null) {
            return;
        }
        this.f63052f.addView(this.f63054h);
        this.f63054h.clearAnimation();
        this.f63054h.startAnimation(this.f63055i);
        this.f63051e.removeCallbacks(this.k);
        this.f63051e.postDelayed(this.k, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        SkinManager.setBackgroundResource(this.f63054h, R.drawable.bg_home_float);
        SkinManager.setViewTextColor(this.f63054h, R.color.CAM_X0302);
    }
}
