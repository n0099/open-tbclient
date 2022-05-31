package com.repackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class o15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final View b;
    public final int c;
    public final boolean d;
    public k15 e;

    public o15(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = view2;
        this.c = r15.a(view2.getContext());
        this.d = s15.c((Activity) view2.getContext());
    }

    public final k15 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
            return (k15) invokeL.objValue;
        }
        k15 k15Var = this.e;
        if (k15Var != null) {
            return k15Var;
        }
        if (view2 instanceof k15) {
            k15 k15Var2 = (k15) view2;
            this.e = k15Var2;
            return k15Var2;
        } else if (!(view2 instanceof ViewGroup)) {
            return null;
        } else {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (i >= viewGroup.getChildCount()) {
                    return null;
                }
                k15 a = a(viewGroup.getChildAt(i));
                if (a != null) {
                    this.e = a;
                    return a;
                }
                i++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.d && Build.VERSION.SDK_INT >= 16 && this.b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.b.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
            }
            Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
            if (i2 < 0) {
                return;
            }
            int i3 = this.a;
            if (i3 < 0) {
                this.a = i2;
                return;
            }
            int i4 = i3 - i2;
            if (i4 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i4 + " == 0 break;");
            } else if (Math.abs(i4) == this.c) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i4)));
            } else {
                this.a = i2;
                k15 a = a(this.b);
                if (a == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i4) < q15.f(this.b.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i4 > 0) {
                    a.handleHide();
                } else if (a.b() && a.isVisible()) {
                    a.handleShow();
                }
            }
        }
    }
}
