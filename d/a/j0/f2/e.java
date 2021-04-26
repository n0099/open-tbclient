package d.a.j0.f2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends Dialog {

    /* renamed from: e  reason: collision with root package name */
    public Context f54273e;

    /* renamed from: f  reason: collision with root package name */
    public View f54274f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f54275g;

    /* renamed from: h  reason: collision with root package name */
    public float f54276h;

    /* loaded from: classes4.dex */
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
        this.f54276h = 0.33f;
        this.f54273e = context;
        this.f54274f = view;
    }

    public void a(float f2) {
        this.f54276h = f2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.f54273e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f54276h);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f54275g = linearLayout;
        linearLayout.setOnClickListener(new a());
        if (this.f54274f == null) {
            return;
        }
        this.f54275g.removeAllViews();
        if (this.f54274f.getParent() != null) {
            if (this.f54274f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f54274f.getParent()).removeView(this.f54274f);
                this.f54275g.addView(this.f54274f);
                return;
            }
            return;
        }
        this.f54275g.addView(this.f54274f);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f54274f = view;
        LinearLayout linearLayout = this.f54275g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (this.f54274f.getParent() != null) {
                if (this.f54274f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f54274f.getParent()).removeView(this.f54274f);
                    this.f54275g.addView(this.f54274f);
                    return;
                }
                return;
            }
            this.f54275g.addView(this.f54274f);
        }
    }
}
