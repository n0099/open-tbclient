package d.a.o0.j1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.appsearchlib.Info;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.heytap.mcssdk.mode.Message;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdAsyncTask<String, Integer, ClientUpdateInfo> {

    /* renamed from: a  reason: collision with root package name */
    public ClientUpdater f60059a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f60060b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f60061c;

    /* renamed from: d  reason: collision with root package name */
    public String f60062d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60063e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f60064f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f60065g = new RunnableC1450a();

    /* renamed from: d.a.o0.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1450a implements Runnable {
        public RunnableC1450a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f60061c != null && "1".equals(a.this.f60061c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(a.this.f60061c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(a.this.f60061c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(a.this.f60061c.mVercode));
                versionData.setNewFile(a.this.f60061c.mPackageName + a.this.f60061c.mVername + ".apk");
                versionData.setHasNewVer(Integer.parseInt(a.this.f60061c.mStatus));
                versionData.setNewVersionDesc(a.this.f60061c.mChangelog);
                versionData.setUrl(a.this.f60061c.mDownurl);
                versionData.setSize(a.this.f60061c.mSize);
                versionData.setPatch(a.this.f60061c.mPatchDownUrl);
                versionData.setPatchSize(a.this.f60061c.mPatchSize);
                versionData.setTiebaIconUrl(a.this.f60061c.mIconUrl);
                versionData.setApkMD5RSA(a.this.f60061c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f60061c, a.this.f60062d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || a.this.f60063e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f60061c, a.this.f60062d)));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements IClientUpdaterCallback {
        public b() {
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onCompleted(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo) {
            if (clientUpdateInfo == null || TextUtils.isEmpty(a.this.f60062d)) {
                return;
            }
            a.this.f60061c = clientUpdateInfo;
            a.this.f60064f.post(a.this.f60065g);
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onError(JSONObject jSONObject) {
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onException(JSONObject jSONObject) {
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onFetched(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(Message.RULE)) == null || (optJSONObject2 = optJSONObject.optJSONObject(SchedulerSupport.CUSTOM)) == null) {
                return;
            }
            a.this.f60062d = optJSONObject2.optString("apk_MD5_RSA");
        }
    }

    public a(boolean z) {
        this.f60063e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.f60059a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.f60059a.setUseRSA(false);
        this.f60059a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f60060b = new b();
        this.f60064f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f60064f.removeCallbacks(this.f60065g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        this.f60059a.setOsName(Info.PASSWORD);
        this.f60059a.setTypeId("0");
        this.f60059a.setFrom("tieba");
        this.f60059a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
        this.f60059a.addParamValue("tieba_versionname", TbConfig.getVersion());
        this.f60059a.checkUpdate(this.f60060b);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.f60064f.removeCallbacks(this.f60065g);
    }
}
