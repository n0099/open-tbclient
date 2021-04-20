package d.b.i0.c1.f;

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
    public TbPageContext<HotTopicActivity> f53592a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f53593b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f53594c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53595d;

    /* renamed from: e  reason: collision with root package name */
    public View f53596e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f53597f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f53598g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f53599h;
    public Animation i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f53600e;

        /* renamed from: d.b.i0.c1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1192a implements Runnable {
            public RunnableC1192a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f53594c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f53594c.startAnimation(e.this.i);
            }
        }

        public a(long j) {
            this.f53600e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f53594c.getAnimation() == e.this.f53598g) {
                e.this.f53594c.clearAnimation();
                return;
            }
            e.this.f53595d.setVisibility(0);
            e.this.f53595d.setText(StringHelper.numFormatOverWan(this.f53600e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f53593b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f53593b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f53597f = (AnimationDrawable) eVar.f53593b.getDrawable();
            e.this.f53597f.start();
            e.this.f53594c.postDelayed(new RunnableC1192a(), 2000L);
            ((HotTopicActivity) e.this.f53592a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f53603e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f53594c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f53594c.startAnimation(e.this.i);
            }
        }

        public b(long j) {
            this.f53603e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f53594c.getAnimation() == e.this.f53598g) {
                e.this.f53594c.clearAnimation();
                return;
            }
            e.this.f53595d.setVisibility(0);
            e.this.f53595d.setText(StringHelper.numFormatOverWan(this.f53603e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f53593b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f53593b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f53597f = (AnimationDrawable) eVar.f53593b.getDrawable();
            e.this.f53597f.start();
            e.this.f53594c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f53592a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f53592a = tbPageContext;
        this.f53593b = (ImageView) view.findViewById(R.id.gif_image);
        this.f53594c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f53595d = (TextView) view.findViewById(R.id.git_desc);
        this.f53596e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f53593b.clearAnimation();
        this.f53594c.clearAnimation();
        Animation animation = this.f53598g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f53599h;
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
        AnimationDrawable animationDrawable = this.f53597f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i, boolean z, long j, int i2) {
        if (this.k) {
            return;
        }
        this.f53594c.setVisibility(i);
        if (i == 8) {
            return;
        }
        this.f53595d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i2 == 1) {
                this.f53595d.setVisibility(0);
                SkinManager.setImageResource(this.f53593b, R.drawable.bless_gif);
            } else {
                this.f53595d.setVisibility(8);
                SkinManager.setImageResource(this.f53593b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f53595d.getLayoutParams()).setMargins(this.f53592a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f53592a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f53595d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f53595d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i2 == 1) {
                this.f53595d.setVisibility(0);
                SkinManager.setImageResource(this.f53593b, R.drawable.candle_gif);
            } else {
                this.f53595d.setVisibility(8);
                SkinManager.setImageResource(this.f53593b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f53595d.getLayoutParams()).setMargins(this.f53592a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f53592a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f53595d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f53595d, R.drawable.pic_float_qifu_num_b);
        }
        if (i2 == 1) {
            this.f53594c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f53593b.getDrawable();
            this.f53597f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f53596e.setOnClickListener(new a(j));
            this.f53594c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f53598g = AnimationUtils.loadAnimation(this.f53592a.getPageActivity(), R.anim.gifview_rotate);
        this.f53599h = AnimationUtils.loadAnimation(this.f53592a.getPageActivity(), R.anim.gifview_rotate_out);
        this.i = AnimationUtils.loadAnimation(this.f53592a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f53592a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i) {
        if (this.k) {
            this.m = i;
            if (this.f53593b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f53594c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f53594c.startAnimation(animation2);
                        this.f53597f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f53594c.getAnimation();
                Animation animation4 = this.i;
                if (animation3 != animation4) {
                    this.f53594c.startAnimation(animation4);
                    this.f53597f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f53594c.getAnimation();
                Animation animation6 = this.f53598g;
                if (animation5 != animation6) {
                    this.f53594c.startAnimation(animation6);
                }
            } else if (this.f53594c.getAnimation() == this.f53598g) {
                this.f53594c.startAnimation(this.f53599h);
            }
        }
    }
}
