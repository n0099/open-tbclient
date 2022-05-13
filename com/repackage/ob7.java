package com.repackage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import com.repackage.qq8;
import com.repackage.yr4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ob7 implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageViewerActivity a;
    public MultiImageView b;
    public PermissionJudgePolicy c;
    public j d;
    public String e;
    public qq8 f;
    public wr4 g;
    public yr4 h;
    public List<ur4> i;
    public ur4 j;
    public ur4 k;
    public ur4 l;
    public ur4 m;
    public ur4 n;
    public ur4 o;
    public mb7 p;
    public CustomMessageListener q;
    public yr4.d r;
    public yr4.d s;
    public yr4.d t;
    public yr4.d u;
    public yr4.d v;
    public yr4.d w;
    public View.OnClickListener x;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ob7 ob7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            bk8 bk8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof bk8) || this.a.a.isFinishing() || (bk8Var = (bk8) customResponsedMessage.getData()) == null) {
                return;
            }
            bk8Var.c = null;
            if (TextUtils.isEmpty(bk8Var.e) || TextUtils.isEmpty(bk8Var.b) || !bk8Var.b.equals(this.a.e)) {
                return;
            }
            this.a.b.setCurrentImageQRInfo(bk8Var.e);
            this.a.s(bk8Var.e);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public b(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // com.repackage.yr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public c(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.m(this.a.a.calCurrentIndex());
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public d(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kb7.a(this.a.a.getPageContext().getPageActivity(), this.a.b.getCurrentImageUrl());
                this.a.u();
                this.a.r(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public e(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageUrl = this.a.b.getCurrentImageUrl();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                } else {
                    Intent intent = new Intent(z35.a);
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra(z35.b, currentImageUrl);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.a.u();
                this.a.r(2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public f(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.a.a.getPageContext().getPageActivity();
                if (this.a.c == null) {
                    this.a.c = new PermissionJudgePolicy();
                }
                this.a.c.clearRequestPermissionList();
                this.a.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.a.c.startRequestPermission(pageActivity)) {
                    return;
                }
                this.a.C();
                this.a.u();
                this.a.r(3);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public g(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
                this.a.u();
                this.a.r(4);
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        /* loaded from: classes6.dex */
        public class a implements qq8.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ h b;

            /* renamed from: com.repackage.ob7$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0480a implements nr4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0480a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.repackage.nr4.e
                public void onClick(nr4 nr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                        nr4Var.dismiss();
                        a aVar = this.a;
                        aVar.b.a.z(aVar.a);
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class b implements nr4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.repackage.nr4.e
                public void onClick(nr4 nr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                        nr4Var.dismiss();
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class c implements nr4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public c(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.repackage.nr4.e
                public void onClick(nr4 nr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                        nr4Var.dismiss();
                    }
                }
            }

            public a(h hVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = str;
            }

            @Override // com.repackage.qq8.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    nr4 nr4Var = new nr4(this.b.a.a.getPageContext().getPageActivity());
                    nr4Var.setTitle((String) null);
                    nr4Var.setMessageShowCenter(true);
                    nr4Var.setMessage(this.b.a.t(R.string.obfuscated_res_0x7f0f0f39));
                    nr4Var.setPositiveButton(this.b.a.t(R.string.obfuscated_res_0x7f0f0f3a), new c(this));
                    nr4Var.setCancelable(false);
                    nr4Var.setCanceledOnTouchOutside(false);
                    nr4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.repackage.qq8.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    nr4 nr4Var = new nr4(this.b.a.a.getPageContext().getPageActivity());
                    nr4Var.setTitleShowCenter(true);
                    nr4Var.setTitle(this.b.a.t(R.string.obfuscated_res_0x7f0f0f38));
                    nr4Var.setMessageShowCenter(true);
                    nr4Var.setMessage(this.b.a.t(R.string.obfuscated_res_0x7f0f0f37));
                    nr4Var.setPositiveButton(this.b.a.t(R.string.obfuscated_res_0x7f0f0428), new C0480a(this));
                    nr4Var.setNegativeButton(this.b.a.t(R.string.obfuscated_res_0x7f0f0374), new b(this));
                    nr4Var.setCancelable(false);
                    nr4Var.setCanceledOnTouchOutside(false);
                    nr4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.repackage.qq8.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.b.a.z(this.a);
                }
            }

            @Override // com.repackage.qq8.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    mi.N(this.b.a.a.getPageContext().getPageActivity(), this.b.a.t(R.string.obfuscated_res_0x7f0f0f36));
                }
            }
        }

        public h(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.a.b.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                    return;
                }
                if (!mi.C()) {
                    mi.N(this.a.a.getPageContext().getPageActivity(), this.a.t(R.string.obfuscated_res_0x7f0f0c2e));
                    return;
                }
                if (this.a.f != null && !this.a.f.isCancelled()) {
                    this.a.f.cancel();
                }
                this.a.f = new qq8(currentImageQRInfo, new a(this, currentImageQRInfo));
                this.a.f.setPriority(3);
                this.a.f.execute(new String[0]);
                this.a.u();
                this.a.r(5);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob7 a;

        public i(ob7 ob7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || (currentUrlDragImageView = this.a.b.getCurrentUrlDragImageView()) == null) {
                return;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str2 = "";
            if (imageUrlData != null) {
                str2 = imageUrlData.imageUrl;
                str = BigImageLoaderProc.getNameMd5FromUrl(str2);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.a.b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.v = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!li.isEmpty(str2)) {
                shareItem.x = Uri.parse(str2);
                shareItem.f0 = 2;
                shareItem.t = this.a.t(R.string.obfuscated_res_0x7f0f1086);
                shareItem.u = this.a.t(R.string.obfuscated_res_0x7f0f1086);
                shareItem.y = str2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.C = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new fz4(this.a.a, null).t(shareItem);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ ob7 c;

        public j(ob7 ob7Var, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob7Var, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ob7Var;
            this.a = str;
            this.b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            byte[] bArr;
            String nameMd5FromUrl;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                Map<String, ImageUrlData> assistUrls = this.c.a.getAssistUrls();
                if (this.a != null && assistUrls != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = assistUrls.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, ImageUrlData> next = it.next();
                        if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.a)) {
                            imageUrlData = next.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.a, this.c.a.getPageContext().getPageActivity()) == 0) {
                            return this.c.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1082);
                        }
                    }
                }
                String str2 = this.a;
                if (str2 != null && (bArr = this.b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.c.a.getPageContext().getPageActivity());
                    if (saveImageFileByUser == -2) {
                        return FileHelper.getSdErrorString();
                    }
                    if (saveImageFileByUser == 0) {
                        return this.c.t(R.string.obfuscated_res_0x7f0f1082);
                    }
                }
                return this.c.t(R.string.obfuscated_res_0x7f0f1081);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((j) str);
                if (!UbsABTestHelper.isImageViewerTestB() || this.c.t(R.string.obfuscated_res_0x7f0f1081).equals(str)) {
                    this.c.a.showToast(str);
                } else if (this.c.p != null) {
                    this.c.p.g(this.c.b, this.c.b.getBottomHeight(), this.c.x);
                }
                this.c.d = null;
            }
        }
    }

    public ob7(@Nullable ImageViewerActivity imageViewerActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageViewerActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.i = null;
        this.q = new a(this, 2921403);
        this.r = new c(this);
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new i(this);
        this.a = imageViewerActivity;
        imageViewerActivity.registerListener(this.q);
        this.p = new mb7(imageViewerActivity);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = this.d;
            if (jVar != null) {
                jVar.cancel();
                this.d = null;
            }
            qq8 qq8Var = this.f;
            if (qq8Var != null) {
                qq8Var.cancel();
                this.f = null;
            }
            mb7 mb7Var = this.p;
            if (mb7Var != null) {
                mb7Var.f();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = null;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                j jVar = new j(this, this.b.getCurrentImageUrl(), this.b.getCurrentImageData());
                this.d = jVar;
                jVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.a.getFrom())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i.clear();
            String o = this.b.o(this.a.calCurrentIndex());
            if (o != null) {
                ur4 ur4Var = new ur4(o, this.h);
                this.j = ur4Var;
                ur4Var.m(this.r);
                this.i.add(this.j);
            }
            ur4 ur4Var2 = new ur4(t(R.string.obfuscated_res_0x7f0f1087), this.h);
            this.l = ur4Var2;
            ur4Var2.m(this.u);
            this.i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.isIsBJHThread()) {
                ur4 ur4Var3 = new ur4(t(R.string.obfuscated_res_0x7f0f1086), this.h);
                this.m = ur4Var3;
                ur4Var3.m(this.t);
                this.i.add(this.m);
            }
            ur4 ur4Var4 = new ur4(t(R.string.obfuscated_res_0x7f0f08a1), this.h);
            this.k = ur4Var4;
            ur4Var4.m(this.s);
            this.i.add(this.k);
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                ur4 ur4Var5 = new ur4(t(R.string.obfuscated_res_0x7f0f08c2), this.h);
                this.o = ur4Var5;
                ur4Var5.m(this.w);
                this.i.add(this.o);
            }
            ur4 ur4Var6 = new ur4(t(R.string.obfuscated_res_0x7f0f08c5), this.h);
            this.n = ur4Var6;
            ur4Var6.m(this.v);
            this.i.add(this.n);
            this.h.m(new b(this));
            this.h.j(this.i);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.g == null || this.a.isFinishing()) {
            return;
        }
        this.g.m();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String currentImageUrl = this.b.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(z35.a);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra(z35.b, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            r(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void onSave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            if (this.c == null) {
                this.c = new PermissionJudgePolicy();
            }
            this.c.clearRequestPermissionList();
            this.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.c.startRequestPermission(pageActivity)) {
                return;
            }
            C();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.a.getUserId()).param("obj_type", i2));
            int i3 = i2 == 1 ? 22 : i2 == 2 ? 21 : i2 == 3 ? 20 : 0;
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void s(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.g == null || this.a.isFinishing() || !this.g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        ur4 ur4Var = new ur4(t(R.string.obfuscated_res_0x7f0f08c2), this.h);
        this.o = ur4Var;
        ur4Var.m(this.w);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.i.size()) {
                if (this.k != null && this.i.get(i3) == this.k && (i2 = i3 + 1) <= this.i.size()) {
                    this.i.add(i2, this.o);
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (!z) {
            this.i.add(this.o);
        }
        this.h.j(this.i);
    }

    public final String t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.a.getString(i2) : (String) invokeI.objValue;
    }

    public void u() {
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (wr4Var = this.g) != null && wr4Var.isShowing()) {
            this.g.dismiss();
        }
    }

    public void v(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, multiImageView) == null) {
            this.b = multiImageView;
            if (this.g == null) {
                this.h = new yr4(this.a);
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            D();
            this.g = new wr4(this.a.getPageContext(), this.h);
        }
    }

    public void w(View view2) {
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && view2 != null && (view2 instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view2;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData != null && !TextUtils.isEmpty(imageUrlData.qrInfo)) || (imageBitmap = dragImageView.getImageBitmap()) == null || imageBitmap.isRecycled()) {
                return;
            }
            bk8 bk8Var = new bk8();
            bk8Var.a = 0;
            bk8Var.c = imageBitmap;
            String currentImageUrl = this.b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                bk8Var.b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                bk8Var.b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.e = bk8Var.b;
            this.a.sendMessage(new CustomMessage(2921403, bk8Var));
        }
    }

    public void x() {
        yr4 yr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (yr4Var = this.h) == null) {
            return;
        }
        yr4Var.i();
    }

    public void y() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (multiImageView = this.b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
            return;
        }
        ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
        String str2 = "";
        if (imageUrlData != null) {
            str2 = imageUrlData.imageUrl;
            str = BigImageLoaderProc.getNameMd5FromUrl(str2);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.b.getCurrentImageUrl();
            str = TbMd5.getNameMd5FromUrl(str2);
        }
        ShareItem shareItem = new ShareItem();
        if (imageUrlData != null) {
            long j2 = imageUrlData.threadId;
            if (j2 > 0) {
                shareItem.v = "http://tieba.baidu.com/p/" + j2 + "?fr=share";
            }
        }
        boolean z = false;
        if (!li.isEmpty(str2)) {
            shareItem.x = Uri.parse(str2);
            shareItem.f0 = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.C = bundle;
        }
        shareItem.j = true;
        shareItem.G = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, false);
        if (UbsABTestHelper.isImageViewerTestA()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.b.o(this.a.calCurrentIndex());
            ImageViewerActivity imageViewerActivity = this.a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.isIsBJHThread()) ? false : true;
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                z = true;
            }
            shareDialogConfig.showQRCode = z;
            shareDialogConfig.dialogSaveToDiskListener = this.u;
            shareDialogConfig.dialogAddToExpressionListener = this.t;
            shareDialogConfig.dialogDownloadOriginListener = this.r;
            shareDialogConfig.dialogRecognizePicListener = this.s;
            shareDialogConfig.qrCodeClickListener = this.w;
            shareDialogConfig.onWeChatEmotionShareListener = this.x;
        }
        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, str, false)));
        }
    }
}
