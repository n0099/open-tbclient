package com.vivo.push.cache.impl;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import com.vivo.push.cache.ISubscribeAppAliasManager;
import com.vivo.push.cache.c;
import com.vivo.push.model.SubscribeAppInfo;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class SubscribeAppAliasManagerImpl extends a implements ISubscribeAppAliasManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribeAppAliasManagerImpl(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public boolean delAlias(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = this.mAppDatas.size();
            SubscribeAppInfo subscribeAppInfo = getSubscribeAppInfo();
            if (size == 1 && subscribeAppInfo != null && str.equals(subscribeAppInfo.getName()) && subscribeAppInfo.getTargetStatus() == 2) {
                return false;
            }
            clearData();
            addData(new SubscribeAppInfo(str, 2, 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public void delAliasSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (c.sAppLock) {
                boolean z = false;
                if (!TextUtils.isEmpty(str)) {
                    Iterator it = this.mAppDatas.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it.next();
                        if (subscribeAppInfo.getName().equals(str) && subscribeAppInfo.getActualStatus() != 2) {
                            subscribeAppInfo.setActualStatus(2);
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    SubscribeAppInfo subscribeAppInfo2 = getSubscribeAppInfo();
                    if (subscribeAppInfo2 == null) {
                        return;
                    }
                    if (subscribeAppInfo2.getActualStatus() == subscribeAppInfo2.getTargetStatus()) {
                        clearData();
                    } else {
                        updateDataToSP(this.mAppDatas);
                    }
                }
            }
        }
    }

    @Override // com.vivo.push.cache.c
    public String generateStrByType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PushClientConstants.PUSH_APP_ALIAS : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public SubscribeAppInfo getRetrySubscribeAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SubscribeAppInfo subscribeAppInfo = getSubscribeAppInfo();
            if (subscribeAppInfo == null || subscribeAppInfo.getTargetStatus() == subscribeAppInfo.getActualStatus()) {
                return null;
            }
            return subscribeAppInfo;
        }
        return (SubscribeAppInfo) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public SubscribeAppInfo getSubscribeAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (c.sAppLock) {
                Iterator it = this.mAppDatas.iterator();
                if (it.hasNext()) {
                    return (SubscribeAppInfo) it.next();
                }
                return null;
            }
        }
        return (SubscribeAppInfo) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public boolean setAlias(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = this.mAppDatas.size();
            SubscribeAppInfo subscribeAppInfo = getSubscribeAppInfo();
            if (size == 1 && subscribeAppInfo != null && str.equals(subscribeAppInfo.getName()) && subscribeAppInfo.getTargetStatus() == 1) {
                return false;
            }
            clearData();
            addData(new SubscribeAppInfo(str, 1, 2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppAliasManager
    public void setAliasSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (c.sAppLock) {
                boolean z = false;
                if (!TextUtils.isEmpty(str)) {
                    Iterator it = this.mAppDatas.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it.next();
                        if (subscribeAppInfo.getName().equals(str) && subscribeAppInfo.getActualStatus() != 1) {
                            subscribeAppInfo.setActualStatus(1);
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    updateDataToSP(this.mAppDatas);
                }
            }
        }
    }
}
