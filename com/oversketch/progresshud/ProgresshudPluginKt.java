package com.oversketch.progresshud;

import android.app.Activity;
import com.bigkoo.svprogresshud.SVProgressHUD;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\"\"\u0010\u0001\u001a\u00020\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t\"\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bigkoo/svprogresshud/SVProgressHUD;", "dialog", "Lcom/bigkoo/svprogresshud/SVProgressHUD;", "getDialog", "()Lcom/bigkoo/svprogresshud/SVProgressHUD;", "setDialog", "(Lcom/bigkoo/svprogresshud/SVProgressHUD;)V", "Landroid/app/Activity;", "mCurrentActivity", "Landroid/app/Activity;", "Lcom/bigkoo/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;", "maskType", "Lcom/bigkoo/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;", "getMaskType", "()Lcom/bigkoo/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;", "setMaskType", "(Lcom/bigkoo/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;)V", "ovprogresshud_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public final class ProgresshudPluginKt {
    public static SVProgressHUD dialog;
    public static Activity mCurrentActivity;
    public static SVProgressHUD.SVProgressHUDMaskType maskType;

    public static final SVProgressHUD getDialog() {
        SVProgressHUD sVProgressHUD = dialog;
        if (sVProgressHUD == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        }
        return sVProgressHUD;
    }

    public static final SVProgressHUD.SVProgressHUDMaskType getMaskType() {
        SVProgressHUD.SVProgressHUDMaskType sVProgressHUDMaskType = maskType;
        if (sVProgressHUDMaskType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maskType");
        }
        return sVProgressHUDMaskType;
    }

    public static final void setDialog(SVProgressHUD sVProgressHUD) {
        dialog = sVProgressHUD;
    }

    public static final void setMaskType(SVProgressHUD.SVProgressHUDMaskType sVProgressHUDMaskType) {
        maskType = sVProgressHUDMaskType;
    }
}
