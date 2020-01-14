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
/* loaded from: classes4.dex */
public class b extends Dialog implements View.OnClickListener {
    @ColorInt
    private static int nZQ = -1;
    private TextView aqn;
    private Button bTn;
    private View cqi;
    private Button ecR;
    private String mCancelText;
    private String mConfirmText;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int nZR;
    private AnimationSet nZS;
    private AnimationSet nZT;
    private Animation nZU;
    private Animation nZV;
    private AnimationSet nZW;
    private AnimationSet nZX;
    private Animation nZY;
    private EditText nZZ;
    private boolean oaa;
    private boolean oab;
    private boolean oac;
    private String oad;
    private boolean oae;
    private boolean oaf;
    private Drawable oag;
    private Drawable oah;
    private String oai;
    private int oaj;
    private FrameLayout oak;
    private FrameLayout oal;
    private FrameLayout oam;
    private SuccessTickView oan;
    private ImageView oao;
    private View oap;
    private View oaq;
    private Drawable oar;
    private ImageView oas;
    private Button oat;
    private FrameLayout oau;
    private a oav;
    private a oaw;
    private a oax;
    private boolean oay;
    private int oaz;

    /* loaded from: classes4.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.nZR = -1;
        this.oaa = true;
        this.oac = true;
        this.oae = true;
        this.oaf = true;
        this.oaz = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oaj = i;
        this.nZV = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.nZW = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.nZW.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.nZY = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.nZX = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.nZS = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_in);
        this.nZT = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_out);
        this.nZT.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cqi.setVisibility(8);
                b.this.cqi.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oay) {
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
        this.nZU = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.nZU.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oaj == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hf(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oaj == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cqi = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aqn = (TextView) findViewById(b.e.content_text);
        this.oak = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oak != null) {
            this.oao = (ImageView) this.oak.findViewById(b.e.error_x);
        }
        this.oal = (FrameLayout) findViewById(b.e.success_frame);
        this.oam = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.oal != null) {
            this.oan = (SuccessTickView) this.oal.findViewById(b.e.success_tick);
            this.oap = this.oal.findViewById(b.e.mask_left);
            this.oaq = this.oal.findViewById(b.e.mask_right);
        }
        this.oas = (ImageView) findViewById(b.e.custom_image);
        this.oau = (FrameLayout) findViewById(b.e.warning_frame);
        this.bTn = (Button) findViewById(b.e.confirm_button);
        this.ecR = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.oat = (Button) findViewById(b.e.middle_btn);
        this.nZZ = (EditText) findViewById(b.e.et_input);
        this.bTn.setOnClickListener(this);
        if (this.ecR != null) {
            this.ecR.setOnClickListener(this);
        }
        if (this.oat != null) {
            this.oat.setOnClickListener(this);
        }
        xg(this.oaa);
        xi(this.oae);
        SR(this.mTitleText);
        x(this.mContentText);
        OG(this.oaz);
        SS(this.mCancelText);
        SU(this.mConfirmText);
        OH(this.nZR);
        A(this.oah);
        SV(this.oai);
        ST(this.oad);
        ai(this.oaj, true);
        if (this.oaj == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0799b.zues_text_color));
            }
            if (this.aqn != null) {
                this.aqn.setTextColor(this.mContext.getResources().getColor(b.C0799b.zues_text_color));
            }
        }
    }

    private void HY() {
        if (this.oas != null) {
            this.oas.setVisibility(8);
        }
        if (this.oak != null) {
            this.oak.setVisibility(8);
        }
        if (this.oal != null) {
            this.oal.setVisibility(8);
        }
        if (this.oau != null) {
            this.oau.setVisibility(8);
        }
        if (this.oam != null) {
            this.oam.setVisibility(8);
        }
        if (this.bTn != null) {
            this.bTn.setVisibility(0);
        }
        this.bTn.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oak != null) {
            this.oak.clearAnimation();
        }
        if (this.oao != null) {
            this.oao.clearAnimation();
        }
        if (this.oan != null) {
            this.oan.clearAnimation();
        }
        if (this.oap != null) {
            this.oap.clearAnimation();
        }
        if (this.oaq != null) {
            this.oaq.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oaj == 1) {
            this.oak.startAnimation(this.nZV);
            this.oao.startAnimation(this.nZW);
        } else if (this.oaj == 2) {
            this.oan.dPE();
            this.oaq.startAnimation(this.nZY);
        }
    }

    private void ai(int i, boolean z) {
        this.oaj = i;
        if (this.cqi != null) {
            if (!z) {
                HY();
            }
            switch (this.oaj) {
                case 1:
                    this.oak.setVisibility(0);
                    break;
                case 2:
                    this.oal.setVisibility(0);
                    this.oap.startAnimation(this.nZX.getAnimations().get(0));
                    this.oaq.startAnimation(this.nZX.getAnimations().get(1));
                    break;
                case 3:
                    this.bTn.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.oau.setVisibility(0);
                    break;
                case 4:
                    z(this.oar);
                    break;
                case 5:
                    this.oam.setVisibility(0);
                    this.bTn.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b SR(String str) {
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
        this.oar = drawable;
        if (this.oas != null && this.oar != null) {
            this.oas.setVisibility(0);
            this.oas.setImageDrawable(this.oar);
        }
        return this;
    }

    public b x(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aqn != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                xh(true);
                this.aqn.setText(this.mContentText);
            } else {
                xh(false);
            }
        }
        return this;
    }

    public b OG(int i) {
        this.oaz = i;
        if (this.aqn != null && this.oaz > 0) {
            this.aqn.setTextSize(2, this.oaz);
        }
        return this;
    }

    public b xg(boolean z) {
        this.oaa = z;
        if (this.ecR != null) {
            this.ecR.setVisibility(this.oaa ? 0 : 8);
        }
        return this;
    }

    public b xh(boolean z) {
        this.oab = z;
        if (this.aqn != null) {
            this.aqn.setVisibility(this.oab ? 0 : 8);
        }
        return this;
    }

    public b SS(String str) {
        this.mCancelText = str;
        if (this.ecR != null && this.mCancelText != null) {
            xg(true);
            this.ecR.setText(this.mCancelText);
            if (this.oac) {
                this.ecR.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.ecR.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oag != null) {
                ViewCompat.setBackground(this.ecR, this.oag);
            }
        }
        return this;
    }

    public b ST(String str) {
        this.oad = str;
        if (this.oat != null && this.oad != null) {
            this.oat.setText(this.oad);
        }
        return this;
    }

    public b xi(boolean z) {
        this.oae = z;
        if (this.oat != null) {
            if (z) {
                this.oat.setVisibility(0);
            } else {
                this.oat.setVisibility(8);
            }
        }
        return this;
    }

    public b SU(String str) {
        this.mConfirmText = str;
        if (this.bTn != null && this.mConfirmText != null) {
            this.bTn.setText(this.mConfirmText);
            if (this.oaf) {
                this.bTn.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.bTn.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oah != null) {
                ViewCompat.setBackground(this.bTn, this.oah);
            }
        }
        return this;
    }

    public b OH(@ColorInt int i) {
        this.nZR = i;
        if (this.bTn != null) {
            if (this.nZR != -1) {
                this.bTn.setTextColor(this.nZR);
            } else if (nZQ != -1) {
                this.bTn.setTextColor(nZQ);
            }
        }
        return this;
    }

    public b A(Drawable drawable) {
        this.oah = drawable;
        if (this.bTn != null) {
            ViewCompat.setBackground(this.bTn, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.oav = aVar;
        return this;
    }

    public b b(a aVar) {
        this.oaw = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cqi.startAnimation(this.nZS);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xj(true);
    }

    public void dPF() {
        xj(false);
    }

    private void xj(boolean z) {
        this.oay = z;
        this.bTn.startAnimation(this.nZU);
        this.cqi.startAnimation(this.nZT);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.oav != null) {
                this.oav.onClick(this);
            } else {
                dPF();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.oaw != null) {
                this.oaw.onClick(this);
            } else {
                dPF();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.oax != null) {
                this.oax.onClick(this);
            } else {
                dPF();
            }
        }
    }

    public b SV(String str) {
        this.oai = str;
        if (this.nZZ != null && this.oai != null) {
            this.nZZ.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.ecR != null && this.bTn != null) {
            if (this.ecR.getVisibility() == 0 && this.bTn.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.ecR.getVisibility() == 0) {
                ViewCompat.setBackground(this.ecR, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.bTn.getVisibility() == 0) {
                ViewCompat.setBackground(this.bTn, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
