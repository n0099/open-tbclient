package org.webrtc;

import android.graphics.ImageFormat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.DisplayCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.qrcodescanner.beans.QRCodeScannerBeanFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes8.dex */
public class CameraEnumerationAndroid {
    public static final ArrayList<Size> COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new Size(160, 120), new Size(240, 160), new Size(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 240), new Size(400, 240), new Size(480, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP), new Size(640, 360), new Size(640, 480), new Size(768, 480), new Size(854, 480), new Size(800, 600), new Size(TbConfig.HEAD_IMG_SIZE, 540), new Size(TbConfig.HEAD_IMG_SIZE, 640), new Size(1024, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE), new Size(1024, 600), new Size(1280, PeerConnectionClient.HD_VIDEO_HEIGHT), new Size(1280, 1024), new Size(1920, IdCardOcrCameraActivity.G), new Size(1920, 1440), new Size(QRCodeScannerBeanFactory.QRCODE_WHITE_LIST, 1440), new Size(DisplayCompat.DISPLAY_SIZE_4K_WIDTH, DisplayCompat.DISPLAY_SIZE_4K_HEIGHT)));
    public static final String TAG = "CameraEnumerationAndroid";

    /* loaded from: classes8.dex */
    public static class CaptureFormat {
        public final FramerateRange framerate;
        public final int height;
        public final int imageFormat = 17;
        public final int width;

        /* loaded from: classes8.dex */
        public static class FramerateRange {
            public int max;
            public int min;

            public FramerateRange(int i2, int i3) {
                this.min = i2;
                this.max = i3;
            }

            public boolean equals(Object obj) {
                if (obj instanceof FramerateRange) {
                    FramerateRange framerateRange = (FramerateRange) obj;
                    return this.min == framerateRange.min && this.max == framerateRange.max;
                }
                return false;
            }

            public int hashCode() {
                return (this.min * 65537) + 1 + this.max;
            }

            public String toString() {
                return "[" + (this.min / 1000.0f) + ":" + (this.max / 1000.0f) + "]";
            }
        }

        public CaptureFormat(int i2, int i3, int i4, int i5) {
            this.width = i2;
            this.height = i3;
            this.framerate = new FramerateRange(i4, i5);
        }

        public CaptureFormat(int i2, int i3, FramerateRange framerateRange) {
            this.width = i2;
            this.height = i3;
            this.framerate = framerateRange;
        }

        public static int frameSize(int i2, int i3, int i4) {
            if (i4 == 17) {
                return ((i2 * i3) * ImageFormat.getBitsPerPixel(i4)) / 8;
            }
            throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
        }

        public boolean equals(Object obj) {
            if (obj instanceof CaptureFormat) {
                CaptureFormat captureFormat = (CaptureFormat) obj;
                return this.width == captureFormat.width && this.height == captureFormat.height && this.framerate.equals(captureFormat.framerate);
            }
            return false;
        }

        public int frameSize() {
            return frameSize(this.width, this.height, 17);
        }

        public int hashCode() {
            return (((this.width * 65497) + this.height) * GDiffPatcher.COPY_USHORT_INT) + 1 + this.framerate.hashCode();
        }

        public String toString() {
            return this.width + "x" + this.height + "@" + this.framerate;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class ClosestComparator<T> implements Comparator<T> {
        public ClosestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return diff(t) - diff(t2);
        }

        public abstract int diff(T t);
    }

    public static CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CaptureFormat.FramerateRange> list, final int i2) {
        return (CaptureFormat.FramerateRange) Collections.min(list, new ClosestComparator<CaptureFormat.FramerateRange>() { // from class: org.webrtc.CameraEnumerationAndroid.1
            public static final int MAX_FPS_DIFF_THRESHOLD = 5000;
            public static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
            public static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
            public static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
            public static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
            public static final int MIN_FPS_THRESHOLD = 8000;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            private int progressivePenalty(int i3, int i4, int i5, int i6) {
                return i3 < i4 ? i3 * i5 : ((i3 - i4) * i6) + (i5 * i4);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(CaptureFormat.FramerateRange framerateRange) {
                return progressivePenalty(framerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs((i2 * 1000) - framerateRange.max), 5000, 1, 3);
            }
        });
    }

    public static Size getClosestSupportedSize(List<Size> list, final int i2, final int i3) {
        return (Size) Collections.min(list, new ClosestComparator<Size>() { // from class: org.webrtc.CameraEnumerationAndroid.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(Size size) {
                return Math.abs(i2 - size.width) + Math.abs(i3 - size.height);
            }
        });
    }

    public static void reportCameraResolution(Histogram histogram, Size size) {
        histogram.addSample(COMMON_RESOLUTIONS.indexOf(size) + 1);
    }
}
