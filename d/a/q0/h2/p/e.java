package d.a.q0.h2.p;

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
public class e extends d.a.d.k.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BaseFragment f58466f;

    /* renamed from: g  reason: collision with root package name */
    public b f58467g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f58468h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f58469i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f58470e;

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
            this.f58470e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ViewHelper.skipToLoginActivity(this.f58470e.f58466f.getContext());
                if (this.f58470e.f58467g != null) {
                    this.f58470e.f58467g.p0(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void p0(boolean z);
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
        this.f58469i = new a(this);
        this.f58466f = baseFragment;
        this.f58467g = bVar;
    }

    @Override // d.a.d.k.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f58466f.getContext()).inflate(R.layout.login_see_more_layout, (ViewGroup) null);
            this.f42346e = inflate;
            this.f58468h = (TBSpecificationBtn) inflate.findViewById(R.id.login_button);
            d.a.p0.s.f0.n.a aVar = new d.a.p0.s.f0.n.a();
            BaseFragment baseFragment = this.f58466f;
            if (baseFragment != null && baseFragment.getContext() != null) {
                this.f58468h.setText(this.f58466f.getContext().getResources().getString(R.string.login_see_more));
            }
            this.f58468h.setTextSize(R.dimen.tbds42);
            this.f58468h.setConfig(aVar);
            this.f58468h.setOnClickListener(this.f58469i);
            f(TbadkCoreApplication.getInst().getSkinType());
            return this.f42346e;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.d.k.e.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            d.a.p0.u0.a.a(this.f58466f.getPageContext(), this.f42346e);
            TBSpecificationBtn tBSpecificationBtn = this.f58468h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f42346e.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f58468h.setOnClickListener(onClickListener);
        }
    }
}
