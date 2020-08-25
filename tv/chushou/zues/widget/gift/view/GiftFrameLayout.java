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
    public static double oOR = 1.0d;
    public static double oOS = 500.0d;
    public static double oOT = 200.0d;
    public static double oOU = 1000.0d;
    private String TAG;
    private boolean isShowing;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mType;
    private ObjectAnimator oOV;
    private ObjectAnimator oOW;
    private AnimatorSet oOX;
    private ObjectAnimator oOY;
    private ObjectAnimator oOZ;
    private AnimatorSet oPa;
    private FrameLayout oPb;
    private FrescoThumbnailView oPc;
    private View oPd;
    private FrescoThumbnailView oPe;
    private FrescoThumbnailView oPf;
    private FrescoThumbnailView oPg;
    private TextView oPh;
    private TextView oPi;
    private LinearLayout oPj;
    private ComboNumView oPk;
    private int oPl;
    private int oPm;
    private a oPn;
    private c oPo;
    private boolean oPp;
    private Animation oPq;
    private Animation oPr;
    private Animation.AnimationListener oPs;
    private boolean oPt;
    private long oPu;
    private b oPv;
    public int oPw;
    public long updateTime;

    static /* synthetic */ int d(GiftFrameLayout giftFrameLayout) {
        int i = giftFrameLayout.oPm;
        giftFrameLayout.oPm = i + 1;
        return i;
    }

    static /* synthetic */ long h(GiftFrameLayout giftFrameLayout) {
        long j = giftFrameLayout.oPu;
        giftFrameLayout.oPu = j - 1;
        return j;
    }

    public void setLayoutDefaultBg(int i) {
        this.oPw = i;
        if (this.oPc != null && this.oPn != null) {
            this.oPc.bX(this.oPn.oOI, this.oPw);
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
        this.oPl = 0;
        this.oPm = 0;
        this.isShowing = false;
        this.oPp = false;
        this.oPt = false;
        this.oPw = b.d.zues_show_gift_animation;
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
        this.oPj = (LinearLayout) inflate.findViewById(b.e.tv_text_content);
        this.oPb = (FrameLayout) inflate.findViewById(b.e.fl_gift);
        this.oPc = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_bg);
        this.oPg = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_icon);
        this.oPg.setAnim(true);
        this.oPd = inflate.findViewById(b.e.rl_user_avatar);
        this.oPe = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user);
        this.oPf = (FrescoThumbnailView) inflate.findViewById(b.e.iv_gift_user_frame);
        this.oPh = (TextView) inflate.findViewById(b.e.tv_gift_user);
        this.oPi = (TextView) inflate.findViewById(b.e.tv_gift_desc);
        addView(inflate);
        this.oPo = new c(this.mContext.getMainLooper(), new Handler.Callback() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GiftFrameLayout.this.emD();
                        return false;
                    default:
                        return false;
                }
            }
        });
        this.oPk = (ComboNumView) findViewById(b.e.ll_numb);
        if (this.mType == 2) {
            this.oPk.setType(2);
        }
        this.oPq = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_switch);
        this.oPr = AnimationUtils.loadAnimation(this.mContext, b.a.zues_scalein_end);
        this.oPs = new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                boolean z;
                int i = GiftFrameLayout.this.oPl - GiftFrameLayout.this.oPm;
                if (i > 150) {
                    GiftFrameLayout.this.oPm = (i / 10) + GiftFrameLayout.this.oPm;
                    z = true;
                } else if (i > 50) {
                    GiftFrameLayout.this.oPm += 5;
                    z = true;
                } else if (i > 40) {
                    GiftFrameLayout.this.oPm += 4;
                    z = true;
                } else if (i > 30) {
                    GiftFrameLayout.this.oPm += 3;
                    z = true;
                } else if (i > 20) {
                    GiftFrameLayout.this.oPm += 2;
                    z = true;
                } else if (i <= 0) {
                    GiftFrameLayout.this.oPm = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    z = false;
                } else {
                    GiftFrameLayout.d(GiftFrameLayout.this);
                    z = true;
                }
                if (GiftFrameLayout.this.oPo != null) {
                    if (z) {
                        if (!GiftFrameLayout.this.oPo.Ox(1)) {
                            GiftFrameLayout.this.oPo.Ow(1);
                            return;
                        }
                        return;
                    }
                    tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oPn, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    GiftFrameLayout.this.oPo.removeMessages(1);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.oPq.setAnimationListener(this.oPs);
        this.oPr.setAnimationListener(this.oPs);
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public boolean emC() {
        return this.oPp;
    }

    public void b(a aVar) {
        this.oPp = false;
        this.updateTime = System.currentTimeMillis();
        this.isShowing = true;
        setGift(aVar);
        if (this.oOV == null) {
            this.oOV = tv.chushou.zues.widget.gift.a.a(this.oPb, -getWidth(), 0.0f, Double.valueOf(oOS * oOR).longValue());
            this.oOV.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    GiftFrameLayout.this.setVisibility(0);
                    GiftFrameLayout.this.setAlpha(1.0f);
                    GiftFrameLayout.this.setStartNumber(GiftFrameLayout.this.oPn.oOJ);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (GiftFrameLayout.this.oPn != null) {
                        if (GiftFrameLayout.this.oPn.oOK != GiftFrameLayout.this.oPn.oOJ) {
                            GiftFrameLayout.this.setEndNumber(GiftFrameLayout.this.oPn.oOK);
                            return;
                        }
                        GiftFrameLayout.this.oPm = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(GiftFrameLayout.this.oPn, tv.chushou.zues.widget.gift.b.a.REMOVE));
                    }
                }
            });
        } else {
            this.oOV.setDuration(Double.valueOf(oOS * oOR).longValue());
        }
        if (this.oOW == null) {
            this.oOW = tv.chushou.zues.widget.gift.a.b(this.oPg, -tv.chushou.zues.utils.a.dip2px(this.mContext, 160.0f), 0.0f, Double.valueOf(oOT * oOR).longValue());
            this.oOW.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (GiftFrameLayout.this.oPg != null) {
                        GiftFrameLayout.this.oPg.setVisibility(0);
                    }
                }
            });
        } else {
            this.oOW.setDuration(Double.valueOf(oOT * oOR).longValue());
        }
        if (this.oOX == null) {
            this.oOX = tv.chushou.zues.widget.gift.a.a(this.oOV, this.oOW);
            this.oOX.start();
            return;
        }
        this.oOX.start();
    }

    public void a(long j, float f) {
        if (this.oPv != null) {
            this.oPv.dispose();
        }
        long j2 = this.oPu == 0 ? (long) (oOS * oOR) : 0L;
        if (this.oPu < j) {
            this.oPu = j;
        }
        if (this.oPu != 0) {
            this.oPv = g.a(0L, this.oPu, j2, 1000.0f * f, TimeUnit.MILLISECONDS).a(io.reactivex.a.b.a.eeV()).b(new io.reactivex.c.g<Long>() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // io.reactivex.c.g
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    GiftFrameLayout.h(GiftFrameLayout.this);
                    if (GiftFrameLayout.this.oPu == 0) {
                        GiftFrameLayout.this.hide();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        if (this.mContext != null) {
            this.oPp = true;
            if (this.oOY == null) {
                this.oOY = tv.chushou.zues.widget.gift.a.a(this, 0, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), Double.valueOf(oOU * oOR).longValue(), 0);
                this.oOY.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.setVisibility(4);
                        if (GiftFrameLayout.this.oPg != null) {
                            GiftFrameLayout.this.oPg.setVisibility(4);
                        }
                    }
                });
            } else {
                this.oOY.setDuration(Double.valueOf(oOU * oOR).longValue());
            }
            if (this.oOZ == null) {
                this.oOZ = tv.chushou.zues.widget.gift.a.a((View) this, -tv.chushou.zues.utils.a.dip2px(this.mContext, 55.0f), 0, 20L);
            }
            if (this.oPa == null) {
                this.oPa = tv.chushou.zues.widget.gift.a.a(this.oOY, this.oOZ);
                this.oPa.addListener(new AnimatorListenerAdapter() { // from class: tv.chushou.zues.widget.gift.view.GiftFrameLayout.7
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GiftFrameLayout.this.isShowing = false;
                        GiftFrameLayout.this.oPn = null;
                        GiftFrameLayout.this.emE();
                        tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(null, tv.chushou.zues.widget.gift.b.a.GET));
                    }
                });
                this.oPa.start();
                return;
            }
            this.oPa.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emD() {
        int i;
        if (this.oPm > this.oPl) {
            this.oPm = this.oPl;
            if (this.oPo != null) {
                tv.chushou.zues.a.a.post(new tv.chushou.zues.widget.gift.b.a(this.oPn, tv.chushou.zues.widget.gift.b.a.REMOVE));
                this.oPo.removeMessages(1);
                return;
            }
            return;
        }
        this.oPt = this.oPm == this.oPl;
        this.oPk.setNumber(this.oPm);
        int i2 = this.oPl - this.oPm;
        if (i2 > 20) {
            i = 50;
        } else if (i2 > 10) {
            i = 100;
        } else if (i2 > 5) {
            i = 200;
        } else {
            i = 300;
        }
        this.oPq.setDuration(i);
        this.oPk.startAnimation(this.oPt ? this.oPr : this.oPq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emE() {
        this.oPm = 0;
    }

    public void OO(int i) {
        this.updateTime = System.currentTimeMillis();
        if (this.oPn != null) {
            this.oPn.oOK = i;
            setEndNumber(this.oPn.oOK);
        }
        if (this.oPv != null) {
            this.oPv.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartNumber(int i) {
        this.oPm = i;
        this.oPk.setNumber(this.oPm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndNumber(int i) {
        this.oPl = i;
        if (this.oPm == Integer.MAX_VALUE) {
            this.oPm = this.oPl;
        }
        if (this.oPo != null && !this.oPo.Ox(1)) {
            this.oPo.Ow(1);
        }
    }

    public a getGift() {
        return this.oPn;
    }

    private void setGift(a aVar) {
        this.oPn = aVar;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oPj.getLayoutParams();
        if (aVar.mShowAvatar) {
            this.oPd.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.oPd.getLayoutParams();
            this.oPe.setVisibility(0);
            this.oPe.i(aVar.oOE, b.C1008b.zues_default_placeholder_bg, b.a.small, b.a.small);
            if (h.isEmpty(aVar.oOF)) {
                this.oPf.setVisibility(8);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 14.0f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            } else {
                this.oPf.setVisibility(0);
                this.oPf.i(aVar.oOF, b.C1008b.float_transparent, b.C1017b.oOz, b.C1017b.oOz);
                layoutParams2.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.5f), 0, tv.chushou.zues.utils.a.dip2px(this.mContext, 4.0f), 0);
            }
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            this.oPd.setVisibility(8);
            layoutParams.setMargins(tv.chushou.zues.utils.a.dip2px(this.mContext, 10.0f), 0, 0, 0);
        }
        this.oPg.h(aVar.oOH, b.d.zues_btn_gift_icon, b.C1017b.oOy, b.C1017b.oOy);
        this.oPj.setLayoutParams(layoutParams);
        this.oPh.setText(aVar.mNickName);
        this.oPi.setText(aVar.oOG);
        this.oPc.bX(aVar.oOI, this.oPw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.oOX != null) {
            this.oOX.cancel();
            this.oOX = null;
        }
        if (this.oOV != null) {
            this.oOV.cancel();
            this.oOV = null;
        }
        if (this.oOW != null) {
            this.oOW.cancel();
            this.oOW = null;
        }
        if (this.oPa != null) {
            this.oPa.cancel();
            this.oPa = null;
        }
        if (this.oOY != null) {
            this.oOY.cancel();
            this.oOY = null;
        }
        if (this.oOZ != null) {
            this.oOZ.cancel();
            this.oOZ = null;
        }
        if (this.oPq != null) {
            this.oPq.cancel();
            this.oPq = null;
        }
        if (this.oPr != null) {
            this.oPr.cancel();
            this.oPr = null;
        }
        this.oPs = null;
        this.mInflater = null;
        this.mContext = null;
        this.oPb = null;
        this.oPc = null;
        this.oPe = null;
        this.oPg = null;
        this.oPh = null;
        this.oPi = null;
        if (this.oPk != null) {
            this.oPk.release();
            this.oPk = null;
        }
        this.oPn = null;
        if (this.oPo != null) {
            this.oPo.cl(null);
            this.oPo = null;
        }
        if (this.oPv != null) {
            this.oPv.dispose();
        }
    }
}
