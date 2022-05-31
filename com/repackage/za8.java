package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;
/* loaded from: classes7.dex */
public class za8 extends va8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cb8 i;
    public WbShareHandler j;
    public WbShareCallback k;
    public final eg<um> l;

    /* loaded from: classes7.dex */
    public class a extends eg<um> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        public a(za8 za8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = za8Var;
        }

        @Override // com.repackage.eg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.a.i != null) {
                    this.a.i.onShare(6, 3);
                }
                this.a.s(3, 6);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        public void onLoaded(um umVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, umVar, str, i) == null) {
                super.onLoaded((a) umVar, str, i);
                if (umVar != null) {
                    Bitmap p = umVar.p();
                    za8 za8Var = this.a;
                    za8Var.L(za8Var.e, p);
                    return;
                }
                za8 za8Var2 = this.a;
                za8Var2.L(za8Var2.e, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za8(Activity activity, cb8 cb8Var, WbShareCallback wbShareCallback) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, cb8Var, wbShareCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.b = activity;
        this.i = cb8Var;
        this.k = wbShareCallback;
        WbShareHandler wbShareHandler = new WbShareHandler(activity);
        this.j = wbShareHandler;
        if (wbShareHandler != null) {
            wbShareHandler.registerApp();
        }
    }

    public final String C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public final ImageObject D(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            ImageObject imageObject = new ImageObject();
            imageObject.setThumbImage(j(bitmap, 120));
            imageObject.setImageObject(bitmap);
            return imageObject;
        }
        return (ImageObject) invokeL.objValue;
    }

    public final WebpageObject E(Bitmap bitmap, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, str, str2, str3)) == null) {
            if (bitmap == null) {
                return null;
            }
            WebpageObject webpageObject = new WebpageObject();
            webpageObject.setThumbImage(bitmap);
            webpageObject.identify = Utility.generateGUID();
            webpageObject.title = C(str);
            webpageObject.description = C(str2);
            webpageObject.actionUrl = C(str3);
            return webpageObject;
        }
        return (WebpageObject) invokeLLLL.objValue;
    }

    public final WebpageObject F(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bArr, str)) == null) {
            if (bArr == null) {
                return null;
            }
            WebpageObject webpageObject = new WebpageObject();
            webpageObject.thumbData = bArr;
            webpageObject.identify = Utility.generateGUID();
            webpageObject.title = "";
            webpageObject.description = "";
            webpageObject.actionUrl = C(str);
            return webpageObject;
        }
        return (WebpageObject) invokeLL.objValue;
    }

    public final TextObject G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.e == null) {
                return null;
            }
            TextObject textObject = new TextObject();
            textObject.title = C(this.e.getTitle());
            textObject.text = C(this.e.topic) + C(this.e.getContent());
            return textObject;
        }
        return (TextObject) invokeV.objValue;
    }

    public final WebpageObject H(WeiboMultiMessage weiboMultiMessage, ShareEntity shareEntity, Bitmap bitmap) {
        InterceptResult invokeLLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, weiboMultiMessage, shareEntity, bitmap)) == null) {
            byte[] bArr2 = null;
            if (weiboMultiMessage != null && shareEntity != null) {
                String linkUrl = shareEntity.getLinkUrl();
                if (TextUtils.isEmpty(linkUrl)) {
                    return null;
                }
                if (weiboMultiMessage.textObject != null) {
                    ImageObject imageObject = weiboMultiMessage.imageObject;
                    if (imageObject != null && (bArr = imageObject.thumbData) != null) {
                        bArr2 = bArr;
                    } else if (bitmap != null) {
                        bArr2 = BitmapHelper.Bitmap2Bytes(j(bitmap, 120), 100);
                    }
                    return F(bArr2, linkUrl);
                } else if (bitmap != null) {
                    return E(j(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
                }
            }
            return null;
        }
        return (WebpageObject) invokeLLL.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            cb8 cb8Var = this.i;
            if (cb8Var != null) {
                cb8Var.onShare(6, 3);
            }
            s(3, 6);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            cb8 cb8Var = this.i;
            if (cb8Var != null) {
                cb8Var.onShare(6, 2);
            }
            s(2, 6);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            cb8 cb8Var = this.i;
            if (cb8Var != null) {
                cb8Var.onShare(6, 1);
            }
            s(1, 6);
        }
    }

    public final void L(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, shareEntity, bitmap) == null) {
            if (this.e != null && this.j != null && (this.b instanceof Activity)) {
                WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
                if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
                    weiboMultiMessage.textObject = G();
                }
                if (bitmap != null) {
                    weiboMultiMessage.imageObject = D(bitmap);
                }
                WebpageObject H = H(weiboMultiMessage, shareEntity, bitmap);
                if (H != null) {
                    weiboMultiMessage.mediaObject = H;
                }
                this.j.shareMessage(weiboMultiMessage, false);
                return;
            }
            cb8 cb8Var = this.i;
            if (cb8Var != null) {
                cb8Var.onShare(6, 2);
            }
            s(2, 6);
        }
    }

    @Override // com.repackage.bb8
    public void a(ShareEntity shareEntity, cb8 cb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, shareEntity, cb8Var) == null) {
            if (shareEntity != null && this.j != null) {
                this.e = shareEntity;
                this.i = cb8Var;
                um p = p(shareEntity);
                if (p != null && p.p() != null) {
                    L(this.e, p.p());
                    return;
                }
                String imgUrl = shareEntity.getImgUrl();
                if (o(shareEntity.getLocalFile())) {
                    L(this.e, h(shareEntity.getLocalFile()));
                    return;
                } else if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                    fg.h().k(imgUrl, 10, this.l, 0, 0, i(), new Object[0]);
                    return;
                } else if (n(shareEntity.getImageUri())) {
                    L(this.e, g(shareEntity.getImageUri()));
                    return;
                } else {
                    L(this.e, e());
                    return;
                }
            }
            s(2, 6);
            if (cb8Var != null) {
                cb8Var.onShare(6, 2);
            }
        }
    }

    @Override // com.repackage.va8
    public void m(Intent intent) {
        WbShareHandler wbShareHandler;
        WbShareCallback wbShareCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, intent) == null) || (wbShareHandler = this.j) == null || (wbShareCallback = this.k) == null) {
            return;
        }
        wbShareHandler.doResultIntent(intent, wbShareCallback);
        if (intent == null || intent.getExtras() != null) {
            return;
        }
        this.k.onWbShareSuccess();
    }
}
