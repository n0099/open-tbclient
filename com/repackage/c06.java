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
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
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
import com.repackage.fs4;
import com.repackage.ur4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes5.dex */
public class c06 extends ds4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fs4.e A;
    public TbPageContext k;
    public Context l;
    public final fs4 m;
    public AlertDialog n;
    public AlertDialog o;
    public ur4 p;
    public Dialog q;
    public final List<bs4> r;
    public String s;
    public String t;
    public List<BlueCheckRadioButton> u;
    public ThreadData v;
    public ForumManageModel w;
    public boolean x;
    public final CompoundButton.OnCheckedChangeListener y;
    public final c9 z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public a(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n != null) {
                    this.a.n.dismiss();
                }
                if (!oi.A()) {
                    qi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c3d);
                } else {
                    this.a.i0(null, false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public b(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public c(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (!oi.A()) {
                    qi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c3d);
                    return;
                }
                this.a.i0(null, true);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.v.getId());
                statisticItem.param("fid", this.a.v.getFid());
                statisticItem.param("fname", this.a.v.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public d(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
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

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public e(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tg.b(this.a.q, this.a.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public f(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tg.b(this.a.q, this.a.k);
                c06 c06Var = this.a;
                c06Var.k0(c06Var.t, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public g(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
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

    /* loaded from: classes5.dex */
    public class h extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        /* loaded from: classes5.dex */
        public class a implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || ur4Var == null) {
                    return;
                }
                ur4Var.dismiss();
            }
        }

        public h(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.w == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.a.Y();
            switch (this.a.w.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.d != 0) {
                        if (bVar.h) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.h(false);
                            bdTopToast.g(this.a.Z(R.string.obfuscated_res_0x7f0f1176, new Object[0]));
                            bdTopToast.i(viewGroup);
                            return;
                        }
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.h(false);
                        bdTopToast2.g(this.a.Z(R.string.obfuscated_res_0x7f0f04b0, new Object[0]));
                        bdTopToast2.i(viewGroup);
                        return;
                    } else if (bVar.a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.v.getId()));
                        if (bVar.h) {
                            BdTopToast bdTopToast3 = new BdTopToast(this.a.getContext());
                            bdTopToast3.h(true);
                            bdTopToast3.g(this.a.Z(R.string.obfuscated_res_0x7f0f1178, new Object[0]));
                            bdTopToast3.i(viewGroup);
                            return;
                        }
                        BdTopToast bdTopToast4 = new BdTopToast(this.a.getContext());
                        bdTopToast4.h(true);
                        bdTopToast4.g(this.a.Z(R.string.obfuscated_res_0x7f0f04b9, new Object[0]));
                        bdTopToast4.i(viewGroup);
                        return;
                    } else {
                        String Z = !TextUtils.isEmpty(bVar.b) ? bVar.b : this.a.Z(R.string.obfuscated_res_0x7f0f04b0, new Object[0]);
                        if (bVar.c == 1211066) {
                            if (this.a.p == null) {
                                c06 c06Var = this.a;
                                c06Var.p = new ur4(c06Var.k.getPageActivity());
                                this.a.p.setMessage(Z);
                                this.a.p.setPositiveButton(R.string.obfuscated_res_0x7f0f04ec, new a(this));
                                this.a.p.setCancelable(true);
                                this.a.p.create(this.a.k);
                            }
                            this.a.p.show();
                            return;
                        }
                        BdTopToast bdTopToast5 = new BdTopToast(this.a.getContext());
                        bdTopToast5.h(false);
                        bdTopToast5.g(Z);
                        bdTopToast5.i(viewGroup);
                        return;
                    }
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    if (dVar == null) {
                        qi.N(this.a.l, this.a.Z(R.string.obfuscated_res_0x7f0f0b32, new Object[0]));
                        return;
                    } else if (dVar.a) {
                        qi.N(this.a.l, !TextUtils.isEmpty(dVar.b) ? dVar.b : this.a.Z(R.string.obfuscated_res_0x7f0f0b35, new Object[0]));
                        return;
                    } else {
                        qi.N(this.a.l, !TextUtils.isEmpty(dVar.b) ? dVar.b : this.a.Z(R.string.obfuscated_res_0x7f0f0b32, new Object[0]));
                        return;
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    c06 c06Var2 = this.a;
                    c06Var2.X(c06Var2.w.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    if (gVar == null || !gVar.a) {
                        qi.N(this.a.l, this.a.Z(R.string.obfuscated_res_0x7f0f0d05, new Object[0]));
                        return;
                    } else {
                        this.a.h0(gVar.c);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c06 a;

        public i(c06 c06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c06Var;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.a.dismiss();
                if (!oi.z()) {
                    qi.M(this.a.l, R.string.obfuscated_res_0x7f0f0c3e);
                    return;
                }
                if (i == 1) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.g0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new zk5(1, this.a.w, this.a.v)));
                        }
                    }
                } else if (i == 9) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.f0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new zk5(3, this.a.w, this.a.v)));
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("tid", this.a.v.getId());
                            if (this.a.v.getForumData() != null) {
                                statisticItem.param("fid", this.a.v.getForumData().d());
                                statisticItem.param("fname", this.a.v.getForumData().c());
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
                    this.a.j0();
                } else if (i == 3) {
                    this.a.l0();
                } else if (i == 4) {
                    c06 c06Var = this.a;
                    c06Var.k0(c06Var.s, true);
                } else if (i == 5) {
                    this.a.P();
                } else if (i == 10) {
                    this.a.O();
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_BAWU_MULTI_MUSK_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("tid", this.a.v.getId());
                    statisticItem3.param("fid", this.a.v.getFid());
                    statisticItem3.param("fname", this.a.v.getForum_name());
                    TiebaStatic.log(statisticItem3);
                } else if (i == 6) {
                    this.a.d0();
                } else if (i == 7) {
                    this.a.N();
                } else if (i == 8) {
                    this.a.M();
                }
                this.a.b0(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c06(TbPageContext tbPageContext, boolean z) {
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
                super((d9) newInitContext.callArgs[0]);
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
        fs4 fs4Var = new fs4(this.l);
        this.m = fs4Var;
        fs4Var.q(Z(R.string.obfuscated_res_0x7f0f13ce, new Object[0]));
        this.m.n(this.A);
        ForumManageModel forumManageModel = new ForumManageModel(this.k);
        this.w = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.z);
        this.x = z;
        h(this.m);
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.v));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ke6.h().p(true, false);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            le6.f().o(true);
            le6.f().p(true, false);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.v.getId());
            statisticItem.param("fid", this.v.getFid());
            statisticItem.param("fname", this.v.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            le6.f().o(false);
            le6.f().p(true, false);
        }
    }

    public final BlueCheckRadioButton Q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.l);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, qi.f(this.l, R.dimen.obfuscated_res_0x7f07019a));
            blueCheckRadioButton.setOnCheckedChangeListener(this.y);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void R() {
        List<bs4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.v == null || (list = this.r) == null || this.m == null) {
            return;
        }
        list.clear();
        if (te6.d(te6.a()) && !te6.f()) {
            if (!this.v.isBjh() && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || gg6.isOn()) && !te6.g() && !this.v.isWorksInfo() && !this.v.isScoreThread() && (!this.v.isTiePlusCantDeleteUnion() || this.v.isSelf()))) {
                this.r.add(new bs4(1, Z(R.string.obfuscated_res_0x7f0f04b4, new Object[0]), this.m));
            }
            if (this.v.isWorksInfo() || this.v.isScoreThread() || (te6.g() && !this.v.isBjh() && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || gg6.isOn()))) {
                this.r.add(new bs4(9, Z(R.string.obfuscated_res_0x7f0f06b9, new Object[0]), this.m));
            }
            if (!UtilHelper.isCurrentAccount(this.v.getAuthor() != null ? this.v.getAuthor().getUserId() : "") && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount()) && !this.v.isTiePlusCantDeleteUnion())) {
                this.r.add(new bs4(2, Z(R.string.obfuscated_res_0x7f0f13c9, new Object[0]), this.m));
            }
        }
        if (te6.e() || te6.f()) {
            this.r.add(new bs4(3, Z(this.v.getIs_top() == 1 ? R.string.obfuscated_res_0x7f0f037c : R.string.obfuscated_res_0x7f0f1434, new Object[0]), this.m));
        }
        if (te6.e() || te6.h()) {
            this.r.add(new bs4(4, Z(this.v.getIs_good() == 1 ? R.string.obfuscated_res_0x7f0f0376 : R.string.obfuscated_res_0x7f0f040f, new Object[0]), this.m));
        }
        if (te6.e()) {
            this.r.add(new bs4(6, Z(R.string.obfuscated_res_0x7f0f0744, new Object[0]), this.m));
        }
        if (te6.e() || te6.f()) {
            this.r.add(new bs4(8, Z(R.string.obfuscated_res_0x7f0f06dd, new Object[0]), this.m));
        }
        if (te6.e() && this.x) {
            this.r.add(new bs4(7, Z(R.string.obfuscated_res_0x7f0f072c, new Object[0]), this.m));
        }
        if (!te6.f() && le6.f().j() && this.x && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || gg6.isOn()) && !te6.g())) {
            this.r.add(new bs4(5, Z(R.string.obfuscated_res_0x7f0f0b24, new Object[0]), this.m));
        }
        if (te6.g() && !te6.f() && le6.f().j() && this.x && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || gg6.isOn())) {
            this.r.add(new bs4(10, Z(R.string.obfuscated_res_0x7f0f0b27, new Object[0]), this.m));
        }
        if (te6.g() && this.v.isSelf() && !this.v.isBjh()) {
            this.r.add(new bs4(1, Z(R.string.obfuscated_res_0x7f0f04ab, new Object[0]), this.m));
        }
        this.m.j(this.r);
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            T();
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            V();
            U();
            W();
            dismiss();
        }
    }

    public void U() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alertDialog = this.o) != null && alertDialog.isShowing()) {
            this.o.dismiss();
        }
    }

    public void V() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alertDialog = this.n) != null && alertDialog.isShowing()) {
            this.n.dismiss();
        }
    }

    public void W() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (dialog = this.q) != null && dialog.isShowing()) {
            this.q.dismiss();
        }
    }

    public final void X(int i2, ForumManageModel.g gVar) {
        String Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, gVar) == null) {
            ThreadData threadData = this.v;
            if (threadData != null && gVar != null && gVar.a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    threadData.setIs_good(1);
                    gp4 gp4Var = new gp4();
                    gp4Var.a = 2;
                    gp4Var.b = this.v.getTid();
                    if (te6.e()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, gp4Var));
                    } else {
                        str = a0(gVar.b, R.string.obfuscated_res_0x7f0f1118);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        threadData.setIs_good(0);
                        str = a0(gVar.b, R.string.obfuscated_res_0x7f0f0d06);
                    } else if (i2 == 4) {
                        threadData.setIs_top(1);
                        gp4 gp4Var2 = new gp4();
                        gp4Var2.a = 1;
                        gp4Var2.b = this.v.getTid();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, gp4Var2));
                    } else if (i2 == 5) {
                        threadData.setIs_top(0);
                        str = a0(gVar.b, R.string.obfuscated_res_0x7f0f0d06);
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
                    str = Z(R.string.obfuscated_res_0x7f0f0d06, new Object[0]);
                }
                if (z) {
                    return;
                }
                qi.N(this.l, str);
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                Z = gVar.b;
            } else {
                Z = Z(R.string.obfuscated_res_0x7f0f0d05, new Object[0]);
            }
            qi.N(this.l, Z);
        }
    }

    public final View Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Context context = this.l;
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final String Z(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i2, objArr)) == null) {
            Context context = this.l;
            if (context == null) {
                return null;
            }
            return context.getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public final String a0(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i2)) == null) ? !TextUtils.isEmpty(str) ? str : Z(i2, new Object[0]) : (String) invokeLI.objValue;
    }

    public final void b0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.v == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.v.getFid()).param("tid", this.v.getId()));
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            fs4 fs4Var = this.m;
            if (fs4Var != null) {
                fs4Var.i();
            }
            ur4 ur4Var = this.p;
            if (ur4Var != null) {
                fb5.a(this.k, ur4Var.getRealView());
            }
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.k == null || this.v == null) {
            return;
        }
        BawuThrones b2 = me6.c().b();
        if (b2 == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (ru4.k().h("key_frs_recommend_tip", true)) {
            me6.c().f(this.k, String.valueOf(this.v.getFid()), this.v.getId());
        } else {
            me6.c().d(String.valueOf(this.v.getFid()), this.v.getId());
        }
    }

    public void e0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) {
            this.v = threadData;
            R();
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            U();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1174, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0370, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.k.getPageActivity());
            tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b2c);
            tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b2d);
            tBAlertBuilder.m(true);
            tBAlertBuilder.r(aVar2, aVar);
            tBAlertBuilder.h(false);
            this.o = tBAlertBuilder.w();
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

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            V();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04ab, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0370, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.k.getPageActivity());
            tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f04a4);
            tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f04a5);
            tBAlertBuilder.m(true);
            tBAlertBuilder.r(aVar2, aVar);
            tBAlertBuilder.h(false);
            this.n = tBAlertBuilder.w();
            aVar.a(new a(this));
            aVar2.a(new b(this));
        }
    }

    public final void h0(ArrayList<sp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.q == null) {
                View inflate = LayoutInflater.from(this.l).inflate(R.layout.obfuscated_res_0x7f0d01e2, (ViewGroup) null);
                Dialog dialog = new Dialog(this.l, R.style.obfuscated_res_0x7f1003a7);
                this.q = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.q.setCancelable(true);
                this.q.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.q.getWindow().getAttributes();
                attributes.width = qi.f(this.l, R.dimen.obfuscated_res_0x7f0702db);
                this.q.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.obfuscated_res_0x7f0907a0).setOnClickListener(new e(this));
                inflate.findViewById(R.id.obfuscated_res_0x7f0907a1).setOnClickListener(new f(this));
            }
            fb5.a(this.k, this.q.findViewById(R.id.obfuscated_res_0x7f090679));
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.obfuscated_res_0x7f090cc2);
            linearLayout.removeAllViews();
            this.u = new ArrayList();
            BlueCheckRadioButton Q = Q(this.s, Z(R.string.obfuscated_res_0x7f0f13ca, new Object[0]));
            Q.setChecked(true);
            linearLayout.addView(Q);
            this.u.add(Q);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sp4 sp4Var = arrayList.get(i2);
                    if (sp4Var != null && !TextUtils.isEmpty(sp4Var.b()) && sp4Var.a() > 0) {
                        BlueCheckRadioButton Q2 = Q(String.valueOf(sp4Var.a()), sp4Var.b());
                        this.u.add(Q2);
                        View view2 = new View(this.l);
                        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, qi.f(this.l, R.dimen.obfuscated_res_0x7f070198)));
                        linearLayout.addView(view2);
                        linearLayout.addView(Q2);
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.q.findViewById(R.id.obfuscated_res_0x7f090cc3);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 == 0 || size2 == 1) {
                    layoutParams.height = qi.d(this.l, 120.0f);
                } else if (size2 != 2) {
                    layoutParams.height = qi.d(this.l, 220.0f);
                } else {
                    layoutParams.height = qi.d(this.l, 186.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            tg.j(this.q, this.k);
        }
    }

    public final void i0(JSONArray jSONArray, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, jSONArray, z) == null) || this.w == null || (threadData = this.v) == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = this.v.getAuthor().getUserId();
        String id = this.v.getId();
        String forum_name = this.v.getForum_name();
        String valueOf = String.valueOf(this.v.getFid());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            this.w.U(StringHelper.JsonArrayToString(jSONArray));
        }
        this.w.V(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, this.v.getBaijiahaoData(), z);
    }

    public final void j0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.l == null || (threadData = this.v) == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = this.v.getAuthor().getUserId();
        String userName = this.v.getAuthor().getUserName();
        String name_show = this.v.getAuthor().getName_show();
        String id = this.v.getId();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.l, String.valueOf(this.v.getFid()), this.v.getForum_name(), id, userId, userName, name_show, null, this.v.getAuthor().getPortrait())));
    }

    public final void k0(String str, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, str, z) == null) || (threadData = this.v) == null || this.w == null) {
            return;
        }
        this.w.W(String.valueOf(this.v.getFid()), this.v.getForum_name(), this.v.getId(), threadData.getIs_good() == 1 ? 3 : z ? 6 : 2, str);
    }

    public final void l0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (threadData = this.v) == null || this.w == null) {
            return;
        }
        int i2 = threadData.getIs_top() == 1 ? 5 : 4;
        this.w.W(String.valueOf(this.v.getFid()), this.v.getForum_name(), this.v.getId(), i2, null);
    }
}
