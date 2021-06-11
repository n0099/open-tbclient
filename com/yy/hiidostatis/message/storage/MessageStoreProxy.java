package com.yy.hiidostatis.message.storage;

import android.content.Context;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.inner.implementation.TaskData;
import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.message.MessageStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class MessageStoreProxy implements MessageStore {
    public TaskDataSqLiteCacheManager cacheManager;
    public Context context;

    /* renamed from: com.yy.hiidostatis.message.storage.MessageStoreProxy$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$yy$hiidostatis$api$StatisContent$Priority;

        static {
            int[] iArr = new int[StatisContent.Priority.values().length];
            $SwitchMap$com$yy$hiidostatis$api$StatisContent$Priority = iArr;
            try {
                iArr[StatisContent.Priority.PRIORITY_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$api$StatisContent$Priority[StatisContent.Priority.PRIORITY_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yy$hiidostatis$api$StatisContent$Priority[StatisContent.Priority.PRIORITY_HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public MessageStoreProxy(Context context, TaskDataSqLiteCacheManager taskDataSqLiteCacheManager) {
        this.context = context;
        this.cacheManager = taskDataSqLiteCacheManager;
    }

    @Override // com.yy.hiidostatis.message.MessageStore
    public int notSave(List<StatisContent> list) {
        ArrayList arrayList = new ArrayList();
        for (StatisContent statisContent : list) {
            TaskData taskData = new TaskData(statisContent.getAct());
            taskData.setContent(statisContent.getContent());
            taskData.setDataId(statisContent.getGuid());
            taskData.setVerifyMd5(taskData.createVerifyMd5());
            taskData.setAid(statisContent.getAutoId());
            taskData.setCrepid(statisContent.getCrepid());
            arrayList.add(taskData);
        }
        return this.cacheManager.cacheData(this.context, arrayList);
    }

    @Override // com.yy.hiidostatis.message.MessageStore
    public int save(List<StatisContent> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (StatisContent statisContent : list) {
            TaskData taskData = new TaskData(statisContent.getAct());
            taskData.setContent(statisContent.getContent());
            taskData.setDataId(statisContent.getGuid());
            taskData.setVerifyMd5(taskData.createVerifyMd5());
            taskData.setAid(statisContent.getAutoId());
            taskData.setCrepid(statisContent.getCrepid());
            int i2 = AnonymousClass1.$SwitchMap$com$yy$hiidostatis$api$StatisContent$Priority[statisContent.getPriority().ordinal()];
            if (i2 == 1) {
                taskData.setOrder(System.currentTimeMillis() - 3600000);
            } else if (i2 == 2) {
                taskData.setOrder(System.currentTimeMillis());
            } else if (i2 == 3) {
                taskData.setOrder(System.currentTimeMillis() + 86400000);
            }
            Integer num = (Integer) hashMap.get(statisContent.getAct());
            if (num == null) {
                hashMap.put(statisContent.getAct(), 1);
            } else {
                hashMap.put(statisContent.getAct(), Integer.valueOf(num.intValue() + 1));
            }
            arrayList.add(taskData);
        }
        return this.cacheManager.saveAll(this.context, arrayList, hashMap);
    }
}
