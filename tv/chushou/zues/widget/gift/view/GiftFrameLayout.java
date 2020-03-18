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
    public static double oaw = 1.0d;
    public static double oax = 500.0d;
    public static double oay = 200.0d;
    public static double oaz = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator oaA;
    private ObjectAnimator oaB;
    private AnimatorSet oaC;
    private ObjectAnimator oaD;
    private ObjectAnimator oaE;
    private AnimatorSet oaF;
    private FrameLayout oaG;
    private FrescoThumbnailView oaH;
    private View oaI;
    private FrescoThumbnailView oaJ;
    private FrescoThumbnailView oaK;
    private FrescoThumbnailView oaL;
    private TextView oaM;
    private TextView oaN;
    private LinearLayout oaO;
    private ComboNumView oaP;
    private int oaQ;
    private int oaR;
    private a oaS;
    private c oaT;
    private boolean oaU;
    private Animation oaV;
    private Animation oaW;
    private Animation.AnimationListener oaX;
    private boolean oaY;
    private long oaZ;
    private b oba;
    public int obb;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.oaR;
        giftFrameLayout.oaR = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.oaZ;
        giftFrameLayout.oaZ = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.obb = i;
        if (this.oaH != null && this.oaS != null) {
            this.oaH.bU(this.oaS.oan, this.obb);
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
        this.oaQ = 0;
        this.oaR = 0;
        this.isShowing = false;
        this.oaU = false;
        this.oaY = false;
        this.obb = b.d.zues_show_gift_animation;
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
        this.oaO = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.oaG = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.oaH = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.oaL = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.oaL.setAnim(true);
        this.oaI = inflate.findViewById(b.e.rl_user_avatar);
        this.oaJ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.oaK = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.oaM = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.oaN = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.oaT = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dRm();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.oaP = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.oaP.setType(2);
        }
        this.oaV = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.oaW = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.oaX = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.oaQ - GiftFrameLayout.this.oaR;
                if (i > 150) {
                    GiftFrameLayout.this.oaR = (i / 10) + GiftFrameLayout.this.oaR;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.oaR += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.oaR += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.oaR += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.oaR += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.oaR = Integer.MAX_VALUE;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.oaT != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.oaT.Om(1)) {
                            GiftFrameLayout.this.oaT.Ol(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oaS, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.oaT.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oaV.setAnimationListener(this.oaX);
        this.oaW.setAnimationListener(this.oaX);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dRl() {
        return this.oaU;
    }

    public void b(a aVar) {
        this.oaU = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.oaA == null) {
            this.oaA = tv.chushou.zues.widget.gift.a.a(this.oaG, -getWidth(), 0.0f, Double.valueOf(oax * oaw).longValue());
            this.oaA.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.oaS.oao);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.oaS != null) {
                        if (GiftFrameLayout.this.oaS.oap != GiftFrameLayout.this.oaS.oao) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.oaS.oap);
                            return;
                        }
                        GiftFrameLayout.this.oaR = Integer.MAX_VALUE;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oaS, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.oaA.setDuration(Double.valueOf(oax * oaw).longValue());
        }
        if (this.oaB == null) {
            this.oaB = tv.chushou.zues.widget.gift.a.b(this.oaL, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(oay * oaw).longValue());
            this.oaB.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.oaL != null) {
                        GiftFrameLayout.this.oaL.setVisibility(0);
                    }
                }
            });
        } else {
            this.oaB.setDuration(Double.valueOf(oay * oaw).longValue());
        }
        if (this.oaC == null) {
            this.oaC = tv.chushou.zues.widget.gift.a.a(this.oaA, this.oaB);
            this.oaC.start();
            return;
        }
        this.oaC.start();
    }

    public void a(long j, float f) {
        if (this.oba != null) {
            this.oba.dispose();
        }
        long j2 = this.oaZ == 0 ? (long) (oax * oaw) : 0L;
        if (this.oaZ < j) {
            this.oaZ = j;
        }
        if (this.oaZ != 0) {
            this.oba = g.a(0L, this.oaZ, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dJJ()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.oaZ == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.oaU = true;
            if (this.oaD == null) {
                this.oaD = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(oaz * oaw).longValue(), 0);
                this.oaD.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.oaL != null) {
                            GiftFrameLayout.this.oaL.setVisibility(4);
                        }
                    }
                });
            } else {
                this.oaD.setDuration(Double.valueOf(oaz * oaw).longValue());
            }
            if (this.oaE == null) {
                this.oaE = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.oaF == null) {
                this.oaF = tv.chushou.zues.widget.gift.a.a(this.oaD, this.oaE);
                this.oaF.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.oaS = null;
                        GiftFrameLayout.this.dRn();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.oaF.start();
                return;
            }
            this.oaF.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRm() {
        int i;
        if (this.oaR > this.oaQ) {
            this.oaR = this.oaQ;
            if (this.oaT != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.oaS, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.oaT.removeMessages(1);
                return;
            }
            return;
        }
        this.oaY = this.oaR == this.oaQ;
        this.oaP.setNumber(this.oaR);
        int i2 = this.oaQ - this.oaR;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.oaV.setDuration(i);
        this.oaP.startAnimation(this.oaY ? this.oaW : this.oaV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRn() {
        this.oaR = 0;
    }

    public void OC(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.oaS != null) {
            this.oaS.oap = i;
            setEndNumber(this.oaS.oap);
        }
        if (this.oba != null) {
            this.oba.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.oaR = i;
        this.oaP.setNumber(this.oaR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.oaQ = i;
        if (this.oaR == Integer.MAX_VALUE) {
            this.oaR = this.oaQ;
        }
        if (this.oaT != null && !this.oaT.Om(1)) {
            this.oaT.Ol(1);
        }
    }

    public a getGift() {
        return this.oaS;
    }

    private void setGift(a aVar) {
        this.oaS = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oaO.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.oaI.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.oaI.getLayoutParams();
            this.oaJ.setVisibility(0);
            this.oaJ.i(aVar.oaj, b.C0808b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.oak)) {
                this.oaK.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.oaK.setVisibility(0);
                this.oaK.i(aVar.oak, b.C0808b.float_transparent, b.C0817b.oae, b.C0817b.oae);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.oaI.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.oaL.h(aVar.oam, b.d.zues_btn_gift_icon, b.C0817b.medium, b.C0817b.medium);
        this.oaO.setLayoutParams(layoutParams);
        this.oaM.setText(aVar.mNickName);
        this.oaN.setText(aVar.oal);
        this.oaH.bU(aVar.oan, this.obb);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.oaC != null) {
            this.oaC.cancel();
            this.oaC = null;
        }
        if (this.oaA != null) {
            this.oaA.cancel();
            this.oaA = null;
        }
        if (this.oaB != null) {
            this.oaB.cancel();
            this.oaB = null;
        }
        if (this.oaF != null) {
            this.oaF.cancel();
            this.oaF = null;
        }
        if (this.oaD != null) {
            this.oaD.cancel();
            this.oaD = null;
        }
        if (this.oaE != null) {
            this.oaE.cancel();
            this.oaE = null;
        }
        if (this.oaV != null) {
            this.oaV.cancel();
            this.oaV = null;
        }
        if (this.oaW != null) {
            this.oaW.cancel();
            this.oaW = null;
        }
        this.oaX = null;
        this.mInflater = null;
        this.mContext = null;
        this.oaG = null;
        this.oaH = null;
        this.oaJ = null;
        this.oaL = null;
        this.oaM = null;
        this.oaN = null;
        if (this.oaP != null) {
            this.oaP.release();
            this.oaP = null;
        }
        this.oaS = null;
        if (this.oaT != null) {
            this.oaT.cq(null);
            this.oaT = null;
        }
        if (this.oba != null) {
            this.oba.dispose();
        }
    }
}
