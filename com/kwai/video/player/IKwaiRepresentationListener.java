package com.kwai.video.player;

import com.kwai.player.KwaiRepresentation;
import java.util.List;
/* loaded from: classes7.dex */
public interface IKwaiRepresentationListener {
    int onSelectRepresentation(List<KwaiRepresentation> list);

    void representationChangeEnd(int i2);

    void representationChangeStart(int i2, int i3);
}
