package com.dxmpay.apollon.statusbar;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class ImmersiveKeyboardAdjust {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    public int usableHeightPrevious;

    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f55720e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ImmersiveKeyboardAdjust f55721f;

        public a(ImmersiveKeyboardAdjust immersiveKeyboardAdjust, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immersiveKeyboardAdjust, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55721f = immersiveKeyboardAdjust;
            this.f55720e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int computeUsableHeight;
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (computeUsableHeight = this.f55721f.computeUsableHeight(this.f55720e)) == this.f55721f.usableHeightPrevious || (view = this.f55720e) == null) {
                return;
            }
            view.getLayoutParams().height = computeUsableHeight;
            this.f55720e.requestLayout();
            this.f55721f.usableHeightPrevious = computeUsableHeight;
        }
    }

    public ImmersiveKeyboardAdjust() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int computeUsableHeight(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view)) == null) {
            if (view == null) {
                return 0;
            }
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            return rect.bottom;
        }
        return invokeL.intValue;
    }

    public void attachActivity(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
            return;
        }
        if (this.globalLayoutListener == null) {
            this.globalLayoutListener = new a(this, view);
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.globalLayoutListener);
    }

    public void detachActivity(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || view == null) {
            return;
        }
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (this.globalLayoutListener != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this.globalLayoutListener);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.globalLayoutListener);
                }
            }
        }
        this.globalLayoutListener = null;
        this.usableHeightPrevious = 0;
    }
}
