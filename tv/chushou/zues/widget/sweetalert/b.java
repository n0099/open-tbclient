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
    private static int nSM = -1;
    private TextView aTU;
    private Button cID;
    private View deC;
    private Button eUc;
    private String fVQ;
    private CharSequence mContentText;
    private Context mContext;
    private View mLineView;
    private String mTitleText;
    private TextView mTitleTextView;
    @ColorInt
    private int nSN;
    private AnimationSet nSO;
    private AnimationSet nSP;
    private Animation nSQ;
    private Animation nSR;
    private AnimationSet nSS;
    private AnimationSet nST;
    private Animation nSU;
    private EditText nSV;
    private boolean nSW;
    private boolean nSX;
    private String nSY;
    private boolean nSZ;
    private String nTa;
    private boolean nTb;
    private boolean nTc;
    private Drawable nTd;
    private Drawable nTe;
    private String nTf;
    private int nTg;
    private FrameLayout nTh;
    private FrameLayout nTi;
    private FrameLayout nTj;
    private SuccessTickView nTk;
    private ImageView nTl;
    private View nTm;
    private View nTn;
    private Drawable nTo;
    private ImageView nTp;
    private Button nTq;
    private FrameLayout nTr;
    private a nTs;
    private a nTt;
    private a nTu;
    private boolean nTv;
    private int nTw;

    /* loaded from: classes5.dex */
    public interface a {
        void onClick(b bVar);
    }

    public b(Context context) {
        this(context, 0);
    }

    public b(Context context, int i) {
        super(context, b.h.zues_alert_dialog);
        this.nSN = -1;
        this.nSW = true;
        this.nSZ = true;
        this.nTb = true;
        this.nTc = true;
        this.nTw = 0;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.nTg = i;
        this.nSR = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_frame_in);
        this.nSS = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_error_x_in);
        if (Build.VERSION.SDK_INT <= 10) {
            List<Animation> animations = this.nSS.getAnimations();
            int i2 = 0;
            while (i2 < animations.size() && !(animations.get(i2) instanceof AlphaAnimation)) {
                i2++;
            }
            if (i2 < animations.size()) {
                animations.remove(i2);
            }
        }
        this.nSU = tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_bow_roate);
        this.nST = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_success_mask_layout);
        this.nSO = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_in);
        this.nSP = (AnimationSet) tv.chushou.zues.widget.sweetalert.a.K(getContext(), b.a.zues_sweetalert_modal_out);
        this.nSP.setAnimationListener(new Animation.AnimationListener() { // from class: tv.chushou.zues.widget.sweetalert.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.deC.setVisibility(8);
                b.this.deC.post(new Runnable() { // from class: tv.chushou.zues.widget.sweetalert.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.nTv) {
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
        this.nSQ = new Animation() { // from class: tv.chushou.zues.widget.sweetalert.b.2
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                WindowManager.LayoutParams attributes = b.this.getWindow().getAttributes();
                attributes.alpha = 1.0f - f;
                b.this.getWindow().setAttributes(attributes);
            }
        };
        this.nSQ.setDuration(120L);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.nTg == 6) {
            super.setContentView(b.f.zues_sweetalert_dialog_withinput);
            findViewById(b.e.loading).getLayoutParams().width = tv.chushou.zues.utils.a.gw(this.mContext).x - (this.mContext.getResources().getDimensionPixelSize(b.c.zues_alert_spac_h) * 2);
        } else if (this.nTg == 7) {
            super.setContentView(b.f.zues_sweetalert_dialog_three_btn);
        } else {
            super.setContentView(b.f.zues_sweetalert_dialog);
        }
        this.deC = getWindow().getDecorView().findViewById(16908290);
        this.mTitleTextView = (TextView) findViewById(b.e.title_text);
        this.aTU = (TextView) findViewById(b.e.content_text);
        this.nTh = (FrameLayout) findViewById(b.e.error_frame);
        if (this.nTh != null) {
            this.nTl = (ImageView) this.nTh.findViewById(b.e.error_x);
        }
        this.nTi = (FrameLayout) findViewById(b.e.success_frame);
        this.nTj = (FrameLayout) findViewById(b.e.progress_dialog);
        if (this.nTi != null) {
            this.nTk = (SuccessTickView) this.nTi.findViewById(b.e.success_tick);
            this.nTm = this.nTi.findViewById(b.e.mask_left);
            this.nTn = this.nTi.findViewById(b.e.mask_right);
        }
        this.nTp = (ImageView) findViewById(b.e.custom_image);
        this.nTr = (FrameLayout) findViewById(b.e.warning_frame);
        this.cID = (Button) findViewById(b.e.confirm_button);
        this.eUc = (Button) findViewById(b.e.cancel_button);
        this.mLineView = findViewById(b.e.vertial_view);
        this.nTq = (Button) findViewById(b.e.middle_btn);
        this.nSV = (EditText) findViewById(b.e.et_input);
        this.cID.setOnClickListener(this);
        if (this.eUc != null) {
            this.eUc.setOnClickListener(this);
        }
        if (this.nTq != null) {
            this.nTq.setOnClickListener(this);
        }
        xv(this.nSW);
        xx(this.nTb);
        SC(this.mTitleText);
        x(this.mContentText);
        KZ(this.nTw);
        SD(this.nSY);
        SF(this.fVQ);
        La(this.nSN);
        w(this.nTe);
        SG(this.nTf);
        SE(this.nTa);
        aj(this.nTg, true);
        if (this.nTg == 7) {
            if (this.mTitleTextView != null) {
                this.mTitleTextView.setTextColor(this.mContext.getResources().getColor(b.C0915b.zues_text_color));
            }
            if (this.aTU != null) {
                this.aTU.setTextColor(this.mContext.getResources().getColor(b.C0915b.zues_text_color));
            }
        }
    }

    private void UR() {
        if (this.nTp != null) {
            this.nTp.setVisibility(8);
        }
        if (this.nTh != null) {
            this.nTh.setVisibility(8);
        }
        if (this.nTi != null) {
            this.nTi.setVisibility(8);
        }
        if (this.nTr != null) {
            this.nTr.setVisibility(8);
        }
        if (this.nTj != null) {
            this.nTj.setVisibility(8);
        }
        if (this.cID != null) {
            this.cID.setVisibility(0);
        }
        this.cID.setBackgroundResource(b.d.zues_sweetalert_kas_button_background);
        if (this.nTh != null) {
            this.nTh.clearAnimation();
        }
        if (this.nTl != null) {
            this.nTl.clearAnimation();
        }
        if (this.nTk != null) {
            this.nTk.clearAnimation();
        }
        if (this.nTm != null) {
            this.nTm.clearAnimation();
        }
        if (this.nTn != null) {
            this.nTn.clearAnimation();
        }
    }

    private void playAnimation() {
        if (this.nTg == 1) {
            this.nTh.startAnimation(this.nSR);
            this.nTl.startAnimation(this.nSS);
        } else if (this.nTg == 2) {
            this.nTk.dSB();
            this.nTn.startAnimation(this.nSU);
        }
    }

    private void aj(int i, boolean z) {
        this.nTg = i;
        if (this.deC != null) {
            if (!z) {
                UR();
            }
            switch (this.nTg) {
                case 1:
                    this.nTh.setVisibility(0);
                    break;
                case 2:
                    this.nTi.setVisibility(0);
                    this.nTm.startAnimation(this.nST.getAnimations().get(0));
                    this.nTn.startAnimation(this.nST.getAnimations().get(1));
                    break;
                case 3:
                    this.cID.setBackgroundResource(b.d.zues_sweetalert_red_button_background);
                    this.nTr.setVisibility(0);
                    break;
                case 4:
                    v(this.nTo);
                    break;
                case 5:
                    this.nTj.setVisibility(0);
                    this.cID.setVisibility(8);
                    break;
            }
            if (!z) {
                playAnimation();
            }
        }
    }

    public b SC(String str) {
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

    public b bf(String str, boolean z) {
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
        this.nTo = drawable;
        if (this.nTp != null && this.nTo != null) {
            this.nTp.setVisibility(0);
            this.nTp.setImageDrawable(this.nTo);
        }
        return this;
    }

    public b x(CharSequence charSequence) {
        this.mContentText = charSequence;
        if (this.aTU != null) {
            if (this.mContentText != null && this.mContentText.length() > 0) {
                xw(true);
                this.aTU.setText(this.mContentText);
            } else {
                xw(false);
            }
        }
        return this;
    }

    public b KZ(int i) {
        this.nTw = i;
        if (this.aTU != null && this.nTw > 0) {
            this.aTU.setTextSize(2, this.nTw);
        }
        return this;
    }

    public b xv(boolean z) {
        this.nSW = z;
        if (this.eUc != null) {
            this.eUc.setVisibility(this.nSW ? 0 : 8);
        }
        return this;
    }

    public b xw(boolean z) {
        this.nSX = z;
        if (this.aTU != null) {
            this.aTU.setVisibility(this.nSX ? 0 : 8);
        }
        return this;
    }

    public b SD(String str) {
        this.nSY = str;
        if (this.eUc != null && this.nSY != null) {
            xv(true);
            this.eUc.setText(this.nSY);
            if (this.nSZ) {
                this.eUc.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.eUc.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nTd != null) {
                ViewCompat.setBackground(this.eUc, this.nTd);
            }
        }
        return this;
    }

    public b SE(String str) {
        this.nTa = str;
        if (this.nTq != null && this.nTa != null) {
            this.nTq.setText(this.nTa);
        }
        return this;
    }

    public b xx(boolean z) {
        this.nTb = z;
        if (this.nTq != null) {
            if (z) {
                this.nTq.setVisibility(0);
            } else {
                this.nTq.setVisibility(8);
            }
        }
        return this;
    }

    public b SF(String str) {
        this.fVQ = str;
        if (this.cID != null && this.fVQ != null) {
            this.cID.setText(this.fVQ);
            if (this.nTc) {
                this.cID.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                this.cID.setTypeface(Typeface.defaultFromStyle(0));
            }
            if (this.nTe != null) {
                ViewCompat.setBackground(this.cID, this.nTe);
            }
        }
        return this;
    }

    public b La(@ColorInt int i) {
        this.nSN = i;
        if (this.cID != null) {
            if (this.nSN != -1) {
                this.cID.setTextColor(this.nSN);
            } else if (nSM != -1) {
                this.cID.setTextColor(nSM);
            }
        }
        return this;
    }

    public b w(Drawable drawable) {
        this.nTe = drawable;
        if (this.cID != null) {
            ViewCompat.setBackground(this.cID, drawable);
        }
        return this;
    }

    public b a(a aVar) {
        this.nTs = aVar;
        return this;
    }

    public b b(a aVar) {
        this.nTt = aVar;
        return this;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.deC.startAnimation(this.nSO);
        playAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        xy(true);
    }

    public void dSC() {
        xy(false);
    }

    private void xy(boolean z) {
        this.nTv = z;
        this.cID.startAnimation(this.nSQ);
        this.deC.startAnimation(this.nSP);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b.e.cancel_button) {
            if (this.nTs != null) {
                this.nTs.onClick(this);
            } else {
                dSC();
            }
        } else if (view.getId() == b.e.confirm_button) {
            if (this.nTt != null) {
                this.nTt.onClick(this);
            } else {
                dSC();
            }
        } else if (view.getId() == b.e.middle_btn) {
            if (this.nTu != null) {
                this.nTu.onClick(this);
            } else {
                dSC();
            }
        }
    }

    public b SG(String str) {
        this.nTf = str;
        if (this.nSV != null && this.nTf != null) {
            this.nSV.setHint(str);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.eUc != null && this.cID != null) {
            if (this.eUc.getVisibility() == 0 && this.cID.getVisibility() == 0) {
                if (this.mLineView != null) {
                    this.mLineView.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.mLineView != null) {
                this.mLineView.setVisibility(8);
            }
            if (this.eUc.getVisibility() == 0) {
                ViewCompat.setBackground(this.eUc, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            } else if (this.cID.getVisibility() == 0) {
                ViewCompat.setBackground(this.cID, ContextCompat.getDrawable(this.mContext, b.d.zues_bg_onebt_selector));
            }
        }
    }
}
