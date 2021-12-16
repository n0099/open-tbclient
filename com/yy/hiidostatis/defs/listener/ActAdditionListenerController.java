package com.yy.hiidostatis.defs.listener;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.defs.interf.IAct;
import com.yy.hiidostatis.defs.obj.Act;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class ActAdditionListenerController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<IAct, ActListener> actMap;
    public HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate;

    public ActAdditionListenerController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actMap = new HashMap();
    }

    public ActListener add(ActListener actListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, actListener)) == null) {
            ActListener put = this.actMap.put(actListener.getAct(), actListener);
            L.info(this, "add ActListener act[%s] new listener[%s],old listener[%s]", actListener.getAct(), actListener, actListener);
            return put;
        }
        return (ActListener) invokeL.objValue;
    }

    public StatisContent getActAddition(Act act, ActListener actListener) {
        InterceptResult invokeLL;
        Map<String, String> additionParams;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, act, actListener)) == null) {
            StatisContent statisContent = null;
            if (actListener != null) {
                if (actListener instanceof ActAdditionListener) {
                    ActAdditionListener actAdditionListener = (ActAdditionListener) actListener;
                    if (actAdditionListener.getAdditionMap() != null && !actAdditionListener.getAdditionMap().isEmpty()) {
                        statisContent = new StatisContent();
                        i2 = actAdditionListener.getAdditionMap().size();
                        for (Map.Entry<String, String> entry : actAdditionListener.getAdditionMap().entrySet()) {
                            if (!Util.empty(entry.getKey()) && !Util.empty(entry.getValue())) {
                                statisContent.put(entry.getKey(), entry.getValue());
                            }
                        }
                        L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i2));
                    }
                    i2 = 0;
                    L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i2));
                } else {
                    if (actListener instanceof ActBakAdditionListener) {
                        ActBakAdditionListener actBakAdditionListener = (ActBakAdditionListener) actListener;
                        StatisContent statisContent2 = new StatisContent();
                        if (Util.empty(actBakAdditionListener.getBak1())) {
                            i2 = 0;
                        } else {
                            statisContent2.put("bak1", actBakAdditionListener.getBak1());
                            i2 = 1;
                        }
                        if (!Util.empty(actBakAdditionListener.getBak2())) {
                            statisContent2.put("bak2", actBakAdditionListener.getBak2());
                            i2++;
                        }
                        if (!Util.empty(actBakAdditionListener.getBak3())) {
                            statisContent2.put("bak3", actBakAdditionListener.getBak3());
                            i2++;
                        }
                        statisContent = statisContent2;
                        L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i2));
                    }
                    i2 = 0;
                    L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i2));
                }
            }
            HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate = this.hiidoSdkAdditionDelegate;
            if (hiidoSdkAdditionDelegate != null && (additionParams = hiidoSdkAdditionDelegate.getAdditionParams(act)) != null && !additionParams.isEmpty()) {
                if (statisContent == null) {
                    statisContent = new StatisContent();
                }
                for (Map.Entry<String, String> entry2 : additionParams.entrySet()) {
                    if (!Util.empty(entry2.getKey()) && !Util.empty(entry2.getValue())) {
                        statisContent.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            return statisContent;
        }
        return (StatisContent) invokeLL.objValue;
    }

    public HiidoSdkAdditionDelegate getHiidoSdkAdditionDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hiidoSdkAdditionDelegate : (HiidoSdkAdditionDelegate) invokeV.objValue;
    }

    public ActListener getListerner(IAct iAct) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iAct)) == null) ? this.actMap.get(iAct) : (ActListener) invokeL.objValue;
    }

    public ActListener remove(ActListener actListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, actListener)) == null) {
            try {
                L.info(this, "remove ActListener act[%s] listener[%s]", actListener.getAct(), actListener);
                return this.actMap.remove(actListener.getAct());
            } catch (Throwable th) {
                L.error(this, "error %s", th);
                return null;
            }
        }
        return (ActListener) invokeL.objValue;
    }

    public void setHiidoSdkAdditionDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hiidoSdkAdditionDelegate) == null) {
            this.hiidoSdkAdditionDelegate = hiidoSdkAdditionDelegate;
        }
    }
}
