package d.b.j0.u2;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
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
import d.b.i0.r.q.x0;
import d.b.j0.e1.l.c.a;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {
    public static a m;

    /* renamed from: d  reason: collision with root package name */
    public final d.b.j0.p3.b f63211d;

    /* renamed from: e  reason: collision with root package name */
    public int f63212e;

    /* renamed from: f  reason: collision with root package name */
    public int f63213f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63214g;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.j0.u2.d> f63209b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.u2.d f63210c = null;

    /* renamed from: h  reason: collision with root package name */
    public Handler f63215h = new HandlerC1670a(this);
    public CustomMessageListener i = new b(0);
    public CustomMessageListener j = new c(0);
    public CustomMessageListener k = new d(2005016);
    public CustomMessageListener l = new e(2001355);

    /* renamed from: a  reason: collision with root package name */
    public final Context f63208a = TbadkApplication.getInst().getApp();

    /* renamed from: d.b.j0.u2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1670a extends Handler {
        public HandlerC1670a(a aVar) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                a.this.q(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2012125 || customResponsedMessage.getCmd() == 2012121 || customResponsedMessage.getCmd() == 2012123) {
                a.this.r(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            a.this.s();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.n()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.f63211d.c()) {
                        a.this.p(remindRecommendMessage);
                    } else {
                        a.this.o(remindRecommendMessage);
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

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f63211d.e();
        }
    }

    public a() {
        MessageManager.getInstance().registerListener(2016004, this.i);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(2012125, this.j);
        MessageManager.getInstance().registerListener(2012121, this.j);
        MessageManager.getInstance().registerListener(2012123, this.j);
        MessageManager.getInstance().registerListener(this.l);
        this.f63213f = 0;
        this.f63211d = new d.b.j0.p3.b();
    }

    public static a j() {
        if (m == null) {
            m = new a();
        }
        return m;
    }

    public static boolean n() {
        StringBuilder sb = new StringBuilder();
        sb.append(TbadkCoreApplication.getCurrentAccount());
        sb.append("remind_recommend_server_switch");
        return TbadkSettings.getInst().loadInt(sb.toString(), 1) == 1;
    }

    public void c(d.b.j0.u2.d dVar) {
        List<d.b.j0.u2.d> list = this.f63209b;
        if (list == null) {
            return;
        }
        list.add(dVar);
    }

    public boolean d(ChatMessage chatMessage) {
        int msgType;
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

    public d.b.j0.u2.d e(ImMessageCenterPojo imMessageCenterPojo) {
        d.b.j0.u2.d dVar = new d.b.j0.u2.d();
        if (imMessageCenterPojo == null) {
            return dVar;
        }
        dVar.i = imMessageCenterPojo.getUnread_count();
        dVar.j = imMessageCenterPojo.getGid();
        dVar.f63235h = imMessageCenterPojo.getCustomGroupType();
        dVar.f63228a = imMessageCenterPojo.getGroup_name();
        dVar.f63229b = imMessageCenterPojo.getLast_user_name();
        dVar.f63230c = imMessageCenterPojo.getNameShow();
        dVar.l = imMessageCenterPojo.getLast_content_time();
        if (dVar.f63235h == 1) {
            dVar.f63232e = dVar.f63229b + ":" + imMessageCenterPojo.getLast_content();
        } else {
            dVar.f63232e = imMessageCenterPojo.getLast_content();
        }
        dVar.s = d.b.c.e.m.b.f(imMessageCenterPojo.getTaskId(), 0L);
        return dVar;
    }

    public d.b.j0.u2.d f(ChatMessage chatMessage, int i) {
        a.C1289a c1289a;
        d.b.j0.u2.d dVar = new d.b.j0.u2.d();
        dVar.i = 0;
        chatMessage.getMsgType();
        dVar.f63235h = i;
        dVar.f63229b = chatMessage.getUserInfo().getUserName();
        dVar.f63230c = chatMessage.getUserInfo().getName_show();
        chatMessage.getRecordId();
        dVar.m = chatMessage.getMsgId();
        dVar.n = true;
        dVar.o = true;
        dVar.p = 1;
        dVar.s = chatMessage.getStatTaskId();
        dVar.t = chatMessage.getStatisticsServiceId();
        int i2 = dVar.f63235h;
        if (i2 == 1) {
            ImMessageCenterPojo i3 = d.b.j0.e1.k.b.o().i(chatMessage.getGroupId(), 1);
            if (i3 != null) {
                dVar.f63228a = i3.getGroup_name();
                dVar.i = i3.getUnread_count();
                dVar.l = i3.getLast_content_time();
            }
            dVar.f63232e = dVar.f63229b + ":" + d.b.j0.e1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
            dVar.j = chatMessage.getGroupId();
            if (!d.b.i0.s.d.d.d().n()) {
                dVar.n = false;
            } else {
                dVar.n = d.b.j0.e1.t.b.k().c(TbadkCoreApplication.getCurrentAccount(), dVar.j);
            }
        } else if (i2 == 2) {
            dVar.j = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo i4 = d.b.j0.e1.k.b.o().i(dVar.j, 2);
            if (i4 != null) {
                dVar.i = i4.getUnread_count();
                dVar.l = i4.getLast_content_time();
                dVar.o = i4.getIsFriend() == 1;
                dVar.p = i4.getFollowStatus();
            }
            dVar.f63228a = chatMessage.getUserInfo().getUserName();
            dVar.f63232e = d.b.j0.e1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
            if (dVar.o) {
                if (!d.b.i0.s.d.d.d().p()) {
                    dVar.n = false;
                } else {
                    dVar.n = d.b.j0.e1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), dVar.j);
                }
            } else if (!d.b.i0.s.d.d.d().p()) {
                dVar.n = false;
            } else if (!d.b.i0.s.d.d.d().z()) {
                dVar.n = false;
            } else {
                dVar.n = d.b.j0.e1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), dVar.j);
            }
        } else if (i2 == 4) {
            String userId = chatMessage.getUserInfo().getUserId();
            dVar.j = userId;
            if (!TbConfig.IM_USER_ID_TBJX.equals(userId) && !"2807977073".equals(dVar.j)) {
                return null;
            }
            ImMessageCenterPojo i5 = d.b.j0.e1.k.b.o().i(dVar.j, 4);
            if (i5 != null) {
                dVar.i = i5.getUnread_count();
                dVar.l = i5.getLast_content_time();
                dVar.o = i5.getIsFriend() == 1;
                dVar.p = i5.getFollowStatus();
            }
            dVar.f63228a = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<a.C1289a> a2 = d.b.j0.e1.l.c.a.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (a2 != null && a2.size() > 0 && (c1289a = a2.get(0)) != null) {
                    dVar.f63231d = c1289a.f55850a;
                    dVar.f63232e = c1289a.f55851b;
                    dVar.f63233f = c1289a.f55852c;
                    dVar.q = c1289a.f55853d;
                    dVar.s = c1289a.k;
                    dVar.t = c1289a.l;
                }
            } else {
                dVar.f63232e = d.b.j0.e1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!d.b.i0.s.d.d.d().l()) {
                dVar.n = false;
            }
        }
        return dVar;
    }

    public boolean g() {
        return d.b.i0.s.d.d.d().h() && d.b.i0.s.d.d.d().s() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1;
    }

    public void h(d.b.j0.u2.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f63209b.remove(dVar);
    }

    public final String i(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("https?://tieba.baidu.com/p/(\\d+)\\?.*").matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    public final Intent k(Context context, x0 x0Var, String str) {
        String substring;
        if (context == null || x0Var == null || TextUtils.isEmpty(str)) {
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
            } else if (str.startsWith("vote")) {
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
        intent.putExtra("message_id", x0Var.c());
        intent.putExtra("task_id", x0Var.e());
        if (!TextUtils.isEmpty(x0Var.d())) {
            intent.putExtra("stat", x0Var.d());
        }
        return intent;
    }

    public d.b.j0.u2.d l() {
        return this.f63210c;
    }

    public List<d.b.j0.u2.d> m() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.f63209b);
        return linkedList;
    }

    public final void o(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage == null) {
            return;
        }
        d.b.j0.u2.d dVar = new d.b.j0.u2.d();
        dVar.i = 0;
        dVar.j = "-1";
        dVar.f63235h = 4;
        String str = remindRecommendMessage.name;
        dVar.f63228a = str;
        dVar.f63229b = str;
        dVar.f63231d = remindRecommendMessage.title;
        dVar.f63233f = remindRecommendMessage.picture;
        dVar.q = remindRecommendMessage.url;
        dVar.l = System.currentTimeMillis();
        dVar.n = true;
        dVar.o = true;
        dVar.p = 1;
        dVar.s = 0L;
        if (remindRecommendMessage.isLocal) {
            dVar.r = "2";
        } else {
            dVar.r = "1";
        }
        c(dVar);
        u();
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public final void p(RemindRecommendMessage remindRecommendMessage) {
        String str;
        if (remindRecommendMessage == null || (str = remindRecommendMessage.url) == null || str.length() <= 0) {
            return;
        }
        Intent k = k(this.f63208a, new x0(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
        if (k == null) {
            return;
        }
        PendingIntent service = PendingIntent.getService(this.f63208a, 0, k, 134217728);
        Context context = this.f63208a;
        String str2 = remindRecommendMessage.name;
        String str3 = remindRecommendMessage.title;
        NotificationHelper.showNotification(context, 2000, str2, str3, str3, service, false);
        TbadkSettings.getInst().saveString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", "");
    }

    public void q(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo data;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && (data = ((MemoryChangedMessage) customResponsedMessage).getData()) != null && data.getUnread_count() <= 0) {
            h(e(data));
        }
    }

    public List<ChatMessage> r(ResponsedMessage<?> responsedMessage) {
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

    public void s() {
        this.f63209b.clear();
        this.f63210c = null;
    }

    public final boolean t(ChatMessage chatMessage, d.b.j0.u2.d dVar) {
        Map<String, String> paramPair;
        if (dVar != null && !StringUtils.isNull(dVar.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(dVar.q))) != null && d.b.c.e.m.b.d(paramPair.get("lockWindow"), 0) == 1) {
            long j = dVar.s;
            String i = i(dVar.q);
            if (j == 0 || StringUtils.isNull(i) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                return false;
            }
            if (!this.f63211d.c()) {
                Activity b2 = d.b.c.a.b.f().b();
                if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                    b2.finish();
                }
                chatMessage.setHasRead(true);
                NotificationHelper.cancelNotification(this.f63208a, 19);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.f63208a, j, i)));
            }
            TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", i));
            return true;
        }
        return false;
    }

    public void u() {
        d.b.j0.u2.d dVar;
        if (g()) {
            List<d.b.j0.u2.d> list = this.f63209b;
            if ((list == null || list.size() == 0) && this.f63210c == null) {
                return;
            }
            if (!this.f63211d.c() || this.f63213f == 1) {
                Activity b2 = d.b.c.a.b.f().b();
                if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                    b2.finish();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.f63208a)));
                this.f63215h.postDelayed(new f(), 1000L);
                List<d.b.j0.u2.d> list2 = this.f63209b;
                if (list2 == null || list2.size() <= 0 || (dVar = this.f63209b.get(0)) == null) {
                    return;
                }
                TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", dVar.m / 100).param("task_id", dVar.s));
            }
        }
    }

    public void v(List<ChatMessage> list, int i) {
        d.b.j0.u2.d f2;
        if (list == null || list.isEmpty()) {
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
                        this.f63210c = f2;
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
