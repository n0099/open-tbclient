package d.b.h0.r.l;

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
import com.baidu.nps.utils.Constant;
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
import d.b.b.e.m.h;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class b {
    public static b l;

    /* renamed from: c  reason: collision with root package name */
    public d f50633c;
    public int i;
    public ChangeSkinReceiver k;

    /* renamed from: a  reason: collision with root package name */
    public AccountData f50631a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50632b = false;

    /* renamed from: d  reason: collision with root package name */
    public int f50634d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f50635e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f50636f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50637g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50638h = true;
    public boolean j = true;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f50639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f50640f;

        public a(AccountData accountData, Context context) {
            this.f50639e = accountData;
            this.f50640f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.M(this.f50639e, this.f50640f);
        }
    }

    /* renamed from: d.b.h0.r.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1083b implements Runnable {
        public RunnableC1083b() {
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
            d.b.i0.c3.n0.a.a("", 7);
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
                    b.this.f50631a = (AccountData) serializableExtra;
                } else {
                    b.this.f50631a = null;
                }
                d.b.h0.f0.f.g(b.this.C());
                if (b.this.f50631a != null) {
                    d.b.h0.f0.f.f(b.this.f50631a.getBDUSS());
                    d.b.h0.f0.f.i(b.this.f50631a.getTbs());
                    d.b.h0.f0.f.h(b.this.f50631a.getStoken());
                }
            }
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }
    }

    public static void H() {
        h.a().b(new c());
        d.b.h0.r.d0.b.i().v("app_inverval", System.currentTimeMillis());
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
        d.b.h0.f0.f.g(!TextUtils.isEmpty(str2));
        if (accountData != null) {
            d.b.h0.f0.f.f(accountData.getBDUSS());
            d.b.h0.f0.f.i(accountData.getTbs());
            d.b.h0.f0.f.h(accountData.getStoken());
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
        if (!D(false) && E() && this.f50633c == null) {
            this.f50633c = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.action.accountChange");
            TbadkCoreApplication.getInst().registerReceiver(this.f50633c, intentFilter);
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
        return this.f50638h;
    }

    public void G(AccountData accountData, Application application) {
        BdLog.e("账号切换");
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        String o = i.o("current_used_theme_" + g(), null);
        if (StringUtils.isNull(o)) {
            this.f50635e = 0;
            this.f50636f = 0;
        } else {
            String[] split = o.split("/");
            if (split != null && split.length >= 2) {
                this.f50635e = d.b.b.e.m.b.d(split[0], 0);
                this.f50636f = d.b.b.e.m.b.d(split[1], 0);
            } else {
                this.f50635e = 0;
                this.f50636f = 0;
            }
        }
        this.f50634d = TbadkSettings.getInst().loadInt("skin_", 0);
        this.j = true;
        e();
        d.b.b.e.m.e.a().postDelayed(new RunnableC1083b(), 600L);
        MessageManager.getInstance().sendMessage(new CustomMessage(2005006, accountData));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005016, accountData));
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2005019, accountData);
        MessageManager.getInstance().registerStickyMode(2005019);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
    }

    public void J(AccountData accountData, String str, String str2) {
        if (accountData == null && this.f50631a != null) {
            this.f50632b = true;
        } else if (this.f50631a == null && accountData != null) {
            this.f50632b = true;
        } else {
            AccountData accountData2 = this.f50631a;
            if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                this.f50632b = true;
            }
        }
        if (this.f50631a == null && accountData != null) {
            this.f50631a = accountData;
        }
        if (this.f50631a == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f50631a.setBDUSS(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f50631a.setTbs(str2);
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
        d.b.h0.r.z.a.a("account", -1L, 0, str, 0, "", new Object[0]);
        if (l.B()) {
            M(accountData, context);
        } else {
            TbadkCoreApplication.getInst().handler.post(new a(accountData, context));
        }
    }

    public void L(AccountData accountData, Context context) {
        String str;
        String str2;
        this.f50631a = accountData;
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
        if (!this.f50632b) {
            if (accountData == null && this.f50631a != null) {
                this.f50632b = true;
            } else if (this.f50631a == null && accountData != null) {
                this.f50632b = true;
            } else {
                AccountData accountData2 = this.f50631a;
                if (accountData2 != null && accountData != null && !TextUtils.equals(accountData2.getAccount(), accountData.getAccount())) {
                    this.f50632b = true;
                }
            }
        }
        this.f50631a = accountData;
        if (context != null) {
            if (TbadkCoreApplication.getInst().isPushServiceOpen()) {
                UtilHelper.startPushService(context);
            } else {
                UtilHelper.stopPushService(context);
            }
        }
        I(accountData);
        if (this.f50632b) {
            G(accountData, TbadkCoreApplication.getInst());
            BdSocketLinkService.setHasAbsoluteClose(false);
            BdSocketLinkService.setAvailable(true);
            d.b.h0.c0.a.b(0, 0, 0, 1, 2);
            BdSocketLinkService.startService(true, "account changed");
        }
        MessageManager.getInstance().runTask(2004603, (Class) null);
        if (j.H() && accountData != null) {
            MessageManager.getInstance().runTask(2004611, (Class) null);
        }
        TbadkCoreApplication.getInst().setActivityPrizeData(null);
    }

    public void N(int i) {
        AccountData accountData = this.f50631a;
        if (accountData != null) {
            accountData.setMemberType(i);
        }
    }

    public void O(int i) {
        this.i = v();
        H();
        P(i);
        TbadkSettings.getInst().saveInt("skin_", i);
        a(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(i)));
    }

    public void P(int i) {
        this.f50634d = i;
    }

    public void Q(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        synchronized (this) {
            if (this.f50631a != null) {
                this.f50631a.setTbs(str);
            }
        }
    }

    public void R(boolean z) {
        this.f50638h = z;
    }

    public void S() {
        int i;
        if (this.f50634d == 2 && (i = this.f50635e) > 0) {
            T(i, this.f50636f);
            return;
        }
        int i2 = this.f50634d;
        if (i2 == 1) {
            O(i2);
        } else {
            SkinManager.setDayOrDarkSkinTypeWithSystemMode(false, true);
        }
    }

    public void T(int i, int i2) {
        if (i <= 0) {
            return;
        }
        if (!this.j && i == this.f50635e && this.f50634d == 2) {
            return;
        }
        this.j = false;
        String str = i + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
        try {
            SkinManager.setSkinRes(str);
            PackageInfo apkFileMetaData = FileHelper.getApkFileMetaData(str);
            if (apkFileMetaData != null && apkFileMetaData.applicationInfo != null && apkFileMetaData.applicationInfo.metaData != null) {
                this.f50637g = apkFileMetaData.applicationInfo.metaData.getInt(SkinManager.THEME_ICON_COLOR_VALUE);
                this.f50638h = apkFileMetaData.applicationInfo.metaData.getInt(SkinManager.THEME_ICON_COVER_VALUE) != 1;
                this.f50635e = i;
                BitmapHelper.clearThemeCashBitmap();
                d.b.h0.r.d0.b.i().w("current_used_theme_" + g(), i + "/" + this.f50636f);
                O(2);
                return;
            }
            O(0);
            this.f50635e = 0;
        } catch (Throwable th) {
            O(0);
            BdLog.e(th);
        }
    }

    public void U(int i) {
        this.f50637g = i;
    }

    public void a(int i) {
        Intent intent = new Intent();
        intent.setAction(TbConfig.getBroadcastActionChangeSkin());
        intent.putExtra("skin_type", i);
        TbadkCoreApplication.getInst().getContext().sendBroadcast(intent);
    }

    public boolean d(String str, int i) {
        d.b.b.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where type=?", new String[]{String.valueOf(i)});
        return mainDBDatabaseManager.e("Insert into cash_data(type ,account ,data ) values(?,?,?)", new String[]{String.valueOf(i), "", str});
    }

    public final void e() {
        TbSingleton.getInstance().clearVideoRecord();
    }

    public void f(String str) {
        if (str == null) {
            return;
        }
        d.b.b.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        mainDBDatabaseManager.e("delete from cash_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from mark_data where account=?", new String[]{str});
        mainDBDatabaseManager.e("delete from draft_box where account=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from account_data where id=?", new Object[]{str});
        mainDBDatabaseManager.e("delete from setting where account=?", new Object[]{str});
    }

    public String g() {
        AccountData accountData = this.f50631a;
        if (accountData != null) {
            return accountData.getID();
        }
        return null;
    }

    public String h() {
        String g2 = g();
        if (TextUtils.isEmpty(g2)) {
            AccountData e2 = d.b.h0.r.l.c.e();
            return e2 != null ? e2.getID() : "";
        }
        return g2;
    }

    public long i() {
        AccountData accountData = this.f50631a;
        if (accountData != null) {
            return d.b.b.e.m.b.f(accountData.getID(), 0L);
        }
        return 0L;
    }

    public AccountData j() {
        return this.f50631a;
    }

    public String k() {
        AccountData accountData = this.f50631a;
        if (accountData != null) {
            return accountData.getAccount();
        }
        return null;
    }

    public String l() {
        AccountData accountData = this.f50631a;
        if (accountData != null) {
            return accountData.getAccountNameShow();
        }
        return null;
    }

    public AccountData m() {
        return this.f50631a;
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
        AccountData accountData = this.f50631a;
        if (accountData != null) {
            return accountData.getBDUSS();
        }
        return null;
    }

    public int p() {
        AccountData accountData = this.f50631a;
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
        AccountData accountData = this.f50631a;
        if (accountData == null || accountData.getVipInfo() == null) {
            return 0;
        }
        return this.f50631a.getVipInfo().getVipLevel();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public String t(int i) {
        Cursor cursor;
        d.b.b.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        Cursor cursor2 = null;
        try {
            try {
                cursor = mainDBDatabaseManager.j("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
                try {
                    String string = cursor.moveToFirst() ? cursor.getString(2) : null;
                    d.b.b.e.m.a.a(cursor);
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    mainDBDatabaseManager.i(e, "getNoAccountData");
                    d.b.b.e.m.a.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = i;
                d.b.b.e.m.a.a(cursor2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.b.e.m.a.a(cursor2);
            throw th;
        }
    }

    public int u() {
        return this.i;
    }

    public int v() {
        return this.f50634d;
    }

    public String w() {
        AccountData accountData = this.f50631a;
        if (accountData != null) {
            return accountData.getTbs();
        }
        return null;
    }

    public int x() {
        return this.f50637g;
    }

    public int y() {
        return this.f50635e;
    }

    public void z() {
        long currentTimeMillis = System.currentTimeMillis();
        if (D(true)) {
            try {
                if (TbadkCoreApplication.getInst().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                    AccountData e2 = d.b.h0.r.l.c.e();
                    if (e2 != null) {
                        d.b.h0.r.z.a.a("account", -1L, 0, "application_init_account", 0, "", new Object[0]);
                        K(e2, TbadkCoreApplication.getInst());
                    } else {
                        d.b.h0.r.z.a.a("account", -1L, 0, "application_init_no_account", 0, "", new Object[0]);
                    }
                } else {
                    d.b.h0.r.z.a.a("account", -1L, 0, "application_bd_no_account", 0, "", new Object[0]);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            d.b.h0.m0.l.b().i(System.currentTimeMillis() - currentTimeMillis);
        }
    }
}
