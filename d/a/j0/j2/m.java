package d.a.j0.j2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f56001a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56002b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f56003c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f56004d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f56005e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f56006f;

    public m(ViewGroup viewGroup) {
        this.f56001a = viewGroup;
        this.f56002b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f56003c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f56004d.cancel();
        this.f56005e.cancel();
        this.f56006f.cancel();
    }

    public void b() {
        a();
        this.f56001a.setVisibility(8);
        this.f56003c.h();
    }

    public void c() {
        a();
        this.f56005e.start();
        this.f56006f.start();
    }

    public final void d() {
        this.f56004d = ObjectAnimator.ofFloat(this.f56002b, "alpha", 1.0f, 0.5f);
        this.f56005e = ObjectAnimator.ofFloat(this.f56002b, "alpha", 0.5f, 0.0f);
        this.f56006f = ObjectAnimator.ofFloat(this.f56003c, "alpha", 1.0f, 0.0f);
        this.f56004d.setDuration(50L);
        this.f56005e.setDuration(50L);
        this.f56006f.setDuration(50L);
    }

    public void e() {
        a();
        this.f56003c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f56003c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f56002b.setAlpha(1.0f);
        this.f56003c.setAlpha(1.0f);
        this.f56001a.setVisibility(0);
        this.f56003c.l();
        this.f56004d.start();
    }
}
