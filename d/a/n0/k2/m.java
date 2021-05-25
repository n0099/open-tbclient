package d.a.n0.k2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f56888a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56889b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f56890c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f56891d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f56892e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f56893f;

    public m(ViewGroup viewGroup) {
        this.f56888a = viewGroup;
        this.f56889b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f56890c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f56891d.cancel();
        this.f56892e.cancel();
        this.f56893f.cancel();
    }

    public void b() {
        a();
        this.f56888a.setVisibility(8);
        this.f56890c.h();
    }

    public void c() {
        a();
        this.f56892e.start();
        this.f56893f.start();
    }

    public final void d() {
        this.f56891d = ObjectAnimator.ofFloat(this.f56889b, "alpha", 1.0f, 0.5f);
        this.f56892e = ObjectAnimator.ofFloat(this.f56889b, "alpha", 0.5f, 0.0f);
        this.f56893f = ObjectAnimator.ofFloat(this.f56890c, "alpha", 1.0f, 0.0f);
        this.f56891d.setDuration(50L);
        this.f56892e.setDuration(50L);
        this.f56893f.setDuration(50L);
    }

    public void e() {
        a();
        this.f56890c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f56890c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f56889b.setAlpha(1.0f);
        this.f56890c.setAlpha(1.0f);
        this.f56888a.setVisibility(0);
        this.f56890c.l();
        this.f56891d.start();
    }
}
