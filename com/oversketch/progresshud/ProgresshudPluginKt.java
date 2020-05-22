package com.oversketch.progresshud;

import android.app.Activity;
import com.bigkoo.svprogresshud.SVProgressHUD;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes6.dex */
public final class ProgresshudPluginKt {
    public static SVProgressHUD dialog;
    private static Activity mCurrentActivity;
    public static SVProgressHUD.SVProgressHUDMaskType maskType;

    public static final SVProgressHUD getDialog() {
        SVProgressHUD sVProgressHUD = dialog;
        if (sVProgressHUD == null) {
            q.RF("dialog");
        }
        return sVProgressHUD;
    }

    public static final void setDialog(SVProgressHUD sVProgressHUD) {
        q.m(sVProgressHUD, "<set-?>");
        dialog = sVProgressHUD;
    }

    public static final SVProgressHUD.SVProgressHUDMaskType getMaskType() {
        SVProgressHUD.SVProgressHUDMaskType sVProgressHUDMaskType = maskType;
        if (sVProgressHUDMaskType == null) {
            q.RF("maskType");
        }
        return sVProgressHUDMaskType;
    }

    public static final void setMaskType(SVProgressHUD.SVProgressHUDMaskType sVProgressHUDMaskType) {
        q.m(sVProgressHUDMaskType, "<set-?>");
        maskType = sVProgressHUDMaskType;
    }
}
