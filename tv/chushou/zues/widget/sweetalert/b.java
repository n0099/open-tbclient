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
    private static int paF = -1;
    private TextView aBe;
    private View dBq;
    private Button dbO;
    private Button fxR;
    private String gDU;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int paG;
    private AnimationSet paH;
    private AnimationSet paI;
    private Animation paJ;
    private Animation paK;
    private AnimationSet paL;
    private AnimationSet paM;
    private Animation paN;
    private EditText paO;
    private boolean paP;
    private boolean paQ;
    private String paR;
    private boolean paS;
    private String paT;
    private boolean paU;
    private boolean paV;
    private Drawable paW;
    private Drawable paX;
    private String paY;
    private int paZ;
    private FrameLayout pba;
    private FrameLayout pbb;
    private FrameLayout pbc;
    private SuccessTickView pbd;
    private ImageView pbe;
    private View pbf;
    private View pbg;
    private Drawable pbh;
    private ImageView pbi;
    private Button pbj;
    private FrameLayout pbk;
    private a pbl;
    private a pbm;
    private a pbn;
    private boolean pbo;
    private int pbp;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.paG = -1;
        this.paP = true;
        this.paS = true;
        this.paU = true;
        this.paV = true;
        this.pbp = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.paZ = i;
        this.paK = tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.paL = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.paL.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.paN = tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.paM = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.paH = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_modal_in);
        this.paI = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_modal_out);
        this.paI.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dBq.setVisibility(8);
                b.this.dBq.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.pbo) {
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
        this.paJ = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.paJ.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.paZ == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hd(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.paZ == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dBq = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aBe = (TextView) findViewById(b.e.content_text);
        this.pba = (FrameLayout) findViewById(b.e.error_frame);
        if (this.pba != null) {
            this.pbe = (ImageView) this.pba.findViewById(b.e.error_x);
        }
        this.pbb = (FrameLayout) findViewById(b.e.success_frame);
        this.pbc = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.pbb != null) {
            this.pbd = (SuccessTickView) this.pbb.findViewById(b.e.success_tick);
            this.pbf = this.pbb.findViewById(b.e.mask_left);
            this.pbg = this.pbb.findViewById(b.e.mask_right);
        }
        this.pbi = (ImageView) findViewById(b.e.custom_image);
        this.pbk = (FrameLayout) findViewById(b.e.warning_frame);
        this.dbO = (Button) findViewById(b.e.confirm_button);
        this.fxR = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.pbj = (Button) findViewById(b.e.middle_btn);
        this.paO = (EditText) findViewById(b.e.et_input);
        this.dbO.setOnClickListener(this);
        if (this.fxR != null) {
            this.fxR.setOnClickListener(this);
        }
        if (this.pbj != null) {
            this.pbj.setOnClickListener(this);
        }
        zw(this.paP);
        zy(this.paU);
        XF(this.mTitleText);
        z(this.mContentText);
        PD(this.pbp);
        XG(this.paR);
        XI(this.gDU);
        PE(this.paG);
        w(this.paX);
        XJ(this.paY);
        XH(this.paT);
        an(this.paZ, true);
        if (this.paZ == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C1005b.zues_text_color));
            }
            if (this.aBe != null) {
                this.aBe.setTextColor(this.mContext.getResources().getColor(b.C1005b.zues_text_color));
            }
        }
    }

    private void adt() {
        if (this.pbi != null) {
            this.pbi.setVisibility(8);
        }
        if (this.pba != null) {
            this.pba.setVisibility(8);
        }
        if (this.pbb != null) {
            this.pbb.setVisibility(8);
        }
        if (this.pbk != null) {
            this.pbk.setVisibility(8);
        }
        if (this.pbc != null) {
            this.pbc.setVisibility(8);
        }
        if (this.dbO != null) {
            this.dbO.setVisibility(0);
        }
        this.dbO.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.pba != null) {
            this.pba.clearAnimation();
        }
        if (this.pbe != null) {
            this.pbe.clearAnimation();
        }
        if (this.pbd != null) {
            this.pbd.clearAnimation();
        }
        if (this.pbf != null) {
            this.pbf.clearAnimation();
        }
        if (this.pbg != null) {
            this.pbg.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.paZ == 1) {
            this.pba.startAnimation(this.paK);
            this.pbe.startAnimation(this.paL);
        } else if (this.paZ == 2) {
            this.pbd.eqQ();
            this.pbg.startAnimation(this.paN);
        }
    }

    private void an(int i, boolean z) {
        this.paZ = i;
        if (this.dBq != null) {
            if (!z) {
                adt();
            }
            switch (this.paZ) {
                case 1:
                    this.pba.setVisibility(0);
                    break;
                case 2:
                    this.pbb.setVisibility(0);
                    this.pbf.startAnimation(this.paM.getAnimations().get(0));
                    this.pbg.startAnimation(this.paM.getAnimations().get(1));
                    break;
                case 3:
                    this.dbO.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.pbk.setVisibility(0);
                    break;
                case 4:
                    v(this.pbh);
                    break;
                case 5:
                    this.pbc.setVisibility(0);
                    this.dbO.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b XF(String str) {
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

    public b bj(String str, boolean z) {
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
        this.pbh = drawable;
        if (this.pbi != null && this.pbh != null) {
            this.pbi.setVisibility(0);
            this.pbi.setImageDrawable(this.pbh);
        }
        return this;
    }

    public b z(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aBe != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                zx(true);
                this.aBe.setText(this.mContentText);
            } else {
                zx(false);
            }
        }
        return this;
    }

    public b PD(int i) {
        this.pbp = i;
        if (this.aBe != null && this.pbp > 0) {
            this.aBe.setTextSize(2, this.pbp);
        }
        return this;
    }

    public b zw(boolean z) {
        this.paP = z;
        if (this.fxR != null) {
            this.fxR.setVisibility(this.paP ? 0 : 8);
        }
        return this;
    }

    public b zx(boolean z) {
        this.paQ = z;
        if (this.aBe != null) {
            this.aBe.setVisibility(this.paQ ? 0 : 8);
        }
        return this;
    }

    public b XG(String str) {
        this.paR = str;
        if (this.fxR != null && this.paR != null) {
            zw(true);
            this.fxR.setText(this.paR);
            if (this.paS) {
                this.fxR.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fxR.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.paW != null) {
                ViewCompat.setBackground(this.fxR, this.paW);
            }
        }
        return this;
    }

    public b XH(String str) {
        this.paT = str;
        if (this.pbj != null && this.paT != null) {
            this.pbj.setText(this.paT);
        }
        return this;
    }

    public b zy(boolean z) {
        this.paU = z;
        if (this.pbj != null) {
            if (z) {
                this.pbj.setVisibility(0);
            } else {
                this.pbj.setVisibility(8);
            }
        }
        return this;
    }

    public b XI(String str) {
        this.gDU = str;
        if (this.dbO != null && this.gDU != null) {
            this.dbO.setText(this.gDU);
            if (this.paV) {
                this.dbO.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.dbO.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.paX != null) {
                ViewCompat.setBackground(this.dbO, this.paX);
            }
        }
        return this;
    }

    public b PE(@ColorInt int i) {
        this.paG = i;
        if (this.dbO != null) {
            if (this.paG != -1) {
                this.dbO.setTextColor(this.paG);
            } else if (paF != -1) {
                this.dbO.setTextColor(paF);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.paX = drawable;
        if (this.dbO != null) {
            ViewCompat.setBackground(this.dbO, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.pbl = aVar;
        return this;
    }

    public b b(a aVar) {
        this.pbm = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dBq.startAnimation(this.paH);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        zz(true);
    }

    public void eqR() {
        zz(false);
    }

    private void zz(boolean z) {
        this.pbo = z;
        this.dbO.startAnimation(this.paJ);
        this.dBq.startAnimation(this.paI);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.pbl != null) {
                this.pbl.onClick(this);
            } else {
                eqR();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.pbm != null) {
                this.pbm.onClick(this);
            } else {
                eqR();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.pbn != null) {
                this.pbn.onClick(this);
            } else {
                eqR();
            }
        }
    }

    public b XJ(String str) {
        this.paY = str;
        if (this.paO != null && this.paY != null) {
            this.paO.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fxR != null && this.dbO != null) {
            if (this.fxR.getVisibility() == 0 && this.dbO.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fxR.getVisibility() == 0) {
                ViewCompat.setBackground(this.fxR, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.dbO.getVisibility() == 0) {
                ViewCompat.setBackground(this.dbO, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
