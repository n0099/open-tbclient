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
/* loaded from: classes5.dex */
public class GiftFrameLayout extends FrameLayout {
    public static double nYJ = 1.0d;
    public static double nYK = 500.0d;
    public static double nYL = 200.0d;
    public static double nYM = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nYN;
    private ObjectAnimator nYO;
    private AnimatorSet nYP;
    private ObjectAnimator nYQ;
    private ObjectAnimator nYR;
    private AnimatorSet nYS;
    private FrameLayout nYT;
    private FrescoThumbnailView nYU;
    private View nYV;
    private FrescoThumbnailView nYW;
    private FrescoThumbnailView nYX;
    private FrescoThumbnailView nYY;
    private TextView nYZ;
    private TextView nZa;
    private LinearLayout nZb;
    private ComboNumView nZc;
    private int nZd;
    private int nZe;
    private a nZf;
    private c nZg;
    private boolean nZh;
    private Animation nZi;
    private Animation nZj;
    private Animation.AnimationListener nZk;
    private boolean nZl;
    private long nZm;
    private b nZn;
    public int nZo;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nZe;
        giftFrameLayout.nZe = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nZm;
        giftFrameLayout.nZm = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nZo = i;
        if (this.nYU != null && this.nZf != null) {
            this.nYU.bU(this.nZf.nYA, this.nZo);
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
        this.nZd = 0;
        this.nZe = 0;
        this.isShowing = false;
        this.nZh = false;
        this.nZl = false;
        this.nZo = b.d.zues_show_gift_animation;
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
        this.nZb = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nYT = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nYU = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nYY = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nYY.setAnim(true);
        this.nYV = inflate.findViewById(b.e.rl_user_avatar);
        this.nYW = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nYX = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nYZ = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nZa = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nZg = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dQM();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nZc = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nZc.setType(2);
        }
        this.nZi = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nZj = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nZk = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nZd - GiftFrameLayout.this.nZe;
                if (i > 150) {
                    GiftFrameLayout.this.nZe = (i / 10) + GiftFrameLayout.this.nZe;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nZe += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nZe += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nZe += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nZe += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nZe = Integer.MAX_VALUE;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nZg != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nZg.Og(1)) {
                            GiftFrameLayout.this.nZg.Of(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nZf, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nZg.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nZi.setAnimationListener(this.nZk);
        this.nZj.setAnimationListener(this.nZk);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dQL() {
        return this.nZh;
    }

    public void b(a aVar) {
        this.nZh = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nYN == null) {
            this.nYN = tv.chushou.zues.widget.gift.a.a(this.nYT, -getWidth(), 0.0f, Double.valueOf(nYK * nYJ).longValue());
            this.nYN.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nZf.nYB);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nZf != null) {
                        if (GiftFrameLayout.this.nZf.nYC != GiftFrameLayout.this.nZf.nYB) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nZf.nYC);
                            return;
                        }
                        GiftFrameLayout.this.nZe = Integer.MAX_VALUE;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nZf, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nYN.setDuration(Double.valueOf(nYK * nYJ).longValue());
        }
        if (this.nYO == null) {
            this.nYO = tv.chushou.zues.widget.gift.a.b(this.nYY, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nYL * nYJ).longValue());
            this.nYO.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nYY != null) {
                        GiftFrameLayout.this.nYY.setVisibility(0);
                    }
                }
            });
        } else {
            this.nYO.setDuration(Double.valueOf(nYL * nYJ).longValue());
        }
        if (this.nYP == null) {
            this.nYP = tv.chushou.zues.widget.gift.a.a(this.nYN, this.nYO);
            this.nYP.start();
            return;
        }
        this.nYP.start();
    }

    public void a(long j, float f) {
        if (this.nZn != null) {
            this.nZn.dispose();
        }
        long j2 = this.nZm == 0 ? (long) (nYK * nYJ) : 0L;
        if (this.nZm < j) {
            this.nZm = j;
        }
        if (this.nZm != 0) {
            this.nZn = g.a(0L, this.nZm, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dJj()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nZm == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nZh = true;
            if (this.nYQ == null) {
                this.nYQ = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nYM * nYJ).longValue(), 0);
                this.nYQ.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nYY != null) {
                            GiftFrameLayout.this.nYY.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nYQ.setDuration(Double.valueOf(nYM * nYJ).longValue());
            }
            if (this.nYR == null) {
                this.nYR = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nYS == null) {
                this.nYS = tv.chushou.zues.widget.gift.a.a(this.nYQ, this.nYR);
                this.nYS.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nZf = null;
                        GiftFrameLayout.this.dQN();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nYS.start();
                return;
            }
            this.nYS.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQM() {
        int i;
        if (this.nZe > this.nZd) {
            this.nZe = this.nZd;
            if (this.nZg != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nZf, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nZg.removeMessages(1);
                return;
            }
            return;
        }
        this.nZl = this.nZe == this.nZd;
        this.nZc.setNumber(this.nZe);
        int i2 = this.nZd - this.nZe;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nZi.setDuration(i);
        this.nZc.startAnimation(this.nZl ? this.nZj : this.nZi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQN() {
        this.nZe = 0;
    }

    public void Ow(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nZf != null) {
            this.nZf.nYC = i;
            setEndNumber(this.nZf.nYC);
        }
        if (this.nZn != null) {
            this.nZn.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nZe = i;
        this.nZc.setNumber(this.nZe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nZd = i;
        if (this.nZe == Integer.MAX_VALUE) {
            this.nZe = this.nZd;
        }
        if (this.nZg != null && !this.nZg.Og(1)) {
            this.nZg.Of(1);
        }
    }

    public a getGift() {
        return this.nZf;
    }

    private void setGift(a aVar) {
        this.nZf = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nZb.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nYV.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nYV.getLayoutParams();
            this.nYW.setVisibility(0);
            this.nYW.i(aVar.nYw, b.C0807b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nYx)) {
                this.nYX.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nYX.setVisibility(0);
                this.nYX.i(aVar.nYx, b.C0807b.float_transparent, b.C0816b.nYr, b.C0816b.nYr);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nYV.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nYY.h(aVar.nYz, b.d.zues_btn_gift_icon, b.C0816b.medium, b.C0816b.medium);
        this.nZb.setLayoutParams(layoutParams);
        this.nYZ.setText(aVar.mNickName);
        this.nZa.setText(aVar.nYy);
        this.nYU.bU(aVar.nYA, this.nZo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nYP != null) {
            this.nYP.cancel();
            this.nYP = null;
        }
        if (this.nYN != null) {
            this.nYN.cancel();
            this.nYN = null;
        }
        if (this.nYO != null) {
            this.nYO.cancel();
            this.nYO = null;
        }
        if (this.nYS != null) {
            this.nYS.cancel();
            this.nYS = null;
        }
        if (this.nYQ != null) {
            this.nYQ.cancel();
            this.nYQ = null;
        }
        if (this.nYR != null) {
            this.nYR.cancel();
            this.nYR = null;
        }
        if (this.nZi != null) {
            this.nZi.cancel();
            this.nZi = null;
        }
        if (this.nZj != null) {
            this.nZj.cancel();
            this.nZj = null;
        }
        this.nZk = null;
        this.mInflater = null;
        this.mContext = null;
        this.nYT = null;
        this.nYU = null;
        this.nYW = null;
        this.nYY = null;
        this.nYZ = null;
        this.nZa = null;
        if (this.nZc != null) {
            this.nZc.release();
            this.nZc = null;
        }
        this.nZf = null;
        if (this.nZg != null) {
            this.nZg.cq(null);
            this.nZg = null;
        }
        if (this.nZn != null) {
            this.nZn.dispose();
        }
    }
}
