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
public final class ht {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ft<? extends ITaskModelData>> a;

    public ht() {
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
        ot otVar = new ot(this);
        this.a.put(otVar.b(), otVar);
        kt ktVar = new kt(this);
        this.a.put(ktVar.b(), ktVar);
        pt ptVar = new pt(this);
        this.a.put(ptVar.c(), ptVar);
        mt mtVar = new mt(this);
        this.a.put(mtVar.b(), mtVar);
        lt ltVar = new lt(this);
        this.a.put(ltVar.c(), ltVar);
        nt ntVar = new nt(this);
        this.a.put(ntVar.b(), ntVar);
        gt gtVar = new gt(this);
        this.a.put(gtVar.b(), gtVar);
        et etVar = new et(this);
        this.a.put(etVar.c(), etVar);
    }

    public final <T extends ITaskModelData> ft<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                ft<? extends ITaskModelData> ftVar = this.a.get(str);
                if (ftVar != null) {
                    return (ft<? extends T>) ftVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (ft) invokeL.objValue;
    }
}
