package d.b.i0.i2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f56153a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56154b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f56155c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f56156d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f56157e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f56158f;

    public m(ViewGroup viewGroup) {
        this.f56153a = viewGroup;
        this.f56154b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f56155c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f56156d.cancel();
        this.f56157e.cancel();
        this.f56158f.cancel();
    }

    public void b() {
        a();
        this.f56153a.setVisibility(8);
        this.f56155c.h();
    }

    public void c() {
        a();
        this.f56157e.start();
        this.f56158f.start();
    }

    public final void d() {
        this.f56156d = ObjectAnimator.ofFloat(this.f56154b, "alpha", 1.0f, 0.5f);
        this.f56157e = ObjectAnimator.ofFloat(this.f56154b, "alpha", 0.5f, 0.0f);
        this.f56158f = ObjectAnimator.ofFloat(this.f56155c, "alpha", 1.0f, 0.0f);
        this.f56156d.setDuration(50L);
        this.f56157e.setDuration(50L);
        this.f56158f.setDuration(50L);
    }

    public void e() {
        a();
        this.f56155c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f56155c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f56154b.setAlpha(1.0f);
        this.f56155c.setAlpha(1.0f);
        this.f56153a.setVisibility(0);
        this.f56155c.l();
        this.f56156d.start();
    }
}
