package d.a.o0.d3;

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
    public static c f56539g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f56542c;

    /* renamed from: d  reason: collision with root package name */
    public C1306c f56543d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f56544e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f56545f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f56541b = d.a.n0.r.d0.b.j().k("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.a.o0.d3.b f56540a = new d.a.o0.d3.b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1306c c1306c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1306c) || (c1306c = (C1306c) obj) == null) {
                return;
            }
            c1306c.f56550d = false;
            c1306c.f56547a = false;
            c1306c.f56548b = 0;
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
            if (c.this.f56542c != null) {
                c.this.f56542c.clear();
            }
            c.this.f56540a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f56545f);
    }

    public static c g() {
        if (f56539g == null) {
            synchronized (c.class) {
                if (f56539g == null) {
                    f56539g = new c();
                }
            }
        }
        return f56539g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f56540a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f56540a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f56542c == null) {
            this.f56542c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f56542c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f56542c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f56540a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f56543d == null) {
            this.f56543d = new C1306c(this, null);
        }
        if (this.f56543d.f56550d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1306c c1306c = this.f56543d;
        if (c1306c.f56547a) {
            int i2 = c1306c.f56548b + 1;
            c1306c.f56548b = i2;
            if (currentTimeMillis - c1306c.f56549c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i2 >= this.f56541b) {
                    c1306c.f56550d = true;
                    f(c1306c);
                    return true;
                }
            } else {
                c1306c.f56547a = false;
                c1306c.f56548b = 0;
            }
        } else {
            c1306c.f56547a = true;
            c1306c.f56549c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1306c c1306c) {
        Message obtainMessage = this.f56544e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1306c;
        this.f56544e.removeMessages(5);
        this.f56544e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f56540a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f56540a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f56542c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f56540a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.a.o0.d3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1306c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f56547a;

        /* renamed from: b  reason: collision with root package name */
        public int f56548b;

        /* renamed from: c  reason: collision with root package name */
        public long f56549c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f56550d;

        public C1306c(c cVar) {
            this.f56547a = false;
            this.f56548b = 0;
            this.f56549c = 0L;
            this.f56550d = false;
        }

        public /* synthetic */ C1306c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
