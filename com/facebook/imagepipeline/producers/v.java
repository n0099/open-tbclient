package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class v extends z {
    private final AssetManager mAssetManager;

    public v(Executor executor, com.facebook.common.memory.g gVar, AssetManager assetManager) {
        super(executor, gVar);
        this.mAssetManager = assetManager;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException {
        return e(this.mAssetManager.open(i(imageRequest), 2), h(imageRequest));
    }

    private int h(ImageRequest imageRequest) {
        Throwable th;
        AssetFileDescriptor assetFileDescriptor;
        AssetFileDescriptor assetFileDescriptor2;
        int i;
        try {
            assetFileDescriptor2 = this.mAssetManager.openFd(i(imageRequest));
        } catch (IOException e) {
            assetFileDescriptor2 = null;
        } catch (Throwable th2) {
            th = th2;
            assetFileDescriptor = null;
        }
        try {
            i = (int) assetFileDescriptor2.getLength();
            if (assetFileDescriptor2 != null) {
                try {
                    assetFileDescriptor2.close();
                } catch (IOException e2) {
                }
            }
        } catch (IOException e3) {
            i = -1;
            if (assetFileDescriptor2 != null) {
                try {
                    assetFileDescriptor2.close();
                } catch (IOException e4) {
                }
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            assetFileDescriptor = assetFileDescriptor2;
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

    @Override // com.facebook.imagepipeline.producers.z
    protected String exa() {
        return "LocalAssetFetchProducer";
    }

    private static String i(ImageRequest imageRequest) {
        return imageRequest.exF().getPath().substring(1);
    }
}
