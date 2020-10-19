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
    private static int pqa = -1;
    private TextView aEj;
    private View dNr;
    private Button dnX;
    private Button fKa;
    private String gSc;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    private View pqA;
    private View pqB;
    private Drawable pqC;
    private ImageView pqD;
    private Button pqE;
    private FrameLayout pqF;
    private a pqG;
    private a pqH;
    private a pqI;
    private boolean pqJ;
    private int pqK;
    @ColorInt
    private int pqb;
    private AnimationSet pqc;
    private AnimationSet pqd;
    private Animation pqe;
    private Animation pqf;
    private AnimationSet pqg;
    private AnimationSet pqh;
    private Animation pqi;
    private EditText pqj;
    private boolean pqk;
    private boolean pql;
    private String pqm;
    private boolean pqn;
    private String pqo;
    private boolean pqp;
    private boolean pqq;
    private Drawable pqr;
    private Drawable pqs;
    private String pqt;
    private int pqu;
    private FrameLayout pqv;
    private FrameLayout pqw;
    private FrameLayout pqx;
    private SuccessTickView pqy;
    private ImageView pqz;

    /* loaded from: classes6.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.pqb = -1;
        this.pqk = true;
        this.pqn = true;
        this.pqp = true;
        this.pqq = true;
        this.pqK = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.pqu = i;
        this.pqf = tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.pqg = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.pqg.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.pqi = tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.pqh = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.pqc = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_modal_in);
        this.pqd = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.O(getContext(), b.a.zues_sweetalert_modal_out);
        this.pqd.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.dNr.setVisibility(8);
                b.this.dNr.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.pqJ) {
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
        this.pqe = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.pqe.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.pqu == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.hk(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.pqu == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.dNr = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aEj = (TextView) findViewById(b.e.content_text);
        this.pqv = (FrameLayout) findViewById(b.e.error_frame);
        if (this.pqv != null) {
            this.pqz = (ImageView) this.pqv.findViewById(b.e.error_x);
        }
        this.pqw = (FrameLayout) findViewById(b.e.success_frame);
        this.pqx = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.pqw != null) {
            this.pqy = (SuccessTickView) this.pqw.findViewById(b.e.success_tick);
            this.pqA = this.pqw.findViewById(b.e.mask_left);
            this.pqB = this.pqw.findViewById(b.e.mask_right);
        }
        this.pqD = (ImageView) findViewById(b.e.custom_image);
        this.pqF = (FrameLayout) findViewById(b.e.warning_frame);
        this.dnX = (Button) findViewById(b.e.confirm_button);
        this.fKa = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.pqE = (Button) findViewById(b.e.middle_btn);
        this.pqj = (EditText) findViewById(b.e.et_input);
        this.dnX.setOnClickListener(this);
        if (this.fKa != null) {
            this.fKa.setOnClickListener(this);
        }
        if (this.pqE != null) {
            this.pqE.setOnClickListener(this);
        }
        Ad(this.pqk);
        Af(this.pqp);
        Yt(this.mTitleText);
        A(this.mContentText);
        Qj(this.pqK);
        Yu(this.pqm);
        Yw(this.gSc);
        Qk(this.pqb);
        w(this.pqs);
        Yx(this.pqt);
        Yv(this.pqo);
        ap(this.pqu, true);
        if (this.pqu == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C1023b.zues_text_color));
            }
            if (this.aEj != null) {
                this.aEj.setTextColor(this.mContext.getResources().getColor(b.C1023b.zues_text_color));
            }
        }
    }

    private void age() {
        if (this.pqD != null) {
            this.pqD.setVisibility(8);
        }
        if (this.pqv != null) {
            this.pqv.setVisibility(8);
        }
        if (this.pqw != null) {
            this.pqw.setVisibility(8);
        }
        if (this.pqF != null) {
            this.pqF.setVisibility(8);
        }
        if (this.pqx != null) {
            this.pqx.setVisibility(8);
        }
        if (this.dnX != null) {
            this.dnX.setVisibility(0);
        }
        this.dnX.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.pqv != null) {
            this.pqv.clearAnimation();
        }
        if (this.pqz != null) {
            this.pqz.clearAnimation();
        }
        if (this.pqy != null) {
            this.pqy.clearAnimation();
        }
        if (this.pqA != null) {
            this.pqA.clearAnimation();
        }
        if (this.pqB != null) {
            this.pqB.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.pqu == 1) {
            this.pqv.startAnimation(this.pqf);
            this.pqz.startAnimation(this.pqg);
        } else if (this.pqu == 2) {
            this.pqy.euB();
            this.pqB.startAnimation(this.pqi);
        }
    }

    private void ap(int i, boolean z) {
        this.pqu = i;
        if (this.dNr != null) {
            if (!z) {
                age();
            }
            switch (this.pqu) {
                case 1:
                    this.pqv.setVisibility(0);
                    break;
                case 2:
                    this.pqw.setVisibility(0);
                    this.pqA.startAnimation(this.pqh.getAnimations().get(0));
                    this.pqB.startAnimation(this.pqh.getAnimations().get(1));
                    break;
                case 3:
                    this.dnX.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.pqF.setVisibility(0);
                    break;
                case 4:
                    v(this.pqC);
                    break;
                case 5:
                    this.pqx.setVisibility(0);
                    this.dnX.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b Yt(String str) {
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

    public b bn(String str, boolean z) {
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
        this.pqC = drawable;
        if (this.pqD != null && this.pqC != null) {
            this.pqD.setVisibility(0);
            this.pqD.setImageDrawable(this.pqC);
        }
        return this;
    }

    public b A(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aEj != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                Ae(true);
                this.aEj.setText(this.mContentText);
            } else {
                Ae(false);
            }
        }
        return this;
    }

    public b Qj(int i) {
        this.pqK = i;
        if (this.aEj != null && this.pqK > 0) {
            this.aEj.setTextSize(2, this.pqK);
        }
        return this;
    }

    public b Ad(boolean z) {
        this.pqk = z;
        if (this.fKa != null) {
            this.fKa.setVisibility(this.pqk ? 0 : 8);
        }
        return this;
    }

    public b Ae(boolean z) {
        this.pql = z;
        if (this.aEj != null) {
            this.aEj.setVisibility(this.pql ? 0 : 8);
        }
        return this;
    }

    public b Yu(String str) {
        this.pqm = str;
        if (this.fKa != null && this.pqm != null) {
            Ad(true);
            this.fKa.setText(this.pqm);
            if (this.pqn) {
                this.fKa.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.fKa.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.pqr != null) {
                ViewCompat.setBackground(this.fKa, this.pqr);
            }
        }
        return this;
    }

    public b Yv(String str) {
        this.pqo = str;
        if (this.pqE != null && this.pqo != null) {
            this.pqE.setText(this.pqo);
        }
        return this;
    }

    public b Af(boolean z) {
        this.pqp = z;
        if (this.pqE != null) {
            if (z) {
                this.pqE.setVisibility(0);
            } else {
                this.pqE.setVisibility(8);
            }
        }
        return this;
    }

    public b Yw(String str) {
        this.gSc = str;
        if (this.dnX != null && this.gSc != null) {
            this.dnX.setText(this.gSc);
            if (this.pqq) {
                this.dnX.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.dnX.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.pqs != null) {
                ViewCompat.setBackground(this.dnX, this.pqs);
            }
        }
        return this;
    }

    public b Qk(@ColorInt int i) {
        this.pqb = i;
        if (this.dnX != null) {
            if (this.pqb != -1) {
                this.dnX.setTextColor(this.pqb);
            } else if (pqa != -1) {
                this.dnX.setTextColor(pqa);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.pqs = drawable;
        if (this.dnX != null) {
            ViewCompat.setBackground(this.dnX, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.pqG = aVar;
        return this;
    }

    public b b(a aVar) {
        this.pqH = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.dNr.startAnimation(this.pqc);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        Ag(true);
    }

    public void euC() {
        Ag(false);
    }

    private void Ag(boolean z) {
        this.pqJ = z;
        this.dnX.startAnimation(this.pqe);
        this.dNr.startAnimation(this.pqd);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.pqG != null) {
                this.pqG.onClick(this);
            } else {
                euC();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.pqH != null) {
                this.pqH.onClick(this);
            } else {
                euC();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.pqI != null) {
                this.pqI.onClick(this);
            } else {
                euC();
            }
        }
    }

    public b Yx(String str) {
        this.pqt = str;
        if (this.pqj != null && this.pqt != null) {
            this.pqj.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fKa != null && this.dnX != null) {
            if (this.fKa.getVisibility() == 0 && this.dnX.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.fKa.getVisibility() == 0) {
                ViewCompat.setBackground(this.fKa, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.dnX.getVisibility() == 0) {
                ViewCompat.setBackground(this.dnX, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
