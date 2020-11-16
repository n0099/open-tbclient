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
/* loaded from: classes6.dex */
public class b extends Dialog implements View.OnClickListener {
    @ColorInt
    private static int qsj = -1;
    private TextView aDw;
    private Button dAJ;
    private View dZY;
    private Button fXR;
    private String hjs;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    private AnimationSet oCx;
    private Drawable qsA;
    private String qsB;
    private int qsC;
    private FrameLayout qsD;
    private FrameLayout qsE;
    private FrameLayout qsF;
    private SuccessTickView qsG;
    private ImageView qsH;
    private View qsI;
    private View qsJ;
    private Drawable qsK;
    private ImageView qsL;
    private Button qsM;
    private FrameLayout qsN;
    private a qsO;
    private a qsP;
    private a qsQ;
    private boolean qsR;
    private int qsS;
    @ColorInt
    private int qsk;
    private AnimationSet qsl;
    private Animation qsm;
    private Animation qsn;
    private AnimationSet qso;
    private AnimationSet qsp;
    private Animation qsq;
    private EditText qsr;
    private boolean qss;
    private boolean qst;
    private String qsu;
    private boolean qsv;
    private String qsw;
    private boolean qsx;
    private boolean qsy;
    private Drawable qsz;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.qsk = -1;
        this.qss = true;
        this.qsv = true;
        this.qsx = true;
        this.qsy = true;
        this.qsS = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.qsC = i;
        this.qsn = tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.qso = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.qso.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.qsq = tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.qsp = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.qsl = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_modal_in);
        this.oCx = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_modal_out);
        this.oCx.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dZY.setVisibility(8);
                b.this.dZY.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.qsR) {
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
        this.qsm = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.qsm.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.qsC == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hC(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.qsC == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dZY = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aDw = (TextView) findViewById(b.e.content_text);
        this.qsD = (FrameLayout) findViewById(b.e.error_frame);
        if (this.qsD != null) {
            this.qsH = (ImageView) this.qsD.findViewById(b.e.error_x);
        }
        this.qsE = (FrameLayout) findViewById(b.e.success_frame);
        this.qsF = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.qsE != null) {
            this.qsG = (SuccessTickView) this.qsE.findViewById(b.e.success_tick);
            this.qsI = this.qsE.findViewById(b.e.mask_left);
            this.qsJ = this.qsE.findViewById(b.e.mask_right);
        }
        this.qsL = (ImageView) findViewById(b.e.custom_image);
        this.qsN = (FrameLayout) findViewById(b.e.warning_frame);
        this.dAJ = (Button) findViewById(b.e.confirm_button);
        this.fXR = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.qsM = (Button) findViewById(b.e.middle_btn);
        this.qsr = (EditText) findViewById(b.e.et_input);
        this.dAJ.setOnClickListener(this);
        if (this.fXR != null) {
            this.fXR.setOnClickListener(this);
        }
        if (this.qsM != null) {
            this.qsM.setOnClickListener(this);
        }
        BC(this.qss);
        BE(this.qsx);
        aav(this.mTitleText);
        E(this.mContentText);
        SW(this.qsS);
        aaw(this.qsu);
        aay(this.hjs);
        SX(this.qsk);
        C(this.qsA);
        aaz(this.qsB);
        aax(this.qsw);
        as(this.qsC, true);
        if (this.qsC == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C1118b.zues_text_color));
            }
            if (this.aDw != null) {
                this.aDw.setTextColor(this.mContext.getResources().getColor(b.C1118b.zues_text_color));
            }
        }
    }

    private void ajQ() {
        if (this.qsL != null) {
            this.qsL.setVisibility(8);
        }
        if (this.qsD != null) {
            this.qsD.setVisibility(8);
        }
        if (this.qsE != null) {
            this.qsE.setVisibility(8);
        }
        if (this.qsN != null) {
            this.qsN.setVisibility(8);
        }
        if (this.qsF != null) {
            this.qsF.setVisibility(8);
        }
        if (this.dAJ != null) {
            this.dAJ.setVisibility(0);
        }
        this.dAJ.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.qsD != null) {
            this.qsD.clearAnimation();
        }
        if (this.qsH != null) {
            this.qsH.clearAnimation();
        }
        if (this.qsG != null) {
            this.qsG.clearAnimation();
        }
        if (this.qsI != null) {
            this.qsI.clearAnimation();
        }
        if (this.qsJ != null) {
            this.qsJ.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.qsC == 1) {
            this.qsD.startAnimation(this.qsn);
            this.qsH.startAnimation(this.qso);
        } else if (this.qsC == 2) {
            this.qsG.eIp();
            this.qsJ.startAnimation(this.qsq);
        }
    }

    private void as(int i, boolean z) {
        this.qsC = i;
        if (this.dZY != null) {
            if (!z) {
                ajQ();
            }
            switch (this.qsC) {
                case 1:
                    this.qsD.setVisibility(0);
                    break;
                case 2:
                    this.qsE.setVisibility(0);
                    this.qsI.startAnimation(this.qsp.getAnimations().get(0));
                    this.qsJ.startAnimation(this.qsp.getAnimations().get(1));
                    break;
                case 3:
                    this.dAJ.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.qsN.setVisibility(0);
                    break;
                case 4:
                    B(this.qsK);
                    break;
                case 5:
                    this.qsF.setVisibility(0);
                    this.dAJ.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b aav(String str) {
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

    public b bv(String str, boolean z) {
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

    public b B(Drawable drawable) {
        this.qsK = drawable;
        if (this.qsL != null && this.qsK != null) {
            this.qsL.setVisibility(0);
            this.qsL.setImageDrawable(this.qsK);
        }
        return this;
    }

    public b E(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aDw != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                BD(true);
                this.aDw.setText(this.mContentText);
            } else {
                BD(false);
            }
        }
        return this;
    }

    public b SW(int i) {
        this.qsS = i;
        if (this.aDw != null && this.qsS > 0) {
            this.aDw.setTextSize(2, this.qsS);
        }
        return this;
    }

    public b BC(boolean z) {
        this.qss = z;
        if (this.fXR != null) {
            this.fXR.setVisibility(this.qss ? 0 : 8);
        }
        return this;
    }

    public b BD(boolean z) {
        this.qst = z;
        if (this.aDw != null) {
            this.aDw.setVisibility(this.qst ? 0 : 8);
        }
        return this;
    }

    public b aaw(String str) {
        this.qsu = str;
        if (this.fXR != null && this.qsu != null) {
            BC(true);
            this.fXR.setText(this.qsu);
            if (this.qsv) {
                this.fXR.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fXR.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.qsz != null) {
                ViewCompat.setBackground(this.fXR, this.qsz);
            }
        }
        return this;
    }

    public b aax(String str) {
        this.qsw = str;
        if (this.qsM != null && this.qsw != null) {
            this.qsM.setText(this.qsw);
        }
        return this;
    }

    public b BE(boolean z) {
        this.qsx = z;
        if (this.qsM != null) {
            if (z) {
                this.qsM.setVisibility(0);
            } else {
                this.qsM.setVisibility(8);
            }
        }
        return this;
    }

    public b aay(String str) {
        this.hjs = str;
        if (this.dAJ != null && this.hjs != null) {
            this.dAJ.setText(this.hjs);
            if (this.qsy) {
                this.dAJ.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.dAJ.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.qsA != null) {
                ViewCompat.setBackground(this.dAJ, this.qsA);
            }
        }
        return this;
    }

    public b SX(@ColorInt int i) {
        this.qsk = i;
        if (this.dAJ != null) {
            if (this.qsk != -1) {
                this.dAJ.setTextColor(this.qsk);
            } else if (qsj != -1) {
                this.dAJ.setTextColor(qsj);
            }
        }
        return this;
    }

    public b C(Drawable drawable) {
        this.qsA = drawable;
        if (this.dAJ != null) {
            ViewCompat.setBackground(this.dAJ, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.qsO = aVar;
        return this;
    }

    public b b(a aVar) {
        this.qsP = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dZY.startAnimation(this.qsl);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        zX(true);
    }

    public void eIq() {
        zX(false);
    }

    private void zX(boolean z) {
        this.qsR = z;
        this.dAJ.startAnimation(this.qsm);
        this.dZY.startAnimation(this.oCx);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.qsO != null) {
                this.qsO.onClick(this);
            } else {
                eIq();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.qsP != null) {
                this.qsP.onClick(this);
            } else {
                eIq();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.qsQ != null) {
                this.qsQ.onClick(this);
            } else {
                eIq();
            }
        }
    }

    public b aaz(String str) {
        this.qsB = str;
        if (this.qsr != null && this.qsB != null) {
            this.qsr.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fXR != null && this.dAJ != null) {
            if (this.fXR.getVisibility() == 0 && this.dAJ.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fXR.getVisibility() == 0) {
                ViewCompat.setBackground(this.fXR, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.dAJ.getVisibility() == 0) {
                ViewCompat.setBackground(this.dAJ, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
