package d.a.n0.r3.l;

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
    public int f63966a = 1;

    /* renamed from: b  reason: collision with root package name */
    public int f63967b;

    /* renamed from: c  reason: collision with root package name */
    public RecordVideoActivity f63968c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressView f63969d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f63970e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63971f;

    /* renamed from: g  reason: collision with root package name */
    public long f63972g;

    /* renamed from: h  reason: collision with root package name */
    public int f63973h;

    /* loaded from: classes5.dex */
    public class a implements ProgressView.a {

        /* renamed from: d.a.n0.r3.l.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1639a implements d.InterfaceC1904d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f63975a;

            /* renamed from: d.a.n0.r3.l.i$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC1640a implements Runnable {
                public RunnableC1640a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.f63968c != null) {
                        i.this.f63968c.onRecordDone();
                    }
                }
            }

            public C1639a(g gVar) {
                this.f63975a = gVar;
            }

            @Override // d.e.b.d.InterfaceC1904d
            public void a() {
            }

            @Override // d.e.b.d.InterfaceC1904d
            public void b() {
                d.a.c.e.m.e.a().post(new RunnableC1640a());
                this.f63975a.setOnEncoderStatusUpdateListener(null);
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i2) {
            h hVar;
            g q;
            i.this.f63973h = i2;
            if (i2 != 100 || i.this.f63968c == null || (hVar = i.this.f63968c.mPreviewController) == null || (q = hVar.q()) == null) {
                return;
            }
            if (q instanceof GLVideoPreviewView) {
                q.setOnEncoderStatusUpdateListener(new C1639a(q));
                i.this.o();
                return;
            }
            i.this.o();
            if (i.this.f63968c != null) {
                i.this.f63968c.onRecordDone();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2);
    }

    public i(RecordVideoActivity recordVideoActivity) {
        this.f63968c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.camera_switch);
        ImageView imageView2 = (ImageView) this.f63968c.findViewById(R.id.flash_switch);
        ProgressView progressView = (ProgressView) this.f63968c.findViewById(R.id.video_progress_view);
        this.f63969d = progressView;
        progressView.setListener(new a());
        if (!d.a.n0.r3.l.a.f(true)) {
            imageView2.setVisibility(4);
        }
        if (d.a.n0.r3.l.a.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        if (this.f63970e == null) {
            this.f63970e = new ArrayList();
        }
        this.f63970e.add(bVar);
    }

    public void d() {
        ProgressView progressView = this.f63969d;
        if (progressView != null) {
            progressView.setCurrentState(ProgressView.State.DELETE);
        }
        this.f63967b = this.f63969d.getLastProgress();
        h hVar = this.f63968c.mPreviewController;
        if (hVar != null) {
            hVar.h();
        }
    }

    public int e() {
        return this.f63973h;
    }

    public int f() {
        return this.f63966a;
    }

    public int g() {
        return this.f63967b;
    }

    public boolean h() {
        return this.f63966a == 6;
    }

    public boolean i() {
        j jVar = this.f63968c.mMusicController;
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
        return this.f63969d.b();
    }

    public void l() {
        ProgressView progressView;
        if (this.f63971f || (progressView = this.f63969d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i2) {
        File[] listFiles;
        this.f63966a = i2;
        if (i2 == 1) {
            this.f63969d.setVisibility(4);
            this.f63969d.d();
            this.f63967b = 0;
            File file = new File(d.a.n0.r3.c.f63686c);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getPath().startsWith("rec_tmp_")) {
                        file2.delete();
                    }
                }
            }
        }
        List<b> list = this.f63970e;
        if (list != null) {
            for (b bVar : list) {
                bVar.a(this.f63966a);
            }
        }
    }

    public void n() {
        h hVar;
        if (this.f63971f) {
            return;
        }
        ProgressView progressView = this.f63969d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.f63969d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f63971f) {
            this.f63971f = true;
            this.f63972g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.f63968c;
        if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
            return;
        }
        hVar.L();
        j jVar = this.f63968c.mMusicController;
        if (jVar != null) {
            jVar.n(this.f63967b);
        }
    }

    public void o() {
        h hVar;
        if (this.f63971f) {
            ProgressView progressView = this.f63969d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f63971f = false;
            this.f63967b = (int) (this.f63967b + (System.currentTimeMillis() - this.f63972g));
            ProgressView progressView2 = this.f63969d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i2 = this.f63967b;
                if (lastProgress != i2) {
                    this.f63969d.c(i2);
                }
            }
            RecordVideoActivity recordVideoActivity = this.f63968c;
            if (recordVideoActivity == null || (hVar = recordVideoActivity.mPreviewController) == null) {
                return;
            }
            hVar.M();
        }
    }
}
