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
import c.p.a.i5;
import c.p.a.k1;
import c.p.a.l1;
import c.p.a.m5;
import c.p.a.q5;
import c.p.a.r0;
import c.p.a.u5;
import c.p.a.y5;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CloseParentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f62662b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f62663c;

    /* renamed from: d  reason: collision with root package name */
    public Context f62664d;

    /* renamed from: e  reason: collision with root package name */
    public View f62665e;

    /* renamed from: f  reason: collision with root package name */
    public View f62666f;

    /* renamed from: g  reason: collision with root package name */
    public u5 f62667g;

    /* renamed from: h  reason: collision with root package name */
    public int f62668h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f62669i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseParentView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62669i = new i5(this, Looper.getMainLooper());
        this.f62664d = context;
        LinearLayout.inflate(context, l1.win_layout_close, this);
        this.f62662b = (LinearLayout) findViewById(k1.win_parent);
        this.f62665e = findViewById(k1.win_iv_clct);
        this.f62663c = (RelativeLayout) findViewById(k1.win_parent_close);
        this.f62666f = findViewById(k1.win_tv_area);
        this.a = (TextView) findViewById(k1.wn_tv_cdt);
        this.f62662b.setOnClickListener(new m5(this));
        this.f62666f.setOnClickListener(new q5(this));
        setAreaLevel(1);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void b() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.f62669i) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62662b.removeView(this.f62663c);
            this.f62662b.addView(this.f62663c, 1);
            ((LinearLayout.LayoutParams) this.f62665e.getLayoutParams()).rightMargin = r0.b(this.f62664d, 12);
            ((LinearLayout.LayoutParams) this.f62663c.getLayoutParams()).rightMargin = 0;
        }
    }

    public void setAreaLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
            ViewGroup.LayoutParams layoutParams = this.f62666f.getLayoutParams();
            int b2 = r0.b(this.f62664d, i3);
            layoutParams.width = b2;
            layoutParams.height = b2;
        }
    }

    public void setCollectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f62665e.setVisibility(z ? 0 : 8);
            this.f62662b.setClickable(z);
        }
    }

    public void setCountDown(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f62668h = i2;
            this.f62669i.sendEmptyMessage(10);
        }
    }

    public void setLocation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 != 110) {
                c();
                return;
            }
            this.f62662b.removeView(this.f62663c);
            this.f62662b.addView(this.f62663c, 0);
            ((LinearLayout.LayoutParams) this.f62665e.getLayoutParams()).rightMargin = 0;
            ((LinearLayout.LayoutParams) this.f62663c.getLayoutParams()).rightMargin = r0.b(this.f62664d, 12);
        }
    }

    public void setOnCloseListener(u5 u5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, u5Var) == null) {
            this.f62667g = u5Var;
        }
    }

    public void setOnCollectListener(y5 y5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, y5Var) == null) {
        }
    }
}
