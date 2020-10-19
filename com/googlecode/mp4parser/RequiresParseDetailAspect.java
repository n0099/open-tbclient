package com.googlecode.mp4parser;

import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.a;
/* loaded from: classes11.dex */
public class RequiresParseDetailAspect {
    private static /* synthetic */ Throwable ajc$initFailureCause;
    public static final /* synthetic */ RequiresParseDetailAspect ajc$perSingletonInstance = null;

    static {
        try {
            ajc$postClinit();
        } catch (Throwable th) {
            ajc$initFailureCause = th;
        }
    }

    private static /* synthetic */ void ajc$postClinit() {
        ajc$perSingletonInstance = new RequiresParseDetailAspect();
    }

    public static RequiresParseDetailAspect aspectOf() {
        if (ajc$perSingletonInstance == null) {
            throw new NoAspectBoundException("com.googlecode.mp4parser.RequiresParseDetailAspect", ajc$initFailureCause);
        }
        return ajc$perSingletonInstance;
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    public void before(a aVar) {
        if (aVar.getTarget() instanceof AbstractBox) {
            if (!((AbstractBox) aVar.getTarget()).isParsed()) {
                ((AbstractBox) aVar.getTarget()).parseDetails();
                return;
            }
            return;
        }
        throw new RuntimeException("Only methods in subclasses of " + AbstractBox.class.getName() + " can  be annotated with ParseDetail");
    }
}
