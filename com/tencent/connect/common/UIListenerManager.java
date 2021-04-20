package com.tencent.connect.common;

import android.content.Intent;
import com.baidu.mobads.container.util.XAdRemoteEvent;
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

    /* renamed from: a  reason: collision with root package name */
    public static UIListenerManager f39393a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ApiTask> f39394b;

    /* loaded from: classes6.dex */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i, IUiListener iUiListener) {
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    public UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f39394b = synchronizedMap;
        if (synchronizedMap == null) {
            this.f39394b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i, IUiListener iUiListener) {
        if (i == 11101) {
            f.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11105) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == 11106) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (f39393a == null) {
            f39393a = new UIListenerManager();
        }
        return f39393a;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            f.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.f39394b) {
            apiTask = this.f39394b.get(str);
            this.f39394b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        String a2 = h.a(i);
        if (a2 == null) {
            f.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i);
            return null;
        }
        return getListnerWithAction(a2);
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
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

    public boolean onActivityResult(int i, int i2, Intent intent, IUiListener iUiListener) {
        f.c("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i + " res=" + i2);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i);
        if (listnerWithRequestCode == null) {
            if (iUiListener != null) {
                listnerWithRequestCode = a(i, iUiListener);
            } else {
                f.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i2 != -1) {
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

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        ApiTask put;
        String a2 = h.a(i);
        if (a2 == null) {
            f.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i);
            return null;
        }
        synchronized (this.f39394b) {
            put = this.f39394b.put(a2, new ApiTask(i, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int a2 = h.a(str);
        if (a2 == -1) {
            f.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.f39394b) {
            put = this.f39394b.put(str, new ApiTask(a2, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
