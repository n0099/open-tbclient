package d.a.q0.a3.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import d.a.d.e.p.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
/* loaded from: classes7.dex */
public class f extends d.a.q0.a3.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f54575h;

    /* renamed from: i  reason: collision with root package name */
    public ShareEntity f54576i;
    public d.a.q0.a3.e.b j;
    public IWXAPI k;
    public d l;
    public final d.a.d.e.l.c<EmotionShareLoaderProc.EmotionShare> m;
    public final c n;

    /* loaded from: classes7.dex */
    public class a extends d.a.d.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f54577a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54577a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i2) == null) {
                super.onLoaded(emotionShare, str, i2);
                if (emotionShare != null && emotionShare.image != null) {
                    f fVar = this.f54577a;
                    if (fVar.a0(fVar.f54576i, emotionShare)) {
                        return;
                    }
                }
                this.f54577a.n.onLoaded((d.a.d.k.d.a) null, str, i2);
            }
        }

        @Override // d.a.d.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.f54577a.n.onCancelled(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Bitmap, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f54578a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54578a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                if (bitmapArr.length <= 0 || bitmapArr[0] == null) {
                    return null;
                }
                f fVar = this.f54578a;
                return fVar.r(bitmapArr[0], fVar.f54576i, false);
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((b) bitmap);
                f fVar = this.f54578a;
                fVar.g0(fVar.f54576i, bitmap);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class c extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f54579a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54579a = fVar;
        }

        @Override // d.a.d.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.f54579a.j != null) {
                    this.f54579a.j.onShare(this.f54579a.f54575h, 3);
                }
                f fVar = this.f54579a;
                fVar.w(3, fVar.f54575h);
            }
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this(fVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                if (aVar == null) {
                    this.f54579a.i0();
                    return;
                }
                Bitmap p = aVar.p();
                if (!TextUtils.isEmpty(this.f54579a.f54576i.getLinkUrl())) {
                    if (this.f54579a.f54575h != 2) {
                        String tid = this.f54579a.f54576i.getTid();
                        int typeShareToSmallApp = this.f54579a.f54576i.getTypeShareToSmallApp();
                        if ((typeShareToSmallApp == 2 || typeShareToSmallApp == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && this.f54579a.f54576i.canShareBySmartApp && !WeChatShareSmallAppToH5Switch.isOn()) {
                            f fVar = this.f54579a;
                            fVar.d0(fVar.f54576i, p);
                            return;
                        }
                        f fVar2 = this.f54579a;
                        fVar2.h0(fVar2.f54576i, p);
                        return;
                    }
                    f fVar3 = this.f54579a;
                    fVar3.h0(fVar3.f54576i, p);
                } else if (TextUtils.isEmpty(this.f54579a.f54576i.getVideoUrl())) {
                    if (!TextUtils.isEmpty(this.f54579a.f54576i.getContent())) {
                        this.f54579a.i0();
                        return;
                    }
                    f fVar4 = this.f54579a;
                    fVar4.b0(fVar4.f54576i, p);
                } else {
                    f fVar5 = this.f54579a;
                    fVar5.f0(fVar5.f54576i, p);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f this$0;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (this.this$0.j != null) {
                        this.this$0.j.onShare(this.this$0.f54575h, 1);
                    }
                    f fVar = this.this$0;
                    fVar.w(1, fVar.f54575h);
                } else if (intExtra == -2) {
                    if (this.this$0.j != null) {
                        this.this$0.j.onShare(this.this$0.f54575h, 3);
                    }
                    f fVar2 = this.this$0;
                    fVar2.w(3, fVar2.f54575h);
                } else {
                    this.this$0.l0(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (this.this$0.j != null) {
                        this.this$0.j.onShare(this.this$0.f54575h, 2);
                    }
                    f fVar3 = this.this$0;
                    fVar3.w(2, fVar3.f54575h);
                }
                this.this$0.T();
            }
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        this.n = new c(this, null);
        this.f54561b = context.getApplicationContext();
        this.f54575h = i2;
        this.k = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    public byte[] M(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            try {
                Bitmap i2 = i(bitmap, 120);
                if (i2 == null) {
                    i2 = d();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                i2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] N(Bitmap bitmap, int i2, boolean z) {
        Bitmap i3;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            try {
                if (z) {
                    i3 = e(R.drawable.miniprogram_share_defaults);
                } else {
                    i3 = i(bitmap, i2);
                }
                if (i3 == null) {
                    i3 = e(R.drawable.miniprogram_share_defaults);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                i3.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f54575h;
            if (i2 == 3) {
                return 0;
            }
            return i2 == 2 ? 1 : -1;
        }
        return invokeV.intValue;
    }

    public final String P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return String.valueOf(System.currentTimeMillis());
            }
            return str + System.currentTimeMillis();
        }
        return (String) invokeL.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    public boolean R(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? this.k.getWXAppSupportAPI() >= 654314752 : invokeL.booleanValue;
    }

    public byte[] S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Bitmap e2 = e(R.drawable.miniprogram_share_defaults);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                e2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FileHelper.deleteFile(new File(d.a.q0.a3.d.a.f54557e + d.a.q0.a3.d.a.f54559g));
        }
    }

    public String U(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
            context.grantUriPermission("com.tencent.mm", uriForFile, 1);
            return uriForFile.toString();
        }
        return (String) invokeLL.objValue;
    }

    public final boolean V(WXImageObject wXImageObject, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, wXImageObject, bitmap)) == null) {
            Context context = this.f54561b;
            if (context != null && wXImageObject != null && bitmap != null && R(context) && Q()) {
                try {
                    X(wXImageObject, FileHelper.saveFileAsPNG(d.a.q0.a3.d.a.f54557e, d.a.q0.a3.d.a.f54559g, bitmap, 100), bitmap);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f54561b == null) {
            return;
        }
        this.l = new d(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
        this.f54561b.registerReceiver(this.l, intentFilter);
    }

    public final void X(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, wXImageObject, str, bitmap) == null) {
            wXImageObject.setImagePath(U(this.f54561b, new File(str)));
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = M(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = P("imageShare");
            req.message = wXMediaMessage;
            req.scene = O();
            this.k.sendReq(req);
        }
    }

    public final boolean Y(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, shareEntity, emotionShare)) == null) {
            if (shareEntity == null || this.k == null || emotionShare == null || emotionShare.image == null || StringUtils.isNull(emotionShare.path)) {
                return false;
            }
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiPath = emotionShare.path;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = M(emotionShare.image.p());
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = P("imageShare");
            req.message = wXMediaMessage;
            req.scene = O();
            this.k.sendReq(req);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void Z(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, shareEntity, bitmap) == null) || shareEntity == null || this.k == null || bitmap == null) {
            return;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiData = N(bitmap, 512, false);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("imageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    @Override // d.a.q0.a3.e.a
    public void a(ShareEntity shareEntity, d.a.q0.a3.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, shareEntity, bVar) == null) {
            if (shareEntity != null && this.k != null) {
                this.f54576i = shareEntity;
                this.j = bVar;
                this.f54575h = shareEntity.getShareTo();
                if (!this.k.isWXAppInstalled()) {
                    d.a.q0.a3.e.b bVar2 = this.j;
                    if (bVar2 != null) {
                        bVar2.onShare(this.f54575h, 2);
                    }
                    BdToast.e(c(), c().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.skinType).q();
                    return;
                }
                d.a.d.k.d.a o = o(shareEntity);
                if (o != null && o.p() != null) {
                    if (this.f54576i.getShareType() == 2) {
                        Z(this.f54576i, o.p());
                        return;
                    } else {
                        b0(this.f54576i, o.p());
                        return;
                    }
                } else if (n(shareEntity.getLocalFile())) {
                    j0(shareEntity.getLocalFile());
                    return;
                } else {
                    String imgUrl = shareEntity.getImgUrl();
                    if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        if (this.f54576i.getShareType() != 0) {
                            d.a.d.e.l.d.h().k(imgUrl, 34, this.m, 0, 0, h(), new Object[0]);
                            return;
                        } else {
                            d.a.d.e.l.d.h().k(imgUrl, 10, this.n, 0, 0, h(), new Object[0]);
                            return;
                        }
                    } else if (m(shareEntity.getImageUri())) {
                        j0(shareEntity.getImageUri().getPath());
                        return;
                    } else {
                        i0();
                        return;
                    }
                }
            }
            w(2, this.f54575h);
            if (bVar != null) {
                bVar.onShare(0, 2);
            }
        }
    }

    public final boolean a0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, shareEntity, emotionShare)) == null) {
            if (this.f54575h != 2 && this.f54576i.getShareType() != 1) {
                return Y(shareEntity, emotionShare);
            }
            return c0(shareEntity, emotionShare);
        }
        return invokeLL.booleanValue;
    }

    public final void b0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, shareEntity, bitmap) == null) || shareEntity == null || this.k == null || bitmap == null) {
            return;
        }
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        if (V(wXImageObject, bitmap)) {
            return;
        }
        wXImageObject.imageData = d.a.d.e.p.d.d().a(bitmap, 85);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("imageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final boolean c0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        d.a.d.k.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, shareEntity, emotionShare)) == null) {
            if (shareEntity == null || this.k == null || emotionShare == null || StringUtils.isNull(emotionShare.path) || (aVar = emotionShare.image) == null || aVar.p() == null) {
                return false;
            }
            WXImageObject wXImageObject = new WXImageObject();
            wXImageObject.setImagePath(emotionShare.path);
            if (V(wXImageObject, emotionShare.image.p())) {
                return false;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = M(emotionShare.image.p());
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = P("imageShare");
            req.message = wXMediaMessage;
            req.scene = O();
            this.k.sendReq(req);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void d0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, shareEntity, bitmap) == null) || shareEntity == null || this.k == null) {
            return;
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
        wXMiniProgramObject.miniprogramType = 0;
        wXMiniProgramObject.userName = "gh_213e5678c5bf";
        if (shareEntity.getTypeShareToSmallApp() != 2 && shareEntity.getTypeShareToSmallApp() != 4) {
            String tid = shareEntity.getTid();
            wXMiniProgramObject.path = "/pages/pb/pb?tid=" + tid;
        } else {
            String str = shareEntity.getfName();
            if (k.isEmpty(str)) {
                str = "";
            }
            String encode = URLEncoder.encode(str);
            wXMiniProgramObject.path = "/pages/frs/frs?kw=" + encode;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        String title = shareEntity.getTitle();
        if (StringUtils.isNull(title)) {
            title = shareEntity.getContent();
        }
        wXMediaMessage.title = title;
        wXMediaMessage.description = shareEntity.getContent();
        if ("https://tb5.bdstatic.com/yunying/tieba_logo.jpg".equals(shareEntity.getImgUrl())) {
            wXMediaMessage.thumbData = m0(bitmap, true);
        } else {
            wXMediaMessage.thumbData = m0(bitmap, false);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("miniProgram");
        req.message = wXMediaMessage;
        req.scene = 0;
        this.k.sendReq(req);
    }

    public final void e0(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, shareEntity) == null) || shareEntity == null || this.k == null) {
            return;
        }
        String content = shareEntity.getContent();
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = content;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = content;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("textShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final void f0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, shareEntity, bitmap) == null) || shareEntity == null || this.k == null) {
            return;
        }
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = shareEntity.getVideoUrl();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
        wXMediaMessage.title = shareEntity.getTitle();
        wXMediaMessage.description = shareEntity.getContent();
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("videoShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final void g0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, shareEntity, bitmap) == null) || shareEntity == null || this.k == null) {
            return;
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = shareEntity.getTitle();
        wXMediaMessage.description = shareEntity.getContent();
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("webpageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final void h0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, shareEntity, bitmap) == null) {
            if (shareEntity.getIsVideoThread()) {
                b bVar = new b(this);
                bVar.setPriority(3);
                bVar.execute(bitmap);
                return;
            }
            g0(this.f54576i, bitmap);
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Bitmap d2 = d();
            if (d2 != null) {
                b0(this.f54576i, d2);
            } else {
                e0(this.f54576i);
            }
        }
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bitmap g2 = g(str);
            if (g2 == null) {
                g2 = d();
            }
            if (g2 != null) {
                b0(this.f54576i, g2);
            } else {
                e0(this.f54576i);
            }
        }
    }

    public final void k0() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (context = this.f54561b) == null || (dVar = this.l) == null) {
            return;
        }
        context.unregisterReceiver(dVar);
    }

    public final void l0(int i2, String str) {
        ShareEntity shareEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048602, this, i2, str) == null) || (shareEntity = this.f54576i) == null || StringUtils.isNull(shareEntity.getImgUrl())) {
            return;
        }
        d.a.p0.s.z.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i2, "", "share_fail_exception", str + "&" + this.f54576i.getImgUrl());
    }

    public byte[] m0(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, bitmap, z)) == null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!z && bitmap != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    double length = byteArray.length / 1024;
                    if (length <= 125.0d) {
                        return byteArray;
                    }
                    while (length > 125.0d) {
                        Double valueOf = Double.valueOf(length / 125.0d);
                        Double valueOf2 = Double.valueOf(width / Math.sqrt(valueOf.doubleValue()));
                        Double valueOf3 = Double.valueOf(height / Math.sqrt(valueOf.doubleValue()));
                        width = valueOf2.intValue();
                        height = valueOf3.intValue();
                        bitmap = j(bitmap, width, height);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                        byteArray = byteArrayOutputStream2.toByteArray();
                        length = byteArray.length / 1024;
                    }
                    byteArrayOutputStream.close();
                    return bitmap == null ? S() : byteArray;
                }
                return S();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }

    @Override // d.a.q0.a3.d.a
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            k0();
            super.p();
        }
    }

    @Override // d.a.q0.a3.d.a
    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdUniqueId) == null) {
            super.q(bdUniqueId);
            W();
        }
    }
}
