package com.repackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.inserting.NadInsertingBaseView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tg0;
import java.util.List;
/* loaded from: classes7.dex */
public class xb7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean m = true;
    public static volatile xb7 n;
    public static boolean o;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;
    public Activity b;
    public View c;
    public NadInsertingBaseView d;
    public RoundRelativeLayout e;
    public RoundRelativeLayout f;
    public ImageView g;
    public boolean h;
    public boolean i;
    public c j;
    public boolean k;
    public sg0 l;

    /* loaded from: classes7.dex */
    public class a implements sg0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xb7 a;

        public a(xb7 xb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xb7Var;
        }

        @Override // com.repackage.sg0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.sg0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.sg0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
                statisticItem.param("obj_type", "a002").param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.repackage.sg0
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.g != null) {
                    this.a.g.setVisibility(8);
                }
                this.a.j();
                this.a.d = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.TRUE));
                if (this.a.h) {
                    this.a.h = false;
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
                statisticItem.param("obj_type", "a002").param("obj_param1", 1).param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.repackage.sg0
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_type", "a002");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xb7 a;

        /* loaded from: classes7.dex */
        public class a implements NadRequester.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.repackage.xb7$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0549a implements tg0.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0549a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.repackage.tg0.d
                public void a(@NonNull NadInsertingBaseView nadInsertingBaseView) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nadInsertingBaseView) == null) {
                        this.a.a.a.d = nadInsertingBaseView;
                        if (this.a.a.a.j != null) {
                            this.a.a.a.j.a();
                        }
                    }
                }

                @Override // com.repackage.tg0.d
                public void onFail() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            }

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
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.nadcore.requester.NadRequester.b
            public void a(@NonNull NadRequester.Error error) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, error) == null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 1).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }

            @Override // com.baidu.nadcore.requester.NadRequester.b
            public void b(@NonNull List<AdBaseModel> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    tg0.b(this.a.a.b, this.a.a.e, list, this.a.a.l, new C0549a(this));
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 0).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public b(xb7 xb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xb7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                tg0.a("1638177515997", new a(this));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755177276, "Lcom/repackage/xb7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755177276, "Lcom/repackage/xb7;");
        }
    }

    public xb7(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = false;
        this.k = false;
        this.l = new a(this);
        this.b = activity;
        n();
    }

    public static void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            if (str.contains("tbmaintab://tieba.baidu.com") || str.contains("com.baidu.tieba://unidispatch/homepage") || str.contains("com.baidu.tieba://unidispatch/activitypage") || "com.baidu.tieba://unidispatch/hometab".equals(str)) {
                p = true;
            }
        }
    }

    public static xb7 k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, activity)) == null) {
            if (n == null) {
                synchronized (xb7.class) {
                    if (n == null) {
                        n = new xb7(activity);
                    }
                }
            }
            return n;
        }
        return (xb7) invokeL.objValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            return !StringUtils.isNull(clipBoardContent) && aj4.j.matcher(clipBoardContent).find();
        }
        return invokeV.booleanValue;
    }

    public static void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST_SUCCESS_NOT_SHOW);
            statisticItem.param("obj_type", "a002").param("obj_param1", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean A(String str, int i, int i2, long j, c cVar, boolean z) {
        InterceptResult invokeCommon;
        boolean r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), cVar, Boolean.valueOf(z)})) == null) {
            this.i = z;
            this.j = cVar;
            if ("1".equals(str)) {
                r = q();
            } else {
                r = r(i, i2, j);
            }
            if (r) {
                return B(str);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Activity activity = this.b;
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.REQUEST_AD_TIME);
            statisticItem.param("obj_type", "a002").param("obj_param1", str);
            TiebaStatic.log(statisticItem);
            new b(this).execute(new Void[0]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e == null || this.f == null) {
            return;
        }
        if (TbadkSettings.getInst().loadInt("skin_", 0) == 1) {
            this.e.post(new Runnable() { // from class: com.repackage.vb7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        xb7.this.x();
                    }
                }
            });
        } else {
            this.f.setVisibility(8);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long m2 = iu4.k().m("key_home_insert_ad_show_time", 0L);
            int l = iu4.k().l("key_home_insert_ad_show_num", 0);
            if (StringHelper.isTaday(m2)) {
                iu4.k().w("key_home_insert_ad_show_num", l + 1);
                return;
            }
            iu4.k().x("key_home_insert_ad_show_time", System.currentTimeMillis());
            iu4.k().w("key_home_insert_ad_show_num", 1);
        }
    }

    public void F(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            if (this.d != null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    if (!s(i, i2)) {
                        this.d = null;
                        return;
                    }
                    RoundRelativeLayout roundRelativeLayout = this.e;
                    if (roundRelativeLayout != null) {
                        roundRelativeLayout.setVisibility(0);
                    }
                    ImageView imageView = this.g;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    this.d.g();
                    G();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.FALSE));
                    D();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.SHOW_AD_TIME);
                    statisticItem.param("obj_type", "a002").param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            this.i = true;
        }
    }

    public void G() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (activity = this.b) == null || activity.isFinishing()) {
            return;
        }
        AlertDialog alertDialog = this.a;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.a.dismiss();
        }
        if (this.a == null) {
            this.a = new AlertDialog.Builder(this.b).create();
        }
        this.a.setCancelable(true);
        this.a.show();
        Window window = this.a.getWindow();
        window.getDecorView().setSystemUiVisibility(l());
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setNavigationBarColor(0);
        window.setAttributes(attributes);
        C();
        View view2 = this.c;
        if (view2 != null) {
            this.a.setContentView(view2);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.d == null) {
            return;
        }
        this.h = true;
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
        statisticItem.param("obj_type", "a002").param("obj_param1", 2).param("obj_source", 1);
        TiebaStatic.log(statisticItem);
        this.d.a();
    }

    public final void j() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (alertDialog = this.a) != null && alertDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1280;
        }
        return invokeV.intValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d003e, (ViewGroup) null);
            this.c = inflate;
            this.e = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d70);
            this.f = (RoundRelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090d71);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = (mi.k(this.b) * 837) / 1076;
            layoutParams.height = -2;
            this.e.setLayoutParams(layoutParams);
            this.e.setRoundLayoutRadius(es4.y(R.string.J_X06));
            this.f.setRoundLayoutRadius(es4.y(R.string.J_X06));
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090d6f);
            this.g = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.wb7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        xb7.this.w(view2);
                    }
                }
            });
        }
    }

    public final boolean o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            return p() && i == i2 && TbadkCoreApplication.getInst().getHomeBarShowType() == 1;
        }
        return invokeII.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int h = x8.g().h();
            Activity f = x8.g().f(h - 1);
            String localClassName = f != null ? f.getLocalClassName() : "";
            if (StringUtils.isNull(localClassName) || !localClassName.contains("MainTabActivity")) {
                Activity f2 = x8.g().f(h - 2);
                String localClassName2 = f2 != null ? f2.getLocalClassName() : "";
                return !StringUtils.isNull(localClassName) && !StringUtils.isNull(localClassName2) && localClassName.contains("LogoActivity") && localClassName2.contains("MainTabActivity");
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if ((!o || p) && UbsABTestHelper.isRequestInsertAd() && PermissionUtil.isAgreePrivacyPolicy()) {
                if (this.k || !u()) {
                    ox4 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                    return (v() || (homeInsertAdData != null && homeInsertAdData.b() == 0) || t()) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean r(int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            AlertDialog alertDialog = this.a;
            if ((alertDialog == null || !alertDialog.isShowing()) && q()) {
                if (o) {
                    if (!p) {
                        return false;
                    }
                } else if (!o(i, i2)) {
                    return false;
                }
                ox4 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                return (((System.currentTimeMillis() - j) / 1000) > ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 1 : (((System.currentTimeMillis() - j) / 1000) == ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 0 : -1)) > 0;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean s(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i, i2)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                y(3);
                return false;
            } else if (TbSingleton.getInstance().getExceptInsertAdDiaShow()) {
                y(1);
                return false;
            } else if (!this.k && u()) {
                y(1);
                return false;
            } else {
                if (o) {
                    if (!p) {
                        y(3);
                        return false;
                    }
                } else if (!o(i, i2)) {
                    y(2);
                    return false;
                }
                if (t()) {
                    y(3);
                    return false;
                }
                return true;
            }
        }
        return invokeII.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (StringHelper.isTaday(iu4.k().m("key_home_insert_ad_show_time", 0L))) {
                int l = iu4.k().l("key_home_insert_ad_show_num", 0);
                ox4 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                if (l >= (homeInsertAdData != null ? homeInsertAdData.a() : 1)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ void w(View view2) {
        i();
    }

    public /* synthetic */ void x() {
        int width = this.e.getWidth();
        int height = this.e.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(0);
        gs4.d(this.f).f(R.color.CAM_X0503);
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            n = null;
            j();
        }
    }
}
