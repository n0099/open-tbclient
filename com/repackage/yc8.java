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
public class yc8 extends xc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Tencent i;
    public int j;
    public IUiListener k;
    public final ig<EmotionShareLoaderProc.EmotionShare> l;
    public ig<ym> m;

    /* loaded from: classes7.dex */
    public class a extends ig<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        public a(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                    yc8 yc8Var = this.a;
                    yc8Var.E(emotionShare.path, yc8Var.k);
                    return;
                }
                yc8 yc8Var2 = this.a;
                yc8Var2.s(2, yc8Var2.j);
            }
        }

        @Override // com.repackage.ig
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                yc8 yc8Var = this.a;
                yc8Var.s(3, yc8Var.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ig<ym> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc8 a;

        /* loaded from: classes7.dex */
        public class a extends BdAsyncTask<ym, Void, Bitmap> {
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
            public Bitmap doInBackground(ym... ymVarArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ymVarArr)) == null) {
                    if (ymVarArr.length <= 0 || ymVarArr[0] == null) {
                        return null;
                    }
                    Bitmap p = ymVarArr[0].p();
                    yc8 yc8Var = this.a.a;
                    return yc8Var.t(p, yc8Var.e, true);
                }
                return (Bitmap) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                    super.onPostExecute((a) bitmap);
                    yc8 yc8Var = this.a.a;
                    yc8Var.D(yc8Var.e, yc8Var.k);
                }
            }
        }

        public b(yc8 yc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ig
        public void onLoaded(ym ymVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) {
                super.onLoaded((b) ymVar, str, i);
                if (ymVar != null) {
                    a aVar = new a(this);
                    aVar.setPriority(3);
                    aVar.execute(ymVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ed8 a;
        public final /* synthetic */ yc8 b;

        public c(yc8 yc8Var, ed8 ed8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc8Var, ed8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yc8Var;
            this.a = ed8Var;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FileHelper.deleteFile(new File(xc8.f + xc8.g));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ed8 ed8Var = this.a;
                if (ed8Var != null) {
                    ed8Var.e1(this.b.j, 3);
                }
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                ed8 ed8Var = this.a;
                if (ed8Var != null) {
                    ed8Var.e1(this.b.j, 1);
                }
                yc8 yc8Var = this.b;
                yc8Var.s(1, yc8Var.j);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) {
                ed8 ed8Var = this.a;
                if (ed8Var != null) {
                    ed8Var.e1(this.b.j, 2);
                }
                String str = uiError != null ? uiError.errorMessage : null;
                yc8 yc8Var = this.b;
                yc8Var.y(2, str, yc8Var.j);
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
    public yc8(Context context) {
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
        this.j = 8;
        this.l = new a(this);
        this.m = new b(this);
        this.i = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void C(ShareEntity shareEntity, ed8 ed8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, shareEntity, ed8Var) == null) || shareEntity == null) {
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
        if (fd8.startActivity(this.b, intent2)) {
            if (ed8Var != null) {
                ed8Var.e1(this.j, 1);
                return;
            }
            return;
        }
        if (ed8Var != null) {
            ed8Var.e1(this.j, 2);
        }
        s(2, this.j);
    }

    public final void D(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", shareEntity.getTitle());
        if (shareEntity.getReadCount() >= 0) {
            if (shareEntity.getReadCount() < 10000) {
                bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f115d));
            } else {
                bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.getReadCount()) + this.b.getString(R.string.obfuscated_res_0x7f0f115c));
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
        this.i.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    public final void E(String str, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iUiListener) == null) || TextUtils.isEmpty(str) || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 2);
        this.i.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    public final void F(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, shareEntity, iUiListener) == null) || shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", fd8.a(this.b));
        if (!StringUtils.isNull(shareEntity.getTitle())) {
            bundle.putString("summary", shareEntity.getTitle());
        } else if (!StringUtils.isNull(shareEntity.getContent())) {
            bundle.putString("summary", shareEntity.getContent());
        } else {
            bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f115d));
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
        this.i.shareToQQ((Activity) this.b, bundle, iUiListener);
    }

    @Override // com.repackage.dd8
    public void a(ShareEntity shareEntity, ed8 ed8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, ed8Var) == null) {
            if (shareEntity != null && this.i != null) {
                this.e = shareEntity;
                Context context = this.b;
                if (context != null && (context instanceof Activity)) {
                    this.k = new c(this, ed8Var);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        F(shareEntity, this.k);
                        return;
                    }
                    String imgUrl = shareEntity.getImgUrl();
                    if (o(shareEntity.getLocalFile())) {
                        E(shareEntity.getLocalFile(), this.k);
                        return;
                    } else if (shareEntity.getShareType() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        jg.h().k(imgUrl, 34, this.l, 0, 0, i(), new Object[0]);
                        return;
                    } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                        if (this.e.getIsVideoThread()) {
                            jg.h().k(shareEntity.getImgUrl(), 10, this.m, 0, 0, i(), new Object[0]);
                            return;
                        } else {
                            D(shareEntity, this.k);
                            return;
                        }
                    } else if (n(shareEntity.getImageUri())) {
                        E(shareEntity.getImageUri().getPath(), this.k);
                        return;
                    } else {
                        C(shareEntity, ed8Var);
                        return;
                    }
                }
                s(2, this.j);
                if (ed8Var != null) {
                    ed8Var.e1(0, 2);
                    return;
                }
                return;
            }
            s(2, this.j);
            if (ed8Var != null) {
                ed8Var.e1(0, 2);
            }
        }
    }
}
