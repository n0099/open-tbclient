package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
/* loaded from: classes15.dex */
public class a implements com.facebook.imagepipeline.e.a {
    private final Resources mResources;
    private final com.facebook.imagepipeline.e.a pAJ;

    public a(Resources resources, com.facebook.imagepipeline.e.a aVar) {
        this.mResources = resources;
        this.pAJ = aVar;
    }

    @Override // com.facebook.imagepipeline.e.a
    public boolean a(com.facebook.imagepipeline.f.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.e.a
    public Drawable b(com.facebook.imagepipeline.f.c cVar) {
        if (cVar instanceof com.facebook.imagepipeline.f.d) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, dVar.eyo());
            if (a(dVar) || b(dVar)) {
                return new i(bitmapDrawable, dVar.eys(), dVar.eyt());
            }
            return bitmapDrawable;
        } else if (this.pAJ != null && this.pAJ.a(cVar)) {
            return this.pAJ.b(cVar);
        } else {
            return null;
        }
    }

    private static boolean a(com.facebook.imagepipeline.f.d dVar) {
        return (dVar.eys() == 0 || dVar.eys() == -1) ? false : true;
    }

    private static boolean b(com.facebook.imagepipeline.f.d dVar) {
        return (dVar.eyt() == 1 || dVar.eyt() == 0) ? false : true;
    }
}
