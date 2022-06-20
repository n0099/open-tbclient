package com.kwad.sdk.core.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.protobuf.CodedInputStream;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes5.dex */
public class d extends com.kwad.sdk.h.b {
    public boolean a;

    private void a() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.obfuscated_res_0x7f0f09be);
        builder.setMessage(R.string.obfuscated_res_0x7f0f09bb);
        builder.setNegativeButton(R.string.obfuscated_res_0x7f0f09bc, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.core.page.d.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.this.finish();
            }
        });
        builder.setPositiveButton(R.string.obfuscated_res_0x7f0f09bd, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.core.page.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.this.b();
            }
        });
        builder.create().show();
    }

    private void a(boolean z) {
        Intent intent = getIntent();
        if (z) {
            getActivity().startActivity((Intent) intent.getParcelableExtra("pendingIntent"));
            return;
        }
        String stringExtra = intent.getStringExtra("filePath");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        KsAdSDKImpl.get().getProxyForAdInstall().installApp(getActivity().getApplicationContext(), stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (Build.VERSION.SDK_INT < 26) {
            finish();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getActivity().getApplicationInfo().packageName));
        intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        getActivity().startActivityForResult(intent, 100);
    }

    @Override // com.kwad.sdk.h.b
    public String getPageName() {
        return "RequestInstallPermissionImpl";
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            a(this.a);
        }
        finish();
    }

    @Override // com.kwad.sdk.h.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("fromNotification", false);
        this.a = booleanExtra;
        if (Build.VERSION.SDK_INT < 26) {
            a(booleanExtra);
            finish();
            return;
        }
        if (booleanExtra) {
            if (getActivity().getPackageManager().canRequestPackageInstalls()) {
                a(this.a);
                return;
            }
        } else if (intent.getBooleanExtra("needAllowDialog", false)) {
            a();
            return;
        }
        b();
    }
}
