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
public final class mt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, kt<? extends ITaskModelData>> a;

    public mt() {
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
        tt ttVar = new tt(this);
        this.a.put(ttVar.b(), ttVar);
        pt ptVar = new pt(this);
        this.a.put(ptVar.b(), ptVar);
        ut utVar = new ut(this);
        this.a.put(utVar.c(), utVar);
        rt rtVar = new rt(this);
        this.a.put(rtVar.b(), rtVar);
        qt qtVar = new qt(this);
        this.a.put(qtVar.c(), qtVar);
        st stVar = new st(this);
        this.a.put(stVar.b(), stVar);
        lt ltVar = new lt(this);
        this.a.put(ltVar.b(), ltVar);
        jt jtVar = new jt(this);
        this.a.put(jtVar.c(), jtVar);
    }

    public final <T extends ITaskModelData> kt<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                kt<? extends ITaskModelData> ktVar = this.a.get(str);
                if (ktVar != null) {
                    return (kt<? extends T>) ktVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (kt) invokeL.objValue;
    }
}
