package d.b.i0.b1.f;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f52191a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f52192b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f52193c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52194d;

    /* renamed from: e  reason: collision with root package name */
    public View f52195e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f52196f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f52197g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f52198h;
    public Animation i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52199e;

        /* renamed from: d.b.i0.b1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1133a implements Runnable {
            public RunnableC1133a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52193c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f52193c.startAnimation(e.this.i);
            }
        }

        public a(long j) {
            this.f52199e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52193c.getAnimation() == e.this.f52197g) {
                e.this.f52193c.clearAnimation();
                return;
            }
            e.this.f52194d.setVisibility(0);
            e.this.f52194d.setText(StringHelper.numFormatOverWan(this.f52199e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52192b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52192b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52196f = (AnimationDrawable) eVar.f52192b.getDrawable();
            e.this.f52196f.start();
            e.this.f52193c.postDelayed(new RunnableC1133a(), 2000L);
            ((HotTopicActivity) e.this.f52191a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52202e;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52193c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f52193c.startAnimation(e.this.i);
            }
        }

        public b(long j) {
            this.f52202e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52193c.getAnimation() == e.this.f52197g) {
                e.this.f52193c.clearAnimation();
                return;
            }
            e.this.f52194d.setVisibility(0);
            e.this.f52194d.setText(StringHelper.numFormatOverWan(this.f52202e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52192b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52192b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52196f = (AnimationDrawable) eVar.f52192b.getDrawable();
            e.this.f52196f.start();
            e.this.f52193c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f52191a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f52191a = tbPageContext;
        this.f52192b = (ImageView) view.findViewById(R.id.gif_image);
        this.f52193c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f52194d = (TextView) view.findViewById(R.id.git_desc);
        this.f52195e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f52192b.clearAnimation();
        this.f52193c.clearAnimation();
        Animation animation = this.f52197g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f52198h;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.i;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.j;
        if (animation4 != null) {
            animation4.cancel();
        }
        AnimationDrawable animationDrawable = this.f52196f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i, boolean z, long j, int i2) {
        if (this.k) {
            return;
        }
        this.f52193c.setVisibility(i);
        if (i == 8) {
            return;
        }
        this.f52194d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i2 == 1) {
                this.f52194d.setVisibility(0);
                SkinManager.setImageResource(this.f52192b, R.drawable.bless_gif);
            } else {
                this.f52194d.setVisibility(8);
                SkinManager.setImageResource(this.f52192b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f52194d.getLayoutParams()).setMargins(this.f52191a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f52191a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f52194d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f52194d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i2 == 1) {
                this.f52194d.setVisibility(0);
                SkinManager.setImageResource(this.f52192b, R.drawable.candle_gif);
            } else {
                this.f52194d.setVisibility(8);
                SkinManager.setImageResource(this.f52192b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f52194d.getLayoutParams()).setMargins(this.f52191a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f52191a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f52194d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f52194d, R.drawable.pic_float_qifu_num_b);
        }
        if (i2 == 1) {
            this.f52193c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f52192b.getDrawable();
            this.f52196f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f52195e.setOnClickListener(new a(j));
            this.f52193c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f52197g = AnimationUtils.loadAnimation(this.f52191a.getPageActivity(), R.anim.gifview_rotate);
        this.f52198h = AnimationUtils.loadAnimation(this.f52191a.getPageActivity(), R.anim.gifview_rotate_out);
        this.i = AnimationUtils.loadAnimation(this.f52191a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f52191a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i) {
        if (this.k) {
            this.m = i;
            if (this.f52192b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f52193c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f52193c.startAnimation(animation2);
                        this.f52196f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f52193c.getAnimation();
                Animation animation4 = this.i;
                if (animation3 != animation4) {
                    this.f52193c.startAnimation(animation4);
                    this.f52196f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f52193c.getAnimation();
                Animation animation6 = this.f52197g;
                if (animation5 != animation6) {
                    this.f52193c.startAnimation(animation6);
                }
            } else if (this.f52193c.getAnimation() == this.f52197g) {
                this.f52193c.startAnimation(this.f52198h);
            }
        }
    }
}
