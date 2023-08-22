package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;
    public int b;

    public b1(Context context, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Engine.loadSuccess && z) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(l2.f).intValue(), 0, i, str);
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    return h.a(context, h.i) != -1;
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    return jSONObject.getString(str);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c1, code lost:
        if (r7 != null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject c() {
        InterceptResult invokeV;
        LineNumberReader lineNumberReader;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return (JSONObject) invokeV.objValue;
        }
        JSONObject jSONObject = new JSONObject();
        StringBuilder sb = new StringBuilder();
        this.b = 0;
        try {
            inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(j.a("2afcabd3eda8ae", "077f")).getInputStream());
            try {
                lineNumberReader = new LineNumberReader(inputStreamReader);
                try {
                    int i = 0;
                    for (String readLine = lineNumberReader.readLine(); !TextUtils.isEmpty(readLine); readLine = lineNumberReader.readLine()) {
                        if (readLine.contains("]:")) {
                            String[] split = readLine.split("]:");
                            if (split.length == 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                if (trim.length() > 2 && trim2.length() > 2) {
                                    String substring = trim.substring(1);
                                    String substring2 = trim2.substring(1, trim2.length() - 1);
                                    if (substring.startsWith("init.svc.") && (substring2.equals("stopped") || substring2.equals("running"))) {
                                        sb.append(substring.replace("init.svc.", ""));
                                    }
                                    jSONObject.put(substring, substring2);
                                }
                            }
                        }
                        i++;
                        if (i > 1300) {
                            break;
                        }
                    }
                    if (jSONObject.length() > 10) {
                        jSONObject.put("n", jSONObject.length());
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused) {
                        try {
                            lineNumberReader.close();
                        } catch (IOException unused2) {
                        }
                        if (jSONObject.length() > 10) {
                            return jSONObject;
                        }
                        return null;
                    }
                } catch (Throwable unused3) {
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            } catch (Throwable unused5) {
                lineNumberReader = null;
            }
        } catch (Throwable unused6) {
            lineNumberReader = null;
            inputStreamReader = null;
        }
    }
}
