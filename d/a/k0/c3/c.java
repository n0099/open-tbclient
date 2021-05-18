package d.a.k0.c3;

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
    public static c f52545g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f52548c;

    /* renamed from: d  reason: collision with root package name */
    public C1229c f52549d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f52550e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f52551f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f52547b = d.a.j0.r.d0.b.j().k("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.a.k0.c3.b f52546a = new d.a.k0.c3.b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1229c c1229c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1229c) || (c1229c = (C1229c) obj) == null) {
                return;
            }
            c1229c.f52556d = false;
            c1229c.f52553a = false;
            c1229c.f52554b = 0;
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
            if (c.this.f52548c != null) {
                c.this.f52548c.clear();
            }
            c.this.f52546a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f52551f);
    }

    public static c g() {
        if (f52545g == null) {
            synchronized (c.class) {
                if (f52545g == null) {
                    f52545g = new c();
                }
            }
        }
        return f52545g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f52546a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f52546a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f52548c == null) {
            this.f52548c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f52548c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f52548c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f52546a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f52549d == null) {
            this.f52549d = new C1229c(this, null);
        }
        if (this.f52549d.f52556d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1229c c1229c = this.f52549d;
        if (c1229c.f52553a) {
            int i2 = c1229c.f52554b + 1;
            c1229c.f52554b = i2;
            if (currentTimeMillis - c1229c.f52555c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i2 >= this.f52547b) {
                    c1229c.f52556d = true;
                    f(c1229c);
                    return true;
                }
            } else {
                c1229c.f52553a = false;
                c1229c.f52554b = 0;
            }
        } else {
            c1229c.f52553a = true;
            c1229c.f52555c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1229c c1229c) {
        Message obtainMessage = this.f52550e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1229c;
        this.f52550e.removeMessages(5);
        this.f52550e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f52546a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52546a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f52548c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52546a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.a.k0.c3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1229c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52553a;

        /* renamed from: b  reason: collision with root package name */
        public int f52554b;

        /* renamed from: c  reason: collision with root package name */
        public long f52555c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52556d;

        public C1229c(c cVar) {
            this.f52553a = false;
            this.f52554b = 0;
            this.f52555c = 0L;
            this.f52556d = false;
        }

        public /* synthetic */ C1229c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
