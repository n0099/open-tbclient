package d.a.q0.q2;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f62346a;

    /* renamed from: b  reason: collision with root package name */
    public View f62347b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeListView f62348c;

    /* renamed from: d  reason: collision with root package name */
    public NoDataView f62349d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.f0.h f62350e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f62351f;

    /* renamed from: g  reason: collision with root package name */
    public d f62352g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f62353h;

    /* renamed from: i  reason: collision with root package name */
    public AbsListView.OnScrollListener f62354i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f62355e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62355e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && d.a.d.e.p.j.A()) {
                if (this.f62355e.f62350e != null) {
                    this.f62355e.f62350e.dettachView(this.f62355e.f62347b);
                    this.f62355e.f62350e = null;
                }
                if (this.f62355e.f62352g != null) {
                    this.f62355e.f62352g.onNoNetRefresh();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f62356e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62356e = hVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.f62356e.f62351f.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 1) {
                this.f62356e.f62351f.c();
            }
        }
    }

    public h(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62349d = null;
        this.f62353h = new a(this);
        this.f62354i = new b(this);
        this.f62346a = context;
        this.f62347b = view;
        this.f62348c = (BdTypeListView) view.findViewById(R.id.list);
        this.f62351f = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.f62348c.setOnScrollListener(this.f62354i);
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62348c : (BdTypeListView) invokeV.objValue;
    }

    public d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62352g : (d) invokeV.objValue;
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f62352g = dVar;
        }
    }

    public void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
            f.b(this.f62350e, this.f62353h, this.f62346a, this.f62347b, str, z);
            this.f62348c.setVisibility(8);
        }
    }
}
