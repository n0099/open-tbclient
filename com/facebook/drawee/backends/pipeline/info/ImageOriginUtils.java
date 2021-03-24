package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
/* loaded from: classes6.dex */
public class ImageOriginUtils {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int mapProducerNameToImageOrigin(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1914072202:
                if (str.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1683996557:
                if (str.equals(LocalResourceFetchProducer.PRODUCER_NAME)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -1579985851:
                if (str.equals(LocalFileFetchProducer.PRODUCER_NAME)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1307634203:
                if (str.equals(EncodedMemoryCacheProducer.PRODUCER_NAME)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1224383234:
                if (str.equals(NetworkFetchProducer.PRODUCER_NAME)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 656304759:
                if (str.equals("DiskCacheProducer")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 957714404:
                if (str.equals(BitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1019542023:
                if (str.equals(LocalAssetFetchProducer.PRODUCER_NAME)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1721672898:
                if (str.equals(DataFetchProducer.PRODUCER_NAME)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1793127518:
                if (str.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME)) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 2113652014:
                if (str.equals(LocalContentUriFetchProducer.PRODUCER_NAME)) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 5;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                return 6;
            default:
                return 1;
        }
    }

    public static String toString(int i) {
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "unknown" : "local" : "memory_bitmap" : "memory_encoded" : "disk" : "network";
    }
}
