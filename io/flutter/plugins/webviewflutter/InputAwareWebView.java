package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ListPopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class InputAwareWebView extends WebView {
    private static final String TAG = "InputAwareWebView";
    private View containerView;
    private OnScrollChangedCallback mOnScrollChangedCallback;
    private ThreadedInputConnectionProxyAdapterView proxyAdapterView;
    private View threadedInputConnectionProxyView;

    /* loaded from: classes12.dex */
    public interface OnScrollChangedCallback {
        void onScroll(int i, int i2, int i3, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputAwareWebView(Context context, View view) {
        super(context);
        this.containerView = view;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mOnScrollChangedCallback != null) {
            this.mOnScrollChangedCallback.onScroll(i, i2, i3, i4);
        }
    }

    public OnScrollChangedCallback getOnScrollChangedCallback() {
        return this.mOnScrollChangedCallback;
    }

    public void setOnScrollChangedCallback(OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContainerView(View view) {
        this.containerView = view;
        if (this.proxyAdapterView != null) {
            Log.w(TAG, "The containerView has changed while the proxyAdapterView exists.");
            if (view != null) {
                setInputConnectionTarget(this.proxyAdapterView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lockInputConnection() {
        if (this.proxyAdapterView != null) {
            this.proxyAdapterView.setLocked(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unlockInputConnection() {
        if (this.proxyAdapterView != null) {
            this.proxyAdapterView.setLocked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispose() {
        resetInputConnection();
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        View view2 = this.threadedInputConnectionProxyView;
        this.threadedInputConnectionProxyView = view;
        if (view2 == view) {
            return super.checkInputConnectionProxy(view);
        }
        if (this.containerView == null) {
            Log.e(TAG, "Can't create a proxy view because there's no container view. Text input may not work.");
            return super.checkInputConnectionProxy(view);
        }
        this.proxyAdapterView = new ThreadedInputConnectionProxyAdapterView(this.containerView, view, view.getHandler());
        setInputConnectionTarget(this.proxyAdapterView);
        return super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        super.clearFocus();
        resetInputConnection();
    }

    private void resetInputConnection() {
        if (this.proxyAdapterView != null) {
            if (this.containerView == null) {
                Log.e(TAG, "Can't reset the input connection to the container view because there is none.");
            } else {
                setInputConnectionTarget(this.containerView);
            }
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

    @Override // android.webkit.WebView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (Build.VERSION.SDK_INT >= 27 || !isCalledFromListPopupWindowShow() || z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    private boolean isCalledFromListPopupWindowShow() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            if (stackTrace[i].getClassName().equals(ListPopupWindow.class.getCanonicalName()) && stackTrace[i].getMethodName().equals("show")) {
                return true;
            }
        }
        return false;
    }
}
