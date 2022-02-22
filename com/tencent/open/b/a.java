package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Rect f60737b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60738c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC2271a f60739d;

    /* renamed from: com.tencent.open.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2271a {
        void a();

        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039309640, "Lcom/tencent/open/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039309640, "Lcom/tencent/open/b/a;");
                return;
            }
        }
        a = a.class.getName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60737b = null;
        this.f60738c = false;
        this.f60739d = null;
        if (0 == 0) {
            this.f60737b = new Rect();
        }
    }

    public void a(InterfaceC2271a interfaceC2271a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC2271a) == null) {
            this.f60739d = interfaceC2271a;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i3);
            Activity activity = (Activity) getContext();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f60737b);
            int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f60737b.top) - size;
            InterfaceC2271a interfaceC2271a = this.f60739d;
            if (interfaceC2271a != null && size != 0) {
                if (height > 100) {
                    interfaceC2271a.a((Math.abs(this.f60737b.height()) - getPaddingBottom()) - getPaddingTop());
                } else {
                    interfaceC2271a.a();
                }
            }
            super.onMeasure(i2, i3);
        }
    }
}
