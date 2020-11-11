package com.kascend.chushou.view.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.kascend.chushou.a;
/* loaded from: classes6.dex */
public abstract class a extends DialogFragment {
    protected Context b;
    protected ProgressDialog pyc = null;

    public abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.b = getActivity();
        setStyle(1, a.j.alert_dialog);
    }

    @Override // android.support.v4.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setCanceledOnTouchOutside(true);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(a.j.alert_dialog_animation);
        }
        return onCreateDialog;
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View a2 = a(layoutInflater, viewGroup, bundle);
        a(a2);
        return a2;
    }

    @Override // android.support.v4.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    public void a(View view) {
    }

    public boolean b() {
        return this.b == null || getDialog() == null || !getDialog().isShowing();
    }

    public void a(int i, int i2, int i3, int i4) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = i;
            attributes.height = i2;
            if (i3 > 0) {
                attributes.gravity = i3;
            }
            window.setAttributes(attributes);
            if (i4 > 0) {
                window.setWindowAnimations(i4);
            }
        }
    }

    public void a(int i, int i2) {
        a(i, i2, -1, -1);
    }
}
