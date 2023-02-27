package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HMS_SESSION_INVALID = "com.huawei.hms.core.action.SESSION_INVALID";
    public static final String TAG = "BaseAdapter";
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> activityWeakReference;
    public WeakReference<ApiClient> api;
    public Context appContext;
    public BaseCallBack baseCallBackReplay;
    public BaseCallBack callback;
    public String jsonHeaderReplay;
    public String jsonObjectReplay;
    public SystemObserver observer;
    public Parcelable parcelableReplay;
    public RequestHeader requestHeader;
    public ResponseHeader responseHeader;
    public String transactionId;

    /* loaded from: classes8.dex */
    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    /* loaded from: classes8.dex */
    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AtomicBoolean isFirstRsp;
        public final /* synthetic */ BaseAdapter this$0;

        public BaseRequestResultCallback(BaseAdapter baseAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = baseAdapter;
            this.isFirstRsp = new AtomicBoolean(true);
        }

        private void handleSolutionForHms(BaseCallBack baseCallBack) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, baseCallBack) == null) {
                if (!Util.isAvailableLibExist(this.this$0.appContext)) {
                    HMSLog.i(BaseAdapter.TAG, "handleSolutionForHms: no Available lib exist");
                    baseCallBack.onError(this.this$0.getResponseHeaderForError(-9));
                    return;
                }
                Activity cpActivity = this.this$0.getCpActivity();
                if (cpActivity != null && !cpActivity.isFinishing()) {
                    HMSLog.i(BaseAdapter.TAG, "start handleSolutionForHMS");
                    AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
                    availableAdapter.setCalledBySolutionInstallHms(true);
                    availableAdapter.startResolution(cpActivity, new AvailableAdapter.AvailableCallBack(this, baseCallBack) { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseRequestResultCallback this$1;
                        public final /* synthetic */ BaseCallBack val$baseCallBack;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, baseCallBack};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$baseCallBack = baseCallBack;
                        }

                        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                        public void onComplete(int i) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                                HMSLog.i(BaseAdapter.TAG, "complete handleSolutionForHMS, result: " + i);
                                if (i == 0) {
                                    HMSPackageManager.getInstance(this.this$1.this$0.appContext).resetMultiServiceState();
                                    BaseAdapter baseAdapter = this.this$1.this$0;
                                    this.val$baseCallBack.onError(baseAdapter.buildResponseWrap(11, baseAdapter.buildBodyStr(11)).toJson());
                                    this.this$1.this$0.sendBroadcastAfterResolutionHms();
                                    return;
                                }
                                BaseAdapter baseAdapter2 = this.this$1.this$0;
                                this.val$baseCallBack.onError(baseAdapter2.buildResponseWrap(i, baseAdapter2.buildBodyStr(i)).toJson());
                            }
                        }
                    });
                    return;
                }
                HMSLog.e(BaseAdapter.TAG, "activity is null");
                BaseAdapter baseAdapter = this.this$0;
                baseCallBack.onError(baseAdapter.buildResponseWrap(-3, baseAdapter.buildBodyStr(-3)).toJson());
            }
        }

        private void handleSolutionIntent(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, baseCallBack, coreBaseResponse) == null) {
                HMSLog.i(BaseAdapter.TAG, "baseCallBack.onComplete");
                PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
                if (pendingIntent != null) {
                    baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
                    return;
                }
                Intent intent = coreBaseResponse.getIntent();
                if (intent != null) {
                    baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), intent);
                } else {
                    baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
                }
            }
        }

        private void resolutionResult(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(65539, this, str, baseCallBack, coreBaseResponse, i) == null) {
                if ("intent".equals(str)) {
                    Activity cpActivity = this.this$0.getCpActivity();
                    HMSLog.i(BaseAdapter.TAG, "activity is: " + cpActivity);
                    if (cpActivity != null && !cpActivity.isFinishing()) {
                        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
                        if (pendingIntent != null) {
                            if (!Util.isAvailableLibExist(this.this$0.appContext)) {
                                baseCallBack.onError(this.this$0.getResponseHeaderForError(-9));
                                return;
                            } else {
                                this.this$0.startResolution(cpActivity, pendingIntent);
                                return;
                            }
                        }
                        Intent intent = coreBaseResponse.getIntent();
                        if (intent != null) {
                            if (!Util.isAvailableLibExist(this.this$0.appContext)) {
                                baseCallBack.onError(this.this$0.getResponseHeaderForError(-9));
                                return;
                            } else {
                                this.this$0.startResolution(cpActivity, intent);
                                return;
                            }
                        } else if (i == 2) {
                            BaseAdapter baseAdapter = this.this$0;
                            baseCallBack.onError(baseAdapter.getResponseHeaderForError(baseAdapter.responseHeader.getErrorCode()));
                            return;
                        } else {
                            HMSLog.e(BaseAdapter.TAG, "hasResolution is true but NO_SOLUTION");
                            baseCallBack.onError(this.this$0.getResponseHeaderForError(-4));
                            return;
                        }
                    }
                    HMSLog.e(BaseAdapter.TAG, "activity null");
                    handleSolutionIntent(baseCallBack, coreBaseResponse);
                } else if ("installHMS".equals(str)) {
                    HMSLog.i(BaseAdapter.TAG, "has resolutin: installHMS, but base-sdk can't support to install HMS");
                    handleSolutionForHms(baseCallBack);
                } else {
                    handleSolutionIntent(baseCallBack, coreBaseResponse);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, resolveResult) == null) {
                BaseCallBack callBack = this.this$0.getCallBack();
                if (callBack == null) {
                    HMSLog.e(BaseAdapter.TAG, "onResult baseCallBack null");
                } else if (resolveResult == null) {
                    HMSLog.e(BaseAdapter.TAG, "result null");
                    callBack.onError(this.this$0.getResponseHeaderForError(-1));
                } else {
                    CoreBaseResponse value = resolveResult.getValue();
                    if (value == null) {
                        HMSLog.e(BaseAdapter.TAG, "response null");
                        callBack.onError(this.this$0.getResponseHeaderForError(-1));
                    } else if (TextUtils.isEmpty(value.getJsonHeader())) {
                        HMSLog.e(BaseAdapter.TAG, "jsonHeader null");
                        callBack.onError(this.this$0.getResponseHeaderForError(-1));
                    } else {
                        JsonUtil.jsonToEntity(value.getJsonHeader(), this.this$0.responseHeader);
                        if (this.isFirstRsp.compareAndSet(true, false)) {
                            BaseAdapter baseAdapter = this.this$0;
                            baseAdapter.biReportRequestReturnIpc(baseAdapter.appContext, this.this$0.responseHeader);
                        }
                        String resolution = this.this$0.responseHeader.getResolution();
                        int statusCode = this.this$0.responseHeader.getStatusCode();
                        HMSLog.i(BaseAdapter.TAG, "api is: " + this.this$0.responseHeader.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
                        resolutionResult(resolution, callBack, value, statusCode);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class MPendingResultImpl extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MPendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apiClient, str, iMessageEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ApiClient) objArr2[0], (String) objArr2[1], (IMessageEntity) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.PendingResultImpl
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, coreBaseResponse)) == null) {
                ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
                resolveResult.setStatus(Status.SUCCESS);
                return resolveResult;
            }
            return (ResolveResult) invokeL.objValue;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apiClient};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestHeader = new RequestHeader();
        this.responseHeader = new ResponseHeader();
        this.api = new WeakReference<>(apiClient);
        this.appContext = apiClient.getContext().getApplicationContext();
        HMSLog.i(TAG, "In constructor, WeakReference is " + this.api);
    }

    private void setResponseHeader(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65578, this, i) == null) {
            this.responseHeader.setTransactionId(this.requestHeader.getTransactionId());
            this.responseHeader.setAppID(this.requestHeader.getAppID());
            this.responseHeader.setApiName(this.requestHeader.getApiName());
            this.responseHeader.setSrvName(this.requestHeader.getSrvName());
            this.responseHeader.setPkgName(this.requestHeader.getPkgName());
            this.responseHeader.setStatusCode(1);
            this.responseHeader.setErrorCode(i);
            this.responseHeader.setErrorReason("Core error");
        }
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apiClient, activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.requestHeader = new RequestHeader();
        this.responseHeader = new ResponseHeader();
        this.api = new WeakReference<>(apiClient);
        this.activityWeakReference = new WeakReference<>(activity);
        this.appContext = activity.getApplicationContext();
        HMSLog.i(TAG, "In constructor, activityWeakReference is " + this.activityWeakReference + ", activity is " + this.activityWeakReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteResult(Intent intent, BaseCallBack baseCallBack) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, this, intent, baseCallBack) == null) {
            String stringExtra = intent.getStringExtra(CommonCode.MapKey.JSON_HEADER);
            String stringExtra2 = intent.getStringExtra(CommonCode.MapKey.JSON_BODY);
            Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
            Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
            if (intent.hasExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
                Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
                if (infoFromJsonobject3 instanceof Long) {
                    j = ((Long) infoFromJsonobject3).longValue();
                    if (!(infoFromJsonobject instanceof Integer) && (infoFromJsonobject2 instanceof Integer)) {
                        int intValue = ((Integer) infoFromJsonobject).intValue();
                        getResponseHeaderForError(((Integer) infoFromJsonobject2).intValue());
                        this.responseHeader.setStatusCode(intValue);
                        biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                    } else {
                        getResponseHeaderForError(-8);
                        biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
                    }
                    baseCallBack.onComplete(stringExtra, stringExtra2, null);
                }
            }
            j = 0;
            if (!(infoFromJsonobject instanceof Integer)) {
            }
            getResponseHeaderForError(-8);
            biReportRequestReturnSolution(this.appContext, this.responseHeader, j);
            baseCallBack.onComplete(stringExtra, stringExtra2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getResponseHeaderForError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, this, i)) == null) {
            setResponseHeader(i);
            return this.responseHeader.toJson();
        }
        return (String) invokeI.objValue;
    }

    private void setBaseCallBackReplay(BaseCallBack baseCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, baseCallBack) == null) {
            this.baseCallBackReplay = baseCallBack;
        }
    }

    private void setJsonHeaderReplay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, this, str) == null) {
            this.jsonHeaderReplay = str;
        }
    }

    private void setJsonObjectReplay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65575, this, str) == null) {
            this.jsonObjectReplay = str;
        }
    }

    private void setParcelableReplay(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, this, parcelable) == null) {
            this.parcelableReplay = parcelable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResponseWrap buildResponseWrap(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65559, this, i, str)) == null) {
            setResponseHeader(i);
            ResponseWrap responseWrap = new ResponseWrap(this.responseHeader);
            responseWrap.setBody(str);
            return responseWrap;
        }
        return (ResponseWrap) invokeIL.objValue;
    }

    private void setReplayData(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65577, this, str, str2, parcelable, baseCallBack) == null) {
            setJsonHeaderReplay(str);
            setJsonObjectReplay(str2);
            setParcelableReplay(parcelable);
            setBaseCallBackReplay(baseCallBack);
        }
    }

    private PendingResult<ResolveResult<CoreBaseResponse>> baseRequest(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, this, apiClient, str, coreBaseRequest)) == null) {
            return new MPendingResultImpl(apiClient, str, coreBaseRequest);
        }
        return (PendingResult) invokeLLL.objValue;
    }

    private void biReportRequestEntryIpc(Context context, RequestHeader requestHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, context, requestHeader) == null) {
            Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "req");
            mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
        }
    }

    private void biReportRequestEntrySolution(Context context, RequestHeader requestHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, context, requestHeader) == null) {
            Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "req");
            mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biReportRequestReturnIpc(Context context, ResponseHeader responseHeader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, this, context, responseHeader) == null) {
            HiAnalyticsUtil.getInstance();
            Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasExtraPrivacyResult(Intent intent, BaseCallBack baseCallBack) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, this, intent, baseCallBack)) == null) {
            if (intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
                if (intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001) == 1001) {
                    HMSLog.i(TAG, "privacy_statement_confirm_result agreed, replay request");
                    replayRequest();
                    return true;
                }
                HMSLog.i(TAG, "privacy_statement_confirm_result rejected");
                baseCallBack.onError(buildResponseWrap(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, buildBodyStr(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasExtraUpdateResult(Intent intent, BaseCallBack baseCallBack) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, this, intent, baseCallBack)) == null) {
            if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
                return false;
            }
            int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
            HMSLog.i(TAG, "kit_update_result is " + intExtra);
            if (intExtra == 1) {
                HMSLog.e(TAG, "kit update success,replay request");
                replayRequest();
            } else {
                HMSLog.e(TAG, "kit update failed");
                baseCallBack.onError(buildResponseWrap(-10, buildBodyStr(intExtra)).toJson());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startResolution(Activity activity, Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65579, this, activity, parcelable) == null) {
            HMSLog.i(TAG, "startResolution");
            RequestHeader requestHeader = this.requestHeader;
            if (requestHeader != null) {
                biReportRequestEntrySolution(this.appContext, requestHeader);
            }
            if (this.observer == null) {
                initObserver();
            }
            SystemManager.getSystemNotifier().registerObserver(this.observer);
            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
            Bundle bundle = new Bundle();
            bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, parcelable);
            intentStartBridgeActivity.putExtras(bundle);
            intentStartBridgeActivity.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.transactionId);
            activity.startActivity(intentStartBridgeActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biReportRequestReturnSolution(Context context, ResponseHeader responseHeader, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{context, responseHeader, Long.valueOf(j)}) == null) {
            HiAnalyticsUtil.getInstance();
            Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j));
            mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion())));
            mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildBodyStr(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, this, i)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i);
            } catch (JSONException e) {
                HMSLog.e(TAG, "buildBodyStr failed: " + e.getMessage());
            }
            return jSONObject.toString();
        }
        return (String) invokeI.objValue;
    }

    private BaseCallBack getBaseCallBackReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            return this.baseCallBackReplay;
        }
        return (BaseCallBack) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseCallBack getCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            BaseCallBack baseCallBack = this.callback;
            if (baseCallBack == null) {
                HMSLog.e(TAG, "callback null");
                return null;
            }
            return baseCallBack;
        }
        return (BaseCallBack) invokeV.objValue;
    }

    private String getJsonHeaderReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            return this.jsonHeaderReplay;
        }
        return (String) invokeV.objValue;
    }

    private String getJsonObjectReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            return this.jsonObjectReplay;
        }
        return (String) invokeV.objValue;
    }

    private Parcelable getParcelableReplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            return this.parcelableReplay;
        }
        return (Parcelable) invokeV.objValue;
    }

    private void initObserver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            this.observer = new SystemObserver(this) { // from class: com.huawei.hms.adapter.BaseAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseAdapter this$0;

                @Override // com.huawei.hms.adapter.sysobs.SystemObserver
                public boolean onNoticeResult(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) {
                        return false;
                    }
                    return invokeI.booleanValue;
                }

                @Override // com.huawei.hms.adapter.sysobs.SystemObserver
                public boolean onUpdateResult(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return false;
                    }
                    return invokeI.booleanValue;
                }

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

                @Override // com.huawei.hms.adapter.sysobs.SystemObserver
                public boolean onSolutionResult(Intent intent, String str) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, str)) == null) {
                        if (TextUtils.isEmpty(str)) {
                            HMSLog.e(BaseAdapter.TAG, "onSolutionResult but id is null");
                            BaseCallBack callBack = this.this$0.getCallBack();
                            if (callBack == null) {
                                HMSLog.e(BaseAdapter.TAG, "onSolutionResult baseCallBack null");
                                return true;
                            }
                            callBack.onError(this.this$0.getResponseHeaderForError(-6));
                            return true;
                        } else if (str.equals(this.this$0.transactionId)) {
                            HMSLog.i(BaseAdapter.TAG, "onSolutionResult + id is :" + str);
                            BaseCallBack callBack2 = this.this$0.getCallBack();
                            if (callBack2 == null) {
                                HMSLog.e(BaseAdapter.TAG, "onResult baseCallBack null");
                                return true;
                            } else if (intent == null) {
                                HMSLog.e(BaseAdapter.TAG, "onSolutionResult but data is null");
                                String responseHeaderForError = this.this$0.getResponseHeaderForError(-7);
                                BaseAdapter baseAdapter = this.this$0;
                                baseAdapter.biReportRequestReturnSolution(baseAdapter.appContext, this.this$0.responseHeader, 0L);
                                callBack2.onError(responseHeaderForError);
                                return true;
                            } else if (this.this$0.hasExtraUpdateResult(intent, callBack2) || this.this$0.hasExtraPrivacyResult(intent, callBack2)) {
                                return true;
                            } else {
                                HMSLog.e(BaseAdapter.TAG, "onComplete for on activity result");
                                this.this$0.onCompleteResult(intent, callBack2);
                                return true;
                            }
                        } else {
                            return false;
                        }
                    }
                    return invokeLL.booleanValue;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBroadcastAfterResolutionHms() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            if (this.appContext == null) {
                HMSLog.e(TAG, "sendBroadcastAfterResolutionHms, context is null");
                return;
            }
            Intent intent = new Intent(HMS_SESSION_INVALID);
            intent.setPackage(this.appContext.getPackageName());
            this.appContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getCpActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            if (this.activityWeakReference == null) {
                HMSLog.i(TAG, "activityWeakReference is " + this.activityWeakReference);
                return null;
            }
            ApiClient apiClient = this.api.get();
            if (apiClient == null) {
                HMSLog.i(TAG, "tmpApi is null");
                return null;
            }
            HMSLog.i(TAG, "activityWeakReference has " + this.activityWeakReference.get());
            return Util.getActiveActivity(this.activityWeakReference.get(), apiClient.getContext());
        }
        return (Activity) invokeV.objValue;
    }

    private void replayRequest() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65571, this) == null) && this.jsonHeaderReplay != null && this.baseCallBackReplay != null) {
            this.responseHeader = null;
            this.responseHeader = new ResponseHeader();
            baseRequest(getJsonHeaderReplay(), getJsonObjectReplay(), getParcelableReplay(), getBaseCallBackReplay());
        }
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, parcelable, baseCallBack) == null) {
            setReplayData(str, str2, parcelable, baseCallBack);
            if (this.api == null) {
                HMSLog.e(TAG, "client is null");
                baseCallBack.onError(getResponseHeaderForError(-2));
                return;
            }
            this.callback = baseCallBack;
            JsonUtil.jsonToEntity(str, this.requestHeader);
            CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
            coreBaseRequest.setJsonObject(str2);
            coreBaseRequest.setJsonHeader(str);
            coreBaseRequest.setParcelable(parcelable);
            String apiName = this.requestHeader.getApiName();
            if (TextUtils.isEmpty(apiName)) {
                HMSLog.e(TAG, "get uri null");
                baseCallBack.onError(getResponseHeaderForError(-5));
                return;
            }
            String transactionId = this.requestHeader.getTransactionId();
            this.transactionId = transactionId;
            if (TextUtils.isEmpty(transactionId)) {
                HMSLog.e(TAG, "get transactionId null");
                baseCallBack.onError(getResponseHeaderForError(-6));
                return;
            }
            HMSLog.i(TAG, "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.transactionId);
            biReportRequestEntryIpc(this.appContext, this.requestHeader);
            baseRequest(this.api.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback(this));
        }
    }
}
