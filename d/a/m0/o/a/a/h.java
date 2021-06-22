package d.a.m0.o.a.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.fragment.app.DialogFragment;
import com.baidu.swan.support.v4.app.Fragment;
/* loaded from: classes3.dex */
public class h extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public int k0 = 0;
    public int l0 = 0;
    public boolean m0 = true;
    public boolean n0 = true;
    public int o0 = -1;
    public Dialog p0;
    public boolean q0;
    public boolean r0;
    public boolean s0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        super.D0();
        Dialog dialog = this.p0;
        if (dialog != null) {
            this.q0 = true;
            dialog.dismiss();
            this.p0 = null;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        super.E0();
        if (this.s0 || this.r0) {
            return;
        }
        this.r0 = true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void M0(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.M0(bundle);
        Dialog dialog = this.p0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i2 = this.k0;
        if (i2 != 0) {
            bundle.putInt(DialogFragment.SAVED_STYLE, i2);
        }
        int i3 = this.l0;
        if (i3 != 0) {
            bundle.putInt(DialogFragment.SAVED_THEME, i3);
        }
        boolean z = this.m0;
        if (!z) {
            bundle.putBoolean(DialogFragment.SAVED_CANCELABLE, z);
        }
        boolean z2 = this.n0;
        if (!z2) {
            bundle.putBoolean(DialogFragment.SAVED_SHOWS_DIALOG, z2);
        }
        int i4 = this.o0;
        if (i4 != -1) {
            bundle.putInt(DialogFragment.SAVED_BACK_STACK_ID, i4);
        }
    }

    public void n1() {
        o1(false);
    }

    public void o1(boolean z) {
        if (this.r0) {
            return;
        }
        this.r0 = true;
        this.s0 = false;
        Dialog dialog = this.p0;
        if (dialog != null) {
            dialog.dismiss();
            this.p0 = null;
        }
        this.q0 = true;
        if (this.o0 >= 0) {
            u().e(this.o0, 1);
            this.o0 = -1;
            return;
        }
        n a2 = u().a();
        a2.g(this);
        if (z) {
            a2.e();
        } else {
            a2.d();
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.n0 = this.B == 0;
        if (bundle != null) {
            this.k0 = bundle.getInt(DialogFragment.SAVED_STYLE, 0);
            this.l0 = bundle.getInt(DialogFragment.SAVED_THEME, 0);
            this.m0 = bundle.getBoolean(DialogFragment.SAVED_CANCELABLE, true);
            this.n0 = bundle.getBoolean(DialogFragment.SAVED_SHOWS_DIALOG, this.n0);
            this.o0 = bundle.getInt(DialogFragment.SAVED_BACK_STACK_ID, -1);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.q0) {
            return;
        }
        o1(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.p0;
        if (dialog != null) {
            this.q0 = false;
            dialog.show();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.p0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public Dialog p1() {
        return this.p0;
    }

    @StyleRes
    public int q1() {
        return this.l0;
    }

    @NonNull
    public Dialog r1(Bundle bundle) {
        return new Dialog(h(), q1());
    }

    public void s1(Dialog dialog, int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            dialog.getWindow().addFlags(24);
        }
        dialog.requestWindowFeature(1);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void t0(Bundle bundle) {
        Bundle bundle2;
        super.t0(bundle);
        if (this.n0) {
            View b0 = b0();
            if (b0 != null) {
                if (b0.getParent() == null) {
                    this.p0.setContentView(b0);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            this.p0.setOwnerActivity(h());
            this.p0.setCancelable(this.m0);
            this.p0.setOnCancelListener(this);
            this.p0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.p0.onRestoreInstanceState(bundle2);
        }
    }

    public void t1(l lVar, String str) {
        this.r0 = false;
        this.s0 = true;
        n a2 = lVar.a();
        a2.c(this, str);
        a2.d();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public LayoutInflater v(Bundle bundle) {
        if (!this.n0) {
            return super.v(bundle);
        }
        Dialog r1 = r1(bundle);
        this.p0 = r1;
        if (r1 != null) {
            s1(r1, this.k0);
            return (LayoutInflater) this.p0.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.x.h().getSystemService("layout_inflater");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Activity activity) {
        super.w0(activity);
        if (this.s0) {
            return;
        }
        this.r0 = false;
    }
}
