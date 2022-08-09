package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.Serializable;
/* loaded from: classes8.dex */
public final class WeiboMultiMessage implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static int NineImageType = 2;
    public static int OneImageType = 1;
    public static final String TAG = "WeiboMultiMessage";
    public transient /* synthetic */ FieldHolder $fh;
    public ImageObject imageObject;
    public BaseMediaObject mediaObject;
    public int msgType;
    public MultiImageObject multiImageObject;
    public TextObject textObject;
    public VideoSourceObject videoSourceObject;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-72811390, "Lcom/sina/weibo/sdk/api/WeiboMultiMessage;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-72811390, "Lcom/sina/weibo/sdk/api/WeiboMultiMessage;");
        }
    }

    public WeiboMultiMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean checkArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            TextObject textObject = this.textObject;
            if (textObject != null && !textObject.checkArgs()) {
                LogUtil.e(TAG, "checkArgs fail, textObject is invalid");
                return false;
            }
            ImageObject imageObject = this.imageObject;
            if (imageObject != null && !imageObject.checkArgs()) {
                LogUtil.e(TAG, "checkArgs fail, imageObject is invalid");
                return false;
            }
            BaseMediaObject baseMediaObject = this.mediaObject;
            if (baseMediaObject != null && !baseMediaObject.checkArgs()) {
                LogUtil.e(TAG, "checkArgs fail, mediaObject is invalid");
                return false;
            } else if (this.textObject == null && this.imageObject == null && this.mediaObject == null) {
                LogUtil.e(TAG, "checkArgs fail, textObject and imageObject and mediaObject is null");
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgType : invokeV.intValue;
    }

    public void setMsgType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.msgType = i;
        }
    }

    public Bundle toBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            TextObject textObject = this.textObject;
            if (textObject != null) {
                bundle.putParcelable(WBConstants.Msg.TEXT, textObject);
                bundle.putString(WBConstants.Msg.TEXT_EXTRA, this.textObject.toExtraMediaString());
            } else {
                bundle.putParcelable(WBConstants.Msg.TEXT, null);
                bundle.putString(WBConstants.Msg.TEXT_EXTRA, null);
            }
            ImageObject imageObject = this.imageObject;
            if (imageObject != null) {
                bundle.putParcelable(WBConstants.Msg.IMAGE, imageObject);
                bundle.putString(WBConstants.Msg.IMAGE_EXTRA, this.imageObject.toExtraMediaString());
            } else {
                bundle.putParcelable(WBConstants.Msg.IMAGE, null);
                bundle.putString(WBConstants.Msg.IMAGE_EXTRA, null);
            }
            BaseMediaObject baseMediaObject = this.mediaObject;
            if (baseMediaObject != null) {
                bundle.putParcelable(WBConstants.Msg.MEDIA, baseMediaObject);
                bundle.putString(WBConstants.Msg.MEDIA_EXTRA, this.mediaObject.toExtraMediaString());
            } else {
                bundle.putParcelable(WBConstants.Msg.MEDIA, null);
                bundle.putString(WBConstants.Msg.MEDIA_EXTRA, null);
            }
            MultiImageObject multiImageObject = this.multiImageObject;
            if (multiImageObject != null) {
                bundle.putParcelable(WBConstants.Msg.MULTI_IMAGE, multiImageObject);
            } else {
                bundle.putParcelable(WBConstants.Msg.MULTI_IMAGE, null);
            }
            VideoSourceObject videoSourceObject = this.videoSourceObject;
            if (videoSourceObject != null) {
                bundle.putParcelable(WBConstants.Msg.VIDEO_SOURCE, videoSourceObject);
            } else {
                bundle.putParcelable(WBConstants.Msg.VIDEO_SOURCE, null);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public WeiboMultiMessage toObject(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
            TextObject textObject = (TextObject) bundle.getParcelable(WBConstants.Msg.TEXT);
            this.textObject = textObject;
            if (textObject != null) {
                textObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.TEXT_EXTRA));
            }
            ImageObject imageObject = (ImageObject) bundle.getParcelable(WBConstants.Msg.IMAGE);
            this.imageObject = imageObject;
            if (imageObject != null) {
                imageObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.IMAGE_EXTRA));
            }
            BaseMediaObject baseMediaObject = (BaseMediaObject) bundle.getParcelable(WBConstants.Msg.MEDIA);
            this.mediaObject = baseMediaObject;
            if (baseMediaObject != null) {
                baseMediaObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.MEDIA_EXTRA));
            }
            this.multiImageObject = (MultiImageObject) bundle.getParcelable(WBConstants.Msg.MULTI_IMAGE);
            this.videoSourceObject = (VideoSourceObject) bundle.getParcelable(WBConstants.Msg.VIDEO_SOURCE);
            return this;
        }
        return (WeiboMultiMessage) invokeL.objValue;
    }

    public WeiboMultiMessage(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        toBundle(bundle);
    }
}
