package d.b.j0.f2;

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
    public Context f56386e;

    /* renamed from: f  reason: collision with root package name */
    public View f56387f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f56388g;

    /* renamed from: h  reason: collision with root package name */
    public float f56389h;

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
        this.f56389h = 0.33f;
        this.f56386e = context;
        this.f56387f = view;
    }

    public void a(float f2) {
        this.f56389h = f2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.f56386e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f56389h);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f56388g = linearLayout;
        linearLayout.setOnClickListener(new a());
        if (this.f56387f == null) {
            return;
        }
        this.f56388g.removeAllViews();
        if (this.f56387f.getParent() != null) {
            if (this.f56387f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f56387f.getParent()).removeView(this.f56387f);
                this.f56388g.addView(this.f56387f);
                return;
            }
            return;
        }
        this.f56388g.addView(this.f56387f);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f56387f = view;
        LinearLayout linearLayout = this.f56388g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (this.f56387f.getParent() != null) {
                if (this.f56387f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f56387f.getParent()).removeView(this.f56387f);
                    this.f56388g.addView(this.f56387f);
                    return;
                }
                return;
            }
            this.f56388g.addView(this.f56387f);
        }
    }
}
