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
    private static int oxd = -1;
    private TextView avu;
    private Button cQI;
    private View dpj;
    private Button fjg;
    private String gnL;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    private FrameLayout oxA;
    private SuccessTickView oxB;
    private ImageView oxC;
    private View oxD;
    private View oxE;
    private Drawable oxF;
    private ImageView oxG;
    private Button oxH;
    private FrameLayout oxI;
    private a oxJ;
    private a oxK;
    private a oxL;
    private boolean oxM;
    private int oxN;
    @ColorInt
    private int oxe;
    private AnimationSet oxf;
    private AnimationSet oxg;
    private Animation oxh;
    private Animation oxi;
    private AnimationSet oxj;
    private AnimationSet oxk;
    private Animation oxl;
    private EditText oxm;
    private boolean oxn;
    private boolean oxo;
    private String oxp;
    private boolean oxq;
    private String oxr;
    private boolean oxs;
    private boolean oxt;
    private Drawable oxu;
    private Drawable oxv;
    private String oxw;
    private int oxx;
    private FrameLayout oxy;
    private FrameLayout oxz;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.oxe = -1;
        this.oxn = true;
        this.oxq = true;
        this.oxs = true;
        this.oxt = true;
        this.oxN = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oxx = i;
        this.oxi = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.oxj = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.oxj.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.oxl = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.oxk = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.oxf = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.oxg = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.oxg.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dpj.setVisibility(8);
                b.this.dpj.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oxM) {
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
        this.oxh = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.oxh.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oxx == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gF(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oxx == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dpj = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.avu = (TextView) findViewById(b.e.content_text);
        this.oxy = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oxy != null) {
            this.oxC = (ImageView) this.oxy.findViewById(b.e.error_x);
        }
        this.oxz = (FrameLayout) findViewById(b.e.success_frame);
        this.oxA = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.oxz != null) {
            this.oxB = (SuccessTickView) this.oxz.findViewById(b.e.success_tick);
            this.oxD = this.oxz.findViewById(b.e.mask_left);
            this.oxE = this.oxz.findViewById(b.e.mask_right);
        }
        this.oxG = (ImageView) findViewById(b.e.custom_image);
        this.oxI = (FrameLayout) findViewById(b.e.warning_frame);
        this.cQI = (Button) findViewById(b.e.confirm_button);
        this.fjg = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.oxH = (Button) findViewById(b.e.middle_btn);
        this.oxm = (EditText) findViewById(b.e.et_input);
        this.cQI.setOnClickListener(this);
        if (this.fjg != null) {
            this.fjg.setOnClickListener(this);
        }
        if (this.oxH != null) {
            this.oxH.setOnClickListener(this);
        }
        yv(this.oxn);
        yx(this.oxs);
        Ua(this.mTitleText);
        B(this.mContentText);
        Mz(this.oxN);
        Ub(this.oxp);
        Ud(this.gnL);
        MA(this.oxe);
        w(this.oxv);
        Ue(this.oxw);
        Uc(this.oxr);
        ak(this.oxx, true);
        if (this.oxx == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0950b.zues_text_color));
            }
            if (this.avu != null) {
                this.avu.setTextColor(this.mContext.getResources().getColor(b.C0950b.zues_text_color));
            }
        }
    }

    private void WE() {
        if (this.oxG != null) {
            this.oxG.setVisibility(8);
        }
        if (this.oxy != null) {
            this.oxy.setVisibility(8);
        }
        if (this.oxz != null) {
            this.oxz.setVisibility(8);
        }
        if (this.oxI != null) {
            this.oxI.setVisibility(8);
        }
        if (this.oxA != null) {
            this.oxA.setVisibility(8);
        }
        if (this.cQI != null) {
            this.cQI.setVisibility(0);
        }
        this.cQI.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oxy != null) {
            this.oxy.clearAnimation();
        }
        if (this.oxC != null) {
            this.oxC.clearAnimation();
        }
        if (this.oxB != null) {
            this.oxB.clearAnimation();
        }
        if (this.oxD != null) {
            this.oxD.clearAnimation();
        }
        if (this.oxE != null) {
            this.oxE.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oxx == 1) {
            this.oxy.startAnimation(this.oxi);
            this.oxC.startAnimation(this.oxj);
        } else if (this.oxx == 2) {
            this.oxB.eaH();
            this.oxE.startAnimation(this.oxl);
        }
    }

    private void ak(int i, boolean z) {
        this.oxx = i;
        if (this.dpj != null) {
            if (!z) {
                WE();
            }
            switch (this.oxx) {
                case 1:
                    this.oxy.setVisibility(0);
                    break;
                case 2:
                    this.oxz.setVisibility(0);
                    this.oxD.startAnimation(this.oxk.getAnimations().get(0));
                    this.oxE.startAnimation(this.oxk.getAnimations().get(1));
                    break;
                case 3:
                    this.cQI.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.oxI.setVisibility(0);
                    break;
                case 4:
                    v(this.oxF);
                    break;
                case 5:
                    this.oxA.setVisibility(0);
                    this.cQI.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Ua(String str) {
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

    public b be(String str, boolean z) {
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
        this.oxF = drawable;
        if (this.oxG != null && this.oxF != null) {
            this.oxG.setVisibility(0);
            this.oxG.setImageDrawable(this.oxF);
        }
        return this;
    }

    public b B(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.avu != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                yw(true);
                this.avu.setText(this.mContentText);
            } else {
                yw(false);
            }
        }
        return this;
    }

    public b Mz(int i) {
        this.oxN = i;
        if (this.avu != null && this.oxN > 0) {
            this.avu.setTextSize(2, this.oxN);
        }
        return this;
    }

    public b yv(boolean z) {
        this.oxn = z;
        if (this.fjg != null) {
            this.fjg.setVisibility(this.oxn ? 0 : 8);
        }
        return this;
    }

    public b yw(boolean z) {
        this.oxo = z;
        if (this.avu != null) {
            this.avu.setVisibility(this.oxo ? 0 : 8);
        }
        return this;
    }

    public b Ub(String str) {
        this.oxp = str;
        if (this.fjg != null && this.oxp != null) {
            yv(true);
            this.fjg.setText(this.oxp);
            if (this.oxq) {
                this.fjg.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fjg.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oxu != null) {
                ViewCompat.setBackground(this.fjg, this.oxu);
            }
        }
        return this;
    }

    public b Uc(String str) {
        this.oxr = str;
        if (this.oxH != null && this.oxr != null) {
            this.oxH.setText(this.oxr);
        }
        return this;
    }

    public b yx(boolean z) {
        this.oxs = z;
        if (this.oxH != null) {
            if (z) {
                this.oxH.setVisibility(0);
            } else {
                this.oxH.setVisibility(8);
            }
        }
        return this;
    }

    public b Ud(String str) {
        this.gnL = str;
        if (this.cQI != null && this.gnL != null) {
            this.cQI.setText(this.gnL);
            if (this.oxt) {
                this.cQI.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cQI.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oxv != null) {
                ViewCompat.setBackground(this.cQI, this.oxv);
            }
        }
        return this;
    }

    public b MA(@ColorInt int i) {
        this.oxe = i;
        if (this.cQI != null) {
            if (this.oxe != -1) {
                this.cQI.setTextColor(this.oxe);
            } else if (oxd != -1) {
                this.cQI.setTextColor(oxd);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.oxv = drawable;
        if (this.cQI != null) {
            ViewCompat.setBackground(this.cQI, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.oxJ = aVar;
        return this;
    }

    public b b(a aVar) {
        this.oxK = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dpj.startAnimation(this.oxf);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        yy(true);
    }

    public void eaI() {
        yy(false);
    }

    private void yy(boolean z) {
        this.oxM = z;
        this.cQI.startAnimation(this.oxh);
        this.dpj.startAnimation(this.oxg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.oxJ != null) {
                this.oxJ.onClick(this);
            } else {
                eaI();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.oxK != null) {
                this.oxK.onClick(this);
            } else {
                eaI();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.oxL != null) {
                this.oxL.onClick(this);
            } else {
                eaI();
            }
        }
    }

    public b Ue(String str) {
        this.oxw = str;
        if (this.oxm != null && this.oxw != null) {
            this.oxm.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fjg != null && this.cQI != null) {
            if (this.fjg.getVisibility() == 0 && this.cQI.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fjg.getVisibility() == 0) {
                ViewCompat.setBackground(this.fjg, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cQI.getVisibility() == 0) {
                ViewCompat.setBackground(this.cQI, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
