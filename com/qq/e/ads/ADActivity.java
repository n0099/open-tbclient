package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes3.dex */
public class ADActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ACTD f11408a;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f11408a != null) {
            this.f11408a.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f11408a != null) {
            this.f11408a.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f11408a != null) {
            this.f11408a.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString(ACTD.DELEGATE_NAME_KEY);
            String string2 = extras.getString("appid");
            if (!StringUtil.isEmpty(string) && !StringUtil.isEmpty(string2)) {
                try {
                    if (GDTADManager.getInstance().initWith(getApplicationContext(), string2)) {
                        this.f11408a = GDTADManager.getInstance().getPM().getPOFactory().getActivityDelegate(string, this);
                        if (this.f11408a == null) {
                            GDTLogger.e("Init ADActivity Delegate return null,delegateName" + string);
                        }
                    } else {
                        GDTLogger.e("Init GDTADManager fail in AdActivity");
                    }
                } catch (Throwable th) {
                    GDTLogger.e("Init ADActivity Delegate Faile,DelegateName:" + string, th);
                }
            }
        }
        if (this.f11408a != null) {
            this.f11408a.onBeforeCreate(bundle);
        } else {
            finish();
        }
        super.onCreate(bundle);
        if (this.f11408a != null) {
            this.f11408a.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f11408a != null) {
            this.f11408a.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        if (this.f11408a != null) {
            this.f11408a.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f11408a != null) {
            this.f11408a.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (this.f11408a != null) {
            this.f11408a.onStop();
        }
        super.onStop();
    }
}
