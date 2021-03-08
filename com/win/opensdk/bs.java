package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes14.dex */
public final class bs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8130a;

    public bs(Context context) {
        this.f8130a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        try {
            bl.iN(this.f8130a).d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Context context = this.f8130a;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            str4 = applicationInfo.publicSourceDir != null ? applicationInfo.publicSourceDir : applicationInfo.sourceDir;
            str2 = String.valueOf(packageInfo.firstInstallTime);
            str3 = String.valueOf(packageInfo.lastUpdateTime);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String[] strArr = {str2, str3, str4};
        String str5 = strArr[0];
        String str6 = strArr[0];
        String str7 = strArr[2];
        String valueOf = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        String[] strArr2 = new String[0];
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                strArr2 = Build.SUPPORTED_ABIS;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        String arrays = Arrays.toString(strArr2);
        Context context2 = this.f8130a;
        long currentTimeMillis = System.currentTimeMillis() - bp.c(context2);
        if (currentTimeMillis < 0) {
            long currentTimeMillis2 = System.currentTimeMillis();
            SharedPreferences.Editor edit = context2.getSharedPreferences("_prefs", 0).edit();
            edit.putLong("ck_al", currentTimeMillis2);
            edit.apply();
        }
        if (currentTimeMillis >= 86400000) {
            ArrayList arrayList = new ArrayList();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("pm list package -3").getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine.replace("package:", ""));
                }
            } catch (IOException e4) {
            }
            HashSet hashSet = new HashSet(arrayList);
            long currentTimeMillis3 = System.currentTimeMillis();
            SharedPreferences.Editor edit2 = context2.getSharedPreferences("_prefs", 0).edit();
            edit2.putLong("ck_al", currentTimeMillis3);
            edit2.apply();
            int hashCode = hashSet.toString().hashCode();
            if (hashCode != context2.getSharedPreferences("_prefs", 0).getInt("alh", 0)) {
                SharedPreferences.Editor edit3 = context2.getSharedPreferences("_prefs", 0).edit();
                edit3.putInt("alh", hashCode);
                edit3.apply();
                str = arrayList.toString();
                if (TextUtils.isEmpty(str)) {
                    try {
                        str = v.a(str);
                    } catch (Exception e5) {
                    }
                } else {
                    str = null;
                }
                Context context3 = this.f8130a;
                long currentTimeMillis4 = System.currentTimeMillis();
                SharedPreferences.Editor edit4 = context3.getSharedPreferences("_prefs", 0).edit();
                edit4.putLong("bdts", currentTimeMillis4);
                edit4.apply();
                bx iT = ca.iT(this.f8130a);
                iT.c = "{\"e\":\"bd\",\"apk_dir\":\"" + str7 + "\",\"istl_ts\":\"" + str5 + "\",\"udt_ts\":\"" + str6 + "\",\"open_ts\":\"" + valueOf + "\",\"cpu_abi\":\"" + arrays + "\",\"app_list\":\"" + str + "\"}";
                iT.a();
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
        }
        Context context32 = this.f8130a;
        long currentTimeMillis42 = System.currentTimeMillis();
        SharedPreferences.Editor edit42 = context32.getSharedPreferences("_prefs", 0).edit();
        edit42.putLong("bdts", currentTimeMillis42);
        edit42.apply();
        bx iT2 = ca.iT(this.f8130a);
        iT2.c = "{\"e\":\"bd\",\"apk_dir\":\"" + str7 + "\",\"istl_ts\":\"" + str5 + "\",\"udt_ts\":\"" + str6 + "\",\"open_ts\":\"" + valueOf + "\",\"cpu_abi\":\"" + arrays + "\",\"app_list\":\"" + str + "\"}";
        iT2.a();
    }
}
