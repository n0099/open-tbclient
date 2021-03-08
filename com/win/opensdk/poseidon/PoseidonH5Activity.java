package com.win.opensdk.poseidon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class PoseidonH5Activity extends H5Activity {
    public static void a(Context context, Info info, String str) {
        Intent intent = new Intent(context, PoseidonH5Activity.class);
        intent.putExtra("pid", str);
        intent.putExtra("id", info.getId());
        intent.putExtra("traceid", info.getTraceid());
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.win.opensdk.activitys.H5Activity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.win.opensdk.activitys.H5Activity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
