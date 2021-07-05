package d.a.s0.h2.k.e.z0;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CardBoxMemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbAdCardGiftItemResponseMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.s.a;
import d.a.r0.z0.l;
import d.a.s0.h3.w;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f60788a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.h2.h.a f60789b;

    /* renamed from: c  reason: collision with root package name */
    public LikeModel f60790c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.h2.h.e f60791d;

    /* renamed from: e  reason: collision with root package name */
    public AlertDialog f60792e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.a.e f60793f;

    /* renamed from: g  reason: collision with root package name */
    public AntiHelper.k f60794g;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60795a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60795a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof PbAdCardGiftItemResponseMessage)) {
                PbAdCardGiftItemResponseMessage pbAdCardGiftItemResponseMessage = (PbAdCardGiftItemResponseMessage) httpResponsedMessage;
                if (pbAdCardGiftItemResponseMessage.getError() == 0 && pbAdCardGiftItemResponseMessage.getData() != null) {
                    this.f60795a.x(pbAdCardGiftItemResponseMessage.getData());
                } else if (pbAdCardGiftItemResponseMessage.getError() == 502014 || pbAdCardGiftItemResponseMessage.getError() == 502015) {
                    this.f60795a.w(pbAdCardGiftItemResponseMessage.getError(), pbAdCardGiftItemResponseMessage.getErrorString());
                } else {
                    this.f60795a.f60788a.showToast(pbAdCardGiftItemResponseMessage.getErrorString());
                }
            }
        }
    }

    /* renamed from: d.a.s0.h2.k.e.z0.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1471b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60796e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60797f;

        public C1471b(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60797f = bVar;
            this.f60796e = i2;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || l.a()) {
                return;
            }
            if (this.f60796e == 502014) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f60797f.f60788a.getActivity()).createNormalCfg(this.f60797f.f60791d.m().getName(), FrsActivityConfig.FRS_PB_CARD_GIFT);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
            } else if (!this.f60797f.f60788a.checkUpIsLogin()) {
                return;
            } else {
                if (this.f60797f.f60790c == null) {
                    b bVar = this.f60797f;
                    bVar.f60790c = new LikeModel(bVar.f60788a.getPageContext());
                    this.f60797f.f60790c.setLoadDataCallBack(this.f60797f.f60793f);
                }
                this.f60797f.f60790c.setFrom(FrsActivityConfig.FRS_PB_CARD_GIFT);
                this.f60797f.f60790c.L(this.f60797f.f60791d.m().getName(), String.valueOf(this.f60797f.f60791d.m().getId()));
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
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
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60798e;

        public d(b bVar) {
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
            this.f60798e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f60798e.p();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60799a;

        public e(b bVar) {
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
            this.f60799a = bVar;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f60799a.f60791d == null || this.f60799a.f60791d.m() == null || obj == null) {
                return;
            }
            if (AntiHelper.m(this.f60799a.f60790c.getErrorCode(), this.f60799a.f60790c.getErrorString())) {
                if (AntiHelper.t(this.f60799a.f60788a.getContext(), this.f60799a.f60790c.J(), this.f60799a.f60794g) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
                    return;
                }
                return;
            }
            this.f60799a.f60791d.m().getName();
            String id = this.f60799a.f60791d.m().getId();
            w wVar = obj instanceof w ? (w) obj : null;
            boolean z = false;
            boolean z2 = wVar != null && this.f60799a.f60790c.getErrorCode() == 0;
            if (wVar == null || wVar.d() != 3250013) {
                z = z2;
            } else {
                BdToast.h(TbadkCoreApplication.getInst().getContext(), wVar.e(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).q();
            }
            if (wVar == null || !z) {
                if (this.f60799a.f60790c.getErrorCode() != 22) {
                    this.f60799a.f60788a.showToast(this.f60799a.f60790c.getErrorString());
                    return;
                } else {
                    this.f60799a.f60788a.showToast(this.f60799a.f60788a.getPageContext().getPageActivity().getString(R.string.had_liked_forum));
                    return;
                }
            }
            wVar.v(1);
            this.f60799a.f60788a.showToast(this.f60799a.f60788a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_success));
            this.f60799a.t(true, id);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
        }
    }

    /* loaded from: classes9.dex */
    public class f implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(b bVar) {
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
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_BAR));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60800e;

        public g(b bVar) {
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
            this.f60800e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60800e.f60792e.dismiss();
                b bVar = this.f60800e;
                bVar.n(bVar.f60789b);
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f60800e.f60788a.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60801e;

        public h(b bVar) {
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
            this.f60801e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60801e.f60792e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60802e;

        public i(b bVar) {
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
            this.f60802e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f60802e.p();
            }
        }
    }

    public b(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60793f = new e(this);
        this.f60794g = new f(this);
        this.f60788a = pbFragment;
        r();
        s();
    }

    public final void n(d.a.s0.h2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        d.a.s0.g3.c.g().c(this.f60788a.getUniqueId(), d.a.s0.g3.a.e(this.f60791d.N(), "a005", "common_click", 1, aVar.f60124f, true, aVar.f60123e.f60125a + "", "", 19));
    }

    public final void o(d.a.s0.h2.h.a aVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        String n1 = this.f60791d.N().n1();
        d.a.s0.g3.c.g().d(this.f60788a.getUniqueId(), d.a.s0.g3.a.c(n1, str, "", null) + "_dialog", d.a.s0.g3.a.g(this.f60791d.N(), "a005", "common_exp", aVar.f60124f, true, aVar.f60123e.f60125a + "", "", 19));
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LikeModel likeModel = this.f60790c;
            if (likeModel != null) {
                likeModel.I();
            }
            AlertDialog alertDialog = this.f60792e;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f60788a.registerListener(new a(this, CmdConfigHttp.CMD_GET_CARD_GIFT_REQ));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ, TbConfig.SERVER_ADDRESS + TbConfig.PB_CARD_GIFT_GET_URL);
            tbHttpMessageTask.setResponsedClass(PbAdCardGiftItemResponseMessage.class);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void t(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            d.a.s0.i1.t.d.j().g(TbadkCoreApplication.getCurrentAccount(), str, z, null);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void u(d.a.s0.h2.h.a aVar) {
        d.a.s0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || aVar.f60123e == null || (eVar = this.f60791d) == null || eVar.N() == null) {
            return;
        }
        this.f60789b = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_CARD_GIFT_REQ);
        httpMessage.addParam("tid", this.f60791d.N().n1());
        httpMessage.addParam(CardBoxMemberPayActivityConfig.PACKET_ID, aVar.f60123e.f60125a);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f60791d = eVar;
        }
    }

    public final void w(int i2, String str) {
        int i3;
        int i4;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            if (i2 == 502014) {
                i3 = R.string.pb_ad_card_gift_fail_guide_update_level;
                i4 = R.string.cancel;
                string = this.f60788a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_update_level_message);
            } else {
                i3 = R.string.pb_ad_card_gift_fail_guide_attention_bar;
                i4 = R.string.pb_ad_card_gift_fail_guide_attention_bar_cancel;
                string = this.f60788a.getPageContext().getPageActivity().getResources().getString(R.string.pb_ad_card_gift_fail_guide_attention_title, this.f60791d.m().getName());
                str = "";
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f60788a.getPageContext().getPageActivity());
            aVar.setTitle(str);
            aVar.setMessage(string);
            aVar.setPositiveButton(i3, new C1471b(this, i2));
            aVar.setNegativeButton(i4, new c(this));
            aVar.setOnDismissListener(new d(this));
            aVar.setTitleShowCenter(true);
            aVar.setNegativeTextColor(R.color.CAM_X0105);
            aVar.setCanceledOnTouchOutside(true);
            aVar.create(this.f60788a.getPageContext()).show();
        }
    }

    public final void x(d.a.s0.h2.h.b bVar) {
        d.a.s0.h2.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            d.a.s0.h2.h.a aVar2 = this.f60789b;
            if (aVar2 != null) {
                aVar2.f60123e = bVar;
            }
            d.a.s0.h2.h.e eVar = this.f60791d;
            if (eVar != null && (aVar = eVar.l) != null) {
                aVar.f60123e = bVar;
            }
            o(this.f60789b);
            AlertDialog create = new AlertDialog.Builder(this.f60788a.getPageContext().getPageActivity()).create();
            this.f60792e = create;
            create.setCanceledOnTouchOutside(false);
            d.a.c.e.m.g.i(this.f60792e, this.f60788a.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f60788a.getPageContext().getPageActivity()).inflate(R.layout.pb_ad_card_gift_success_dialog, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bg_ad_card_gift_success);
            tbImageView.setRadius(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30));
            tbImageView.setConrers(3);
            tbImageView.setDrawCorner(true);
            tbImageView.M(String.valueOf(R.drawable.pic_popupwindow_gife), 24, false);
            TextView textView = (TextView) inflate.findViewById(R.id.btn_ad_card_gift_success_view);
            textView.setOnClickListener(new g(this));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.btn_ad_card_gift_success_close);
            imageView.setOnClickListener(new h(this));
            TextView textView2 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_card_id);
            TextView textView3 = (TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_title);
            textView3.setText(this.f60788a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_title, new Object[]{bVar.f60127c}));
            textView2.setText(this.f60788a.getPageContext().getPageActivity().getString(R.string.pb_ad_card_gift_success_dialog_card_id, new Object[]{bVar.f60130f}));
            SkinManager.setImageResource(imageView, R.drawable.icon_use_close_n);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0105);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.txt_ad_card_gift_success_tip), R.color.CAM_X0107);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_pb_ad_card_gift_get);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0112);
            this.f60792e.setOnDismissListener(new i(this));
            Window window = this.f60792e.getWindow();
            window.setWindowAnimations(R.style.normal_dialog_style);
            window.setGravity(17);
            window.setLayout(-2, -2);
            window.setContentView(inflate);
        }
    }
}
