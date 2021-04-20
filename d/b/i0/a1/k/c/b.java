package d.b.i0.a1.k.c;

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
import d.b.c.e.d.l;
import d.b.c.e.p.j;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.i0.x.e0.k;
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
    public TbPageContext f53022a;

    /* renamed from: b  reason: collision with root package name */
    public f f53023b;

    /* renamed from: f  reason: collision with root package name */
    public DataRes.Builder f53027f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53028g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53029h = true;
    public d.b.c.c.g.a i = new a(CmdConfigHttp.CMD_VIDEO_TAB, 309648);

    /* renamed from: c  reason: collision with root package name */
    public List<n> f53024c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadInfo> f53025d = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadPersonalized> f53026e = new LinkedList();

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.f53028g = false;
            b.this.f53029h = false;
            if (responsedMessage != null) {
                b.this.g(responsedMessage);
            } else if (b.this.f53023b != null) {
                b.this.f53023b.b(-1, "", false);
            }
        }
    }

    /* renamed from: d.b.i0.a1.k.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1166b extends f0<DataRes> {
        public C1166b(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            byte[] bArr;
            l<byte[]> e2 = d.b.h0.r.r.a.f().e("tb.video_tab", TbadkCoreApplication.getCurrentAccount());
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
    public class c implements d.b.h0.z0.n<DataRes> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            if (dataRes != null) {
                b.this.f53027f = new DataRes.Builder(dataRes);
                int count = ListUtils.getCount(dataRes.thread_list);
                if (count > 0) {
                    b.this.i(dataRes, false);
                    if (b.this.f53023b != null) {
                        b.this.f53023b.a(count, false, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.h0.b1.m.f {
        public final /* synthetic */ d.b.i0.x.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i, String str, d.b.i0.x.e0.b bVar2) {
            super(i, str);
            this.l = bVar2;
        }

        @Override // d.b.h0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            d.b.i0.a1.k.d.a.e(this.l);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f0<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataRes.Builder f53032a;

        public e(b bVar, DataRes.Builder builder) {
            this.f53032a = builder;
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            DataRes.Builder builder = new DataRes.Builder(this.f53032a.build(true));
            try {
                d.b.h0.r.r.a.f().e("tb.video_tab", TbadkCoreApplication.getCurrentAccount()).g(TbadkCoreApplication.getCurrentAccount(), builder.build(true).toByteArray());
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i, boolean z, boolean z2);

        void b(int i, String str, boolean z);
    }

    public b(TbPageContext tbPageContext, f fVar) {
        this.f53022a = tbPageContext;
        this.f53023b = fVar;
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309648);
        bVar.setResponsedClass(VideoTabSocketResMessage.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TAB, d.b.i0.d3.d0.a.a(TbConfig.URL_VIDEO_TAB, 309648));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(VideoTabHttpResMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void g(ResponsedMessage<?> responsedMessage) {
        DataRes dataRes;
        int i;
        if (responsedMessage instanceof VideoTabSocketResMessage) {
            dataRes = ((VideoTabSocketResMessage) responsedMessage).mResultData;
        } else {
            dataRes = responsedMessage instanceof VideoTabHttpResMessage ? ((VideoTabHttpResMessage) responsedMessage).mResultData : null;
        }
        boolean z = responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof VideoTabRequestMessage) && ((VideoTabRequestMessage) responsedMessage.getOrginalMessage().getExtra()).load_type == 2;
        if (dataRes == null || ListUtils.getCount(dataRes.thread_list) <= 0) {
            i = 0;
        } else {
            i = ListUtils.getCount(dataRes.thread_list);
            i(dataRes, z);
            if (!ListUtils.isEmpty(dataRes.thread_list)) {
                t(z);
            }
        }
        if (this.f53023b != null) {
            if (responsedMessage.getError() != 0) {
                this.f53023b.b(responsedMessage.getError(), responsedMessage.getErrorString(), z);
            } else {
                this.f53023b.a(i, z, false);
            }
        }
    }

    public List<n> h() {
        return this.f53024c;
    }

    public final void i(DataRes dataRes, boolean z) {
        m(dataRes.thread_list, !z);
        n(dataRes.thread_personalized, !z);
        List<n> s = s();
        this.f53024c = s;
        d.b.i0.a1.k.c.a.b(this.f53026e, s);
    }

    public void j() {
        if (this.f53028g) {
            return;
        }
        this.f53028g = true;
        if (this.f53029h) {
            k();
            this.f53029h = false;
        }
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 1;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f53022a.sendMessage(videoTabRequestMessage);
    }

    public final void k() {
        h0.b(new C1166b(this), new c());
    }

    public void l() {
        if (this.f53028g) {
            return;
        }
        this.f53028g = true;
        VideoTabRequestMessage videoTabRequestMessage = new VideoTabRequestMessage();
        videoTabRequestMessage.new_net_type = j.I();
        videoTabRequestMessage.load_type = 2;
        videoTabRequestMessage.page_thread_count = 12;
        videoTabRequestMessage.setNetType(NetMessage.NetType.HTTP);
        this.f53022a.sendMessage(videoTabRequestMessage);
    }

    public final void m(List<ThreadInfo> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f53025d);
            this.f53025d.clear();
            this.f53025d.addAll(linkedList);
            return;
        }
        this.f53025d.addAll(list);
    }

    public final void n(List<ThreadPersonalized> list, boolean z) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            linkedList.addAll(this.f53026e);
            this.f53026e.clear();
            this.f53026e.addAll(linkedList);
            return;
        }
        this.f53026e.addAll(list);
    }

    public void o() {
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    public void p() {
        MessageManager.getInstance().registerListener(this.i);
    }

    public void q(String str) {
        Long l;
        DataRes.Builder builder = this.f53027f;
        if (builder == null || ListUtils.isEmpty(builder.thread_list)) {
            return;
        }
        long f2 = d.b.c.e.m.b.f(str, 0L);
        for (int i = 0; i < this.f53027f.thread_list.size(); i++) {
            ThreadInfo threadInfo = this.f53027f.thread_list.get(i);
            if (threadInfo != null && (l = threadInfo.tid) != null && l.longValue() == f2) {
                this.f53027f.thread_list.remove(i);
                v(this.f53027f);
                return;
            }
        }
    }

    public void r(String str) {
        if (ListUtils.isEmpty(this.f53024c)) {
            return;
        }
        Iterator<n> it = this.f53024c.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof d.b.i0.x.e0.b) {
                d.b.i0.x.e0.b bVar = (d.b.i0.x.e0.b) next;
                if (bVar.n() != null && bVar.n().w1() != null && bVar.n().w1().equals(str)) {
                    it.remove();
                }
            }
        }
    }

    public final List<n> s() {
        k g2;
        a2 a2Var;
        LinkedList linkedList = new LinkedList();
        if (ListUtils.isEmpty(this.f53025d)) {
            return linkedList;
        }
        int i = 0;
        for (ThreadInfo threadInfo : this.f53025d) {
            a2 a2Var2 = new a2();
            a2Var2.R2(threadInfo);
            a2Var2.V1 = true;
            if (d.b.i0.x.e0.l.d0(a2Var2)) {
                k g3 = d.b.i0.a1.g.k.d.g(a2Var2);
                if (g3 != null && (a2Var = g3.f63772e) != null && a2Var.h0() != null && !StringUtils.isNull(g3.f63772e.h0().f51324b) && !g3.f63772e.D2()) {
                    g3.l = a2Var2.w1();
                    g3.position = i;
                    d.b.i0.a1.g.k.d.r(g3);
                    linkedList.add(g3);
                } else {
                    k g4 = d.b.i0.a1.g.k.d.g(a2Var2);
                    if (g4 != null) {
                        g4.l = a2Var2.w1();
                        g4.position = i;
                        d.b.i0.a1.g.k.d.t(g4);
                    }
                    if (g4 != null && g4.isValid()) {
                        linkedList.add(g4);
                    }
                }
                int[] p0 = a2Var2.p0();
                d.b.i0.x.e0.b e2 = d.b.i0.a1.g.k.d.e(a2Var2);
                if (e2 != null) {
                    e2.l = a2Var2.w1();
                    e2.position = i;
                    if (e2 instanceof k) {
                        if (a2Var2.P1()) {
                            d.b.i0.a1.g.k.d.u(e2);
                        } else if (a2Var2.W2() == 1) {
                            d.b.i0.a1.g.k.d.w(e2);
                            e2.o = p0[0];
                            e2.p = p0[1];
                        } else if (a2Var2.W2() >= 2) {
                            d.b.i0.a1.g.k.d.v(e2);
                        } else {
                            d.b.i0.a1.g.k.d.x(e2);
                        }
                    } else if (e2 instanceof d.b.i0.x.e0.l) {
                        d.b.i0.a1.g.k.d.y(e2);
                    }
                }
                if (e2 != null && e2.isValid()) {
                    if (!a2Var2.y2() && a2Var2.T() != null && a2Var2.h0() != null && !StringUtils.isNull(a2Var2.h0().f51324b)) {
                        String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), a2Var2.T().getName_show());
                        SpannableString spannableString = new SpannableString(format);
                        spannableString.setSpan(new d(this, 16, a2Var2.T().getUserId(), e2), 0, format.length() - 1, 33);
                        e2.f63772e.K1(spannableString);
                    }
                    linkedList.add(e2);
                }
                if (a2Var2.u() && (g2 = d.b.i0.a1.g.k.d.g(a2Var2)) != null) {
                    g2.l = a2Var2.w1();
                    g2.position = i;
                    d.b.i0.a1.g.k.d.q(g2);
                    if (k.i0(a2Var2)) {
                        g2.X("1");
                    } else if (d.b.i0.x.e0.l.d0(a2Var2)) {
                        g2.X("2");
                    }
                    if (a2Var2.u() && !StringUtils.isNull(a2Var2.i0())) {
                        linkedList.add(g2);
                    } else if (!StringUtils.isNull(a2Var2.i0())) {
                        linkedList.add(g2);
                    }
                }
                if (threadInfo.top_agree_post != null) {
                    k g5 = d.b.i0.a1.g.k.d.g(a2Var2);
                    if (g5 != null) {
                        g5.l = a2Var2.w1();
                        g5.position = i;
                        d.b.i0.a1.g.k.d.s(g5);
                    }
                    if (g5 != null && g5.isValid()) {
                        linkedList.add(g5);
                    }
                }
                k g6 = d.b.i0.a1.g.k.d.g(a2Var2);
                if (g6 != null) {
                    g6.l = a2Var2.w1();
                    g6.position = i;
                    d.b.i0.a1.g.k.d.p(g6);
                }
                if (g6 != null && g6.isValid()) {
                    linkedList.add(g6);
                }
                i++;
            }
        }
        d.b.h0.b.f.a.d(linkedList);
        return linkedList;
    }

    public final void t(boolean z) {
        DataRes.Builder builder = new DataRes.Builder();
        if (ListUtils.getCount(this.f53025d) < 12) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f53025d);
            builder.thread_list = arrayList;
            u(builder, false);
        } else if (z) {
            List<ThreadInfo> list = this.f53025d;
            builder.thread_list = list.subList(list.size() - 12, this.f53025d.size());
            u(builder, true);
        } else {
            builder.thread_list = this.f53025d.subList(0, 12);
            u(builder, false);
        }
        this.f53027f = builder;
        v(builder);
    }

    public final void u(DataRes.Builder builder, boolean z) {
        if (builder == null) {
            return;
        }
        if (ListUtils.getCount(this.f53026e) < 12) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.f53026e);
            builder.thread_personalized = linkedList;
        } else if (z) {
            List<ThreadPersonalized> list = this.f53026e;
            builder.thread_personalized = list.subList(list.size() - 12, this.f53026e.size());
        } else {
            builder.thread_personalized = this.f53026e.subList(0, 12);
        }
    }

    public final void v(DataRes.Builder builder) {
        h0.b(new e(this, builder), null);
    }
}
