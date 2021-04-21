package d.b.j0.c3;

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
    public static c f54072g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f54075c;

    /* renamed from: d  reason: collision with root package name */
    public C1218c f54076d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f54077e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f54078f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f54074b = d.b.i0.r.d0.b.j().k("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.b.j0.c3.b f54073a = new d.b.j0.c3.b();

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1218c c1218c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1218c) || (c1218c = (C1218c) obj) == null) {
                return;
            }
            c1218c.f54083d = false;
            c1218c.f54080a = false;
            c1218c.f54081b = 0;
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
            if (c.this.f54075c != null) {
                c.this.f54075c.clear();
            }
            c.this.f54073a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f54078f);
    }

    public static c g() {
        if (f54072g == null) {
            synchronized (c.class) {
                if (f54072g == null) {
                    f54072g = new c();
                }
            }
        }
        return f54072g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f54073a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f54073a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f54075c == null) {
            this.f54075c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f54075c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f54075c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f54073a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f54076d == null) {
            this.f54076d = new C1218c(this, null);
        }
        if (this.f54076d.f54083d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1218c c1218c = this.f54076d;
        if (c1218c.f54080a) {
            int i = c1218c.f54081b + 1;
            c1218c.f54081b = i;
            if (currentTimeMillis - c1218c.f54082c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i >= this.f54074b) {
                    c1218c.f54083d = true;
                    f(c1218c);
                    return true;
                }
            } else {
                c1218c.f54080a = false;
                c1218c.f54081b = 0;
            }
        } else {
            c1218c.f54080a = true;
            c1218c.f54082c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1218c c1218c) {
        Message obtainMessage = this.f54077e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1218c;
        this.f54077e.removeMessages(5);
        this.f54077e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f54073a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f54073a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f54075c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f54073a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.b.j0.c3.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1218c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f54080a;

        /* renamed from: b  reason: collision with root package name */
        public int f54081b;

        /* renamed from: c  reason: collision with root package name */
        public long f54082c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f54083d;

        public C1218c(c cVar) {
            this.f54080a = false;
            this.f54081b = 0;
            this.f54082c = 0L;
            this.f54083d = false;
        }

        public /* synthetic */ C1218c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
