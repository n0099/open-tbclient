package d.a.j0.q3;

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
    public static f f59126e;

    /* renamed from: a  reason: collision with root package name */
    public VideoHolyCardModel f59127a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59128b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59129c;

    /* renamed from: d  reason: collision with root package name */
    public VideoHolyCardModel.b f59130d = new b();

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
            f.this.f59128b = z;
        }
    }

    public f() {
        f();
        c();
    }

    public static f d() {
        if (f59126e == null) {
            synchronized (f.class) {
                if (f59126e == null) {
                    f59126e = new f();
                }
            }
        }
        return f59126e;
    }

    public final void c() {
        if (this.f59127a == null) {
            VideoHolyCardModel videoHolyCardModel = new VideoHolyCardModel();
            this.f59127a = videoHolyCardModel;
            videoHolyCardModel.v(this.f59130d);
        }
        this.f59127a.t();
    }

    public boolean e() {
        return this.f59128b;
    }

    public final void f() {
        MessageManager.getInstance().registerListener(new a(2000994));
    }

    public void g(Context context) {
        if (this.f59128b && !this.f59129c) {
            l.L(context, R.string.free_data_tips);
            this.f59129c = true;
        }
    }
}
