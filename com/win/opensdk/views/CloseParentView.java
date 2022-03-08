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
import c.q.a.d5;
import c.q.a.h5;
import c.q.a.l5;
import c.q.a.p5;
import c.q.a.r0;
import c.q.a.t5;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class CloseParentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f59420b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f59421c;

    /* renamed from: d  reason: collision with root package name */
    public Context f59422d;

    /* renamed from: e  reason: collision with root package name */
    public View f59423e;

    /* renamed from: f  reason: collision with root package name */
    public View f59424f;

    /* renamed from: g  reason: collision with root package name */
    public p5 f59425g;

    /* renamed from: h  reason: collision with root package name */
    public int f59426h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f59427i;

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
        this.f59427i = new d5(this, Looper.getMainLooper());
        this.f59422d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f59420b = (LinearLayout) findViewById(R.id.win_parent);
        this.f59423e = findViewById(R.id.win_iv_clct);
        this.f59421c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f59424f = findViewById(R.id.win_tv_area);
        this.a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f59420b.setOnClickListener(new h5(this));
        this.f59424f.setOnClickListener(new l5(this));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.f59427i) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59420b.removeView(this.f59421c);
            this.f59420b.addView(this.f59421c, 1);
            ((LinearLayout.LayoutParams) this.f59423e.getLayoutParams()).rightMargin = r0.b(this.f59422d, 12);
            ((LinearLayout.LayoutParams) this.f59421c.getLayoutParams()).rightMargin = 0;
        }
    }

    public void setAreaLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
            ViewGroup.LayoutParams layoutParams = this.f59424f.getLayoutParams();
            int b2 = r0.b(this.f59422d, i3);
            layoutParams.width = b2;
            layoutParams.height = b2;
        }
    }

    public void setCollectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f59423e.setVisibility(z ? 0 : 8);
            this.f59420b.setClickable(z);
        }
    }

    public void setCountDown(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f59426h = i2;
            this.f59427i.sendEmptyMessage(10);
        }
    }

    public void setLocation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 != 110) {
                c();
                return;
            }
            this.f59420b.removeView(this.f59421c);
            this.f59420b.addView(this.f59421c, 0);
            ((LinearLayout.LayoutParams) this.f59423e.getLayoutParams()).rightMargin = 0;
            ((LinearLayout.LayoutParams) this.f59421c.getLayoutParams()).rightMargin = r0.b(this.f59422d, 12);
        }
    }

    public void setOnCloseListener(p5 p5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p5Var) == null) {
            this.f59425g = p5Var;
        }
    }

    public void setOnCollectListener(t5 t5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t5Var) == null) {
        }
    }
}
