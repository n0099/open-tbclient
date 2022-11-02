package com.yy.hiidostatis.message.storage;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class MessageSupplierProxy implements MessageSupplier {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLACK_LIST_CAPACITY = 200;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> blackList;
    public Set<String> blackListIndex;
    public final TaskDataSqLiteCacheManager cacheManager;
    public final MessageConfig config;
    public final Context context;
    public MessageMonitor monitor;

    public MessageSupplierProxy(Context context, MessageConfig messageConfig, TaskDataSqLiteCacheManager taskDataSqLiteCacheManager, MessageMonitor messageMonitor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, messageConfig, taskDataSqLiteCacheManager, messageMonitor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.blackListIndex = new HashSet(200);
        this.blackList = new LinkedList();
        this.context = context;
        this.cacheManager = taskDataSqLiteCacheManager;
        this.monitor = messageMonitor;
        this.config = messageConfig;
    }

    private synchronized void addBlackList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            synchronized (this) {
                if (str == null) {
                    return;
                }
                if (this.blackList.size() >= 200) {
                    this.blackListIndex.remove(this.blackList.remove(0));
                }
                this.blackList.add(str);
                this.blackListIndex.add(str);
            }
        }
    }

    @Override // com.yy.hiidostatis.message.MessageSupplier
    public Message fetchMessage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<TaskData> andMoveToSendingList = this.cacheManager.getAndMoveToSendingList(this.context, i);
            if (andMoveToSendingList != null && !andMoveToSendingList.isEmpty()) {
                if (andMoveToSendingList.size() == 1) {
                    return trans(andMoveToSendingList.get(0));
                }
                return trans(andMoveToSendingList);
            }
            L.brief("data is null,end send. ", new Object[0]);
            return null;
        }
        return (Message) invokeI.objValue;
    }

    @Override // com.yy.hiidostatis.message.MessageSupplier
    public void removeMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
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
    }

    @Override // com.yy.hiidostatis.message.MessageSupplier
    public void restoreMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
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
    }

    private synchronized boolean isInBlackList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            synchronized (this) {
                if (str == null) {
                    return false;
                }
                return this.blackListIndex.contains(str);
            }
        }
        return invokeL.booleanValue;
    }

    private Message trans(TaskData taskData) {
        InterceptResult invokeL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, taskData)) == null) {
            String format2 = String.format(Locale.CHINA, "act=mbsdkdata&EC=%d&appkey=%s&item=%s", Integer.valueOf(taskData.getTryTimes()), taskData.getAppkey(), taskData.getAct());
            try {
                if (taskData.getCrepid() == this.monitor.getProcessId()) {
                    format = String.format(Locale.CHINA, "%s&%s=%d&%s=%d&hd_stime=%d", taskData.getContent(), BaseStatisContent.PACKID, Integer.valueOf(taskData.getPackId()), BaseStatisContent.REMAIN, Integer.valueOf(taskData.getRemain()), Long.valueOf(Util.wallTimeMillis()));
                } else {
                    format = String.format(Locale.CHINA, "%s&%s=%d&%s=%d&%s=%d&hd_stime=%d", taskData.getContent(), BaseStatisContent.PACKID, Integer.valueOf(taskData.getPackId()), BaseStatisContent.CURPID, Integer.valueOf(this.monitor.getProcessId()), BaseStatisContent.REMAIN, Integer.valueOf(taskData.getRemain()), Long.valueOf(Util.wallTimeMillis()));
                }
                return new Message(taskData.getAct() + "_" + taskData.getDataId(), 1, format2, format.getBytes("UTF-8"), format.length());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }

    private Message trans(List<TaskData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list)) == null) {
            try {
                long wallTimeMillis = Util.wallTimeMillis();
                StringBuilder sb = new StringBuilder();
                sb.append(PreferencesUtil.LEFT_MOUNT);
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
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                sb2.setLength(sb2.length() - 1);
                return new Message(sb2.toString(), list.size(), "act=mbsdkdata", sb.toString().getBytes("UTF-8"), sb.length());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }
}
