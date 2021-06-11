package d.a.n0.f1.p;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.a.m0.s.e.f;
import d.a.n0.f1.t.c;
import d.a.n0.f1.t.d;
import d.a.n0.f1.t.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f58356c;

    /* renamed from: a  reason: collision with root package name */
    public List<ImMessageCenterPojo> f58357a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public final CustomMessageListener f58358b = new C1378a(0);

    /* renamed from: d.a.n0.f1.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1378a extends CustomMessageListener {
        public C1378a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                a.this.t(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                a.this.s(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                a.this.u(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                if (a.this.f58357a != null) {
                    a.this.f58357a.clear();
                }
                d.a.m0.s.d.b.g0().f0(new f());
                d.a.m0.s.d.b.g0().b0(0);
                d.a.m0.s.d.b.g0().a();
                d.a.m0.s.d.b.g0().l();
            } else if (customResponsedMessage.getCmd() != 2016010 || a.this.f58357a == null) {
            } else {
                a.this.v(false);
            }
        }
    }

    public a() {
        w();
    }

    public static a o() {
        if (f58356c == null) {
            synchronized (a.class) {
                if (f58356c == null) {
                    f58356c = new a();
                }
            }
        }
        return f58356c;
    }

    public final boolean f(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) ? false : true;
    }

    public final void g(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -8 && c.a().b()) {
            fVar.T(imMessageCenterPojo.getUnread_count());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        int userType;
        String str;
        String str2;
        String str3;
        JSONArray jSONArray;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 4 && d.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid()) && !StringUtils.isNull(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0 && (userType = imMessageCenterPojo.getUserType()) != 3) {
            f.a aVar = new f.a();
            aVar.f54315a = imMessageCenterPojo.getGid();
            aVar.f54319e = imMessageCenterPojo.getGroup_name();
            if (userType == 4) {
                String str4 = null;
                try {
                    jSONArray = new JSONArray(imMessageCenterPojo.getLastContentRawData());
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                    str2 = null;
                }
                if (jSONArray.length() == 1) {
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    str = jSONObject.optString("title", null);
                    try {
                        str2 = jSONObject.optString("text", null);
                        try {
                            str3 = jSONObject.optString("isShow", null);
                        } catch (Exception e3) {
                            e = e3;
                            BdLog.e(e);
                            str3 = null;
                            str4 = str;
                            if (str2 == null) {
                            }
                            if (str4 == null) {
                            }
                            aVar.f54316b = str4;
                            aVar.f54317c = str2;
                            aVar.f54323i = str3;
                            aVar.f54318d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                            aVar.f54320f = userType;
                            aVar.f54321g = imMessageCenterPojo.getUnread_count();
                            fVar.g().add(aVar);
                            if (userType == 4) {
                            }
                            fVar.U(fVar.u() + imMessageCenterPojo.getUnread_count());
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str2 = null;
                    }
                    str4 = str;
                    if (str2 == null) {
                        str4 = imMessageCenterPojo.getGroup_name();
                        str2 = imMessageCenterPojo.getLast_content();
                    }
                    if (str4 == null) {
                        str4 = imMessageCenterPojo.getGroup_name();
                    }
                    aVar.f54316b = str4;
                    aVar.f54317c = str2;
                    aVar.f54323i = str3;
                    aVar.f54318d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                } else {
                    str3 = null;
                    str2 = null;
                    if (str2 == null) {
                    }
                    if (str4 == null) {
                    }
                    aVar.f54316b = str4;
                    aVar.f54317c = str2;
                    aVar.f54323i = str3;
                    aVar.f54318d = imMessageCenterPojo.getGroup_name() + ":" + imMessageCenterPojo.getLast_content();
                }
            } else {
                String str5 = TbadkCoreApplication.getInst().getContext().getString(R.string.chosen_pb_original_bar, imMessageCenterPojo.getGroup_name()) + ZeusCrashHandler.NAME_SEPERATOR + imMessageCenterPojo.getLast_content();
                aVar.f54317c = str5;
                aVar.f54318d = str5;
            }
            aVar.f54320f = userType;
            aVar.f54321g = imMessageCenterPojo.getUnread_count();
            fVar.g().add(aVar);
            if (userType == 4) {
                fVar.S(fVar.s() + imMessageCenterPojo.getUnread_count());
            }
            fVar.U(fVar.u() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void i(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && e.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            if (imMessageCenterPojo.getUnread_count() > 0) {
                fVar.H(imMessageCenterPojo.getLast_content());
                String nameShow = imMessageCenterPojo.getNameShow();
                HashMap<String, String> h2 = fVar.h();
                if (h2 != null) {
                    h2.put(imMessageCenterPojo.getGid(), nameShow);
                }
            }
            fVar.W(fVar.w() + imMessageCenterPojo.getUnread_count());
        }
    }

    public final void j(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() == -7 && d.a.n0.f1.t.f.a().b()) {
            fVar.Y(imMessageCenterPojo.getUnread_count());
        }
    }

    public final void k(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != -3) {
            return;
        }
        fVar.B(imMessageCenterPojo.getGroup_name());
        fVar.G(imMessageCenterPojo.getLast_content());
        fVar.O(imMessageCenterPojo.getUnread_count());
    }

    public final void l(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != -4) {
            return;
        }
        fVar.Q(imMessageCenterPojo.getUnread_count());
        fVar.I(imMessageCenterPojo.getLast_content());
        fVar.C(imMessageCenterPojo.getGroup_name());
    }

    public final void m(ImMessageCenterPojo imMessageCenterPojo, f fVar) {
        if (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 1) {
            return;
        }
        HashMap<String, String> a2 = fVar.a();
        if (!d.a.n0.f1.t.b.k().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid())) {
            fVar.M(fVar.l() + imMessageCenterPojo.getUnread_count());
        } else if (imMessageCenterPojo.getUnread_count() > 0) {
            if (TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name())) {
                fVar.F(imMessageCenterPojo.getLast_content());
            } else {
                fVar.F(imMessageCenterPojo.getLast_user_name() + ":" + imMessageCenterPojo.getLast_content());
            }
            a2.put(imMessageCenterPojo.getGid(), imMessageCenterPojo.getGroup_name());
        }
        fVar.L(fVar.j() + imMessageCenterPojo.getUnread_count());
    }

    public final void n(List<f.a> list, List<f.a> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return;
        }
        for (f.a aVar : list) {
            if (aVar != null) {
                for (f.a aVar2 : list2) {
                    if (aVar2 != null && StringHelper.equals(aVar.f54315a, aVar2.f54315a)) {
                        aVar.f54322h = aVar2.f54321g;
                    }
                }
            }
        }
    }

    public final void p(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        if (imMessageCenterPojo == null || list == null) {
            return;
        }
        x(imMessageCenterPojo, list);
        list.add(imMessageCenterPojo);
    }

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return f(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() == -3 || imMessageCenterPojo.getCustomGroupType() == -4) {
            return true;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return f(imMessageCenterPojo);
        }
        if (imMessageCenterPojo.getCustomGroupType() == -8) {
            return true;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 2) {
            return f(imMessageCenterPojo);
        }
        return imMessageCenterPojo.getCustomGroupType() == -7;
    }

    public final boolean r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1) {
            return e.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 4) {
            return d.j().c(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3) {
            imMessageCenterPojo.getCustomGroupType();
            return false;
        }
        return false;
    }

    public final void s(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            boolean r = r(data);
            if (memoryChangedMessage.getType() == 1) {
                p(data, this.f58357a);
            } else if (memoryChangedMessage.getType() == 2) {
                x(data, this.f58357a);
            }
            v(r);
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void u(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 1) {
                this.f58357a.clear();
                for (ImMessageCenterPojo imMessageCenterPojo : data) {
                    if (q(imMessageCenterPojo)) {
                        this.f58357a.add(imMessageCenterPojo);
                    }
                }
            }
        }
    }

    public final void v(boolean z) {
        f fVar = new f();
        fVar.K(z);
        y(fVar);
        fVar.D();
        fVar.E();
        fVar.X(d.a.m0.s.d.b.g0().F().w());
        fVar.N(d.a.m0.s.d.b.g0().F().k());
        fVar.V(d.a.m0.s.d.b.g0().F().u());
        fVar.R(d.a.m0.s.d.b.g0().F().q());
        fVar.P(d.a.m0.s.d.b.g0().F().n());
        n(fVar.g(), d.a.m0.s.d.b.g0().F().g());
        if (!d.a.m0.s.d.d.d().n()) {
            fVar.L(0);
        }
        if (!d.a.m0.s.d.d.d().p()) {
            fVar.W(0);
        }
        if (!d.a.m0.s.d.d.d().l()) {
            fVar.U(0);
            fVar.T(0);
            fVar.S(0);
        }
        if (d.a.m0.s.d.d.d().e() <= 0) {
            fVar.L(0);
            fVar.W(0);
            fVar.T(0);
            fVar.U(0);
            fVar.S(0);
            fVar.Y(0);
            fVar.K(false);
        }
        if ((((((fVar.w() + fVar.j()) + fVar.n()) + fVar.q()) + fVar.t()) + fVar.u()) - fVar.l() <= 0) {
            fVar.K(false);
        }
        d.a.m0.s.d.b.g0().V(fVar);
    }

    public final void w() {
        MessageManager.getInstance().registerListener(2016004, this.f58358b);
        MessageManager.getInstance().registerListener(2016007, this.f58358b);
        MessageManager.getInstance().registerListener(2016001, this.f58358b);
        MessageManager.getInstance().registerListener(2016010, this.f58358b);
        MessageManager.getInstance().registerListener(2016002, this.f58358b);
    }

    public final void x(ImMessageCenterPojo imMessageCenterPojo, List<ImMessageCenterPojo> list) {
        if (imMessageCenterPojo == null || list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImMessageCenterPojo imMessageCenterPojo2 = list.get(i2);
            if (imMessageCenterPojo2 != null && imMessageCenterPojo2.getGid().equals(imMessageCenterPojo.getGid()) && imMessageCenterPojo2.getCustomGroupType() == imMessageCenterPojo.getCustomGroupType()) {
                list.remove(i2);
                return;
            }
        }
    }

    public final void y(f fVar) {
        if (fVar == null) {
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : this.f58357a) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && q(imMessageCenterPojo)) {
                m(imMessageCenterPojo, fVar);
                h(imMessageCenterPojo, fVar);
                i(imMessageCenterPojo, fVar);
                l(imMessageCenterPojo, fVar);
                k(imMessageCenterPojo, fVar);
                g(imMessageCenterPojo, fVar);
                j(imMessageCenterPojo, fVar);
            }
        }
    }
}
