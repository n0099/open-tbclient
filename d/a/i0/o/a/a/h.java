package d.a.i0.o.a.a;

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
    public int f0 = 0;
    public int g0 = 0;
    public boolean h0 = true;
    public boolean i0 = true;
    public int j0 = -1;
    public Dialog k0;
    public boolean l0;
    public boolean m0;
    public boolean n0;

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        super.D0();
        Dialog dialog = this.k0;
        if (dialog != null) {
            this.l0 = true;
            dialog.dismiss();
            this.k0 = null;
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0() {
        super.E0();
        if (this.n0 || this.m0) {
            return;
        }
        this.m0 = true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void M0(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.M0(bundle);
        Dialog dialog = this.k0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i2 = this.f0;
        if (i2 != 0) {
            bundle.putInt(DialogFragment.SAVED_STYLE, i2);
        }
        int i3 = this.g0;
        if (i3 != 0) {
            bundle.putInt(DialogFragment.SAVED_THEME, i3);
        }
        boolean z = this.h0;
        if (!z) {
            bundle.putBoolean(DialogFragment.SAVED_CANCELABLE, z);
        }
        boolean z2 = this.i0;
        if (!z2) {
            bundle.putBoolean(DialogFragment.SAVED_SHOWS_DIALOG, z2);
        }
        int i4 = this.j0;
        if (i4 != -1) {
            bundle.putInt(DialogFragment.SAVED_BACK_STACK_ID, i4);
        }
    }

    public void n1() {
        o1(false);
    }

    public void o1(boolean z) {
        if (this.m0) {
            return;
        }
        this.m0 = true;
        this.n0 = false;
        Dialog dialog = this.k0;
        if (dialog != null) {
            dialog.dismiss();
            this.k0 = null;
        }
        this.l0 = true;
        if (this.j0 >= 0) {
            u().e(this.j0, 1);
            this.j0 = -1;
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
        this.i0 = this.B == 0;
        if (bundle != null) {
            this.f0 = bundle.getInt(DialogFragment.SAVED_STYLE, 0);
            this.g0 = bundle.getInt(DialogFragment.SAVED_THEME, 0);
            this.h0 = bundle.getBoolean(DialogFragment.SAVED_CANCELABLE, true);
            this.i0 = bundle.getBoolean(DialogFragment.SAVED_SHOWS_DIALOG, this.i0);
            this.j0 = bundle.getInt(DialogFragment.SAVED_BACK_STACK_ID, -1);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.l0) {
            return;
        }
        o1(true);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.k0;
        if (dialog != null) {
            this.l0 = false;
            dialog.show();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.k0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public Dialog p1() {
        return this.k0;
    }

    @StyleRes
    public int q1() {
        return this.g0;
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

    public void t1(l lVar, String str) {
        this.m0 = false;
        this.n0 = true;
        n a2 = lVar.a();
        a2.c(this, str);
        a2.d();
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Bundle bundle2;
        super.u0(bundle);
        if (this.i0) {
            View b0 = b0();
            if (b0 != null) {
                if (b0.getParent() == null) {
                    this.k0.setContentView(b0);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            this.k0.setOwnerActivity(h());
            this.k0.setCancelable(this.h0);
            this.k0.setOnCancelListener(this);
            this.k0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.k0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public LayoutInflater v(Bundle bundle) {
        if (!this.i0) {
            return super.v(bundle);
        }
        Dialog r1 = r1(bundle);
        this.k0 = r1;
        if (r1 != null) {
            s1(r1, this.f0);
            return (LayoutInflater) this.k0.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.x.h().getSystemService("layout_inflater");
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Activity activity) {
        super.w0(activity);
        if (this.n0) {
            return;
        }
        this.m0 = false;
    }
}
