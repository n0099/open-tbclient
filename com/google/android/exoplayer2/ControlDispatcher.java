package com.google.android.exoplayer2;
/* loaded from: classes7.dex */
public interface ControlDispatcher {
    boolean dispatchSeekTo(Player player, int i2, long j2);

    boolean dispatchSetPlayWhenReady(Player player, boolean z);

    boolean dispatchSetRepeatMode(Player player, int i2);

    boolean dispatchSetShuffleModeEnabled(Player player, boolean z);
}
