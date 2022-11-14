package com.kwad.components.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.protobuf.CodedInputStream;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ai;
/* loaded from: classes7.dex */
public class d extends com.kwad.components.core.i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean Ga;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void au(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            Intent intent = getIntent();
            if (z) {
                getActivity().startActivity((Intent) intent.getParcelableExtra(BaseGmsClient.KEY_PENDING_INTENT));
                return;
            }
            String stringExtra = intent.getStringExtra("filePath");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            ai.X(getActivity().getApplicationContext(), stringExtra);
        }
    }

    private void nJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.obfuscated_res_0x7f0f09ef);
            builder.setMessage(R.string.obfuscated_res_0x7f0f09ec);
            builder.setNegativeButton(R.string.obfuscated_res_0x7f0f09ed, new DialogInterface.OnClickListener(this) { // from class: com.kwad.components.core.page.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Gb;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Gb = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                        this.Gb.finish();
                    }
                }
            });
            builder.setPositiveButton(R.string.obfuscated_res_0x7f0f09ee, new DialogInterface.OnClickListener(this) { // from class: com.kwad.components.core.page.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d Gb;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Gb = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i) == null) {
                        this.Gb.nK();
                    }
                }
            });
            builder.create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                finish();
                return;
            }
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
            intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            getActivity().startActivityForResult(intent, 100);
        }
    }

    @Override // com.kwad.components.core.i.b
    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "RequestInstallPermissionImpl" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) {
            if (i == 100 && i2 == -1) {
                au(this.Ga);
            }
            finish();
        }
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                finish();
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("fromNotification", false);
            this.Ga = booleanExtra;
            if (Build.VERSION.SDK_INT < 26) {
                au(booleanExtra);
                finish();
            } else if (booleanExtra) {
                if (ah.cD(getActivity())) {
                    au(this.Ga);
                } else {
                    nK();
                }
            } else if (intent.getBooleanExtra("needAllowDialog", false)) {
                nJ();
            } else {
                nK();
            }
        }
    }
}
