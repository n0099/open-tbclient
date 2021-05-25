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
    public static c f52725g;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<HashSet<String>> f52728c;

    /* renamed from: d  reason: collision with root package name */
    public C1246c f52729d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f52730e = new a(this, Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f52731f = new b(2005016);

    /* renamed from: b  reason: collision with root package name */
    public int f52727b = d.a.m0.r.d0.b.j().k("card_show_statistic_max_count", 200);

    /* renamed from: a  reason: collision with root package name */
    public final d.a.n0.d3.b f52726a = new d.a.n0.d3.b();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(c cVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1246c c1246c;
            super.handleMessage(message);
            if (message.what != 5) {
                return;
            }
            Object obj = message.obj;
            if (!(obj instanceof C1246c) || (c1246c = (C1246c) obj) == null) {
                return;
            }
            c1246c.f52736d = false;
            c1246c.f52733a = false;
            c1246c.f52734b = 0;
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
            if (c.this.f52728c != null) {
                c.this.f52728c.clear();
            }
            c.this.f52726a.g();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f52731f);
    }

    public static c g() {
        if (f52725g == null) {
            synchronized (c.class) {
                if (f52725g == null) {
                    f52725g = new c();
                }
            }
        }
        return f52725g;
    }

    public void c(BdUniqueId bdUniqueId, StatisticItem statisticItem) {
        this.f52726a.d(bdUniqueId, true);
        TiebaStatic.log(statisticItem);
    }

    public void d(BdUniqueId bdUniqueId, String str, StatisticItem statisticItem) {
        if (bdUniqueId == null || statisticItem == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f52726a.c(bdUniqueId)) {
            BdLog.e("error, bdUniqueId not register");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            BdLog.e("id is null, statistic key is=" + statisticItem.getKey());
        }
        if (this.f52728c == null) {
            this.f52728c = new SparseArray<>();
        }
        HashSet<String> hashSet = this.f52728c.get(bdUniqueId.getId());
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f52728c.put(bdUniqueId.getId(), hashSet);
        }
        String str2 = statisticItem.getKey() + "_" + str;
        if (hashSet.contains(str2) || e()) {
            return;
        }
        hashSet.add(str2);
        this.f52726a.a(bdUniqueId, statisticItem);
        if (BdLog.isDebugMode()) {
            BdLog.d("add show statistic log success" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final boolean e() {
        if (this.f52729d == null) {
            this.f52729d = new C1246c(this, null);
        }
        if (this.f52729d.f52736d) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C1246c c1246c = this.f52729d;
        if (c1246c.f52733a) {
            int i2 = c1246c.f52734b + 1;
            c1246c.f52734b = i2;
            if (currentTimeMillis - c1246c.f52735c < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                if (i2 >= this.f52727b) {
                    c1246c.f52736d = true;
                    f(c1246c);
                    return true;
                }
            } else {
                c1246c.f52733a = false;
                c1246c.f52734b = 0;
            }
        } else {
            c1246c.f52733a = true;
            c1246c.f52735c = currentTimeMillis;
        }
        return false;
    }

    public final void f(C1246c c1246c) {
        Message obtainMessage = this.f52730e.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = c1246c;
        this.f52730e.removeMessages(5);
        this.f52730e.sendMessageDelayed(obtainMessage, 300000L);
    }

    public void h(BdUniqueId bdUniqueId, boolean z) {
        if (BdLog.isDebugMode()) {
            BdLog.d("logStatisticByKey start write log ");
        }
        this.f52726a.d(bdUniqueId, z);
    }

    public void i(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52726a.f(bdUniqueId);
    }

    public void j(BdUniqueId bdUniqueId) {
        SparseArray<HashSet<String>> sparseArray = this.f52728c;
        if (sparseArray != null) {
            sparseArray.remove(bdUniqueId.getId());
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        this.f52726a.h(bdUniqueId);
        j(bdUniqueId);
    }

    /* renamed from: d.a.n0.d3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1246c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52733a;

        /* renamed from: b  reason: collision with root package name */
        public int f52734b;

        /* renamed from: c  reason: collision with root package name */
        public long f52735c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52736d;

        public C1246c(c cVar) {
            this.f52733a = false;
            this.f52734b = 0;
            this.f52735c = 0L;
            this.f52736d = false;
        }

        public /* synthetic */ C1246c(c cVar, a aVar) {
            this(cVar);
        }
    }
}
