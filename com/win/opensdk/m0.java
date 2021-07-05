package com.win.opensdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f42605a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42606b;

    /* renamed from: c  reason: collision with root package name */
    public l0 f42607c;

    /* renamed from: d  reason: collision with root package name */
    public Info f42608d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f42609e;

    public m0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42609e = new j0(this, Looper.getMainLooper());
    }

    public void a(View view, Info info, l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view, info, l0Var) == null) {
            this.f42605a = view;
            this.f42607c = l0Var;
            this.f42608d = info;
            try {
                if (!this.f42606b) {
                    this.f42609e.sendEmptyMessage(1101);
                }
                this.f42605a.getViewTreeObserver().addOnScrollChangedListener(new k0(this, l0Var));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(View view) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) != null) {
            return invokeL.booleanValue;
        }
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && this.f42608d != null) {
            if (rect.width() >= this.f42608d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f42608d.getSper() * view.getMeasuredHeight()) {
                    z = false;
                    return z;
                }
            }
        }
        z = true;
        if (z) {
        }
    }
}
