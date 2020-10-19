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
    public static double pof = 1.0d;
    public static double pog = 500.0d;
    public static double poh = 200.0d;
    public static double poj = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ComboNumView poA;
    private int poB;
    private int poC;
    private a poD;
    private c poE;
    private boolean poF;
    private Animation poG;
    private Animation poH;
    private Animation.AnimationListener poI;
    private boolean poJ;
    private long poK;
    private b poL;
    public int poM;
    private ObjectAnimator pok;
    private ObjectAnimator pol;
    private AnimatorSet pom;
    private ObjectAnimator pon;
    private ObjectAnimator poo;
    private AnimatorSet pop;
    private FrameLayout poq;
    private FrescoThumbnailView por;
    private View pot;
    private FrescoThumbnailView pou;
    private FrescoThumbnailView pov;
    private FrescoThumbnailView pow;
    private TextView pox;
    private TextView poy;
    private LinearLayout poz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.poC;
        giftFrameLayout.poC = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.poK;
        giftFrameLayout.poK = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.poM = i;
        if (this.por != null && this.poD != null) {
            this.por.bY(this.poD.pnW, this.poM);
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
        this.poB = 0;
        this.poC = 0;
        this.isShowing = false;
        this.poF = false;
        this.poJ = false;
        this.poM = b.d.zues_show_gift_animation;
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
        this.poz = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.poq = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.por = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.pow = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.pow.setAnim(true);
        this.pot = inflate.findViewById(b.e.rl_user_avatar);
        this.pou = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.pov = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.pox = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.poy = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.poE = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.euv();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.poA = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.poA.setType(2);
        }
        this.poG = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.poH = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.poI = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.poB - GiftFrameLayout.this.poC;
                if (i > 150) {
                    GiftFrameLayout.this.poC = (i / 10) + GiftFrameLayout.this.poC;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.poC += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.poC += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.poC += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.poC += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.poC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.poE != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.poE.PI(1)) {
                            GiftFrameLayout.this.poE.PH(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.poD, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.poE.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.poG.setAnimationListener(this.poI);
        this.poH.setAnimationListener(this.poI);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean euu() {
        return this.poF;
    }

    public void b(a aVar) {
        this.poF = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.pok == null) {
            this.pok = tv.chushou.zues.widget.gift.a.a(this.poq, -getWidth(), 0.0f, Double.valueOf(pog * pof).longValue());
            this.pok.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.poD.pnX);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.poD != null) {
                        if (GiftFrameLayout.this.poD.pnY != GiftFrameLayout.this.poD.pnX) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.poD.pnY);
                            return;
                        }
                        GiftFrameLayout.this.poC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.poD, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.pok.setDuration(Double.valueOf(pog * pof).longValue());
        }
        if (this.pol == null) {
            this.pol = tv.chushou.zues.widget.gift.a.b(this.pow, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(poh * pof).longValue());
            this.pol.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.pow != null) {
                        GiftFrameLayout.this.pow.setVisibility(0);
                    }
                }
            });
        } else {
            this.pol.setDuration(Double.valueOf(poh * pof).longValue());
        }
        if (this.pom == null) {
            this.pom = tv.chushou.zues.widget.gift.a.a(this.pok, this.pol);
            this.pom.start();
            return;
        }
        this.pom.start();
    }

    public void a(long j, float f) {
        if (this.poL != null) {
            this.poL.dispose();
        }
        long j2 = this.poK == 0 ? (long) (pog * pof) : 0L;
        if (this.poK < j) {
            this.poK = j;
        }
        if (this.poK != 0) {
            this.poL = g.a(0L, this.poK, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.emM()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: j */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.poK == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.poF = true;
            if (this.pon == null) {
                this.pon = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(poj * pof).longValue(), 0);
                this.pon.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.pow != null) {
                            GiftFrameLayout.this.pow.setVisibility(4);
                        }
                    }
                });
            } else {
                this.pon.setDuration(Double.valueOf(poj * pof).longValue());
            }
            if (this.poo == null) {
                this.poo = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.pop == null) {
                this.pop = tv.chushou.zues.widget.gift.a.a(this.pon, this.poo);
                this.pop.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.poD = null;
                        GiftFrameLayout.this.euw();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.pop.start();
                return;
            }
            this.pop.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euv() {
        int i;
        if (this.poC > this.poB) {
            this.poC = this.poB;
            if (this.poE != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.poD, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.poE.removeMessages(1);
                return;
            }
            return;
        }
        this.poJ = this.poC == this.poB;
        this.poA.setNumber(this.poC);
        int i2 = this.poB - this.poC;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.poG.setDuration(i);
        this.poA.startAnimation(this.poJ ? this.poH : this.poG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euw() {
        this.poC = 0;
    }

    public void PZ(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.poD != null) {
            this.poD.pnY = i;
            setEndNumber(this.poD.pnY);
        }
        if (this.poL != null) {
            this.poL.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.poC = i;
        this.poA.setNumber(this.poC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.poB = i;
        if (this.poC == Integer.MAX_VALUE) {
            this.poC = this.poB;
        }
        if (this.poE != null && !this.poE.PI(1)) {
            this.poE.PH(1);
        }
    }

    public a getGift() {
        return this.poD;
    }

    private void setGift(a aVar) {
        this.poD = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.poz.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.pot.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.pot.getLayoutParams();
            this.pou.setVisibility(0);
            this.pou.i(aVar.pnS, b.C1023b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.pnT)) {
                this.pov.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.pov.setVisibility(0);
                this.pov.i(aVar.pnT, b.C1023b.float_transparent, b.C1032b.pnN, b.C1032b.pnN);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.pot.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.pow.h(aVar.pnV, b.d.zues_btn_gift_icon, b.C1032b.pnM, b.C1032b.pnM);
        this.poz.setLayoutParams(layoutParams);
        this.pox.setText(aVar.mNickName);
        this.poy.setText(aVar.pnU);
        this.por.bY(aVar.pnW, this.poM);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.pom != null) {
            this.pom.cancel();
            this.pom = null;
        }
        if (this.pok != null) {
            this.pok.cancel();
            this.pok = null;
        }
        if (this.pol != null) {
            this.pol.cancel();
            this.pol = null;
        }
        if (this.pop != null) {
            this.pop.cancel();
            this.pop = null;
        }
        if (this.pon != null) {
            this.pon.cancel();
            this.pon = null;
        }
        if (this.poo != null) {
            this.poo.cancel();
            this.poo = null;
        }
        if (this.poG != null) {
            this.poG.cancel();
            this.poG = null;
        }
        if (this.poH != null) {
            this.poH.cancel();
            this.poH = null;
        }
        this.poI = null;
        this.mInflater = null;
        this.mContext = null;
        this.poq = null;
        this.por = null;
        this.pou = null;
        this.pow = null;
        this.pox = null;
        this.poy = null;
        if (this.poA != null) {
            this.poA.release();
            this.poA = null;
        }
        this.poD = null;
        if (this.poE != null) {
            this.poE.co(null);
            this.poE = null;
        }
        if (this.poL != null) {
            this.poL.dispose();
        }
    }
}
