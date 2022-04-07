package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class we8 extends ve8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Tencent h;
    public int i;
    public IUiListener j;
    public ShareEntity k;
    public final hg<EmotionShareLoaderProc.EmotionShare> l;
    public hg<fo> m;

    /* loaded from: classes7.dex */
    public class a extends hg<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ we8 a;

        public a(we8 we8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = we8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                    we8 we8Var = this.a;
                    we8Var.D(emotionShare.path, we8Var.j);
                    return;
                }
                we8 we8Var2 = this.a;
                we8Var2.w(2, we8Var2.i);
            }
        }

        @Override // com.repackage.hg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                we8 we8Var = this.a;
                we8Var.w(3, we8Var.i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ we8 a;

        /* loaded from: classes7.dex */
        public class a extends BdAsyncTask<fo, Void, Bitmap> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Bitmap doInBackground(fo... foVarArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, foVarArr)) == null) {
                    if (foVarArr.length <= 0 || foVarArr[0] == null) {
                        return null;
                    }
                    Bitmap p = foVarArr[0].p();
                    we8 we8Var = this.a.a;
                    return we8Var.r(p, we8Var.k, true);
                }
                return (Bitmap) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                    super.onPostExecute((a) bitmap);
                    we8 we8Var = this.a.a;
                    we8Var.C(we8Var.k, we8Var.j);
                }
            }
        }

        public b(we8 we8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = we8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) {
                super.onLoaded((b) foVar, str, i);
                if (foVar != null) {
                    a aVar = new a(this);
                    aVar.setPriority(3);
                    aVar.execute(foVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public cf8 a;
        public final /* synthetic */ we8 b;

        public c(we8 we8Var, cf8 cf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we8Var, cf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = we8Var;
            this.a = cf8Var;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FileHelper.deleteFile(new File(ve8.e + ve8.f));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                cf8 cf8Var = this.a;
                if (cf8Var != null) {
                    cf8Var.onShare(this.b.i, 3);
                }
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                cf8 cf8Var = this.a;
                if (cf8Var != null) {
                    cf8Var.onShare(this.b.i, 1);
                }
                we8 we8Var = this.b;
                we8Var.w(1, we8Var.i);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) {
                cf8 cf8Var = this.a;
                if (cf8Var != null) {
                    cf8Var.onShare(this.b.i, 2);
                }
                String str = uiError != null ? uiError.errorMessage : null;
                we8 we8Var = this.b;
                we8Var.x(2, str, we8Var.i);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public we8(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.i = 8;
        this.l = new a(this);
        this.m = new b(this);
        this.h = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void B(ShareEntity shareEntity, cf8 cf8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, cf8Var) == null) || shareEntity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Iterator<ResolveInfo> it = this.b.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            ResolveInfo next = it.next();
            if (TextUtils.equals("com.tencent.mobileqq", next.activityInfo.packageName)) {
                str = next.activityInfo.name;
                break;
            }
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.SUBJECT", shareEntity.getTitle());
        intent2.putExtra("android.intent.extra.TEXT", shareEntity.getContent());
        intent2.setClassName("com.tencent.mobileqq", str);
        intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        if (df8.startActivity(this.b, intent2)) {
            if (cf8Var != null) {
                cf8Var.onShare(this.i, 1);
                return;
            }
            return;
        }
        if (cf8Var != null) {
            cf8Var.onShare(this.i, 2);
        }
        w(2, this.i);
    }

    public final void C(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", shareEntity.getTitle());
        if (shareEntity.getReadCount() >= 0) {
            if (shareEntity.getReadCount() < 10000) {
                bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f112e));
            } else {
                bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.getReadCount()) + this.b.getString(R.string.obfuscated_res_0x7f0f112d));
            }
        } else {
            bundle.putString("summary", shareEntity.getContent());
        }
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        bundle.putInt("req_type", 1);
        if (shareEntity.getIsVideoThread() && !StringUtils.isNull(shareEntity.getImgUrl()) && !shareEntity.getImgUrl().startsWith("http")) {
            bundle.putString("imageLocalUrl", shareEntity.getImgUrl());
        } else {
            bundle.putString("imageUrl", shareEntity.getImgUrl());
        }
        this.h.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    public final void D(String str, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iUiListener) == null) || TextUtils.isEmpty(str) || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 2);
        this.h.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    public final void E(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", df8.a(this.b));
        if (!StringUtils.isNull(shareEntity.getTitle())) {
            bundle.putString("summary", shareEntity.getTitle());
        } else if (!StringUtils.isNull(shareEntity.getContent())) {
            bundle.putString("summary", shareEntity.getContent());
        } else {
            bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f112e));
        }
        bundle.putString("targetUrl", shareEntity.getLinkUrl());
        if (!StringUtils.isNull(shareEntity.getImgUrl())) {
            bundle.putString("imageUrl", shareEntity.getImgUrl());
        } else {
            bundle.putString("imageUrl", "http://tb3.bdstatic.com/public/img/fcf10e29473417fa5e0d4a1e6.fcf10e29.png");
        }
        bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID, "1111264064");
        bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE, "3");
        bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH, "pages/pb/pb?tid=" + shareEntity.getTid());
        bundle.putInt("req_type", 7);
        this.h.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    @Override // com.repackage.bf8
    public void a(ShareEntity shareEntity, cf8 cf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, cf8Var) == null) {
            if (shareEntity != null && this.h != null) {
                Context context = this.b;
                if (context != null && (context instanceof Activity)) {
                    this.j = new c(this, cf8Var);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        E(shareEntity, this.j);
                        return;
                    }
                    String imgUrl = shareEntity.getImgUrl();
                    if (n(shareEntity.getLocalFile())) {
                        D(shareEntity.getLocalFile(), this.j);
                        return;
                    } else if (shareEntity.getShareType() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        ig.h().k(imgUrl, 34, this.l, 0, 0, h(), new Object[0]);
                        return;
                    } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                        this.k = shareEntity;
                        if (shareEntity.getIsVideoThread()) {
                            ig.h().k(shareEntity.getImgUrl(), 10, this.m, 0, 0, h(), new Object[0]);
                            return;
                        } else {
                            C(shareEntity, this.j);
                            return;
                        }
                    } else if (m(shareEntity.getImageUri())) {
                        D(shareEntity.getImageUri().getPath(), this.j);
                        return;
                    } else {
                        B(shareEntity, cf8Var);
                        return;
                    }
                }
                w(2, this.i);
                if (cf8Var != null) {
                    cf8Var.onShare(0, 2);
                    return;
                }
                return;
            }
            w(2, this.i);
            if (cf8Var != null) {
                cf8Var.onShare(0, 2);
            }
        }
    }
}
