package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class qx4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qx4 k;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<ImMessageCenterPojo> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public final CustomMessageListener j;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qx4 qx4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001120) {
                this.a.p(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016002) {
                this.a.o(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.m(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.q(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.n(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                this.a.s();
            } else if (customResponsedMessage.getCmd() == 2016011) {
                this.a.r();
            }
        }
    }

    public qx4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList<>();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.j = new a(this, 0);
    }

    public static qx4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (k == null) {
                synchronized (qx4.class) {
                    if (k == null) {
                        k = new qx4();
                    }
                }
            }
            return k;
        }
        return (qx4) invokeV.objValue;
    }

    public final void h(List<ImMessageCenterPojo> list) {
        int unread_count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ImMessageCenterPojo imMessageCenterPojo = list.get(i2);
            if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
                if (imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -7) {
                    if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        if (rx4.d().r()) {
                            GroupSettingItemData a2 = y67.k().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (a2 != null) {
                                if (a2.isAcceptNotify()) {
                                    unread_count = imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                unread_count = imMessageCenterPojo.getUnread_count();
                            }
                            i += unread_count;
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (rx4.d().t()) {
                            PersonalSettingItemData a3 = b77.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (a3 != null) {
                                if (a3.isAcceptNotify()) {
                                    unread_count = imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                unread_count = imMessageCenterPojo.getUnread_count();
                            }
                            i += unread_count;
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        if (imMessageCenterPojo.getUserType() == 4) {
                            if (rx4.d().t()) {
                                OfficialSettingItemData a4 = a77.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                                if (a4 != null) {
                                    if (a4.isAcceptNotify()) {
                                        unread_count = imMessageCenterPojo.getUnread_count();
                                    }
                                } else {
                                    unread_count = imMessageCenterPojo.getUnread_count();
                                }
                                i += unread_count;
                            }
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() != -8) {
                    }
                }
                z = true;
            }
        }
        if (rx4.d().f() == 0) {
            i = 0;
        }
        boolean z2 = i > 0 ? z : false;
        this.h = i;
        this.i = z2;
    }

    public final void i(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            boolean z = i > 0 || i2 > 0 || i3 > 0 || i4 > 0;
            int i5 = i > 0 ? i + 0 : 0;
            if (i2 > 0) {
                i5 += i2;
            }
            if (i3 > 0) {
                i5 += i3;
            }
            if (i4 > 0) {
                i5 += i4;
            }
            if (rx4.d().f() == 0) {
                i5 = 0;
            }
            this.g = i5 > 0 ? z : false;
            this.f = i5;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public final boolean j(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && ((!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) && imMessageCenterPojo.getLast_content_time() != 0)) {
                if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    return !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
                } else if (imMessageCenterPojo.getCustomGroupType() == -4) {
                    return true;
                } else {
                    if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                        return true;
                    }
                    if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 1 || imMessageCenterPojo.getIsFriend() == 2 || 1 == imMessageCenterPojo.getShowOutOfStranger())) {
                        return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u();
            MessageManager.getInstance().registerStickyMode(2921002);
            MessageManager.getInstance().registerListener(2001120, this.j);
            MessageManager.getInstance().registerListener(2016002, this.j);
            MessageManager.getInstance().registerListener(2016004, this.j);
            MessageManager.getInstance().registerListener(2016001, this.j);
            MessageManager.getInstance().registerListener(2016007, this.j);
            MessageManager.getInstance().registerListener(2016011, this.j);
            MessageManager.getInstance().registerListener(2016010, this.j);
        }
    }

    public final void m(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryChangedMessage memoryChangedMessage;
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof MemoryChangedMessage) || (data = (memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.getGid())) {
            return;
        }
        if (memoryChangedMessage.getType() == 1) {
            t(this.a, data);
            if (j(data)) {
                this.a.add(data);
            }
        } else if (memoryChangedMessage.getType() == 2) {
            t(this.a, data);
        }
        h(this.a);
        v();
    }

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) {
            this.a.clear();
            h(this.a);
            v();
        }
    }

    public final void o(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void p(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
            return;
        }
        NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
        i(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgFans());
        v();
    }

    public final void q(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || data == null) {
                return;
            }
            this.a.clear();
            for (ImMessageCenterPojo imMessageCenterPojo : data) {
                if (imMessageCenterPojo != null && j(imMessageCenterPojo)) {
                    this.a.add(imMessageCenterPojo);
                }
            }
            h(this.a);
            v();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            i(this.b, this.c, this.d, this.e);
            h(this.a);
            v();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            i(this.b, this.c, this.d, this.e);
            h(this.a);
            v();
        }
    }

    public final void t(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, linkedList, imMessageCenterPojo) == null) || linkedList == null || linkedList.size() <= 0 || imMessageCenterPojo == null) {
            return;
        }
        Iterator<ImMessageCenterPojo> it = linkedList.iterator();
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next != null && next.getGid() == imMessageCenterPojo.getGid()) {
                it.remove();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.clear();
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = false;
            this.h = 0;
            this.i = false;
            this.h = 0;
            this.i = false;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
            newsRemindMessage.setMsgAgreeCount(this.b);
            newsRemindMessage.setMsgAtCount(this.c);
            newsRemindMessage.setMsgReplyCount(this.d);
            newsRemindMessage.setMsgFansCount(this.e);
            newsRemindMessage.setMsgCount(this.f);
            newsRemindMessage.setHasMsgRemind(this.g);
            newsRemindMessage.setChatCount(this.h);
            newsRemindMessage.setHasChatRemind(this.i);
            MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
        }
    }
}
