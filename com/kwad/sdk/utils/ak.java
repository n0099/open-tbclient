package com.kwad.sdk.utils;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes7.dex */
public final class ak {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0010 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0004 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:6:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x000c */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r0 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i) {
        boolean z7;
        if (z2) {
            z7 = (z ? 1 : 0) | true;
        }
        if (z3) {
            z7 = (z7 ? 1 : 0) | true;
        }
        if (z4) {
            z7 = (z7 ? 1 : 0) | 8;
        }
        if (z5) {
            z7 = (z7 == true ? 1 : 0) | 16;
        }
        if (z6) {
            z7 = (z7 == true ? 1 : 0) | WebvttCueParser.CHAR_SPACE;
        }
        return i == 2 ? z7 | 64 : z7;
    }
}
