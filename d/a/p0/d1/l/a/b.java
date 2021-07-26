package d.a.p0.d1.l.a;

import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<LoadingLayout> f52377e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52377e = new HashSet<>();
    }

    public void a(LoadingLayout loadingLayout) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, loadingLayout) == null) || loadingLayout == null) {
            return;
        }
        this.f52377e.add(loadingLayout);
    }

    @Override // d.a.p0.d1.l.a.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.f52377e.iterator();
            while (it.hasNext()) {
                it.next().setLastUpdatedLabel(charSequence);
            }
        }
    }

    @Override // d.a.p0.d1.l.a.a
    public void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) {
            Iterator<LoadingLayout> it = this.f52377e.iterator();
            while (it.hasNext()) {
                it.next().setLoadingDrawable(drawable);
            }
        }
    }

    @Override // d.a.p0.d1.l.a.a
    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.f52377e.iterator();
            while (it.hasNext()) {
                it.next().setPullLabel(charSequence);
            }
        }
    }

    @Override // d.a.p0.d1.l.a.a
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.f52377e.iterator();
            while (it.hasNext()) {
                it.next().setRefreshingLabel(charSequence);
            }
        }
    }

    @Override // d.a.p0.d1.l.a.a
    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            Iterator<LoadingLayout> it = this.f52377e.iterator();
            while (it.hasNext()) {
                it.next().setReleaseLabel(charSequence);
            }
        }
    }
}
