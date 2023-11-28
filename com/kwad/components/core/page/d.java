package com.kwad.components.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.proxy.f;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.ak;
/* loaded from: classes10.dex */
public class d extends f {
    public boolean Ok;

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.a(BaseFragmentActivity.RequestInstallPermissionActivity.class, d.class);
        } catch (Throwable unused) {
        }
    }

    private void aE(boolean z) {
        Intent intent = getIntent();
        if (z) {
            getActivity().startActivity((Intent) intent.getParcelableExtra(BaseGmsClient.KEY_PENDING_INTENT));
            return;
        }
        String stringExtra = intent.getStringExtra("filePath");
        if (!TextUtils.isEmpty(stringExtra)) {
            ak.fW(stringExtra);
        }
    }

    private void pd() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.obfuscated_res_0x7f0f0ba2);
        builder.setMessage(R.string.obfuscated_res_0x7f0f0b9f);
        builder.setNegativeButton(R.string.obfuscated_res_0x7f0f0ba0, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.this.finish();
            }
        });
        builder.setPositiveButton(R.string.obfuscated_res_0x7f0f0ba1, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.this.pe();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pe() {
        if (Build.VERSION.SDK_INT >= 26) {
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
            intent.addFlags(67108864);
            getActivity().startActivityForResult(intent, 100);
            return;
        }
        finish();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            aE(this.Ok);
        }
        finish();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("fromNotification", false);
        this.Ok = booleanExtra;
        if (Build.VERSION.SDK_INT < 26) {
            aE(booleanExtra);
            finish();
        } else if (booleanExtra) {
            if (aj.cp(getActivity())) {
                aE(this.Ok);
            } else {
                pe();
            }
        } else if (intent.getBooleanExtra("needAllowDialog", false)) {
            pd();
        } else {
            pe();
        }
    }
}
