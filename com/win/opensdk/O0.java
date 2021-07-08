package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class O0 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ P0 f39429a;

    public O0(P0 p0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39429a = p0;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            HashMap a2 = M0.a(this.f39429a.f39430a);
            a2.put("pid", this.f39429a.f39431b);
            Q0.a(this.f39429a, a2);
            P0 p0 = this.f39429a;
            char c2 = 0;
            try {
                String[] split = s1.o(p0.f39430a).split(",");
                ArrayList<A0> arrayList = new ArrayList();
                arrayList.clear();
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String[] split2 = split[i2].split(":");
                    String str2 = split2[c2];
                    String str3 = split2[1];
                    if (System.currentTimeMillis() - Long.parseLong(str3) < s1.m(p0.f39430a)) {
                        A0 a0 = new A0();
                        a0.f39319a = str2;
                        a0.f39320b = Long.parseLong(str3);
                        arrayList.add(a0);
                    }
                    i2++;
                    c2 = 0;
                }
                if (!arrayList.isEmpty()) {
                    String str4 = "";
                    String str5 = str4;
                    for (A0 a02 : arrayList) {
                        str4 = str4 + a02.f39319a + ",";
                        str5 = str5 + a02.f39319a + ":" + a02.f39320b + ",";
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        a2.put("a605", str4.substring(0, str4.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        s1.b(p0.f39430a, str5.substring(0, str5.length() - 1), true);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            P0 p02 = this.f39429a;
            try {
                String[] split3 = s1.n(p02.f39430a).split(",");
                ArrayList<A0> arrayList2 = new ArrayList();
                arrayList2.clear();
                for (String str6 : split3) {
                    String[] split4 = str6.split(":");
                    String str7 = split4[0];
                    String str8 = split4[1];
                    if (System.currentTimeMillis() - Long.parseLong(str8) <= s1.m(p02.f39430a)) {
                        A0 a03 = new A0();
                        a03.f39319a = str7;
                        a03.f39320b = Long.parseLong(str8);
                        arrayList2.add(a03);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String str9 = "";
                    String str10 = str9;
                    for (A0 a04 : arrayList2) {
                        str9 = str9 + a04.f39319a + ",";
                        str10 = str10 + a04.f39319a + ":" + a04.f39320b + ",";
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        a2.put("a601", str9.substring(0, str9.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        s1.a(p02.f39430a, str10.substring(0, str10.length() - 1), true);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                str = this.f39429a.f39432c + M0.a(a2);
            } catch (UnsupportedEncodingException unused) {
            }
            z.a(str, (Map) null, new N0(this));
        }
    }
}
