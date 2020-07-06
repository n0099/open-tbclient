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
    private static int ooE = -1;
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
    private int ooF;
    private AnimationSet ooG;
    private AnimationSet ooH;
    private Animation ooI;
    private Animation ooJ;
    private AnimationSet ooK;
    private AnimationSet ooL;
    private Animation ooM;
    private EditText ooN;
    private boolean ooO;
    private boolean ooP;
    private String ooQ;
    private boolean ooR;
    private String ooS;
    private boolean ooT;
    private boolean ooU;
    private Drawable ooV;
    private Drawable ooW;
    private String ooX;
    private int ooY;
    private FrameLayout ooZ;
    private FrameLayout opa;
    private FrameLayout opb;
    private SuccessTickView opc;
    private ImageView opd;
    private View ope;
    private View opf;
    private Drawable opg;
    private ImageView oph;
    private Button opi;
    private FrameLayout opj;
    private a opk;
    private a opl;
    private a opm;
    private boolean opn;
    private int opo;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.ooF = -1;
        this.ooO = true;
        this.ooR = true;
        this.ooT = true;
        this.ooU = true;
        this.opo = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.ooY = i;
        this.ooJ = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.ooK = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.ooK.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.ooM = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.ooL = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.ooG = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.ooH = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.ooH.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.djo.setVisibility(8);
                b.this.djo.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.opn) {
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
        this.ooI = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.ooI.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ooY == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gx(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.ooY == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.djo = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aWB = (TextView) findViewById(b.e.content_text);
        this.ooZ = (FrameLayout) findViewById(b.e.error_frame);
        if (this.ooZ != null) {
            this.opd = (ImageView) this.ooZ.findViewById(b.e.error_x);
        }
        this.opa = (FrameLayout) findViewById(b.e.success_frame);
        this.opb = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.opa != null) {
            this.opc = (SuccessTickView) this.opa.findViewById(b.e.success_tick);
            this.ope = this.opa.findViewById(b.e.mask_left);
            this.opf = this.opa.findViewById(b.e.mask_right);
        }
        this.oph = (ImageView) findViewById(b.e.custom_image);
        this.opj = (FrameLayout) findViewById(b.e.warning_frame);
        this.cNn = (Button) findViewById(b.e.confirm_button);
        this.fen = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.opi = (Button) findViewById(b.e.middle_btn);
        this.ooN = (EditText) findViewById(b.e.et_input);
        this.cNn.setOnClickListener(this);
        if (this.fen != null) {
            this.fen.setOnClickListener(this);
        }
        if (this.opi != null) {
            this.opi.setOnClickListener(this);
        }
        xQ(this.ooO);
        xS(this.ooT);
        Tp(this.mTitleText);
        B(this.mContentText);
        Mf(this.opo);
        Tq(this.ooQ);
        Ts(this.giN);
        Mg(this.ooF);
        w(this.ooW);
        Tt(this.ooX);
        Tr(this.ooS);
        al(this.ooY, true);
        if (this.ooY == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0935b.zues_text_color));
            }
            if (this.aWB != null) {
                this.aWB.setTextColor(this.mContext.getResources().getColor(b.C0935b.zues_text_color));
            }
        }
    }

    private void VX() {
        if (this.oph != null) {
            this.oph.setVisibility(8);
        }
        if (this.ooZ != null) {
            this.ooZ.setVisibility(8);
        }
        if (this.opa != null) {
            this.opa.setVisibility(8);
        }
        if (this.opj != null) {
            this.opj.setVisibility(8);
        }
        if (this.opb != null) {
            this.opb.setVisibility(8);
        }
        if (this.cNn != null) {
            this.cNn.setVisibility(0);
        }
        this.cNn.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.ooZ != null) {
            this.ooZ.clearAnimation();
        }
        if (this.opd != null) {
            this.opd.clearAnimation();
        }
        if (this.opc != null) {
            this.opc.clearAnimation();
        }
        if (this.ope != null) {
            this.ope.clearAnimation();
        }
        if (this.opf != null) {
            this.opf.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.ooY == 1) {
            this.ooZ.startAnimation(this.ooJ);
            this.opd.startAnimation(this.ooK);
        } else if (this.ooY == 2) {
            this.opc.dXl();
            this.opf.startAnimation(this.ooM);
        }
    }

    private void al(int i, boolean z) {
        this.ooY = i;
        if (this.djo != null) {
            if (!z) {
                VX();
            }
            switch (this.ooY) {
                case 1:
                    this.ooZ.setVisibility(0);
                    break;
                case 2:
                    this.opa.setVisibility(0);
                    this.ope.startAnimation(this.ooL.getAnimations().get(0));
                    this.opf.startAnimation(this.ooL.getAnimations().get(1));
                    break;
                case 3:
                    this.cNn.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.opj.setVisibility(0);
                    break;
                case 4:
                    v(this.opg);
                    break;
                case 5:
                    this.opb.setVisibility(0);
                    this.cNn.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Tp(String str) {
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
        this.opg = drawable;
        if (this.oph != null && this.opg != null) {
            this.oph.setVisibility(0);
            this.oph.setImageDrawable(this.opg);
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
        this.opo = i;
        if (this.aWB != null && this.opo > 0) {
            this.aWB.setTextSize(2, this.opo);
        }
        return this;
    }

    public b xQ(boolean z) {
        this.ooO = z;
        if (this.fen != null) {
            this.fen.setVisibility(this.ooO ? 0 : 8);
        }
        return this;
    }

    public b xR(boolean z) {
        this.ooP = z;
        if (this.aWB != null) {
            this.aWB.setVisibility(this.ooP ? 0 : 8);
        }
        return this;
    }

    public b Tq(String str) {
        this.ooQ = str;
        if (this.fen != null && this.ooQ != null) {
            xQ(true);
            this.fen.setText(this.ooQ);
            if (this.ooR) {
                this.fen.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fen.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.ooV != null) {
                ViewCompat.setBackground(this.fen, this.ooV);
            }
        }
        return this;
    }

    public b Tr(String str) {
        this.ooS = str;
        if (this.opi != null && this.ooS != null) {
            this.opi.setText(this.ooS);
        }
        return this;
    }

    public b xS(boolean z) {
        this.ooT = z;
        if (this.opi != null) {
            if (z) {
                this.opi.setVisibility(0);
            } else {
                this.opi.setVisibility(8);
            }
        }
        return this;
    }

    public b Ts(String str) {
        this.giN = str;
        if (this.cNn != null && this.giN != null) {
            this.cNn.setText(this.giN);
            if (this.ooU) {
                this.cNn.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cNn.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.ooW != null) {
                ViewCompat.setBackground(this.cNn, this.ooW);
            }
        }
        return this;
    }

    public b Mg(@ColorInt int i) {
        this.ooF = i;
        if (this.cNn != null) {
            if (this.ooF != -1) {
                this.cNn.setTextColor(this.ooF);
            } else if (ooE != -1) {
                this.cNn.setTextColor(ooE);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.ooW = drawable;
        if (this.cNn != null) {
            ViewCompat.setBackground(this.cNn, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.opk = aVar;
        return this;
    }

    public b b(a aVar) {
        this.opl = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.djo.startAnimation(this.ooG);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xT(true);
    }

    public void dXm() {
        xT(false);
    }

    private void xT(boolean z) {
        this.opn = z;
        this.cNn.startAnimation(this.ooI);
        this.djo.startAnimation(this.ooH);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.opk != null) {
                this.opk.onClick(this);
            } else {
                dXm();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.opl != null) {
                this.opl.onClick(this);
            } else {
                dXm();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.opm != null) {
                this.opm.onClick(this);
            } else {
                dXm();
            }
        }
    }

    public b Tt(String str) {
        this.ooX = str;
        if (this.ooN != null && this.ooX != null) {
            this.ooN.setHint(str);
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
