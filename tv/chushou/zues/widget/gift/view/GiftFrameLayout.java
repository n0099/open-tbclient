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
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nYC;
    private ObjectAnimator nYD;
    private AnimatorSet nYE;
    private ObjectAnimator nYF;
    private ObjectAnimator nYG;
    private AnimatorSet nYH;
    private FrameLayout nYI;
    private FrescoThumbnailView nYJ;
    private View nYK;
    private FrescoThumbnailView nYL;
    private FrescoThumbnailView nYM;
    private FrescoThumbnailView nYN;
    private TextView nYO;
    private TextView nYP;
    private LinearLayout nYQ;
    private ComboNumView nYR;
    private int nYS;
    private int nYT;
    private a nYU;
    private c nYV;
    private boolean nYW;
    private Animation nYX;
    private Animation nYY;
    private Animation.AnimationListener nYZ;
    private boolean nZa;
    private long nZb;
    private b nZc;
    public int nZd;
    public long updateTime;
    public static double nYy = 1.0d;
    public static double nYz = 500.0d;
    public static double nYA = 200.0d;
    public static double nYB = 1000.0d;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nYT;
        giftFrameLayout.nYT = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nZb;
        giftFrameLayout.nZb = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nZd = i;
        if (this.nYJ != null && this.nYU != null) {
            this.nYJ.bU(this.nYU.nYp, this.nZd);
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
        this.nYS = 0;
        this.nYT = 0;
        this.isShowing = false;
        this.nYW = false;
        this.nZa = false;
        this.nZd = b.d.zues_show_gift_animation;
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
        this.nYQ = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nYI = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nYJ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nYN = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nYN.setAnim(true);
        this.nYK = inflate.findViewById(b.e.rl_user_avatar);
        this.nYL = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nYM = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nYO = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nYP = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nYV = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dQL();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nYR = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nYR.setType(2);
        }
        this.nYX = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nYY = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nYZ = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nYS - GiftFrameLayout.this.nYT;
                if (i > 150) {
                    GiftFrameLayout.this.nYT = (i / 10) + GiftFrameLayout.this.nYT;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nYT += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nYT += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nYT += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nYT += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nYT = Integer.MAX_VALUE;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nYV != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nYV.Og(1)) {
                            GiftFrameLayout.this.nYV.Of(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nYU, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nYV.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nYX.setAnimationListener(this.nYZ);
        this.nYY.setAnimationListener(this.nYZ);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dQK() {
        return this.nYW;
    }

    public void b(a aVar) {
        this.nYW = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nYC == null) {
            this.nYC = tv.chushou.zues.widget.gift.a.a(this.nYI, -getWidth(), 0.0f, Double.valueOf(nYz * nYy).longValue());
            this.nYC.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nYU.nYq);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nYU != null) {
                        if (GiftFrameLayout.this.nYU.nYr != GiftFrameLayout.this.nYU.nYq) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nYU.nYr);
                            return;
                        }
                        GiftFrameLayout.this.nYT = Integer.MAX_VALUE;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nYU, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nYC.setDuration(Double.valueOf(nYz * nYy).longValue());
        }
        if (this.nYD == null) {
            this.nYD = tv.chushou.zues.widget.gift.a.b(this.nYN, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nYA * nYy).longValue());
            this.nYD.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nYN != null) {
                        GiftFrameLayout.this.nYN.setVisibility(0);
                    }
                }
            });
        } else {
            this.nYD.setDuration(Double.valueOf(nYA * nYy).longValue());
        }
        if (this.nYE == null) {
            this.nYE = tv.chushou.zues.widget.gift.a.a(this.nYC, this.nYD);
            this.nYE.start();
            return;
        }
        this.nYE.start();
    }

    public void a(long j, float f) {
        if (this.nZc != null) {
            this.nZc.dispose();
        }
        long j2 = this.nZb == 0 ? (long) (nYz * nYy) : 0L;
        if (this.nZb < j) {
            this.nZb = j;
        }
        if (this.nZb != 0) {
            this.nZc = g.a(0L, this.nZb, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dJi()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nZb == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nYW = true;
            if (this.nYF == null) {
                this.nYF = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nYB * nYy).longValue(), 0);
                this.nYF.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nYN != null) {
                            GiftFrameLayout.this.nYN.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nYF.setDuration(Double.valueOf(nYB * nYy).longValue());
            }
            if (this.nYG == null) {
                this.nYG = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nYH == null) {
                this.nYH = tv.chushou.zues.widget.gift.a.a(this.nYF, this.nYG);
                this.nYH.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nYU = null;
                        GiftFrameLayout.this.dQM();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nYH.start();
                return;
            }
            this.nYH.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQL() {
        int i;
        if (this.nYT > this.nYS) {
            this.nYT = this.nYS;
            if (this.nYV != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nYU, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nYV.removeMessages(1);
                return;
            }
            return;
        }
        this.nZa = this.nYT == this.nYS;
        this.nYR.setNumber(this.nYT);
        int i2 = this.nYS - this.nYT;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nYX.setDuration(i);
        this.nYR.startAnimation(this.nZa ? this.nYY : this.nYX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQM() {
        this.nYT = 0;
    }

    public void Ow(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nYU != null) {
            this.nYU.nYr = i;
            setEndNumber(this.nYU.nYr);
        }
        if (this.nZc != null) {
            this.nZc.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nYT = i;
        this.nYR.setNumber(this.nYT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nYS = i;
        if (this.nYT == Integer.MAX_VALUE) {
            this.nYT = this.nYS;
        }
        if (this.nYV != null && !this.nYV.Og(1)) {
            this.nYV.Of(1);
        }
    }

    public a getGift() {
        return this.nYU;
    }

    private void setGift(a aVar) {
        this.nYU = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nYQ.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nYK.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nYK.getLayoutParams();
            this.nYL.setVisibility(0);
            this.nYL.i(aVar.nYl, b.C0807b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nYm)) {
                this.nYM.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nYM.setVisibility(0);
                this.nYM.i(aVar.nYm, b.C0807b.float_transparent, b.C0816b.nYg, b.C0816b.nYg);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nYK.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nYN.h(aVar.nYo, b.d.zues_btn_gift_icon, b.C0816b.medium, b.C0816b.medium);
        this.nYQ.setLayoutParams(layoutParams);
        this.nYO.setText(aVar.mNickName);
        this.nYP.setText(aVar.nYn);
        this.nYJ.bU(aVar.nYp, this.nZd);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nYE != null) {
            this.nYE.cancel();
            this.nYE = null;
        }
        if (this.nYC != null) {
            this.nYC.cancel();
            this.nYC = null;
        }
        if (this.nYD != null) {
            this.nYD.cancel();
            this.nYD = null;
        }
        if (this.nYH != null) {
            this.nYH.cancel();
            this.nYH = null;
        }
        if (this.nYF != null) {
            this.nYF.cancel();
            this.nYF = null;
        }
        if (this.nYG != null) {
            this.nYG.cancel();
            this.nYG = null;
        }
        if (this.nYX != null) {
            this.nYX.cancel();
            this.nYX = null;
        }
        if (this.nYY != null) {
            this.nYY.cancel();
            this.nYY = null;
        }
        this.nYZ = null;
        this.mInflater = null;
        this.mContext = null;
        this.nYI = null;
        this.nYJ = null;
        this.nYL = null;
        this.nYN = null;
        this.nYO = null;
        this.nYP = null;
        if (this.nYR != null) {
            this.nYR.release();
            this.nYR = null;
        }
        this.nYU = null;
        if (this.nYV != null) {
            this.nYV.cq(null);
            this.nYV = null;
        }
        if (this.nZc != null) {
            this.nZc.dispose();
        }
    }
}
