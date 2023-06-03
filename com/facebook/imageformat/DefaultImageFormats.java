package com.facebook.imageformat;

import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.facebook.common.internal.ImmutableList;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class DefaultImageFormats {
    public static ImmutableList<ImageFormat> sAllDefaultFormats;
    public static final ImageFormat JPEG = new ImageFormat("JPEG", "jpeg");
    public static final ImageFormat PNG = new ImageFormat("PNG", "png");
    public static final ImageFormat GIF = new ImageFormat("GIF", NativeConstants.TYPE_GIF);
    public static final ImageFormat BMP = new ImageFormat("BMP", "bmp");
    public static final ImageFormat ICO = new ImageFormat("ICO", "ico");
    public static final ImageFormat WEBP_SIMPLE = new ImageFormat("WEBP_SIMPLE", WebpUtils.TYPE_IMG_WEBP);
    public static final ImageFormat WEBP_LOSSLESS = new ImageFormat("WEBP_LOSSLESS", WebpUtils.TYPE_IMG_WEBP);
    public static final ImageFormat WEBP_EXTENDED = new ImageFormat("WEBP_EXTENDED", WebpUtils.TYPE_IMG_WEBP);
    public static final ImageFormat WEBP_EXTENDED_WITH_ALPHA = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", WebpUtils.TYPE_IMG_WEBP);
    public static final ImageFormat WEBP_ANIMATED = new ImageFormat("WEBP_ANIMATED", WebpUtils.TYPE_IMG_WEBP);
    public static final ImageFormat HEIF = new ImageFormat("HEIF", "heif");
    public static final ImageFormat DNG = new ImageFormat("DNG", "dng");

    public static List<ImageFormat> getDefaultFormats() {
        if (sAllDefaultFormats == null) {
            ArrayList arrayList = new ArrayList(9);
            arrayList.add(JPEG);
            arrayList.add(PNG);
            arrayList.add(GIF);
            arrayList.add(BMP);
            arrayList.add(ICO);
            arrayList.add(WEBP_SIMPLE);
            arrayList.add(WEBP_LOSSLESS);
            arrayList.add(WEBP_EXTENDED);
            arrayList.add(WEBP_EXTENDED_WITH_ALPHA);
            arrayList.add(WEBP_ANIMATED);
            arrayList.add(HEIF);
            sAllDefaultFormats = ImmutableList.copyOf((List) arrayList);
        }
        return sAllDefaultFormats;
    }

    public static boolean isStaticWebpFormat(ImageFormat imageFormat) {
        if (imageFormat != WEBP_SIMPLE && imageFormat != WEBP_LOSSLESS && imageFormat != WEBP_EXTENDED && imageFormat != WEBP_EXTENDED_WITH_ALPHA) {
            return false;
        }
        return true;
    }

    public static boolean isWebpFormat(ImageFormat imageFormat) {
        if (!isStaticWebpFormat(imageFormat) && imageFormat != WEBP_ANIMATED) {
            return false;
        }
        return true;
    }
}
