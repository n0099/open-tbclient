package com.kwad.components.core.i;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.BaseSystemDialogFragment;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.utils.q;
/* loaded from: classes10.dex */
public abstract class e extends BaseSystemDialogFragment {
    private int a(FragmentTransaction fragmentTransaction, String str) {
        try {
            q.a(this, "mDismissed", Boolean.FALSE);
            q.a(this, "mShownByMe", Boolean.TRUE);
            q.a(this, "mViewDestroyed", Boolean.FALSE);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
        }
        return fragmentTransaction.add(this, str).commitAllowingStateLoss();
    }

    public abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            if (getActivity().isFinishing()) {
                return;
            }
            super.dismissAllowingStateLoss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        return a(Wrapper.wrapInflaterIfNeed(layoutInflater), viewGroup);
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Throwable unused) {
            return a(fragmentTransaction, str);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                super.show(fragmentManager, str);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(th);
                a(fragmentManager.beginTransaction(), str);
            }
        } catch (Throwable unused) {
            q.a((Object) this, "showAllowingStateLoss", fragmentManager, str);
        }
    }
}
