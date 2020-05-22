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
    public static double nPr = 1.0d;
    public static double nPs = 500.0d;
    public static double nPt = 200.0d;
    public static double nPu = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private AnimatorSet nPA;
    private FrameLayout nPB;
    private FrescoThumbnailView nPC;
    private View nPD;
    private FrescoThumbnailView nPE;
    private FrescoThumbnailView nPF;
    private FrescoThumbnailView nPG;
    private TextView nPH;
    private TextView nPI;
    private LinearLayout nPJ;
    private ComboNumView nPK;
    private int nPL;
    private int nPM;
    private a nPN;
    private c nPO;
    private boolean nPP;
    private Animation nPQ;
    private Animation nPR;
    private Animation.AnimationListener nPS;
    private boolean nPT;
    private long nPU;
    private b nPV;
    public int nPW;
    private ObjectAnimator nPv;
    private ObjectAnimator nPw;
    private AnimatorSet nPx;
    private ObjectAnimator nPy;
    private ObjectAnimator nPz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nPM;
        giftFrameLayout.nPM = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nPU;
        giftFrameLayout.nPU = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nPW = i;
        if (this.nPC != null && this.nPN != null) {
            this.nPC.bV(this.nPN.nPi, this.nPW);
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
        this.nPL = 0;
        this.nPM = 0;
        this.isShowing = false;
        this.nPP = false;
        this.nPT = false;
        this.nPW = b.d.zues_show_gift_animation;
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
        this.nPJ = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nPB = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nPC = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nPG = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nPG.setAnim(true);
        this.nPD = inflate.findViewById(b.e.rl_user_avatar);
        this.nPE = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nPF = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nPH = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nPI = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nPO = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dSf();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nPK = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nPK.setType(2);
        }
        this.nPQ = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nPR = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nPS = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nPL - GiftFrameLayout.this.nPM;
                if (i > 150) {
                    GiftFrameLayout.this.nPM = (i / 10) + GiftFrameLayout.this.nPM;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nPM += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nPM += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nPM += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nPM += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nPM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nPO != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nPO.Kr(1)) {
                            GiftFrameLayout.this.nPO.Kq(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nPN, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nPO.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nPQ.setAnimationListener(this.nPS);
        this.nPR.setAnimationListener(this.nPS);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dSe() {
        return this.nPP;
    }

    public void b(a aVar) {
        this.nPP = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nPv == null) {
            this.nPv = tv.chushou.zues.widget.gift.a.a(this.nPB, -getWidth(), 0.0f, Double.valueOf(nPs * nPr).longValue());
            this.nPv.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nPN.nPj);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nPN != null) {
                        if (GiftFrameLayout.this.nPN.nPk != GiftFrameLayout.this.nPN.nPj) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nPN.nPk);
                            return;
                        }
                        GiftFrameLayout.this.nPM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nPN, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nPv.setDuration(Double.valueOf(nPs * nPr).longValue());
        }
        if (this.nPw == null) {
            this.nPw = tv.chushou.zues.widget.gift.a.b(this.nPG, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nPt * nPr).longValue());
            this.nPw.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nPG != null) {
                        GiftFrameLayout.this.nPG.setVisibility(0);
                    }
                }
            });
        } else {
            this.nPw.setDuration(Double.valueOf(nPt * nPr).longValue());
        }
        if (this.nPx == null) {
            this.nPx = tv.chushou.zues.widget.gift.a.a(this.nPv, this.nPw);
            this.nPx.start();
            return;
        }
        this.nPx.start();
    }

    public void a(long j, float f) {
        if (this.nPV != null) {
            this.nPV.dispose();
        }
        long j2 = this.nPU == 0 ? (long) (nPs * nPr) : 0L;
        if (this.nPU < j) {
            this.nPU = j;
        }
        if (this.nPU != 0) {
            this.nPV = g.a(0L, this.nPU, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dKy()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nPU == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nPP = true;
            if (this.nPy == null) {
                this.nPy = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nPu * nPr).longValue(), 0);
                this.nPy.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nPG != null) {
                            GiftFrameLayout.this.nPG.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nPy.setDuration(Double.valueOf(nPu * nPr).longValue());
            }
            if (this.nPz == null) {
                this.nPz = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nPA == null) {
                this.nPA = tv.chushou.zues.widget.gift.a.a(this.nPy, this.nPz);
                this.nPA.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nPN = null;
                        GiftFrameLayout.this.dSg();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nPA.start();
                return;
            }
            this.nPA.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSf() {
        int i;
        if (this.nPM > this.nPL) {
            this.nPM = this.nPL;
            if (this.nPO != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nPN, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nPO.removeMessages(1);
                return;
            }
            return;
        }
        this.nPT = this.nPM == this.nPL;
        this.nPK.setNumber(this.nPM);
        int i2 = this.nPL - this.nPM;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nPQ.setDuration(i);
        this.nPK.startAnimation(this.nPT ? this.nPR : this.nPQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSg() {
        this.nPM = 0;
    }

    public void KJ(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nPN != null) {
            this.nPN.nPk = i;
            setEndNumber(this.nPN.nPk);
        }
        if (this.nPV != null) {
            this.nPV.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nPM = i;
        this.nPK.setNumber(this.nPM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nPL = i;
        if (this.nPM == Integer.MAX_VALUE) {
            this.nPM = this.nPL;
        }
        if (this.nPO != null && !this.nPO.Kr(1)) {
            this.nPO.Kq(1);
        }
    }

    public a getGift() {
        return this.nPN;
    }

    private void setGift(a aVar) {
        this.nPN = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nPJ.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nPD.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nPD.getLayoutParams();
            this.nPE.setVisibility(0);
            this.nPE.i(aVar.nPe, b.C0914b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nPf)) {
                this.nPF.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nPF.setVisibility(0);
                this.nPF.i(aVar.nPf, b.C0914b.float_transparent, b.C0923b.nOZ, b.C0923b.nOZ);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nPD.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nPG.h(aVar.nPh, b.d.zues_btn_gift_icon, b.C0923b.nOY, b.C0923b.nOY);
        this.nPJ.setLayoutParams(layoutParams);
        this.nPH.setText(aVar.mNickName);
        this.nPI.setText(aVar.nPg);
        this.nPC.bV(aVar.nPi, this.nPW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nPx != null) {
            this.nPx.cancel();
            this.nPx = null;
        }
        if (this.nPv != null) {
            this.nPv.cancel();
            this.nPv = null;
        }
        if (this.nPw != null) {
            this.nPw.cancel();
            this.nPw = null;
        }
        if (this.nPA != null) {
            this.nPA.cancel();
            this.nPA = null;
        }
        if (this.nPy != null) {
            this.nPy.cancel();
            this.nPy = null;
        }
        if (this.nPz != null) {
            this.nPz.cancel();
            this.nPz = null;
        }
        if (this.nPQ != null) {
            this.nPQ.cancel();
            this.nPQ = null;
        }
        if (this.nPR != null) {
            this.nPR.cancel();
            this.nPR = null;
        }
        this.nPS = null;
        this.mInflater = null;
        this.mContext = null;
        this.nPB = null;
        this.nPC = null;
        this.nPE = null;
        this.nPG = null;
        this.nPH = null;
        this.nPI = null;
        if (this.nPK != null) {
            this.nPK.release();
            this.nPK = null;
        }
        this.nPN = null;
        if (this.nPO != null) {
            this.nPO.cg(null);
            this.nPO = null;
        }
        if (this.nPV != null) {
            this.nPV.dispose();
        }
    }
}
