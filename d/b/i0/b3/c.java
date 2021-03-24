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
    public static c f52249g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f52252c;

    /* renamed from: d  reason: collision with root package name */
    public C1135c f52253d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f52254e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f52255f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f52251b = d.b.h0.r.d0.b.i().j("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.b.i0.b3.b f52250a = new d.b.i0.b3.b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1135c c1135c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1135c) || (c1135c = (C1135c) obj) == null) {
                return;
            }
            c1135c.f52260d = false;
            c1135c.f52257a = false;
            c1135c.f52258b = 0;
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
            if (c.this.f52252c != null) {
                c.this.f52252c.clear();
            }
            c.this.f52250a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f52255f);
    }

    public static c g() {
        if (f52249g == null) {
            synchronized (c.class) {
                if (f52249g == null) {
                    f52249g = new c();
                }
            }
        }
        return f52249g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f52250a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f52250a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f52252c == null) {
            this.f52252c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f52252c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f52252c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f52250a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f52253d == null) {
            this.f52253d = new C1135c(this, null);
        }
        if (this.f52253d.f52260d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1135c c1135c = this.f52253d;
        if (c1135c.f52257a) {
            int i = c1135c.f52258b + 1;
            c1135c.f52258b = i;
            if (currentTimeMillis - c1135c.f52259c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i >= this.f52251b) {
                    c1135c.f52260d = true;
                    f(c1135c);
                    return true;
                }
            } else {
                c1135c.f52257a = false;
                c1135c.f52258b = 0;
            }
        } else {
            c1135c.f52257a = true;
            c1135c.f52259c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1135c c1135c) {
        Message obtainMessage = this.f52254e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1135c;
        this.f52254e.removeMessages(5);
        this.f52254e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f52250a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52250a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f52252c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52250a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.b.i0.b3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1135c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52257a;

        /* renamed from: b  reason: collision with root package name */
        public int f52258b;

        /* renamed from: c  reason: collision with root package name */
        public long f52259c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52260d;

        public C1135c(c cVar) {
            this.f52257a = false;
            this.f52258b = 0;
            this.f52259c = 0L;
            this.f52260d = false;
        }

        public /* synthetic */ C1135c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
