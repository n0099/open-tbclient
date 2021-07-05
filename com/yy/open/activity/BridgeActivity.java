package com.yy.open.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class BridgeActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FLAG_RESTART = "isRestart";
    public transient /* synthetic */ FieldHolder $fh;

    public BridgeActivity() {
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

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            Log.d("BridgeActivity", "onActivityResult");
            setResult(i3, intent);
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        Intent intent;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            requestWindowFeature(1);
            int i2 = 0;
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            super.onCreate(bundle);
            if (getIntent() == null) {
                setResult(444222000);
                finish();
                return;
            }
            Log.d("BridgeActivity", MissionEvent.MESSAGE_CREATE);
            if (bundle == null || !bundle.getBoolean(FLAG_RESTART)) {
                try {
                    intent = (Intent) getIntent().getParcelableExtra("intent");
                    if (intent != null) {
                        try {
                            i2 = intent.getIntExtra("request_code", 0);
                        } catch (Exception e3) {
                            e2 = e3;
                            Log.e("YYOpenSdk", "resultCode getIntExtra exception " + e2);
                            if (intent == null) {
                            }
                        }
                    }
                } catch (Exception e4) {
                    intent = null;
                    e2 = e4;
                }
                if (intent == null) {
                    startActivityForResult(intent, i2);
                    return;
                }
                setResult(444222000);
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            bundle.putBoolean(FLAG_RESTART, true);
            super.onSaveInstanceState(bundle);
            Log.d("BridgeActivity", "onSaveInstanceState");
        }
    }
}
