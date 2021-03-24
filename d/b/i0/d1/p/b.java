package d.b.i0.d1.p;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.RequestGetGroupInfoMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import d.b.b.c.g.c;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static b f53965d;

    /* renamed from: a  reason: collision with root package name */
    public String f53966a;

    /* renamed from: b  reason: collision with root package name */
    public c f53967b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f53968c;

    /* loaded from: classes4.dex */
    public class a extends c {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 202006 && (socketResponsedMessage instanceof PushNotifyMessage)) {
                b.this.e((PushNotifyMessage) socketResponsedMessage);
            }
        }
    }

    /* renamed from: d.b.i0.d1.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1207b extends CustomMessageListener {
        public C1207b(b bVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016014 || (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) == null) {
                return;
            }
            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                MessageManager.getInstance().dispatchResponsedMessage(new RequestGetGroupInfoMessage(Long.valueOf(d.b.b.e.m.b.f(imMessageCenterPojo.getGid(), 0L))));
            }
            d.b.i0.d1.m.b.l().s(d.b.b.e.m.b.f(imMessageCenterPojo.getGid(), 0L), d.b.i0.d1.w.b.c(imMessageCenterPojo.getPulled_msgId()), 0L, true);
        }
    }

    public b() {
        new ArrayList();
        this.f53967b = new a(202006);
        this.f53968c = new C1207b(this, 0);
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (f53965d == null) {
                f53965d = new b();
            }
            bVar = f53965d;
        }
        return bVar;
    }

    public String c() {
        return this.f53966a;
    }

    public void d() {
        f();
    }

    public final void e(PushNotifyMessage pushNotifyMessage) {
        if (pushNotifyMessage != null) {
            if (pushNotifyMessage.getType() == 3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SyncServiceConfig(TbadkCoreApplication.getInst())));
            } else if (pushNotifyMessage.getType() == 4) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010001, pushNotifyMessage.getContent()));
            } else if (d.b.i0.d1.k.b.o().z()) {
                String valueOf = String.valueOf(pushNotifyMessage.getGroupId());
                d.b.h0.r.z.a.a("im", -1L, 202006, "notify", 0, null, "comment", "gid-" + valueOf + "-gType-" + pushNotifyMessage.getGroupType() + "-mid-" + pushNotifyMessage.getNewestMsgId());
                if (TextUtils.isEmpty(valueOf)) {
                    return;
                }
                BdLog.e("pushNotifyManager groupType = " + pushNotifyMessage.getGroupType() + " gid = " + valueOf + "msgid = " + pushNotifyMessage.getNewestMsgId());
                if (pushNotifyMessage.getGroupType() == 0) {
                    d.b.i0.d1.m.b.l().r(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                    return;
                }
                int a2 = d.b.i0.d1.m.a.a(pushNotifyMessage.getGroupType());
                if (TbadkCoreApplication.getInst().getCustomizedFilter() == null || TbadkCoreApplication.getInst().getCustomizedFilter().b(a2)) {
                    if (d.b.i0.d1.k.b.o().i(String.valueOf(pushNotifyMessage.getGroupId()), a2) != null) {
                        d.b.i0.d1.m.b.l().r(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), pushNotifyMessage.getPushTime());
                    } else {
                        h(pushNotifyMessage.getGroupId(), pushNotifyMessage.getNewestMsgId(), a2);
                    }
                }
            }
        }
    }

    public final void f() {
        MessageManager.getInstance().registerListener(this.f53967b);
        MessageManager.getInstance().registerListener(2016014, this.f53968c);
    }

    public void g(String str) {
        this.f53966a = str;
    }

    public final void h(long j, long j2, int i) {
        if (j2 <= 0) {
            return;
        }
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setCustomGroupType(i);
        imMessageCenterPojo.setGid(String.valueOf(j));
        imMessageCenterPojo.setPulled_msgId(d.b.i0.d1.w.b.a(j2 - 1));
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryNotifyUpdataGroupMessage(imMessageCenterPojo));
    }
}
