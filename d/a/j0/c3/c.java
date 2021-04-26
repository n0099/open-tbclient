package d.a.j0.c3;

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
    public static c f51846g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f51849c;

    /* renamed from: d  reason: collision with root package name */
    public C1157c f51850d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f51851e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f51852f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f51848b = d.a.i0.r.d0.b.j().k("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.a.j0.c3.b f51847a = new d.a.j0.c3.b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1157c c1157c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1157c) || (c1157c = (C1157c) obj) == null) {
                return;
            }
            c1157c.f51857d = false;
            c1157c.f51854a = false;
            c1157c.f51855b = 0;
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
            if (c.this.f51849c != null) {
                c.this.f51849c.clear();
            }
            c.this.f51847a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f51852f);
    }

    public static c g() {
        if (f51846g == null) {
            synchronized (c.class) {
                if (f51846g == null) {
                    f51846g = new c();
                }
            }
        }
        return f51846g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f51847a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f51847a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f51849c == null) {
            this.f51849c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f51849c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f51849c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f51847a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f51850d == null) {
            this.f51850d = new C1157c(this, null);
        }
        if (this.f51850d.f51857d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1157c c1157c = this.f51850d;
        if (c1157c.f51854a) {
            int i2 = c1157c.f51855b + 1;
            c1157c.f51855b = i2;
            if (currentTimeMillis - c1157c.f51856c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i2 >= this.f51848b) {
                    c1157c.f51857d = true;
                    f(c1157c);
                    return true;
                }
            } else {
                c1157c.f51854a = false;
                c1157c.f51855b = 0;
            }
        } else {
            c1157c.f51854a = true;
            c1157c.f51856c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1157c c1157c) {
        Message obtainMessage = this.f51851e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1157c;
        this.f51851e.removeMessages(5);
        this.f51851e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f51847a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f51847a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f51849c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f51847a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.a.j0.c3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1157c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f51854a;

        /* renamed from: b  reason: collision with root package name */
        public int f51855b;

        /* renamed from: c  reason: collision with root package name */
        public long f51856c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f51857d;

        public C1157c(c cVar) {
            this.f51854a = false;
            this.f51855b = 0;
            this.f51856c = 0L;
            this.f51857d = false;
        }

        public /* synthetic */ C1157c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
