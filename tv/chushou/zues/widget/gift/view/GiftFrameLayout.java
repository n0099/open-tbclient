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
    public static double ouY = 1.0d;
    public static double ouZ = 500.0d;
    public static double ova = 200.0d;
    public static double ovb = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private boolean ovA;
    private long ovB;
    private b ovC;
    public int ovD;
    private ObjectAnimator ovc;
    private ObjectAnimator ovd;
    private AnimatorSet ove;
    private ObjectAnimator ovf;
    private ObjectAnimator ovg;
    private AnimatorSet ovh;
    private FrameLayout ovi;
    private FrescoThumbnailView ovj;
    private View ovk;
    private FrescoThumbnailView ovl;
    private FrescoThumbnailView ovm;
    private FrescoThumbnailView ovn;
    private TextView ovo;
    private TextView ovp;
    private LinearLayout ovq;
    private ComboNumView ovr;
    private int ovs;
    private int ovt;
    private a ovu;
    private c ovv;
    private boolean ovw;
    private Animation ovx;
    private Animation ovy;
    private Animation.AnimationListener ovz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.ovt;
        giftFrameLayout.ovt = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.ovB;
        giftFrameLayout.ovB = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.ovD = i;
        if (this.ovj != null && this.ovu != null) {
            this.ovj.bS(this.ovu.ouP, this.ovD);
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
        this.ovs = 0;
        this.ovt = 0;
        this.isShowing = false;
        this.ovw = false;
        this.ovA = false;
        this.ovD = b.d.zues_show_gift_animation;
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
        this.ovq = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.ovi = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.ovj = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.ovn = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.ovn.setAnim(true);
        this.ovk = inflate.findViewById(b.e.rl_user_avatar);
        this.ovl = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.ovm = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.ovo = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.ovp = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.ovv = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.eaz();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.ovr = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.ovr.setType(2);
        }
        this.ovx = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.ovy = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.ovz = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.ovs - GiftFrameLayout.this.ovt;
                if (i > 150) {
                    GiftFrameLayout.this.ovt = (i / 10) + GiftFrameLayout.this.ovt;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.ovt += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.ovt += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.ovt += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.ovt += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.ovt = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.ovv != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.ovv.LU(1)) {
                            GiftFrameLayout.this.ovv.LT(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.ovu, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.ovv.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.ovx.setAnimationListener(this.ovz);
        this.ovy.setAnimationListener(this.ovz);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean eay() {
        return this.ovw;
    }

    public void b(a aVar) {
        this.ovw = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.ovc == null) {
            this.ovc = tv.chushou.zues.widget.gift.a.a(this.ovi, -getWidth(), 0.0f, Double.valueOf(ouZ * ouY).longValue());
            this.ovc.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.ovu.ouQ);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.ovu != null) {
                        if (GiftFrameLayout.this.ovu.ouR != GiftFrameLayout.this.ovu.ouQ) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.ovu.ouR);
                            return;
                        }
                        GiftFrameLayout.this.ovt = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.ovu, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.ovc.setDuration(Double.valueOf(ouZ * ouY).longValue());
        }
        if (this.ovd == null) {
            this.ovd = tv.chushou.zues.widget.gift.a.b(this.ovn, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(ova * ouY).longValue());
            this.ovd.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.ovn != null) {
                        GiftFrameLayout.this.ovn.setVisibility(0);
                    }
                }
            });
        } else {
            this.ovd.setDuration(Double.valueOf(ova * ouY).longValue());
        }
        if (this.ove == null) {
            this.ove = tv.chushou.zues.widget.gift.a.a(this.ovc, this.ovd);
            this.ove.start();
            return;
        }
        this.ove.start();
    }

    public void a(long j, float f) {
        if (this.ovC != null) {
            this.ovC.dispose();
        }
        long j2 = this.ovB == 0 ? (long) (ouZ * ouY) : 0L;
        if (this.ovB < j) {
            this.ovB = j;
        }
        if (this.ovB != 0) {
            this.ovC = g.a(0L, this.ovB, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.dSS()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.ovB == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.ovw = true;
            if (this.ovf == null) {
                this.ovf = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(ovb * ouY).longValue(), 0);
                this.ovf.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.ovn != null) {
                            GiftFrameLayout.this.ovn.setVisibility(4);
                        }
                    }
                });
            } else {
                this.ovf.setDuration(Double.valueOf(ovb * ouY).longValue());
            }
            if (this.ovg == null) {
                this.ovg = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.ovh == null) {
                this.ovh = tv.chushou.zues.widget.gift.a.a(this.ovf, this.ovg);
                this.ovh.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.ovu = null;
                        GiftFrameLayout.this.eaA();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.ovh.start();
                return;
            }
            this.ovh.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaz() {
        int i;
        if (this.ovt > this.ovs) {
            this.ovt = this.ovs;
            if (this.ovv != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.ovu, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.ovv.removeMessages(1);
                return;
            }
            return;
        }
        this.ovA = this.ovt == this.ovs;
        this.ovr.setNumber(this.ovt);
        int i2 = this.ovs - this.ovt;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.ovx.setDuration(i);
        this.ovr.startAnimation(this.ovA ? this.ovy : this.ovx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaA() {
        this.ovt = 0;
    }

    public void Ml(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.ovu != null) {
            this.ovu.ouR = i;
            setEndNumber(this.ovu.ouR);
        }
        if (this.ovC != null) {
            this.ovC.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.ovt = i;
        this.ovr.setNumber(this.ovt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.ovs = i;
        if (this.ovt == Integer.MAX_VALUE) {
            this.ovt = this.ovs;
        }
        if (this.ovv != null && !this.ovv.LU(1)) {
            this.ovv.LT(1);
        }
    }

    public a getGift() {
        return this.ovu;
    }

    private void setGift(a aVar) {
        this.ovu = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ovq.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.ovk.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ovk.getLayoutParams();
            this.ovl.setVisibility(0);
            this.ovl.i(aVar.ouL, b.C0950b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.ouM)) {
                this.ovm.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.ovm.setVisibility(0);
                this.ovm.i(aVar.ouM, b.C0950b.float_transparent, b.C0959b.ouG, b.C0959b.ouG);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.ovk.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.ovn.h(aVar.ouO, b.d.zues_btn_gift_icon, b.C0959b.ouF, b.C0959b.ouF);
        this.ovq.setLayoutParams(layoutParams);
        this.ovo.setText(aVar.mNickName);
        this.ovp.setText(aVar.ouN);
        this.ovj.bS(aVar.ouP, this.ovD);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ove != null) {
            this.ove.cancel();
            this.ove = null;
        }
        if (this.ovc != null) {
            this.ovc.cancel();
            this.ovc = null;
        }
        if (this.ovd != null) {
            this.ovd.cancel();
            this.ovd = null;
        }
        if (this.ovh != null) {
            this.ovh.cancel();
            this.ovh = null;
        }
        if (this.ovf != null) {
            this.ovf.cancel();
            this.ovf = null;
        }
        if (this.ovg != null) {
            this.ovg.cancel();
            this.ovg = null;
        }
        if (this.ovx != null) {
            this.ovx.cancel();
            this.ovx = null;
        }
        if (this.ovy != null) {
            this.ovy.cancel();
            this.ovy = null;
        }
        this.ovz = null;
        this.mInflater = null;
        this.mContext = null;
        this.ovi = null;
        this.ovj = null;
        this.ovl = null;
        this.ovn = null;
        this.ovo = null;
        this.ovp = null;
        if (this.ovr != null) {
            this.ovr.release();
            this.ovr = null;
        }
        this.ovu = null;
        if (this.ovv != null) {
            this.ovv.ch(null);
            this.ovv = null;
        }
        if (this.ovC != null) {
            this.ovC.dispose();
        }
    }
}
