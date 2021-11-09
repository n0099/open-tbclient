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
import b.q.a.i5;
import b.q.a.k1;
import b.q.a.l1;
import b.q.a.m5;
import b.q.a.q5;
import b.q.a.r0;
import b.q.a.u5;
import b.q.a.y5;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CloseParentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f70533a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f70534b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f70535c;

    /* renamed from: d  reason: collision with root package name */
    public Context f70536d;

    /* renamed from: e  reason: collision with root package name */
    public View f70537e;

    /* renamed from: f  reason: collision with root package name */
    public View f70538f;

    /* renamed from: g  reason: collision with root package name */
    public u5 f70539g;

    /* renamed from: h  reason: collision with root package name */
    public int f70540h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f70541i;

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
        this.f70541i = new i5(this, Looper.getMainLooper());
        this.f70536d = context;
        LinearLayout.inflate(context, l1.win_layout_close, this);
        this.f70534b = (LinearLayout) findViewById(k1.win_parent);
        this.f70537e = findViewById(k1.win_iv_clct);
        this.f70535c = (RelativeLayout) findViewById(k1.win_parent_close);
        this.f70538f = findViewById(k1.win_tv_area);
        this.f70533a = (TextView) findViewById(k1.wn_tv_cdt);
        this.f70534b.setOnClickListener(new m5(this));
        this.f70538f.setOnClickListener(new q5(this));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.f70541i) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f70534b.removeView(this.f70535c);
            this.f70534b.addView(this.f70535c, 1);
            ((LinearLayout.LayoutParams) this.f70537e.getLayoutParams()).rightMargin = r0.b(this.f70536d, 12);
            ((LinearLayout.LayoutParams) this.f70535c.getLayoutParams()).rightMargin = 0;
        }
    }

    public void setAreaLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
            ViewGroup.LayoutParams layoutParams = this.f70538f.getLayoutParams();
            int b2 = r0.b(this.f70536d, i3);
            layoutParams.width = b2;
            layoutParams.height = b2;
        }
    }

    public void setCollectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f70537e.setVisibility(z ? 0 : 8);
            this.f70534b.setClickable(z);
        }
    }

    public void setCountDown(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f70540h = i2;
            this.f70541i.sendEmptyMessage(10);
        }
    }

    public void setLocation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 != 110) {
                c();
                return;
            }
            this.f70534b.removeView(this.f70535c);
            this.f70534b.addView(this.f70535c, 0);
            ((LinearLayout.LayoutParams) this.f70537e.getLayoutParams()).rightMargin = 0;
            ((LinearLayout.LayoutParams) this.f70535c.getLayoutParams()).rightMargin = r0.b(this.f70536d, 12);
        }
    }

    public void setOnCloseListener(u5 u5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, u5Var) == null) {
            this.f70539g = u5Var;
        }
    }

    public void setOnCollectListener(y5 y5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, y5Var) == null) {
        }
    }
}
