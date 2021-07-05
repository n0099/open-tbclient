package d.a.s0.m1;

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
/* loaded from: classes9.dex */
public class a extends BdAsyncTask<String, Integer, ClientUpdateInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ClientUpdater f63326a;

    /* renamed from: b  reason: collision with root package name */
    public IClientUpdaterCallback f63327b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ClientUpdateInfo f63328c;

    /* renamed from: d  reason: collision with root package name */
    public String f63329d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63330e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f63331f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f63332g;

    /* renamed from: d.a.s0.m1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1580a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63333e;

        public RunnableC1580a(a aVar) {
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
            this.f63333e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f63333e.f63328c != null && "1".equals(this.f63333e.f63328c.mStatus) && TbConfig.COULD_UPDATE) {
                VersionData versionData = new VersionData();
                versionData.setForceUpdate(Integer.parseInt(this.f63333e.f63328c.mIsForceUpdate));
                versionData.setStrategy(0);
                versionData.setNewVersion(this.f63333e.f63328c.mVername);
                versionData.setNewVersionCode(Integer.parseInt(this.f63333e.f63328c.mVercode));
                versionData.setNewFile(this.f63333e.f63328c.mPackageName + this.f63333e.f63328c.mVername + ".apk");
                versionData.setHasNewVer(Integer.parseInt(this.f63333e.f63328c.mStatus));
                versionData.setNewVersionDesc(this.f63333e.f63328c.mChangelog);
                versionData.setUrl(this.f63333e.f63328c.mDownurl);
                versionData.setSize(this.f63333e.f63328c.mSize);
                versionData.setPatch(this.f63333e.f63328c.mPatchDownUrl);
                versionData.setPatchSize(this.f63333e.f63328c.mPatchSize);
                versionData.setTiebaIconUrl(this.f63333e.f63328c.mIconUrl);
                versionData.setApkMD5RSA(this.f63333e.f63328c.mSignMd5);
                TbadkCoreApplication.getInst().setVersionData(versionData);
                TbadkCoreApplication.getInst().refreshNewVersion(true);
                if (TbadkCoreApplication.getInst().getResumeNum() > 0) {
                    if (versionData.forceUpdate()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f63333e.f63328c, this.f63333e.f63329d)));
                        return;
                    }
                    Long valueOf = Long.valueOf(TbadkCoreApplication.getInst().getUpdateNotifyTime());
                    Long valueOf2 = Long.valueOf(new Date().getTime());
                    if ((valueOf2.longValue() - valueOf.longValue() > 86400000 || this.f63333e.f63330e) && versionData.getStrategy() == 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LcUpdateDialogActivityConfig(TbadkCoreApplication.getInst().getApp(), this.f63333e.f63328c, this.f63333e.f63329d)));
                        TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf2.longValue());
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements IClientUpdaterCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63334a;

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
            this.f63334a = aVar;
        }

        @Override // com.baidu.clientupdate.IClientUpdaterCallback
        public void onCompleted(ClientUpdateInfo clientUpdateInfo, RuleInfo ruleInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, clientUpdateInfo, ruleInfo) == null) || clientUpdateInfo == null || TextUtils.isEmpty(this.f63334a.f63329d)) {
                return;
            }
            this.f63334a.f63328c = clientUpdateInfo;
            this.f63334a.f63331f.post(this.f63334a.f63332g);
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
            this.f63334a.f63329d = optJSONObject2.optString("apk_MD5_RSA");
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
        this.f63332g = new RunnableC1580a(this);
        this.f63330e = z;
        ClientUpdater clientUpdater = ClientUpdater.getInstance(TbadkCoreApplication.getInst());
        this.f63326a = clientUpdater;
        clientUpdater.setUseCFG(false);
        this.f63326a.setUseRSA(false);
        this.f63326a.setFileProvider("com.baidu.tieba.fileprovider");
        this.f63327b = new b(this);
        this.f63331f = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.cancel();
            this.f63331f.removeCallbacks(this.f63332g);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public ClientUpdateInfo doInBackground(String... strArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            this.f63326a.setOsName(Info.PASSWORD);
            this.f63326a.setTypeId("0");
            this.f63326a.setFrom("tieba");
            this.f63326a.addParamValue("versionType", String.valueOf(TbConfig.getVersionType()));
            this.f63326a.addParamValue("tieba_versionname", TbConfig.getVersion());
            this.f63326a.checkUpdate(this.f63327b);
            return null;
        }
        return (ClientUpdateInfo) invokeL.objValue;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPreExecute();
            this.f63331f.removeCallbacks(this.f63332g);
        }
    }
}
