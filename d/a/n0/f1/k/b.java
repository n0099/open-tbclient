package d.a.n0.f1.k;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryGetFromDBMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import d.a.n0.f1.k.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import protobuf.NewpushRepair;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f54583h;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessage<String> f54588e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f54589f;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f54584a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final d.a.n0.f1.k.a f54585b = new d.a.n0.f1.k.a();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.n0.f1.k.a f54586c = new d.a.n0.f1.k.a();

    /* renamed from: d  reason: collision with root package name */
    public final d.a.n0.f1.k.a f54587d = new d.a.n0.f1.k.a();

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f54590g = new k(2016008);

    /* loaded from: classes4.dex */
    public class a implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54591a;

        public a(b bVar, List list) {
            this.f54591a = list;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                this.f54591a.add(it.next());
            }
        }
    }

    /* renamed from: d.a.n0.f1.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1317b implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54592a;

        public C1317b(b bVar, List list) {
            this.f54592a = list;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0) {
                    this.f54592a.add(next);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54593a;

        public c(b bVar, List list) {
            this.f54593a = list;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next.getCustomGroupType() == 2 && next.getIsFriend() == 1 && next.getIs_hidden() == 0) {
                    this.f54593a.add(next);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f54594a;

        public d(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
            this.f54594a = imMessageCenterPojo;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                    if (this.f54594a.getLast_content_time() < next.getLast_content_time()) {
                        this.f54594a.setLast_content(next.getLast_content());
                        this.f54594a.setLast_content_time(next.getLast_content_time());
                        this.f54594a.setLast_rid(next.getLast_rid());
                        this.f54594a.setLast_user_name(next.getLast_user_name());
                        this.f54594a.setSend_status(next.getSend_status());
                    }
                    ImMessageCenterPojo imMessageCenterPojo = this.f54594a;
                    imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                    this.f54594a.setIs_hidden(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements CustomMessageTask.CustomRunnable<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f54595e;

        public e(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
            this.f54595e = imMessageCenterPojo;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            d.a.n0.f1.h.j.f().j(this.f54595e);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterPojo f54596a;

        public f(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
            this.f54596a = imMessageCenterPojo;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                    if (this.f54596a.getLast_content_time() < next.getLast_content_time()) {
                        this.f54596a.setLast_content(next.getLast_content());
                        this.f54596a.setLast_content_time(next.getLast_content_time());
                        this.f54596a.setLast_rid(next.getLast_rid());
                        this.f54596a.setLast_user_name(next.getLast_user_name());
                    }
                    this.f54596a.setIs_hidden(0);
                    ImMessageCenterPojo imMessageCenterPojo = this.f54596a;
                    imMessageCenterPojo.setUnread_count(imMessageCenterPojo.getUnread_count() + next.getUnread_count());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements CustomMessageTask.CustomRunnable<String> {
        public g(b bVar) {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
            imMessageCenterPojo.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            imMessageCenterPojo.setCustomGroupType(-8);
            imMessageCenterPojo.setIs_hidden(1);
            d.a.n0.f1.h.j.f().j(imMessageCenterPojo);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LongSparseArray f54597a;

        public h(LongSparseArray longSparseArray) {
            this.f54597a = longSparseArray;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (b.this.A(next)) {
                    this.f54597a.put(d.a.c.e.m.b.f(next.getGid(), 0L), Long.valueOf(d.a.n0.f1.w.b.c(next.getPulled_msgId())));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54599a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewpushRepair.Builder f54600b;

        public i(b bVar, List list, NewpushRepair.Builder builder) {
            this.f54599a = list;
            this.f54600b = builder;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                long f2 = d.a.c.e.m.b.f(next.getGid(), 0L);
                long sid = next.getSid();
                if (sid > 0) {
                    this.f54599a.add(MessageUtils.makeNewpushGroupRepair(f2, next.getUserType(), sid, 0L, d.a.n0.f1.w.b.c(next.getPulled_msgId())));
                }
            }
            if (this.f54599a.size() <= 10) {
                this.f54600b.groups = this.f54599a;
                return;
            }
            this.f54600b.followType = "0";
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CustomMessageTask.CustomRunnable<String> {
        public j(b bVar) {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            String data = customMessage.getData();
            d.a.n0.f1.h.n.a();
            LinkedList<ImMessageCenterPojo> d2 = d.a.n0.f1.h.j.f().d();
            long c2 = d.a.n0.f1.f.l.g.b().c(11L);
            long c3 = d.a.n0.f1.f.l.g.b().c(12L);
            if (d2 == null) {
                d2 = new LinkedList<>();
            }
            if (c2 != -1) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                d2.add(imMessageCenterPojo);
                imMessageCenterPojo.setCustomGroupType(7);
                imMessageCenterPojo.setGid(String.valueOf(11));
                imMessageCenterPojo.setPulled_msgId(d.a.n0.f1.w.b.a(c2));
                imMessageCenterPojo.setIs_hidden(1);
            }
            if (c3 != -1) {
                ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                d2.add(imMessageCenterPojo2);
                imMessageCenterPojo2.setCustomGroupType(8);
                imMessageCenterPojo2.setGid(String.valueOf(12));
                imMessageCenterPojo2.setPulled_msgId(d.a.n0.f1.w.b.a(c3));
                imMessageCenterPojo2.setIs_hidden(1);
            }
            return new MemoryGetFromDBMessage(d2, data);
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof MemoryGetFromDBMessage)) {
                return;
            }
            d.a.n0.f1.o.c.e().b();
            MemoryGetFromDBMessage memoryGetFromDBMessage = (MemoryGetFromDBMessage) customResponsedMessage;
            String uid = memoryGetFromDBMessage.getUid();
            if (!TextUtils.isEmpty(uid) && uid.equals(TbadkCoreApplication.getCurrentAccount())) {
                try {
                    for (ImMessageCenterPojo imMessageCenterPojo : memoryGetFromDBMessage.getData()) {
                        if (!b.this.A(imMessageCenterPojo) || imMessageCenterPojo.getPulled_msgId() > 0) {
                            if (imMessageCenterPojo.getCustomGroupType() == -9 && imMessageCenterPojo.getPushIds() != null && imMessageCenterPojo.getPushIds().length() > 0) {
                                d.a.n0.f1.o.c.e().j(imMessageCenterPojo.getGid(), imMessageCenterPojo.getPushIds());
                            }
                            b.this.F(imMessageCenterPojo);
                        }
                    }
                    b.this.v(false);
                    b.this.q(false);
                    b.this.y();
                    b.this.x();
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                b.this.f54584a.set(true);
                b.this.M();
                return;
            }
            List<ImMessageCenterPojo> data = memoryGetFromDBMessage.getData();
            if (data != null) {
                for (ImMessageCenterPojo imMessageCenterPojo2 : data) {
                    if (imMessageCenterPojo2 != null && d.a.n0.f1.k.c.b(imMessageCenterPojo2.getCustomGroupType()) && imMessageCenterPojo2.getPulled_msgId() > 0) {
                        b.this.F(imMessageCenterPojo2);
                    }
                }
            }
            b.this.f54584a.set(true);
            b.this.M();
        }
    }

    /* loaded from: classes4.dex */
    public class l implements a.InterfaceC1316a {
        public l(b bVar) {
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setIs_hidden(1);
                next.setLast_content("");
                next.setLast_content_time(0L);
                next.setLast_user_name("");
                next.setUnread_count(0);
                next.setSend_status(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements a.InterfaceC1316a {
        public m(b bVar) {
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setIs_hidden(1);
                next.setLast_content("");
                next.setLast_content_time(0L);
                next.setLast_user_name("");
                next.setUnread_count(0);
                next.setSend_status(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements a.InterfaceC1316a {
        public n(b bVar) {
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                next.setIs_hidden(1);
                next.setLast_content("");
                next.setLast_content_time(0L);
                next.setLast_user_name("");
                next.setUnread_count(0);
                next.setSend_status(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54602a;

        public o(b bVar, List list) {
            this.f54602a = list;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                this.f54602a.add(it.next());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54603a;

        public p(b bVar, List list) {
            this.f54603a = list;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                this.f54603a.add(it.next());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54604a;

        public q(b bVar, List list) {
            this.f54604a = list;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                this.f54604a.add(it.next());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements a.InterfaceC1316a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f54605a;

        public r(b bVar, List list) {
            this.f54605a = list;
        }

        @Override // d.a.n0.f1.k.a.InterfaceC1316a
        public void a(Iterator<ImMessageCenterPojo> it) {
            while (it.hasNext()) {
                this.f54605a.add(it.next());
            }
        }
    }

    public b() {
        MessageManager.getInstance().registerListener(this.f54590g);
        this.f54588e = new CustomMessage<>(2016008, TbadkCoreApplication.getCurrentAccount());
        BdUniqueId gen = BdUniqueId.gen();
        this.f54589f = gen;
        this.f54588e.setTag(gen);
    }

    public static b o() {
        if (f54583h == null) {
            synchronized (b.class) {
                if (f54583h == null) {
                    f54583h = new b();
                }
            }
        }
        return f54583h;
    }

    public final boolean A(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (TbadkCoreApplication.getInst().getCustomizedFilter() != null) {
            return TbadkCoreApplication.getInst().getCustomizedFilter().b(imMessageCenterPojo.getCustomGroupType());
        }
        return d.a.n0.f1.k.c.a(imMessageCenterPojo.getCustomGroupType());
    }

    public void B(String str, int i2, boolean z) {
        ImMessageCenterPojo C = C(str, i2, z);
        if (C != null) {
            D(C, false);
        }
    }

    public ImMessageCenterPojo C(String str, int i2, boolean z) {
        ImMessageCenterPojo i3 = i(str, i2);
        if (i3 != null) {
            if (z) {
                i3.setIs_hidden(0);
            } else {
                i3.setIs_hidden(1);
            }
        }
        return i3;
    }

    public final void D(ImMessageCenterPojo imMessageCenterPojo, boolean z) {
        if (this.f54584a.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                P(imMessageCenterPojo, z, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                O(imMessageCenterPojo, z, 1);
            } else {
                L(imMessageCenterPojo, z, 1);
            }
        }
    }

    public final void E(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.f54584a.get()) {
            if (imMessageCenterPojo.getCustomGroupType() == 2) {
                L(imMessageCenterPojo, false, 2);
                L(v(false), false, 1);
            } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                L(imMessageCenterPojo, false, 2);
                L(q(false), false, 1);
            } else {
                L(imMessageCenterPojo, false, 2);
            }
        }
    }

    public final void F(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return;
        }
        n(imMessageCenterPojo.getCustomGroupType()).a(imMessageCenterPojo);
    }

    public void G(String str, int i2) {
        ImMessageCenterPojo i3 = i(str, i2);
        if (i3 == null) {
            return;
        }
        H(str, i2);
        E(i3);
    }

    public void H(String str, int i2) {
        d.a.n0.f1.k.a n2;
        if (this.f54584a.get() && (n2 = n(i2)) != null) {
            n2.e(str);
        }
    }

    public void I(List<ImMessageCenterPojo> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : list) {
            if (imMessageCenterPojo != null) {
                this.f54585b.e(imMessageCenterPojo.getGid());
            }
        }
    }

    public void J() {
        if (this.f54584a.get()) {
            this.f54585b.d(new l(this));
            this.f54586c.d(new m(this));
            this.f54587d.d(new n(this));
            K();
        }
    }

    public void K() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016001));
    }

    public void L(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryChangedMessage(imMessageCenterPojo, z, i2));
    }

    public void M() {
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryInitCompleteMessage(true));
    }

    public void N() {
        L(q(false), false, 1);
    }

    public final void O(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        L(imMessageCenterPojo, z, i2);
        L(q(z), z, i2);
    }

    public final void P(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i2) {
        L(imMessageCenterPojo, z, i2);
        L(v(z), z, i2);
    }

    public void Q() {
        L(v(false), false, 1);
    }

    public void R(String str, String str2) {
        ImMessageCenterPojo i2 = i(str, 1);
        if (i2 != null) {
            i2.setGroup_head(str2);
            D(i2, false);
        }
    }

    public void S(String str, String str2) {
        ImMessageCenterPojo i2 = i(str, 1);
        if (i2 != null) {
            i2.setGroup_name(str2);
            D(i2, false);
        }
    }

    public void T(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.f54584a.get()) {
            ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i2 == null) {
                F(imMessageCenterPojo);
                D(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() >= i2.getLast_rid()) {
                H(i2.getGid(), i2.getCustomGroupType());
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                    imMessageCenterPojo.setGroup_head(i2.getGroup_head());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                    imMessageCenterPojo.setGroup_name(i2.getGroup_name());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                    imMessageCenterPojo.setNameShow(i2.getNameShow());
                }
                if (TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    imMessageCenterPojo.setBjhAvatar(i2.getBjhAvatar());
                }
                F(imMessageCenterPojo);
                D(imMessageCenterPojo, true);
            } else {
                i2.setRead_msgId(imMessageCenterPojo.getRead_msgId());
            }
        }
    }

    public void U(ImMessageCenterPojo imMessageCenterPojo, int i2) {
        if (this.f54584a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo i3 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i3 == null) {
                imMessageCenterPojo.setUnread_count(i2);
                F(imMessageCenterPojo);
                imMessageCenterPojo.setIs_hidden(0);
                D(imMessageCenterPojo, true);
            } else if (imMessageCenterPojo.getLast_rid() > i3.getLast_rid()) {
                i3.setLast_rid(imMessageCenterPojo.getLast_rid());
                i3.setLast_content(imMessageCenterPojo.getLast_content());
                i3.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                i3.setUnread_count(i3.getUnread_count() + i2);
                i3.setIs_hidden(0);
                i3.setCustomGroupType(imMessageCenterPojo.getCustomGroupType());
                i3.setGroup_name(imMessageCenterPojo.getGroup_name());
                i3.setNameShow(imMessageCenterPojo.getNameShow());
                i3.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
                D(i3, true);
            }
        }
    }

    public void V(int i2, long j2, String str) {
        if (this.f54584a.get()) {
            ImMessageCenterPojo i3 = i(str, i2);
            if (i3 == null) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setCustomGroupType(i2);
                imMessageCenterPojo.setPulled_msgId(j2);
                imMessageCenterPojo.setGid(str);
                F(imMessageCenterPojo);
            } else if (i3.getPulled_msgId() < j2) {
                i3.setPulled_msgId(j2);
            }
        }
    }

    public void W(ImMessageCenterPojo imMessageCenterPojo) {
        if (!this.f54584a.get() || imMessageCenterPojo == null || TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            return;
        }
        ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
        if (i2 == null) {
            F(imMessageCenterPojo);
        } else if (i2.getPulled_msgId() > 0 || imMessageCenterPojo.getPulled_msgId() <= 0) {
        } else {
            i2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
        }
    }

    public void X(int i2, ChatMessage chatMessage, String str, int i3) {
        int userType;
        ImMessageCenterPojo i4;
        if (this.f54584a.get()) {
            UserData userData = null;
            if ((i2 == 2 || i2 == 4) && chatMessage != null) {
                if (String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                    userData = chatMessage.getToUserInfo();
                } else {
                    userData = chatMessage.getUserInfo();
                }
                if (userData != null) {
                    str = userData.getUserId();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ImMessageCenterPojo i5 = i(str, i2);
            if (i5 == null) {
                i5 = new ImMessageCenterPojo();
                i5.setCustomGroupType(i2);
                i5.setGid(str);
                F(i5);
            }
            if (i2 == 2 || i2 == 4) {
                if (userData != null) {
                    if (!TextUtils.isEmpty(userData.getPortrait())) {
                        i5.setGroup_head(userData.getPortrait());
                    }
                    if (!TextUtils.isEmpty(userData.getUserName())) {
                        i5.setGroup_name(userData.getUserName());
                    }
                    if (!TextUtils.isEmpty(userData.getName_show())) {
                        i5.setNameShow(userData.getName_show());
                    }
                    if (!TextUtils.isEmpty(userData.getImBjhAvatar())) {
                        i5.setBjhAvatar(userData.getImBjhAvatar());
                    }
                }
                if (chatMessage != null) {
                    if (d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L) != chatMessage.getUserId()) {
                        userType = chatMessage.getUserInfo().getUserType();
                    } else {
                        userType = chatMessage.getToUserInfo().getUserType();
                    }
                    i5.setUserType(userType);
                }
            }
            if (i3 == 1) {
                i5.setLast_content("");
                i5.setLast_rid(0L);
                i5.setSend_status(0);
                i5.setUnread_count(0);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (chatMessage != null && i5.getLast_rid() <= chatMessage.getRecordId()) {
                        i5.setLast_content_time(chatMessage.getTime() * 1000);
                        i5.setLast_content(d.a.n0.f1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent()));
                        i5.setLast_user_name(chatMessage.getUserInfo().getName_show());
                        i5.setLast_rid(chatMessage.getRecordId());
                        i5.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                        i5.setIsFriend(chatMessage.getIsFriend());
                        i5.setFollowStatus(chatMessage.getFollowStatus());
                        if (chatMessage.getLocalData() != null) {
                            i5.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                        }
                    }
                    i5.setIs_hidden(0);
                    if (i2 == 4 && (i4 = i(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)) != null) {
                        i4.setIs_hidden(0);
                    }
                }
            } else if (chatMessage != null) {
                i5.setLast_content_time(chatMessage.getTime() * 1000);
                i5.setLast_content(d.a.n0.f1.w.c.u(chatMessage.getMsgType(), chatMessage.getContent()));
                i5.setLast_user_name(chatMessage.getUserInfo().getName_show());
                i5.setLast_rid(chatMessage.getRecordId());
                i5.setSelf(new CommonMsgPojo(chatMessage).isSelf());
                i5.setIsFriend(chatMessage.getIsFriend());
                i5.setFollowStatus(chatMessage.getFollowStatus());
                if (chatMessage.getLocalData() != null) {
                    i5.setSend_status(chatMessage.getLocalData().getStatus().shortValue());
                }
            } else {
                i5.setLast_content("");
                i5.setLast_rid(0L);
                i5.setSend_status(0);
                i5.setUnread_count(0);
            }
            BdLog.i("send message status " + i5.getSend_status());
            D(i5, false);
        }
    }

    public void Y(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.f54584a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i2 == null) {
                F(imMessageCenterPojo);
                return;
            }
            i2.setGroup_head(imMessageCenterPojo.getGroup_head());
            i2.setGroup_name(imMessageCenterPojo.getGroup_name());
            i2.setNameShow(imMessageCenterPojo.getNameShow());
            i2.setBjhAvatar(imMessageCenterPojo.getBjhAvatar());
        }
    }

    public void Z(ImMessageCenterPojo imMessageCenterPojo) {
        D(a0(imMessageCenterPojo), false);
    }

    public ImMessageCenterPojo a0(ImMessageCenterPojo imMessageCenterPojo) {
        if (this.f54584a.get() && imMessageCenterPojo != null) {
            ImMessageCenterPojo i2 = i(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
            if (i2 == null) {
                F(imMessageCenterPojo);
            } else {
                H(imMessageCenterPojo.getGid(), imMessageCenterPojo.getCustomGroupType());
                imMessageCenterPojo.setPulled_msgId(i2.getPulled_msgId());
                F(imMessageCenterPojo);
            }
            return imMessageCenterPojo;
        }
        return null;
    }

    public final void g() {
        this.f54585b.b();
        this.f54586c.b();
        this.f54587d.b();
        K();
    }

    public void h(String str, int i2) {
        ImMessageCenterPojo i3 = i(str, i2);
        if (i3 != null) {
            i3.setUnread_count(0);
            D(i3, false);
        }
    }

    public ImMessageCenterPojo i(String str, int i2) {
        d.a.n0.f1.k.a n2;
        if (this.f54584a.get() && (n2 = n(i2)) != null) {
            return n2.c(str);
        }
        return null;
    }

    public List<ImMessageCenterPojo> j() {
        LinkedList linkedList = new LinkedList();
        this.f54585b.d(new r(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> k() {
        LinkedList linkedList = new LinkedList();
        this.f54585b.d(new o(this, linkedList));
        this.f54586c.d(new p(this, linkedList));
        this.f54587d.d(new q(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> l() {
        LinkedList linkedList = new LinkedList();
        this.f54587d.d(new a(this, linkedList));
        return linkedList;
    }

    public List<ImMessageCenterPojo> m() {
        LinkedList linkedList = new LinkedList();
        this.f54586c.d(new C1317b(this, linkedList));
        return linkedList;
    }

    public final d.a.n0.f1.k.a n(int i2) {
        if (i2 == 2) {
            return this.f54586c;
        }
        if (i2 == 4) {
            return this.f54587d;
        }
        return this.f54585b;
    }

    public long p(String str, int i2) {
        ImMessageCenterPojo i3 = i(str, i2);
        if (i3 != null) {
            return i3.getPulled_msgId();
        }
        return 0L;
    }

    public final ImMessageCenterPojo q(boolean z) {
        d.a.n0.f1.k.a n2 = n(-8);
        ImMessageCenterPojo c2 = n2 != null ? n2.c(TbEnum.CustomGroupId.OFFICIAL_MERGE) : null;
        if (c2 == null) {
            c2 = new ImMessageCenterPojo();
            c2.setGid(TbEnum.CustomGroupId.OFFICIAL_MERGE);
            c2.setCustomGroupType(-8);
            F(c2);
        }
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setIs_hidden(1);
        this.f54587d.d(new f(this, imMessageCenterPojo));
        c2.setUserType(imMessageCenterPojo.getUserType());
        c2.setLast_content(imMessageCenterPojo.getLast_content());
        c2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
        c2.setLast_rid(imMessageCenterPojo.getLast_rid());
        c2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            c2.setUnread_count(0);
            if (c2.getIs_hidden() != 1) {
                c2.setIs_hidden(1);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new g(this));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        } else if (z) {
            if (ChatStatusManager.getInst().getIsOpen(4)) {
                c2.setUnread_count(0);
            } else {
                c2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
                c2.setUnread_count(imMessageCenterPojo.getUnread_count());
            }
        } else if (c2.getUnread_count() > 0) {
            c2.setUnread_count(imMessageCenterPojo.getUnread_count());
        }
        return c2;
    }

    public LongSparseArray<Long> r() {
        LongSparseArray<Long> longSparseArray = new LongSparseArray<>();
        if (this.f54584a.get()) {
            this.f54585b.d(new h(longSparseArray));
        }
        return longSparseArray;
    }

    public NewpushRepair s() {
        NewpushRepair.Builder builder = new NewpushRepair.Builder();
        ArrayList arrayList = new ArrayList();
        if (this.f54584a.get()) {
            this.f54587d.d(new i(this, arrayList, builder));
        }
        return builder.build(false);
    }

    public long t(String str, int i2) {
        long j2;
        ImMessageCenterPojo i3 = i(str, i2);
        if (i3 != null) {
            j2 = i3.getLast_rid() > i3.getPulled_msgId() ? i3.getLast_rid() : i3.getPulled_msgId();
        } else {
            j2 = 0;
        }
        return j2 + 1;
    }

    public List<ImMessageCenterPojo> u() {
        LinkedList linkedList = new LinkedList();
        this.f54586c.d(new c(this, linkedList));
        return linkedList;
    }

    public final ImMessageCenterPojo v(boolean z) {
        d.a.n0.f1.k.a n2 = n(-7);
        ImMessageCenterPojo c2 = n2 != null ? n2.c(TbEnum.CustomGroupId.STRANGE_MERGE) : null;
        if (c2 == null) {
            c2 = new ImMessageCenterPojo();
            c2.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
            c2.setCustomGroupType(-7);
            F(c2);
        }
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setIs_hidden(1);
        this.f54586c.d(new d(this, imMessageCenterPojo));
        c2.setLast_content(imMessageCenterPojo.getLast_content());
        c2.setLast_content_time(imMessageCenterPojo.getLast_content_time());
        c2.setLast_rid(imMessageCenterPojo.getLast_rid());
        c2.setLast_user_name(imMessageCenterPojo.getLast_user_name());
        c2.setSend_status(imMessageCenterPojo.getSend_status());
        if (imMessageCenterPojo.getIs_hidden() == 1) {
            c2.setUnread_count(0);
            if (c2.getIs_hidden() != 1) {
                c2.setIs_hidden(1);
                ImMessageCenterPojo i2 = i(TbEnum.CustomGroupId.STRANGE_MERGE, -7);
                if (i2 != null) {
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new e(this, i2));
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        } else {
            if (z) {
                if (ChatStatusManager.getInst().getIsOpen(5)) {
                    c2.setUnread_count(0);
                } else {
                    c2.setUnread_count(imMessageCenterPojo.getUnread_count());
                }
            } else if (c2.getUnread_count() > 0) {
                c2.setUnread_count(imMessageCenterPojo.getUnread_count());
            }
            c2.setIs_hidden(imMessageCenterPojo.getIs_hidden());
        }
        return c2;
    }

    public void w() {
        this.f54584a.set(false);
        g();
        MessageManager.getInstance().removeMessage(2016008, this.f54589f);
        this.f54588e.setData(TbadkCoreApplication.getCurrentAccount());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016008, new j(this));
        customMessageTask.setParallel(TiebaIMConfig.getParallel());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(this.f54588e, customMessageTask);
    }

    public final void x() {
        ImMessageCenterPojo c2;
        d.a.n0.f1.k.a n2 = n(-3);
        if (n2 == null || (c2 = n2.c(TbEnum.CustomGroupId.GROUP_UPDATE)) == null) {
            return;
        }
        String last_content = c2.getLast_content();
        if (TextUtils.isEmpty(last_content)) {
            return;
        }
        try {
            c2.setLast_content(new JSONObject(last_content).optString(TbEnum.SystemMessage.KEY_USER_MSG));
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public final void y() {
        ImMessageCenterPojo c2;
        String str;
        String str2;
        d.a.n0.f1.k.a n2 = n(-4);
        if (n2 == null || (c2 = n2.c(TbEnum.CustomGroupId.GROUP_VALIDATION)) == null) {
            return;
        }
        String last_content = c2.getLast_content();
        if (TextUtils.isEmpty(last_content)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(last_content);
            JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            String str3 = "";
            if (true != jSONObject.isNull("notice_id")) {
                str3 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                String optString = jSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                String optString2 = jSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                str = optString;
                str2 = optString2;
            } else if (optJSONObject != null) {
                str3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                str = optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME);
                str2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
            } else {
                str2 = "";
                str = str2;
            }
            ImMessageCenterPojo c3 = this.f54585b.c(str3);
            if (c3 != null) {
                str2 = c3.getGroup_name();
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            c2.setLast_content(str + TbadkCoreApplication.getInst().getApp().getApplicationContext().getString(R.string.validate_im_apply_prefix1) + str2);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public boolean z() {
        return this.f54584a.get();
    }
}
