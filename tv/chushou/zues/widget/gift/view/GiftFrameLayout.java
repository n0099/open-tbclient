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
    public static double ova = 1.0d;
    public static double ovb = 500.0d;
    public static double ovc = 200.0d;
    public static double ovd = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private Animation ovA;
    private Animation.AnimationListener ovB;
    private boolean ovC;
    private long ovD;
    private b ovE;
    public int ovF;
    private ObjectAnimator ove;
    private ObjectAnimator ovf;
    private AnimatorSet ovg;
    private ObjectAnimator ovh;
    private ObjectAnimator ovi;
    private AnimatorSet ovj;
    private FrameLayout ovk;
    private FrescoThumbnailView ovl;
    private View ovm;
    private FrescoThumbnailView ovn;
    private FrescoThumbnailView ovo;
    private FrescoThumbnailView ovp;
    private TextView ovq;
    private TextView ovr;
    private LinearLayout ovs;
    private ComboNumView ovt;
    private int ovu;
    private int ovv;
    private a ovw;
    private c ovx;
    private boolean ovy;
    private Animation ovz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.ovv;
        giftFrameLayout.ovv = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.ovD;
        giftFrameLayout.ovD = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.ovF = i;
        if (this.ovl != null && this.ovw != null) {
            this.ovl.bS(this.ovw.ouR, this.ovF);
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
        this.ovu = 0;
        this.ovv = 0;
        this.isShowing = false;
        this.ovy = false;
        this.ovC = false;
        this.ovF = b.d.zues_show_gift_animation;
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
        this.ovs = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.ovk = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.ovl = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.ovp = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.ovp.setAnim(true);
        this.ovm = inflate.findViewById(b.e.rl_user_avatar);
        this.ovn = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.ovo = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.ovq = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.ovr = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.ovx = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.eaA();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.ovt = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.ovt.setType(2);
        }
        this.ovz = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.ovA = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.ovB = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.ovu - GiftFrameLayout.this.ovv;
                if (i > 150) {
                    GiftFrameLayout.this.ovv = (i / 10) + GiftFrameLayout.this.ovv;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.ovv += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.ovv += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.ovv += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.ovv += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.ovv = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.ovx != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.ovx.LU(1)) {
                            GiftFrameLayout.this.ovx.LT(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.ovw, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.ovx.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ovz.setAnimationListener(this.ovB);
        this.ovA.setAnimationListener(this.ovB);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean eaz() {
        return this.ovy;
    }

    public void b(a aVar) {
        this.ovy = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.ove == null) {
            this.ove = tv.chushou.zues.widget.gift.a.a(this.ovk, -getWidth(), 0.0f, Double.valueOf(ovb * ova).longValue());
            this.ove.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.ovw.ouS);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.ovw != null) {
                        if (GiftFrameLayout.this.ovw.ouT != GiftFrameLayout.this.ovw.ouS) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.ovw.ouT);
                            return;
                        }
                        GiftFrameLayout.this.ovv = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.ovw, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.ove.setDuration(Double.valueOf(ovb * ova).longValue());
        }
        if (this.ovf == null) {
            this.ovf = tv.chushou.zues.widget.gift.a.b(this.ovp, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(ovc * ova).longValue());
            this.ovf.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.ovp != null) {
                        GiftFrameLayout.this.ovp.setVisibility(0);
                    }
                }
            });
        } else {
            this.ovf.setDuration(Double.valueOf(ovc * ova).longValue());
        }
        if (this.ovg == null) {
            this.ovg = tv.chushou.zues.widget.gift.a.a(this.ove, this.ovf);
            this.ovg.start();
            return;
        }
        this.ovg.start();
    }

    public void a(long j, float f) {
        if (this.ovE != null) {
            this.ovE.dispose();
        }
        long j2 = this.ovD == 0 ? (long) (ovb * ova) : 0L;
        if (this.ovD < j) {
            this.ovD = j;
        }
        if (this.ovD != 0) {
            this.ovE = g.a(0L, this.ovD, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dST()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.ovD == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.ovy = true;
            if (this.ovh == null) {
                this.ovh = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(ovd * ova).longValue(), 0);
                this.ovh.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.ovp != null) {
                            GiftFrameLayout.this.ovp.setVisibility(4);
                        }
                    }
                });
            } else {
                this.ovh.setDuration(Double.valueOf(ovd * ova).longValue());
            }
            if (this.ovi == null) {
                this.ovi = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.ovj == null) {
                this.ovj = tv.chushou.zues.widget.gift.a.a(this.ovh, this.ovi);
                this.ovj.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.ovw = null;
                        GiftFrameLayout.this.eaB();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.ovj.start();
                return;
            }
            this.ovj.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaA() {
        int i;
        if (this.ovv > this.ovu) {
            this.ovv = this.ovu;
            if (this.ovx != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.ovw, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.ovx.removeMessages(1);
                return;
            }
            return;
        }
        this.ovC = this.ovv == this.ovu;
        this.ovt.setNumber(this.ovv);
        int i2 = this.ovu - this.ovv;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.ovz.setDuration(i);
        this.ovt.startAnimation(this.ovC ? this.ovA : this.ovz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaB() {
        this.ovv = 0;
    }

    public void Ml(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.ovw != null) {
            this.ovw.ouT = i;
            setEndNumber(this.ovw.ouT);
        }
        if (this.ovE != null) {
            this.ovE.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.ovv = i;
        this.ovt.setNumber(this.ovv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.ovu = i;
        if (this.ovv == Integer.MAX_VALUE) {
            this.ovv = this.ovu;
        }
        if (this.ovx != null && !this.ovx.LU(1)) {
            this.ovx.LT(1);
        }
    }

    public a getGift() {
        return this.ovw;
    }

    private void setGift(a aVar) {
        this.ovw = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ovs.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.ovm.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ovm.getLayoutParams();
            this.ovn.setVisibility(0);
            this.ovn.i(aVar.ouN, b.C0950b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.ouO)) {
                this.ovo.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.ovo.setVisibility(0);
                this.ovo.i(aVar.ouO, b.C0950b.float_transparent, b.C0959b.ouI, b.C0959b.ouI);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.ovm.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.ovp.h(aVar.ouQ, b.d.zues_btn_gift_icon, b.C0959b.ouH, b.C0959b.ouH);
        this.ovs.setLayoutParams(layoutParams);
        this.ovq.setText(aVar.mNickName);
        this.ovr.setText(aVar.ouP);
        this.ovl.bS(aVar.ouR, this.ovF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ovg != null) {
            this.ovg.cancel();
            this.ovg = null;
        }
        if (this.ove != null) {
            this.ove.cancel();
            this.ove = null;
        }
        if (this.ovf != null) {
            this.ovf.cancel();
            this.ovf = null;
        }
        if (this.ovj != null) {
            this.ovj.cancel();
            this.ovj = null;
        }
        if (this.ovh != null) {
            this.ovh.cancel();
            this.ovh = null;
        }
        if (this.ovi != null) {
            this.ovi.cancel();
            this.ovi = null;
        }
        if (this.ovz != null) {
            this.ovz.cancel();
            this.ovz = null;
        }
        if (this.ovA != null) {
            this.ovA.cancel();
            this.ovA = null;
        }
        this.ovB = null;
        this.mInflater = null;
        this.mContext = null;
        this.ovk = null;
        this.ovl = null;
        this.ovn = null;
        this.ovp = null;
        this.ovq = null;
        this.ovr = null;
        if (this.ovt != null) {
            this.ovt.release();
            this.ovt = null;
        }
        this.ovw = null;
        if (this.ovx != null) {
            this.ovx.ch(null);
            this.ovx = null;
        }
        if (this.ovE != null) {
            this.ovE.dispose();
        }
    }
}
