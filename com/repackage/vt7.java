package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vt7 extends es7<fp7, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wt7 o;
    public fp7 p;
    public kp7 q;
    public View.OnClickListener r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vt7 a;

        public a(vt7 vt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.p == null || this.a.p.a == null || qb5.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.a.j.getPageContext().getPageActivity());
                return;
            }
            vt7 vt7Var = this.a;
            vt7Var.g0(vt7Var.p);
            if (this.a.p.a.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.j.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.a.p.a.a()) {
                this.a.o.u(this.a.p);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TbImageView b;
        public TextView c;
        public ProgressBar d;
        public TextView e;
        public View f;
        public View.OnClickListener g;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                    return;
                }
                this.a.g.onClick(view2);
            }
        }

        public /* synthetic */ b(View view2, a aVar) {
            this(view2);
        }

        public final void e(Context context, gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, gp7Var) == null) || gp7Var == null) {
                return;
            }
            this.e.setText(gp7Var.c);
            this.b.K(gp7Var.b, 38, false);
            this.a.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0da8, gp7Var.d) + "%");
            int e = jg.e(gp7Var.d, 0);
            if (e > 100) {
                e = 100;
            } else if (e < 0) {
                e = 0;
            }
            this.d.setProgress(e);
            if (gp7Var.a()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0da6);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.btn_pb_ad_card_gift_get);
                this.c.setClickable(true);
            } else if (gp7Var.b()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0dad);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f0803bc);
                this.c.setClickable(true);
            } else {
                this.c.setText(R.string.obfuscated_res_0x7f0f0da7);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f081233);
                this.c.setClickable(false);
            }
            f();
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }

        public void g(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.g = onClickListener;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f09035a);
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e65);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092218);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090403);
            this.d = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f09192a);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09221c);
            this.b.setRadius(li.f(b().getContext(), R.dimen.tbds20));
            this.b.setConrers(5);
            this.b.setDefaultBgResource(R.color.cp_atp_a);
            this.b.setDrawCorner(true);
            this.c.setOnClickListener(new a(this));
            this.d.setMax(100);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vt7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((pw7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.o = new wt7(pbFragment);
    }

    @Override // com.repackage.es7, com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i, view2, viewGroup, (fp7) obj, (b) viewHolder);
        return view2;
    }

    public final void g0(fp7 fp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fp7Var) == null) {
            bf8.g().c(this.j.getUniqueId(), ze8.c(this.q.O(), "a005", "common_click", 1, fp7Var.b, true, fp7Var.a.a + "", null, 18));
        }
    }

    public final void h0(fp7 fp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fp7Var) == null) {
            String str = fp7Var.a.a + "";
            bf8.g().d(this.j.getUniqueId(), ze8.b(this.q.O().getTid(), str, "", null), ze8.d(this.q.O(), "a005", "common_exp", fp7Var.b, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: i0 */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0659, viewGroup, false), null);
            bVar.g(this.r);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View j0(int i, View view2, ViewGroup viewGroup, fp7 fp7Var, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fp7Var, bVar})) == null) {
            super.S(i, view2, viewGroup, fp7Var, bVar);
            if (fp7Var != null && bVar != null) {
                fp7Var.b = i + 1;
                this.p = fp7Var;
                h0(fp7Var);
                bVar.e(this.a, fp7Var.a);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        wt7 wt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (wt7Var = this.o) == null) {
            return;
        }
        wt7Var.q();
    }

    public void t(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, kp7Var) == null) {
            this.q = kp7Var;
            wt7 wt7Var = this.o;
            if (wt7Var != null) {
                wt7Var.v(kp7Var);
            }
        }
    }
}
