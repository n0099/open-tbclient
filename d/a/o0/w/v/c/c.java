package d.a.o0.w.v.c;

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
import d.a.o0.w.v.d.d;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53521a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53522b;

    /* renamed from: c  reason: collision with root package name */
    public final int f53523c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f53524d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.w.v.a f53525e;

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53521a = -1;
        this.f53522b = view;
        this.f53523c = d.a.o0.w.v.d.c.a(view.getContext());
        this.f53524d = d.c((Activity) view.getContext());
    }

    public final d.a.o0.w.v.a a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view)) != null) {
            return (d.a.o0.w.v.a) invokeL.objValue;
        }
        d.a.o0.w.v.a aVar = this.f53525e;
        if (aVar != null) {
            return aVar;
        }
        if (view instanceof d.a.o0.w.v.a) {
            d.a.o0.w.v.a aVar2 = (d.a.o0.w.v.a) view;
            this.f53525e = aVar2;
            return aVar2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    return null;
                }
                d.a.o0.w.v.a a2 = a(viewGroup.getChildAt(i2));
                if (a2 != null) {
                    this.f53525e = a2;
                    return a2;
                }
                i2++;
            }
        }
    }

    @TargetApi(16)
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            if (this.f53524d && Build.VERSION.SDK_INT >= 16 && this.f53522b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.f53522b.getWindowVisibleDisplayFrame(rect);
                i3 = rect.bottom - rect.top;
            }
            Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i2 + " height: " + i3);
            if (i3 < 0) {
                return;
            }
            int i4 = this.f53521a;
            if (i4 < 0) {
                this.f53521a = i3;
                return;
            }
            int i5 = i4 - i3;
            if (i5 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i5 + " == 0 break;");
            } else if (Math.abs(i5) == this.f53523c) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i5)));
            } else {
                this.f53521a = i3;
                d.a.o0.w.v.a a2 = a(this.f53522b);
                if (a2 == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i5) < d.a.o0.w.v.d.b.f(this.f53522b.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i5 > 0) {
                    a2.handleHide();
                } else if (a2.b() && a2.isVisible()) {
                    a2.handleShow();
                }
            }
        }
    }
}
