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
/* loaded from: classes7.dex */
public final class uu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, su<? extends ITaskModelData>> a;

    public uu() {
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
        bv bvVar = new bv(this);
        this.a.put(bvVar.b(), bvVar);
        xu xuVar = new xu(this);
        this.a.put(xuVar.b(), xuVar);
        cv cvVar = new cv(this);
        this.a.put(cvVar.c(), cvVar);
        zu zuVar = new zu(this);
        this.a.put(zuVar.b(), zuVar);
        yu yuVar = new yu(this);
        this.a.put(yuVar.c(), yuVar);
        av avVar = new av(this);
        this.a.put(avVar.b(), avVar);
        tu tuVar = new tu(this);
        this.a.put(tuVar.b(), tuVar);
        ru ruVar = new ru(this);
        this.a.put(ruVar.c(), ruVar);
    }

    public final <T extends ITaskModelData> su<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                su<? extends ITaskModelData> suVar = this.a.get(str);
                if (suVar != null) {
                    return (su<? extends T>) suVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (su) invokeL.objValue;
    }
}
