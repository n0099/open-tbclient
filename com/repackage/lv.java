package com.repackage;

import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.TypeCastException;
/* loaded from: classes6.dex */
public final class lv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, jv<? extends ITaskModelData>> a;

    public lv() {
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
        this.a = new HashMap();
        sv svVar = new sv(this);
        this.a.put(svVar.b(), svVar);
        ov ovVar = new ov(this);
        this.a.put(ovVar.b(), ovVar);
        tv tvVar = new tv(this);
        this.a.put(tvVar.c(), tvVar);
        qv qvVar = new qv(this);
        this.a.put(qvVar.b(), qvVar);
        pv pvVar = new pv(this);
        this.a.put(pvVar.c(), pvVar);
        rv rvVar = new rv(this);
        this.a.put(rvVar.b(), rvVar);
        kv kvVar = new kv(this);
        this.a.put(kvVar.b(), kvVar);
        iv ivVar = new iv(this);
        this.a.put(ivVar.c(), ivVar);
    }

    public final <T extends ITaskModelData> jv<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                jv<? extends ITaskModelData> jvVar = this.a.get(str);
                if (jvVar != null) {
                    return (jv<? extends T>) jvVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (jv) invokeL.objValue;
    }
}
