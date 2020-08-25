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
    private static int oQW = -1;
    private TextView aAw;
    private Button cZI;
    private View dzl;
    private Button fuC;
    private String gAB;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int oQX;
    private AnimationSet oQY;
    private AnimationSet oQZ;
    private Button oRA;
    private FrameLayout oRB;
    private a oRC;
    private a oRD;
    private a oRE;
    private boolean oRF;
    private int oRG;
    private Animation oRa;
    private Animation oRb;
    private AnimationSet oRc;
    private AnimationSet oRd;
    private Animation oRe;
    private EditText oRf;
    private boolean oRg;
    private boolean oRh;
    private String oRi;
    private boolean oRj;
    private String oRk;
    private boolean oRl;
    private boolean oRm;
    private Drawable oRn;
    private Drawable oRo;
    private String oRp;
    private int oRq;
    private FrameLayout oRr;
    private FrameLayout oRs;
    private FrameLayout oRt;
    private SuccessTickView oRu;
    private ImageView oRv;
    private View oRw;
    private View oRx;
    private Drawable oRy;
    private ImageView oRz;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.oQX = -1;
        this.oRg = true;
        this.oRj = true;
        this.oRl = true;
        this.oRm = true;
        this.oRG = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oRq = i;
        this.oRb = tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.oRc = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.oRc.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.oRe = tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.oRd = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.oQY = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_modal_in);
        this.oQZ = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.M(getContext(), b.a.zues_sweetalert_modal_out);
        this.oQZ.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dzl.setVisibility(8);
                b.this.dzl.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oRF) {
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
        this.oRa = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.oRa.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oRq == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gX(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oRq == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dzl = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aAw = (TextView) findViewById(b.e.content_text);
        this.oRr = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oRr != null) {
            this.oRv = (ImageView) this.oRr.findViewById(b.e.error_x);
        }
        this.oRs = (FrameLayout) findViewById(b.e.success_frame);
        this.oRt = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.oRs != null) {
            this.oRu = (SuccessTickView) this.oRs.findViewById(b.e.success_tick);
            this.oRw = this.oRs.findViewById(b.e.mask_left);
            this.oRx = this.oRs.findViewById(b.e.mask_right);
        }
        this.oRz = (ImageView) findViewById(b.e.custom_image);
        this.oRB = (FrameLayout) findViewById(b.e.warning_frame);
        this.cZI = (Button) findViewById(b.e.confirm_button);
        this.fuC = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.oRA = (Button) findViewById(b.e.middle_btn);
        this.oRf = (EditText) findViewById(b.e.et_input);
        this.cZI.setOnClickListener(this);
        if (this.fuC != null) {
            this.fuC.setOnClickListener(this);
        }
        if (this.oRA != null) {
            this.oRA.setOnClickListener(this);
        }
        zn(this.oRg);
        zp(this.oRl);
        Xe(this.mTitleText);
        B(this.mContentText);
        Pc(this.oRG);
        Xf(this.oRi);
        Xh(this.gAB);
        Pd(this.oQX);
        w(this.oRo);
        Xi(this.oRp);
        Xg(this.oRk);
        am(this.oRq, true);
        if (this.oRq == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C1008b.zues_text_color));
            }
            if (this.aAw != null) {
                this.aAw.setTextColor(this.mContext.getResources().getColor(b.C1008b.zues_text_color));
            }
        }
    }

    private void acK() {
        if (this.oRz != null) {
            this.oRz.setVisibility(8);
        }
        if (this.oRr != null) {
            this.oRr.setVisibility(8);
        }
        if (this.oRs != null) {
            this.oRs.setVisibility(8);
        }
        if (this.oRB != null) {
            this.oRB.setVisibility(8);
        }
        if (this.oRt != null) {
            this.oRt.setVisibility(8);
        }
        if (this.cZI != null) {
            this.cZI.setVisibility(0);
        }
        this.cZI.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oRr != null) {
            this.oRr.clearAnimation();
        }
        if (this.oRv != null) {
            this.oRv.clearAnimation();
        }
        if (this.oRu != null) {
            this.oRu.clearAnimation();
        }
        if (this.oRw != null) {
            this.oRw.clearAnimation();
        }
        if (this.oRx != null) {
            this.oRx.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oRq == 1) {
            this.oRr.startAnimation(this.oRb);
            this.oRv.startAnimation(this.oRc);
        } else if (this.oRq == 2) {
            this.oRu.emL();
            this.oRx.startAnimation(this.oRe);
        }
    }

    private void am(int i, boolean z) {
        this.oRq = i;
        if (this.dzl != null) {
            if (!z) {
                acK();
            }
            switch (this.oRq) {
                case 1:
                    this.oRr.setVisibility(0);
                    break;
                case 2:
                    this.oRs.setVisibility(0);
                    this.oRw.startAnimation(this.oRd.getAnimations().get(0));
                    this.oRx.startAnimation(this.oRd.getAnimations().get(1));
                    break;
                case 3:
                    this.cZI.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.oRB.setVisibility(0);
                    break;
                case 4:
                    v(this.oRy);
                    break;
                case 5:
                    this.oRt.setVisibility(0);
                    this.cZI.setVisibility(8);
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
        this.oRy = drawable;
        if (this.oRz != null && this.oRy != null) {
            this.oRz.setVisibility(0);
            this.oRz.setImageDrawable(this.oRy);
        }
        return this;
    }

    public b B(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aAw != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                zo(true);
                this.aAw.setText(this.mContentText);
            } else {
                zo(false);
            }
        }
        return this;
    }

    public b Pc(int i) {
        this.oRG = i;
        if (this.aAw != null && this.oRG > 0) {
            this.aAw.setTextSize(2, this.oRG);
        }
        return this;
    }

    public b zn(boolean z) {
        this.oRg = z;
        if (this.fuC != null) {
            this.fuC.setVisibility(this.oRg ? 0 : 8);
        }
        return this;
    }

    public b zo(boolean z) {
        this.oRh = z;
        if (this.aAw != null) {
            this.aAw.setVisibility(this.oRh ? 0 : 8);
        }
        return this;
    }

    public b Xf(String str) {
        this.oRi = str;
        if (this.fuC != null && this.oRi != null) {
            zn(true);
            this.fuC.setText(this.oRi);
            if (this.oRj) {
                this.fuC.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fuC.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oRn != null) {
                ViewCompat.setBackground(this.fuC, this.oRn);
            }
        }
        return this;
    }

    public b Xg(String str) {
        this.oRk = str;
        if (this.oRA != null && this.oRk != null) {
            this.oRA.setText(this.oRk);
        }
        return this;
    }

    public b zp(boolean z) {
        this.oRl = z;
        if (this.oRA != null) {
            if (z) {
                this.oRA.setVisibility(0);
            } else {
                this.oRA.setVisibility(8);
            }
        }
        return this;
    }

    public b Xh(String str) {
        this.gAB = str;
        if (this.cZI != null && this.gAB != null) {
            this.cZI.setText(this.gAB);
            if (this.oRm) {
                this.cZI.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cZI.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oRo != null) {
                ViewCompat.setBackground(this.cZI, this.oRo);
            }
        }
        return this;
    }

    public b Pd(@ColorInt int i) {
        this.oQX = i;
        if (this.cZI != null) {
            if (this.oQX != -1) {
                this.cZI.setTextColor(this.oQX);
            } else if (oQW != -1) {
                this.cZI.setTextColor(oQW);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.oRo = drawable;
        if (this.cZI != null) {
            ViewCompat.setBackground(this.cZI, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.oRC = aVar;
        return this;
    }

    public b b(a aVar) {
        this.oRD = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dzl.startAnimation(this.oQY);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        zq(true);
    }

    public void emM() {
        zq(false);
    }

    private void zq(boolean z) {
        this.oRF = z;
        this.cZI.startAnimation(this.oRa);
        this.dzl.startAnimation(this.oQZ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.oRC != null) {
                this.oRC.onClick(this);
            } else {
                emM();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.oRD != null) {
                this.oRD.onClick(this);
            } else {
                emM();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.oRE != null) {
                this.oRE.onClick(this);
            } else {
                emM();
            }
        }
    }

    public b Xi(String str) {
        this.oRp = str;
        if (this.oRf != null && this.oRp != null) {
            this.oRf.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fuC != null && this.cZI != null) {
            if (this.fuC.getVisibility() == 0 && this.cZI.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fuC.getVisibility() == 0) {
                ViewCompat.setBackground(this.fuC, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cZI.getVisibility() == 0) {
                ViewCompat.setBackground(this.cZI, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
