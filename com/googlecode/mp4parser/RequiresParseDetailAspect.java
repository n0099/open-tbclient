package com.googlecode.mp4parser;

import g.a.a.a;
import org.aspectj.lang.NoAspectBoundException;
/* loaded from: classes6.dex */
public class RequiresParseDetailAspect {
    public static /* synthetic */ Throwable ajc$initFailureCause;
    public static final /* synthetic */ RequiresParseDetailAspect ajc$perSingletonInstance = null;

    static {
        try {
            ajc$postClinit();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    public static /* synthetic */ void ajc$postClinit() {
        ajc$perSingletonInstance = new RequiresParseDetailAspect();
    }

    public static RequiresParseDetailAspect aspectOf() {
        RequiresParseDetailAspect requiresParseDetailAspect = ajc$perSingletonInstance;
        if (requiresParseDetailAspect != null) {
            return requiresParseDetailAspect;
        }
        throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", ajc$initFailureCause);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    public void before(a aVar) {
        if (aVar.getTarget() instanceof AbstractBox) {
            if (((AbstractBox) aVar.getTarget()).isParsed()) {
                return;
            }
            ((AbstractBox) aVar.getTarget()).parseDetails();
            return;
        }
        throw new RuntimeException("Only methods in subclasses of " + AbstractBox.class.getName() + " can  be annotated with ParseDetail");
    }
}
