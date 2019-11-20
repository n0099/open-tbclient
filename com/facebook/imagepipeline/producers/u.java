package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class u extends y {
    private final AssetManager mAssetManager;

    public u(Executor executor, com.facebook.common.memory.g gVar, AssetManager assetManager) {
        super(executor, gVar);
        this.mAssetManager = assetManager;
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException {
        return e(this.mAssetManager.open(j(imageRequest), 2), i(imageRequest));
    }

    private int i(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        int i;
        try {
            assetFileDescriptor = this.mAssetManager.openFd(j(imageRequest));
        } catch (IOException e) {
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
        } catch (IOException e3) {
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
    protected String cIQ() {
        return "LocalAssetFetchProducer";
    }

    private static String j(ImageRequest imageRequest) {
        return imageRequest.cJs().getPath().substring(1);
    }
}
