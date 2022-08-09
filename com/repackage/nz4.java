package com.repackage;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes6.dex */
public class nz4 implements iz4 {
    public static /* synthetic */ Interceptable $ic;
    public static final long e;
    public transient /* synthetic */ FieldHolder $fh;
    public dj5 a;
    public boolean b;
    public int c;
    public int d;

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nz4 nz4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz4Var, Integer.valueOf(i)};
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
            this.a = nz4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (!httpResponsedMessage.isSuccess() || httpResponsedMessage.getError() != 0) {
                    TbadkSettings.getInst().saveBoolean("alert_sign_on", this.a.b);
                    TbadkSettings.getInst().saveInt("alert_sign_hours", this.a.c);
                    TbadkSettings.getInst().saveInt("alert_sign_mins", this.a.d);
                    return;
                }
                this.a.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yi5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ nz4 d;

        public b(nz4 nz4Var, Activity activity, TbPageContext tbPageContext, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz4Var, activity, tbPageContext, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = nz4Var;
            this.a = activity;
            this.b = tbPageContext;
            this.c = viewGroup;
        }

        @Override // com.repackage.yi5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || date == null) {
                return;
            }
            boolean z = false;
            if ("frs.FrsActivity".equals(this.a.getLocalClassName()) && ru4.k().h("first_call_attention", true) && !UbsABTestHelper.isPushOpenNewStyle()) {
                ru4.k().u("first_call_attention", false);
                if (!NotificationManagerCompat.from(this.b.getPageActivity()).areNotificationsEnabled()) {
                    z = true;
                }
            }
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                g05.h(this.b, new boolean[]{true, false}, 2);
            } else if (UbsABTestHelper.isPushOpenNewStyle()) {
            } else {
                this.d.h(true, date.getHours(), date.getMinutes());
                this.d.e(this.a, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ti5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ int b;
        public final /* synthetic */ nz4 c;

        /* loaded from: classes6.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    return true;
                }
                return invokeLL.booleanValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.c.a != null) {
                        this.a.c.a.A();
                        this.a.c.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_OK_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    new mz4(this.a.a).b(this.a.b);
                }
            }
        }

        /* renamed from: com.repackage.nz4$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0541c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public View$OnClickListenerC0541c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.c.a != null) {
                        this.a.c.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_CLOSE_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public c(nz4 nz4Var, TbPageContext tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nz4Var, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nz4Var;
            this.a = tbPageContext;
            this.b = i;
        }

        @Override // com.repackage.ti5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09125a);
                View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f091255);
                View findViewById3 = view2.findViewById(R.id.obfuscated_res_0x7f091256);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907c1);
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
                SkinManager.setBackgroundResource(findViewById2, R.color.CAM_X0211);
                SkinManager.setBackgroundResource(findViewById3, R.drawable.pic_frs_popup_sign);
                SkinManager.setViewTextColor(textView, (int) R.color.select_topbar_icon_white_color_tint);
                SkinManager.setImageResource(imageView, R.drawable.selector_topbar_close_white);
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923b3), (int) R.color.CAM_X0101);
                View findViewById4 = view2.findViewById(R.id.obfuscated_res_0x7f091264);
                SkinManager.setBackgroundColor(findViewById4, R.color.CAM_X0211);
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923b1), (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091e85), (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor((LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092194), R.color.CAM_X0211);
                a aVar = new a(this);
                findViewById.setOnTouchListener(aVar);
                findViewById4.setOnTouchListener(aVar);
                textView.setOnClickListener(new b(this));
                imageView.setOnClickListener(new View$OnClickListenerC0541c(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755452215, "Lcom/repackage/nz4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755452215, "Lcom/repackage/nz4;");
                return;
            }
        }
        e = StringHelper.MS_TO_MIN * 1;
    }

    public nz4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = 12;
        this.d = 0;
        a aVar = new a(this, CmdConfigHttp.CMD_UPDATE_SIGN_DATA);
        aVar.setPriority(-1);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // com.repackage.iz4
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkSettings.getInst().loadBoolean("alert_sign_on", false) : invokeV.booleanValue;
    }

    @Override // com.repackage.iz4
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
            if (loadInt == -1) {
                q();
                return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.iz4
    public void c(int i, TbPageContext tbPageContext, ViewGroup viewGroup) {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, tbPageContext, viewGroup) == null) || tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !tg.e(pageActivity) || lz4.d().D() || ru4.k().l("sign_time_set_dialog", 0) > 0) {
            return;
        }
        i(i, tbPageContext, new b(this, pageActivity, tbPageContext, viewGroup));
        ru4.k().w("sign_time_set_dialog", 1);
    }

    @Override // com.repackage.iz4
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent n = n();
            if (a() && UbsABTestHelper.isUseLocalSignPush()) {
                Calendar calendar = Calendar.getInstance();
                int f = f();
                int i = calendar.get(11);
                int b2 = b();
                int i2 = calendar.get(12);
                calendar.set(11, f);
                calendar.set(12, b2);
                calendar.set(13, 0);
                calendar.set(14, 0);
                if (i >= f && (i != f || i2 >= b2)) {
                    calendar.set(6, calendar.get(6) + 1);
                }
                alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(inst, 0, n, 134217728));
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(inst, 0, n, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
            }
        }
    }

    @Override // com.repackage.iz4
    public NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, activity, viewGroup)) == null) {
            if (activity == null || viewGroup == null) {
                return null;
            }
            View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f091603);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
            navigationBarCoverTip.setId(R.id.obfuscated_res_0x7f091603);
            viewGroup.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
            TextView textView = new TextView(activity);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView.setMinHeight(o(R.dimen.tbds112));
            int o = o(R.dimen.tbds20);
            textView.setPadding(o, 0, o, 0);
            textView.setGravity(17);
            textView.setTextSize(0, o(R.dimen.tbfontsize42));
            textView.setLineSpacing(o(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
            textView.setText(activity.getString(R.string.obfuscated_res_0x7f0f1186));
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
            navigationBarCoverTip.l(activity, textView);
            return navigationBarCoverTip;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    @Override // com.repackage.iz4
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
            if (loadInt == -1) {
                q();
                return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.iz4
    public void g(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            int[] p = p(j);
            if (p == null) {
                s(a(), f(), b());
            } else if (p.length == 2) {
                h(z, p[0], p[1]);
                d();
            }
        }
    }

    @Override // com.repackage.iz4
    public void h(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            s(z, i, i2);
            TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
            TbadkSettings.getInst().saveInt("alert_sign_hours", i);
            TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        }
    }

    @Override // com.repackage.iz4
    public Dialog i(int i, TbPageContext tbPageContext, yi5 yi5Var) {
        InterceptResult invokeILL;
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, tbPageContext, yi5Var)) == null) {
            if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !tg.e(pageActivity)) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            int j = lz4.d().j();
            int k = lz4.d().k();
            if (j > 0 && k > 0) {
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), j, k);
            } else {
                calendar.setTimeInMillis(System.currentTimeMillis() + e);
            }
            ri5 ri5Var = new ri5(pageActivity, yi5Var);
            ri5Var.g(calendar);
            ri5Var.k(R.layout.obfuscated_res_0x7f0d022e, new c(this, tbPageContext, i));
            ri5Var.f(18);
            ri5Var.p(new boolean[]{false, false, false, true, true, false});
            ri5Var.j("年", "月", "日", "时", "分", "秒");
            ri5Var.l(2.0f);
            ri5Var.o(0, 0, 0, 0, 0, 0);
            ri5Var.b(false);
            ri5Var.i(SkinManager.getColor(R.color.CAM_X0204));
            ri5Var.m(SkinManager.getColor(R.color.CAM_X0105));
            ri5Var.n(SkinManager.getColor(R.color.CAM_X0109));
            ri5Var.d(SkinManager.getColor(R.color.black_alpha30));
            ri5Var.e(SkinManager.getColor(R.color.CAM_X0211));
            dj5 a2 = ri5Var.a();
            this.a = a2;
            a2.u();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return this.a.j();
        }
        return (Dialog) invokeILL.objValue;
    }

    public final Intent n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
            intent.setData(Uri.parse("tieba_sign://alert"));
            intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public final int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? qi.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    public final int[] p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            if (j <= 0) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            return new int[]{calendar.get(11), calendar.get(12)};
        }
        return (int[]) invokeJ.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis() + e);
            TbadkSettings.getInst().saveInt("alert_sign_hours", calendar.get(11));
            TbadkSettings.getInst().saveInt("alert_sign_mins", calendar.get(12));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UPDATE_SIGN_DATA, TbConfig.SERVER_ADDRESS + TbConfig.UPDATE_SIGN_DATA);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void s(boolean z, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            r();
            this.b = a();
            this.c = f();
            this.d = b();
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i);
            calendar.set(12, i2);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_UPDATE_SIGN_DATA);
            httpMessage.addParam("sign_push_mask", z ? 1 : 0);
            httpMessage.addParam("sign_push_time_stamp", calendar.getTimeInMillis() / 1000);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
