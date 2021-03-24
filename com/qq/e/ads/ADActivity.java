package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes6.dex */
public class ADActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public ACTD f38004a;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        String str2 = null;
        try {
            POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
            if (pOFactory != null) {
                Intent intent = getIntent();
                intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    str2 = extras.getString(ACTD.DELEGATE_NAME_KEY);
                    String string = extras.getString("appid");
                    if (!StringUtil.isEmpty(str2) && !StringUtil.isEmpty(string)) {
                        if (GDTADManager.getInstance().initWith(getApplicationContext(), string)) {
                            ACTD activityDelegate = pOFactory.getActivityDelegate(str2, this);
                            this.f38004a = activityDelegate;
                            if (activityDelegate == null) {
                                str = "Init ADActivity Delegate return null,delegateName" + str2;
                            }
                        } else {
                            str = "Init GDTADManager fail in AdActivity";
                        }
                        GDTLogger.e(str);
                    }
                }
            }
        } catch (Throwable th) {
            GDTLogger.e("Init ADActivity Delegate Faile,DelegateName:" + str2, th);
        }
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            try {
                finish();
            } catch (Exception e2) {
                GDTLogger.report("finish ADActivity err", e2);
            }
        }
        try {
            super.onCreate(bundle);
        } catch (Exception e3) {
            GDTLogger.report("onCreate ADActivity err", e3);
        }
        ACTD actd2 = this.f38004a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onResume();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        ACTD actd = this.f38004a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }
}
