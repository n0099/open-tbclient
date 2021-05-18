package d.a.k0.i1;

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
    public ClientUpdater f56061a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f56062b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f56063c;

    /* renamed from: d  reason: collision with root package name */
    public String f56064d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56065e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f56066f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f56067g = new RunnableC1372a();

    /* renamed from: d.a.k0.i1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1372a implements Runnable {
        public RunnableC1372a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f56063c != null && "1".equals(a.this.f56063c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(a.this.f56063c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(a.this.f56063c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(a.this.f56063c.mVercode));
                versionData.setNewFile(a.this.f56063c.mPackageName + a.this.f56063c.mVername + ".apk");
                versionData.setHasNewVer(Integer.parseInt(a.this.f56063c.mStatus));
                versionData.setNewVersionDesc(a.this.f56063c.mChangelog);
                versionData.setUrl(a.this.f56063c.mDownurl);
                versionData.setSize(a.this.f56063c.mSize);
                versionData.setPatch(a.this.f56063c.mPatchDownUrl);
                versionData.setPatchSize(a.this.f56063c.mPatchSize);
                versionData.setTiebaIconUrl(a.this.f56063c.mIconUrl);
                versionData.setApkMD5RSA(a.this.f56063c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f56063c, a.this.f56064d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || a.this.f56065e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f56063c, a.this.f56064d)));
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
            if (clientUpdateInfo == null || TextUtils.isEmpty(a.this.f56064d)) {
                return;
            }
            a.this.f56063c = clientUpdateInfo;
            a.this.f56066f.post(a.this.f56067g);
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
            a.this.f56064d = optJSONObject2.optString("apk_MD5_RSA");
        }
    }

    public a(boolean z) {
        this.f56065e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.f56061a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.f56061a.setUseRSA(false);
        this.f56061a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f56062b = new b();
        this.f56066f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f56066f.removeCallbacks(this.f56067g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        this.f56061a.setOsName(Info.PASSWORD);
        this.f56061a.setTypeId("0");
        this.f56061a.setFrom("tieba");
        this.f56061a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
        this.f56061a.addParamValue("tieba_versionname", TbConfig.getVersion());
        this.f56061a.checkUpdate(this.f56062b);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.f56066f.removeCallbacks(this.f56067g);
    }
}
