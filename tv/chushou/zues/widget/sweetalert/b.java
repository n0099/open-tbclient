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
    private static int qqG = -1;
    private TextView aFh;
    private Button dCq;
    private View ebG;
    private Button fYk;
    private String hjL;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    private AnimationSet oAT;
    @ColorInt
    private int qqH;
    private AnimationSet qqI;
    private Animation qqJ;
    private Animation qqK;
    private AnimationSet qqL;
    private AnimationSet qqM;
    private Animation qqN;
    private EditText qqO;
    private boolean qqP;
    private boolean qqQ;
    private String qqR;
    private boolean qqS;
    private String qqT;
    private boolean qqU;
    private boolean qqV;
    private Drawable qqW;
    private Drawable qqX;
    private String qqY;
    private int qqZ;
    private FrameLayout qra;
    private FrameLayout qrb;
    private FrameLayout qrc;
    private SuccessTickView qrd;
    private ImageView qre;
    private View qrf;
    private View qrg;
    private Drawable qrh;
    private ImageView qri;
    private Button qrj;
    private FrameLayout qrk;
    private a qrl;
    private a qrm;
    private a qrn;
    private boolean qro;
    private int qrp;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.qqH = -1;
        this.qqP = true;
        this.qqS = true;
        this.qqU = true;
        this.qqV = true;
        this.qrp = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.qqZ = i;
        this.qqK = tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.qqL = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.qqL.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.qqN = tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.qqM = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.qqI = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_modal_in);
        this.oAT = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.J(getContext(), b.a.zues_sweetalert_modal_out);
        this.oAT.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.ebG.setVisibility(8);
                b.this.ebG.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.qro) {
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
        this.qqJ = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.qqJ.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.qqZ == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hE(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.qqZ == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.ebG = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aFh = (TextView) findViewById(b.e.content_text);
        this.qra = (FrameLayout) findViewById(b.e.error_frame);
        if (this.qra != null) {
            this.qre = (ImageView) this.qra.findViewById(b.e.error_x);
        }
        this.qrb = (FrameLayout) findViewById(b.e.success_frame);
        this.qrc = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.qrb != null) {
            this.qrd = (SuccessTickView) this.qrb.findViewById(b.e.success_tick);
            this.qrf = this.qrb.findViewById(b.e.mask_left);
            this.qrg = this.qrb.findViewById(b.e.mask_right);
        }
        this.qri = (ImageView) findViewById(b.e.custom_image);
        this.qrk = (FrameLayout) findViewById(b.e.warning_frame);
        this.dCq = (Button) findViewById(b.e.confirm_button);
        this.fYk = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.qrj = (Button) findViewById(b.e.middle_btn);
        this.qqO = (EditText) findViewById(b.e.et_input);
        this.dCq.setOnClickListener(this);
        if (this.fYk != null) {
            this.fYk.setOnClickListener(this);
        }
        if (this.qrj != null) {
            this.qrj.setOnClickListener(this);
        }
        Bv(this.qqP);
        Bx(this.qqU);
        aaK(this.mTitleText);
        D(this.mContentText);
        Su(this.qrp);
        aaL(this.qqR);
        aaN(this.hjL);
        Sv(this.qqH);
        B(this.qqX);
        aaO(this.qqY);
        aaM(this.qqT);
        as(this.qqZ, true);
        if (this.qqZ == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C1115b.zues_text_color));
            }
            if (this.aFh != null) {
                this.aFh.setTextColor(this.mContext.getResources().getColor(b.C1115b.zues_text_color));
            }
        }
    }

    private void aky() {
        if (this.qri != null) {
            this.qri.setVisibility(8);
        }
        if (this.qra != null) {
            this.qra.setVisibility(8);
        }
        if (this.qrb != null) {
            this.qrb.setVisibility(8);
        }
        if (this.qrk != null) {
            this.qrk.setVisibility(8);
        }
        if (this.qrc != null) {
            this.qrc.setVisibility(8);
        }
        if (this.dCq != null) {
            this.dCq.setVisibility(0);
        }
        this.dCq.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.qra != null) {
            this.qra.clearAnimation();
        }
        if (this.qre != null) {
            this.qre.clearAnimation();
        }
        if (this.qrd != null) {
            this.qrd.clearAnimation();
        }
        if (this.qrf != null) {
            this.qrf.clearAnimation();
        }
        if (this.qrg != null) {
            this.qrg.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.qqZ == 1) {
            this.qra.startAnimation(this.qqK);
            this.qre.startAnimation(this.qqL);
        } else if (this.qqZ == 2) {
            this.qrd.eIo();
            this.qrg.startAnimation(this.qqN);
        }
    }

    private void as(int i, boolean z) {
        this.qqZ = i;
        if (this.ebG != null) {
            if (!z) {
                aky();
            }
            switch (this.qqZ) {
                case 1:
                    this.qra.setVisibility(0);
                    break;
                case 2:
                    this.qrb.setVisibility(0);
                    this.qrf.startAnimation(this.qqM.getAnimations().get(0));
                    this.qrg.startAnimation(this.qqM.getAnimations().get(1));
                    break;
                case 3:
                    this.dCq.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.qrk.setVisibility(0);
                    break;
                case 4:
                    A(this.qrh);
                    break;
                case 5:
                    this.qrc.setVisibility(0);
                    this.dCq.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b aaK(String str) {
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

    public b A(Drawable drawable) {
        this.qrh = drawable;
        if (this.qri != null && this.qrh != null) {
            this.qri.setVisibility(0);
            this.qri.setImageDrawable(this.qrh);
        }
        return this;
    }

    public b D(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aFh != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                Bw(true);
                this.aFh.setText(this.mContentText);
            } else {
                Bw(false);
            }
        }
        return this;
    }

    public b Su(int i) {
        this.qrp = i;
        if (this.aFh != null && this.qrp > 0) {
            this.aFh.setTextSize(2, this.qrp);
        }
        return this;
    }

    public b Bv(boolean z) {
        this.qqP = z;
        if (this.fYk != null) {
            this.fYk.setVisibility(this.qqP ? 0 : 8);
        }
        return this;
    }

    public b Bw(boolean z) {
        this.qqQ = z;
        if (this.aFh != null) {
            this.aFh.setVisibility(this.qqQ ? 0 : 8);
        }
        return this;
    }

    public b aaL(String str) {
        this.qqR = str;
        if (this.fYk != null && this.qqR != null) {
            Bv(true);
            this.fYk.setText(this.qqR);
            if (this.qqS) {
                this.fYk.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fYk.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.qqW != null) {
                ViewCompat.setBackground(this.fYk, this.qqW);
            }
        }
        return this;
    }

    public b aaM(String str) {
        this.qqT = str;
        if (this.qrj != null && this.qqT != null) {
            this.qrj.setText(this.qqT);
        }
        return this;
    }

    public b Bx(boolean z) {
        this.qqU = z;
        if (this.qrj != null) {
            if (z) {
                this.qrj.setVisibility(0);
            } else {
                this.qrj.setVisibility(8);
            }
        }
        return this;
    }

    public b aaN(String str) {
        this.hjL = str;
        if (this.dCq != null && this.hjL != null) {
            this.dCq.setText(this.hjL);
            if (this.qqV) {
                this.dCq.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.dCq.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.qqX != null) {
                ViewCompat.setBackground(this.dCq, this.qqX);
            }
        }
        return this;
    }

    public b Sv(@ColorInt int i) {
        this.qqH = i;
        if (this.dCq != null) {
            if (this.qqH != -1) {
                this.dCq.setTextColor(this.qqH);
            } else if (qqG != -1) {
                this.dCq.setTextColor(qqG);
            }
        }
        return this;
    }

    public b B(Drawable drawable) {
        this.qqX = drawable;
        if (this.dCq != null) {
            ViewCompat.setBackground(this.dCq, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.qrl = aVar;
        return this;
    }

    public b b(a aVar) {
        this.qrm = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.ebG.startAnimation(this.qqI);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        zQ(true);
    }

    public void eIp() {
        zQ(false);
    }

    private void zQ(boolean z) {
        this.qro = z;
        this.dCq.startAnimation(this.qqJ);
        this.ebG.startAnimation(this.oAT);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.qrl != null) {
                this.qrl.onClick(this);
            } else {
                eIp();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.qrm != null) {
                this.qrm.onClick(this);
            } else {
                eIp();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.qrn != null) {
                this.qrn.onClick(this);
            } else {
                eIp();
            }
        }
    }

    public b aaO(String str) {
        this.qqY = str;
        if (this.qqO != null && this.qqY != null) {
            this.qqO.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fYk != null && this.dCq != null) {
            if (this.fYk.getVisibility() == 0 && this.dCq.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fYk.getVisibility() == 0) {
                ViewCompat.setBackground(this.fYk, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.dCq.getVisibility() == 0) {
                ViewCompat.setBackground(this.dCq, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
