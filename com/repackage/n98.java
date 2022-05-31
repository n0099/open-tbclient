package com.repackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PushDialogActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.ScreenLockSyncSwitch;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.screenlocknotify.ScreenLockActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u47;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class n98 {
    public static /* synthetic */ Interceptable $ic;
    public static n98 m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<q98> b;
    public q98 c;
    public final go8 d;
    public int e;
    public int f;
    public boolean g;
    public Handler h;
    public CustomMessageListener i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public CustomMessageListener l;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n98 n98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n98 n98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var, Integer.valueOf(i)};
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
            this.a = n98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                this.a.q(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(n98 n98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var, Integer.valueOf(i)};
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
            this.a = n98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012125 || customResponsedMessage.getCmd() == 2012121 || customResponsedMessage.getCmd() == 2012123) {
                this.a.r(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(n98 n98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var, Integer.valueOf(i)};
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
            this.a = n98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(n98 n98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var, Integer.valueOf(i)};
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
            this.a = n98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && n98.n()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (this.a.d.c()) {
                        this.a.p(remindRecommendMessage);
                    } else {
                        this.a.o(remindRecommendMessage);
                    }
                    if (remindRecommendMessage.isLocal) {
                        TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 2).param("obj_locate", 1));
                    } else {
                        TiebaStatic.log(new StatisticItem("c10316").param("obj_type", 1).param("obj_locate", 1));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n98 a;

        public f(n98 n98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.e();
            }
        }
    }

    public n98() {
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
        this.b = new LinkedList();
        this.c = null;
        this.h = new a(this);
        this.i = new b(this, 0);
        this.j = new c(this, 0);
        this.k = new d(this, 2005016);
        this.l = new e(this, 2001355);
        this.a = TbadkApplication.getInst().getApp();
        MessageManager.getInstance().registerListener(2016004, this.i);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(2012125, this.j);
        MessageManager.getInstance().registerListener(2012121, this.j);
        MessageManager.getInstance().registerListener(2012123, this.j);
        MessageManager.getInstance().registerListener(this.l);
        this.f = 0;
        this.d = new go8();
    }

    public static n98 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new n98();
            }
            return m;
        }
        return (n98) invokeV.objValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(TbadkCoreApplication.getCurrentAccount());
            sb.append("remind_recommend_server_switch");
            return TbadkSettings.getInst().loadInt(sb.toString(), 1) == 1;
        }
        return invokeV.booleanValue;
    }

    public void c(q98 q98Var) {
        List<q98> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, q98Var) == null) || (list = this.b) == null) {
            return;
        }
        list.add(q98Var);
    }

    public boolean d(ChatMessage chatMessage) {
        InterceptResult invokeL;
        int msgType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatMessage)) == null) {
            if (chatMessage != null && (msgType = chatMessage.getMsgType()) != 6 && msgType != 22 && msgType != 23) {
                switch (msgType) {
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        if (!StringUtils.isNull(chatMessage.getContent()) && !StringUtils.isNull(chatMessage.getUserInfo().getUserName()) && !chatMessage.getUserInfo().getUserName().equalsIgnoreCase(TbadkCoreApplication.getCurrentAccountName())) {
                            return true;
                        }
                        break;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public q98 e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            q98 q98Var = new q98();
            if (imMessageCenterPojo == null) {
                return q98Var;
            }
            q98Var.i = imMessageCenterPojo.getUnread_count();
            q98Var.j = imMessageCenterPojo.getGid();
            q98Var.h = imMessageCenterPojo.getCustomGroupType();
            q98Var.a = imMessageCenterPojo.getGroup_name();
            q98Var.b = imMessageCenterPojo.getLast_user_name();
            q98Var.c = imMessageCenterPojo.getNameShow();
            q98Var.l = imMessageCenterPojo.getLast_content_time();
            if (q98Var.h == 1) {
                q98Var.e = q98Var.b + ":" + imMessageCenterPojo.getLast_content();
            } else {
                q98Var.e = imMessageCenterPojo.getLast_content();
            }
            q98Var.s = jg.g(imMessageCenterPojo.getTaskId(), 0L);
            return q98Var;
        }
        return (q98) invokeL.objValue;
    }

    public q98 f(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        u47.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i)) == null) {
            q98 q98Var = new q98();
            q98Var.i = 0;
            chatMessage.getMsgType();
            q98Var.h = i;
            q98Var.b = chatMessage.getUserInfo().getUserName();
            q98Var.c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            q98Var.m = chatMessage.getMsgId();
            q98Var.n = true;
            q98Var.o = true;
            q98Var.p = 1;
            q98Var.s = chatMessage.getStatTaskId();
            q98Var.t = chatMessage.getStatisticsServiceId();
            int i2 = q98Var.h;
            if (i2 == 1) {
                ImMessageCenterPojo i3 = q47.o().i(chatMessage.getGroupId(), 1);
                if (i3 != null) {
                    q98Var.a = i3.getGroup_name();
                    q98Var.i = i3.getUnread_count();
                    q98Var.l = i3.getLast_content_time();
                }
                q98Var.e = q98Var.b + ":" + y67.y(chatMessage.getMsgType(), chatMessage.getContent());
                q98Var.j = chatMessage.getGroupId();
                if (!ex4.d().r()) {
                    q98Var.n = false;
                } else {
                    q98Var.n = o57.k().c(TbadkCoreApplication.getCurrentAccount(), q98Var.j);
                }
            } else if (i2 == 2) {
                q98Var.j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo i4 = q47.o().i(q98Var.j, 2);
                if (i4 != null) {
                    q98Var.i = i4.getUnread_count();
                    q98Var.l = i4.getLast_content_time();
                    q98Var.o = i4.getIsFriend() == 1;
                    q98Var.p = i4.getFollowStatus();
                }
                q98Var.a = chatMessage.getUserInfo().getUserName();
                q98Var.e = y67.y(chatMessage.getMsgType(), chatMessage.getContent());
                if (q98Var.o) {
                    if (!ex4.d().t()) {
                        q98Var.n = false;
                    } else {
                        q98Var.n = r57.j().c(TbadkCoreApplication.getCurrentAccount(), q98Var.j);
                    }
                } else if (!ex4.d().t()) {
                    q98Var.n = false;
                } else if (!ex4.d().D()) {
                    q98Var.n = false;
                } else {
                    q98Var.n = r57.j().c(TbadkCoreApplication.getCurrentAccount(), q98Var.j);
                }
            } else if (i2 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                q98Var.j = userId;
                if (!TbConfig.IM_USER_ID_TBJX.equals(userId) && !"2807977073".equals(q98Var.j)) {
                    return null;
                }
                ImMessageCenterPojo i5 = q47.o().i(q98Var.j, 4);
                if (i5 != null) {
                    q98Var.i = i5.getUnread_count();
                    q98Var.l = i5.getLast_content_time();
                    q98Var.o = i5.getIsFriend() == 1;
                    q98Var.p = i5.getFollowStatus();
                }
                q98Var.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<u47.a> a2 = u47.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (aVar = a2.get(0)) != null) {
                        q98Var.d = aVar.a;
                        q98Var.e = aVar.b;
                        q98Var.f = aVar.c;
                        q98Var.q = aVar.d;
                        q98Var.s = aVar.k;
                        q98Var.t = aVar.l;
                    }
                } else {
                    q98Var.e = y67.y(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!ex4.d().n()) {
                    q98Var.n = false;
                }
            }
            return q98Var;
        }
        return (q98) invokeLI.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ex4.d().i() && ex4.d().w() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public void h(q98 q98Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, q98Var) == null) || q98Var == null) {
            return;
        }
        this.b.remove(q98Var);
    }

    public final String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("https?://tieba.baidu.com/p/(\\d+)\\?.*").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final Intent k(Context context, no4 no4Var, String str) {
        InterceptResult invokeLLL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, no4Var, str)) == null) {
            if (context == null || no4Var == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            if (!str.startsWith("http://tieba.baidu.com/p/") && !str.startsWith("http://tieba.baidu.com/p/")) {
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                    String substring2 = str.substring(str.lastIndexOf(":") + 1);
                    intent.putExtra(DealIntentService.KEY_CLASS, 1);
                    intent.putExtra("key_start_from", 7);
                    intent.putExtra("id", substring2);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                    if (!str.contains("ftid=")) {
                        return null;
                    }
                    intent.putExtra(DealIntentService.KEY_CLASS, 29);
                    intent.putExtra(PbChosenActivityConfig.KEY_TID, str.substring(str.lastIndexOf("ftid=") + 5));
                } else if (str.startsWith("pk_before:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 6);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith("pk_after:")) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 7);
                    intent.putExtra("value", str.substring(str.lastIndexOf(":") + 1));
                } else if (str.startsWith(NativeConstants.COMPONENT_VOTE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 8);
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE)) {
                    intent.putExtra(DealIntentService.KEY_CLASS, 31);
                    String substring3 = str.substring(str.lastIndexOf(UrlSchemaHelper.SCHEMA_TYPE_PHOTOLIVE) + 5);
                    if (substring3.startsWith("pid=")) {
                        substring = substring3.substring(substring3.lastIndexOf("pid=") + 4);
                    } else {
                        substring = substring3.startsWith("http://") ? substring3.substring(substring3.lastIndexOf("p/") + 2) : "";
                    }
                    if (StringUtils.isNull(substring)) {
                        return null;
                    }
                    intent.putExtra("tid", substring);
                } else if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    return null;
                } else {
                    intent.putExtra(DealIntentService.KEY_CLASS, 0);
                    intent.putExtra("url", str);
                }
            } else {
                String substring4 = str.substring(str.lastIndexOf("/") + 1);
                intent.putExtra(DealIntentService.KEY_CLASS, 1);
                intent.putExtra("key_start_from", 7);
                intent.putExtra("id", substring4);
            }
            intent.putExtra("is_notify", true);
            intent.putExtra("link", str);
            intent.putExtra("message_id", no4Var.c());
            intent.putExtra("task_id", no4Var.e());
            if (!TextUtils.isEmpty(no4Var.d())) {
                intent.putExtra("stat", no4Var.d());
            }
            return intent;
        }
        return (Intent) invokeLLL.objValue;
    }

    public q98 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (q98) invokeV.objValue;
    }

    public List<q98> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.b);
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void o(RemindRecommendMessage remindRecommendMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, remindRecommendMessage) == null) || remindRecommendMessage == null) {
            return;
        }
        q98 q98Var = new q98();
        q98Var.i = 0;
        q98Var.j = "-1";
        q98Var.h = 4;
        String str = remindRecommendMessage.name;
        q98Var.a = str;
        q98Var.b = str;
        q98Var.d = remindRecommendMessage.title;
        q98Var.f = remindRecommendMessage.picture;
        q98Var.q = remindRecommendMessage.url;
        q98Var.l = System.currentTimeMillis();
        q98Var.n = true;
        q98Var.o = true;
        q98Var.p = 1;
        q98Var.s = 0L;
        if (remindRecommendMessage.isLocal) {
            q98Var.r = "2";
        } else {
            q98Var.r = "1";
        }
        c(q98Var);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) || remindRecommendMessage == null || (str = remindRecommendMessage.url) == null || str.length() <= 0) {
            return;
        }
        Intent k = k(this.a, new no4(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
        if (k == null) {
            return;
        }
        PendingIntent service = PendingIntent.getService(this.a, 0, k, 134217728);
        Context context = this.a;
        String str2 = remindRecommendMessage.name;
        String str3 = remindRecommendMessage.title;
        NotificationHelper.showNotification(context, 2000, str2, str3, str3, service, false);
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public void q(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof MemoryChangedMessage) || (data = ((MemoryChangedMessage) customResponsedMessage).getData()) == null || data.getUnread_count() > 0) {
            return;
        }
        h(e(data));
    }

    public List<ChatMessage> r(ResponsedMessage<?> responsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, responsedMessage)) == null) {
            if (responsedMessage instanceof GroupMsgData) {
                GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
                int customType = groupMsgData.getGroupInfo().getCustomType();
                if (groupMsgData.getListMessage() == null || groupMsgData.getListMessage().isEmpty()) {
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(groupMsgData.getListMessage());
                v(linkedList, customType);
                return linkedList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.clear();
            this.c = null;
        }
    }

    public final boolean t(ChatMessage chatMessage, q98 q98Var) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, q98Var)) == null) {
            if (q98Var != null && !StringUtils.isNull(q98Var.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(q98Var.q))) != null && jg.e(paramPair.get("lockWindow"), 0) == 1) {
                long j = q98Var.s;
                String i = i(q98Var.q);
                if (j == 0 || StringUtils.isNull(i) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                    return false;
                }
                if (!this.d.c()) {
                    Activity b2 = x8.g().b();
                    if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                        b2.finish();
                    }
                    chatMessage.setHasRead(true);
                    NotificationHelper.cancelNotification(this.a, 19);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.a, j, i)));
                }
                TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", i));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void u() {
        q98 q98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<q98> list = this.b;
            if ((list == null || list.size() == 0) && this.c == null) {
                return;
            }
            if (!this.d.c() || this.f == 1) {
                Activity b2 = x8.g().b();
                if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                    b2.finish();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.a)));
                this.h.postDelayed(new f(this), 1000L);
                List<q98> list2 = this.b;
                if (list2 == null || list2.size() <= 0 || (q98Var = this.b.get(0)) == null) {
                    return;
                }
                TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", q98Var.m / 100).param("task_id", q98Var.s));
            }
        }
    }

    public void v(List<ChatMessage> list, int i) {
        q98 f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048593, this, list, i) == null) || list == null || list.isEmpty()) {
            return;
        }
        boolean z = false;
        for (ChatMessage chatMessage : list) {
            if (chatMessage != null && d(chatMessage) && (f2 = f(chatMessage, i)) != null && f2.i > 0) {
                if (f2.n) {
                    if (i == 4) {
                        if (t(chatMessage, f2)) {
                            return;
                        }
                        c(f2);
                    } else {
                        this.c = f2;
                    }
                    z = true;
                } else {
                    h(f2);
                }
            }
        }
        if (z) {
            u();
        }
    }
}
