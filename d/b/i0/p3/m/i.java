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
    public int f59162a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f59163b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f59164c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f59165d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f59166e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59167f;

    /* renamed from: g  reason: collision with root package name */
    public long f59168g;

    /* renamed from: h  reason: collision with root package name */
    public int f59169h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.b.i0.p3.m.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1471a implements d.InterfaceC1805d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f59171a;

            /* renamed from: d.b.i0.p3.m.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1472a implements Runnable {
                public RunnableC1472a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f59164c != null) {
                        i.this.f59164c.onRecordDone();
                    }
                }
            }

            public C1471a(g gVar) {
                this.f59171a = gVar;
            }

            @Override // d.e.b.d.InterfaceC1805d
            public void a() {
                d.b.b.e.m.e.a().post(new RunnableC1472a());
                this.f59171a.setOnEncoderStatusUpdateListener(null);
            }

            @Override // d.e.b.d.InterfaceC1805d
            public void b() {
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i) {
            h hVar;
            g q;
            i.this.f59169h = i;
            if (i != 100 || i.this.f59164c == null || (hVar = i.this.f59164c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1471a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f59164c != null) {
                i.this.f59164c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f59164c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f59164c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f59164c.findViewById(R.id.video_progress_view);
        this.f59165d = progressView;
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
        if (this.f59166e == null) {
            this.f59166e = new ArrayList();
        }
        this.f59166e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f59165d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f59163b = this.f59165d.getLastProgress();
        h hVar = this.f59164c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f59169h;
    }

    public int f() {
        return this.f59162a;
    }

    public int g() {
        return this.f59163b;
    }

    public boolean h() {
        return this.f59162a == 6;
    }

    public boolean i() {
        j jVar = this.f59164c.mMusicController;
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
        return this.f59165d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f59167f || (progressView = this.f59165d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i) {
        File[] listFiles;
        this.f59162a = i;
        if (i == 1) {
            this.f59165d.setVisibility(4);
            this.f59165d.d();
            this.f59163b = 0;
            File file = new File(d.b.i0.p3.c.f58890c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f59166e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f59162a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f59167f) {
            return;
        }
        ProgressView progressView = this.f59165d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f59165d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f59167f) {
            this.f59167f = true;
            this.f59168g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f59164c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f59164c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f59163b);
        }
    }

    public void o() {
        h hVar;
        if (this.f59167f) {
            ProgressView progressView = this.f59165d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f59167f = false;
            this.f59163b = (int) (this.f59163b + (System.currentTimeMillis() - this.f59168g));
            ProgressView progressView2 = this.f59165d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i = this.f59163b;
                if (lastProgress != i) {
                    this.f59165d.c(i);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f59164c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
