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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class gx4 implements bx4 {
    public static /* synthetic */ Interceptable $ic;
    public static final long b;
    public transient /* synthetic */ FieldHolder $fh;
    public pf5 a;

    /* loaded from: classes6.dex */
    public class a implements kf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ gx4 d;

        public a(gx4 gx4Var, Activity activity, TbPageContext tbPageContext, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx4Var, activity, tbPageContext, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gx4Var;
            this.a = activity;
            this.b = tbPageContext;
            this.c = viewGroup;
        }

        @Override // com.repackage.kf5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || date == null) {
                return;
            }
            boolean z = false;
            if ("frs.FrsActivity".equals(this.a.getLocalClassName()) && ys4.k().h("first_call_attention", true) && !UbsABTestHelper.isPushOpenNewStyle()) {
                ys4.k().u("first_call_attention", false);
                if (!NotificationManagerCompat.from(this.b.getPageActivity()).areNotificationsEnabled()) {
                    z = true;
                }
            }
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                zx4.h(this.b, new boolean[]{true, false}, 2);
            } else if (UbsABTestHelper.isPushOpenNewStyle()) {
            } else {
                this.d.i(true);
                ex4.d().W(date.getHours(), date.getMinutes());
                this.d.e(this.a, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ gx4 b;

        /* loaded from: classes6.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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

        /* renamed from: com.repackage.gx4$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0436b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public View$OnClickListenerC0436b(b bVar) {
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
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.b.a != null) {
                        this.a.b.a.B();
                        this.a.b.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_OK_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    new fx4(this.a.a).b();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public c(b bVar) {
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
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.b.a != null) {
                        this.a.b.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_CLOSE_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public b(gx4 gx4Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx4Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gx4Var;
            this.a = tbPageContext;
        }

        @Override // com.repackage.ff5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09118f);
                View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f09118a);
                View findViewById3 = view2.findViewById(R.id.obfuscated_res_0x7f09118b);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907a5);
                ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090785);
                SkinManager.setBackgroundResource(findViewById2, R.color.CAM_X0211);
                SkinManager.setBackgroundResource(findViewById3, R.drawable.pic_frs_popup_sign);
                SkinManager.setViewTextColor(textView, (int) R.color.select_topbar_icon_white_color_tint);
                SkinManager.setImageResource(imageView, R.drawable.selector_topbar_close_white);
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ff), (int) R.color.CAM_X0101);
                View findViewById4 = view2.findViewById(R.id.obfuscated_res_0x7f091199);
                SkinManager.setBackgroundColor(findViewById4, R.color.CAM_X0211);
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921fd), (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf6), (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor((LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ff0), R.color.CAM_X0211);
                a aVar = new a(this);
                findViewById.setOnTouchListener(aVar);
                findViewById4.setOnTouchListener(aVar);
                textView.setOnClickListener(new View$OnClickListenerC0436b(this));
                imageView.setOnClickListener(new c(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755662674, "Lcom/repackage/gx4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755662674, "Lcom/repackage/gx4;");
                return;
            }
        }
        b = StringHelper.MS_TO_MIN * 1;
    }

    public gx4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.bx4
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkSettings.getInst().loadBoolean("alert_sign_on", false) : invokeV.booleanValue;
    }

    @Override // com.repackage.bx4
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
            if (loadInt == -1) {
                m();
                return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.bx4
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent k = k();
            if (a()) {
                Calendar calendar = Calendar.getInstance();
                int h = h();
                int i = calendar.get(11);
                int b2 = b();
                int i2 = calendar.get(12);
                calendar.set(11, h);
                calendar.set(12, b2);
                calendar.set(13, 0);
                calendar.set(14, 0);
                if (i >= h && (i != h || i2 >= b2)) {
                    calendar.set(6, calendar.get(6) + 1);
                }
                alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(inst, 0, k, 134217728));
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(inst, 0, k, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
            }
        }
    }

    @Override // com.repackage.bx4
    public Dialog d(TbPageContext tbPageContext, kf5 kf5Var) {
        InterceptResult invokeLL;
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tbPageContext, kf5Var)) == null) {
            if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !og.e(pageActivity)) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            int j = ex4.d().j();
            int k = ex4.d().k();
            if (j > 0 && k > 0) {
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), j, k);
            } else {
                calendar.setTimeInMillis(System.currentTimeMillis() + b);
            }
            df5 df5Var = new df5(pageActivity, kf5Var);
            df5Var.g(calendar);
            df5Var.k(R.layout.obfuscated_res_0x7f0d022f, new b(this, tbPageContext));
            df5Var.f(18);
            df5Var.p(new boolean[]{false, false, false, true, true, false});
            df5Var.j("年", "月", "日", "时", "分", "秒");
            df5Var.l(2.0f);
            df5Var.o(0, 0, 0, 0, 0, 0);
            df5Var.b(false);
            df5Var.i(SkinManager.getColor(R.color.CAM_X0204));
            df5Var.m(SkinManager.getColor(R.color.CAM_X0105));
            df5Var.n(SkinManager.getColor(R.color.CAM_X0109));
            df5Var.d(SkinManager.getColor(R.color.black_alpha30));
            df5Var.e(SkinManager.getColor(R.color.CAM_X0211));
            pf5 a2 = df5Var.a();
            this.a = a2;
            a2.v();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return this.a.j();
        }
        return (Dialog) invokeLL.objValue;
    }

    @Override // com.repackage.bx4
    public NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, activity, viewGroup)) == null) {
            if (activity == null || viewGroup == null) {
                return null;
            }
            View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f0914d1);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
            navigationBarCoverTip.setId(R.id.obfuscated_res_0x7f0914d1);
            viewGroup.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
            TextView textView = new TextView(activity);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView.setMinHeight(l(R.dimen.tbds112));
            int l = l(R.dimen.tbds20);
            textView.setPadding(l, 0, l, 0);
            textView.setGravity(17);
            textView.setTextSize(0, l(R.dimen.tbfontsize42));
            textView.setLineSpacing(l(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
            textView.setText(activity.getString(R.string.obfuscated_res_0x7f0f1199));
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
            navigationBarCoverTip.l(activity, textView);
            return navigationBarCoverTip;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    @Override // com.repackage.bx4
    public void f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, viewGroup) == null) || tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !og.e(pageActivity) || ex4.d().C() || ys4.k().l("sign_time_set_dialog", 0) > 0) {
            return;
        }
        d(tbPageContext, new a(this, pageActivity, tbPageContext, viewGroup));
        ys4.k().w("sign_time_set_dialog", 1);
    }

    @Override // com.repackage.bx4
    public void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            TbadkSettings.getInst().saveInt("alert_sign_hours", i);
            TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
            c();
        }
    }

    @Override // com.repackage.bx4
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
            if (loadInt == -1) {
                m();
                return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.bx4
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
            c();
        }
    }

    public Intent k() {
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

    public final int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? li.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis() + b);
            g(calendar.get(11), calendar.get(12));
        }
    }
}
