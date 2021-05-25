package d.a.m0.r.l;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
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
import d.a.c.e.m.h;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class b {
    public static b l;

    /* renamed from: c  reason: collision with root package name */
    public d f49867c;

    /* renamed from: i  reason: collision with root package name */
    public int f49873i;
    public ChangeSkinReceiver k;

    /* renamed from: a  reason: collision with root package name */
    public AccountData f49865a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49866b = false;

    /* renamed from: d  reason: collision with root package name */
    public int f49868d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f49869e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f49870f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49871g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49872h = true;
    public boolean j = true;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f49874e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f49875f;

        public a(AccountData accountData, Context context) {
            this.f49874e = accountData;
            this.f49875f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.M(this.f49874e, this.f49875f);
        }
    }

    /* renamed from: d.a.m0.r.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1142b implements Runnable {
        public RunnableC1142b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.S();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.e3.n0.a.a("", 7);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (b.this.E() && intent != null && "com.baidu.tieba.action.accountChange".equals(intent.getAction())) {
                Serializable serializableExtra = intent.getSerializableExtra("intent_data_accountData");
                if (serializableExtra instanceof AccountData) {
                    b.this.f49865a = (AccountData) serializableExtra;
                } else {
                    b.this.f49865a = null;
                }
                d.a.m0.f0.f.h(b.this.C());
                if (b.this.f49865a != null) {
                    d.a.m0.f0.f.g(b.this.f49865a.getBDUSS());
                    d.a.m0.f0.f.j(b.this.f49865a.getTbs());
                    d.a.m0.f0.f.i(b.this.f49865a.getStoken());
                }
            }
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }
    }

    public static void H() {
        h.a().b(new c());
        d.a.m0.r.d0.b.j().w("app_inverval", System.currentTimeMillis());
    }

    public static void I(AccountData accountData) {
        String str;
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
        d.a.m0.f0.f.h(!TextUtils.isEmpty(str2));
        if (accountData != null) {
            d.a.m0.f0.f.g(accountData.getBDUSS());
            d.a.m0.f0.f.j(accountData.getTbs());
            d.a.m0.f0.f.i(accountData.getStoken());
        }
    }

    public static b s() {
        if (l == null) {
            synchronized (b.class) {
                if (l == null) {
                    l = new b();
                }
            }
        }
        return l;
    }

    public void A() {
        if (!D(false) && E() && this.f49867c == null) {
            this.f49867c = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
            TbadkCoreApplication.getInst().registerReceiver(this.f49867c, intentFilter);
        }
    }

    public void B() {
        if (E()) {
            this.k = new ChangeSkinReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TbConfig.getBroadcastActionChangeSkin());
            TbadkCoreApplication.getInst().registerReceiver(this.k, intentFilter);
        }
    }

    public boolean C() {
        String g2 = g();
        return g2 != null && g2.length() > 0;
    }

    public boolean D(boolean z) {
        return TbadkCoreApplication.getInst().isMainProcess(z);
    }

    public boolean E() {
        return TbadkCoreApplication.getInst().isRemoteProcess();
    }

    public boolean F() {
        return this.f49872h;
    }

    public void G(AccountData accountData, Application application) {
        BdLog.e("账号切换");
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        String p = j.p("current_used_theme_" + g(), null);
        if (StringUtils.isNull(p)) {
            this.f49869e = 0;
            this.f49870f = 0;
        } else {
            String[] split = p.split("/");
            if (split != null && split.length >= 2) {
                this.f49869e = d.a.c.e.m.b.d(split[0], 0);
                this.f49870f = d.a.c.e.m.b.d(split[1], 0);
            } else {
                this.f49869e = 0;
                this.f49870f = 0;
            }
        }
        this.f49868d = TbadkSettings.getInst().loadInt("skin_", 0);
        this.j = true;
        e();
        d.a.c.e.m.e.a().postDelayed(new RunnableC1142b(), 600L);
        MessageManager.getInstance().sendMessage(new CustomMessage(2005006, accountData));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
        MessageManager.getInstance().registerStickyMode(2005019);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        TbSingleton.getInstance().onAccountChange();
    }

    public void J(AccountData accountData, String str, String str2) {
        if (accountData == null && this.f49865a != null) {
            this.f49866b = true;
        } else if (this.f49865a == null && accountData != null) {
            this.f49866b = true;
        } else {
            AccountData accountData2 = this.f49865a;
            if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                this.f49866b = true;
            }
        }
        if (this.f49865a == null && accountData != null) {
            this.f49865a = accountData;
        }
        if (this.f49865a == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f49865a.setBDUSS(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f49865a.setTbs(str2);
    }

    public void K(AccountData accountData, Context context) {
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
        d.a.m0.r.z.a.a("account", -1L, 0, str, 0, "", new Object[0]);
        if (l.C()) {
            M(accountData, context);
        } else {
            TbadkCoreApplication.getInst().handler.post(new a(accountData, context));
        }
    }

    public void L(AccountData accountData, Context context) {
        String str;
        String str2;
        this.f49865a = accountData;
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

    public void M(AccountData accountData, Context context) {
        if (!this.f49866b) {
            if (accountData == null && this.f49865a != null) {
                this.f49866b = true;
            } else if (this.f49865a == null && accountData != null) {
                this.f49866b = true;
            } else {
                AccountData accountData2 = this.f49865a;
                if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                    this.f49866b = true;
                }
            }
        }
        this.f49865a = accountData;
        if (context != null) {
            if (TbadkCoreApplication.getInst().isPushServiceOpen()) {
                UtilHelper.startPushService(context);
            } else {
                UtilHelper.stopPushService(context);
            }
        }
        I(accountData);
        if (this.f49866b) {
            G(accountData, TbadkCoreApplication.getInst());
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            d.a.m0.c0.a.b(0, 0, 0, 1, 2);
            BdSocketLinkService.startService(true, "account changed");
        }
        MessageManager.getInstance().runTask(2004603, (Class) null);
        if (j.H() && accountData != null) {
            MessageManager.getInstance().runTask(2004611, (Class) null);
        }
        TbadkCoreApplication.getInst().setActivityPrizeData(null);
    }

    public void N(int i2) {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            accountData.setMemberType(i2);
        }
    }

    public void O(int i2) {
        this.f49873i = v();
        H();
        P(i2);
        TbadkSettings.getInst().saveInt("skin_", i2);
        a(i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i2)));
    }

    public void P(int i2) {
        this.f49868d = i2;
    }

    public void Q(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        synchronized (this) {
            if (this.f49865a != null) {
                this.f49865a.setTbs(str);
            }
        }
    }

    public void R(boolean z) {
        this.f49872h = z;
    }

    public void S() {
        int i2;
        if (this.f49868d == 2 && (i2 = this.f49869e) > 0) {
            T(i2, this.f49870f);
            return;
        }
        int i3 = this.f49868d;
        if (i3 == 1) {
            O(i3);
        } else {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
        }
    }

    public void T(int i2, int i3) {
        if (i2 <= 0) {
            return;
        }
        if (!this.j && i2 == this.f49869e && this.f49868d == 2) {
            return;
        }
        this.j = false;
        String str = i2 + ".apk";
        try {
            SkinManager.setSkinRes(str);
            PackageInfo apkFileMetaData = FileHelper.getApkFileMetaData(str);
            if (apkFileMetaData != null && apkFileMetaData.applicationInfo != null && apkFileMetaData.applicationInfo.metaData != null) {
                this.f49871g = apkFileMetaData.applicationInfo.metaData.getInt(SkinManager.THEME_ICON_COLOR_VALUE);
                this.f49872h = apkFileMetaData.applicationInfo.metaData.getInt(SkinManager.THEME_ICON_COVER_VALUE) != 1;
                this.f49869e = i2;
                BitmapHelper.clearThemeCashBitmap();
                d.a.m0.r.d0.b.j().x("current_used_theme_" + g(), i2 + "/" + this.f49870f);
                O(2);
                return;
            }
            O(0);
            this.f49869e = 0;
        } catch (Throwable th) {
            O(0);
            BdLog.e(th);
        }
    }

    public void U(int i2) {
        this.f49871g = i2;
    }

    public void a(int i2) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.getBroadcastActionChangeSkin());
        intent.putExtra("skin_type", i2);
        TbadkCoreApplication.getInst().getContext().sendBroadcast(intent);
    }

    public boolean d(String str, int i2) {
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i2)});
        return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i2), "", str});
    }

    public final void e() {
        TbSingleton.getInstance().clearVideoRecord();
    }

    public void f(String str) {
        if (str == null) {
            return;
        }
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from mark_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from draft_box where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from account_data where id=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{str});
    }

    public String g() {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            return accountData.getID();
        }
        return null;
    }

    public String h() {
        String g2 = g();
        if (TextUtils.isEmpty(g2)) {
            AccountData e2 = d.a.m0.r.l.c.e();
            return e2 != null ? e2.getID() : "";
        }
        return g2;
    }

    public long i() {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            return d.a.c.e.m.b.f(accountData.getID(), 0L);
        }
        return 0L;
    }

    public AccountData j() {
        return this.f49865a;
    }

    public String k() {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            return accountData.getAccount();
        }
        return null;
    }

    public String l() {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            return accountData.getAccountNameShow();
        }
        return null;
    }

    public AccountData m() {
        return this.f49865a;
    }

    public String n() {
        AccountData m = m();
        if (m == null) {
            return null;
        }
        if (!TextUtils.isEmpty(m.getAvatar())) {
            return m.getAvatar();
        }
        return m.getPortrait();
    }

    public String o() {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            return accountData.getBDUSS();
        }
        return null;
    }

    public int p() {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            return accountData.getMemberType();
        }
        return 0;
    }

    public String q() {
        AccountData m = m();
        if (m == null) {
            return null;
        }
        return m.getPortrait();
    }

    public int r() {
        AccountData accountData = this.f49865a;
        if (accountData == null || accountData.getVipInfo() == null) {
            return 0;
        }
        return this.f49865a.getVipInfo().getVipLevel();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public String t(int i2) {
        Cursor cursor;
        d.a.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor2 = null;
        try {
            try {
                cursor = mainDBDatabaseManager.j("select * from cash_data where type=? ", new String[]{String.valueOf(i2)});
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(2) : null;
                    d.a.c.e.m.a.a(cursor);
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    mainDBDatabaseManager.i(e, "getNoAccountData");
                    d.a.c.e.m.a.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = i2;
                d.a.c.e.m.a.a(cursor2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.c.e.m.a.a(cursor2);
            throw th;
        }
    }

    public int u() {
        return this.f49873i;
    }

    public int v() {
        return this.f49868d;
    }

    public String w() {
        AccountData accountData = this.f49865a;
        if (accountData != null) {
            return accountData.getTbs();
        }
        return null;
    }

    public int x() {
        return this.f49871g;
    }

    public int y() {
        return this.f49869e;
    }

    public void z() {
        long currentTimeMillis = System.currentTimeMillis();
        if (D(true)) {
            try {
                if (TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                    AccountData e2 = d.a.m0.r.l.c.e();
                    if (e2 != null) {
                        d.a.m0.r.z.a.a("account", -1L, 0, "application_init_account", 0, "", new Object[0]);
                        K(e2, TbadkCoreApplication.getInst());
                    } else {
                        d.a.m0.r.z.a.a("account", -1L, 0, "application_init_no_account", 0, "", new Object[0]);
                    }
                } else {
                    d.a.m0.r.z.a.a("account", -1L, 0, "application_bd_no_account", 0, "", new Object[0]);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            d.a.m0.m0.l.b().i(System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
