package d.b.h0.s.j;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import java.util.HashSet;
@ModifyClass
/* loaded from: classes3.dex */
public class c extends d.b.c.c.g.c {

    /* renamed from: g  reason: collision with root package name */
    public static c f51827g = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f51828a;

    /* renamed from: b  reason: collision with root package name */
    public int f51829b;

    /* renamed from: c  reason: collision with root package name */
    public long f51830c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f51831d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f51832e;

    /* renamed from: f  reason: collision with root package name */
    public int f51833f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f51834a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f51835b;

        /* renamed from: c  reason: collision with root package name */
        public long f51836c;

        public b() {
        }

        public void a(int i) {
            int i2 = this.f51834a + 1;
            this.f51834a = i2;
            if (this.f51835b || i2 < i) {
                return;
            }
            this.f51835b = true;
            this.f51836c = System.currentTimeMillis();
        }

        public void b() {
            this.f51834a = 0;
            if (this.f51835b) {
                this.f51835b = false;
                this.f51836c = 0L;
            }
        }
    }

    public c() {
        super(1001);
        this.f51829b = 3;
        this.f51830c = 300000L;
        this.f51831d = new SparseArray<>();
        this.f51832e = new HashSet<>();
        this.f51833f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        return f51827g;
    }

    public int b() {
        return this.f51833f;
    }

    @Modify(description = "长连接是否可用")
    public boolean c(int i) {
        this.f51833f = 0;
        if (this.f51828a) {
            this.f51833f = 3;
            return false;
        } else if (this.f51832e.contains(Integer.valueOf(i))) {
            this.f51833f = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().v()) {
            this.f51833f = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
            d.b.c.c.e.c.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.f51833f = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            b bVar = this.f51831d.get(i);
            if (bVar != null && bVar.f51835b) {
                if (Math.abs(System.currentTimeMillis() - bVar.f51836c) > this.f51830c) {
                    bVar.b();
                } else {
                    this.f51833f = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void d(int i) {
        b bVar = this.f51831d.get(i);
        if (bVar == null) {
            bVar = new b();
            this.f51831d.append(i, bVar);
        }
        if (bVar != null) {
            bVar.a(this.f51829b);
        }
        this.f51833f = 5;
    }

    public void e(int i) {
        this.f51831d.remove(i);
    }

    public void f() {
        for (int i = 0; i < this.f51831d.size(); i++) {
            this.f51831d.valueAt(i).b();
        }
    }

    public void g(boolean z) {
        this.f51828a = z;
    }

    public void h(int i) {
        this.f51829b = i;
    }

    public void i(long j) {
        this.f51830c = j;
    }

    public void j(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.f51832e.clear();
        for (int i : iArr) {
            this.f51832e.add(Integer.valueOf(i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            f();
        }
    }
}
