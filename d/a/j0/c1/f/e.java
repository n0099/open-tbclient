package d.a.j0.c1.f;

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
    public TbPageContext<HotTopicActivity> f51782a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f51783b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f51784c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51785d;

    /* renamed from: e  reason: collision with root package name */
    public View f51786e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f51787f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f51788g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f51789h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f51790i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f51791e;

        /* renamed from: d.a.j0.c1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1154a implements Runnable {
            public RunnableC1154a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f51784c.getAnimation() == e.this.f51790i) {
                    return;
                }
                e.this.f51784c.startAnimation(e.this.f51790i);
            }
        }

        public a(long j) {
            this.f51791e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f51784c.getAnimation() == e.this.f51788g) {
                e.this.f51784c.clearAnimation();
                return;
            }
            e.this.f51785d.setVisibility(0);
            e.this.f51785d.setText(StringHelper.numFormatOverWan(this.f51791e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f51783b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f51783b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f51787f = (AnimationDrawable) eVar.f51783b.getDrawable();
            e.this.f51787f.start();
            e.this.f51784c.postDelayed(new RunnableC1154a(), 2000L);
            ((HotTopicActivity) e.this.f51782a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f51794e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f51784c.getAnimation() == e.this.f51790i) {
                    return;
                }
                e.this.f51784c.startAnimation(e.this.f51790i);
            }
        }

        public b(long j) {
            this.f51794e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f51784c.getAnimation() == e.this.f51788g) {
                e.this.f51784c.clearAnimation();
                return;
            }
            e.this.f51785d.setVisibility(0);
            e.this.f51785d.setText(StringHelper.numFormatOverWan(this.f51794e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f51783b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f51783b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f51787f = (AnimationDrawable) eVar.f51783b.getDrawable();
            e.this.f51787f.start();
            e.this.f51784c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f51782a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f51782a = tbPageContext;
        this.f51783b = (ImageView) view.findViewById(R.id.gif_image);
        this.f51784c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f51785d = (TextView) view.findViewById(R.id.git_desc);
        this.f51786e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f51783b.clearAnimation();
        this.f51784c.clearAnimation();
        Animation animation = this.f51788g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f51789h;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f51790i;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.j;
        if (animation4 != null) {
            animation4.cancel();
        }
        AnimationDrawable animationDrawable = this.f51787f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i2, boolean z, long j, int i3) {
        if (this.k) {
            return;
        }
        this.f51784c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f51785d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f51785d.setVisibility(0);
                SkinManager.setImageResource(this.f51783b, R.drawable.bless_gif);
            } else {
                this.f51785d.setVisibility(8);
                SkinManager.setImageResource(this.f51783b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f51785d.getLayoutParams()).setMargins(this.f51782a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f51782a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f51785d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f51785d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f51785d.setVisibility(0);
                SkinManager.setImageResource(this.f51783b, R.drawable.candle_gif);
            } else {
                this.f51785d.setVisibility(8);
                SkinManager.setImageResource(this.f51783b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f51785d.getLayoutParams()).setMargins(this.f51782a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f51782a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f51785d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f51785d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f51784c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f51783b.getDrawable();
            this.f51787f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f51786e.setOnClickListener(new a(j));
            this.f51784c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f51788g = AnimationUtils.loadAnimation(this.f51782a.getPageActivity(), R.anim.gifview_rotate);
        this.f51789h = AnimationUtils.loadAnimation(this.f51782a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f51790i = AnimationUtils.loadAnimation(this.f51782a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f51782a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        if (this.k) {
            this.m = i2;
            if (this.f51783b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f51784c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f51784c.startAnimation(animation2);
                        this.f51787f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f51784c.getAnimation();
                Animation animation4 = this.f51790i;
                if (animation3 != animation4) {
                    this.f51784c.startAnimation(animation4);
                    this.f51787f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f51784c.getAnimation();
                Animation animation6 = this.f51788g;
                if (animation5 != animation6) {
                    this.f51784c.startAnimation(animation6);
                }
            } else if (this.f51784c.getAnimation() == this.f51788g) {
                this.f51784c.startAnimation(this.f51789h);
            }
        }
    }
}
