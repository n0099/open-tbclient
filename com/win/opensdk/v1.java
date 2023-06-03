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
public class v1 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ w1 a;

    public v1(w1 w1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = w1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            HashMap a = t1.a(this.a.a);
            a.put("pid", this.a.b);
            x1.a(this.a, a);
            w1 w1Var = this.a;
            char c = 0;
            try {
                String[] split = Z1.q(w1Var.a).split(",");
                ArrayList<h1> arrayList = new ArrayList();
                arrayList.clear();
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split(":");
                    String str2 = split2[c];
                    String str3 = split2[1];
                    if (System.currentTimeMillis() - Long.parseLong(str3) < Z1.o(w1Var.a)) {
                        h1 h1Var = new h1();
                        h1Var.a = str2;
                        h1Var.b = Long.parseLong(str3);
                        arrayList.add(h1Var);
                    }
                    i++;
                    c = 0;
                }
                if (!arrayList.isEmpty()) {
                    String str4 = "";
                    String str5 = str4;
                    for (h1 h1Var2 : arrayList) {
                        str4 = str4 + h1Var2.a + ",";
                        str5 = str5 + h1Var2.a + ":" + h1Var2.b + ",";
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        a.put("a605", str4.substring(0, str4.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        Z1.b(w1Var.a, str5.substring(0, str5.length() - 1), true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            w1 w1Var2 = this.a;
            try {
                String[] split3 = Z1.p(w1Var2.a).split(",");
                ArrayList<h1> arrayList2 = new ArrayList();
                arrayList2.clear();
                for (String str6 : split3) {
                    String[] split4 = str6.split(":");
                    String str7 = split4[0];
                    String str8 = split4[1];
                    if (System.currentTimeMillis() - Long.parseLong(str8) <= Z1.o(w1Var2.a)) {
                        h1 h1Var3 = new h1();
                        h1Var3.a = str7;
                        h1Var3.b = Long.parseLong(str8);
                        arrayList2.add(h1Var3);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String str9 = "";
                    String str10 = str9;
                    for (h1 h1Var4 : arrayList2) {
                        str9 = str9 + h1Var4.a + ",";
                        str10 = str10 + h1Var4.a + ":" + h1Var4.b + ",";
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        a.put("a601", str9.substring(0, str9.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        Z1.a(w1Var2.a, str10.substring(0, str10.length() - 1), true);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                str = this.a.c + t1.a(a);
            } catch (UnsupportedEncodingException unused) {
            }
            M.a(str, (Map) null, new u1(this));
        }
    }
}
