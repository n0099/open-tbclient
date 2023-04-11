package com.yy.hiidostatis.defs.listener;

import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.defs.interf.IAct;
import com.yy.hiidostatis.defs.obj.Act;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class ActAdditionListenerController {
    public Map<IAct, ActListener> actMap = new HashMap();
    public HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate;

    public HiidoSdkAdditionDelegate getHiidoSdkAdditionDelegate() {
        return this.hiidoSdkAdditionDelegate;
    }

    public ActListener add(ActListener actListener) {
        ActListener put = this.actMap.put(actListener.getAct(), actListener);
        L.info(this, "add ActListener act[%s] new listener[%s],old listener[%s]", actListener.getAct(), actListener, actListener);
        return put;
    }

    public ActListener getListerner(IAct iAct) {
        return this.actMap.get(iAct);
    }

    public ActListener remove(ActListener actListener) {
        try {
            L.info(this, "remove ActListener act[%s] listener[%s]", actListener.getAct(), actListener);
            return this.actMap.remove(actListener.getAct());
        } catch (Throwable th) {
            L.error(this, "error %s", th);
            return null;
        }
    }

    public void setHiidoSdkAdditionDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        this.hiidoSdkAdditionDelegate = hiidoSdkAdditionDelegate;
    }

    public StatisContent getActAddition(Act act, ActListener actListener) {
        Map<String, String> additionParams;
        int i;
        StatisContent statisContent = null;
        if (actListener != null) {
            if (actListener instanceof ActAdditionListener) {
                ActAdditionListener actAdditionListener = (ActAdditionListener) actListener;
                if (actAdditionListener.getAdditionMap() != null && !actAdditionListener.getAdditionMap().isEmpty()) {
                    statisContent = new StatisContent();
                    i = actAdditionListener.getAdditionMap().size();
                    for (Map.Entry<String, String> entry : actAdditionListener.getAdditionMap().entrySet()) {
                        if (!Util.empty(entry.getKey()) && !Util.empty(entry.getValue())) {
                            statisContent.put(entry.getKey(), entry.getValue());
                        }
                    }
                    L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i));
                }
                i = 0;
                L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i));
            } else {
                if (actListener instanceof ActBakAdditionListener) {
                    ActBakAdditionListener actBakAdditionListener = (ActBakAdditionListener) actListener;
                    StatisContent statisContent2 = new StatisContent();
                    if (!Util.empty(actBakAdditionListener.getBak1())) {
                        statisContent2.put("bak1", actBakAdditionListener.getBak1());
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (!Util.empty(actBakAdditionListener.getBak2())) {
                        statisContent2.put("bak2", actBakAdditionListener.getBak2());
                        i++;
                    }
                    if (!Util.empty(actBakAdditionListener.getBak3())) {
                        statisContent2.put("bak3", actBakAdditionListener.getBak3());
                        i++;
                    }
                    statisContent = statisContent2;
                    L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i));
                }
                i = 0;
                L.debug(this, "getActAddition act[%s], listener[%s], ActAddition size[%d]", actListener.getAct(), actListener, Integer.valueOf(i));
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
}
