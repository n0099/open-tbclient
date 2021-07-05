package d.a.s0.v3.h.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends d.a.c.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f68729a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f68730b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.v3.h.h.a f68731c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.v3.h.c.b f68732d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.v3.h.d.a f68733e;

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f68734e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68734e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                d.a.s0.v3.h.e.a aVar = (d.a.s0.v3.h.e.a) this.f68734e.f68732d.getItem(i2);
                if (this.f68734e.f68733e != null) {
                    this.f68734e.f68733e.h(aVar);
                }
                if (this.f68734e.f68731c == null || this.f68734e.f68731c.x() == null) {
                    return;
                }
                this.f68734e.f68731c.x().setFilter(aVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar, d.a.s0.v3.h.h.a aVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68731c = aVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_filter_layout, (ViewGroup) null);
        this.f68729a = inflate;
        inflate.getResources();
        k();
    }

    public d.a.s0.v3.h.e.a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            for (d.a.s0.v3.h.e.a aVar : this.f68732d.a()) {
                if (aVar != null && StringHelper.equals(aVar.f68677c, str)) {
                    return aVar;
                }
            }
            return null;
        }
        return (d.a.s0.v3.h.e.a) invokeL.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f68729a : (View) invokeV.objValue;
    }

    public void i(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f68730b = (HorizontalListView) this.f68729a.findViewById(R.id.edit_filter_horizontal_list);
            this.f68732d = new d.a.s0.v3.h.c.b();
            q(d.a.s0.v3.h.d.a.c(this.f68729a.getContext()));
            this.f68730b.setOnItemClickListener(new a(this));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public void o(d.a.s0.v3.h.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.f68732d.b(aVar);
        }
    }

    public void p(d.a.s0.v3.h.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f68733e = aVar;
        }
    }

    public void q(List<d.a.s0.v3.h.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.f68732d.c(list);
            this.f68730b.setAdapter((ListAdapter) this.f68732d);
        }
    }
}
