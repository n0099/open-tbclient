package d.a.o0.g2;

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
    public Context f58982e;

    /* renamed from: f  reason: collision with root package name */
    public View f58983f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f58984g;

    /* renamed from: h  reason: collision with root package name */
    public float f58985h;

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
        this.f58985h = 0.33f;
        this.f58982e = context;
        this.f58983f = view;
    }

    public void a(float f2) {
        this.f58985h = f2;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.person_info_more_dialog);
        Display defaultDisplay = ((WindowManager) this.f58982e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f58985h);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(R.style.pb_more_pop_anim);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_view);
        this.f58984g = linearLayout;
        linearLayout.setOnClickListener(new a());
        if (this.f58983f == null) {
            return;
        }
        this.f58984g.removeAllViews();
        if (this.f58983f.getParent() != null) {
            if (this.f58983f.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f58983f.getParent()).removeView(this.f58983f);
                this.f58984g.addView(this.f58983f);
                return;
            }
            return;
        }
        this.f58984g.addView(this.f58983f);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f58983f = view;
        LinearLayout linearLayout = this.f58984g;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if (this.f58983f.getParent() != null) {
                if (this.f58983f.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.f58983f.getParent()).removeView(this.f58983f);
                    this.f58984g.addView(this.f58983f);
                    return;
                }
                return;
            }
            this.f58984g.addView(this.f58983f);
        }
    }
}
