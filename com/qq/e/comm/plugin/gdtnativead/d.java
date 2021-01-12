package com.qq.e.comm.plugin.gdtnativead;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.qq.e.comm.util.GDTLogger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    final Window.Callback f12014a;

    public d(Window.Callback callback) {
        if (callback == null) {
            GDTLogger.e("Window callback may not be null");
        }
        this.f12014a = callback;
    }

    @Override // android.view.Window.Callback
    @TargetApi(12)
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f12014a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f12014a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    @TargetApi(11)
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f12014a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f12014a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f12014a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f12014a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    @TargetApi(11)
    public void onActionModeFinished(ActionMode actionMode) {
        this.f12014a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    @TargetApi(11)
    public void onActionModeStarted(ActionMode actionMode) {
        this.f12014a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f12014a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f12014a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f12014a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return this.f12014a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f12014a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f12014a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return this.f12014a.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        this.f12014a.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f12014a.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f12014a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f12014a.onSearchRequested(searchEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f12014a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.f12014a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    @TargetApi(11)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f12014a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.f12014a.onWindowStartingActionMode(callback, i);
        }
        return null;
    }
}
