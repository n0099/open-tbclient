package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
/* loaded from: classes15.dex */
public class a implements com.facebook.imagepipeline.f.a {
    private final Resources mResources;
    private final com.facebook.imagepipeline.f.a nwv;

    public a(Resources resources, com.facebook.imagepipeline.f.a aVar) {
        this.mResources = resources;
        this.nwv = aVar;
    }

    @Override // com.facebook.imagepipeline.f.a
    public boolean a(com.facebook.imagepipeline.g.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Drawable b(com.facebook.imagepipeline.g.c cVar) {
        if (cVar instanceof com.facebook.imagepipeline.g.d) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, dVar.dYq());
            if (a(dVar) || b(dVar)) {
                return new i(bitmapDrawable, dVar.dYu(), dVar.dYv());
            }
            return bitmapDrawable;
        } else if (this.nwv != null && this.nwv.a(cVar)) {
            return this.nwv.b(cVar);
        } else {
            return null;
        }
    }

    private static boolean a(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dYu() == 0 || dVar.dYu() == -1) ? false : true;
    }

    private static boolean b(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dYv() == 1 || dVar.dYv() == 0) ? false : true;
    }
}
