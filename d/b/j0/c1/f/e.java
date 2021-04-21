package d.b.j0.c1.f;

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
    public TbPageContext<HotTopicActivity> f54013a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f54014b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f54015c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54016d;

    /* renamed from: e  reason: collision with root package name */
    public View f54017e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f54018f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f54019g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f54020h;
    public Animation i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f54021e;

        /* renamed from: d.b.j0.c1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1215a implements Runnable {
            public RunnableC1215a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f54015c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f54015c.startAnimation(e.this.i);
            }
        }

        public a(long j) {
            this.f54021e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f54015c.getAnimation() == e.this.f54019g) {
                e.this.f54015c.clearAnimation();
                return;
            }
            e.this.f54016d.setVisibility(0);
            e.this.f54016d.setText(StringHelper.numFormatOverWan(this.f54021e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f54014b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f54014b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f54018f = (AnimationDrawable) eVar.f54014b.getDrawable();
            e.this.f54018f.start();
            e.this.f54015c.postDelayed(new RunnableC1215a(), 2000L);
            ((HotTopicActivity) e.this.f54013a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f54024e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f54015c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f54015c.startAnimation(e.this.i);
            }
        }

        public b(long j) {
            this.f54024e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f54015c.getAnimation() == e.this.f54019g) {
                e.this.f54015c.clearAnimation();
                return;
            }
            e.this.f54016d.setVisibility(0);
            e.this.f54016d.setText(StringHelper.numFormatOverWan(this.f54024e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f54014b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f54014b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f54018f = (AnimationDrawable) eVar.f54014b.getDrawable();
            e.this.f54018f.start();
            e.this.f54015c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f54013a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f54013a = tbPageContext;
        this.f54014b = (ImageView) view.findViewById(R.id.gif_image);
        this.f54015c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f54016d = (TextView) view.findViewById(R.id.git_desc);
        this.f54017e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f54014b.clearAnimation();
        this.f54015c.clearAnimation();
        Animation animation = this.f54019g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f54020h;
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
        AnimationDrawable animationDrawable = this.f54018f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i, boolean z, long j, int i2) {
        if (this.k) {
            return;
        }
        this.f54015c.setVisibility(i);
        if (i == 8) {
            return;
        }
        this.f54016d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i2 == 1) {
                this.f54016d.setVisibility(0);
                SkinManager.setImageResource(this.f54014b, R.drawable.bless_gif);
            } else {
                this.f54016d.setVisibility(8);
                SkinManager.setImageResource(this.f54014b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f54016d.getLayoutParams()).setMargins(this.f54013a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f54013a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f54016d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f54016d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i2 == 1) {
                this.f54016d.setVisibility(0);
                SkinManager.setImageResource(this.f54014b, R.drawable.candle_gif);
            } else {
                this.f54016d.setVisibility(8);
                SkinManager.setImageResource(this.f54014b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f54016d.getLayoutParams()).setMargins(this.f54013a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f54013a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f54016d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f54016d, R.drawable.pic_float_qifu_num_b);
        }
        if (i2 == 1) {
            this.f54015c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f54014b.getDrawable();
            this.f54018f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f54017e.setOnClickListener(new a(j));
            this.f54015c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f54019g = AnimationUtils.loadAnimation(this.f54013a.getPageActivity(), R.anim.gifview_rotate);
        this.f54020h = AnimationUtils.loadAnimation(this.f54013a.getPageActivity(), R.anim.gifview_rotate_out);
        this.i = AnimationUtils.loadAnimation(this.f54013a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f54013a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i) {
        if (this.k) {
            this.m = i;
            if (this.f54014b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f54015c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f54015c.startAnimation(animation2);
                        this.f54018f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f54015c.getAnimation();
                Animation animation4 = this.i;
                if (animation3 != animation4) {
                    this.f54015c.startAnimation(animation4);
                    this.f54018f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f54015c.getAnimation();
                Animation animation6 = this.f54019g;
                if (animation5 != animation6) {
                    this.f54015c.startAnimation(animation6);
                }
            } else if (this.f54015c.getAnimation() == this.f54019g) {
                this.f54015c.startAnimation(this.f54020h);
            }
        }
    }
}
