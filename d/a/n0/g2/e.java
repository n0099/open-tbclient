package d.a.n0.g2;

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
    public Context f55168e;

    /* renamed from: f  reason: collision with root package name */
    public View f55169f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f55170g;

    /* renamed from: h  reason: collision with root package name */
    public float f55171h;

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
        this.f55171h = 0.33f;
        this.f55168e = context;
        this.f55169f = view;
    }

    public void a(float f2) {
        this.f55171h = f2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.f55168e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f55171h);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f55170g = linearLayout;
        linearLayout.setOnClickListener(new a());
        if (this.f55169f == null) {
            return;
        }
        this.f55170g.removeAllViews();
        if (this.f55169f.getParent() != null) {
            if (this.f55169f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f55169f.getParent()).removeView(this.f55169f);
                this.f55170g.addView(this.f55169f);
                return;
            }
            return;
        }
        this.f55170g.addView(this.f55169f);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f55169f = view;
        LinearLayout linearLayout = this.f55170g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (this.f55169f.getParent() != null) {
                if (this.f55169f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f55169f.getParent()).removeView(this.f55169f);
                    this.f55170g.addView(this.f55169f);
                    return;
                }
                return;
            }
            this.f55170g.addView(this.f55169f);
        }
    }
}
