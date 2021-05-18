package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes7.dex */
public class AsyncWeiboRunner {
    public Context mContext;

    /* loaded from: classes7.dex */
    public static class RequestRunner extends AsyncTask<Void, Void, AsyncTaskResult<String>> {
        public final Context mContext;
        public final String mHttpMethod;
        public final RequestListener mListener;
        public final WeiboParameters mParams;
        public final String mUrl;

        public RequestRunner(Context context, String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
            this.mContext = context;
            this.mUrl = str;
            this.mParams = weiboParameters;
            this.mHttpMethod = str2;
            this.mListener = requestListener;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public AsyncTaskResult<String> doInBackground(Void... voidArr) {
            try {
                return new AsyncTaskResult<>(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
            } catch (WeiboException e2) {
                LogUtil.e("ContentValues", e2.getMessage());
                return new AsyncTaskResult<>(e2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onPostExecute(AsyncTaskResult<String> asyncTaskResult) {
            WeiboException error = asyncTaskResult.getError();
            if (error != null) {
                this.mListener.onWeiboException(error);
            } else {
                this.mListener.onComplete(asyncTaskResult.getResult());
            }
        }
    }

    public AsyncWeiboRunner(Context context) {
        this.mContext = context;
    }

    private void addAction(Context context, String str) {
        try {
            Class.forName("com.sina.weibo.sdk.cmd.WbAppActivator").getMethod("getInstance", Context.class, String.class).invoke(null, context, str).getClass().getMethod("activateApp", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public String request(String str, WeiboParameters weiboParameters, String str2) throws WeiboException {
        addAction(this.mContext, weiboParameters.getAppKey());
        return HttpManager.openUrl(this.mContext, str, str2, weiboParameters);
    }

    public void request4RdirectURL(final String str, final WeiboParameters weiboParameters, final String str2, final RequestListener requestListener) {
        new Thread() { // from class: com.sina.weibo.sdk.net.AsyncWeiboRunner.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    String openRedirectUrl4LocationUri = HttpManager.openRedirectUrl4LocationUri(AsyncWeiboRunner.this.mContext, str, str2, weiboParameters);
                    if (requestListener != null) {
                        requestListener.onComplete(openRedirectUrl4LocationUri);
                    }
                } catch (WeiboException e2) {
                    if (requestListener != null) {
                        requestListener.onWeiboException(e2);
                    }
                }
            }
        }.start();
    }

    public void requestAsync(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        addAction(this.mContext, weiboParameters.getAppKey());
        new RequestRunner(this.mContext, str, weiboParameters, str2, requestListener).execute(null);
    }

    @Deprecated
    public void requestByThread(final String str, final WeiboParameters weiboParameters, final String str2, final RequestListener requestListener) {
        new Thread() { // from class: com.sina.weibo.sdk.net.AsyncWeiboRunner.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    String openUrl = HttpManager.openUrl(AsyncWeiboRunner.this.mContext, str, str2, weiboParameters);
                    if (requestListener != null) {
                        requestListener.onComplete(openUrl);
                    }
                } catch (WeiboException e2) {
                    if (requestListener != null) {
                        requestListener.onWeiboException(e2);
                    }
                }
            }
        }.start();
    }

    /* loaded from: classes7.dex */
    public static class AsyncTaskResult<T> {
        public WeiboException error;
        public T result;

        public AsyncTaskResult(T t) {
            this.result = t;
        }

        public WeiboException getError() {
            return this.error;
        }

        public T getResult() {
            return this.result;
        }

        public AsyncTaskResult(WeiboException weiboException) {
            this.error = weiboException;
        }
    }

    public String request(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4) throws WeiboException {
        if (z) {
            weiboParameters.put("source", str);
            weiboParameters.setAnonymousCookie(str2);
            return request(str3, weiboParameters, str4);
        }
        return request(str3, weiboParameters, str4);
    }

    public void requestAsync(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4, RequestListener requestListener) {
        if (z) {
            weiboParameters.put("source", str);
            weiboParameters.setAnonymousCookie(str2);
            requestAsync(str3, weiboParameters, str4, requestListener);
            return;
        }
        requestAsync(str3, weiboParameters, str4, requestListener);
    }
}
