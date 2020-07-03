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
    public static double omp = 1.0d;
    public static double omq = 500.0d;
    public static double omr = 200.0d;
    public static double oms = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private FrescoThumbnailView omA;
    private View omB;
    private FrescoThumbnailView omC;
    private FrescoThumbnailView omD;
    private FrescoThumbnailView omE;
    private TextView omF;
    private TextView omG;
    private LinearLayout omH;
    private ComboNumView omI;
    private int omJ;
    private int omK;
    private a omL;
    private c omM;
    private boolean omN;
    private Animation omO;
    private Animation omP;
    private Animation.AnimationListener omQ;
    private boolean omR;
    private long omS;
    private b omT;
    public int omU;
    private ObjectAnimator omt;
    private ObjectAnimator omu;
    private AnimatorSet omv;
    private ObjectAnimator omw;
    private ObjectAnimator omx;
    private AnimatorSet omy;
    private FrameLayout omz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.omK;
        giftFrameLayout.omK = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.omS;
        giftFrameLayout.omS = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.omU = i;
        if (this.omA != null && this.omL != null) {
            this.omA.bU(this.omL.omg, this.omU);
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
        this.omJ = 0;
        this.omK = 0;
        this.isShowing = false;
        this.omN = false;
        this.omR = false;
        this.omU = b.d.zues_show_gift_animation;
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
        this.omH = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.omz = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.omA = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.omE = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.omE.setAnim(true);
        this.omB = inflate.findViewById(b.e.rl_user_avatar);
        this.omC = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.omD = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.omF = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.omG = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.omM = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dWZ();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.omI = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.omI.setType(2);
        }
        this.omO = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.omP = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.omQ = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.omJ - GiftFrameLayout.this.omK;
                if (i > 150) {
                    GiftFrameLayout.this.omK = (i / 10) + GiftFrameLayout.this.omK;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.omK += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.omK += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.omK += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.omK += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.omK = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.omM != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.omM.LA(1)) {
                            GiftFrameLayout.this.omM.Lz(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.omL, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.omM.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.omO.setAnimationListener(this.omQ);
        this.omP.setAnimationListener(this.omQ);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dWY() {
        return this.omN;
    }

    public void b(a aVar) {
        this.omN = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.omt == null) {
            this.omt = tv.chushou.zues.widget.gift.a.a(this.omz, -getWidth(), 0.0f, Double.valueOf(omq * omp).longValue());
            this.omt.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.omL.omh);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.omL != null) {
                        if (GiftFrameLayout.this.omL.omi != GiftFrameLayout.this.omL.omh) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.omL.omi);
                            return;
                        }
                        GiftFrameLayout.this.omK = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.omL, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.omt.setDuration(Double.valueOf(omq * omp).longValue());
        }
        if (this.omu == null) {
            this.omu = tv.chushou.zues.widget.gift.a.b(this.omE, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(omr * omp).longValue());
            this.omu.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.omE != null) {
                        GiftFrameLayout.this.omE.setVisibility(0);
                    }
                }
            });
        } else {
            this.omu.setDuration(Double.valueOf(omr * omp).longValue());
        }
        if (this.omv == null) {
            this.omv = tv.chushou.zues.widget.gift.a.a(this.omt, this.omu);
            this.omv.start();
            return;
        }
        this.omv.start();
    }

    public void a(long j, float f) {
        if (this.omT != null) {
            this.omT.dispose();
        }
        long j2 = this.omS == 0 ? (long) (omq * omp) : 0L;
        if (this.omS < j) {
            this.omS = j;
        }
        if (this.omS != 0) {
            this.omT = g.a(0L, this.omS, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dPs()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.omS == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.omN = true;
            if (this.omw == null) {
                this.omw = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(oms * omp).longValue(), 0);
                this.omw.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.omE != null) {
                            GiftFrameLayout.this.omE.setVisibility(4);
                        }
                    }
                });
            } else {
                this.omw.setDuration(Double.valueOf(oms * omp).longValue());
            }
            if (this.omx == null) {
                this.omx = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.omy == null) {
                this.omy = tv.chushou.zues.widget.gift.a.a(this.omw, this.omx);
                this.omy.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.omL = null;
                        GiftFrameLayout.this.dXa();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.omy.start();
                return;
            }
            this.omy.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWZ() {
        int i;
        if (this.omK > this.omJ) {
            this.omK = this.omJ;
            if (this.omM != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.omL, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.omM.removeMessages(1);
                return;
            }
            return;
        }
        this.omR = this.omK == this.omJ;
        this.omI.setNumber(this.omK);
        int i2 = this.omJ - this.omK;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.omO.setDuration(i);
        this.omI.startAnimation(this.omR ? this.omP : this.omO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXa() {
        this.omK = 0;
    }

    public void LR(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.omL != null) {
            this.omL.omi = i;
            setEndNumber(this.omL.omi);
        }
        if (this.omT != null) {
            this.omT.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.omK = i;
        this.omI.setNumber(this.omK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.omJ = i;
        if (this.omK == Integer.MAX_VALUE) {
            this.omK = this.omJ;
        }
        if (this.omM != null && !this.omM.LA(1)) {
            this.omM.Lz(1);
        }
    }

    public a getGift() {
        return this.omL;
    }

    private void setGift(a aVar) {
        this.omL = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omH.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.omB.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.omB.getLayoutParams();
            this.omC.setVisibility(0);
            this.omC.i(aVar.omc, b.C0934b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.omd)) {
                this.omD.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.omD.setVisibility(0);
                this.omD.i(aVar.omd, b.C0934b.float_transparent, b.C0943b.olX, b.C0943b.olX);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.omB.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.omE.h(aVar.omf, b.d.zues_btn_gift_icon, b.C0943b.olW, b.C0943b.olW);
        this.omH.setLayoutParams(layoutParams);
        this.omF.setText(aVar.mNickName);
        this.omG.setText(aVar.ome);
        this.omA.bU(aVar.omg, this.omU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.omv != null) {
            this.omv.cancel();
            this.omv = null;
        }
        if (this.omt != null) {
            this.omt.cancel();
            this.omt = null;
        }
        if (this.omu != null) {
            this.omu.cancel();
            this.omu = null;
        }
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
        if (this.omO != null) {
            this.omO.cancel();
            this.omO = null;
        }
        if (this.omP != null) {
            this.omP.cancel();
            this.omP = null;
        }
        this.omQ = null;
        this.mInflater = null;
        this.mContext = null;
        this.omz = null;
        this.omA = null;
        this.omC = null;
        this.omE = null;
        this.omF = null;
        this.omG = null;
        if (this.omI != null) {
            this.omI.release();
            this.omI = null;
        }
        this.omL = null;
        if (this.omM != null) {
            this.omM.ch(null);
            this.omM = null;
        }
        if (this.omT != null) {
            this.omT.dispose();
        }
    }
}
