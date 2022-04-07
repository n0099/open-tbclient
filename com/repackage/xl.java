package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
/* loaded from: classes7.dex */
public interface xl {
    Activity getActivity();

    PluginBaseActivity getTarget();

    void proxyAddContentView(View view2, ViewGroup.LayoutParams layoutParams);

    boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i);

    void proxyCloseContextMenu();

    void proxyCloseOptionsMenu();

    PendingIntent proxyCreatePendingResult(int i, Intent intent, int i2);

    boolean proxyDispatchGenericMotionEvent(MotionEvent motionEvent);

    boolean proxyDispatchKeyEvent(KeyEvent keyEvent);

    boolean proxyDispatchKeyShortcutEvent(KeyEvent keyEvent);

    boolean proxyDispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent);

    boolean proxyDispatchTouchEvent(MotionEvent motionEvent);

    boolean proxyDispatchTrackballEvent(MotionEvent motionEvent);

    View proxyFindViewById(int i);

    void proxyFinish();

    void proxyFinishActivity(int i);

    void proxyFinishActivityFromChild(Activity activity, int i);

    void proxyFinishFromChild(Activity activity);

    Context proxyGetApplicationContext();

    ComponentName proxyGetCallingActivity();

    String proxyGetCallingPackage();

    int proxyGetChangingConfigurations();

    View proxyGetCurrentFocus();

    Intent proxyGetIntent();

    LayoutInflater proxyGetLayoutInflater();

    String proxyGetLocalClassName();

    MenuInflater proxyGetMenuInflater();

    PackageManager proxyGetPackageManager();

    SharedPreferences proxyGetPreferences(int i);

    int proxyGetRequestedOrientation();

    SharedPreferences proxyGetSharedPreferences(String str, int i);

    Object proxyGetSystemService(String str);

    int proxyGetTaskId();

    int proxyGetWallpaperDesiredMinimumHeight();

    int proxyGetWallpaperDesiredMinimumWidth();

    Window proxyGetWindow();

    WindowManager proxyGetWindowManager();

    boolean proxyHasWindowFocus();

    boolean proxyIsFinishing();

    boolean proxyIsTaskRoot();

    boolean proxyMoveTaskToBack(boolean z);

    void proxyOnActivityResult(int i, int i2, Intent intent);

    void proxyOnApplyThemeResource(Resources.Theme theme, int i, boolean z);

    void proxyOnAttachedToWindow();

    void proxyOnBackPressed();

    void proxyOnChildTitleChanged(Activity activity, CharSequence charSequence);

    void proxyOnConfigurationChanged(Configuration configuration);

    void proxyOnContentChanged();

    boolean proxyOnContextItemSelected(MenuItem menuItem);

    void proxyOnContextMenuClosed(Menu menu);

    void proxyOnCreate(Bundle bundle);

    void proxyOnCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo);

    boolean proxyOnCreatePanelMenu(int i, Menu menu);

    boolean proxyOnCreateThumbnail(Bitmap bitmap, Canvas canvas);

    View proxyOnCreateView(View view2, String str, Context context, AttributeSet attributeSet);

    View proxyOnCreateView(String str, Context context, AttributeSet attributeSet);

    void proxyOnDestroy();

    void proxyOnDetachedFromWindow();

    boolean proxyOnKeyDown(int i, KeyEvent keyEvent);

    boolean proxyOnKeyLongPress(int i, KeyEvent keyEvent);

    boolean proxyOnKeyMultiple(int i, int i2, KeyEvent keyEvent);

    boolean proxyOnKeyUp(int i, KeyEvent keyEvent);

    void proxyOnLowMemory();

    boolean proxyOnMenuItemSelected(int i, MenuItem menuItem);

    boolean proxyOnMenuOpened(int i, Menu menu);

    boolean proxyOnOptionsItemSelected(MenuItem menuItem);

    void proxyOnOptionsMenuClosed(Menu menu);

    void proxyOnPanelClosed(int i, Menu menu);

    void proxyOnPause();

    void proxyOnPostCreate(Bundle bundle);

    void proxyOnPostResume();

    void proxyOnPrepareDialog(int i, Dialog dialog);

    boolean proxyOnPrepareOptionsMenu(Menu menu);

    boolean proxyOnPreparePanel(int i, View view2, Menu menu);

    void proxyOnRestart();

    void proxyOnRestoreInstanceState(Bundle bundle);

    void proxyOnResume();

    Object proxyOnRetainNonConfigurationInstance();

    void proxyOnSaveInstanceState(Bundle bundle);

    boolean proxyOnSearchRequested();

    void proxyOnStart();

    void proxyOnStop();

    void proxyOnTitleChanged(CharSequence charSequence, int i);

    boolean proxyOnTouchEvent(MotionEvent motionEvent);

    boolean proxyOnTrackballEvent(MotionEvent motionEvent);

    void proxyOnUserInteraction();

    void proxyOnWindowAttributesChanged(WindowManager.LayoutParams layoutParams);

    void proxyOnWindowFocusChanged(boolean z);

    void proxyOpenContextMenu(View view2);

    void proxyOpenOptionsMenu();

    void proxyOverridePendingTransition(int i, int i2);

    void proxyRegisterForContextMenu(View view2);

    void proxySetContentView(int i);

    void proxySetContentView(View view2);

    void proxySetContentView(View view2, ViewGroup.LayoutParams layoutParams);

    void proxySetIntent(Intent intent);

    void proxySetRequestedOrientation(int i);

    void proxySetTitle(int i);

    void proxySetTitle(CharSequence charSequence);

    void proxySetTitleColor(int i);

    void proxySetVisible(boolean z);

    void proxyStartActivity(Intent intent);

    void proxyStartActivityForResult(Intent intent, int i);

    void proxyStartActivityFromChild(Activity activity, Intent intent, int i);

    boolean proxyStartActivityIfNeeded(Intent intent, int i);

    void proxyStartIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException;

    void proxyStartIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException;

    void proxyStartManagingCursor(Cursor cursor);

    boolean proxyStartNextMatchingActivity(Intent intent);

    void proxyStartSearch(String str, boolean z, Bundle bundle, boolean z2);

    ComponentName proxyStartService(Intent intent);

    void proxyStopManagingCursor(Cursor cursor);

    boolean proxyStopService(Intent intent);

    void proxyTakeKeyEvents(boolean z);

    void proxyUnregisterForContextMenu(View view2);

    Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void unregisterReceiver(BroadcastReceiver broadcastReceiver);
}
