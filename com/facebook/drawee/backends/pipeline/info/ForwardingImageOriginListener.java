package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.logging.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public class ForwardingImageOriginListener implements ImageOriginListener {
    public static final String TAG = "ForwardingImageOriginListener";
    public final List<ImageOriginListener> mImageOriginListeners;

    public ForwardingImageOriginListener(Set<ImageOriginListener> set) {
        this.mImageOriginListeners = new ArrayList(set);
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        this.mImageOriginListeners.add(imageOriginListener);
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public synchronized void onImageLoaded(String str, int i2, boolean z) {
        int size = this.mImageOriginListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            ImageOriginListener imageOriginListener = this.mImageOriginListeners.get(i3);
            if (imageOriginListener != null) {
                try {
                    imageOriginListener.onImageLoaded(str, i2, z);
                } catch (Exception e2) {
                    FLog.e(TAG, "InternalListener exception in onImageLoaded", e2);
                }
            }
        }
    }

    public synchronized void removeImageOriginListener(ImageOriginListener imageOriginListener) {
        this.mImageOriginListeners.remove(imageOriginListener);
    }

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        ArrayList arrayList = new ArrayList(imageOriginListenerArr.length);
        this.mImageOriginListeners = arrayList;
        Collections.addAll(arrayList, imageOriginListenerArr);
    }
}
