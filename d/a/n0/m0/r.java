package d.a.n0.m0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import d.a.m0.w.p.a;
import d.a.n0.m0.q;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class r extends d.a.m0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static r f61017f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.m0.w.p.c> f61018e;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001444) {
                Object data = customResponsedMessage.getData();
                if (data == null || !(data instanceof SingleBarEmotionRecommendData)) {
                    r.this.g(null);
                    return;
                }
                SingleBarEmotionRecommendData singleBarEmotionRecommendData = (SingleBarEmotionRecommendData) data;
                LinkedList linkedList = new LinkedList();
                if (singleBarEmotionRecommendData == null || TextUtils.isEmpty(singleBarEmotionRecommendData.pkg_id) || TextUtils.isEmpty(singleBarEmotionRecommendData.cover)) {
                    r.this.g(null);
                    return;
                }
                linkedList.add(singleBarEmotionRecommendData);
                r.this.g(linkedList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements q.b {
        public b(r rVar) {
        }

        @Override // d.a.n0.m0.q.b
        public void a(q qVar) {
            MessageManager.getInstance().runTask(2004603, (Class) null);
        }
    }

    public static r f() {
        if (f61017f == null) {
            synchronized (r.class) {
                if (f61017f == null) {
                    f61017f = new r();
                }
            }
        }
        return f61017f;
    }

    @Override // d.a.m0.w.p.a
    public void b(a.InterfaceC1223a interfaceC1223a) {
        if (!FileHelper.checkSD() || this.f61018e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f61018e.size(); i2++) {
            q qVar = (q) this.f61018e.get(i2);
            if (qVar.t() && d.a.n0.z1.c.i().g(qVar.f()) == null && interfaceC1223a != null) {
                interfaceC1223a.a(qVar);
            }
        }
    }

    @Override // d.a.m0.w.p.a
    public int c() {
        return 2;
    }

    @Override // d.a.m0.w.p.a
    public void d() {
        MessageManager.getInstance().registerListener(new a(2001444));
    }

    public final synchronized void g(List<d.a.n0.l0.c.b> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.f61018e != null) {
                    this.f61018e = null;
                }
                LinkedList<d.a.m0.w.p.c> linkedList = new LinkedList<>();
                boolean z = false;
                for (d.a.n0.l0.c.b bVar : list) {
                    if (bVar != null && !StringUtils.isNull(bVar.getGroupId()) && bVar.IsValid()) {
                        q qVar = new q(bVar);
                        linkedList.add(qVar);
                        z = qVar.u(bVar, new b(this));
                    }
                }
                this.f61018e = linkedList;
                if (z) {
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
            }
        }
        if (this.f61018e != null) {
            this.f61018e = null;
            MessageManager.getInstance().runTask(2004603, (Class) null);
        }
    }
}
