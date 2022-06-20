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
public final class lt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, jt<? extends ITaskModelData>> a;

    public lt() {
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
        st stVar = new st(this);
        this.a.put(stVar.b(), stVar);
        ot otVar = new ot(this);
        this.a.put(otVar.b(), otVar);
        tt ttVar = new tt(this);
        this.a.put(ttVar.c(), ttVar);
        qt qtVar = new qt(this);
        this.a.put(qtVar.b(), qtVar);
        pt ptVar = new pt(this);
        this.a.put(ptVar.c(), ptVar);
        rt rtVar = new rt(this);
        this.a.put(rtVar.b(), rtVar);
        kt ktVar = new kt(this);
        this.a.put(ktVar.b(), ktVar);
        it itVar = new it(this);
        this.a.put(itVar.c(), itVar);
    }

    public final <T extends ITaskModelData> jt<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                jt<? extends ITaskModelData> jtVar = this.a.get(str);
                if (jtVar != null) {
                    return (jt<? extends T>) jtVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (jt) invokeL.objValue;
    }
}
