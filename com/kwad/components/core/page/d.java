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
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ai;
/* loaded from: classes9.dex */
public class d extends com.kwad.components.core.i.b {
    public boolean Ga;

    private void au(boolean z) {
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

    private void nJ() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.obfuscated_res_0x7f0f0b4d);
        builder.setMessage(R.string.obfuscated_res_0x7f0f0b4a);
        builder.setNegativeButton(R.string.obfuscated_res_0x7f0f0b4b, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.this.finish();
            }
        });
        builder.setPositiveButton(R.string.obfuscated_res_0x7f0f0b4c, new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                d.this.nK();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK() {
        if (Build.VERSION.SDK_INT < 26) {
            finish();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
        intent.addFlags(67108864);
        getActivity().startActivityForResult(intent, 100);
    }

    @Override // com.kwad.components.core.i.b
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            au(this.Ga);
        }
        finish();
    }

    @Override // com.kwad.components.core.i.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
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
