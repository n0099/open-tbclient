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
    public static double qoO = 1.0d;
    public static double qoP = 500.0d;
    public static double qoQ = 200.0d;
    public static double qoR = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator qoS;
    private ObjectAnimator qoT;
    private AnimatorSet qoU;
    private ObjectAnimator qoV;
    private ObjectAnimator qoW;
    private AnimatorSet qoX;
    private FrameLayout qoY;
    private FrescoThumbnailView qoZ;
    private View qpa;
    private FrescoThumbnailView qpb;
    private FrescoThumbnailView qpc;
    private FrescoThumbnailView qpd;
    private TextView qpe;
    private TextView qpf;
    private LinearLayout qpg;
    private ComboNumView qph;
    private int qpi;
    private int qpj;
    private a qpk;
    private c qpl;
    private boolean qpm;
    private Animation qpn;
    private Animation qpo;
    private Animation.AnimationListener qpp;
    private boolean qpq;
    private long qpr;
    private b qps;
    public int qpt;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.qpj;
        giftFrameLayout.qpj = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.qpr;
        giftFrameLayout.qpr = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.qpt = i;
        if (this.qoZ != null && this.qpk != null) {
            this.qoZ.ce(this.qpk.qoF, this.qpt);
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
        this.qpi = 0;
        this.qpj = 0;
        this.isShowing = false;
        this.qpm = false;
        this.qpq = false;
        this.qpt = b.d.zues_show_gift_animation;
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
        this.qpg = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.qoY = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.qoZ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.qpd = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.qpd.setAnim(true);
        this.qpa = inflate.findViewById(b.e.rl_user_avatar);
        this.qpb = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.qpc = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.qpe = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.qpf = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.qpl = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.eIi();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.qph = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.qph.setType(2);
        }
        this.qpn = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.qpo = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.qpp = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.qpi - GiftFrameLayout.this.qpj;
                if (i > 150) {
                    GiftFrameLayout.this.qpj = (i / 10) + GiftFrameLayout.this.qpj;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.qpj += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.qpj += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.qpj += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.qpj += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.qpj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.qpl != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.qpl.RU(1)) {
                            GiftFrameLayout.this.qpl.RT(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.qpk, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.qpl.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.qpn.setAnimationListener(this.qpp);
        this.qpo.setAnimationListener(this.qpp);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean eIh() {
        return this.qpm;
    }

    public void b(a aVar) {
        this.qpm = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.qoS == null) {
            this.qoS = tv.chushou.zues.widget.gift.a.a(this.qoY, -getWidth(), 0.0f, Double.valueOf(qoP * qoO).longValue());
            this.qoS.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.qpk.qoG);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.qpk != null) {
                        if (GiftFrameLayout.this.qpk.qoH != GiftFrameLayout.this.qpk.qoG) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.qpk.qoH);
                            return;
                        }
                        GiftFrameLayout.this.qpj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.qpk, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.qoS.setDuration(Double.valueOf(qoP * qoO).longValue());
        }
        if (this.qoT == null) {
            this.qoT = tv.chushou.zues.widget.gift.a.b(this.qpd, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(qoQ * qoO).longValue());
            this.qoT.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.qpd != null) {
                        GiftFrameLayout.this.qpd.setVisibility(0);
                    }
                }
            });
        } else {
            this.qoT.setDuration(Double.valueOf(qoQ * qoO).longValue());
        }
        if (this.qoU == null) {
            this.qoU = tv.chushou.zues.widget.gift.a.a(this.qoS, this.qoT);
            this.qoU.start();
            return;
        }
        this.qoU.start();
    }

    public void a(long j, float f) {
        if (this.qps != null) {
            this.qps.dispose();
        }
        long j2 = this.qpr == 0 ? (long) (qoP * qoO) : 0L;
        if (this.qpr < j) {
            this.qpr = j;
        }
        if (this.qpr != 0) {
            this.qps = g.a(0L, this.qpr, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.eAB()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: k */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.qpr == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.qpm = true;
            if (this.qoV == null) {
                this.qoV = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(qoR * qoO).longValue(), 0);
                this.qoV.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.qpd != null) {
                            GiftFrameLayout.this.qpd.setVisibility(4);
                        }
                    }
                });
            } else {
                this.qoV.setDuration(Double.valueOf(qoR * qoO).longValue());
            }
            if (this.qoW == null) {
                this.qoW = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.qoX == null) {
                this.qoX = tv.chushou.zues.widget.gift.a.a(this.qoV, this.qoW);
                this.qoX.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.qpk = null;
                        GiftFrameLayout.this.eIj();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.qoX.start();
                return;
            }
            this.qoX.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eIi() {
        int i;
        if (this.qpj > this.qpi) {
            this.qpj = this.qpi;
            if (this.qpl != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.qpk, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.qpl.removeMessages(1);
                return;
            }
            return;
        }
        this.qpq = this.qpj == this.qpi;
        this.qph.setNumber(this.qpj);
        int i2 = this.qpi - this.qpj;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.qpn.setDuration(i);
        this.qph.startAnimation(this.qpq ? this.qpo : this.qpn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eIj() {
        this.qpj = 0;
    }

    public void Sk(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.qpk != null) {
            this.qpk.qoH = i;
            setEndNumber(this.qpk.qoH);
        }
        if (this.qps != null) {
            this.qps.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.qpj = i;
        this.qph.setNumber(this.qpj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.qpi = i;
        if (this.qpj == Integer.MAX_VALUE) {
            this.qpj = this.qpi;
        }
        if (this.qpl != null && !this.qpl.RU(1)) {
            this.qpl.RT(1);
        }
    }

    public a getGift() {
        return this.qpk;
    }

    private void setGift(a aVar) {
        this.qpk = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qpg.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.qpa.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.qpa.getLayoutParams();
            this.qpb.setVisibility(0);
            this.qpb.i(aVar.qoB, b.C1115b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.qoC)) {
                this.qpc.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.qpc.setVisibility(0);
                this.qpc.i(aVar.qoC, b.C1115b.float_transparent, b.C1124b.qow, b.C1124b.qow);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.qpa.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.qpd.h(aVar.qoE, b.d.zues_btn_gift_icon, b.C1124b.qov, b.C1124b.qov);
        this.qpg.setLayoutParams(layoutParams);
        this.qpe.setText(aVar.mNickName);
        this.qpf.setText(aVar.qoD);
        this.qoZ.ce(aVar.qoF, this.qpt);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.qoU != null) {
            this.qoU.cancel();
            this.qoU = null;
        }
        if (this.qoS != null) {
            this.qoS.cancel();
            this.qoS = null;
        }
        if (this.qoT != null) {
            this.qoT.cancel();
            this.qoT = null;
        }
        if (this.qoX != null) {
            this.qoX.cancel();
            this.qoX = null;
        }
        if (this.qoV != null) {
            this.qoV.cancel();
            this.qoV = null;
        }
        if (this.qoW != null) {
            this.qoW.cancel();
            this.qoW = null;
        }
        if (this.qpn != null) {
            this.qpn.cancel();
            this.qpn = null;
        }
        if (this.qpo != null) {
            this.qpo.cancel();
            this.qpo = null;
        }
        this.qpp = null;
        this.mInflater = null;
        this.mContext = null;
        this.qoY = null;
        this.qoZ = null;
        this.qpb = null;
        this.qpd = null;
        this.qpe = null;
        this.qpf = null;
        if (this.qph != null) {
            this.qph.release();
            this.qph = null;
        }
        this.qpk = null;
        if (this.qpl != null) {
            this.qpl.cs(null);
            this.qpl = null;
        }
        if (this.qps != null) {
            this.qps.dispose();
        }
    }
}
