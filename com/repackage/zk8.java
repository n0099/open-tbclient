package com.repackage;

import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nq4;
/* loaded from: classes7.dex */
public class zk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final dk8 b;
    public final qk8 c;
    public long d;

    /* loaded from: classes7.dex */
    public class a implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;

        public a(zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk8Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
                if (this.a.c == null || this.a.c.e() == null) {
                    return;
                }
                this.a.c.e().b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk8 a;

        public b(zk8 zk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk8Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                try {
                    this.a.a.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    nq4Var.dismiss();
                } catch (Exception unused) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f07d4);
                }
            }
        }
    }

    public zk8(MainTabActivity mainTabActivity, dk8 dk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, dk8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0L;
        this.a = mainTabActivity;
        this.b = dk8Var;
        this.c = mainTabActivity.f;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new nq4(this.a).setTitle(R.string.obfuscated_res_0x7f0f0427).setCancelable(false).setMessageId(R.string.obfuscated_res_0x7f0f02c6).setPositiveButton(R.string.obfuscated_res_0x7f0f0cbf, new b(this)).setNegativeButton(R.string.obfuscated_res_0x7f0f0c43, new a(this)).create(h9.a(this.a)).show();
        }
    }

    public boolean d(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return false;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016322, (Class) null);
            if (runTask == null || !((Boolean) runTask.getData()).booleanValue()) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2016323, (Class) null);
                if (runTask2 == null || !((Boolean) runTask2.getData()).booleanValue()) {
                    ov8 ov8Var = this.a.r;
                    if (ov8Var != null && ov8Var.n()) {
                        this.a.r.m(true);
                        return true;
                    } else if (this.b.C()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007010));
                        return true;
                    } else {
                        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.FALSE);
                        if (runTask3 == null || runTask3.getData() == null || !(runTask3.getData() instanceof Boolean) || !((Boolean) runTask3.getData()).booleanValue()) {
                            if (TbSingleton.getInstance().isFromFeedVideoClick()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                                return true;
                            }
                            if (System.currentTimeMillis() - this.d > 2000) {
                                this.a.showToast(R.string.obfuscated_res_0x7f0f04e7);
                                this.d = System.currentTimeMillis();
                            } else if (UtilHelper.isBackgroundProcessLimitNone() && Build.VERSION.SDK_INT >= 14) {
                                c();
                                return true;
                            } else {
                                qk8 qk8Var = this.c;
                                if (qk8Var != null && qk8Var.e() != null) {
                                    this.c.e().b();
                                }
                            }
                            return false;
                        }
                        return true;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
