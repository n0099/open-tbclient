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
import com.repackage.v67;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class gc8 {
    public static /* synthetic */ Interceptable $ic;
    public static gc8 m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<jc8> b;
    public jc8 c;
    public final er8 d;
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

        public a(gc8 gc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var};
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
        public final /* synthetic */ gc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
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
        public final /* synthetic */ gc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
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
        public final /* synthetic */ gc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
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
        public final /* synthetic */ gc8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(gc8 gc8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var, Integer.valueOf(i)};
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
            this.a = gc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && gc8.n()) {
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
        public final /* synthetic */ gc8 a;

        public f(gc8 gc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d.e();
            }
        }
    }

    public gc8() {
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
        this.d = new er8();
    }

    public static gc8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (m == null) {
                m = new gc8();
            }
            return m;
        }
        return (gc8) invokeV.objValue;
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

    public void c(jc8 jc8Var) {
        List<jc8> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jc8Var) == null) || (list = this.b) == null) {
            return;
        }
        list.add(jc8Var);
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

    public jc8 e(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterPojo)) == null) {
            jc8 jc8Var = new jc8();
            if (imMessageCenterPojo == null) {
                return jc8Var;
            }
            jc8Var.i = imMessageCenterPojo.getUnread_count();
            jc8Var.j = imMessageCenterPojo.getGid();
            jc8Var.h = imMessageCenterPojo.getCustomGroupType();
            jc8Var.a = imMessageCenterPojo.getGroup_name();
            jc8Var.b = imMessageCenterPojo.getLast_user_name();
            jc8Var.c = imMessageCenterPojo.getNameShow();
            jc8Var.l = imMessageCenterPojo.getLast_content_time();
            if (jc8Var.h == 1) {
                jc8Var.e = jc8Var.b + ":" + imMessageCenterPojo.getLast_content();
            } else {
                jc8Var.e = imMessageCenterPojo.getLast_content();
            }
            jc8Var.s = kg.g(imMessageCenterPojo.getTaskId(), 0L);
            return jc8Var;
        }
        return (jc8) invokeL.objValue;
    }

    public jc8 f(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        v67.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, chatMessage, i)) == null) {
            jc8 jc8Var = new jc8();
            jc8Var.i = 0;
            chatMessage.getMsgType();
            jc8Var.h = i;
            jc8Var.b = chatMessage.getUserInfo().getUserName();
            jc8Var.c = chatMessage.getUserInfo().getName_show();
            chatMessage.getRecordId();
            jc8Var.m = chatMessage.getMsgId();
            jc8Var.n = true;
            jc8Var.o = true;
            jc8Var.p = 1;
            jc8Var.s = chatMessage.getStatTaskId();
            jc8Var.t = chatMessage.getStatisticsServiceId();
            int i2 = jc8Var.h;
            if (i2 == 1) {
                ImMessageCenterPojo j = r67.p().j(chatMessage.getGroupId(), 1);
                if (j != null) {
                    jc8Var.a = j.getGroup_name();
                    jc8Var.i = j.getUnread_count();
                    jc8Var.l = j.getLast_content_time();
                }
                jc8Var.e = jc8Var.b + ":" + a97.y(chatMessage.getMsgType(), chatMessage.getContent());
                jc8Var.j = chatMessage.getGroupId();
                if (!my4.d().r()) {
                    jc8Var.n = false;
                } else {
                    jc8Var.n = q77.k().c(TbadkCoreApplication.getCurrentAccount(), jc8Var.j);
                }
            } else if (i2 == 2) {
                jc8Var.j = chatMessage.getUserInfo().getUserId();
                ImMessageCenterPojo j2 = r67.p().j(jc8Var.j, 2);
                if (j2 != null) {
                    jc8Var.i = j2.getUnread_count();
                    jc8Var.l = j2.getLast_content_time();
                    jc8Var.o = j2.getIsFriend() == 1;
                    jc8Var.p = j2.getFollowStatus();
                }
                jc8Var.a = chatMessage.getUserInfo().getUserName();
                jc8Var.e = a97.y(chatMessage.getMsgType(), chatMessage.getContent());
                if (jc8Var.o) {
                    if (!my4.d().t()) {
                        jc8Var.n = false;
                    } else {
                        jc8Var.n = t77.j().c(TbadkCoreApplication.getCurrentAccount(), jc8Var.j);
                    }
                } else if (!my4.d().t()) {
                    jc8Var.n = false;
                } else if (!my4.d().D()) {
                    jc8Var.n = false;
                } else {
                    jc8Var.n = t77.j().c(TbadkCoreApplication.getCurrentAccount(), jc8Var.j);
                }
            } else if (i2 == 4) {
                String userId = chatMessage.getUserInfo().getUserId();
                jc8Var.j = userId;
                if (!TbConfig.IM_USER_ID_TBJX.equals(userId) && !"2807977073".equals(jc8Var.j)) {
                    return null;
                }
                ImMessageCenterPojo j3 = r67.p().j(jc8Var.j, 4);
                if (j3 != null) {
                    jc8Var.i = j3.getUnread_count();
                    jc8Var.l = j3.getLast_content_time();
                    jc8Var.o = j3.getIsFriend() == 1;
                    jc8Var.p = j3.getFollowStatus();
                }
                jc8Var.a = chatMessage.getUserInfo().getUserName();
                if (chatMessage.getMsgType() == 7) {
                    List<v67.a> a2 = v67.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (aVar = a2.get(0)) != null) {
                        jc8Var.d = aVar.a;
                        jc8Var.e = aVar.b;
                        jc8Var.f = aVar.c;
                        jc8Var.q = aVar.d;
                        jc8Var.s = aVar.k;
                        jc8Var.t = aVar.l;
                    }
                } else {
                    jc8Var.e = a97.y(chatMessage.getMsgType(), chatMessage.getContent());
                }
                if (!my4.d().n()) {
                    jc8Var.n = false;
                }
            }
            return jc8Var;
        }
        return (jc8) invokeLI.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? my4.d().i() && my4.d().w() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1 : invokeV.booleanValue;
    }

    public void h(jc8 jc8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jc8Var) == null) || jc8Var == null) {
            return;
        }
        this.b.remove(jc8Var);
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

    public final Intent k(Context context, yp4 yp4Var, String str) {
        InterceptResult invokeLLL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, yp4Var, str)) == null) {
            if (context == null || yp4Var == null || TextUtils.isEmpty(str)) {
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
            intent.putExtra("message_id", yp4Var.c());
            intent.putExtra("task_id", yp4Var.e());
            if (!TextUtils.isEmpty(yp4Var.d())) {
                intent.putExtra("stat", yp4Var.d());
            }
            return intent;
        }
        return (Intent) invokeLLL.objValue;
    }

    public jc8 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (jc8) invokeV.objValue;
    }

    public List<jc8> m() {
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
        jc8 jc8Var = new jc8();
        jc8Var.i = 0;
        jc8Var.j = "-1";
        jc8Var.h = 4;
        String str = remindRecommendMessage.name;
        jc8Var.a = str;
        jc8Var.b = str;
        jc8Var.d = remindRecommendMessage.title;
        jc8Var.f = remindRecommendMessage.picture;
        jc8Var.q = remindRecommendMessage.url;
        jc8Var.l = System.currentTimeMillis();
        jc8Var.n = true;
        jc8Var.o = true;
        jc8Var.p = 1;
        jc8Var.s = 0L;
        if (remindRecommendMessage.isLocal) {
            jc8Var.r = "2";
        } else {
            jc8Var.r = "1";
        }
        c(jc8Var);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, remindRecommendMessage) == null) || remindRecommendMessage == null || (str = remindRecommendMessage.url) == null || str.length() <= 0) {
            return;
        }
        Intent k = k(this.a, new yp4(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
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

    public final boolean t(ChatMessage chatMessage, jc8 jc8Var) {
        InterceptResult invokeLL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, chatMessage, jc8Var)) == null) {
            if (jc8Var != null && !StringUtils.isNull(jc8Var.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(jc8Var.q))) != null && kg.e(paramPair.get("lockWindow"), 0) == 1) {
                long j = jc8Var.s;
                String i = i(jc8Var.q);
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
        jc8 jc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && g()) {
            List<jc8> list = this.b;
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
                List<jc8> list2 = this.b;
                if (list2 == null || list2.size() <= 0 || (jc8Var = this.b.get(0)) == null) {
                    return;
                }
                TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", jc8Var.m / 100).param("task_id", jc8Var.s));
            }
        }
    }

    public void v(List<ChatMessage> list, int i) {
        jc8 f2;
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
