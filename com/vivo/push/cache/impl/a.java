package com.vivo.push.cache.impl;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.cache.c;
import com.vivo.push.model.SubscribeAppInfo;
import com.vivo.push.util.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class a extends c<SubscribeAppInfo> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SPILTE_TAG = "@#";
    public static final String TAG = "SubscribeAppInfoManager";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
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

    public SubscribeAppInfo getConfigByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (c.sAppLock) {
                for (T t : this.mAppDatas) {
                    if (!TextUtils.isEmpty(t.getName()) && t.getName().equals(str)) {
                        return t;
                    }
                }
                return null;
            }
        }
        return (SubscribeAppInfo) invokeL.objValue;
    }

    @Override // com.vivo.push.cache.c
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.loadData();
            synchronized (c.sAppLock) {
                boolean z = false;
                Iterator it = this.mAppDatas.iterator();
                while (it.hasNext()) {
                    SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it.next();
                    if (subscribeAppInfo.getTargetStatus() == 2 && subscribeAppInfo.getActualStatus() == 2) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    updateDataToSP(this.mAppDatas);
                }
            }
        }
    }

    @Override // com.vivo.push.cache.c
    public Set<SubscribeAppInfo> parseAppStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.trim().split(SPILTE_TAG)) {
                    String[] split = str2.trim().trim().split(",");
                    if (split.length >= 3) {
                        try {
                            hashSet.add(new SubscribeAppInfo(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                        } catch (Exception e2) {
                            p.d(TAG, "str2Clients E: " + e2);
                        }
                    }
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    @Override // com.vivo.push.cache.c
    public String toAppStr(Set<SubscribeAppInfo> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, set)) == null) {
            if (set == null || set.size() == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (SubscribeAppInfo subscribeAppInfo : set) {
                stringBuffer.append(subscribeAppInfo.getName());
                stringBuffer.append(",");
                stringBuffer.append(subscribeAppInfo.getTargetStatus());
                stringBuffer.append(",");
                stringBuffer.append(subscribeAppInfo.getActualStatus());
                stringBuffer.append(SPILTE_TAG);
            }
            return stringBuffer.substring(0, stringBuffer.length() - 2);
        }
        return (String) invokeL.objValue;
    }

    public void updateSubscribeApp(SubscribeAppInfo subscribeAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, subscribeAppInfo) == null) {
            synchronized (c.sAppLock) {
                boolean z = false;
                if (!TextUtils.isEmpty(subscribeAppInfo.getName())) {
                    Iterator it = this.mAppDatas.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SubscribeAppInfo subscribeAppInfo2 = (SubscribeAppInfo) it.next();
                        if (subscribeAppInfo2.getName().equals(subscribeAppInfo.getName())) {
                            subscribeAppInfo2.setTargetStatus(subscribeAppInfo.getTargetStatus());
                            subscribeAppInfo2.setActualStatus(subscribeAppInfo.getActualStatus());
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
