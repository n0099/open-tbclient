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
    private static int nwD = -1;
    private TextView aNH;
    private View cTu;
    private Button cwv;
    private Button eHo;
    private String fHE;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int nwE;
    private AnimationSet nwF;
    private AnimationSet nwG;
    private Animation nwH;
    private Animation nwI;
    private AnimationSet nwJ;
    private AnimationSet nwK;
    private Animation nwL;
    private EditText nwM;
    private boolean nwN;
    private boolean nwO;
    private String nwP;
    private boolean nwQ;
    private String nwR;
    private boolean nwS;
    private boolean nwT;
    private Drawable nwU;
    private Drawable nwV;
    private String nwW;
    private int nwX;
    private FrameLayout nwY;
    private FrameLayout nwZ;
    private FrameLayout nxa;
    private SuccessTickView nxb;
    private ImageView nxc;
    private View nxd;
    private View nxe;
    private Drawable nxf;
    private ImageView nxg;
    private Button nxh;
    private FrameLayout nxi;
    private a nxj;
    private a nxk;
    private a nxl;
    private boolean nxm;
    private int nxn;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.nwE = -1;
        this.nwN = true;
        this.nwQ = true;
        this.nwS = true;
        this.nwT = true;
        this.nxn = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.nwX = i;
        this.nwI = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.nwJ = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.nwJ.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.nwL = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.nwK = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.nwF = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.nwG = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.nwG.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.cTu.setVisibility(8);
                b.this.cTu.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.nxm) {
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
        this.nwH = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.nwH.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.nwX == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gi(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.nwX == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.cTu = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aNH = (TextView) findViewById(b.e.content_text);
        this.nwY = (FrameLayout) findViewById(b.e.error_frame);
        if (this.nwY != null) {
            this.nxc = (ImageView) this.nwY.findViewById(b.e.error_x);
        }
        this.nwZ = (FrameLayout) findViewById(b.e.success_frame);
        this.nxa = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.nwZ != null) {
            this.nxb = (SuccessTickView) this.nwZ.findViewById(b.e.success_tick);
            this.nxd = this.nwZ.findViewById(b.e.mask_left);
            this.nxe = this.nwZ.findViewById(b.e.mask_right);
        }
        this.nxg = (ImageView) findViewById(b.e.custom_image);
        this.nxi = (FrameLayout) findViewById(b.e.warning_frame);
        this.cwv = (Button) findViewById(b.e.confirm_button);
        this.eHo = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.nxh = (Button) findViewById(b.e.middle_btn);
        this.nwM = (EditText) findViewById(b.e.et_input);
        this.cwv.setOnClickListener(this);
        if (this.eHo != null) {
            this.eHo.setOnClickListener(this);
        }
        if (this.nxh != null) {
            this.nxh.setOnClickListener(this);
        }
        wW(this.nwN);
        wY(this.nwS);
        Qs(this.mTitleText);
        w(this.mContentText);
        Km(this.nxn);
        Qt(this.nwP);
        Qv(this.fHE);
        Kn(this.nwE);
        w(this.nwV);
        Qw(this.nwW);
        Qu(this.nwR);
        af(this.nwX, true);
        if (this.nwX == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0831b.zues_text_color));
            }
            if (this.aNH != null) {
                this.aNH.setTextColor(this.mContext.getResources().getColor(b.C0831b.zues_text_color));
            }
        }
    }

    private void Sg() {
        if (this.nxg != null) {
            this.nxg.setVisibility(8);
        }
        if (this.nwY != null) {
            this.nwY.setVisibility(8);
        }
        if (this.nwZ != null) {
            this.nwZ.setVisibility(8);
        }
        if (this.nxi != null) {
            this.nxi.setVisibility(8);
        }
        if (this.nxa != null) {
            this.nxa.setVisibility(8);
        }
        if (this.cwv != null) {
            this.cwv.setVisibility(0);
        }
        this.cwv.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.nwY != null) {
            this.nwY.clearAnimation();
        }
        if (this.nxc != null) {
            this.nxc.clearAnimation();
        }
        if (this.nxb != null) {
            this.nxb.clearAnimation();
        }
        if (this.nxd != null) {
            this.nxd.clearAnimation();
        }
        if (this.nxe != null) {
            this.nxe.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.nwX == 1) {
            this.nwY.startAnimation(this.nwI);
            this.nxc.startAnimation(this.nwJ);
        } else if (this.nwX == 2) {
            this.nxb.dKw();
            this.nxe.startAnimation(this.nwL);
        }
    }

    private void af(int i, boolean z) {
        this.nwX = i;
        if (this.cTu != null) {
            if (!z) {
                Sg();
            }
            switch (this.nwX) {
                case 1:
                    this.nwY.setVisibility(0);
                    break;
                case 2:
                    this.nwZ.setVisibility(0);
                    this.nxd.startAnimation(this.nwK.getAnimations().get(0));
                    this.nxe.startAnimation(this.nwK.getAnimations().get(1));
                    break;
                case 3:
                    this.cwv.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.nxi.setVisibility(0);
                    break;
                case 4:
                    v(this.nxf);
                    break;
                case 5:
                    this.nxa.setVisibility(0);
                    this.cwv.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Qs(String str) {
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
        this.nxf = drawable;
        if (this.nxg != null && this.nxf != null) {
            this.nxg.setVisibility(0);
            this.nxg.setImageDrawable(this.nxf);
        }
        return this;
    }

    public b w(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aNH != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                wX(true);
                this.aNH.setText(this.mContentText);
            } else {
                wX(false);
            }
        }
        return this;
    }

    public b Km(int i) {
        this.nxn = i;
        if (this.aNH != null && this.nxn > 0) {
            this.aNH.setTextSize(2, this.nxn);
        }
        return this;
    }

    public b wW(boolean z) {
        this.nwN = z;
        if (this.eHo != null) {
            this.eHo.setVisibility(this.nwN ? 0 : 8);
        }
        return this;
    }

    public b wX(boolean z) {
        this.nwO = z;
        if (this.aNH != null) {
            this.aNH.setVisibility(this.nwO ? 0 : 8);
        }
        return this;
    }

    public b Qt(String str) {
        this.nwP = str;
        if (this.eHo != null && this.nwP != null) {
            wW(true);
            this.eHo.setText(this.nwP);
            if (this.nwQ) {
                this.eHo.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.eHo.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nwU != null) {
                ViewCompat.setBackground(this.eHo, this.nwU);
            }
        }
        return this;
    }

    public b Qu(String str) {
        this.nwR = str;
        if (this.nxh != null && this.nwR != null) {
            this.nxh.setText(this.nwR);
        }
        return this;
    }

    public b wY(boolean z) {
        this.nwS = z;
        if (this.nxh != null) {
            if (z) {
                this.nxh.setVisibility(0);
            } else {
                this.nxh.setVisibility(8);
            }
        }
        return this;
    }

    public b Qv(String str) {
        this.fHE = str;
        if (this.cwv != null && this.fHE != null) {
            this.cwv.setText(this.fHE);
            if (this.nwT) {
                this.cwv.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cwv.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nwV != null) {
                ViewCompat.setBackground(this.cwv, this.nwV);
            }
        }
        return this;
    }

    public b Kn(@ColorInt int i) {
        this.nwE = i;
        if (this.cwv != null) {
            if (this.nwE != -1) {
                this.cwv.setTextColor(this.nwE);
            } else if (nwD != -1) {
                this.cwv.setTextColor(nwD);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.nwV = drawable;
        if (this.cwv != null) {
            ViewCompat.setBackground(this.cwv, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.nxj = aVar;
        return this;
    }

    public b b(a aVar) {
        this.nxk = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.cTu.startAnimation(this.nwF);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        wZ(true);
    }

    public void dKx() {
        wZ(false);
    }

    private void wZ(boolean z) {
        this.nxm = z;
        this.cwv.startAnimation(this.nwH);
        this.cTu.startAnimation(this.nwG);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.nxj != null) {
                this.nxj.onClick(this);
            } else {
                dKx();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.nxk != null) {
                this.nxk.onClick(this);
            } else {
                dKx();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.nxl != null) {
                this.nxl.onClick(this);
            } else {
                dKx();
            }
        }
    }

    public b Qw(String str) {
        this.nwW = str;
        if (this.nwM != null && this.nwW != null) {
            this.nwM.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.eHo != null && this.cwv != null) {
            if (this.eHo.getVisibility() == 0 && this.cwv.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.eHo.getVisibility() == 0) {
                ViewCompat.setBackground(this.eHo, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cwv.getVisibility() == 0) {
                ViewCompat.setBackground(this.cwv, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
