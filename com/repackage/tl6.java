package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.FrsItemTabFragment;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoAlbumLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoBriefLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoDownloadLayout;
import com.baidu.tieba.frs.itemtab.card.CardItemInfoTagLayout;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetMsg;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.km6;
import java.util.List;
import tbclient.ApkDetail;
import tbclient.GameCodeList;
import tbclient.ItemInfo;
/* loaded from: classes7.dex */
public class tl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsItemTabFragment a;
    public CardItemInfoDownloadLayout b;
    public CardItemInfoAlbumLayout c;
    public CardItemInfoTagLayout d;
    public CardItemInfoBriefLayout e;
    public BdTypeRecyclerView f;
    public sl6 g;
    public vl6 h;
    public View i;
    public ItemCardDownloadButton j;
    public TextView k;
    public View l;
    public String m;
    public RecyclerView.OnScrollListener n;
    public CustomMessageListener o;
    public View.OnClickListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public HttpMessageListener s;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(tl6 tl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                mx5.b().e(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB() && i2 > 0) {
                    ni8.r().A(3, 2);
                    ni8.r().G();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tl6 tl6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                int objTypeByDownloadMode = this.a.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    tu4 tu4Var = new tu4(8);
                    tu4Var.o(objTypeByDownloadMode);
                    tu4Var.n(uu4.a(this.a.j.getCurrentItem().buttonLinkType.intValue(), this.a.j.getCurrentItem().apkDetail != null ? this.a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0));
                    tu4Var.l(str);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, tu4Var));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(tl6 tl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, view2));
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f090f60);
                if (tag instanceof su4) {
                    ItemData a = ((su4) tag).a();
                    if (ItemCardHelper.a.equals(a.buttonName) || ItemCardHelper.b.equals(a.buttonName) || ItemCardHelper.f.equals(a.buttonName)) {
                        tu4 tu4Var = new tu4(8);
                        tu4Var.o(uu4.b(a.buttonName));
                        int intValue = a.buttonLinkType.intValue();
                        ApkDetail apkDetail = a.apkDetail;
                        tu4Var.n(uu4.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, tu4Var));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ItemCardDownloadButton.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl6 a;

        public d(tl6 tl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tl6Var;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.download.ItemCardDownloadButton.e
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int objTypeByDownloadMode = this.a.j.getObjTypeByDownloadMode();
                int a = uu4.a(this.a.j.getCurrentItem().buttonLinkType.intValue(), this.a.j.getCurrentItem().apkDetail != null ? this.a.j.getCurrentItem().apkDetail.pkg_source.intValue() : 0);
                if (objTypeByDownloadMode <= 0 || a == 4) {
                    return;
                }
                tu4 tu4Var = new tu4(8);
                tu4Var.o(objTypeByDownloadMode);
                tu4Var.n(a);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, tu4Var));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(tl6 tl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            PlayVoiceBnt playVoiceBnt;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || (view2 = viewHolder.itemView) == null || (playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.obfuscated_res_0x7f090029)) == null) {
                return;
            }
            playVoiceBnt.k();
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(tl6 tl6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.m = (String) customResponsedMessage.getData();
                ItemCardHelper.y(this.a.k, this.a.m);
                this.a.j.setCustomColorBtn(gj8.e(this.a.m));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(tl6 tl6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof jp6)) {
                jp6 jp6Var = (jp6) customResponsedMessage.getData();
                if (jp6Var.b == this.a.a.a) {
                    int i = jp6Var.c;
                    if (i == 0 || i == 2) {
                        jp6Var.a = this.a.i;
                    } else if (i == 1) {
                        jp6Var.a = null;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(tl6 tl6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003516 && this.a.h.c.get(0).getType() == nm6.c) {
                int error = httpResponsedMessage.getError();
                GameCodeGetResponseMsg gameCodeGetResponseMsg = (GameCodeGetResponseMsg) httpResponsedMessage;
                if (httpResponsedMessage.getStatusCode() == 200 && error == 0 && gameCodeGetResponseMsg.errCode == 0) {
                    this.a.s(true, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f078e));
                    sm6 sm6Var = new sm6(((GameCodeGetMsg) httpResponsedMessage.getOrginalMessage()).getPosition(), gameCodeGetResponseMsg.getCodeValue());
                    this.a.t(sm6Var);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921640, sm6Var));
                    return;
                }
                this.a.s(false, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f078d));
            }
        }
    }

    public tl6(FrsItemTabFragment frsItemTabFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsItemTabFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.n = new a(this);
        this.o = new b(this, 2921609);
        this.p = new c(this);
        this.q = new f(this, 2921591);
        this.r = new g(this, 2921590);
        this.s = new h(this, CmdConfigHttp.CMD_GET_GAME_CODE);
        if (frsItemTabFragment == null || view2 == null) {
            return;
        }
        this.a = frsItemTabFragment;
        this.r.setSelfListener(true);
        frsItemTabFragment.getBaseFragmentActivity().registerListener(this.r);
        frsItemTabFragment.registerListener(this.q);
        frsItemTabFragment.registerListener(this.s);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f090ae3);
        ItemCardDownloadButton itemCardDownloadButton = (ItemCardDownloadButton) view2.findViewById(R.id.obfuscated_res_0x7f090ae1);
        this.j = itemCardDownloadButton;
        itemCardDownloadButton.setShadow(R.array.S_O_X003);
        this.j.A();
        this.j.setClickCallback(new d(this));
        this.o.setSelfListener(true);
        this.o.setTag(this.j.getTag());
        MessageManager.getInstance().registerListener(this.o);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ae2);
        this.k = textView;
        textView.setOnClickListener(this.p);
        vr4.d(this.k).u(R.array.S_O_X003);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090b61);
        this.f = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(frsItemTabFragment.getContext()));
        this.f.setFadingEdgeLength(0);
        this.f.setOverScrollMode(2);
        this.f.addOnScrollListener(this.n);
        this.f.setRecyclerListener(new e(this));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
        bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.f.getPaddingBottom());
        this.b = new CardItemInfoDownloadLayout(frsItemTabFragment.getContext());
        this.c = new CardItemInfoAlbumLayout(frsItemTabFragment.getContext());
        this.d = new CardItemInfoTagLayout(frsItemTabFragment.getContext());
        this.e = new CardItemInfoBriefLayout(frsItemTabFragment.getContext());
        this.g = new sl6(frsItemTabFragment, this.f);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.removeHeaderView(this.b);
            this.f.removeHeaderView(this.c);
            this.f.removeHeaderView(this.d);
            this.f.removeHeaderView(this.e);
            vl6 vl6Var = this.h;
            if (vl6Var == null) {
                return;
            }
            if (vl6Var.a != null) {
                this.f.s(this.b);
                this.b.setData(this.h.a);
            }
            if (!ListUtils.isEmpty(this.h.b)) {
                this.f.s(this.c);
                this.c.setData(this.h.b);
            }
            ItemInfo itemInfo = this.h.a;
            if (itemInfo != null && !ListUtils.isEmpty(itemInfo.tag_info)) {
                this.f.s(this.d);
                this.d.setData(this.h.a);
            }
            if (this.h.a != null) {
                this.f.s(this.e);
                this.e.setData(this.h.a);
            }
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            View view2 = this.i;
            view2.setPadding(view2.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), z ? UtilHelper.getDimenPixelSize(R.dimen.tbds200) : this.i.getPaddingBottom());
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sl6 sl6Var = this.g;
            if (sl6Var != null) {
                sl6Var.d();
            }
            this.b.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.c.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.d.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.e.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.j.v();
            vr4 d2 = vr4.d(this.k);
            if (!ItemCardHelper.d.contentEquals(this.k.getText()) && !ItemCardHelper.f.contentEquals(this.k.getText())) {
                this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                d2.n(R.string.J_X01);
                d2.k(R.color.transparent);
                d2.g(gj8.e(this.m));
            } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.k.setTextColor(gj8.a(gj8.e(this.m), tr4.a(R.string.A_X01)));
                d2.l(R.dimen.tbds1);
                d2.t(gj8.a(gj8.e(this.m), tr4.a(R.string.A_X07)));
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0208);
            } else {
                vr4.d(this.k).v(R.color.CAM_X0103);
                d2.l(R.dimen.tbds1);
                d2.k(R.color.CAM_X0209);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0209);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sl6 sl6Var = this.g;
            if (sl6Var != null) {
                sl6Var.f();
            }
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            jp6 jp6Var = new jp6();
            jp6Var.b = z ? this.a.a : 0;
            jp6Var.c = 0;
            CustomMessage customMessage = new CustomMessage(2921590);
            customMessage.setTag(this.a.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921590, jp6Var);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void m(vl6 vl6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vl6Var) == null) || vl6Var == null) {
            return;
        }
        this.h = vl6Var;
        h();
        if (vl6Var.d) {
            km6.b bVar = new km6.b();
            bVar.e(this.m);
            ItemInfo itemInfo = vl6Var.a;
            bVar.d(itemInfo != null ? itemInfo.id.intValue() : 0L);
            this.h.c.add(0, bVar.c());
        }
        if (vl6Var.a != null) {
            ItemData itemData = new ItemData();
            itemData.parseProto(vl6Var.a);
            su4 su4Var = new su4(itemData, 0, "");
            if (ItemCardHelper.w(itemData) && ItemCardHelper.o(itemData)) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setCustomColorBtn(gj8.e(this.m));
                this.j.B();
                this.j.setData(itemData, -1, this.a.e);
                int objTypeByDownloadMode = this.j.getObjTypeByDownloadMode();
                if (objTypeByDownloadMode > 0) {
                    tu4 tu4Var = new tu4(7);
                    tu4Var.o(objTypeByDownloadMode);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, tu4Var));
                }
                r();
            } else {
                ItemCardHelper.m(this.k, su4Var, this.m);
                if (!ItemCardHelper.e.equals(itemData.buttonName)) {
                    vr4 d2 = vr4.d(this.k);
                    if (!ItemCardHelper.d.equals(itemData.buttonName) && !ItemCardHelper.f.equals(itemData.buttonName)) {
                        this.k.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), (int) R.color.CAM_X0101));
                        d2.n(R.string.J_X01);
                        d2.k(R.color.transparent);
                        d2.g(gj8.e(this.m));
                    } else if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                        this.k.setTextColor(gj8.a(gj8.e(this.m), tr4.a(R.string.A_X01)));
                        d2.l(R.dimen.tbds1);
                        d2.t(gj8.a(gj8.e(this.m), tr4.a(R.string.A_X07)));
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0208);
                    } else {
                        vr4.d(this.k).v(R.color.CAM_X0103);
                        d2.l(R.dimen.tbds1);
                        d2.k(R.color.CAM_X0209);
                        d2.n(R.string.J_X01);
                        d2.f(R.color.CAM_X0209);
                    }
                    this.i.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(itemData.buttonName);
                    if (ItemCardHelper.f.equals(itemData.buttonName)) {
                        this.k.setEnabled(false);
                    }
                    r();
                    if (ItemCardHelper.a.equals(itemData.buttonName) || ItemCardHelper.b.equals(itemData.buttonName) || ItemCardHelper.f.equals(itemData.buttonName)) {
                        tu4 tu4Var2 = new tu4(7);
                        tu4Var2.o(uu4.b(itemData.buttonName));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, tu4Var2));
                    }
                }
            }
        }
        this.g.g(vl6Var.c);
        this.g.d();
    }

    public void n(BdUniqueId bdUniqueId) {
        sl6 sl6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) || (sl6Var = this.g) == null) {
            return;
        }
        sl6Var.h(bdUniqueId);
    }

    public void o(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (bdTypeRecyclerView = this.f) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(i);
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.m = str;
        }
    }

    public void q(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bdTypeRecyclerView = this.f) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(z ? 0 : 8);
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l == null) {
                this.l = new View(this.a.getContext());
                this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds200)));
            }
            this.f.setFooterView(this.l);
        }
    }

    public void s(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
            bdTopToast.i(z);
            bdTopToast.h(str);
            bdTopToast.j((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
        }
    }

    public void t(sm6 sm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sm6Var) == null) {
            ((nm6) this.h.c.get(0)).a--;
            List<GameCodeList> list = ((nm6) this.h.c.get(0)).b;
            GameCodeList gameCodeList = list.get(sm6Var.a);
            list.remove(sm6Var.a);
            GameCodeList.Builder builder = new GameCodeList.Builder();
            builder.claimed_status = 2;
            builder.claimed_value = sm6Var.b;
            builder.type = gameCodeList.type;
            builder.label = gameCodeList.label;
            builder.begin_time = gameCodeList.begin_time;
            builder.end_time = gameCodeList.end_time;
            builder.item_id = gameCodeList.item_id;
            builder.list_id = gameCodeList.list_id;
            GameCodeList build = builder.build(false);
            int i = sm6Var.a;
            while (i < list.size() && list.get(i).claimed_status.intValue() == 1) {
                i++;
            }
            while (i < list.size() && list.get(i).end_time.intValue() < build.end_time.intValue() && list.get(i).claimed_status.intValue() == 2) {
                i++;
            }
            list.add(i, build);
            this.g.e();
        }
    }
}
