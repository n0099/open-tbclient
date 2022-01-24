package com.dxmpay.wallet.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
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
import com.kuaishou.weapon.un.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DangerousPermissionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, DangerousPermission> a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Activity> f54006b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f54007c;

    /* renamed from: d  reason: collision with root package name */
    public int f54008d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54009e;

    /* renamed from: f  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f54010f;

    /* renamed from: g  reason: collision with root package name */
    public DangerousPermissionDialog f54011g;

    /* loaded from: classes3.dex */
    public static class DangerousPermission {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public String f54012b;

        /* renamed from: c  reason: collision with root package name */
        public String f54013c;

        /* renamed from: d  reason: collision with root package name */
        public String f54014d;

        /* renamed from: e  reason: collision with root package name */
        public String f54015e;

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
            this.a = context.getApplicationContext();
            this.f54012b = str;
            this.f54013c = str2;
            this.f54014d = str3;
            this.f54015e = str4;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return TextUtils.isEmpty(this.f54015e) ? ResUtils.getString(this.a, this.f54014d) : this.f54015e;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                try {
                    str = new JSONObject(this.f54013c).optString("positive");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.a, "dxm_wallet_base_permission_positive") : str;
            }
            return (String) invokeV.objValue;
        }

        public String c() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                try {
                    str = new JSONObject(this.f54013c).optString("negative");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.a, "dxm_wallet_base_permission_negative") : str;
            }
            return (String) invokeV.objValue;
        }

        public String getPermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54012b : (String) invokeV.objValue;
        }

        public String getTitle() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    str = new JSONObject(this.f54013c).optString("title");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.a, "dxm_wallet_base_permission_title") : str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DangerousPermission f54016e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionDialog f54017f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionUtils f54018g;

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
            this.f54018g = dangerousPermissionUtils;
            this.f54016e = dangerousPermission;
            this.f54017f = dangerousPermissionDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54018g.f54009e = false;
                if (this.f54018g.f54010f != null) {
                    this.f54018g.f54010f.requestResult(this.f54016e.getPermission(), Boolean.FALSE);
                }
                this.f54017f.dismiss();
                this.f54018g.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DangerousPermission f54019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionDialog f54020f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionUtils f54021g;

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
            this.f54021g = dangerousPermissionUtils;
            this.f54019e = dangerousPermission;
            this.f54020f = dangerousPermissionDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54021g.f54010f != null) {
                    this.f54021g.f54010f.requestResult(this.f54019e.getPermission(), Boolean.TRUE);
                }
                this.f54020f.dismiss();
                this.f54021g.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static DangerousPermissionUtils a;
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
            a = new DangerousPermissionUtils(null);
        }
    }

    public /* synthetic */ DangerousPermissionUtils(a aVar) {
        this();
    }

    public static DangerousPermissionUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.a : (DangerousPermissionUtils) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.f54008d + 1;
            this.f54008d = i2;
            String[] strArr = this.f54007c;
            if (i2 >= strArr.length) {
                d(true);
                return;
            }
            DangerousPermission dangerousPermission = this.a.get(strArr[i2]);
            if (dangerousPermission == null) {
                b();
                return;
            }
            Activity activity = this.f54006b.get();
            if (activity == null) {
                d(false);
                return;
            }
            DangerousPermissionDialog dangerousPermissionDialog = new DangerousPermissionDialog(activity);
            dangerousPermissionDialog.setTitleText(dangerousPermission.getTitle());
            dangerousPermissionDialog.setMessage(dangerousPermission.a());
            dangerousPermissionDialog.setNegativeBtn(dangerousPermission.c(), new a(this, dangerousPermission, dangerousPermissionDialog));
            dangerousPermissionDialog.setPositiveBtn(dangerousPermission.b(), new b(this, dangerousPermission, dangerousPermissionDialog));
            this.f54011g = dangerousPermissionDialog;
            dangerousPermissionDialog.show();
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f54010f;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
            }
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.a == null && context != null) {
            HashMap hashMap = new HashMap();
            this.a = hashMap;
            hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
            this.a.put(s.f55291g, new DangerousPermission(context, s.f55291g, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
            this.a.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
            this.a.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
            this.a.put("android.permission.WRITE_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
            this.a.put(s.f55293i, new DangerousPermission(context, s.f55293i, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f54010f;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f54009e));
            }
            this.f54011g = null;
            this.f54010f = null;
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
            this.f54006b = new WeakReference<>(activity);
            this.f54007c = strArr;
            this.f54008d = -1;
            this.f54009e = true;
            this.f54010f = iRequestPermissionCallBack;
            DangerousPermissionDialog dangerousPermissionDialog = this.f54011g;
            if (dangerousPermissionDialog != null) {
                dangerousPermissionDialog.dismiss();
                this.f54011g = null;
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
