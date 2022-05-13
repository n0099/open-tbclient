package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class kt9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ot9 a;

    public kt9(ot9 ot9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ot9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ot9Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            HashMap b = ct9.b(this.a.a);
            b.put("pid", this.a.b);
            st9.c(this.a, b);
            ot9 ot9Var = this.a;
            char c = 0;
            try {
                String[] split = hq9.J(ot9Var.a).split(",");
                ArrayList<ir9> arrayList = new ArrayList();
                arrayList.clear();
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split(":");
                    String str2 = split2[c];
                    String str3 = split2[1];
                    if (System.currentTimeMillis() - Long.parseLong(str3) < hq9.H(ot9Var.a)) {
                        ir9 ir9Var = new ir9();
                        ir9Var.a = str2;
                        ir9Var.b = Long.parseLong(str3);
                        arrayList.add(ir9Var);
                    }
                    i++;
                    c = 0;
                }
                if (!arrayList.isEmpty()) {
                    String str4 = "";
                    String str5 = str4;
                    for (ir9 ir9Var2 : arrayList) {
                        str4 = str4 + ir9Var2.a + ",";
                        str5 = str5 + ir9Var2.a + ":" + ir9Var2.b + ",";
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        b.put("a605", str4.substring(0, str4.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        hq9.m(ot9Var.a, str5.substring(0, str5.length() - 1), true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ot9 ot9Var2 = this.a;
            try {
                String[] split3 = hq9.I(ot9Var2.a).split(",");
                ArrayList<ir9> arrayList2 = new ArrayList();
                arrayList2.clear();
                for (String str6 : split3) {
                    String[] split4 = str6.split(":");
                    String str7 = split4[0];
                    String str8 = split4[1];
                    if (System.currentTimeMillis() - Long.parseLong(str8) <= hq9.H(ot9Var2.a)) {
                        ir9 ir9Var3 = new ir9();
                        ir9Var3.a = str7;
                        ir9Var3.b = Long.parseLong(str8);
                        arrayList2.add(ir9Var3);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String str9 = "";
                    String str10 = str9;
                    for (ir9 ir9Var4 : arrayList2) {
                        str9 = str9 + ir9Var4.a + ",";
                        str10 = str10 + ir9Var4.a + ":" + ir9Var4.b + ",";
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        b.put("a601", str9.substring(0, str9.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        hq9.g(ot9Var2.a, str10.substring(0, str10.length() - 1), true);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                str = this.a.c + ct9.a(b);
            } catch (UnsupportedEncodingException unused) {
            }
            ro9.s(str, null, new gt9(this));
        }
    }
}
