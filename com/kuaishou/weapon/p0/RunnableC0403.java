package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qq.e.comm.constants.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ˉ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class RunnableC0403 implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final int f436 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final int f437 = 2;

    /* renamed from: ˑ  reason: contains not printable characters */
    public static final int f438 = 4;

    /* renamed from: י  reason: contains not printable characters */
    public static final int f439 = 0;

    /* renamed from: ـ  reason: contains not printable characters */
    public static final int f440 = 8;

    /* renamed from: ٴ  reason: contains not printable characters */
    public static final int f441 = 1;

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static final int f442 = 3;

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static final int f443 = 4;

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static long f444;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f445;

    /* renamed from: ʼ  reason: contains not printable characters */
    public C0392 f446;

    /* renamed from: ʽ  reason: contains not printable characters */
    public C0400 f447;

    /* renamed from: ʾ  reason: contains not printable characters */
    public File f448;

    /* renamed from: ʿ  reason: contains not printable characters */
    public C0390 f449;

    /* renamed from: ˆ  reason: contains not printable characters */
    public int f450;

    /* renamed from: ˈ  reason: contains not printable characters */
    public int f451;

    /* renamed from: ˉ  reason: contains not printable characters */
    public boolean f452;

    /* renamed from: ˊ  reason: contains not printable characters */
    public List<Integer> f453;

    /* renamed from: ˋ  reason: contains not printable characters */
    public Map<Integer, C0404> f454;

    /* renamed from: com.kuaishou.weapon.p0.ˉ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class C0404 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public int f455;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ RunnableC0403 f456;

        public C0404(RunnableC0403 runnableC0403, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnableC0403, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f456 = runnableC0403;
            this.f455 = i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1651755914, "Lcom/kuaishou/weapon/p0/ˉ;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1651755914, "Lcom/kuaishou/weapon/p0/ˉ;");
        }
    }

    public RunnableC0403(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f450 = 0;
        this.f451 = 0;
        this.f452 = false;
        this.f453 = new ArrayList();
        this.f454 = new HashMap();
        this.f445 = context;
        this.f446 = C0392.m492(context);
        this.f447 = C0400.m529(context);
        this.f449 = C0390.m479(context);
        this.f448 = new File(context.getFilesDir(), ".tmp");
        this.f450 = i;
        this.f452 = z;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v10 long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v4 long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0125: IGET  (r8v1 int A[REMOVE]) = (r20v0 com.kuaishou.weapon.p0.ˆ) com.kuaishou.weapon.p0.ˆ.ʻ int)] */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m547(C0398 c0398) {
        File file;
        Object obj;
        long j;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, c0398) == null) {
            try {
                if (TextUtils.isEmpty(c0398.f386) || c0398.f386.length() < 10) {
                    this.f446.m499(c0398.f377, c0398.f380, (PackageInfo) null);
                    return;
                }
                if (!this.f448.exists()) {
                    this.f448.mkdir();
                }
                File file2 = this.f448;
                File file3 = new File(file2, c0398.f377 + "-" + c0398.f380 + ".tmp");
                File file4 = this.f448;
                File file5 = new File(file4, c0398.f377 + "-" + c0398.f380 + ".zip");
                boolean m314 = C0346.m302().m314(c0398.f385, file3);
                if (m314) {
                    if (file5.exists()) {
                        file5.delete();
                    }
                    int m939 = C0440.m939(file3.getAbsolutePath(), file5.getAbsolutePath(), C0446.m974("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(IMAudioTransRequest.CHARSET), 2));
                    if (m939 != 0) {
                        long length = file5.exists() ? file5.length() : -1L;
                        if (file5.exists()) {
                            file5.delete();
                        }
                        HashMap hashMap = new HashMap();
                        file = file5;
                        hashMap.put("e", C0331.f91);
                        StringBuilder sb = new StringBuilder();
                        obj2 = "e";
                        sb.append(c0398.f377);
                        hashMap.put(PushConstants.URI_PACKAGE_NAME, sb.toString());
                        hashMap.put("pv", c0398.f380);
                        hashMap.put("m", c0398.f386);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(length);
                        hashMap.put("len", sb2.toString());
                        hashMap.put("l", "T");
                        C0433.m856(this.f445, "1002001", hashMap);
                        m314 = false;
                    } else {
                        file = file5;
                        obj2 = "e";
                    }
                    if (m939 == 0 && file3.exists()) {
                        file3.delete();
                    }
                    obj = obj2;
                } else {
                    file = file5;
                    HashMap hashMap2 = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(c0398.f377);
                    hashMap2.put(PushConstants.URI_PACKAGE_NAME, sb3.toString());
                    hashMap2.put("pv", c0398.f380);
                    hashMap2.put("m", c0398.f386);
                    obj = "e";
                    hashMap2.put(obj, "download fail");
                    hashMap2.put("l", "T");
                    C0433.m856(this.f445, "1002001", hashMap2);
                    this.f454.put(Integer.valueOf(c0398.f377), new C0404(this, 3));
                }
                String m173 = C0304.m173(file);
                if (m314 && c0398.f386.equals(m173)) {
                    C0383.m460(file.getAbsolutePath(), Boolean.TRUE);
                    c0398.f381 = file.getAbsolutePath();
                    if (this.f446.m500(c0398, (String) null, (String) null)) {
                        if (this.f454 != null && !this.f454.containsKey(Integer.valueOf(c0398.f377))) {
                            this.f454.put(Integer.valueOf(c0398.f377), new C0404(this, 1));
                        }
                        this.f449.m483(C0390.f345, System.currentTimeMillis(), true);
                        return;
                    }
                    if (this.f454 != null && !this.f454.containsKey(Integer.valueOf(c0398.f377))) {
                        this.f454.put(Integer.valueOf(c0398.f377), new C0404(this, 4));
                    }
                    this.f446.m499(c0398.f377, c0398.f380, (PackageInfo) null);
                    return;
                }
                if (file3.exists()) {
                    j = file3.length();
                    file3.delete();
                } else {
                    j = -1;
                }
                this.f446.m499(c0398.f377, c0398.f380, (PackageInfo) null);
                HashMap hashMap3 = new HashMap();
                hashMap3.put(obj, C0331.f92);
                hashMap3.put(Constants.KEYS.RET, m314 ? "1" : "0");
                hashMap3.put(FunAdSdk.PLATFORM_AM, c0398.f386);
                hashMap3.put("acm", m173);
                hashMap3.put("p", file.getAbsolutePath());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(j);
                hashMap3.put("len", sb4.toString());
                hashMap3.put("l", "T");
                C0433.m856(this.f445, "1002001", hashMap3);
            } catch (Throwable unused) {
                this.f446.m499(c0398.f377, c0398.f380, (PackageInfo) null);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                try {
                } finally {
                    WeaponHI.iD();
                }
            } catch (Throwable unused) {
                this.f446.m503();
                this.f447.m534();
            }
            synchronized (RunnableC0403.class) {
                if (this.f450 == 1 || this.f450 == 2 || this.f450 == 4 || this.f452 || System.currentTimeMillis() - f444 >= 300000) {
                    this.f447.m543();
                    f444 = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - this.f449.m486(C0390.f345)) - (this.f449.m480(C0390.f346, 6) * 3600000) > 0) {
                        List<C0398> m538 = this.f447.m538();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<C0398> arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        JSONObject m548 = m548();
                        if (m548 == null) {
                            throw new Exception("pluginJsonObject is null ");
                        }
                        boolean z2 = false;
                        try {
                            boolean m459 = C0381.m459(this.f445);
                            Iterator<String> keys = m548.keys();
                            HashSet<String> hashSet = new HashSet();
                            boolean z3 = false;
                            while (keys.hasNext()) {
                                String next = keys.next();
                                if (m459 && next.endsWith(WebKitFactory.OS_64)) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".32";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                } else if (!m459 && next.endsWith("32")) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".64";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                } else if (m459 && next.endsWith(V8Engine.TYPE_V8)) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".v7";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                } else if (!m459 && next.endsWith("v7")) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".v8";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                }
                            }
                            if (z3) {
                                for (String str2 : hashSet) {
                                    m548.remove(str2);
                                }
                            }
                            z2 = z3;
                        } catch (Throwable unused2) {
                        }
                        Iterator<String> keys2 = m548.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            C0398 m226 = C0318.m226(m548.optJSONObject(next2));
                            if (m226 != null) {
                                if (z2 && !m226.f401 && (next2.endsWith("32") || next2.endsWith(WebKitFactory.OS_64) || next2.endsWith("v7") || next2.endsWith(V8Engine.TYPE_V8))) {
                                    m226.f401 = true;
                                }
                                if (m226.f398) {
                                    arrayList4.add(next2);
                                }
                                if (!m226.f401) {
                                    arrayList3.add(m226);
                                }
                                int indexOf = m538.indexOf(m226);
                                if (indexOf < 0 || !m226.f401) {
                                    it = keys2;
                                    jSONObject = m548;
                                    z = z2;
                                    if (m226.f401) {
                                        arrayList2.add(m226);
                                    }
                                } else {
                                    C0398 c0398 = m538.get(indexOf);
                                    if (C0383.m465(m226.f380, c0398.f380)) {
                                        if (m226.f400 != c0398.f400) {
                                            this.f447.m541(m226.f377, m226.f400);
                                        }
                                        if (!this.f447.m542(m226.f377)) {
                                            arrayList2.add(m226);
                                        }
                                        it = keys2;
                                        jSONObject = m548;
                                        z = z2;
                                    } else {
                                        jSONObject = m548;
                                        z = z2;
                                        it = keys2;
                                        this.f449.m483(C0390.f345, System.currentTimeMillis(), true);
                                        if (m226.f400 != c0398.f400) {
                                            this.f447.m541(m226.f377, m226.f400);
                                        }
                                        arrayList.add(m226);
                                    }
                                    m538.remove(indexOf);
                                }
                                m548 = jSONObject;
                                z2 = z;
                                keys2 = it;
                            }
                        }
                        for (C0398 c03982 : m538) {
                            if (!arrayList4.contains(c03982.f379)) {
                                if (this.f453 != null) {
                                    this.f453.add(Integer.valueOf(c03982.f377));
                                }
                                this.f446.m497(c03982.f379);
                            }
                        }
                        for (C0398 c03983 : arrayList3) {
                            if (!arrayList4.contains(c03983.f379)) {
                                if (this.f453 != null) {
                                    this.f453.add(Integer.valueOf(c03983.f377));
                                }
                                this.f446.m497(c03983.f379);
                            }
                        }
                        ArrayList<C0398> arrayList5 = new ArrayList();
                        if (arrayList2.size() != 0) {
                            arrayList5.addAll(arrayList2);
                        }
                        if (arrayList.size() != 0) {
                            arrayList5.addAll(arrayList);
                        }
                        for (C0398 c03984 : arrayList5) {
                            if (c03984 != null) {
                                if (arrayList.contains(c03984)) {
                                    this.f446.m499(c03984.f377, c03984.f380, (PackageInfo) null);
                                } else if (arrayList2.contains(c03984)) {
                                    m547(c03984);
                                }
                            }
                        }
                    } else {
                        this.f446.m503();
                        this.f447.m534();
                    }
                }
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m548() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                String str = C0345.f141 + C0345.f147;
                String m363 = C0355.m363(this.f445);
                if (!TextUtils.isEmpty(m363)) {
                    str = str + "?" + m363;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject m362 = C0355.m362(this.f445);
                if (m362 != null) {
                    jSONObject.put("data", new C0297(this.f445).m150(m362.toString()));
                }
                JSONObject jSONObject2 = new JSONObject(C0346.m302().m310(new C0348(str, jSONObject)));
                int optInt = jSONObject2.optInt("result", 0);
                if (optInt != 1) {
                    if (optInt == -7) {
                        C0390.m479(this.f445).m482(C0390.f344, 1, false);
                        return null;
                    }
                    return null;
                }
                String m148 = new C0297(this.f445).m148(jSONObject2.getString("antispamPluginManageRsp"));
                if (TextUtils.isEmpty(m148)) {
                    if (this.f451 == 0) {
                        this.f451 = 8;
                    }
                    throw new NetworkErrorException("kuaishou risk pluginloader response is null");
                }
                JSONObject jSONObject3 = new JSONObject(m148);
                if (jSONObject3.optInt("status", 0) == 1) {
                    return jSONObject3.optJSONObject("plugin");
                }
                if (this.f449 != null) {
                    this.f449.m483(C0390.f345, System.currentTimeMillis(), true);
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
