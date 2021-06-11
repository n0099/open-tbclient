package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.text.Typography;
/* loaded from: classes7.dex */
public final class u0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40805a;

    public u0(Context context) {
        this.f40805a = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|(2:2|3)|4|(4:5|6|(1:8)(1:58)|(2:9|10))|(2:12|13)|14|15|16|(1:18)|20|(1:22)|23|(1:25)(1:50)|26|(6:28|29|30|(2:31|(1:33)(1:34))|35|(5:37|38|(2:43|44)|40|41))|49|38|(0)|40|41|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[Catch: Exception -> 0x006e, TRY_LEAVE, TryCatch #0 {Exception -> 0x006e, blocks: (B:23:0x0065, B:25:0x006b), top: B:56:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String str;
        String str2;
        String str3;
        long currentTimeMillis;
        String str4;
        PackageInfo packageInfo;
        try {
            q1.a(this.f40805a).d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Context context = this.f40805a;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            str = applicationInfo.publicSourceDir != null ? applicationInfo.publicSourceDir : applicationInfo.sourceDir;
            try {
                str2 = String.valueOf(packageInfo.firstInstallTime);
            } catch (Exception e3) {
                e = e3;
                str2 = "";
            }
        } catch (Exception e4) {
            e = e4;
            str = "";
            str2 = str;
        }
        try {
            str3 = String.valueOf(packageInfo.lastUpdateTime);
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            str3 = "";
            String[] strArr = {str2, str3, str};
            String str5 = strArr[0];
            String str6 = strArr[0];
            String str7 = strArr[2];
            String valueOf = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
            String[] strArr2 = new String[0];
            if (Build.VERSION.SDK_INT >= 21) {
            }
            String arrays = Arrays.toString(strArr2);
            Context context2 = this.f40805a;
            currentTimeMillis = System.currentTimeMillis() - s1.c(context2);
            if (currentTimeMillis < 0) {
            }
            String str8 = null;
            if (currentTimeMillis < 86400000) {
            }
            str4 = null;
            if (!TextUtils.isEmpty(str4)) {
            }
            Context context3 = this.f40805a;
            long currentTimeMillis2 = System.currentTimeMillis();
            SharedPreferences.Editor edit = context3.getSharedPreferences("_prefs", 0).edit();
            edit.putLong("bdts", currentTimeMillis2);
            edit.apply();
            w0 a2 = x0.a(this.f40805a);
            a2.f40838c = "{\"e\":\"bd\",\"apk_dir\":\"" + str7 + Typography.quote + ",\"istl_ts\":\"" + str5 + Typography.quote + ",\"udt_ts\":\"" + str6 + Typography.quote + ",\"open_ts\":\"" + valueOf + Typography.quote + ",\"cpu_abi\":\"" + arrays + Typography.quote + ",\"app_list\":\"" + str8 + Typography.quote + '}';
            a2.a();
        }
        String[] strArr3 = {str2, str3, str};
        String str52 = strArr3[0];
        String str62 = strArr3[0];
        String str72 = strArr3[2];
        String valueOf2 = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        String[] strArr22 = new String[0];
        if (Build.VERSION.SDK_INT >= 21) {
            strArr22 = Build.SUPPORTED_ABIS;
        }
        String arrays2 = Arrays.toString(strArr22);
        Context context22 = this.f40805a;
        currentTimeMillis = System.currentTimeMillis() - s1.c(context22);
        if (currentTimeMillis < 0) {
            long currentTimeMillis3 = System.currentTimeMillis();
            SharedPreferences.Editor edit2 = context22.getSharedPreferences("_prefs", 0).edit();
            edit2.putLong("ck_al", currentTimeMillis3);
            edit2.apply();
        }
        String str82 = null;
        if (currentTimeMillis < 86400000) {
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
            } catch (Exception unused) {
            }
            HashSet hashSet = new HashSet(arrayList);
            long currentTimeMillis4 = System.currentTimeMillis();
            SharedPreferences.Editor edit3 = context22.getSharedPreferences("_prefs", 0).edit();
            edit3.putLong("ck_al", currentTimeMillis4);
            edit3.apply();
            int hashCode = hashSet.toString().hashCode();
            if (hashCode != context22.getSharedPreferences("_prefs", 0).getInt("alh", 0)) {
                SharedPreferences.Editor edit4 = context22.getSharedPreferences("_prefs", 0).edit();
                edit4.putInt("alh", hashCode);
                edit4.apply();
                str4 = arrayList.toString();
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        str82 = z.a(str4);
                    } catch (Exception unused2) {
                        str82 = str4;
                    }
                }
                Context context32 = this.f40805a;
                long currentTimeMillis22 = System.currentTimeMillis();
                SharedPreferences.Editor edit5 = context32.getSharedPreferences("_prefs", 0).edit();
                edit5.putLong("bdts", currentTimeMillis22);
                edit5.apply();
                w0 a22 = x0.a(this.f40805a);
                a22.f40838c = "{\"e\":\"bd\",\"apk_dir\":\"" + str72 + Typography.quote + ",\"istl_ts\":\"" + str52 + Typography.quote + ",\"udt_ts\":\"" + str62 + Typography.quote + ",\"open_ts\":\"" + valueOf2 + Typography.quote + ",\"cpu_abi\":\"" + arrays2 + Typography.quote + ",\"app_list\":\"" + str82 + Typography.quote + '}';
                a22.a();
            }
        }
        str4 = null;
        if (!TextUtils.isEmpty(str4)) {
        }
        Context context322 = this.f40805a;
        long currentTimeMillis222 = System.currentTimeMillis();
        SharedPreferences.Editor edit52 = context322.getSharedPreferences("_prefs", 0).edit();
        edit52.putLong("bdts", currentTimeMillis222);
        edit52.apply();
        w0 a222 = x0.a(this.f40805a);
        a222.f40838c = "{\"e\":\"bd\",\"apk_dir\":\"" + str72 + Typography.quote + ",\"istl_ts\":\"" + str52 + Typography.quote + ",\"udt_ts\":\"" + str62 + Typography.quote + ",\"open_ts\":\"" + valueOf2 + Typography.quote + ",\"cpu_abi\":\"" + arrays2 + Typography.quote + ",\"app_list\":\"" + str82 + Typography.quote + '}';
        a222.a();
    }
}
