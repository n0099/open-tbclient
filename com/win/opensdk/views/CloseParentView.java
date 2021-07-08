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
import com.win.opensdk.L1;
import com.win.opensdk.M1;
import com.win.opensdk.N1;
import com.win.opensdk.O1;
import com.win.opensdk.P1;
import com.win.opensdk.R;
import com.win.opensdk.z;
/* loaded from: classes6.dex */
public class CloseParentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f39684a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f39685b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f39686c;

    /* renamed from: d  reason: collision with root package name */
    public Context f39687d;

    /* renamed from: e  reason: collision with root package name */
    public View f39688e;

    /* renamed from: f  reason: collision with root package name */
    public View f39689f;

    /* renamed from: g  reason: collision with root package name */
    public O1 f39690g;

    /* renamed from: h  reason: collision with root package name */
    public int f39691h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f39692i;

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
        this.f39692i = new L1(this);
        this.f39687d = context;
        LinearLayout.inflate(context, R.layout.win_layout_close, this);
        this.f39685b = (LinearLayout) findViewById(R.id.win_parent);
        this.f39688e = findViewById(R.id.win_iv_clct);
        this.f39686c = (RelativeLayout) findViewById(R.id.win_parent_close);
        this.f39689f = findViewById(R.id.win_tv_area);
        this.f39684a = (TextView) findViewById(R.id.wn_tv_cdt);
        this.f39685b.setOnClickListener(new M1(this));
        this.f39689f.setOnClickListener(new N1(this));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.f39692i) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f39685b.removeView(this.f39686c);
            this.f39685b.addView(this.f39686c, 1);
            ((LinearLayout.LayoutParams) this.f39688e.getLayoutParams()).rightMargin = z.a(this.f39687d, 12.0f);
            ((LinearLayout.LayoutParams) this.f39686c.getLayoutParams()).rightMargin = 0;
        }
    }

    public void setAreaLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 30 : 22 : 10;
            ViewGroup.LayoutParams layoutParams = this.f39689f.getLayoutParams();
            int a2 = z.a(this.f39687d, i3);
            layoutParams.width = a2;
            layoutParams.height = a2;
        }
    }

    public void setCollectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f39688e.setVisibility(z ? 0 : 8);
            this.f39685b.setClickable(z);
        }
    }

    public void setCountDown(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f39691h = i2;
            this.f39692i.sendEmptyMessage(10);
        }
    }

    public void setLocation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 != 110) {
                c();
                return;
            }
            this.f39685b.removeView(this.f39686c);
            this.f39685b.addView(this.f39686c, 0);
            ((LinearLayout.LayoutParams) this.f39688e.getLayoutParams()).rightMargin = 0;
            ((LinearLayout.LayoutParams) this.f39686c.getLayoutParams()).rightMargin = z.a(this.f39687d, 12.0f);
        }
    }

    public void setOnCloseListener(O1 o1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, o1) == null) {
            this.f39690g = o1;
        }
    }

    public void setOnCollectListener(P1 p1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, p1) == null) {
        }
    }
}
