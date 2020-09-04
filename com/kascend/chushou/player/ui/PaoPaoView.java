package com.kascend.chushou.player.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.kascend.chushou.a;
import com.kascend.chushou.player.ui.pk.CustomCircle;
import com.kascend.chushou.player.ui.pk.b;
import com.kascend.chushou.player.ui.pk.g;
import com.kascend.chushou.player.ui.pk.h;
import com.kascend.chushou.player.ui.pk.i;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
/* loaded from: classes6.dex */
public class PaoPaoView extends FrameLayout implements b {
    final Queue<WeakReference<ImageView>> a;
    private final Object c;
    private boolean d;
    private ImageView e;
    private ImageView f;
    private float g;
    private float h;
    private List<CustomCircle> k;
    private List<CustomCircle> l;
    private int m;
    private int n;
    final Queue<WeakReference<ImageView>> nSb;
    private Random nSc;
    private i<PaoPaoView> nSd;
    private final int o;
    private final int p;

    public PaoPaoView(Context context) {
        this(context, null);
    }

    public PaoPaoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaoPaoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayDeque();
        this.nSb = new ArrayDeque();
        this.c = new Object();
        this.d = false;
        this.g = tv.chushou.zues.utils.a.dip2px(getContext(), 188.0f);
        this.h = tv.chushou.zues.utils.a.dip2px(getContext(), 220.0f);
        this.nSc = new Random();
        this.nSd = new i<>(this);
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.o = 0;
        this.p = 1;
    }

    public void a() {
        synchronized (this.c) {
            if (!this.d) {
                setVisibility(0);
                this.d = true;
                e();
                f();
            }
        }
    }

    private void e() {
        d();
        if (this.l != null && this.l.size() > 0) {
            for (int i = 0; i < this.l.size(); i++) {
                int randDelayTime = getRandDelayTime();
                if (this.nSd != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = Integer.valueOf(i);
                    obtain.what = 1;
                    this.nSd.sendMessageDelayed(obtain, randDelayTime);
                }
            }
        }
        if (this.nSd != null) {
            this.nSd.sendEmptyMessageDelayed(0, 10000L);
        }
    }

    private void f() {
        List<CustomCircle> smallAnimationList = getSmallAnimationList();
        if (smallAnimationList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < smallAnimationList.size()) {
                    a(smallAnimationList.get(i2), smallAnimationList.get(i2 + 1), smallAnimationList.get(i2 + 2));
                    i = i2 + 3;
                } else {
                    return;
                }
            }
        }
    }

    private List<CustomCircle> getSmallAnimationList() {
        ArrayList arrayList = new ArrayList();
        CustomCircle customCircle = new CustomCircle();
        CustomCircle customCircle2 = new CustomCircle();
        CustomCircle customCircle3 = new CustomCircle();
        customCircle.a = tv.chushou.zues.utils.a.dip2px(getContext(), 39.5f);
        customCircle.b = tv.chushou.zues.utils.a.dip2px(getContext(), 249.5f);
        customCircle2.a = tv.chushou.zues.utils.a.dip2px(getContext(), 72.5f);
        customCircle2.b = tv.chushou.zues.utils.a.dip2px(getContext(), 268.5f);
        customCircle3.a = tv.chushou.zues.utils.a.dip2px(getContext(), 40.0f);
        customCircle3.b = tv.chushou.zues.utils.a.dip2px(getContext(), 188.0f);
        CustomCircle customCircle4 = new CustomCircle();
        CustomCircle customCircle5 = new CustomCircle();
        CustomCircle customCircle6 = new CustomCircle();
        customCircle4.a = tv.chushou.zues.utils.a.dip2px(getContext(), 323.5f);
        customCircle4.b = tv.chushou.zues.utils.a.dip2px(getContext(), 209.5f);
        customCircle5.a = tv.chushou.zues.utils.a.dip2px(getContext(), 345.5f);
        customCircle5.b = tv.chushou.zues.utils.a.dip2px(getContext(), 184.5f);
        customCircle6.a = tv.chushou.zues.utils.a.dip2px(getContext(), 274.0f);
        customCircle6.b = tv.chushou.zues.utils.a.dip2px(getContext(), 247.0f);
        CustomCircle customCircle7 = new CustomCircle();
        CustomCircle customCircle8 = new CustomCircle();
        CustomCircle customCircle9 = new CustomCircle();
        customCircle7.a = tv.chushou.zues.utils.a.dip2px(getContext(), 275.5f);
        customCircle7.b = tv.chushou.zues.utils.a.dip2px(getContext(), 161.5f);
        customCircle8.a = tv.chushou.zues.utils.a.dip2px(getContext(), 286.0f);
        customCircle8.b = tv.chushou.zues.utils.a.dip2px(getContext(), 121.0f);
        customCircle9.a = tv.chushou.zues.utils.a.dip2px(getContext(), 241.5f);
        customCircle9.b = tv.chushou.zues.utils.a.dip2px(getContext(), 83.0f);
        CustomCircle customCircle10 = new CustomCircle();
        CustomCircle customCircle11 = new CustomCircle();
        CustomCircle customCircle12 = new CustomCircle();
        customCircle10.a = tv.chushou.zues.utils.a.dip2px(getContext(), 69.5f);
        customCircle10.b = tv.chushou.zues.utils.a.dip2px(getContext(), 133.5f);
        customCircle11.a = tv.chushou.zues.utils.a.dip2px(getContext(), 85.5f);
        customCircle11.b = tv.chushou.zues.utils.a.dip2px(getContext(), 162.5f);
        customCircle12.a = tv.chushou.zues.utils.a.dip2px(getContext(), 159.5f);
        customCircle12.b = tv.chushou.zues.utils.a.dip2px(getContext(), 125.0f);
        CustomCircle customCircle13 = new CustomCircle();
        CustomCircle customCircle14 = new CustomCircle();
        CustomCircle customCircle15 = new CustomCircle();
        customCircle13.a = tv.chushou.zues.utils.a.dip2px(getContext(), 183.5f);
        customCircle13.b = tv.chushou.zues.utils.a.dip2px(getContext(), 135.5f);
        customCircle14.a = tv.chushou.zues.utils.a.dip2px(getContext(), 161.5f);
        customCircle14.b = tv.chushou.zues.utils.a.dip2px(getContext(), 120.5f);
        customCircle15.a = tv.chushou.zues.utils.a.dip2px(getContext(), 205.0f);
        customCircle15.b = tv.chushou.zues.utils.a.dip2px(getContext(), 180.0f);
        CustomCircle customCircle16 = new CustomCircle();
        CustomCircle customCircle17 = new CustomCircle();
        CustomCircle customCircle18 = new CustomCircle();
        customCircle16.a = tv.chushou.zues.utils.a.dip2px(getContext(), 283.5f);
        customCircle16.b = tv.chushou.zues.utils.a.dip2px(getContext(), 257.5f);
        customCircle17.a = tv.chushou.zues.utils.a.dip2px(getContext(), 304.0f);
        customCircle17.b = tv.chushou.zues.utils.a.dip2px(getContext(), 278.5f);
        customCircle18.a = tv.chushou.zues.utils.a.dip2px(getContext(), 208.5f);
        customCircle18.b = tv.chushou.zues.utils.a.dip2px(getContext(), 332.0f);
        CustomCircle customCircle19 = new CustomCircle();
        CustomCircle customCircle20 = new CustomCircle();
        CustomCircle customCircle21 = new CustomCircle();
        customCircle19.a = tv.chushou.zues.utils.a.dip2px(getContext(), 237.5f);
        customCircle19.b = tv.chushou.zues.utils.a.dip2px(getContext(), 337.5f);
        customCircle20.a = tv.chushou.zues.utils.a.dip2px(getContext(), 244.5f);
        customCircle20.b = tv.chushou.zues.utils.a.dip2px(getContext(), 316.5f);
        customCircle21.a = tv.chushou.zues.utils.a.dip2px(getContext(), 333.0f);
        customCircle21.b = tv.chushou.zues.utils.a.dip2px(getContext(), 293.5f);
        CustomCircle customCircle22 = new CustomCircle();
        CustomCircle customCircle23 = new CustomCircle();
        CustomCircle customCircle24 = new CustomCircle();
        customCircle22.a = tv.chushou.zues.utils.a.dip2px(getContext(), 125.5f);
        customCircle22.b = tv.chushou.zues.utils.a.dip2px(getContext(), 313.5f);
        customCircle23.a = tv.chushou.zues.utils.a.dip2px(getContext(), 84.0f);
        customCircle23.b = tv.chushou.zues.utils.a.dip2px(getContext(), 336.5f);
        customCircle24.a = tv.chushou.zues.utils.a.dip2px(getContext(), 44.6f);
        customCircle24.b = tv.chushou.zues.utils.a.dip2px(getContext(), 279.5f);
        arrayList.add(customCircle);
        arrayList.add(customCircle2);
        arrayList.add(customCircle3);
        arrayList.add(customCircle4);
        arrayList.add(customCircle5);
        arrayList.add(customCircle6);
        arrayList.add(customCircle7);
        arrayList.add(customCircle8);
        arrayList.add(customCircle9);
        arrayList.add(customCircle10);
        arrayList.add(customCircle11);
        arrayList.add(customCircle12);
        arrayList.add(customCircle13);
        arrayList.add(customCircle14);
        arrayList.add(customCircle15);
        arrayList.add(customCircle16);
        arrayList.add(customCircle17);
        arrayList.add(customCircle18);
        arrayList.add(customCircle19);
        arrayList.add(customCircle20);
        arrayList.add(customCircle21);
        arrayList.add(customCircle22);
        arrayList.add(customCircle23);
        arrayList.add(customCircle24);
        return arrayList;
    }

    public void a(CustomCircle customCircle, CustomCircle customCircle2) {
        ImageView imageView;
        if (customCircle != null && customCircle2 != null) {
            setVisibility(0);
            while (true) {
                if (this.a.isEmpty()) {
                    imageView = null;
                    break;
                }
                WeakReference<ImageView> poll = this.a.poll();
                if (poll != null && poll.get() != null) {
                    imageView = poll.get();
                    if (imageView.getParent() != null) {
                        ((ViewGroup) imageView.getParent()).removeView(imageView);
                    }
                }
            }
            int dip2px = tv.chushou.zues.utils.a.dip2px(getContext(), 16.0f);
            if (imageView == null) {
                imageView = new ImageView(getContext());
                imageView.setLayoutParams(new FrameLayout.LayoutParams(dip2px, dip2px));
            }
            imageView.setImageResource(a.e.icon_live_online_voice_live_animation_icon);
            int i = (int) customCircle.a;
            int i2 = (int) customCircle.b;
            tv.chushou.zues.toolkit.d.b.setX(imageView, i);
            tv.chushou.zues.toolkit.d.b.setY(imageView, i2);
            addView(imageView);
            PointF pointF = new PointF();
            pointF.x = (int) customCircle.a;
            pointF.y = (int) customCircle.b;
            PointF pointF2 = new PointF();
            pointF2.x = (int) customCircle2.a;
            pointF2.y = (int) customCircle2.b;
            ValueAnimator ofObject = ValueAnimator.ofObject(new com.kascend.chushou.player.ui.pk.a(pointF, pointF2), new PointF(i, i2), new PointF((int) customCircle2.a, (int) customCircle2.b));
            ofObject.addUpdateListener(new h(imageView) { // from class: com.kascend.chushou.player.ui.PaoPaoView.1
                @Override // com.kascend.chushou.player.ui.pk.h, android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    super.onAnimationUpdate(valueAnimator);
                    if (this.b != null) {
                        ImageView imageView2 = (ImageView) this.b;
                        PointF pointF3 = (PointF) valueAnimator.getAnimatedValue();
                        tv.chushou.zues.toolkit.d.b.setX(imageView2, pointF3.x);
                        tv.chushou.zues.toolkit.d.b.setY(imageView2, pointF3.y);
                    }
                }
            });
            ofObject.setDuration(14000L);
            float randScale = getRandScale();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, randScale);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, randScale);
            ofFloat2.setDuration(0L);
            ofFloat3.setDuration(0L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(14000L);
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.play(ofObject).with(ofFloat).with(ofFloat2).with(ofFloat3);
            animatorSet.setTarget(imageView);
            this.e = imageView;
            animatorSet.addListener(new g(imageView) { // from class: com.kascend.chushou.player.ui.PaoPaoView.2
                private void a() {
                    if (this.e != null) {
                        ImageView imageView2 = (ImageView) this.e;
                        PaoPaoView.this.removeView(imageView2);
                        PaoPaoView.this.a.offer(new WeakReference<>(imageView2));
                        if (PaoPaoView.this.e == imageView2) {
                            PaoPaoView.this.e = null;
                        }
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a();
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a();
                }
            });
            animatorSet.start();
        }
    }

    public void a(CustomCircle customCircle, CustomCircle customCircle2, CustomCircle customCircle3) {
        ImageView imageView;
        if (customCircle != null && customCircle2 != null && customCircle3 != null) {
            setVisibility(0);
            while (true) {
                if (this.nSb.isEmpty()) {
                    imageView = null;
                    break;
                }
                WeakReference<ImageView> poll = this.nSb.poll();
                if (poll != null && poll.get() != null) {
                    imageView = poll.get();
                    if (imageView.getParent() != null) {
                        ((ViewGroup) imageView.getParent()).removeView(imageView);
                    }
                }
            }
            int dip2px = tv.chushou.zues.utils.a.dip2px(getContext(), 16.0f);
            if (imageView == null) {
                imageView = new ImageView(getContext());
            }
            imageView.setImageResource(a.e.icon_live_online_voice_live_animation_small_icon);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dip2px, dip2px);
            layoutParams.leftMargin = (int) customCircle.a;
            layoutParams.topMargin = (int) customCircle.b;
            addView(imageView, layoutParams);
            int i = (int) (customCircle2.a - customCircle.a);
            int i2 = (int) (customCircle2.b - customCircle.b);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", 0.0f, i, (int) (customCircle3.a - customCircle.a), i, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "translationY", 0.0f, i2, (int) (customCircle3.b - customCircle.b), i2, 0.0f);
            ofFloat.setDuration(50000L);
            ofFloat2.setDuration(50000L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat2.setRepeatMode(1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.setDuration(50000L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setTarget(imageView);
            this.f = imageView;
            animatorSet.addListener(new g(imageView) { // from class: com.kascend.chushou.player.ui.PaoPaoView.3
                private void a() {
                    if (this.e != null && PaoPaoView.this.getContext() != null) {
                        ImageView imageView2 = (ImageView) this.e;
                        PaoPaoView.this.removeView(imageView2);
                        PaoPaoView.this.nSb.offer(new WeakReference<>(imageView2));
                        if (PaoPaoView.this.f == imageView2) {
                            PaoPaoView.this.f = null;
                        }
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a();
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    a();
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                }

                @Override // com.kascend.chushou.player.ui.pk.g, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                }
            });
            animatorSet.start();
        }
    }

    public void b() {
        if (this.nSd != null) {
            this.nSd.removeMessages(1);
            this.nSd.removeMessages(0);
        }
        synchronized (this.c) {
            if (this.d) {
                this.d = false;
            }
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.clear();
        }
        if (this.nSb != null) {
            this.nSb.clear();
        }
        if (this.k != null) {
            this.k.clear();
        }
        if (this.l != null) {
            this.l.clear();
        }
        this.e = null;
        this.f = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public int getRandBubbleTotal() {
        return this.nSc.nextInt(3) + 6;
    }

    public int getRandOffsetAngle() {
        return this.nSc.nextInt(20) - 10;
    }

    public int getRandDelayTime() {
        return this.nSc.nextInt(2000);
    }

    public float getRandScale() {
        return (this.nSc.nextFloat() / 2.0f) + 0.5f;
    }

    public float a(float f, float f2, float f3) {
        return (int) (f + (f2 * Math.cos((f3 * 3.14d) / 180.0d)));
    }

    public float i(float f, float f2, float f3) {
        return (int) (f + (f2 * Math.sin((f3 * 3.14d) / 180.0d)));
    }

    public void d() {
        this.l.clear();
        this.k.clear();
        this.m = getRandBubbleTotal();
        int i = EncoderTextureDrawer.X264_WIDTH / this.m;
        float endRadius = getEndRadius();
        float startRadius = getStartRadius();
        for (int i2 = 0; i2 < this.m; i2++) {
            this.n = getRandOffsetAngle();
            CustomCircle customCircle = new CustomCircle();
            customCircle.d = startRadius;
            customCircle.c = ((i * i2) + this.n) % EncoderTextureDrawer.X264_WIDTH;
            customCircle.a = a(this.g, startRadius, customCircle.c);
            customCircle.b = i(this.h, startRadius, customCircle.c);
            this.k.add(customCircle);
            CustomCircle customCircle2 = new CustomCircle();
            customCircle2.d = endRadius;
            customCircle2.c = ((i * i2) + this.n) % EncoderTextureDrawer.X264_WIDTH;
            customCircle2.a = a(this.g, endRadius, customCircle2.c);
            customCircle2.b = i(this.h, endRadius, customCircle2.c);
            this.l.add(customCircle2);
        }
    }

    public float getEndRadius() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) tv.chushou.basis.d.b.elS().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels / 2.0f;
    }

    public float getStartRadius() {
        return tv.chushou.zues.utils.a.dip2px(getContext(), 40.0f);
    }

    @Override // com.kascend.chushou.player.ui.pk.b
    public void a(Message message) {
        int intValue;
        switch (message.what) {
            case 0:
                e();
                return;
            case 1:
                Object obj = message.obj;
                if (obj != null && (intValue = ((Integer) obj).intValue()) >= 0 && this.k != null && this.l != null && this.l.size() == this.k.size()) {
                    a(this.k.get(intValue), this.l.get(intValue));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
