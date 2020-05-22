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
    private static int nRC = -1;
    private TextView aTU;
    private Button cID;
    private View deC;
    private Button eTR;
    private String fVF;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int nRD;
    private AnimationSet nRE;
    private AnimationSet nRF;
    private Animation nRG;
    private Animation nRH;
    private AnimationSet nRI;
    private AnimationSet nRJ;
    private Animation nRK;
    private EditText nRL;
    private boolean nRM;
    private boolean nRN;
    private String nRO;
    private boolean nRP;
    private String nRQ;
    private boolean nRR;
    private boolean nRS;
    private Drawable nRT;
    private Drawable nRU;
    private String nRV;
    private int nRW;
    private FrameLayout nRX;
    private FrameLayout nRY;
    private FrameLayout nRZ;
    private SuccessTickView nSa;
    private ImageView nSb;
    private View nSc;
    private View nSd;
    private Drawable nSe;
    private ImageView nSf;
    private Button nSg;
    private FrameLayout nSh;
    private a nSi;
    private a nSj;
    private a nSk;
    private boolean nSl;
    private int nSm;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.nRD = -1;
        this.nRM = true;
        this.nRP = true;
        this.nRR = true;
        this.nRS = true;
        this.nSm = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.nRW = i;
        this.nRH = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.nRI = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.nRI.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.nRK = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.nRJ = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.nRE = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.nRF = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.nRF.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.deC.setVisibility(8);
                b.this.deC.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.nSl) {
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
        this.nRG = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.nRG.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.nRW == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gw(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.nRW == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.deC = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aTU = (TextView) findViewById(b.e.content_text);
        this.nRX = (FrameLayout) findViewById(b.e.error_frame);
        if (this.nRX != null) {
            this.nSb = (ImageView) this.nRX.findViewById(b.e.error_x);
        }
        this.nRY = (FrameLayout) findViewById(b.e.success_frame);
        this.nRZ = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.nRY != null) {
            this.nSa = (SuccessTickView) this.nRY.findViewById(b.e.success_tick);
            this.nSc = this.nRY.findViewById(b.e.mask_left);
            this.nSd = this.nRY.findViewById(b.e.mask_right);
        }
        this.nSf = (ImageView) findViewById(b.e.custom_image);
        this.nSh = (FrameLayout) findViewById(b.e.warning_frame);
        this.cID = (Button) findViewById(b.e.confirm_button);
        this.eTR = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.nSg = (Button) findViewById(b.e.middle_btn);
        this.nRL = (EditText) findViewById(b.e.et_input);
        this.cID.setOnClickListener(this);
        if (this.eTR != null) {
            this.eTR.setOnClickListener(this);
        }
        if (this.nSg != null) {
            this.nSg.setOnClickListener(this);
        }
        xt(this.nRM);
        xv(this.nRR);
        SB(this.mTitleText);
        x(this.mContentText);
        KX(this.nSm);
        SC(this.nRO);
        SE(this.fVF);
        KY(this.nRD);
        w(this.nRU);
        SF(this.nRV);
        SD(this.nRQ);
        aj(this.nRW, true);
        if (this.nRW == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0914b.zues_text_color));
            }
            if (this.aTU != null) {
                this.aTU.setTextColor(this.mContext.getResources().getColor(b.C0914b.zues_text_color));
            }
        }
    }

    private void UR() {
        if (this.nSf != null) {
            this.nSf.setVisibility(8);
        }
        if (this.nRX != null) {
            this.nRX.setVisibility(8);
        }
        if (this.nRY != null) {
            this.nRY.setVisibility(8);
        }
        if (this.nSh != null) {
            this.nSh.setVisibility(8);
        }
        if (this.nRZ != null) {
            this.nRZ.setVisibility(8);
        }
        if (this.cID != null) {
            this.cID.setVisibility(0);
        }
        this.cID.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.nRX != null) {
            this.nRX.clearAnimation();
        }
        if (this.nSb != null) {
            this.nSb.clearAnimation();
        }
        if (this.nSa != null) {
            this.nSa.clearAnimation();
        }
        if (this.nSc != null) {
            this.nSc.clearAnimation();
        }
        if (this.nSd != null) {
            this.nSd.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.nRW == 1) {
            this.nRX.startAnimation(this.nRH);
            this.nSb.startAnimation(this.nRI);
        } else if (this.nRW == 2) {
            this.nSa.dSn();
            this.nSd.startAnimation(this.nRK);
        }
    }

    private void aj(int i, boolean z) {
        this.nRW = i;
        if (this.deC != null) {
            if (!z) {
                UR();
            }
            switch (this.nRW) {
                case 1:
                    this.nRX.setVisibility(0);
                    break;
                case 2:
                    this.nRY.setVisibility(0);
                    this.nSc.startAnimation(this.nRJ.getAnimations().get(0));
                    this.nSd.startAnimation(this.nRJ.getAnimations().get(1));
                    break;
                case 3:
                    this.cID.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.nSh.setVisibility(0);
                    break;
                case 4:
                    v(this.nSe);
                    break;
                case 5:
                    this.nRZ.setVisibility(0);
                    this.cID.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b SB(String str) {
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

    public b bf(String str, boolean z) {
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

    public b v(Drawable drawable) {
        this.nSe = drawable;
        if (this.nSf != null && this.nSe != null) {
            this.nSf.setVisibility(0);
            this.nSf.setImageDrawable(this.nSe);
        }
        return this;
    }

    public b x(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aTU != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                xu(true);
                this.aTU.setText(this.mContentText);
            } else {
                xu(false);
            }
        }
        return this;
    }

    public b KX(int i) {
        this.nSm = i;
        if (this.aTU != null && this.nSm > 0) {
            this.aTU.setTextSize(2, this.nSm);
        }
        return this;
    }

    public b xt(boolean z) {
        this.nRM = z;
        if (this.eTR != null) {
            this.eTR.setVisibility(this.nRM ? 0 : 8);
        }
        return this;
    }

    public b xu(boolean z) {
        this.nRN = z;
        if (this.aTU != null) {
            this.aTU.setVisibility(this.nRN ? 0 : 8);
        }
        return this;
    }

    public b SC(String str) {
        this.nRO = str;
        if (this.eTR != null && this.nRO != null) {
            xt(true);
            this.eTR.setText(this.nRO);
            if (this.nRP) {
                this.eTR.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.eTR.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nRT != null) {
                ViewCompat.setBackground(this.eTR, this.nRT);
            }
        }
        return this;
    }

    public b SD(String str) {
        this.nRQ = str;
        if (this.nSg != null && this.nRQ != null) {
            this.nSg.setText(this.nRQ);
        }
        return this;
    }

    public b xv(boolean z) {
        this.nRR = z;
        if (this.nSg != null) {
            if (z) {
                this.nSg.setVisibility(0);
            } else {
                this.nSg.setVisibility(8);
            }
        }
        return this;
    }

    public b SE(String str) {
        this.fVF = str;
        if (this.cID != null && this.fVF != null) {
            this.cID.setText(this.fVF);
            if (this.nRS) {
                this.cID.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cID.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nRU != null) {
                ViewCompat.setBackground(this.cID, this.nRU);
            }
        }
        return this;
    }

    public b KY(@ColorInt int i) {
        this.nRD = i;
        if (this.cID != null) {
            if (this.nRD != -1) {
                this.cID.setTextColor(this.nRD);
            } else if (nRC != -1) {
                this.cID.setTextColor(nRC);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.nRU = drawable;
        if (this.cID != null) {
            ViewCompat.setBackground(this.cID, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.nSi = aVar;
        return this;
    }

    public b b(a aVar) {
        this.nSj = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.deC.startAnimation(this.nRE);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xw(true);
    }

    public void dSo() {
        xw(false);
    }

    private void xw(boolean z) {
        this.nSl = z;
        this.cID.startAnimation(this.nRG);
        this.deC.startAnimation(this.nRF);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.nSi != null) {
                this.nSi.onClick(this);
            } else {
                dSo();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.nSj != null) {
                this.nSj.onClick(this);
            } else {
                dSo();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.nSk != null) {
                this.nSk.onClick(this);
            } else {
                dSo();
            }
        }
    }

    public b SF(String str) {
        this.nRV = str;
        if (this.nRL != null && this.nRV != null) {
            this.nRL.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.eTR != null && this.cID != null) {
            if (this.eTR.getVisibility() == 0 && this.cID.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.eTR.getVisibility() == 0) {
                ViewCompat.setBackground(this.eTR, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cID.getVisibility() == 0) {
                ViewCompat.setBackground(this.cID, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
