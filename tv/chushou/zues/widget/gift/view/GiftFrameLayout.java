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
    public static double nus = 1.0d;
    public static double nut = 500.0d;
    public static double nuu = 200.0d;
    public static double nuv = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nuA;
    private AnimatorSet nuB;
    private FrameLayout nuC;
    private FrescoThumbnailView nuD;
    private View nuE;
    private FrescoThumbnailView nuF;
    private FrescoThumbnailView nuG;
    private FrescoThumbnailView nuH;
    private TextView nuI;
    private TextView nuJ;
    private LinearLayout nuK;
    private ComboNumView nuL;
    private int nuM;
    private int nuN;
    private a nuO;
    private c nuP;
    private boolean nuQ;
    private Animation nuR;
    private Animation nuS;
    private Animation.AnimationListener nuT;
    private boolean nuU;
    private long nuV;
    private b nuW;
    public int nuX;
    private ObjectAnimator nuw;
    private ObjectAnimator nux;
    private AnimatorSet nuy;
    private ObjectAnimator nuz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nuN;
        giftFrameLayout.nuN = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nuV;
        giftFrameLayout.nuV = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nuX = i;
        if (this.nuD != null && this.nuO != null) {
            this.nuD.bU(this.nuO.nui, this.nuX);
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
        this.nuM = 0;
        this.nuN = 0;
        this.isShowing = false;
        this.nuQ = false;
        this.nuU = false;
        this.nuX = b.d.zues_show_gift_animation;
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
        this.nuK = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nuC = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nuD = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nuH = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nuH.setAnim(true);
        this.nuE = inflate.findViewById(b.e.rl_user_avatar);
        this.nuF = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nuG = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nuI = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nuJ = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nuP = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dKo();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nuL = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nuL.setType(2);
        }
        this.nuR = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nuS = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nuT = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nuM - GiftFrameLayout.this.nuN;
                if (i > 150) {
                    GiftFrameLayout.this.nuN = (i / 10) + GiftFrameLayout.this.nuN;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nuN += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nuN += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nuN += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nuN += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nuN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nuP != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nuP.JG(1)) {
                            GiftFrameLayout.this.nuP.JF(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nuO, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nuP.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nuR.setAnimationListener(this.nuT);
        this.nuS.setAnimationListener(this.nuT);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dKn() {
        return this.nuQ;
    }

    public void b(a aVar) {
        this.nuQ = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nuw == null) {
            this.nuw = tv.chushou.zues.widget.gift.a.a(this.nuC, -getWidth(), 0.0f, Double.valueOf(nut * nus).longValue());
            this.nuw.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nuO.nuj);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nuO != null) {
                        if (GiftFrameLayout.this.nuO.nuk != GiftFrameLayout.this.nuO.nuj) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nuO.nuk);
                            return;
                        }
                        GiftFrameLayout.this.nuN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nuO, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nuw.setDuration(Double.valueOf(nut * nus).longValue());
        }
        if (this.nux == null) {
            this.nux = tv.chushou.zues.widget.gift.a.b(this.nuH, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nuu * nus).longValue());
            this.nux.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nuH != null) {
                        GiftFrameLayout.this.nuH.setVisibility(0);
                    }
                }
            });
        } else {
            this.nux.setDuration(Double.valueOf(nuu * nus).longValue());
        }
        if (this.nuy == null) {
            this.nuy = tv.chushou.zues.widget.gift.a.a(this.nuw, this.nux);
            this.nuy.start();
            return;
        }
        this.nuy.start();
    }

    public void a(long j, float f) {
        if (this.nuW != null) {
            this.nuW.dispose();
        }
        long j2 = this.nuV == 0 ? (long) (nut * nus) : 0L;
        if (this.nuV < j) {
            this.nuV = j;
        }
        if (this.nuV != 0) {
            this.nuW = g.a(0L, this.nuV, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dCH()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nuV == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nuQ = true;
            if (this.nuz == null) {
                this.nuz = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nuv * nus).longValue(), 0);
                this.nuz.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nuH != null) {
                            GiftFrameLayout.this.nuH.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nuz.setDuration(Double.valueOf(nuv * nus).longValue());
            }
            if (this.nuA == null) {
                this.nuA = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nuB == null) {
                this.nuB = tv.chushou.zues.widget.gift.a.a(this.nuz, this.nuA);
                this.nuB.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nuO = null;
                        GiftFrameLayout.this.dKp();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nuB.start();
                return;
            }
            this.nuB.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKo() {
        int i;
        if (this.nuN > this.nuM) {
            this.nuN = this.nuM;
            if (this.nuP != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nuO, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nuP.removeMessages(1);
                return;
            }
            return;
        }
        this.nuU = this.nuN == this.nuM;
        this.nuL.setNumber(this.nuN);
        int i2 = this.nuM - this.nuN;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nuR.setDuration(i);
        this.nuL.startAnimation(this.nuU ? this.nuS : this.nuR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKp() {
        this.nuN = 0;
    }

    public void JY(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nuO != null) {
            this.nuO.nuk = i;
            setEndNumber(this.nuO.nuk);
        }
        if (this.nuW != null) {
            this.nuW.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nuN = i;
        this.nuL.setNumber(this.nuN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nuM = i;
        if (this.nuN == Integer.MAX_VALUE) {
            this.nuN = this.nuM;
        }
        if (this.nuP != null && !this.nuP.JG(1)) {
            this.nuP.JF(1);
        }
    }

    public a getGift() {
        return this.nuO;
    }

    private void setGift(a aVar) {
        this.nuO = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nuK.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nuE.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nuE.getLayoutParams();
            this.nuF.setVisibility(0);
            this.nuF.i(aVar.nue, b.C0831b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nuf)) {
                this.nuG.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nuG.setVisibility(0);
                this.nuG.i(aVar.nuf, b.C0831b.float_transparent, b.C0840b.ntZ, b.C0840b.ntZ);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nuE.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nuH.h(aVar.nuh, b.d.zues_btn_gift_icon, b.C0840b.ntY, b.C0840b.ntY);
        this.nuK.setLayoutParams(layoutParams);
        this.nuI.setText(aVar.mNickName);
        this.nuJ.setText(aVar.nug);
        this.nuD.bU(aVar.nui, this.nuX);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.nuy != null) {
            this.nuy.cancel();
            this.nuy = null;
        }
        if (this.nuw != null) {
            this.nuw.cancel();
            this.nuw = null;
        }
        if (this.nux != null) {
            this.nux.cancel();
            this.nux = null;
        }
        if (this.nuB != null) {
            this.nuB.cancel();
            this.nuB = null;
        }
        if (this.nuz != null) {
            this.nuz.cancel();
            this.nuz = null;
        }
        if (this.nuA != null) {
            this.nuA.cancel();
            this.nuA = null;
        }
        if (this.nuR != null) {
            this.nuR.cancel();
            this.nuR = null;
        }
        if (this.nuS != null) {
            this.nuS.cancel();
            this.nuS = null;
        }
        this.nuT = null;
        this.mInflater = null;
        this.mContext = null;
        this.nuC = null;
        this.nuD = null;
        this.nuF = null;
        this.nuH = null;
        this.nuI = null;
        this.nuJ = null;
        if (this.nuL != null) {
            this.nuL.release();
            this.nuL = null;
        }
        this.nuO = null;
        if (this.nuP != null) {
            this.nuP.bZ(null);
            this.nuP = null;
        }
        if (this.nuW != null) {
            this.nuW.dispose();
        }
    }
}
