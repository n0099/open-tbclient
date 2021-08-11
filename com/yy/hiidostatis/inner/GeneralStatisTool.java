package com.yy.hiidostatis.inner;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.implementation.ITaskManager;
import com.yy.hiidostatis.inner.implementation.TaskManagerNew;
/* loaded from: classes10.dex */
public class GeneralStatisTool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbstractConfig mConfig;
    public Context mContext;
    public ITaskManager mTaskManager;

    public GeneralStatisTool(Context context, AbstractConfig abstractConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, abstractConfig};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConfig = abstractConfig;
        this.mContext = context;
        this.mTaskManager = new TaskManagerNew(this.mContext, this.mConfig);
    }

    private BaseStatisContent fillComm(Context context, String str, BaseStatisContent baseStatisContent, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{context, str, baseStatisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z || z2) {
                BaseStatisContent baseStatisContent2 = new BaseStatisContent();
                if (z) {
                    CommonFiller.fillCommonNew(context, baseStatisContent2, str, this.mConfig.getSdkVer());
                }
                if (z2) {
                    CommonFiller.fillConcreteInfoNew(context, baseStatisContent2);
                }
                baseStatisContent2.putContent(baseStatisContent, z3);
                baseStatisContent = baseStatisContent2;
            }
            baseStatisContent.put("act", str);
            return baseStatisContent;
        }
        return (BaseStatisContent) invokeCommon.objValue;
    }

    public AbstractConfig getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mConfig : (AbstractConfig) invokeV.objValue;
    }

    public ITaskManager getTaskManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTaskManager : (ITaskManager) invokeV.objValue;
    }

    public boolean reportCustom(Context context, String str, BaseStatisContent baseStatisContent, boolean z, boolean z2, boolean z3, Long l) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, baseStatisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), l})) == null) ? this.mTaskManager.send(context, str, fillComm(context, str, baseStatisContent, z, z2, z3).getContent(), l) : invokeCommon.booleanValue;
    }

    public void reportCustomTemporary(Context context, String str, BaseStatisContent baseStatisContent, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, baseStatisContent, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mTaskManager.sendTemporary(context, fillComm(context, str, baseStatisContent, z, z2, z3).getContent());
        }
    }
}
