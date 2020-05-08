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
    public static double nuv = 1.0d;
    public static double nuw = 500.0d;
    public static double nux = 200.0d;
    public static double nuy = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator nuA;
    private AnimatorSet nuB;
    private ObjectAnimator nuC;
    private ObjectAnimator nuD;
    private AnimatorSet nuE;
    private FrameLayout nuF;
    private FrescoThumbnailView nuG;
    private View nuH;
    private FrescoThumbnailView nuI;
    private FrescoThumbnailView nuJ;
    private FrescoThumbnailView nuK;
    private TextView nuL;
    private TextView nuM;
    private LinearLayout nuN;
    private ComboNumView nuO;
    private int nuP;
    private int nuQ;
    private a nuR;
    private c nuS;
    private boolean nuT;
    private Animation nuU;
    private Animation nuV;
    private Animation.AnimationListener nuW;
    private boolean nuX;
    private long nuY;
    private b nuZ;
    private ObjectAnimator nuz;
    public int nva;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.nuQ;
        giftFrameLayout.nuQ = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.nuY;
        giftFrameLayout.nuY = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.nva = i;
        if (this.nuG != null && this.nuR != null) {
            this.nuG.bU(this.nuR.nul, this.nva);
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
        this.nuP = 0;
        this.nuQ = 0;
        this.isShowing = false;
        this.nuT = false;
        this.nuX = false;
        this.nva = b.d.zues_show_gift_animation;
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
        this.nuN = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.nuF = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.nuG = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.nuK = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.nuK.setAnim(true);
        this.nuH = inflate.findViewById(b.e.rl_user_avatar);
        this.nuI = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.nuJ = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.nuL = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.nuM = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.nuS = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.dKk();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.nuO = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.nuO.setType(2);
        }
        this.nuU = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.nuV = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.nuW = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.nuP - GiftFrameLayout.this.nuQ;
                if (i > 150) {
                    GiftFrameLayout.this.nuQ = (i / 10) + GiftFrameLayout.this.nuQ;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.nuQ += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.nuQ += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.nuQ += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.nuQ += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.nuQ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.nuS != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.nuS.JG(1)) {
                            GiftFrameLayout.this.nuS.JF(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nuR, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.nuS.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nuU.setAnimationListener(this.nuW);
        this.nuV.setAnimationListener(this.nuW);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean dKj() {
        return this.nuT;
    }

    public void b(a aVar) {
        this.nuT = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.nuz == null) {
            this.nuz = tv.chushou.zues.widget.gift.a.a(this.nuF, -getWidth(), 0.0f, Double.valueOf(nuw * nuv).longValue());
            this.nuz.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.nuR.nun);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.nuR != null) {
                        if (GiftFrameLayout.this.nuR.nuo != GiftFrameLayout.this.nuR.nun) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.nuR.nuo);
                            return;
                        }
                        GiftFrameLayout.this.nuQ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.nuR, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.nuz.setDuration(Double.valueOf(nuw * nuv).longValue());
        }
        if (this.nuA == null) {
            this.nuA = tv.chushou.zues.widget.gift.a.b(this.nuK, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(nux * nuv).longValue());
            this.nuA.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.nuK != null) {
                        GiftFrameLayout.this.nuK.setVisibility(0);
                    }
                }
            });
        } else {
            this.nuA.setDuration(Double.valueOf(nux * nuv).longValue());
        }
        if (this.nuB == null) {
            this.nuB = tv.chushou.zues.widget.gift.a.a(this.nuz, this.nuA);
            this.nuB.start();
            return;
        }
        this.nuB.start();
    }

    public void a(long j, float f) {
        if (this.nuZ != null) {
            this.nuZ.dispose();
        }
        long j2 = this.nuY == 0 ? (long) (nuw * nuv) : 0L;
        if (this.nuY < j) {
            this.nuY = j;
        }
        if (this.nuY != 0) {
            this.nuZ = g.a(0L, this.nuY, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dCD()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.nuY == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.nuT = true;
            if (this.nuC == null) {
                this.nuC = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(nuy * nuv).longValue(), 0);
                this.nuC.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.nuK != null) {
                            GiftFrameLayout.this.nuK.setVisibility(4);
                        }
                    }
                });
            } else {
                this.nuC.setDuration(Double.valueOf(nuy * nuv).longValue());
            }
            if (this.nuD == null) {
                this.nuD = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.nuE == null) {
                this.nuE = tv.chushou.zues.widget.gift.a.a(this.nuC, this.nuD);
                this.nuE.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.nuR = null;
                        GiftFrameLayout.this.dKl();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.nuE.start();
                return;
            }
            this.nuE.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKk() {
        int i;
        if (this.nuQ > this.nuP) {
            this.nuQ = this.nuP;
            if (this.nuS != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.nuR, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.nuS.removeMessages(1);
                return;
            }
            return;
        }
        this.nuX = this.nuQ == this.nuP;
        this.nuO.setNumber(this.nuQ);
        int i2 = this.nuP - this.nuQ;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.nuU.setDuration(i);
        this.nuO.startAnimation(this.nuX ? this.nuV : this.nuU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKl() {
        this.nuQ = 0;
    }

    public void JY(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.nuR != null) {
            this.nuR.nuo = i;
            setEndNumber(this.nuR.nuo);
        }
        if (this.nuZ != null) {
            this.nuZ.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.nuQ = i;
        this.nuO.setNumber(this.nuQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.nuP = i;
        if (this.nuQ == Integer.MAX_VALUE) {
            this.nuQ = this.nuP;
        }
        if (this.nuS != null && !this.nuS.JG(1)) {
            this.nuS.JF(1);
        }
    }

    public a getGift() {
        return this.nuR;
    }

    private void setGift(a aVar) {
        this.nuR = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nuN.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.nuH.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.nuH.getLayoutParams();
            this.nuI.setVisibility(0);
            this.nuI.i(aVar.nuh, b.C0852b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.nui)) {
                this.nuJ.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.nuJ.setVisibility(0);
                this.nuJ.i(aVar.nui, b.C0852b.float_transparent, b.C0861b.nuc, b.C0861b.nuc);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.nuH.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.nuK.h(aVar.nuk, b.d.zues_btn_gift_icon, b.C0861b.nub, b.C0861b.nub);
        this.nuN.setLayoutParams(layoutParams);
        this.nuL.setText(aVar.mNickName);
        this.nuM.setText(aVar.nuj);
        this.nuG.bU(aVar.nul, this.nva);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
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
        if (this.nuE != null) {
            this.nuE.cancel();
            this.nuE = null;
        }
        if (this.nuC != null) {
            this.nuC.cancel();
            this.nuC = null;
        }
        if (this.nuD != null) {
            this.nuD.cancel();
            this.nuD = null;
        }
        if (this.nuU != null) {
            this.nuU.cancel();
            this.nuU = null;
        }
        if (this.nuV != null) {
            this.nuV.cancel();
            this.nuV = null;
        }
        this.nuW = null;
        this.mInflater = null;
        this.mContext = null;
        this.nuF = null;
        this.nuG = null;
        this.nuI = null;
        this.nuK = null;
        this.nuL = null;
        this.nuM = null;
        if (this.nuO != null) {
            this.nuO.release();
            this.nuO = null;
        }
        this.nuR = null;
        if (this.nuS != null) {
            this.nuS.ca(null);
            this.nuS = null;
        }
        if (this.nuZ != null) {
            this.nuZ.dispose();
        }
    }
}
