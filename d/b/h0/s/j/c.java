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
public class c extends d.b.b.c.g.c {

    /* renamed from: g  reason: collision with root package name */
    public static c f51410g = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f51411a;

    /* renamed from: b  reason: collision with root package name */
    public int f51412b;

    /* renamed from: c  reason: collision with root package name */
    public long f51413c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f51414d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f51415e;

    /* renamed from: f  reason: collision with root package name */
    public int f51416f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f51417a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f51418b;

        /* renamed from: c  reason: collision with root package name */
        public long f51419c;

        public b() {
        }

        public void a(int i) {
            int i2 = this.f51417a + 1;
            this.f51417a = i2;
            if (this.f51418b || i2 < i) {
                return;
            }
            this.f51418b = true;
            this.f51419c = System.currentTimeMillis();
        }

        public void b() {
            this.f51417a = 0;
            if (this.f51418b) {
                this.f51418b = false;
                this.f51419c = 0L;
            }
        }
    }

    public c() {
        super(1001);
        this.f51412b = 3;
        this.f51413c = 300000L;
        this.f51414d = new SparseArray<>();
        this.f51415e = new HashSet<>();
        this.f51416f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        return f51410g;
    }

    public int b() {
        return this.f51416f;
    }

    @Modify(description = "长连接是否可用")
    public boolean c(int i) {
        this.f51416f = 0;
        if (this.f51411a) {
            this.f51416f = 3;
            return false;
        } else if (this.f51415e.contains(Integer.valueOf(i))) {
            this.f51416f = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().v()) {
            this.f51416f = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
            d.b.b.c.e.c.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.f51416f = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            b bVar = this.f51414d.get(i);
            if (bVar != null && bVar.f51418b) {
                if (Math.abs(System.currentTimeMillis() - bVar.f51419c) > this.f51413c) {
                    bVar.b();
                } else {
                    this.f51416f = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void d(int i) {
        b bVar = this.f51414d.get(i);
        if (bVar == null) {
            bVar = new b();
            this.f51414d.append(i, bVar);
        }
        if (bVar != null) {
            bVar.a(this.f51412b);
        }
        this.f51416f = 5;
    }

    public void e(int i) {
        this.f51414d.remove(i);
    }

    public void f() {
        for (int i = 0; i < this.f51414d.size(); i++) {
            this.f51414d.valueAt(i).b();
        }
    }

    public void g(boolean z) {
        this.f51411a = z;
    }

    public void h(int i) {
        this.f51412b = i;
    }

    public void i(long j) {
        this.f51413c = j;
    }

    public void j(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.f51415e.clear();
        for (int i : iArr) {
            this.f51415e.add(Integer.valueOf(i));
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
