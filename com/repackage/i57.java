package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c57;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class i57 {
    public static /* synthetic */ Interceptable $ic;
    public static i57 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements c57.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.c57.c
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public i57() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized i57 b() {
        InterceptResult invokeV;
        i57 i57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (i57.class) {
                if (a == null) {
                    a = new i57();
                }
                i57Var = a;
            }
            return i57Var;
        }
        return (i57) invokeV.objValue;
    }

    public static void d(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, c57.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, groupMsgData, imMessageCenterPojo, bVar) == null) {
            c57.d(groupMsgData, imMessageCenterPojo, bVar, new a(), false);
        }
    }

    public long[] a(GroupMsgData groupMsgData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, groupMsgData)) == null) {
            if (groupMsgData == null || groupMsgData.getGroupInfo() == null) {
                return null;
            }
            long j = 0;
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (next.getMsgId() > j) {
                    j = next.getMsgId();
                }
            }
            return new long[]{groupId, j};
        }
        return (long[]) invokeL.objValue;
    }

    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            TbadkSettings inst = TbadkSettings.getInst();
            return inst.loadLong("tb_group_msg_" + j, -1L);
        }
        return invokeJ.longValue;
    }

    public void e(GroupMsgData groupMsgData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, groupMsgData) == null) || groupMsgData == null || groupMsgData.getGroupInfo() == null) {
            return;
        }
        Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
        while (it.hasNext()) {
            ChatMessage next = it.next();
            if (!TextUtils.isEmpty(next.getStat())) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "push_noti:" + next.getStat(), "taskId:" + next.getTaskId() + ";link:" + next.getLink() + ";uid:" + TbadkCoreApplication.getCurrentAccount());
            }
            if (!TextUtils.isEmpty(next.getLink()) && !TextUtils.isEmpty(next.getStat())) {
                TiebaStatic.pushMsg(next.getMsgId(), 1, next.getLink(), next.getStat());
            }
            CustomMessage customMessage = new CustomMessage(2012100);
            customMessage.setData(new yp4(next.getMsgId(), next.getTaskId(), next.getLink(), next.getContent(), next.getStat(), next.getServiceId()));
            MessageManager.getInstance().sendMessage(customMessage);
        }
        if (groupMsgData.getListMessage().size() > 0) {
            TiebaStatic.saveAndUploadMsg();
        }
    }

    public void f(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        inst.saveLong("tb_group_msg_" + str, j);
    }
}
