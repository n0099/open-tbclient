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
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.utils.FileUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class SaveFileTask extends AsyncTask<StoryMessage, Object, StoryObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TransResourceCallback mCallback;
    public WeakReference<Context> mReference;

    public SaveFileTask(Context context, TransResourceCallback transResourceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, transResourceCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mReference = new WeakReference<>(context);
        this.mCallback = transResourceCallback;
    }

    private StoryObject copyFileToWeiboTem(Context context, Uri uri, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, this, context, uri, i)) == null) {
            String copyFileToWeiboTem = ShareUtils.copyFileToWeiboTem(context, uri, i);
            if (TextUtils.isEmpty(copyFileToWeiboTem)) {
                return null;
            }
            StoryObject storyObject = new StoryObject();
            storyObject.sourcePath = copyFileToWeiboTem;
            storyObject.sourceType = i;
            storyObject.appId = WbSdk.getAuthInfo().getAppKey();
            storyObject.appPackage = context.getPackageName();
            return storyObject;
        }
        return (StoryObject) invokeLLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public StoryObject doInBackground(StoryMessage... storyMessageArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, storyMessageArr)) == null) {
            StoryMessage storyMessage = storyMessageArr[0];
            if (storyMessage == null) {
                return null;
            }
            Uri imageUri = storyMessage.getImageUri();
            Uri videoUri = storyMessage.getVideoUri();
            Context context = this.mReference.get();
            if (context == null) {
                return null;
            }
            if (imageUri != null && FileUtils.isImageFile(context, imageUri)) {
                return copyFileToWeiboTem(context, imageUri, 1);
            }
            if (videoUri == null || !FileUtils.isVideoFile(context, videoUri)) {
                return null;
            }
            return copyFileToWeiboTem(context, videoUri, 0);
        }
        return (StoryObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onPostExecute(StoryObject storyObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, storyObject) == null) {
            super.onPostExecute((SaveFileTask) storyObject);
            TransResourceCallback transResourceCallback = this.mCallback;
            if (transResourceCallback != null) {
                transResourceCallback.onTransFinish(storyObject);
            }
        }
    }
}
