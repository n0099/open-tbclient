package com.win.opensdk.poseidon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
/* loaded from: classes3.dex */
public class PoseidonH5Activity extends H5Activity {
    @Override // com.win.opensdk.activitys.H5Activity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public static void b(Context context, Info info, String str) {
        Intent intent = new Intent(context, PoseidonH5Activity.class);
        intent.putExtra("pid", str);
        intent.putExtra("id", info.getId());
        intent.putExtra("traceid", info.getTraceid());
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.win.opensdk.activitys.H5Activity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
