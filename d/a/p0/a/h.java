package d.a.p0.a;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51848e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.d.a.f f51849f;

    /* renamed from: g  reason: collision with root package name */
    public float f51850g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f51851h;

    /* renamed from: i  reason: collision with root package name */
    public RoundRelativeLayout f51852i;
    public View j;
    public ImageView k;
    public ImageView l;
    public Drawable m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.d.a.f fVar) {
        super(fVar.getPageActivity(), 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51850g = 0.33f;
        this.f51849f = fVar;
        this.f51848e = fVar.getPageActivity();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.d.e.m.g.b(this, this.f51849f);
        }
    }

    public void b(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
            this.m = drawable;
        }
    }

    public void c(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            this.j = viewGroup;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (isShowing()) {
                d.a.d.e.m.g.b(this, this.f51849f);
            }
            d.a.d.e.m.g.j(this, this.f51849f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view.getId() == R.id.img_btn_close) {
            a();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.dialog_card_main);
            Display defaultDisplay = ((WindowManager) this.f51848e.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            getWindow().setDimAmount(this.f51850g);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(0);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            this.f51851h = (ViewGroup) findViewById(R.id.card_root_layout);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.round_corner_layout);
            this.f51852i = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(d.a.d.e.m.b.c(TbadkCoreApplication.getInst().getString(R.string.J_X06), 31.0f));
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
                layoutParams.width = -1;
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            this.f51852i.addView(this.j, layoutParams);
            ImageView imageView = (ImageView) findViewById(R.id.img_bg);
            this.k = imageView;
            imageView.setImageDrawable(this.m);
            ImageView imageView2 = (ImageView) findViewById(R.id.img_btn_close);
            this.l = imageView2;
            imageView2.setOnClickListener(this);
        }
    }
}
