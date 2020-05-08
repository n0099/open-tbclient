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
    private static int nwG = -1;
    private TextView aNN;
    private View cTz;
    private Button cwB;
    private Button eHt;
    private String fHJ;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int nwH;
    private AnimationSet nwI;
    private AnimationSet nwJ;
    private Animation nwK;
    private Animation nwL;
    private AnimationSet nwM;
    private AnimationSet nwN;
    private Animation nwO;
    private EditText nwP;
    private boolean nwQ;
    private boolean nwR;
    private String nwS;
    private boolean nwT;
    private String nwU;
    private boolean nwV;
    private boolean nwW;
    private Drawable nwX;
    private Drawable nwY;
    private String nwZ;
    private int nxa;
    private FrameLayout nxb;
    private FrameLayout nxc;
    private FrameLayout nxd;
    private SuccessTickView nxe;
    private ImageView nxf;
    private View nxg;
    private View nxh;
    private Drawable nxi;
    private ImageView nxj;
    private Button nxk;
    private FrameLayout nxl;
    private a nxm;
    private a nxn;
    private a nxo;
    private boolean nxp;
    private int nxq;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.nwH = -1;
        this.nwQ = true;
        this.nwT = true;
        this.nwV = true;
        this.nwW = true;
        this.nxq = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.nxa = i;
        this.nwL = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.nwM = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.nwM.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.nwO = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.nwN = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.nwI = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.nwJ = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.nwJ.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cTz.setVisibility(8);
                b.this.cTz.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.nxp) {
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
        this.nwK = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.nwK.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.nxa == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.fV(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.nxa == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cTz = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aNN = (TextView) findViewById(b.e.content_text);
        this.nxb = (FrameLayout) findViewById(b.e.error_frame);
        if (this.nxb != null) {
            this.nxf = (ImageView) this.nxb.findViewById(b.e.error_x);
        }
        this.nxc = (FrameLayout) findViewById(b.e.success_frame);
        this.nxd = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.nxc != null) {
            this.nxe = (SuccessTickView) this.nxc.findViewById(b.e.success_tick);
            this.nxg = this.nxc.findViewById(b.e.mask_left);
            this.nxh = this.nxc.findViewById(b.e.mask_right);
        }
        this.nxj = (ImageView) findViewById(b.e.custom_image);
        this.nxl = (FrameLayout) findViewById(b.e.warning_frame);
        this.cwB = (Button) findViewById(b.e.confirm_button);
        this.eHt = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.nxk = (Button) findViewById(b.e.middle_btn);
        this.nwP = (EditText) findViewById(b.e.et_input);
        this.cwB.setOnClickListener(this);
        if (this.eHt != null) {
            this.eHt.setOnClickListener(this);
        }
        if (this.nxk != null) {
            this.nxk.setOnClickListener(this);
        }
        wW(this.nwQ);
        wY(this.nwV);
        Qv(this.mTitleText);
        w(this.mContentText);
        Km(this.nxq);
        Qw(this.nwS);
        Qy(this.fHJ);
        Kn(this.nwH);
        w(this.nwY);
        Qz(this.nwZ);
        Qx(this.nwU);
        af(this.nxa, true);
        if (this.nxa == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0852b.zues_text_color));
            }
            if (this.aNN != null) {
                this.aNN.setTextColor(this.mContext.getResources().getColor(b.C0852b.zues_text_color));
            }
        }
    }

    private void Sf() {
        if (this.nxj != null) {
            this.nxj.setVisibility(8);
        }
        if (this.nxb != null) {
            this.nxb.setVisibility(8);
        }
        if (this.nxc != null) {
            this.nxc.setVisibility(8);
        }
        if (this.nxl != null) {
            this.nxl.setVisibility(8);
        }
        if (this.nxd != null) {
            this.nxd.setVisibility(8);
        }
        if (this.cwB != null) {
            this.cwB.setVisibility(0);
        }
        this.cwB.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.nxb != null) {
            this.nxb.clearAnimation();
        }
        if (this.nxf != null) {
            this.nxf.clearAnimation();
        }
        if (this.nxe != null) {
            this.nxe.clearAnimation();
        }
        if (this.nxg != null) {
            this.nxg.clearAnimation();
        }
        if (this.nxh != null) {
            this.nxh.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.nxa == 1) {
            this.nxb.startAnimation(this.nwL);
            this.nxf.startAnimation(this.nwM);
        } else if (this.nxa == 2) {
            this.nxe.dKs();
            this.nxh.startAnimation(this.nwO);
        }
    }

    private void af(int i, boolean z) {
        this.nxa = i;
        if (this.cTz != null) {
            if (!z) {
                Sf();
            }
            switch (this.nxa) {
                case 1:
                    this.nxb.setVisibility(0);
                    break;
                case 2:
                    this.nxc.setVisibility(0);
                    this.nxg.startAnimation(this.nwN.getAnimations().get(0));
                    this.nxh.startAnimation(this.nwN.getAnimations().get(1));
                    break;
                case 3:
                    this.cwB.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.nxl.setVisibility(0);
                    break;
                case 4:
                    v(this.nxi);
                    break;
                case 5:
                    this.nxd.setVisibility(0);
                    this.cwB.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Qv(String str) {
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

    public b aS(String str, boolean z) {
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
        this.nxi = drawable;
        if (this.nxj != null && this.nxi != null) {
            this.nxj.setVisibility(0);
            this.nxj.setImageDrawable(this.nxi);
        }
        return this;
    }

    public b w(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aNN != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                wX(true);
                this.aNN.setText(this.mContentText);
            } else {
                wX(false);
            }
        }
        return this;
    }

    public b Km(int i) {
        this.nxq = i;
        if (this.aNN != null && this.nxq > 0) {
            this.aNN.setTextSize(2, this.nxq);
        }
        return this;
    }

    public b wW(boolean z) {
        this.nwQ = z;
        if (this.eHt != null) {
            this.eHt.setVisibility(this.nwQ ? 0 : 8);
        }
        return this;
    }

    public b wX(boolean z) {
        this.nwR = z;
        if (this.aNN != null) {
            this.aNN.setVisibility(this.nwR ? 0 : 8);
        }
        return this;
    }

    public b Qw(String str) {
        this.nwS = str;
        if (this.eHt != null && this.nwS != null) {
            wW(true);
            this.eHt.setText(this.nwS);
            if (this.nwT) {
                this.eHt.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.eHt.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nwX != null) {
                ViewCompat.setBackground(this.eHt, this.nwX);
            }
        }
        return this;
    }

    public b Qx(String str) {
        this.nwU = str;
        if (this.nxk != null && this.nwU != null) {
            this.nxk.setText(this.nwU);
        }
        return this;
    }

    public b wY(boolean z) {
        this.nwV = z;
        if (this.nxk != null) {
            if (z) {
                this.nxk.setVisibility(0);
            } else {
                this.nxk.setVisibility(8);
            }
        }
        return this;
    }

    public b Qy(String str) {
        this.fHJ = str;
        if (this.cwB != null && this.fHJ != null) {
            this.cwB.setText(this.fHJ);
            if (this.nwW) {
                this.cwB.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cwB.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nwY != null) {
                ViewCompat.setBackground(this.cwB, this.nwY);
            }
        }
        return this;
    }

    public b Kn(@ColorInt int i) {
        this.nwH = i;
        if (this.cwB != null) {
            if (this.nwH != -1) {
                this.cwB.setTextColor(this.nwH);
            } else if (nwG != -1) {
                this.cwB.setTextColor(nwG);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.nwY = drawable;
        if (this.cwB != null) {
            ViewCompat.setBackground(this.cwB, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.nxm = aVar;
        return this;
    }

    public b b(a aVar) {
        this.nxn = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cTz.startAnimation(this.nwI);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        wZ(true);
    }

    public void dKt() {
        wZ(false);
    }

    private void wZ(boolean z) {
        this.nxp = z;
        this.cwB.startAnimation(this.nwK);
        this.cTz.startAnimation(this.nwJ);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.nxm != null) {
                this.nxm.onClick(this);
            } else {
                dKt();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.nxn != null) {
                this.nxn.onClick(this);
            } else {
                dKt();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.nxo != null) {
                this.nxo.onClick(this);
            } else {
                dKt();
            }
        }
    }

    public b Qz(String str) {
        this.nwZ = str;
        if (this.nwP != null && this.nwZ != null) {
            this.nwP.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.eHt != null && this.cwB != null) {
            if (this.eHt.getVisibility() == 0 && this.cwB.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.eHt.getVisibility() == 0) {
                ViewCompat.setBackground(this.eHt, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cwB.getVisibility() == 0) {
                ViewCompat.setBackground(this.cwB, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
