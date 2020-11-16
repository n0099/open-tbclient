package tv.chushou.zues.widget.gift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
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
/* loaded from: classes6.dex */
public class GiftFrameLayout extends FrameLayout {
    public static double qqr = 1.0d;
    public static double qqs = 500.0d;
    public static double qqt = 200.0d;
    public static double qqu = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private AnimatorSet qqA;
    private FrameLayout qqB;
    private FrescoThumbnailView qqC;
    private View qqD;
    private FrescoThumbnailView qqE;
    private FrescoThumbnailView qqF;
    private FrescoThumbnailView qqG;
    private TextView qqH;
    private TextView qqI;
    private LinearLayout qqJ;
    private ComboNumView qqK;
    private int qqL;
    private int qqM;
    private a qqN;
    private c qqO;
    private boolean qqP;
    private Animation qqQ;
    private Animation qqR;
    private Animation.AnimationListener qqS;
    private boolean qqT;
    private long qqU;
    private b qqV;
    public int qqW;
    private ObjectAnimator qqv;
    private ObjectAnimator qqw;
    private AnimatorSet qqx;
    private ObjectAnimator qqy;
    private ObjectAnimator qqz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.qqM;
        giftFrameLayout.qqM = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.qqU;
        giftFrameLayout.qqU = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.qqW = i;
        if (this.qqC != null && this.qqN != null) {
            this.qqC.cd(this.qqN.qqi, this.qqW);
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
        this.qqL = 0;
        this.qqM = 0;
        this.isShowing = false;
        this.qqP = false;
        this.qqT = false;
        this.qqW = b.d.zues_show_gift_animation;
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
        this.qqJ = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.qqB = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.qqC = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.qqG = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.qqG.setAnim(true);
        this.qqD = inflate.findViewById(b.e.rl_user_avatar);
        this.qqE = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.qqF = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.qqH = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.qqI = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.qqO = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.eIj();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.qqK = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.qqK.setType(2);
        }
        this.qqQ = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.qqR = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.qqS = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.qqL - GiftFrameLayout.this.qqM;
                if (i > 150) {
                    GiftFrameLayout.this.qqM = (i / 10) + GiftFrameLayout.this.qqM;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.qqM += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.qqM += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.qqM += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.qqM += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.qqM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.qqO != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.qqO.Sw(1)) {
                            GiftFrameLayout.this.qqO.Sv(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.qqN, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.qqO.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.qqQ.setAnimationListener(this.qqS);
        this.qqR.setAnimationListener(this.qqS);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean eIi() {
        return this.qqP;
    }

    public void b(a aVar) {
        this.qqP = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.qqv == null) {
            this.qqv = tv.chushou.zues.widget.gift.a.a(this.qqB, -getWidth(), 0.0f, Double.valueOf(qqs * qqr).longValue());
            this.qqv.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.qqN.qqj);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.qqN != null) {
                        if (GiftFrameLayout.this.qqN.qqk != GiftFrameLayout.this.qqN.qqj) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.qqN.qqk);
                            return;
                        }
                        GiftFrameLayout.this.qqM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.qqN, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.qqv.setDuration(Double.valueOf(qqs * qqr).longValue());
        }
        if (this.qqw == null) {
            this.qqw = tv.chushou.zues.widget.gift.a.b(this.qqG, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(qqt * qqr).longValue());
            this.qqw.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.qqG != null) {
                        GiftFrameLayout.this.qqG.setVisibility(0);
                    }
                }
            });
        } else {
            this.qqw.setDuration(Double.valueOf(qqt * qqr).longValue());
        }
        if (this.qqx == null) {
            this.qqx = tv.chushou.zues.widget.gift.a.a(this.qqv, this.qqw);
            this.qqx.start();
            return;
        }
        this.qqx.start();
    }

    public void a(long j, float f) {
        if (this.qqV != null) {
            this.qqV.dispose();
        }
        long j2 = this.qqU == 0 ? (long) (qqs * qqr) : 0L;
        if (this.qqU < j) {
            this.qqU = j;
        }
        if (this.qqU != 0) {
            this.qqV = g.a(0L, this.qqU, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.eAC()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: l */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.qqU == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.qqP = true;
            if (this.qqy == null) {
                this.qqy = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(qqu * qqr).longValue(), 0);
                this.qqy.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.qqG != null) {
                            GiftFrameLayout.this.qqG.setVisibility(4);
                        }
                    }
                });
            } else {
                this.qqy.setDuration(Double.valueOf(qqu * qqr).longValue());
            }
            if (this.qqz == null) {
                this.qqz = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.qqA == null) {
                this.qqA = tv.chushou.zues.widget.gift.a.a(this.qqy, this.qqz);
                this.qqA.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.qqN = null;
                        GiftFrameLayout.this.eIk();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.qqA.start();
                return;
            }
            this.qqA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eIj() {
        int i;
        if (this.qqM > this.qqL) {
            this.qqM = this.qqL;
            if (this.qqO != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.qqN, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.qqO.removeMessages(1);
                return;
            }
            return;
        }
        this.qqT = this.qqM == this.qqL;
        this.qqK.setNumber(this.qqM);
        int i2 = this.qqL - this.qqM;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.qqQ.setDuration(i);
        this.qqK.startAnimation(this.qqT ? this.qqR : this.qqQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eIk() {
        this.qqM = 0;
    }

    public void SM(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.qqN != null) {
            this.qqN.qqk = i;
            setEndNumber(this.qqN.qqk);
        }
        if (this.qqV != null) {
            this.qqV.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.qqM = i;
        this.qqK.setNumber(this.qqM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.qqL = i;
        if (this.qqM == Integer.MAX_VALUE) {
            this.qqM = this.qqL;
        }
        if (this.qqO != null && !this.qqO.Sw(1)) {
            this.qqO.Sv(1);
        }
    }

    public a getGift() {
        return this.qqN;
    }

    private void setGift(a aVar) {
        this.qqN = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qqJ.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.qqD.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.qqD.getLayoutParams();
            this.qqE.setVisibility(0);
            this.qqE.i(aVar.qqe, b.C1118b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.qqf)) {
                this.qqF.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.qqF.setVisibility(0);
                this.qqF.i(aVar.qqf, b.C1118b.float_transparent, b.C1127b.qpZ, b.C1127b.qpZ);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.qqD.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.qqG.h(aVar.qqh, b.d.zues_btn_gift_icon, b.C1127b.qpY, b.C1127b.qpY);
        this.qqJ.setLayoutParams(layoutParams);
        this.qqH.setText(aVar.mNickName);
        this.qqI.setText(aVar.qqg);
        this.qqC.cd(aVar.qqi, this.qqW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.qqx != null) {
            this.qqx.cancel();
            this.qqx = null;
        }
        if (this.qqv != null) {
            this.qqv.cancel();
            this.qqv = null;
        }
        if (this.qqw != null) {
            this.qqw.cancel();
            this.qqw = null;
        }
        if (this.qqA != null) {
            this.qqA.cancel();
            this.qqA = null;
        }
        if (this.qqy != null) {
            this.qqy.cancel();
            this.qqy = null;
        }
        if (this.qqz != null) {
            this.qqz.cancel();
            this.qqz = null;
        }
        if (this.qqQ != null) {
            this.qqQ.cancel();
            this.qqQ = null;
        }
        if (this.qqR != null) {
            this.qqR.cancel();
            this.qqR = null;
        }
        this.qqS = null;
        this.mInflater = null;
        this.mContext = null;
        this.qqB = null;
        this.qqC = null;
        this.qqE = null;
        this.qqG = null;
        this.qqH = null;
        this.qqI = null;
        if (this.qqK != null) {
            this.qqK.release();
            this.qqK = null;
        }
        this.qqN = null;
        if (this.qqO != null) {
            this.qqO.ct(null);
            this.qqO = null;
        }
        if (this.qqV != null) {
            this.qqV.dispose();
        }
    }
}
