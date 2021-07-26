package d.a.q0.a3.d;

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
public class e extends d.a.q0.a3.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ShareEntity f54572h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.a3.e.b f54573i;
    public WbShareHandler j;
    public WbShareCallback k;
    public final d.a.d.e.l.c<d.a.d.k.d.a> l;

    /* loaded from: classes7.dex */
    public class a extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f54574a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54574a = eVar;
        }

        @Override // d.a.d.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.f54574a.f54573i != null) {
                    this.f54574a.f54573i.onShare(6, 3);
                }
                this.f54574a.w(3, 6);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar != null) {
                    Bitmap p = aVar.p();
                    e eVar = this.f54574a;
                    eVar.L(eVar.f54572h, p);
                    return;
                }
                e eVar2 = this.f54574a;
                eVar2.L(eVar2.f54572h, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Activity activity, d.a.q0.a3.e.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bVar, wbShareCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f54561b = activity;
        this.f54573i = bVar;
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
            imageObject.setThumbImage(i(bitmap, 120));
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
            if (this.f54572h == null) {
                return null;
            }
            TextObject textObject = new TextObject();
            textObject.title = C(this.f54572h.getTitle());
            textObject.text = C(this.f54572h.topic) + C(this.f54572h.getContent());
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
                        bArr2 = BitmapHelper.Bitmap2Bytes(i(bitmap, 120), 100);
                    }
                    return F(bArr2, linkUrl);
                } else if (bitmap != null) {
                    return E(i(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
                }
            }
            return null;
        }
        return (WebpageObject) invokeLLL.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.q0.a3.e.b bVar = this.f54573i;
            if (bVar != null) {
                bVar.onShare(6, 3);
            }
            w(3, 6);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.q0.a3.e.b bVar = this.f54573i;
            if (bVar != null) {
                bVar.onShare(6, 2);
            }
            w(2, 6);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.a3.e.b bVar = this.f54573i;
            if (bVar != null) {
                bVar.onShare(6, 1);
            }
            w(1, 6);
        }
    }

    public final void L(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, shareEntity, bitmap) == null) {
            if (this.f54572h != null && this.j != null && (this.f54561b instanceof Activity)) {
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
            d.a.q0.a3.e.b bVar = this.f54573i;
            if (bVar != null) {
                bVar.onShare(6, 2);
            }
            w(2, 6);
        }
    }

    @Override // d.a.q0.a3.e.a
    public void a(ShareEntity shareEntity, d.a.q0.a3.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, shareEntity, bVar) == null) {
            if (shareEntity != null && this.j != null) {
                this.f54572h = shareEntity;
                this.f54573i = bVar;
                d.a.d.k.d.a o = o(shareEntity);
                if (o != null && o.p() != null) {
                    L(this.f54572h, o.p());
                    return;
                }
                String imgUrl = shareEntity.getImgUrl();
                if (n(shareEntity.getLocalFile())) {
                    L(this.f54572h, g(shareEntity.getLocalFile()));
                    return;
                } else if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                    d.a.d.e.l.d.h().k(imgUrl, 10, this.l, 0, 0, h(), new Object[0]);
                    return;
                } else if (m(shareEntity.getImageUri())) {
                    L(this.f54572h, f(shareEntity.getImageUri()));
                    return;
                } else {
                    L(this.f54572h, d());
                    return;
                }
            }
            w(2, 6);
            if (bVar != null) {
                bVar.onShare(6, 2);
            }
        }
    }

    @Override // d.a.q0.a3.d.a
    public void l(Intent intent) {
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
