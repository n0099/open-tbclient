package d.b.i0.u3;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes5.dex */
public class b extends TimePickerDialog {

    /* renamed from: e  reason: collision with root package name */
    public int f62835e;

    /* renamed from: f  reason: collision with root package name */
    public int f62836f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62837g;

    public b(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        super(context, onTimeSetListener, i, i2, z);
        this.f62835e = -1;
        this.f62836f = -1;
        this.f62837g = false;
        this.f62835e = i;
        this.f62836f = i2;
    }

    @Override // android.app.TimePickerDialog, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        if (i == -1) {
            this.f62837g = true;
        } else {
            int i3 = this.f62835e;
            if (i3 >= 0 && (i2 = this.f62836f) >= 0) {
                updateTime(i3, i2);
            }
        }
        super.onClick(dialogInterface, i);
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updateTime(0, 0);
        this.f62835e = bundle.getInt("hour_key");
        int i = bundle.getInt("min_key");
        this.f62836f = i;
        updateTime(this.f62835e, i);
    }

    @Override // android.app.TimePickerDialog, android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundle;
        try {
            bundle = super.onSaveInstanceState();
        } catch (Exception unused) {
            bundle = null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("hour_key", this.f62835e);
        bundle.putInt("min_key", this.f62836f);
        return bundle;
    }

    @Override // android.app.Dialog
    public void onStop() {
        if (!this.f62837g) {
            updateTime(this.f62835e, this.f62836f);
        }
        super.onStop();
    }

    @Override // android.app.TimePickerDialog
    public void updateTime(int i, int i2) {
        super.updateTime(i, i2);
        this.f62835e = i;
        this.f62836f = i2;
        this.f62837g = false;
    }
}
