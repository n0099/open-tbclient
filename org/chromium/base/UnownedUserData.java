package org.chromium.base;
/* loaded from: classes2.dex */
public interface UnownedUserData {
    boolean informOnDetachmentFromHost();

    void onDetachedFromHost(UnownedUserDataHost unownedUserDataHost);
}
