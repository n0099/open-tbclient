package com.fun;

import com.baidu.tieba.gma;
import com.baidu.tieba.ira;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class s0 extends HashMap<String, Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Object[] a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ira c;

    public s0(ira iraVar, Object[] objArr, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {iraVar, objArr, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = iraVar;
        this.a = objArr;
        this.b = str;
        if (objArr != null && objArr.length > 0) {
            if (objArr.length % 2 != 0) {
                throw new IllegalArgumentException("Length of argument 'appends' must be even.");
            }
            int i3 = 0;
            while (true) {
                Object[] objArr3 = this.a;
                if (i3 >= objArr3.length) {
                    break;
                }
                put(objArr3[i3].toString(), this.a[i3 + 1]);
                i3 += 2;
            }
        }
        put("st", this.b);
        put("sid", this.c.b);
        put("sidv", Integer.valueOf(this.c.c));
        put("ldr_i", Integer.valueOf(gma.a(this.c.b)));
        str2 = this.c.d;
        put("type", str2);
    }
}
