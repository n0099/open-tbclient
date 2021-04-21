package d.b.j0.q3;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public static f f60995e;

    /* renamed from: a  reason: collision with root package name */
    public VideoHolyCardModel f60996a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60997b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60998c;

    /* renamed from: d  reason: collision with root package name */
    public VideoHolyCardModel.b f60999d = new b();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
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
            f.this.f60997b = z;
        }
    }

    public f() {
        f();
        c();
    }

    public static f d() {
        if (f60995e == null) {
            synchronized (f.class) {
                if (f60995e == null) {
                    f60995e = new f();
                }
            }
        }
        return f60995e;
    }

    public final void c() {
        if (this.f60996a == null) {
            VideoHolyCardModel videoHolyCardModel = new VideoHolyCardModel();
            this.f60996a = videoHolyCardModel;
            videoHolyCardModel.v(this.f60999d);
        }
        this.f60996a.t();
    }

    public boolean e() {
        return this.f60997b;
    }

    public final void f() {
        MessageManager.getInstance().registerListener(new a(2000994));
    }

    public void g(Context context) {
        if (this.f60997b && !this.f60998c) {
            l.K(context, R.string.free_data_tips);
            this.f60998c = true;
        }
    }
}
