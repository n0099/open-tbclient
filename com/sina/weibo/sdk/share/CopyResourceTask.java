package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.utils.FileUtils;
import com.sina.weibo.sdk.utils.ImageUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class CopyResourceTask extends AsyncTask<WeiboMultiMessage, Object, TransResourceResult> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TransResourceCallback mCallback;
    public WeakReference<Context> mReference;

    public CopyResourceTask(Context context, TransResourceCallback transResourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transResourceCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReference = new WeakReference<>(context);
        this.mCallback = transResourceCallback;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPreExecute();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public TransResourceResult doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        InterceptResult invokeL;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, weiboMultiMessageArr)) == null) {
            Context context = this.mReference.get();
            if (context == null) {
                return null;
            }
            WeiboMultiMessage weiboMultiMessage = weiboMultiMessageArr[0];
            TransResourceResult transResourceResult = new TransResourceResult();
            try {
                if (WbSdk.isWbInstall(context)) {
                    WbAppInfo queryWbInfoInternal = WeiboAppManager.queryWbInfoInternal(context);
                    if (queryWbInfoInternal != null && queryWbInfoInternal.getSupportVersion() >= 10772) {
                        if (weiboMultiMessage.imageObject != null && weiboMultiMessage.multiImageObject != null) {
                            weiboMultiMessage.imageObject = null;
                        }
                        if (weiboMultiMessage.videoSourceObject != null && (weiboMultiMessage.multiImageObject != null || weiboMultiMessage.imageObject != null)) {
                            weiboMultiMessage.multiImageObject = null;
                            weiboMultiMessage.imageObject = null;
                        }
                    } else {
                        weiboMultiMessage.multiImageObject = null;
                        weiboMultiMessage.videoSourceObject = null;
                    }
                    if (weiboMultiMessage.multiImageObject != null) {
                        ArrayList<Uri> arrayList = new ArrayList<>();
                        Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                        while (it.hasNext()) {
                            Uri next = it.next();
                            if (next != null && FileUtils.isImageFile(context, next)) {
                                String copyFileToWeiboTem = ShareUtils.copyFileToWeiboTem(context, next, 1);
                                if (!TextUtils.isEmpty(copyFileToWeiboTem)) {
                                    arrayList.add(Uri.fromFile(new File(copyFileToWeiboTem)));
                                }
                            }
                        }
                        weiboMultiMessage.multiImageObject.setImageList(arrayList);
                    }
                    if (weiboMultiMessage.videoSourceObject != null && (uri = weiboMultiMessage.videoSourceObject.videoPath) != null && FileUtils.isVideoFile(context, uri)) {
                        String copyFileToWeiboTem2 = ShareUtils.copyFileToWeiboTem(context, uri, 0);
                        weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(copyFileToWeiboTem2));
                        weiboMultiMessage.videoSourceObject.during = ImageUtils.getVideoDuring(copyFileToWeiboTem2);
                    }
                }
                transResourceResult.message = weiboMultiMessage;
                transResourceResult.transDone = true;
            } catch (Exception unused) {
                transResourceResult.transDone = false;
            }
            return transResourceResult;
        }
        return (TransResourceResult) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onPostExecute(TransResourceResult transResourceResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, transResourceResult) == null) {
            super.onPostExecute((CopyResourceTask) transResourceResult);
            TransResourceCallback transResourceCallback = this.mCallback;
            if (transResourceCallback != null) {
                transResourceCallback.onTransFinish(transResourceResult);
            }
        }
    }
}
