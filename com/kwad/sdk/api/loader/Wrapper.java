package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.ResContext;
import java.util.Map;
import java.util.WeakHashMap;
@Keep
/* loaded from: classes4.dex */
public class Wrapper {
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

    @Keep
    public static Context unwrapContextIfNeed(Context context) {
        Context context2;
        ResContext resContext = null;
        if (context instanceof ResContext) {
            resContext = (ResContext) context;
            context2 = context;
        } else {
            context2 = context;
        }
        while (context2 instanceof ContextWrapper) {
            if (context2 instanceof Activity) {
                return context2;
            }
            if (context2 instanceof ResContext) {
                resContext = (ResContext) context2;
                context2 = resContext.getDelegatedContext();
            } else {
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
        }
        return resContext != null ? resContext.getDelegatedContext() : context;
    }

    @Keep
    public static Context wrapContextIfNeed(Context context) {
        if (Loader.get().isExternalLoaded() && !(context instanceof ResContext)) {
            if (context instanceof ContextThemeWrapper) {
                Context context2 = sResContextCache.get(context);
                if (context2 == null) {
                    l lVar = new l((ContextThemeWrapper) context);
                    sResContextCache.put(context, lVar);
                    return lVar;
                }
                return context2;
            } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                Context context3 = sResContextCache.get(context);
                if (context3 == null) {
                    m mVar = new m((androidx.appcompat.view.ContextThemeWrapper) context);
                    sResContextCache.put(context, mVar);
                    return mVar;
                }
                return context3;
            } else if (context instanceof ContextWrapper) {
                Context context4 = sResContextCache.get(context);
                if (context4 == null) {
                    n nVar = new n(context);
                    sResContextCache.put(context, nVar);
                    return nVar;
                }
                return context4;
            } else {
                Context context5 = sResContextCache.get(context);
                if (context5 == null) {
                    n nVar2 = new n(context);
                    sResContextCache.put(context, nVar2);
                    return nVar2;
                }
                return context5;
            }
        }
        return context;
    }

    @Keep
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        if (Loader.get().isExternalLoaded()) {
            Context context = layoutInflater.getContext();
            if (context instanceof ResContext) {
                return layoutInflater;
            }
            Context wrapContextIfNeed = wrapContextIfNeed(context);
            return wrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(wrapContextIfNeed) : layoutInflater;
        }
        return layoutInflater;
    }
}
