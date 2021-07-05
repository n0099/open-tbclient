package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ListPopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class InputAwareWebView extends WebView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "InputAwareWebView";
    public transient /* synthetic */ FieldHolder $fh;
    public View containerView;
    public OnScrollChangedCallback mOnScrollChangedCallback;
    public ThreadedInputConnectionProxyAdapterView proxyAdapterView;
    public View threadedInputConnectionProxyView;

    /* loaded from: classes10.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i2, int i3, int i4, int i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAwareWebView(Context context, View view) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.containerView = view;
    }

    private boolean isCalledFromListPopupWindowShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i2 = 0; i2 < stackTrace.length; i2++) {
                if (stackTrace[i2].getClassName().equals(ListPopupWindow.class.getCanonicalName()) && stackTrace[i2].getMethodName().equals("show")) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void resetInputConnection() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.proxyAdapterView == null) {
            return;
        }
        View view = this.containerView;
        if (view == null) {
            Log.e(TAG, "Can't reset the input connection to the container view because there is none.");
        } else {
            setInputConnectionTarget(view);
        }
    }

    private void setInputConnectionTarget(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, view) == null) {
            if (this.containerView == null) {
                Log.e(TAG, "Can't set the input connection target because there is no containerView to use as a handler.");
                return;
            }
            view.requestFocus();
            this.containerView.post(new Runnable(this, view) { // from class: io.flutter.plugins.webviewflutter.InputAwareWebView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InputAwareWebView this$0;
                public final /* synthetic */ View val$targetView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$targetView = view;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$targetView.onWindowFocusChanged(true);
                        ((InputMethodManager) this.this$0.getContext().getSystemService("input_method")).isActive(this.this$0.containerView);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            View view2 = this.threadedInputConnectionProxyView;
            this.threadedInputConnectionProxyView = view;
            if (view2 == view) {
                return super.checkInputConnectionProxy(view);
            }
            View view3 = this.containerView;
            if (view3 == null) {
                Log.e(TAG, "Can't create a proxy view because there's no container view. Text input may not work.");
                return super.checkInputConnectionProxy(view);
            }
            ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = new ThreadedInputConnectionProxyAdapterView(view3, view, view.getHandler());
            this.proxyAdapterView = threadedInputConnectionProxyAdapterView;
            setInputConnectionTarget(threadedInputConnectionProxyAdapterView);
            return super.checkInputConnectionProxy(view);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.clearFocus();
            resetInputConnection();
        }
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            resetInputConnection();
        }
    }

    public OnScrollChangedCallback getOnScrollChangedCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOnScrollChangedCallback : (OnScrollChangedCallback) invokeV.objValue;
    }

    public void lockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (threadedInputConnectionProxyAdapterView = this.proxyAdapterView) == null) {
            return;
        }
        threadedInputConnectionProxyAdapterView.setLocked(true);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            if (Build.VERSION.SDK_INT >= 27 || !isCalledFromListPopupWindowShow() || z) {
                super.onFocusChanged(z, i2, rect);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            OnScrollChangedCallback onScrollChangedCallback = this.mOnScrollChangedCallback;
            if (onScrollChangedCallback != null) {
                onScrollChangedCallback.onScroll(i2, i3, i4, i5);
            }
        }
    }

    public void setContainerView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            this.containerView = view;
            if (this.proxyAdapterView == null) {
                return;
            }
            Log.w(TAG, "The containerView has changed while the proxyAdapterView exists.");
            if (view != null) {
                setInputConnectionTarget(this.proxyAdapterView);
            }
        }
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollChangedCallback) == null) {
            this.mOnScrollChangedCallback = onScrollChangedCallback;
        }
    }

    public void unlockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (threadedInputConnectionProxyAdapterView = this.proxyAdapterView) == null) {
            return;
        }
        threadedInputConnectionProxyAdapterView.setLocked(false);
    }
}
