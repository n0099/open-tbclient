package com.sina.weibo.sdk.network.impl;

import android.os.AsyncTask;
import android.os.Bundle;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.RequestCancelable;
import com.sina.weibo.sdk.network.base.RequestResult;
import com.sina.weibo.sdk.network.base.WbResponse;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.network.exception.SdkException;
import com.sina.weibo.sdk.network.intercept.GlobalInterceptHelper;
import com.sina.weibo.sdk.network.target.Target;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class RequestTask<T, R> extends AsyncTask<Object, Object, RequestResult> implements RequestCancelable {
    public IRequestParam param;
    public Class<T> tClass;
    public Target<R> target;

    public RequestTask(IRequestParam iRequestParam, Target<R> target) {
        this.param = iRequestParam;
        this.target = target;
    }

    @Override // com.sina.weibo.sdk.network.RequestCancelable
    public void cancelRequest() {
    }

    @Override // com.sina.weibo.sdk.network.RequestCancelable
    public boolean isCancelRequest() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.AsyncTask
    public RequestResult doInBackground(Object... objArr) {
        RequestResult requestResult = new RequestResult();
        if (!NetStateManager.isNetworkConnected(this.param.getContext())) {
            LogUtil.e("Task", "RequestTask:android.permission.ACCESS_NETWORK_STATE");
            requestResult.setE(new SdkException(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
        }
        if (this.param.needIntercept()) {
            try {
                Bundle bundle = new Bundle();
                HashMap<String, IRequestIntercept> globalIntercept = GlobalInterceptHelper.init().getGlobalIntercept();
                for (String str : globalIntercept.keySet()) {
                    IRequestIntercept iRequestIntercept = globalIntercept.get(str);
                    if (iRequestIntercept != null && iRequestIntercept.needIntercept(this.param, bundle)) {
                        iRequestIntercept.doIntercept(this.param, bundle);
                    }
                }
                Iterator<IRequestIntercept> it = this.param.getIntercept().iterator();
                while (it.hasNext()) {
                    IRequestIntercept next = it.next();
                    if (next.needIntercept(this.param, bundle)) {
                        next.doIntercept(this.param, bundle);
                    }
                }
                this.param.getPostBundle().putAll(bundle);
            } catch (InterceptException e2) {
                requestResult.setE(e2);
                return requestResult;
            }
        }
        try {
            WbResponse request = RequestEngine.request(this.param);
            R transResponse = this.target.transResponse(request);
            this.target.onRequestSuccessBg(transResponse);
            requestResult.setResponse(transResponse);
            try {
                InputStream byteStream = request.body().byteStream();
                if (byteStream != null) {
                    byteStream.close();
                }
            } catch (Exception unused) {
            }
        } catch (Exception e3) {
            requestResult.setE(e3);
        }
        return requestResult;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.sina.weibo.sdk.network.target.Target<R> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.AsyncTask
    public void onPostExecute(RequestResult requestResult) {
        super.onPostExecute((RequestTask<T, R>) requestResult);
        Target<R> target = this.target;
        if (target != null) {
            target.onRequestDone();
            if (requestResult.getE() != null) {
                this.target.onFailure(requestResult.getE());
                this.target.onError();
                return;
            }
            this.target.onRequestSuccess(requestResult.getResponse());
        }
    }
}
