package tv.chushou.zues.widget.gift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.reactivex.disposables.b;
import io.reactivex.g;
import java.util.concurrent.TimeUnit;
import tv.chushou.zues.b;
import tv.chushou.zues.c;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
import tv.chushou.zues.widget.gift.a.a;
/* loaded from: classes4.dex */
public class GiftFrameLayout extends FrameLayout {
    public static double nXI = 1.0d;
    public static double nXJ = 500.0d;
    public static double nXK = 200.0d;
    public static double nXL = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nXM;
    private ObjectAnimator nXN;
    private AnimatorSet nXO;
    private ObjectAnimator nXP;
    private ObjectAnimator nXQ;
    private AnimatorSet nXR;
    private FrameLayout nXS;
    private FrescoThumbnailView nXT;
    private View nXU;
    private FrescoThumbnailView nXV;
    private FrescoThumbnailView nXW;
    private FrescoThumbnailView nXX;
    private TextView nXY;
    private TextView nXZ;
    private LinearLayout nYa;
    private ComboNumView nYb;
    private int nYc;
    private int nYd;
    private a nYe;
    private c nYf;
    private boolean nYg;
    private Animation nYh;
    private Animation nYi;
    private Animation.AnimationListener nYj;
    private boolean nYk;
    private long nYl;
    private b nYm;
    public int nYn;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nYd;
        giftFrameLayout.nYd = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nYl;
        giftFrameLayout.nYl = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nYn = i;
        if (this.nXT != null && this.nYe != null) {
            this.nXT.bV(this.nYe.nXz, this.nYn);
        }
    }

    public GiftFrameLayout(Context context) {
        this(context, null, 1);
    }

    public GiftFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 1);
    }

    public GiftFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.TAG = "GiftFrameLayout";
        this.mType = 1;
        this.updateTime = 0L;
        this.nYc = 0;
        this.nYd = 0;
        this.isShowing = false;
        this.nYg = false;
        this.nYk = false;
        this.nYn = b.d.zues_show_gift_animation;
        this.mType = i;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        initView();
    }

    private void initView() {
        View inflate;
        if (this.mType == 2) {
            inflate = this.mInflater.inflate(b.f.zues_widget_play_show_gift_item, (ViewGroup) this, false);
        } else {
            inflate = this.mInflater.inflate(b.f.zues_widget_play_show_gift_item, (ViewGroup) this, false);
        }
        this.nYa = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nXS = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nXT = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nXX = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nXX.setAnim(true);
        this.nXU = inflate.findViewById(b.e.rl_user_avatar);
        this.nXV = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nXW = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nXY = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nXZ = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nYf = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dPw();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nYb = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nYb.setType(2);
        }
        this.nYh = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nYi = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nYj = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nYc - GiftFrameLayout.this.nYd;
                if (i > 150) {
                    GiftFrameLayout.this.nYd = (i / 10) + GiftFrameLayout.this.nYd;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nYd += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nYd += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nYd += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nYd += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nYd = Integer.MAX_VALUE;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nYf != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nYf.Od(1)) {
                            GiftFrameLayout.this.nYf.Oc(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nYe, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nYf.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nYh.setAnimationListener(this.nYj);
        this.nYi.setAnimationListener(this.nYj);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dPv() {
        return this.nYg;
    }

    public void b(a aVar) {
        this.nYg = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nXM == null) {
            this.nXM = tv.chushou.zues.widget.gift.a.a(this.nXS, -getWidth(), 0.0f, Double.valueOf(nXJ * nXI).longValue());
            this.nXM.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nYe.nXA);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nYe != null) {
                        if (GiftFrameLayout.this.nYe.nXB != GiftFrameLayout.this.nYe.nXA) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nYe.nXB);
                            return;
                        }
                        GiftFrameLayout.this.nYd = Integer.MAX_VALUE;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nYe, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nXM.setDuration(Double.valueOf(nXJ * nXI).longValue());
        }
        if (this.nXN == null) {
            this.nXN = tv.chushou.zues.widget.gift.a.b(this.nXX, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nXK * nXI).longValue());
            this.nXN.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nXX != null) {
                        GiftFrameLayout.this.nXX.setVisibility(0);
                    }
                }
            });
        } else {
            this.nXN.setDuration(Double.valueOf(nXK * nXI).longValue());
        }
        if (this.nXO == null) {
            this.nXO = tv.chushou.zues.widget.gift.a.a(this.nXM, this.nXN);
            this.nXO.start();
            return;
        }
        this.nXO.start();
    }

    public void a(long j, float f) {
        if (this.nYm != null) {
            this.nYm.dispose();
        }
        long j2 = this.nYl == 0 ? (long) (nXJ * nXI) : 0L;
        if (this.nYl < j) {
            this.nYl = j;
        }
        if (this.nYl != 0) {
            this.nYm = g.a(0L, this.nYl, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dHZ()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nYl == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nYg = true;
            if (this.nXP == null) {
                this.nXP = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nXL * nXI).longValue(), 0);
                this.nXP.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nXX != null) {
                            GiftFrameLayout.this.nXX.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nXP.setDuration(Double.valueOf(nXL * nXI).longValue());
            }
            if (this.nXQ == null) {
                this.nXQ = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nXR == null) {
                this.nXR = tv.chushou.zues.widget.gift.a.a(this.nXP, this.nXQ);
                this.nXR.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nYe = null;
                        GiftFrameLayout.this.dPx();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nXR.start();
                return;
            }
            this.nXR.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPw() {
        int i;
        if (this.nYd > this.nYc) {
            this.nYd = this.nYc;
            if (this.nYf != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nYe, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nYf.removeMessages(1);
                return;
            }
            return;
        }
        this.nYk = this.nYd == this.nYc;
        this.nYb.setNumber(this.nYd);
        int i2 = this.nYc - this.nYd;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nYh.setDuration(i);
        this.nYb.startAnimation(this.nYk ? this.nYi : this.nYh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPx() {
        this.nYd = 0;
    }

    public void Ot(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nYe != null) {
            this.nYe.nXB = i;
            setEndNumber(this.nYe.nXB);
        }
        if (this.nYm != null) {
            this.nYm.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nYd = i;
        this.nYb.setNumber(this.nYd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nYc = i;
        if (this.nYd == Integer.MAX_VALUE) {
            this.nYd = this.nYc;
        }
        if (this.nYf != null && !this.nYf.Od(1)) {
            this.nYf.Oc(1);
        }
    }

    public a getGift() {
        return this.nYe;
    }

    private void setGift(a aVar) {
        this.nYe = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nYa.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nXU.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nXU.getLayoutParams();
            this.nXV.setVisibility(0);
            this.nXV.i(aVar.nXv, b.C0799b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nXw)) {
                this.nXW.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nXW.setVisibility(0);
                this.nXW.i(aVar.nXw, b.C0799b.float_transparent, b.C0808b.nXq, b.C0808b.nXq);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nXU.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nXX.h(aVar.nXy, b.d.zues_btn_gift_icon, b.C0808b.medium, b.C0808b.medium);
        this.nYa.setLayoutParams(layoutParams);
        this.nXY.setText(aVar.mNickName);
        this.nXZ.setText(aVar.nXx);
        this.nXT.bV(aVar.nXz, this.nYn);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nXO != null) {
            this.nXO.cancel();
            this.nXO = null;
        }
        if (this.nXM != null) {
            this.nXM.cancel();
            this.nXM = null;
        }
        if (this.nXN != null) {
            this.nXN.cancel();
            this.nXN = null;
        }
        if (this.nXR != null) {
            this.nXR.cancel();
            this.nXR = null;
        }
        if (this.nXP != null) {
            this.nXP.cancel();
            this.nXP = null;
        }
        if (this.nXQ != null) {
            this.nXQ.cancel();
            this.nXQ = null;
        }
        if (this.nYh != null) {
            this.nYh.cancel();
            this.nYh = null;
        }
        if (this.nYi != null) {
            this.nYi.cancel();
            this.nYi = null;
        }
        this.nYj = null;
        this.mInflater = null;
        this.mContext = null;
        this.nXS = null;
        this.nXT = null;
        this.nXV = null;
        this.nXX = null;
        this.nXY = null;
        this.nXZ = null;
        if (this.nYb != null) {
            this.nYb.release();
            this.nYb = null;
        }
        this.nYe = null;
        if (this.nYf != null) {
            this.nYf.cp(null);
            this.nYf = null;
        }
        if (this.nYm != null) {
            this.nYm.dispose();
        }
    }
}
