package d.b.i0.c3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.l;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static c f53651g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f53654c;

    /* renamed from: d  reason: collision with root package name */
    public C1195c f53655d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f53656e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f53657f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f53653b = d.b.h0.r.d0.b.j().k("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.b.i0.c3.b f53652a = new d.b.i0.c3.b();

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1195c c1195c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1195c) || (c1195c = (C1195c) obj) == null) {
                return;
            }
            c1195c.f53662d = false;
            c1195c.f53659a = false;
            c1195c.f53660b = 0;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (c.this.f53654c != null) {
                c.this.f53654c.clear();
            }
            c.this.f53652a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f53657f);
    }

    public static c g() {
        if (f53651g == null) {
            synchronized (c.class) {
                if (f53651g == null) {
                    f53651g = new c();
                }
            }
        }
        return f53651g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f53652a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f53652a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f53654c == null) {
            this.f53654c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f53654c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f53654c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f53652a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f53655d == null) {
            this.f53655d = new C1195c(this, null);
        }
        if (this.f53655d.f53662d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1195c c1195c = this.f53655d;
        if (c1195c.f53659a) {
            int i = c1195c.f53660b + 1;
            c1195c.f53660b = i;
            if (currentTimeMillis - c1195c.f53661c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i >= this.f53653b) {
                    c1195c.f53662d = true;
                    f(c1195c);
                    return true;
                }
            } else {
                c1195c.f53659a = false;
                c1195c.f53660b = 0;
            }
        } else {
            c1195c.f53659a = true;
            c1195c.f53661c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1195c c1195c) {
        Message obtainMessage = this.f53656e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1195c;
        this.f53656e.removeMessages(5);
        this.f53656e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f53652a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f53652a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f53654c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f53652a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.b.i0.c3.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1195c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f53659a;

        /* renamed from: b  reason: collision with root package name */
        public int f53660b;

        /* renamed from: c  reason: collision with root package name */
        public long f53661c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f53662d;

        public C1195c(c cVar) {
            this.f53659a = false;
            this.f53660b = 0;
            this.f53661c = 0L;
            this.f53662d = false;
        }

        public /* synthetic */ C1195c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
