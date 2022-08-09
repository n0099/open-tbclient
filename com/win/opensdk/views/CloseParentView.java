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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.M;
import com.win.opensdk.t2;
import com.win.opensdk.u2;
import com.win.opensdk.v2;
import com.win.opensdk.w2;
import com.win.opensdk.x2;
/* loaded from: classes8.dex */
public class CloseParentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public LinearLayout b;
    public RelativeLayout c;
    public Context d;
    public View e;
    public View f;
    public w2 g;
    public int h;
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
        this.i = new t2(this, Looper.getMainLooper());
        this.d = context;
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d090c, this);
        this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092629);
        this.e = findViewById(R.id.obfuscated_res_0x7f092626);
        this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09262a);
        this.f = findViewById(R.id.obfuscated_res_0x7f092630);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f092634);
        this.b.setOnClickListener(new u2(this));
        this.f.setOnClickListener(new v2(this));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (handler = this.i) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.removeView(this.c);
            this.b.addView(this.c, 1);
            ((LinearLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = M.a(this.d, 12);
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = 0;
        }
    }

    public void setAreaLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int i2 = i != 0 ? i != 1 ? i != 2 ? 0 : 30 : 22 : 10;
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            int a = M.a(this.d, i2);
            layoutParams.width = a;
            layoutParams.height = a;
        }
    }

    public void setCollectVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e.setVisibility(z ? 0 : 8);
            this.b.setClickable(z);
        }
    }

    public void setCountDown(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.h = i;
            this.i.sendEmptyMessage(10);
        }
    }

    public void setLocation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i != 110) {
                c();
                return;
            }
            this.b.removeView(this.c);
            this.b.addView(this.c, 0);
            ((LinearLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = 0;
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = M.a(this.d, 12);
        }
    }

    public void setOnCloseListener(w2 w2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, w2Var) == null) {
            this.g = w2Var;
        }
    }

    public void setOnCollectListener(x2 x2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, x2Var) == null) {
        }
    }
}
