package d.b.j0.a1.d.d;

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
import d.b.c.e.d.l;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.j0.x.e0.k;
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
    public TbPageContext f52939a;

    /* renamed from: b  reason: collision with root package name */
    public e f52940b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52941c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52942d;

    /* renamed from: h  reason: collision with root package name */
    public int f52946h;
    public DataRes.Builder k;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52943e = true;
    public boolean j = false;
    public d.b.c.c.g.a l = new a(CmdConfigHttp.CMD_GAME_VIDEO, 309646);

    /* renamed from: f  reason: collision with root package name */
    public List<n> f52944f = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public List<ThreadInfo> f52945g = new LinkedList();
    public List<d.b.j0.a1.d.c.a> i = new LinkedList();

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i;
            ClassInfo classInfo;
            b.this.f52941c = false;
            if (responsedMessage == null) {
                b.this.f52943e = false;
                if (b.this.f52940b != null) {
                    b.this.f52940b.b(-1, "", b.this.f52942d);
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
                i = 0;
            } else {
                i = ListUtils.getCount(dataRes.thread_list);
                b.this.n(dataRes);
                if (!ListUtils.isEmpty(dataRes.thread_list)) {
                    b.this.z(dataRes);
                }
            }
            if (b.this.f52940b != null) {
                if (responsedMessage.getError() == 0) {
                    b.this.f52940b.a(i, b.this.f52942d, false);
                } else {
                    b.this.f52940b.b(responsedMessage.getError(), responsedMessage.getErrorString(), b.this.f52942d);
                }
            }
            b.this.f52943e = false;
        }
    }

    /* renamed from: d.b.j0.a1.d.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1167b extends f0<DataRes> {
        public C1167b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            l<byte[]> e2 = d.b.i0.r.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount());
            if (e2 != null && (bArr = e2.get(String.valueOf(b.this.f52946h))) != null && bArr.length != 0) {
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
    public class c implements d.b.i0.z0.n<DataRes> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            if (dataRes != null) {
                b.this.k = new DataRes.Builder(dataRes);
                int count = ListUtils.getCount(dataRes.thread_list);
                if (count > 0) {
                    b.this.n(dataRes);
                    b.this.k(dataRes.class_info.sub_class_list);
                    if (b.this.f52940b != null) {
                        b.this.f52940b.a(count, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f52950a;

        public d(DataRes.Builder builder) {
            this.f52950a = builder;
        }

        @Override // d.b.i0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f52950a.build(true));
            try {
                d.b.i0.r.r.a.f().e("tb.game_video", TbadkCoreApplication.getCurrentAccount()).g(String.valueOf(b.this.f52946h), builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i, boolean z, boolean z2);

        void b(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, e eVar) {
        this.f52939a = tbPageContext;
        this.f52940b = eVar;
    }

    public final void A(DataRes.Builder builder) {
        h0.b(new d(builder), null);
    }

    public final void k(List<SubClassItem> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.i == null) {
            this.i = new LinkedList();
        }
        this.i.clear();
        for (SubClassItem subClassItem : list) {
            d.b.j0.a1.d.c.a aVar = new d.b.j0.a1.d.c.a();
            aVar.a(subClassItem);
            this.i.add(aVar);
        }
    }

    public List<n> l() {
        return this.f52944f;
    }

    public List<d.b.j0.a1.d.c.a> m() {
        return this.i;
    }

    public final void n(DataRes dataRes) {
        s(dataRes.thread_list, !this.f52942d);
        List<n> y = y();
        this.f52944f = y;
        d.b.j0.a1.d.d.a.b(dataRes, y);
    }

    public boolean o() {
        return this.j;
    }

    public final void p() {
        h0.b(new C1167b(), new c());
    }

    public void q(int i) {
        int i2;
        if (this.f52941c) {
            return;
        }
        this.f52946h = i;
        this.f52941c = true;
        this.f52942d = false;
        if (this.f52943e) {
            p();
            this.f52943e = false;
        }
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!j.H()) {
            if (j.v()) {
                i2 = 4;
            } else if (j.u()) {
                i2 = 3;
            } else if (j.t()) {
                i2 = 2;
            }
            gameVideoRequestMessage.new_net_type = i2;
            gameVideoRequestMessage.load_type = 1;
            gameVideoRequestMessage.page_thread_count = 12;
            gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
            this.f52939a.sendMessage(gameVideoRequestMessage);
        }
        i2 = 1;
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 1;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f52939a.sendMessage(gameVideoRequestMessage);
    }

    public void r(int i) {
        if (this.f52941c) {
            return;
        }
        this.f52946h = i;
        int i2 = 1;
        this.f52941c = true;
        this.f52942d = true;
        GameVideoRequestMessage gameVideoRequestMessage = new GameVideoRequestMessage();
        gameVideoRequestMessage.class_id = "1";
        gameVideoRequestMessage.sub_class_id = i;
        if (!j.H()) {
            if (j.v()) {
                i2 = 4;
            } else if (j.u()) {
                i2 = 3;
            } else if (j.t()) {
                i2 = 2;
            }
        }
        gameVideoRequestMessage.new_net_type = i2;
        gameVideoRequestMessage.load_type = 2;
        gameVideoRequestMessage.page_thread_count = 12;
        gameVideoRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f52939a.sendMessage(gameVideoRequestMessage);
    }

    public final void s(List<ThreadInfo> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f52945g);
            this.f52945g.clear();
            this.f52945g.addAll(linkedList);
            return;
        }
        this.f52945g.addAll(list);
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
        long f2 = d.b.c.e.m.b.f(str, 0L);
        for (int i = 0; i < this.k.thread_list.size(); i++) {
            ThreadInfo threadInfo = this.k.thread_list.get(i);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                this.k.thread_list.remove(i);
                A(this.k);
                return;
            }
        }
    }

    public void w(String str) {
        if (ListUtils.isEmpty(this.f52944f)) {
            return;
        }
        Iterator<n> it = this.f52944f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.b.j0.x.e0.b) {
                d.b.j0.x.e0.b bVar = (d.b.j0.x.e0.b) next;
                if (bVar.n() != null && bVar.n().w1() != null && bVar.n().w1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public void x() {
        this.f52943e = true;
        this.f52944f.clear();
        this.f52945g.clear();
    }

    public final List<n> y() {
        LinkedList linkedList = new LinkedList();
        if (ListUtils.isEmpty(this.f52945g)) {
            return linkedList;
        }
        int i = 0;
        for (ThreadInfo threadInfo : this.f52945g) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            if (d.b.j0.x.e0.l.d0(a2Var)) {
                k kVar = new k();
                kVar.f64193e = a2Var;
                kVar.l = a2Var.w1();
                kVar.position = i;
                kVar.r = true;
                linkedList.add(kVar);
                d.b.j0.x.e0.l lVar = new d.b.j0.x.e0.l(a2Var);
                lVar.l = a2Var.w1();
                lVar.position = i;
                lVar.x = true;
                linkedList.add(lVar);
                if (threadInfo.top_agree_post != null) {
                    k kVar2 = new k();
                    kVar2.f64193e = a2Var;
                    kVar2.l = a2Var.w1();
                    kVar2.position = i;
                    kVar2.C = true;
                    linkedList.add(kVar2);
                }
                k kVar3 = new k();
                kVar3.f64193e = a2Var;
                kVar3.l = a2Var.w1();
                kVar3.position = i;
                kVar3.D = true;
                linkedList.add(kVar3);
                i++;
            }
        }
        return linkedList;
    }

    public final void z(DataRes dataRes) {
        DataRes.Builder builder = new DataRes.Builder();
        builder.need_rechoose = dataRes.need_rechoose;
        builder.class_info = dataRes.class_info;
        builder.thread_personalized = dataRes.thread_personalized;
        if (ListUtils.getCount(this.f52945g) >= 12) {
            if (this.f52942d) {
                List<ThreadInfo> list = this.f52945g;
                builder.thread_list = list.subList(list.size() - 12, this.f52945g.size());
            } else {
                builder.thread_list = this.f52945g.subList(0, 12);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f52945g);
            builder.thread_list = arrayList;
        }
        this.k = builder;
        A(builder);
    }
}
