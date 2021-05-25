package d.a.n0.r3.m;

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
    public int f60277a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f60278b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f60279c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f60280d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f60281e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60282f;

    /* renamed from: g  reason: collision with root package name */
    public long f60283g;

    /* renamed from: h  reason: collision with root package name */
    public int f60284h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.a.n0.r3.m.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1583a implements d.InterfaceC1845d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f60286a;

            /* renamed from: d.a.n0.r3.m.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1584a implements Runnable {
                public RunnableC1584a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f60279c != null) {
                        i.this.f60279c.onRecordDone();
                    }
                }
            }

            public C1583a(g gVar) {
                this.f60286a = gVar;
            }

            @Override // d.e.b.d.InterfaceC1845d
            public void a() {
            }

            @Override // d.e.b.d.InterfaceC1845d
            public void b() {
                d.a.c.e.m.e.a().post(new RunnableC1584a());
                this.f60286a.setOnEncoderStatusUpdateListener(null);
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            h hVar;
            g q;
            i.this.f60284h = i2;
            if (i2 != 100 || i.this.f60279c == null || (hVar = i.this.f60279c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1583a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f60279c != null) {
                i.this.f60279c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f60279c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f60279c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f60279c.findViewById(R.id.video_progress_view);
        this.f60280d = progressView;
        progressView.setListener(new a());
        if (!d.a.n0.r3.m.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.a.n0.r3.m.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        if (this.f60281e == null) {
            this.f60281e = new ArrayList();
        }
        this.f60281e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f60280d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f60278b = this.f60280d.getLastProgress();
        h hVar = this.f60279c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f60284h;
    }

    public int f() {
        return this.f60277a;
    }

    public int g() {
        return this.f60278b;
    }

    public boolean h() {
        return this.f60277a == 6;
    }

    public boolean i() {
        j jVar = this.f60279c.mMusicController;
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
        return this.f60280d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f60282f || (progressView = this.f60280d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        this.f60277a = i2;
        if (i2 == 1) {
            this.f60280d.setVisibility(4);
            this.f60280d.d();
            this.f60278b = 0;
            File file = new File(d.a.n0.r3.c.f59995c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f60281e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f60277a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f60282f) {
            return;
        }
        ProgressView progressView = this.f60280d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f60280d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f60282f) {
            this.f60282f = true;
            this.f60283g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f60279c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f60279c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f60278b);
        }
    }

    public void o() {
        h hVar;
        if (this.f60282f) {
            ProgressView progressView = this.f60280d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f60282f = false;
            this.f60278b = (int) (this.f60278b + (System.currentTimeMillis() - this.f60283g));
            ProgressView progressView2 = this.f60280d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f60278b;
                if (lastProgress != i2) {
                    this.f60280d.c(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f60279c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
