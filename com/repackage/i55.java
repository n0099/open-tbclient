package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.mutiprocess.face.EmotionReloadEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i55 implements u45<EmotionReloadEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i55() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u45
    /* renamed from: a */
    public boolean onEvent(EmotionReloadEvent emotionReloadEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, emotionReloadEvent)) == null) {
            if (emotionReloadEvent == null) {
                return false;
            }
            MessageManager.getInstance().runTask(2004603, (Class) null);
            return true;
        }
        return invokeL.booleanValue;
    }
}
