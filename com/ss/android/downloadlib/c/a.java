package com.ss.android.downloadlib.c;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.a.a.a.k;
import com.ss.android.a.a.b.c;
/* loaded from: classes6.dex */
public class a implements k {
    @Override // com.ss.android.a.a.a.k
    public void a(int i, @Nullable Context context, c cVar, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.a.a.a.k
    public Dialog b(@NonNull com.ss.android.a.a.d.c cVar) {
        return d(cVar);
    }

    private static Dialog d(final com.ss.android.a.a.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(cVar.f12899a).setTitle(cVar.f12900b).setMessage(cVar.c).setPositiveButton(cVar.d, new DialogInterface.OnClickListener() { // from class: com.ss.android.downloadlib.c.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (com.ss.android.a.a.d.c.this.qaY != null) {
                    com.ss.android.a.a.d.c.this.qaY.a(dialogInterface);
                }
            }
        }).setNegativeButton(cVar.e, new DialogInterface.OnClickListener() { // from class: com.ss.android.downloadlib.c.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (com.ss.android.a.a.d.c.this.qaY != null) {
                    com.ss.android.a.a.d.c.this.qaY.b(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(cVar.f);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.c.a.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (com.ss.android.a.a.d.c.this.qaY != null) {
                    com.ss.android.a.a.d.c.this.qaY.c(dialogInterface);
                }
            }
        });
        if (cVar.g != null) {
            show.setIcon(cVar.g);
            return show;
        }
        return show;
    }
}
