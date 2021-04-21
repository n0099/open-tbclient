package d.b.j0.i1;

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
import java.io.IOException;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdAsyncTask<String, Integer, ClientUpdateInfo> {

    /* renamed from: a  reason: collision with root package name */
    public ClientUpdater f57414a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f57415b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f57416c;

    /* renamed from: d  reason: collision with root package name */
    public String f57417d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57418e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f57419f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f57420g = new RunnableC1361a();

    /* renamed from: d.b.j0.i1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1361a implements Runnable {
        public RunnableC1361a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f57416c != null && "1".equals(a.this.f57416c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(a.this.f57416c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(a.this.f57416c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(a.this.f57416c.mVercode));
                versionData.setNewFile(a.this.f57416c.mPackageName + a.this.f57416c.mVername + ".apk");
                versionData.setHasNewVer(Integer.parseInt(a.this.f57416c.mStatus));
                versionData.setNewVersionDesc(a.this.f57416c.mChangelog);
                versionData.setUrl(a.this.f57416c.mDownurl);
                versionData.setSize(a.this.f57416c.mSize);
                versionData.setPatch(a.this.f57416c.mPatchDownUrl);
                versionData.setPatchSize(a.this.f57416c.mPatchSize);
                versionData.setTiebaIconUrl(a.this.f57416c.mIconUrl);
                versionData.setApkMD5RSA(a.this.f57416c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f57416c, a.this.f57417d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || a.this.f57418e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), a.this.f57416c, a.this.f57417d)));
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
            if (clientUpdateInfo == null || TextUtils.isEmpty(a.this.f57417d)) {
                return;
            }
            a.this.f57416c = clientUpdateInfo;
            a.this.f57419f.post(a.this.f57420g);
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
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(Message.RULE)) == null || (optJSONObject2 = optJSONObject.optJSONObject("custom")) == null) {
                return;
            }
            a.this.f57417d = optJSONObject2.optString("apk_MD5_RSA");
        }
    }

    public a(boolean z) {
        this.f57418e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.f57414a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.f57414a.setUseRSA(false);
        this.f57414a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f57415b = new b();
        this.f57419f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.f57419f.removeCallbacks(this.f57420g);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        this.f57414a.setOsName(Info.PASSWORD);
        this.f57414a.setTypeId("0");
        this.f57414a.setFrom("tieba");
        this.f57414a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
        this.f57414a.addParamValue("tieba_versionname", TbConfig.getVersion());
        this.f57414a.checkUpdate(this.f57415b);
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.f57419f.removeCallbacks(this.f57420g);
    }
}
