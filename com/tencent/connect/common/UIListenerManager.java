package com.tencent.connect.common;

import android.content.Intent;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UIListenerManager {
    public static /* synthetic */ Interceptable $ic;
    public static UIListenerManager a;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ApiTask> b;

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

    /* loaded from: classes8.dex */
    public class ApiTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UIListenerManager a;
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(UIListenerManager uIListenerManager, int i, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uIListenerManager, Integer.valueOf(i), iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uIListenerManager;
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    public UIListenerManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.b = synchronizedMap;
        if (synchronizedMap == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i, IUiListener iUiListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i, iUiListener)) == null) {
            if (i == 11101) {
                SLog.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
            } else if (i == 11105) {
                SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
            } else if (i == 11106) {
                SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
            }
            return iUiListener;
        }
        return (IUiListener) invokeIL.objValue;
    }

    public static UIListenerManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                a = new UIListenerManager();
            }
            return a;
        }
        return (UIListenerManager) invokeV.objValue;
    }

    public IUiListener getListnerWithAction(String str) {
        InterceptResult invokeL;
        ApiTask apiTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
                return null;
            }
            synchronized (this.b) {
                apiTask = this.b.get(str);
                this.b.remove(str);
            }
            if (apiTask == null) {
                return null;
            }
            return apiTask.mListener;
        }
        return (IUiListener) invokeL.objValue;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String a2 = i.a(i);
            if (a2 == null) {
                SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i);
                return null;
            }
            return getListnerWithAction(a2);
        }
        return (IUiListener) invokeI.objValue;
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, intent, iUiListener) == null) {
            SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
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
                            iUiListener.onComplete(l.d(stringExtra2));
                            return;
                        } catch (JSONException e) {
                            iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                            return;
                        }
                    }
                    SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                    iUiListener.onComplete(new JSONObject());
                    return;
                }
                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
            } else if ("action_share".equals(stringExtra)) {
                String stringExtra3 = intent.getStringExtra("result");
                String stringExtra4 = intent.getStringExtra("response");
                if ("cancel".equals(stringExtra3)) {
                    iUiListener.onCancel();
                } else if ("error".equals(stringExtra3)) {
                    iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
                } else if (TaskProcessData.keyComplete.equals(stringExtra3)) {
                    try {
                        if (stringExtra4 == null) {
                            str = "{\"ret\": 0}";
                        } else {
                            str = stringExtra4;
                        }
                        iUiListener.onComplete(new JSONObject(str));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                    }
                }
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent, IUiListener iUiListener) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, iUiListener})) == null) {
            SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
            IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
            if (listnerWithRequestCode == null) {
                if (iUiListener != null) {
                    listnerWithRequestCode = a(i, iUiListener);
                } else {
                    SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                    return false;
                }
            }
            if (i2 == -1) {
                if (intent == null) {
                    listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
                    return true;
                }
                String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
                if ("action_login".equals(stringExtra)) {
                    int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                    if (intExtra == 0) {
                        String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                        if (stringExtra2 != null) {
                            try {
                                listnerWithRequestCode.onComplete(l.d(stringExtra2));
                            } catch (JSONException e) {
                                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                                SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                            }
                        } else {
                            SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                            listnerWithRequestCode.onComplete(new JSONObject());
                        }
                    } else {
                        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                        listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    }
                } else if (!"action_share".equals(stringExtra) && !"action_request_avatar".equals(stringExtra) && !"action_request_dynamic_avatar".equals(stringExtra) && !"action_request_set_emotion".equals(stringExtra)) {
                    int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                    if (intExtra2 == 0) {
                        String stringExtra3 = intent.getStringExtra(Constants.KEY_RESPONSE);
                        if (stringExtra3 != null) {
                            try {
                                listnerWithRequestCode.onComplete(l.d(stringExtra3));
                            } catch (JSONException unused) {
                                listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra3));
                            }
                        } else {
                            listnerWithRequestCode.onComplete(new JSONObject());
                        }
                    } else {
                        listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                    }
                } else {
                    String stringExtra4 = intent.getStringExtra("result");
                    String stringExtra5 = intent.getStringExtra("response");
                    if ("cancel".equals(stringExtra4)) {
                        listnerWithRequestCode.onCancel();
                    } else if ("error".equals(stringExtra4)) {
                        listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra5 + ""));
                    } else if (TaskProcessData.keyComplete.equals(stringExtra4)) {
                        try {
                            if (stringExtra5 == null) {
                                str = "{\"ret\": 0}";
                            } else {
                                str = stringExtra5;
                            }
                            listnerWithRequestCode.onComplete(new JSONObject(str));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra5 + ""));
                        }
                    }
                }
            } else {
                listnerWithRequestCode.onCancel();
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        InterceptResult invokeIL;
        ApiTask put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, iUiListener)) == null) {
            String a2 = i.a(i);
            if (a2 == null) {
                SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
                return null;
            }
            synchronized (this.b) {
                put = this.b.put(a2, new ApiTask(this, i, iUiListener));
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
            int a2 = i.a(str);
            if (a2 == -1) {
                SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
                return null;
            }
            synchronized (this.b) {
                put = this.b.put(str, new ApiTask(this, a2, iUiListener));
            }
            if (put == null) {
                return null;
            }
            return put.mListener;
        }
        return invokeLL.objValue;
    }
}
