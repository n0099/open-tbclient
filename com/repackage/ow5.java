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
import com.repackage.dq4;
import com.repackage.oq4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes6.dex */
public class ow5 extends mq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final oq4.e A;
    public TbPageContext k;
    public Context l;
    public final oq4 m;
    public AlertDialog n;
    public AlertDialog o;
    public dq4 p;
    public Dialog q;
    public final List<kq4> r;
    public String s;
    public String t;
    public List<BlueCheckRadioButton> u;
    public ThreadData v;
    public ForumManageModel w;
    public boolean x;
    public final CompoundButton.OnCheckedChangeListener y;
    public final a9 z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public a(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.n != null) {
                    this.a.n.dismiss();
                }
                if (!ji.A()) {
                    li.N(this.a.l, R.string.obfuscated_res_0x7f0f0c33);
                } else {
                    this.a.k0(null, false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public b(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
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

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public c(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.o != null) {
                    this.a.o.dismiss();
                }
                if (!ji.A()) {
                    li.N(this.a.l, R.string.obfuscated_res_0x7f0f0c33);
                    return;
                }
                this.a.k0(null, true);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_SELF_DIALOG_CONFIRM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", this.a.v.getId());
                statisticItem.param("fid", this.a.v.getFid());
                statisticItem.param("fname", this.a.v.getForum_name());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public d(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
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

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public e(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                og.b(this.a.q, this.a.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public f(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                og.b(this.a.q, this.a.k);
                ow5 ow5Var = this.a;
                ow5Var.m0(ow5Var.t, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public g(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
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

    /* loaded from: classes6.dex */
    public class h extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        /* loaded from: classes6.dex */
        public class a implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || dq4Var == null) {
                    return;
                }
                dq4Var.dismiss();
            }
        }

        public h(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.w == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) this.a.a0();
            switch (this.a.w.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.d != 0) {
                        if (bVar.h) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.i(false);
                            bdTopToast.h(this.a.b0(R.string.obfuscated_res_0x7f0f1189, new Object[0]));
                            bdTopToast.j(viewGroup);
                            return;
                        }
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(this.a.b0(R.string.obfuscated_res_0x7f0f04a9, new Object[0]));
                        bdTopToast2.j(viewGroup);
                        return;
                    } else if (bVar.a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, this.a.v.getId()));
                        if (bVar.h) {
                            BdTopToast bdTopToast3 = new BdTopToast(this.a.getContext());
                            bdTopToast3.i(true);
                            bdTopToast3.h(this.a.b0(R.string.obfuscated_res_0x7f0f118b, new Object[0]));
                            bdTopToast3.j(viewGroup);
                            return;
                        }
                        BdTopToast bdTopToast4 = new BdTopToast(this.a.getContext());
                        bdTopToast4.i(true);
                        bdTopToast4.h(this.a.b0(R.string.obfuscated_res_0x7f0f04b2, new Object[0]));
                        bdTopToast4.j(viewGroup);
                        return;
                    } else {
                        String b0 = !TextUtils.isEmpty(bVar.b) ? bVar.b : this.a.b0(R.string.obfuscated_res_0x7f0f04a9, new Object[0]);
                        if (bVar.c == 1211066) {
                            if (this.a.p == null) {
                                ow5 ow5Var = this.a;
                                ow5Var.p = new dq4(ow5Var.k.getPageActivity());
                                this.a.p.setMessage(b0);
                                this.a.p.setPositiveButton(R.string.obfuscated_res_0x7f0f04e8, new a(this));
                                this.a.p.setCancelable(true);
                                this.a.p.create(this.a.k);
                            }
                            this.a.p.show();
                            return;
                        }
                        BdTopToast bdTopToast5 = new BdTopToast(this.a.getContext());
                        bdTopToast5.i(false);
                        bdTopToast5.h(b0);
                        bdTopToast5.j(viewGroup);
                        return;
                    }
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    if (dVar == null) {
                        li.O(this.a.l, this.a.b0(R.string.obfuscated_res_0x7f0f0b2d, new Object[0]));
                        return;
                    } else if (dVar.a) {
                        li.O(this.a.l, !TextUtils.isEmpty(dVar.b) ? dVar.b : this.a.b0(R.string.obfuscated_res_0x7f0f0b30, new Object[0]));
                        return;
                    } else {
                        li.O(this.a.l, !TextUtils.isEmpty(dVar.b) ? dVar.b : this.a.b0(R.string.obfuscated_res_0x7f0f0b2d, new Object[0]));
                        return;
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    ow5 ow5Var2 = this.a;
                    ow5Var2.Z(ow5Var2.w.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    if (gVar == null || !gVar.a) {
                        li.O(this.a.l, this.a.b0(R.string.obfuscated_res_0x7f0f0cf9, new Object[0]));
                        return;
                    } else {
                        this.a.j0(gVar.c);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ow5 a;

        public i(ow5 ow5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ow5Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                this.a.dismiss();
                if (!ji.z()) {
                    li.N(this.a.l, R.string.obfuscated_res_0x7f0f0c34);
                    return;
                }
                if (i == 1) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.i0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new mh5(1, this.a.w, this.a.v)));
                        }
                    }
                } else if (i == 9) {
                    if (this.a.v != null && this.a.v.getAuthor() != null) {
                        if (UtilHelper.isCurrentAccount(this.a.v.getAuthor().getUserId())) {
                            this.a.h0();
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new mh5(3, this.a.w, this.a.v)));
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
                    this.a.l0();
                } else if (i == 3) {
                    this.a.n0();
                } else if (i == 4) {
                    ow5 ow5Var = this.a;
                    ow5Var.m0(ow5Var.s, true);
                } else if (i == 5) {
                    this.a.R();
                } else if (i == 10) {
                    this.a.Q();
                    StatisticItem statisticItem3 = new StatisticItem(CommonStatisticKey.KEY_BAWU_MULTI_MUSK_CLICK);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem3.param("tid", this.a.v.getId());
                    statisticItem3.param("fid", this.a.v.getFid());
                    statisticItem3.param("fname", this.a.v.getForum_name());
                    TiebaStatic.log(statisticItem3);
                } else if (i == 6) {
                    this.a.f0();
                } else if (i == 7) {
                    this.a.P();
                } else if (i == 8) {
                    this.a.O();
                }
                this.a.d0(i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow5(TbPageContext tbPageContext, boolean z) {
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
        oq4 oq4Var = new oq4(this.l);
        this.m = oq4Var;
        oq4Var.q(b0(R.string.obfuscated_res_0x7f0f13da, new Object[0]));
        this.m.n(this.A);
        ForumManageModel forumManageModel = new ForumManageModel(this.k);
        this.w = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.z);
        this.x = z;
        i(this.m);
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.v));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            va6.h().p(true, false);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            wa6.f().o(true);
            wa6.f().p(true, false);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_MULTI_MUSK_VIEW_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", this.v.getId());
            statisticItem.param("fid", this.v.getFid());
            statisticItem.param("fname", this.v.getForum_name());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wa6.f().o(false);
            wa6.f().p(true, false);
        }
    }

    public final BlueCheckRadioButton S(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.l);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, li.f(this.l, R.dimen.obfuscated_res_0x7f07019a));
            blueCheckRadioButton.setOnCheckedChangeListener(this.y);
            blueCheckRadioButton.setTag(str);
            blueCheckRadioButton.setText(str2);
            blueCheckRadioButton.setLayoutParams(layoutParams);
            return blueCheckRadioButton;
        }
        return (BlueCheckRadioButton) invokeLL.objValue;
    }

    public final void T() {
        List<kq4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.v == null || (list = this.r) == null || this.m == null) {
            return;
        }
        list.clear();
        if (eb6.d(eb6.a()) && !eb6.f()) {
            if (!this.v.isBjh() && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || rc6.isOn()) && !eb6.g() && !this.v.isWorksInfo() && !this.v.isScoreThread() && (!this.v.isTiePlusCantDeleteUnion() || this.v.isSelf()))) {
                this.r.add(new kq4(1, b0(R.string.obfuscated_res_0x7f0f04ad, new Object[0]), this.m));
            }
            if (this.v.isWorksInfo() || this.v.isScoreThread() || (eb6.g() && !this.v.isBjh() && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || rc6.isOn()))) {
                this.r.add(new kq4(9, b0(R.string.obfuscated_res_0x7f0f06b1, new Object[0]), this.m));
            }
            if (!UtilHelper.isCurrentAccount(this.v.getAuthor() != null ? this.v.getAuthor().getUserId() : "") && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount()) && !this.v.isTiePlusCantDeleteUnion())) {
                this.r.add(new kq4(2, b0(R.string.obfuscated_res_0x7f0f13d5, new Object[0]), this.m));
            }
        }
        if (eb6.e() || eb6.f()) {
            this.r.add(new kq4(3, b0(this.v.getIs_top() == 1 ? R.string.obfuscated_res_0x7f0f0381 : R.string.obfuscated_res_0x7f0f143e, new Object[0]), this.m));
        }
        if (eb6.e() || eb6.h()) {
            this.r.add(new kq4(4, b0(this.v.getIs_good() == 1 ? R.string.obfuscated_res_0x7f0f037b : R.string.obfuscated_res_0x7f0f040d, new Object[0]), this.m));
        }
        if (eb6.e()) {
            this.r.add(new kq4(6, b0(R.string.obfuscated_res_0x7f0f073a, new Object[0]), this.m));
        }
        if (eb6.e() || eb6.f()) {
            this.r.add(new kq4(8, b0(R.string.obfuscated_res_0x7f0f06d3, new Object[0]), this.m));
        }
        if (eb6.e() && this.x) {
            this.r.add(new kq4(7, b0(R.string.obfuscated_res_0x7f0f0722, new Object[0]), this.m));
        }
        if (!eb6.f() && wa6.f().j() && this.x && ((this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || rc6.isOn()) && !eb6.g())) {
            this.r.add(new kq4(5, b0(R.string.obfuscated_res_0x7f0f0b1f, new Object[0]), this.m));
        }
        if (eb6.g() && !eb6.f() && wa6.f().j() && this.x && (this.v.getAuthor() == null || !this.v.getAuthor().isForumBusinessAccount() || this.v.isSelf() || rc6.isOn())) {
            this.r.add(new kq4(10, b0(R.string.obfuscated_res_0x7f0f0b22, new Object[0]), this.m));
        }
        if (eb6.g() && this.v.isSelf() && !this.v.isBjh()) {
            this.r.add(new kq4(1, b0(R.string.obfuscated_res_0x7f0f04a4, new Object[0]), this.m));
        }
        this.m.j(this.r);
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            V();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            X();
            W();
            Y();
            dismiss();
        }
    }

    public void W() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (alertDialog = this.o) != null && alertDialog.isShowing()) {
            this.o.dismiss();
        }
    }

    public void X() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alertDialog = this.n) != null && alertDialog.isShowing()) {
            this.n.dismiss();
        }
    }

    public void Y() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (dialog = this.q) != null && dialog.isShowing()) {
            this.q.dismiss();
        }
    }

    public final void Z(int i2, ForumManageModel.g gVar) {
        String b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, gVar) == null) {
            ThreadData threadData = this.v;
            if (threadData != null && gVar != null && gVar.a) {
                String str = "";
                boolean z = true;
                if (i2 == 2) {
                    threadData.setIs_good(1);
                    pn4 pn4Var = new pn4();
                    pn4Var.a = 2;
                    pn4Var.b = this.v.getTid();
                    if (eb6.e()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, pn4Var));
                    } else {
                        str = c0(gVar.b, R.string.obfuscated_res_0x7f0f111f);
                        z = false;
                    }
                } else {
                    if (i2 == 3) {
                        threadData.setIs_good(0);
                        str = c0(gVar.b, R.string.obfuscated_res_0x7f0f0cfa);
                    } else if (i2 == 4) {
                        threadData.setIs_top(1);
                        pn4 pn4Var2 = new pn4();
                        pn4Var2.a = 1;
                        pn4Var2.b = this.v.getTid();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, pn4Var2));
                    } else if (i2 == 5) {
                        threadData.setIs_top(0);
                        str = c0(gVar.b, R.string.obfuscated_res_0x7f0f0cfa);
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
                    str = b0(R.string.obfuscated_res_0x7f0f0cfa, new Object[0]);
                }
                if (z) {
                    return;
                }
                li.O(this.l, str);
                return;
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                b0 = gVar.b;
            } else {
                b0 = b0(R.string.obfuscated_res_0x7f0f0cf9, new Object[0]);
            }
            li.O(this.l, b0);
        }
    }

    public final View a0() {
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

    public final String b0(int i2, Object... objArr) {
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

    public final String c0(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i2)) == null) ? !TextUtils.isEmpty(str) ? str : b0(i2, new Object[0]) : (String) invokeLI.objValue;
    }

    public final void d0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.v == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.v.getFid()).param("tid", this.v.getId()));
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            oq4 oq4Var = this.m;
            if (oq4Var != null) {
                oq4Var.i();
            }
            dq4 dq4Var = this.p;
            if (dq4Var != null) {
                q85.a(this.k, dq4Var.getRealView());
            }
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.k == null || this.v == null) {
            return;
        }
        BawuThrones b2 = xa6.c().b();
        if (b2 == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (ys4.k().h("key_frs_recommend_tip", true)) {
            xa6.c().f(this.k, String.valueOf(this.v.getFid()), this.v.getId());
        } else {
            xa6.c().d(String.valueOf(this.v.getFid()), this.v.getId());
        }
    }

    public void g0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) {
            this.v = threadData;
            T();
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            W();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1187, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0376, TBAlertConfig.OperateBtnStyle.SECONDARY);
            rq4 rq4Var = new rq4(this.k.getPageActivity());
            rq4Var.u(R.string.obfuscated_res_0x7f0f0b27);
            rq4Var.l(R.string.obfuscated_res_0x7f0f0b28);
            rq4Var.n(true);
            rq4Var.r(aVar2, aVar);
            rq4Var.i(false);
            this.o = rq4Var.x();
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

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            X();
            if (this.k == null) {
                return;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04a4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0376, TBAlertConfig.OperateBtnStyle.SECONDARY);
            rq4 rq4Var = new rq4(this.k.getPageActivity());
            rq4Var.u(R.string.obfuscated_res_0x7f0f049d);
            rq4Var.l(R.string.obfuscated_res_0x7f0f049e);
            rq4Var.n(true);
            rq4Var.r(aVar2, aVar);
            rq4Var.i(false);
            this.n = rq4Var.x();
            aVar.a(new a(this));
            aVar2.a(new b(this));
        }
    }

    public final void j0(ArrayList<bo4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) {
            if (this.q == null) {
                View inflate = LayoutInflater.from(this.l).inflate(R.layout.obfuscated_res_0x7f0d01e4, (ViewGroup) null);
                Dialog dialog = new Dialog(this.l, R.style.obfuscated_res_0x7f10039f);
                this.q = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.q.setCancelable(true);
                this.q.setContentView(inflate);
                WindowManager.LayoutParams attributes = this.q.getWindow().getAttributes();
                attributes.width = li.f(this.l, R.dimen.obfuscated_res_0x7f0702de);
                this.q.getWindow().setAttributes(attributes);
                inflate.findViewById(R.id.obfuscated_res_0x7f090783).setOnClickListener(new e(this));
                inflate.findViewById(R.id.obfuscated_res_0x7f090784).setOnClickListener(new f(this));
            }
            q85.a(this.k, this.q.findViewById(R.id.obfuscated_res_0x7f090677));
            LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.obfuscated_res_0x7f090c8f);
            linearLayout.removeAllViews();
            this.u = new ArrayList();
            BlueCheckRadioButton S = S(this.s, b0(R.string.obfuscated_res_0x7f0f13d6, new Object[0]));
            S.setChecked(true);
            linearLayout.addView(S);
            this.u.add(S);
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bo4 bo4Var = arrayList.get(i2);
                    if (bo4Var != null && !TextUtils.isEmpty(bo4Var.b()) && bo4Var.a() > 0) {
                        BlueCheckRadioButton S2 = S(String.valueOf(bo4Var.a()), bo4Var.b());
                        this.u.add(S2);
                        View view2 = new View(this.l);
                        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, li.f(this.l, R.dimen.obfuscated_res_0x7f070198)));
                        linearLayout.addView(view2);
                        linearLayout.addView(S2);
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                    }
                }
                ScrollView scrollView = (ScrollView) this.q.findViewById(R.id.obfuscated_res_0x7f090c90);
                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                int size2 = arrayList.size();
                if (size2 == 0 || size2 == 1) {
                    layoutParams.height = li.d(this.l, 120.0f);
                } else if (size2 != 2) {
                    layoutParams.height = li.d(this.l, 220.0f);
                } else {
                    layoutParams.height = li.d(this.l, 186.0f);
                }
                scrollView.setLayoutParams(layoutParams);
                scrollView.removeAllViews();
                scrollView.addView(linearLayout);
            }
            og.j(this.q, this.k);
        }
    }

    public final void k0(JSONArray jSONArray, boolean z) {
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
            this.w.T(StringHelper.JsonArrayToString(jSONArray));
        }
        this.w.U(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, this.v.getBaijiahaoData(), z);
    }

    public final void l0() {
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

    public final void m0(String str, boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, str, z) == null) || (threadData = this.v) == null || this.w == null) {
            return;
        }
        this.w.V(String.valueOf(this.v.getFid()), this.v.getForum_name(), this.v.getId(), threadData.getIs_good() == 1 ? 3 : z ? 6 : 2, str);
    }

    public final void n0() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (threadData = this.v) == null || this.w == null) {
            return;
        }
        int i2 = threadData.getIs_top() == 1 ? 5 : 4;
        this.w.V(String.valueOf(this.v.getFid()), this.v.getForum_name(), this.v.getId(), i2, null);
    }
}
