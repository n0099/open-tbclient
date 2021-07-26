package d.a.q0.m1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.Info;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.Message;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.util.Date;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends BdAsyncTask<String, Integer, ClientUpdateInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ClientUpdater f60703a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f60704b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f60705c;

    /* renamed from: d  reason: collision with root package name */
    public String f60706d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60707e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f60708f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f60709g;

    /* renamed from: d.a.q0.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1541a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f60710e;

        public RunnableC1541a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60710e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f60710e.f60705c != null && "1".equals(this.f60710e.f60705c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(this.f60710e.f60705c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(this.f60710e.f60705c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(this.f60710e.f60705c.mVercode));
                versionData.setNewFile(this.f60710e.f60705c.mPackageName + this.f60710e.f60705c.mVername + ".apk");
                versionData.setHasNewVer(Integer.parseInt(this.f60710e.f60705c.mStatus));
                versionData.setNewVersionDesc(this.f60710e.f60705c.mChangelog);
                versionData.setUrl(this.f60710e.f60705c.mDownurl);
                versionData.setSize(this.f60710e.f60705c.mSize);
                versionData.setPatch(this.f60710e.f60705c.mPatchDownUrl);
                versionData.setPatchSize(this.f60710e.f60705c.mPatchSize);
                versionData.setTiebaIconUrl(this.f60710e.f60705c.mIconUrl);
                versionData.setApkMD5RSA(this.f60710e.f60705c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f60710e.f60705c, this.f60710e.f60706d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || this.f60710e.f60707e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f60710e.f60705c, this.f60710e.f60706d)));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IClientUpdaterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60711a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60711a = aVar;
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onCompleted(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, clientUpdateInfo, ruleInfo) == null) || clientUpdateInfo == null || TextUtils.isEmpty(this.f60711a.f60706d)) {
                return;
            }
            this.f60711a.f60705c = clientUpdateInfo;
            this.f60711a.f60708f.post(this.f60711a.f60709g);
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onError(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            }
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onException(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            }
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onFetched(JSONObject jSONObject) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject(Message.RULE)) == null || (optJSONObject2 = optJSONObject.optJSONObject(SchedulerSupport.CUSTOM)) == null) {
                return;
            }
            this.f60711a.f60706d = optJSONObject2.optString("apk_MD5_RSA");
        }
    }

    public a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60709g = new RunnableC1541a(this);
        this.f60707e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.f60703a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.f60703a.setUseRSA(false);
        this.f60703a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f60704b = new b(this);
        this.f60708f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.cancel();
            this.f60708f.removeCallbacks(this.f60709g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            this.f60703a.setOsName(Info.PASSWORD);
            this.f60703a.setTypeId("0");
            this.f60703a.setFrom("tieba");
            this.f60703a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
            this.f60703a.addParamValue("tieba_versionname", TbConfig.getVersion());
            this.f60703a.checkUpdate(this.f60704b);
            return null;
        }
        return (ClientUpdateInfo) invokeL.objValue;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPreExecute();
            this.f60708f.removeCallbacks(this.f60709g);
        }
    }
}
