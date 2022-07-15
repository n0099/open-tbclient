package com.repackage;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.service.ChangeSkinReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class bn4 {
    public static /* synthetic */ Interceptable $ic;
    public static bn4 k;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountData a;
    public boolean b;
    public c c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public ChangeSkinReceiver i;
    public boolean j;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountData a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ bn4 c;

        public a(bn4 bn4Var, AccountData accountData, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bn4Var, accountData, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bn4Var;
            this.a = accountData;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.N(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oj8.a("", 7);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bn4 this$0;

        public c(bn4 bn4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bn4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bn4Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.this$0.F() && intent != null && "com.baidu.tieba.action.accountChange".equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra("intent_data_accountData");
                if (serializableExtra instanceof AccountData) {
                    this.this$0.a = (AccountData) serializableExtra;
                } else {
                    this.this$0.a = null;
                }
                p65.o(this.this$0.D());
                if (this.this$0.a != null) {
                    p65.n(this.this$0.a.getBDUSS());
                    p65.q(this.this$0.a.getTbs());
                    p65.p(this.this$0.a.getStoken());
                }
            }
        }

        public /* synthetic */ c(bn4 bn4Var, a aVar) {
            this(bn4Var);
        }
    }

    public bn4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = false;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = true;
        this.j = false;
    }

    public static void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            tg.a().b(new b());
            xt4.k().x("app_inverval", System.currentTimeMillis());
        }
    }

    public static void J(AccountData accountData) {
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
            p65.o(!TextUtils.isEmpty(str2));
            if (accountData != null) {
                p65.n(accountData.getBDUSS());
                p65.q(accountData.getTbs());
                p65.p(accountData.getStoken());
            }
        }
    }

    public static bn4 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (k == null) {
                synchronized (bn4.class) {
                    if (k == null) {
                        k = new bn4();
                    }
                }
            }
            return k;
        }
        return (bn4) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.j) {
            return;
        }
        this.j = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (E(true)) {
            try {
                if (TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                    AccountData e = cn4.e();
                    if (e != null) {
                        mt4.a(DI.ACCOUNT, -1L, 0, "application_init_account", 0, "", new Object[0]);
                        L(e, TbadkCoreApplication.getInst());
                    } else {
                        mt4.a(DI.ACCOUNT, -1L, 0, "application_init_no_account", 0, "", new Object[0]);
                    }
                } else {
                    mt4.a(DI.ACCOUNT, -1L, 0, "application_bd_no_account", 0, "", new Object[0]);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            s95.b().i(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !E(false) && F() && this.c == null) {
            this.c = new c(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
            TbadkCoreApplication.getInst().registerReceiver(this.c, intentFilter);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && F()) {
            this.i = new ChangeSkinReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionChangeSkin());
            TbadkCoreApplication.getInst().registerReceiver(this.i, intentFilter);
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String h = h();
            return h != null && h.length() > 0;
        }
        return invokeV.booleanValue;
    }

    public boolean E(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) ? TbadkCoreApplication.getInst().isMainProcess(z) : invokeZ.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TbadkCoreApplication.getInst().isRemoteProcess() : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void H(AccountData accountData, Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, accountData, application) == null) {
            v87.a("onAccountChanged()");
            BdLog.e("账号切换");
            xt4 k2 = xt4.k();
            String q = k2.q("current_used_theme_" + h(), null);
            if (StringUtils.isNull(q)) {
                this.e = 0;
            } else {
                String[] split = q.split("/");
                if (split != null && split.length >= 2) {
                    this.e = ng.e(split[0], 0);
                } else {
                    this.e = 0;
                }
            }
            f();
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2005006, accountData));
            v87.a("send METHOD_ACCOUNT_CHANGE");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
            MessageManager.getInstance().registerStickyMode(2005019);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            TbSingleton.getInstance().onAccountChange();
        }
    }

    public void K(AccountData accountData, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accountData, str, str2) == null) {
            if (accountData == null && this.a != null) {
                this.b = true;
            } else if (this.a == null && accountData != null) {
                this.b = true;
            } else {
                AccountData accountData2 = this.a;
                if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                    this.b = true;
                }
            }
            if (this.a == null && accountData != null) {
                this.a = accountData;
            }
            if (this.a == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.a.setBDUSS(str);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.a.setTbs(str2);
        }
    }

    public void L(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, accountData, context) == null) {
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
            mt4.a(DI.ACCOUNT, -1L, 0, str, 0, "", new Object[0]);
            if (!this.b) {
                if (accountData == null && this.a != null) {
                    this.b = true;
                    v87.a("account == null && mAccount != null");
                } else if (this.a == null && accountData != null) {
                    this.b = true;
                    v87.a("mAccount == null && account != null 初始化");
                } else {
                    AccountData accountData2 = this.a;
                    if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                        this.b = true;
                        v87.a("mAccount != null && account != null");
                    }
                }
            }
            this.a = accountData;
            qb.b().a("setCurrentAccountInUI", new a(this, accountData, context));
        }
    }

    public void M(AccountData accountData, Context context) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, accountData, context) == null) {
            this.a = accountData;
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

    public final void N(AccountData accountData, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, accountData, context) == null) {
            oj8.n();
            if (context != null) {
                if (TbadkCoreApplication.getInst().isPushServiceOpen()) {
                    UtilHelper.startPushService(context);
                } else {
                    UtilHelper.stopPushService(context);
                }
            }
            J(accountData);
            if (this.b) {
                H(accountData, TbadkCoreApplication.getInst());
                BdSocketLinkService.setHasAbsoluteClose(false);
                BdSocketLinkService.setAvailable(true);
                c55.b(0, 0, 0, 1, 2);
                BdSocketLinkService.startService(true, "account changed");
            }
            MessageManager.getInstance().runTask(2004603, (Class) null);
            if (ni.H() && accountData != null) {
                MessageManager.getInstance().runTask(2004611, (Class) null);
            }
            TbadkCoreApplication.getInst().setActivityPrizeData(null);
        }
    }

    public void O(int i) {
        AccountData accountData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (accountData = this.a) == null) {
            return;
        }
        accountData.setMemberType(i);
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h = w();
            I();
            Q(i);
            TbadkSettings.getInst().saveInt("skin_", i);
            a(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i)));
        }
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.d = i;
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        synchronized (this) {
            if (this.a != null) {
                this.a.setTbs(str);
            }
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            Intent intent = new Intent();
            intent.setAction(TbConfig.getBroadcastActionChangeSkin());
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent.putExtra("skin_type", i);
            TbadkCoreApplication.getInst().getContext().sendBroadcast(intent);
        }
    }

    public boolean e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i)) == null) {
            j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i)});
            return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
        }
        return invokeLI.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TbSingleton.getInstance().clearVideoRecord();
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || str == null) {
            return;
        }
        j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from mark_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from draft_box where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from account_data where id=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{str});
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String h = h();
            if (TextUtils.isEmpty(h)) {
                AccountData e = cn4.e();
                return e != null ? e.getID() : "";
            }
            return h;
        }
        return (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return ng.g(accountData.getID(), 0L);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public AccountData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a : (AccountData) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getAccount();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getAccountNameShow();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public AccountData n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.a : (AccountData) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            AccountData n = n();
            if (n == null) {
                return null;
            }
            if (!TextUtils.isEmpty(n.getAvatar())) {
                return n.getAvatar();
            }
            return n.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getBDUSS();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getMemberType();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            AccountData n = n();
            if (n == null) {
                return null;
            }
            return n.getPortrait();
        }
        return (String) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            AccountData accountData = this.a;
            if (accountData == null || accountData.getVipInfo() == null) {
                return 0;
            }
            return this.a.getVipInfo().getVipLevel();
        }
        return invokeV.intValue;
    }

    public String u(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048608, this, i)) != null) {
            return (String) invokeI.objValue;
        }
        j9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor2 = null;
        try {
            cursor = mainDBDatabaseManager.j("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
            try {
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(2) : null;
                    mg.a(cursor);
                    return string;
                } catch (Exception e) {
                    e = e;
                    mainDBDatabaseManager.i(e, "getNoAccountData");
                    mg.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                mg.a(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            mg.a(cursor2);
            throw th;
        }
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.h : invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.d : invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            AccountData accountData = this.a;
            if (accountData != null) {
                return accountData.getTbs();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f : invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.e : invokeV.intValue;
    }
}
