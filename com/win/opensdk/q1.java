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
/* loaded from: classes10.dex */
public final class q1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r1 f77151a;

    public q1(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77151a = r1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            HashMap a2 = o1.a(this.f77151a.f77156a);
            a2.put("pid", this.f77151a.f77157b);
            s1.a(this.f77151a, a2);
            r1 r1Var = this.f77151a;
            char c2 = 0;
            try {
                String[] split = U1.p(r1Var.f77156a).split(",");
                ArrayList<c1> arrayList = new ArrayList();
                arrayList.clear();
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    String[] split2 = split[i2].split(":");
                    String str2 = split2[c2];
                    String str3 = split2[1];
                    if (System.currentTimeMillis() - Long.parseLong(str3) < U1.n(r1Var.f77156a)) {
                        c1 c1Var = new c1();
                        c1Var.f76991a = str2;
                        c1Var.f76992b = Long.parseLong(str3);
                        arrayList.add(c1Var);
                    }
                    i2++;
                    c2 = 0;
                }
                if (!arrayList.isEmpty()) {
                    String str4 = "";
                    String str5 = str4;
                    for (c1 c1Var2 : arrayList) {
                        str4 = str4 + c1Var2.f76991a + ",";
                        str5 = str5 + c1Var2.f76991a + ":" + c1Var2.f76992b + ",";
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        a2.put("a605", str4.substring(0, str4.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        U1.b(r1Var.f77156a, str5.substring(0, str5.length() - 1), true);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            r1 r1Var2 = this.f77151a;
            try {
                String[] split3 = U1.o(r1Var2.f77156a).split(",");
                ArrayList<c1> arrayList2 = new ArrayList();
                arrayList2.clear();
                for (String str6 : split3) {
                    String[] split4 = str6.split(":");
                    String str7 = split4[0];
                    String str8 = split4[1];
                    if (System.currentTimeMillis() - Long.parseLong(str8) <= U1.n(r1Var2.f77156a)) {
                        c1 c1Var3 = new c1();
                        c1Var3.f76991a = str7;
                        c1Var3.f76992b = Long.parseLong(str8);
                        arrayList2.add(c1Var3);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String str9 = "";
                    String str10 = str9;
                    for (c1 c1Var4 : arrayList2) {
                        str9 = str9 + c1Var4.f76991a + ",";
                        str10 = str10 + c1Var4.f76991a + ":" + c1Var4.f76992b + ",";
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        a2.put("a601", str9.substring(0, str9.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        U1.a(r1Var2.f77156a, str10.substring(0, str10.length() - 1), true);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                str = this.f77151a.f77158c + o1.a(a2);
            } catch (UnsupportedEncodingException unused) {
            }
            N.a(str, (Map) null, new p1(this));
        }
    }
}
