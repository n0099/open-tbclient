package com.kwai.video.player;

import com.kwai.player.KwaiRepresentation;
import java.util.List;
/* loaded from: classes6.dex */
public interface IKwaiRepresentationListener {
    int onSelectRepresentation(List<KwaiRepresentation> list);

    void representationChangeEnd(int i);

    void representationChangeStart(int i, int i2);
}
