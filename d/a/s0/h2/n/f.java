package d.a.s0.h2.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f60929a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f60930b;

    /* renamed from: c  reason: collision with root package name */
    public int f60931c;

    public f(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60931c = 3;
        this.f60930b = baseFragmentActivity;
    }

    public final void a(d.a.s0.h2.h.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, str) == null) || eVar == null) {
            return;
        }
        if (this.f60929a == null) {
            this.f60929a = new c(LayoutInflater.from(this.f60930b.getPageContext().getPageActivity()).inflate(R.layout.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f60929a.m(eVar, str);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f60929a;
            if (cVar == null) {
                return null;
            }
            return cVar.f60908a;
        }
        return (View) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f60931c == i2) {
            return;
        }
        c cVar = this.f60929a;
        if (cVar != null) {
            cVar.o();
        }
        this.f60931c = i2;
    }

    public void d(d.a.s0.h2.h.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, eVar, str) == null) || eVar == null || eVar.N() == null) {
            return;
        }
        a(eVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) || (cVar = this.f60929a) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(cVar.f60908a);
    }
}
