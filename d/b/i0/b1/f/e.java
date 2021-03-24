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
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<HotTopicActivity> f52190a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f52191b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f52192c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52193d;

    /* renamed from: e  reason: collision with root package name */
    public View f52194e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f52195f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f52196g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f52197h;
    public Animation i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52198e;

        /* renamed from: d.b.i0.b1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1132a implements Runnable {
            public RunnableC1132a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52192c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f52192c.startAnimation(e.this.i);
            }
        }

        public a(long j) {
            this.f52198e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52192c.getAnimation() == e.this.f52196g) {
                e.this.f52192c.clearAnimation();
                return;
            }
            e.this.f52193d.setVisibility(0);
            e.this.f52193d.setText(StringHelper.numFormatOverWan(this.f52198e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52191b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52191b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52195f = (AnimationDrawable) eVar.f52191b.getDrawable();
            e.this.f52195f.start();
            e.this.f52192c.postDelayed(new RunnableC1132a(), 2000L);
            ((HotTopicActivity) e.this.f52190a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52201e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52192c.getAnimation() == e.this.i) {
                    return;
                }
                e.this.f52192c.startAnimation(e.this.i);
            }
        }

        public b(long j) {
            this.f52201e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52192c.getAnimation() == e.this.f52196g) {
                e.this.f52192c.clearAnimation();
                return;
            }
            e.this.f52193d.setVisibility(0);
            e.this.f52193d.setText(StringHelper.numFormatOverWan(this.f52201e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52191b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52191b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52195f = (AnimationDrawable) eVar.f52191b.getDrawable();
            e.this.f52195f.start();
            e.this.f52192c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f52190a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f52190a = tbPageContext;
        this.f52191b = (ImageView) view.findViewById(R.id.gif_image);
        this.f52192c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f52193d = (TextView) view.findViewById(R.id.git_desc);
        this.f52194e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f52191b.clearAnimation();
        this.f52192c.clearAnimation();
        Animation animation = this.f52196g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f52197h;
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
        AnimationDrawable animationDrawable = this.f52195f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i, boolean z, long j, int i2) {
        if (this.k) {
            return;
        }
        this.f52192c.setVisibility(i);
        if (i == 8) {
            return;
        }
        this.f52193d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i2 == 1) {
                this.f52193d.setVisibility(0);
                SkinManager.setImageResource(this.f52191b, R.drawable.bless_gif);
            } else {
                this.f52193d.setVisibility(8);
                SkinManager.setImageResource(this.f52191b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f52193d.getLayoutParams()).setMargins(this.f52190a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f52190a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f52193d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f52193d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i2 == 1) {
                this.f52193d.setVisibility(0);
                SkinManager.setImageResource(this.f52191b, R.drawable.candle_gif);
            } else {
                this.f52193d.setVisibility(8);
                SkinManager.setImageResource(this.f52191b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f52193d.getLayoutParams()).setMargins(this.f52190a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f52190a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f52193d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f52193d, R.drawable.pic_float_qifu_num_b);
        }
        if (i2 == 1) {
            this.f52192c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f52191b.getDrawable();
            this.f52195f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f52194e.setOnClickListener(new a(j));
            this.f52192c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f52196g = AnimationUtils.loadAnimation(this.f52190a.getPageActivity(), R.anim.gifview_rotate);
        this.f52197h = AnimationUtils.loadAnimation(this.f52190a.getPageActivity(), R.anim.gifview_rotate_out);
        this.i = AnimationUtils.loadAnimation(this.f52190a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f52190a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i) {
        if (this.k) {
            this.m = i;
            if (this.f52191b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f52192c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f52192c.startAnimation(animation2);
                        this.f52195f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f52192c.getAnimation();
                Animation animation4 = this.i;
                if (animation3 != animation4) {
                    this.f52192c.startAnimation(animation4);
                    this.f52195f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f52192c.getAnimation();
                Animation animation6 = this.f52196g;
                if (animation5 != animation6) {
                    this.f52192c.startAnimation(animation6);
                }
            } else if (this.f52192c.getAnimation() == this.f52196g) {
                this.f52192c.startAnimation(this.f52197h);
            }
        }
    }
}
