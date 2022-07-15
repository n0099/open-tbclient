package com.repackage;

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
/* loaded from: classes6.dex */
public class oi4 extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public d9 b;
    public float c;
    public ViewGroup d;
    public RoundRelativeLayout e;
    public View f;
    public ImageView g;
    public ImageView h;
    public Drawable i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oi4(d9 d9Var) {
        super(d9Var.getPageActivity(), 16973835);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0.33f;
        this.b = d9Var;
        this.a = d9Var.getPageActivity();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            sg.b(this, this.b);
        }
    }

    public void b(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
            this.i = drawable;
        }
    }

    public void c(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            this.f = viewGroup;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (isShowing()) {
                sg.b(this, this.b);
            }
            sg.j(this, this.b);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f090e6f) {
            a();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(R.layout.obfuscated_res_0x7f0d0221);
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = defaultDisplay.getWidth();
            attributes.height = defaultDisplay.getHeight();
            getWindow().setAttributes(attributes);
            getWindow().setBackgroundDrawableResource(R.color.transparent);
            getWindow().setDimAmount(this.c);
            getWindow().setGravity(80);
            getWindow().setWindowAnimations(0);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            this.d = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090552);
            RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b7c);
            this.e = roundRelativeLayout;
            roundRelativeLayout.setAllCornerRound(ng.d(TbadkCoreApplication.getInst().getString(R.string.J_X06), 31.0f));
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
                layoutParams.width = -1;
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            this.e.addView(this.f, layoutParams);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e6c);
            this.g = imageView;
            imageView.setImageDrawable(this.i);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f090e6f);
            this.h = imageView2;
            imageView2.setOnClickListener(this);
        }
    }
}
