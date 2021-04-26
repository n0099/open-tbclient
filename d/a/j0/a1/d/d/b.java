package d.a.j0.a1.d.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoHttpResMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoRequestMessage;
import com.baidu.tieba.homepage.gamevideo.message.GameVideoSocketResMessage;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.j0.x.e0.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVertical.ClassInfo;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.SubClassItem;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f50639a;

    /* renamed from: b  reason: collision with root package name */
    public e f50640b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50641c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50642d;

    /* renamed from: h  reason: collision with root package name */
    public int f50646h;
    public DataRes.Builder k;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50643e = true;
    public boolean j = false;
    public d.a.c.c.g.a l = new a(CmdConfigHttp.CMD_GAME_VIDEO, 309646);

    /* renamed from: f  reason: collision with root package name */
    public List<n> f50644f = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public List<ThreadInfo> f50645g = new LinkedList();

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.j0.a1.d.c.a> f50647i = new LinkedList();

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i2;
            ClassInfo classInfo;
            b.this.f50641c = false;
            if (responsedMessage == null) {
                b.this.f50643e = false;
                if (b.this.f50640b != null) {
                    b.this.f50640b.b(-1, "", b.this.f50642d);
                    return;
                }
                return;
            }
            DataRes dataRes = null;
            if (responsedMessage instanceof GameVideoSocketResMessage) {
                dataRes = ((GameVideoSocketResMessage) responsedMessage).mResultData;
            } else if (responsedMessage instanceof GameVideoHttpResMessage) {
                dataRes = ((GameVideoHttpResMessage) responsedMessage).mResultData;
            }
            if (dataRes != null && (classInfo = dataRes.class_info) != null && !ListUtils.isEmpty(classInfo.sub_class_list)) {
                b.this.k(dataRes.class_info.sub_class_list);
                b.this.j = dataRes.need_rechoose.intValue() == 1;
            }
            if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
                i2 = 0;
            } else {
                i2 = ListUtils.getCount(dataRes.thread_list);
                b.this.n(dataRes);
                if (!ListUtils.isEmpty(dataRes.thread_list)) {
                    b.this.z(dataRes);
                }
            }
            if (b.this.f50640b != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.f50640b.a(i2, b.this.f50642d, false);
                } else {
                    b.this.f50640b.b(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.f50642d);
                }
            }
            b.this.f50643e = false;
        }
    }

    /* renamed from: d.a.j0.a1.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1106b extends f0<DataRes> {
        public C1106b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            l<byte[]> e2 = d.a.i0.r.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
            if (e2 != null && (bArr = e2.get(String.valueOf(b.this.f50646h))) != null && bArr.length != 0) {
                try {
                    return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                } catch (IOException e3) {
                    BdLog.e(e3);
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.i0.z0.n<DataRes> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            if (dataRes != null) {
                b.this.k = new DataRes.Builder(dataRes);
                int count = ListUtils.getCount(dataRes.thread_list);
                if (count > 0) {
                    b.this.n(dataRes);
                    b.this.k(dataRes.class_info.sub_class_list);
                    if (b.this.f50640b != null) {
                        b.this.f50640b.a(count, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f50651a;

        public d(DataRes.Builder builder) {
            this.f50651a = builder;
        }

        @Override // d.a.i0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f50651a.build(true));
            try {
                d.a.i0.r.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(b.this.f50646h), builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2, boolean z, boolean z2);

        void b(int i2, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, e eVar) {
        this.f50639a = tbPageContext;
        this.f50640b = eVar;
    }

    public final void A(DataRes.Builder builder) {
        h0.b(new d(builder), null);
    }

    public final void k(List<SubClassItem> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f50647i == null) {
            this.f50647i = new LinkedList();
        }
        this.f50647i.clear();
        for (SubClassItem subClassItem : list) {
            d.a.j0.a1.d.c.a aVar = new d.a.j0.a1.d.c.a();
            aVar.a(subClassItem);
            this.f50647i.add(aVar);
        }
    }

    public List<n> l() {
        return this.f50644f;
    }

    public List<d.a.j0.a1.d.c.a> m() {
        return this.f50647i;
    }

    public final void n(DataRes dataRes) {
        s(dataRes.thread_list, !this.f50642d);
        List<n> y = y();
        this.f50644f = y;
        d.a.j0.a1.d.d.a.b(dataRes, y);
    }

    public boolean o() {
        return this.j;
    }

    public final void p() {
        h0.b(new C1106b(), new c());
    }

    public void q(int i2) {
        int i3;
        if (this.f50641c) {
            return;
        }
        this.f50646h = i2;
        this.f50641c = true;
        this.f50642d = false;
        if (this.f50643e) {
            p();
            this.f50643e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!j.H()) {
            if (j.v()) {
                i3 = 4;
            } else if (j.u()) {
                i3 = 3;
            } else if (j.t()) {
                i3 = 2;
            }
            gameVideoRequestMessage.new_net_type = i3;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.f50639a.sendMessage(gameVideoRequestMessage);
        }
        i3 = 1;
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f50639a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i2) {
        if (this.f50641c) {
            return;
        }
        this.f50646h = i2;
        int i3 = 1;
        this.f50641c = true;
        this.f50642d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i2;
        if (!j.H()) {
            if (j.v()) {
                i3 = 4;
            } else if (j.u()) {
                i3 = 3;
            } else if (j.t()) {
                i3 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i3;
        gameVideoRequestMessage.load_type = 2;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f50639a.sendMessage(gameVideoRequestMessage);
    }

    public final void s(List<ThreadInfo> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f50645g);
            this.f50645g.clear();
            this.f50645g.addAll(linkedList);
            return;
        }
        this.f50645g.addAll(list);
    }

    public void t() {
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public void u() {
        MessageManager.getInstance().registerListener(this.l);
    }

    public void v(String str) {
        Long l;
        DataRes.Builder builder = this.k;
        if (builder == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(str, 0L);
        for (int i2 = 0; i2 < this.k.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.k.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                this.k.thread_list.remove(i2);
                A(this.k);
                return;
            }
        }
    }

    public void w(String str) {
        if (ListUtils.isEmpty(this.f50644f)) {
            return;
        }
        Iterator<n> it = this.f50644f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.j0.x.e0.b) {
                d.a.j0.x.e0.b bVar = (d.a.j0.x.e0.b) next;
                if (bVar.m() != null && bVar.m().w1() != null && bVar.m().w1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        this.f50643e = true;
        this.f50644f.clear();
        this.f50645g.clear();
    }

    public final List<n> y() {
        LinkedList linkedList = new LinkedList();
        if (ListUtils.isEmpty(this.f50645g)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.f50645g) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            if (d.a.j0.x.e0.l.d0(a2Var)) {
                k kVar = new k();
                kVar.f62455e = a2Var;
                kVar.l = a2Var.w1();
                kVar.position = i2;
                kVar.r = true;
                linkedList.add(kVar);
                d.a.j0.x.e0.l lVar = new d.a.j0.x.e0.l(a2Var);
                lVar.l = a2Var.w1();
                lVar.position = i2;
                lVar.x = true;
                linkedList.add(lVar);
                if (threadInfo.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.f62455e = a2Var;
                    kVar2.l = a2Var.w1();
                    kVar2.position = i2;
                    kVar2.C = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.f62455e = a2Var;
                kVar3.l = a2Var.w1();
                kVar3.position = i2;
                kVar3.D = true;
                linkedList.add(kVar3);
                i2++;
            }
        }
        return linkedList;
    }

    public final void z(DataRes dataRes) {
        DataRes.Builder builder = new DataRes.Builder();
        builder.need_rechoose = dataRes.need_rechoose;
        builder.class_info = dataRes.class_info;
        builder.thread_personalized = dataRes.thread_personalized;
        if (ListUtils.getCount(this.f50645g) >= 12) {
            if (this.f50642d) {
                List<ThreadInfo> list = this.f50645g;
                builder.thread_list = list.subList(list.size() - 12, this.f50645g.size());
            } else {
                builder.thread_list = this.f50645g.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f50645g);
            builder.thread_list = arrayList;
        }
        this.k = builder;
        A(builder);
    }
}
