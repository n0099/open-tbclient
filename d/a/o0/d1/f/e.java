package d.a.o0.d1.f;

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
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f56475a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56476b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f56477c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56478d;

    /* renamed from: e  reason: collision with root package name */
    public View f56479e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f56480f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f56481g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f56482h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f56483i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f56484e;

        /* renamed from: d.a.o0.d1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1303a implements Runnable {
            public RunnableC1303a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f56477c.getAnimation() == e.this.f56483i) {
                    return;
                }
                e.this.f56477c.startAnimation(e.this.f56483i);
            }
        }

        public a(long j) {
            this.f56484e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f56477c.getAnimation() == e.this.f56481g) {
                e.this.f56477c.clearAnimation();
                return;
            }
            e.this.f56478d.setVisibility(0);
            e.this.f56478d.setText(StringHelper.numFormatOverWan(this.f56484e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f56476b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f56476b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f56480f = (AnimationDrawable) eVar.f56476b.getDrawable();
            e.this.f56480f.start();
            e.this.f56477c.postDelayed(new RunnableC1303a(), 2000L);
            ((HotTopicActivity) e.this.f56475a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f56487e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f56477c.getAnimation() == e.this.f56483i) {
                    return;
                }
                e.this.f56477c.startAnimation(e.this.f56483i);
            }
        }

        public b(long j) {
            this.f56487e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f56477c.getAnimation() == e.this.f56481g) {
                e.this.f56477c.clearAnimation();
                return;
            }
            e.this.f56478d.setVisibility(0);
            e.this.f56478d.setText(StringHelper.numFormatOverWan(this.f56487e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f56476b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f56476b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f56480f = (AnimationDrawable) eVar.f56476b.getDrawable();
            e.this.f56480f.start();
            e.this.f56477c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f56475a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f56475a = tbPageContext;
        this.f56476b = (ImageView) view.findViewById(R.id.gif_image);
        this.f56477c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f56478d = (TextView) view.findViewById(R.id.git_desc);
        this.f56479e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f56476b.clearAnimation();
        this.f56477c.clearAnimation();
        Animation animation = this.f56481g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f56482h;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f56483i;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.j;
        if (animation4 != null) {
            animation4.cancel();
        }
        AnimationDrawable animationDrawable = this.f56480f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i2, boolean z, long j, int i3) {
        if (this.k) {
            return;
        }
        this.f56477c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f56478d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f56478d.setVisibility(0);
                SkinManager.setImageResource(this.f56476b, R.drawable.bless_gif);
            } else {
                this.f56478d.setVisibility(8);
                SkinManager.setImageResource(this.f56476b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f56478d.getLayoutParams()).setMargins(this.f56475a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f56475a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f56478d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f56478d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f56478d.setVisibility(0);
                SkinManager.setImageResource(this.f56476b, R.drawable.candle_gif);
            } else {
                this.f56478d.setVisibility(8);
                SkinManager.setImageResource(this.f56476b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f56478d.getLayoutParams()).setMargins(this.f56475a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f56475a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f56478d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f56478d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f56477c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f56476b.getDrawable();
            this.f56480f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f56479e.setOnClickListener(new a(j));
            this.f56477c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f56481g = AnimationUtils.loadAnimation(this.f56475a.getPageActivity(), R.anim.gifview_rotate);
        this.f56482h = AnimationUtils.loadAnimation(this.f56475a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f56483i = AnimationUtils.loadAnimation(this.f56475a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f56475a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        if (this.k) {
            this.m = i2;
            if (this.f56476b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f56477c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f56477c.startAnimation(animation2);
                        this.f56480f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f56477c.getAnimation();
                Animation animation4 = this.f56483i;
                if (animation3 != animation4) {
                    this.f56477c.startAnimation(animation4);
                    this.f56480f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f56477c.getAnimation();
                Animation animation6 = this.f56481g;
                if (animation5 != animation6) {
                    this.f56477c.startAnimation(animation6);
                }
            } else if (this.f56477c.getAnimation() == this.f56481g) {
                this.f56477c.startAnimation(this.f56482h);
            }
        }
    }
}
