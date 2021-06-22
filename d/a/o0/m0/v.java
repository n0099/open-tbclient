package d.a.o0.m0;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import d.a.n0.w.p.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class v extends d.a.n0.w.p.a {

    /* renamed from: g  reason: collision with root package name */
    public static v f61189g;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.n0.w.p.c> f61190e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomMessageListener f61191f = new a(2005016);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {

        /* renamed from: d.a.o0.m0.v$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1493a implements Runnable {
            public RunnableC1493a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.g();
            }
        }

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            v.this.d();
            new Thread(new RunnableC1493a()).start();
        }
    }

    public v() {
        MessageManager.getInstance().registerListener(this.f61191f);
    }

    public static v e() {
        if (f61189g == null) {
            synchronized (v.class) {
                if (f61189g == null) {
                    f61189g = new v();
                }
            }
        }
        return f61189g;
    }

    @Override // d.a.n0.w.p.a
    public void b(a.InterfaceC1226a interfaceC1226a) {
        if (FileHelper.checkSD()) {
            LinkedList<d.a.n0.w.p.c> linkedList = this.f61190e;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<d.a.n0.w.p.c> it = this.f61190e.iterator();
                while (it.hasNext()) {
                    d.a.n0.w.p.c next = it.next();
                    if (interfaceC1226a != null) {
                        interfaceC1226a.a(next);
                    }
                }
                return;
            }
            this.f61190e = new LinkedList<>();
            t tVar = new t();
            this.f61190e.add(tVar);
            if (interfaceC1226a != null) {
                interfaceC1226a.a(tVar);
            }
        }
    }

    @Override // d.a.n0.w.p.a
    public int c() {
        return 3;
    }

    @Override // d.a.n0.w.p.a
    public void d() {
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccount());
        if (n != null && n.size() != 0) {
            int size = (n == null || n.size() == 0) ? 0 : n.size() - 1;
            StatisticItem statisticItem = new StatisticItem("c12224");
            statisticItem.param("obj_param1", size);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        CollectEmotionData collectEmotionData = new CollectEmotionData();
        collectEmotionData.pid = "setting_icon";
        collectEmotionData.orderId = 301;
        collectEmotionData.sharpText = d.a.n0.a0.d.f52597d;
        collectEmotionData.uid = TbadkCoreApplication.getCurrentAccount();
        g.k().a(collectEmotionData);
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.groupId = d.a.n0.a0.d.a();
        emotionGroupData.groupName = "用户收藏表情";
        emotionGroupData.groupDesc = "用户收藏表情";
        emotionGroupData.emotionsCount = 301;
        emotionGroupData.status = 1;
        emotionGroupData.downloadUrl = "";
        g.k().f(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        g.k().e(emotionGroupData);
    }

    public boolean f(String str) {
        LinkedList<d.a.n0.w.p.c> linkedList = this.f61190e;
        if (linkedList == null) {
            return false;
        }
        Iterator<d.a.n0.w.p.c> it = linkedList.iterator();
        while (it.hasNext()) {
            d.a.n0.w.p.c next = it.next();
            if (next instanceof t) {
                return ((t) next).u(str);
            }
        }
        return false;
    }

    public synchronized void g() {
        if (this.f61190e == null) {
            return;
        }
        Iterator<d.a.n0.w.p.c> it = this.f61190e.iterator();
        while (it.hasNext()) {
            d.a.n0.w.p.c next = it.next();
            if (next instanceof t) {
                ((t) next).w();
            }
        }
    }
}
