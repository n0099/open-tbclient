package com.tencent.connect.common;

import android.content.Intent;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.tencent.open.a.f;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class UIListenerManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static UIListenerManager f38796a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ApiTask> f38797b;

    /* loaded from: classes6.dex */
    public class ApiTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UIListenerManager f38798a;
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(UIListenerManager uIListenerManager, int i2, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uIListenerManager, Integer.valueOf(i2), iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38798a = uIListenerManager;
            this.mRequestCode = i2;
            this.mListener = iUiListener;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-871137455, "Lcom/tencent/connect/common/UIListenerManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-871137455, "Lcom/tencent/connect/common/UIListenerManager;");
        }
    }

    public UIListenerManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f38797b = synchronizedMap;
        if (synchronizedMap == null) {
            this.f38797b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i2, IUiListener iUiListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i2, iUiListener)) == null) {
            if (i2 == 11101) {
                f.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
            } else if (i2 == 11105) {
                f.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
            } else if (i2 == 11106) {
                f.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
            }
            return iUiListener;
        }
        return (IUiListener) invokeIL.objValue;
    }

    public static UIListenerManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f38796a == null) {
                f38796a = new UIListenerManager();
            }
            return f38796a;
        }
        return (UIListenerManager) invokeV.objValue;
    }

    public IUiListener getListnerWithAction(String str) {
        InterceptResult invokeL;
        ApiTask apiTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                f.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
                return null;
            }
            synchronized (this.f38797b) {
                apiTask = this.f38797b.get(str);
                this.f38797b.remove(str);
            }
            if (apiTask == null) {
                return null;
            }
            return apiTask.mListener;
        }
        return (IUiListener) invokeL.objValue;
    }

    public IUiListener getListnerWithRequestCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String a2 = h.a(i2);
            if (a2 == null) {
                f.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i2);
                return null;
            }
            return getListnerWithAction(a2);
        }
        return (IUiListener) invokeI.objValue;
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, intent, iUiListener) == null) {
            f.c("openSDK_LOG.UIListenerManager", "handleDataToListener");
            if (intent == null) {
                iUiListener.onCancel();
                return;
            }
            String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra2 != null) {
                        try {
                            iUiListener.onComplete(j.d(stringExtra2));
                            return;
                        } catch (JSONException e2) {
                            iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                            f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e2);
                            return;
                        }
                    }
                    f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    iUiListener.onComplete(new JSONObject());
                    return;
                }
                f.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
            } else if ("action_share".equals(stringExtra)) {
                String stringExtra3 = intent.getStringExtra("result");
                String stringExtra4 = intent.getStringExtra("response");
                if (QueryResponse.Options.CANCEL.equals(stringExtra3)) {
                    iUiListener.onCancel();
                } else if ("error".equals(stringExtra3)) {
                    iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
                } else if (XAdRemoteEvent.COMPLETE.equals(stringExtra3)) {
                    try {
                        iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                        iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                    }
                }
            }
        }
    }

    public boolean onActivityResult(int i2, int i3, Intent intent, IUiListener iUiListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, iUiListener})) == null) {
            f.c("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i2 + " res=" + i3);
            IUiListener listnerWithRequestCode = getListnerWithRequestCode(i2);
            if (listnerWithRequestCode == null) {
                if (iUiListener != null) {
                    listnerWithRequestCode = a(i2, iUiListener);
                } else {
                    f.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                    return false;
                }
            }
            if (i3 != -1) {
                listnerWithRequestCode.onCancel();
            } else if (intent == null) {
                listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
                return true;
            } else {
                String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
                if ("action_login".equals(stringExtra)) {
                    int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                    if (intExtra == 0) {
                        String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                        if (stringExtra2 != null) {
                            try {
                                listnerWithRequestCode.onComplete(j.d(stringExtra2));
                            } catch (JSONException e2) {
                                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                                f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e2);
                            }
                        } else {
                            f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                            listnerWithRequestCode.onComplete(new JSONObject());
                        }
                    } else {
                        f.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                        listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    }
                } else if ("action_share".equals(stringExtra)) {
                    String stringExtra3 = intent.getStringExtra("result");
                    String stringExtra4 = intent.getStringExtra("response");
                    if (QueryResponse.Options.CANCEL.equals(stringExtra3)) {
                        listnerWithRequestCode.onCancel();
                    } else if ("error".equals(stringExtra3)) {
                        listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
                    } else if (XAdRemoteEvent.COMPLETE.equals(stringExtra3)) {
                        try {
                            listnerWithRequestCode.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                            listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra4 + ""));
                        }
                    }
                } else {
                    int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                    if (intExtra2 == 0) {
                        String stringExtra5 = intent.getStringExtra(Constants.KEY_RESPONSE);
                        if (stringExtra5 != null) {
                            try {
                                listnerWithRequestCode.onComplete(j.d(stringExtra5));
                            } catch (JSONException unused) {
                                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra5));
                            }
                        } else {
                            listnerWithRequestCode.onComplete(new JSONObject());
                        }
                    } else {
                        listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    }
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public Object setListenerWithRequestcode(int i2, IUiListener iUiListener) {
        InterceptResult invokeIL;
        ApiTask put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, iUiListener)) == null) {
            String a2 = h.a(i2);
            if (a2 == null) {
                f.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i2);
                return null;
            }
            synchronized (this.f38797b) {
                put = this.f38797b.put(a2, new ApiTask(this, i2, iUiListener));
            }
            if (put == null) {
                return null;
            }
            return put.mListener;
        }
        return invokeIL.objValue;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        InterceptResult invokeLL;
        ApiTask put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, iUiListener)) == null) {
            int a2 = h.a(str);
            if (a2 == -1) {
                f.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
                return null;
            }
            synchronized (this.f38797b) {
                put = this.f38797b.put(str, new ApiTask(this, a2, iUiListener));
            }
            if (put == null) {
                return null;
            }
            return put.mListener;
        }
        return invokeLL.objValue;
    }
}
