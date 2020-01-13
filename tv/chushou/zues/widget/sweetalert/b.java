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
    private static int nZL = -1;
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
    private int nZM;
    private AnimationSet nZN;
    private AnimationSet nZO;
    private Animation nZP;
    private Animation nZQ;
    private AnimationSet nZR;
    private AnimationSet nZS;
    private Animation nZT;
    private EditText nZU;
    private boolean nZV;
    private boolean nZW;
    private boolean nZX;
    private String nZY;
    private boolean nZZ;
    private boolean oaa;
    private Drawable oab;
    private Drawable oac;
    private String oad;
    private int oae;
    private FrameLayout oaf;
    private FrameLayout oag;
    private FrameLayout oah;
    private SuccessTickView oai;
    private ImageView oaj;
    private View oak;
    private View oal;
    private Drawable oam;
    private ImageView oan;
    private Button oao;
    private FrameLayout oap;
    private a oaq;
    private a oar;
    private a oas;
    private boolean oat;
    private int oau;

    /* loaded from: classes4.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.nZM = -1;
        this.nZV = true;
        this.nZX = true;
        this.nZZ = true;
        this.oaa = true;
        this.oau = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.oae = i;
        this.nZQ = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.nZR = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.nZR.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.nZT = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.nZS = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.nZN = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_in);
        this.nZO = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_out);
        this.nZO.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cqi.setVisibility(8);
                b.this.cqi.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.oat) {
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
        this.nZP = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.nZP.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.oae == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hf(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.oae == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cqi = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aqn = (TextView) findViewById(b.e.content_text);
        this.oaf = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oaf != null) {
            this.oaj = (ImageView) this.oaf.findViewById(b.e.error_x);
        }
        this.oag = (FrameLayout) findViewById(b.e.success_frame);
        this.oah = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.oag != null) {
            this.oai = (SuccessTickView) this.oag.findViewById(b.e.success_tick);
            this.oak = this.oag.findViewById(b.e.mask_left);
            this.oal = this.oag.findViewById(b.e.mask_right);
        }
        this.oan = (ImageView) findViewById(b.e.custom_image);
        this.oap = (FrameLayout) findViewById(b.e.warning_frame);
        this.bTn = (Button) findViewById(b.e.confirm_button);
        this.ecR = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.oao = (Button) findViewById(b.e.middle_btn);
        this.nZU = (EditText) findViewById(b.e.et_input);
        this.bTn.setOnClickListener(this);
        if (this.ecR != null) {
            this.ecR.setOnClickListener(this);
        }
        if (this.oao != null) {
            this.oao.setOnClickListener(this);
        }
        xg(this.nZV);
        xi(this.nZZ);
        SR(this.mTitleText);
        x(this.mContentText);
        OG(this.oau);
        SS(this.mCancelText);
        SU(this.mConfirmText);
        OH(this.nZM);
        A(this.oac);
        SV(this.oad);
        ST(this.nZY);
        ai(this.oae, true);
        if (this.oae == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0799b.zues_text_color));
            }
            if (this.aqn != null) {
                this.aqn.setTextColor(this.mContext.getResources().getColor(b.C0799b.zues_text_color));
            }
        }
    }

    private void HY() {
        if (this.oan != null) {
            this.oan.setVisibility(8);
        }
        if (this.oaf != null) {
            this.oaf.setVisibility(8);
        }
        if (this.oag != null) {
            this.oag.setVisibility(8);
        }
        if (this.oap != null) {
            this.oap.setVisibility(8);
        }
        if (this.oah != null) {
            this.oah.setVisibility(8);
        }
        if (this.bTn != null) {
            this.bTn.setVisibility(0);
        }
        this.bTn.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oaf != null) {
            this.oaf.clearAnimation();
        }
        if (this.oaj != null) {
            this.oaj.clearAnimation();
        }
        if (this.oai != null) {
            this.oai.clearAnimation();
        }
        if (this.oak != null) {
            this.oak.clearAnimation();
        }
        if (this.oal != null) {
            this.oal.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.oae == 1) {
            this.oaf.startAnimation(this.nZQ);
            this.oaj.startAnimation(this.nZR);
        } else if (this.oae == 2) {
            this.oai.dPC();
            this.oal.startAnimation(this.nZT);
        }
    }

    private void ai(int i, boolean z) {
        this.oae = i;
        if (this.cqi != null) {
            if (!z) {
                HY();
            }
            switch (this.oae) {
                case 1:
                    this.oaf.setVisibility(0);
                    break;
                case 2:
                    this.oag.setVisibility(0);
                    this.oak.startAnimation(this.nZS.getAnimations().get(0));
                    this.oal.startAnimation(this.nZS.getAnimations().get(1));
                    break;
                case 3:
                    this.bTn.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.oap.setVisibility(0);
                    break;
                case 4:
                    z(this.oam);
                    break;
                case 5:
                    this.oah.setVisibility(0);
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
        this.oam = drawable;
        if (this.oan != null && this.oam != null) {
            this.oan.setVisibility(0);
            this.oan.setImageDrawable(this.oam);
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
        this.oau = i;
        if (this.aqn != null && this.oau > 0) {
            this.aqn.setTextSize(2, this.oau);
        }
        return this;
    }

    public b xg(boolean z) {
        this.nZV = z;
        if (this.ecR != null) {
            this.ecR.setVisibility(this.nZV ? 0 : 8);
        }
        return this;
    }

    public b xh(boolean z) {
        this.nZW = z;
        if (this.aqn != null) {
            this.aqn.setVisibility(this.nZW ? 0 : 8);
        }
        return this;
    }

    public b SS(String str) {
        this.mCancelText = str;
        if (this.ecR != null && this.mCancelText != null) {
            xg(true);
            this.ecR.setText(this.mCancelText);
            if (this.nZX) {
                this.ecR.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.ecR.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oab != null) {
                ViewCompat.setBackground(this.ecR, this.oab);
            }
        }
        return this;
    }

    public b ST(String str) {
        this.nZY = str;
        if (this.oao != null && this.nZY != null) {
            this.oao.setText(this.nZY);
        }
        return this;
    }

    public b xi(boolean z) {
        this.nZZ = z;
        if (this.oao != null) {
            if (z) {
                this.oao.setVisibility(0);
            } else {
                this.oao.setVisibility(8);
            }
        }
        return this;
    }

    public b SU(String str) {
        this.mConfirmText = str;
        if (this.bTn != null && this.mConfirmText != null) {
            this.bTn.setText(this.mConfirmText);
            if (this.oaa) {
                this.bTn.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.bTn.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.oac != null) {
                ViewCompat.setBackground(this.bTn, this.oac);
            }
        }
        return this;
    }

    public b OH(@ColorInt int i) {
        this.nZM = i;
        if (this.bTn != null) {
            if (this.nZM != -1) {
                this.bTn.setTextColor(this.nZM);
            } else if (nZL != -1) {
                this.bTn.setTextColor(nZL);
            }
        }
        return this;
    }

    public b A(Drawable drawable) {
        this.oac = drawable;
        if (this.bTn != null) {
            ViewCompat.setBackground(this.bTn, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.oaq = aVar;
        return this;
    }

    public b b(a aVar) {
        this.oar = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cqi.startAnimation(this.nZN);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xj(true);
    }

    public void dPD() {
        xj(false);
    }

    private void xj(boolean z) {
        this.oat = z;
        this.bTn.startAnimation(this.nZP);
        this.cqi.startAnimation(this.nZO);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.oaq != null) {
                this.oaq.onClick(this);
            } else {
                dPD();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.oar != null) {
                this.oar.onClick(this);
            } else {
                dPD();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.oas != null) {
                this.oas.onClick(this);
            } else {
                dPD();
            }
        }
    }

    public b SV(String str) {
        this.oad = str;
        if (this.nZU != null && this.oad != null) {
            this.nZU.setHint(str);
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
