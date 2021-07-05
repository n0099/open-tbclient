package d.a.s0.n2;

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
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f64033a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f64034b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f64035c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f64036d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f64037e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f64038f;

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
        this.f64033a = viewGroup;
        this.f64034b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f64035c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64036d.cancel();
            this.f64037e.cancel();
            this.f64038f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f64033a.setVisibility(8);
            this.f64035c.h();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f64037e.start();
            this.f64038f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f64036d = ObjectAnimator.ofFloat(this.f64034b, "alpha", 1.0f, 0.5f);
            this.f64037e = ObjectAnimator.ofFloat(this.f64034b, "alpha", 0.5f, 0.0f);
            this.f64038f = ObjectAnimator.ofFloat(this.f64035c, "alpha", 1.0f, 0.0f);
            this.f64036d.setDuration(50L);
            this.f64037e.setDuration(50L);
            this.f64038f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f64035c.j();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f64035c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f64034b.setAlpha(1.0f);
            this.f64035c.setAlpha(1.0f);
            this.f64033a.setVisibility(0);
            this.f64035c.l();
            this.f64036d.start();
        }
    }
}
