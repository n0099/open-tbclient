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
    private static int qhl = -1;
    private TextView aEr;
    private View dVO;
    private Button dwy;
    private Button fSu;
    private String hdP;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    private AnimationSet orA;
    private boolean qhA;
    private Drawable qhB;
    private Drawable qhC;
    private String qhD;
    private int qhE;
    private FrameLayout qhF;
    private FrameLayout qhG;
    private FrameLayout qhH;
    private SuccessTickView qhI;
    private ImageView qhJ;
    private View qhK;
    private View qhL;
    private Drawable qhM;
    private ImageView qhN;
    private Button qhO;
    private FrameLayout qhP;
    private a qhQ;
    private a qhR;
    private a qhS;
    private boolean qhT;
    private int qhU;
    @ColorInt
    private int qhm;
    private AnimationSet qhn;
    private Animation qho;
    private Animation qhp;
    private AnimationSet qhq;
    private AnimationSet qhr;
    private Animation qhs;
    private EditText qht;
    private boolean qhu;
    private boolean qhv;
    private String qhw;
    private boolean qhx;
    private String qhy;
    private boolean qhz;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.qhm = -1;
        this.qhu = true;
        this.qhx = true;
        this.qhz = true;
        this.qhA = true;
        this.qhU = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.qhE = i;
        this.qhp = tv.chushou.zues.widget.sweetalert.a.I(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.qhq = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.I(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.qhq.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.qhs = tv.chushou.zues.widget.sweetalert.a.I(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.qhr = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.I(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.qhn = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.I(getContext(), b.a.zues_sweetalert_modal_in);
        this.orA = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.I(getContext(), b.a.zues_sweetalert_modal_out);
        this.orA.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dVO.setVisibility(8);
                b.this.dVO.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.qhT) {
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
        this.qho = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.qho.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.qhE == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hE(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.qhE == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dVO = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aEr = (TextView) findViewById(b.e.content_text);
        this.qhF = (FrameLayout) findViewById(b.e.error_frame);
        if (this.qhF != null) {
            this.qhJ = (ImageView) this.qhF.findViewById(b.e.error_x);
        }
        this.qhG = (FrameLayout) findViewById(b.e.success_frame);
        this.qhH = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.qhG != null) {
            this.qhI = (SuccessTickView) this.qhG.findViewById(b.e.success_tick);
            this.qhK = this.qhG.findViewById(b.e.mask_left);
            this.qhL = this.qhG.findViewById(b.e.mask_right);
        }
        this.qhN = (ImageView) findViewById(b.e.custom_image);
        this.qhP = (FrameLayout) findViewById(b.e.warning_frame);
        this.dwy = (Button) findViewById(b.e.confirm_button);
        this.fSu = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.qhO = (Button) findViewById(b.e.middle_btn);
        this.qht = (EditText) findViewById(b.e.et_input);
        this.dwy.setOnClickListener(this);
        if (this.fSu != null) {
            this.fSu.setOnClickListener(this);
        }
        if (this.qhO != null) {
            this.qhO.setOnClickListener(this);
        }
        Bk(this.qhu);
        Bm(this.qhz);
        aag(this.mTitleText);
        D(this.mContentText);
        Sa(this.qhU);
        aah(this.qhw);
        aaj(this.hdP);
        Sb(this.qhm);
        B(this.qhC);
        aak(this.qhD);
        aai(this.qhy);
        as(this.qhE, true);
        if (this.qhE == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C1095b.zues_text_color));
            }
            if (this.aEr != null) {
                this.aEr.setTextColor(this.mContext.getResources().getColor(b.C1095b.zues_text_color));
            }
        }
    }

    private void ahY() {
        if (this.qhN != null) {
            this.qhN.setVisibility(8);
        }
        if (this.qhF != null) {
            this.qhF.setVisibility(8);
        }
        if (this.qhG != null) {
            this.qhG.setVisibility(8);
        }
        if (this.qhP != null) {
            this.qhP.setVisibility(8);
        }
        if (this.qhH != null) {
            this.qhH.setVisibility(8);
        }
        if (this.dwy != null) {
            this.dwy.setVisibility(0);
        }
        this.dwy.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.qhF != null) {
            this.qhF.clearAnimation();
        }
        if (this.qhJ != null) {
            this.qhJ.clearAnimation();
        }
        if (this.qhI != null) {
            this.qhI.clearAnimation();
        }
        if (this.qhK != null) {
            this.qhK.clearAnimation();
        }
        if (this.qhL != null) {
            this.qhL.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.qhE == 1) {
            this.qhF.startAnimation(this.qhp);
            this.qhJ.startAnimation(this.qhq);
        } else if (this.qhE == 2) {
            this.qhI.eEz();
            this.qhL.startAnimation(this.qhs);
        }
    }

    private void as(int i, boolean z) {
        this.qhE = i;
        if (this.dVO != null) {
            if (!z) {
                ahY();
            }
            switch (this.qhE) {
                case 1:
                    this.qhF.setVisibility(0);
                    break;
                case 2:
                    this.qhG.setVisibility(0);
                    this.qhK.startAnimation(this.qhr.getAnimations().get(0));
                    this.qhL.startAnimation(this.qhr.getAnimations().get(1));
                    break;
                case 3:
                    this.dwy.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.qhP.setVisibility(0);
                    break;
                case 4:
                    A(this.qhM);
                    break;
                case 5:
                    this.qhH.setVisibility(0);
                    this.dwy.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b aag(String str) {
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

    public b bt(String str, boolean z) {
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
        this.qhM = drawable;
        if (this.qhN != null && this.qhM != null) {
            this.qhN.setVisibility(0);
            this.qhN.setImageDrawable(this.qhM);
        }
        return this;
    }

    public b D(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aEr != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                Bl(true);
                this.aEr.setText(this.mContentText);
            } else {
                Bl(false);
            }
        }
        return this;
    }

    public b Sa(int i) {
        this.qhU = i;
        if (this.aEr != null && this.qhU > 0) {
            this.aEr.setTextSize(2, this.qhU);
        }
        return this;
    }

    public b Bk(boolean z) {
        this.qhu = z;
        if (this.fSu != null) {
            this.fSu.setVisibility(this.qhu ? 0 : 8);
        }
        return this;
    }

    public b Bl(boolean z) {
        this.qhv = z;
        if (this.aEr != null) {
            this.aEr.setVisibility(this.qhv ? 0 : 8);
        }
        return this;
    }

    public b aah(String str) {
        this.qhw = str;
        if (this.fSu != null && this.qhw != null) {
            Bk(true);
            this.fSu.setText(this.qhw);
            if (this.qhx) {
                this.fSu.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fSu.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.qhB != null) {
                ViewCompat.setBackground(this.fSu, this.qhB);
            }
        }
        return this;
    }

    public b aai(String str) {
        this.qhy = str;
        if (this.qhO != null && this.qhy != null) {
            this.qhO.setText(this.qhy);
        }
        return this;
    }

    public b Bm(boolean z) {
        this.qhz = z;
        if (this.qhO != null) {
            if (z) {
                this.qhO.setVisibility(0);
            } else {
                this.qhO.setVisibility(8);
            }
        }
        return this;
    }

    public b aaj(String str) {
        this.hdP = str;
        if (this.dwy != null && this.hdP != null) {
            this.dwy.setText(this.hdP);
            if (this.qhA) {
                this.dwy.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.dwy.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.qhC != null) {
                ViewCompat.setBackground(this.dwy, this.qhC);
            }
        }
        return this;
    }

    public b Sb(@ColorInt int i) {
        this.qhm = i;
        if (this.dwy != null) {
            if (this.qhm != -1) {
                this.dwy.setTextColor(this.qhm);
            } else if (qhl != -1) {
                this.dwy.setTextColor(qhl);
            }
        }
        return this;
    }

    public b B(Drawable drawable) {
        this.qhC = drawable;
        if (this.dwy != null) {
            ViewCompat.setBackground(this.dwy, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.qhQ = aVar;
        return this;
    }

    public b b(a aVar) {
        this.qhR = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dVO.startAnimation(this.qhn);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        zF(true);
    }

    public void eEA() {
        zF(false);
    }

    private void zF(boolean z) {
        this.qhT = z;
        this.dwy.startAnimation(this.qho);
        this.dVO.startAnimation(this.orA);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.qhQ != null) {
                this.qhQ.onClick(this);
            } else {
                eEA();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.qhR != null) {
                this.qhR.onClick(this);
            } else {
                eEA();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.qhS != null) {
                this.qhS.onClick(this);
            } else {
                eEA();
            }
        }
    }

    public b aak(String str) {
        this.qhD = str;
        if (this.qht != null && this.qhD != null) {
            this.qht.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fSu != null && this.dwy != null) {
            if (this.fSu.getVisibility() == 0 && this.dwy.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fSu.getVisibility() == 0) {
                ViewCompat.setBackground(this.fSu, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.dwy.getVisibility() == 0) {
                ViewCompat.setBackground(this.dwy, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
