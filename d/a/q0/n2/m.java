package d.a.q0.n2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f61413a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f61414b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f61415c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f61416d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f61417e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f61418f;

    public m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61413a = viewGroup;
        this.f61414b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f61415c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61416d.cancel();
            this.f61417e.cancel();
            this.f61418f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f61413a.setVisibility(8);
            this.f61415c.h();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f61417e.start();
            this.f61418f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f61416d = ObjectAnimator.ofFloat(this.f61414b, "alpha", 1.0f, 0.5f);
            this.f61417e = ObjectAnimator.ofFloat(this.f61414b, "alpha", 0.5f, 0.0f);
            this.f61418f = ObjectAnimator.ofFloat(this.f61415c, "alpha", 1.0f, 0.0f);
            this.f61416d.setDuration(50L);
            this.f61417e.setDuration(50L);
            this.f61418f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f61415c.j();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f61415c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f61414b.setAlpha(1.0f);
            this.f61415c.setAlpha(1.0f);
            this.f61413a.setVisibility(0);
            this.f61415c.l();
            this.f61416d.start();
        }
    }
}
