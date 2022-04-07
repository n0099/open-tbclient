package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fj5 extends ck0 implements pj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj5 a;
        public final /* synthetic */ fj5 b;

        public a(fj5 fj5Var, oj5 oj5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fj5Var, oj5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fj5Var;
            this.a = oj5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b(view2)) {
                return;
            }
            this.b.p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.view.View] */
    public fj5(@NonNull oj5 oj5Var, @NonNull hk0<?> hk0Var, @NonNull AdDownloadData adDownloadData) {
        super(y(adDownloadData), hk0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oj5Var, hk0Var, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((rj0) objArr2[0], (hk0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ?? realView = this.f.get().getRealView();
        if (realView != 0) {
            realView.setOnClickListener(new a(this, oj5Var));
        }
    }

    public static rj0 y(@NonNull AdDownloadData adDownloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adDownloadData)) == null) {
            if (hj0.a().query(adDownloadData.getDownloadKey()) != null) {
                return hj0.a().query(adDownloadData.getDownloadKey());
            }
            rj0 rj0Var = new rj0();
            rj0Var.g(adDownloadData.getDownloadKey());
            if (TextUtils.isEmpty(rj0Var.d())) {
                rj0Var.g(adDownloadData.getDownloadUrl());
            }
            rj0Var.g = adDownloadData.getDownloadUrl();
            rj0Var.d = adDownloadData.getPkgName();
            uj0 uj0Var = new uj0();
            uj0Var.j = adDownloadData.adId();
            uj0Var.a = adDownloadData.getExtInfo();
            uj0Var.g = adDownloadData.getAppIcon();
            uj0Var.h = adDownloadData.getAppName();
            if (z(adDownloadData.getCmdScheme())) {
                uj0Var.c = adDownloadData.getCmdScheme();
            }
            rj0Var.p = uj0Var;
            sj0 sj0Var = new sj0();
            sj0Var.a = adDownloadData.getPage();
            rj0Var.q = sj0Var;
            return rj0Var;
        }
        return (rj0) invokeL.objValue;
    }

    public static boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return TextUtils.equals("dlink", ei0.i(Uri.parse(str)));
            } catch (Exception e) {
                zi0.d("AdNewDownloadPresenter", "cmd parse faile, cmd=" + str, e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.pj5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View] */
    @Override // com.repackage.pj5
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.get().getRealView().setVisibility(0);
            p();
        }
    }

    @Override // com.repackage.ck0, com.repackage.zj0, com.repackage.gk0
    public void c(@NonNull AdDownloadAction adDownloadAction, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, rj0Var) == null) {
            super.c(adDownloadAction, rj0Var);
        }
    }

    @Override // com.repackage.pj5
    public void d(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadStatus) == null) {
        }
    }

    @Override // com.repackage.pj5
    public void e(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adDownloadData) == null) {
        }
    }
}
