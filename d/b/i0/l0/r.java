package d.b.i0.l0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import d.b.h0.w.p.a;
import d.b.i0.l0.q;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class r extends d.b.h0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static r f56599f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.b.h0.w.p.c> f56600e;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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

        @Override // d.b.i0.l0.q.b
        public void a(q qVar) {
            MessageManager.getInstance().runTask(2004603, (Class) null);
        }
    }

    public static r f() {
        if (f56599f == null) {
            synchronized (r.class) {
                if (f56599f == null) {
                    f56599f = new r();
                }
            }
        }
        return f56599f;
    }

    @Override // d.b.h0.w.p.a
    public void b(a.InterfaceC1109a interfaceC1109a) {
        if (!FileHelper.checkSD() || this.f56600e == null) {
            return;
        }
        for (int i = 0; i < this.f56600e.size(); i++) {
            q qVar = (q) this.f56600e.get(i);
            if (qVar.t() && d.b.i0.x1.c.i().g(qVar.f()) == null && interfaceC1109a != null) {
                interfaceC1109a.a(qVar);
            }
        }
    }

    @Override // d.b.h0.w.p.a
    public int c() {
        return 2;
    }

    @Override // d.b.h0.w.p.a
    public void d() {
        MessageManager.getInstance().registerListener(new a(2001444));
    }

    public final synchronized void g(List<d.b.i0.k0.c.b> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.f56600e != null) {
                    this.f56600e = null;
                }
                LinkedList<d.b.h0.w.p.c> linkedList = new LinkedList<>();
                boolean z = false;
                for (d.b.i0.k0.c.b bVar : list) {
                    if (bVar != null && !StringUtils.isNull(bVar.getGroupId()) && bVar.IsValid()) {
                        q qVar = new q(bVar);
                        linkedList.add(qVar);
                        z = qVar.u(bVar, new b(this));
                    }
                }
                this.f56600e = linkedList;
                if (z) {
                    MessageManager.getInstance().runTask(2004603, (Class) null);
                }
            }
        }
        if (this.f56600e != null) {
            this.f56600e = null;
            MessageManager.getInstance().runTask(2004603, (Class) null);
        }
    }
}
