package d.a.p0.e1.b;

import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import tbclient.FrsPage.TipInfo;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.p0.e1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1195a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f52508e;

        public C1195a(d.a.p0.s.s.a aVar) {
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
            this.f52508e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.f52508e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52509e;

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
            this.f52509e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(this.f52509e.getPageActivity());
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterPasswordActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f52510e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52511f;

        public c(d.a.p0.s.s.a aVar, TbPageContext tbPageContext) {
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
            this.f52510e = aVar;
            this.f52511f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486));
                this.f52510e.dismiss();
                this.f52511f.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f52512a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52513b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f52514c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i2, d.a.p0.s.s.a aVar, TbPageContext tbPageContext, int i3) {
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
            this.f52512a = aVar;
            this.f52513b = tbPageContext;
            this.f52514c = i3;
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
                this.f52512a.dismiss();
                BdTopToast bdTopToast = new BdTopToast(this.f52513b.getPageActivity(), 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f52513b.getPageActivity().getString(R.string.youngster_close_title));
                bdTopToast.j((ViewGroup) this.f52513b.getPageActivity().findViewById(this.f52514c));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f52515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52516f;

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
            this.f52515e = youngsterFrsDialogView;
            this.f52516f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.p0.s.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f52515e.b());
                YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(this.f52516f.getPageActivity());
                youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, youngsterIntroduceActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YoungsterFrsDialogView f52517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52518f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52519g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f52520h;

        public f(YoungsterFrsDialogView youngsterFrsDialogView, TbPageContext tbPageContext, int i2, d.a.p0.s.s.a aVar) {
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
            this.f52517e = youngsterFrsDialogView;
            this.f52518f = tbPageContext;
            this.f52519g = i2;
            this.f52520h = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.p0.s.d0.b.j().t("key_youngster_frs_dialog_no_tip_again", this.f52517e.b());
                BdTopToast bdTopToast = new BdTopToast(this.f52518f.getPageActivity(), 2000);
                bdTopToast.i(true);
                bdTopToast.h(this.f52518f.getPageActivity().getString(R.string.youngster_frs_top_toast));
                bdTopToast.j((ViewGroup) this.f52518f.getPageActivity().findViewById(this.f52519g));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.f52520h.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f52521a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52522b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f52523c;

        /* renamed from: d.a.p0.e1.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class DialogInterface$OnDismissListenerC1196a implements DialogInterface.OnDismissListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f52524e;

            public DialogInterface$OnDismissListenerC1196a(g gVar) {
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
                this.f52524e = gVar;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    g gVar = this.f52524e;
                    a.d(gVar.f52522b, gVar.f52523c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2, d.a.p0.s.s.a aVar, TbPageContext tbPageContext, int i3) {
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
            this.f52521a = aVar;
            this.f52522b = tbPageContext;
            this.f52523c = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921588));
                this.f52521a.dismiss();
                if (d.a.p0.e1.b.d.d(this.f52522b.getPageActivity(), new DialogInterface$OnDismissListenerC1196a(this))) {
                    return;
                }
                a.d(this.f52522b, this.f52523c);
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (d.a.p0.s.d0.b.j().g("key_youngster_frs_dialog_no_tip_again", false) || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            return c(str, null);
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str, d.a.p0.e1.b.b bVar) {
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
                d2 = d.a.p0.s.d0.b.j().k("key_youngster_frs_showed_times", 0);
            } else {
                d2 = bVar.d();
            }
            if (bVar == null) {
                c2 = d.a.p0.s.d0.b.j().l("key_youngster_frs_dialog_show_time", 0L);
            } else {
                c2 = bVar.c();
            }
            int min = Math.min(d2, split.length) - 1;
            if (min < 0 || min >= split.length) {
                return true;
            }
            return System.currentTimeMillis() - c2 > ((long) d.a.d.e.m.b.d(split[min], 0)) * 86400000;
        }
        return invokeLL.booleanValue;
    }

    public static void d(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, tbPageContext, i2) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(tbPageContext.getPageActivity());
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
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, i2) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(tbPageContext.getPageActivity());
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
            d.a.p0.s.d0.b.j().w("key_youngster_frs_dialog_show_time", System.currentTimeMillis());
            int k = d.a.p0.s.d0.b.j().k("key_youngster_frs_showed_times", 0) + 1;
            if (k > 2) {
                k = 2;
            }
            d.a.p0.s.d0.b.j().v("key_youngster_frs_showed_times", k);
            g gVar = new g(2921487, aVar, tbPageContext, i2);
            if (tbPageContext.getPageActivity() instanceof BaseActivity) {
                gVar.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
            } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
                gVar.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
            }
            MessageManager.getInstance().registerListener(gVar);
        }
    }

    public static boolean f(d.a.d.a.f<?> fVar, TipInfo tipInfo, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.AD_TEXT_ID, null, fVar, tipInfo, str, str2, str3)) == null) {
            if (fVar == null || tipInfo == null || StringUtils.isNull(tipInfo.tip_pop_title) || StringUtils.isNull(tipInfo.tip_pop)) {
                return false;
            }
            d.a.p0.e1.b.b bVar = new d.a.p0.e1.b.b(str, str2);
            if (c(tipInfo.tip_interval, bVar)) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(fVar.getPageActivity());
                aVar.setTitle(tipInfo.tip_pop_title);
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.setMessage(tipInfo.tip_pop);
                aVar.setPositiveButton(str3, new C1195a(aVar));
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
                if (d.a.p0.e1.b.e.d()) {
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
