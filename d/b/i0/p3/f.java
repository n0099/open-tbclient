package d.b.i0.p3;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.model.VideoHolyCardModel;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
/* loaded from: classes.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public static f f58905e;

    /* renamed from: a  reason: collision with root package name */
    public VideoHolyCardModel f58906a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58907b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58908c;

    /* renamed from: d  reason: collision with root package name */
    public VideoHolyCardModel.b f58909d = new b();

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
            f.this.f58907b = z;
        }
    }

    public f() {
        f();
        c();
    }

    public static f d() {
        if (f58905e == null) {
            synchronized (f.class) {
                if (f58905e == null) {
                    f58905e = new f();
                }
            }
        }
        return f58905e;
    }

    public final void c() {
        if (this.f58906a == null) {
            VideoHolyCardModel videoHolyCardModel = new VideoHolyCardModel();
            this.f58906a = videoHolyCardModel;
            videoHolyCardModel.v(this.f58909d);
        }
        this.f58906a.t();
    }

    public boolean e() {
        return this.f58907b;
    }

    public final void f() {
        MessageManager.getInstance().registerListener(new a(2000994));
    }

    public void g(Context context) {
        if (this.f58907b && !this.f58908c) {
            l.K(context, R.string.free_data_tips);
            this.f58908c = true;
        }
    }
}
