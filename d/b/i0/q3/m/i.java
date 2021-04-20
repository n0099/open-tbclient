package d.b.i0.q3.m;

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
    public int f60830a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f60831b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f60832c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f60833d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f60834e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60835f;

    /* renamed from: g  reason: collision with root package name */
    public long f60836g;

    /* renamed from: h  reason: collision with root package name */
    public int f60837h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.b.i0.q3.m.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1534a implements d.InterfaceC1833d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f60839a;

            /* renamed from: d.b.i0.q3.m.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1535a implements Runnable {
                public RunnableC1535a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f60832c != null) {
                        i.this.f60832c.onRecordDone();
                    }
                }
            }

            public C1534a(g gVar) {
                this.f60839a = gVar;
            }

            @Override // d.e.b.d.InterfaceC1833d
            public void a() {
                d.b.c.e.m.e.a().post(new RunnableC1535a());
                this.f60839a.setOnEncoderStatusUpdateListener(null);
            }

            @Override // d.e.b.d.InterfaceC1833d
            public void b() {
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i) {
            h hVar;
            g q;
            i.this.f60837h = i;
            if (i != 100 || i.this.f60832c == null || (hVar = i.this.f60832c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1534a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f60832c != null) {
                i.this.f60832c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f60832c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f60832c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f60832c.findViewById(R.id.video_progress_view);
        this.f60833d = progressView;
        progressView.setListener(new a());
        if (!d.b.i0.q3.m.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.b.i0.q3.m.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        if (this.f60834e == null) {
            this.f60834e = new ArrayList();
        }
        this.f60834e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f60833d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f60831b = this.f60833d.getLastProgress();
        h hVar = this.f60832c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f60837h;
    }

    public int f() {
        return this.f60830a;
    }

    public int g() {
        return this.f60831b;
    }

    public boolean h() {
        return this.f60830a == 6;
    }

    public boolean i() {
        j jVar = this.f60832c.mMusicController;
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
        return this.f60833d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f60835f || (progressView = this.f60833d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i) {
        File[] listFiles;
        this.f60830a = i;
        if (i == 1) {
            this.f60833d.setVisibility(4);
            this.f60833d.d();
            this.f60831b = 0;
            File file = new File(d.b.i0.q3.c.f60558c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f60834e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f60830a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f60835f) {
            return;
        }
        ProgressView progressView = this.f60833d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f60833d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f60835f) {
            this.f60835f = true;
            this.f60836g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f60832c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f60832c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f60831b);
        }
    }

    public void o() {
        h hVar;
        if (this.f60835f) {
            ProgressView progressView = this.f60833d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f60835f = false;
            this.f60831b = (int) (this.f60831b + (System.currentTimeMillis() - this.f60836g));
            ProgressView progressView2 = this.f60833d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i = this.f60831b;
                if (lastProgress != i) {
                    this.f60833d.c(i);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f60832c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
