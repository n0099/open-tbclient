package com.tencent.open.c;

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
/* loaded from: classes7.dex */
public class a extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f41953a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Rect f41954b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41955c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC0565a f41956d;

    /* renamed from: com.tencent.open.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0565a {
        void a();

        void a(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039339431, "Lcom/tencent/open/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039339431, "Lcom/tencent/open/c/a;");
                return;
            }
        }
        f41953a = a.class.getName();
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
        this.f41954b = null;
        this.f41955c = false;
        this.f41956d = null;
        if (0 == 0) {
            this.f41954b = new Rect();
        }
    }

    public void a(InterfaceC0565a interfaceC0565a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0565a) == null) {
            this.f41956d = interfaceC0565a;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i3);
            Activity activity = (Activity) getContext();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f41954b);
            int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f41954b.top) - size;
            InterfaceC0565a interfaceC0565a = this.f41956d;
            if (interfaceC0565a != null && size != 0) {
                if (height > 100) {
                    interfaceC0565a.a((Math.abs(this.f41954b.height()) - getPaddingBottom()) - getPaddingTop());
                } else {
                    interfaceC0565a.a();
                }
            }
            super.onMeasure(i2, i3);
        }
    }
}
