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
    public static double nYw = 1.0d;
    public static double nYx = 500.0d;
    public static double nYy = 200.0d;
    public static double nYz = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nYA;
    private ObjectAnimator nYB;
    private AnimatorSet nYC;
    private ObjectAnimator nYD;
    private ObjectAnimator nYE;
    private AnimatorSet nYF;
    private FrameLayout nYG;
    private FrescoThumbnailView nYH;
    private View nYI;
    private FrescoThumbnailView nYJ;
    private FrescoThumbnailView nYK;
    private FrescoThumbnailView nYL;
    private TextView nYM;
    private TextView nYN;
    private LinearLayout nYO;
    private ComboNumView nYP;
    private int nYQ;
    private int nYR;
    private a nYS;
    private c nYT;
    private boolean nYU;
    private Animation nYV;
    private Animation nYW;
    private Animation.AnimationListener nYX;
    private boolean nYY;
    private long nYZ;
    private b nZa;
    public int nZb;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nYR;
        giftFrameLayout.nYR = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nYZ;
        giftFrameLayout.nYZ = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nZb = i;
        if (this.nYH != null && this.nYS != null) {
            this.nYH.bU(this.nYS.nYn, this.nZb);
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
        this.nYQ = 0;
        this.nYR = 0;
        this.isShowing = false;
        this.nYU = false;
        this.nYY = false;
        this.nZb = b.d.zues_show_gift_animation;
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
        this.nYO = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nYG = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nYH = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nYL = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nYL.setAnim(true);
        this.nYI = inflate.findViewById(b.e.rl_user_avatar);
        this.nYJ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nYK = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nYM = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nYN = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nYT = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dQJ();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nYP = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nYP.setType(2);
        }
        this.nYV = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nYW = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nYX = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nYQ - GiftFrameLayout.this.nYR;
                if (i > 150) {
                    GiftFrameLayout.this.nYR = (i / 10) + GiftFrameLayout.this.nYR;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nYR += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nYR += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nYR += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nYR += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nYR = Integer.MAX_VALUE;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nYT != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nYT.Og(1)) {
                            GiftFrameLayout.this.nYT.Of(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nYS, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nYT.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nYV.setAnimationListener(this.nYX);
        this.nYW.setAnimationListener(this.nYX);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dQI() {
        return this.nYU;
    }

    public void b(a aVar) {
        this.nYU = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nYA == null) {
            this.nYA = tv.chushou.zues.widget.gift.a.a(this.nYG, -getWidth(), 0.0f, Double.valueOf(nYx * nYw).longValue());
            this.nYA.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nYS.nYo);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nYS != null) {
                        if (GiftFrameLayout.this.nYS.nYp != GiftFrameLayout.this.nYS.nYo) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nYS.nYp);
                            return;
                        }
                        GiftFrameLayout.this.nYR = Integer.MAX_VALUE;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nYS, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nYA.setDuration(Double.valueOf(nYx * nYw).longValue());
        }
        if (this.nYB == null) {
            this.nYB = tv.chushou.zues.widget.gift.a.b(this.nYL, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nYy * nYw).longValue());
            this.nYB.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nYL != null) {
                        GiftFrameLayout.this.nYL.setVisibility(0);
                    }
                }
            });
        } else {
            this.nYB.setDuration(Double.valueOf(nYy * nYw).longValue());
        }
        if (this.nYC == null) {
            this.nYC = tv.chushou.zues.widget.gift.a.a(this.nYA, this.nYB);
            this.nYC.start();
            return;
        }
        this.nYC.start();
    }

    public void a(long j, float f) {
        if (this.nZa != null) {
            this.nZa.dispose();
        }
        long j2 = this.nYZ == 0 ? (long) (nYx * nYw) : 0L;
        if (this.nYZ < j) {
            this.nYZ = j;
        }
        if (this.nYZ != 0) {
            this.nZa = g.a(0L, this.nYZ, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dJg()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nYZ == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nYU = true;
            if (this.nYD == null) {
                this.nYD = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nYz * nYw).longValue(), 0);
                this.nYD.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nYL != null) {
                            GiftFrameLayout.this.nYL.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nYD.setDuration(Double.valueOf(nYz * nYw).longValue());
            }
            if (this.nYE == null) {
                this.nYE = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nYF == null) {
                this.nYF = tv.chushou.zues.widget.gift.a.a(this.nYD, this.nYE);
                this.nYF.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nYS = null;
                        GiftFrameLayout.this.dQK();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nYF.start();
                return;
            }
            this.nYF.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQJ() {
        int i;
        if (this.nYR > this.nYQ) {
            this.nYR = this.nYQ;
            if (this.nYT != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nYS, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nYT.removeMessages(1);
                return;
            }
            return;
        }
        this.nYY = this.nYR == this.nYQ;
        this.nYP.setNumber(this.nYR);
        int i2 = this.nYQ - this.nYR;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nYV.setDuration(i);
        this.nYP.startAnimation(this.nYY ? this.nYW : this.nYV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQK() {
        this.nYR = 0;
    }

    public void Ow(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nYS != null) {
            this.nYS.nYp = i;
            setEndNumber(this.nYS.nYp);
        }
        if (this.nZa != null) {
            this.nZa.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nYR = i;
        this.nYP.setNumber(this.nYR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nYQ = i;
        if (this.nYR == Integer.MAX_VALUE) {
            this.nYR = this.nYQ;
        }
        if (this.nYT != null && !this.nYT.Og(1)) {
            this.nYT.Of(1);
        }
    }

    public a getGift() {
        return this.nYS;
    }

    private void setGift(a aVar) {
        this.nYS = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nYO.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nYI.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nYI.getLayoutParams();
            this.nYJ.setVisibility(0);
            this.nYJ.i(aVar.nYj, b.C0807b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nYk)) {
                this.nYK.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nYK.setVisibility(0);
                this.nYK.i(aVar.nYk, b.C0807b.float_transparent, b.C0816b.nYe, b.C0816b.nYe);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nYI.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nYL.h(aVar.nYm, b.d.zues_btn_gift_icon, b.C0816b.medium, b.C0816b.medium);
        this.nYO.setLayoutParams(layoutParams);
        this.nYM.setText(aVar.mNickName);
        this.nYN.setText(aVar.nYl);
        this.nYH.bU(aVar.nYn, this.nZb);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nYC != null) {
            this.nYC.cancel();
            this.nYC = null;
        }
        if (this.nYA != null) {
            this.nYA.cancel();
            this.nYA = null;
        }
        if (this.nYB != null) {
            this.nYB.cancel();
            this.nYB = null;
        }
        if (this.nYF != null) {
            this.nYF.cancel();
            this.nYF = null;
        }
        if (this.nYD != null) {
            this.nYD.cancel();
            this.nYD = null;
        }
        if (this.nYE != null) {
            this.nYE.cancel();
            this.nYE = null;
        }
        if (this.nYV != null) {
            this.nYV.cancel();
            this.nYV = null;
        }
        if (this.nYW != null) {
            this.nYW.cancel();
            this.nYW = null;
        }
        this.nYX = null;
        this.mInflater = null;
        this.mContext = null;
        this.nYG = null;
        this.nYH = null;
        this.nYJ = null;
        this.nYL = null;
        this.nYM = null;
        this.nYN = null;
        if (this.nYP != null) {
            this.nYP.release();
            this.nYP = null;
        }
        this.nYS = null;
        if (this.nYT != null) {
            this.nYT.cq(null);
            this.nYT = null;
        }
        if (this.nZa != null) {
            this.nZa.dispose();
        }
    }
}
