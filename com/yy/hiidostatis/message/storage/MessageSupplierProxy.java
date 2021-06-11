package com.yy.hiidostatis.message.storage;

import android.content.Context;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.implementation.TaskData;
import com.yy.hiidostatis.inner.implementation.TaskDataSqLiteCacheManager;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.MessageSupplier;
import com.yy.hiidostatis.message.bean.Message;
import com.yy.hiidostatis.provider.MessageConfig;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes7.dex */
public class MessageSupplierProxy implements MessageSupplier {
    public static final int BLACK_LIST_CAPACITY = 200;
    public final TaskDataSqLiteCacheManager cacheManager;
    public final MessageConfig config;
    public final Context context;
    public MessageMonitor monitor;
    public Set<String> blackListIndex = new HashSet(200);
    public List<String> blackList = new LinkedList();

    public MessageSupplierProxy(Context context, MessageConfig messageConfig, TaskDataSqLiteCacheManager taskDataSqLiteCacheManager, MessageMonitor messageMonitor) {
        this.context = context;
        this.cacheManager = taskDataSqLiteCacheManager;
        this.monitor = messageMonitor;
        this.config = messageConfig;
    }

    private synchronized void addBlackList(String str) {
        if (str == null) {
            return;
        }
        if (this.blackList.size() >= 200) {
            this.blackListIndex.remove(this.blackList.remove(0));
        }
        this.blackList.add(str);
        this.blackListIndex.add(str);
    }

    private synchronized boolean isInBlackList(String str) {
        if (str == null) {
            return false;
        }
        return this.blackListIndex.contains(str);
    }

    private Message trans(TaskData taskData) {
        String format;
        String format2 = String.format(Locale.CHINA, "act=mbsdkdata&EC=%d&appkey=%s&item=%s", Integer.valueOf(taskData.getTryTimes()), taskData.getAppkey(), taskData.getAct());
        try {
            if (taskData.getCrepid() == this.monitor.getProcessId()) {
                format = String.format(Locale.CHINA, "%s&%s=%d&%s=%d&hd_stime=%d", taskData.getContent(), BaseStatisContent.PACKID, Integer.valueOf(taskData.getPackId()), BaseStatisContent.REMAIN, Integer.valueOf(taskData.getRemain()), Long.valueOf(Util.wallTimeMillis()));
            } else {
                format = String.format(Locale.CHINA, "%s&%s=%d&%s=%d&%s=%d&hd_stime=%d", taskData.getContent(), BaseStatisContent.PACKID, Integer.valueOf(taskData.getPackId()), BaseStatisContent.CURPID, Integer.valueOf(this.monitor.getProcessId()), BaseStatisContent.REMAIN, Integer.valueOf(taskData.getRemain()), Long.valueOf(Util.wallTimeMillis()));
            }
            return new Message(taskData.getAct() + "_" + taskData.getDataId(), 1, format2, format.getBytes("UTF-8"), format.length());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.yy.hiidostatis.message.MessageSupplier
    public Message fetchMessage(int i2) {
        List<TaskData> andMoveToSendingList = this.cacheManager.getAndMoveToSendingList(this.context, i2);
        if (andMoveToSendingList != null && !andMoveToSendingList.isEmpty()) {
            if (andMoveToSendingList.size() == 1) {
                return trans(andMoveToSendingList.get(0));
            }
            return trans(andMoveToSendingList);
        }
        L.brief("data is null,end send. ", new Object[0]);
        return null;
    }

    @Override // com.yy.hiidostatis.message.MessageSupplier
    public void removeMessage(String str) {
        String[] split = str.split(",");
        try {
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                if (!str2.isEmpty()) {
                    arrayList.add(str2.split("_")[1]);
                }
            }
            this.cacheManager.removeSendListBatch(this.context, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yy.hiidostatis.message.MessageSupplier
    public void restoreMessage(String str) {
        String[] split = str.split(",");
        try {
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                if (!str2.isEmpty()) {
                    arrayList.add(str2.split("_"));
                }
            }
            this.cacheManager.restoreSendList(this.context, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Message trans(List<TaskData> list) {
        try {
            long wallTimeMillis = Util.wallTimeMillis();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            StringBuilder sb2 = new StringBuilder();
            for (TaskData taskData : list) {
                sb.append("\"");
                sb.append(taskData.getContent());
                sb.append("&");
                sb.append(BaseStatisContent.PACKID);
                sb.append("=");
                sb.append(taskData.getPackId());
                sb.append("&");
                sb.append(BaseStatisContent.REMAIN);
                sb.append("=");
                sb.append(taskData.getRemain());
                if (taskData.getCrepid() != this.monitor.getProcessId()) {
                    sb.append("&");
                    sb.append(BaseStatisContent.CURPID);
                    sb.append("=");
                    sb.append(this.monitor.getProcessId());
                }
                sb.append("&hd_stime=");
                sb.append(wallTimeMillis);
                sb.append("\",");
                sb2.append(taskData.getAct());
                sb2.append("_");
                sb2.append(taskData.getDataId());
                sb2.append(",");
            }
            sb.setLength(sb.length() - 1);
            sb.append("]");
            sb2.setLength(sb2.length() - 1);
            return new Message(sb2.toString(), list.size(), "act=mbsdkdata", sb.toString().getBytes("UTF-8"), sb.length());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
