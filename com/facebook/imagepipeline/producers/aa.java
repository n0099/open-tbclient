package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class aa extends y {
    private final Resources mResources;

    public aa(Executor executor, com.facebook.common.memory.g gVar, Resources resources) {
        super(executor, gVar);
        this.mResources = resources;
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException {
        return e(this.mResources.openRawResource(k(imageRequest)), i(imageRequest));
    }

    private int i(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        int i;
        try {
            assetFileDescriptor = this.mResources.openRawResourceFd(k(imageRequest));
        } catch (Resources.NotFoundException e) {
            assetFileDescriptor = null;
        } catch (Throwable th2) {
            assetFileDescriptor = null;
            th = th2;
        }
        try {
            i = (int) assetFileDescriptor.getLength();
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e2) {
                }
            }
        } catch (Resources.NotFoundException e3) {
            i = -1;
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e4) {
                }
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected String cLV() {
        return "LocalResourceFetchProducer";
    }

    private static int k(ImageRequest imageRequest) {
        return Integer.parseInt(imageRequest.cMx().getPath().substring(1));
    }
}
