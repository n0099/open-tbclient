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
    private static int ocG = -1;
    private TextView aui;
    private Button bXE;
    private View cuy;
    private Button ehy;
    private String mCancelText;
    private String mConfirmText;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int ocH;
    private AnimationSet ocI;
    private AnimationSet ocJ;
    private Animation ocK;
    private Animation ocL;
    private AnimationSet ocM;
    private AnimationSet ocN;
    private Animation ocO;
    private EditText ocP;
    private boolean ocQ;
    private boolean ocR;
    private boolean ocS;
    private String ocT;
    private boolean ocU;
    private boolean ocV;
    private Drawable ocW;
    private Drawable ocX;
    private String ocY;
    private int ocZ;
    private FrameLayout oda;
    private FrameLayout odb;
    private FrameLayout odc;
    private SuccessTickView odd;
    private ImageView ode;
    private View odf;
    private View odg;
    private Drawable odh;
    private ImageView odi;
    private Button odj;
    private FrameLayout odk;
    private a odl;
    private a odm;
    private a odn;
    private boolean odo;
    private int odp;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.ocH = -1;
        this.ocQ = true;
        this.ocS = true;
        this.ocU = true;
        this.ocV = true;
        this.odp = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.ocZ = i;
        this.ocL = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.ocM = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.ocM.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.ocO = tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.ocN = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.ocI = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_in);
        this.ocJ = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.P(getContext(), b.a.zues_sweetalert_modal_out);
        this.ocJ.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cuy.setVisibility(8);
                b.this.cuy.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.odo) {
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
        this.ocK = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.ocK.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ocZ == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hd(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.ocZ == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cuy = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aui = (TextView) findViewById(b.e.content_text);
        this.oda = (FrameLayout) findViewById(b.e.error_frame);
        if (this.oda != null) {
            this.ode = (ImageView) this.oda.findViewById(b.e.error_x);
        }
        this.odb = (FrameLayout) findViewById(b.e.success_frame);
        this.odc = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.odb != null) {
            this.odd = (SuccessTickView) this.odb.findViewById(b.e.success_tick);
            this.odf = this.odb.findViewById(b.e.mask_left);
            this.odg = this.odb.findViewById(b.e.mask_right);
        }
        this.odi = (ImageView) findViewById(b.e.custom_image);
        this.odk = (FrameLayout) findViewById(b.e.warning_frame);
        this.bXE = (Button) findViewById(b.e.confirm_button);
        this.ehy = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.odj = (Button) findViewById(b.e.middle_btn);
        this.ocP = (EditText) findViewById(b.e.et_input);
        this.bXE.setOnClickListener(this);
        if (this.ehy != null) {
            this.ehy.setOnClickListener(this);
        }
        if (this.odj != null) {
            this.odj.setOnClickListener(this);
        }
        xr(this.ocQ);
        xt(this.ocU);
        Tc(this.mTitleText);
        x(this.mContentText);
        OP(this.odp);
        Td(this.mCancelText);
        Tf(this.mConfirmText);
        OQ(this.ocH);
        A(this.ocX);
        Tg(this.ocY);
        Te(this.ocT);
        ah(this.ocZ, true);
        if (this.ocZ == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0808b.zues_text_color));
            }
            if (this.aui != null) {
                this.aui.setTextColor(this.mContext.getResources().getColor(b.C0808b.zues_text_color));
            }
        }
    }

    private void Ks() {
        if (this.odi != null) {
            this.odi.setVisibility(8);
        }
        if (this.oda != null) {
            this.oda.setVisibility(8);
        }
        if (this.odb != null) {
            this.odb.setVisibility(8);
        }
        if (this.odk != null) {
            this.odk.setVisibility(8);
        }
        if (this.odc != null) {
            this.odc.setVisibility(8);
        }
        if (this.bXE != null) {
            this.bXE.setVisibility(0);
        }
        this.bXE.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.oda != null) {
            this.oda.clearAnimation();
        }
        if (this.ode != null) {
            this.ode.clearAnimation();
        }
        if (this.odd != null) {
            this.odd.clearAnimation();
        }
        if (this.odf != null) {
            this.odf.clearAnimation();
        }
        if (this.odg != null) {
            this.odg.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.ocZ == 1) {
            this.oda.startAnimation(this.ocL);
            this.ode.startAnimation(this.ocM);
        } else if (this.ocZ == 2) {
            this.odd.dRu();
            this.odg.startAnimation(this.ocO);
        }
    }

    private void ah(int i, boolean z) {
        this.ocZ = i;
        if (this.cuy != null) {
            if (!z) {
                Ks();
            }
            switch (this.ocZ) {
                case 1:
                    this.oda.setVisibility(0);
                    break;
                case 2:
                    this.odb.setVisibility(0);
                    this.odf.startAnimation(this.ocN.getAnimations().get(0));
                    this.odg.startAnimation(this.ocN.getAnimations().get(1));
                    break;
                case 3:
                    this.bXE.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.odk.setVisibility(0);
                    break;
                case 4:
                    z(this.odh);
                    break;
                case 5:
                    this.odc.setVisibility(0);
                    this.bXE.setVisibility(8);
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
        this.odh = drawable;
        if (this.odi != null && this.odh != null) {
            this.odi.setVisibility(0);
            this.odi.setImageDrawable(this.odh);
        }
        return this;
    }

    public b x(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aui != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                xs(true);
                this.aui.setText(this.mContentText);
            } else {
                xs(false);
            }
        }
        return this;
    }

    public b OP(int i) {
        this.odp = i;
        if (this.aui != null && this.odp > 0) {
            this.aui.setTextSize(2, this.odp);
        }
        return this;
    }

    public b xr(boolean z) {
        this.ocQ = z;
        if (this.ehy != null) {
            this.ehy.setVisibility(this.ocQ ? 0 : 8);
        }
        return this;
    }

    public b xs(boolean z) {
        this.ocR = z;
        if (this.aui != null) {
            this.aui.setVisibility(this.ocR ? 0 : 8);
        }
        return this;
    }

    public b Td(String str) {
        this.mCancelText = str;
        if (this.ehy != null && this.mCancelText != null) {
            xr(true);
            this.ehy.setText(this.mCancelText);
            if (this.ocS) {
                this.ehy.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.ehy.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.ocW != null) {
                ViewCompat.setBackground(this.ehy, this.ocW);
            }
        }
        return this;
    }

    public b Te(String str) {
        this.ocT = str;
        if (this.odj != null && this.ocT != null) {
            this.odj.setText(this.ocT);
        }
        return this;
    }

    public b xt(boolean z) {
        this.ocU = z;
        if (this.odj != null) {
            if (z) {
                this.odj.setVisibility(0);
            } else {
                this.odj.setVisibility(8);
            }
        }
        return this;
    }

    public b Tf(String str) {
        this.mConfirmText = str;
        if (this.bXE != null && this.mConfirmText != null) {
            this.bXE.setText(this.mConfirmText);
            if (this.ocV) {
                this.bXE.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.bXE.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.ocX != null) {
                ViewCompat.setBackground(this.bXE, this.ocX);
            }
        }
        return this;
    }

    public b OQ(@ColorInt int i) {
        this.ocH = i;
        if (this.bXE != null) {
            if (this.ocH != -1) {
                this.bXE.setTextColor(this.ocH);
            } else if (ocG != -1) {
                this.bXE.setTextColor(ocG);
            }
        }
        return this;
    }

    public b A(Drawable drawable) {
        this.ocX = drawable;
        if (this.bXE != null) {
            ViewCompat.setBackground(this.bXE, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.odl = aVar;
        return this;
    }

    public b b(a aVar) {
        this.odm = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cuy.startAnimation(this.ocI);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xu(true);
    }

    public void dRv() {
        xu(false);
    }

    private void xu(boolean z) {
        this.odo = z;
        this.bXE.startAnimation(this.ocK);
        this.cuy.startAnimation(this.ocJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.odl != null) {
                this.odl.onClick(this);
            } else {
                dRv();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.odm != null) {
                this.odm.onClick(this);
            } else {
                dRv();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.odn != null) {
                this.odn.onClick(this);
            } else {
                dRv();
            }
        }
    }

    public b Tg(String str) {
        this.ocY = str;
        if (this.ocP != null && this.ocY != null) {
            this.ocP.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.ehy != null && this.bXE != null) {
            if (this.ehy.getVisibility() == 0 && this.bXE.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.ehy.getVisibility() == 0) {
                ViewCompat.setBackground(this.ehy, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.bXE.getVisibility() == 0) {
                ViewCompat.setBackground(this.bXE, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
