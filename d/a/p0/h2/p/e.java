package d.a.p0.h2.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends d.a.c.k.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f57891f;

    /* renamed from: g  reason: collision with root package name */
    public b f57892g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f57893h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f57894i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f57895e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57895e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f57895e.f57891f.getContext());
                if (this.f57895e.f57892g != null) {
                    this.f57895e.f57892g.m0(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void m0(boolean z);
    }

    public e(BaseFragment baseFragment, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57894i = new a(this);
        this.f57891f = baseFragment;
        this.f57892g = bVar;
    }

    @Override // d.a.c.k.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f57891f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
            this.f41842e = inflate;
            this.f57893h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
            d.a.o0.r.f0.n.a aVar = new d.a.o0.r.f0.n.a();
            BaseFragment baseFragment = this.f57891f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f57893h.setText(this.f57891f.getContext().getResources().getString(R.string.login_see_more));
            }
            this.f57893h.setTextSize(R.dimen.tbds42);
            this.f57893h.setConfig(aVar);
            this.f57893h.setOnClickListener(this.f57894i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f41842e;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.c.k.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            d.a.o0.s0.a.a(this.f57891f.getPageContext(), this.f41842e);
            TBSpecificationBtn tBSpecificationBtn = this.f57893h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f41842e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }
}
