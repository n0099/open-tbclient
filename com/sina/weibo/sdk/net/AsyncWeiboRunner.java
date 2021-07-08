package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
/* loaded from: classes6.dex */
public class AsyncWeiboRunner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes6.dex */
    public static class RequestRunner extends AsyncTask<Void, Void, AsyncTaskResult<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;
        public final String mHttpMethod;
        public final RequestListener mListener;
        public final WeiboParameters mParams;
        public final String mUrl;

        public RequestRunner(Context context, String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, weiboParameters, str2, requestListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
            this.mUrl = str;
            this.mParams = weiboParameters;
            this.mHttpMethod = str2;
            this.mListener = requestListener;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public AsyncTaskResult<String> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    return new AsyncTaskResult<>(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
                } catch (WeiboException e2) {
                    LogUtil.e("ContentValues", e2.getMessage());
                    return new AsyncTaskResult<>(e2);
                }
            }
            return (AsyncTaskResult) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public void onPostExecute(AsyncTaskResult<String> asyncTaskResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, asyncTaskResult) == null) {
                WeiboException error = asyncTaskResult.getError();
                if (error != null) {
                    this.mListener.onWeiboException(error);
                } else {
                    this.mListener.onComplete(asyncTaskResult.getResult());
                }
            }
        }
    }

    public AsyncWeiboRunner(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    private void addAction(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, str) == null) {
            try {
                Class.forName("com.sina.weibo.sdk.cmd.WbAppActivator").getMethod("getInstance", Context.class, String.class).invoke(null, context, str).getClass().getMethod("activateApp", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public String request(String str, WeiboParameters weiboParameters, String str2) throws WeiboException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, weiboParameters, str2)) == null) {
            addAction(this.mContext, weiboParameters.getAppKey());
            return HttpManager.openUrl(this.mContext, str, str2, weiboParameters);
        }
        return (String) invokeLLL.objValue;
    }

    public void request4RdirectURL(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, weiboParameters, str2, requestListener) == null) {
            new Thread(this, str, str2, weiboParameters, requestListener) { // from class: com.sina.weibo.sdk.net.AsyncWeiboRunner.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncWeiboRunner this$0;
                public final /* synthetic */ String val$httpMethod;
                public final /* synthetic */ RequestListener val$listener;
                public final /* synthetic */ WeiboParameters val$params;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, weiboParameters, requestListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$url = str;
                    this.val$httpMethod = str2;
                    this.val$params = weiboParameters;
                    this.val$listener = requestListener;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String openRedirectUrl4LocationUri = HttpManager.openRedirectUrl4LocationUri(this.this$0.mContext, this.val$url, this.val$httpMethod, this.val$params);
                            if (this.val$listener != null) {
                                this.val$listener.onComplete(openRedirectUrl4LocationUri);
                            }
                        } catch (WeiboException e2) {
                            if (this.val$listener != null) {
                                this.val$listener.onWeiboException(e2);
                            }
                        }
                    }
                }
            }.start();
        }
    }

    public void requestAsync(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, weiboParameters, str2, requestListener) == null) {
            addAction(this.mContext, weiboParameters.getAppKey());
            new RequestRunner(this.mContext, str, weiboParameters, str2, requestListener).execute(null);
        }
    }

    @Deprecated
    public void requestByThread(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, weiboParameters, str2, requestListener) == null) {
            new Thread(this, str, str2, weiboParameters, requestListener) { // from class: com.sina.weibo.sdk.net.AsyncWeiboRunner.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncWeiboRunner this$0;
                public final /* synthetic */ String val$httpMethod;
                public final /* synthetic */ RequestListener val$listener;
                public final /* synthetic */ WeiboParameters val$params;
                public final /* synthetic */ String val$url;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, weiboParameters, requestListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$url = str;
                    this.val$httpMethod = str2;
                    this.val$params = weiboParameters;
                    this.val$listener = requestListener;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            String openUrl = HttpManager.openUrl(this.this$0.mContext, this.val$url, this.val$httpMethod, this.val$params);
                            if (this.val$listener != null) {
                                this.val$listener.onComplete(openUrl);
                            }
                        } catch (WeiboException e2) {
                            if (this.val$listener != null) {
                                this.val$listener.onWeiboException(e2);
                            }
                        }
                    }
                }
            }.start();
        }
    }

    /* loaded from: classes6.dex */
    public static class AsyncTaskResult<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeiboException error;
        public T result;

        public AsyncTaskResult(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.result = t;
        }

        public WeiboException getError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.error : (WeiboException) invokeV.objValue;
        }

        public T getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.result : (T) invokeV.objValue;
        }

        public AsyncTaskResult(WeiboException weiboException) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weiboException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.error = weiboException;
        }
    }

    public String request(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4) throws WeiboException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), str2, str3, weiboParameters, str4})) == null) {
            if (z) {
                weiboParameters.put("source", str);
                weiboParameters.setAnonymousCookie(str2);
                return request(str3, weiboParameters, str4);
            }
            return request(str3, weiboParameters, str4);
        }
        return (String) invokeCommon.objValue;
    }

    public void requestAsync(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4, RequestListener requestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), str2, str3, weiboParameters, str4, requestListener}) == null) {
            if (z) {
                weiboParameters.put("source", str);
                weiboParameters.setAnonymousCookie(str2);
                requestAsync(str3, weiboParameters, str4, requestListener);
                return;
            }
            requestAsync(str3, weiboParameters, str4, requestListener);
        }
    }
}
