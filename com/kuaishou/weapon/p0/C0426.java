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
/* renamed from: com.kuaishou.weapon.p0.ˑ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0426 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public String f598;

    /* renamed from: ʼ  reason: contains not printable characters */
    public String f599;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f600;

    /* renamed from: ʾ  reason: contains not printable characters */
    public String f601;

    /* renamed from: ʿ  reason: contains not printable characters */
    public Set<String> f602;

    /* renamed from: ˆ  reason: contains not printable characters */
    public Set<String> f603;

    /* renamed from: ˈ  reason: contains not printable characters */
    public Set<String> f604;

    /* renamed from: ˉ  reason: contains not printable characters */
    public Set<String> f605;

    public C0426() {
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
        this.f602 = new HashSet();
        this.f603 = new HashSet();
        this.f604 = new HashSet();
        this.f605 = new HashSet();
        this.f598 = C0307.m182("f118f1f9431de3a626df48d7302911", "0820");
        this.f599 = C0307.m182("f118f1ef4616f3fc27d1", "0820");
        this.f600 = C0307.m182("f118f1e84f0bf5ba3bd1579c6d35", "0820");
        this.f601 = C0307.m182("fc03e7a44510", "0820");
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Set<String> m814() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f605 == null || this.f605.size() <= 0) {
                    return null;
                }
                return this.f605;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x01e5, code lost:
        if (r1 != null) goto L131;
     */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray m815(Context context) {
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
            this.f602.clear();
            this.f603.clear();
            this.f604.clear();
            this.f605.clear();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && !readLine.endsWith(".jar") && !readLine.endsWith(".dex") && !readLine.endsWith(".odex") && !readLine.endsWith(".so")) {
                    z = false;
                    if (z && !readLine.contains("gson.jar") && !readLine.contains("volley.jar") && !readLine.contains("FwkPlugin") && (indexOf = readLine.indexOf(47)) >= 0) {
                        substring = readLine.substring(indexOf);
                        if (!substring.contains(this.f598) || substring.contains(this.f599) || substring.contains(this.f600)) {
                            set = this.f602;
                        } else {
                            if (substring.contains(this.f601) && !substring.contains("libart.so") && !substring.contains("libart64.so")) {
                                this.f605.add(substring);
                            }
                            if (!substring.contains("es/.0/") && !substring.contains("app_DvaPlugin") && !substring.contains("/system_ext/") && (!substring.contains(packageName) || substring.contains("odex_cache") || substring.contains("app_"))) {
                                String substring2 = substring.length() > 10 ? substring.substring(0, 10) : substring;
                                if (!substring.contains("FeatureFramework") && !substring.contains("GmsConfigOverlay") && !substring.contains("/system/app/") && !substring.contains("/system/vendor/lib/") && !substring.contains("/hw_") && !substring.contains("/system/product/lib")) {
                                    if (substring.contains("mokee-") || substring.contains("mokee.")) {
                                        set = this.f603;
                                    } else if (substring.contains("lineageos-") || substring.contains("lineageos.") || substring.contains("Hook") || substring.contains("hook")) {
                                        set = this.f604;
                                    } else if (substring.contains("posedBridge") || !hashSet2.contains(substring2)) {
                                        hashSet.add(substring);
                                        if (hashSet.size() > 15 || this.f602.size() > 10 || this.f603.size() > 10 || this.f604.size() > 10) {
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
                    if (substring.contains(this.f598)) {
                    }
                    set = this.f602;
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public int m816() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (this.f603 == null || this.f603.size() <= 0) {
                    return 0;
                }
                return this.f603.size();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public Set<String> m817() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (this.f604 == null || this.f604.size() <= 0) {
                    return null;
                }
                return this.f604;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public Set m818() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                HashSet hashSet = new HashSet();
                if (this.f602 == null || this.f602.size() <= 0) {
                    return null;
                }
                for (String str : this.f602) {
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

    /* renamed from: ʿ  reason: contains not printable characters */
    public JSONObject m819() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (this.f602 == null || this.f602.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                for (String str2 : this.f602) {
                    if (str2.contains(this.f598)) {
                        str = "0";
                    } else if (str2.contains(this.f599)) {
                        str = "1";
                    } else if (str2.contains(this.f600)) {
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
