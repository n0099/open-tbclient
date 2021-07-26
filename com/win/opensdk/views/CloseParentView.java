package com.win.opensdk.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.N;
import com.win.opensdk.R;
import com.win.opensdk.n2;
import com.win.opensdk.o2;
import com.win.opensdk.p2;
import com.win.opensdk.q2;
import com.win.opensdk.r2;
/* loaded from: classes6.dex */
public class CloseParentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f39966a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f39967b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f39968c;

    /* renamed from: d  reason: collision with root package name */
    public Context f39969d;

    /* renamed from: e  reason: collision with root package name */
    public View f39970e;

    /* renamed from: f  reason: collision with root package name */
    public View f39971f;

    /* renamed from: g  reason: collision with root package name */
    public q2 f39972g;

    /* renamed from: h  reason: collision with root package name */
    public int f39973h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f39974i;

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
        this.f39974i = new n2(this);
        this.f39969d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f39967b = (LinearLayout) findViewById(R.id.win_parent);
        this.f39970e = findViewById(R.id.win_iv_clct);
        this.f39968c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f39971f = findViewById(R.id.win_tv_area);
        this.f39966a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f39967b.setOnClickListener(new o2(this));
        this.f39971f.setOnClickListener(new p2(this));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.f39974i) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f39967b.removeView(this.f39968c);
            this.f39967b.addView(this.f39968c, 1);
            ((LinearLayout.LayoutParams) this.f39970e.getLayoutParams()).rightMargin = N.a(this.f39969d, 12.0f);
            ((LinearLayout.LayoutParams) this.f39968c.getLayoutParams()).rightMargin = 0;
        }
    }

    public void setAreaLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
            ViewGroup.LayoutParams layoutParams = this.f39971f.getLayoutParams();
            int a2 = N.a(this.f39969d, i3);
            layoutParams.width = a2;
            layoutParams.height = a2;
        }
    }

    public void setCollectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f39970e.setVisibility(z ? 0 : 8);
            this.f39967b.setClickable(z);
        }
    }

    public void setCountDown(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f39973h = i2;
            this.f39974i.sendEmptyMessage(10);
        }
    }

    public void setLocation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 != 110) {
                c();
                return;
            }
            this.f39967b.removeView(this.f39968c);
            this.f39967b.addView(this.f39968c, 0);
            ((LinearLayout.LayoutParams) this.f39970e.getLayoutParams()).rightMargin = 0;
            ((LinearLayout.LayoutParams) this.f39968c.getLayoutParams()).rightMargin = N.a(this.f39969d, 12.0f);
        }
    }

    public void setOnCloseListener(q2 q2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, q2Var) == null) {
            this.f39972g = q2Var;
        }
    }

    public void setOnCollectListener(r2 r2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, r2Var) == null) {
        }
    }
}
