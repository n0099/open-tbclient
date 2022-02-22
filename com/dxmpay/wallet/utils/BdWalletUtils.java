package com.dxmpay.wallet.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.paysdk.SDKInitBeanCallBack;
import com.dxmpay.wallet.paysdk.beans.NewSdkInitBean;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class BdWalletUtils {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f54247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f54248f;

        public a(View.OnClickListener onClickListener, PromptDialog promptDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onClickListener, promptDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54247e = onClickListener;
            this.f54248f = promptDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                View.OnClickListener onClickListener = this.f54247e;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                this.f54248f.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f54249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f54250f;

        public b(View.OnClickListener onClickListener, PromptDialog promptDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onClickListener, promptDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54249e = onClickListener;
            this.f54250f = promptDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                View.OnClickListener onClickListener = this.f54249e;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                this.f54250f.dismiss();
            }
        }
    }

    public BdWalletUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            activity.getWindow().addFlags(8192);
        }
    }

    public static void clearFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, activity) == null) {
            activity.getWindow().clearFlags(8192);
        }
    }

    public static void dealCashDesk(BeanResponseBase.Session session) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, session) == null) || session == null) {
            return;
        }
        NetworkBean.SessionCache.getInstance().put(null, session);
    }

    public static String getDeviceFP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str = (String) SharedPreferencesUtils.getParam(context, "__DxmPay_Wallet_SDK_FP", com.baidu.wallet.utils.BdWalletUtils.f52923b, "");
            return !TextUtils.isEmpty(str) ? SecurePay.getInstance().localDecrypt1(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getFPFileLastModified(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            File file = new File(context.getFilesDir().getParent() + "/shared_prefs/__DxmPay_Wallet_SDK_FP" + ActivityChooserModel.HISTORY_FILE_EXTENSION);
            if (file.exists()) {
                return "" + (file.lastModified() / 1000);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static ArrayList getFunctionNameList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? a : (ArrayList) invokeV.objValue;
    }

    public static String getKefuPhoneNum(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null) {
                return "";
            }
            String str = (String) SharedPreferencesUtils.getParam(context, "__DxmPay_Wallet_SDK_KEFU", com.baidu.wallet.utils.BdWalletUtils.f52925d, "");
            return TextUtils.isEmpty(str) ? ResUtils.getString(context, "dxm_wallet_base_help_phone_no_dial") : str;
        }
        return (String) invokeL.objValue;
    }

    public static void loadDeviceFP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            SDKInitBeanCallBack sDKInitBeanCallBack = new SDKInitBeanCallBack(context);
            NewSdkInitBean newSdkInitBean = new NewSdkInitBean(context.getApplicationContext());
            newSdkInitBean.setResponseCallback(sDKInitBeanCallBack);
            newSdkInitBean.execBean();
            c.f.b.e.a.a aVar = new c.f.b.e.a.a(context.getApplicationContext());
            aVar.setResponseCallback(sDKInitBeanCallBack);
            aVar.execBean();
        }
    }

    public static void putFunctionNameList(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, strArr) == null) {
            if (a == null) {
                a = new ArrayList();
            }
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (!a.contains(strArr[i2])) {
                    a.add(strArr[i2]);
                }
            }
        }
    }

    public static void setDeviceFP(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) || str == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, "__DxmPay_Wallet_SDK_FP", com.baidu.wallet.utils.BdWalletUtils.f52923b, SecurePay.getInstance().localEncrypt1(str));
    }

    public static void setKefuPhoneNumToSP(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, context, str) == null) || str == null || context == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, "__DxmPay_Wallet_SDK_KEFU", com.baidu.wallet.utils.BdWalletUtils.f52925d, str);
    }

    public static void showThemeDialog(Context context, String str, String str2, String str3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{context, str, str2, str3, onClickListener, onClickListener2}) == null) {
            PromptDialog promptDialog = new PromptDialog(context);
            promptDialog.setMessage(str);
            promptDialog.setNegativeBtn(str2, new a(onClickListener, promptDialog));
            promptDialog.setPositiveBtn(str3, new b(onClickListener2, promptDialog));
            promptDialog.show();
        }
    }
}
