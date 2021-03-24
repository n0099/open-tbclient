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
/* loaded from: classes.dex */
public class c extends d.b.b.c.g.c {

    /* renamed from: g  reason: collision with root package name */
    public static c f51409g = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f51410a;

    /* renamed from: b  reason: collision with root package name */
    public int f51411b;

    /* renamed from: c  reason: collision with root package name */
    public long f51412c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f51413d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f51414e;

    /* renamed from: f  reason: collision with root package name */
    public int f51415f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f51416a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f51417b;

        /* renamed from: c  reason: collision with root package name */
        public long f51418c;

        public b() {
        }

        public void a(int i) {
            int i2 = this.f51416a + 1;
            this.f51416a = i2;
            if (this.f51417b || i2 < i) {
                return;
            }
            this.f51417b = true;
            this.f51418c = System.currentTimeMillis();
        }

        public void b() {
            this.f51416a = 0;
            if (this.f51417b) {
                this.f51417b = false;
                this.f51418c = 0L;
            }
        }
    }

    public c() {
        super(1001);
        this.f51411b = 3;
        this.f51412c = 300000L;
        this.f51413d = new SparseArray<>();
        this.f51414e = new HashSet<>();
        this.f51415f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        return f51409g;
    }

    public int b() {
        return this.f51415f;
    }

    @Modify(description = "长连接是否可用")
    public boolean c(int i) {
        this.f51415f = 0;
        if (this.f51410a) {
            this.f51415f = 3;
            return false;
        } else if (this.f51414e.contains(Integer.valueOf(i))) {
            this.f51415f = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().v()) {
            this.f51415f = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
            d.b.b.c.e.c.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.f51415f = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            b bVar = this.f51413d.get(i);
            if (bVar != null && bVar.f51417b) {
                if (Math.abs(System.currentTimeMillis() - bVar.f51418c) > this.f51412c) {
                    bVar.b();
                } else {
                    this.f51415f = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void d(int i) {
        b bVar = this.f51413d.get(i);
        if (bVar == null) {
            bVar = new b();
            this.f51413d.append(i, bVar);
        }
        if (bVar != null) {
            bVar.a(this.f51411b);
        }
        this.f51415f = 5;
    }

    public void e(int i) {
        this.f51413d.remove(i);
    }

    public void f() {
        for (int i = 0; i < this.f51413d.size(); i++) {
            this.f51413d.valueAt(i).b();
        }
    }

    public void g(boolean z) {
        this.f51410a = z;
    }

    public void h(int i) {
        this.f51411b = i;
    }

    public void i(long j) {
        this.f51412c = j;
    }

    public void j(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.f51414e.clear();
        for (int i : iArr) {
            this.f51414e.add(Integer.valueOf(i));
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
