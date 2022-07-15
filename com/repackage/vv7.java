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
public class vv7 extends du7<er7, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wv7 o;
    public er7 p;
    public jr7 q;
    public View.OnClickListener r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv7 a;

        public a(vv7 vv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.p == null || this.a.p.a == null || gd5.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.a.j.getPageContext().getPageActivity());
                return;
            }
            vv7 vv7Var = this.a;
            vv7Var.g0(vv7Var.p);
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

        public final void e(Context context, fr7 fr7Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fr7Var) == null) || fr7Var == null) {
                return;
            }
            this.e.setText(fr7Var.c);
            this.b.J(fr7Var.b, 38, false);
            this.a.setText(context.getResources().getString(R.string.obfuscated_res_0x7f0f0da2, fr7Var.d) + "%");
            int e = ng.e(fr7Var.d, 0);
            if (e > 100) {
                e = 100;
            } else if (e < 0) {
                e = 0;
            }
            this.d.setProgress(e);
            if (fr7Var.a()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0da0);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.btn_pb_ad_card_gift_get);
                this.c.setClickable(true);
            } else if (fr7Var.b()) {
                this.c.setText(R.string.obfuscated_res_0x7f0f0da7);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.c, R.drawable.obfuscated_res_0x7f0803bc);
                this.c.setClickable(true);
            } else {
                this.c.setText(R.string.obfuscated_res_0x7f0f0da1);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                this.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f0811a4);
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
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f09035f);
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e64);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922ba);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0903ff);
            this.d = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f0919ca);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922be);
            this.b.setRadius(pi.f(b().getContext(), R.dimen.tbds20));
            this.b.setConrers(5);
            this.b.setDefaultBgResource(R.color.cp_atp_a);
            this.b.setDrawCorner(true);
            this.c.setOnClickListener(new a(this));
            this.d.setMax(100);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv7(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((qy7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.o = new wv7(pbFragment);
    }

    @Override // com.repackage.du7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i, view2, viewGroup, (er7) obj, (b) viewHolder);
        return view2;
    }

    public final void g0(er7 er7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, er7Var) == null) {
            pg8.g().c(this.j.getUniqueId(), ng8.c(this.q.O(), "a005", "common_click", 1, er7Var.b, true, er7Var.a.a + "", null, 18));
        }
    }

    public final void h0(er7 er7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, er7Var) == null) {
            String str = er7Var.a.a + "";
            pg8.g().d(this.j.getUniqueId(), ng8.b(this.q.O().getTid(), str, "", null), ng8.d(this.q.O(), "a005", "common_exp", er7Var.b, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: i0 */
    public b M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0672, viewGroup, false), null);
            bVar.g(this.r);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View j0(int i, View view2, ViewGroup viewGroup, er7 er7Var, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, er7Var, bVar})) == null) {
            super.S(i, view2, viewGroup, er7Var, bVar);
            if (er7Var != null && bVar != null) {
                er7Var.b = i + 1;
                this.p = er7Var;
                h0(er7Var);
                bVar.e(this.a, er7Var.a);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void onDestroy() {
        wv7 wv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (wv7Var = this.o) == null) {
            return;
        }
        wv7Var.q();
    }

    public void s(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jr7Var) == null) {
            this.q = jr7Var;
            wv7 wv7Var = this.o;
            if (wv7Var != null) {
                wv7Var.v(jr7Var);
            }
        }
    }
}
