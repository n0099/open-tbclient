package d.a.o0.r3.l;

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
    public int f64091a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f64092b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f64093c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f64094d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f64095e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64096f;

    /* renamed from: g  reason: collision with root package name */
    public long f64097g;

    /* renamed from: h  reason: collision with root package name */
    public int f64098h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.a.o0.r3.l.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1643a implements d.InterfaceC1907d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f64100a;

            /* renamed from: d.a.o0.r3.l.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1644a implements Runnable {
                public RunnableC1644a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f64093c != null) {
                        i.this.f64093c.onRecordDone();
                    }
                }
            }

            public C1643a(g gVar) {
                this.f64100a = gVar;
            }

            @Override // d.e.b.d.InterfaceC1907d
            public void a() {
            }

            @Override // d.e.b.d.InterfaceC1907d
            public void b() {
                d.a.c.e.m.e.a().post(new RunnableC1644a());
                this.f64100a.setOnEncoderStatusUpdateListener(null);
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            h hVar;
            g q;
            i.this.f64098h = i2;
            if (i2 != 100 || i.this.f64093c == null || (hVar = i.this.f64093c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1643a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f64093c != null) {
                i.this.f64093c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f64093c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f64093c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f64093c.findViewById(R.id.video_progress_view);
        this.f64094d = progressView;
        progressView.setListener(new a());
        if (!d.a.o0.r3.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.a.o0.r3.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        if (this.f64095e == null) {
            this.f64095e = new ArrayList();
        }
        this.f64095e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f64094d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f64092b = this.f64094d.getLastProgress();
        h hVar = this.f64093c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f64098h;
    }

    public int f() {
        return this.f64091a;
    }

    public int g() {
        return this.f64092b;
    }

    public boolean h() {
        return this.f64091a == 6;
    }

    public boolean i() {
        j jVar = this.f64093c.mMusicController;
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
        return this.f64094d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f64096f || (progressView = this.f64094d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        this.f64091a = i2;
        if (i2 == 1) {
            this.f64094d.setVisibility(4);
            this.f64094d.d();
            this.f64092b = 0;
            File file = new File(d.a.o0.r3.c.f63811c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f64095e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f64091a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f64096f) {
            return;
        }
        ProgressView progressView = this.f64094d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f64094d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f64096f) {
            this.f64096f = true;
            this.f64097g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f64093c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f64093c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f64092b);
        }
    }

    public void o() {
        h hVar;
        if (this.f64096f) {
            ProgressView progressView = this.f64094d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f64096f = false;
            this.f64092b = (int) (this.f64092b + (System.currentTimeMillis() - this.f64097g));
            ProgressView progressView2 = this.f64094d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f64092b;
                if (lastProgress != i2) {
                    this.f64094d.c(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f64093c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
