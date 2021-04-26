package d.a.i0.s.j;

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
public class c extends d.a.c.c.g.c {

    /* renamed from: g  reason: collision with root package name */
    public static c f49828g = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f49829a;

    /* renamed from: b  reason: collision with root package name */
    public int f49830b;

    /* renamed from: c  reason: collision with root package name */
    public long f49831c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f49832d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f49833e;

    /* renamed from: f  reason: collision with root package name */
    public int f49834f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f49835a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f49836b;

        /* renamed from: c  reason: collision with root package name */
        public long f49837c;

        public b() {
        }

        public void a(int i2) {
            int i3 = this.f49835a + 1;
            this.f49835a = i3;
            if (this.f49836b || i3 < i2) {
                return;
            }
            this.f49836b = true;
            this.f49837c = System.currentTimeMillis();
        }

        public void b() {
            this.f49835a = 0;
            if (this.f49836b) {
                this.f49836b = false;
                this.f49837c = 0L;
            }
        }
    }

    public c() {
        super(1001);
        this.f49830b = 3;
        this.f49831c = 300000L;
        this.f49832d = new SparseArray<>();
        this.f49833e = new HashSet<>();
        this.f49834f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        return f49828g;
    }

    public int b() {
        return this.f49834f;
    }

    @Modify(description = "长连接是否可用")
    public boolean c(int i2) {
        this.f49834f = 0;
        if (this.f49829a) {
            this.f49834f = 3;
            return false;
        } else if (this.f49833e.contains(Integer.valueOf(i2))) {
            this.f49834f = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().v()) {
            this.f49834f = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
            d.a.c.c.e.c.i.a("lcapimgr", i2, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.f49834f = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            b bVar = this.f49832d.get(i2);
            if (bVar != null && bVar.f49836b) {
                if (Math.abs(System.currentTimeMillis() - bVar.f49837c) > this.f49831c) {
                    bVar.b();
                } else {
                    this.f49834f = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void d(int i2) {
        b bVar = this.f49832d.get(i2);
        if (bVar == null) {
            bVar = new b();
            this.f49832d.append(i2, bVar);
        }
        if (bVar != null) {
            bVar.a(this.f49830b);
        }
        this.f49834f = 5;
    }

    public void e(int i2) {
        this.f49832d.remove(i2);
    }

    public void f() {
        for (int i2 = 0; i2 < this.f49832d.size(); i2++) {
            this.f49832d.valueAt(i2).b();
        }
    }

    public void g(boolean z) {
        this.f49829a = z;
    }

    public void h(int i2) {
        this.f49830b = i2;
    }

    public void i(long j) {
        this.f49831c = j;
    }

    public void j(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.f49833e.clear();
        for (int i2 : iArr) {
            this.f49833e.add(Integer.valueOf(i2));
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
