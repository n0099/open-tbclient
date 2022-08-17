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
/* loaded from: classes6.dex */
public class hf8 extends gf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Tencent j;
    public int k;
    public IUiListener l;
    public final jg<EmotionShareLoaderProc.EmotionShare> m;
    public jg<zm> n;

    /* loaded from: classes6.dex */
    public class a extends jg<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf8 a;

        public a(hf8 hf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jg
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                    hf8 hf8Var = this.a;
                    hf8Var.I(emotionShare.path, hf8Var.l);
                    return;
                }
                hf8 hf8Var2 = this.a;
                hf8Var2.t(2, hf8Var2.k);
            }
        }

        @Override // com.repackage.jg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                hf8 hf8Var = this.a;
                hf8Var.t(3, hf8Var.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends jg<zm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf8 a;

        /* loaded from: classes6.dex */
        public class a extends BdAsyncTask<zm, Void, Bitmap> {
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
            public Bitmap doInBackground(zm... zmVarArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zmVarArr)) == null) {
                    if (zmVarArr.length <= 0 || zmVarArr[0] == null) {
                        return null;
                    }
                    Bitmap p = zmVarArr[0].p();
                    hf8 hf8Var = this.a.a;
                    return hf8Var.u(p, hf8Var.e, true);
                }
                return (Bitmap) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                    super.onPostExecute((a) bitmap);
                    hf8 hf8Var = this.a.a;
                    hf8Var.H(hf8Var.e, hf8Var.l);
                }
            }
        }

        public b(hf8 hf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hf8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jg
        public void onLoaded(zm zmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, zmVar, str, i) == null) {
                super.onLoaded((b) zmVar, str, i);
                if (zmVar != null) {
                    a aVar = new a(this);
                    aVar.setPriority(3);
                    aVar.execute(zmVar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public nf8 a;
        public final /* synthetic */ hf8 b;

        public c(hf8 hf8Var, nf8 nf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hf8Var, nf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hf8Var;
            this.a = nf8Var;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FileHelper.deleteFile(new File(gf8.g + gf8.h));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                nf8 nf8Var = this.a;
                if (nf8Var != null) {
                    nf8Var.d1(this.b.k, 3);
                }
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                nf8 nf8Var = this.a;
                if (nf8Var != null) {
                    nf8Var.d1(this.b.k, 1);
                }
                hf8 hf8Var = this.b;
                hf8Var.t(1, hf8Var.k);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) {
                nf8 nf8Var = this.a;
                if (nf8Var != null) {
                    nf8Var.d1(this.b.k, 2);
                }
                String str = uiError != null ? uiError.errorMessage : null;
                hf8 hf8Var = this.b;
                hf8Var.B(2, str, hf8Var.k);
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
    public hf8(Context context) {
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
        this.k = 8;
        this.m = new a(this);
        this.n = new b(this);
        this.j = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void G(ShareEntity shareEntity, nf8 nf8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, nf8Var) == null) || shareEntity == null) {
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
        if (of8.startActivity(this.b, intent2)) {
            if (nf8Var != null) {
                nf8Var.d1(this.k, 1);
                return;
            }
            return;
        }
        if (nf8Var != null) {
            nf8Var.d1(this.k, 2);
        }
        t(2, this.k);
    }

    public final void H(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", shareEntity.getTitle());
        if (shareEntity.getReadCount() >= 0) {
            if (shareEntity.getReadCount() < 10000) {
                bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f1147));
            } else {
                bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.getReadCount()) + this.b.getString(R.string.obfuscated_res_0x7f0f1146));
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
        this.j.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    public final void I(String str, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iUiListener) == null) || TextUtils.isEmpty(str) || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 2);
        this.j.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    public final void J(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", of8.a(this.b));
        if (!StringUtils.isNull(shareEntity.getTitle())) {
            bundle.putString("summary", shareEntity.getTitle());
        } else if (!StringUtils.isNull(shareEntity.getContent())) {
            bundle.putString("summary", shareEntity.getContent());
        } else {
            bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f1147));
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
        this.j.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    @Override // com.repackage.mf8
    public void a(ShareEntity shareEntity, nf8 nf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, nf8Var) == null) {
            if (shareEntity != null && this.j != null) {
                this.e = shareEntity;
                Context context = this.b;
                if (context != null && (context instanceof Activity)) {
                    this.l = new c(this, nf8Var);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        J(shareEntity, this.l);
                        return;
                    }
                    String imgUrl = shareEntity.getImgUrl();
                    if (p(shareEntity.getLocalFile())) {
                        I(shareEntity.getLocalFile(), this.l);
                        return;
                    } else if (shareEntity.getShareType() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        kg.h().k(imgUrl, 34, this.m, 0, 0, i(), new Object[0]);
                        return;
                    } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                        if (this.e.getIsVideoThread()) {
                            kg.h().k(shareEntity.getImgUrl(), 10, this.n, 0, 0, i(), new Object[0]);
                            return;
                        } else {
                            H(shareEntity, this.l);
                            return;
                        }
                    } else if (o(shareEntity.getImageUri())) {
                        I(shareEntity.getImageUri().getPath(), this.l);
                        return;
                    } else {
                        G(shareEntity, nf8Var);
                        return;
                    }
                }
                t(2, this.k);
                if (nf8Var != null) {
                    nf8Var.d1(0, 2);
                    return;
                }
                return;
            }
            t(2, this.k);
            if (nf8Var != null) {
                nf8Var.d1(0, 2);
            }
        }
    }
}
