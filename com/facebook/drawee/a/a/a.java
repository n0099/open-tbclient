package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
/* loaded from: classes6.dex */
public class a implements com.facebook.imagepipeline.e.a {
    private final Resources mResources;
    private final com.facebook.imagepipeline.e.a puu;

    public a(Resources resources, com.facebook.imagepipeline.e.a aVar) {
        this.mResources = resources;
        this.puu = aVar;
    }

    @Override // com.facebook.imagepipeline.e.a
    public boolean a(com.facebook.imagepipeline.f.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.e.a
    public Drawable b(com.facebook.imagepipeline.f.c cVar) {
        if (cVar instanceof com.facebook.imagepipeline.f.d) {
            com.facebook.imagepipeline.f.d dVar = (com.facebook.imagepipeline.f.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, dVar.ezc());
            if (a(dVar) || b(dVar)) {
                return new i(bitmapDrawable, dVar.ezf(), dVar.ezg());
            }
            return bitmapDrawable;
        } else if (this.puu != null && this.puu.a(cVar)) {
            return this.puu.b(cVar);
        } else {
            return null;
        }
    }

    private static boolean a(com.facebook.imagepipeline.f.d dVar) {
        return (dVar.ezf() == 0 || dVar.ezf() == -1) ? false : true;
    }

    private static boolean b(com.facebook.imagepipeline.f.d dVar) {
        return (dVar.ezg() == 1 || dVar.ezg() == 0) ? false : true;
    }
}
