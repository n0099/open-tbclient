package d.b.j0.q3.m;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.ProgressView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import d.f.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f61251a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f61252b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f61253c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f61254d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f61255e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61256f;

    /* renamed from: g  reason: collision with root package name */
    public long f61257g;

    /* renamed from: h  reason: collision with root package name */
    public int f61258h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.b.j0.q3.m.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1557a implements d.InterfaceC1837d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f61260a;

            /* renamed from: d.b.j0.q3.m.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1558a implements Runnable {
                public RunnableC1558a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f61253c != null) {
                        i.this.f61253c.onRecordDone();
                    }
                }
            }

            public C1557a(g gVar) {
                this.f61260a = gVar;
            }

            @Override // d.f.b.d.InterfaceC1837d
            public void a() {
                d.b.c.e.m.e.a().post(new RunnableC1558a());
                this.f61260a.setOnEncoderStatusUpdateListener(null);
            }

            @Override // d.f.b.d.InterfaceC1837d
            public void b() {
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i) {
            h hVar;
            g q;
            i.this.f61258h = i;
            if (i != 100 || i.this.f61253c == null || (hVar = i.this.f61253c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1557a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f61253c != null) {
                i.this.f61253c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f61253c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f61253c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f61253c.findViewById(R.id.video_progress_view);
        this.f61254d = progressView;
        progressView.setListener(new a());
        if (!d.b.j0.q3.m.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.b.j0.q3.m.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        if (this.f61255e == null) {
            this.f61255e = new ArrayList();
        }
        this.f61255e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f61254d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f61252b = this.f61254d.getLastProgress();
        h hVar = this.f61253c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f61258h;
    }

    public int f() {
        return this.f61251a;
    }

    public int g() {
        return this.f61252b;
    }

    public boolean h() {
        return this.f61251a == 6;
    }

    public boolean i() {
        j jVar = this.f61253c.mMusicController;
        if (jVar != null) {
            return jVar.i();
        }
        return false;
    }

    public boolean j() {
        int f2 = f();
        return f2 == 2 || f2 == 7;
    }

    public boolean k() {
        return this.f61254d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f61256f || (progressView = this.f61254d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i) {
        File[] listFiles;
        this.f61251a = i;
        if (i == 1) {
            this.f61254d.setVisibility(4);
            this.f61254d.d();
            this.f61252b = 0;
            File file = new File(d.b.j0.q3.c.f60979c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f61255e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f61251a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f61256f) {
            return;
        }
        ProgressView progressView = this.f61254d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f61254d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f61256f) {
            this.f61256f = true;
            this.f61257g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f61253c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f61253c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f61252b);
        }
    }

    public void o() {
        h hVar;
        if (this.f61256f) {
            ProgressView progressView = this.f61254d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f61256f = false;
            this.f61252b = (int) (this.f61252b + (System.currentTimeMillis() - this.f61257g));
            ProgressView progressView2 = this.f61254d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i = this.f61252b;
                if (lastProgress != i) {
                    this.f61254d.c(i);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f61253c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
