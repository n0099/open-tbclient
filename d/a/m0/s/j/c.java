package d.a.m0.s.j;

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
    public static c f50720g = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f50721a;

    /* renamed from: b  reason: collision with root package name */
    public int f50722b;

    /* renamed from: c  reason: collision with root package name */
    public long f50723c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f50724d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f50725e;

    /* renamed from: f  reason: collision with root package name */
    public int f50726f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f50727a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f50728b;

        /* renamed from: c  reason: collision with root package name */
        public long f50729c;

        public b() {
        }

        public void a(int i2) {
            int i3 = this.f50727a + 1;
            this.f50727a = i3;
            if (this.f50728b || i3 < i2) {
                return;
            }
            this.f50728b = true;
            this.f50729c = System.currentTimeMillis();
        }

        public void b() {
            this.f50727a = 0;
            if (this.f50728b) {
                this.f50728b = false;
                this.f50729c = 0L;
            }
        }
    }

    public c() {
        super(1001);
        this.f50722b = 3;
        this.f50723c = 300000L;
        this.f50724d = new SparseArray<>();
        this.f50725e = new HashSet<>();
        this.f50726f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        return f50720g;
    }

    public int b() {
        return this.f50726f;
    }

    @Modify(description = "长连接是否可用")
    public boolean c(int i2) {
        this.f50726f = 0;
        if (this.f50721a) {
            this.f50726f = 3;
            return false;
        } else if (this.f50725e.contains(Integer.valueOf(i2))) {
            this.f50726f = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().v()) {
            this.f50726f = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
            d.a.c.c.e.c.i.a("lcapimgr", i2, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.f50726f = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            b bVar = this.f50724d.get(i2);
            if (bVar != null && bVar.f50728b) {
                if (Math.abs(System.currentTimeMillis() - bVar.f50729c) > this.f50723c) {
                    bVar.b();
                } else {
                    this.f50726f = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void d(int i2) {
        b bVar = this.f50724d.get(i2);
        if (bVar == null) {
            bVar = new b();
            this.f50724d.append(i2, bVar);
        }
        if (bVar != null) {
            bVar.a(this.f50722b);
        }
        this.f50726f = 5;
    }

    public void e(int i2) {
        this.f50724d.remove(i2);
    }

    public void f() {
        for (int i2 = 0; i2 < this.f50724d.size(); i2++) {
            this.f50724d.valueAt(i2).b();
        }
    }

    public void g(boolean z) {
        this.f50721a = z;
    }

    public void h(int i2) {
        this.f50722b = i2;
    }

    public void i(long j) {
        this.f50723c = j;
    }

    public void j(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.f50725e.clear();
        for (int i2 : iArr) {
            this.f50725e.add(Integer.valueOf(i2));
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
