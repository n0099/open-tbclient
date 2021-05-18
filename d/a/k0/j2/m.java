package d.a.k0.j2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f56708a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56709b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f56710c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f56711d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f56712e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f56713f;

    public m(ViewGroup viewGroup) {
        this.f56708a = viewGroup;
        this.f56709b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f56710c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f56711d.cancel();
        this.f56712e.cancel();
        this.f56713f.cancel();
    }

    public void b() {
        a();
        this.f56708a.setVisibility(8);
        this.f56710c.h();
    }

    public void c() {
        a();
        this.f56712e.start();
        this.f56713f.start();
    }

    public final void d() {
        this.f56711d = ObjectAnimator.ofFloat(this.f56709b, "alpha", 1.0f, 0.5f);
        this.f56712e = ObjectAnimator.ofFloat(this.f56709b, "alpha", 0.5f, 0.0f);
        this.f56713f = ObjectAnimator.ofFloat(this.f56710c, "alpha", 1.0f, 0.0f);
        this.f56711d.setDuration(50L);
        this.f56712e.setDuration(50L);
        this.f56713f.setDuration(50L);
    }

    public void e() {
        a();
        this.f56710c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f56710c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f56709b.setAlpha(1.0f);
        this.f56710c.setAlpha(1.0f);
        this.f56708a.setVisibility(0);
        this.f56710c.l();
        this.f56711d.start();
    }
}
