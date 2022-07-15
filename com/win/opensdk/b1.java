package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.text.Typography;
/* loaded from: classes8.dex */
public final class b1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    public b1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006f A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #4 {Exception -> 0x0072, blocks: (B:25:0x0069, B:27:0x006f), top: B:69:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                X1.a(this.a).d();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Context context = this.a;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                str = applicationInfo.publicSourceDir != null ? applicationInfo.publicSourceDir : applicationInfo.sourceDir;
                try {
                    str2 = String.valueOf(packageInfo.firstInstallTime);
                } catch (Exception e2) {
                    e = e2;
                    str2 = "";
                }
                try {
                    str3 = String.valueOf(packageInfo.lastUpdateTime);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    str3 = "";
                    String[] strArr = {str2, str3, str};
                    String str6 = strArr[0];
                    String str7 = strArr[0];
                    String str8 = strArr[2];
                    String valueOf = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
                    String[] strArr2 = new String[0];
                    if (Build.VERSION.SDK_INT >= 21) {
                    }
                    String arrays = Arrays.toString(strArr2);
                    Context context2 = this.a;
                    currentTimeMillis = System.currentTimeMillis() - Z1.c(context2);
                    if (currentTimeMillis < 0) {
                    }
                    if (currentTimeMillis < 86400000) {
                    }
                    str4 = null;
                    if (TextUtils.isEmpty(str4)) {
                    }
                    Context context3 = this.a;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    SharedPreferences.Editor edit = context3.getSharedPreferences("_prefs", 0).edit();
                    edit.putLong("bdts", currentTimeMillis2);
                    edit.apply();
                    d1 a = e1.a(this.a);
                    a.c = "{\"e\":\"bd\",\"apk_dir\":\"" + str8 + Typography.quote + ",\"istl_ts\":\"" + str6 + Typography.quote + ",\"udt_ts\":\"" + str7 + Typography.quote + ",\"open_ts\":\"" + valueOf + Typography.quote + ",\"cpu_abi\":\"" + arrays + Typography.quote + ",\"app_list\":\"" + str5 + Typography.quote + '}';
                    a.a();
                }
            } catch (Exception e4) {
                e = e4;
                str = "";
                str2 = str;
            }
            String[] strArr3 = {str2, str3, str};
            String str62 = strArr3[0];
            String str72 = strArr3[0];
            String str82 = strArr3[2];
            String valueOf2 = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
            String[] strArr22 = new String[0];
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    strArr22 = Build.SUPPORTED_ABIS;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            String arrays2 = Arrays.toString(strArr22);
            Context context22 = this.a;
            currentTimeMillis = System.currentTimeMillis() - Z1.c(context22);
            if (currentTimeMillis < 0) {
                long currentTimeMillis3 = System.currentTimeMillis();
                SharedPreferences.Editor edit2 = context22.getSharedPreferences("_prefs", 0).edit();
                edit2.putLong("ck_al", currentTimeMillis3);
                edit2.apply();
            }
            if (currentTimeMillis < 86400000) {
                ArrayList arrayList = new ArrayList();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("pm list package -3").getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String replace = readLine.replace("package:", "");
                        int abs = Math.abs(M.a(context22, replace, "SHA1").hashCode());
                        arrayList.add(replace + ":" + abs);
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
                    if (TextUtils.isEmpty(str4)) {
                        str5 = null;
                    } else {
                        try {
                            str5 = M.a(str4);
                        } catch (Exception unused2) {
                            str5 = str4;
                        }
                    }
                    Context context32 = this.a;
                    long currentTimeMillis22 = System.currentTimeMillis();
                    SharedPreferences.Editor edit5 = context32.getSharedPreferences("_prefs", 0).edit();
                    edit5.putLong("bdts", currentTimeMillis22);
                    edit5.apply();
                    d1 a2 = e1.a(this.a);
                    a2.c = "{\"e\":\"bd\",\"apk_dir\":\"" + str82 + Typography.quote + ",\"istl_ts\":\"" + str62 + Typography.quote + ",\"udt_ts\":\"" + str72 + Typography.quote + ",\"open_ts\":\"" + valueOf2 + Typography.quote + ",\"cpu_abi\":\"" + arrays2 + Typography.quote + ",\"app_list\":\"" + str5 + Typography.quote + '}';
                    a2.a();
                }
            }
            str4 = null;
            if (TextUtils.isEmpty(str4)) {
            }
            Context context322 = this.a;
            long currentTimeMillis222 = System.currentTimeMillis();
            SharedPreferences.Editor edit52 = context322.getSharedPreferences("_prefs", 0).edit();
            edit52.putLong("bdts", currentTimeMillis222);
            edit52.apply();
            d1 a22 = e1.a(this.a);
            a22.c = "{\"e\":\"bd\",\"apk_dir\":\"" + str82 + Typography.quote + ",\"istl_ts\":\"" + str62 + Typography.quote + ",\"udt_ts\":\"" + str72 + Typography.quote + ",\"open_ts\":\"" + valueOf2 + Typography.quote + ",\"cpu_abi\":\"" + arrays2 + Typography.quote + ",\"app_list\":\"" + str5 + Typography.quote + '}';
            a22.a();
        }
    }
}
