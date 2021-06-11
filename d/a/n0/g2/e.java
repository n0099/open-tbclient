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
    public Context f58857e;

    /* renamed from: f  reason: collision with root package name */
    public View f58858f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f58859g;

    /* renamed from: h  reason: collision with root package name */
    public float f58860h;

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
        this.f58860h = 0.33f;
        this.f58857e = context;
        this.f58858f = view;
    }

    public void a(float f2) {
        this.f58860h = f2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.f58857e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f58860h);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f58859g = linearLayout;
        linearLayout.setOnClickListener(new a());
        if (this.f58858f == null) {
            return;
        }
        this.f58859g.removeAllViews();
        if (this.f58858f.getParent() != null) {
            if (this.f58858f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f58858f.getParent()).removeView(this.f58858f);
                this.f58859g.addView(this.f58858f);
                return;
            }
            return;
        }
        this.f58859g.addView(this.f58858f);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f58858f = view;
        LinearLayout linearLayout = this.f58859g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (this.f58858f.getParent() != null) {
                if (this.f58858f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f58858f.getParent()).removeView(this.f58858f);
                    this.f58859g.addView(this.f58858f);
                    return;
                }
                return;
            }
            this.f58859g.addView(this.f58858f);
        }
    }
}
