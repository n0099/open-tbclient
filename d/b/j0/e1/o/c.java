package d.b.j0.e1.o;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.c.e.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f55900d;

    /* renamed from: a  reason: collision with root package name */
    public long f55901a = 0;

    /* renamed from: b  reason: collision with root package name */
    public List<Long> f55902b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f55903c = new a(2005016);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            c.this.b();
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f55903c);
    }

    public static c e() {
        if (f55900d == null) {
            synchronized (c.class) {
                if (f55900d == null) {
                    f55900d = new c();
                }
            }
        }
        return f55900d;
    }

    public synchronized void a(long j, long j2) {
        if (this.f55901a != 0 && this.f55901a != j) {
            this.f55902b.clear();
            i.c("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + "-" + this.f55901a);
        }
        this.f55901a = j;
        for (Long l : this.f55902b) {
            if (l != null && l.longValue() == j2) {
                return;
            }
        }
        this.f55902b.add(Long.valueOf(j2));
    }

    public synchronized void b() {
        this.f55901a = 0L;
        this.f55902b.clear();
    }

    public synchronized boolean c(long j) {
        for (Long l : this.f55902b) {
            if (l != null && l.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    public long d() {
        return this.f55901a;
    }

    public Long f() {
        return d.b.j0.e1.k.b.o().r().get(this.f55901a);
    }

    public synchronized List<Long> g() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.f55902b) {
            if (l != null) {
                arrayList.add(Long.valueOf(d.b.j0.e1.w.b.c(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized String h() {
        String str;
        str = "";
        for (Long l : this.f55902b) {
            if (l != null && l.longValue() != 0) {
                str = (str + l.longValue()) + ",";
            }
        }
        return str;
    }

    public synchronized boolean i() {
        boolean z;
        if (this.f55901a > 0) {
            z = this.f55902b.size() > 0;
        }
        return z;
    }

    public synchronized void j(String str, String str2) {
        b();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.f55901a = d.b.c.e.m.b.f(str, 0L);
            try {
                String[] split = str2.split(",");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!TextUtils.isEmpty(split[i])) {
                            this.f55902b.add(Long.valueOf(Long.parseLong(split[i])));
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        } catch (Exception e3) {
            BdLog.e(e3);
        }
    }

    public synchronized void k() {
        this.f55902b.clear();
    }
}
