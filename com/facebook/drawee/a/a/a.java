package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
/* loaded from: classes9.dex */
public class a implements com.facebook.imagepipeline.f.a {
    private final Resources mResources;
    private final com.facebook.imagepipeline.f.a nmd;

    public a(Resources resources, com.facebook.imagepipeline.f.a aVar) {
        this.mResources = resources;
        this.nmd = aVar;
    }

    @Override // com.facebook.imagepipeline.f.a
    public boolean a(com.facebook.imagepipeline.g.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Drawable b(com.facebook.imagepipeline.g.c cVar) {
        if (cVar instanceof com.facebook.imagepipeline.g.d) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, dVar.dUj());
            if (a(dVar) || b(dVar)) {
                return new i(bitmapDrawable, dVar.dUn(), dVar.dUo());
            }
            return bitmapDrawable;
        } else if (this.nmd != null && this.nmd.a(cVar)) {
            return this.nmd.b(cVar);
        } else {
            return null;
        }
    }

    private static boolean a(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dUn() == 0 || dVar.dUn() == -1) ? false : true;
    }

    private static boolean b(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dUo() == 1 || dVar.dUo() == 0) ? false : true;
    }
}
