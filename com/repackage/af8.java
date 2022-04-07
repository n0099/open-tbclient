package com.repackage;

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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class af8 extends ve8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public ShareEntity i;
    public cf8 j;
    public IWXAPI k;
    public d l;
    public final hg<EmotionShareLoaderProc.EmotionShare> m;
    public final c n;

    /* loaded from: classes5.dex */
    public class a extends hg<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af8 a;

        public a(af8 af8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null) {
                    af8 af8Var = this.a;
                    if (af8Var.a0(af8Var.i, emotionShare)) {
                        return;
                    }
                }
                this.a.n.onLoaded((fo) null, str, i);
            }
        }

        @Override // com.repackage.hg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.a.n.onCancelled(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Bitmap, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af8 a;

        public b(af8 af8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af8Var;
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
                af8 af8Var = this.a;
                return af8Var.r(bitmapArr[0], af8Var.i, false);
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((b) bitmap);
                af8 af8Var = this.a;
                af8Var.g0(af8Var.i, bitmap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class c extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af8 a;

        public c(af8 af8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af8Var;
        }

        @Override // com.repackage.hg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.a.j != null) {
                    this.a.j.onShare(this.a.h, 3);
                }
                af8 af8Var = this.a;
                af8Var.w(3, af8Var.h);
            }
        }

        public /* synthetic */ c(af8 af8Var, a aVar) {
            this(af8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, foVar, str, i) == null) {
                super.onLoaded((c) foVar, str, i);
                if (foVar == null) {
                    this.a.i0();
                    return;
                }
                Bitmap p = foVar.p();
                if (!TextUtils.isEmpty(this.a.i.getLinkUrl())) {
                    if (this.a.h != 2) {
                        String tid = this.a.i.getTid();
                        int typeShareToSmallApp = this.a.i.getTypeShareToSmallApp();
                        if ((typeShareToSmallApp == 2 || typeShareToSmallApp == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && this.a.i.canShareBySmartApp && !WeChatShareSmallAppToH5Switch.isOn()) {
                            af8 af8Var = this.a;
                            af8Var.d0(af8Var.i, p);
                            return;
                        }
                        af8 af8Var2 = this.a;
                        af8Var2.h0(af8Var2.i, p);
                        return;
                    }
                    af8 af8Var3 = this.a;
                    af8Var3.h0(af8Var3.i, p);
                } else if (TextUtils.isEmpty(this.a.i.getVideoUrl())) {
                    if (!TextUtils.isEmpty(this.a.i.getContent())) {
                        this.a.i0();
                        return;
                    }
                    af8 af8Var4 = this.a;
                    af8Var4.b0(af8Var4.i, p);
                } else {
                    af8 af8Var5 = this.a;
                    af8Var5.f0(af8Var5.i, p);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af8 this$0;

        public d(af8 af8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = af8Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (this.this$0.j != null) {
                        this.this$0.j.onShare(this.this$0.h, 1);
                    }
                    af8 af8Var = this.this$0;
                    af8Var.w(1, af8Var.h);
                } else if (intExtra == -2) {
                    if (this.this$0.j != null) {
                        this.this$0.j.onShare(this.this$0.h, 3);
                    }
                    af8 af8Var2 = this.this$0;
                    af8Var2.w(3, af8Var2.h);
                } else {
                    this.this$0.l0(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (this.this$0.j != null) {
                        this.this$0.j.onShare(this.this$0.h, 2);
                    }
                    af8 af8Var3 = this.this$0;
                    af8Var3.w(2, af8Var3.h);
                }
                this.this$0.T();
            }
        }

        public /* synthetic */ d(af8 af8Var, a aVar) {
            this(af8Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af8(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        this.m = new a(this);
        this.n = new c(this, null);
        this.b = context.getApplicationContext();
        this.h = i;
        this.k = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    public byte[] M(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            try {
                Bitmap i = i(bitmap, 120);
                if (i == null) {
                    i = d();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                i.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] N(Bitmap bitmap, int i, boolean z) {
        InterceptResult invokeCommon;
        Bitmap i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                if (z) {
                    i2 = e(R.drawable.obfuscated_res_0x7f080d5a);
                } else {
                    i2 = i(bitmap, i);
                }
                if (i2 == null) {
                    i2 = e(R.drawable.obfuscated_res_0x7f080d5a);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                i2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.h;
            if (i == 3) {
                return 0;
            }
            return i == 2 ? 1 : -1;
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
                Bitmap e = e(R.drawable.obfuscated_res_0x7f080d5a);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                e.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FileHelper.deleteFile(new File(ve8.e + ve8.g));
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
            Context context = this.b;
            if (context != null && wXImageObject != null && bitmap != null && R(context) && Q()) {
                try {
                    X(wXImageObject, FileHelper.saveFileAsPNG(ve8.e, ve8.g, bitmap, 100), bitmap);
                    return true;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.b == null) {
            return;
        }
        this.l = new d(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
        this.b.registerReceiver(this.l, intentFilter);
    }

    public final void X(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, wXImageObject, str, bitmap) == null) {
            wXImageObject.setImagePath(U(this.b, new File(str)));
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

    @Override // com.repackage.bf8
    public void a(ShareEntity shareEntity, cf8 cf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, shareEntity, cf8Var) == null) {
            if (shareEntity != null && this.k != null) {
                this.i = shareEntity;
                this.j = cf8Var;
                this.h = shareEntity.getShareTo();
                if (!this.k.isWXAppInstalled()) {
                    cf8 cf8Var2 = this.j;
                    if (cf8Var2 != null) {
                        cf8Var2.onShare(this.h, 2);
                    }
                    BdToast.e(c(), c().getText(R.string.obfuscated_res_0x7f0f1156), 0, ShareHandlerActivity.skinType).q();
                    return;
                }
                fo o = o(shareEntity);
                if (o != null && o.p() != null) {
                    if (this.i.getShareType() == 2) {
                        Z(this.i, o.p());
                        return;
                    } else {
                        b0(this.i, o.p());
                        return;
                    }
                } else if (n(shareEntity.getLocalFile())) {
                    j0(shareEntity.getLocalFile());
                    return;
                } else {
                    String imgUrl = shareEntity.getImgUrl();
                    if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        if (this.i.getShareType() != 0) {
                            ig.h().k(imgUrl, 34, this.m, 0, 0, h(), new Object[0]);
                            return;
                        } else {
                            ig.h().k(imgUrl, 10, this.n, 0, 0, h(), new Object[0]);
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
            w(2, this.h);
            if (cf8Var != null) {
                cf8Var.onShare(0, 2);
            }
        }
    }

    public final boolean a0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, shareEntity, emotionShare)) == null) {
            if (this.h != 2 && this.i.getShareType() != 1) {
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
        wXImageObject.imageData = gi.d().a(bitmap, 85);
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
        fo foVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, shareEntity, emotionShare)) == null) {
            if (shareEntity == null || this.k == null || emotionShare == null || StringUtils.isNull(emotionShare.path) || (foVar = emotionShare.image) == null || foVar.p() == null) {
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
            if (ni.isEmpty(str)) {
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
            g0(this.i, bitmap);
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Bitmap d2 = d();
            if (d2 != null) {
                b0(this.i, d2);
            } else {
                e0(this.i);
            }
        }
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bitmap g = g(str);
            if (g == null) {
                g = d();
            }
            if (g != null) {
                b0(this.i, g);
            } else {
                e0(this.i);
            }
        }
    }

    public final void k0() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (context = this.b) == null || (dVar = this.l) == null) {
            return;
        }
        context.unregisterReceiver(dVar);
    }

    public final void l0(int i, String str) {
        ShareEntity shareEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048602, this, i, str) == null) || (shareEntity = this.i) == null || StringUtils.isNull(shareEntity.getImgUrl())) {
            return;
        }
        lt4.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.i.getImgUrl());
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
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }

    @Override // com.repackage.ve8
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            k0();
            super.p();
        }
    }

    @Override // com.repackage.ve8
    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdUniqueId) == null) {
            super.q(bdUniqueId);
            W();
        }
    }
}
