package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.handler.CrashHandler;
import com.yy.hiidostatis.defs.interf.IOnStatisListener;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.Preference;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.StringUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.hdid.ClientIdProxy;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.hdid.UuidManager;
import com.yy.hiidostatis.inner.util.http.HttpUtil;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.pref.HdStatisConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CrashController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EXPIRES_DAY = 5;
    public static final String PREF_NAME = "hd_crash_pref";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public CrashHandler mCrashHandler;
    public boolean mIsSpecialDo;
    public OnCrashListener mOnCrashListener;
    public IOnStatisListener mOnStatisListener;
    public Preference mPreference;
    public IStatisAPI mStatisAPI;

    /* loaded from: classes8.dex */
    public interface OnCrashListener {
        void handler(JSONObject jSONObject);
    }

    private boolean report(JSONObject jSONObject) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, jSONObject)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void flushCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public CrashController(Context context, IStatisAPI iStatisAPI, IOnStatisListener iOnStatisListener, OnCrashListener onCrashListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iStatisAPI, iOnStatisListener, onCrashListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPreference = new Preference(PREF_NAME);
        this.mIsSpecialDo = false;
        this.mContext = context;
        this.mStatisAPI = iStatisAPI;
        this.mOnStatisListener = iOnStatisListener;
        this.mOnCrashListener = onCrashListener;
    }

    private void clearInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            try {
                this.mPreference.clearKey(this.mContext, str);
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
            }
        }
    }

    private boolean delFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return false;
                }
                if (!file.delete()) {
                    return false;
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private String parseCrashId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            return new File(str).getName().replaceAll(".dmp", "");
        }
        return (String) invokeL.objValue;
    }

    private String parseJsonFilePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, str)) == null) {
            return str.replaceAll(".dmp", ".json");
        }
        return (String) invokeL.objValue;
    }

    private String parseZipFilePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            return str.replaceAll(".dmp", ".zip");
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, jSONObject) == null) {
            try {
                this.mPreference.setPrefString(this.mContext, jSONObject.getString("crashid"), jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean doExpire(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, jSONObject)) == null) {
            try {
                if (Util.daysBetween(Long.parseLong(jSONObject.getString("time")) * 1000, Util.wallTimeMillis()) > 5) {
                    String string = jSONObject.getString("crashid");
                    L.warn("CrashController", "del expires crash data: crashId = %s", string);
                    clearInfo(string);
                    delFile(jSONObject.getString("dpath"));
                    delFile(jSONObject.getString("lpath"));
                    return true;
                }
            } catch (Throwable th) {
                L.debug("CrashController", "deal expires error,%s", th);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private synchronized void doFlushCache() {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            synchronized (this) {
                if (!this.mIsSpecialDo && Build.VERSION.SDK_INT >= 21) {
                    this.mIsSpecialDo = true;
                    doSpecial();
                }
                Map<String, ?> all = getAll();
                Object[] objArr = new Object[1];
                if (all == null) {
                    size = 0;
                } else {
                    size = all.size();
                }
                objArr[0] = Integer.valueOf(size);
                L.brief("all crash size = %d", objArr);
                if (all != null && all.size() > 0) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        String key = entry.getKey();
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        L.brief("get crashid = %s", key);
                        if (!doExpire(jSONObject)) {
                            if (!report(jSONObject)) {
                                break;
                            }
                            clearInfo(key);
                            delFile(jSONObject.getString("dpath"));
                            delFile(jSONObject.getString("lpath"));
                            L.brief("del crashid = %s", key);
                        }
                    }
                }
            }
        }
    }

    private boolean doReport(String str, Map<String, String> map, Map<String, String> map2, int i) {
        InterceptResult invokeLLLI;
        HttpUtil.HttpResp postFileByUrlConn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65544, this, str, map, map2, i)) == null) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    break;
                }
                try {
                    postFileByUrlConn = HttpUtil.postFileByUrlConn(str, map, map2);
                } catch (Throwable th) {
                    Object[] objArr = new Object[2];
                    objArr[z ? 1 : 0] = Integer.valueOf(i3);
                    objArr[1] = th;
                    L.debug(this, "doReport exception. tryTimes=%d exception=%s", objArr);
                }
                if (postFileByUrlConn.isSucceed) {
                    Object[] objArr2 = new Object[2];
                    objArr2[z ? 1 : 0] = Integer.valueOf(i3);
                    objArr2[1] = Integer.valueOf(postFileByUrlConn.statusCode);
                    L.debug(this, "doReport succeed.tryTimes:%d,statusCode:%d,", objArr2);
                    z = postFileByUrlConn.isSucceed;
                    break;
                }
                Object[] objArr3 = new Object[3];
                objArr3[z ? 1 : 0] = Integer.valueOf(i3);
                objArr3[1] = Integer.valueOf(postFileByUrlConn.statusCode);
                objArr3[2] = postFileByUrlConn.reason + "";
                L.warn(this, "doReport failed.tryTimes:%d,statusCode:%d,reason:%s", objArr3);
                i2 = i3;
            }
            return z;
        }
        return invokeLLLI.booleanValue;
    }

    private void doSpecial() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            try {
                for (File file : new File(this.mCrashHandler.getDmpPath()).listFiles(new FilenameFilter(this) { // from class: com.yy.hiidostatis.defs.controller.CrashController.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CrashController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file2, str)) == null) {
                            if (str != null && !str.startsWith("J-") && str.endsWith(".dmp")) {
                                return true;
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                })) {
                    String absolutePath = file.getAbsolutePath();
                    String replace = absolutePath.replace(".dmp", ".log");
                    if (!FileUtil.isExist(replace)) {
                        String valueOf = String.valueOf(Util.millisToSec(file.lastModified()));
                        L.brief("timetime = %s", valueOf);
                        FileUtil.writeFile(replace, "");
                        saveInfo(fillInfo(2, valueOf, absolutePath, replace));
                    }
                }
            } catch (Throwable th) {
                L.debug(this, "doSpecial exception.%s", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject fillInfo(int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i), str, str2, str3})) == null) {
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                try {
                    str = String.valueOf(Util.wallTimeSec());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            jSONObject.put("act", "mbsdkhdcrash");
            jSONObject.put("time", str);
            jSONObject.put("key", CommonFiller.calKey("mbsdkhdcrash", str));
            jSONObject.put("lpath", str3);
            jSONObject.put("dpath", str2);
            jSONObject.put("crashid", parseCrashId(str2));
            jSONObject.put("ctyp", i);
            jSONObject.put("uid", this.mOnStatisListener.getCurrentUid());
            jSONObject.put("app", this.mStatisAPI.getOption().getAppId());
            jSONObject.put("appkey", this.mStatisAPI.getOption().getAppkey());
            jSONObject.put("ver", this.mStatisAPI.getOption().getVer());
            jSONObject.put("from", this.mStatisAPI.getOption().getFrom());
            jSONObject.put(BaseStatisContent.SESSIONID, this.mStatisAPI.getSession());
            jSONObject.put(BaseStatisContent.SDKVER, HdStatisConfig.getConfig(this.mStatisAPI.getOption().getAppkey()).getSdkVer());
            jSONObject.put("imei", CommonFiller.getIMEI(this.mContext));
            jSONObject.put("mac", CommonFiller.getMacAddr(this.mContext));
            jSONObject.put(BaseStatisContent.SJP, ArdUtil.getSjp(this.mContext));
            jSONObject.put("sjm", ArdUtil.getSjm(this.mContext));
            jSONObject.put("sys", 2);
            jSONObject.put("mbos", ArdUtil.getOS());
            jSONObject.put(BaseStatisContent.MBL, ArdUtil.getLang());
            jSONObject.put(BaseStatisContent.NTM, ArdUtil.getNtm(this.mContext));
            jSONObject.put("net", ArdUtil.getNetworkTypeNew(this.mContext));
            jSONObject.put(BaseStatisContent.SR, ArdUtil.getScreenResolution(this.mContext));
            if (ArdUtil.isRoot()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            jSONObject.put("rot", i2);
            jSONObject.put("tram", ArdUtil.getTotalMemory(this.mContext));
            jSONObject.put("trom", ArdUtil.getTotalInternalStorgeSize());
            jSONObject.put("tsd", 0);
            jSONObject.put("aram", ArdUtil.getAvailMemory(this.mContext));
            jSONObject.put("arom", ArdUtil.getAvailInternalStorgeSize());
            jSONObject.put("asd", 0);
            jSONObject.put(BaseStatisContent.ARID, CommonFiller.getAndroidId(this.mContext));
            jSONObject.put(BaseStatisContent.OPID, ClientIdProxy.getClientId(this.mContext));
            jSONObject.put("hdid", DeviceProxy.getHdid(this.mContext));
            jSONObject.put(BaseStatisContent.IMC, ArdUtil.getImei(this.mContext) + "," + CommonFiller.getMacAddr(this.mContext));
            jSONObject.put(BaseStatisContent.IMSI, ArdUtil.getImsi(this.mContext));
            jSONObject.put(BaseStatisContent.IDFV, UuidManager.fetchUUid(this.mContext));
            jSONObject.put(BaseStatisContent.GUID, StringUtil.geneGuid());
            jSONObject.put("rtyp", 1);
            Long launchTime = this.mStatisAPI.getLaunchTime();
            if (launchTime != null) {
                jSONObject.put("ltime", (System.currentTimeMillis() - launchTime.longValue()) / 1000);
            }
            jSONObject.put("cpage", DefaultPreference.getPreference().getPrefString(this.mContext, HdStatisConfig.PREF_CPAGE, null));
            jSONObject.put("cpkg", ArdUtil.getPackageName(this.mContext));
            jSONObject.put("cthread", ProcessUtil.getCurProcessName(this.mContext) + "#" + Process.myTid());
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    private Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            return this.mPreference.getAll(this.mContext);
        }
        return (Map) invokeV.objValue;
    }

    public void startCrashMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mCrashHandler != null) {
                L.warn(this, "crash monitor has been started.", new Object[0]);
                return;
            }
            CrashHandler crashHandler = new CrashHandler(this.mContext, this.mStatisAPI, this.mOnStatisListener, new CrashHandler.OnHandlerListener(this) { // from class: com.yy.hiidostatis.defs.controller.CrashController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CrashController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.yy.hiidostatis.defs.handler.CrashHandler.OnHandlerListener
                public void handler(int i, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i, str, str2) == null) {
                        JSONObject fillInfo = this.this$0.fillInfo(i, null, str, str2);
                        this.this$0.saveInfo(fillInfo);
                        this.this$0.flushCache();
                        if (this.this$0.mOnCrashListener != null) {
                            this.this$0.mOnCrashListener.handler(fillInfo);
                        }
                    }
                }
            });
            this.mCrashHandler = crashHandler;
            crashHandler.init();
            flushCache();
            L.debug(this, "crash monitor start", new Object[0]);
        }
    }
}
