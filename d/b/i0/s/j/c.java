package d.b.i0.s.j;

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
    public static c f52163g = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f52164a;

    /* renamed from: b  reason: collision with root package name */
    public int f52165b;

    /* renamed from: c  reason: collision with root package name */
    public long f52166c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f52167d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f52168e;

    /* renamed from: f  reason: collision with root package name */
    public int f52169f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f52170a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52171b;

        /* renamed from: c  reason: collision with root package name */
        public long f52172c;

        public b() {
        }

        public void a(int i) {
            int i2 = this.f52170a + 1;
            this.f52170a = i2;
            if (this.f52171b || i2 < i) {
                return;
            }
            this.f52171b = true;
            this.f52172c = System.currentTimeMillis();
        }

        public void b() {
            this.f52170a = 0;
            if (this.f52171b) {
                this.f52171b = false;
                this.f52172c = 0L;
            }
        }
    }

    public c() {
        super(1001);
        this.f52165b = 3;
        this.f52166c = 300000L;
        this.f52167d = new SparseArray<>();
        this.f52168e = new HashSet<>();
        this.f52169f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        return f52163g;
    }

    public int b() {
        return this.f52169f;
    }

    @Modify(description = "长连接是否可用")
    public boolean c(int i) {
        this.f52169f = 0;
        if (this.f52164a) {
            this.f52169f = 3;
            return false;
        } else if (this.f52168e.contains(Integer.valueOf(i))) {
            this.f52169f = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().v()) {
            this.f52169f = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
            d.b.c.c.e.c.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.f52169f = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            b bVar = this.f52167d.get(i);
            if (bVar != null && bVar.f52171b) {
                if (Math.abs(System.currentTimeMillis() - bVar.f52172c) > this.f52166c) {
                    bVar.b();
                } else {
                    this.f52169f = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void d(int i) {
        b bVar = this.f52167d.get(i);
        if (bVar == null) {
            bVar = new b();
            this.f52167d.append(i, bVar);
        }
        if (bVar != null) {
            bVar.a(this.f52165b);
        }
        this.f52169f = 5;
    }

    public void e(int i) {
        this.f52167d.remove(i);
    }

    public void f() {
        for (int i = 0; i < this.f52167d.size(); i++) {
            this.f52167d.valueAt(i).b();
        }
    }

    public void g(boolean z) {
        this.f52164a = z;
    }

    public void h(int i) {
        this.f52165b = i;
    }

    public void i(long j) {
        this.f52166c = j;
    }

    public void j(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.f52168e.clear();
        for (int i : iArr) {
            this.f52168e.add(Integer.valueOf(i));
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
