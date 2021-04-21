package d.b.j0.j2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f58022a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f58023b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f58024c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f58025d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f58026e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f58027f;

    public m(ViewGroup viewGroup) {
        this.f58022a = viewGroup;
        this.f58023b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f58024c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f58025d.cancel();
        this.f58026e.cancel();
        this.f58027f.cancel();
    }

    public void b() {
        a();
        this.f58022a.setVisibility(8);
        this.f58024c.h();
    }

    public void c() {
        a();
        this.f58026e.start();
        this.f58027f.start();
    }

    public final void d() {
        this.f58025d = ObjectAnimator.ofFloat(this.f58023b, "alpha", 1.0f, 0.5f);
        this.f58026e = ObjectAnimator.ofFloat(this.f58023b, "alpha", 0.5f, 0.0f);
        this.f58027f = ObjectAnimator.ofFloat(this.f58024c, "alpha", 1.0f, 0.0f);
        this.f58025d.setDuration(50L);
        this.f58026e.setDuration(50L);
        this.f58027f.setDuration(50L);
    }

    public void e() {
        a();
        this.f58024c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f58024c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f58023b.setAlpha(1.0f);
        this.f58024c.setAlpha(1.0f);
        this.f58022a.setVisibility(0);
        this.f58024c.l();
        this.f58025d.start();
    }
}
