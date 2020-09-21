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
    public static double oYL = 1.0d;
    public static double oYM = 500.0d;
    public static double oYN = 200.0d;
    public static double oYO = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator oYP;
    private ObjectAnimator oYQ;
    private AnimatorSet oYR;
    private ObjectAnimator oYS;
    private ObjectAnimator oYT;
    private AnimatorSet oYU;
    private FrameLayout oYV;
    private FrescoThumbnailView oYW;
    private View oYX;
    private FrescoThumbnailView oYY;
    private FrescoThumbnailView oYZ;
    private FrescoThumbnailView oZa;
    private TextView oZb;
    private TextView oZc;
    private LinearLayout oZd;
    private ComboNumView oZe;
    private int oZf;
    private int oZg;
    private a oZh;
    private c oZi;
    private boolean oZj;
    private Animation oZk;
    private Animation oZl;
    private Animation.AnimationListener oZm;
    private boolean oZn;
    private long oZo;
    private b oZp;
    public int oZq;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.oZg;
        giftFrameLayout.oZg = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.oZo;
        giftFrameLayout.oZo = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.oZq = i;
        if (this.oYW != null && this.oZh != null) {
            this.oYW.bX(this.oZh.oYC, this.oZq);
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
        this.oZf = 0;
        this.oZg = 0;
        this.isShowing = false;
        this.oZj = false;
        this.oZn = false;
        this.oZq = b.d.zues_show_gift_animation;
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
        this.oZd = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.oYV = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.oYW = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.oZa = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.oZa.setAnim(true);
        this.oYX = inflate.findViewById(b.e.rl_user_avatar);
        this.oYY = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.oYZ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.oZb = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.oZc = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.oZi = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.eqK();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.oZe = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.oZe.setType(2);
        }
        this.oZk = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.oZl = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.oZm = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.oZf - GiftFrameLayout.this.oZg;
                if (i > 150) {
                    GiftFrameLayout.this.oZg = (i / 10) + GiftFrameLayout.this.oZg;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.oZg += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.oZg += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.oZg += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.oZg += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.oZg = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.oZi != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.oZi.Pc(1)) {
                            GiftFrameLayout.this.oZi.Pb(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oZh, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.oZi.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oZk.setAnimationListener(this.oZm);
        this.oZl.setAnimationListener(this.oZm);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean eqJ() {
        return this.oZj;
    }

    public void b(a aVar) {
        this.oZj = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.oYP == null) {
            this.oYP = tv.chushou.zues.widget.gift.a.a(this.oYV, -getWidth(), 0.0f, Double.valueOf(oYM * oYL).longValue());
            this.oYP.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.oZh.oYD);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.oZh != null) {
                        if (GiftFrameLayout.this.oZh.oYE != GiftFrameLayout.this.oZh.oYD) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.oZh.oYE);
                            return;
                        }
                        GiftFrameLayout.this.oZg = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oZh, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.oYP.setDuration(Double.valueOf(oYM * oYL).longValue());
        }
        if (this.oYQ == null) {
            this.oYQ = tv.chushou.zues.widget.gift.a.b(this.oZa, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(oYN * oYL).longValue());
            this.oYQ.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.oZa != null) {
                        GiftFrameLayout.this.oZa.setVisibility(0);
                    }
                }
            });
        } else {
            this.oYQ.setDuration(Double.valueOf(oYN * oYL).longValue());
        }
        if (this.oYR == null) {
            this.oYR = tv.chushou.zues.widget.gift.a.a(this.oYP, this.oYQ);
            this.oYR.start();
            return;
        }
        this.oYR.start();
    }

    public void a(long j, float f) {
        if (this.oZp != null) {
            this.oZp.dispose();
        }
        long j2 = this.oZo == 0 ? (long) (oYM * oYL) : 0L;
        if (this.oZo < j) {
            this.oZo = j;
        }
        if (this.oZo != 0) {
            this.oZp = g.a(0L, this.oZo, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.ejb()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.oZo == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.oZj = true;
            if (this.oYS == null) {
                this.oYS = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(oYO * oYL).longValue(), 0);
                this.oYS.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.oZa != null) {
                            GiftFrameLayout.this.oZa.setVisibility(4);
                        }
                    }
                });
            } else {
                this.oYS.setDuration(Double.valueOf(oYO * oYL).longValue());
            }
            if (this.oYT == null) {
                this.oYT = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.oYU == null) {
                this.oYU = tv.chushou.zues.widget.gift.a.a(this.oYS, this.oYT);
                this.oYU.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.oZh = null;
                        GiftFrameLayout.this.eqL();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.oYU.start();
                return;
            }
            this.oYU.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eqK() {
        int i;
        if (this.oZg > this.oZf) {
            this.oZg = this.oZf;
            if (this.oZi != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.oZh, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.oZi.removeMessages(1);
                return;
            }
            return;
        }
        this.oZn = this.oZg == this.oZf;
        this.oZe.setNumber(this.oZg);
        int i2 = this.oZf - this.oZg;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.oZk.setDuration(i);
        this.oZe.startAnimation(this.oZn ? this.oZl : this.oZk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eqL() {
        this.oZg = 0;
    }

    public void Pt(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.oZh != null) {
            this.oZh.oYE = i;
            setEndNumber(this.oZh.oYE);
        }
        if (this.oZp != null) {
            this.oZp.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.oZg = i;
        this.oZe.setNumber(this.oZg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.oZf = i;
        if (this.oZg == Integer.MAX_VALUE) {
            this.oZg = this.oZf;
        }
        if (this.oZi != null && !this.oZi.Pc(1)) {
            this.oZi.Pb(1);
        }
    }

    public a getGift() {
        return this.oZh;
    }

    private void setGift(a aVar) {
        this.oZh = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oZd.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.oYX.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.oYX.getLayoutParams();
            this.oYY.setVisibility(0);
            this.oYY.i(aVar.oYy, b.C1005b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.oYz)) {
                this.oYZ.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.oYZ.setVisibility(0);
                this.oYZ.i(aVar.oYz, b.C1005b.float_transparent, b.C1014b.oYt, b.C1014b.oYt);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.oYX.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.oZa.h(aVar.oYB, b.d.zues_btn_gift_icon, b.C1014b.oYs, b.C1014b.oYs);
        this.oZd.setLayoutParams(layoutParams);
        this.oZb.setText(aVar.mNickName);
        this.oZc.setText(aVar.oYA);
        this.oYW.bX(aVar.oYC, this.oZq);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.oYR != null) {
            this.oYR.cancel();
            this.oYR = null;
        }
        if (this.oYP != null) {
            this.oYP.cancel();
            this.oYP = null;
        }
        if (this.oYQ != null) {
            this.oYQ.cancel();
            this.oYQ = null;
        }
        if (this.oYU != null) {
            this.oYU.cancel();
            this.oYU = null;
        }
        if (this.oYS != null) {
            this.oYS.cancel();
            this.oYS = null;
        }
        if (this.oYT != null) {
            this.oYT.cancel();
            this.oYT = null;
        }
        if (this.oZk != null) {
            this.oZk.cancel();
            this.oZk = null;
        }
        if (this.oZl != null) {
            this.oZl.cancel();
            this.oZl = null;
        }
        this.oZm = null;
        this.mInflater = null;
        this.mContext = null;
        this.oYV = null;
        this.oYW = null;
        this.oYY = null;
        this.oZa = null;
        this.oZb = null;
        this.oZc = null;
        if (this.oZe != null) {
            this.oZe.release();
            this.oZe = null;
        }
        this.oZh = null;
        if (this.oZi != null) {
            this.oZi.cl(null);
            this.oZi = null;
        }
        if (this.oZp != null) {
            this.oZp.dispose();
        }
    }
}
