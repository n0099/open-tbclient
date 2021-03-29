package d.b.h0.s.d;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static volatile c k;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<ImMessageCenterPojo> f51259a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f51260b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f51261c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51262d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f51263e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51264f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51265g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f51266h = 0;
    public boolean i = false;
    public final CustomMessageListener j = new a(0);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001120) {
                c.this.p(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016002) {
                c.this.o(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                c.this.m(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                c.this.q(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                c.this.n(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                c.this.s();
            } else if (customResponsedMessage.getCmd() == 2016011) {
                c.this.r();
            }
        }
    }

    public static c k() {
        if (k == null) {
            synchronized (c.class) {
                if (k == null) {
                    k = new c();
                }
            }
        }
        return k;
    }

    public final void h(List<ImMessageCenterPojo> list) {
        int unread_count;
        if (list == null) {
            return;
        }
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ImMessageCenterPojo imMessageCenterPojo = list.get(i2);
            if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
                if (imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -7) {
                    if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        if (d.d().n()) {
                            GroupSettingItemData a2 = d.b.i0.d1.t.b.k().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                        if (d.d().p()) {
                            PersonalSettingItemData a3 = d.b.i0.d1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
                            if (d.d().p()) {
                                unread_count = imMessageCenterPojo.getUnread_count();
                                i += unread_count;
                            }
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() != -8) {
                    }
                }
                z = true;
            }
        }
        if (d.d().e() == 0) {
            i = 0;
        }
        boolean z2 = i > 0 ? z : false;
        this.f51266h = i;
        this.i = z2;
    }

    public final void i(int i, int i2, int i3, int i4) {
        boolean z = i > 0 || i2 > 0 || i3 > 0 || i4 > 0;
        int i5 = (i <= 0 || !d.d().w()) ? 0 : i + 0;
        if (i2 > 0 && d.d().o()) {
            i5 += i2;
        }
        if (i3 > 0 && d.d().t()) {
            i5 += i3;
        }
        if (i4 > 0 && d.d().r()) {
            i5 += i4;
        }
        if (d.d().e() == 0) {
            i5 = 0;
        }
        this.f51265g = i5 > 0 ? z : false;
        this.f51264f = i5;
        this.f51260b = i;
        this.f51261c = i2;
        this.f51262d = i3;
        this.f51263e = i4;
    }

    public final boolean j(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && ((!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) && imMessageCenterPojo.getLast_content_time() != 0)) {
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                return !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
            } else if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
                return true;
            } else {
                if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                    return true;
                }
                if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
                    return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
                }
            }
        }
        return false;
    }

    public void l() {
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

    public final void m(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryChangedMessage memoryChangedMessage;
        ImMessageCenterPojo data;
        if (!(customResponsedMessage instanceof MemoryChangedMessage) || (data = (memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage).getData()) == null || TextUtils.isEmpty(data.getGid())) {
            return;
        }
        if (memoryChangedMessage.getType() == 1) {
            t(this.f51259a, data);
            if (j(data)) {
                this.f51259a.add(data);
            }
        } else if (memoryChangedMessage.getType() == 2) {
            t(this.f51259a, data);
        }
        h(this.f51259a);
        v();
    }

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        this.f51259a.clear();
        h(this.f51259a);
        v();
    }

    public final void o(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void p(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
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
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || data == null) {
                return;
            }
            this.f51259a.clear();
            for (ImMessageCenterPojo imMessageCenterPojo : data) {
                if (imMessageCenterPojo != null && j(imMessageCenterPojo)) {
                    this.f51259a.add(imMessageCenterPojo);
                }
            }
            h(this.f51259a);
            v();
        }
    }

    public final void r() {
        i(this.f51260b, this.f51261c, this.f51262d, this.f51263e);
        h(this.f51259a);
        v();
    }

    public final void s() {
        i(this.f51260b, this.f51261c, this.f51262d, this.f51263e);
        h(this.f51259a);
        v();
    }

    public final void t(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        if (linkedList == null || linkedList.size() <= 0 || imMessageCenterPojo == null) {
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
        this.f51259a.clear();
        this.f51260b = 0;
        this.f51261c = 0;
        this.f51262d = 0;
        this.f51263e = 0;
        this.f51264f = 0;
        this.f51265g = false;
        this.f51266h = 0;
        this.i = false;
        this.f51266h = 0;
        this.i = false;
    }

    public final void v() {
        NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
        newsRemindMessage.setMsgAgreeCount(this.f51260b);
        newsRemindMessage.setMsgAtCount(this.f51261c);
        newsRemindMessage.setMsgReplyCount(this.f51262d);
        newsRemindMessage.setMsgFansCount(this.f51263e);
        newsRemindMessage.setMsgCount(this.f51264f);
        newsRemindMessage.setHasMsgRemind(this.f51265g);
        newsRemindMessage.setChatCount(this.f51266h);
        newsRemindMessage.setHasChatRemind(this.i);
        MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
    }
}
