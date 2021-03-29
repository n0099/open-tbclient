package d.b.i0.b3;

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
import d.b.b.e.p.l;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static c f52250g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f52253c;

    /* renamed from: d  reason: collision with root package name */
    public C1136c f52254d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f52255e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f52256f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f52252b = d.b.h0.r.d0.b.i().j("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.b.i0.b3.b f52251a = new d.b.i0.b3.b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1136c c1136c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1136c) || (c1136c = (C1136c) obj) == null) {
                return;
            }
            c1136c.f52261d = false;
            c1136c.f52258a = false;
            c1136c.f52259b = 0;
        }
    }

    /* loaded from: classes5.dex */
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
            if (c.this.f52253c != null) {
                c.this.f52253c.clear();
            }
            c.this.f52251a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f52256f);
    }

    public static c g() {
        if (f52250g == null) {
            synchronized (c.class) {
                if (f52250g == null) {
                    f52250g = new c();
                }
            }
        }
        return f52250g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f52251a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f52251a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f52253c == null) {
            this.f52253c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f52253c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f52253c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f52251a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f52254d == null) {
            this.f52254d = new C1136c(this, null);
        }
        if (this.f52254d.f52261d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1136c c1136c = this.f52254d;
        if (c1136c.f52258a) {
            int i = c1136c.f52259b + 1;
            c1136c.f52259b = i;
            if (currentTimeMillis - c1136c.f52260c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i >= this.f52252b) {
                    c1136c.f52261d = true;
                    f(c1136c);
                    return true;
                }
            } else {
                c1136c.f52258a = false;
                c1136c.f52259b = 0;
            }
        } else {
            c1136c.f52258a = true;
            c1136c.f52260c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1136c c1136c) {
        Message obtainMessage = this.f52255e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1136c;
        this.f52255e.removeMessages(5);
        this.f52255e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f52251a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52251a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f52253c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52251a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.b.i0.b3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1136c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52258a;

        /* renamed from: b  reason: collision with root package name */
        public int f52259b;

        /* renamed from: c  reason: collision with root package name */
        public long f52260c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52261d;

        public C1136c(c cVar) {
            this.f52258a = false;
            this.f52259b = 0;
            this.f52260c = 0L;
            this.f52261d = false;
        }

        public /* synthetic */ C1136c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
