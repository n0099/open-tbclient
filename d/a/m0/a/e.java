package d.a.m0.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.DecryptCodeHttpRespMsg;
import com.baidu.tbadk.BdToken.DecryptCodeReqMsg;
import com.baidu.tbadk.BdToken.DecryptCodeSocketRespMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckHttpResMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckReqMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.m0.a.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f52335h = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f52336i = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2);
    public static final Pattern j = Pattern.compile("\\$(com.baidu.tieba://unidispatch/)[0-9a-zA-Z]{1,10}\\?[0-9a-zA-Z_=&%\\-.]{1,300}[$]", 2);

    /* renamed from: a  reason: collision with root package name */
    public boolean f52337a;

    /* renamed from: b  reason: collision with root package name */
    public long f52338b;

    /* renamed from: c  reason: collision with root package name */
    public v f52339c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.f f52340d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f52341e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f52342f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public f.b f52343g = new b();

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, l> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public l doInBackground(String... strArr) {
            Matcher matcher;
            if (strArr == null || strArr.length < 1) {
                return null;
            }
            String str = strArr[0];
            if (!d.a.c.e.p.k.isEmpty(str) && (matcher = e.f52336i.matcher(str)) != null && matcher.find() && matcher.groupCount() >= 2) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (TextUtils.isEmpty(group2)) {
                    return null;
                }
                UserData b2 = d.a.m0.z.b.a().b();
                String tiebaUid = b2 != null ? b2.getTiebaUid() : "";
                if ((TextUtils.isEmpty(group) || !group.equals(TbadkCoreApplication.getCurrentAccountNameShow())) && !group2.equals(tiebaUid)) {
                    l lVar = new l();
                    lVar.c(group);
                    lVar.d(group2);
                    return lVar;
                }
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(l lVar) {
            super.onPostExecute(lVar);
            if (lVar == null || e.this.f52342f.get()) {
                return;
            }
            e.this.f52342f.compareAndSet(false, true);
            TiebaUidCheckReqMsg tiebaUidCheckReqMsg = new TiebaUidCheckReqMsg();
            tiebaUidCheckReqMsg.setTiebaUid(lVar);
            MessageManager.getInstance().sendMessage(tiebaUidCheckReqMsg);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.b {
        public b() {
        }

        @Override // d.a.m0.a.f.b
        public void a(boolean z, b0 b0Var) {
            if (!z || b0Var == null) {
                return;
            }
            e.this.p();
            e.this.q(b0Var.a(), b0Var.c());
            e.this.s(b0Var);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.y().m(e.this.w());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.y().m(e.this.w());
        }
    }

    /* renamed from: d.a.m0.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1153e extends d.a.c.c.g.a {
        public C1153e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage responsedMessage) {
            d.a.m0.a.i decryptData;
            e.this.f52341e.compareAndSet(true, false);
            if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
            } else if (!(responsedMessage instanceof DecryptCodeSocketRespMsg)) {
                return;
            } else {
                decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
            }
            if (decryptData == null) {
                return;
            }
            UtilHelper.clearClipBoard();
            int g2 = decryptData.g();
            if (g2 == 1 || g2 == 0) {
                if (MessageManager.getInstance().findTask(2921361) == null || decryptData.f52406g.equals(TbadkCoreApplication.getInst().getCurAiAppid())) {
                    return;
                }
                TbadkCoreApplication.getInst().setCurAiAppid(null);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
            } else if (g2 == 2) {
                e.this.q(decryptData.e(), decryptData.f());
            } else if (g2 == 4 || g2 != 3 || StringUtils.isNull(decryptData.f())) {
            } else {
                Uri parse = Uri.parse(decryptData.f());
                String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                String queryParameter5 = parse != null ? parse.getQueryParameter("eqid") : "";
                if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || !queryParameter2.startsWith("tbcm")) {
                    e.this.r(decryptData.f());
                    TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4).param("query", queryParameter5));
                    return;
                }
                e.this.r(decryptData.f());
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends d.a.c.c.g.a {
        public f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tbadk.core.data.UserData userData;
            TiebaUidCheckReqMsg tiebaUidCheckReqMsg;
            e.this.f52342f.compareAndSet(true, false);
            if (responsedMessage instanceof TiebaUidCheckSocketResMsg) {
                userData = ((TiebaUidCheckSocketResMsg) responsedMessage).getUserData();
            } else if (!(responsedMessage instanceof TiebaUidCheckHttpResMsg)) {
                return;
            } else {
                userData = ((TiebaUidCheckHttpResMsg) responsedMessage).getUserData();
            }
            l lVar = (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof TiebaUidCheckReqMsg) || (tiebaUidCheckReqMsg = (TiebaUidCheckReqMsg) responsedMessage.getOrginalMessage().getExtra()) == null) ? null : tiebaUidCheckReqMsg.mTiebaUidData;
            if (userData == null || lVar == null) {
                return;
            }
            UtilHelper.clearClipBoard();
            z d2 = z.d();
            d2.b();
            d2.e(userData, lVar);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            e.this.m(e.this.w());
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<String, Integer, String> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Matcher matcher;
            if (strArr != null && strArr.length >= 1) {
                String str = strArr[0];
                if (d.a.c.e.p.k.isEmpty(str)) {
                    return null;
                }
                String z = e.this.z();
                if (!d.a.c.e.p.k.isEmpty(z) && (matcher = Pattern.compile(z).matcher(str)) != null && matcher.find()) {
                    return str;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((h) str);
            if (str == null) {
                if (e.this.f52339c == null || !e.this.B()) {
                    return;
                }
                e.this.f52339c.b();
                return;
            }
            e.this.n(str);
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<String, Integer, String> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Matcher matcher;
            if (strArr != null && strArr.length >= 1) {
                String str = strArr[0];
                if (!d.a.c.e.p.k.isEmpty(str) && (matcher = e.j.matcher(str)) != null && matcher.find()) {
                    return str;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((i) str);
            if (str != null) {
                e.this.r(str.substring(1, str.length() - 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Matcher matcher;
            if (strArr != null && strArr.length >= 1) {
                String str = strArr[0];
                if (!d.a.c.e.p.k.isEmpty(str) && (matcher = e.f52335h.matcher(str)) != null && matcher.find()) {
                    return str;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((j) str);
            if (str == null || e.this.f52341e.get()) {
                return;
            }
            e.this.f52341e.compareAndSet(false, true);
            DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
            decryptCodeReqMsg.setCode(str);
            MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
        }
    }

    /* loaded from: classes3.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public static final e f52354a = new e();
    }

    /* loaded from: classes3.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public String f52355a;

        /* renamed from: b  reason: collision with root package name */
        public String f52356b;

        public String a() {
            return this.f52355a;
        }

        public String b() {
            return this.f52356b;
        }

        public void c(String str) {
            this.f52355a = str;
        }

        public void d(String str) {
            this.f52356b = str;
        }
    }

    public static final e y() {
        return k.f52354a;
    }

    public void A(Activity activity) {
        if (this.f52337a) {
            return;
        }
        C();
        E();
        D();
        d.a.m0.a.f fVar = new d.a.m0.a.f();
        this.f52340d = fVar;
        fVar.g(this.f52343g);
        this.f52339c = new v();
        String w = w();
        if (!d.a.c.e.p.k.isEmpty(w)) {
            y().m(w);
        } else if (UtilHelper.isActivityStartFromScheme(activity)) {
            d.a.c.e.m.e.a().postDelayed(new c(), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        } else if (RomTypeUtil.isEmui() || RomTypeUtil.isOnePlus() || RomTypeUtil.check("MIUI")) {
            d.a.c.e.m.e.a().postDelayed(new d(), 2000L);
        }
        this.f52337a = true;
    }

    public final boolean B() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !d.a.c.e.p.k.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    public final void C() {
        d.a.n0.e3.d0.a.h(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, d.a.n0.e3.d0.a.a(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void D() {
        MessageManager.getInstance().registerListener(new C1153e(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626));
        MessageManager.getInstance().registerListener(new f(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, 309702));
        MessageManager.getInstance().registerListener(new g(2001011));
    }

    public final void E() {
        d.a.n0.e3.d0.a.h(309702, TiebaUidCheckSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, d.a.n0.e3.d0.a.a(TbConfig.URL_GET_USER_BY_TIEBA_UID, 309702));
        tbHttpMessageTask.setResponsedClass(TiebaUidCheckHttpResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void l(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new h().execute(str);
    }

    public void m(String str) {
        l(str);
        o(str);
        t(str);
        u(str);
        v(str);
    }

    public final void n(String str) {
        this.f52340d.c(str);
    }

    public void o(String str) {
        if (d.a.c.e.p.k.isEmpty(str) || !str.contains("^sZqulxTVsT$")) {
            return;
        }
        n(str);
    }

    public final void p() {
        UtilHelper.clearClipBoard();
    }

    public final void q(String str, String str2) {
        TbPageContext<?> x;
        if (d.a.c.e.p.k.isEmpty(str2) || (x = x(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(x, str, new String[]{str2});
    }

    public final void r(String str) {
        Activity currentActivity;
        Uri parse;
        if (d.a.c.e.p.k.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (parse = Uri.parse(str)) == null) {
            return;
        }
        if (str.startsWith(d.a.m0.a.g.f52385a)) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(d.a.m0.a.g.w, d.a.m0.a.g.R);
            parse = buildUpon.build();
        }
        UtilHelper.dealOneScheme(currentActivity, parse.toString());
    }

    public final void s(b0 b0Var) {
        if (b0Var == null || b0Var.b() == null || d.a.c.e.p.k.isEmpty(b0Var.b().f52286a) || !B()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, b0Var.b().f52286a));
    }

    public void t(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new j().execute(str);
    }

    public void u(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new i().execute(str);
    }

    public void v(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new a().execute(str);
    }

    public final String w() {
        if (System.currentTimeMillis() - this.f52338b < 2000) {
            return null;
        }
        this.f52338b = System.currentTimeMillis();
        return UtilHelper.getClipBoardContent();
    }

    public final TbPageContext x(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public final String z() {
        return new String(Base64.decode(d.a.m0.r.d0.b.j().p("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
    }
}
