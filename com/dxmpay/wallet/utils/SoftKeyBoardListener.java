package com.dxmpay.wallet.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
/* loaded from: classes11.dex */
public class SoftKeyBoardListener implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    public View rootView;
    public int rootViewVisibleHeight;

    /* loaded from: classes11.dex */
    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    /* loaded from: classes11.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SoftKeyBoardListener f62701e;

        public a(SoftKeyBoardListener softKeyBoardListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {softKeyBoardListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62701e = softKeyBoardListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                this.f62701e.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                SoftKeyBoardListener softKeyBoardListener = this.f62701e;
                int i2 = softKeyBoardListener.rootViewVisibleHeight;
                if (i2 == 0) {
                    softKeyBoardListener.rootViewVisibleHeight = height;
                } else if (i2 == height) {
                } else {
                    if (i2 - height > 200) {
                        if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                            this.f62701e.onSoftKeyBoardChangeListener.keyBoardShow(this.f62701e.rootViewVisibleHeight - height);
                        }
                        this.f62701e.rootViewVisibleHeight = height;
                    } else if (height - i2 > 200) {
                        if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                            this.f62701e.onSoftKeyBoardChangeListener.keyBoardHide(height - this.f62701e.rootViewVisibleHeight);
                        }
                        this.f62701e.rootViewVisibleHeight = height;
                    }
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View decorView = activity.getWindow().getDecorView();
        this.rootView = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, activity, onSoftKeyBoardChangeListener) == null) {
            new SoftKeyBoardListener(activity).setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener);
        }
    }

    private void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, onSoftKeyBoardChangeListener) == null) {
            this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener;
        }
    }
}
