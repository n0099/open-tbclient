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
    public static double qft = 1.0d;
    public static double qfu = 500.0d;
    public static double qfv = 200.0d;
    public static double qfw = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator qfA;
    private ObjectAnimator qfB;
    private AnimatorSet qfC;
    private FrameLayout qfD;
    private FrescoThumbnailView qfE;
    private View qfF;
    private FrescoThumbnailView qfG;
    private FrescoThumbnailView qfH;
    private FrescoThumbnailView qfI;
    private TextView qfJ;
    private TextView qfK;
    private LinearLayout qfL;
    private ComboNumView qfM;
    private int qfN;
    private int qfO;
    private a qfP;
    private c qfQ;
    private boolean qfR;
    private Animation qfS;
    private Animation qfT;
    private Animation.AnimationListener qfU;
    private boolean qfV;
    private long qfW;
    private b qfX;
    public int qfY;
    private ObjectAnimator qfx;
    private ObjectAnimator qfy;
    private AnimatorSet qfz;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.qfO;
        giftFrameLayout.qfO = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.qfW;
        giftFrameLayout.qfW = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.qfY = i;
        if (this.qfE != null && this.qfP != null) {
            this.qfE.cc(this.qfP.qfk, this.qfY);
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
        this.qfN = 0;
        this.qfO = 0;
        this.isShowing = false;
        this.qfR = false;
        this.qfV = false;
        this.qfY = b.d.zues_show_gift_animation;
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
        this.qfL = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.qfD = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.qfE = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.qfI = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.qfI.setAnim(true);
        this.qfF = inflate.findViewById(b.e.rl_user_avatar);
        this.qfG = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.qfH = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.qfJ = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.qfK = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.qfQ = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.eEt();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.qfM = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.qfM.setType(2);
        }
        this.qfS = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.qfT = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.qfU = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.qfN - GiftFrameLayout.this.qfO;
                if (i > 150) {
                    GiftFrameLayout.this.qfO = (i / 10) + GiftFrameLayout.this.qfO;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.qfO += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.qfO += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.qfO += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.qfO += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.qfO = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.qfQ != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.qfQ.Rz(1)) {
                            GiftFrameLayout.this.qfQ.Ry(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.qfP, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.qfQ.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.qfS.setAnimationListener(this.qfU);
        this.qfT.setAnimationListener(this.qfU);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean eEs() {
        return this.qfR;
    }

    public void b(a aVar) {
        this.qfR = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.qfx == null) {
            this.qfx = tv.chushou.zues.widget.gift.a.a(this.qfD, -getWidth(), 0.0f, Double.valueOf(qfu * qft).longValue());
            this.qfx.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.qfP.qfl);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.qfP != null) {
                        if (GiftFrameLayout.this.qfP.qfm != GiftFrameLayout.this.qfP.qfl) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.qfP.qfm);
                            return;
                        }
                        GiftFrameLayout.this.qfO = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.qfP, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.qfx.setDuration(Double.valueOf(qfu * qft).longValue());
        }
        if (this.qfy == null) {
            this.qfy = tv.chushou.zues.widget.gift.a.b(this.qfI, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(qfv * qft).longValue());
            this.qfy.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.qfI != null) {
                        GiftFrameLayout.this.qfI.setVisibility(0);
                    }
                }
            });
        } else {
            this.qfy.setDuration(Double.valueOf(qfv * qft).longValue());
        }
        if (this.qfz == null) {
            this.qfz = tv.chushou.zues.widget.gift.a.a(this.qfx, this.qfy);
            this.qfz.start();
            return;
        }
        this.qfz.start();
    }

    public void a(long j, float f) {
        if (this.qfX != null) {
            this.qfX.dispose();
        }
        long j2 = this.qfW == 0 ? (long) (qfu * qft) : 0L;
        if (this.qfW < j) {
            this.qfW = j;
        }
        if (this.qfW != 0) {
            this.qfX = g.a(0L, this.qfW, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.ewM()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: k */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.qfW == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.qfR = true;
            if (this.qfA == null) {
                this.qfA = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(qfw * qft).longValue(), 0);
                this.qfA.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.qfI != null) {
                            GiftFrameLayout.this.qfI.setVisibility(4);
                        }
                    }
                });
            } else {
                this.qfA.setDuration(Double.valueOf(qfw * qft).longValue());
            }
            if (this.qfB == null) {
                this.qfB = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.qfC == null) {
                this.qfC = tv.chushou.zues.widget.gift.a.a(this.qfA, this.qfB);
                this.qfC.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.qfP = null;
                        GiftFrameLayout.this.eEu();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.qfC.start();
                return;
            }
            this.qfC.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eEt() {
        int i;
        if (this.qfO > this.qfN) {
            this.qfO = this.qfN;
            if (this.qfQ != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.qfP, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.qfQ.removeMessages(1);
                return;
            }
            return;
        }
        this.qfV = this.qfO == this.qfN;
        this.qfM.setNumber(this.qfO);
        int i2 = this.qfN - this.qfO;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.qfS.setDuration(i);
        this.qfM.startAnimation(this.qfV ? this.qfT : this.qfS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eEu() {
        this.qfO = 0;
    }

    public void RQ(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.qfP != null) {
            this.qfP.qfm = i;
            setEndNumber(this.qfP.qfm);
        }
        if (this.qfX != null) {
            this.qfX.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.qfO = i;
        this.qfM.setNumber(this.qfO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.qfN = i;
        if (this.qfO == Integer.MAX_VALUE) {
            this.qfO = this.qfN;
        }
        if (this.qfQ != null && !this.qfQ.Rz(1)) {
            this.qfQ.Ry(1);
        }
    }

    public a getGift() {
        return this.qfP;
    }

    private void setGift(a aVar) {
        this.qfP = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qfL.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.qfF.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.qfF.getLayoutParams();
            this.qfG.setVisibility(0);
            this.qfG.j(aVar.qfg, b.C1095b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.qfh)) {
                this.qfH.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.qfH.setVisibility(0);
                this.qfH.j(aVar.qfh, b.C1095b.float_transparent, b.C1104b.qfb, b.C1104b.qfb);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.qfF.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.qfI.i(aVar.qfj, b.d.zues_btn_gift_icon, b.C1104b.qfa, b.C1104b.qfa);
        this.qfL.setLayoutParams(layoutParams);
        this.qfJ.setText(aVar.mNickName);
        this.qfK.setText(aVar.qfi);
        this.qfE.cc(aVar.qfk, this.qfY);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.qfz != null) {
            this.qfz.cancel();
            this.qfz = null;
        }
        if (this.qfx != null) {
            this.qfx.cancel();
            this.qfx = null;
        }
        if (this.qfy != null) {
            this.qfy.cancel();
            this.qfy = null;
        }
        if (this.qfC != null) {
            this.qfC.cancel();
            this.qfC = null;
        }
        if (this.qfA != null) {
            this.qfA.cancel();
            this.qfA = null;
        }
        if (this.qfB != null) {
            this.qfB.cancel();
            this.qfB = null;
        }
        if (this.qfS != null) {
            this.qfS.cancel();
            this.qfS = null;
        }
        if (this.qfT != null) {
            this.qfT.cancel();
            this.qfT = null;
        }
        this.qfU = null;
        this.mInflater = null;
        this.mContext = null;
        this.qfD = null;
        this.qfE = null;
        this.qfG = null;
        this.qfI = null;
        this.qfJ = null;
        this.qfK = null;
        if (this.qfM != null) {
            this.qfM.release();
            this.qfM = null;
        }
        this.qfP = null;
        if (this.qfQ != null) {
            this.qfQ.cs(null);
            this.qfQ = null;
        }
        if (this.qfX != null) {
            this.qfX.dispose();
        }
    }
}
