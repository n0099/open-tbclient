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
/* loaded from: classes8.dex */
public class a0 {
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

    public a0() {
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
        this.a = j.a("f118f1f9431de3a626df48d7302911", "0820");
        this.b = j.a("f118f1ef4616f3fc27d1", "0820");
        this.c = j.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");
        this.d = j.a("fc03e7a44510", "0820");
    }

    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.h == null || this.h.size() <= 0) {
                    return null;
                }
                return this.h;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x01e5, code lost:
        if (r1 != null) goto L131;
     */
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
        Set<String> set;
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
                        if (!substring.contains(this.a) || substring.contains(this.b) || substring.contains(this.c)) {
                            set = this.e;
                        } else {
                            if (substring.contains(this.d) && !substring.contains("libart.so") && !substring.contains("libart64.so")) {
                                this.h.add(substring);
                            }
                            if (!substring.contains("es/.0/") && !substring.contains("app_DvaPlugin") && !substring.contains("/system_ext/") && (!substring.contains(packageName) || substring.contains("odex_cache") || substring.contains("app_"))) {
                                String substring2 = substring.length() > 10 ? substring.substring(0, 10) : substring;
                                if (!substring.contains("FeatureFramework") && !substring.contains("GmsConfigOverlay") && !substring.contains("/system/app/") && !substring.contains("/system/vendor/lib/") && !substring.contains("/hw_") && !substring.contains("/system/product/lib")) {
                                    if (substring.contains("mokee-") || substring.contains("mokee.")) {
                                        set = this.f;
                                    } else if (substring.contains("lineageos-") || substring.contains("lineageos.") || substring.contains("Hook") || substring.contains("hook")) {
                                        set = this.g;
                                    } else if (substring.contains("posedBridge") || !hashSet2.contains(substring2)) {
                                        hashSet.add(substring);
                                        if (hashSet.size() > 15 || this.e.size() > 10 || this.f.size() > 10 || this.g.size() > 10) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        set.add(substring);
                    }
                }
                z = true;
                if (z) {
                    substring = readLine.substring(indexOf);
                    if (substring.contains(this.a)) {
                    }
                    set = this.e;
                    set.add(substring);
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

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.f == null || this.f.size() <= 0) {
                    return 0;
                }
                return this.f.size();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public Set<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.g == null || this.g.size() <= 0) {
                    return null;
                }
                return this.g;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public Set d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                HashSet hashSet = new HashSet();
                if (this.e == null || this.e.size() <= 0) {
                    return null;
                }
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
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public JSONObject e() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (this.e == null || this.e.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                for (String str2 : this.e) {
                    if (str2.contains(this.a)) {
                        str = "0";
                    } else if (str2.contains(this.b)) {
                        str = "1";
                    } else if (str2.contains(this.c)) {
                        str = "2";
                    }
                    jSONObject.put(str, 1);
                }
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
