package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.repackage.sw8;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class ow8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BottomSheetDialog a;
    public final Context b;
    public final sw8 c;
    public final int d;
    public final String e;
    public ForumWriteData f;
    public String g;
    public ItemInfo h;
    public LinearLayout i;
    public View j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public int t;
    public int u;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public a(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.k(this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public b(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.f(this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public c(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.h(this.a.f, this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public d(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.p(this.a.f, this.a.h);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        public e(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.j(this.a.f, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_HOME_VIDEO, this.a.g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow8 a;

        /* loaded from: classes6.dex */
        public class a implements sw8.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // com.repackage.sw8.d
            public void onSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = this.a.a.f != null ? this.a.a.f.forumId : "0";
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.a.a.e).param("obj_type", 4));
                    if (this.a.a.d != 1) {
                        if (this.a.a.d == 2) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
                }
            }
        }

        public f(ow8 ow8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.dismiss();
                this.a.c.d(this.a.f, new a(this));
            }
        }
    }

    public ow8(Context context, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 3;
        this.b = context;
        this.d = i;
        this.e = str2;
        sw8 sw8Var = new sw8(((TbPageContextSupport) context).getPageContext(), str);
        this.c = sw8Var;
        sw8Var.t(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.b instanceof TbPageContextSupport)) {
            this.a = new BottomSheetDialog(this.b, R.style.obfuscated_res_0x7f1000f9);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08eb, (ViewGroup) null);
            this.i = linearLayout;
            this.j = linearLayout.findViewById(R.id.obfuscated_res_0x7f092539);
            this.k = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f092525);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092527);
            this.m = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092526);
            this.k.setOnClickListener(new a(this));
            this.n = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f09252d);
            this.o = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09252f);
            ((LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f09252e)).setOnClickListener(new b(this));
            this.p = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092521);
            ((LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f092520)).setOnClickListener(new c(this));
            this.q = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092531);
            ((LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f092530)).setOnClickListener(new d(this));
            this.r = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09253c);
            ((LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f09253a)).setOnClickListener(new e(this));
            this.s = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09251f);
            ((LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f09251e)).setOnClickListener(new f(this));
            this.a.setContentView(this.i);
            if (this.a.getWindow() != null && this.a.getWindow().getAttributes() != null) {
                this.u = this.a.getWindow().getAttributes().windowAnimations;
            }
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == null || i == this.t) {
            return;
        }
        vr4 d2 = vr4.d(this.i);
        d2.m(1);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0211);
        vr4 d3 = vr4.d(this.j);
        d3.m(0);
        d3.n(R.string.J_X03);
        d3.f(R.color.CAM_X1112);
        vr4 d4 = vr4.d(this.k);
        d4.m(0);
        d4.n(R.string.J_X06);
        d4.f(R.color.CAM_X0206);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0110);
        this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097d, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0105);
    }

    public void j(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumWriteData) == null) {
            this.f = forumWriteData;
        }
    }

    public void k(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) {
            this.h = itemInfo;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.g = str;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a == null) {
                h();
            }
            if (this.a.getWindow() != null && this.u > 0) {
                this.a.getWindow().setWindowAnimations(this.u);
            }
            this.a.show();
            if (this.a.getWindow() != null) {
                this.a.getWindow().setWindowAnimations(-1);
            }
        }
    }
}
