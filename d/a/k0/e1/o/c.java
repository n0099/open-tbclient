package d.a.k0.e1.o;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.c.e.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static c f54472d;

    /* renamed from: a  reason: collision with root package name */
    public long f54473a = 0;

    /* renamed from: b  reason: collision with root package name */
    public List<Long> f54474b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f54475c = new a(2005016);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
        MessageManager.getInstance().registerListener(this.f54475c);
    }

    public static c e() {
        if (f54472d == null) {
            synchronized (c.class) {
                if (f54472d == null) {
                    f54472d = new c();
                }
            }
        }
        return f54472d;
    }

    public synchronized void a(long j, long j2) {
        if (this.f54473a != 0 && this.f54473a != j) {
            this.f54474b.clear();
            i.c("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j + "-" + this.f54473a);
        }
        this.f54473a = j;
        for (Long l : this.f54474b) {
            if (l != null && l.longValue() == j2) {
                return;
            }
        }
        this.f54474b.add(Long.valueOf(j2));
    }

    public synchronized void b() {
        this.f54473a = 0L;
        this.f54474b.clear();
    }

    public synchronized boolean c(long j) {
        for (Long l : this.f54474b) {
            if (l != null && l.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    public long d() {
        return this.f54473a;
    }

    public Long f() {
        return d.a.k0.e1.k.b.o().r().get(this.f54473a);
    }

    public synchronized List<Long> g() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Long l : this.f54474b) {
            if (l != null) {
                arrayList.add(Long.valueOf(d.a.k0.e1.w.b.c(l.longValue())));
            }
        }
        return arrayList;
    }

    public synchronized String h() {
        String str;
        str = "";
        for (Long l : this.f54474b) {
            if (l != null && l.longValue() != 0) {
                str = (str + l.longValue()) + ",";
            }
        }
        return str;
    }

    public synchronized boolean i() {
        boolean z;
        if (this.f54473a > 0) {
            z = this.f54474b.size() > 0;
        }
        return z;
    }

    public synchronized void j(String str, String str2) {
        b();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.f54473a = d.a.c.e.m.b.f(str, 0L);
            try {
                String[] split = str2.split(",");
                if (split != null && split.length > 0) {
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (!TextUtils.isEmpty(split[i2])) {
                            this.f54474b.add(Long.valueOf(Long.parseLong(split[i2])));
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
        this.f54474b.clear();
    }
}
