package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
/* loaded from: classes12.dex */
final class ThreadedInputConnectionProxyAdapterView extends View {
    private InputConnection cachedConnection;
    final View containerView;
    final Handler imeHandler;
    private boolean isLocked;
    final View rootView;
    final View targetView;
    private boolean triggerDelayed;
    final IBinder windowToken;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadedInputConnectionProxyAdapterView(View view, View view2, Handler handler) {
        super(view.getContext());
        this.triggerDelayed = true;
        this.isLocked = false;
        this.imeHandler = handler;
        this.containerView = view;
        this.targetView = view2;
        this.windowToken = view.getWindowToken();
        this.rootView = view.getRootView();
        setFocusable(true);
        setFocusableInTouchMode(true);
        setVisibility(0);
    }

    boolean isTriggerDelayed() {
        return this.triggerDelayed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocked(boolean z) {
        this.isLocked = z;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.triggerDelayed = false;
        InputConnection onCreateInputConnection = this.isLocked ? this.cachedConnection : this.targetView.onCreateInputConnection(editorInfo);
        this.triggerDelayed = true;
        this.cachedConnection = onCreateInputConnection;
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return true;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return true;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.rootView;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    @Override // android.view.View
    public IBinder getWindowToken() {
        return this.windowToken;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.imeHandler;
    }
}
