package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class u extends y {
    private final AssetManager ifa;

    public u(Executor executor, com.facebook.common.memory.g gVar, AssetManager assetManager) {
        super(executor, gVar);
        this.ifa = assetManager;
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d e(ImageRequest imageRequest) throws IOException {
        return d(this.ifa.open(g(imageRequest), 2), f(imageRequest));
    }

    private int f(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        int i;
        try {
            assetFileDescriptor = this.ifa.openFd(g(imageRequest));
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
    protected String bXB() {
        return "LocalAssetFetchProducer";
    }

    private static String g(ImageRequest imageRequest) {
        return imageRequest.bYd().getPath().substring(1);
    }
}
