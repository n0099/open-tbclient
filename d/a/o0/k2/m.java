package d.a.o0.k2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes5.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f60702a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60703b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f60704c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f60705d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f60706e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f60707f;

    public m(ViewGroup viewGroup) {
        this.f60702a = viewGroup;
        this.f60703b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f60704c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        this.f60705d.cancel();
        this.f60706e.cancel();
        this.f60707f.cancel();
    }

    public void b() {
        a();
        this.f60702a.setVisibility(8);
        this.f60704c.h();
    }

    public void c() {
        a();
        this.f60706e.start();
        this.f60707f.start();
    }

    public final void d() {
        this.f60705d = ObjectAnimator.ofFloat(this.f60703b, "alpha", 1.0f, 0.5f);
        this.f60706e = ObjectAnimator.ofFloat(this.f60703b, "alpha", 0.5f, 0.0f);
        this.f60707f = ObjectAnimator.ofFloat(this.f60704c, "alpha", 1.0f, 0.0f);
        this.f60705d.setDuration(50L);
        this.f60706e.setDuration(50L);
        this.f60707f.setDuration(50L);
    }

    public void e() {
        a();
        this.f60704c.j();
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView = this.f60704c;
        if (videoLoadingProgressView != null) {
            videoLoadingProgressView.setLoadingAnimationListener(cVar);
        }
    }

    public void g() {
        a();
        this.f60703b.setAlpha(1.0f);
        this.f60704c.setAlpha(1.0f);
        this.f60702a.setVisibility(0);
        this.f60704c.l();
        this.f60705d.start();
    }
}
