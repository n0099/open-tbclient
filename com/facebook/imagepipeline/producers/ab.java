package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class ab extends z {
    private final Resources mResources;

    public ab(Executor executor, com.facebook.common.memory.g gVar, Resources resources) {
        super(executor, gVar);
        this.mResources = resources;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException {
        return e(this.mResources.openRawResource(j(imageRequest)), h(imageRequest));
    }

    private int h(ImageRequest imageRequest) {
        Throwable th;
        AssetFileDescriptor assetFileDescriptor;
        AssetFileDescriptor assetFileDescriptor2;
        int i;
        try {
            assetFileDescriptor2 = this.mResources.openRawResourceFd(j(imageRequest));
        } catch (Resources.NotFoundException e) {
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
        } catch (Resources.NotFoundException e3) {
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
    protected String ezs() {
        return "LocalResourceFetchProducer";
    }

    private static int j(ImageRequest imageRequest) {
        return Integer.parseInt(imageRequest.ezX().getPath().substring(1));
    }
}
