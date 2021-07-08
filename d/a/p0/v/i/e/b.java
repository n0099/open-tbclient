package d.a.p0.v.i.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.p0.a0.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class b extends d.a.p0.a0.b<b2> implements z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public RelativeLayout n;
    public b2 o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public RelativeLayout v;
    public final View.OnClickListener w;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f64804e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64804e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64804e.o == null || this.f64804e.h() == null) {
                return;
            }
            this.f64804e.h().a(view, this.f64804e.o);
            TiebaStatic.log(new StatisticItem("c11844").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f64804e.o.Q()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.m = tbPageContext;
        View k = k();
        this.p = k.findViewById(R.id.divider);
        this.q = k.findViewById(R.id.recommend_left_line);
        this.r = k.findViewById(R.id.recommend_right_line);
        this.n = (RelativeLayout) k.findViewById(R.id.ala_live_empty_layout_root);
        this.s = (TextView) k.findViewById(R.id.ala_live_title);
        this.t = (TextView) k.findViewById(R.id.start_live_btn);
        this.v = (RelativeLayout) k.findViewById(R.id.ala_bottom_container);
        this.u = (TextView) k.findViewById(R.id.ala_recommend_live);
    }

    @Override // d.a.p0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // d.a.p0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.frs_ala_video_empty_layout : invokeV.intValue;
    }

    @Override // d.a.p0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f53776e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.ala_live_card_start_live_selector);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
        this.f53776e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    @Override // d.a.p0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.a0.b
    /* renamed from: s */
    public void l(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, b2Var) == null) {
            this.o = b2Var;
            t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.o.e1) {
                this.u.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
                layoutParams.height = l.i(this.m.getPageActivity()) / 4;
                this.v.setLayoutParams(layoutParams);
            } else {
                this.u.setVisibility(0);
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                ViewGroup.LayoutParams layoutParams2 = this.v.getLayoutParams();
                layoutParams2.height = this.m.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
                this.v.setLayoutParams(layoutParams2);
            }
            m(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.t.setOnClickListener(this.w);
        }
    }
}
