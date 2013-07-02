package com.mofamulu.tieba.map;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements GoogleMap.OnCameraChangeListener {
    final /* synthetic */ FreeJumpByMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FreeJumpByMapActivity freeJumpByMapActivity) {
        this.a = freeJumpByMapActivity;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraChangeListener
    public void a(CameraPosition cameraPosition) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        gVar = this.a.i;
        if (gVar != null) {
            gVar4 = this.a.i;
            gVar4.cancel(true);
        }
        this.a.i = new g(this.a, cameraPosition.b.b, cameraPosition.b.c);
        gVar2 = this.a.i;
        gVar2.setPriority(3);
        gVar3 = this.a.i;
        gVar3.execute(String.valueOf(com.baidu.tieba.data.g.a) + "c/f/lbs/thread");
    }
}
