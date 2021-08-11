package com.vivo.push.cache.impl;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import com.vivo.push.cache.ISubscribeAppTagManager;
import com.vivo.push.cache.c;
import com.vivo.push.model.SubscribeAppInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes10.dex */
public final class b extends a implements ISubscribeAppTagManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    /* renamed from: a */
    public ArrayList<String> getSubscribeTags() {
        InterceptResult invokeV;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            synchronized (c.sAppLock) {
                arrayList = new ArrayList<>();
                for (T t : this.mAppDatas) {
                    if (t != null && t.getTargetStatus() == 1) {
                        arrayList.add(t.getName());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final boolean delTags(Set<String> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, set)) == null) {
            boolean z = false;
            if (set == null) {
                return false;
            }
            synchronized (c.sAppLock) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator it2 = this.mAppDatas.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it2.next();
                            if (subscribeAppInfo.getName().equals(next)) {
                                if (subscribeAppInfo.getTargetStatus() == 2) {
                                    it.remove();
                                    break;
                                }
                                subscribeAppInfo.setTargetStatus(2);
                                subscribeAppInfo.setActualStatus(1);
                                z = true;
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                for (String str : set) {
                    hashSet.add(new SubscribeAppInfo(str, 2, 1));
                }
                if (hashSet.size() > 0) {
                    addDatas(hashSet);
                    z = true;
                } else if (z) {
                    updateDataToSP(this.mAppDatas);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final void delTagsSuccess(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
            synchronized (c.sAppLock) {
                boolean z = false;
                for (String str : set) {
                    Iterator it = this.mAppDatas.iterator();
                    while (it.hasNext()) {
                        SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it.next();
                        if (str.equals(subscribeAppInfo.getName()) && subscribeAppInfo.getActualStatus() != 2) {
                            if (subscribeAppInfo.getTargetStatus() == 2) {
                                it.remove();
                            } else {
                                subscribeAppInfo.setActualStatus(2);
                            }
                            z = true;
                        }
                    }
                }
                if (z) {
                    updateDataToSP(this.mAppDatas);
                }
            }
        }
    }

    @Override // com.vivo.push.cache.c
    public final String generateStrByType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PushClientConstants.PUSH_APP_TAGS : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final ArrayList<String> getRetrySubscribeAppInfo() {
        InterceptResult invokeV;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (c.sAppLock) {
                arrayList = new ArrayList<>();
                for (T t : this.mAppDatas) {
                    if (t != null && t.getTargetStatus() == 1 && t.getTargetStatus() != t.getActualStatus()) {
                        arrayList.add(t.getName());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final ArrayList<String> getRetryUnsubscribeAppInfo() {
        InterceptResult invokeV;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (c.sAppLock) {
                arrayList = new ArrayList<>();
                for (T t : this.mAppDatas) {
                    if (t != null && t.getTargetStatus() == 2 && t.getTargetStatus() != t.getActualStatus()) {
                        arrayList.add(t.getName());
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final boolean setTags(Set<String> set) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, set)) == null) {
            boolean z = false;
            if (set == null) {
                return false;
            }
            synchronized (c.sAppLock) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator it2 = this.mAppDatas.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            SubscribeAppInfo subscribeAppInfo = (SubscribeAppInfo) it2.next();
                            if (subscribeAppInfo.getName().equals(next)) {
                                if (subscribeAppInfo.getTargetStatus() == 1) {
                                    it.remove();
                                    break;
                                }
                                subscribeAppInfo.setTargetStatus(1);
                                subscribeAppInfo.setActualStatus(2);
                                z = true;
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                for (String str : set) {
                    hashSet.add(new SubscribeAppInfo(str, 1, 2));
                }
                if (hashSet.size() > 0) {
                    addDatas(hashSet);
                    z = true;
                } else if (z) {
                    updateDataToSP(this.mAppDatas);
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.cache.ISubscribeAppTagManager
    public final void setTagsSuccess(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, set) == null) {
            synchronized (c.sAppLock) {
                boolean z = false;
                for (String str : set) {
                    for (T t : this.mAppDatas) {
                        if (str.equals(t.getName()) && t.getActualStatus() != 1) {
                            t.setActualStatus(1);
                            z = true;
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
