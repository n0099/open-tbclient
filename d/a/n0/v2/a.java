package d.a.n0.v2;

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
import d.a.m0.r.q.x0;
import d.a.n0.f1.l.c.a;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class a {
    public static a m;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.n0.q3.b f62310d;

    /* renamed from: e  reason: collision with root package name */
    public int f62311e;

    /* renamed from: f  reason: collision with root package name */
    public int f62312f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62313g;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.n0.v2.d> f62308b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.v2.d f62309c = null;

    /* renamed from: h  reason: collision with root package name */
    public Handler f62314h = new HandlerC1688a(this);

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f62315i = new b(0);
    public CustomMessageListener j = new c(0);
    public CustomMessageListener k = new d(2005016);
    public CustomMessageListener l = new e(2001355);

    /* renamed from: a  reason: collision with root package name */
    public final Context f62307a = TbadkApplication.getInst().getApp();

    /* renamed from: d.a.n0.v2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC1688a extends Handler {
        public HandlerC1688a(a aVar) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004) {
                a.this.q(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
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

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof RemindRecommendMessage) && a.n()) {
                int hours = new Date(System.currentTimeMillis()).getHours();
                if ((hours < 0 || hours > 7) && hours < 23) {
                    RemindRecommendMessage remindRecommendMessage = (RemindRecommendMessage) customResponsedMessage;
                    if (a.this.f62310d.c()) {
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

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f62310d.e();
        }
    }

    public a() {
        MessageManager.getInstance().registerListener(2016004, this.f62315i);
        MessageManager.getInstance().registerListener(this.k);
        MessageManager.getInstance().registerListener(2012125, this.j);
        MessageManager.getInstance().registerListener(2012121, this.j);
        MessageManager.getInstance().registerListener(2012123, this.j);
        MessageManager.getInstance().registerListener(this.l);
        this.f62312f = 0;
        this.f62310d = new d.a.n0.q3.b();
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

    public void c(d.a.n0.v2.d dVar) {
        List<d.a.n0.v2.d> list = this.f62308b;
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

    public d.a.n0.v2.d e(ImMessageCenterPojo imMessageCenterPojo) {
        d.a.n0.v2.d dVar = new d.a.n0.v2.d();
        if (imMessageCenterPojo == null) {
            return dVar;
        }
        dVar.f62336i = imMessageCenterPojo.getUnread_count();
        dVar.j = imMessageCenterPojo.getGid();
        dVar.f62335h = imMessageCenterPojo.getCustomGroupType();
        dVar.f62328a = imMessageCenterPojo.getGroup_name();
        dVar.f62329b = imMessageCenterPojo.getLast_user_name();
        dVar.f62330c = imMessageCenterPojo.getNameShow();
        dVar.l = imMessageCenterPojo.getLast_content_time();
        if (dVar.f62335h == 1) {
            dVar.f62332e = dVar.f62329b + ":" + imMessageCenterPojo.getLast_content();
        } else {
            dVar.f62332e = imMessageCenterPojo.getLast_content();
        }
        dVar.s = d.a.c.e.m.b.f(imMessageCenterPojo.getTaskId(), 0L);
        return dVar;
    }

    public d.a.n0.v2.d f(ChatMessage chatMessage, int i2) {
        a.C1318a c1318a;
        d.a.n0.v2.d dVar = new d.a.n0.v2.d();
        dVar.f62336i = 0;
        chatMessage.getMsgType();
        dVar.f62335h = i2;
        dVar.f62329b = chatMessage.getUserInfo().getUserName();
        dVar.f62330c = chatMessage.getUserInfo().getName_show();
        chatMessage.getRecordId();
        dVar.m = chatMessage.getMsgId();
        dVar.n = true;
        dVar.o = true;
        dVar.p = 1;
        dVar.s = chatMessage.getStatTaskId();
        dVar.t = chatMessage.getStatisticsServiceId();
        int i3 = dVar.f62335h;
        if (i3 == 1) {
            ImMessageCenterPojo i4 = d.a.n0.f1.k.b.o().i(chatMessage.getGroupId(), 1);
            if (i4 != null) {
                dVar.f62328a = i4.getGroup_name();
                dVar.f62336i = i4.getUnread_count();
                dVar.l = i4.getLast_content_time();
            }
            dVar.f62332e = dVar.f62329b + ":" + d.a.n0.f1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
            dVar.j = chatMessage.getGroupId();
            if (!d.a.m0.s.d.d.d().n()) {
                dVar.n = false;
            } else {
                dVar.n = d.a.n0.f1.t.b.k().c(TbadkCoreApplication.getCurrentAccount(), dVar.j);
            }
        } else if (i3 == 2) {
            dVar.j = chatMessage.getUserInfo().getUserId();
            ImMessageCenterPojo i5 = d.a.n0.f1.k.b.o().i(dVar.j, 2);
            if (i5 != null) {
                dVar.f62336i = i5.getUnread_count();
                dVar.l = i5.getLast_content_time();
                dVar.o = i5.getIsFriend() == 1;
                dVar.p = i5.getFollowStatus();
            }
            dVar.f62328a = chatMessage.getUserInfo().getUserName();
            dVar.f62332e = d.a.n0.f1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
            if (dVar.o) {
                if (!d.a.m0.s.d.d.d().p()) {
                    dVar.n = false;
                } else {
                    dVar.n = d.a.n0.f1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), dVar.j);
                }
            } else if (!d.a.m0.s.d.d.d().p()) {
                dVar.n = false;
            } else if (!d.a.m0.s.d.d.d().z()) {
                dVar.n = false;
            } else {
                dVar.n = d.a.n0.f1.t.e.j().c(TbadkCoreApplication.getCurrentAccount(), dVar.j);
            }
        } else if (i3 == 4) {
            String userId = chatMessage.getUserInfo().getUserId();
            dVar.j = userId;
            if (!TbConfig.IM_USER_ID_TBJX.equals(userId) && !"2807977073".equals(dVar.j)) {
                return null;
            }
            ImMessageCenterPojo i6 = d.a.n0.f1.k.b.o().i(dVar.j, 4);
            if (i6 != null) {
                dVar.f62336i = i6.getUnread_count();
                dVar.l = i6.getLast_content_time();
                dVar.o = i6.getIsFriend() == 1;
                dVar.p = i6.getFollowStatus();
            }
            dVar.f62328a = chatMessage.getUserInfo().getUserName();
            if (chatMessage.getMsgType() == 7) {
                List<a.C1318a> a2 = d.a.n0.f1.l.c.a.a(chatMessage.getContent(), null, chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (a2 != null && a2.size() > 0 && (c1318a = a2.get(0)) != null) {
                    dVar.f62331d = c1318a.f54607a;
                    dVar.f62332e = c1318a.f54608b;
                    dVar.f62333f = c1318a.f54609c;
                    dVar.q = c1318a.f54610d;
                    dVar.s = c1318a.k;
                    dVar.t = c1318a.l;
                }
            } else {
                dVar.f62332e = d.a.n0.f1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent());
            }
            if (!d.a.m0.s.d.d.d().l()) {
                dVar.n = false;
            }
        }
        return dVar;
    }

    public boolean g() {
        return d.a.m0.s.d.d.d().h() && d.a.m0.s.d.d.d().s() && SwitchManager.getInstance().findType(ScreenLockSyncSwitch.KEY) == 1;
    }

    public void h(d.a.n0.v2.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f62308b.remove(dVar);
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

    public d.a.n0.v2.d l() {
        return this.f62309c;
    }

    public List<d.a.n0.v2.d> m() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.f62308b);
        return linkedList;
    }

    public final void o(RemindRecommendMessage remindRecommendMessage) {
        if (remindRecommendMessage == null) {
            return;
        }
        d.a.n0.v2.d dVar = new d.a.n0.v2.d();
        dVar.f62336i = 0;
        dVar.j = "-1";
        dVar.f62335h = 4;
        String str = remindRecommendMessage.name;
        dVar.f62328a = str;
        dVar.f62329b = str;
        dVar.f62331d = remindRecommendMessage.title;
        dVar.f62333f = remindRecommendMessage.picture;
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
        Intent k = k(this.f62307a, new x0(-1L, -1L, remindRecommendMessage.url, remindRecommendMessage.title, "", -1L), str);
        if (k == null) {
            return;
        }
        PendingIntent service = PendingIntent.getService(this.f62307a, 0, k, 134217728);
        Context context = this.f62307a;
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
        this.f62308b.clear();
        this.f62309c = null;
    }

    public final boolean t(ChatMessage chatMessage, d.a.n0.v2.d dVar) {
        Map<String, String> paramPair;
        if (dVar != null && !StringUtils.isNull(dVar.q) && g() && (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(dVar.q))) != null && d.a.c.e.m.b.d(paramPair.get("lockWindow"), 0) == 1) {
            long j = dVar.s;
            String i2 = i(dVar.q);
            if (j == 0 || StringUtils.isNull(i2) || UtilHelper.getTodayZeroTime() < TbSingleton.getInstance().getLastResumeTime()) {
                return false;
            }
            if (!this.f62310d.c()) {
                Activity b2 = d.a.c.a.b.f().b();
                if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals(ScreenLockActivity.class.getName())) {
                    b2.finish();
                }
                chatMessage.setHasRead(true);
                NotificationHelper.cancelNotification(this.f62307a, 19);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PushDialogActivityConfig(this.f62307a, j, i2)));
            }
            TiebaStatic.log(new StatisticItem("c13196").param("obj_type", 1).param("obj_source", 2).param("tid", i2));
            return true;
        }
        return false;
    }

    public void u() {
        d.a.n0.v2.d dVar;
        if (g()) {
            List<d.a.n0.v2.d> list = this.f62308b;
            if ((list == null || list.size() == 0) && this.f62309c == null) {
                return;
            }
            if (!this.f62310d.c() || this.f62312f == 1) {
                Activity b2 = d.a.c.a.b.f().b();
                if (b2 != null && b2.getClass() != null && b2.getClass().getName().equals("com.baidu.tieba.pushdialog.PushDialogActivity")) {
                    b2.finish();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ScreenLockActivityConfig(this.f62307a)));
                this.f62314h.postDelayed(new f(), 1000L);
                List<d.a.n0.v2.d> list2 = this.f62308b;
                if (list2 == null || list2.size() <= 0 || (dVar = this.f62308b.get(0)) == null) {
                    return;
                }
                TiebaStatic.logPagePV(new StatisticItem("c11702").param("msg_id", dVar.m / 100).param("task_id", dVar.s));
            }
        }
    }

    public void v(List<ChatMessage> list, int i2) {
        d.a.n0.v2.d f2;
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z = false;
        for (ChatMessage chatMessage : list) {
            if (chatMessage != null && d(chatMessage) && (f2 = f(chatMessage, i2)) != null && f2.f62336i > 0) {
                if (f2.n) {
                    if (i2 == 4) {
                        if (t(chatMessage, f2)) {
                            return;
                        }
                        c(f2);
                    } else {
                        this.f62309c = f2;
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
