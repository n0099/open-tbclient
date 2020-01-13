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
    public static double nXD = 1.0d;
    public static double nXE = 500.0d;
    public static double nXF = 200.0d;
    public static double nXG = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nXH;
    private ObjectAnimator nXI;
    private AnimatorSet nXJ;
    private ObjectAnimator nXK;
    private ObjectAnimator nXL;
    private AnimatorSet nXM;
    private FrameLayout nXN;
    private FrescoThumbnailView nXO;
    private View nXP;
    private FrescoThumbnailView nXQ;
    private FrescoThumbnailView nXR;
    private FrescoThumbnailView nXS;
    private TextView nXT;
    private TextView nXU;
    private LinearLayout nXV;
    private ComboNumView nXW;
    private int nXX;
    private int nXY;
    private a nXZ;
    private c nYa;
    private boolean nYb;
    private Animation nYc;
    private Animation nYd;
    private Animation.AnimationListener nYe;
    private boolean nYf;
    private long nYg;
    private b nYh;
    public int nYi;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nXY;
        giftFrameLayout.nXY = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nYg;
        giftFrameLayout.nYg = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nYi = i;
        if (this.nXO != null && this.nXZ != null) {
            this.nXO.bV(this.nXZ.nXu, this.nYi);
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
        this.nXX = 0;
        this.nXY = 0;
        this.isShowing = false;
        this.nYb = false;
        this.nYf = false;
        this.nYi = b.d.zues_show_gift_animation;
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
        this.nXV = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nXN = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nXO = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nXS = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nXS.setAnim(true);
        this.nXP = inflate.findViewById(b.e.rl_user_avatar);
        this.nXQ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nXR = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nXT = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nXU = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nYa = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dPu();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nXW = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nXW.setType(2);
        }
        this.nYc = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nYd = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nYe = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nXX - GiftFrameLayout.this.nXY;
                if (i > 150) {
                    GiftFrameLayout.this.nXY = (i / 10) + GiftFrameLayout.this.nXY;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nXY += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nXY += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nXY += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nXY += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nXY = Integer.MAX_VALUE;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nYa != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nYa.Od(1)) {
                            GiftFrameLayout.this.nYa.Oc(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nXZ, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nYa.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nYc.setAnimationListener(this.nYe);
        this.nYd.setAnimationListener(this.nYe);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dPt() {
        return this.nYb;
    }

    public void b(a aVar) {
        this.nYb = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nXH == null) {
            this.nXH = tv.chushou.zues.widget.gift.a.a(this.nXN, -getWidth(), 0.0f, Double.valueOf(nXE * nXD).longValue());
            this.nXH.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nXZ.nXv);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nXZ != null) {
                        if (GiftFrameLayout.this.nXZ.nXw != GiftFrameLayout.this.nXZ.nXv) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nXZ.nXw);
                            return;
                        }
                        GiftFrameLayout.this.nXY = Integer.MAX_VALUE;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nXZ, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nXH.setDuration(Double.valueOf(nXE * nXD).longValue());
        }
        if (this.nXI == null) {
            this.nXI = tv.chushou.zues.widget.gift.a.b(this.nXS, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nXF * nXD).longValue());
            this.nXI.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nXS != null) {
                        GiftFrameLayout.this.nXS.setVisibility(0);
                    }
                }
            });
        } else {
            this.nXI.setDuration(Double.valueOf(nXF * nXD).longValue());
        }
        if (this.nXJ == null) {
            this.nXJ = tv.chushou.zues.widget.gift.a.a(this.nXH, this.nXI);
            this.nXJ.start();
            return;
        }
        this.nXJ.start();
    }

    public void a(long j, float f) {
        if (this.nYh != null) {
            this.nYh.dispose();
        }
        long j2 = this.nYg == 0 ? (long) (nXE * nXD) : 0L;
        if (this.nYg < j) {
            this.nYg = j;
        }
        if (this.nYg != 0) {
            this.nYh = g.a(0L, this.nYg, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dHX()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nYg == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nYb = true;
            if (this.nXK == null) {
                this.nXK = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nXG * nXD).longValue(), 0);
                this.nXK.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nXS != null) {
                            GiftFrameLayout.this.nXS.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nXK.setDuration(Double.valueOf(nXG * nXD).longValue());
            }
            if (this.nXL == null) {
                this.nXL = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nXM == null) {
                this.nXM = tv.chushou.zues.widget.gift.a.a(this.nXK, this.nXL);
                this.nXM.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nXZ = null;
                        GiftFrameLayout.this.dPv();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nXM.start();
                return;
            }
            this.nXM.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPu() {
        int i;
        if (this.nXY > this.nXX) {
            this.nXY = this.nXX;
            if (this.nYa != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nXZ, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nYa.removeMessages(1);
                return;
            }
            return;
        }
        this.nYf = this.nXY == this.nXX;
        this.nXW.setNumber(this.nXY);
        int i2 = this.nXX - this.nXY;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nYc.setDuration(i);
        this.nXW.startAnimation(this.nYf ? this.nYd : this.nYc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPv() {
        this.nXY = 0;
    }

    public void Ot(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nXZ != null) {
            this.nXZ.nXw = i;
            setEndNumber(this.nXZ.nXw);
        }
        if (this.nYh != null) {
            this.nYh.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nXY = i;
        this.nXW.setNumber(this.nXY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nXX = i;
        if (this.nXY == Integer.MAX_VALUE) {
            this.nXY = this.nXX;
        }
        if (this.nYa != null && !this.nYa.Od(1)) {
            this.nYa.Oc(1);
        }
    }

    public a getGift() {
        return this.nXZ;
    }

    private void setGift(a aVar) {
        this.nXZ = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nXV.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nXP.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nXP.getLayoutParams();
            this.nXQ.setVisibility(0);
            this.nXQ.i(aVar.nXq, b.C0799b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nXr)) {
                this.nXR.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nXR.setVisibility(0);
                this.nXR.i(aVar.nXr, b.C0799b.float_transparent, b.C0808b.nXl, b.C0808b.nXl);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nXP.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nXS.h(aVar.nXt, b.d.zues_btn_gift_icon, b.C0808b.medium, b.C0808b.medium);
        this.nXV.setLayoutParams(layoutParams);
        this.nXT.setText(aVar.mNickName);
        this.nXU.setText(aVar.nXs);
        this.nXO.bV(aVar.nXu, this.nYi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nXJ != null) {
            this.nXJ.cancel();
            this.nXJ = null;
        }
        if (this.nXH != null) {
            this.nXH.cancel();
            this.nXH = null;
        }
        if (this.nXI != null) {
            this.nXI.cancel();
            this.nXI = null;
        }
        if (this.nXM != null) {
            this.nXM.cancel();
            this.nXM = null;
        }
        if (this.nXK != null) {
            this.nXK.cancel();
            this.nXK = null;
        }
        if (this.nXL != null) {
            this.nXL.cancel();
            this.nXL = null;
        }
        if (this.nYc != null) {
            this.nYc.cancel();
            this.nYc = null;
        }
        if (this.nYd != null) {
            this.nYd.cancel();
            this.nYd = null;
        }
        this.nYe = null;
        this.mInflater = null;
        this.mContext = null;
        this.nXN = null;
        this.nXO = null;
        this.nXQ = null;
        this.nXS = null;
        this.nXT = null;
        this.nXU = null;
        if (this.nXW != null) {
            this.nXW.release();
            this.nXW = null;
        }
        this.nXZ = null;
        if (this.nYa != null) {
            this.nYa.cp(null);
            this.nYa = null;
        }
        if (this.nYh != null) {
            this.nYh.dispose();
        }
    }
}
