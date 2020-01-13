package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class ab extends z {
    private final Resources mResources;

    public ab(Executor executor, com.facebook.common.memory.g gVar, Resources resources) {
        super(executor, gVar);
        this.mResources = resources;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e h(ImageRequest imageRequest) throws IOException {
        return f(this.mResources.openRawResource(k(imageRequest)), i(imageRequest));
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

    @Override // com.facebook.imagepipeline.producers.z
    protected String dqr() {
        return "LocalResourceFetchProducer";
    }

    private static int k(ImageRequest imageRequest) {
        return Integer.parseInt(imageRequest.dra().getPath().substring(1));
    }
}
