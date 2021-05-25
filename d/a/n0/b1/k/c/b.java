package d.a.n0.b1.k.c;

import android.text.SpannableString;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.video.message.VideoTabHttpResMessage;
import com.baidu.tieba.homepage.video.message.VideoTabRequestMessage;
import com.baidu.tieba.homepage.video.message.VideoTabSocketResMessage;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.n0.z.e0.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.RecomVideo.DataRes;
import tbclient.RecomVideo.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52036a;

    /* renamed from: b  reason: collision with root package name */
    public f f52037b;

    /* renamed from: f  reason: collision with root package name */
    public DataRes.Builder f52041f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52042g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52043h = true;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f52044i = new a(CmdConfigHttp.CMD_VIDEO_TAB, 309648);

    /* renamed from: c  reason: collision with root package name */
    public List<n> f52038c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f52039d = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadPersonalized> f52040e = new LinkedList();

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.f52042g = false;
            b.this.f52043h = false;
            if (responsedMessage != null) {
                b.this.g(responsedMessage);
            } else if (b.this.f52037b != null) {
                b.this.f52037b.b(-1, "", false);
            }
        }
    }

    /* renamed from: d.a.n0.b1.k.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1217b extends f0<DataRes> {
        public C1217b(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            l<byte[]> e2 = d.a.m0.r.r.a.f().e("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
            if (e2 != null && (bArr = e2.get(TbadkCoreApplication.getCurrentAccount())) != null && bArr.length != 0) {
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
    public class c implements d.a.m0.z0.n<DataRes> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            if (dataRes != null) {
                b.this.f52041f = new DataRes.Builder(dataRes);
                int count = ListUtils.getCount(dataRes.thread_list);
                if (count > 0) {
                    b.this.i(dataRes, false);
                    if (b.this.f52037b != null) {
                        b.this.f52037b.a(count, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.m0.b1.m.f {
        public final /* synthetic */ d.a.n0.z.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2, String str, d.a.n0.z.e0.b bVar2) {
            super(i2, str);
            this.l = bVar2;
        }

        @Override // d.a.m0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.a.n0.b1.k.d.a.e(this.l);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f52047a;

        public e(b bVar, DataRes.Builder builder) {
            this.f52047a = builder;
        }

        @Override // d.a.m0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f52047a.build(true));
            try {
                d.a.m0.r.r.a.f().e("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).g(TbadkCoreApplication.getCurrentAccount(), builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2, boolean z, boolean z2);

        void b(int i2, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, f fVar) {
        this.f52036a = tbPageContext;
        this.f52037b = fVar;
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, d.a.n0.e3.d0.a.a(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void g(ResponsedMessage<?> responsedMessage) {
        DataRes dataRes;
        int i2;
        if (responsedMessage instanceof VideoTabSocketResMessage) {
            dataRes = ((VideoTabSocketResMessage) responsedMessage).mResultData;
        } else {
            dataRes = responsedMessage instanceof VideoTabHttpResMessage ? ((VideoTabHttpResMessage) responsedMessage).mResultData : null;
        }
        boolean z = responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof VideoTabRequestMessage) && ((VideoTabRequestMessage) responsedMessage.getOrginalMessage().getExtra()).load_type == 2;
        if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
            i2 = 0;
        } else {
            i2 = ListUtils.getCount(dataRes.thread_list);
            i(dataRes, z);
            if (!ListUtils.isEmpty(dataRes.thread_list)) {
                t(z);
            }
        }
        if (this.f52037b != null) {
            if (responsedMessage.getError() != 0) {
                this.f52037b.b(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.f52037b.a(i2, z, false);
            }
        }
    }

    public List<n> h() {
        return this.f52038c;
    }

    public final void i(DataRes dataRes, boolean z) {
        m(dataRes.thread_list, !z);
        n(dataRes.thread_personalized, !z);
        List<n> s = s();
        this.f52038c = s;
        d.a.n0.b1.k.c.a.b(this.f52040e, s);
    }

    public void j() {
        if (this.f52042g) {
            return;
        }
        this.f52042g = true;
        if (this.f52043h) {
            k();
            this.f52043h = false;
        }
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 1;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f52036a.sendMessage(videoTabRequestMessage);
    }

    public final void k() {
        h0.b(new C1217b(this), new c());
    }

    public void l() {
        if (this.f52042g) {
            return;
        }
        this.f52042g = true;
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 2;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f52036a.sendMessage(videoTabRequestMessage);
    }

    public final void m(List<ThreadInfo> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f52039d);
            this.f52039d.clear();
            this.f52039d.addAll(linkedList);
            return;
        }
        this.f52039d.addAll(list);
    }

    public final void n(List<ThreadPersonalized> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f52040e);
            this.f52040e.clear();
            this.f52040e.addAll(linkedList);
            return;
        }
        this.f52040e.addAll(list);
    }

    public void o() {
        MessageManager.getInstance().unRegisterListener(this.f52044i);
    }

    public void p() {
        MessageManager.getInstance().registerListener(this.f52044i);
    }

    public void q(String str) {
        Long l;
        DataRes.Builder builder = this.f52041f;
        if (builder == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(str, 0L);
        for (int i2 = 0; i2 < this.f52041f.thread_list.size(); i2++) {
            ThreadInfo threadInfo = this.f52041f.thread_list.get(i2);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                this.f52041f.thread_list.remove(i2);
                v(this.f52041f);
                return;
            }
        }
    }

    public void r(String str) {
        if (ListUtils.isEmpty(this.f52038c)) {
            return;
        }
        Iterator<n> it = this.f52038c.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.a.n0.z.e0.b) {
                d.a.n0.z.e0.b bVar = (d.a.n0.z.e0.b) next;
                if (bVar.m() != null && bVar.m().y1() != null && bVar.m().y1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public final List<n> s() {
        k g2;
        a2 a2Var;
        LinkedList linkedList = new LinkedList();
        if (ListUtils.isEmpty(this.f52039d)) {
            return linkedList;
        }
        int i2 = 0;
        for (ThreadInfo threadInfo : this.f52039d) {
            a2 a2Var2 = new a2();
            a2Var2.U2(threadInfo);
            a2Var2.W1 = true;
            if (d.a.n0.z.e0.l.d0(a2Var2)) {
                k g3 = d.a.n0.b1.g.k.d.g(a2Var2);
                if (g3 != null && (a2Var = g3.f63459e) != null && a2Var.h0() != null && !StringUtils.isNull(g3.f63459e.h0().f50158b) && !g3.f63459e.G2()) {
                    g3.l = a2Var2.y1();
                    g3.position = i2;
                    d.a.n0.b1.g.k.d.r(g3);
                    linkedList.add(g3);
                } else {
                    k g4 = d.a.n0.b1.g.k.d.g(a2Var2);
                    if (g4 != null) {
                        g4.l = a2Var2.y1();
                        g4.position = i2;
                        d.a.n0.b1.g.k.d.t(g4);
                    }
                    if (g4 != null && g4.isValid()) {
                        linkedList.add(g4);
                    }
                }
                int[] p0 = a2Var2.p0();
                d.a.n0.z.e0.b e2 = d.a.n0.b1.g.k.d.e(a2Var2);
                if (e2 != null) {
                    e2.l = a2Var2.y1();
                    e2.position = i2;
                    if (e2 instanceof k) {
                        if (a2Var2.R1()) {
                            d.a.n0.b1.g.k.d.u(e2);
                        } else if (a2Var2.Z2() == 1) {
                            d.a.n0.b1.g.k.d.w(e2);
                            e2.o = p0[0];
                            e2.p = p0[1];
                        } else if (a2Var2.Z2() >= 2) {
                            d.a.n0.b1.g.k.d.v(e2);
                        } else {
                            d.a.n0.b1.g.k.d.x(e2);
                        }
                    } else if (e2 instanceof d.a.n0.z.e0.l) {
                        d.a.n0.b1.g.k.d.y(e2);
                    }
                }
                if (e2 != null && e2.isValid()) {
                    if (!a2Var2.B2() && a2Var2.T() != null && a2Var2.h0() != null && !StringUtils.isNull(a2Var2.h0().f50158b)) {
                        String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), a2Var2.T().getName_show());
                        SpannableString spannableString = new SpannableString(format);
                        spannableString.setSpan(new d(this, 16, a2Var2.T().getUserId(), e2), 0, format.length() - 1, 33);
                        e2.f63459e.M1(spannableString);
                    }
                    linkedList.add(e2);
                }
                if (a2Var2.u() && (g2 = d.a.n0.b1.g.k.d.g(a2Var2)) != null) {
                    g2.l = a2Var2.y1();
                    g2.position = i2;
                    d.a.n0.b1.g.k.d.q(g2);
                    if (k.i0(a2Var2)) {
                        g2.X("1");
                    } else if (d.a.n0.z.e0.l.d0(a2Var2)) {
                        g2.X("2");
                    }
                    if (a2Var2.u() && !StringUtils.isNull(a2Var2.i0())) {
                        linkedList.add(g2);
                    } else if (!StringUtils.isNull(a2Var2.i0())) {
                        linkedList.add(g2);
                    }
                }
                if (threadInfo.top_agree_post != null) {
                    k g5 = d.a.n0.b1.g.k.d.g(a2Var2);
                    if (g5 != null) {
                        g5.l = a2Var2.y1();
                        g5.position = i2;
                        d.a.n0.b1.g.k.d.s(g5);
                    }
                    if (g5 != null && g5.isValid()) {
                        linkedList.add(g5);
                    }
                }
                k g6 = d.a.n0.b1.g.k.d.g(a2Var2);
                if (g6 != null) {
                    g6.l = a2Var2.y1();
                    g6.position = i2;
                    d.a.n0.b1.g.k.d.p(g6);
                }
                if (g6 != null && g6.isValid()) {
                    linkedList.add(g6);
                }
                i2++;
            }
        }
        d.a.m0.b.f.a.d(linkedList);
        return linkedList;
    }

    public final void t(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (ListUtils.getCount(this.f52039d) < 12) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f52039d);
            builder.thread_list = arrayList;
            u(builder, false);
        } else if (z) {
            List<ThreadInfo> list = this.f52039d;
            builder.thread_list = list.subList(list.size() - 12, this.f52039d.size());
            u(builder, true);
        } else {
            builder.thread_list = this.f52039d.subList(0, 12);
            u(builder, false);
        }
        this.f52041f = builder;
        v(builder);
    }

    public final void u(DataRes.Builder builder, boolean z) {
        if (builder == null) {
            return;
        }
        if (ListUtils.getCount(this.f52040e) < 12) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f52040e);
            builder.thread_personalized = linkedList;
        } else if (z) {
            List<ThreadPersonalized> list = this.f52040e;
            builder.thread_personalized = list.subList(list.size() - 12, this.f52040e.size());
        } else {
            builder.thread_personalized = this.f52040e.subList(0, 12);
        }
    }

    public final void v(DataRes.Builder builder) {
        h0.b(new e(this, builder), null);
    }
}
