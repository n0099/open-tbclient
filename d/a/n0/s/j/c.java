package d.a.n0.s.j;

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
    public static c f54504g = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f54505a;

    /* renamed from: b  reason: collision with root package name */
    public int f54506b;

    /* renamed from: c  reason: collision with root package name */
    public long f54507c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f54508d;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<Integer> f54509e;

    /* renamed from: f  reason: collision with root package name */
    public int f54510f;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f54511a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f54512b;

        /* renamed from: c  reason: collision with root package name */
        public long f54513c;

        public b() {
        }

        public void a(int i2) {
            int i3 = this.f54511a + 1;
            this.f54511a = i3;
            if (this.f54512b || i3 < i2) {
                return;
            }
            this.f54512b = true;
            this.f54513c = System.currentTimeMillis();
        }

        public void b() {
            this.f54511a = 0;
            if (this.f54512b) {
                this.f54512b = false;
                this.f54513c = 0L;
            }
        }
    }

    public c() {
        super(1001);
        this.f54506b = 3;
        this.f54507c = 300000L;
        this.f54508d = new SparseArray<>();
        this.f54509e = new HashSet<>();
        this.f54510f = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public static c a() {
        return f54504g;
    }

    public int b() {
        return this.f54510f;
    }

    @Modify(description = "长连接是否可用")
    public boolean c(int i2) {
        this.f54510f = 0;
        if (this.f54505a) {
            this.f54510f = 3;
            return false;
        } else if (this.f54509e.contains(Integer.valueOf(i2))) {
            this.f54510f = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().v()) {
            this.f54510f = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().q() > e.j().i() + 20000) {
            d.a.c.c.e.c.i.a("lcapimgr", i2, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.f54510f = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            b bVar = this.f54508d.get(i2);
            if (bVar != null && bVar.f54512b) {
                if (Math.abs(System.currentTimeMillis() - bVar.f54513c) > this.f54507c) {
                    bVar.b();
                } else {
                    this.f54510f = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void d(int i2) {
        b bVar = this.f54508d.get(i2);
        if (bVar == null) {
            bVar = new b();
            this.f54508d.append(i2, bVar);
        }
        if (bVar != null) {
            bVar.a(this.f54506b);
        }
        this.f54510f = 5;
    }

    public void e(int i2) {
        this.f54508d.remove(i2);
    }

    public void f() {
        for (int i2 = 0; i2 < this.f54508d.size(); i2++) {
            this.f54508d.valueAt(i2).b();
        }
    }

    public void g(boolean z) {
        this.f54505a = z;
    }

    public void h(int i2) {
        this.f54506b = i2;
    }

    public void i(long j) {
        this.f54507c = j;
    }

    public void j(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.f54509e.clear();
        for (int i2 : iArr) {
            this.f54509e.add(Integer.valueOf(i2));
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
