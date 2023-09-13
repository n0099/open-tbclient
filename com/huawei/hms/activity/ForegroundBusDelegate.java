package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes10.dex */
public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_DELEGATE_NAME = "intent.extra.hms.core.DELEGATE_NAME";
    public static final String EXTRA_DELEGATE_VALUE = "com.huawei.hms.core.activity.ForegroundBus";
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";
    public static final int REQUEST_CODE_BUS = 431057;
    public static final String TAG = "ForegroundBusDelegate";
    public static final String UI_JUMP_ACTIVITY_NAME = "com.huawei.hms.core.activity.UiJumpActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public String foregroundBody;
    public RequestHeader foregroundHeader;
    public ForegroundInnerHeader innerHeader;
    public boolean isUseInnerHms;
    public WeakReference<Activity> mThisWeakRef;
    public ResponseHeader responseHeader;

    /* renamed from: com.huawei.hms.activity.ForegroundBusDelegate$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? REQUEST_CODE_BUS : invokeV.intValue;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, keyEvent) == null) {
        }
    }

    /* loaded from: classes10.dex */
    public class MyAvailableCallBack implements AvailableAdapter.AvailableCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForegroundBusDelegate this$0;

        public MyAvailableCallBack(ForegroundBusDelegate foregroundBusDelegate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {foregroundBusDelegate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = foregroundBusDelegate;
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    HMSLog.i(ForegroundBusDelegate.TAG, "version check failed");
                    this.this$0.errorReturn(0, "apk version is invalid");
                    return;
                }
                this.this$0.startApkHubActivity();
            }
        }

        public /* synthetic */ MyAvailableCallBack(ForegroundBusDelegate foregroundBusDelegate, AnonymousClass1 anonymousClass1) {
            this(foregroundBusDelegate);
        }
    }

    public ForegroundBusDelegate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.innerHeader = new ForegroundInnerHeader();
    }

    private void finishBridgeActivity() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && (activity = getActivity()) != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            WeakReference<Activity> weakReference = this.mThisWeakRef;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            biReportRequestReturnForegroundBus();
            this.mThisWeakRef = null;
        }
    }

    private BusResponseCallback getResponseCallback(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            return ForegroundBusResponseMgr.getInstance().get(str);
        }
        return (BusResponseCallback) invokeL.objValue;
    }

    public static void resolution(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, activity, availableAdapter, availableCallBack) == null) {
            if (activity == null) {
                HMSLog.i(TAG, "null activity, could not start resolution intent");
            }
            availableAdapter.startResolution(activity, availableCallBack);
        }
    }

    private void biReportRequestEntryForegroundBus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "req");
            mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
            if (getActivity() != null) {
                HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
            }
        }
    }

    private void biReportRequestEntryStartCore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "req");
            mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
            if (getActivity() != null) {
                HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
            }
        }
    }

    private void biReportRequestReturnForegroundBus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.foregroundHeader != null) {
            Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
            ResponseHeader responseHeader = this.responseHeader;
            if (responseHeader != null) {
                mapFromForegroundRequestHeader.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
                mapFromForegroundRequestHeader.put("result", String.valueOf(this.responseHeader.getErrorCode()));
            }
            if (getActivity() != null) {
                HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
            }
        }
    }

    private void biReportRequestReturnStartCore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
            mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
            ResponseHeader responseHeader = this.responseHeader;
            if (responseHeader != null) {
                mapFromForegroundRequestHeader.put("statusCode", String.valueOf(responseHeader.getStatusCode()));
                mapFromForegroundRequestHeader.put("result", String.valueOf(this.responseHeader.getErrorCode()));
            }
            if (getActivity() != null) {
                HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
            }
        }
    }

    private void checkMinVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (getActivity() == null) {
                HMSLog.e(TAG, "checkMinVersion failed, activity must not be null.");
            } else if (this.isUseInnerHms) {
                startApkHubActivity();
            } else if (!Util.isAvailableLibExist(getActivity().getApplicationContext())) {
                if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getActivity().getApplicationContext(), this.innerHeader.getApkVersion()) != 0) {
                    HMSLog.e(TAG, "checkMinVersion failed, and no available lib exists.");
                } else {
                    startApkHubActivity();
                }
            } else {
                MyAvailableCallBack myAvailableCallBack = new MyAvailableCallBack(this, null);
                AvailableAdapter availableAdapter = new AvailableAdapter(this.innerHeader.getApkVersion());
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(getActivity());
                if (isHuaweiMobileServicesAvailable == 0) {
                    myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
                } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    resolution(getActivity(), availableAdapter, myAvailableCallBack);
                } else {
                    myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApkHubActivity() {
        String hMSPackageNameForMultiService;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            HMSLog.i(TAG, "startApkHubActivity");
            Activity activity = getActivity();
            if (activity == null) {
                HMSLog.e(TAG, "startApkHubActivity but activity is null");
                return;
            }
            if (this.isUseInnerHms) {
                hMSPackageNameForMultiService = activity.getPackageName();
            } else {
                hMSPackageNameForMultiService = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService();
            }
            Intent intent = new Intent(this.innerHeader.getAction());
            intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.foregroundBody);
            try {
                intent.setPackage(hMSPackageNameForMultiService);
            } catch (IllegalArgumentException unused) {
                HMSLog.e(TAG, "IllegalArgumentException when startApkHubActivity intent.setPackage");
            }
            intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
            intent.setClassName(hMSPackageNameForMultiService, UI_JUMP_ACTIVITY_NAME);
            intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.foregroundHeader.toJson());
            intent.putExtra(EXTRA_DELEGATE_NAME, EXTRA_DELEGATE_VALUE);
            try {
                biReportRequestEntryStartCore();
                activity.startActivityForResult(intent, REQUEST_CODE_BUS);
            } catch (ActivityNotFoundException e) {
                HMSLog.e(TAG, "Launch sign in Intent failed. hms is probably being updated：", e);
                errorReturn(0, "launch bus intent failed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorReturn(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, this, i, str) == null) {
            HMSLog.e(TAG, str);
            Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
            if (responseCallback != null) {
                BusResponseResult innerError = responseCallback.innerError(this.mThisWeakRef.get(), i, str);
                if (innerError == null) {
                    activity.setResult(0);
                } else {
                    activity.setResult(innerError.getCode(), innerError.getIntent());
                }
            } else {
                activity.setResult(0);
            }
            finishBridgeActivity();
        }
    }

    private void succeedReturn(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65550, this, i, intent) == null) {
            HMSLog.i(TAG, "succeedReturn");
            Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.setResult(i, intent);
            finishBridgeActivity();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.mThisWeakRef = new WeakReference<>(activity);
            Intent intent = activity.getIntent();
            String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
            RequestHeader requestHeader = new RequestHeader();
            this.foregroundHeader = requestHeader;
            if (!requestHeader.fromJson(stringExtra)) {
                errorReturn(0, "header is invalid");
                return;
            }
            this.foregroundBody = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
            ForegroundInnerHeader foregroundInnerHeader = this.innerHeader;
            if (foregroundInnerHeader == null) {
                errorReturn(0, "inner header is invalid");
                return;
            }
            foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
            if (TextUtils.isEmpty(this.foregroundHeader.getApiName())) {
                errorReturn(0, "action is invalid");
                return;
            }
            biReportRequestEntryForegroundBus();
            if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
                HMSLog.i(TAG, "isUseInnerHms: true");
                this.isUseInnerHms = true;
            }
            checkMinVersion();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i, i2, intent)) == null) {
            if (i == 431057) {
                if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
                    String stringExtra = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
                    ResponseHeader responseHeader = new ResponseHeader();
                    this.responseHeader = responseHeader;
                    JsonUtil.jsonToEntity(stringExtra, responseHeader);
                }
                biReportRequestReturnStartCore();
                BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
                if (responseCallback == null) {
                    succeedReturn(i2, intent);
                    return true;
                }
                BusResponseResult succeedReturn = responseCallback.succeedReturn(this.mThisWeakRef.get(), i2, intent);
                if (succeedReturn == null) {
                    succeedReturn(i2, intent);
                    return true;
                }
                succeedReturn(succeedReturn.getCode(), succeedReturn.getIntent());
                return true;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }
}
