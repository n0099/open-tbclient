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
    private static int oRo = -1;
    private TextView aAy;
    private Button cZM;
    private View dzp;
    private Button fuG;
    private String gAF;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    private String oRA;
    private boolean oRB;
    private String oRC;
    private boolean oRD;
    private boolean oRE;
    private Drawable oRF;
    private Drawable oRG;
    private String oRH;
    private int oRI;
    private FrameLayout oRJ;
    private FrameLayout oRK;
    private FrameLayout oRL;
    private SuccessTickView oRM;
    private ImageView oRN;
    private View oRO;
    private View oRP;
    private Drawable oRQ;
    private ImageView oRR;
    private Button oRS;
    private FrameLayout oRT;
    private a oRU;
    private a oRV;
    private a oRW;
    private boolean oRX;
    private int oRY;
    @ColorInt
    private int oRp;
    private AnimationSet oRq;
    private AnimationSet oRr;
    private Animation oRs;
    private Animation oRt;
    private AnimationSet oRu;
    private AnimationSet oRv;
    private Animation oRw;
    private EditText oRx;
    private boolean oRy;
    private boolean oRz;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.oRp = -1;
        this.oRy = true;
        this.oRB = true;
        this.oRD = true;
        this.oRE = true;
        this.oRY = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oRI = i;
        this.oRt = tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.oRu = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.oRu.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.oRw = tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.oRv = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.oRq = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_modal_in);
        this.oRr = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_modal_out);
        this.oRr.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dzp.setVisibility(8);
                b.this.dzp.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oRX) {
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
        this.oRs = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.oRs.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oRI == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gX(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oRI == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dzp = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aAy = (TextView) findViewById(b.e.content_text);
        this.oRJ = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oRJ != null) {
            this.oRN = (ImageView) this.oRJ.findViewById(b.e.error_x);
        }
        this.oRK = (FrameLayout) findViewById(b.e.success_frame);
        this.oRL = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.oRK != null) {
            this.oRM = (SuccessTickView) this.oRK.findViewById(b.e.success_tick);
            this.oRO = this.oRK.findViewById(b.e.mask_left);
            this.oRP = this.oRK.findViewById(b.e.mask_right);
        }
        this.oRR = (ImageView) findViewById(b.e.custom_image);
        this.oRT = (FrameLayout) findViewById(b.e.warning_frame);
        this.cZM = (Button) findViewById(b.e.confirm_button);
        this.fuG = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.oRS = (Button) findViewById(b.e.middle_btn);
        this.oRx = (EditText) findViewById(b.e.et_input);
        this.cZM.setOnClickListener(this);
        if (this.fuG != null) {
            this.fuG.setOnClickListener(this);
        }
        if (this.oRS != null) {
            this.oRS.setOnClickListener(this);
        }
        zp(this.oRy);
        zr(this.oRD);
        Xe(this.mTitleText);
        B(this.mContentText);
        Pc(this.oRY);
        Xf(this.oRA);
        Xh(this.gAF);
        Pd(this.oRp);
        w(this.oRG);
        Xi(this.oRH);
        Xg(this.oRC);
        am(this.oRI, true);
        if (this.oRI == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C1008b.zues_text_color));
            }
            if (this.aAy != null) {
                this.aAy.setTextColor(this.mContext.getResources().getColor(b.C1008b.zues_text_color));
            }
        }
    }

    private void acK() {
        if (this.oRR != null) {
            this.oRR.setVisibility(8);
        }
        if (this.oRJ != null) {
            this.oRJ.setVisibility(8);
        }
        if (this.oRK != null) {
            this.oRK.setVisibility(8);
        }
        if (this.oRT != null) {
            this.oRT.setVisibility(8);
        }
        if (this.oRL != null) {
            this.oRL.setVisibility(8);
        }
        if (this.cZM != null) {
            this.cZM.setVisibility(0);
        }
        this.cZM.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oRJ != null) {
            this.oRJ.clearAnimation();
        }
        if (this.oRN != null) {
            this.oRN.clearAnimation();
        }
        if (this.oRM != null) {
            this.oRM.clearAnimation();
        }
        if (this.oRO != null) {
            this.oRO.clearAnimation();
        }
        if (this.oRP != null) {
            this.oRP.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oRI == 1) {
            this.oRJ.startAnimation(this.oRt);
            this.oRN.startAnimation(this.oRu);
        } else if (this.oRI == 2) {
            this.oRM.emU();
            this.oRP.startAnimation(this.oRw);
        }
    }

    private void am(int i, boolean z) {
        this.oRI = i;
        if (this.dzp != null) {
            if (!z) {
                acK();
            }
            switch (this.oRI) {
                case 1:
                    this.oRJ.setVisibility(0);
                    break;
                case 2:
                    this.oRK.setVisibility(0);
                    this.oRO.startAnimation(this.oRv.getAnimations().get(0));
                    this.oRP.startAnimation(this.oRv.getAnimations().get(1));
                    break;
                case 3:
                    this.cZM.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.oRT.setVisibility(0);
                    break;
                case 4:
                    v(this.oRQ);
                    break;
                case 5:
                    this.oRL.setVisibility(0);
                    this.cZM.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Xe(String str) {
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

    public b bi(String str, boolean z) {
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
        this.oRQ = drawable;
        if (this.oRR != null && this.oRQ != null) {
            this.oRR.setVisibility(0);
            this.oRR.setImageDrawable(this.oRQ);
        }
        return this;
    }

    public b B(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aAy != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                zq(true);
                this.aAy.setText(this.mContentText);
            } else {
                zq(false);
            }
        }
        return this;
    }

    public b Pc(int i) {
        this.oRY = i;
        if (this.aAy != null && this.oRY > 0) {
            this.aAy.setTextSize(2, this.oRY);
        }
        return this;
    }

    public b zp(boolean z) {
        this.oRy = z;
        if (this.fuG != null) {
            this.fuG.setVisibility(this.oRy ? 0 : 8);
        }
        return this;
    }

    public b zq(boolean z) {
        this.oRz = z;
        if (this.aAy != null) {
            this.aAy.setVisibility(this.oRz ? 0 : 8);
        }
        return this;
    }

    public b Xf(String str) {
        this.oRA = str;
        if (this.fuG != null && this.oRA != null) {
            zp(true);
            this.fuG.setText(this.oRA);
            if (this.oRB) {
                this.fuG.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fuG.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oRF != null) {
                ViewCompat.setBackground(this.fuG, this.oRF);
            }
        }
        return this;
    }

    public b Xg(String str) {
        this.oRC = str;
        if (this.oRS != null && this.oRC != null) {
            this.oRS.setText(this.oRC);
        }
        return this;
    }

    public b zr(boolean z) {
        this.oRD = z;
        if (this.oRS != null) {
            if (z) {
                this.oRS.setVisibility(0);
            } else {
                this.oRS.setVisibility(8);
            }
        }
        return this;
    }

    public b Xh(String str) {
        this.gAF = str;
        if (this.cZM != null && this.gAF != null) {
            this.cZM.setText(this.gAF);
            if (this.oRE) {
                this.cZM.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cZM.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oRG != null) {
                ViewCompat.setBackground(this.cZM, this.oRG);
            }
        }
        return this;
    }

    public b Pd(@ColorInt int i) {
        this.oRp = i;
        if (this.cZM != null) {
            if (this.oRp != -1) {
                this.cZM.setTextColor(this.oRp);
            } else if (oRo != -1) {
                this.cZM.setTextColor(oRo);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.oRG = drawable;
        if (this.cZM != null) {
            ViewCompat.setBackground(this.cZM, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.oRU = aVar;
        return this;
    }

    public b b(a aVar) {
        this.oRV = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dzp.startAnimation(this.oRq);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        zs(true);
    }

    public void emV() {
        zs(false);
    }

    private void zs(boolean z) {
        this.oRX = z;
        this.cZM.startAnimation(this.oRs);
        this.dzp.startAnimation(this.oRr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.oRU != null) {
                this.oRU.onClick(this);
            } else {
                emV();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.oRV != null) {
                this.oRV.onClick(this);
            } else {
                emV();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.oRW != null) {
                this.oRW.onClick(this);
            } else {
                emV();
            }
        }
    }

    public b Xi(String str) {
        this.oRH = str;
        if (this.oRx != null && this.oRH != null) {
            this.oRx.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fuG != null && this.cZM != null) {
            if (this.fuG.getVisibility() == 0 && this.cZM.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fuG.getVisibility() == 0) {
                ViewCompat.setBackground(this.fuG, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cZM.getVisibility() == 0) {
                ViewCompat.setBackground(this.cZM, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
