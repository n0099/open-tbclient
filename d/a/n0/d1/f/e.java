package d.a.n0.d1.f;

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
    public TbPageContext<HotTopicActivity> f52661a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f52662b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f52663c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52664d;

    /* renamed from: e  reason: collision with root package name */
    public View f52665e;

    /* renamed from: f  reason: collision with root package name */
    public AnimationDrawable f52666f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f52667g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f52668h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f52669i;
    public Animation j;
    public boolean k = false;
    public boolean l = false;
    public int m = -1;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52670e;

        /* renamed from: d.a.n0.d1.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1243a implements Runnable {
            public RunnableC1243a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52663c.getAnimation() == e.this.f52669i) {
                    return;
                }
                e.this.f52663c.startAnimation(e.this.f52669i);
            }
        }

        public a(long j) {
            this.f52670e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52663c.getAnimation() == e.this.f52667g) {
                e.this.f52663c.clearAnimation();
                return;
            }
            e.this.f52664d.setVisibility(0);
            e.this.f52664d.setText(StringHelper.numFormatOverWan(this.f52670e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52662b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52662b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52666f = (AnimationDrawable) eVar.f52662b.getDrawable();
            e.this.f52666f.start();
            e.this.f52663c.postDelayed(new RunnableC1243a(), 2000L);
            ((HotTopicActivity) e.this.f52661a.getOrignalPage()).sendBlessData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f52673e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.m <= 1 || e.this.f52663c.getAnimation() == e.this.f52669i) {
                    return;
                }
                e.this.f52663c.startAnimation(e.this.f52669i);
            }
        }

        public b(long j) {
            this.f52673e = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f52663c.getAnimation() == e.this.f52667g) {
                e.this.f52663c.clearAnimation();
                return;
            }
            e.this.f52664d.setVisibility(0);
            e.this.f52664d.setText(StringHelper.numFormatOverWan(this.f52673e + 1));
            if (e.this.l) {
                SkinManager.setImageResource(e.this.f52662b, R.drawable.bless_gif);
            } else {
                SkinManager.setImageResource(e.this.f52662b, R.drawable.candle_gif);
            }
            e eVar = e.this;
            eVar.f52666f = (AnimationDrawable) eVar.f52662b.getDrawable();
            e.this.f52666f.start();
            e.this.f52663c.postDelayed(new a(), 2000L);
            ((HotTopicActivity) e.this.f52661a.getOrignalPage()).sendBlessData();
        }
    }

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.f52661a = tbPageContext;
        this.f52662b = (ImageView) view.findViewById(R.id.gif_image);
        this.f52663c = (LinearLayout) view.findViewById(R.id.gif_group);
        this.f52664d = (TextView) view.findViewById(R.id.git_desc);
        this.f52665e = view.findViewById(R.id.gif_clikc_view);
    }

    public void k() {
        this.f52662b.clearAnimation();
        this.f52663c.clearAnimation();
        Animation animation = this.f52667g;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.f52668h;
        if (animation2 != null) {
            animation2.cancel();
        }
        Animation animation3 = this.f52669i;
        if (animation3 != null) {
            animation3.cancel();
        }
        Animation animation4 = this.j;
        if (animation4 != null) {
            animation4.cancel();
        }
        AnimationDrawable animationDrawable = this.f52666f;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void l(int i2, boolean z, long j, int i3) {
        if (this.k) {
            return;
        }
        this.f52663c.setVisibility(i2);
        if (i2 == 8) {
            return;
        }
        this.f52664d.setText(StringHelper.numFormatOverWan(j));
        this.l = z;
        if (z) {
            if (i3 == 1) {
                this.f52664d.setVisibility(0);
                SkinManager.setImageResource(this.f52662b, R.drawable.bless_gif);
            } else {
                this.f52664d.setVisibility(8);
                SkinManager.setImageResource(this.f52662b, R.drawable.pic_float_zhufu);
            }
            ((LinearLayout.LayoutParams) this.f52664d.getLayoutParams()).setMargins(this.f52661a.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.f52661a.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
            SkinManager.setViewTextColor(this.f52664d, R.color.topic_bless_text, 1);
            SkinManager.setBackgroundResource(this.f52664d, R.drawable.pic_float_zhufu_num_b);
        } else {
            if (i3 == 1) {
                this.f52664d.setVisibility(0);
                SkinManager.setImageResource(this.f52662b, R.drawable.candle_gif);
            } else {
                this.f52664d.setVisibility(8);
                SkinManager.setImageResource(this.f52662b, R.drawable.pic_float_qifu);
            }
            ((LinearLayout.LayoutParams) this.f52664d.getLayoutParams()).setMargins(this.f52661a.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.f52661a.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
            SkinManager.setViewTextColor(this.f52664d, R.color.topic_candle_text, 1);
            SkinManager.setBackgroundResource(this.f52664d, R.drawable.pic_float_qifu_num_b);
        }
        if (i3 == 1) {
            this.f52663c.clearAnimation();
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f52662b.getDrawable();
            this.f52666f = animationDrawable;
            animationDrawable.start();
        } else {
            this.f52665e.setOnClickListener(new a(j));
            this.f52663c.setOnClickListener(new b(j));
        }
        this.k = true;
        this.f52667g = AnimationUtils.loadAnimation(this.f52661a.getPageActivity(), R.anim.gifview_rotate);
        this.f52668h = AnimationUtils.loadAnimation(this.f52661a.getPageActivity(), R.anim.gifview_rotate_out);
        this.f52669i = AnimationUtils.loadAnimation(this.f52661a.getPageActivity(), R.anim.gifview_alpha);
        this.j = AnimationUtils.loadAnimation(this.f52661a.getPageActivity(), R.anim.gifview_alpha_visible);
    }

    public void m(int i2) {
        if (this.k) {
            this.m = i2;
            if (this.f52662b.getDrawable() instanceof AnimationDrawable) {
                if (this.m <= 1) {
                    Animation animation = this.f52663c.getAnimation();
                    Animation animation2 = this.j;
                    if (animation != animation2) {
                        this.f52663c.startAnimation(animation2);
                        this.f52666f.start();
                        return;
                    }
                    return;
                }
                Animation animation3 = this.f52663c.getAnimation();
                Animation animation4 = this.f52669i;
                if (animation3 != animation4) {
                    this.f52663c.startAnimation(animation4);
                    this.f52666f.stop();
                }
            } else if (this.m >= 2) {
                Animation animation5 = this.f52663c.getAnimation();
                Animation animation6 = this.f52667g;
                if (animation5 != animation6) {
                    this.f52663c.startAnimation(animation6);
                }
            } else if (this.f52663c.getAnimation() == this.f52667g) {
                this.f52663c.startAnimation(this.f52668h);
            }
        }
    }
}
