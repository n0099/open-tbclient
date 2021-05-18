package d.a.j0.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes3.dex */
public class g extends Dialog implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f48697e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.a.f f48698f;

    /* renamed from: g  reason: collision with root package name */
    public float f48699g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f48700h;

    /* renamed from: i  reason: collision with root package name */
    public RoundRelativeLayout f48701i;
    public View j;
    public ImageView k;
    public ImageView l;
    public Drawable m;

    public g(d.a.c.a.f fVar) {
        super(fVar.getPageActivity(), 16973835);
        this.f48699g = 0.33f;
        this.f48698f = fVar;
        this.f48697e = fVar.getPageActivity();
    }

    public void a() {
        d.a.c.e.m.g.b(this, this.f48698f);
    }

    public void b(Drawable drawable) {
        this.m = drawable;
    }

    public void c(ViewGroup viewGroup) {
        this.j = viewGroup;
    }

    public void d() {
        if (isShowing()) {
            d.a.c.e.m.g.b(this, this.f48698f);
        }
        d.a.c.e.m.g.j(this, this.f48698f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.img_btn_close) {
            a();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_card_main);
        Display defaultDisplay = ((WindowManager) this.f48697e.getSystemService("window")).getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        attributes.height = defaultDisplay.getHeight();
        getWindow().setAttributes(attributes);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setDimAmount(this.f48699g);
        getWindow().setGravity(80);
        getWindow().setWindowAnimations(0);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f48700h = (ViewGroup) findViewById(R.id.card_root_layout);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
        this.f48701i = roundRelativeLayout;
        roundRelativeLayout.setAllCornerRound(d.a.c.e.m.b.c(TbadkCoreApplication.getInst().getString(R.string.J_X06), 31.0f));
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = -1;
            layoutParams.width = -1;
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.f48701i.addView(this.j, layoutParams);
        ImageView imageView = (ImageView) findViewById(R.id.img_bg);
        this.k = imageView;
        imageView.setImageDrawable(this.m);
        ImageView imageView2 = (ImageView) findViewById(R.id.img_btn_close);
        this.l = imageView2;
        imageView2.setOnClickListener(this);
    }
}
