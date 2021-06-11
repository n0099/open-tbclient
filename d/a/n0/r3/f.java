package d.a.n0.r3;

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
    public static f f63703e;

    /* renamed from: a  reason: collision with root package name */
    public VideoHolyCardModel f63704a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63705b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63706c;

    /* renamed from: d  reason: collision with root package name */
    public VideoHolyCardModel.b f63707d = new b();

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
            f.this.f63705b = z;
        }
    }

    public f() {
        f();
        c();
    }

    public static f d() {
        if (f63703e == null) {
            synchronized (f.class) {
                if (f63703e == null) {
                    f63703e = new f();
                }
            }
        }
        return f63703e;
    }

    public final void c() {
        if (this.f63704a == null) {
            VideoHolyCardModel videoHolyCardModel = new VideoHolyCardModel();
            this.f63704a = videoHolyCardModel;
            videoHolyCardModel.z(this.f63707d);
        }
        this.f63704a.x();
    }

    public boolean e() {
        return this.f63705b;
    }

    public final void f() {
        MessageManager.getInstance().registerListener(new a(2000994));
    }

    public void g(Context context) {
        if (this.f63705b && !this.f63706c) {
            l.L(context, R.string.free_data_tips);
            this.f63706c = true;
        }
    }
}
