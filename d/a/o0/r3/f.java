package d.a.o0.r3;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public static f f63828e;

    /* renamed from: a  reason: collision with root package name */
    public VideoHolyCardModel f63829a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63830b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63831c;

    /* renamed from: d  reason: collision with root package name */
    public VideoHolyCardModel.b f63832d = new b();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (j.x()) {
                f.this.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements VideoHolyCardModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.model.VideoHolyCardModel.b
        public void onResult(boolean z) {
            f.this.f63830b = z;
        }
    }

    public f() {
        f();
        c();
    }

    public static f d() {
        if (f63828e == null) {
            synchronized (f.class) {
                if (f63828e == null) {
                    f63828e = new f();
                }
            }
        }
        return f63828e;
    }

    public final void c() {
        if (this.f63829a == null) {
            VideoHolyCardModel videoHolyCardModel = new VideoHolyCardModel();
            this.f63829a = videoHolyCardModel;
            videoHolyCardModel.z(this.f63832d);
        }
        this.f63829a.x();
    }

    public boolean e() {
        return this.f63830b;
    }

    public final void f() {
        MessageManager.getInstance().registerListener(new a(2000994));
    }

    public void g(Context context) {
        if (this.f63830b && !this.f63831c) {
            l.L(context, R.string.free_data_tips);
            this.f63831c = true;
        }
    }
}
