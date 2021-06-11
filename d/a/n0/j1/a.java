package d.a.n0.j1;

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
    public ClientUpdater f59934a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f59935b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f59936c;

    /* renamed from: d  reason: collision with root package name */
    public String f59937d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59938e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f59939f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f59940g = new RunnableC1446a();

    /* renamed from: d.a.n0.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1446a implements Runnable {
        public RunnableC1446a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f59936c != null && "1".equals(a.this.f59936c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(a.this.f59936c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(a.this.f59936c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(a.this.f59936c.mVercode));
                versionData.setNewFile(a.this.f59936c.mPackageName + a.this.f59936c.mVername + ".apk");
                versionData.setHasNewVer(Integer.parseInt(a.this.f59936c.mStatus));
                versionData.setNewVersionDesc(a.this.f59936c.mChangelog);
                versionData.setUrl(a.this.f59936c.mDownurl);
                versionData.setSize(a.this.f59936c.mSize);
                versionData.setPatch(a.this.f59936c.mPatchDownUrl);
                versionData.setPatchSize(a.this.f59936c.mPatchSize);
                versionData.setTiebaIconUrl(a.this.f59936c.mIconUrl);
                versionData.setApkMD5RSA(a.this.f59936c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f59936c, a.this.f59937d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || a.this.f59938e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f59936c, a.this.f59937d)));
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
            if (clientUpdateInfo == null || TextUtils.isEmpty(a.this.f59937d)) {
                return;
            }
            a.this.f59936c = clientUpdateInfo;
            a.this.f59939f.post(a.this.f59940g);
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
            a.this.f59937d = optJSONObject2.optString("apk_MD5_RSA");
        }
    }

    public a(boolean z) {
        this.f59938e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.f59934a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.f59934a.setUseRSA(false);
        this.f59934a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f59935b = new b();
        this.f59939f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f59939f.removeCallbacks(this.f59940g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        this.f59934a.setOsName(Info.PASSWORD);
        this.f59934a.setTypeId("0");
        this.f59934a.setFrom("tieba");
        this.f59934a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
        this.f59934a.addParamValue("tieba_versionname", TbConfig.getVersion());
        this.f59934a.checkUpdate(this.f59935b);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.f59939f.removeCallbacks(this.f59940g);
    }
}
