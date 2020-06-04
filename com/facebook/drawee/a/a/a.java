package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
/* loaded from: classes13.dex */
public class a implements com.facebook.imagepipeline.f.a {
    private final Resources mResources;
    private final com.facebook.imagepipeline.f.a mob;

    public a(Resources resources, com.facebook.imagepipeline.f.a aVar) {
        this.mResources = resources;
        this.mob = aVar;
    }

    @Override // com.facebook.imagepipeline.f.a
    public boolean a(com.facebook.imagepipeline.g.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Drawable b(com.facebook.imagepipeline.g.c cVar) {
        if (cVar instanceof com.facebook.imagepipeline.g.d) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, dVar.dAr());
            if (a(dVar) || b(dVar)) {
                return new i(bitmapDrawable, dVar.dAv(), dVar.dAw());
            }
            return bitmapDrawable;
        } else if (this.mob != null && this.mob.a(cVar)) {
            return this.mob.b(cVar);
        } else {
            return null;
        }
    }

    private static boolean a(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dAv() == 0 || dVar.dAv() == -1) ? false : true;
    }

    private static boolean b(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dAw() == 1 || dVar.dAw() == 0) ? false : true;
    }
}
