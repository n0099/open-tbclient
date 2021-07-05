package d.a.s0.h2.p;

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
/* loaded from: classes9.dex */
public class e extends d.a.c.k.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f61135f;

    /* renamed from: g  reason: collision with root package name */
    public b f61136g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f61137h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f61138i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f61139e;

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
            this.f61139e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f61139e.f61135f.getContext());
                if (this.f61139e.f61136g != null) {
                    this.f61139e.f61136g.m0(true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f61138i = new a(this);
        this.f61135f = baseFragment;
        this.f61136g = bVar;
    }

    @Override // d.a.c.k.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f61135f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
            this.f44826e = inflate;
            this.f61137h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
            d.a.r0.r.f0.m.a aVar = new d.a.r0.r.f0.m.a();
            BaseFragment baseFragment = this.f61135f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f61137h.setText(this.f61135f.getContext().getResources().getString(R.string.login_see_more));
            }
            this.f61137h.setTextSize(R.dimen.tbds42);
            this.f61137h.setConfig(aVar);
            this.f61137h.setOnClickListener(this.f61138i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f44826e;
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
            d.a.r0.s0.a.a(this.f61135f.getPageContext(), this.f44826e);
            TBSpecificationBtn tBSpecificationBtn = this.f61137h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f44826e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }
}
