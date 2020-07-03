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
    private static int ooB = -1;
    private TextView aWB;
    private Button cNn;
    private View djo;
    private Button fen;
    private String giN;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int ooC;
    private AnimationSet ooD;
    private AnimationSet ooE;
    private Animation ooF;
    private Animation ooG;
    private AnimationSet ooH;
    private AnimationSet ooI;
    private Animation ooJ;
    private EditText ooK;
    private boolean ooL;
    private boolean ooM;
    private String ooN;
    private boolean ooO;
    private String ooP;
    private boolean ooQ;
    private boolean ooR;
    private Drawable ooS;
    private Drawable ooT;
    private String ooU;
    private int ooV;
    private FrameLayout ooW;
    private FrameLayout ooX;
    private FrameLayout ooY;
    private SuccessTickView ooZ;
    private ImageView opa;
    private View opb;
    private View opc;
    private Drawable opd;
    private ImageView ope;
    private Button opf;
    private FrameLayout opg;
    private a oph;
    private a opi;
    private a opj;
    private boolean opk;
    private int opl;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.ooC = -1;
        this.ooL = true;
        this.ooO = true;
        this.ooQ = true;
        this.ooR = true;
        this.opl = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.ooV = i;
        this.ooG = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.ooH = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.ooH.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.ooJ = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.ooI = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.ooD = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.ooE = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.ooE.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.djo.setVisibility(8);
                b.this.djo.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.opk) {
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
        this.ooF = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.ooF.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ooV == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gx(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.ooV == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.djo = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aWB = (TextView) findViewById(b.e.content_text);
        this.ooW = (FrameLayout) findViewById(b.e.error_frame);
        if (this.ooW != null) {
            this.opa = (ImageView) this.ooW.findViewById(b.e.error_x);
        }
        this.ooX = (FrameLayout) findViewById(b.e.success_frame);
        this.ooY = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.ooX != null) {
            this.ooZ = (SuccessTickView) this.ooX.findViewById(b.e.success_tick);
            this.opb = this.ooX.findViewById(b.e.mask_left);
            this.opc = this.ooX.findViewById(b.e.mask_right);
        }
        this.ope = (ImageView) findViewById(b.e.custom_image);
        this.opg = (FrameLayout) findViewById(b.e.warning_frame);
        this.cNn = (Button) findViewById(b.e.confirm_button);
        this.fen = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.opf = (Button) findViewById(b.e.middle_btn);
        this.ooK = (EditText) findViewById(b.e.et_input);
        this.cNn.setOnClickListener(this);
        if (this.fen != null) {
            this.fen.setOnClickListener(this);
        }
        if (this.opf != null) {
            this.opf.setOnClickListener(this);
        }
        xQ(this.ooL);
        xS(this.ooQ);
        To(this.mTitleText);
        B(this.mContentText);
        Mf(this.opl);
        Tp(this.ooN);
        Tr(this.giN);
        Mg(this.ooC);
        w(this.ooT);
        Ts(this.ooU);
        Tq(this.ooP);
        al(this.ooV, true);
        if (this.ooV == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0934b.zues_text_color));
            }
            if (this.aWB != null) {
                this.aWB.setTextColor(this.mContext.getResources().getColor(b.C0934b.zues_text_color));
            }
        }
    }

    private void VX() {
        if (this.ope != null) {
            this.ope.setVisibility(8);
        }
        if (this.ooW != null) {
            this.ooW.setVisibility(8);
        }
        if (this.ooX != null) {
            this.ooX.setVisibility(8);
        }
        if (this.opg != null) {
            this.opg.setVisibility(8);
        }
        if (this.ooY != null) {
            this.ooY.setVisibility(8);
        }
        if (this.cNn != null) {
            this.cNn.setVisibility(0);
        }
        this.cNn.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.ooW != null) {
            this.ooW.clearAnimation();
        }
        if (this.opa != null) {
            this.opa.clearAnimation();
        }
        if (this.ooZ != null) {
            this.ooZ.clearAnimation();
        }
        if (this.opb != null) {
            this.opb.clearAnimation();
        }
        if (this.opc != null) {
            this.opc.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.ooV == 1) {
            this.ooW.startAnimation(this.ooG);
            this.opa.startAnimation(this.ooH);
        } else if (this.ooV == 2) {
            this.ooZ.dXh();
            this.opc.startAnimation(this.ooJ);
        }
    }

    private void al(int i, boolean z) {
        this.ooV = i;
        if (this.djo != null) {
            if (!z) {
                VX();
            }
            switch (this.ooV) {
                case 1:
                    this.ooW.setVisibility(0);
                    break;
                case 2:
                    this.ooX.setVisibility(0);
                    this.opb.startAnimation(this.ooI.getAnimations().get(0));
                    this.opc.startAnimation(this.ooI.getAnimations().get(1));
                    break;
                case 3:
                    this.cNn.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.opg.setVisibility(0);
                    break;
                case 4:
                    v(this.opd);
                    break;
                case 5:
                    this.ooY.setVisibility(0);
                    this.cNn.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b To(String str) {
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

    public b bh(String str, boolean z) {
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
        this.opd = drawable;
        if (this.ope != null && this.opd != null) {
            this.ope.setVisibility(0);
            this.ope.setImageDrawable(this.opd);
        }
        return this;
    }

    public b B(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aWB != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                xR(true);
                this.aWB.setText(this.mContentText);
            } else {
                xR(false);
            }
        }
        return this;
    }

    public b Mf(int i) {
        this.opl = i;
        if (this.aWB != null && this.opl > 0) {
            this.aWB.setTextSize(2, this.opl);
        }
        return this;
    }

    public b xQ(boolean z) {
        this.ooL = z;
        if (this.fen != null) {
            this.fen.setVisibility(this.ooL ? 0 : 8);
        }
        return this;
    }

    public b xR(boolean z) {
        this.ooM = z;
        if (this.aWB != null) {
            this.aWB.setVisibility(this.ooM ? 0 : 8);
        }
        return this;
    }

    public b Tp(String str) {
        this.ooN = str;
        if (this.fen != null && this.ooN != null) {
            xQ(true);
            this.fen.setText(this.ooN);
            if (this.ooO) {
                this.fen.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fen.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.ooS != null) {
                ViewCompat.setBackground(this.fen, this.ooS);
            }
        }
        return this;
    }

    public b Tq(String str) {
        this.ooP = str;
        if (this.opf != null && this.ooP != null) {
            this.opf.setText(this.ooP);
        }
        return this;
    }

    public b xS(boolean z) {
        this.ooQ = z;
        if (this.opf != null) {
            if (z) {
                this.opf.setVisibility(0);
            } else {
                this.opf.setVisibility(8);
            }
        }
        return this;
    }

    public b Tr(String str) {
        this.giN = str;
        if (this.cNn != null && this.giN != null) {
            this.cNn.setText(this.giN);
            if (this.ooR) {
                this.cNn.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cNn.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.ooT != null) {
                ViewCompat.setBackground(this.cNn, this.ooT);
            }
        }
        return this;
    }

    public b Mg(@ColorInt int i) {
        this.ooC = i;
        if (this.cNn != null) {
            if (this.ooC != -1) {
                this.cNn.setTextColor(this.ooC);
            } else if (ooB != -1) {
                this.cNn.setTextColor(ooB);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.ooT = drawable;
        if (this.cNn != null) {
            ViewCompat.setBackground(this.cNn, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.oph = aVar;
        return this;
    }

    public b b(a aVar) {
        this.opi = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.djo.startAnimation(this.ooD);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xT(true);
    }

    public void dXi() {
        xT(false);
    }

    private void xT(boolean z) {
        this.opk = z;
        this.cNn.startAnimation(this.ooF);
        this.djo.startAnimation(this.ooE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.oph != null) {
                this.oph.onClick(this);
            } else {
                dXi();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.opi != null) {
                this.opi.onClick(this);
            } else {
                dXi();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.opj != null) {
                this.opj.onClick(this);
            } else {
                dXi();
            }
        }
    }

    public b Ts(String str) {
        this.ooU = str;
        if (this.ooK != null && this.ooU != null) {
            this.ooK.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fen != null && this.cNn != null) {
            if (this.fen.getVisibility() == 0 && this.cNn.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fen.getVisibility() == 0) {
                ViewCompat.setBackground(this.fen, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cNn.getVisibility() == 0) {
                ViewCompat.setBackground(this.cNn, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
