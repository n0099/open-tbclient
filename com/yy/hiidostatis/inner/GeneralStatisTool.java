package com.yy.hiidostatis.inner;

import android.content.Context;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.implementation.ITaskManager;
import com.yy.hiidostatis.inner.implementation.TaskManagerNew;
/* loaded from: classes8.dex */
public class GeneralStatisTool {
    public AbstractConfig mConfig;
    public Context mContext;
    public ITaskManager mTaskManager;

    public GeneralStatisTool(Context context, AbstractConfig abstractConfig) {
        this.mConfig = abstractConfig;
        this.mContext = context;
        this.mTaskManager = new TaskManagerNew(this.mContext, this.mConfig);
    }

    private BaseStatisContent fillComm(Context context, String str, BaseStatisContent baseStatisContent, boolean z, boolean z2, boolean z3) {
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

    public void reportCustomTemporary(Context context, String str, BaseStatisContent baseStatisContent, boolean z, boolean z2, boolean z3) {
        this.mTaskManager.sendTemporary(context, fillComm(context, str, baseStatisContent, z, z2, z3).getContent());
    }

    public AbstractConfig getConfig() {
        return this.mConfig;
    }

    public ITaskManager getTaskManager() {
        return this.mTaskManager;
    }

    public boolean reportCustom(Context context, String str, BaseStatisContent baseStatisContent, boolean z, boolean z2, boolean z3, Long l) {
        return this.mTaskManager.send(context, str, fillComm(context, str, baseStatisContent, z, z2, z3).getContent(), l);
    }
}
