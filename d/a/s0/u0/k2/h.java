package d.a.s0.u0.k2;

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
import d.a.s0.u0.d1;
import d.a.s0.u0.k2.f;
import java.util.List;
/* loaded from: classes9.dex */
public class h implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66262a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f66263b;

    /* renamed from: c  reason: collision with root package name */
    public List<d1> f66264c;

    /* renamed from: d  reason: collision with root package name */
    public View f66265d;

    /* renamed from: e  reason: collision with root package name */
    public View f66266e;

    /* renamed from: f  reason: collision with root package name */
    public TabMenuPopView f66267f;

    /* renamed from: g  reason: collision with root package name */
    public f f66268g;

    /* renamed from: h  reason: collision with root package name */
    public TabMenuPopView.c f66269h;

    /* loaded from: classes9.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f66270a;

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
            this.f66270a = hVar;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view, d1 d1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, d1Var) == null) {
                if (this.f66270a.f66268g != null) {
                    this.f66270a.f66268g.c();
                }
                this.f66270a.f66263b.a(d1Var.f65831b);
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
        this.f66269h = new a(this);
    }

    @Override // d.a.s0.u0.k2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f66262a = context;
        this.f66268g = fVar;
        this.f66263b = fVar.d();
        View inflate = LayoutInflater.from(this.f66262a).inflate(R.layout.tab_menu_multline_view, (ViewGroup) null);
        this.f66265d = inflate;
        this.f66266e = inflate.findViewById(R.id.top_line);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.f66265d.findViewById(R.id.categorycontainer);
        this.f66267f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.f66269h);
    }

    @Override // d.a.s0.u0.k2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f66265d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.f66265d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // d.a.s0.u0.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66265d : (View) invokeV.objValue;
    }

    @Override // d.a.s0.u0.k2.b
    public void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.f66264c = list;
        d1 d1Var = new d1();
        d1Var.f65831b = 0;
        d1Var.f65830a = this.f66262a.getResources().getString(R.string.all);
        d1Var.f65832c = false;
        SkinManager.setBackgroundColor(this.f66265d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f66266e, R.color.CAM_X0204);
        this.f66267f.setData(this.f66264c, d1Var);
    }
}
