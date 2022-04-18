package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.nr4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes7.dex */
public class ux5 extends lr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final nr4.e A;
    public TbPageContext k;
    public Context l;
    public final nr4 m;
    public AlertDialog n;
    public AlertDialog o;
    public cr4 p;
    public Dialog q;
    public final List<jr4> r;
    public String s;
    public String t;
    public List<BlueCheckRadioButton> u;
    public ThreadData v;
    public ForumManageModel w;
    public boolean x;
    public final CompoundButton.OnCheckedChangeListener y;
    public final a9 z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public a(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n != null) {
                    this.a.n.dismiss();
                }
                if (!mi.A()) {
                    oi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c17);
                } else {
                    this.a.m0(null, false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public b(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.n == null) {
                return;
            }
            this.a.n.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public c(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (!mi.A()) {
                    oi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c17);
                    return;
                }
                this.a.m0(null, true);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.v.getId());
                statisticItem.param("fid", this.a.v.getFid());
                statisticItem.param("fname", this.a.v.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public d(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CANCEL_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.v.getId());
                statisticItem.param("fid", this.a.v.getFid());
                statisticItem.param("fname", this.a.v.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public e(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                rg.b(this.a.q, this.a.k);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public f(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                rg.b(this.a.q, this.a.k);
                ux5 ux5Var = this.a;
                ux5Var.o0(ux5Var.t, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public g(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z && (compoundButton.getTag() instanceof String)) {
                this.a.t = (String) compoundButton.getTag();
                if (this.a.u != null) {
                    for (BlueCheckRadioButton blueCheckRadioButton : this.a.u) {
                        String str = (String) blueCheckRadioButton.getTag();
                        if (str != null && this.a.t != null && !str.equals(this.a.t)) {
                            blueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        /* loaded from: classes7.dex */
        public class a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) || cr4Var == null) {
                    return;
                }
                cr4Var.dismiss();
            }
        }

        public h(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.w == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.a.c0();
            switch (this.a.w.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.d != 0) {
                        if (bVar.h) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.i(false);
                            bdTopToast.h(this.a.d0(R.string.obfuscated_res_0x7f0f115b, new Object[0]));
                            bdTopToast.j(viewGroup);
                            return;
                        }
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(this.a.d0(R.string.obfuscated_res_0x7f0f049a, new Object[0]));
                        bdTopToast2.j(viewGroup);
                        return;
                    } else if (bVar.a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.v.getId()));
                        if (bVar.h) {
                            BdTopToast bdTopToast3 = new BdTopToast(this.a.getContext());
                            bdTopToast3.i(true);
                            bdTopToast3.h(this.a.d0(R.string.obfuscated_res_0x7f0f115d, new Object[0]));
                            bdTopToast3.j(viewGroup);
                            return;
                        }
                        BdTopToast bdTopToast4 = new BdTopToast(this.a.getContext());
                        bdTopToast4.i(true);
                        bdTopToast4.h(this.a.d0(R.string.obfuscated_res_0x7f0f04a3, new Object[0]));
                        bdTopToast4.j(viewGroup);
                        return;
                    } else {
                        String d0 = !TextUtils.isEmpty(bVar.b) ? bVar.b : this.a.d0(R.string.obfuscated_res_0x7f0f049a, new Object[0]);
                        if (bVar.c == 1211066) {
                            if (this.a.p == null) {
                                ux5 ux5Var = this.a;
                                ux5Var.p = new cr4(ux5Var.k.getPageActivity());
                                this.a.p.setMessage(d0);
                                this.a.p.setPositiveButton(R.string.obfuscated_res_0x7f0f04db, new a(this));
                                this.a.p.setCancelable(true);
                                this.a.p.create(this.a.k);
                            }
                            this.a.p.show();
                            return;
                        }
                        BdTopToast bdTopToast5 = new BdTopToast(this.a.getContext());
                        bdTopToast5.i(false);
                        bdTopToast5.h(d0);
                        bdTopToast5.j(viewGroup);
                        return;
                    }
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    if (dVar == null) {
                        oi.N(this.a.l, this.a.d0(R.string.obfuscated_res_0x7f0f0b16, new Object[0]));
                        return;
                    } else if (dVar.a) {
                        oi.N(this.a.l, !TextUtils.isEmpty(dVar.b) ? dVar.b : this.a.d0(R.string.obfuscated_res_0x7f0f0b19, new Object[0]));
                        return;
                    } else {
                        oi.N(this.a.l, !TextUtils.isEmpty(dVar.b) ? dVar.b : this.a.d0(R.string.obfuscated_res_0x7f0f0b16, new Object[0]));
                        return;
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    ux5 ux5Var2 = this.a;
                    ux5Var2.b0(ux5Var2.w.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    if (gVar == null || !gVar.a) {
                        oi.N(this.a.l, this.a.d0(R.string.obfuscated_res_0x7f0f0cdb, new Object[0]));
                        return;
                    } else if (gVar.c.size() != 0) {
                        this.a.l0(gVar.c);
                        return;
                    } else {
                        ux5 ux5Var3 = this.a;
                        ux5Var3.a0(ux5Var3.w.getLoadDataMode(), gVar);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public i(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.a.dismiss();
                if (!mi.z()) {
                    oi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c18);
                    return;
                }
                if (i == 1) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.k0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new zh5(1, this.a.w, this.a.v)));
                        }
                    }
                } else if (i == 9) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.j0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new zh5(3, this.a.w, this.a.v)));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("tid", this.a.v.getId());
                            if (this.a.v.getForumData() != null) {
                                statisticItem.param("fid", this.a.v.getForumData().b());
                                statisticItem.param("fname", this.a.v.getForumData().a());
                            }
                            statisticItem.param("obj_source", 1);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_BAWU_FRS_MUSK_CLICK);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem2.param("tid", this.a.v.getId());
                        statisticItem2.param("fid", this.a.v.getFid());
                        statisticItem2.param("fname", this.a.v.getForum_name());
                        TiebaStatic.log(statisticItem2);
                    }
                } else if (i == 2) {
                    this.a.n0();
                } else if (i == 3) {
                    this.a.p0();
                } else if (i == 4) {
                    ux5 ux5Var = this.a;
                    ux5Var.o0(ux5Var.s, true);
                } else if (i == 5) {
                    this.a.S();
                } else if (i == 10) {
                    this.a.R();
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_BAWU_MULTI_MUSK_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("tid", this.a.v.getId());
                    statisticItem3.param("fid", this.a.v.getFid());
                    statisticItem3.param("fname", this.a.v.getForum_name());
                    TiebaStatic.log(statisticItem3);
                } else if (i == 6) {
                    this.a.h0();
                } else if (i == 7) {
                    this.a.Q();
                } else if (i == 8) {
                    this.a.P();
                }
                this.a.f0(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ux5(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = "0";
        this.t = "0";
        this.x = false;
        this.y = new g(this);
        this.z = new h(this);
        this.A = new i(this);
        this.k = tbPageContext;
        this.l = tbPageContext.getPageActivity();
        this.r = new ArrayList();
        nr4 nr4Var = new nr4(this.l);
        this.m = nr4Var;
        nr4Var.q(d0(R.string.obfuscated_res_0x7f0f13a3, new Object[0]));
        this.m.n(this.A);
        ForumManageModel forumManageModel = new ForumManageModel(this.k);
        this.w = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.z);
        this.x = z;
        i(this.m);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.v));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ad6.h().p(true, false);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            bd6.f().o(true);
            bd6.f().p(true, false);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.v.getId());
            statisticItem.param("fid", this.v.getFid());
            statisticItem.param("fname", this.v.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bd6.f().o(false);
            bd6.f().p(true, false);
        }
    }

    public final BlueCheckRadioButton T(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.l);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, oi.f(this.l, R.dimen.obfuscated_res_0x7f07019a));
            blueCheckRadioButton.setOnCheckedChangeListener(this.y);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void U() {
        List<jr4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.v == null || (list = this.r) == null || this.m == null) {
            return;
        }
        list.clear();
        if (jd6.d(jd6.a()) && !jd6.f()) {
            if (!this.v.isBjh() && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || we6.isOn()) && !jd6.g() && !this.v.isWorksInfo() && !this.v.isScoreThread() && (!this.v.isTiePlusCantDeleteUnion() || this.v.isSelf()))) {
                this.r.add(new jr4(1, d0(R.string.obfuscated_res_0x7f0f049e, new Object[0]), this.m));
            }
            if (this.v.isWorksInfo() || this.v.isScoreThread() || (jd6.g() && !this.v.isBjh() && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || we6.isOn()))) {
                this.r.add(new jr4(9, d0(R.string.obfuscated_res_0x7f0f06a2, new Object[0]), this.m));
            }
            if (!UtilHelper.isCurrentAccount(this.v.getAuthor() != null ? this.v.getAuthor().getUserId() : "") && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount()) && !this.v.isTiePlusCantDeleteUnion())) {
                this.r.add(new jr4(2, d0(R.string.obfuscated_res_0x7f0f139e, new Object[0]), this.m));
            }
        }
        if (jd6.e() || jd6.f()) {
            this.r.add(new jr4(3, d0(this.v.getIs_top() == 1 ? R.string.obfuscated_res_0x7f0f0379 : R.string.obfuscated_res_0x7f0f1404, new Object[0]), this.m));
        }
        if (jd6.e() || jd6.h()) {
            this.r.add(new jr4(4, d0(this.v.getIs_good() == 1 ? R.string.obfuscated_res_0x7f0f0373 : R.string.obfuscated_res_0x7f0f0404, new Object[0]), this.m));
        }
        if (jd6.e()) {
            this.r.add(new jr4(6, d0(R.string.obfuscated_res_0x7f0f072b, new Object[0]), this.m));
        }
        if (jd6.e() || jd6.f()) {
            this.r.add(new jr4(8, d0(R.string.obfuscated_res_0x7f0f06c3, new Object[0]), this.m));
        }
        if (jd6.e() && this.x) {
            this.r.add(new jr4(7, d0(R.string.obfuscated_res_0x7f0f0712, new Object[0]), this.m));
        }
        if (!jd6.f() && bd6.f().j() && this.x && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || we6.isOn()) && !jd6.g())) {
            this.r.add(new jr4(5, d0(R.string.obfuscated_res_0x7f0f0b08, new Object[0]), this.m));
        }
        if (jd6.g() && !jd6.f() && bd6.f().j() && this.x && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || we6.isOn())) {
            this.r.add(new jr4(10, d0(R.string.obfuscated_res_0x7f0f0b0b, new Object[0]), this.m));
        }
        if (jd6.g() && this.v.isSelf() && !this.v.isBjh()) {
            this.r.add(new jr4(1, d0(R.string.obfuscated_res_0x7f0f0495, new Object[0]), this.m));
        }
        this.m.j(this.r);
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            W();
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Y();
            X();
            Z();
            dismiss();
        }
    }

    public void X() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alertDialog = this.o) != null && alertDialog.isShowing()) {
            this.o.dismiss();
        }
    }

    public void Y() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alertDialog = this.n) != null && alertDialog.isShowing()) {
            this.n.dismiss();
        }
    }

    public void Z() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (dialog = this.q) != null && dialog.isShowing()) {
            this.q.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0(int i2, ForumManageModel.g gVar) {
        String d0;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(1048587, this, i2, gVar) != null) {
            return;
        }
        ThreadData threadData = this.v;
        if (threadData != null && gVar != null && gVar.a) {
            boolean z = true;
            String str = "";
            if (i2 == 6) {
                threadData.setIs_good(1);
                qo4 qo4Var = new qo4();
                qo4Var.a = 2;
                qo4Var.b = this.v.getTid();
                if (jd6.e()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, qo4Var));
                    ForumManageModel.e eVar = new ForumManageModel.e();
                    eVar.a = this.v.getId();
                    eVar.c = this.v.getForum_name();
                    eVar.b = String.valueOf(this.v.getFid());
                    eVar.d = i2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                    if (TextUtils.isEmpty(str)) {
                        str = d0(R.string.obfuscated_res_0x7f0f0cdc, new Object[0]);
                    }
                    if (z) {
                        oi.N(this.l, str);
                        return;
                    }
                    return;
                }
                str = e0(gVar.b, R.string.obfuscated_res_0x7f0f10f4);
            }
            z = false;
            ForumManageModel.e eVar2 = new ForumManageModel.e();
            eVar2.a = this.v.getId();
            eVar2.c = this.v.getForum_name();
            eVar2.b = String.valueOf(this.v.getFid());
            eVar2.d = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar2));
            if (TextUtils.isEmpty(str)) {
            }
            if (z) {
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                d0 = gVar.b;
            } else {
                d0 = d0(R.string.obfuscated_res_0x7f0f0cdb, new Object[0]);
            }
            oi.N(this.l, d0);
        }
    }

    public final void b0(int i2, ForumManageModel.g gVar) {
        String d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, gVar) == null) {
            ThreadData threadData = this.v;
            if (threadData != null && gVar != null && gVar.a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    threadData.setIs_good(1);
                    qo4 qo4Var = new qo4();
                    qo4Var.a = 2;
                    qo4Var.b = this.v.getTid();
                    if (jd6.e()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, qo4Var));
                    } else {
                        str = e0(gVar.b, R.string.obfuscated_res_0x7f0f10f4);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        threadData.setIs_good(0);
                        str = e0(gVar.b, R.string.obfuscated_res_0x7f0f0cdc);
                    } else if (i2 == 4) {
                        threadData.setIs_top(1);
                        qo4 qo4Var2 = new qo4();
                        qo4Var2.a = 1;
                        qo4Var2.b = this.v.getTid();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, qo4Var2));
                    } else if (i2 == 5) {
                        threadData.setIs_top(0);
                        str = e0(gVar.b, R.string.obfuscated_res_0x7f0f0cdc);
                    }
                    z = false;
                }
                ForumManageModel.e eVar = new ForumManageModel.e();
                eVar.a = this.v.getId();
                eVar.c = this.v.getForum_name();
                eVar.b = String.valueOf(this.v.getFid());
                eVar.d = i2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
                if (TextUtils.isEmpty(str)) {
                    str = d0(R.string.obfuscated_res_0x7f0f0cdc, new Object[0]);
                }
                if (z) {
                    return;
                }
                oi.N(this.l, str);
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                d0 = gVar.b;
            } else {
                d0 = d0(R.string.obfuscated_res_0x7f0f0cdb, new Object[0]);
            }
            oi.N(this.l, d0);
        }
    }

    public final View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.l;
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final String d0(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, objArr)) == null) {
            Context context = this.l;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final String e0(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i2)) == null) ? !TextUtils.isEmpty(str) ? str : d0(i2, new Object[0]) : (String) invokeLI.objValue;
    }

    public final void f0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.v == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.v.getFid()).param("tid", this.v.getId()));
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            nr4 nr4Var = this.m;
            if (nr4Var != null) {
                nr4Var.i();
            }
            cr4 cr4Var = this.p;
            if (cr4Var != null) {
                f95.a(this.k, cr4Var.getRealView());
            }
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.k == null || this.v == null) {
            return;
        }
        BawuThrones b2 = cd6.c().b();
        if (b2 == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (vt4.k().h("key_frs_recommend_tip", true)) {
            cd6.c().f(this.k, String.valueOf(this.v.getFid()), this.v.getId());
        } else {
            cd6.c().d(String.valueOf(this.v.getFid()), this.v.getId());
        }
    }

    public void i0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) {
            this.v = threadData;
            U();
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            X();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1159, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
            qr4 qr4Var = new qr4(this.k.getPageActivity());
            qr4Var.v(R.string.obfuscated_res_0x7f0f0b10);
            qr4Var.l(R.string.obfuscated_res_0x7f0f0b11);
            qr4Var.n(true);
            qr4Var.r(aVar2, aVar);
            qr4Var.i(false);
            this.o = qr4Var.y();
            aVar.a(new c(this));
            aVar2.a(new d(this));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.v.getId());
            statisticItem.param("fid", this.v.getFid());
            statisticItem.param("fname", this.v.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Y();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0495, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
            qr4 qr4Var = new qr4(this.k.getPageActivity());
            qr4Var.v(R.string.obfuscated_res_0x7f0f048e);
            qr4Var.l(R.string.obfuscated_res_0x7f0f048f);
            qr4Var.n(true);
            qr4Var.r(aVar2, aVar);
            qr4Var.i(false);
            this.n = qr4Var.y();
            aVar.a(new a(this));
            aVar2.a(new b(this));
        }
    }

    public final void l0(ArrayList<cp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            if (this.q == null) {
                View inflate = LayoutInflater.from(this.l).inflate(R.layout.obfuscated_res_0x7f0d01f2, (ViewGroup) null);
                Dialog dialog = new Dialog(this.l, R.style.obfuscated_res_0x7f10039f);
                this.q = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.q.setCancelable(true);
                this.q.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.q.getWindow().getAttributes();
                attributes.width = oi.f(this.l, R.dimen.obfuscated_res_0x7f0702de);
                this.q.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.obfuscated_res_0x7f0907a1).setOnClickListener(new e(this));
                inflate.findViewById(R.id.obfuscated_res_0x7f0907a2).setOnClickListener(new f(this));
            }
            f95.a(this.k, this.q.findViewById(R.id.obfuscated_res_0x7f09069b));
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.obfuscated_res_0x7f090cdf);
            linearLayout.removeAllViews();
            this.u = new ArrayList();
            BlueCheckRadioButton T = T(this.s, d0(R.string.obfuscated_res_0x7f0f139f, new Object[0]));
            T.setChecked(true);
            linearLayout.addView(T);
            this.u.add(T);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    cp4 cp4Var = arrayList.get(i2);
                    if (cp4Var != null && !TextUtils.isEmpty(cp4Var.b()) && cp4Var.a() > 0) {
                        BlueCheckRadioButton T2 = T(String.valueOf(cp4Var.a()), cp4Var.b());
                        this.u.add(T2);
                        View view2 = new View(this.l);
                        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, oi.f(this.l, R.dimen.obfuscated_res_0x7f070198)));
                        linearLayout.addView(view2);
                        linearLayout.addView(T2);
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.q.findViewById(R.id.obfuscated_res_0x7f090ce0);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 == 0 || size2 == 1) {
                    layoutParams.height = oi.d(this.l, 120.0f);
                } else if (size2 != 2) {
                    layoutParams.height = oi.d(this.l, 220.0f);
                } else {
                    layoutParams.height = oi.d(this.l, 186.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            rg.j(this.q, this.k);
        }
    }

    public final void m0(JSONArray jSONArray, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, jSONArray, z) == null) || this.w == null || (threadData = this.v) == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = this.v.getAuthor().getUserId();
        String id = this.v.getId();
        String forum_name = this.v.getForum_name();
        String valueOf = String.valueOf(this.v.getFid());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            this.w.T(StringHelper.JsonArrayToString(jSONArray));
        }
        this.w.U(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, this.v.getBaijiahaoData(), z);
    }

    public final void n0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.l == null || (threadData = this.v) == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = this.v.getAuthor().getUserId();
        String userName = this.v.getAuthor().getUserName();
        String name_show = this.v.getAuthor().getName_show();
        String id = this.v.getId();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.l, String.valueOf(this.v.getFid()), this.v.getForum_name(), id, userId, userName, name_show, null, this.v.getAuthor().getPortrait())));
    }

    public final void o0(String str, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, str, z) == null) || (threadData = this.v) == null || this.w == null) {
            return;
        }
        this.w.V(String.valueOf(this.v.getFid()), this.v.getForum_name(), this.v.getId(), threadData.getIs_good() == 1 ? 3 : z ? 6 : 2, str);
    }

    public final void p0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (threadData = this.v) == null || this.w == null) {
            return;
        }
        int i2 = threadData.getIs_top() == 1 ? 5 : 4;
        this.w.V(String.valueOf(this.v.getFid()), this.v.getForum_name(), this.v.getId(), i2, null);
    }
}
