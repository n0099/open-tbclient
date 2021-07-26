package d.a.p0.s.l;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.service.ChangeSkinReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.h;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AccountData f53155a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53156b;

    /* renamed from: c  reason: collision with root package name */
    public d f53157c;

    /* renamed from: d  reason: collision with root package name */
    public int f53158d;

    /* renamed from: e  reason: collision with root package name */
    public int f53159e;

    /* renamed from: f  reason: collision with root package name */
    public int f53160f;

    /* renamed from: g  reason: collision with root package name */
    public int f53161g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53162h;

    /* renamed from: i  reason: collision with root package name */
    public int f53163i;
    public boolean j;
    public ChangeSkinReceiver k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f53164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f53165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f53166g;

        public a(b bVar, AccountData accountData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, accountData, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53166g = bVar;
            this.f53164e = accountData;
            this.f53165f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53166g.M(this.f53164e, this.f53165f);
            }
        }
    }

    /* renamed from: d.a.p0.s.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1220b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f53167e;

        public RunnableC1220b(b bVar) {
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
            this.f53167e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53167e.S();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.h3.n0.a.a("", 7);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b this$0;

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
            this.this$0 = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.E() && intent != null && "com.baidu.tieba.action.accountChange".equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra("intent_data_accountData");
                if (serializableExtra instanceof AccountData) {
                    this.this$0.f53155a = (AccountData) serializableExtra;
                } else {
                    this.this$0.f53155a = null;
                }
                d.a.p0.h0.f.h(this.this$0.C());
                if (this.this$0.f53155a != null) {
                    d.a.p0.h0.f.g(this.this$0.f53155a.getBDUSS());
                    d.a.p0.h0.f.j(this.this$0.f53155a.getTbs());
                    d.a.p0.h0.f.i(this.this$0.f53155a.getStoken());
                }
            }
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53155a = null;
        this.f53156b = false;
        this.f53158d = 0;
        this.f53159e = 0;
        this.f53160f = 0;
        this.f53161g = 0;
        this.f53162h = true;
        this.j = true;
    }

    public static void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            h.a().b(new c());
            d.a.p0.s.d0.b.j().w("app_inverval", System.currentTimeMillis());
        }
    }

    public static void I(AccountData accountData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, accountData) == null) {
            String str2 = null;
            if (accountData != null) {
                str2 = accountData.getID();
                str = accountData.getAccount();
            } else {
                str = null;
            }
            String currentBduss = TbadkCoreApplication.getCurrentBduss();
            Intent intent = new Intent();
            intent.setAction("adp.bdstatisticsmanager.account_changed");
            intent.putExtra("intent_data_userid", str2);
            intent.putExtra("intent_data_username", str);
            intent.putExtra("intent_data_bduss", currentBduss);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            try {
                TbadkCoreApplication.getInst().sendStickyBroadcast(intent);
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
            Intent intent2 = new Intent();
            intent2.setAction("com.baidu.tieba.action.accountChange");
            intent2.putExtra("intent_data_accountData", accountData);
            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
            TbadkCoreApplication.getInst().sendBroadcast(intent2);
            d.a.p0.h0.f.h(!TextUtils.isEmpty(str2));
            if (accountData != null) {
                d.a.p0.h0.f.g(accountData.getBDUSS());
                d.a.p0.h0.f.j(accountData.getTbs());
                d.a.p0.h0.f.i(accountData.getStoken());
            }
        }
    }

    public static b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (l == null) {
                synchronized (b.class) {
                    if (l == null) {
                        l = new b();
                    }
                }
            }
            return l;
        }
        return (b) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !D(false) && E() && this.f53157c == null) {
            this.f53157c = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
            TbadkCoreApplication.getInst().registerReceiver(this.f53157c, intentFilter);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && E()) {
            this.k = new ChangeSkinReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionChangeSkin());
            TbadkCoreApplication.getInst().registerReceiver(this.k, intentFilter);
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String g2 = g();
            return g2 != null && g2.length() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean D(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? TbadkCoreApplication.getInst().isMainProcess(z) : invokeZ.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TbadkCoreApplication.getInst().isRemoteProcess() : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f53162h : invokeV.booleanValue;
    }

    public void G(AccountData accountData, Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, accountData, application) == null) {
            BdLog.e("账号切换");
            d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
            String p = j.p("current_used_theme_" + g(), null);
            if (StringUtils.isNull(p)) {
                this.f53159e = 0;
                this.f53160f = 0;
            } else {
                String[] split = p.split("/");
                if (split != null && split.length >= 2) {
                    this.f53159e = d.a.d.e.m.b.d(split[0], 0);
                    this.f53160f = d.a.d.e.m.b.d(split[1], 0);
                } else {
                    this.f53159e = 0;
                    this.f53160f = 0;
                }
            }
            this.f53158d = TbadkSettings.getInst().loadInt("skin_", 0);
            this.j = true;
            e();
            d.a.d.e.m.e.a().postDelayed(new RunnableC1220b(this), 600L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2005006, accountData));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
            MessageManager.getInstance().registerStickyMode(2005019);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TbSingleton.getInstance().onAccountChange();
        }
    }

    public void J(AccountData accountData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, accountData, str, str2) == null) {
            if (accountData == null && this.f53155a != null) {
                this.f53156b = true;
            } else if (this.f53155a == null && accountData != null) {
                this.f53156b = true;
            } else {
                AccountData accountData2 = this.f53155a;
                if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                    this.f53156b = true;
                }
            }
            if (this.f53155a == null && accountData != null) {
                this.f53155a = accountData;
            }
            if (this.f53155a == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f53155a.setBDUSS(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f53155a.setTbs(str2);
        }
    }

    public void K(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accountData, context) == null) {
            String str = "set_application_account:";
            if (accountData == null) {
                str = "set_application_account:" + StringUtil.NULL_STRING;
            } else if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_application_account:valid_logined";
            } else if (!StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_application_account:valid";
            } else if (!StringUtils.isNull(accountData.getID())) {
                str = "set_application_account:logined";
            }
            d.a.p0.s.z.a.a("account", -1L, 0, str, 0, "", new Object[0]);
            if (l.C()) {
                M(accountData, context);
            } else {
                TbadkCoreApplication.getInst().handler.post(new a(this, accountData, context));
            }
        }
    }

    public void L(AccountData accountData, Context context) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, accountData, context) == null) {
            this.f53155a = accountData;
            String str3 = null;
            if (accountData != null) {
                str3 = accountData.getID();
                str2 = accountData.getAccount();
                str = accountData.getBDUSS();
            } else {
                str = null;
                str2 = null;
            }
            BdStatisticsManager.getInstance().setUser(str3, str2, str);
        }
    }

    public void M(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, accountData, context) == null) {
            if (!this.f53156b) {
                if (accountData == null && this.f53155a != null) {
                    this.f53156b = true;
                } else if (this.f53155a == null && accountData != null) {
                    this.f53156b = true;
                } else {
                    AccountData accountData2 = this.f53155a;
                    if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                        this.f53156b = true;
                    }
                }
            }
            this.f53155a = accountData;
            if (context != null) {
                if (TbadkCoreApplication.getInst().isPushServiceOpen()) {
                    UtilHelper.startPushService(context);
                } else {
                    UtilHelper.stopPushService(context);
                }
            }
            I(accountData);
            if (this.f53156b) {
                G(accountData, TbadkCoreApplication.getInst());
                BdSocketLinkService.setHasAbsoluteClose(false);
                BdSocketLinkService.setAvailable(true);
                d.a.p0.e0.a.b(0, 0, 0, 1, 2);
                BdSocketLinkService.startService(true, "account changed");
            }
            MessageManager.getInstance().runTask(2004603, (Class) null);
            if (j.H() && accountData != null) {
                MessageManager.getInstance().runTask(2004611, (Class) null);
            }
            TbadkCoreApplication.getInst().setActivityPrizeData(null);
        }
    }

    public void N(int i2) {
        AccountData accountData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (accountData = this.f53155a) == null) {
            return;
        }
        accountData.setMemberType(i2);
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f53163i = v();
            H();
            P(i2);
            TbadkSettings.getInst().saveInt("skin_", i2);
            a(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i2)));
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f53158d = i2;
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        synchronized (this) {
            if (this.f53155a != null) {
                this.f53155a.setTbs(str);
            }
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f53162h = z;
        }
    }

    public void S() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f53158d == 2 && (i2 = this.f53159e) > 0) {
                T(i2, this.f53160f);
                return;
            }
            int i3 = this.f53158d;
            if (i3 == 1) {
                O(i3);
            } else {
                SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
            }
        }
    }

    public void T(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || i2 <= 0) {
            return;
        }
        if (!this.j && i2 == this.f53159e && this.f53158d == 2) {
            return;
        }
        this.j = false;
        String str = i2 + ".apk";
        try {
            SkinManager.setSkinRes(str);
            PackageInfo apkFileMetaData = FileHelper.getApkFileMetaData(str);
            if (apkFileMetaData != null && apkFileMetaData.applicationInfo != null && apkFileMetaData.applicationInfo.metaData != null) {
                this.f53161g = apkFileMetaData.applicationInfo.metaData.getInt(SkinManager.THEME_ICON_COLOR_VALUE);
                this.f53162h = apkFileMetaData.applicationInfo.metaData.getInt(SkinManager.THEME_ICON_COVER_VALUE) != 1;
                this.f53159e = i2;
                BitmapHelper.clearThemeCashBitmap();
                d.a.p0.s.d0.b.j().x("current_used_theme_" + g(), i2 + "/" + this.f53160f);
                O(2);
                return;
            }
            O(0);
            this.f53159e = 0;
        } catch (Throwable th) {
            O(0);
            BdLog.e(th);
        }
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f53161g = i2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.getBroadcastActionChangeSkin());
            intent.putExtra("skin_type", i2);
            TbadkCoreApplication.getInst().getContext().sendBroadcast(intent);
        }
    }

    public boolean d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, str, i2)) == null) {
            d.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i2)});
            return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i2), "", str});
        }
        return invokeLI.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TbSingleton.getInstance().clearVideoRecord();
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || str == null) {
            return;
        }
        d.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from mark_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from draft_box where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from account_data where id=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{str});
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData != null) {
                return accountData.getID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String g2 = g();
            if (TextUtils.isEmpty(g2)) {
                AccountData e2 = d.a.p0.s.l.c.e();
                return e2 != null ? e2.getID() : "";
            }
            return g2;
        }
        return (String) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData != null) {
                return d.a.d.e.m.b.f(accountData.getID(), 0L);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public AccountData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f53155a : (AccountData) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData != null) {
                return accountData.getAccount();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData != null) {
                return accountData.getAccountNameShow();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AccountData m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f53155a : (AccountData) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            AccountData m = m();
            if (m == null) {
                return null;
            }
            if (!TextUtils.isEmpty(m.getAvatar())) {
                return m.getAvatar();
            }
            return m.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData != null) {
                return accountData.getBDUSS();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData != null) {
                return accountData.getMemberType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            AccountData m = m();
            if (m == null) {
                return null;
            }
            return m.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData == null || accountData.getVipInfo() == null) {
                return 0;
            }
            return this.f53155a.getVipInfo().getVipLevel();
        }
        return invokeV.intValue;
    }

    public String t(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048611, this, i2)) != null) {
            return (String) invokeI.objValue;
        }
        d.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor2 = null;
        try {
            cursor = mainDBDatabaseManager.j("select * from cash_data where type=? ", new String[]{String.valueOf(i2)});
            try {
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(2) : null;
                    d.a.d.e.m.a.a(cursor);
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    mainDBDatabaseManager.i(e, "getNoAccountData");
                    d.a.d.e.m.a.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                d.a.d.e.m.a.a(cursor2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.d.e.m.a.a(cursor2);
            throw th;
        }
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f53163i : invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f53158d : invokeV.intValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            AccountData accountData = this.f53155a;
            if (accountData != null) {
                return accountData.getTbs();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f53161g : invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f53159e : invokeV.intValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (D(true)) {
                try {
                    if (TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                        AccountData e2 = d.a.p0.s.l.c.e();
                        if (e2 != null) {
                            d.a.p0.s.z.a.a("account", -1L, 0, "application_init_account", 0, "", new Object[0]);
                            K(e2, TbadkCoreApplication.getInst());
                        } else {
                            d.a.p0.s.z.a.a("account", -1L, 0, "application_init_no_account", 0, "", new Object[0]);
                        }
                    } else {
                        d.a.p0.s.z.a.a("account", -1L, 0, "application_bd_no_account", 0, "", new Object[0]);
                    }
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                d.a.p0.o0.l.b().i(System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }
}
