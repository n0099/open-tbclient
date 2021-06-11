package d.a.n0.k2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f60577a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60578b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f60579c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f60580d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f60581e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f60582f;

    public m(ViewGroup viewGroup) {
        this.f60577a = viewGroup;
        this.f60578b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f60579c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f60580d.cancel();
        this.f60581e.cancel();
        this.f60582f.cancel();
    }

    public void b() {
        a();
        this.f60577a.setVisibility(8);
        this.f60579c.h();
    }

    public void c() {
        a();
        this.f60581e.start();
        this.f60582f.start();
    }

    public final void d() {
        this.f60580d = ObjectAnimator.ofFloat(this.f60578b, "alpha", 1.0f, 0.5f);
        this.f60581e = ObjectAnimator.ofFloat(this.f60578b, "alpha", 0.5f, 0.0f);
        this.f60582f = ObjectAnimator.ofFloat(this.f60579c, "alpha", 1.0f, 0.0f);
        this.f60580d.setDuration(50L);
        this.f60581e.setDuration(50L);
        this.f60582f.setDuration(50L);
    }

    public void e() {
        a();
        this.f60579c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f60579c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f60578b.setAlpha(1.0f);
        this.f60579c.setAlpha(1.0f);
        this.f60577a.setVisibility(0);
        this.f60579c.l();
        this.f60580d.start();
    }
}
