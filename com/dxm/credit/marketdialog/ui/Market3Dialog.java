package com.dxm.credit.marketdialog.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.RoundRectNetImageView;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.dxm.credit.marketdialog.data.MarketDialogResponse;
import java.util.Arrays;
/* loaded from: classes12.dex */
public class Market3Dialog extends MarketBaseDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_SIZE_BIG = "1";
    public static final String TYPE_SIZE_DEFAULT = "0";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public Context f55029j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f55030k;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Market3Dialog f55031e;

        /* renamed from: com.dxm.credit.marketdialog.ui.Market3Dialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class C1966a implements SDKJumpManager.OnJumpListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1966a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.wallet.base.widget.SDKJumpManager.OnJumpListener
            public void beforeJump(Context context, String str, String str2, String str3, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z)}) == null) {
                    MarketDialogResponse.Dialog dialog = this.a.f55031e.mData;
                    DXMSdkSAUtils.onEventWithValues("sdk_market_dialog_click_jump", Arrays.asList(dialog.group_name, dialog.group_limit));
                }
            }
        }

        public a(Market3Dialog market3Dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {market3Dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55031e = market3Dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                return;
            }
            SDKJumpManager sDKJumpManager = SDKJumpManager.getInstance();
            Context context = this.f55031e.getContext();
            MarketDialogResponse.Dialog dialog = this.f55031e.mData;
            sDKJumpManager.doSDKJump(context, dialog.group_name, dialog.group_link_type, dialog.group_link_addr, false, new C1966a(this));
            this.f55031e.dismissOnly();
        }
    }

    /* loaded from: classes12.dex */
    public class b implements ImageLoader.OnGetBitmapListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RoundRectNetImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Market3Dialog f55032b;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f55033e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f55034f;

            public a(b bVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55034f = bVar;
                this.f55033e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f55034f.a.setImageBitmap(this.f55033e);
                    this.f55034f.f55032b.showOnly();
                }
            }
        }

        /* renamed from: com.dxm.credit.marketdialog.ui.Market3Dialog$b$b  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class RunnableC1967b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f55035e;

            public RunnableC1967b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55035e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f55035e.f55032b.dismiss();
                }
            }
        }

        public b(Market3Dialog market3Dialog, RoundRectNetImageView roundRectNetImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {market3Dialog, roundRectNetImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55032b = market3Dialog;
            this.a = roundRectNetImageView;
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public boolean needCancel(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onError(String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
                this.f55032b.f55030k.post(new RunnableC1967b(this));
            }
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) || bitmap == null || this.a == null) {
                return;
            }
            this.f55032b.f55030k.post(new a(this, bitmap));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1620606094, "Lcom/dxm/credit/marketdialog/ui/Market3Dialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1620606094, "Lcom/dxm/credit/marketdialog/ui/Market3Dialog;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Market3Dialog(Context context) {
        super(context, ResUtils.style(context, "WalletTheme.TranslucentDialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55029j = context;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Market3Dialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(ResUtils.layout(this.f55029j, "credit_market_dialog_layout_3"), (ViewGroup) null);
            this.mRootView = inflate;
            setContentView(inflate);
        }
    }

    @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog
    public boolean initViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                RoundRectNetImageView roundRectNetImageView = (RoundRectNetImageView) findViewById(ResUtils.id(this.f55029j, "image"));
                if (roundRectNetImageView != null) {
                    roundRectNetImageView.setCornerSize(DisplayUtils.dip2px(getContext(), 20.0f));
                }
                this.close = findViewById(ResUtils.id(this.f55029j, IntentConfig.CLOSE));
                if (this.mData.isClickable()) {
                    roundRectNetImageView.setOnClickListener(new a(this));
                }
                setCancelable(true);
                roundRectNetImageView.setImageUrl(this.mData.group_img, true);
                if (this.f55030k == null) {
                    this.f55030k = new Handler(Looper.getMainLooper());
                }
                ImageLoader.getInstance(this.f55029j).getBitmapFromDiskOrNet(this.mData.group_img, new b(this, roundRectNetImageView), null, 0);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                setCancelable(true);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean isValid = super.isValid();
            return isValid && (isValid && !TextUtils.isEmpty(this.mData.group_img));
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setCancelable(false);
        }
    }

    @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog, android.app.Dialog, c.e.b.a.c.b
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!isValid()) {
                dismiss();
            } else if (isShowing()) {
            } else {
                initViews();
                dealCloseButton();
            }
        }
    }
}
