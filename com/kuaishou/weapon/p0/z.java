package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
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
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public Set<String> e;
    public Set<String> f;
    public Set<String> g;
    public Set<String> h;

    public z() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new HashSet();
        this.f = new HashSet();
        this.g = new HashSet();
        this.h = new HashSet();
        this.a = i.a("f118f1f9431de3a626df48d7302911", "0820");
        this.b = i.a("f118f1ef4616f3fc27d1", "0820");
        this.c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");
        this.d = i.a("fc03e7a44510", "0820");
    }

    public Set e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                HashSet hashSet = new HashSet();
                if (this.e != null && this.e.size() > 0) {
                    for (String str : this.e) {
                        if (str.endsWith("dex")) {
                            hashSet.add(str);
                        }
                        if (hashSet.size() > 5) {
                            break;
                        }
                    }
                    if (hashSet.size() > 0) {
                        return hashSet;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f != null && this.f.size() > 0) {
                    return this.f.size();
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public Set<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.g != null && this.g.size() > 0) {
                    return this.g;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public Set<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.h != null && this.h.size() > 0) {
                    return this.h;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x01f6, code lost:
        if (r1 == null) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0126 A[Catch: all -> 0x01e9, Exception -> 0x01ec, TryCatch #8 {Exception -> 0x01ec, all -> 0x01e9, blocks: (B:6:0x0011, B:10:0x004c, B:11:0x0060, B:13:0x0066, B:15:0x006f, B:17:0x0077, B:19:0x007f, B:21:0x0087, B:27:0x0095, B:29:0x009d, B:31:0x00a5, B:33:0x00ad, B:35:0x00b5, B:37:0x00c1, B:39:0x00c9, B:42:0x00d3, B:44:0x00db, B:46:0x00e3, B:48:0x00eb, B:49:0x00f0, B:51:0x00f8, B:53:0x0100, B:55:0x0108, B:57:0x010e, B:59:0x0116, B:61:0x011e, B:63:0x0126, B:65:0x012c, B:67:0x0134, B:69:0x013c, B:71:0x0144, B:73:0x014c, B:75:0x0154, B:77:0x015c, B:79:0x0164, B:82:0x016d, B:84:0x0175, B:86:0x017d, B:88:0x0185, B:91:0x018e, B:93:0x0196, B:95:0x019c, B:97:0x01a7, B:99:0x01af, B:101:0x01b7, B:104:0x01c1, B:105:0x01c8, B:106:0x01cf, B:107:0x01d6, B:109:0x01dc), top: B:141:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
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
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
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
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h.clear();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && !readLine.endsWith(".jar") && !readLine.endsWith(".dex") && !readLine.endsWith(".odex") && !readLine.endsWith(".so")) {
                    z = false;
                    if (z && !readLine.contains("gson.jar") && !readLine.contains("volley.jar") && !readLine.contains("FwkPlugin") && (indexOf = readLine.indexOf(47)) >= 0) {
                        substring = readLine.substring(indexOf);
                        if (!substring.contains(this.a) && !substring.contains(this.b) && !substring.contains(this.c)) {
                            if (substring.contains(this.d) && !substring.contains("libart.so") && !substring.contains("libart64.so")) {
                                this.h.add(substring);
                            }
                            if (substring.contains("es/.0/") && !substring.contains("app_DvaPlugin") && !substring.contains("/system_ext/") && (!substring.contains(packageName) || substring.contains("odex_cache") || substring.contains("app_"))) {
                                if (substring.length() <= 10) {
                                    str = substring.substring(0, 10);
                                } else {
                                    str = substring;
                                }
                                if (substring.contains("FeatureFramework") && !substring.contains("GmsConfigOverlay") && !substring.contains("/system/app/") && !substring.contains("/system/vendor/lib/") && !substring.contains("/hw_") && !substring.contains("/system/product/lib")) {
                                    if (!substring.contains("mokee-") && !substring.contains("mokee.")) {
                                        if (!substring.contains("lineageos-") && !substring.contains("lineageos.") && !substring.contains("Hook") && !substring.contains("hook")) {
                                            if (!substring.contains("posedBridge") || !hashSet2.contains(str)) {
                                                hashSet.add(substring);
                                                if (hashSet.size() <= 15 || this.e.size() > 10 || this.f.size() > 10 || this.g.size() > 10) {
                                                    break;
                                                    break;
                                                }
                                            }
                                        }
                                        this.g.add(substring);
                                    }
                                    this.f.add(substring);
                                }
                            }
                        }
                        this.e.add(substring);
                    }
                }
                z = true;
                if (z) {
                    substring = readLine.substring(indexOf);
                    if (!substring.contains(this.a)) {
                        if (substring.contains(this.d)) {
                            this.h.add(substring);
                        }
                        if (substring.contains("es/.0/")) {
                            continue;
                        } else {
                            if (substring.length() <= 10) {
                            }
                            if (substring.contains("FeatureFramework")) {
                                continue;
                            } else {
                                if (!substring.contains("mokee-")) {
                                    if (!substring.contains("lineageos-")) {
                                        if (!substring.contains("posedBridge")) {
                                        }
                                        hashSet.add(substring);
                                        if (hashSet.size() <= 15) {
                                            break;
                                        }
                                    }
                                    this.g.add(substring);
                                }
                                this.f.add(substring);
                            }
                        }
                    }
                    this.e.add(substring);
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
                return null;
            }
        } else {
            return (JSONArray) invokeL.objValue;
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.e != null && this.e.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : this.e) {
                        if (str.contains(this.a)) {
                            jSONObject.put("0", 1);
                        } else if (str.contains(this.b)) {
                            jSONObject.put("1", 1);
                        } else if (str.contains(this.c)) {
                            jSONObject.put("2", 1);
                        }
                    }
                    if (jSONObject.length() > 0) {
                        return jSONObject;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
