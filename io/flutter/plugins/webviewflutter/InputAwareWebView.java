package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ListPopupWindow;
/* loaded from: classes7.dex */
public final class InputAwareWebView extends WebView {
    public static final String TAG = "InputAwareWebView";
    public View containerView;
    public OnScrollChangedCallback mOnScrollChangedCallback;
    public ThreadedInputConnectionProxyAdapterView proxyAdapterView;
    public View threadedInputConnectionProxyView;

    /* loaded from: classes7.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i2, int i3, int i4, int i5);
    }

    public InputAwareWebView(Context context, View view) {
        super(context);
        this.containerView = view;
    }

    private boolean isCalledFromListPopupWindowShow() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().equals(ListPopupWindow.class.getCanonicalName()) && stackTrace[i2].getMethodName().equals("show")) {
                return true;
            }
        }
        return false;
    }

    private void resetInputConnection() {
        if (this.proxyAdapterView == null) {
            return;
        }
        View view = this.containerView;
        if (view == null) {
            Log.e(TAG, "Can't reset the input connection to the container view because there is none.");
        } else {
            setInputConnectionTarget(view);
        }
    }

    private void setInputConnectionTarget(final View view) {
        if (this.containerView == null) {
            Log.e(TAG, "Can't set the input connection target because there is no containerView to use as a handler.");
            return;
        }
        view.requestFocus();
        this.containerView.post(new Runnable() { // from class: io.flutter.plugins.webviewflutter.InputAwareWebView.1
            @Override // java.lang.Runnable
            public void run() {
                view.onWindowFocusChanged(true);
                ((InputMethodManager) InputAwareWebView.this.getContext().getSystemService("input_method")).isActive(InputAwareWebView.this.containerView);
            }
        });
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        resetInputConnection();
    }

    public void dispose() {
        resetInputConnection();
    }

    public OnScrollChangedCallback getOnScrollChangedCallback() {
        return this.mOnScrollChangedCallback;
    }

    public void lockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = this.proxyAdapterView;
        if (threadedInputConnectionProxyAdapterView == null) {
            return;
        }
        threadedInputConnectionProxyAdapterView.setLocked(true);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (Build.VERSION.SDK_INT >= 27 || !isCalledFromListPopupWindowShow() || z) {
            super.onFocusChanged(z, i2, rect);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        OnScrollChangedCallback onScrollChangedCallback = this.mOnScrollChangedCallback;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(i2, i3, i4, i5);
        }
    }

    public void setContainerView(View view) {
        this.containerView = view;
        if (this.proxyAdapterView == null) {
            return;
        }
        Log.w(TAG, "The containerView has changed while the proxyAdapterView exists.");
        if (view != null) {
            setInputConnectionTarget(this.proxyAdapterView);
        }
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }

    public void unlockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = this.proxyAdapterView;
        if (threadedInputConnectionProxyAdapterView == null) {
            return;
        }
        threadedInputConnectionProxyAdapterView.setLocked(false);
    }
}
