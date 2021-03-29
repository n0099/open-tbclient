package d.b.i0.p0.n2;

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
import d.b.i.q;
/* loaded from: classes4.dex */
public class e implements q {

    /* renamed from: f  reason: collision with root package name */
    public NoPressedRelativeLayout f58149f;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f58150g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58151h;
    public final Animation j;
    public final Runnable k;
    public int l = -1;
    public int m = -1;
    public int n = -1;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f58148e = new Handler(new a());
    public final Animation i = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);

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
            if (e.this.f58151h.getParent() != null) {
                ((ViewGroup) e.this.f58151h.getParent()).removeView(e.this.f58151h);
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
            if (e.this.f58150g == null || e.this.f58150g.u2() || e.this.f58150g.x0() == null) {
                return;
            }
            e.this.f58150g.x0().K1();
        }
    }

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        this.f58149f = noPressedRelativeLayout;
        this.f58150g = frsFragment;
        Animation loadAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.j = loadAnimation;
        loadAnimation.setAnimationListener(new b());
        this.k = new c();
        f();
    }

    public final void e() {
        if (this.f58151h.getParent() == null) {
            return;
        }
        this.l = -1;
        this.n = -1;
        this.f58148e.removeCallbacks(this.k);
        this.f58151h.clearAnimation();
        this.f58151h.startAnimation(this.j);
    }

    public final void f() {
        TextView textView = new TextView(TbadkCoreApplication.getInst());
        this.f58151h = textView;
        textView.setOnClickListener(new d());
        this.f58151h.setGravity(17);
        this.f58151h.setText(R.string.frs_game_refresh_tip_text);
        int dimensionPixelSize = this.f58150g.getResources().getDimensionPixelSize(R.dimen.ds20);
        int dimensionPixelSize2 = this.f58150g.getResources().getDimensionPixelSize(R.dimen.ds40);
        this.f58151h.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        this.f58151h.setTextSize(0, this.f58150g.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        SkinManager.setBackgroundResource(this.f58151h, R.drawable.bg_home_float);
        SkinManager.setViewTextColor(this.f58151h, R.color.CAM_X0302);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.f58150g.Q().getBottom() + d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
        this.f58151h.setLayoutParams(layoutParams);
    }

    public void g() {
        this.f58148e.removeCallbacksAndMessages(null);
    }

    public void h(RecyclerView recyclerView, int i, int i2) {
        this.l = i;
        this.m = i2;
        if (this.n < 0) {
            this.n = i;
        }
    }

    public void i(RecyclerView recyclerView, int i) {
        int i2;
        int i3;
        if (i == 0) {
            int i4 = this.l;
            if (i4 > 0 && (i2 = this.m) > 0 && (i3 = this.n) >= 0 && i4 + i2 + 1 < i3) {
                this.f58148e.sendEmptyMessage(111);
            }
            this.n = this.l;
        }
    }

    public final void j() {
        if (this.f58151h.getParent() != null) {
            return;
        }
        this.f58149f.addView(this.f58151h);
        this.f58151h.clearAnimation();
        this.f58151h.startAnimation(this.i);
        this.f58148e.removeCallbacks(this.k);
        this.f58148e.postDelayed(this.k, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SkinManager.setBackgroundResource(this.f58151h, R.drawable.bg_home_float);
        SkinManager.setViewTextColor(this.f58151h, R.color.CAM_X0302);
    }
}
