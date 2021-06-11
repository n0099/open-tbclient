package com.kwai.player;

import androidx.annotation.Keep;
import com.kwai.video.player.IKwaiRepresentationListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
@Keep
/* loaded from: classes7.dex */
public class KwaiRepresentationListenerBridge {
    public static IKwaiRepresentationListener getListener(Object obj) {
        if (obj == null) {
            return null;
        }
        return (IKwaiRepresentationListener) ((WeakReference) obj).get();
    }

    public static int onSelectRepresentation(Object obj, ArrayList arrayList) {
        IKwaiRepresentationListener listener = getListener(obj);
        if (listener == null) {
            return 0;
        }
        return listener.onSelectRepresentation(arrayList);
    }

    public static void representationChangeEnd(Object obj, int i2) {
        IKwaiRepresentationListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.representationChangeEnd(i2);
    }

    public static void representationChangeStart(Object obj, int i2, int i3) {
        IKwaiRepresentationListener listener = getListener(obj);
        if (listener == null) {
            return;
        }
        listener.representationChangeStart(i2, i3);
    }
}
