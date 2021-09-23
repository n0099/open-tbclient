package com.win.opensdk;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes10.dex */
public class O0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f77144a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f77145b;

    /* renamed from: c  reason: collision with root package name */
    public N0 f77146c;

    /* renamed from: d  reason: collision with root package name */
    public Info f77147d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f77148e;

    public O0() {
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
        this.f77148e = new F0(this, Looper.getMainLooper());
    }

    public void a(View view, Info info, N0 n0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view, info, n0) == null) {
            this.f77144a = view;
            this.f77146c = n0;
            this.f77147d = info;
            try {
                String str = "b111:" + this.f77145b;
                if (!this.f77145b) {
                    this.f77148e.sendEmptyMessage(1101);
                }
                ViewTreeObserver viewTreeObserver = this.f77144a.getViewTreeObserver();
                viewTreeObserver.addOnScrollChangedListener(new G0(this, n0));
                viewTreeObserver.addOnGlobalFocusChangeListener(new H0(this, n0));
                if (Build.VERSION.SDK_INT >= 18) {
                    viewTreeObserver.addOnWindowFocusChangeListener(new I0(this));
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    viewTreeObserver.addOnWindowAttachListener(new J0(this));
                }
                viewTreeObserver.addOnTouchModeChangeListener(new K0(this));
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.addOnDrawListener(new L0(this, viewTreeObserver));
                }
                viewTreeObserver.addOnGlobalLayoutListener(new M0(this, viewTreeObserver));
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
        if (view.getGlobalVisibleRect(rect) && this.f77147d != null) {
            if (rect.width() >= this.f77147d.getSper() * view.getMeasuredWidth()) {
                if (rect.height() >= this.f77147d.getSper() * view.getMeasuredHeight()) {
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
