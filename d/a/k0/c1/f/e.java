package d.a.k0.c1.f;

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
    public TbPageContext<HotTopicActivity> f52481a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f52482b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f52483c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52484d;

    /* renamed from: e  reason: collision with root package name */
    public View f52485e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f52486f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f52487g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f52488h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f52489i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52490e;

        /* renamed from: d.a.k0.c1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1226a implements Runnable {
            public RunnableC1226a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52483c.getAnimation() == e.this.f52489i) {
                    return;
                }
                e.this.f52483c.startAnimation(e.this.f52489i);
            }
        }

        public a(long j) {
            this.f52490e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52483c.getAnimation() == e.this.f52487g) {
                e.this.f52483c.clearAnimation();
                return;
            }
            e.this.f52484d.setVisibility(0);
            e.this.f52484d.setText(StringHelper.numFormatOverWan(this.f52490e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52482b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52482b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52486f = (AnimationDrawable) eVar.f52482b.getDrawable();
            e.this.f52486f.start();
            e.this.f52483c.postDelayed(new RunnableC1226a(), 2000L);
            ((HotTopicActivity) e.this.f52481a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52493e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52483c.getAnimation() == e.this.f52489i) {
                    return;
                }
                e.this.f52483c.startAnimation(e.this.f52489i);
            }
        }

        public b(long j) {
            this.f52493e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52483c.getAnimation() == e.this.f52487g) {
                e.this.f52483c.clearAnimation();
                return;
            }
            e.this.f52484d.setVisibility(0);
            e.this.f52484d.setText(StringHelper.numFormatOverWan(this.f52493e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52482b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52482b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52486f = (AnimationDrawable) eVar.f52482b.getDrawable();
            e.this.f52486f.start();
            e.this.f52483c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f52481a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f52481a = tbPageContext;
        this.f52482b = (ImageView) view.findViewById(R.id.gif_image);
        this.f52483c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f52484d = (TextView) view.findViewById(R.id.git_desc);
        this.f52485e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f52482b.clearAnimation();
        this.f52483c.clearAnimation();
        Animation animation = this.f52487g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f52488h;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f52489i;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.j;
        if (animation4 != null) {
            animation4.cancel();
        }
        AnimationDrawable animationDrawable = this.f52486f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i2, boolean z, long j, int i3) {
        if (this.k) {
            return;
        }
        this.f52483c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f52484d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f52484d.setVisibility(0);
                SkinManager.setImageResource(this.f52482b, R.drawable.bless_gif);
            } else {
                this.f52484d.setVisibility(8);
                SkinManager.setImageResource(this.f52482b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f52484d.getLayoutParams()).setMargins(this.f52481a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f52481a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f52484d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f52484d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f52484d.setVisibility(0);
                SkinManager.setImageResource(this.f52482b, R.drawable.candle_gif);
            } else {
                this.f52484d.setVisibility(8);
                SkinManager.setImageResource(this.f52482b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f52484d.getLayoutParams()).setMargins(this.f52481a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f52481a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f52484d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f52484d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f52483c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f52482b.getDrawable();
            this.f52486f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f52485e.setOnClickListener(new a(j));
            this.f52483c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f52487g = AnimationUtils.loadAnimation(this.f52481a.getPageActivity(), R.anim.gifview_rotate);
        this.f52488h = AnimationUtils.loadAnimation(this.f52481a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f52489i = AnimationUtils.loadAnimation(this.f52481a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f52481a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        if (this.k) {
            this.m = i2;
            if (this.f52482b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f52483c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f52483c.startAnimation(animation2);
                        this.f52486f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f52483c.getAnimation();
                Animation animation4 = this.f52489i;
                if (animation3 != animation4) {
                    this.f52483c.startAnimation(animation4);
                    this.f52486f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f52483c.getAnimation();
                Animation animation6 = this.f52487g;
                if (animation5 != animation6) {
                    this.f52483c.startAnimation(animation6);
                }
            } else if (this.f52483c.getAnimation() == this.f52487g) {
                this.f52483c.startAnimation(this.f52488h);
            }
        }
    }
}
