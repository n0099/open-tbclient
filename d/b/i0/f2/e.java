package d.b.i0.f2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public Context f55965e;

    /* renamed from: f  reason: collision with root package name */
    public View f55966f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f55967g;

    /* renamed from: h  reason: collision with root package name */
    public float f55968h;

    /* loaded from: classes3.dex */
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
        this.f55968h = 0.33f;
        this.f55965e = context;
        this.f55966f = view;
    }

    public void a(float f2) {
        this.f55968h = f2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.f55965e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f55968h);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f55967g = linearLayout;
        linearLayout.setOnClickListener(new a());
        if (this.f55966f == null) {
            return;
        }
        this.f55967g.removeAllViews();
        if (this.f55966f.getParent() != null) {
            if (this.f55966f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f55966f.getParent()).removeView(this.f55966f);
                this.f55967g.addView(this.f55966f);
                return;
            }
            return;
        }
        this.f55967g.addView(this.f55966f);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f55966f = view;
        LinearLayout linearLayout = this.f55967g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (this.f55966f.getParent() != null) {
                if (this.f55966f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f55966f.getParent()).removeView(this.f55966f);
                    this.f55967g.addView(this.f55966f);
                    return;
                }
                return;
            }
            this.f55967g.addView(this.f55966f);
        }
    }
}
