package d.a.r0.c1.b;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.YoungsterIntroduceActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.view.YoungsterFrsDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import tbclient.FrsPage.TipInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.r0.c1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1236a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f55138e;

        public C1236a(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55138e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.f55138e.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55139e;

        public b(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55139e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f55139e.getPageActivity());
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f55140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55141f;

        public c(d.a.r0.r.s.a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55140e = aVar;
            this.f55141f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486));
                this.f55140e.dismiss();
                this.f55141f.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f55142a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55143b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55144c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2, d.a.r0.r.s.a aVar, TbPageContext tbPageContext, int i3) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), aVar, tbPageContext, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55142a = aVar;
            this.f55143b = tbPageContext;
            this.f55144c = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer ? ((Integer) data).intValue() : 0) != 3) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.f55142a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f55143b.getPageActivity(), 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f55143b.getPageActivity().getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f55143b.getPageActivity().findViewById(this.f55144c));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f55145e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55146f;

        public e(YoungsterFrsDialogView youngsterFrsDialogView, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterFrsDialogView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55145e = youngsterFrsDialogView;
            this.f55146f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.r0.r.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f55145e.b());
                YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(this.f55146f.getPageActivity());
                youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterIntroduceActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f55147e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55148f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f55149g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f55150h;

        public f(YoungsterFrsDialogView youngsterFrsDialogView, TbPageContext tbPageContext, int i2, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {youngsterFrsDialogView, tbPageContext, Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55147e = youngsterFrsDialogView;
            this.f55148f = tbPageContext;
            this.f55149g = i2;
            this.f55150h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.r0.r.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f55147e.b());
                BdTopToast bdTopToast = new BdTopToast(this.f55148f.getPageActivity(), 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f55148f.getPageActivity().getString(R.string.youngster_frs_top_toast));
                bdTopToast.j((ViewGroup) this.f55148f.getPageActivity().findViewById(this.f55149g));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.f55150h.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f55151a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55153c;

        /* renamed from: d.a.r0.c1.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class DialogInterface$OnDismissListenerC1237a implements DialogInterface.OnDismissListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f55154e;

            public DialogInterface$OnDismissListenerC1237a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55154e = gVar;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    g gVar = this.f55154e;
                    a.d(gVar.f55152b, gVar.f55153c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2, d.a.r0.r.s.a aVar, TbPageContext tbPageContext, int i3) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), aVar, tbPageContext, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55151a = aVar;
            this.f55152b = tbPageContext;
            this.f55153c = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.f55151a.dismiss();
                if (d.a.r0.c1.b.d.d(this.f55152b.getPageActivity(), new DialogInterface$OnDismissListenerC1237a(this))) {
                    return;
                }
                a.d(this.f55152b, this.f55153c);
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (d.a.r0.r.d0.b.j().g("key_youngster_frs_dialog_no_tip_again", false) || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            return c(str, null);
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str, d.a.r0.c1.b.b bVar) {
        InterceptResult invokeLL;
        int d2;
        long c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, bVar)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String[] split = str.split(",");
            if (bVar == null) {
                d2 = d.a.r0.r.d0.b.j().k("key_youngster_frs_showed_times", 0);
            } else {
                d2 = bVar.d();
            }
            if (bVar == null) {
                c2 = d.a.r0.r.d0.b.j().l("key_youngster_frs_dialog_show_time", 0L);
            } else {
                c2 = bVar.c();
            }
            int min = Math.min(d2, split.length) - 1;
            if (min < 0 || min >= split.length) {
                return true;
            }
            return System.currentTimeMillis() - c2 > ((long) d.a.c.e.m.b.d(split[min], 0)) * 86400000;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, tbPageContext, i2) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(tbPageContext.getPageActivity());
            YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
            youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_close_title, new b(tbPageContext));
            youngsterFrsDialogView.setRightOnClickListener(R.string.back, new c(aVar, tbPageContext));
            youngsterFrsDialogView.setNoTipAgainViewVisible(false);
            youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_open_title);
            youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_close_message);
            youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.g(tbPageContext.getPageActivity(), R.dimen.tbds95));
            aVar.setContentView(youngsterFrsDialogView);
            aVar.setContentViewSize(5);
            aVar.setCancelable(false);
            aVar.create(tbPageContext).show();
            d dVar = new d(2921484, aVar, tbPageContext, i2);
            if (tbPageContext.getPageActivity() instanceof BaseActivity) {
                dVar.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
            } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                dVar.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(dVar);
        }
    }

    public static void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65540, null, tbPageContext, i2) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(tbPageContext.getPageActivity());
            YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
            youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_open_title, new e(youngsterFrsDialogView, tbPageContext));
            youngsterFrsDialogView.setRightOnClickListener(R.string.youngster_dialog_negative_button, new f(youngsterFrsDialogView, tbPageContext, i2, aVar));
            youngsterFrsDialogView.setNoTipAgainViewVisible(true);
            youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_setting);
            youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_message);
            youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.g(tbPageContext.getPageActivity(), R.dimen.tbds65));
            aVar.setContentView(youngsterFrsDialogView);
            aVar.setContentViewSize(5);
            aVar.setCancelable(false);
            aVar.create(tbPageContext).show();
            d.a.r0.r.d0.b.j().w("key_youngster_frs_dialog_show_time", System.currentTimeMillis());
            int k = d.a.r0.r.d0.b.j().k("key_youngster_frs_showed_times", 0) + 1;
            if (k > 2) {
                k = 2;
            }
            d.a.r0.r.d0.b.j().v("key_youngster_frs_showed_times", k);
            g gVar = new g(2921487, aVar, tbPageContext, i2);
            if (tbPageContext.getPageActivity() instanceof BaseActivity) {
                gVar.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
            } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                gVar.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(gVar);
        }
    }

    public static boolean f(d.a.c.a.f<?> fVar, TipInfo tipInfo, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, fVar, tipInfo, str, str2, str3)) == null) {
            if (fVar == null || tipInfo == null || StringUtils.isNull(tipInfo.tip_pop_title) || StringUtils.isNull(tipInfo.tip_pop)) {
                return false;
            }
            d.a.r0.c1.b.b bVar = new d.a.r0.c1.b.b(str, str2);
            if (c(tipInfo.tip_interval, bVar)) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(fVar.getPageActivity());
                aVar.setTitle(tipInfo.tip_pop_title);
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.setMessage(tipInfo.tip_pop);
                aVar.setPositiveButton(str3, new C1236a(aVar));
                aVar.create(fVar).show();
                bVar.a(System.currentTimeMillis());
                return true;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean g(TbPageContext<?> tbPageContext, AntiData antiData, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, tbPageContext, antiData, i2)) == null) {
            if (antiData != null && antiData.isSexyForum()) {
                if (d.a.r0.c1.b.e.d()) {
                    d(tbPageContext, i2);
                    return true;
                } else if (b(antiData.getTeenModeInterval())) {
                    e(tbPageContext, i2);
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }
}
