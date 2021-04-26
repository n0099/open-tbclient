package d.a.i0.a;

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
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.i0.a.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f47832g = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f47833h = Pattern.compile("\\$(com.baidu.tieba://unidispatch/)[0-9a-zA-Z]{1,10}\\?[0-9a-zA-Z_=&%\\-.]{1,300}[$]", 2);

    /* renamed from: a  reason: collision with root package name */
    public boolean f47834a;

    /* renamed from: b  reason: collision with root package name */
    public long f47835b;

    /* renamed from: c  reason: collision with root package name */
    public t f47836c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.e f47837d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f47838e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public e.b f47839f = new a();

    /* loaded from: classes3.dex */
    public class a implements e.b {
        public a() {
        }

        @Override // d.a.i0.a.e.b
        public void a(boolean z, y yVar) {
            if (!z || yVar == null) {
                return;
            }
            d.this.o();
            d.this.p(yVar.a(), yVar.c());
            d.this.r(yVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.w().l(d.this.u());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.w().l(d.this.u());
        }
    }

    /* renamed from: d.a.i0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1015d extends d.a.c.c.g.a {
        public C1015d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage responsedMessage) {
            d.a.i0.a.g decryptData;
            d.this.f47838e.compareAndSet(true, false);
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
                if (MessageManager.getInstance().findTask(2921361) == null || decryptData.f47869g.equals(TbadkCoreApplication.getInst().getCurAiAppid())) {
                    return;
                }
                TbadkCoreApplication.getInst().setCurAiAppid(null);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
            } else if (g2 == 2) {
                d.this.p(decryptData.e(), decryptData.f());
            } else if (g2 == 4 || g2 != 3 || StringUtils.isNull(decryptData.f())) {
            } else {
                Uri parse = Uri.parse(decryptData.f());
                String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                String queryParameter5 = parse != null ? parse.getQueryParameter("eqid") : "";
                if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || !queryParameter2.startsWith("tbcm")) {
                    d.this.q(decryptData.f());
                    TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4).param("query", queryParameter5));
                    return;
                }
                d.this.q(decryptData.f());
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            d.this.l(d.this.u());
        }
    }

    /* loaded from: classes3.dex */
    public class f extends BdAsyncTask<String, Integer, String> {
        public f() {
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
                String x = d.this.x();
                if (!d.a.c.e.p.k.isEmpty(x) && (matcher = Pattern.compile(x).matcher(str)) != null && matcher.find()) {
                    return str;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((f) str);
            if (str == null) {
                if (d.this.f47836c == null || !d.this.z()) {
                    return;
                }
                d.this.f47836c.b();
                return;
            }
            d.this.m(str);
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BdAsyncTask<String, Integer, String> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            Matcher matcher;
            if (strArr != null && strArr.length >= 1) {
                String str = strArr[0];
                if (!d.a.c.e.p.k.isEmpty(str) && (matcher = d.f47833h.matcher(str)) != null && matcher.find()) {
                    return str;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((g) str);
            if (str != null) {
                d.this.q(str.substring(1, str.length() - 1));
            }
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
                if (!d.a.c.e.p.k.isEmpty(str) && (matcher = d.f47832g.matcher(str)) != null && matcher.find()) {
                    return str;
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((h) str);
            if (str == null || d.this.f47838e.get()) {
                return;
            }
            d.this.f47838e.compareAndSet(false, true);
            DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
            decryptCodeReqMsg.setCode(str);
            MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
        }
    }

    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public static final d f47848a = new d();
    }

    public static final d w() {
        return i.f47848a;
    }

    public final void A() {
        MessageManager.getInstance().registerListener(new C1015d(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626));
        MessageManager.getInstance().registerListener(new e(2001011));
    }

    public final void B() {
        d.a.j0.d3.d0.a.h(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, d.a.j0.d3.d0.a.a(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void k(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new f().execute(str);
    }

    public void l(String str) {
        k(str);
        n(str);
        s(str);
        t(str);
    }

    public final void m(String str) {
        this.f47837d.c(str);
    }

    public void n(String str) {
        if (d.a.c.e.p.k.isEmpty(str) || !str.contains("^sZqulxTVsT$")) {
            return;
        }
        m(str);
    }

    public final void o() {
        UtilHelper.clearClipBoard();
    }

    public final void p(String str, String str2) {
        TbPageContext<?> v;
        if (d.a.c.e.p.k.isEmpty(str2) || (v = v(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(v, str, new String[]{str2});
    }

    public final void q(String str) {
        Activity currentActivity;
        Uri parse;
        if (d.a.c.e.p.k.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (parse = Uri.parse(str)) == null) {
            return;
        }
        if (str.startsWith(d.a.i0.a.f.f47853a)) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(d.a.i0.a.f.w, d.a.i0.a.f.L);
            parse = buildUpon.build();
        }
        UtilHelper.dealOneScheme(currentActivity, parse.toString());
    }

    public final void r(y yVar) {
        if (yVar == null || yVar.b() == null || d.a.c.e.p.k.isEmpty(yVar.b().f47942a) || !z()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, yVar.b().f47942a));
    }

    public void s(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new h().execute(str);
    }

    public void t(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new g().execute(str);
    }

    public final String u() {
        if (System.currentTimeMillis() - this.f47835b < 2000) {
            return null;
        }
        this.f47835b = System.currentTimeMillis();
        return UtilHelper.getClipBoardContent();
    }

    public final TbPageContext v(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public final String x() {
        return new String(Base64.decode(d.a.i0.r.d0.b.j().p("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
    }

    public void y(Activity activity) {
        if (this.f47834a) {
            return;
        }
        B();
        A();
        d.a.i0.a.e eVar = new d.a.i0.a.e();
        this.f47837d = eVar;
        eVar.g(this.f47839f);
        this.f47836c = new t();
        String u = u();
        if (!d.a.c.e.p.k.isEmpty(u)) {
            w().l(u);
        } else if (UtilHelper.isActivityStartFromScheme(activity)) {
            d.a.c.e.m.e.a().postDelayed(new b(), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        } else if (RomTypeUtil.isEmui() || RomTypeUtil.isOnePlus()) {
            d.a.c.e.m.e.a().postDelayed(new c(), 2000L);
        }
        this.f47834a = true;
    }

    public final boolean z() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !d.a.c.e.p.k.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }
}
