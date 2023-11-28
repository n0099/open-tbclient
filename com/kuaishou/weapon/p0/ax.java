package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ax {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject a;

    public ax(Context context) {
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
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.g).intValue(), 1, 0, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public Set b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            HashSet hashSet = new HashSet();
            if (i == 1) {
                hashSet.add(DefaultAudioSink.TAG);
                hashSet.add("processrea");
                hashSet.add("RemitDatab");
                hashSet.add("BrowserBlo");
                hashSet.add("game_push");
                hashSet.add("Godzilla:I");
                hashSet.add("IndexedDB");
                hashSet.add("ScopeRetry");
                hashSet.add("RobustPatc");
                hashSet.add("FrescoIoBo");
                hashSet.add("key_config");
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    return jSONObject.optString(str, null);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public Set a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            HashSet hashSet = new HashSet();
            if (i == 1) {
                hashSet.add("HeapTaskDa");
                hashSet.add("queued-wor");
                hashSet.add("JDWP");
                hashSet.add("dTi");
                hashSet.add("MessageHan");
                hashSet.add("MediaPrefe");
                hashSet.add("CleanupRef");
                hashSet.add("GeoLocatio");
                hashSet.add("securityai");
                hashSet.add("Connectivi");
                hashSet.add("PatchManag");
                hashSet.add("CronetInte");
                hashSet.add("AegonLogge");
                hashSet.add("Countly");
                hashSet.add("DownloadSt");
                hashSet.add("GoogleApiH");
                hashSet.add("PlatformSe");
                hashSet.add("MemoryInfr");
                hashSet.add("CronetLibr");
                hashSet.add("Dex2OatIni");
                hashSet.add("EncodeApiH");
                hashSet.add("CookieMons");
            }
            return hashSet;
        }
        return (Set) invokeI.objValue;
    }

    public Set a(Context context, String str, int i) {
        InterceptResult invokeLLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, i)) == null) {
            JSONObject jSONObject = this.a;
            if (jSONObject != null) {
                try {
                    String string = jSONObject.getString(str);
                    Set a = a(i);
                    if (!TextUtils.isEmpty(string) && string.length() > 3) {
                        JSONArray jSONArray = new JSONArray(string);
                        HashSet hashSet = new HashSet();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String string2 = jSONArray.getString(i2);
                            if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                                int i3 = 0;
                                do {
                                    if (!string2.contains(" ")) {
                                        break;
                                    }
                                    string2 = string2.replace(" ", "");
                                    i3++;
                                } while (i3 <= 200);
                                String replace = string2.replace("\n", "").replace("\t", "").replace("\u200b", "");
                                if (replace.startsWith(":")) {
                                    replace = replace.substring(1);
                                }
                                if (replace.length() > 10) {
                                    str2 = replace.substring(0, 10);
                                } else {
                                    str2 = replace;
                                }
                                if (replace.contains("ridge")) {
                                    hashSet.add(replace);
                                }
                                String packageName = context.getPackageName();
                                if (!replace.contains(packageName) && !packageName.contains(replace) && !a.contains(str2) && !b(i).contains(str2)) {
                                    hashSet.add(replace);
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            return hashSet;
                        }
                        return null;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (Set) invokeLLI.objValue;
    }
}
