package d.a.n0.d3;

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
import d.a.c.e.p.l;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static c f56414g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f56417c;

    /* renamed from: d  reason: collision with root package name */
    public C1302c f56418d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f56419e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f56420f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f56416b = d.a.m0.r.d0.b.j().k("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.a.n0.d3.b f56415a = new d.a.n0.d3.b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1302c c1302c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1302c) || (c1302c = (C1302c) obj) == null) {
                return;
            }
            c1302c.f56425d = false;
            c1302c.f56422a = false;
            c1302c.f56423b = 0;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (c.this.f56417c != null) {
                c.this.f56417c.clear();
            }
            c.this.f56415a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f56420f);
    }

    public static c g() {
        if (f56414g == null) {
            synchronized (c.class) {
                if (f56414g == null) {
                    f56414g = new c();
                }
            }
        }
        return f56414g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f56415a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f56415a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f56417c == null) {
            this.f56417c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f56417c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f56417c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f56415a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f56418d == null) {
            this.f56418d = new C1302c(this, null);
        }
        if (this.f56418d.f56425d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1302c c1302c = this.f56418d;
        if (c1302c.f56422a) {
            int i2 = c1302c.f56423b + 1;
            c1302c.f56423b = i2;
            if (currentTimeMillis - c1302c.f56424c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i2 >= this.f56416b) {
                    c1302c.f56425d = true;
                    f(c1302c);
                    return true;
                }
            } else {
                c1302c.f56422a = false;
                c1302c.f56423b = 0;
            }
        } else {
            c1302c.f56422a = true;
            c1302c.f56424c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1302c c1302c) {
        Message obtainMessage = this.f56419e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1302c;
        this.f56419e.removeMessages(5);
        this.f56419e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f56415a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f56415a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f56417c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f56415a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.a.n0.d3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1302c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f56422a;

        /* renamed from: b  reason: collision with root package name */
        public int f56423b;

        /* renamed from: c  reason: collision with root package name */
        public long f56424c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56425d;

        public C1302c(c cVar) {
            this.f56422a = false;
            this.f56423b = 0;
            this.f56424c = 0L;
            this.f56425d = false;
        }

        public /* synthetic */ C1302c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
