package com.dxmpay.wallet.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DangerousPermissionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, DangerousPermission> f62582a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f62583b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f62584c;

    /* renamed from: d  reason: collision with root package name */
    public int f62585d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62586e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f62587f;

    /* renamed from: g  reason: collision with root package name */
    public DangerousPermissionDialog f62588g;

    /* loaded from: classes11.dex */
    public static class DangerousPermission {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f62589a;

        /* renamed from: b  reason: collision with root package name */
        public String f62590b;

        /* renamed from: c  reason: collision with root package name */
        public String f62591c;

        /* renamed from: d  reason: collision with root package name */
        public String f62592d;

        /* renamed from: e  reason: collision with root package name */
        public String f62593e;

        public DangerousPermission(Context context, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62589a = context.getApplicationContext();
            this.f62590b = str;
            this.f62591c = str2;
            this.f62592d = str3;
            this.f62593e = str4;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return TextUtils.isEmpty(this.f62593e) ? ResUtils.getString(this.f62589a, this.f62592d) : this.f62593e;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    str = new JSONObject(this.f62591c).optString("positive");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f62589a, "dxm_wallet_base_permission_positive") : str;
            }
            return (String) invokeV.objValue;
        }

        public String c() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    str = new JSONObject(this.f62591c).optString("negative");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f62589a, "dxm_wallet_base_permission_negative") : str;
            }
            return (String) invokeV.objValue;
        }

        public String getPermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62590b : (String) invokeV.objValue;
        }

        public String getTitle() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    str = new JSONObject(this.f62591c).optString("title");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f62589a, "dxm_wallet_base_permission_title") : str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class DangerousPermissionDialog extends PromptDialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DangerousPermissionDialog(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    super.dismiss();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.app.Dialog
        public void show() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    super.show();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DangerousPermission f62594e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionDialog f62595f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionUtils f62596g;

        public a(DangerousPermissionUtils dangerousPermissionUtils, DangerousPermission dangerousPermission, DangerousPermissionDialog dangerousPermissionDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dangerousPermissionUtils, dangerousPermission, dangerousPermissionDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62596g = dangerousPermissionUtils;
            this.f62594e = dangerousPermission;
            this.f62595f = dangerousPermissionDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62596g.f62586e = false;
                if (this.f62596g.f62587f != null) {
                    this.f62596g.f62587f.requestResult(this.f62594e.getPermission(), Boolean.FALSE);
                }
                this.f62595f.dismiss();
                this.f62596g.b();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DangerousPermission f62597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionDialog f62598f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionUtils f62599g;

        public b(DangerousPermissionUtils dangerousPermissionUtils, DangerousPermission dangerousPermission, DangerousPermissionDialog dangerousPermissionDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dangerousPermissionUtils, dangerousPermission, dangerousPermissionDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62599g = dangerousPermissionUtils;
            this.f62597e = dangerousPermission;
            this.f62598f = dangerousPermissionDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f62599g.f62587f != null) {
                    this.f62599g.f62587f.requestResult(this.f62597e.getPermission(), Boolean.TRUE);
                }
                this.f62598f.dismiss();
                this.f62599g.b();
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static DangerousPermissionUtils f62600a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1859153286, "Lcom/dxmpay/wallet/core/utils/DangerousPermissionUtils$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1859153286, "Lcom/dxmpay/wallet/core/utils/DangerousPermissionUtils$c;");
                    return;
                }
            }
            f62600a = new DangerousPermissionUtils(null);
        }
    }

    public /* synthetic */ DangerousPermissionUtils(a aVar) {
        this();
    }

    public static DangerousPermissionUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? c.f62600a : (DangerousPermissionUtils) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f62585d + 1;
            this.f62585d = i2;
            String[] strArr = this.f62584c;
            if (i2 >= strArr.length) {
                d(true);
                return;
            }
            DangerousPermission dangerousPermission = this.f62582a.get(strArr[i2]);
            if (dangerousPermission == null) {
                b();
                return;
            }
            Activity activity = this.f62583b.get();
            if (activity == null) {
                d(false);
                return;
            }
            DangerousPermissionDialog dangerousPermissionDialog = new DangerousPermissionDialog(activity);
            dangerousPermissionDialog.setTitleText(dangerousPermission.getTitle());
            dangerousPermissionDialog.setMessage(dangerousPermission.a());
            dangerousPermissionDialog.setNegativeBtn(dangerousPermission.c(), new a(this, dangerousPermission, dangerousPermissionDialog));
            dangerousPermissionDialog.setPositiveBtn(dangerousPermission.b(), new b(this, dangerousPermission, dangerousPermissionDialog));
            this.f62588g = dangerousPermissionDialog;
            dangerousPermissionDialog.show();
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f62587f;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
            }
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.f62582a == null && context != null) {
            HashMap hashMap = new HashMap();
            this.f62582a = hashMap;
            hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
            this.f62582a.put("android.permission.ACCESS_FINE_LOCATION", new DangerousPermission(context, "android.permission.ACCESS_FINE_LOCATION", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
            this.f62582a.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
            this.f62582a.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
            this.f62582a.put("android.permission.WRITE_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
            this.f62582a.put("android.permission.READ_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.READ_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f62587f;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f62586e));
            }
            this.f62588g = null;
            this.f62587f = null;
        }
    }

    public final boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if ("wallet_langbridge".equals(str)) {
                return "1".equals(SdkInitResponse.getInstance().langbridge_permission_dialog);
            }
            if ("1".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
                return true;
            }
            if ("0".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
                return false;
            }
            return "walletapp".equals(BeanConstants.CHANNEL_ID) || BeanConstants.CHANNEL_ID_WALLET_APP_PRO.equals(BeanConstants.CHANNEL_ID) || "bdyouqianhuapro".equals(BeanConstants.CHANNEL_ID) || "bdlicai".equals(BeanConstants.CHANNEL_ID);
        }
        return invokeL.booleanValue;
    }

    public void requestPermissionsDialog(String str, Activity activity, String[] strArr, BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, activity, strArr, iRequestPermissionCallBack) == null) {
            c(activity);
            if (!f(str) || activity == null) {
                if (iRequestPermissionCallBack != null) {
                    iRequestPermissionCallBack.isAllAgree(Boolean.TRUE);
                    return;
                }
                return;
            }
            this.f62583b = new WeakReference<>(activity);
            this.f62584c = strArr;
            this.f62585d = -1;
            this.f62586e = true;
            this.f62587f = iRequestPermissionCallBack;
            DangerousPermissionDialog dangerousPermissionDialog = this.f62588g;
            if (dangerousPermissionDialog != null) {
                dangerousPermissionDialog.dismiss();
                this.f62588g = null;
            }
            b();
        }
    }

    public DangerousPermissionUtils() {
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
}
