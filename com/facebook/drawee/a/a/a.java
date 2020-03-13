package com.facebook.drawee.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
/* loaded from: classes13.dex */
public class a implements com.facebook.imagepipeline.f.a {
    private final com.facebook.imagepipeline.f.a lJU;
    private final Resources mResources;

    public a(Resources resources, com.facebook.imagepipeline.f.a aVar) {
        this.mResources = resources;
        this.lJU = aVar;
    }

    @Override // com.facebook.imagepipeline.f.a
    public boolean a(com.facebook.imagepipeline.g.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Drawable b(com.facebook.imagepipeline.g.c cVar) {
        if (cVar instanceof com.facebook.imagepipeline.g.d) {
            com.facebook.imagepipeline.g.d dVar = (com.facebook.imagepipeline.g.d) cVar;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, dVar.dqs());
            if (a(dVar) || b(dVar)) {
                return new i(bitmapDrawable, dVar.dqw(), dVar.dqx());
            }
            return bitmapDrawable;
        } else if (this.lJU != null && this.lJU.a(cVar)) {
            return this.lJU.b(cVar);
        } else {
            return null;
        }
    }

    private static boolean a(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dqw() == 0 || dVar.dqw() == -1) ? false : true;
    }

    private static boolean b(com.facebook.imagepipeline.g.d dVar) {
        return (dVar.dqx() == 1 || dVar.dqx() == 0) ? false : true;
    }
}
