package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
/* loaded from: classes6.dex */
public class a implements com.facebook.imagepipeline.e.a {
    private final Resources mResources;
    private final com.facebook.imagepipeline.e.a ppZ;

    public a(Resources resources, com.facebook.imagepipeline.e.a aVar) {
        this.mResources = resources;
        this.ppZ = aVar;
    }

    @Override // com.facebook.imagepipeline.e.a
    public boolean a(com.facebook.imagepipeline.f.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.e.a
    public Drawable b(com.facebook.imagepipeline.f.c cVar) {
        if (cVar instanceof com.facebook.imagepipeline.f.d) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, dVar.evN());
            if (a(dVar) || b(dVar)) {
                return new i(bitmapDrawable, dVar.evR(), dVar.evS());
            }
            return bitmapDrawable;
        } else if (this.ppZ != null && this.ppZ.a(cVar)) {
            return this.ppZ.b(cVar);
        } else {
            return null;
        }
    }

    private static boolean a(com.facebook.imagepipeline.f.d dVar) {
        return (dVar.evR() == 0 || dVar.evR() == -1) ? false : true;
    }

    private static boolean b(com.facebook.imagepipeline.f.d dVar) {
        return (dVar.evS() == 1 || dVar.evS() == 0) ? false : true;
    }
}
