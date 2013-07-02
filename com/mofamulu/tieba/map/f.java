package com.mofamulu.tieba.map;

import android.view.View;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ FreeJumpByMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FreeJumpByMapActivity freeJumpByMapActivity) {
        this.a = freeJumpByMapActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GoogleMap googleMap;
        GoogleMap googleMap2;
        googleMap = this.a.b;
        if (googleMap != null) {
            googleMap2 = this.a.b;
            CameraPosition b = googleMap2.b();
            String c = this.a.a.c(b.b.b, b.b.c);
            if (c != null) {
                Toast.makeText(this.a, c, 1).show();
                return;
            } else {
                this.a.a(true);
                return;
            }
        }
        this.a.finish();
    }
}
