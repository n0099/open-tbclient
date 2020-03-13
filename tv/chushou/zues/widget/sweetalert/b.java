package tv.chushou.zues.widget.sweetalert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import tv.chushou.zues.b;
/* loaded from: classes5.dex */
public class b extends Dialog implements View.OnClickListener {
    @ColorInt
    private static int oaR = -1;
    private TextView atY;
    private Button bXt;
    private View cul;
    private Button ehi;
    private String mCancelText;
    private String mConfirmText;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int oaS;
    private AnimationSet oaT;
    private AnimationSet oaU;
    private Animation oaV;
    private Animation oaW;
    private AnimationSet oaX;
    private AnimationSet oaY;
    private Animation oaZ;
    private boolean obA;
    private int obB;
    private EditText oba;
    private boolean obb;
    private boolean obc;
    private boolean obd;
    private String obe;
    private boolean obf;
    private boolean obg;
    private Drawable obh;
    private Drawable obi;
    private String obk;
    private int obl;
    private FrameLayout obm;
    private FrameLayout obn;
    private FrameLayout obo;
    private SuccessTickView obp;
    private ImageView obq;
    private View obr;
    private View obs;
    private Drawable obt;
    private ImageView obu;
    private Button obv;
    private FrameLayout obw;
    private a obx;
    private a oby;
    private a obz;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.oaS = -1;
        this.obb = true;
        this.obd = true;
        this.obf = true;
        this.obg = true;
        this.obB = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.obl = i;
        this.oaW = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.oaX = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.oaX.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.oaZ = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.oaY = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.oaT = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_in);
        this.oaU = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_out);
        this.oaU.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cul.setVisibility(8);
                b.this.cul.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.obA) {
                            b.super.cancel();
                        } else {
                            b.super.dismiss();
                        }
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.oaV = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.oaV.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.obl == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.he(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.obl == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cul = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.atY = (TextView) findViewById(b.e.content_text);
        this.obm = (FrameLayout) findViewById(b.e.error_frame);
        if (this.obm != null) {
            this.obq = (ImageView) this.obm.findViewById(b.e.error_x);
        }
        this.obn = (FrameLayout) findViewById(b.e.success_frame);
        this.obo = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.obn != null) {
            this.obp = (SuccessTickView) this.obn.findViewById(b.e.success_tick);
            this.obr = this.obn.findViewById(b.e.mask_left);
            this.obs = this.obn.findViewById(b.e.mask_right);
        }
        this.obu = (ImageView) findViewById(b.e.custom_image);
        this.obw = (FrameLayout) findViewById(b.e.warning_frame);
        this.bXt = (Button) findViewById(b.e.confirm_button);
        this.ehi = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.obv = (Button) findViewById(b.e.middle_btn);
        this.oba = (EditText) findViewById(b.e.et_input);
        this.bXt.setOnClickListener(this);
        if (this.ehi != null) {
            this.ehi.setOnClickListener(this);
        }
        if (this.obv != null) {
            this.obv.setOnClickListener(this);
        }
        xj(this.obb);
        xl(this.obf);
        Td(this.mTitleText);
        x(this.mContentText);
        OJ(this.obB);
        Te(this.mCancelText);
        Tg(this.mConfirmText);
        OK(this.oaS);
        A(this.obi);
        Th(this.obk);
        Tf(this.obe);
        ah(this.obl, true);
        if (this.obl == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0807b.zues_text_color));
            }
            if (this.atY != null) {
                this.atY.setTextColor(this.mContext.getResources().getColor(b.C0807b.zues_text_color));
            }
        }
    }

    private void Kp() {
        if (this.obu != null) {
            this.obu.setVisibility(8);
        }
        if (this.obm != null) {
            this.obm.setVisibility(8);
        }
        if (this.obn != null) {
            this.obn.setVisibility(8);
        }
        if (this.obw != null) {
            this.obw.setVisibility(8);
        }
        if (this.obo != null) {
            this.obo.setVisibility(8);
        }
        if (this.bXt != null) {
            this.bXt.setVisibility(0);
        }
        this.bXt.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.obm != null) {
            this.obm.clearAnimation();
        }
        if (this.obq != null) {
            this.obq.clearAnimation();
        }
        if (this.obp != null) {
            this.obp.clearAnimation();
        }
        if (this.obr != null) {
            this.obr.clearAnimation();
        }
        if (this.obs != null) {
            this.obs.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.obl == 1) {
            this.obm.startAnimation(this.oaW);
            this.obq.startAnimation(this.oaX);
        } else if (this.obl == 2) {
            this.obp.dQU();
            this.obs.startAnimation(this.oaZ);
        }
    }

    private void ah(int i, boolean z) {
        this.obl = i;
        if (this.cul != null) {
            if (!z) {
                Kp();
            }
            switch (this.obl) {
                case 1:
                    this.obm.setVisibility(0);
                    break;
                case 2:
                    this.obn.setVisibility(0);
                    this.obr.startAnimation(this.oaY.getAnimations().get(0));
                    this.obs.startAnimation(this.oaY.getAnimations().get(1));
                    break;
                case 3:
                    this.bXt.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.obw.setVisibility(0);
                    break;
                case 4:
                    z(this.obt);
                    break;
                case 5:
                    this.obo.setVisibility(0);
                    this.bXt.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Td(String str) {
        this.mTitleText = str;
        if (this.mTitleTextView != null) {
            if (this.mTitleText != null) {
                this.mTitleTextView.setVisibility(0);
                this.mTitleTextView.setText(this.mTitleText);
            } else {
                this.mTitleTextView.setVisibility(8);
            }
        }
        return this;
    }

    public b aW(String str, boolean z) {
        this.mTitleText = str;
        if (this.mTitleTextView != null) {
            if (this.mTitleText != null) {
                this.mTitleTextView.setVisibility(0);
                this.mTitleTextView.setText(this.mTitleText);
                if (z) {
                    this.mTitleTextView.getPaint().setFakeBoldText(true);
                }
            } else {
                this.mTitleTextView.setVisibility(8);
            }
        }
        return this;
    }

    public b z(Drawable drawable) {
        this.obt = drawable;
        if (this.obu != null && this.obt != null) {
            this.obu.setVisibility(0);
            this.obu.setImageDrawable(this.obt);
        }
        return this;
    }

    public b x(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.atY != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                xk(true);
                this.atY.setText(this.mContentText);
            } else {
                xk(false);
            }
        }
        return this;
    }

    public b OJ(int i) {
        this.obB = i;
        if (this.atY != null && this.obB > 0) {
            this.atY.setTextSize(2, this.obB);
        }
        return this;
    }

    public b xj(boolean z) {
        this.obb = z;
        if (this.ehi != null) {
            this.ehi.setVisibility(this.obb ? 0 : 8);
        }
        return this;
    }

    public b xk(boolean z) {
        this.obc = z;
        if (this.atY != null) {
            this.atY.setVisibility(this.obc ? 0 : 8);
        }
        return this;
    }

    public b Te(String str) {
        this.mCancelText = str;
        if (this.ehi != null && this.mCancelText != null) {
            xj(true);
            this.ehi.setText(this.mCancelText);
            if (this.obd) {
                this.ehi.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.ehi.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.obh != null) {
                ViewCompat.setBackground(this.ehi, this.obh);
            }
        }
        return this;
    }

    public b Tf(String str) {
        this.obe = str;
        if (this.obv != null && this.obe != null) {
            this.obv.setText(this.obe);
        }
        return this;
    }

    public b xl(boolean z) {
        this.obf = z;
        if (this.obv != null) {
            if (z) {
                this.obv.setVisibility(0);
            } else {
                this.obv.setVisibility(8);
            }
        }
        return this;
    }

    public b Tg(String str) {
        this.mConfirmText = str;
        if (this.bXt != null && this.mConfirmText != null) {
            this.bXt.setText(this.mConfirmText);
            if (this.obg) {
                this.bXt.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.bXt.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.obi != null) {
                ViewCompat.setBackground(this.bXt, this.obi);
            }
        }
        return this;
    }

    public b OK(@ColorInt int i) {
        this.oaS = i;
        if (this.bXt != null) {
            if (this.oaS != -1) {
                this.bXt.setTextColor(this.oaS);
            } else if (oaR != -1) {
                this.bXt.setTextColor(oaR);
            }
        }
        return this;
    }

    public b A(Drawable drawable) {
        this.obi = drawable;
        if (this.bXt != null) {
            ViewCompat.setBackground(this.bXt, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.obx = aVar;
        return this;
    }

    public b b(a aVar) {
        this.oby = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cul.startAnimation(this.oaT);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xm(true);
    }

    public void dQV() {
        xm(false);
    }

    private void xm(boolean z) {
        this.obA = z;
        this.bXt.startAnimation(this.oaV);
        this.cul.startAnimation(this.oaU);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.obx != null) {
                this.obx.onClick(this);
            } else {
                dQV();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.oby != null) {
                this.oby.onClick(this);
            } else {
                dQV();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.obz != null) {
                this.obz.onClick(this);
            } else {
                dQV();
            }
        }
    }

    public b Th(String str) {
        this.obk = str;
        if (this.oba != null && this.obk != null) {
            this.oba.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.ehi != null && this.bXt != null) {
            if (this.ehi.getVisibility() == 0 && this.bXt.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.ehi.getVisibility() == 0) {
                ViewCompat.setBackground(this.ehi, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.bXt.getVisibility() == 0) {
                ViewCompat.setBackground(this.bXt, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
