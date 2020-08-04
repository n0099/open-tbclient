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
    private static int oxf = -1;
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
    private FrameLayout oxB;
    private FrameLayout oxC;
    private SuccessTickView oxD;
    private ImageView oxE;
    private View oxF;
    private View oxG;
    private Drawable oxH;
    private ImageView oxI;
    private Button oxJ;
    private FrameLayout oxK;
    private a oxL;
    private a oxM;
    private a oxN;
    private boolean oxO;
    private int oxP;
    @ColorInt
    private int oxg;
    private AnimationSet oxh;
    private AnimationSet oxi;
    private Animation oxj;
    private Animation oxk;
    private AnimationSet oxl;
    private AnimationSet oxm;
    private Animation oxn;
    private EditText oxo;
    private boolean oxp;
    private boolean oxq;
    private String oxr;
    private boolean oxs;
    private String oxt;
    private boolean oxu;
    private boolean oxv;
    private Drawable oxw;
    private Drawable oxx;
    private String oxy;
    private int oxz;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.oxg = -1;
        this.oxp = true;
        this.oxs = true;
        this.oxu = true;
        this.oxv = true;
        this.oxP = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oxz = i;
        this.oxk = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.oxl = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.oxl.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.oxn = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.oxm = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.oxh = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.oxi = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.oxi.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dpj.setVisibility(8);
                b.this.dpj.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oxO) {
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
        this.oxj = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.oxj.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oxz == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gF(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oxz == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dpj = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.avu = (TextView) findViewById(b.e.content_text);
        this.oxA = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oxA != null) {
            this.oxE = (ImageView) this.oxA.findViewById(b.e.error_x);
        }
        this.oxB = (FrameLayout) findViewById(b.e.success_frame);
        this.oxC = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.oxB != null) {
            this.oxD = (SuccessTickView) this.oxB.findViewById(b.e.success_tick);
            this.oxF = this.oxB.findViewById(b.e.mask_left);
            this.oxG = this.oxB.findViewById(b.e.mask_right);
        }
        this.oxI = (ImageView) findViewById(b.e.custom_image);
        this.oxK = (FrameLayout) findViewById(b.e.warning_frame);
        this.cQI = (Button) findViewById(b.e.confirm_button);
        this.fjg = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.oxJ = (Button) findViewById(b.e.middle_btn);
        this.oxo = (EditText) findViewById(b.e.et_input);
        this.cQI.setOnClickListener(this);
        if (this.fjg != null) {
            this.fjg.setOnClickListener(this);
        }
        if (this.oxJ != null) {
            this.oxJ.setOnClickListener(this);
        }
        yv(this.oxp);
        yx(this.oxu);
        Ua(this.mTitleText);
        B(this.mContentText);
        Mz(this.oxP);
        Ub(this.oxr);
        Ud(this.gnL);
        MA(this.oxg);
        w(this.oxx);
        Ue(this.oxy);
        Uc(this.oxt);
        ak(this.oxz, true);
        if (this.oxz == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0950b.zues_text_color));
            }
            if (this.avu != null) {
                this.avu.setTextColor(this.mContext.getResources().getColor(b.C0950b.zues_text_color));
            }
        }
    }

    private void WE() {
        if (this.oxI != null) {
            this.oxI.setVisibility(8);
        }
        if (this.oxA != null) {
            this.oxA.setVisibility(8);
        }
        if (this.oxB != null) {
            this.oxB.setVisibility(8);
        }
        if (this.oxK != null) {
            this.oxK.setVisibility(8);
        }
        if (this.oxC != null) {
            this.oxC.setVisibility(8);
        }
        if (this.cQI != null) {
            this.cQI.setVisibility(0);
        }
        this.cQI.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oxA != null) {
            this.oxA.clearAnimation();
        }
        if (this.oxE != null) {
            this.oxE.clearAnimation();
        }
        if (this.oxD != null) {
            this.oxD.clearAnimation();
        }
        if (this.oxF != null) {
            this.oxF.clearAnimation();
        }
        if (this.oxG != null) {
            this.oxG.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oxz == 1) {
            this.oxA.startAnimation(this.oxk);
            this.oxE.startAnimation(this.oxl);
        } else if (this.oxz == 2) {
            this.oxD.eaI();
            this.oxG.startAnimation(this.oxn);
        }
    }

    private void ak(int i, boolean z) {
        this.oxz = i;
        if (this.dpj != null) {
            if (!z) {
                WE();
            }
            switch (this.oxz) {
                case 1:
                    this.oxA.setVisibility(0);
                    break;
                case 2:
                    this.oxB.setVisibility(0);
                    this.oxF.startAnimation(this.oxm.getAnimations().get(0));
                    this.oxG.startAnimation(this.oxm.getAnimations().get(1));
                    break;
                case 3:
                    this.cQI.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.oxK.setVisibility(0);
                    break;
                case 4:
                    v(this.oxH);
                    break;
                case 5:
                    this.oxC.setVisibility(0);
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
        this.oxH = drawable;
        if (this.oxI != null && this.oxH != null) {
            this.oxI.setVisibility(0);
            this.oxI.setImageDrawable(this.oxH);
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
        this.oxP = i;
        if (this.avu != null && this.oxP > 0) {
            this.avu.setTextSize(2, this.oxP);
        }
        return this;
    }

    public b yv(boolean z) {
        this.oxp = z;
        if (this.fjg != null) {
            this.fjg.setVisibility(this.oxp ? 0 : 8);
        }
        return this;
    }

    public b yw(boolean z) {
        this.oxq = z;
        if (this.avu != null) {
            this.avu.setVisibility(this.oxq ? 0 : 8);
        }
        return this;
    }

    public b Ub(String str) {
        this.oxr = str;
        if (this.fjg != null && this.oxr != null) {
            yv(true);
            this.fjg.setText(this.oxr);
            if (this.oxs) {
                this.fjg.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fjg.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oxw != null) {
                ViewCompat.setBackground(this.fjg, this.oxw);
            }
        }
        return this;
    }

    public b Uc(String str) {
        this.oxt = str;
        if (this.oxJ != null && this.oxt != null) {
            this.oxJ.setText(this.oxt);
        }
        return this;
    }

    public b yx(boolean z) {
        this.oxu = z;
        if (this.oxJ != null) {
            if (z) {
                this.oxJ.setVisibility(0);
            } else {
                this.oxJ.setVisibility(8);
            }
        }
        return this;
    }

    public b Ud(String str) {
        this.gnL = str;
        if (this.cQI != null && this.gnL != null) {
            this.cQI.setText(this.gnL);
            if (this.oxv) {
                this.cQI.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cQI.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oxx != null) {
                ViewCompat.setBackground(this.cQI, this.oxx);
            }
        }
        return this;
    }

    public b MA(@ColorInt int i) {
        this.oxg = i;
        if (this.cQI != null) {
            if (this.oxg != -1) {
                this.cQI.setTextColor(this.oxg);
            } else if (oxf != -1) {
                this.cQI.setTextColor(oxf);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.oxx = drawable;
        if (this.cQI != null) {
            ViewCompat.setBackground(this.cQI, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.oxL = aVar;
        return this;
    }

    public b b(a aVar) {
        this.oxM = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dpj.startAnimation(this.oxh);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        yy(true);
    }

    public void eaJ() {
        yy(false);
    }

    private void yy(boolean z) {
        this.oxO = z;
        this.cQI.startAnimation(this.oxj);
        this.dpj.startAnimation(this.oxi);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.oxL != null) {
                this.oxL.onClick(this);
            } else {
                eaJ();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.oxM != null) {
                this.oxM.onClick(this);
            } else {
                eaJ();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.oxN != null) {
                this.oxN.onClick(this);
            } else {
                eaJ();
            }
        }
    }

    public b Ue(String str) {
        this.oxy = str;
        if (this.oxo != null && this.oxy != null) {
            this.oxo.setHint(str);
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
