package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class eq9 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ iq9 a;

    public eq9(iq9 iq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iq9Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "";
            HashMap b = wp9.b(this.a.a);
            b.put("pid", this.a.b);
            mq9.c(this.a, b);
            iq9 iq9Var = this.a;
            char c = 0;
            try {
                String[] split = bn9.J(iq9Var.a).split(",");
                ArrayList<co9> arrayList = new ArrayList();
                arrayList.clear();
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split(":");
                    String str2 = split2[c];
                    String str3 = split2[1];
                    if (System.currentTimeMillis() - Long.parseLong(str3) < bn9.H(iq9Var.a)) {
                        co9 co9Var = new co9();
                        co9Var.a = str2;
                        co9Var.b = Long.parseLong(str3);
                        arrayList.add(co9Var);
                    }
                    i++;
                    c = 0;
                }
                if (!arrayList.isEmpty()) {
                    String str4 = "";
                    String str5 = str4;
                    for (co9 co9Var2 : arrayList) {
                        str4 = str4 + co9Var2.a + ",";
                        str5 = str5 + co9Var2.a + ":" + co9Var2.b + ",";
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        b.put("a605", str4.substring(0, str4.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        bn9.m(iq9Var.a, str5.substring(0, str5.length() - 1), true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            iq9 iq9Var2 = this.a;
            try {
                String[] split3 = bn9.I(iq9Var2.a).split(",");
                ArrayList<co9> arrayList2 = new ArrayList();
                arrayList2.clear();
                for (String str6 : split3) {
                    String[] split4 = str6.split(":");
                    String str7 = split4[0];
                    String str8 = split4[1];
                    if (System.currentTimeMillis() - Long.parseLong(str8) <= bn9.H(iq9Var2.a)) {
                        co9 co9Var3 = new co9();
                        co9Var3.a = str7;
                        co9Var3.b = Long.parseLong(str8);
                        arrayList2.add(co9Var3);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    String str9 = "";
                    String str10 = str9;
                    for (co9 co9Var4 : arrayList2) {
                        str9 = str9 + co9Var4.a + ",";
                        str10 = str10 + co9Var4.a + ":" + co9Var4.b + ",";
                    }
                    if (!TextUtils.isEmpty(str9)) {
                        b.put("a601", str9.substring(0, str9.length() - 1));
                    }
                    if (!TextUtils.isEmpty(str10)) {
                        bn9.g(iq9Var2.a, str10.substring(0, str10.length() - 1), true);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                str = this.a.c + wp9.a(b);
            } catch (UnsupportedEncodingException unused) {
            }
            ll9.s(str, null, new aq9(this));
        }
    }
}
