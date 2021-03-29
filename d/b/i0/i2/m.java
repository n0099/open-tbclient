package d.b.i0.i2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f56154a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56155b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f56156c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f56157d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f56158e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f56159f;

    public m(ViewGroup viewGroup) {
        this.f56154a = viewGroup;
        this.f56155b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f56156c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f56157d.cancel();
        this.f56158e.cancel();
        this.f56159f.cancel();
    }

    public void b() {
        a();
        this.f56154a.setVisibility(8);
        this.f56156c.h();
    }

    public void c() {
        a();
        this.f56158e.start();
        this.f56159f.start();
    }

    public final void d() {
        this.f56157d = ObjectAnimator.ofFloat(this.f56155b, "alpha", 1.0f, 0.5f);
        this.f56158e = ObjectAnimator.ofFloat(this.f56155b, "alpha", 0.5f, 0.0f);
        this.f56159f = ObjectAnimator.ofFloat(this.f56156c, "alpha", 1.0f, 0.0f);
        this.f56157d.setDuration(50L);
        this.f56158e.setDuration(50L);
        this.f56159f.setDuration(50L);
    }

    public void e() {
        a();
        this.f56156c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f56156c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f56155b.setAlpha(1.0f);
        this.f56156c.setAlpha(1.0f);
        this.f56154a.setVisibility(0);
        this.f56156c.l();
        this.f56157d.start();
    }
}
