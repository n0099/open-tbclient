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
import com.repackage.cr4;
import com.repackage.nr4;
import com.repackage.wo8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class fb7 implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageViewerActivity a;
    public MultiImageView b;
    public PermissionJudgePolicy c;
    public j d;
    public String e;
    public wo8 f;
    public lr4 g;
    public nr4 h;
    public List<jr4> i;
    public jr4 j;
    public jr4 k;
    public jr4 l;
    public jr4 m;
    public jr4 n;
    public jr4 o;
    public db7 p;
    public CustomMessageListener q;
    public nr4.d r;
    public nr4.d s;
    public nr4.d t;
    public nr4.d u;
    public nr4.d v;
    public nr4.d w;
    public View.OnClickListener x;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fb7 fb7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var, Integer.valueOf(i)};
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
            this.a = fb7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            pi8 pi8Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof pi8) || this.a.a.isFinishing() || (pi8Var = (pi8) customResponsedMessage.getData()) == null) {
                return;
            }
            pi8Var.c = null;
            if (TextUtils.isEmpty(pi8Var.e) || TextUtils.isEmpty(pi8Var.b) || !pi8Var.b.equals(this.a.e)) {
                return;
            }
            this.a.b.setCurrentImageQRInfo(pi8Var.e);
            this.a.t(pi8Var.e);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        public b(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
        }

        @Override // com.repackage.nr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        public c(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.m(this.a.a.F2());
                this.a.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        public d(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bb7.a(this.a.a.getPageContext().getPageActivity(), this.a.b.getCurrentImageUrl());
                this.a.v();
                this.a.s(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        public e(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentOriginalUrl = this.a.b.getCurrentOriginalUrl();
                String currentImageUrl = this.a.b.getCurrentImageUrl();
                String currentPicId = this.a.b.getCurrentPicId();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
                } else {
                    Intent intent = new Intent(m45.a);
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra(m45.b, currentOriginalUrl);
                    intent.putExtra(m45.c, currentImageUrl);
                    intent.putExtra(m45.d, currentPicId);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.a.v();
                this.a.s(2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        public f(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
        }

        @Override // com.repackage.nr4.d
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
                this.a.D();
                this.a.v();
                this.a.s(3);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        public g(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z();
                this.a.v();
                this.a.s(4);
                this.a.r();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements nr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        /* loaded from: classes6.dex */
        public class a implements wo8.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ h b;

            /* renamed from: com.repackage.fb7$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0633a implements cr4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0633a(a aVar) {
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

                @Override // com.repackage.cr4.e
                public void onClick(cr4 cr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                        cr4Var.dismiss();
                        a aVar = this.a;
                        aVar.b.a.A(aVar.a);
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class b implements cr4.e {
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

                @Override // com.repackage.cr4.e
                public void onClick(cr4 cr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                        cr4Var.dismiss();
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class c implements cr4.e {
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

                @Override // com.repackage.cr4.e
                public void onClick(cr4 cr4Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                        cr4Var.dismiss();
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

            @Override // com.repackage.wo8.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    cr4 cr4Var = new cr4(this.b.a.a.getPageContext().getPageActivity());
                    cr4Var.setTitle((String) null);
                    cr4Var.setMessageShowCenter(true);
                    cr4Var.setMessage(this.b.a.u(R.string.obfuscated_res_0x7f0f0f4e));
                    cr4Var.setPositiveButton(this.b.a.u(R.string.obfuscated_res_0x7f0f0f4f), new c(this));
                    cr4Var.setCancelable(false);
                    cr4Var.setCanceledOnTouchOutside(false);
                    cr4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.repackage.wo8.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    cr4 cr4Var = new cr4(this.b.a.a.getPageContext().getPageActivity());
                    cr4Var.setTitleShowCenter(true);
                    cr4Var.setTitle(this.b.a.u(R.string.obfuscated_res_0x7f0f0f4d));
                    cr4Var.setMessageShowCenter(true);
                    cr4Var.setMessage(this.b.a.u(R.string.obfuscated_res_0x7f0f0f4c));
                    cr4Var.setPositiveButton(this.b.a.u(R.string.obfuscated_res_0x7f0f0427), new C0633a(this));
                    cr4Var.setNegativeButton(this.b.a.u(R.string.obfuscated_res_0x7f0f036a), new b(this));
                    cr4Var.setCancelable(false);
                    cr4Var.setCanceledOnTouchOutside(false);
                    cr4Var.create(this.b.a.a.getPageContext()).show();
                }
            }

            @Override // com.repackage.wo8.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.b.a.A(this.a);
                }
            }

            @Override // com.repackage.wo8.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    pi.O(this.b.a.a.getPageContext().getPageActivity(), this.b.a.u(R.string.obfuscated_res_0x7f0f0f4b));
                }
            }
        }

        public h(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
        }

        @Override // com.repackage.nr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.a.b.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                    return;
                }
                if (!pi.D()) {
                    pi.O(this.a.a.getPageContext().getPageActivity(), this.a.u(R.string.obfuscated_res_0x7f0f0c2c));
                    return;
                }
                if (this.a.f != null && !this.a.f.isCancelled()) {
                    this.a.f.cancel();
                }
                this.a.f = new wo8(currentImageQRInfo, new a(this, currentImageQRInfo));
                this.a.f.setPriority(3);
                this.a.f.execute(new String[0]);
                this.a.v();
                this.a.s(5);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb7 a;

        public i(fb7 fb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb7Var;
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
                    shareItem.w = "https://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!oi.isEmpty(str2)) {
                shareItem.y = Uri.parse(str2);
                shareItem.g0 = 2;
                shareItem.u = this.a.u(R.string.obfuscated_res_0x7f0f1098);
                shareItem.v = this.a.u(R.string.obfuscated_res_0x7f0f1098);
                shareItem.z = str2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.D = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new jz4(this.a.a, null).t(shareItem);
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public byte[] b;
        public final /* synthetic */ fb7 c;

        public j(fb7 fb7Var, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb7Var, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fb7Var;
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
                Map<String, ImageUrlData> J2 = this.c.a.J2();
                if (this.a != null && J2 != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = J2.entrySet().iterator();
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
                            return this.c.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1094);
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
                        return this.c.u(R.string.obfuscated_res_0x7f0f1094);
                    }
                }
                return this.c.u(R.string.obfuscated_res_0x7f0f1093);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((j) str);
                if (!UbsABTestHelper.isImageViewerTestB() || this.c.u(R.string.obfuscated_res_0x7f0f1093).equals(str)) {
                    this.c.a.showToast(str);
                } else if (this.c.p != null) {
                    this.c.p.g(this.c.b, this.c.b.getBottomHeight(), this.c.x);
                }
                this.c.d = null;
            }
        }
    }

    public fb7(@Nullable ImageViewerActivity imageViewerActivity) {
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
        this.p = new db7(imageViewerActivity);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, str, false)));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j jVar = this.d;
            if (jVar != null) {
                jVar.cancel();
                this.d = null;
            }
            wo8 wo8Var = this.f;
            if (wo8Var != null) {
                wo8Var.cancel();
                this.f = null;
            }
            db7 db7Var = this.p;
            if (db7Var != null) {
                db7Var.f();
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = null;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                j jVar = new j(this, this.b.getCurrentImageUrl(), this.b.getCurrentImageData());
                this.d = jVar;
                jVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.a.M2())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i.clear();
            String o = this.b.o(this.a.F2());
            if (o != null) {
                jr4 jr4Var = new jr4(o, this.h);
                this.j = jr4Var;
                jr4Var.m(this.r);
                this.i.add(this.j);
            }
            jr4 jr4Var2 = new jr4(u(R.string.obfuscated_res_0x7f0f1099), this.h);
            this.l = jr4Var2;
            jr4Var2.m(this.u);
            this.i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.b3()) {
                jr4 jr4Var3 = new jr4(u(R.string.obfuscated_res_0x7f0f1098), this.h);
                this.m = jr4Var3;
                jr4Var3.m(this.t);
                this.i.add(this.m);
            }
            jr4 jr4Var4 = new jr4(u(R.string.obfuscated_res_0x7f0f08ae), this.h);
            this.k = jr4Var4;
            jr4Var4.m(this.s);
            this.i.add(this.k);
            String currentImageQRInfo = this.b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                jr4 jr4Var5 = new jr4(u(R.string.obfuscated_res_0x7f0f08d4), this.h);
                this.o = jr4Var5;
                jr4Var5.m(this.w);
                this.i.add(this.o);
            }
            jr4 jr4Var6 = new jr4(u(R.string.obfuscated_res_0x7f0f08d7), this.h);
            this.n = jr4Var6;
            jr4Var6.m(this.v);
            this.i.add(this.n);
            this.h.m(new b(this));
            this.h.j(this.i);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.g == null || this.a.isFinishing()) {
            return;
        }
        this.g.m();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String currentOriginalUrl = this.b.getCurrentOriginalUrl();
            String currentImageUrl = this.b.getCurrentImageUrl();
            String currentPicId = this.b.getCurrentPicId();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentOriginalUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(m45.a);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra(m45.b, currentOriginalUrl);
                intent.putExtra(m45.c, currentImageUrl);
                intent.putExtra(m45.d, currentPicId);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            s(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            if (this.c == null) {
                this.c = new PermissionJudgePolicy();
            }
            this.c.clearRequestPermissionList();
            this.c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.c.startRequestPermission(pageActivity)) {
                return;
            }
            D();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.a.N2()).param("obj_type", i2));
            int i3 = i2 == 1 ? 22 : i2 == 2 ? 21 : i2 == 3 ? 20 : 0;
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void t(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.g == null || this.a.isFinishing() || !this.g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        jr4 jr4Var = new jr4(u(R.string.obfuscated_res_0x7f0f08d4), this.h);
        this.o = jr4Var;
        jr4Var.m(this.w);
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

    public final String u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.a.getString(i2) : (String) invokeI.objValue;
    }

    public void v() {
        lr4 lr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (lr4Var = this.g) != null && lr4Var.isShowing()) {
            this.g.dismiss();
        }
    }

    public void w(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, multiImageView) == null) {
            this.b = multiImageView;
            if (this.g == null) {
                this.h = new nr4(this.a);
            }
            if (this.i == null) {
                this.i = new ArrayList();
            }
            E();
            this.g = new lr4(this.a.getPageContext(), this.h);
        }
    }

    public void x(View view2) {
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && view2 != null && (view2 instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view2;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData != null && !TextUtils.isEmpty(imageUrlData.qrInfo)) || (imageBitmap = dragImageView.getImageBitmap()) == null || imageBitmap.isRecycled()) {
                return;
            }
            pi8 pi8Var = new pi8();
            pi8Var.a = 0;
            pi8Var.c = imageBitmap;
            String currentImageUrl = this.b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                pi8Var.b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                pi8Var.b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.e = pi8Var.b;
            this.a.sendMessage(new CustomMessage(2921403, pi8Var));
        }
    }

    public void y() {
        nr4 nr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (nr4Var = this.h) == null) {
            return;
        }
        nr4Var.i();
    }

    public void z() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (multiImageView = this.b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
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
                shareItem.w = "https://tieba.baidu.com/p/" + j2 + "?fr=share";
            }
        }
        boolean z = false;
        if (!oi.isEmpty(str2)) {
            shareItem.y = Uri.parse(str2);
            shareItem.g0 = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.D = bundle;
        }
        shareItem.j = true;
        shareItem.H = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, false);
        if (UbsABTestHelper.isImageViewerTestA()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.b.o(this.a.F2());
            ImageViewerActivity imageViewerActivity = this.a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.b3()) ? false : true;
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
        ImageViewerActivity imageViewerActivity2 = this.a;
        if (imageViewerActivity2 != null) {
            imageViewerActivity2.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
