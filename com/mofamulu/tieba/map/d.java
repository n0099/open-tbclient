package com.mofamulu.tieba.map;

import android.widget.Toast;
import com.baidu.tieba.model.aw;
import com.baidu.tieba.nearby.NearbyPbActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements GoogleMap.OnInfoWindowClickListener {
    final /* synthetic */ FreeJumpByMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FreeJumpByMapActivity freeJumpByMapActivity) {
        this.a = freeJumpByMapActivity;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void a(Marker marker) {
        HashMap hashMap;
        HashMap hashMap2;
        hashMap = this.a.j;
        if (hashMap == null) {
            return;
        }
        hashMap2 = this.a.j;
        aw awVar = (aw) hashMap2.get(marker);
        if (awVar != null) {
            String b = this.a.a.b(marker.a().b, marker.a().c);
            if (b == null) {
                NearbyPbActivity.a(this.a, awVar.h(), null);
            } else {
                Toast.makeText(this.a, b, 1).show();
            }
        }
    }
}
