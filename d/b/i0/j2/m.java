package d.b.i0.j2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f57601a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f57602b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f57603c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f57604d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f57605e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f57606f;

    public m(ViewGroup viewGroup) {
        this.f57601a = viewGroup;
        this.f57602b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f57603c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f57604d.cancel();
        this.f57605e.cancel();
        this.f57606f.cancel();
    }

    public void b() {
        a();
        this.f57601a.setVisibility(8);
        this.f57603c.h();
    }

    public void c() {
        a();
        this.f57605e.start();
        this.f57606f.start();
    }

    public final void d() {
        this.f57604d = ObjectAnimator.ofFloat(this.f57602b, "alpha", 1.0f, 0.5f);
        this.f57605e = ObjectAnimator.ofFloat(this.f57602b, "alpha", 0.5f, 0.0f);
        this.f57606f = ObjectAnimator.ofFloat(this.f57603c, "alpha", 1.0f, 0.0f);
        this.f57604d.setDuration(50L);
        this.f57605e.setDuration(50L);
        this.f57606f.setDuration(50L);
    }

    public void e() {
        a();
        this.f57603c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f57603c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f57602b.setAlpha(1.0f);
        this.f57603c.setAlpha(1.0f);
        this.f57601a.setVisibility(0);
        this.f57603c.l();
        this.f57604d.start();
    }
}
