package d.a.k0.f2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class e extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public Context f54980e;

    /* renamed from: f  reason: collision with root package name */
    public View f54981f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f54982g;

    /* renamed from: h  reason: collision with root package name */
    public float f54983h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.dismiss();
        }
    }

    public e(Context context, View view) {
        super(context, 16973835);
        this.f54983h = 0.33f;
        this.f54980e = context;
        this.f54981f = view;
    }

    public void a(float f2) {
        this.f54983h = f2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.f54980e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f54983h);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f54982g = linearLayout;
        linearLayout.setOnClickListener(new a());
        if (this.f54981f == null) {
            return;
        }
        this.f54982g.removeAllViews();
        if (this.f54981f.getParent() != null) {
            if (this.f54981f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f54981f.getParent()).removeView(this.f54981f);
                this.f54982g.addView(this.f54981f);
                return;
            }
            return;
        }
        this.f54982g.addView(this.f54981f);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f54981f = view;
        LinearLayout linearLayout = this.f54982g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (this.f54981f.getParent() != null) {
                if (this.f54981f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f54981f.getParent()).removeView(this.f54981f);
                    this.f54982g.addView(this.f54981f);
                    return;
                }
                return;
            }
            this.f54982g.addView(this.f54981f);
        }
    }
}
