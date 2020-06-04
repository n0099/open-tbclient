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
/* loaded from: classes5.dex */
public class GiftFrameLayout extends FrameLayout {
    public static double nQB = 1.0d;
    public static double nQC = 500.0d;
    public static double nQD = 200.0d;
    public static double nQE = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nQF;
    private ObjectAnimator nQG;
    private AnimatorSet nQH;
    private ObjectAnimator nQI;
    private ObjectAnimator nQJ;
    private AnimatorSet nQK;
    private FrameLayout nQL;
    private FrescoThumbnailView nQM;
    private View nQN;
    private FrescoThumbnailView nQO;
    private FrescoThumbnailView nQP;
    private FrescoThumbnailView nQQ;
    private TextView nQR;
    private TextView nQS;
    private LinearLayout nQT;
    private ComboNumView nQU;
    private int nQV;
    private int nQW;
    private a nQX;
    private c nQY;
    private boolean nQZ;
    private Animation nRa;
    private Animation nRb;
    private Animation.AnimationListener nRc;
    private boolean nRd;
    private long nRe;
    private b nRf;
    public int nRg;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nQW;
        giftFrameLayout.nQW = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nRe;
        giftFrameLayout.nRe = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nRg = i;
        if (this.nQM != null && this.nQX != null) {
            this.nQM.bV(this.nQX.nQs, this.nRg);
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
        this.nQV = 0;
        this.nQW = 0;
        this.isShowing = false;
        this.nQZ = false;
        this.nRd = false;
        this.nRg = b.d.zues_show_gift_animation;
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
        this.nQT = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nQL = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nQM = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nQQ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nQQ.setAnim(true);
        this.nQN = inflate.findViewById(b.e.rl_user_avatar);
        this.nQO = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nQP = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nQR = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nQS = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nQY = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dSt();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nQU = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nQU.setType(2);
        }
        this.nRa = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nRb = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nRc = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nQV - GiftFrameLayout.this.nQW;
                if (i > 150) {
                    GiftFrameLayout.this.nQW = (i / 10) + GiftFrameLayout.this.nQW;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nQW += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nQW += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nQW += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nQW += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nQW = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nQY != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nQY.Kt(1)) {
                            GiftFrameLayout.this.nQY.Ks(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nQX, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nQY.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nRa.setAnimationListener(this.nRc);
        this.nRb.setAnimationListener(this.nRc);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dSs() {
        return this.nQZ;
    }

    public void b(a aVar) {
        this.nQZ = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nQF == null) {
            this.nQF = tv.chushou.zues.widget.gift.a.a(this.nQL, -getWidth(), 0.0f, Double.valueOf(nQC * nQB).longValue());
            this.nQF.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nQX.nQt);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nQX != null) {
                        if (GiftFrameLayout.this.nQX.nQu != GiftFrameLayout.this.nQX.nQt) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nQX.nQu);
                            return;
                        }
                        GiftFrameLayout.this.nQW = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nQX, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nQF.setDuration(Double.valueOf(nQC * nQB).longValue());
        }
        if (this.nQG == null) {
            this.nQG = tv.chushou.zues.widget.gift.a.b(this.nQQ, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nQD * nQB).longValue());
            this.nQG.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nQQ != null) {
                        GiftFrameLayout.this.nQQ.setVisibility(0);
                    }
                }
            });
        } else {
            this.nQG.setDuration(Double.valueOf(nQD * nQB).longValue());
        }
        if (this.nQH == null) {
            this.nQH = tv.chushou.zues.widget.gift.a.a(this.nQF, this.nQG);
            this.nQH.start();
            return;
        }
        this.nQH.start();
    }

    public void a(long j, float f) {
        if (this.nRf != null) {
            this.nRf.dispose();
        }
        long j2 = this.nRe == 0 ? (long) (nQC * nQB) : 0L;
        if (this.nRe < j) {
            this.nRe = j;
        }
        if (this.nRe != 0) {
            this.nRf = g.a(0L, this.nRe, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dKM()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nRe == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nQZ = true;
            if (this.nQI == null) {
                this.nQI = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nQE * nQB).longValue(), 0);
                this.nQI.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nQQ != null) {
                            GiftFrameLayout.this.nQQ.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nQI.setDuration(Double.valueOf(nQE * nQB).longValue());
            }
            if (this.nQJ == null) {
                this.nQJ = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nQK == null) {
                this.nQK = tv.chushou.zues.widget.gift.a.a(this.nQI, this.nQJ);
                this.nQK.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nQX = null;
                        GiftFrameLayout.this.dSu();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nQK.start();
                return;
            }
            this.nQK.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSt() {
        int i;
        if (this.nQW > this.nQV) {
            this.nQW = this.nQV;
            if (this.nQY != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nQX, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nQY.removeMessages(1);
                return;
            }
            return;
        }
        this.nRd = this.nQW == this.nQV;
        this.nQU.setNumber(this.nQW);
        int i2 = this.nQV - this.nQW;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nRa.setDuration(i);
        this.nQU.startAnimation(this.nRd ? this.nRb : this.nRa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSu() {
        this.nQW = 0;
    }

    public void KL(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nQX != null) {
            this.nQX.nQu = i;
            setEndNumber(this.nQX.nQu);
        }
        if (this.nRf != null) {
            this.nRf.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nQW = i;
        this.nQU.setNumber(this.nQW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nQV = i;
        if (this.nQW == Integer.MAX_VALUE) {
            this.nQW = this.nQV;
        }
        if (this.nQY != null && !this.nQY.Kt(1)) {
            this.nQY.Ks(1);
        }
    }

    public a getGift() {
        return this.nQX;
    }

    private void setGift(a aVar) {
        this.nQX = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nQT.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nQN.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nQN.getLayoutParams();
            this.nQO.setVisibility(0);
            this.nQO.i(aVar.nQo, b.C0915b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nQp)) {
                this.nQP.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nQP.setVisibility(0);
                this.nQP.i(aVar.nQp, b.C0915b.float_transparent, b.C0924b.nQj, b.C0924b.nQj);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nQN.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nQQ.h(aVar.nQr, b.d.zues_btn_gift_icon, b.C0924b.nQi, b.C0924b.nQi);
        this.nQT.setLayoutParams(layoutParams);
        this.nQR.setText(aVar.mNickName);
        this.nQS.setText(aVar.nQq);
        this.nQM.bV(aVar.nQs, this.nRg);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nQH != null) {
            this.nQH.cancel();
            this.nQH = null;
        }
        if (this.nQF != null) {
            this.nQF.cancel();
            this.nQF = null;
        }
        if (this.nQG != null) {
            this.nQG.cancel();
            this.nQG = null;
        }
        if (this.nQK != null) {
            this.nQK.cancel();
            this.nQK = null;
        }
        if (this.nQI != null) {
            this.nQI.cancel();
            this.nQI = null;
        }
        if (this.nQJ != null) {
            this.nQJ.cancel();
            this.nQJ = null;
        }
        if (this.nRa != null) {
            this.nRa.cancel();
            this.nRa = null;
        }
        if (this.nRb != null) {
            this.nRb.cancel();
            this.nRb = null;
        }
        this.nRc = null;
        this.mInflater = null;
        this.mContext = null;
        this.nQL = null;
        this.nQM = null;
        this.nQO = null;
        this.nQQ = null;
        this.nQR = null;
        this.nQS = null;
        if (this.nQU != null) {
            this.nQU.release();
            this.nQU = null;
        }
        this.nQX = null;
        if (this.nQY != null) {
            this.nQY.cg(null);
            this.nQY = null;
        }
        if (this.nRf != null) {
            this.nRf.dispose();
        }
    }
}
