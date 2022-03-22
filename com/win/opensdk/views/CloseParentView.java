package com.win.opensdk.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.m.a.d5;
import c.m.a.h5;
import c.m.a.l5;
import c.m.a.p5;
import c.m.a.r0;
import c.m.a.t5;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CloseParentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f44042b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f44043c;

    /* renamed from: d  reason: collision with root package name */
    public Context f44044d;

    /* renamed from: e  reason: collision with root package name */
    public View f44045e;

    /* renamed from: f  reason: collision with root package name */
    public View f44046f;

    /* renamed from: g  reason: collision with root package name */
    public p5 f44047g;

    /* renamed from: h  reason: collision with root package name */
    public int f44048h;
    public Handler i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseParentView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloseParentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new d5(this, Looper.getMainLooper());
        this.f44044d = context;
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d08d9, this);
        this.f44042b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092484);
        this.f44045e = findViewById(R.id.obfuscated_res_0x7f092481);
        this.f44043c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092485);
        this.f44046f = findViewById(R.id.obfuscated_res_0x7f09248b);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f09248f);
        this.f44042b.setOnClickListener(new h5(this));
        this.f44046f.setOnClickListener(new l5(this));
        setAreaLevel(1);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void c() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.i) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f44042b.removeView(this.f44043c);
            this.f44042b.addView(this.f44043c, 1);
            ((LinearLayout.LayoutParams) this.f44045e.getLayoutParams()).rightMargin = r0.b(this.f44044d, 12);
            ((LinearLayout.LayoutParams) this.f44043c.getLayoutParams()).rightMargin = 0;
        }
    }

    public void setAreaLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int i2 = i != 0 ? i != 1 ? i != 2 ? 0 : 30 : 22 : 10;
            ViewGroup.LayoutParams layoutParams = this.f44046f.getLayoutParams();
            int b2 = r0.b(this.f44044d, i2);
            layoutParams.width = b2;
            layoutParams.height = b2;
        }
    }

    public void setCollectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f44045e.setVisibility(z ? 0 : 8);
            this.f44042b.setClickable(z);
        }
    }

    public void setCountDown(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f44048h = i;
            this.i.sendEmptyMessage(10);
        }
    }

    public void setLocation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i != 110) {
                d();
                return;
            }
            this.f44042b.removeView(this.f44043c);
            this.f44042b.addView(this.f44043c, 0);
            ((LinearLayout.LayoutParams) this.f44045e.getLayoutParams()).rightMargin = 0;
            ((LinearLayout.LayoutParams) this.f44043c.getLayoutParams()).rightMargin = r0.b(this.f44044d, 12);
        }
    }

    public void setOnCloseListener(p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p5Var) == null) {
            this.f44047g = p5Var;
        }
    }

    public void setOnCollectListener(t5 t5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t5Var) == null) {
        }
    }
}
