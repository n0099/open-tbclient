package d.a.p0.u0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.u0.d1;
import d.a.p0.u0.k2.f;
import java.util.List;
/* loaded from: classes8.dex */
public class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f63043a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f63044b;

    /* renamed from: c  reason: collision with root package name */
    public List<d1> f63045c;

    /* renamed from: d  reason: collision with root package name */
    public View f63046d;

    /* renamed from: e  reason: collision with root package name */
    public View f63047e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f63048f;

    /* renamed from: g  reason: collision with root package name */
    public f f63049g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f63050h;

    /* loaded from: classes8.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f63051a;

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
            this.f63051a = hVar;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, d1 d1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, d1Var) == null) {
                if (this.f63051a.f63049g != null) {
                    this.f63051a.f63049g.c();
                }
                this.f63051a.f63044b.a(d1Var.f62612b);
            }
        }
    }

    public h() {
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
        this.f63050h = new a(this);
    }

    @Override // d.a.p0.u0.k2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f63043a = context;
        this.f63049g = fVar;
        this.f63044b = fVar.d();
        View inflate = LayoutInflater.from(this.f63043a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f63046d = inflate;
        this.f63047e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f63046d.findViewById(R.id.categorycontainer);
        this.f63048f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f63050h);
    }

    @Override // d.a.p0.u0.k2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f63046d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f63046d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.u0.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63046d : (View) invokeV.objValue;
    }

    @Override // d.a.p0.u0.k2.b
    public void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f63045c = list;
        d1 d1Var = new d1();
        d1Var.f62612b = 0;
        d1Var.f62611a = this.f63043a.getResources().getString(R.string.all);
        d1Var.f62613c = false;
        SkinManager.setBackgroundColor(this.f63046d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f63047e, R.color.CAM_X0204);
        this.f63048f.setData(this.f63045c, d1Var);
    }
}
