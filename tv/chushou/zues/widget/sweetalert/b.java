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
    private static int oaG = -1;
    private TextView atX;
    private Button bXs;
    private View cuk;
    private Button egV;
    private String mCancelText;
    private String mConfirmText;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int oaH;
    private AnimationSet oaI;
    private AnimationSet oaJ;
    private Animation oaK;
    private Animation oaL;
    private AnimationSet oaM;
    private AnimationSet oaN;
    private Animation oaO;
    private EditText oaP;
    private boolean oaQ;
    private boolean oaR;
    private boolean oaS;
    private String oaT;
    private boolean oaU;
    private boolean oaV;
    private Drawable oaW;
    private Drawable oaX;
    private String oaY;
    private int oaZ;
    private FrameLayout oba;
    private FrameLayout obb;
    private FrameLayout obc;
    private SuccessTickView obd;
    private ImageView obe;
    private View obf;
    private View obg;
    private Drawable obh;
    private ImageView obi;
    private Button obk;
    private FrameLayout obl;
    private a obm;
    private a obn;
    private a obo;
    private boolean obp;
    private int obq;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.oaH = -1;
        this.oaQ = true;
        this.oaS = true;
        this.oaU = true;
        this.oaV = true;
        this.obq = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oaZ = i;
        this.oaL = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.oaM = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.oaM.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.oaO = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.oaN = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.oaI = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_in);
        this.oaJ = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_out);
        this.oaJ.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cuk.setVisibility(8);
                b.this.cuk.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.obp) {
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
        this.oaK = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.oaK.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oaZ == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.he(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oaZ == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cuk = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.atX = (TextView) findViewById(b.e.content_text);
        this.oba = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oba != null) {
            this.obe = (ImageView) this.oba.findViewById(b.e.error_x);
        }
        this.obb = (FrameLayout) findViewById(b.e.success_frame);
        this.obc = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.obb != null) {
            this.obd = (SuccessTickView) this.obb.findViewById(b.e.success_tick);
            this.obf = this.obb.findViewById(b.e.mask_left);
            this.obg = this.obb.findViewById(b.e.mask_right);
        }
        this.obi = (ImageView) findViewById(b.e.custom_image);
        this.obl = (FrameLayout) findViewById(b.e.warning_frame);
        this.bXs = (Button) findViewById(b.e.confirm_button);
        this.egV = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.obk = (Button) findViewById(b.e.middle_btn);
        this.oaP = (EditText) findViewById(b.e.et_input);
        this.bXs.setOnClickListener(this);
        if (this.egV != null) {
            this.egV.setOnClickListener(this);
        }
        if (this.obk != null) {
            this.obk.setOnClickListener(this);
        }
        xj(this.oaQ);
        xl(this.oaU);
        Tc(this.mTitleText);
        x(this.mContentText);
        OJ(this.obq);
        Td(this.mCancelText);
        Tf(this.mConfirmText);
        OK(this.oaH);
        A(this.oaX);
        Tg(this.oaY);
        Te(this.oaT);
        ah(this.oaZ, true);
        if (this.oaZ == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0807b.zues_text_color));
            }
            if (this.atX != null) {
                this.atX.setTextColor(this.mContext.getResources().getColor(b.C0807b.zues_text_color));
            }
        }
    }

    private void Kp() {
        if (this.obi != null) {
            this.obi.setVisibility(8);
        }
        if (this.oba != null) {
            this.oba.setVisibility(8);
        }
        if (this.obb != null) {
            this.obb.setVisibility(8);
        }
        if (this.obl != null) {
            this.obl.setVisibility(8);
        }
        if (this.obc != null) {
            this.obc.setVisibility(8);
        }
        if (this.bXs != null) {
            this.bXs.setVisibility(0);
        }
        this.bXs.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oba != null) {
            this.oba.clearAnimation();
        }
        if (this.obe != null) {
            this.obe.clearAnimation();
        }
        if (this.obd != null) {
            this.obd.clearAnimation();
        }
        if (this.obf != null) {
            this.obf.clearAnimation();
        }
        if (this.obg != null) {
            this.obg.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oaZ == 1) {
            this.oba.startAnimation(this.oaL);
            this.obe.startAnimation(this.oaM);
        } else if (this.oaZ == 2) {
            this.obd.dQT();
            this.obg.startAnimation(this.oaO);
        }
    }

    private void ah(int i, boolean z) {
        this.oaZ = i;
        if (this.cuk != null) {
            if (!z) {
                Kp();
            }
            switch (this.oaZ) {
                case 1:
                    this.oba.setVisibility(0);
                    break;
                case 2:
                    this.obb.setVisibility(0);
                    this.obf.startAnimation(this.oaN.getAnimations().get(0));
                    this.obg.startAnimation(this.oaN.getAnimations().get(1));
                    break;
                case 3:
                    this.bXs.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.obl.setVisibility(0);
                    break;
                case 4:
                    z(this.obh);
                    break;
                case 5:
                    this.obc.setVisibility(0);
                    this.bXs.setVisibility(8);
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
        this.obh = drawable;
        if (this.obi != null && this.obh != null) {
            this.obi.setVisibility(0);
            this.obi.setImageDrawable(this.obh);
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
        this.obq = i;
        if (this.atX != null && this.obq > 0) {
            this.atX.setTextSize(2, this.obq);
        }
        return this;
    }

    public b xj(boolean z) {
        this.oaQ = z;
        if (this.egV != null) {
            this.egV.setVisibility(this.oaQ ? 0 : 8);
        }
        return this;
    }

    public b xk(boolean z) {
        this.oaR = z;
        if (this.atX != null) {
            this.atX.setVisibility(this.oaR ? 0 : 8);
        }
        return this;
    }

    public b Td(String str) {
        this.mCancelText = str;
        if (this.egV != null && this.mCancelText != null) {
            xj(true);
            this.egV.setText(this.mCancelText);
            if (this.oaS) {
                this.egV.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.egV.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oaW != null) {
                ViewCompat.setBackground(this.egV, this.oaW);
            }
        }
        return this;
    }

    public b Te(String str) {
        this.oaT = str;
        if (this.obk != null && this.oaT != null) {
            this.obk.setText(this.oaT);
        }
        return this;
    }

    public b xl(boolean z) {
        this.oaU = z;
        if (this.obk != null) {
            if (z) {
                this.obk.setVisibility(0);
            } else {
                this.obk.setVisibility(8);
            }
        }
        return this;
    }

    public b Tf(String str) {
        this.mConfirmText = str;
        if (this.bXs != null && this.mConfirmText != null) {
            this.bXs.setText(this.mConfirmText);
            if (this.oaV) {
                this.bXs.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.bXs.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oaX != null) {
                ViewCompat.setBackground(this.bXs, this.oaX);
            }
        }
        return this;
    }

    public b OK(@ColorInt int i) {
        this.oaH = i;
        if (this.bXs != null) {
            if (this.oaH != -1) {
                this.bXs.setTextColor(this.oaH);
            } else if (oaG != -1) {
                this.bXs.setTextColor(oaG);
            }
        }
        return this;
    }

    public b A(Drawable drawable) {
        this.oaX = drawable;
        if (this.bXs != null) {
            ViewCompat.setBackground(this.bXs, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.obm = aVar;
        return this;
    }

    public b b(a aVar) {
        this.obn = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cuk.startAnimation(this.oaI);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xm(true);
    }

    public void dQU() {
        xm(false);
    }

    private void xm(boolean z) {
        this.obp = z;
        this.bXs.startAnimation(this.oaK);
        this.cuk.startAnimation(this.oaJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.obm != null) {
                this.obm.onClick(this);
            } else {
                dQU();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.obn != null) {
                this.obn.onClick(this);
            } else {
                dQU();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.obo != null) {
                this.obo.onClick(this);
            } else {
                dQU();
            }
        }
    }

    public b Tg(String str) {
        this.oaY = str;
        if (this.oaP != null && this.oaY != null) {
            this.oaP.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.egV != null && this.bXs != null) {
            if (this.egV.getVisibility() == 0 && this.bXs.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.egV.getVisibility() == 0) {
                ViewCompat.setBackground(this.egV, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.bXs.getVisibility() == 0) {
                ViewCompat.setBackground(this.bXs, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
