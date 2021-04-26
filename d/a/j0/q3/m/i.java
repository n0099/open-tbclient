package d.a.j0.q3.m;

import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.ProgressView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import d.e.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f59391a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f59392b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f59393c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f59394d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f59395e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59396f;

    /* renamed from: g  reason: collision with root package name */
    public long f59397g;

    /* renamed from: h  reason: collision with root package name */
    public int f59398h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.a.j0.q3.m.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1496a implements d.InterfaceC1777d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f59400a;

            /* renamed from: d.a.j0.q3.m.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1497a implements Runnable {
                public RunnableC1497a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f59393c != null) {
                        i.this.f59393c.onRecordDone();
                    }
                }
            }

            public C1496a(g gVar) {
                this.f59400a = gVar;
            }

            @Override // d.e.b.d.InterfaceC1777d
            public void a() {
            }

            @Override // d.e.b.d.InterfaceC1777d
            public void b() {
                d.a.c.e.m.e.a().post(new RunnableC1497a());
                this.f59400a.setOnEncoderStatusUpdateListener(null);
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            h hVar;
            g q;
            i.this.f59398h = i2;
            if (i2 != 100 || i.this.f59393c == null || (hVar = i.this.f59393c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1496a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f59393c != null) {
                i.this.f59393c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f59393c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f59393c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f59393c.findViewById(R.id.video_progress_view);
        this.f59394d = progressView;
        progressView.setListener(new a());
        if (!d.a.j0.q3.m.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.a.j0.q3.m.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        if (this.f59395e == null) {
            this.f59395e = new ArrayList();
        }
        this.f59395e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f59394d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f59392b = this.f59394d.getLastProgress();
        h hVar = this.f59393c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f59398h;
    }

    public int f() {
        return this.f59391a;
    }

    public int g() {
        return this.f59392b;
    }

    public boolean h() {
        return this.f59391a == 6;
    }

    public boolean i() {
        j jVar = this.f59393c.mMusicController;
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
        return this.f59394d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f59396f || (progressView = this.f59394d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        this.f59391a = i2;
        if (i2 == 1) {
            this.f59394d.setVisibility(4);
            this.f59394d.d();
            this.f59392b = 0;
            File file = new File(d.a.j0.q3.c.f59109c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f59395e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f59391a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f59396f) {
            return;
        }
        ProgressView progressView = this.f59394d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f59394d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f59396f) {
            this.f59396f = true;
            this.f59397g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f59393c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f59393c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f59392b);
        }
    }

    public void o() {
        h hVar;
        if (this.f59396f) {
            ProgressView progressView = this.f59394d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f59396f = false;
            this.f59392b = (int) (this.f59392b + (System.currentTimeMillis() - this.f59397g));
            ProgressView progressView2 = this.f59394d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f59392b;
                if (lastProgress != i2) {
                    this.f59394d.c(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f59393c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
