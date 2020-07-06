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
    public static double oms = 1.0d;
    public static double omt = 500.0d;
    public static double omu = 200.0d;
    public static double omv = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator omA;
    private AnimatorSet omB;
    private FrameLayout omC;
    private FrescoThumbnailView omD;
    private View omE;
    private FrescoThumbnailView omF;
    private FrescoThumbnailView omG;
    private FrescoThumbnailView omH;
    private TextView omI;
    private TextView omJ;
    private LinearLayout omK;
    private ComboNumView omL;
    private int omM;
    private int omN;
    private a omO;
    private c omP;
    private boolean omQ;
    private Animation omR;
    private Animation omS;
    private Animation.AnimationListener omT;
    private boolean omU;
    private long omV;
    private b omW;
    public int omX;
    private ObjectAnimator omw;
    private ObjectAnimator omx;
    private AnimatorSet omy;
    private ObjectAnimator omz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.omN;
        giftFrameLayout.omN = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.omV;
        giftFrameLayout.omV = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.omX = i;
        if (this.omD != null && this.omO != null) {
            this.omD.bU(this.omO.omj, this.omX);
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
        this.omM = 0;
        this.omN = 0;
        this.isShowing = false;
        this.omQ = false;
        this.omU = false;
        this.omX = b.d.zues_show_gift_animation;
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
        this.omK = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.omC = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.omD = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.omH = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.omH.setAnim(true);
        this.omE = inflate.findViewById(b.e.rl_user_avatar);
        this.omF = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.omG = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.omI = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.omJ = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.omP = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dXd();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.omL = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.omL.setType(2);
        }
        this.omR = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.omS = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.omT = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.omM - GiftFrameLayout.this.omN;
                if (i > 150) {
                    GiftFrameLayout.this.omN = (i / 10) + GiftFrameLayout.this.omN;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.omN += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.omN += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.omN += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.omN += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.omN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.omP != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.omP.LA(1)) {
                            GiftFrameLayout.this.omP.Lz(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.omO, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.omP.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.omR.setAnimationListener(this.omT);
        this.omS.setAnimationListener(this.omT);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dXc() {
        return this.omQ;
    }

    public void b(a aVar) {
        this.omQ = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.omw == null) {
            this.omw = tv.chushou.zues.widget.gift.a.a(this.omC, -getWidth(), 0.0f, Double.valueOf(omt * oms).longValue());
            this.omw.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.omO.omk);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.omO != null) {
                        if (GiftFrameLayout.this.omO.oml != GiftFrameLayout.this.omO.omk) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.omO.oml);
                            return;
                        }
                        GiftFrameLayout.this.omN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.omO, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.omw.setDuration(Double.valueOf(omt * oms).longValue());
        }
        if (this.omx == null) {
            this.omx = tv.chushou.zues.widget.gift.a.b(this.omH, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(omu * oms).longValue());
            this.omx.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.omH != null) {
                        GiftFrameLayout.this.omH.setVisibility(0);
                    }
                }
            });
        } else {
            this.omx.setDuration(Double.valueOf(omu * oms).longValue());
        }
        if (this.omy == null) {
            this.omy = tv.chushou.zues.widget.gift.a.a(this.omw, this.omx);
            this.omy.start();
            return;
        }
        this.omy.start();
    }

    public void a(long j, float f) {
        if (this.omW != null) {
            this.omW.dispose();
        }
        long j2 = this.omV == 0 ? (long) (omt * oms) : 0L;
        if (this.omV < j) {
            this.omV = j;
        }
        if (this.omV != 0) {
            this.omW = g.a(0L, this.omV, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dPw()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.omV == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.omQ = true;
            if (this.omz == null) {
                this.omz = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(omv * oms).longValue(), 0);
                this.omz.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.omH != null) {
                            GiftFrameLayout.this.omH.setVisibility(4);
                        }
                    }
                });
            } else {
                this.omz.setDuration(Double.valueOf(omv * oms).longValue());
            }
            if (this.omA == null) {
                this.omA = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.omB == null) {
                this.omB = tv.chushou.zues.widget.gift.a.a(this.omz, this.omA);
                this.omB.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.omO = null;
                        GiftFrameLayout.this.dXe();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.omB.start();
                return;
            }
            this.omB.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXd() {
        int i;
        if (this.omN > this.omM) {
            this.omN = this.omM;
            if (this.omP != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.omO, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.omP.removeMessages(1);
                return;
            }
            return;
        }
        this.omU = this.omN == this.omM;
        this.omL.setNumber(this.omN);
        int i2 = this.omM - this.omN;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.omR.setDuration(i);
        this.omL.startAnimation(this.omU ? this.omS : this.omR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXe() {
        this.omN = 0;
    }

    public void LR(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.omO != null) {
            this.omO.oml = i;
            setEndNumber(this.omO.oml);
        }
        if (this.omW != null) {
            this.omW.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.omN = i;
        this.omL.setNumber(this.omN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.omM = i;
        if (this.omN == Integer.MAX_VALUE) {
            this.omN = this.omM;
        }
        if (this.omP != null && !this.omP.LA(1)) {
            this.omP.Lz(1);
        }
    }

    public a getGift() {
        return this.omO;
    }

    private void setGift(a aVar) {
        this.omO = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omK.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.omE.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.omE.getLayoutParams();
            this.omF.setVisibility(0);
            this.omF.i(aVar.omf, b.C0935b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.omg)) {
                this.omG.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.omG.setVisibility(0);
                this.omG.i(aVar.omg, b.C0935b.float_transparent, b.C0944b.oma, b.C0944b.oma);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.omE.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.omH.h(aVar.omi, b.d.zues_btn_gift_icon, b.C0944b.olZ, b.C0944b.olZ);
        this.omK.setLayoutParams(layoutParams);
        this.omI.setText(aVar.mNickName);
        this.omJ.setText(aVar.omh);
        this.omD.bU(aVar.omj, this.omX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.omy != null) {
            this.omy.cancel();
            this.omy = null;
        }
        if (this.omw != null) {
            this.omw.cancel();
            this.omw = null;
        }
        if (this.omx != null) {
            this.omx.cancel();
            this.omx = null;
        }
        if (this.omB != null) {
            this.omB.cancel();
            this.omB = null;
        }
        if (this.omz != null) {
            this.omz.cancel();
            this.omz = null;
        }
        if (this.omA != null) {
            this.omA.cancel();
            this.omA = null;
        }
        if (this.omR != null) {
            this.omR.cancel();
            this.omR = null;
        }
        if (this.omS != null) {
            this.omS.cancel();
            this.omS = null;
        }
        this.omT = null;
        this.mInflater = null;
        this.mContext = null;
        this.omC = null;
        this.omD = null;
        this.omF = null;
        this.omH = null;
        this.omI = null;
        this.omJ = null;
        if (this.omL != null) {
            this.omL.release();
            this.omL = null;
        }
        this.omO = null;
        if (this.omP != null) {
            this.omP.ch(null);
            this.omP = null;
        }
        if (this.omW != null) {
            this.omW.dispose();
        }
    }
}
