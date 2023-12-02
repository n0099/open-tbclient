package com.yy.transvod.player.common;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.tieba.zhc;
import com.yy.transvod.player.log.TLog;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class ProcessLifecycleOwnerInitializer extends ContentProvider implements Application.ActivityLifecycleCallbacks {
    public HashSet<Integer> a = new HashSet<>();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
            return false;
        }
        throw new RuntimeException("no application instance!");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        TLog.g(this, "onActivityCreated " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        TLog.g(this, "onActivitySaveInstanceState " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        TLog.g(this, "onActivityDestroyed " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        TLog.g(this, "onActivityPaused " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        TLog.g(this, "onActivityResumed " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        TLog.g(this, "onActivityStarted " + activity);
        zhc.a(true);
        this.a.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        TLog.g(this, "onActivityStopped " + activity);
        if (this.a.contains(Integer.valueOf(activity.hashCode()))) {
            zhc.a(false);
            this.a.remove(Integer.valueOf(activity.hashCode()));
        }
    }
}
