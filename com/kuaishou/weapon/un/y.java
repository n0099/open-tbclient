package com.kuaishou.weapon.un;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0112, code lost:
        if (r1 == null) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00f6 A[EDGE_INSN: B:115:0x00f6->B:59:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3 A[Catch: all -> 0x0105, Exception -> 0x0108, TryCatch #8 {Exception -> 0x0108, all -> 0x0105, blocks: (B:6:0x0015, B:10:0x0050, B:12:0x0056, B:14:0x005f, B:16:0x0067, B:18:0x006f, B:25:0x007e, B:28:0x0085, B:30:0x008d, B:32:0x0095, B:35:0x009e, B:38:0x00a7, B:40:0x00b3, B:42:0x00b9, B:44:0x00c1, B:46:0x00c9, B:49:0x00d3, B:51:0x00db, B:54:0x00e5, B:57:0x00ed, B:59:0x00f6, B:61:0x00fc), top: B:91:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray a(Context context) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        HashSet hashSet;
        HashSet hashSet2;
        String packageName;
        boolean z;
        int indexOf;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(u1.a("jNPRzMCM0MbPxYzOwtPQ")));
                try {
                    hashSet = new HashSet();
                    hashSet2 = new HashSet();
                    hashSet2.add("/system/fr");
                    hashSet2.add("/system/em");
                    hashSet2.add("/apex/com.");
                    hashSet2.add("/data/dalv");
                    hashSet2.add("/system/li");
                    hashSet2.add("/vendor/li");
                    hashSet2.add("/system/ve");
                    packageName = context.getPackageName();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
            if (TextUtils.isEmpty(packageName)) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
                return null;
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.endsWith(".jar") && !readLine.endsWith(".dex") && !readLine.endsWith(".odex") && !readLine.endsWith(".so")) {
                    z = false;
                    if (z && !readLine.contains(packageName) && !readLine.contains("gson.jar") && !readLine.contains("volley.jar") && !readLine.contains("FwkPlugin") && (indexOf = readLine.indexOf(47)) >= 0) {
                        substring = readLine.substring(indexOf);
                        String substring2 = substring.length() <= 10 ? substring.substring(0, 10) : substring;
                        if (substring.contains("es/.0/") && !substring.contains("app_DvaPlugin") && !substring.contains("/system_ext/") && !substring.contains("/system/vendor/lib/") && !substring.contains("/hw_") && !hashSet2.contains(substring2)) {
                            hashSet.add(substring);
                            if (hashSet.size() <= 10) {
                                break;
                            }
                        }
                    }
                }
                z = true;
                if (z) {
                    substring = readLine.substring(indexOf);
                    if (substring.length() <= 10) {
                    }
                    if (substring.contains("es/.0/")) {
                        continue;
                    } else {
                        hashSet.add(substring);
                        if (hashSet.size() <= 10) {
                        }
                    }
                }
            }
            if (hashSet.size() > 0) {
                JSONArray jSONArray = new JSONArray((Collection) hashSet);
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
                return jSONArray;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused6) {
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }
}
