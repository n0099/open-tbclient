package com.yy.hiidostatis.inner.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Map;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class Preference {
    public SharedPreferences cacheSp;
    public boolean isBindProcess;
    public String name;
    public Object obj;

    public Preference(String str) {
        this.isBindProcess = false;
        this.obj = new Object();
        this.cacheSp = null;
        this.name = str;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        String str;
        SharedPreferences sharedPreferences = this.cacheSp;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.obj) {
            if (this.cacheSp != null) {
                return this.cacheSp;
            }
            if (this.isBindProcess) {
                str = ProcessUtil.getFileNameBindProcess(context, this.name);
            } else {
                str = this.name;
            }
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
            this.cacheSp = sharedPreferences2;
            return sharedPreferences2;
        }
    }

    public void clearPreference(Context context) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.clear();
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public Map<String, ?> getAll(Context context) {
        return getSharedPreferences(context).getAll();
    }

    public Preference(String str, boolean z) {
        this.isBindProcess = false;
        this.obj = new Object();
        this.cacheSp = null;
        this.name = str;
        this.isBindProcess = z;
    }

    public void clearKey(Context context, String str) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.remove(str);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public boolean hasKey(Context context, String str) {
        return getSharedPreferences(context).contains(str);
    }

    public boolean getPrefBoolean(Context context, String str, boolean z) {
        return getSharedPreferences(context).getBoolean(str, z);
    }

    public float getPrefFloat(Context context, String str, float f) {
        return getSharedPreferences(context).getFloat(str, f);
    }

    public int getPrefInt(Context context, String str, int i) {
        return getSharedPreferences(context).getInt(str, i);
    }

    public long getPrefLong(Context context, String str, long j) {
        return getSharedPreferences(context).getLong(str, j);
    }

    public String getPrefString(Context context, String str, String str2) {
        return getSharedPreferences(context).getString(str, str2);
    }

    public void setPrefBoolean(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (Build.VERSION.SDK_INT >= 9) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        } else {
            sharedPreferences.edit().putBoolean(str, z).commit();
        }
    }

    public void setPrefFloat(Context context, String str, float f) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (Build.VERSION.SDK_INT >= 9) {
            sharedPreferences.edit().putFloat(str, f).apply();
        } else {
            sharedPreferences.edit().putFloat(str, f).commit();
        }
    }

    public void setPrefInt(Context context, String str, int i) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (Build.VERSION.SDK_INT >= 9) {
            sharedPreferences.edit().putInt(str, i).apply();
        } else {
            sharedPreferences.edit().putInt(str, i).commit();
        }
    }

    public void setPrefLong(Context context, String str, long j) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (Build.VERSION.SDK_INT >= 9) {
            sharedPreferences.edit().putLong(str, j).apply();
        } else {
            sharedPreferences.edit().putLong(str, j).commit();
        }
    }

    public void setPrefString(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (Build.VERSION.SDK_INT >= 9) {
            sharedPreferences.edit().putString(str, str2).apply();
        } else {
            sharedPreferences.edit().putString(str, str2).commit();
        }
    }
}
