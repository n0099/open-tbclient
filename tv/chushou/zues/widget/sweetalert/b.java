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
    private static int oaE = -1;
    private TextView atX;
    private Button bXr;
    private View cuj;
    private Button egU;
    private String mCancelText;
    private String mConfirmText;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int oaF;
    private AnimationSet oaG;
    private AnimationSet oaH;
    private Animation oaI;
    private Animation oaJ;
    private AnimationSet oaK;
    private AnimationSet oaL;
    private Animation oaM;
    private EditText oaN;
    private boolean oaO;
    private boolean oaP;
    private boolean oaQ;
    private String oaR;
    private boolean oaS;
    private boolean oaT;
    private Drawable oaU;
    private Drawable oaV;
    private String oaW;
    private int oaX;
    private FrameLayout oaY;
    private FrameLayout oaZ;
    private FrameLayout oba;
    private SuccessTickView obb;
    private ImageView obc;
    private View obd;
    private View obe;
    private Drawable obf;
    private ImageView obg;
    private Button obh;
    private FrameLayout obi;
    private a obk;
    private a obl;
    private a obm;
    private boolean obn;
    private int obo;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.oaF = -1;
        this.oaO = true;
        this.oaQ = true;
        this.oaS = true;
        this.oaT = true;
        this.obo = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oaX = i;
        this.oaJ = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.oaK = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.oaK.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.oaM = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.oaL = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.oaG = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_in);
        this.oaH = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_out);
        this.oaH.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cuj.setVisibility(8);
                b.this.cuj.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.obn) {
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
        this.oaI = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.oaI.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oaX == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.he(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oaX == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cuj = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.atX = (TextView) findViewById(b.e.content_text);
        this.oaY = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oaY != null) {
            this.obc = (ImageView) this.oaY.findViewById(b.e.error_x);
        }
        this.oaZ = (FrameLayout) findViewById(b.e.success_frame);
        this.oba = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.oaZ != null) {
            this.obb = (SuccessTickView) this.oaZ.findViewById(b.e.success_tick);
            this.obd = this.oaZ.findViewById(b.e.mask_left);
            this.obe = this.oaZ.findViewById(b.e.mask_right);
        }
        this.obg = (ImageView) findViewById(b.e.custom_image);
        this.obi = (FrameLayout) findViewById(b.e.warning_frame);
        this.bXr = (Button) findViewById(b.e.confirm_button);
        this.egU = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.obh = (Button) findViewById(b.e.middle_btn);
        this.oaN = (EditText) findViewById(b.e.et_input);
        this.bXr.setOnClickListener(this);
        if (this.egU != null) {
            this.egU.setOnClickListener(this);
        }
        if (this.obh != null) {
            this.obh.setOnClickListener(this);
        }
        xj(this.oaO);
        xl(this.oaS);
        Tc(this.mTitleText);
        x(this.mContentText);
        OJ(this.obo);
        Td(this.mCancelText);
        Tf(this.mConfirmText);
        OK(this.oaF);
        A(this.oaV);
        Tg(this.oaW);
        Te(this.oaR);
        ah(this.oaX, true);
        if (this.oaX == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0807b.zues_text_color));
            }
            if (this.atX != null) {
                this.atX.setTextColor(this.mContext.getResources().getColor(b.C0807b.zues_text_color));
            }
        }
    }

    private void Kn() {
        if (this.obg != null) {
            this.obg.setVisibility(8);
        }
        if (this.oaY != null) {
            this.oaY.setVisibility(8);
        }
        if (this.oaZ != null) {
            this.oaZ.setVisibility(8);
        }
        if (this.obi != null) {
            this.obi.setVisibility(8);
        }
        if (this.oba != null) {
            this.oba.setVisibility(8);
        }
        if (this.bXr != null) {
            this.bXr.setVisibility(0);
        }
        this.bXr.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oaY != null) {
            this.oaY.clearAnimation();
        }
        if (this.obc != null) {
            this.obc.clearAnimation();
        }
        if (this.obb != null) {
            this.obb.clearAnimation();
        }
        if (this.obd != null) {
            this.obd.clearAnimation();
        }
        if (this.obe != null) {
            this.obe.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oaX == 1) {
            this.oaY.startAnimation(this.oaJ);
            this.obc.startAnimation(this.oaK);
        } else if (this.oaX == 2) {
            this.obb.dQR();
            this.obe.startAnimation(this.oaM);
        }
    }

    private void ah(int i, boolean z) {
        this.oaX = i;
        if (this.cuj != null) {
            if (!z) {
                Kn();
            }
            switch (this.oaX) {
                case 1:
                    this.oaY.setVisibility(0);
                    break;
                case 2:
                    this.oaZ.setVisibility(0);
                    this.obd.startAnimation(this.oaL.getAnimations().get(0));
                    this.obe.startAnimation(this.oaL.getAnimations().get(1));
                    break;
                case 3:
                    this.bXr.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.obi.setVisibility(0);
                    break;
                case 4:
                    z(this.obf);
                    break;
                case 5:
                    this.oba.setVisibility(0);
                    this.bXr.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Tc(String str) {
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
        this.obf = drawable;
        if (this.obg != null && this.obf != null) {
            this.obg.setVisibility(0);
            this.obg.setImageDrawable(this.obf);
        }
        return this;
    }

    public b x(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.atX != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                xk(true);
                this.atX.setText(this.mContentText);
            } else {
                xk(false);
            }
        }
        return this;
    }

    public b OJ(int i) {
        this.obo = i;
        if (this.atX != null && this.obo > 0) {
            this.atX.setTextSize(2, this.obo);
        }
        return this;
    }

    public b xj(boolean z) {
        this.oaO = z;
        if (this.egU != null) {
            this.egU.setVisibility(this.oaO ? 0 : 8);
        }
        return this;
    }

    public b xk(boolean z) {
        this.oaP = z;
        if (this.atX != null) {
            this.atX.setVisibility(this.oaP ? 0 : 8);
        }
        return this;
    }

    public b Td(String str) {
        this.mCancelText = str;
        if (this.egU != null && this.mCancelText != null) {
            xj(true);
            this.egU.setText(this.mCancelText);
            if (this.oaQ) {
                this.egU.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.egU.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oaU != null) {
                ViewCompat.setBackground(this.egU, this.oaU);
            }
        }
        return this;
    }

    public b Te(String str) {
        this.oaR = str;
        if (this.obh != null && this.oaR != null) {
            this.obh.setText(this.oaR);
        }
        return this;
    }

    public b xl(boolean z) {
        this.oaS = z;
        if (this.obh != null) {
            if (z) {
                this.obh.setVisibility(0);
            } else {
                this.obh.setVisibility(8);
            }
        }
        return this;
    }

    public b Tf(String str) {
        this.mConfirmText = str;
        if (this.bXr != null && this.mConfirmText != null) {
            this.bXr.setText(this.mConfirmText);
            if (this.oaT) {
                this.bXr.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.bXr.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oaV != null) {
                ViewCompat.setBackground(this.bXr, this.oaV);
            }
        }
        return this;
    }

    public b OK(@ColorInt int i) {
        this.oaF = i;
        if (this.bXr != null) {
            if (this.oaF != -1) {
                this.bXr.setTextColor(this.oaF);
            } else if (oaE != -1) {
                this.bXr.setTextColor(oaE);
            }
        }
        return this;
    }

    public b A(Drawable drawable) {
        this.oaV = drawable;
        if (this.bXr != null) {
            ViewCompat.setBackground(this.bXr, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.obk = aVar;
        return this;
    }

    public b b(a aVar) {
        this.obl = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cuj.startAnimation(this.oaG);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xm(true);
    }

    public void dQS() {
        xm(false);
    }

    private void xm(boolean z) {
        this.obn = z;
        this.bXr.startAnimation(this.oaI);
        this.cuj.startAnimation(this.oaH);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.obk != null) {
                this.obk.onClick(this);
            } else {
                dQS();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.obl != null) {
                this.obl.onClick(this);
            } else {
                dQS();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.obm != null) {
                this.obm.onClick(this);
            } else {
                dQS();
            }
        }
    }

    public b Tg(String str) {
        this.oaW = str;
        if (this.oaN != null && this.oaW != null) {
            this.oaN.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.egU != null && this.bXr != null) {
            if (this.egU.getVisibility() == 0 && this.bXr.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.egU.getVisibility() == 0) {
                ViewCompat.setBackground(this.egU, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.bXr.getVisibility() == 0) {
                ViewCompat.setBackground(this.bXr, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
