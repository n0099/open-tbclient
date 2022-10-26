package com.win.opensdk;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes8.dex */
public class N0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public boolean b;
    public M0 c;
    public Info d;
    public Handler e;

    public N0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new E0(this, Looper.getMainLooper());
    }

    public void a(View view2, Info info, M0 m0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, view2, info, m0) == null) {
            this.a = view2;
            this.c = m0;
            this.d = info;
            try {
                Log.e(MiPushClient.COMMAND_REGISTER, "b111:" + this.b);
                if (!this.b) {
                    this.e.sendEmptyMessage(1101);
                }
                Log.e(MiPushClient.COMMAND_REGISTER, "b2222");
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                viewTreeObserver.addOnScrollChangedListener(new F0(this, m0));
                viewTreeObserver.addOnGlobalFocusChangeListener(new G0(this, m0));
                if (Build.VERSION.SDK_INT >= 18) {
                    viewTreeObserver.addOnWindowFocusChangeListener(new H0(this));
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    viewTreeObserver.addOnWindowAttachListener(new I0(this));
                }
                viewTreeObserver.addOnTouchModeChangeListener(new J0(this));
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.addOnDrawListener(new K0(this, viewTreeObserver));
                }
                viewTreeObserver.addOnGlobalLayoutListener(new L0(this, viewTreeObserver));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(View view2) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            if (view2 == null || !view2.isShown()) {
                return false;
            }
            Rect rect = new Rect();
            if (view2.getGlobalVisibleRect(rect) && this.d != null) {
                if (rect.width() >= this.d.getSper() * view2.getMeasuredWidth()) {
                    if (rect.height() >= this.d.getSper() * view2.getMeasuredHeight()) {
                        z = false;
                        if (!z) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            z = true;
            if (!z) {
            }
        } else {
            return invokeL.booleanValue;
        }
    }
}
