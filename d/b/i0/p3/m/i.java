package d.b.i0.p3.m;

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
    public int f59161a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f59162b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f59163c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f59164d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f59165e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59166f;

    /* renamed from: g  reason: collision with root package name */
    public long f59167g;

    /* renamed from: h  reason: collision with root package name */
    public int f59168h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.b.i0.p3.m.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1470a implements d.InterfaceC1804d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f59170a;

            /* renamed from: d.b.i0.p3.m.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1471a implements Runnable {
                public RunnableC1471a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f59163c != null) {
                        i.this.f59163c.onRecordDone();
                    }
                }
            }

            public C1470a(g gVar) {
                this.f59170a = gVar;
            }

            @Override // d.e.b.d.InterfaceC1804d
            public void a() {
                d.b.b.e.m.e.a().post(new RunnableC1471a());
                this.f59170a.setOnEncoderStatusUpdateListener(null);
            }

            @Override // d.e.b.d.InterfaceC1804d
            public void b() {
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i) {
            h hVar;
            g q;
            i.this.f59168h = i;
            if (i != 100 || i.this.f59163c == null || (hVar = i.this.f59163c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1470a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f59163c != null) {
                i.this.f59163c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f59163c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f59163c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f59163c.findViewById(R.id.video_progress_view);
        this.f59164d = progressView;
        progressView.setListener(new a());
        if (!d.b.i0.p3.m.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.b.i0.p3.m.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        if (this.f59165e == null) {
            this.f59165e = new ArrayList();
        }
        this.f59165e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f59164d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f59162b = this.f59164d.getLastProgress();
        h hVar = this.f59163c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f59168h;
    }

    public int f() {
        return this.f59161a;
    }

    public int g() {
        return this.f59162b;
    }

    public boolean h() {
        return this.f59161a == 6;
    }

    public boolean i() {
        j jVar = this.f59163c.mMusicController;
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
        return this.f59164d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f59166f || (progressView = this.f59164d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i) {
        File[] listFiles;
        this.f59161a = i;
        if (i == 1) {
            this.f59164d.setVisibility(4);
            this.f59164d.d();
            this.f59162b = 0;
            File file = new File(d.b.i0.p3.c.f58889c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f59165e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f59161a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f59166f) {
            return;
        }
        ProgressView progressView = this.f59164d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f59164d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f59166f) {
            this.f59166f = true;
            this.f59167g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f59163c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f59163c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f59162b);
        }
    }

    public void o() {
        h hVar;
        if (this.f59166f) {
            ProgressView progressView = this.f59164d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f59166f = false;
            this.f59162b = (int) (this.f59162b + (System.currentTimeMillis() - this.f59167g));
            ProgressView progressView2 = this.f59164d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i = this.f59162b;
                if (lastProgress != i) {
                    this.f59164d.c(i);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f59163c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
