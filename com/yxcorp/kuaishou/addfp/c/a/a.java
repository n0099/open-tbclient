package com.yxcorp.kuaishou.addfp.c.a;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.kuaishou.weapon.p0.bi;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.android.a.d;
import com.yxcorp.kuaishou.addfp.android.b.e;
import com.yxcorp.kuaishou.addfp.android.b.g;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i, String str) {
        InterceptResult invokeIL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, str)) == null) {
            Context paramContext = KWEGIDDFP.instance().getParamContext();
            if (paramContext == null) {
                return "";
            }
            String[] split = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
            StringBuilder sb = new StringBuilder();
            sb.append(split[0]);
            sb.append(split[1]);
            sb.append(split[2]);
            if (i == 0) {
                a = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[0], str);
                if (TextUtils.isEmpty(a)) {
                    a = ApiReplaceUtil.getString(paramContext.getContentResolver(), str);
                }
            } else if (i == 1) {
                a = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[1], str);
                if (TextUtils.isEmpty(a)) {
                    a = ApiReplaceUtil.Overload.getString(paramContext.getContentResolver(), str);
                }
            } else if (i == 2) {
                a = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, split[2], str);
                if (TextUtils.isEmpty(a)) {
                    a = Settings.Global.getString(paramContext.getContentResolver(), str);
                }
            } else {
                a = "";
            }
            return a == null ? "" : a;
        }
        return (String) invokeIL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return ApiReplaceUtil.getString(context.getContentResolver(), str);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                str3 = (String) cls.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class, String.class).invoke(cls, str, str2);
            } catch (Exception unused) {
                str3 = null;
            }
            return str3 == null ? "" : str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x00cf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x013e */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0163, code lost:
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0165, code lost:
        r11 = r0;
        r10 = r1;
        r1 = r12;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x013e, code lost:
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x015c A[Catch: IOException -> 0x0153, TRY_LEAVE, TryCatch #3 {IOException -> 0x0153, blocks: (B:95:0x014f, B:99:0x0157, B:101:0x015c), top: B:130:0x014f }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0184 A[Catch: IOException -> 0x0180, TryCatch #18 {IOException -> 0x0180, blocks: (B:114:0x017c, B:118:0x0184, B:120:0x0189), top: B:137:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0189 A[Catch: IOException -> 0x0180, TRY_LEAVE, TryCatch #18 {IOException -> 0x0180, blocks: (B:114:0x017c, B:118:0x0184, B:120:0x0189), top: B:137:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0132 A[Catch: IOException -> 0x012e, TryCatch #6 {IOException -> 0x012e, blocks: (B:78:0x012a, B:82:0x0132, B:84:0x0137), top: B:132:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0137 A[Catch: IOException -> 0x012e, TRY_LEAVE, TryCatch #6 {IOException -> 0x012e, blocks: (B:78:0x012a, B:82:0x0132, B:84:0x0137), top: B:132:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0157 A[Catch: IOException -> 0x0153, TryCatch #3 {IOException -> 0x0153, blocks: (B:95:0x014f, B:99:0x0157, B:101:0x015c), top: B:130:0x014f }] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(String str, boolean z) {
        InterceptResult invokeLZ;
        Throwable th;
        Process process;
        Exception exc;
        IOException iOException;
        DataOutputStream dataOutputStream;
        Throwable th2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str2;
        Exception exc2;
        Process process2;
        IOException iOException2;
        String str3;
        Process process3;
        Process process4;
        String str4;
        String str5;
        String str6;
        StringBuilder sb;
        StringBuilder sb2;
        Exception exc3;
        IOException iOException3;
        DataOutputStream dataOutputStream2;
        DataOutputStream dataOutputStream3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, str, z)) == null) {
            String[] strArr = {str};
            DataOutputStream dataOutputStream4 = null;
            int i = -1;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    if (z) {
                        str6 = bi.y;
                    } else {
                        str6 = "sh";
                    }
                    process = runtime.exec(str6);
                } catch (Throwable th3) {
                    dataOutputStream = null;
                    th2 = th3;
                    process = strArr;
                }
                try {
                    dataOutputStream = new DataOutputStream(process.getOutputStream());
                    for (int i2 = 0; i2 <= 0; i2++) {
                        try {
                            String str7 = strArr[0];
                            if (str7 != null) {
                                dataOutputStream.write(str7.getBytes());
                                dataOutputStream.writeBytes("\n");
                                dataOutputStream.flush();
                            }
                        } catch (IOException e) {
                            bufferedReader = null;
                            bufferedReader2 = null;
                            process2 = process;
                            iOException2 = e;
                            dataOutputStream3 = null;
                            str2 = null;
                            dataOutputStream4 = dataOutputStream;
                            str3 = dataOutputStream3;
                            iOException2.printStackTrace();
                            if (dataOutputStream4 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        } catch (Exception e2) {
                            bufferedReader = null;
                            bufferedReader2 = null;
                            process2 = process;
                            exc2 = e2;
                            dataOutputStream2 = null;
                            str2 = null;
                            dataOutputStream4 = dataOutputStream;
                            str3 = dataOutputStream2;
                            exc2.printStackTrace();
                            if (dataOutputStream4 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = null;
                            bufferedReader2 = null;
                            process4 = process;
                            dataOutputStream4 = dataOutputStream;
                            process3 = process4;
                            if (dataOutputStream4 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                            if (process3 != null) {
                            }
                            throw th;
                        }
                    }
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    i = process.waitFor();
                    sb = new StringBuilder();
                    sb2 = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                } catch (IOException e3) {
                    iOException = e3;
                    str2 = null;
                    bufferedReader = null;
                    bufferedReader2 = null;
                    iOException2 = iOException;
                    process2 = process;
                    str3 = bufferedReader2;
                    iOException2.printStackTrace();
                    if (dataOutputStream4 != null) {
                        try {
                            dataOutputStream4.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Exception e5) {
                    exc = e5;
                    str2 = null;
                    bufferedReader = null;
                    bufferedReader2 = null;
                    exc2 = exc;
                    process2 = process;
                    str3 = bufferedReader2;
                    exc2.printStackTrace();
                    if (dataOutputStream4 != null) {
                        try {
                            dataOutputStream4.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                    bufferedReader2 = null;
                    process3 = process;
                    if (dataOutputStream4 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    if (process3 != null) {
                    }
                    throw th;
                }
            } catch (IOException e7) {
                iOException = e7;
                process = null;
            } catch (Exception e8) {
                exc = e8;
                process = null;
            } catch (Throwable th6) {
                th = th6;
                process = null;
            }
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("|");
                        } catch (Throwable th7) {
                            th2 = th7;
                            th = th2;
                            process4 = process;
                            dataOutputStream4 = dataOutputStream;
                            process3 = process4;
                            if (dataOutputStream4 != null) {
                                try {
                                    dataOutputStream4.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                    if (process3 != null) {
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (process3 != null) {
                                process3.destroy();
                            }
                            throw th;
                        }
                    } catch (IOException e10) {
                        iOException3 = e10;
                        str2 = null;
                    } catch (Exception e11) {
                        exc3 = e11;
                        str2 = null;
                    }
                }
                str5 = sb.toString();
                try {
                    if (str5.length() > 0) {
                        str5 = str5.substring(0, str5.length() - 1);
                    }
                    while (true) {
                        String readLine2 = bufferedReader2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb2.append(readLine2);
                        sb2.append("|");
                    }
                    str4 = sb2.toString();
                    if (str4.length() > 0) {
                        str4 = str4.substring(0, str4.length() - 1);
                    }
                    try {
                        dataOutputStream.close();
                        bufferedReader.close();
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                } catch (IOException e13) {
                    str2 = null;
                    dataOutputStream4 = str5;
                    iOException3 = e13;
                    iOException2 = iOException3;
                    process2 = process;
                    dataOutputStream3 = dataOutputStream4;
                    dataOutputStream4 = dataOutputStream;
                    str3 = dataOutputStream3;
                    iOException2.printStackTrace();
                    if (dataOutputStream4 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                } catch (Exception e14) {
                    str2 = null;
                    dataOutputStream4 = str5;
                    exc3 = e14;
                    exc2 = exc3;
                    process2 = process;
                    dataOutputStream2 = dataOutputStream4;
                    dataOutputStream4 = dataOutputStream;
                    str3 = dataOutputStream2;
                    exc2.printStackTrace();
                    if (dataOutputStream4 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                }
            } catch (IOException e15) {
                str2 = null;
                bufferedReader2 = null;
                iOException2 = e15;
                process2 = process;
                dataOutputStream4 = dataOutputStream;
                str3 = bufferedReader2;
                iOException2.printStackTrace();
                if (dataOutputStream4 != null) {
                }
                if (bufferedReader != null) {
                }
                if (bufferedReader2 != null) {
                }
            } catch (Exception e16) {
                str2 = null;
                bufferedReader2 = null;
                exc2 = e16;
                process2 = process;
                dataOutputStream4 = dataOutputStream;
                str3 = bufferedReader2;
                exc2.printStackTrace();
                if (dataOutputStream4 != null) {
                }
                if (bufferedReader != null) {
                }
                if (bufferedReader2 != null) {
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedReader2 = null;
                process4 = process;
                dataOutputStream4 = dataOutputStream;
                process3 = process4;
                if (dataOutputStream4 != null) {
                }
                if (bufferedReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                if (process3 != null) {
                }
                throw th;
            }
            process.destroy();
            str2 = str4;
            str3 = str5;
            return new e(i, str3, str2);
        }
        return (e) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = Build.MANUFACTURER;
            boolean z7 = false;
            if (!str.equalsIgnoreCase(RomUtils.ROM_XIAOMI)) {
                String str2 = Build.BRAND;
                if (!str2.equalsIgnoreCase(RomUtils.ROM_XIAOMI) && !str2.equalsIgnoreCase("REDMI") && !str2.equalsIgnoreCase("MEITU") && TextUtils.isEmpty(a("ro.miui.ui.version.name", ""))) {
                    z = false;
                    if (!z) {
                        if (!str.equalsIgnoreCase("BLACKSHARK") && !Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            if (!str.equalsIgnoreCase("SAMSUNG") && !Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (z3) {
                                return "3";
                            }
                            if (!str.equalsIgnoreCase("VIVO")) {
                                String str3 = Build.BRAND;
                                if (!str3.equalsIgnoreCase("VIVO") && !str3.equalsIgnoreCase("IQOO") && TextUtils.isEmpty(a("ro.vivo.os.version", ""))) {
                                    z4 = false;
                                    if (!z4) {
                                        return "2";
                                    }
                                    if (!str.equalsIgnoreCase("HUAWEI") && !Build.BRAND.equalsIgnoreCase("HUAWEI")) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        return "1";
                                    }
                                    if (!str.equalsIgnoreCase("OPPO")) {
                                        String str4 = Build.BRAND;
                                        if (!str4.equalsIgnoreCase("OPPO") && !str4.equalsIgnoreCase("REALME") && TextUtils.isEmpty(a("ro.build.version.opporom", ""))) {
                                            z6 = false;
                                            if (!z6) {
                                                if (!((str.equalsIgnoreCase(RomTypeUtil.ROM_ONEPLUS) || Build.BRAND.equalsIgnoreCase(RomTypeUtil.ROM_ONEPLUS)) ? true : true)) {
                                                    if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                                                        return "7";
                                                    }
                                                    return "0";
                                                }
                                            }
                                            return "5";
                                        }
                                    }
                                    z6 = true;
                                    if (!z6) {
                                    }
                                    return "5";
                                }
                            }
                            z4 = true;
                            if (!z4) {
                            }
                        }
                    }
                    return "4";
                }
            }
            z = true;
            if (!z) {
            }
            return "4";
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00af A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #2 {all -> 0x009d, blocks: (B:39:0x00a7, B:41:0x00af), top: B:61:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5 A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #1 {all -> 0x00cc, blocks: (B:5:0x0008, B:8:0x001a, B:10:0x0024, B:21:0x0059, B:23:0x005f, B:26:0x0066, B:28:0x0070, B:32:0x0080, B:34:0x0086, B:35:0x009d, B:43:0x00bf, B:45:0x00c5, B:30:0x0076, B:15:0x003d, B:17:0x0047, B:19:0x0055), top: B:59:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        LinkedHashMap b;
        int i;
        ListIterator listIterator;
        JSONObject jSONObject;
        Map.Entry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                String a = a(context, "k_w_o_d_out_dtt");
                String str2 = "";
                if (TextUtils.isEmpty(a)) {
                    if (g.a(context, new String[]{com.kuaishou.weapon.p0.g.i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        str2 = d.a(context).a("Lm91a2R0ZnQ=");
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                Settings.System.putString(context.getContentResolver(), "k_w_o_d_out_dtt", str2);
                            } catch (Throwable unused) {
                            }
                        }
                    } else {
                        str = "KWE_PN";
                        if (!TextUtils.isEmpty(a) && TextUtils.isEmpty(str2)) {
                            return "KWE_N";
                        }
                        b = d.a(context).b(a);
                        if (b != null || b.size() == 0) {
                            b = d.a(context).b(str2);
                        }
                        if (b != null && b.size() > 0) {
                            i = 0;
                            listIterator = new ArrayList(b.entrySet()).listIterator(b.size());
                            jSONObject = new JSONObject();
                            while (listIterator.hasPrevious() && i < 10) {
                                try {
                                    entry = (Map.Entry) listIterator.previous();
                                    if (entry != null) {
                                        jSONObject.put((String) entry.getKey(), entry.getValue());
                                    }
                                    i++;
                                } catch (Throwable unused2) {
                                }
                            }
                            if (jSONObject.length() > 0) {
                                return jSONObject.toString();
                            }
                        }
                        return str;
                    }
                } else if (g.a(context, new String[]{com.kuaishou.weapon.p0.g.i, "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                    str2 = d.a(context).a("Lm91a2R0ZnQ=");
                    if (TextUtils.isEmpty(str2)) {
                        d.a(context, a);
                    }
                }
                str = "KWE_N";
                if (!TextUtils.isEmpty(a)) {
                }
                b = d.a(context).b(a);
                if (b != null) {
                }
                b = d.a(context).b(str2);
                if (b != null) {
                    i = 0;
                    listIterator = new ArrayList(b.entrySet()).listIterator(b.size());
                    jSONObject = new JSONObject();
                    while (listIterator.hasPrevious()) {
                        entry = (Map.Entry) listIterator.previous();
                        if (entry != null) {
                        }
                        i++;
                    }
                    if (jSONObject.length() > 0) {
                    }
                }
                return str;
            } catch (Throwable th) {
                th.printStackTrace();
                return "KWE_PE";
            }
        }
        return (String) invokeL.objValue;
    }
}
