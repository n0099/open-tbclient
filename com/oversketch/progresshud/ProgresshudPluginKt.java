package com.oversketch.progresshud;

import android.app.Activity;
import com.bigkoo.svprogresshud.SVProgressHUD;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes4.dex */
public final class ProgresshudPluginKt {
    public static SVProgressHUD dialog;
    private static Activity mCurrentActivity;
    public static SVProgressHUD.SVProgressHUDMaskType maskType;

    public static final SVProgressHUD getDialog() {
        SVProgressHUD sVProgressHUD = dialog;
        if (sVProgressHUD == null) {
            p.acs("dialog");
        }
        return sVProgressHUD;
    }

    public static final void setDialog(SVProgressHUD sVProgressHUD) {
        p.o(sVProgressHUD, "<set-?>");
        dialog = sVProgressHUD;
    }

    public static final SVProgressHUD.SVProgressHUDMaskType getMaskType() {
        SVProgressHUD.SVProgressHUDMaskType sVProgressHUDMaskType = maskType;
        if (sVProgressHUDMaskType == null) {
            p.acs("maskType");
        }
        return sVProgressHUDMaskType;
    }

    public static final void setMaskType(SVProgressHUD.SVProgressHUDMaskType sVProgressHUDMaskType) {
        p.o(sVProgressHUDMaskType, "<set-?>");
        maskType = sVProgressHUDMaskType;
    }
}
