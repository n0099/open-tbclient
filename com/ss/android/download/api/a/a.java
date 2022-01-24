package com.ss.android.download.api.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.b;
/* loaded from: classes4.dex */
public class a implements k {
    @Override // com.ss.android.download.api.config.k
    public void a(int i2, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.k
    public Dialog b(@NonNull com.ss.android.download.api.model.b bVar) {
        return a(bVar);
    }

    public static Dialog a(final com.ss.android.download.api.model.b bVar) {
        if (bVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(bVar.a).setTitle(bVar.f59369b).setMessage(bVar.f59370c).setPositiveButton(bVar.f59371d, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                b.InterfaceC2185b interfaceC2185b = com.ss.android.download.api.model.b.this.f59375h;
                if (interfaceC2185b != null) {
                    interfaceC2185b.a(dialogInterface);
                }
            }
        }).setNegativeButton(bVar.f59372e, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                b.InterfaceC2185b interfaceC2185b = com.ss.android.download.api.model.b.this.f59375h;
                if (interfaceC2185b != null) {
                    interfaceC2185b.b(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(bVar.f59373f);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.a.a.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.InterfaceC2185b interfaceC2185b = com.ss.android.download.api.model.b.this.f59375h;
                if (interfaceC2185b != null) {
                    interfaceC2185b.c(dialogInterface);
                }
            }
        });
        Drawable drawable = bVar.f59374g;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
