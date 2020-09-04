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
    public static double oPj = 1.0d;
    public static double oPk = 500.0d;
    public static double oPl = 200.0d;
    public static double oPm = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private TextView oPA;
    private LinearLayout oPB;
    private ComboNumView oPC;
    private int oPD;
    private int oPE;
    private a oPF;
    private c oPG;
    private boolean oPH;
    private Animation oPI;
    private Animation oPJ;
    private Animation.AnimationListener oPK;
    private boolean oPL;
    private long oPM;
    private b oPN;
    public int oPO;
    private ObjectAnimator oPn;
    private ObjectAnimator oPo;
    private AnimatorSet oPp;
    private ObjectAnimator oPq;
    private ObjectAnimator oPr;
    private AnimatorSet oPs;
    private FrameLayout oPt;
    private FrescoThumbnailView oPu;
    private View oPv;
    private FrescoThumbnailView oPw;
    private FrescoThumbnailView oPx;
    private FrescoThumbnailView oPy;
    private TextView oPz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.oPE;
        giftFrameLayout.oPE = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.oPM;
        giftFrameLayout.oPM = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.oPO = i;
        if (this.oPu != null && this.oPF != null) {
            this.oPu.bX(this.oPF.oPa, this.oPO);
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
        this.oPD = 0;
        this.oPE = 0;
        this.isShowing = false;
        this.oPH = false;
        this.oPL = false;
        this.oPO = b.d.zues_show_gift_animation;
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
        this.oPB = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.oPt = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.oPu = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.oPy = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.oPy.setAnim(true);
        this.oPv = inflate.findViewById(b.e.rl_user_avatar);
        this.oPw = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.oPx = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.oPz = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.oPA = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.oPG = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.emM();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.oPC = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.oPC.setType(2);
        }
        this.oPI = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.oPJ = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.oPK = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.oPD - GiftFrameLayout.this.oPE;
                if (i > 150) {
                    GiftFrameLayout.this.oPE = (i / 10) + GiftFrameLayout.this.oPE;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.oPE += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.oPE += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.oPE += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.oPE += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.oPE = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.oPG != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.oPG.Ox(1)) {
                            GiftFrameLayout.this.oPG.Ow(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oPF, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.oPG.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oPI.setAnimationListener(this.oPK);
        this.oPJ.setAnimationListener(this.oPK);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean emL() {
        return this.oPH;
    }

    public void b(a aVar) {
        this.oPH = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.oPn == null) {
            this.oPn = tv.chushou.zues.widget.gift.a.a(this.oPt, -getWidth(), 0.0f, Double.valueOf(oPk * oPj).longValue());
            this.oPn.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.oPF.oPb);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.oPF != null) {
                        if (GiftFrameLayout.this.oPF.oPc != GiftFrameLayout.this.oPF.oPb) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.oPF.oPc);
                            return;
                        }
                        GiftFrameLayout.this.oPE = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oPF, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.oPn.setDuration(Double.valueOf(oPk * oPj).longValue());
        }
        if (this.oPo == null) {
            this.oPo = tv.chushou.zues.widget.gift.a.b(this.oPy, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(oPl * oPj).longValue());
            this.oPo.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.oPy != null) {
                        GiftFrameLayout.this.oPy.setVisibility(0);
                    }
                }
            });
        } else {
            this.oPo.setDuration(Double.valueOf(oPl * oPj).longValue());
        }
        if (this.oPp == null) {
            this.oPp = tv.chushou.zues.widget.gift.a.a(this.oPn, this.oPo);
            this.oPp.start();
            return;
        }
        this.oPp.start();
    }

    public void a(long j, float f) {
        if (this.oPN != null) {
            this.oPN.dispose();
        }
        long j2 = this.oPM == 0 ? (long) (oPk * oPj) : 0L;
        if (this.oPM < j) {
            this.oPM = j;
        }
        if (this.oPM != 0) {
            this.oPN = g.a(0L, this.oPM, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.efe()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.oPM == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.oPH = true;
            if (this.oPq == null) {
                this.oPq = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(oPm * oPj).longValue(), 0);
                this.oPq.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.oPy != null) {
                            GiftFrameLayout.this.oPy.setVisibility(4);
                        }
                    }
                });
            } else {
                this.oPq.setDuration(Double.valueOf(oPm * oPj).longValue());
            }
            if (this.oPr == null) {
                this.oPr = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.oPs == null) {
                this.oPs = tv.chushou.zues.widget.gift.a.a(this.oPq, this.oPr);
                this.oPs.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.oPF = null;
                        GiftFrameLayout.this.emN();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.oPs.start();
                return;
            }
            this.oPs.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emM() {
        int i;
        if (this.oPE > this.oPD) {
            this.oPE = this.oPD;
            if (this.oPG != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.oPF, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.oPG.removeMessages(1);
                return;
            }
            return;
        }
        this.oPL = this.oPE == this.oPD;
        this.oPC.setNumber(this.oPE);
        int i2 = this.oPD - this.oPE;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.oPI.setDuration(i);
        this.oPC.startAnimation(this.oPL ? this.oPJ : this.oPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emN() {
        this.oPE = 0;
    }

    public void OO(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.oPF != null) {
            this.oPF.oPc = i;
            setEndNumber(this.oPF.oPc);
        }
        if (this.oPN != null) {
            this.oPN.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.oPE = i;
        this.oPC.setNumber(this.oPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.oPD = i;
        if (this.oPE == Integer.MAX_VALUE) {
            this.oPE = this.oPD;
        }
        if (this.oPG != null && !this.oPG.Ox(1)) {
            this.oPG.Ow(1);
        }
    }

    public a getGift() {
        return this.oPF;
    }

    private void setGift(a aVar) {
        this.oPF = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oPB.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.oPv.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.oPv.getLayoutParams();
            this.oPw.setVisibility(0);
            this.oPw.i(aVar.oOW, b.C1008b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.oOX)) {
                this.oPx.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.oPx.setVisibility(0);
                this.oPx.i(aVar.oOX, b.C1008b.float_transparent, b.C1017b.oOR, b.C1017b.oOR);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.oPv.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.oPy.h(aVar.oOZ, b.d.zues_btn_gift_icon, b.C1017b.oOQ, b.C1017b.oOQ);
        this.oPB.setLayoutParams(layoutParams);
        this.oPz.setText(aVar.mNickName);
        this.oPA.setText(aVar.oOY);
        this.oPu.bX(aVar.oPa, this.oPO);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.oPp != null) {
            this.oPp.cancel();
            this.oPp = null;
        }
        if (this.oPn != null) {
            this.oPn.cancel();
            this.oPn = null;
        }
        if (this.oPo != null) {
            this.oPo.cancel();
            this.oPo = null;
        }
        if (this.oPs != null) {
            this.oPs.cancel();
            this.oPs = null;
        }
        if (this.oPq != null) {
            this.oPq.cancel();
            this.oPq = null;
        }
        if (this.oPr != null) {
            this.oPr.cancel();
            this.oPr = null;
        }
        if (this.oPI != null) {
            this.oPI.cancel();
            this.oPI = null;
        }
        if (this.oPJ != null) {
            this.oPJ.cancel();
            this.oPJ = null;
        }
        this.oPK = null;
        this.mInflater = null;
        this.mContext = null;
        this.oPt = null;
        this.oPu = null;
        this.oPw = null;
        this.oPy = null;
        this.oPz = null;
        this.oPA = null;
        if (this.oPC != null) {
            this.oPC.release();
            this.oPC = null;
        }
        this.oPF = null;
        if (this.oPG != null) {
            this.oPG.cl(null);
            this.oPG = null;
        }
        if (this.oPN != null) {
            this.oPN.dispose();
        }
    }
}
